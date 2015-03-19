<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Ejecutar montos Comprometidos</title>
        <link href="tablarep/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablarep/tablecloth.js"></script>
    </head>
    <body>
        <div id="container">
            <div id="content">
                <form name="form1" method="post" action="<c:url value="/EjecuCompro2.do"/>">
                    <table width="523" align="center">
                        <tr>
                            <th colspan="2" ><div align="center">Ejecutar Montos Comprometidos - Egresos </div></th>
                        </tr>
                        <tr>
                            <th width="238" ><div align="center">Actividad</div></th>
                            <th width="269" ><div align="center">Tarea</div></th>
                        </tr>
                        <tr>
                            <td width="238">
                                <c:out value="${actividad.descripcion}"/>
                                <input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>
                                <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                            </td>
                            <td width="269">
                                <c:out value="${tarea.descripcion}"/>
                                <input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>
                                <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                            </td>
                        </tr>
                    </table>
                    <table width="842" border="1" align="center">
                        <tr>
                            <th width="87">Partida</th>
                            <th width="134">Fuente Econ&oacute;mica</th>
                            <th width="98">Monto Comprometido</th>
                            <th width="421">Glosa</th>
                            <th width="68"> </th>
                        </tr>
                        <c:forEach var="mo" items="${refcompro}">
                            <tr>
                                <td><c:out value="${mo.codmonegr}"/></td>
                                <td><c:out value="${mo.codfueneco}"/></td>
                                <td><div align="right"><fmt:formatNumber pattern="###,###.##"><c:out value="${mo.monto}"/></fmt:formatNumber></div></td>
                                <td><div align="left"><c:out value="${mo.glosa}"/> <c:out value="${mo.glo_rut}"/></div></td>
                                <td> <input type="checkbox" name="comproref" value="<c:out value="${mo.codmonegr}"/>::<c:out value="${mo.codfueneco}"/>::<c:out value="${mo.monto}"/>::<c:out value="${mo.id}"/>::<c:out value="${mo.glosa}"/>::<c:out value="${mo.fecha}"/>::<c:out value="${mo.obs}"/>::<c:out value="${mo.i_e}"/>::<c:out value="${mo.ref123}"/>::<c:out value="${mo.glo_rut}"/>"></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${gg != '-1'}">
                            <tr>
                                <td height="19" colspan="7">
                                    <div align="right">
                                        <input type="submit" name="Submit" value="Aceptar">
                                    </div>
                                </td>
                            </tr>
                        </c:if>
                    </table>
                    <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                    <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                </form>
            </div>
        </div>
    </body>
</html>
