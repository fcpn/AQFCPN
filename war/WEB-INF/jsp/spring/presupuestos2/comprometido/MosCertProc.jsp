<%@ include file="../../Cabecera.jsp" %>

<html>
    <head>
      

<script>
function validar(e) {
    tecla = (document.all)?e.keyCode:e.which;
    if (tecla==8) return true;
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
                $("tr>td").parent("tr").mouseenter(function ()
                {
                    $(this).find("td").css("background","#092B86");
                    $(this).find("td").css("color","#ffffff");
                    $(this).find("td").find("a").css("color","#ffffff");
                    
                });
                $("tr>td").parent("tr").mouseleave(function ()
                {
                    $(this).find("td").removeAttr("style");
                    $(this).find("td").find("a").removeAttr("style");
                    
                });
                $("tr>td>a").mouseenter(function(){
                    $(this).css("cursor","pointer");
                
                    $(this).css("font-weight","bold");
                });
                $("tr>td>a").mouseleave(function(){
                    $(this).css("cursor","pointer");
                    
                    $(this).css("font-weight","normal");
                });
                $("th>div>a").css("color","#FFFFF5");
                $("th>div>a").parent("div").parent("th").mouseenter(function(){
                    $(this).css("cursor","pointer");
                    
                });
                $("th>div>a").parent("div").parent("th").click(function(){
                    $(location).attr("href",$(this).find("div>a").attr("href"));
                });
            });
        </script>
    </head>
    <body>
        <div id="content">
            <table  border="1" align="center">
                <tr >
                    <th colspan="9" ><div align="center"><strong>Lista de certificaciones Presupuestarias de la tarea<br>
                        <c:out value="${tarea.descripcion}"/><br>
                        con c&oacute;digo <br><c:out value="${tarea.codtar}"/><br>
                        en Proceso<br>
                        Mostradas en orden de<br>
                        correlativo</strong></div>
                    </th>
                </tr>
                <tr>
                    <th colspan="9">
                        <div align="center">Correlativo # <c:out value="${num_sol}"/><br>
                        realizado en fecha <c:out value="${fecha}"/></div>
                    </th>
                </tr>
                <tr>
                    <th width="42" ><strong align="center">Nro</strong></th>
                    <th width="110" ><strong align="center">Requerimiento especificado</strong></th>
                    <th width="41"><strong align="center">Cantidad</strong></th>
                    <th width="41"><strong align="center">Monto</strong></th>
                    <th width="52"><strong align="center">Tarea</strong></th>
                    <th width="59"><strong align="center">Partida</strong></th>
                    <th width="59"><strong align="center">FF-OF</strong></th>
                    <th width="85"><strong align="center">Responsable de tarea</strong></th>
                    <th width="150"><strong align="center">Acciones</strong></th>
                </tr>
<% int i;


//a.substring(0,4);
//son los numeros de pedidos
i=1; %>
      <c:forEach var="g" items="${lista_cert}">

	  <tr>
            <td><div align="center"> <%= i%> </div></td>
            <td valign="top"><div align="right"><c:out value="${g.glosa}"/> <c:out value="${g.glo_rut}"/></div></td>
            <td valign="top"><div align="center" ><c:out value="${g.cantidad}"/></div></td>
            <td valign="top"><div align="right"><c:out value="${g.monto}"/> </div></td>
            <td valign="top"><div align="center"><c:out value="${g.codtar}"/> </div></td>
            <td valign="top"><div align="center"><c:out value="${g.codmonegr}"/></div></td>
            <td valign="top"><div align="center"><c:out value="${g.codfueneco}"/></div></td>
            <td valign="top" align="center"><c:out value="${g.responsable}"/></td>
            <td>
                <a  href="<c:url value="/ModifiCertProc3.do">
                    <c:param name="codtar" value="${tarea.codtar}"/>
                    <c:param name="codacti" value="${actividad.codacti}"/>
                    <c:param name="fecha" value="${g.fecha}"/>
                    <c:param name="codfueneco" value="${g.codfueneco}"/>
                    <c:param name="codmonegr" value="${g.codmonegr}"/>
                    <c:param name="num_sol" value="${g.num_sol}"/>
                    <c:param name="monto" value="${g.monto}"/>
                    <c:param name="id" value="${g.id}"/>
                    </c:url>" title="Clic para realizar modificaci&oacute;n simple al requerimiento especificado: <c:out value="${g.glosa}"/>"><div align="center">
                    Modificacion simple</div></a> 
                <br>
                <a  href="<c:url value="/ModifiCertProc.do">
                    <c:param name="codtar" value="${tarea.codtar}"/>
                    <c:param name="codacti" value="${actividad.codacti}"/>
                    <c:param name="fecha" value="${g.fecha}"/>
                    <c:param name="codfueneco" value="${g.codfueneco}"/>
                    <c:param name="codmonegr" value="${g.codmonegr}"/>
                    <c:param name="num_sol" value="${g.num_sol}"/>
                    <c:param name="monto" value="${g.monto}"/>
                    <c:param name="id" value="${g.id}"/>
                    </c:url>" title="Clic para realizar modificaci&oacute;n con la fecha actual al requerimiento especificado: <c:out value="${g.glosa}"/>"><div align="center">
                    Modificar con la fecha actual</div>
                </a>
                <br>
                <a href="<c:url value="/ejecucionparcial0.do">
                   <c:param name="codtar" value="${tarea.codtar}"/>
                    <c:param name="codacti" value="${actividad.codacti}"/>
                    <c:param name="fecha" value="${g.fecha}"/>
                    <c:param name="codfueneco" value="${g.codfueneco}"/>
                    <c:param name="codmonegr" value="${g.codmonegr}"/>
                    <c:param name="num_sol" value="${g.num_sol}"/>
                    <c:param name="monto" value="${g.monto}"/>
                    <c:param name="id" value="${g.id}"/>
                   </c:url>"
                   >
                    <div align="center" title="Clic para ver la ejecuci&oacute;n parcial">
                        Ejecuci&oacute;n Parcial
                    </div>
                </a>
            </td>
        </tr>

      <% i++;%>
    </c:forEach>
    </table>
    <br>
    <table width="267" align="center">
    <tr>
        <th Title="Clic para ver en formato PDF">
            <div align="center">
                <a  href="<c:url value="/MosCertProc2.do">
                <c:param name="codtar" value="${tarea.codtar}"/>
                <c:param name="num_sol" value="${num_sol}"/>
                <c:param name="fecha" value="${fecha}"/>
                </c:url>">
                    Certificación Presupuestaria en PDF 
                </a>
            </div>
        </th>
        <th title="Clic para ver en formato EXCEL">
            <div align="center">
                <a  href="<c:url value="/MosCertExel.do">
                <c:param name="codtar" value="${tarea.codtar}"/>
                <c:param name="num_sol" value="${num_sol}"/>
                <c:param name="fecha" value="${fecha}"/>
                </c:url>" >
                    Certificación Presupestaria en EXCEL
                </a>
            </div>
        </th>
    </tr>
    </table>

<div align="right">
    <a  href="<c:url value="/nrocert.do">
    <c:param name="codtar" value="${tarea.codtar}"/>
    </c:url>"> Ir atras 
    </a>
</div>
<br><br><br>
<br><br><br><br><br><br><br>Recuerde que, si modifica los datos de la certificación se cambiara a la fecha y la hora de la modificación para la impresión
        </div>
</body>
</html>