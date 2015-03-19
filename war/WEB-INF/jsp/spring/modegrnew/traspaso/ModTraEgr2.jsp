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
.montitos {font-size: 11px; font-weight: normal; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo29 {font-size: 10px; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo30 {font-family: Verdana, Arial, Helvetica, sans-serif}





			-->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" onsubmit="return confirm('¿Esta seguro de los cambios?')" action="<c:url value="/ModTraEgr3.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#422D00" >
      <td colspan="2" ><div align="center" class="Estilo4">Modificar Traspasos</div></td>
    </tr>
    <tr class="Estilo25" >
        <td width="238" bgcolor="#D6D6D6" ><div align="center" class="Estilo25">Actividad  </div></td>
        <td width="269" bgcolor="#D6D6D6" ><div align="center" class="Estilo25">Tarea  </div></td>
    </tr>
    <tr >
      <td ><div align="left" class="montitos"><c:out value="${actividad.descripcion}"/></div></td>
      <td ><div align="left" class="montitos"><c:out value="${tarea.descripcion}"/></div></td>
    </tr>
</table>


<br><br>


<table width="812" border="1" align="center" bordercolor="#CC9933">
<tr bgcolor="#D6D6D6" class="Estilo25">
    <td width="193"><span class="Estilo25">Clasificador</span></td>
    <td width="236" ><span class="Estilo25"> - Fuente Econ&oacute;mica </span></td>

    <td width="148"><span class="Estilo25">&nbsp;Monto Presupuestado
        <!---Ultimo # de comprobante-->
    </span></td>
    <td width="129"><span class="Estilo25"> Monto Ejecutado
        <!--monto insertando -->
    </span></td>
    <td width="131"><span class="Estilo25">Saldo</span></td>
</tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr>
    <td align="center"><div class="montitos">

        <input name="codmonegr_n" type="text" id="codmonegr" size="12" value="<c:out value="${codmonegr}"/>">

</div></td>
    <td><div class="montitos"><c:out value="${codfueneco}"/> - <c:out value="${fuente.descripcion}"/></div></td>

    <td><div align="right" class="montitos">&nbsp;<c:out value="${monto}"/>                  <!--comprocompro-->
    </div></td>
    <td><div align="right" class="montitos">&nbsp;<c:out value="${moneje}"/>                  <!--UltiMonInser-->
    </div></td>
    <td><div align="right" class="montitos">&nbsp;<c:out value="${saldo}"/> </div></td>

</tr>
</table>



<br><br>


<table width="795" border="1" align="center" bordercolor="#CC9933">
  <tr bgcolor="#D6D6D6" class="Estilo25">
    <td width="169">&nbsp;</td>
    <td width="199" >&nbsp;</td>

    <td width="149"><span class="Estilo25">&nbsp;
        <!---Ultimo # de comprobante-->
    </span></td>
    <td width="149">&nbsp;</td>
    <td width="95">&nbsp;</td>
        <td width="95">&nbsp;</td>
</tr>

<tr>
    <td bgcolor="#D6D6D6"><div align="center"><span class="Estilo25">Partida de recepcion de monto </span></div></td>
    <td width="199" bgcolor="#D6D6D6"><div align="center" class="Estilo25">Glosa</div></td>


    <td bgcolor="#D6D6D6"><span class="Estilo29"><strong>Comprobante
    </strong> </span>      <div align="right" class="Estilo29"></div></td>
    <td bgcolor="#D6D6D6"> <span class="Estilo29"><strong>&nbsp;Fecha deTraspaso </strong> </span>      <div align="right" class="Estilo29"></div></td>



    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto Acumulado&nbsp;</strong></div></td>
<td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Fuente Econ&oacute;mica</strong></div></td>



</tr>


    <!-- Elige la tarea para mostrala -->

    <tr>
 <td bgcolor="#CF7272"><div class="montitos"><input name="codmonegr2" type="text" id="codmonegr2" value="<c:out value="${moo.codmonegr2}"/>"></div>
</td>
        <td bgcolor="#CF7272"><div align="justify" class="montitos">
         <textarea name="glosa" id="glosa"><c:out value="${moo.glosa}"/></textarea> </div> </td>
        <td bgcolor="#CF7272"> <div align="right" class="montitos"><input name="cbte" type="text" size="15" id="cbte" value="<c:out value="${moo.cbte}"/>"></div></td>
        <td bgcolor="#CF7272"><div align="right" class="montitos"><input name="fecha" type="text" id="fecha"  size="20" value="<c:out value="${moo.fecha}"/>"></div></td>
        <td bgcolor="#CF7272"> <div align="right" class="montitos"><input name="monto" size="15" type="text" id="monto" value="<c:out value="${moo.monto}"/>"></div></td>


<td bgcolor="#CF7272"> <div align="right" class="montitos"><input name="codfueneco" size="15" type="text" id="codfueneco" value="<c:out value="${moo.codfueneco}"/>"></div></td>

    </tr>



<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->



<!--FIN FIN TOTALES suma -->


<tr>
    <td height="19" colspan="7" bgcolor="#993300"><div align="right"><span class="Estilo3"><!--[Salir a Men&uacute; Principal]--> </span>

        <input type="submit" name="Modificar" id="Modificar" value="Modificar">

    </div></td>
</tr>


</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
<input type=hidden name=codmonegr value='<c:out value="${codmonegr}"/>'>
<input type=hidden name=codfuenecog value='<c:out value="${codfueneco}"/>'>

<input type=hidden name=codfueneco_ value='<c:out value="${moo.codfueneco}"/>'>
<input type=hidden name=codmonegr2_ value='<c:out value="${moo.codmonegr2}"/>'>
<input type=hidden name=glosa_ value='<c:out value="${moo.glosa}"/>'>
<input type=hidden name=cbte_ value='<c:out value="${moo.cbte}"/>'>
<input type=hidden name=fecha_ value='<c:out value="${moo.fecha}"/>'>
<input type=hidden name=monto_ value='<c:out value="${moo.monto}"/>'>
<input type=hidden name=moneje_ value='<c:out value="${moo.moneje}"/>'>
<input type=hidden name=saldo_ value='<c:out value="${moo.saldo}"/>'>
<input type=hidden name=id_ value='<c:out value="${moo.id}"/>'>

</form>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>