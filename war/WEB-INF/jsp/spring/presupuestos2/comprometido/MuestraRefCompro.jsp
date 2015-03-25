<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Mostrando Referencia de los montos presupuestados</title>
    <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>

<body>          
    <div id="content">
        <form name="form1" method="post" action="<c:url value="/InsAcuCom.do"/>">
            <table>
                <tr>
                    <th colspan="2" width="500"><div align="center"><h2>Montos Comprometidos Egresos</h2></div></th>
                </tr>
                <tr>
                    <th width="250"><div align="center">Actividad</div></td>
                    <th width="250"><div align="center">Tarea</div></td>
                </tr>
                <tr >
                    <td width="250"><strong> <c:out value="${actividad.descripcion}"/> </strong></td>
                        <input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>
                        <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                    <td width="250"><strong> <c:out value="${tarea.descripcion}"/> </strong> </td>
                        <input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>
                        <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                </tr>
            </table>
<!-- mostrando datos generales -->
            <table>
                <tr>
                    <th>&nbsp;Partida</th>
                    <th>Fuente Econ&oacute;mica</th>
                    <th>&nbsp;Monto Comprometido<!---Ultimo # de comprobante--></th>
                    <th> </th>
                </tr>
            <c:forEach var="mo" items="${refcompro}">  
                <tr>
                    <td><c:out value="${mo.codmonegr}"/></td>
                    <td><c:out value="${mo.codfueneco}"/></td>
                    <td><div align="right">&nbsp;<c:out value="${mo.monto}"/></div></td>
                    <td> <input type="checkbox" name="comproref" value="<c:out value="${mo.codmonegr}"/>::<c:out value="${mo.codfueneco}"/>::<c:out value="${mo.ref123}"/>"></td>
		</tr>
            </c:forEach>    
            <c:if test="${gg != '-1'}">
                <tr>
                    <td height="19" colspan="7"><div align="right"><input type="submit" name="Submit" value="Aceptar"></div></td>
                </tr>
            </c:if>
            </table>
            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
        </form>
    </div>
</body>
</html>
