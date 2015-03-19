<%@ include file="../Cabecera.jsp" %>
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
                <form name="form1" method="post" action="<c:url value="/FormBus.do"/>">
                    <table width="446" border="0" align="center">
                        <tr>
                            <td colspan="3">
                                <table width="437" border="0">
                                    <tr>
                                        <td>&nbsp;</td>
                                        <th><div align="center">Búsqueda</div></th>
                                        <td>&nbsp;</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <div align="center">
                                    <input type="text" name="num" id="num">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td width="184">
                                <label>Formulario Sol Compra
                                    <input type="radio" name="opbus" value="fc">
                                </label>
                            </td>
                            <td width="157">Orden de Compra
                                <label>
                                    <input type="radio" name="opbus" value="oc" checked>
                                </label>
                            </td>
                            <td width="83">
                                <div align="right">
                                    <input type="submit" name="Buscar" id="Buscar" value="Buscar">
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
                <div id="mostrar">
                    <table width="563" align="center">
                        <tr>
                            <th colspan="4" align="center"><br> <div align="center"><h3>FORMULARIOS</h3></div></th>
                        </tr>
                        <%int i = 0;%>
                        <c:forEach var="g" items="${pat}">
                            <c:if test="${g.tipo == '2'}">
                                <tr>
                                    <td colspan="4"><div align="center"><span class="Estilo1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></div> </td>
                                </tr>
                                <tr>
                                    <th colspan="4"><div align="center"><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></div> </th>
                                </tr>
                            </c:if>

                            <c:if test="${g.tipo == '3'}">
                                <%i++;%>
                                <tr>
                                    <td width="22"><div align="center"><%= i%></div></td>
                                    <td width="29">Tarea</td>
                                    <td width="86"><div align="center">
                                            <a  href="<c:url value="/SolComUc2.do">
                                                    <c:param name="codtar" value="${g.codigo}"/>
                                                    <c:param name="descripcion" value="${g.descripcion}"/>

                                                </c:url>"> <c:out value="${g.codigo}"/>
                                            </a>
                                        </div>
                                    </td>
                                    <td width="398">
                                        <a  href="<c:url value="/SolComUc2.do">
                                                <c:param name="codtar" value="${g.codigo}"/>
                                                <c:param name="descripcion" value="${g.descripcion}"/>
                                            </c:url>"><c:out value="${g.descripcion}"/>
                                        </a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>