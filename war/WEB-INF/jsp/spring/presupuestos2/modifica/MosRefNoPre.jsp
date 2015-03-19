<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    <title>Mostrando los montos presupuestados</title>
<script type="text/javascript">
        function confirma(miurl,aa,bb){

        question = confirm("Desea Eliminar la ejecucion Partida: "+ aa +" con el comprobante "+ bb +"?")
        if (question !="0"){
        document.location.href = miurl;
        }
        }

</script>

</head>
<body>

<div id="container">
<div id="content">
<form name="form1" method="post" action="  ">
<table width="523">
    <tr>
        <th colspan="2" ><div align="center">Modificar No Presupuestados Egresos</div></th>
    </tr>
    <tr >
        <th width="238" >Actividad <c:out value="${actividad.descripcion}"/> </th>
        <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
    </tr>
</table>


<table width="871">
<tr>
    <th>Partida</th>
    <th width="138" >Fuente Econ&oacute;mica </th>
    <th>Presupuestado</th>
    <th>Ejecutado</th>
    <th>Saldo</th>

</tr>


<tr>
    <td><c:out value="${codmonnopreegr}"/> - <c:out value="${descla}"/> </td>
    <td><c:out value="${codfueneco}"/> - <c:out value="${fuu.descripcion}"/>  </td>
    <td><div align="right">.</div></td>
    <td><div align="right"><c:out value="${monejenopre}"/></div></td>
    <td><div align="right">.</div></td>
</tr>

<tr>
    <th colspan="5" >Historial del monto Ejecutado </th>
</tr>

<tr>
    <th>Glosa</th>
    <th width="138">Fecha de Ejecuci&oacute;n</th>
    <th>Comprobante</th>
    <th>Monto acumulado </th>
    <th>.</th>
</tr>

<tr>
    <td height="36"><div align="center"><c:out value="${monp.glosa_s}"/></div></td>
    <td width="107"><div align="center"><c:out value="${monp.fecha_saldo}"/></div></td>


    <td><c:out value="${monp.comprobante}"/></td>
    <td><div align="right"><fmt:formatNumber  value="${monp.saldo_ej_i}" pattern="#,###,###,##0.00"/></div></td>

    <th>Inicial</th>

</tr>

<c:forEach var="moo" items="${montos_ref}">

    <tr>
        <td><c:out value="${moo.obs}"/></td>
        <td><div align="right"><c:out value="${moo.fecharef}"/></div></td>
        <td><div align="right"> <c:out value="${moo.comprobante}"/></div></td>
        <td><div align="right">
		<a href=<c:url value="/ModRefEjeNoPreE.do">

                   <c:param name="comprobante" value="${moo.comprobante}"/>
                   <c:param name="codtar" value="${tarea.codtar}"/>
                   <c:param name="destar" value="${tarea.descripcion}"/>
                   <c:param name="codacti" value="${actividad.codacti}"/>
                   <c:param name="desact" value="${actividad.descripcion}"/>
                   <c:param name="codfueneco" value="${codfueneco}"/>
                   <c:param name="idd" value="${moo.idd}"/>
                   <c:param name="fecha" value="${moo.fecharef}"/>
                   <c:param name="codmonnopreegr" value="${codmonnopreegr}"/>
                   <c:param name="descla" value="${descla}"/>
                   <c:param name="monacumulado" value="${moo.mon_acu}"/>
                   <c:param name="observaciones" value="${moo.obs}"/>

               </c:url>>


		<fmt:formatNumber  value="${moo.mon_acu}" pattern="#,###,###,##0.00"/> </a></div></td>
        <td><div align="right"></div>

		<a  target="mainFrame"  onClick="confirma('<c:url value="/EliRefEjeNoPreE.do">

                   <c:param name="comprobante" value="${moo.comprobante}"/>
                   <c:param name="codtar" value="${tarea.codtar}"/>
                   <c:param name="destar" value="${tarea.descripcion}"/>
                   <c:param name="codacti" value="${actividad.codacti}"/>
                   <c:param name="desact" value="${actividad.descripcion}"/>
                   <c:param name="codfueneco" value="${codfueneco}"/>
                   <c:param name="idd" value="${moo.idd}"/>
                   <c:param name="fecha" value="${moo.fecharef}"/>
                   <c:param name="codmonnopreegr" value="${codmonnopreegr}"/>
                   <c:param name="descla" value="${descla}"/>
                   <c:param name="monacumulado" value="${moo.mon_acu}"/>
                   <c:param name="observaciones" value="${moo.obs}"/>

            </c:url>','<c:out value="${moo.obs}"/>','<c:out value="${moo.comprobante}"/>'); return false;"><font color="#FF0000" >Eliminar</font></a>




		</td>
    </tr>


</c:forEach>

</table>

<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>


</form>
</div></div>
</body>
</html>