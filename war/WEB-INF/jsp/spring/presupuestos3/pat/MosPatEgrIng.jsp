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
                <table width="563" align="center">
                    <tr>
                        <th colspan="4" align="center"><br>MEN&Uacute; DE TAREAS <br></th>
                    </tr>
                    <%int i = 0;%>
                    <c:forEach var="g" items="${pat}">
                        <c:if test="${g.tipo == '2'}">
                            <tr>
                                <td colspan="4"><div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div> </td>
                            </tr>
                            <tr>
                                <th colspan="4"><div align="center"><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></div> </th>
                            </tr>
                        </c:if>

                        <c:if test="${g.tipo == '3'}">
                            <%i++;%>
                            <tr onMouseOver="this.style.backgroundColor='#66FFCC';" onMouseOut="this.style.backgroundColor='#ffffff';" >
                                <td width="22"><div align="center"><%= i%></div></td>
                                <td width="29">Tarea</td>
                                <td width="86"><div align="center"><a  href="javascript:popUp('<c:url value="/MostrarTarIngEgr.do">
                                                                           <c:param name="codtar" value="${g.codigo}"/>
                                                                           <c:param name="descripcion" value="${g.descripcion}"/>

                                                                       </c:url>')">
                                        <c:out value="${g.codigo}"/> </a></div></td>
                                <td width="398"><a  href="javascript:popUp('<c:url value="/MostrarTarIngEgr.do">
                                                        <c:param name="codtar" value="${g.codigo}"/>
                                                        <c:param name="descripcion" value="${g.descripcion}"/>

                                                    </c:url>')">
                                    <c:out value="${g.descripcion}"/> </a></td>
                            </tr>


                        </c:if>

                    </c:forEach>
                </table>
            </div></div>
    </body>
</html>
