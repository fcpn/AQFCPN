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
.Estilo25 {font-size: 10px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; }
.montitos {font-size: 11px; font-weight: normal; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo29 {font-size: 10px; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo30 {color: #000000}
.Estilo31 {color: #FFFFFF}





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

<br>
<br>
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#422D00" >
      <td bgcolor="#C0C0C0" ><div align="center" class="Estilo4 Estilo30">Datos Eliminados</div></td>
    </tr>
</table>
<br>




<table width="812" border="1" align="center" bordercolor="#CC9933">

<tr bgcolor="#D6D6D6" class="Estilo25">
    <td colspan="5"><div align="center">Partida Anterior</div></td>
  </tr>


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
<c:out value="${egremon.codmonegr}"/>


</div></td>
    <td><div class="montitos"><c:out value="${egremon.codfueneco}"/> </div></td>

    <td><div align="right" class="montitos"><c:out value="${egremon.montopresu}"/></div></td>
    <td><div align="right" class="montitos"><c:out value="${egremon.montoeje}"/></div></td>
    <td><div align="right" class="montitos"><c:out value="${egremon.saldo}"/> </div></td>

</tr>
</table>



<br>


<table width="795" border="1" align="center" bordercolor="#CC9933">
  <tr bgcolor="#D6D6D6" class="Estilo25">
    <td colspan="6"><div align="center"><span class="Estilo25">&nbsp; Ejecucion de traspaso anterior <!---Ultimo # de comprobante-->
    </span></div></td>
  </tr>

<tr>
    <th width="169" bgcolor="#D6D6D6"><div align="center"><span class="Estilo25">Partida de recepcion de monto </span></div></th>
    <td width="199" bgcolor="#D6D6D6"><div align="center" class="Estilo25">Glosa</div></td>


    <td width="149" bgcolor="#D6D6D6"><span class="Estilo29"><strong>Comprobante
    </strong> </span>      <div align="right" class="Estilo29"></div></td>
    <td width="149" bgcolor="#D6D6D6"> <span class="Estilo29"><strong>&nbsp;Fecha deTraspaso </strong> </span>      <div align="right" class="Estilo29"></div></td>



    <td width="95" bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto Acumulado&nbsp;</strong></div></td>
<td width="95" bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Fuente Econ&oacute;mica</strong></div></td>




</tr>


    <!-- Elige la tarea para mostrala -->

    <tr bgcolor="#999999">
 <td><div class="montitos"><c:out value="${codmonegr2_}"/></div></td>
        <td><div align="justify" class="montitos"><c:out value="${glosa_}"/></div> </td>
      <td> <div align="right" class="montitos"><c:out value="${cbte_}"/></div></td>
      <td><div align="right" class="montitos"><c:out value="${fecha_}"/></div></td>
      <td> <div align="right" class="montitos"><c:out value="${monto_}"/></div></td>


<td> <div align="right" class="montitos"><c:out value="${codfueneco_}"/></div></td>

    </tr>



<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->



<!--FIN FIN TOTALES suma -->


<tr bgcolor="#626262">
    <td height="19" colspan="7"><div align="right"><span class="Estilo3"><!--[Salir a Men&uacute; Principal]--> </span>

    </div></td>
</tr>
</table>


<br>

<br>
<br>
<br>
    <div align="right">
     <a  href="<c:url value="/ModClasificador1e.do">
                            <c:param name="codtar" value="${tarea.codtar}"/>
                            <c:param name="codacti" value="${actividad.codacti}"/>

    </c:url>"> Modificar Traspaso</a>

    </div>
    <br><br>
</form>

</body>
</html>