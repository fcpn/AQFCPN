<%@ include file="../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script type="text/javascript" src="prototype.js"></script>


        <script type="text/javascript">


            function buscar_proveedor(e)
            {


                if(e.value.length>=0) {
                    var params = 'lik='+e.value;
                    //alert(sd);
                    // alert(e.value);
                    var url = '<c:url value="/SolCom7_1.do"/>';

                    new Ajax.Updater({success:'lis_pro'},url,
                    {method: 'post', parameters: params, onFailure: reportError});


                }
                else{ $('lis_pro').innerHTML="";}
                return false;
            }
            function reportError(request) {
                $('fixme') = "Error";
            }
            function al_pro(nit,des){
                $('nit').value=nit;
                $('proveedor').value=des;
                $('lis_pro').innerHTML="";
            }


        </script>
    </head>
    <body>
        <div id="container">
            <div id="content">

                <form method="post" action="<c:url value="/SolCom71_1.do"/>">
                    <table width="792" border="0">
                        <tr>
                            <td colspan="7"><div align="center">
                                    <a  href="<c:url value="/SolComUc2.do">
                                            <c:param name="codtar" value="${tarea.codtar}"/>
                                            <c:param name="descripcion" value="${tarea.descripcion}"/>
                                        </c:url>"> <strong> <font color="red">Men&uacute; Formularios</font></strong>
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6"><table width="785" border="0">
                                    <tr>
                                        <td colspan="4">
                                            <table width="572" border="0">
                                                <tr>
                                                    <th width="333"><div align="center">ORDEN DE COMPRA</div></th>
                                                    <td width="229">N°</td>
                                                </tr>
                                                <tr>
                                                    <td rowspan="4">&nbsp;</td>
                                                    <td>Tipo de Cambio:</td>
                                                </tr>
                                                <tr>
                                                    <td>Fecha:</td>
                                                </tr>
                                                <tr>
                                                    <td>Nro de Cbte:</td>
                                                </tr>
                                                <tr>
                                                    <td>Nro de Cheque:</td>
                                                </tr>
                                            </table>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td rowspan="2">UNIDAD SOLICITANTE</td>
                                        <td width="145" rowspan="2">Se Adjudica a:</td>
                                        <td width="120"><c:out value="${nit}"/></td>
                                        <td width="303"><c:out value="${pro.proveedor}"/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <table align="center" >

                                                <c:forEach var="g" items="${lis_suc}">
                                                    <tr>

                                                        <td>
                                                            <c:out value="${g.direccion}"/> <br><br>TELEFONOS: <c:out value="${g.telefonos}"/>
                                                        </td>

                                                    </tr>

                                                </c:forEach>
                                            </table>


                                        </td>

                                    </tr>
                                    <tr>
                                        <td height="21"><c:out value="${actividad.descripcion}"/></td>
                                        <td colspan="3">       </td>
                                    </tr>
                                </table></td>
                        </tr>

                        <tr>
                            <th width="22"><div align="center">N°</div></th>
                            <th width="90"><div align="center">CANTIDAD</div></th>
                            <th width="88"><div align="center">UNIDAD DE<br>
                                    MEDIDA</div></th>
                            <th width="448"><div align="center">DESCRIPCIÓN</div></th>
                            <th width="90"><div align="center">UNITARIO</div></th>
                            <th width="53"><div align="center">TOTAL</div></th>
                        </tr>

                        <c:forEach var="g" items="${lista_cert}" varStatus="status">
                            <tr>
                                <td><c:out value="${status.count}" /></td>
                                <td><c:out value="${g.cantidad}"/></td>
                                <td><c:out value="${g.uni_medida}"/></td>
                                <td><c:out value="${g.glosa}"/></td>
                                <td><c:out value="${g.monto/g.cantidad}"/></td>
                                <td><c:out value="${g.monto}"/></td>
                            </tr>
                        </c:forEach>

                        <tr>
                            <td colspan="3">&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                        </tr>

                        <tr>
                            <td colspan="6">
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
                            <td colspan="6">
                                <div align="right">

                                    <input type="hidden" id="codtar" value="<c:out value="${codtar}"/>">
                                    <input type="hidden" id="codacti" value="<c:out value="${codacti}"/>">
                                    <input type="hidden" id="fecha" value="<c:out value="${fecha}"/>">
                                    <input type="hidden" id="num_sol" value="<c:out value="${num_sol}"/>">
                                    <input type="hidden" id="correlativo_unidad" value="<c:out value="${correlativo_unidad}"/>">
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>