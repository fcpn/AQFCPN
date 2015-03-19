
<%@ include file="../../Cabecera.jsp" %>

<html>
    <head>
      <style type="text/css">

.tablilla {border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px double #000000;}
.Estilo1 {color: #FFFFFF}
      </style>

<script>
function validar(e) {
    tecla = (document.all)?e.keyCode:e.which;
    if (tecla==8) return true;
    patron = /\d/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}
</script>
    </head>
    <body>
    <table width="349" height="244" border="1" align="center">
          <tr bgcolor="#E88B24">
            <td bgcolor="#2F4D84"><span class="Estilo1"><div align="center"><strong>Lista de certificaciones Presupuestarias de la tarea<br>
              <c:out value="${tarea.descripcion}"/><br>
              con c&oacute;digo <br><c:out value="${tarea.codtar}"/><br>
            en Proceso<br>
              Mostradas en orden de<br>
              correlativo</strong></div></span></td>
          </tr>
          <tr>
            <td>
                <div align="center">Correltivo # <c:out value="${num_sol}"/></div><br>
                <div align="center">realizado en fecha <c:out value="${fecha}"/></div>
                <br>

                <div align="center">
             <table width="617" height="52"  border="1" align="center">
      <tr>
        <td width="42" align="center" bgcolor="#F3BF5F"><span class="Estilo4 Estilo1"><strong>Nro</strong></span></td>
        <td width="110" align="center" bgcolor="#F3BF5F"><span class="Estilo4 Estilo1"><strong>Requerimiento especificado</strong></span></td>
        <td width="41"align="center" bgcolor="#F3BF5F"><span class="Estilo4 Estilo1"><strong>Cantidad</strong></span></td>
        <td width="41" align="center" bgcolor="#F3BF5F"><span class="Estilo4 Estilo1"><strong>Monto</strong></span></td>
        <td width="52" align="center" bgcolor="#F3BF5F"><span class="Estilo4 Estilo1"><strong>Tarea</strong></span></td>
        <td width="59" align="center" bgcolor="#F3BF5F"><span class="Estilo4 Estilo1"><strong>Partida</strong></span></td>
        <td width="59" align="center" bgcolor="#F3BF5F"><div align="right" class="Estilo1"><span class="Estilo4"><strong>FF-OF</strong></span></div></td>
        <td width="85" colspan="2" align="center" bgcolor="#F3BF5F"><span class="Estilo4 Estilo1"><strong>Responsable de tarea</strong></span></td>

                <td width="41" bgcolor="#F3BF5F" class="Estilo4"><span class="Estilo3">Modificacion simple</span></td>
		<td width="41" bgcolor="#F3BF5F" class="Estilo4"><span class="Estilo3">Modificar con fecha actual</span></td>
      </tr>
<% int i;


//a.substring(0,4);
//son los numeros de pedidos
i=1; %>
      <c:forEach var="g" items="${lista_cert}">

	  <tr>
        <td class="Estilo5"><div align="center"> <%= i%> </div></td>
        <td valign="top"><div align="right"><c:out value="${g.glosa}"/> <c:out value="${g.glo_rut}"/></div></td>
        <td valign="top"><div align="center" ><c:out value="${g.cantidad}"/></div></td>
        <td valign="top"><div align="right"><c:out value="${g.monto}"/> </div></td>
        <td valign="top"><div align="center"><c:out value="${g.codtar}"/> </div></td>
        <td valign="top"><div align="center"><c:out value="${g.codmonegr}"/></div></td>
        <td valign="top"><div align="center"><c:out value="${g.codfueneco}"/></div></td>
        <td valign="top" colspan="2" align="center"><c:out value="${g.responsable}"/></td>

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
                        </c:url>"><div align="center">

		<span class="Estilo3">Modificacion simple</span></div></a> </td>
        <td>
		<a  href="<c:url value="/ModifiCertProc.do">
                            <c:param name="codtar" value="${tarea.codtar}"/>
                            <c:param name="codacti" value="${actividad.codacti}"/>
                            <c:param name="fecha" value="${g.fecha}"/>
							<c:param name="codfueneco" value="${g.codfueneco}"/>
							<c:param name="codmonegr" value="${g.codmonegr}"/>
                            <c:param name="num_sol" value="${g.num_sol}"/>
                            <c:param name="monto" value="${g.monto}"/>
                            <c:param name="id" value="${g.id}"/>
                        </c:url>"><div align="center">

		<span class="Estilo3">Modificar con la fecha actual</span></div></a></td>
      </tr>

      <% i++;%>
	  </c:forEach>


</table>
<br>
</div></td>
          </tr>
          <tr bgcolor="#E88B24">
            <td bgcolor="#243C66">&nbsp;			</td>
          </tr>
</table>
<table width="267" border="0" align="center">
      <tr bgcolor="#243C66">
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr bgcolor="#DA9410">
        <td><div align="center" class="Estilo1"><a  href="<c:url value="/MosCertProc2.do">
      <c:param name="codtar" value="${tarea.codtar}"/>
      <c:param name="num_sol" value="${num_sol}"/>
      <c:param name="fecha" value="${fecha}"/>
      </c:url>">Certificación Presupuestaria en PDF </a></div></td>
        <td>
		  <div align="center" class="Estilo1"><a  href="<c:url value="/MosCertExel.do">
      <c:param name="codtar" value="${tarea.codtar}"/>
      <c:param name="num_sol" value="${num_sol}"/>
      <c:param name="fecha" value="${fecha}"/>
      </c:url>">Certificación Presupestaria en EXEL</a></div></td>
      </tr>
    </table>

<div align="right"><a  href="<c:url value="/nrocert.do">
                            <c:param name="codtar" value="${tarea.codtar}"/>
                            </c:url>"> Ir atras </a></div>
<br><br><br>



<br><br><br><br><br><br><br>Recuerde que, si modifica los datos de la certificación se cambiara a la fecha y la hora de la modificación para la impresión
    </body>
</html>