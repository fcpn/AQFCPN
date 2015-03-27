<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Tarea2</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <style type="text/css">
            table{
                width: 65%;

            }
        </style>
    </head>
    <body>
        <div id="content" align="center">
            <form name="form1" method="post" action=" <c:url value="Presupuestado_ingresose.do"/>"">
                <table>
                    <tr> 
                        <th colspan="2"><h1 align="center">Montos Presupuestados Egresos</h1></th>
                    </tr>
                    <tr>
                        <th colspan="2"><div align="center">Ud. eligi&oacute; la actividad [<c:out value="${actividad.descripcion}"/>]</div></th>
                    </tr>
                    <tr>
                        <th>Elija <strong><u>Tarea</u></strong> para insertar monto--&gt;</th>
                        <td><select name="codtar">
                                <c:forEach var="pat" items="${proacttar}">
                                    <option value="<c:out value="${pat.codtar}"/>"><c:out value="${pat.codtar}"/> - <c:out value="${pat.descripcion}"/></option>
                                </c:forEach> 
                                    <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                                    <input type=hidden name=descripcion value='<c:out value="${actividad.descripcion}"/>'>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><div align="right"><input type="submit" name="Submit" value="Aceptar"></div></td>
                        <td><div align="right"><input type="reset" name="Submit2" value="cancelar"></div></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>