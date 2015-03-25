<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Comprometido 1</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("table:nth-child(1)").width("350");
                $("table:nth-child(1)").css("align","center");
            });
        </script>
    </head>
    <body>
    <div id="content" align="center">
        <table>
            <tr>
                <th colspan="2" ><div align="center">Men&uacute;  Montos Comprometidos</div></th>
            </tr>
            <tr>
                <th><div align="center"><strong>Actividad </strong></div></th>
                <th><div align="center"><strong>Tarea </strong></div></th>
            </tr>
            <tr >
                <td><c:out value="${actividad.descripcion}"/> </td>
                <td><c:out value="${tarea.descripcion}"/> </td>
            </tr>
        </table>
        <br>
        <table border="1">
            <tr>
                <td width="430">
                    <div align="center">
                        <a  href="<c:url value="/InformeEgrCom.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Nuevo monto Comprometido </a>
                    </div>
                </td>
                <td width="425">
                    <div align="center">
                        <a  href="<c:url value="/ActuCom.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Acumular monto comprometido </a>
                    </div>
                </td>
            </tr>
            <br>
        </table>
        <br>
        <table border="1">
            <tr>
                <td><div align="center">
                        <a  href="<c:url value="/EjecuCompro.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Ejecutar Comprometido </a>
                    </div>
                </td>
            </tr>
            
        </table>
        <br>
        <table>
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
        </table>
        <br>
        <table>
            <tr>
                <th colspan="2"><div align="center"><strong>Certificaci&oacute;n Presupuestaria </strong></div></th>
            </tr>
            <tr>
                <td width="50%">
                    <div align="center">
                        <a  href="<c:url value="/nrocert.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Nro. Certificación </a>
                    </div>
                </td>
                <td>
                    <div align="center">
                        <a  href="<c:url value="/fechacert.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>"> Fecha </a>
                    </div>
                </td>
            </tr>
        </table>
        <br>
        <table>
            <tr>
                <td width="50%">
                    <div align="center"> 
                        <a  href="<c:url value="/EliMonComEgr.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>

                            </c:url>"> Anular monto comprometido con su historial</a> 
                    </div>
                </td>
                <td> 
                    <div align="center"> 
                        <a  href="<c:url value="/EliMonComEgrAcu.do">
                                <c:param name="codtar" value="${tarea.codtar}"/>
                                <c:param name="codacti" value="${actividad.codacti}"/>
                            </c:url>">Eliminar Comprometido Acumulado
                        </a> 
                    </div>
                </td>
            </tr>
            <br>
            <br>
        </table>
        <br>
    </div>
    </body>
</html>