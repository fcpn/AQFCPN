<%@ include file="../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>

        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script type="text/javascript">
            function confirma(miurl,aa,bb){

                question = confirm("Anular este Formulario  con correlativo : "+ aa +" ?\n NOTA:: Al Anular \nTambien se anulara la Certificación presupuestaria Nro "+bb)
                if (question !="0"){
                    document.location.href = miurl;
                }
            }

        </script>


    </head>

    <body>

        <div id="container">
            <div id="content">

                <form name="form1" method="post" action="<c:url value="/SolCom4.do"/>">
                    <table width="811">
                        <tr>
                            <td colspan="10" rowspan="3" ><div align="center"><font color="red">

                                        <a style="cursor: pointer; color: red;"onClick="confirma('<c:url value="/SolComAnu2.do">
                                               <c:param name="codtar" value="${codtar}"/>
                                               <c:param name="fecha" value="${fecha}"/>
                                               <c:param name="num_sol" value="${num_sol}"/>
                                               <c:param name="correlativo_unidad" value="${correlativo_unidad}"/>
                                               <c:param name="codmonegr" value="${codmonegr}"/>
                                               <c:param name="codfueneco" value="${codfueneco}"/>
                                                   
                                           </c:url>','<c:out value="${correlativo_unidad}"/>','<c:out value="${num_sol}"/>'); return false;"> <strong> ANULAR EL FORMULARIO </strong></a>

                                    </font></div></td>

                        </tr>

                    </table>
                    <table width="811" height="180">


                        <tr>
                            <th colspan="4" rowspan="3"><div align="center">Universidad mayor de san andres <br> Facultad de Ciencias Puras y Naturales</div></th>
                            <th colspan="3" rowspan="3"><div align="center">SOLICITUD DE COMPRA </div></th>
                            <th height="22" colspan="3"><div align="center">UNIDAD SOLICITANTE </div></th>
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
                                    <c:out value="${destinov}"/>
                                </span></td>
                        </tr>
                        <tr>
                            <th width="46" rowspan="2"><div align="center"><span  >N&deg;</span></div></th>
                            <th width="62" rowspan="2"><div align="center"><span  >CANTIDAD<br>SOLICITANTE </span></div></th>
                            <th width="67" rowspan="2"  ><div align="center">UNIDAD DE MEDIDA </div></th>
                            <th width="72" rowspan="2"><div align="center"><span  >CANTIDAD AUTORIZADA </span></div></th>
                            <th colspan="3" rowspan="2"><div align="center">DESCRIPCION</div></th>
                            <th colspan="3"  ><div align="center">PARA COTIZACION </div></th>
                        </tr>
                        <tr>
                            <th width="65"><div align="center"><span>UNITARIO</span></div></th>
                            <th width="67"  ><div align="center">TOTAL</div></th>
                            <th><div align="center"><span  >PARTIDA GASTO </span></div></th>
                        </tr>
                        <% int i;


            //a.substring(0,4);
            //son los numeros de pedidos
            i = 1;%>
                        <c:forEach var="g" items="${lista_cert}">
                            <tr>
                                <!--nro-->
                                <td><span  ><%= i%> </span></td>
                                <!--cantidad -->
                                <td><span  ><c:out value="${g.cantidad}"/></span></td>
                                <!--unidadmedida -->
                                <td><span  ><c:out value="${g.uni_medida}"/></span></td>
                                <!--cantidad -->
                                <td><span  ><c:out value="${g.cantidad}"/></span></td>
                                <!--Glosa -->
                                <td colspan="3"><span  ><c:out value="${g.glosa}"/></span></td>
                                <!-- unitario-->
                                <td><span  ><c:out value="${g.monto/g.cantidad}"/></span></td>
                                <!-- total-->
                                <td><span  ><c:out value="${g.monto}"/></span></td>
                                <!--partida -->
                                <td><span  ><c:out value="${g.codmonegr}"/></span></td>
                            <input type="hidden" name="idd" value="<c:out value="${g.id}"/>"></tr>

                            <% i++;%>
                        </c:forEach>

                        <tr>
                            <td colspan="3" rowspan="3">      </td>
                            <th colspan="7"><div align="center"> <span  >CONTROL PRESUPUESTARIO<br>
                                    </span></div></th>
                        </tr>
                        <tr>
                            <th  >NOMBRE ACTIVIDAD </th>
                            <td colspan="3">   <span  ><c:out value="${tarea.descripcion}"/></span></td>
                            <td colspan="3" rowspan="2">    </td>
                        </tr>
                        <tr>
                            <th  >RESPONSABLE</th>
                            <td colspan="3"><span  ><c:out value="${responsable}"/></span></td>
                        </tr>
                        <tr>
                            <th colspan="3"><div align="center"> UNIDAD SOLICITANTE></div></th>
                            <td>&nbsp;</td>
                            <td colspan="3">    </td>
                            <th colspan="3"><div align="center"> RESPONSABLE CONTROL </div></th>
                        </tr>
                    </table>
                    <table width="812" border="0">
                        <tr>
                            <td width="806"><div align="right">

                                </div></td>
                        </tr>
                    </table>

                    <input type="hidden" name="num_sol" value="<c:out value="${num_sol}"/>">
                    <input type="hidden" name="correlativo_unidad" value="<c:out value="${correlativo_unidad}"/>">
                    <input type="hidden" name="fecha" value="<c:out value="${fecha}"/>">
                    <input type="hidden" name="codtar" value="<c:out value="${codtar}"/>">

                </form>




                <table width="811">
                    <tr>
                        <td><div align="center"><font color="red"> <a style="cursor: pointer; color: red;"onClick="confirma('<c:url value="/SolComAnu2.do">
                                                                          <c:param name="codtar" value="${codtar}"/>
                                                                          <c:param name="fecha" value="${fecha}"/>
                                                                          <c:param name="num_sol" value="${num_sol}"/>
                                                                          <c:param name="correlativo_unidad" value="${correlativo_unidad}"/>
                                                                      </c:url>','<c:out value="${correlativo_unidad}"/>'); return false;"> <strong> ANULAR EL FORMULARIO </strong></a></font></div></td>
                    </tr>
                    <tr><td><br><br><div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div></td></tr>
                </table>
            </div>
        </div>
    </body>
</html>
