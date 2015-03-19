<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <script type="text/javascript">
        function confirma(miurl){

        question = confirm("Elimnar el Registro?")
        if (question !="0"){
        document.location.href = miurl;
        }
        }

</script>
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
    <tr bgcolor="#003366" >
      <td colspan="2" ><div align="center" class="Estilo4">Modificar  Incrementos</div></td>
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
    <td width="164"><span class="Estilo25">Clasificador</span></td>
    <td width="172" ><span class="Estilo25"> - Fuente Econ&oacute;mica </span></td>

    <td width="123"><span class="Estilo25">&nbsp;Monto Presupuestado
        <!---Ultimo # de comprobante-->
    </span></td>
    <td width="100"><span class="Estilo25"> Monto Ejecutado
        <!--monto insertando -->
    </span></td>
    <td width="85"><span class="Estilo25">Saldo</span></td>
	 <td width="85"><span class="Estilo25">&nbsp;</span></td>
</tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr>
    <td><span class="Estilo25"> <c:out value="${codmon}"/> - <c:out value="${descla}"/> </span></td>
    <td> <span class="Estilo25"> <c:out value="${codfueneco}"/> - <c:out value="${fuente.descripcion}"/></span></td>

    <td><span class="Estilo25"><div align="right"><fmt:formatNumber value="${reging.montopresu}" pattern="#,###,###,##0.00"/></div></span></td>
    <td><span class="Estilo25"><div align="right"><fmt:formatNumber value="${reging.montoeje}" pattern="#,###,###,##0.00"/></div></span></td>
    <td><span class="Estilo25"><div align="right"><fmt:formatNumber value="${reging.saldo}" pattern="#,###,###,##0.00"/></div></span></td>
    <td><span class="Estilo25"><div align="right">&nbsp; </div></span></td>

</tr>







<!--Montos No presupuestados -->
<tr bgcolor="#838383" >
    <td colspan="6" > <span class="Estilo5">Historial del monto de Incrementos</span> </td>
    </tr>

<tr>
    <td colspan="2" bgcolor="#D6D6D6"><div align="center"></div>      <div align="center" class="Estilo25">Glosa</div></td>
    <td bgcolor="#D6D6D6"><span class="Estilo29"><strong>&nbsp;
        <!---Ultimo # de comprobante-->
Comprobante
    </strong> </span>      <div align="right" class="Estilo29"></div></td>
    <td bgcolor="#D6D6D6"> <span class="Estilo29"><strong>Fecha deTraspaso </strong> </span></td>



    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Modificar Monto&nbsp;</strong></div></td>
    <td bgcolor="#CC3333"><div align="center" class="Estilo29" ><strong>Eliminar</strong></div></td>

</tr>

<c:forEach var="moo" items="${his_inc}">
    <!-- Elige la tarea para mostrala -->

    <tr onMouseOver="this.style.backgroundColor='#CC9999';" onMouseOut="this.style.backgroundColor='#ffffff';">
        <td colspan="2"><span class="Estilo25"> <div align="justify"><c:out value="${moo.glosa}"/></div></span> </td>
        <td><span class="Estilo25"><div align="right"><c:out value="${moo.cbte}"/></div> </span></td>
        <td><span class="Estilo25"><div align="right"><c:out value="${moo.fecha}"/></div> </span></td>
        <td><span class="Estilo25"><div align="right">
        <a  href="<c:url value="/ModdIncEgr.do">
                           <c:param name="codmon" value="${codmon}"/>
                           <c:param name="codfueneco" value="${codfueneco}"/>
                           <c:param name="codtar" value="${tarea.codtar}"/>
                           <c:param name="id" value="${moo.id}"/>
                           <c:param name="monto" value="${moo.monto}"/>
                   </c:url>"><fmt:formatNumber value="${moo.monto}" pattern="#,###,###,##0.00"/></a>
                </div> </span></td>



		<td><span class="Estilo25"><div align="center">
                         <a  target="mainFrame" onClick="confirma('<c:url value="/EliIncEgr.do">
                          <c:param name="codmon" value="${codmon}"/>
                          <c:param name="codfueneco" value="${codfueneco}"/>
                          <c:param name="codtar" value="${tarea.codtar}"/>
                          <c:param name="id" value="${moo.id}"/>
                          <c:param name="glosa" value="${moo.glosa}"/>
                          <c:param name="cbte" value="${moo.cbte}"/>
                          <c:param name="fecha" value="${moo.fecha}"/>
                          <c:param name="monto" value="${moo.monto}"/>
                   </c:url>'); return false;">Eliminar </a>

                        </div> </span></td>

    </tr>


</c:forEach>

<tr bgcolor="#CC3333" >
    <td height="5" colspan="6"></td>
</tr>
</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>