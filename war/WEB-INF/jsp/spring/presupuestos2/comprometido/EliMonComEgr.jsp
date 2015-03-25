<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Eliminar montos Comprometidos</title>
    <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    <style type="text/css">
            .tab{
                width: 80%;
            }
        </style>
</head>
<body>          
    <div id="content" align="center">
        <form name="form1" method="post" action="<c:url value="/EliMonComEgr2.do"/>">
            <table class="tab">
                <tr>
                    <th colspan="2" ><div align="center"><h2>Eliminar Montos Comprometidos Egresos </h2></div></th>
                </tr>
                <tr>
                    <th><div align="center">Actividad</div></th>
                    <th><div align="center">Tarea</div></th>
                </tr>
                <tr >
                    <td><strong> <c:out value="${actividad.descripcion}"/> </strong></td>
                        <input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>
                        <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                    <td><strong> <c:out value="${tarea.descripcion}"/> </strong> </td>
                        <input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>
                        <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                </tr>
            </table>
<!-- mostrando datos generales -->
        <br><br>
            <table>
                <tr>
                    <th>&nbsp;Partida</th>
                    <th> Fuente Econ&oacute;mica</th>
                    <th>&nbsp;Monto Comprometido<!---Ultimo # de comprobante--></th>
                    <th> </th>
                </tr>
            <c:forEach var="mo" items="${refcompro}">  
                <tr>
                    <td><c:out value="${mo.codmonegr}"/></td>
                    <td><c:out value="${mo.codfueneco}"/></td>
                    <td><div align="right">&nbsp;<c:out value="${mo.monto}"/></div></td>
                    <td> <input type="checkbox" name="comproref" value="<c:out value="${mo.codmonegr}"/>::<c:out value="${mo.codfueneco}"/>::<c:out value="${mo.monto}"/>"></td>
                </tr>
              
            </c:forEach>    
            <c:if test="${gg != '-1'}">
            <tr>
                <td colspan="7"><div align="right"><input type="submit" name="Submit" value="Aceptar"></div></td>
            </tr>
            </c:if>
            </table>
                <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
        </form>
    </div>
</body>
</html>
