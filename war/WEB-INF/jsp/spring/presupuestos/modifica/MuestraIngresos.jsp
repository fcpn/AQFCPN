<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    <title>Mostrando los montos presupuestados</title>


<script type="text/javascript">
        function confirma(miurl,aa,bb){

        question = confirm("Para Eliminar el Rubro no debe tener ejecuciones, Desea Eliminar el Rubro: "+ aa +" de la fuente Economica "+ bb +"?")
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
<table width="523" align="center">
    <tr>
        <th colspan="2" ><div align="center">Modificar Ingresos </div></th>
    </tr>
    <tr >
        <th width="238" >Actividad <c:out value="${actividad.descripcion}"/> </th>
        <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
    </tr>
</table>




<br>
<table width="597" align="center">
<tr >
    <th width="85">&nbsp;</th>
    <th width="112" ><div align="center">Fuente Econ&oacute;mica</div></th>
    <th width="77"><div align="center">Presupuestado</div></th>
    <th width="52"><div align="center">Ejecutado</div></th>
    <th width="28"><div align="center">Saldo</div></th>
    <th width="109" colspan="3">&nbsp;</th>
</tr>
<c:forEach var="mo" items="${mosmoneje}">

    <c:if test="${mo.codtar==tarea.codtar }">

        <tr>
            <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
            <td><c:out value="${mo.codfueneco}"/> - <c:out value="${mo.desfe}"/></td>
            <td>
                <div align="right">
                <a href=<c:url value="/MoodPreIng.do">
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       </c:url>><c:out value="${mo.monto}"/> </a>
                </div>
            </td>

            <td><div align="right">
			<a href=<c:url value="/MosEjePre.do">
                       <c:param name="moneje" value="${mo.moneje}"/>
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="desfe" value="${mo.desfe}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="descla" value="${mo.descla}"/>
                   </c:url>> <c:out value="${mo.moneje}"/> </a></div></td>

            <td><div align="right"><c:out value="${mo.saldo}"/> </div></td>
            <td>

                 <a href=<c:url value="/ModIng.do">
                       <c:param name="moneje" value="${mo.moneje}"/>

                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="destar" value="${tarea.descripcion}"/>

                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="desatc" value="${actividad.descripcion}"/>

                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="desfe" value="${mo.desfe}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="descla" value="${mo.descla}"/>
                   </c:url>>Modif. Presupuestado/Fuentes </a>
            </td>

			<td>
			 <a href=<c:url value="/ModIncIng.do">
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="i_e" value="${mo.i_e}"/>
                       </c:url>>Modif. Incrementos</a>
			</td>

			<td>
			 <a  target="mainFrame"  onClick="confirma('<c:url value="/EliPresuIng.do">

                       <c:param name="codtar" value="${codtar}"/>
                       <c:param name="codacti" value="${codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="i_e" value="${mo.i_e}"/>
                       </c:url>','<c:out value="${mo.codmoning}"/>','<c:out value="${mo.codfueneco}"/>'); return false;"><font color="#FF0000" >Eliminar</font></a>
			</td>


        </tr>
    </c:if>
</c:forEach>


<tr>
    <th colspan="8" >Montos No Presupuestados</th>
</tr>

<c:forEach var="moo" items="${mos}">

    <c:if test="${moo.codtar==tarea.codtar }">
        <tr>
            <td><c:out value="${moo.codmonnopreing}"/> - <c:out value="${moo.descla}"/></td>
            <td><c:out value="${moo.codfueneco}"/></td>
            <td>_</td>
            <td><div align="right">
			<a href=<c:url value="/MosEjeNoPreCla.do">
                       <c:param name="monejenopre" value="${moo.monejenopre}"/>

                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="destar" value="${tarea.descripcion}"/>

                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="desact" value="${actividad.descripcion}"/>

                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="ref123" value="${moo.ref123}"/>

                       <c:param name="codmonnopreing" value="${moo.codmonnopreing}"/>
                       <c:param name="descla" value="${moo.descla}"/>
                   </c:url>> <c:out value="${moo.monejenopre}"/></a>

            </div></td>
            <td>


            </td>
            <td>
		 <a href=<c:url value="/MosEjeNoPre.do">
                       <c:param name="monejenopre" value="${moo.monejenopre}"/>
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="codmonnopreing" value="${moo.codmonnopreing}"/>
                       <c:param name="descla" value="${moo.descla}"/>
                       <c:param name="saldo_ej_i" value="${moo.saldo_ej_i}"/>
                       <c:param name="fecha_saldo" value="${moo.fecha_saldo}"/>
                       <c:param name="comprobante" value="${moo.comprobante}"/>
                       <c:param name="glosa_s" value="${moo.glosa_s}"/>

                   </c:url>>Modif. Ejecutado </a>


			</td>
            <td width="88"> </td>
			<td width="88">
			<a  target="mainFrame"  onClick="confirma('<c:url value="/EliNoPresuIng.do">

                       <c:param name="monejenopre" value="${moo.monejenopre}"/>
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="codmonnopreing" value="${moo.codmonnopreing}"/>
                       <c:param name="descla" value="${moo.descla}"/>
                       
                       </c:url>','<c:out value="${moo.codmonnopreing}"/>','<c:out value="${moo.codfueneco}"/>'); return false;"><font color="#FF0000" >Eliminar</font></a>

			</td>
        </tr>

    </c:if>
</c:forEach>

<tr>
    <th><div align="center"><strong>TOTALES </strong></div></th>
    <td>.&nbsp;</td>
    <td><div align="right" class="Estilo5">[<c:out value="${too}"/>]</div></td>
    <td><div align="right" class="Estilo5">[<c:out value="${too3}"/>]</div></td>
    <td><div align="right" class="Estilo5">[<c:out value="${too1}"/>]</div></td>
    <td>.</td>
    <td>.</td>
</tr>

</table>

<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>
</div></div>
</body>
</html>