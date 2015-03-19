<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Eliminar montos Comprometidos</title>
    <style type="text/css">
        <!--
.Estilo3 {color: #003399}
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo7 {color: #000000; font-weight: bold; }
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="<c:url value="/EliMonComEgrAcu2.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#BAAD74" >
        <td colspan="2" ><div align="center" class="Estilo4">Eliminar Montos Comprometidos Acumulados Egresos </div></td>
    </tr>
    <tr bgcolor="#DED8BC" >
        <td width="238" ><div align="center"><strong>Actividad </strong></div></td>

        <td width="269" ><div align="center"><strong>Tarea </strong></div></td>

    </tr>
	<tr >
        <td width="238" ><strong> <c:out value="${actividad.descripcion}"/> </strong>
        <input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>
        <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'></td>
        <td width="269"><strong> <c:out value="${tarea.descripcion}"/> </strong>
        <input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>
        <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'></td>
    </tr>
</table>

<!-- mostrando datos generales -->
<br><br><br>
<table width="842" border="1" align="center" bordercolor="#CC9933">
<tr>
    <td width="91" bgcolor="#BAAD74">&nbsp;Partida</td>
    <td width="119" bgcolor="#BAAD74" ><strong> Fuente Econ&oacute;mica </strong></td>

    <td width="120" bgcolor="#BAAD74"><strong>&nbsp;Monto Comprometido
        <!---Ultimo # de comprobante-->
    </strong></td>

    <td width="400" bgcolor="#BAAD74"><strong>&nbsp;Glosa
        <!---Ultimo # de comprobante-->
    </strong></td>


    <td width="78"> </td>
</tr>



<c:forEach var="mo" items="${refcompro}">

            <tr>
            <td><c:out value="${mo.codmonegr}"/></td>
            <td><c:out value="${mo.codfueneco}"/></td>
            <td><div align="right">&nbsp;<c:out value="${mo.monto}"/>
            </div></td>

            <td><div align="right">&nbsp;<c:out value="${mo.glosa}"/></div></td>

            <td> <input type="checkbox" name="comproref" value="<c:out value="${mo.codmonegr}"/>::<c:out value="${mo.codfueneco}"/>::<c:out value="${mo.monto}"/>::<c:out value="${mo.id}"/>::<c:out value="${mo.glosa}"/>::<c:out value="${mo.num_sol}"/>::<c:out value="${mo.cantidad}"/>::<c:out value="${mo.responsable}"/>::<c:out value="${mo.glo_rut}"/>"></td>


        </tr>

</c:forEach>



    <c:if test="${gg != '-1'}">
       <tr bgcolor="#BAAD74">
            <td height="19" colspan="7"><div align="right"><span class="Estilo3">
                        <input type="submit" name="Submit" value="Aceptar">
           </span></div></td>
        </tr>

    </c:if>
</table>

<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>

</form>

</body>
</html>
