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
                <c:if test="${sw==1}">
                    <table border="1" align="center">
                        <tr>
                            <th>
                                <div align="center">           Sistema de Presupuestos<br>
                                    AQUILES<br>
                                    Ingresos de Material
                                </div>

                            </th>
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
                        <tr>
                            <td>
                                <div align="center">
                                    <iframe src="pdf/<c:out value="${direc}"/>" frameborder="0" style="width:900px;height:900px"></iframe>
                                </div>
                            </td>
                        </tr>

                    </table>
                </c:if>
                <c:if test="${sw==0}">Falta completar datos para imprimir el documento en unidades de medida o proveedor</c:if>
            </div>
        </div>
    </body>
</html>