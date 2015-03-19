<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>Tarea2</title>

    </head>

    <body>
        <div id="container">
<div id="content">
    <form name="form1" method="post" action=" <c:url value="Tarea3.do"/>">

                                <table width="574" border="0" align="center">
                                    <tr>
                                        <th colspan="4"><div align="center">Nueva Tarea</div></th>
                                    </tr>
                                    <tr>
                                        <th colspan="4"><div align="center">programa [<c:out value="${programa.descripcion}"/>]</div></th>
                                    </tr>
                                    <tr>
                                        <th colspan="4">Actividad para nueva Tarea</th>
                                    </tr>
<tr>
                                        <td colspan="4"><div align="left">
                                          <select name="codacti">
                                            <c:forEach var="pat" items="${proacttar}">
                                              <option value="<c:out value="${pat.codacti}"/>">
                                              <c:out value="${pat.codacti}"/>
                                               -
                                              <c:out value="${pat.descripcion}"/>
                                              </option>
                                            </c:forEach>
                                          </select>
                                        </div></td>
                                    </tr>


                                    <tr>
                                        <td width="253">&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td><input type="submit" name="Submit" value="Aceptar"></td>
                                        <td>
                                            <div align="right">
                                                <input type="reset" name="Submit2" value="cancelar">
                                        </div></td>
                                    </tr>
                            </table>

    </form>
</div></div>
    </body>
</html>