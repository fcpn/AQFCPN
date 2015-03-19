<%@ include file="../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>

    </head>

    <body>

        <div id="container">
            <div id="content">
                <c:if test="${sw==0}">
                    <table border="1" align="center">
                        <tr>
                            <th>
                                <div align="center">           Sistema de Presupuestos<br>
                                    AQUILES<br>
                                    Pedido de materiales
                                </div>

                            </th>
                        </tr>

                        <tr>
                            <td><div align="center">
                                    <a  href="<c:url value="/SolCom2.do">
                                            <c:param name="codtar" value="${tarea.codtar}"/>
                                            <c:param name="descripcion" value="${tarea.descripcion}"/>
                                        </c:url>"> <strong> <font color="red">Men&uacute; Formularios</font></strong>
                                    </a>
                                </div>
                            </td>

                        </tr>

                        <tr>
                            <td>
                                <div align="center">
                                    <iframe src="pdf/<c:out value="${direc}"/>" frameborder="0" style="width:900px;height:900px"></iframe>
                                </div>
                            </td>
                        </tr>

                    </table>

                </c:if>


                <c:if test="${sw==1}"> Hay datos que no se definieron de unidad de medida o destino, no podra imprimir el documento</c:if>
                <p>&nbsp;</p>

            </div>
        </div>
    </body>
</html>
