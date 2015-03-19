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
                <br>
                <div align="center"><b>REPORTE GENERAL</b></div>
                <table width="563" border="1" align="center">
                    <%int i = 0;%>
                    <c:forEach var="i" begin="0" end="${Fcl-1}">
                        <c:if test="${M[i][0]==2}">
                            <tr>
                                <td colspan="5"><div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div> </td>
                            </tr>
<!--                            <tr>
                                <th colspan="5"><div align="left">Actividad</div></th>
                            </tr>-->
                            <tr>
                                <th colspan="5"><div align="center"><c:out value="${M[i][2]}"/> - <c:out value="${M[i][3]}"/></div> </th>
                            </tr>
                        </c:if>
                        <c:if test="${M[i][0]==3}">
                            <%i++;%>
                            <tr onMouseOver="this.style.backgroundColor='#66FFCC';" onMouseOut="this.style.backgroundColor='#ffffff';" >
                                <td width="22"><div align="center"><%= i%></div></td>
                                <td width="29">.</td>
                                <td width="86">
                                    <div align="center">
                                        <a  href="javascript:popUp('<c:url value="/MostrarTarIngEgr.do">
                                                <c:param name="codtar" value="${M[i][2]}"/>
                                                <c:param name="descripcion" value="${M[i][3]}"/>
                                            </c:url>')">
                                        <c:out value="${M[i][2]}"/></a>
                                    </div>
                                </td>
                                <td width="200">
                                    <a  href="javascript:popUp('<c:url value="/MostrarTarIngEgr.do">
                                            <c:param name="codtar" value="${M[i][2]}"/>
                                            <c:param name="descripcion" value="${M[i][3]}"/>
                                        </c:url>')">
                                    <c:out value="${M[i][3]}"/> </a>
                                </td>
                                <td width="298">
                                    <c:forEach var="n" begin="4" end="${cmax}">
                                        <c:if test="${!empty M[i][n]}">
                                           [ <c:out value="${M[i][n]}"/> ]<br>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>