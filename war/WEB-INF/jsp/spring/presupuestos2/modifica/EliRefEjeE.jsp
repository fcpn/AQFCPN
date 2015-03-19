
<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    <title>Mostrando los montos presupuestados</title>
<script type="text/javascript">
        function confirma(miurl,aa,bb,cc,dd){

        question = confirm("Desea Eliminar la ejecucion del Rubro: "+ aa +" de la fuente Economica "+ bb +" "+cc+" con monto "+dd+"?")
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
    <tr>
        <th width="238" >Actividad <c:out value="${actividad.descripcion}"/> </th>
        <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
    </tr>
</table>

<table width="787">


<!--Montos No presupuestados -->
<tr>
    <th colspan="5">Historial del monto Ejecutado</th>

</tr>

<tr>
    <th width="236">Glosa</th>
    <th width="105"><div align="center">Fecha de Ejecuci&oacute;n </div></th>
    <th width="92">Comprobante</th>
    <th width="84">Monto Acumulado</th>

    <th width="78">Rubro</th>
    <th width="152">Fuente Economica </th>
</tr>


    <!-- Elige la tarea para mostrala -->

    <tr>
        <td><c:out value="${moo.observaciones}"/></td>
        <td><div align="right"> <c:out value="${moo.fecha}"/>  </div></td>
        <td><div align="right"><c:out value="${moo.comprobante}"/></div></td>
        <td><div align="right"><c:out value="${moo.monacumulado}"/> </div></td>
        <td><div align="right"><c:out value="${moo.codmonegr}"/></div></td>
        <td><div align="right"><c:out value="${moo.codfueneco}"/></div></td>
    </tr>
<tr> <td colspan="6">si los datos de fecha, glosa y cbte estan vacios se borro los datos satisfactoriamente<!--
<a href="<c:url value="/MosEjePre.do">

                   <c:param name="comprobante" value="${moo.comprobante}"/>
                   <c:param name="id" value="${moo.id}"/>


                   <c:param name="codtar" value="${tarea.codtar}"/>
                   <c:param name="destar" value="${tarea.descripcion}"/>

                   <c:param name="codacti" value="${actividad.codacti}"/>
                   <c:param name="desact" value="${actividad.descripcion}"/>

                   <c:param name="codfueneco" value="${codfueneco}"/>
                   <c:param name="desfe" value="${desfe}"/>

                   <c:param name="fecha" value="${moo.fecha}"/>

                   <c:param name="codmoning" value="${codmoning}"/>
                   <c:param name="descla" value="${descla}"/>

                   <c:param name="monacumulado" value="${moo.monacumulado}"/>
                   <c:param name="observaciones" value="${moo.observaciones}"/>

               </c:url>">Retornar</a> -->

</td></tr>




</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>
</div></div>
</body>
</html>