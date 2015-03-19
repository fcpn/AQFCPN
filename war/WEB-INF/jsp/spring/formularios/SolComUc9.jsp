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
                    <form name="form23" method="post" action="<c:url value="/SolComUc10.do"/>">
                        <table>
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
                                <th colspan="6">
                                    <table>
                                        <tr>
                                            <td width="111"><div align="center" class="Estilo6">UMSA</div></td>
                                            <th width="390"><div align="center" class="Estilo6">INGRESO DE MATERIAL</div></th>
                                            <td width="83"><div align="center" class="Estilo6">Nro</div></td>
                                        </tr>
                                    </table>
                                </th>
                            </tr>
                            <tr>
                                <td colspan="6">Proveedor: </td>
                            </tr>
                            <tr>
                                <th colspan="6">
                                    <table>
                                        <tr>
                                            <td width="300" style="background-color:#D2ECF9">
                                                <b<font size="2">Factura:</font></b>
                                                <input name="factura" type="text" id="factura" value="<c:out value="${factura}"/>" size="30" maxlength="120"/>
                                            </td>
                                            <td width="286">
                                                <table style="width:300px;">
                                                    <tr>
                                                        <th colspan="4" style="width:250px;"><div align="center"><font size="2">Fecha Factura</font></div></th>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3" style="width:18px;background-color:#FF9900;">
                                                            <div align="center">
                                                              <input name="fecha_factura" type="text" id="fecha_factura" value="<c:out value="${fecha_factura}"/>" size="8" maxlength="8">
                                                            </div>
                                                        </td>
                                                        <td rowspan="2" style="width:18px;background-color:#C7C7C7;"><font size="1">El Formato de fecha es <b>01/04/10</b></font></td>
                                                    </tr>
                                                    <tr>
                                                        <th style="width:18px;" align="center"><div align="center">Dia</div></th>
                                                        <th style="width:18px;" align="center"><div align="center">Mes</div></th>
                                                        <th style="width:18px;" align="center"><div align="center">Año</div></th>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </th>
                            </tr>
                            <tr>
                                <th colspan="6">
                                    <table border="0">
                                        <tr>
                                            <td width="304"><b>Comprobate:</b>&nbsp;&nbsp;&nbsp;&nbsp; <b> <font size="2" color="green"><c:out value="${cbte}"/></font> </b> </td>
                                            <td style="background-color:#D2ECF9" width="290">
                                                <table style="width:300px;">
                                                    <tr>
                                                        <th colspan="4" style="width:250px;"><div align="center"><font size="2">Fecha Comprobante</font></div> </th>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="3" style="width:18px;background-color:#FF9900;">
                                                            <div align="center">
                                                              <input name="fecha_cbte" type="text" id="fecha_cbte" value="<c:out value="${fecha_cbte}"/>" size="8" maxlength="8">
                                                            </div></td>
                                                        <td rowspan="2" style="width:18px;background-color:#C7C7C7;"><font size="1">El Formato de fecha es <b>01/04/10</b></font></td>
                                                    </tr>
                                                    <tr>
                                                        <th style="width:18px;" align="center"><div align="center">Dia</div></th>
                                                        <th style="width:18px;" align="center"><div align="center">Mes</div></th>
                                                        <th style="width:18px;" align="center"><div align="center">Año</div></th>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </th>
                            </tr>
                            <tr>
                                <td height="23" colspan="6">
                                    <div align="right">
                                        <input type="submit" value="Aceptar"/>
                                        <input type="hidden" id="codtar" name="codtar" value="<c:out value="${codtar}"/>">
                                        <input type="hidden" id="codacti" name="codacti" value="<c:out value="${codacti}"/>">
                                        <input type="hidden" id="fecha"  name="fecha" value="<c:out value="${fecha}"/>">
                                        <input type="hidden" id="num_sol" name="num_sol" value="<c:out value="${num_sol}"/>">
                                        <input type="hidden" id="correlativo_unidad" name="correlativo_unidad" value="<c:out value="${correlativo_unidad}"/>">
                                        <input type="hidden" id="correlativo_orden_compra" name="correlativo_orden_compra" value="<c:out value="${correlativo_orden_compra}"/>">
                                        <input type="hidden" id="corr_ing_mat" name="corr_ing_mat" value="<c:out value="${corr_ing_mat}"/>">
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