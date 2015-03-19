



<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Mostrando los montos presupuestados</title>
    <style type="text/css">
        <!--

.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {
	color: #FFFFFF;
	font-weight: bold;
}
.Estilo25 {font-size: 10px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo29 {font-size: 10px; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo30 {font-family: Verdana, Arial, Helvetica, sans-serif}
.Estilo31 {font-size: 12px}

.Estilo1 {font-size: 12px}
.Estilo3 {font-size: 12px; font-weight: bold; }
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>
<form name="form1" method="post" action="<c:url value="/ModifiCertProc4.do"/>">

<div align="center">Correltivo # <c:out value="${num_sol}"/></div><br>
                <div align="center">realizado en fecha <c:out value="${fecha}"/></div>
                <br>
<table width="650" height="239" border="1" align="center">
      <tr bgcolor="#F3BF5F">
        <td width="146" align="center"><div align="center"><span class="Estilo1"><strong>Requerimiento especificado</strong></span></div></td>
        <td width="48"align="center"><div align="center"><span class="Estilo1"><strong>Cantidad</strong></span></div></td>
        <td width="48" align="center"><div align="center"><span class="Estilo1"><strong>Monto</strong></span></div></td>
        <td width="52" align="center"><div align="center"><span class="Estilo1"><strong>Tarea</strong></span></div></td>
        <td width="60" align="center"><div align="center"><span class="Estilo1"><strong>Partida</strong></span></div></td>
        <td width="68" align="center"><div align="center"><span class="Estilo1"><strong>FF-OF</strong></span></div></td>
        <td colspan="2" align="center"><div align="center"><span class="Estilo1"><strong>Responsable de tarea</strong></span></div></td>

        <td width="69" ><div align="center"><span class="Estilo1">Modificar</span></div></td>
      </tr>


	  <tr bgcolor="#CCCCCC">
        <!--           <c:out value="${g.glosa}"/> -->
		<td height="89" valign="top"><div align="right">
          <textarea name="especificacion" cols="20" id="textarea"><c:out value="${lis_cert.glosa}"/></textarea>
		</div></td>

        <td valign="top"><div align="center" >
          <input name="cantidad" type="text" id="cantidad" size="5" value="<c:out value="${lis_cert.cantidad}"/>">
          </div></td>

        <td valign="top"><div align="right">
          <input name="monto" type="text" id="monto" size="5" value="<c:out value="${lis_cert.monto}"/>">
           </div></td>

        <td valign="top"><div align="center"><c:out value="${lis_cert.codtar}"/> </div></td>

	    <!--  <c:out value="${g.codmonegr}"/> -->
	    <td valign="top"><div align="center">
          <input name="partida" type="text" id="partida" size="7"  value="<c:out value="${lis_cert.codmonegr}"/>">
         </div></td>

        <td valign="top"><div align="center">
          <input name="codfueneco" type="text" id="codfueneco" size="6"  value="<c:out value="${lis_cert.codfueneco}"/>">
          </div></td>

        <td colspan="2" align="center" valign="top"><textarea name="responsable" cols="15" id="responsable"><c:out value="${lis_cert.responsable}"/></textarea>  </td>

        <td> <input type="submit" name="Submit" value="modificar"></td>
      </tr>
	  <tr bgcolor="#CCCCCC">
	    <td rowspan="2" valign="top">&nbsp;</td>
	    <td colspan="4" valign="top" bgcolor="#F3BF5F"><span class="Estilo1"><strong>Otros para la glosa y RUT</strong></span></td>
	    <td colspan="4" rowspan="2" valign="top">&nbsp;</td>
  </tr>
	  <tr>
	    <td height="85" colspan="4" valign="top" bgcolor="#CCCCCC"><div align="center"><textarea name="glo_rut" cols="18" id="glo_rut"><c:out value="${lis_cert.glo_rut}"/></textarea>
	    </div></td>
  </tr>


</table>

<input type=hidden name="id" id="id" value='<c:out value="${lis_cert.id}"/>'>
<input type=hidden name="codmonegran" id="codmonegran" value='<c:out value="${lis_cert.codmonegr}"/>'>
<input type=hidden name="codfuenecoan" id="codfuenecoan" value='<c:out value="${lis_cert.codfueneco}"/>'>
<input type=hidden name="montoan" id="montoan" value='<c:out value="${lis_cert.monto}"/>'>
<input type=hidden name="id_usuario_certificado" id="montoan" value='<c:out value="${lis_cert.id_usuario_certificado}"/>'>
<input type=hidden name="glosaan" id="glosaan" value='<c:out value="${lis_cert.glosa}"/>'>
<input type=hidden name="cantidadan" id="cantidadan" value='<c:out value="${lis_cert.cantidad}"/>'>
<input type=hidden name="responsablean" id="responsablean" value='<c:out value="${lis_cert.responsable}"/>'>
<input type=hidden name="glo_rutan" id="glo_rutan" value='<c:out value="${lis_cert.glo_rut}"/>'>


<input type=hidden name="codtar" id="codtar" value='<c:out value="${codtar}"/>'>
  <input type=hidden name="codacti" id="codacti" value='<c:out value="${codacti}"/>'>
 <input type=hidden name="num_sol" id="num_sol" value='<c:out value="${num_sol}"/>'>
  <input type=hidden name="fecha" id="fecha" value='<c:out value="${fecha}"/>'>
<input type=hidden name="fechalit" id="fechalit" value='<c:out value="${lis_cert.fechalit}"/>'>
    <input type=hidden name="fechahrs" id="fechahrs" value='<c:out value="${lis_cert.fechahrs}"/>'>
<input type=hidden name="id" id="id" value='<c:out value="${id}"/>'>

</form>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>