<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>

    <title>Mostrando los montos presupuestados</title>


<script type="text/javascript">
        function confirma(miurl,aa,bb){

        question = confirm("Desea Eliminar la ejecucion Rubro: "+ aa +" con el comprobante "+ bb +"?")
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
      <th colspan="2" ><div align="center">Modificar Monto No Presupuestados Ingresos</div></th>
    </tr>
    <tr >
        <th width="238" >Actividad <c:out value="${actividad.descripcion}"/> </th>
        <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
    </tr>
</table>

<table width="616">
<tr>
    <th width="184"><div align="center">Rubro</div></th>
    <th width="107" ><div align="center">Fuente Econ&oacute;mica</div></th>

    <th width="88"><div align="center">Presupuestado</div></th>
    <th width="102"><div align="center">Ejecutado</div></th>
    <th width="44"><div align="center">Saldo</div></th>

</tr>

<tr>
    <td><c:out value="${codmonnopreing}"/> - <c:out value="${descla}"/> </td>
    <td><c:out value="${codfueneco}"/> - <c:out value="${fuu.descripcion}"/>  </td>

    <td><div align="right">-</div></td>
    <td><div align="right"><c:out value="${monejenopre}"/></div></td>
    <td><div align="right">.</div></td>

</tr>

<tr>
    <th colspan="5" >Historial Ejecutados</th>

</tr>

<tr>
    <th height="36"><div align="center">Glosa</div></th>
    <th width="107"><div align="center">Fecha de Ejecuci&oacute;n</div></th>


    <th>Comprobante</th>
    <th>Monto Acumulado</th>

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
    <!-- Elige la tarea para mostrala -->

    <tr>
        <td><div align="right"><c:out value="${moo.obs}"/></div></td>
        <td><div align="right"><c:out value="${moo.fecharef}"/> </div></td>
        <td><div align="right"> <c:out value="${moo.comprobante}"/></div></td>
        <td><div align="right">
		  <a href=<c:url value="/ModRefEjeNoPre.do">

                   <c:param name="comprobante" value="${moo.comprobante}"/>
                   <c:param name="codtar" value="${tarea.codtar}"/>
                   <c:param name="codacti" value="${actividad.codacti}"/>
                   <c:param name="codfueneco" value="${codfueneco}"/>
                   <c:param name="desfuen" value="${fuu.descripcion}"/>
                   <c:param name="idd" value="${moo.idd}"/>
                   <c:param name="fecha" value="${moo.fecharef}"/>
                   <c:param name="codmonnopreing" value="${codmonnopreing}"/>
                   <c:param name="descla" value="${descla}"/>
                   <c:param name="monacumulado" value="${moo.mon_acu}"/>
                   <c:param name="observaciones" value="${moo.obs}"/>
               </c:url>> <fmt:formatNumber  value="${moo.mon_acu}" pattern="#,###,###,##0.00"/> </a>


		  </div></td>
        <td>
            <a  target="mainFrame"  onClick="confirma('<c:url value="/EliRefEjeNoPre.do">

                   <c:param name="comprobante" value="${moo.comprobante}"/>
                   <c:param name="codtar" value="${tarea.codtar}"/>
                   <c:param name="codacti" value="${actividad.codacti}"/>
                   <c:param name="codfueneco" value="${codfueneco}"/>
                   <c:param name="desfuen" value="${fuu.descripcion}"/>
                   <c:param name="idd" value="${moo.idd}"/>
                   <c:param name="fecha" value="${moo.fecharef}"/>
                   <c:param name="codmonnopreing" value="${codmonnopreing}"/>
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