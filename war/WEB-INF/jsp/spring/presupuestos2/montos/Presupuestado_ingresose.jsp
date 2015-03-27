<%@ include file="../../Cabecera.jsp" %>


<html>
    <head>
        <title>montos presupuestados</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <style type="text/css">
            table{
                width: 75%;

            }
        </style>
    </head>
    
    <body> 
        <div id="content" align="center">
            <form name="form1" method="post" action="<c:url value="InsertarPresupuestadoe.do"/>">
                <table>
                    <tr>
                        <th colspan="2"><h2 align="center">Insertar Montos a Egresos</h2></th>
                    </tr>
                    <tr>
                        <th><div align="center">Actividad  </div></th>
                        <th><div align="center">Tarea</div></td>
                    </tr>
		    <tr> 
			<td><c:out value="${actividad.descripcion}"/></td>
			<td><c:out value="${tarea.descripcion}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"></td>
                    </tr>
                    <tr>
                        <th colspan="2">Partida</th>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="codigo">
                                <c:forEach var="g" items="${partida}">                                                            
                                    <!-- <c:if test="${g.tipo == '1'}">
                                        <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>" ><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                                            <input type=hidden name=tipo value='<c:out value="${g.tipo}"/>'>
                                        </c:if>-->
                                    <!--   <c:if test="${g.tipo == '2'}">
                                        <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>">&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                                            <input type=hidden name=tipo value='<c:out value="${g.tipo}"/>'>
                                        </c:if>-->
                                    <c:if test="${g.tipo == '3'}">
                                        <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>"><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                                        <!--   <input type=hidden name=tipo value='<c:out value="${g.tipo}"/>'>-->
                                    </c:if>                                                           
                                </c:forEach>             
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Fuente</th>
                        <th>Monto</th>
                    </tr>
                    <tr>
                        <td>
                            <select name="codfueneco">
                                <c:forEach var="fe" items="${fuente}">
                                    <option value="<c:out value="${fe.codfueneco}"/>"><c:out value="${fe.codfueneco}"/> - <c:out value="${fe.descripcion}"/></option>
                                </c:forEach>                                                         
                                <!-- llavando los parametros   -->
                                <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                                <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                            </select>
                        </td>
                        <td><input name="monpreegre" type="text" id="monpreegre" size="8"></td>
                    </tr>
                    <tr>
                        <th>Saldos a la fecha</th>
                        <th>Monto Ejecutado</th>
                    </tr>
                    <tr>
                        <td rowspan="2">
                            <div align="center">
                            <table align="center">
                                <tr>
                                    <td><input name="dia" type="text" id="dia" size="2" maxlength="2"></td>
                                    <td><input name="mes" type="text" id="mes" size="2" maxlength="2"></td>
                                    <td><input name="ani" type="text" id="ani" size="2" maxlength="2"></td>
                                </tr>
                                <tr>
                                    <th>D&iacute;a</th>
                                    <th>Mes</th>
                                    <th>A&ntilde;o</th>
                                </tr>
                            </table>
                            </div>
                        </td>
                        <td>
                            <input name="monejeing" type="text" id="monejeing" value="0" size="8">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name="sal" type="radio" value="a" checked>
                            <strong>Saldo incial</strong>
                            <input name="sal" type="radio" value="b">
                            <strong>Cuenta Nueva </strong>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><!-- <a href="#">Ver montos presupuestados Ingresos</a> --></td>
                    </tr>
                    <tr>
			<th>Comprobante</th>
                        <th>Glosa</th>
                    </tr>
                    <tr>
			<td><input name="cbte" type="text" id="cbte" value="NA" size="20"></td>
                        <td><input name="glosa_s" type="text" id="glosa_s" value="Saldos de Caja y Bancos al la fecha" size="50"></td>
                    </tr>
                    <tr>
                        <td><div align="right"><input type="submit" name="Submit2" value="Aceptar"></td>
                        <td><div align="right"><input type="reset" name="Submit3" value="cancelar"></div></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
