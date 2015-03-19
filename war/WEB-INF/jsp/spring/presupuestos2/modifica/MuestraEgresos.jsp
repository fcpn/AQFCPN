<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    <title>Mostrando los montos presupuestados Egresos</title>
    <script type="text/javascript">
        function confirma(miurl,aa,bb){

        question = confirm("Para Eliminar la Partida no debe tener ejecuciones, Desea Eliminar el Rubro: "+ aa +" de la fuente Economica "+ bb +"?")
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
        <th colspan="2" ><div align="center">Modificar Egresos </div></th>
    </tr>
    <tr >
        <th width="238" >Actividad  <c:out value="${actividad.descripcion}"/> </th>
        <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
    </tr>
</table>

<table width="597">
<tr>
    <th width="76">-</th>
    <th width="80" ><div align="center">Fuente Econ&oacute;mica</div></th>

    <th width="66"><div align="center">Presupuestado</div></th>
    <th width="46"><div align="center">Ejecutado</div></th>

    <th width="57"><div align="center">Saldo</div></th>
    <th width="45" colspan="4">-</th>
</tr>



<c:forEach var="mo" items="${mosmoneje}">
    <!-- Elige la tarea para mostrala -->

    <c:if test="${mo.codtar==tarea.codtar }">
        <!--  funciona   -->

        <tr>
            <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
            <td><c:out value="${mo.codfueneco}"/> - <c:out value="${mo.desfe}"/></td>
            <td>
                <div align="right">
                <a href=<c:url value="/MoodPreEgr.do">
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       </c:url>><c:out value="${mo.monto}"/> </a>
                </div>
            </td>

               <td><div align="right">
                <a href=<c:url value="/MosEjePreE.do">
                       <c:param name="moneje" value="${mo.moneje}"/>
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="desfe" value="${mo.desfe}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="descla" value="${mo.descla}"/>
                   </c:url>> <c:out value="${mo.moneje}"/> </a></div></td>

            <td><div align="right"><c:out value="${mo.saldo}"/> </div></td>
            <td width="91">
                     <a href=<c:url value="/ModEgr.do">
                       <c:param name="moneje" value="${mo.moneje}"/>

                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="destar" value="${tarea.descripcion}"/>

                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="desatc" value="${actividad.descripcion}"/>



                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="desfe" value="${mo.desfe}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="descla" value="${mo.descla}"/>
                   </c:url>>Modificar Ppto/Fuentes</a>



            </td>

			<td>
			 <a href=<c:url value="/ModIncEgr.do">
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="i_e" value="${mo.i_e}"/>
                       </c:url>>Modificar Incrementos</a>
			</td>

            <td>
			 <a href=<c:url value="/ModTraEgr.do">
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="monto" value="${mo.monto}"/>
                       <c:param name="moneje" value="${mo.moneje}"/>
                       <c:param name="saldo" value="${mo.saldo}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="codmonegr" value="${mo.codmoning}"/>
                       <c:param name="i_e" value="${mo.i_e}"/>
                       </c:url>>Modificar Traspaso</a>
			</td>

                        <td>


                      <a  target="mainFrame"  onClick="confirma('<c:url value="/EliPresuEgr.do">

                       <c:param name="codtar" value="${codtar}"/>
                       <c:param name="codacti" value="${codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="codmonegr" value="${mo.codmoning}"/>
                       <c:param name="i_e" value="${mo.i_e}"/>
                       </c:url>','<c:out value="${mo.codmoning}"/>','<c:out value="${mo.codfueneco}"/>'); return false;"><font color="#FF0000" >Eliminar</font></a>





                        </td>
        </tr>
    </c:if>
</c:forEach>






<!--Montos No presupuestados -->
<tr>
    <th colspan="9" >Montos No Presupuestados</th>
    </tr>

<c:forEach var="moo" items="${mos}">
      <c:if test="${moo.codtar==tarea.codtar }">
        <tr>
            <td><c:out value="${moo.codmonnopreegr}"/> - <c:out value="${moo.descla}"/></td>
            <td><c:out value="${moo.codfueneco}"/></td>
            <td>.</td>
            <td><div align="right">
                    <a href=<c:url value="/MosEjeNoPreClaE.do">
                       <c:param name="monejenopre" value="${moo.monejenopre}"/>

                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="destar" value="${tarea.descripcion}"/>

                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="desact" value="${actividad.descripcion}"/>

                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="ref123" value="${moo.ref123}"/>

                       <c:param name="codmonnopreegr" value="${moo.codmonnopreegr}"/>
                       <c:param name="descla" value="${moo.descla}"/>
                   </c:url>> <c:out value="${moo.monejenopre}"/> </a>




            </div></td>
            <td>
            .

            </td>
            <td><div align="right"> <a href=<c:url value="/MosEjeNoPreE.do">
                       <c:param name="monejenopre" value="${moo.monejenopre}"/>
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${moo.codfueneco}"/>


                       <c:param name="codmonnopreegr" value="${moo.codmonnopreegr}"/>
                       <c:param name="descla" value="${moo.descla}"/>
                   </c:url>>Modificar Ejecutado</a></div></td>
            <td>



         </td>
            <td width="84">

            </td>

			<td width="84">
<a  target="mainFrame"  onClick="confirma('<c:url value="/EliNoPresuEgr.do">

                     <c:param name="monejenopre" value="${moo.monejenopre}"/>
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="codmonnopreegr" value="${moo.codmonnopreegr}"/>
                       <c:param name="descla" value="${moo.descla}"/>

                       </c:url>','<c:out value="${moo.codmonnopreegr}"/>','<c:out value="${moo.codfueneco}"/>'); return false;"><font color="#FF0000" >Eliminar</font></a>


            </td>
        </tr>

    </c:if>
</c:forEach>

<tr>
    <th><div align="center" >TOTALES </div></th>
    <td></td>
    <td><div align="right">[<c:out value="${too}"/>]</div></td>
    <td><div align="right" >[<c:out value="${too3}"/>]
    </div></td>
    <td><div align="right">[<c:out value="${too1}"/>]</div></td>
    <td colspan="4"></td>

</tr>


</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>
</div></div>
</body>
</html>