<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Ejecutar montos Comprometidos</title>
    <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
</head>
<body>          
    <div id="content">
        <form name="form1" method="post" action="<c:url value="/ModMonCompro2.do"/>">
            <table>
                <tr>
                    <th colspan="2" ><div align="center"><h2>Modificar Montos Comprometidos - Egresos</h2> </div></th>
                </tr>
                <tr>
                    <th><div align="center">Actividad</div></th>
                    <th><div align="center">Tarea</div></th>
                </tr>
                <tr>
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
                    <th>Partida</th>
                    <th>Fuente Econ&oacute;mica</th>
                    <th>&nbsp;Monto Comprometido</th>
                    <th>Glosa</th>
                    <th></th>
                </tr>
            <c:forEach var="mo" items="${refcompro}">  
   
                <tr>
                    <td><c:out value="${mo.codmonegr}"/></td>
                    <td><c:out value="${mo.codfueneco}"/></td>
                    <td><div align="right">&nbsp;<c:out value="${mo.monto}"/></div></td>
                    <td><c:out value="${mo.glosa}"/></td>
		
                <c:if test="${mo.i_e == 3}">
                    <td> <a  href="<c:url value="/MosCertProc.do">
                                    <c:param name="codtar" value="${mo.codtar}"/>
                                    <c:param name="fecha" value="${mo.fecha}"/>
                                    <c:param name="num_sol" value="${mo.num_sol}"/>
                                    </c:url>"> Cert.# <c:out value="${mo.num_sol}"/></a></td>

                </c:if>
                <c:if test="${mo.i_e != 3}">
                    <td><input type="checkbox" name="comproref" value="<c:out value="${mo.codmonegr}"/>::<c:out value="${mo.codfueneco}"/>::<c:out value="${mo.monto}"/>::<c:out value="${mo.id}"/>::<c:out value="${mo.glosa}"/>::<c:out value="${mo.fecha}"/>::<c:out value="${mo.obs}"/>::<c:out value="${mo.i_e}"/>::<c:out value="${mo.ref123}"/>"></td>
                </c:if>
                </tr>
              
            </c:forEach>    
            <c:if test="${gg != '-1'}">
                <tr bgcolor="#BAAD74">
                    <td colspan="8"><div align="right"><input type="submit" name="Submit" value="Aceptar"></div></td>
                </tr>
            </c:if>
            </table>
                <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
        </form>
    </div>
</body>
</html>
