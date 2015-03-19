<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    </head>
    <body>
        <div id="container">
            <div id="content">
                <table>
                    <tr>
                        <th colspan="4"><div align="center">Certificaciones Presupuestarias en Proceso</div></th>
                    </tr>
                    <%int i = 0;%>
                    <c:forEach var="i" begin="0" end="${Fcl-1}">
                        <c:if test="${M[i][2]==2}">
                            <tr>
                                <th colspan="4"><div align="left">Actividad</div></th>
                            </tr>
                            <tr>
                                <td colspan="4"><div align="center"><c:out value="${M[i][0]}"/> - <c:out value="${M[i][1]}"/></div></td>
                            </tr>
                        </c:if>
                        <c:if test="${M[i][2]==5}">
                        </c:if>
                        <c:if test="${M[i][2]==3}">
                            <%i++;%>
                            <tr onMouseOver="this.style.backgroundColor='#F5E1D8';" onMouseOut="this.style.backgroundColor='#ffffff';" >
                                <td width="22"><div align="center"><%= i%></div></td>
                                <td width="29">Tarea</td>
                                <td width="86">
                                    <div align="center">
                                        <a  href="javascript:popUp('<c:url value="/nrocertcarreras.do">
                                                <c:param name="codtar" value="${M[i][0]}"/>
                                                <c:param name="descripcion" value="${M[i][1]}"/>
                                            </c:url>')">
                                        <c:out value="${M[i][0]}"/> </a>

                                    </div>
                                </td>
                                <td width="398">
                                    <a  href="javascript:popUp('<c:url value="/nrocertcarreras.do">
                                            <c:param name="codtar" value="${M[i][0]}"/>
                                            <c:param name="descripcion" value="${M[i][1]}"/>
                                        </c:url>')"><c:out value="${M[i][1]}"/> </a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
