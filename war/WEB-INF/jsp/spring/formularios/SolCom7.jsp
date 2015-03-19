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
                <c:if test="${sw==3}">
                    <form name="form23" method="post" action="<c:url value="/SolCom71_1.do"/>">
                        <table width="820" height="360" border="0">
                            <tr>
                                <td colspan="6"><table width="814" border="0">
                                        <tr>
                                            <td width="199"><div align="center"><STRONG>UNIVERSIDAD MAYOR DE SAN ANDRÉS<br>
                                                        FACULTAD DE CIENCIAS PURAS Y NATURALES<br>
                                                        UNIDAD DESCONCENTRADA</STRONG></div></td>
                                            <td colspan="3">
                                                <table width="608" border="0">
                                                    <tr>
                                                        <th width="310"><div align="center">ORDEN DE COMPRA</div></th>
                                                        <td width="284">N°</td>
                                                    </tr>
                                                    <tr>
                                                        <td rowspan="4">&nbsp;</td>
                                                        <td>Tipo de Cambio:</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Fecha:</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Nro de Cbte:
                                                            <input name="cbte" type="text" id="cbte" value="<c:out value="${cbte}"/>" maxlength="250">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Nro de Cheque:
                                                            <input name="cheque" type="text" id="cheque" value="<c:out value="${cheque}"/>" maxlength="250">
                                                        </td>
                                                    </tr>
                                                </table>

                                            </td>
                                        </tr>
                                        <tr>
                                            <td rowspan="2">UNIDAD SOLICITANTE</td>
                                            <td width="145" rowspan="2">Se Adjudica a:</td>
                                            <td width="120"><input name="nit" type="text" id="nit" onKeyPress="javascript:buscar_proveedor(this)" value="<c:out value="${bprovee.nit}"/>" size="20"></td>
                                            <td width="303"><input name="proveedor" type="text" id="proveedor" value="<c:out value="${bprovee.proveedor}"/>" readonly="readonly" size="45"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><div id="lis_pro"></div> </td>

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
                                    <div align="right">
                                        <input type="submit" name="button" id="button" value="Aceptar">
                                        <input type="hidden" id="codtar" name="codtar" value="<c:out value="${codtar}"/>">
                                        <input type="hidden" id="codacti" name="codacti" value="<c:out value="${codacti}"/>">
                                        <input type="hidden" id="fecha"  name="fecha" value="<c:out value="${fecha}"/>">
                                        <input type="hidden" id="num_sol" name="num_sol" value="<c:out value="${num_sol}"/>">
                                        <input type="hidden" id="correlativo_unidad" name="correlativo_unidad" value="<c:out value="${correlativo_unidad}"/>">
                                        <input type="hidden" id="correlativo_orden_compra" name="correlativo_orden_compra" value="<c:out value="${correlativo_orden_compra}"/>">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6">
                                    <div align="center">
                                        <a  href="<c:url value="/SolCom2.do">
                                                <c:param name="codtar" value="${tarea.codtar}"/>
                                                <c:param name="descripcion" value="${tarea.descripcion}"/>
                                            </c:url>"> <strong> <font color="red">Men&uacute; Formularios</font></strong>
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
                </c:if>
                <c:if test="${sw==1}"> No se definieron las <b>unidades de medida</b></c:if>
                <c:if test="${sw==2}"> No se esta defindo el <b>destino</b> actulice datos del documento</c:if>
                <c:if test="${sw==0}"> Ya se esta definido el <b>provedordes y nit</b><font color="red"><a>i</a></font></c:if>
                <p>&nbsp;</p>
            </div>
        </div>
    </body>
</html>