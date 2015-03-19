	<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>

<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>Tarea1</title>

    </head>

    <body>
<div id="container">
<div id="content">
        <form name="form1" method="post" action="<c:url value="/Tarea2.do"/>">


                                <table width="574" >
                                    <tr>
                                        <th colspan="4"><div align="center">Nueva Tarea</div></th>
                                    </tr>

                                    <tr>
                                        <th width="253">Programa para nueva Tarea </th>
                                        <td colspan="3"><select name="codpro">

                                                <c:forEach var="pat" items="${proacttar}">
                                                    <option value="<c:out value="${pat.codpro}"/>"><c:out value="${pat.codpro}"/> - <c:out value="${pat.descripcion}"/></option>
                                                </c:forEach>


                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
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