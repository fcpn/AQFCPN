
<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    <title>Mostrando los montos presupuestados</title>
<script type="text/javascript">
        function confirma(miurl,aa,bb,cc,dd){

        question = confirm("Desea Eliminar la ejecucion de la Partida: "+ aa +" de la fuente Economica "+ bb +" "+cc+" con monto "+dd+"?")
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
      <th colspan="2" ><div align="center">Modificar Ejecuciones Egresos </div></th>
    </tr>
    <tr >
        <th width="238" >Actividad <c:out value="${actividad.descripcion}"/> </th>
        <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
    </tr>
</table>

<table width="787">
<tr>
    <th width="236">-</th>
    <th width="105">Fuente Econ&oacute;mica<th>

    <th width="92">Presupuestado</th>
    <th width="84">Modif/Ejecutado</th>
    <th width="78">Saldo</th>
    <th width="152">-</th>
</tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr>
    <td><c:out value="${codmonegr}"/> - <c:out value="${descla}"/></td>
    <td><c:out value="${codfueneco}"/> - <c:out value="${desfe}"/></td>

    <td><div align="right"><c:out value="${montos.montopresu}"/></div></td>
    <td><div align="right">
	<a href=<c:url value="/ModSoloEjeE.do">


                   <c:param name="codtar" value="${tarea.codtar}"/>
                   <c:param name="codacti" value="${actividad.codacti}"/>
                   <c:param name="codfueneco" value="${codfueneco}"/>
                   <c:param name="codmonegr" value="${codmonegr}"/>
                   <c:param name="moneje" value="${montos.montoeje}"/>
                   <c:param name="montopresu" value="${montos.montopresu}"/>


               </c:url>>  <c:out value="${montos.montoeje}"/>  </a>

    </div></td>
    <td><div align="right"><c:out value="${montos.saldo}"/> </div></td>
    <td> </td>
</tr>


<!--Montos No presupuestados -->
<tr>
    <td colspan="6">Historial Ejecutado </td>

</tr>

<tr>
    <th>Glosa</th>
    <th width="105"><div align="center">Fecha de Ejecuci&oacute;n </div></th>

    <th>Comprobante</th>
    <th>Monto Acumulado</th>
    <th>-</th>
    <th>-</th>
</tr>

<c:forEach var="moo" items="${montos_ref}">
    <!-- Elige la tarea para mostrala -->

    <tr>
        <td><c:out value="${moo.observaciones}"/></td>
        <td><div align="right"> <c:out value="${moo.fecha}"/>  </div></td>
        <td><div align="right"><c:out value="${moo.comprobante}"/></div></td>
        <td><div align="right"> <c:out value="${moo.monacumulado}"/> </div></td>
        <td><div align="right">
		<a href=<c:url value="/ModRefEjeE.do">

                   <c:param name="comprobante" value="${moo.comprobante}"/>
                   <c:param name="id" value="${moo.id}"/>


                   <c:param name="codtar" value="${tarea.codtar}"/>
                   <c:param name="destar" value="${tarea.descripcion}"/>

                   <c:param name="codacti" value="${actividad.codacti}"/>
                   <c:param name="desact" value="${actividad.descripcion}"/>

                   <c:param name="codfueneco" value="${codfueneco}"/>
                   <c:param name="desfe" value="${desfe}"/>

                   <c:param name="fecha" value="${moo.fecha}"/>

                   <c:param name="codmonegr" value="${codmonegr}"/>
                   <c:param name="descla" value="${descla}"/>

                   <c:param name="monacumulado" value="${moo.monacumulado}"/>
                   <c:param name="observaciones" value="${moo.observaciones}"/>

               </c:url>>Modificar</a>

		</div></td>
        <td>

<a  target="mainFrame"  onClick="confirma('<c:url value="/EliRefEjeE.do">
                   <c:param name="id" value="${moo.id}"/>
                   <c:param name="codtar" value="${tarea.codtar}"/>
                   <c:param name="codacti" value="${actividad.codacti}"/>
                   <c:param name="codfueneco" value="${codfueneco}"/>
                   <c:param name="monacumulado" value="${moo.monacumulado}"/>
                   <c:param name="codmonegr" value="${codmonegr}"/>
</c:url>','<c:out value="${codmoning}"/>','<c:out value="${codfueneco}"/>','<c:out value="${moo.observaciones}"/>','<c:out value="${moo.monacumulado}"/>'); return false;"> <font color="#FF0000">Eliminar</font></a>

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