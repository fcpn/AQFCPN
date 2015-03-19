<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Mostrando los montos presupuestados</title>
    <style type="text/css">
        <!--
.Estilo3 {color: #003399}
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
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="  ">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#422D00" >
      <td colspan="2" ><div align="center" class="Estilo4">Informe Comprometidos </div></td>
    </tr>
    <tr class="Estilo25" >
        <td width="238" bgcolor="#D6D6D6" ><div align="center" class="Estilo30">Actividad  </div></td>
        <td width="269" bgcolor="#D6D6D6" ><div align="center" class="Estilo30">Tarea  </div></td>
    </tr>
    <tr >
      <td ><div align="justify"><span class="Estilo31"><c:out value="${actividad.descripcion}"/></span></div></td>
      <td ><div align="justify"><span class="Estilo31"><c:out value="${tarea.descripcion}"/></span></div></td>
    </tr>
</table>
<br>
<br>

<table width="871" border="1" align="center" bordercolor="#CC9933">
<tr bgcolor="#D6D6D6" class="Estilo25">
    <td width="282"><span class="Estilo25">Clasificador</span></td>
    <td width="220" ><span class="Estilo25"> - Fuente Econ&oacute;mica </span></td>

    <td width="125"><span class="Estilo25">&nbsp;Monto Presupuestado
        <!---Ultimo # de comprobante-->
    </span></td>
    <td width="114"><span class="Estilo25"> Monto Ejecutado
        <!--monto insertando -->
    </span></td>
    <td width="96"><span class="Estilo25">Saldo</span></td>
	<td width="96" bgcolor="#FC9698"><span class="Estilo25">Monto Comprometido</span></td>
    <td width="96" bgcolor="#FC9698"><span class="Estilo25">Saldo mas comprometido</span></td>
</tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr>
    <td><span class="Estilo31"><c:out value="${codmon}"/> - <c:out value="${descla}"/> </span></td>
    <td><span class="Estilo31"><c:out value="${codfueneco}"/> - <c:out value="${fuente.descripcion}"/></span></td>

    <td><div align="right">&nbsp;<span class="Estilo31"><c:out value="${monto}"/></span></div></td>
    <td><div align="right">&nbsp;<span class="Estilo31"><c:out value="${moneje}"/></span></div></td>
    <td><div align="right">&nbsp;<span class="Estilo31"><c:out value="${saldo}"/></span></div></td>
    <td><div align="right">&nbsp;<span class="Estilo31"><c:out value="${montocom}"/></span></div></td>
    <td><div align="right">&nbsp;<span class="Estilo31"><c:out value="${saldocompro}"/></span></div></td>
</tr>







<!--Montos No presupuestados -->
<tr bgcolor="#838383" >
    <td colspan="7" > <span class="Estilo5">Historial del monto Comprometido al Gasto</span> </td>
    </tr>

<tr>
    <td colspan="2" bgcolor="#D6D6D6"><div align="center"></div>      <div align="center" class="Estilo25">Glosa</div></td>
    <td bgcolor="#D6D6D6"><span class="Estilo29"><strong>&nbsp;
        <!---Ultimo # de comprobante-->
Observaciones</strong> </span>      <div align="right" class="Estilo29"></div></td>
    <td bgcolor="#D6D6D6"> <span class="Estilo29"><strong>&nbsp;
        <!--monto insertando -->
      Fecha</strong> </span>      <div align="right" class="Estilo29"></div></td>



    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto</strong></div></td>

</tr>

<c:forEach var="moo" items="${his_com}">
    <!-- Elige la tarea para mostrala -->

    <tr>
        <td colspan="2"> <div align="justify"><span class="Estilo31"><c:out value="${moo.glosa}"/> - <c:out value="${moo.glo_rut}"/>
        </span></div></td>
        <td><div align="right"><span class="Estilo31"><c:out value="${moo.obs}"/> - <c:out value="${moo.num_sol}"/></span></div></td>
        <td><div align="right"><span class="Estilo31"><c:out value="${moo.fecha}"/></span></div></td>
        <td> <div align="right"><span class="Estilo31"><c:out value="${moo.monto}"/></span></div></td>

    </tr>


</c:forEach>
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->



<!--FIN FIN TOTALES suma -->










<tr bgcolor="#BAAD74">
    <td height="19" colspan="8"><div align="right"><span class="Estilo3"><!--[Salir a Men&uacute; Principal]--> </span></div></td>
</tr>
</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>