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
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="  ">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#422D00" >
      <td colspan="2" ><div align="center" class="Estilo4">Informe Traspasos</div></td>
    </tr>
    <tr class="Estilo25" >
        <td width="238" bgcolor="#D6D6D6" ><div align="center" class="Estilo30">Actividad  </div></td>
        <td width="269" bgcolor="#D6D6D6" ><div align="center" class="Estilo30">Tarea  </div></td>
    </tr>
    <tr >
      <td ><div align="justify"><c:out value="${actividad.descripcion}"/></div></td>
      <td ><div align="justify"><c:out value="${tarea.descripcion}"/></div></td>
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
</tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr>
    <td><c:out value="${codmonegr}"/> - <c:out value="${descla}"/> </td>
    <td><c:out value="${codfueneco}"/> - <c:out value="${fuente.descripcion}"/></td>

    <td><div align="right">&nbsp;<c:out value="${monto}"/>                  <!--comprocompro-->
    </div></td>
    <td><div align="right">&nbsp;<c:out value="${moneje}"/>                  <!--UltiMonInser-->
    </div></td>
    <td><div align="right">&nbsp;<c:out value="${saldo}"/> </div></td>

</tr>







<!--Montos No presupuestados -->
<tr bgcolor="#838383" >
    <td colspan="5" bgcolor="#838383" > <span class="Estilo5">Monto Traspaso de la Partida <c:out value="${codmonegr}"/> a:</span> </td>
    </tr>

<tr>
    <td bgcolor="#D6D6D6"><div align="center"><span class="Estilo25">Partida de recepcion de monto </span></div></td>
    <td width="220" bgcolor="#D6D6D6"><div align="center" class="Estilo25">Glosa</div></td>


    <td bgcolor="#D6D6D6"><span class="Estilo29"><strong>&nbsp;
        <!---Ultimo # de comprobante-->
Comprobante
    </strong> </span>      <div align="right" class="Estilo29"></div></td>
    <td bgcolor="#D6D6D6"> <span class="Estilo29"><strong>&nbsp;
        <!--monto insertando -->
      Fecha deTraspaso </strong> </span>      <div align="right" class="Estilo29"></div></td>



    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto Acumulado&nbsp;</strong></div></td>

</tr>

<c:forEach var="moo" items="${his_tra}">
    <!-- Elige la tarea para mostrala -->

    <tr>
        <td><c:out value="${moo.codmonegr2}"/> - <c:out value="${moo.descla2}"/></td>
        <td><div align="justify"><c:out value="${moo.glosa}"/></div> </td>
        <td><div align="right"><c:out value="${moo.cbte}"/></div></td>
        <td><div align="right"><c:out value="${moo.fecha}"/>           <!--UltiMonInser-->
        </div></td>
        <td> <div align="right"><c:out value="${moo.monto}"/> </div></td>

    </tr>


</c:forEach>
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->



<!--FIN FIN TOTALES suma -->










<tr bgcolor="#BAAD74">
    <td height="19" colspan="6" bgcolor="#993300"><div align="right"><span class="Estilo3"><!--[Salir a Men&uacute; Principal]--> </span></div></td>
</tr>

<tr>
    <td colspan="5" bgcolor="#003366" > <span class="Estilo5"> </span> <br>
      <br></td>
</tr>


<tr>
    <td colspan="5" bgcolor="#838383" align="left"> <span class="Estilo5">Montos Traspasados a la partida <c:out value="${codmonegr}"/> de:</span></td>
</tr>

<tr>
    <td bgcolor="#D6D6D6"><div align="center"><span class="Estilo25">Partida </span></div></td>
    <td width="220" bgcolor="#D6D6D6"><div align="center" class="Estilo25">Glosa</div></td>


    <td bgcolor="#D6D6D6"><span class="Estilo29"><strong>&nbsp;
        <!---Ultimo # de comprobante-->
Comprobante
    </strong> </span>      <div align="right" class="Estilo29"></div></td>
    <td bgcolor="#D6D6D6"> <span class="Estilo29"><strong>&nbsp;
        <!--monto insertando -->
      Fecha deTraspaso </strong> </span>      <div align="right" class="Estilo29"></div></td>



    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto Acumulado&nbsp;</strong></div></td>

</tr>
<c:forEach var="moo2" items="${his_tra2}">
    <!-- Elige la tarea para mostrala -->

    <tr>
        <td><c:out value="${moo2.codmonegr}"/> - <c:out value="${moo2.descla}"/></td>
        <td><div align="justify"><c:out value="${moo2.glosa}"/></div> </td>
        <td><div align="right"><c:out value="${moo2.cbte}"/></div></td>
        <td><div align="right"><c:out value="${moo2.fecha}"/>           <!--UltiMonInser-->
        </div></td>
        <td> <div align="right"><c:out value="${moo2.monto}"/> </div></td>

    </tr>


</c:forEach>


</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>