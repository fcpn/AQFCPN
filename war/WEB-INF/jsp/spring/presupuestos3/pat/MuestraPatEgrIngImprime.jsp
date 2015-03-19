<%@ include file="../../Cabecera.jsp" %>

<html>
    <head>
        <title>Mostrando los montos presupuestados</title>
        <style type="text/css">
            <!--
            .cabeza {
                color: #000000;
                font-size: 14px;
                font-weight: bold;
            }
            .cabeza2 {
                color: #000000;
                font-size: 12px;
                font-weight: bold;
            }
            .text {
                color: #000000;
                font-size: 9px;

            }
            table
            {
                border-collapse:collapse;
            }
            -->
        </style>
    </head>
    <body>

        <p>&nbsp;</p>

        <!--  MOSTRANDO TODO DE INGRESOS  -->

        <form name="form1" metdod="post" action="  ">
            <table border="" width="370" border="0" align="center" widtd="523">
                <tr >
                    <td colspan="2" class="cabeza"><div align="center" >Informe General </div></td>
                </tr>
                <tr >
                    <td widtd="238" class="cabeza"><div align="center" >Actividad</div></td>
                    <td widtd="269" class="cabeza"><div align="center" >Tarea</div></td>
                </tr>
                <tr >
                    <td widtd="238" class="text" ><c:out value="${actividad.descripcion}"/></td>
                    <td widtd="269" class="text"><c:out value="${fech.descripcion}"/> </td>
                </tr>
                <tr >
                    <td colspan="2" class="cabeza"><div align="center" class="cabeza">Fecha de Actualizaci&oacute;n </div></td>
                </tr>
                <tr >
                    <td colspan="2" class="text"><div align="center"><strong><c:out value="${fech.fecha_act}"/></strong></div></td>
                </tr>
            </table>

            <!-- DATOS GENERALES-->

            <table border="" widtd="630" border="0" align="center">
                <c:forEach var="grl" items="${grl}">
                    <c:if test="${grl.codtar==codtar }">
                        <tr>
                            <td widtd="192" class="cabeza">Identificacion de la Funci&oacute;n </td>
                            <td colspan="4" class="text"> <c:out value="${grl.funcion}"/> </td>
                        </tr>
                        <tr>
                            <td class="cabeza">Responsable</td>
                            <td colspan="4" class="text"><c:out value="${grl.nom}"/> <c:out value="${grl.ap}"/> <c:out value="${grl.am}"/></td>
                        </tr>
                        <tr>
                            <td class="cabeza">Cargo del Responsable</td>
                            <td widtd="195" class="text"><c:out value="${grl.cargo}"/></td>
                            <td widtd="95" class="cabeza">Resultado </td>
                            <td widtd="108" class="text"><c:out value="${grl.cargah}"/></td>
                        </tr>
                        <tr>
                            <td class="cabeza">Objetivo</td>
                            <td class="text" colspan="4"><c:out value="${grl.objetivo}"/></td>
                        </tr>
                        <tr>
                            <td class="cabeza">Fecha de inicio </td>
                            <td class="text"><c:out value="${grl.fechai}"/></td>
                            <td class="cabeza">Fecha Final </td>
                            <td class="text"><c:out value="${grl.fechaf}"/></td>
                        </tr>
                        <tr>
                            <td height="23" colspan="5">&nbsp;</td>
                        </tr>
                        <tr>
                            <td class="cabeza" height="23">Apertura Progr&aacute;matica </td>
                            <td height="23" class="text" colspan="3"><c:out value="${tarea.aper_prog}"/></td>
                        </tr>
                    </c:if>    </c:forEach>
                </table>

                <br>
                <table align="left">
                    <tr>
                        <td class="cabeza"><strong>Ingresos</strong></td>
                    </tr>
                </table>
                <br>                <br>

                <table border="" widtd="700" border="0">

                <c:forEach var="i" begin="0" end="${Fcl-1}">
                    <tr>
                        <c:forEach var="j" begin="0" end="${Ccl-1}">

                            <c:if test="${i==0}">

                                <td align="right"  widtd="500" class="cabeza"> <c:out value="${M[i][j]}"/></td>

                            </c:if>

                            <c:if test="${i==1}">

                                <td align="right" class="cabeza2" widtd="500"> <c:out value="${M[i][j]}"/></td>

                            </c:if>

                            <c:if test="${i>1}">

                                <td align="right" class="text" widtd="500"> <c:out value="${M[i][j]}"/> </td>

                            </c:if>

                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>

            <br>
            <table border="0">
                <tr><td class="cabeza"><strong>Egresos</strong></td>
                </tr></table>
            <br>

            <table border="" widtd="700" border="0">

                <c:forEach var="i" begin="0" end="${EFcl-1}">
                    <tr>
                        <c:forEach var="j" begin="0" end="${ECcl-1}">

                            <c:if test="${i==0}">

                                <td align="right" class="cabeza" widtd="500"><c:out value="${EM[i][j]}"/></td>

                            </c:if>

                            <c:if test="${i==1}">

                                <td widtd="500" class="cabeza2" align="right"><c:out value="${EM[i][j]}"/></td>

                            </c:if>

                            <c:if test="${i>1}">

                                <td align="right" class="text" widtd="500"><c:out value="${EM[i][j]}"/></td>

                            </c:if>

                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>

            <br>
            <table ><tr><td class="cabeza"><div align="center">Saldos Reales</div></td>
                </tr></table>

            <table border="" widtd="700" border="0">

                <c:forEach var="i" begin="0" end="${4}">
                    <tr>
                        <c:forEach var="j" begin="0" end="${coto-1}">

                            <c:if test="${i==0}">

                                <td align="right" class="cabeza2" widtd="500"><c:out value="${MB[i][j]}"/></td>

                            </c:if>

                            <c:if test="${i==1}">

                                <td align="right" class="text"  widtd="500"><c:out value="${MB[i][j]}"/></td>

                            </c:if>


                            <c:if test="${i==2}">
                                <td align="right" class="text"  widtd="500"><c:out value="${MB[i][j]}"/></td>
                            </c:if>

                            <c:if test="${i==3}">
                                <td align="right" class="text" widtd="500"><c:out value="${MB[i][j]}"/> </td>
                            </c:if>

                            <c:if test="${i==4}">
                                <td align="right" class="text" widtd="500"><c:out value="${MB[i][j]}"/></td>
                            </c:if>


                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            <br>

            <table><tr><td class="cabeza"><div align="center">Porcentajes de ejecuci&oacute;n Real</div></td>
                </tr></table>

            <table border="" widtd="700" border="0">

                <c:forEach var="i" begin="0" end="${2}">
                    <tr>
                        <c:forEach var="j" begin="0" end="${colcom-1}">

                            <c:if test="${i==0}">

                                <td align="right" class="cabeza2" widtd="500"><c:out value="${COM[i][j]}"/></td>

                            </c:if>

                            <c:if test="${i==1}">

                                <td align="right" class="text" widtd="500"><c:out value="${COM[i][j]}"/></td>

                            </c:if>


                            <c:if test="${i==2}">
                                <td align="right" class="text"  widtd="500"><c:out value="${COM[i][j]}"/></td>
                            </c:if>

                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>




            <table><tr><td class="cabeza"><div align="center">Porcentajes de ejecuci&oacute;n Real y en Proceso</div></td>
                </tr></table>
            <table border="" widtd="700" border="0">

                <c:forEach var="i" begin="0" end="${2}">
                    <tr>
                        <c:forEach var="j" begin="0" end="${colcom-1}">

                            <c:if test="${i==0}">

                                <td align="right" class="cabeza2" widtd="500"><c:out value="${MCM[i][j]}"/></td>

                            </c:if>

                            <c:if test="${i==1}">

                                <td align="right" class="text" widtd="500"><c:out value="${MCM[i][j]}"/></td>

                            </c:if>


                            <c:if test="${i==2}">
                                <td align="right" class="text" widtd="500"><c:out value="${MCM[i][j]}"/></td>
                            </c:if>





                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <br><br>
        <table align="center">
            <tr>
                <td>
                    <c:forEach var="r" items="${dicecciones}">
                        <img src="imagenes/porcentajes_pr/<c:out value="${r}"/>" widtd="400" height="150">
                    </c:forEach>
                </td>
            </tr>
        </table>
         <br>
            <div align="right">
              <input type="submit" name="Submit" value="Imprimir" onclick="window.print();">
            </div>

            

    </body>
</html>