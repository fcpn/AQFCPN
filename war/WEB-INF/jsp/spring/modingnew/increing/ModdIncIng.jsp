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

<form name="form1" method="post"  onsubmit="return confirm('¿Esta seguro de los cambios?')" action="<c:url value="/ModdIncIng2.do"/>">

  <table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#003366" >
      <td colspan="2" ><div align="center" class="Estilo4">Modificar Incrementos</div></td>
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
<tr bgcolor="#D6D6D6" class="Estilo25">
    <td width="164" colspan="2"><div align="center"><span class="Estilo25">Clasificador</span></div></td>
    <td width="172" colspan="2"><div align="center"><span class="Estilo25"> Fuente Econ&oacute;mica </span></div></td>


    </tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr bgcolor="#8F8F8F">
    <td colspan="2"><div align="center"><span class="Estilo25">
      <input  align="center" name="codmoning" type="text" id="codmoning" value="<c:out value="${codmoning}"/>"></span></div></td>
    <td colspan="2"> <div align="center"><span class="Estilo25">
      <input  align="center" name="codfueneco" type="text" id="codfueneco" value="<c:out value="${codfueneco}"/>"> </span></div></td>


    </tr>







<!--Montos No presupuestados -->
<tr bgcolor="#CC3333" >
    <td colspan="6" ></td>
    </tr>

<tr>
    <td colspan="2" bgcolor="#D6D6D6"><div align="center" class="Estilo25">Glosa</div></td>
    <td width="123" bgcolor="#D6D6D6"><span class="Estilo29"><strong>Comprobante </strong> </span>     </td>
    <td width="100" bgcolor="#D6D6D6"><span class="Estilo29"><strong>Fecha deTraspaso </strong> </span></td>



    <td width="85" bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong> Monto&nbsp;</strong></div></td>


</tr>


    <!-- Elige la tarea para mostrala -->

    <tr bgcolor="#8F8F8F">
        <td colspan="2"><span class="Estilo25">
        <textarea name="glosa" id="glosa"><c:out value="${reghis.glosa}"/></textarea>
       </span> </td>
        <td><span class="Estilo25"><input  align="center" name="cbte" type="text" id="cbte" value="<c:out value="${reghis.cbte}"/>">  </span></td>
        <td><span class="Estilo25"><input  align="center" name="fecha" type="text" id="fecha" value="<c:out value="${reghis.fecha}"/>"> </span></td>
        <td><span class="Estilo25"><input  align="center" name="monto" type="text" id="monto" value="<c:out value="${reghis.monto}"/>"> </span></td>

    </tr>




<tr bgcolor="#CC3333" >
    <td height="5" colspan="6"></td>
</tr>

<tr>
    <td height="5" colspan="6"></td>
</tr>
<tr>
    <td height="5" colspan="6"><div align="right">
      <input type="submit" name="Submit" value="Modificar datos">
    </div></td>
</tr>
</table>



<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
<input type=hidden name=codmoning1 value='<c:out value="${codmoning}"/>'>
<input type=hidden name=monto1 value='<c:out value="${reghis.monto}"/>'>
<input type=hidden name=codfueneco1 value='<c:out value="${reghis.codfueneco}"/>'>
<input type=hidden name=glosa1 value='<c:out value="${reghis.glosa}"/>'>
<input type=hidden name=cbte1 value='<c:out value="${reghis.cbte}"/>'>
<input type=hidden name=id value='<c:out value="${reghis.id}"/>'>
<input type=hidden name=fecha1 value='<c:out value="${reghis.fecha}"/>'>


</form>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>