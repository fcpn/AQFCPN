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
                        <th colspan="2"><div align="center">Informe Incrementos</div></th>
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
                        <th width="282">Clasificador</th>
                        <th width="220">Fuente Econ&oacute;mica</th>
                        <th width="125">Monto Presupuestado</th>
                        <th width="114">Monto Ejecutado</th>
                        <th width="96">Saldo</th>
                    </tr>
                    <tr>
                        <td><c:out value="${codmon}"/> - <c:out value="${descla}"/> </td>
                        <td><c:out value="${codfueneco}"/> - <c:out value="${fuente.descripcion}"/></td>
                        <td><div align="right"><c:out value="${monto}"/></div></td>
                        <td><div align="right"><c:out value="${moneje}"/></div></td>
                        <td><div align="right"><c:out value="${saldo}"/> </div></td>
                    </tr>
                    <tr>
                        <th colspan="5">Historial del monto de Incrementos</th>
                    </tr>
                    <tr>
                        <th colspan="2"><div align="center">Glosa</div></th>
                        <th>Comprobante</th>
                        <th>Fecha deTraspaso</th>
                        <th><div align="center">Monto Acumulado&nbsp;</div></th>
                    </tr>
                    <c:forEach var="moo" items="${his_inc}">
                        <tr>
                            <td colspan="2"><div align="justify"><c:out value="${moo.glosa}"/></div></td>
                            <td><div align="right"><c:out value="${moo.cbte}"/></div></td>
                            <td><div align="right"><c:out value="${moo.fecha}"/></div></td>
                            <td> <div align="right"><c:out value="${moo.monto}"/></div></td>
                        </tr>
                    </c:forEach>
                </table>
                <div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
            </div>
        </div>
    </body>
</html>