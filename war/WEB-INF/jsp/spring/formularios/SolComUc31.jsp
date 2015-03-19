<%@ include file="../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script type="text/javascript" src="prototype.js"></script>
        <script type="text/javascript">
            function buscar_medida(e,id)
            {
                var sd=String(id);
                if(e.length>=1) {
                    var params = 'id='+id+'&lik='+e;
                    var url = '<c:url value="/SolCom31_1.do"/>';
                    new Ajax.Updater({success:sd},url,
                    {method: 'post', parameters: params, onFailure: reportError});
                }
                else{ $(sd).innerHTML="";}
                return false;
            }
            function reportError(request) {
                $('fixme') = "Error";
            }
            function al_in(ii,des){

                $('uni_medida'+ii).value=des;
                $(ii).innerHTML="";
            }
        </script>




    </head>

    <body>

        <div id="container">
            <div id="content">

                <form name="form1" method="post" action="<c:url value="/SolComUc4.do"/>">
                    <table width="811" border="1">
                        <tr>
                            <td colspan="10">
                                <div align="center">
                                    <a  href="<c:url value="/SolComUc2.do">
                                            <c:param name="codtar" value="${tarea.codtar}"/>
                                            <c:param name="descripcion" value="${tarea.descripcion}"/>
                                        </c:url>"> <strong> <font color="red">Men&uacute; Formularios</font></strong>
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th colspan="4" rowspan="3"><div align="center"  >Universidad mayor de san andres<br> Facultad de Ciencias Puras y Naturales </div></th>
                            <th colspan="3" rowspan="3"><div align="center"  >SOLICITUD DE COMPRA </div></th>
                            <th height="22" colspan="3"><div align="center"  >UNIDAD SOLICITANTE </div></th>
                        </tr>
                        <tr>
                            <th height="21" colspan="2"><div align="center"  >CORRELATIVO</div></th>
                            <th width="106"><div align="center"  >FECHA</div></th>
                        </tr>
                        <tr>
                            <td height="21" colspan="2"><div align="center"><span  ><c:out value="${correlativo_unidad}"/>-<c:out value="${tarea.descripcion}"/>-FCPN</span></div></td>
                            <td><div align="center"><span  ><c:out value="${fecha}"/></span></div></td>
                        </tr>
                        <tr>
                            <th colspan="5"><div align="center"  >UNIDAD SOLICITANTE </div></th>
                            <th colspan="5"><div align="center"  >DESTINO</div></th>
                        </tr>
                        <tr>
                            <td colspan="5"><span  ><c:out value="${actividad.descripcion}"/> </span></td>
                            <td colspan="5"><span  >
                                    <input size="45" name="destino" type="text" id="destino" value="<c:out value="${destinov}"/>">
                                </span></td>
                        </tr>
                        <tr>
                            <th width="46" rowspan="2"><div align="center"><span  >Relaci&oacute;n</span></div></th>
                            <th width="62" rowspan="2"><div align="center"><span  >CANTIDAD<br>
                                        SOLICITANTE </span></div></th>
                            <th width="67" rowspan="2"  ><div align="center">UNIDAD DE MEDIDA </div></th>
                            <th width="72" rowspan="2"><div align="center"><span  >CANTIDAD AUTORIZADA </span></div></th>
                            <th colspan="3" rowspan="2"><div align="center"><span  >DESCRIPCION</span></div></th>
                            <th colspan="3"  ><div align="center">PARA COTIZACION </div></th>
                        </tr>
                        <tr>
                            <th width="65"><div align="center"><span  >UNITARIO</span></div></th>
                            <th width="67"  ><div align="center">TOTAL</div></th>
                            <th><div align="center"><span  >PARTIDA GASTO </span></div></th>
                        </tr>
                        <% int i;


            //a.substring(0,4);
            //son los numeros de pedidos
            i = 1;%>
                        <c:forEach var="g" items="${lista_cert}" varStatus="status">
                            <tr>
                                <!--nro-->
                                <td> <select name="unionFormulario">
                                        <c:forEach begin="1" end="250" varStatus="im">
                                            <option value="<c:out value="${im.count}"/>" <c:if test="${im.count == g.uni}">selected</c:if><c:if test="${0 == g.uni}"><c:if test="${im.count == status.count}">selected</c:if></c:if>><c:out value="${im.count}" /></option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <!--cantidad -->
                                <td><span  ><c:out value="${g.cantidad}"/></span></td>
                                <!--unidadmedida -->
                                <td>
                                    <input name="uni_medida<c:out value="${status.count}"/>" value="<c:out value="${g.uni_medida}"/>" type="text" id="uni_medida<c:out value="${status.count}"/>" onKeyPress="javascript:buscar_medida(this.value,'<c:out value="${status.count}"/>')" size="30"/>
                                    <div id="<c:out value="${status.count}" />"></div>
                                </td>
                                <!--cantidad   -->
                                <td><span  ><c:out value="${g.cantidad}"/></span></td>
                                <!--Glosa -->
                                <td colspan="3"><span  ><c:out value="${g.glosa}"/></span></td>
                                <!-- unitario-->
                                <td><div align="right"><fmt:formatNumber value="${g.monto/g.cantidad}" pattern="#,###,###,##0.00"/></div></td>
                                <!-- total-->
                                <td><div align="right"><fmt:formatNumber value="${g.monto}" pattern="#,###,###,##0.00"/></div></td>
                                <!--partida -->
                                <td><span  ><c:out value="${g.codmonegr}"/> </span >
                                    <input type="hidden" name="idd" value="<c:out value="${g.id}"/>">
                                </td>
                            </tr>
                            <% i++;%>
                        </c:forEach>
                        <tr>
                            <td colspan="3" rowspan="3"></td>
                            <th colspan="7">
                                <div align="center">
                                    <span>CONTROL PRESUPUESTARIO<br></span>
                                </div>
                            </th>
                        </tr>
                        <tr>
                            <td  >NOMBRE ACTIVIDAD </td>
                            <td colspan="3"><span  ><c:out value="${tarea.descripcion}"/></span></td>
                            <td colspan="3" rowspan="2"></td>
                        </tr>
                        <tr>
                            <td  >RESPONSABLE</td>

                            <td colspan="3"><span><c:out value="${responsable}"/></span></td>
                        </tr>
                        <tr>
                            <td colspan="3"><div align="center"><span  >UNIDAD SOLICITANTE </span></div></td>
                            <td>&nbsp;</td>
                            <td colspan="3"></td>
                            <td colspan="3"><div align="center"><span  >RESPONSABLE CONTROL <c:out value="${tam_um-1}"/> <c:out value="${tam_um-1}"/></span></div></td>
                        </tr>
                    </table>
                    <table width="812" border="0">
                        <tr>
                            <td><div align="right">
                                    <a  href="<c:url value="/SolComUc2.do">
                                            <c:param name="codtar" value="${tarea.codtar}"/>
                                            <c:param name="descripcion" value="${tarea.descripcion}"/>
                                        </c:url>"> <strong> <font color="red">Men&uacute; Formularios</font></strong>
                                    </a>
                                </div>
                            </td>
                            <td width="375"><div align="right">
                                    <input type="submit" name="Submit" value="Aceptar actualizaciones">
                                </div></td>
                        </tr>
                    </table>
                    <input type="hidden" name="num_sol" value="<c:out value="${num_sol}"/>">
                    <input type="hidden" name="correlativo_unidad" value="<c:out value="${correlativo_unidad}"/>">
                    <input type="hidden" name="fecha" value="<c:out value="${fecha}"/>">
                    <input type="hidden" name="codtar" value="<c:out value="${codtar}"/>">
                    <input type="hidden" name="tam_um" value="<c:out value="${tam_um}"/>">
                </form>
            </div>
        </div>
    </body>
</html>