<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Mostrando los montos presupuestados</title>
        <link href="tablarep/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablarep/tablecloth.js"></script>
    </head>
    <body>
        <div id="container">
            <div id="content">
                <form name="form1" method="post" action="  ">
                    <table width="523" border="0" align="center">
                        <tr>
                            <th colspan="2" ><div align="center">Informe General </div></th>
                        </tr>
                        <tr>
                            <th width="238" ><div align="center"><strong>Actividad</strong></div></th>
                            <th width="269" ><div align="center"><strong>Tarea</strong></div></th>
                        </tr>
                        <tr >
                            <td width="238" ><c:out value="${actividad.descripcion}"/> </td>
                            <td width="269" ><c:out value="${fech.descripcion}"/> </td>
                        </tr>
                    </table>
                    <table width="523" border="0" align="center">
                        <tr >
                            <th><div align="center">Fecha de Actualizacion </div></th>
                        </tr>
                        <tr >
                            <td><div align="center"><strong><c:out value="${fech.fecha_act}"/></strong></div></td>
                        </tr>
                    </table>
                    <table width="630" border="0" align="center">
                        <c:forEach var="grl" items="${grl}">
                            <c:if test="${grl.codtar==codtar }">
                                <tr>
                                    <th width="192">Identificacion de la Funci&oacute;n </th>
                                    <td colspan="4"> <c:out value="${grl.funcion}"/> </td>
                                </tr>
                                <tr>
                                    <th>Responsable</th>
                                    <td colspan="4"><c:out value="${grl.nom}"/> <c:out value="${grl.ap}"/> <c:out value="${grl.am}"/></td>
                                </tr>
                                <tr>
                                    <th>Cargo del Responsable</th>
                                    <td width="195"><c:out value="${grl.cargo}"/></td>
                                    <th>Resultado</th>
                                    <td width="108"><c:out value="${grl.cargah}"/></td>
                                </tr>
                                <tr>
                                    <th>Objetivo</th>
                                    <td colspan="4"><c:out value="${grl.objetivo}"/></td>
                                </tr>
                                <tr>
                                    <th>Fecha de inicio</th>
                                    <td><c:out value="${grl.fechai}"/></td>
                                    <th>Fecha Final</th>
                                    <td><c:out value="${grl.fechaf}"/></td>
                                </tr>
                                <tr>
                                    <th height="23">Apertura Progr&aacute;matica</th>
                                    <td height="23" colspan="3"><c:out value="${actividad.apertura_prog}"/></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                    <table width="731" border="0" align="center">
                        <tr>
                            <th><div align="center">INFORME INGRESOS</div></th>
                        </tr>
                        <tr>
                            <th><div align="center"> Fuente Econ&oacute;mica </div><br> <div align="center"> <c:out value="${codfueneco}"/> - <c:out value="${fuente.descripcion}"/></div></th>
                        </tr>
                    </table>
                    <table width="830" border="0" align="center">
                        <tr>
                            <th width="262">Clasificador</th>
                            <th width="151">Presupuestado</th>
                            <th width="121">Ejecutado</th>
                            <th width="114">Saldo</th>
                            <th width="108">His. Ejecutado</th>
                            <th width="108">His. Traspasos</th>
                            <th width="108">His. Incrementos</th>
                        </tr>
                        <c:forEach var="mo" items="${mosmoneje}">
                            <c:if test="${mo.codtar==codtar }">
                                <c:if test="${mo.codfueneco==codfueneco }">
                                    <tr>
                                        <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
                                        <td><div align="right"><c:out value="${mo.monto}"/></div></td>
                                        <td><div align="right"><c:out value="${mo.moneje}"/></div></td>
                                        <td><div align="right"><c:out value="${mo.saldo}"/></div></td>
                                        <td>
                                            <a href=<c:url value="/MostrarEjePresu.do">
                                                   <c:param name="moneje" value="${mo.moneje}"/>
                                                   <c:param name="codtar" value="${codtar}"/>
                                                   <c:param name="codacti" value="${actividad.codacti}"/>
                                                   <c:param name="codfueneco" value="${mo.codfueneco}"/>
                                                   <c:param name="desfe" value="${mo.desfe}"/>
                                                   <c:param name="codmoning" value="${mo.codmoning}"/>
                                                   <c:param name="descla" value="${mo.descla}"/>
                                               </c:url>>Historial
                                            </a>
                                        </td>
                                        <td><div align="center"> </div></td>
                                        <td>
                                            <a href=<c:url value="/MosHisIncIE.do">
                                                   <c:param name="monto" value="${mo.monto}"/>
                                                   <c:param name="moneje" value="${mo.moneje}"/>
                                                   <c:param name="saldo" value="${mo.saldo}"/>
                                                   <c:param name="codtar" value="${codtar}"/>
                                                   <c:param name="codacti" value="${actividad.codacti}"/>
                                                   <c:param name="codfueneco" value="${mo.codfueneco}"/>
                                                   <c:param name="desfe" value="${mo.desfe}"/>
                                                   <c:param name="codmon" value="${mo.codmoning}"/>
                                                   <c:param name="descla" value="${mo.descla}"/>
                                                   <c:param name="ref1" value="${mo.tipo}"/>
                                                   <c:param name="i_e" value="${0}"/>
                                               </c:url>>Historial
                                            </a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <tr >
                            <th colspan="7" >Montos No Presupuestados</th>
                        </tr>

                        <c:forEach var="moo" items="${mos}">

                            <!-- Elige la tarea para mostrala -->
                            <c:if test="${moo.codtar==codtar }">
                                <c:if test="${moo.codfueneco==codfueneco}">
                                    <tr>
                                        <td><c:out value="${moo.codmonnopreing}"/> - <c:out value="${moo.descla}"/></td>
                                        <td><div align="center">-</div></td>
                                        <td><div align="right"><c:out value="${moo.monejenopre}"/></div></td>
                                        <td><div align="right"> </div></td>
                                        <td>
                                            <a href=<c:url value="/MostrarEjeNoPresu.do">
                                                   <c:param name="monejenopre" value="${moo.monejenopre}"/>
                                                   <c:param name="codtar" value="${codtar}"/>
                                                   <c:param name="codacti" value="${actividad.codacti}"/>
                                                   <c:param name="codfueneco" value="${moo.codfueneco}"/>
                                                   <c:param name="codmonnopreing" value="${moo.codmonnopreing}"/>
                                                   <c:param name="noref123" value="${moo.ref123}"/>
                                                   <c:param name="descla" value="${moo.descla}"/>
                                               </c:url>> Historial
                                            </a>
                                        </td>
                                        <td><div align="center"> </div></td>
                                        <td> </td>
                                    </tr>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <th>TOTALES</th>
                            <td><div align="right">[<c:out value="${too}"/>]</div></td>
                            <td><div align="right">[<c:out value="${too3}"/>]</div></td>
                            <td><div align="right">[<c:out value="${too1}"/>]</div></td>
                            <td colspan="3"> </td>
                        </tr>
                    </table>
                    <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                    <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                </form>
                <form name="form1z" method="post" action="  ">
                    <table width="731" border="0" align="center">
                        <tr>
                            <th><div align="center">INFORME EGRESOS</div></th>
                        </tr>
                        <tr>
                            <th><div align="center"> Fuente Econ&oacute;mica </div><br>
                                <div align="center"> <c:out value="${codfueneco}"/> - <c:out value="${fuente.descripcion}"/></div></th>
                        </tr>
                    </table>

                    <table width="830" border="0" align="center">
                        <tr>
                            <th width="234">Clasificador</th>
                            <th width="137">Presupuestado</th>
                            <th width="116">Ejecutado</th>
                            <th width="97">Saldo</th>
                            <th width="111">His. Ejecutado</th>
                            <th width="95">His. Traspasos</th>
                            <th width="95">His. Incrementos</th>
                            <c:if test="${scom!=null}">
                                <td width="95" ><c:out value="${scom2}"/></td>
                                <td width="95"><c:out value="${scom3}"/></td>
                            </c:if>
                        </tr>
                        <c:forEach var="mo" items="${mosmonejez}">
                            <c:if test="${mo.codtar==codtar }">
                                <c:if test="${mo.codfueneco==codfueneco}">
                                    <tr>
                                        <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
                                        <td><div align="right"><c:out value="${mo.monto}"/></div></td>
                                        <td><div align="right"><c:out value="${mo.moneje}"/></div></td>
                                        <td><div align="right"><c:out value="${mo.saldo}"/></div></td>
                                        <td>
                                            <a href=<c:url value="/MostrarEjePresue.do">
                                                   <c:param name="moneje" value="${mo.moneje}"/>
                                                   <c:param name="codtar" value="${codtar}"/>
                                                   <c:param name="codacti" value="${actividad.codacti}"/>
                                                   <c:param name="codfueneco" value="${mo.codfueneco}"/>
                                                   <c:param name="desfe" value="${mo.desfe}"/>
                                                   <c:param name="codmoning" value="${mo.codmoning}"/>
                                                   <c:param name="descla" value="${mo.descla}"/>
                                               </c:url>>Historial
                                            </a>
                                        </td>
                                        <td>
                                            <a href=<c:url value="/MosHisTras.do">
                                                   <c:param name="monto" value="${mo.monto}"/>
                                                   <c:param name="moneje" value="${mo.moneje}"/>
                                                   <c:param name="saldo" value="${mo.saldo}"/>
                                                   <c:param name="codtar" value="${codtar}"/>
                                                   <c:param name="codacti" value="${actividad.codacti}"/>
                                                   <c:param name="codfueneco" value="${mo.codfueneco}"/>
                                                   <c:param name="codmonegr" value="${mo.codmoning}"/>
                                                   <c:param name="descla" value="${mo.descla}"/>
                                               </c:url>>Historial
                                            </a>
                                        </td>
                                        <td>
                                            <a href=<c:url value="/MosHisIncIE.do">
                                                   <c:param name="monto" value="${mo.monto}"/>
                                                   <c:param name="moneje" value="${mo.moneje}"/>
                                                   <c:param name="saldo" value="${mo.saldo}"/>
                                                   <c:param name="codtar" value="${codtar}"/>
                                                   <c:param name="codacti" value="${actividad.codacti}"/>
                                                   <c:param name="codfueneco" value="${mo.codfueneco}"/>
                                                   <c:param name="codmon" value="${mo.codmoning}"/>
                                                   <c:param name="descla" value="${mo.descla}"/>
                                                   <c:param name="ref1" value="${mo.ref123}"/>
                                                   <c:param name="i_e" value="${1}"/>
                                               </c:url>>Historial
                                            </a>
                                        </td>
                                        <c:if test="${mo.montocom!=null}">
                                            <td>
                                                <div align="right">
                                                    <a href=<c:url value="/MosHisCom.do">
                                                           <c:param name="montocom" value="${mo.montocom}"/>
                                                           <c:param name="saldocompro" value="${mo.saldocompro}"/>
                                                           <c:param name="monto" value="${mo.monto}"/>
                                                           <c:param name="moneje" value="${mo.moneje}"/>
                                                           <c:param name="saldo" value="${mo.saldo}"/>
                                                           <c:param name="codtar" value="${codtar}"/>
                                                           <c:param name="codacti" value="${actividad.codacti}"/>
                                                           <c:param name="codfueneco" value="${mo.codfueneco}"/>
                                                           <c:param name="codmon" value="${mo.codmoning}"/>
                                                           <c:param name="descla" value="${mo.descla}"/>
                                                           <c:param name="ref1" value="${mo.ref123}"/>
                                                           <c:param name="i_e" value="${1}"/>
                                                       </c:url>> <c:out value="${mo.montocom}"/>
                                                    </a>
                                                </div>
                                            </td>
                                            <td>
                                                <div align="right"> <c:out value="${mo.saldocompro}"/></div>
                                            </td>
                                        </c:if>
                                    </tr>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <tr >
                            <th colspan="9" >Montos No Presupuestados</th>
                        </tr>
                        <c:forEach var="moo" items="${mosz}">
                            <c:if test="${moo.codtar==codtar }">
                                <c:if test="${moo.codfueneco==codfueneco}">
                                    <tr>
                                        <td><c:out value="${moo.codmonnopreegr}"/> - <c:out value="${moo.descla}"/></td>
                                        <td><div align="center"> </div></td>
                                        <td><div align="right"><c:out value="${moo.monejenopre}"/></div></td>
                                        <td><div align="center"> </div></td>
                                        <td>
                                            <a href=<c:url value="/MostrarEjeNoPresue.do">
                                                   <c:param name="monejenopre" value="${moo.monejenopre}"/>
                                                   <c:param name="codtar" value="${codtar}"/>
                                                   <c:param name="codacti" value="${actividad.codacti}"/>
                                                   <c:param name="codfueneco" value="${moo.codfueneco}"/>
                                                   <c:param name="codmonnopreegr" value="${moo.codmonnopreegr}"/>
                                                   <c:param name="descla" value="${moo.descla}"/>
                                                   <c:param name="noref123" value="${moo.ref123}"/>
                                               </c:url>> Historial
                                            </a>
                                        </td>
                                        <td><div align="center"> </div></td>
                                        <td> </td>
                                    </tr>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <th>TOTALES</th>
                            <td><div align="right">[<c:out value="${tooz}"/>]</div></td>
                            <td><div align="right">[<c:out value="${too3z}"/>]</div></td>
                            <td><div align="right">[<c:out value="${too1z}"/>]</div></td>
                            <td colspan="3">&nbsp;</td>
                            <c:if test="${scom!=null}">
                                <td><div align="right">[<c:out value="${totmoncom}"/>]</div></td>
                                <td> </td>
                            </c:if>
                        </tr>
                        <tr>
                            <th height="19" colspan="2">Saldo Disponible Real</th>
                            <td height="19"><div align="right">[ <c:out value="${toto}"/> ]</div></td>
                            <c:if test="${scom!=null}">
                                <td height="19">&nbsp;</td>
                                <th height="19" colspan="3">Saldo mas Montos Comprometidos</th>
                                <td height="19" colspan="2"><div align="right">[<c:out value="${totmsalcom}"/>]</div></td>
                            </c:if>
                        </tr>
                    </table>
                    <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                    <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                </form>
                <c:if test="${tooz==too}">
                    <h5> LOS TOTALES DE MONTOS PRESUPUESTADOS ENTRE INGRESOS Y EGRESOS SON IGUALES </h5>
                </c:if>
                <c:if test="${tooz!=too}">
                    <h3> <font color="#FF0000"> LOS TOTALES DE MONTOS PRESUPUESTADOS ENTRE INGRESOS Y EGRESOS NO SON IGUALES</font></h3>
                </c:if>
                <p>&nbsp;</p>
                <div align="right"><a href="javascript:cerrarse('')">cerrar ventana</a></div>
                <p>&nbsp;</p>
            </div>
        </div>
    </body>
</html>