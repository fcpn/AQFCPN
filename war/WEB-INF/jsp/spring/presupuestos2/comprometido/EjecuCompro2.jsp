<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Comprometido 1</title>
        <link href="tablarep/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablarep/tablecloth.js"></script>
    </head>
    <body>
        <div id="container">
            <div id="content">
                <form name="form1" method="post" action="<c:url value="/EjecuCompro3.do"/>">
                    <table width="523" border="1" align="center">
                        <tr>
                            <th colspan="2"><div align="center">Ejecutar Montos Comprometidos </div></th>
                        </tr>
                        <tr>
                            <th width="238" ><div align="center">Actividad</div></th>
                            <th width="269" ><div align="center">Tarea</div></th>
                        </tr>
                        <tr>
                            <td width="238" ><c:out value="${actividad.descripcion}"/> </td>
                            <td width="269" ><c:out value="${tarea.descripcion}"/> </td>
                        </tr>
                    </table>
                    <br>
                    <table width="750"align="center">
                        <c:if test="${j != '-1'}">
                            <c:forEach var="i" begin="0" end="${j}" step="9">
                                <tr>
                                    <th width="196">Partida</th>
                                    <th width="270" >Fuente Econ&oacute;mica</th>
                                    <th width="383">Monto Comprometido a Acumular</th>
                                <tr>
                                    <td><c:out value="${M[i]}"/></td>
                                    <td> <c:out value="${M[i+1]}"/></td>
                                    <td><input name="monto" type="text" id="monto" value="<c:out value="${M[i+2]}"/>"></td>
                                </tr>
                                <tr>
                                    <th width="196">Fecha</th>
                                    <th width="270" >Glosa</th>
                                    <th><div align="left">numero de Comprobante</div></th>
                                <tr>
                                    <td>
                                        <table width="200" border="0">
                                            <tr>
                                                <td><div align="center">
                                                        <input name="dia" type="text" id="dia6" size="3" maxlength="2">
                                                    </div></td>
                                                <td><div align="center">
                                                        <input name="mes" type="text" id="mes5" size="3" maxlength="2">
                                                    </div></td>
                                                <td><div align="center">
                                                        <input name="anio" type="text" id="anio5" size="3" maxlength="2">
                                                    </div></td>
                                            </tr>
                                            <tr>
                                                <th><div align="center">Dia</div></th>
                                                <th><div align="center">Mes</div></th>
                                                <th><div align="center">A&ntilde;o</div></th>
                                            </tr>
                                        </table>
                                    </td>
                                    <td>
                                        <div align="center">
                                            <textarea name="glosa" cols="30" rows="3" id="Glosa" ><c:out value="${M[i+4]}"/></textarea>
                                        </div>
                                    </td>
                                    <td>
                                        <div align="center">
                                            <input name="cbte" type="text" id="cbte">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" rowspan="2"></td>
                                    <td>Observaciones (Este campo no se almacenara en el registro)</td>
                                </tr>
                                <tr>
                                    <td> <c:out value="${M[i+6]}"/> </td>
                                </tr>
                                <tr>
                                    <td height="19" colspan="6"><input type=hidden name=complemento value='<c:out value="${M[i]}"/>::<c:out value="${M[i+1]}"/>::<c:out value="${M[i+2]}"/>::<c:out value="${M[i+3]}"/>::<c:out value="${M[i+8]}"/>'> </td>
                                </tr>
                                <tr>
                                    <td height="19" colspan="6"><div align="left"><font color="red"> ------->>> </font></div> <div align="right"><font color="red"> <<------- </font></div></td>
                                </tr>
                            </c:forEach>
                            <c:if test="${j != '-1'}">
                                <tr>
                                    <td height="19" colspan="6">
                                        <div align="right">
                                            <input type="submit" name="Submit" value="Ejecutar">
                                            <input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
                                            <input type=hidden name=codtar value='<c:out value="${codtar}"/>'>
                                        </div>
                                    </td>
                                </tr>
                            </c:if>
                        </c:if>
                    </table>
                    <c:if test="${j == '-1'}">
                    Usted no eligió Montos Comprometidos para Ejecutar </c:if>
                    <div align="right"><a href="javascript:history.back(0);">Volver Atras</a></div>
                </form>
                <p>&nbsp;</p>
            </div>
        </div>
    </body>
</html>