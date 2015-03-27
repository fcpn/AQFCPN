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
            <form name="form1" method="post" action=" <c:url value="Montos3e.do"/>"">
                <table>
                    <tr> 
                        <th colspan="2"><h1 align="center">Montos Presupuestados Egresos</h1></th>
                    </tr>
                    <tr>                    
                        <th colspan="2"><div align="center">Ud. eligi&oacute; el programa [<c:out value="${programa.descripcion}"/>]</div></th>
                    </tr>
                    <tr>
                        <td>Elija <strong><u>Actividad</u></strong> para insertar monto--&gt;</td>
                        <td><select name="codacti">
                                <c:forEach var="pat" items="${proacttar}">
                                    <option value="<c:out value="${pat.codacti}"/>"><c:out value="${pat.codacti}"/> - <c:out value="${pat.descripcion}"/></option>
                                </c:forEach> 
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><div align="right"><input type="submit" name="Submit" value="Aceptar"></div></td>
                        <td><div align="right"><input type="reset" name="Submit2" value="cancelar"></div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>