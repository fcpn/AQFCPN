<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fuentes Economicas</title>
    </head>
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
                $("table").width(650);
            });
        </script>
    <body>
        <div id="content" align="center">
            <h1 align="center">Traspasos</h1>  
            <table>
                <tr>
                    <th colspan="2"><div align="center">Elija Fuente</div></th>
                </tr>
                <tr>
                    <th>C&oacute;digo</th>
                    <th>Nombre de la Fuente </th>
                </tr>
                <c:forEach var="g" items="${fuente}">
                    <tr title="Clic para realizar traspaso de la fuente econ&oacute;mica <c:out value="${g.codfueneco}"/> - <c:out value="${g.descripcion}"/> ">
                    <td>
                        <a href=<c:url value="/TrasMo.do">            
                                <c:param name="codfueneco" value="${g.codfueneco}"/>
                                <c:param name="descripcion" value="${g.descripcion}"/>
                                </c:url> > <c:out value="${g.codfueneco}"/>  
                        </a>
                    </td>
                    <td>
                        <a href=<c:url value="/TrasMo.do">            
                                <c:param name="codfueneco" value="${g.codfueneco}"/>
                                <c:param name="descripcion" value="${g.descripcion}"/>
                                </c:url>><c:out value="${g.descripcion}"/> 
                        </a>
                    </td>
                </tr>
                </c:forEach> 
            </table>
        </div>
    </body>
</html>
