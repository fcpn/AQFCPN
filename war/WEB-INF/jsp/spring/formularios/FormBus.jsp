<%@ include file="../Cabecera.jsp" %>
<html>
    <head>
        <title></title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    </head>
    <body>
        <div id="container">
            <div id="content">

                <table width="449" align="center">
                    <tr>
                        <th>
                            <div align="center">
                                <strong>
                                    Lista de Formularios de compra de la tarea<br>
                                    <c:out value="${tarea.descripcion}"/><br>
                                    con c&oacute;digo <br><c:out value="${tarea.codtar}"/><br>
                                    en Proceso<br>
                                    Mostradas en orden de<br>
                                    correlativo de la UNIDAD
                                </strong>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <td><div align="center">
                                <table width="328">
                                    <tr>
                                        <th width="121"><strong>Fecha de petici&oacute;n </strong></th>
                                        <th width="132"><strong>Nro. de correlativo Cert. presupuestaria </strong></th>
                                        <th width="132"><strong>Nro. de correlativo Unidad</strong></th>
                                        <th width="132"><strong>Solicitud de compra</strong></th>
                                        <th width="132"><strong>Pedido de Material</strong></th>
                                        <th width="132"><strong>Orden Compra</strong></th>
                                        <th width="132"><strong>Orden de Compra</strong></th>
                                        <th width="132"><strong>Nro. de correlativo Ingreso Mat.</strong></th>
                                        <th width="132"><strong>Orden de Compra</strong></th>
                                    </tr>
                                    <c:forEach var="g" items="${correlativo}">
                                        <tr>
                                            <td style="<c:if test="${g.culmi_anula == 'culminado'}">background:#8AFF6C</c:if><c:if test="${g.culmi_anula == 'anulado'}">background:#FF9693</c:if>">
                                                <div align="center"><strong> <c:out value="${g.fecha}"/> - <c:out value="${g.culmi_anula}"/></strong></div>                                            </td>
                                            <td>
                                                <div align="center"><strong> <c:out value="${g.num_sol}"/></strong> </div>                                            </td>
                                            <td>
                                                <div align="center">
                                                    <a  href="<c:url value="/SolComUc31.do">
                                                            <c:param name="codtar" value="${g.codtar}"/>
                                                            <c:param name="codacti" value="${actividad.codacti}"/>
                                                            <c:param name="fecha" value="${g.fecha}"/>
                                                            <c:param name="num_sol" value="${g.num_sol}"/>
                                                            <c:param name="correlativo_unidad" value="${g.correlativo_unidad}"/>
                                                        </c:url>"><strong> <c:out value="${g.correlativo_unidad}"/></strong>                                                    </a>                                                </div>                                            </td>
                                            <td>
                                                <div align="center">
                                                    <a  href="<c:url value="/SolComUc5.do">
                                                            <c:param name="codtar" value="${g.codtar}"/>
                                                            <c:param name="codacti" value="${actividad.codacti}"/>
                                                            <c:param name="fecha" value="${g.fecha}"/>
                                                            <c:param name="num_sol" value="${g.num_sol}"/>
                                                            <c:param name="correlativo_unidad" value="${g.correlativo_unidad}"/>
                                                        </c:url>">
                                                        <strong>Solicitud de Compra</strong>                                                    </a>                                                </div>                                            </td>
                                            <td>
                                                <div align="center">
                                                    <a  href="<c:url value="/SolComUc6.do">
                                                            <c:param name="codtar" value="${g.codtar}"/>
                                                            <c:param name="codacti" value="${actividad.codacti}"/>
                                                            <c:param name="fecha" value="${g.fecha}"/>
                                                            <c:param name="num_sol" value="${g.num_sol}"/>
                                                            <c:param name="correlativo_unidad" value="${g.correlativo_unidad}"/>
                                                        </c:url>">
                                                        <strong>Pedido de Material</strong>                                                    </a>                                                </div>                                            </td>
                                            <td>
                                                <div align="center">
                                                    <a  href="<c:url value="/SolComUc7.do">
                                                            <c:param name="codtar" value="${g.codtar}"/>
                                                            <c:param name="codacti" value="${actividad.codacti}"/>
                                                            <c:param name="fecha" value="${g.fecha}"/>
                                                            <c:param name="num_sol" value="${g.num_sol}"/>
                                                            <c:param name="correlativo_unidad" value="${g.correlativo_unidad}"/>
                                                            <c:param name="correlativo_orden_compra" value="${g.correlativo_orden_compra}"/>
                                                        </c:url>"><STRONG><c:out value="${g.correlativo_orden_compra}"/> </STRONG>                                                    </a>                                                </div>                                            </td>
                                            <td>
                                                <div align="center">
                                                    <a  href="<c:url value="/SolComUc8.do">
                                                            <c:param name="codtar" value="${g.codtar}"/>
                                                            <c:param name="codacti" value="${actividad.codacti}"/>
                                                            <c:param name="fecha" value="${g.fecha}"/>
                                                            <c:param name="num_sol" value="${g.num_sol}"/>
                                                            <c:param name="correlativo_unidad" value="${g.correlativo_unidad}"/>
                                                        </c:url>">
                                                        <strong> Orden de Compra</strong>                                                    </a>                                                </div>                                            </td>
                                            <td>
                                                <div align="center">
                                                    <a  href="<c:url value="/SolComUc9.do">
                                                            <c:param name="codtar" value="${g.codtar}"/>
                                                            <c:param name="codacti" value="${actividad.codacti}"/>
                                                            <c:param name="fecha" value="${g.fecha}"/>
                                                            <c:param name="num_sol" value="${g.num_sol}"/>
                                                            <c:param name="correlativo_unidad" value="${g.correlativo_unidad}"/>
                                                            <c:param name="correlativo_ing_material" value="${g.correlativo_ing_material}"/>
                                                        </c:url>"><STRONG> <c:out value="${g.correlativo_ing_material}"/> </STRONG>                                                    </a>                                                </div>                                            </td>
                                            <td>
                                                <div align="center">
                                                    <a  href="<c:url value="/SolComUc11.do">
                                                            <c:param name="codtar" value="${g.codtar}"/>
                                                            <c:param name="codacti" value="${actividad.codacti}"/>
                                                            <c:param name="fecha" value="${g.fecha}"/>
                                                            <c:param name="num_sol" value="${g.num_sol}"/>
                                                            <c:param name="correlativo_unidad" value="${g.correlativo_unidad}"/>
                                                            <c:param name="correlativo_orden_compra" value="${g.correlativo_orden_compra}"/>
                                                        </c:url>">
                                                        <strong> Ingreso de material</strong>                                                    </a>                                                </div>                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                                <br>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>