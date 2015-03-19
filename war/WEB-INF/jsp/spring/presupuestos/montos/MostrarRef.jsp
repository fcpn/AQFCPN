<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Mostrando los montos presupuestados</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    </head>
    <body>
        <div id="container">
            <div id="content">
                <table width="523">
                    <tr>
                        <th colspan="2"><div align="center">Informe Ejecutados Ingresos</div></th>
                    </tr>
                    <tr>
                        <th width="238"><div align="center">Actividad</div></th>
                        <th width="269"><div align="center">Tarea</div></th>
                    </tr>
                    <tr>
                        <td><div align="justify"><c:out value="${actividad.descripcion}"/></div></td>
                        <td><div align="justify"><c:out value="${tarea.descripcion}"/></div></td>
                    </tr>
                </table>
                <table width="871">
                    <tr>
                        <th width="122">Clasificador</th>
                        <th width="219">Fuente Econ&oacute;mica</th>
                        <th width="153">Presupuestado</th>
                        <th width="168">Ejecutado</th>
                        <th width="175">Saldo</th>
                    </tr>
                    <tr>
                        <td><c:out value="${codmoning}"/> - <c:out value="${descla}"/> </td>
                        <td><c:out value="${codfueneco}"/> - <c:out value="${desfe}"/></td>
                        <td><div align="right"><c:out value="${montos.montopresu}"/></div></td>
                        <td><div align="right"><c:out value="${montos.montoeje}"/></div></td>
                        <td><div align="right"><c:out value="${montos.saldo}"/> </div></td>
                    </tr>
                    <tr>
                        <th colspan="5">Historial del monto Ejecutado</th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <th width="219">Glosa</th>
                        <th>Comprobante</th>
                        <th>Fecha de Ejecuci&oacute;n</th>
                        <th><div align="center">Monto Acumulado</div></th>
                    </tr>
                    <tr>
                        <td>Saldo Inicial</td>
                        <td><c:out value="${montos.glosa_s}"/></td>
                        <td>NA</td>
                        <td><c:out value="${montos.fecha_saldo}"/></td>
                        <td><c:out value="${montos.saldo_ej_i}"/></td>
                    </tr>
                    <c:forEach var="moo" items="${montos_ref}">
                        <tr>
                            <td>&nbsp;</td>
                            <td><div align="justify"><c:out value="${moo.observaciones}"/> </div></td>
                            <td><div align="right"><c:out value="${moo.comprobante}"/></div></td>
                            <td><div align="right"><c:out value="${moo.fecha}"/></div></td>
                            <td><div align="right"><c:out value="${moo.monacumulado}"/> </div> </td>
                        </tr>
                    </c:forEach>
                </table>
                <div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
            </div>
        </div>
    </body>
</html>