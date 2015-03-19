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
.Estilo25 {font-size: 10px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo29 {font-size: 10px; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo30 {font-family: Verdana, Arial, Helvetica, sans-serif}
.Estilo32 {font-size: 12px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; color: #FFFFFF; }
.Estilo34 {font-size: 14px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; color: #FFFFFF; }
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>


<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#003366" >
      <td colspan="2" ><div align="center" class="Estilo4">Datos Modificados   Incrementos</div></td>
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

<table width="678" border="1" align="center" bordercolor="#000066">
<tr bgcolor="#000033">
<td colspan="6"><div align="center"><span class="Estilo32">Datos Anteriores</span></div></td>
</tr>
<tr bgcolor="#D6D6D6" class="Estilo25">
    <td width="164" colspan="2"><span class="Estilo25">Clasificador</span></td>
    <td width="172" colspan="2"><span class="Estilo25"> - Fuente Econ&oacute;mica </span></td>


</tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr>
    <td colspan="2"><span class="Estilo25"> <c:out value="${codmonegr1}"/></span></td>
    <td colspan="2"> <span class="Estilo25"> <c:out value="${codfueneco1}"/></span></td>


</tr>







<!--Montos No presupuestados -->


<tr>
    <td colspan="2" bgcolor="#D6D6D6"><div align="center"></div>      <div align="center" class="Estilo25">Glosa</div></td>
    <td bgcolor="#D6D6D6"><div align="center"><span class="Estilo29"><strong>&nbsp;
          <!---Ultimo # de comprobante-->
  Comprobante
    </strong> </span> </div>      <div align="right" class="Estilo29"></div></td>
    <td bgcolor="#D6D6D6"> <div align="center"><span class="Estilo29"><strong>Fecha</strong> </span></div></td>



    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto&nbsp;</strong></div></td>


</tr>



    <tr>
        <td colspan="2"><span class="Estilo25"><c:out value="${glosa1}"/></span> </td>
        <td><span class="Estilo25"><c:out value="${cbte1}"/> </span></td>
        <td><span class="Estilo25"><c:out value="${fecha1}"/> </span></td>
        <td><span class="Estilo25"><fmt:formatNumber value="${monpre1}" pattern="#,###,###,##0.00"/> </span></td>


    </tr>




<tr bgcolor="#CC3333" >
    <td height="5" colspan="6" bgcolor="#000066"></td>
</tr>
</table>


<p>&nbsp;</p>
<table width="678" border="1" align="center" bordercolor="#000066">
  <tr bgcolor="#CC3333">
    <td colspan="6"><div align="center"><span class="Estilo34">Datos Actuales</span></div></td>
  </tr>
  <tr bgcolor="#D6D6D6" class="Estilo25">
    <td width="164" colspan="2">Clasificador</td>
    <td width="172" colspan="2">Fuente Econ&oacute;mica </td>
  </tr>
  <!-- Elige la tarea para mostrala -->
  <!--  funciona   -->
  <tr>
    <td colspan="2"><span class="Estilo25"> <c:out value="${reghisto.codmon}"/> </span></td>
    <td colspan="2"><span class="Estilo25"> <c:out value="${reghisto.codfueneco}"/> </span></td>
  </tr>
  <tr>
    <td colspan="2" bgcolor="#D6D6D6"><div align="center"></div>
        <div align="center" class="Estilo25">Glosa</div></td>
    <td bgcolor="#D6D6D6"><div align="center"><span class="Estilo29"><strong>Comprobante </strong> </span> </div> </td>
    <td bgcolor="#D6D6D6"><div align="center"><span class="Estilo29"><strong>Fecha</strong> </span></div></td>
    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto&nbsp;</strong></div></td>
  </tr>


  <tr>
    <td colspan="2">
      <div align="justify"><span class="Estilo25"><c:out value="${reghisto.glosa}"/></span></div></td>
    <td><div align="right"><span class="Estilo25"><c:out value="${reghisto.cbte}"/></span></div></td>
    <td><div align="right"><span class="Estilo25"><c:out value="${reghisto.fecha}"/></span></div></td>
    <td><div align="right"><span class="Estilo25"><fmt:formatNumber value="${reghisto.monto}" pattern="#,###,###,##0.00"/></span></div></td>
  </tr>

  <tr bgcolor="#CC3333" >
    <td height="5" colspan="6"></td>
  </tr>
</table>

<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>