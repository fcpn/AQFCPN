<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <script>
            function validar(e) {
                tecla = (document.all) ? e.keyCode : e.which;
                if (tecla == 8)
                    return true;
                patron = /\d/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
        </script>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
 <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
         <script type="text/javascript">
            $(document).ready(function()
            {
                $("tr>td").click(function(){
                    $(location).attr("href",$(this).find("a").attr("href"));
                })
                $("tr>td").parent("tr").mouseenter(function ()
                {
                    $(this).find("td").css("background","#092B86");
                    $(this).find("td").css("color","#ffffff");
                    $(this).find("td").find("a").css("color","#ffffff");
                    $(this).css("cursor","pointer");
                    
                });
                $("tr>td").parent("tr").mouseleave(function ()
                {
                    $(this).find("td").removeAttr("style");
                    $(this).find("td").find("a").removeAttr("style");
                    
                });
            });
        </script>
    </head>
    <body oncontextmenu="return false">
        <div id="content">
        <table width="349" height="244" border="1" align="center">
            <tr>
                <th colspan="2">
            <div align="center">  <strong>
                    Lista de certificaciones Presupuestarias de la tarea
                    <br>
                    <c:out value="${tarea.descripcion}"/>
                    <br>
                    con c&oacute;digo 
                    <br>
                    <c:out value="${tarea.codtar}"/>
                    <br>
                    en Proceso<br>
                    Mostradas en orden de
                    <br>
                    correlativo
                            </strong>
            </div>
                </th>
            </tr>
            <tr bgcolor="#F3BF5F">
                        <th width="121"><strong>Fecha de petici&oacute;n </strong></th>
                        <th width="132"><strong>Nro. de correlativo </strong></th>
                    </tr>
                    <c:forEach var="g" items="${correlativo}">
                    <tr onMouseOver="this.style.backgroundColor = '#D6D6D6';" onMouseOut="this.style.backgroundColor = '#ffffff';">
                        <td>
                            <a  href="<c:url value="/MosCertProc.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                                <c:param name="fecha" value="${g.fecha}"/>
                                <c:param name="num_sol" value="${g.num_sol}"/>
                                </c:url>">
                                    <strong> <c:out value="${g.fecha}"/> </strong>
                            </a>
                        </td>
                        <td>
                            <a  href="<c:url value="/MosCertProc.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                                <c:param name="fecha" value="${g.fecha}"/>
                                <c:param name="num_sol" value="${g.num_sol}"/>
                                </c:url>"> 
                                    <strong> <c:out value="${g.num_sol}"/></strong> 
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
           
        </table>
    </body>
</html>