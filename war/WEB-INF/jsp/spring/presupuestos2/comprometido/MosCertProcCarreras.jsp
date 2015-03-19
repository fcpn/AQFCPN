<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <TITLE></TITLE>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script>
            function validar(e) {
                tecla = (document.all)?e.keyCode:e.which;
                if (tecla==8) return true;
                patron = /\d/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
        </script>
    </head>
    <body>
        <div id="container">
            <div id="content">
                <table width="349">
                    <tr>
                        <th>
                            <div align="center">
                                <strong>Lista de certificaciones Presupuestarias de la tarea<br>
                                    <c:out value="${tarea.descripcion}"/><br>
                                    con c&oacute;digo <br><c:out value="${tarea.codtar}"/><br>
                                    en Proceso<br>
                                    Mostradas en orden de<br>
                                    correlativo</strong>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <div align="center">Correltivo # <c:out value="${num_sol}"/></div><br>
                            <div align="center">realizado en fecha <c:out value="${fecha}"/></div>
                            <div align="center">
                                <table>
                                    <tr>
                                        <th width="42">Nro</th>
                                        <th width="110">Requerimiento especificado</th>
                                        <th width="41">Cantidad</th>
                                        <th width="41">Monto</th>
                                        <th width="52">Tarea</th>
                                        <th width="59">Partida</th>
                                        <th width="59">FF-OF</th>
                                        <th width="85" colspan="2">Responsable de tarea</th>
                                    </tr>
                                    <% int i;
            i = 1;%>
                                    <c:forEach var="g" items="${lista_cert}">
                                        <tr>
                                            <td><div align="center"> <%= i%> </div></td>
                                            <td valign="top"><div align="justify"><c:out value="${g.glosa}"/> <c:out value="${g.glo_rut}"/></div></td>
                                            <td valign="top"><div align="center" ><c:out value="${g.cantidad}"/></div></td>
                                            <td valign="top"><div align="right"><c:out value="${g.monto}"/> </div></td>
                                            <td valign="top"><div align="center"><c:out value="${g.codtar}"/> </div></td>
                                            <td valign="top"><div align="center"><c:out value="${g.codmonegr}"/></div></td>
                                            <td valign="top"><div align="center"><c:out value="${g.codfueneco}"/></div></td>
                                            <td valign="top" colspan="2" align="center"><c:out value="${g.responsable}"/></td>
                                        </tr>
                                        <% i++;%>
                                    </c:forEach>
                                </table>
                            </div>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td>
                            <div align="center">
                                <a  href="<c:url value="/MosCertProc2.do">
                                        <c:param name="codtar" value="${tarea.codtar}"/>
                                        <c:param name="num_sol" value="${num_sol}"/>
                                        <c:param name="fecha" value="${fecha}"/>
                                    </c:url>">Certificación Presupuestaria en PDF </a>
                            </div>
                        </td>
                        <td>
                            <div align="center">
                                <a  href="<c:url value="/MosCertExel.do">
                                        <c:param name="codtar" value="${tarea.codtar}"/>
                                        <c:param name="num_sol" value="${num_sol}"/>
                                        <c:param name="fecha" value="${fecha}"/>
                                    </c:url>">Certificación Presupestaria en EXCEL</a>
                            </div>
                        </td>
                    </tr>
                </table>
                <div align="right">
                    <a  href="<c:url value="/nrocertcarreras.do">
                            <c:param name="codtar" value="${tarea.codtar}"/>
                        </c:url>"> Ir atras </a>
                </div>
            </div>
        </div>
    </body>
</html>