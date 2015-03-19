<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Comprometido 1</title>
        <style type="text/css">
            <!--
            .Estilo4 {
                color: #FFFFFF;
                font-weight: bold;
                font-size: 24px;
            }
            .Estilo13 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold; }
            .Estilo14 {
                font-family: Verdana, Arial, Helvetica, sans-serif;
                font-weight: bold;
            }
            .Estilo15 {font-size: 10px}
            -->
        </style>
    </head>
    <body>
        <p>&nbsp;</p>
        <table width="523" border="1" align="center" bordercolor="#CC9933">
            <tr bgcolor="#544D29" >
                <td colspan="2" ><div align="center" class="Estilo4">Men&uacute;  Montos Comprometidos</div></td>
            </tr>
            <tr bgcolor="#CBC196" >
                <td width="238" ><div align="center"><strong>Actividad </strong></div></td>
                <td width="269" ><div align="center"><strong>Tarea </strong></div></td>
            </tr>
            <tr >
                <td width="238" ><c:out value="${actividad.descripcion}"/> </td>
                <td width="269" ><c:out value="${tarea.descripcion}"/> </td>
            </tr>
        </table>
        <br>
        <br>
        <br>
        <table width="871" border="1" align="center" bordercolor="#CC9933">
            <tr bgcolor="#CBC196">
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td width="430">

                    <div align="center">
                        <a  href="<c:url value="/InformeEgrCom.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Nuevo monto Comprometido </a>
                    </div></td>
                <td width="425">
                    <div align="center">
                        <a  href="<c:url value="/ActuCom.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Acumular monto comprometido </a>
                    </div>
                </td>
            </tr>
            <tr bordercolor="#666666" bgcolor="#CBC196">
                <td height="19" colspan="3">&nbsp; </td>
            </tr>
            <br>
            <br>
        </table>
        <br>
        <br>
        <table width="200" border="1" align="center">
            <tr>
                <td bgcolor="#CBC196">&nbsp;</td>
            </tr>
            <tr>
                <td><div align="center">
                        <a  href="<c:url value="/EjecuCompro.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Ejecutar Comprometido </a>
                    </div>
                </td>
            </tr>
            <tr>
                <td bgcolor="#CBC196">&nbsp;</td>
            </tr>
        </table>
        <br>
        <table width="200" border="1" align="center">
            <tr>
                <td bgcolor="#CBC196">&nbsp;</td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        <a  href="<c:url value="/ModMonCompro.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Modificar Montos Comprometidos </a>
                    </div>
                </td>
            </tr>
            <tr>
                <td bgcolor="#CBC196">&nbsp;</td>
            </tr>
        </table>
        <br>
        <table width="323" border="1" align="center">
            <tr bgcolor="#E88B24">
                <td colspan="2"><div align="center"><strong>Certificaci&oacute;n Presupuestaria </strong></div></td>
            </tr>
            <tr>
                <td width="154">
                    <div align="center">
                        <a  href="<c:url value="/nrocert.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Nro. Certificación </a>
                    </div>
                </td>
                <td width="153">
                    <div align="center">
                        <a  href="<c:url value="/fechacert.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Fecha </a>
                    </div>
                </td>
            </tr>
            <tr bgcolor="#E88B24">
                <td colspan="2">&nbsp;</td>
            </tr>
        </table>
        <br>
        <table width="486" border="1" align="center" bordercolor="#CC9933">
            <tr bgcolor="#CBC196">
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td width="213" bgcolor="#FF0000">
                    <div align="center"> 
                        <a  href="<c:url value="/EliMonComEgr.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>

                            </c:url>"> Anular monto comprometido con su historial</a> 
                    </div>
                </td>
                <td width="215" bgcolor="#C10000"> 
                    <div align="center"> 
                        <a  href="<c:url value="/EliMonComEgrAcu.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>">Eliminar Comprometido Acumulado
                        </a> 
                    </div>
                </td>
            </tr>
            <tr bordercolor="#666666" bgcolor="#CBC196">
                <td height="19">&nbsp; </td>
                <td height="19">&nbsp;</td>
            </tr>
            <br>
            <br>
        </table>
        <br>
        <p>&nbsp;</p>
    </body>
</html>