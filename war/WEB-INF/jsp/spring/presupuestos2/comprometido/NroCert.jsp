<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <style type="text/css">
            .tablilla {border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px double #000000;}
            .Estilo1 {color: #FFFFFF}
        </style>
        <script>
            function validar(e) {
                tecla = (document.all) ? e.keyCode : e.which;
                if (tecla == 8)
                    return true;
                patron = /\d/;
                te = String.fromCharCode(tecla);
                return patron.test(te);
            }
        </script>
    </head>
    <body oncontextmenu="return false">
        <table width="349" height="244" border="1" align="center">
            <tr bgcolor="#E88B24">
                <td bgcolor="#2F4D84">
                    <span class="Estilo1">
                        <div align="center">
                            <strong>
                                Lista de certificaciones Presupuestarias de la tarea
                                <br>
                                <c:out value="${tarea.descripcion}"/>
                                <br>
                                con c&oacute;digo 
                                <br>
                                <c:out value="${tarea.codtar}"/>
                                <br>
                                en Proceso<br>
                                Mostradas en orden de
                                <br>
                                correlativo
                            </strong>
                        </div>
                    </span>
                </td>
            </tr>
            <tr>
                <td>
                    <br> 
                    <div align="center">
                        <table width="328" border="0" class="tablilla">
                            <tr bgcolor="#F3BF5F">
                                <td width="121"><strong>Fecha de petici&oacute;n </strong></td>
                                <td width="132"><strong>Nro. de correlativo </strong></td>
                                <td width="132"><strong>Ejecuci&oacute;n parcial</strong></td>
                            </tr>
                            <c:forEach var="g" items="${correlativo}">
                                <tr onMouseOver="this.style.backgroundColor = '#D6D6D6';" onMouseOut="this.style.backgroundColor = '#ffffff';">
                                    <td>
                                        <a  href="<c:url value="/MosCertProc.do">
                                                <c:param name="codtar" value="${tarea.codtar}"/>
                                                <c:param name="codacti" value="${actividad.codacti}"/>
                                                <c:param name="fecha" value="${g.fecha}"/>
                                                <c:param name="num_sol" value="${g.num_sol}"/>
                                            </c:url>">
                                            <div align="center">
                                                <strong> <c:out value="${g.fecha}"/> </strong>
                                            </div>
                                        </a>
                                    </td>
                                    <td>
                                        <a  href="<c:url value="/MosCertProc.do">
                                                <c:param name="codtar" value="${tarea.codtar}"/>
                                                <c:param name="codacti" value="${actividad.codacti}"/>
                                                <c:param name="fecha" value="${g.fecha}"/>
                                                <c:param name="num_sol" value="${g.num_sol}"/>
                                            </c:url>"> 
                                            <div align="center">
                                                <strong> <c:out value="${g.num_sol}"/></strong> 
                                            </div>
                                        </a>
                                    </td>
                                    <td>
                                        <a  href="<c:url value="/EjecucionParcia1.do">
                                                <c:param name="codtar" value="${tarea.codtar}"/>
                                                <c:param name="codacti" value="${actividad.codacti}"/>
                                                <c:param name="fecha" value="${g.fecha}"/>
                                                <c:param name="num_sol" value="${g.num_sol}"/>
                                            </c:url>"> 
                                            <div align="center">
                                                <strong> Eje. Parcial</strong> 
                                            </div>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <br>
                    </div>
                </td>
            </tr>
            <tr bgcolor="#E88B24">
                <td bgcolor="#243C66">&nbsp;</td>
            </tr>
        </table>
    </body>
</html>