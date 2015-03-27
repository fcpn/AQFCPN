<<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>

    </head>
    <body>
        <div id="container">
            <div id="content">

                <table width="811" height="180" border="1">
                    <tr>
                        <th colspan="7" rowspan="3"><div align="center" class="Estilo1">SOLICITUD DE COMPRA </div></th>
                        <th height="22" colspan="3"><div align="center" class="Estilo1">UNIDAD SOLICITANTE </div></th>
                    </tr>
                    <tr>
                        <th height="21" colspan="2"><div align="center" class="Estilo1">CORRELATIVO</div></th>
                        <th width="106"><div align="center" class="Estilo1">FECHA</div></th>
                    </tr>
                    <tr>
                        <td height="21" colspan="2"><div align="center"><c:out value="${correlativo_unidad}"/>-<c:out value="${tarea.descripcion}"/>-FCPN</div></td>
                        <td><div align="center"><c:out value="${fecha}"/></div></td>
                    </tr>
                    <tr>
                        <th colspan="5"><div align="center" class="Estilo1">UNIDAD SOLICITANTE </div></th>
                        <th colspan="5"><div align="center" class="Estilo1">DESTINO</div></th>
                    </tr>
                    <tr>
                        <td colspan="5"><c:out value="${actividad.descripcion}"/> </td>
                    <td colspan="5">
                    <c:out value="${destinov}"/>
                    </td>
                    </tr>
                    <tr>
                        <th width="46" rowspan="2"><div align="center">Relaci&oacute;n</div></th>
                        <th width="62" rowspan="2"><div align="center">CANTIDAD<br>
                                SOLICITANTE </div></th>
                        <th width="67" rowspan="2"><div align="center">UNIDAD DE MEDIDA </div></th>
                        <th width="72" rowspan="2"><div align="center">CANTIDAD AUTORIZADA</div></th>
                        <th colspan="3" rowspan="2"><div align="center">DESCRIPCIO</div></th>
                        <th colspan="3"><div align="center">PARA COTIZACION </div></th>
                    </tr>
                    <tr>
                        <th width="65"><div align="center">UNITARIO</div></th>
                        <th width="67"><div align="center">TOTAL</div></th>
                        <th><div align="center">PARTIDA GASTO�</div></th>
                    </tr>
                    <% int i;
                    //a.substring(0,4);
                    //son los numeros de pedidos
                                i = 1;%>
                    <c:forEach var="g" items="${lista_cert}">
                        <tr>
                            <!--nro-->
                            <td><span class="Estilo1"><c:out value="${g.uni}"/> </span></td>
                            <!--cantidad -->
                            <td><span class="Estilo1"><c:out value="${g.cantidad}"/></span></td>
                            <!--unidadmedida -->
                            <td><span class="Estilo1"><c:out value="${g.uni_medida}"/></span></td>
                            <!--cantidad -->
                            <td><span class="Estilo1"><c:out value="${g.cantidad}"/></span></td>
                            <!--Glosa -->
                            <td colspan="3"><span class="Estilo1"><c:out value="${g.glosa}"/></span></td>
                            <!-- unitario-->
                            <td><span class="Estilo1"><c:out value="${g.monto/g.cantidad}"/></span></td>
                            <!-- total-->
                            <td><span class="Estilo1"><c:out value="${g.monto}"/></span></td>
                            <!--partida -->
                            <td><span class="Estilo1"><c:out value="${g.codmonegr}"/></span></td>
                        <input type="hidden" name="idd" value="<c:out value="${g.id}"/>"></tr>

                        <% i++;%>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td>&nbsp;</td>
                        <td></td>
                        <td>&nbsp;</td>
                        <td colspan="3"></td>
                        <td></td>
                        <td>&nbsp;</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="3" rowspan="3"></td>
                        <td colspan="7"><div align="center">CONTROL PRESUPUESTARIO<br></div></td>
                    </tr>
                    <tr>
                        <th>NOMBRE ACTIVIDAD </th>
                        <td colspan="6"><c:out value="${tarea.descripcion}"/></td>

                    </tr>
                    <tr>
                        <th>RESPONSABLE</th>
                        <td colspan="6"><c:out value="${responsable}"/></td>
                    </tr>

                </table>
                <table width="812" border="0">
                    <tr>
                        <td width="806"><div align="center" >
                                <a  href="<c:url value="/SolFor.do">
                                    <c:param name="codtar" value="${tarea.codtar}"/>
                                    <c:param name="descripcion" value="${tarea.descripcion}"/>
                                    </c:url>"> <strong><font color="red"> Menu Formularios </font></strong>
                                </a>

                            </div></td>
                    </tr>
                </table>

                <input type="hidden" name="num_sol" value="<c:out value="${num_sol}"/>">
                       <input type="hidden" name="correlativo_unidad" value="<c:out value="${correlativo_unidad}"/>">
                       <input type="hidden" name="fecha" value="<c:out value="${fecha}"/>">
                       <input type="hidden" name="codtar" value="<c:out value="${codtar}"/>">


            </div>
        </div>

    </body>
</html>
