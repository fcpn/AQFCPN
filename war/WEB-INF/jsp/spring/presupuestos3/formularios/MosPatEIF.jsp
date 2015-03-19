<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title> </title>
    </head>
    <body>
        <div id="container">
            <div id="content">
                <table width="563" align="center">
                    <tr>
                        <th colspan="5">
                            <div align="center">
                                <p>
                                    MEN&Uacute; DE TAREAS
                                </p>
                                <p>
                                    ELABORACI&Oacute;N DE FORMULARIOS<br>
                                </p>
                            </div>
                        </th>
                    </tr>
                    <%int i = 0;%>
                    <c:forEach var="i" begin="0" end="${Fcl-1}">
                        <c:if test="${M[i][0]==2}">
                            <tr>
                                <td colspan="4">&nbsp;</td>
                            </tr>
                            <tr>
                                <th colspan="4"><div align="center">Actividad: <c:out value="${M[i][2]}"/> - <c:out value="${M[i][3]}"/></div></th>
                            </tr>                            
                        </c:if>
                        <c:if test="${M[i][0]==3}">
                            <%i++;%>
                            <tr>
                                <td width="22"><div align="center"><%= i%></div></td>
                                <td width="29">Tarea</td>
                                <td width="86"><div align="center">
                                        <a  href="<c:url value="/SolFor.do">
                                                <c:param name="codtar" value="${M[i][2]}"/>
                                                <c:param name="descripcion" value="${M[i][3]}"/>
                                            </c:url>"><c:out value="${M[i][2]}"/></a>
                                    </div>
                                </td>
                                <td width="398">
                                    <a  href="<c:url value="/SolFor.do">
                                            <c:param name="codtar" value="${M[i][2]}"/>
                                            <c:param name="descripcion" value="${M[i][3]}"/>
                                        </c:url>"><c:out value="${M[i][3]}"/> </a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
