<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Mostrando los montos presupuestados</title>
        <style type="text/css">
            <!--
.Estilo2 {
	color: #FFCC00;
	font-weight: bold;
}
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {color: #FFFFFF}
.Estilo8 {font-family: Verdana, Arial, Helvetica, sans-serif; font-weight: bold; font-size: 10px; }
.Estilo13 {font-size: 10}
.Estilo14 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
}
.Estilo16 {color: #FFFFFF; font-weight: bold; }
.Estilo19 {font-size: 14px}
            -->
        </style>
    </head>
    <body>
        <p>&nbsp;</p>

        <form name="form1" method="post" action="  ">
            <table width="523" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#372500" >
                    <td colspan="2" ><div align="center" class="Estilo4 Estilo5">Informe Ingresos <br>
                    Referencia no presupuestados </div></td>
                </tr>
                <tr bgcolor="#CCCCCC" >
                    <td width="238" ><div align="center"><strong>Actividad</strong></div></td>
                    <td width="269" ><div align="center"><strong>Tarea</strong></div></td>
                </tr>
                <tr >
                    <td ><c:out value="${actividad.descripcion}"/></td>
                    <td ><c:out value="${tarea.descripcion}"/></td>
                </tr>
            </table>
            <br>
            <br>









            <table width="871" border="1" align="center" bordercolor="#CC9933">
                <c:if test="${supe==1 }">
                    <tr bgcolor="#EBEBEB">
                        <td colspan="3" bgcolor="#EBEBEB"><div align="left" class="Estilo8 Estilo13 Estilo14"><span class="Estilo19"><c:out value="${sup.descripcion}"/></span></div> </td>
                        <td ></td>
                        <td ></td>
                    </tr>
                </c:if>
                <tr bgcolor="#BFBFBF">
                    <td><span class="Estilo8">Partida</span></td>
                    <td width="138" ><span class="Estilo8"> - Fuente Econ&oacute;mica </span></td>

                    <td><span class="Estilo8">&nbsp;Presupuestado
                            <!---Ultimo # de comprobante-->
                    </span></td>
                    <td><span class="Estilo8"> Ejecutado___
                            <!--monto insertando -->
                    </span></td>
                    <td><span class="Estilo8">Saldo___</span></td>

                </tr>

                <!-- Elige la tarea para mostrala -->


                <!--  funciona   -->

                <tr>
                    <td><c:out value="${codmonnopreing}"/> - <c:out value="${descla}"/> </td>
                    <td><c:out value="${codfueneco}"/> - </td>

                    <td><div align="right">&nbsp;-                  <!--comprocompro-->
                    </div></td>
                    <td><div align="right">&nbsp;<c:out value="${monejenopre}"/>                  <!--UltiMonInser-->
                    </div></td>
                    <td><div align="right">&nbsp;- </div></td>

                </tr>


<tr bgcolor="#CCCCCC">
    <td colspan="5" class="Estilo8">Saldo inicial</td>
</tr>



<tr bgcolor="#CCCCCC">
    <td width="138"><div align="center" class="Estilo14"><strong>Monto Acumulado </strong></div></td>


    <td><span class="Estilo14"><strong>&nbsp;
        <!---Ultimo # de comprobante-->
Comprobante
    </strong> </span>      <div align="right" class="Estilo14"></div></td>
    <td> <span class="Estilo14"><strong>&nbsp;
        <!--monto insertando -->
      Fecha de Ejecuci&oacute;n </strong> </span>      <div align="right" class="Estilo14"></div></td>



    <td><div align="center" class="Estilo14"><strong>Observaciones&nbsp;</strong></div></td>

</tr>





<tr>
     <td bgcolor="#EBEBEB" ><div align="right"> <fmt:formatNumber  value="${salini.saldo_ej_i}" pattern="#,###,###,##0.00"/>   </div></td>
        <td bgcolor="#EBEBEB"><div align="right"><c:out value="${salini.comprobante}"/> </div></td>
        <td bgcolor="#EBEBEB"><div align="right"> <c:out value="${salini.fecha_saldo}"/>           <!--UltiMonInser-->
      </div></td>
        <td bgcolor="#EBEBEB"><div align="right"> <c:out value="${salini.glosa_s}"/></div></td>

</tr>






                <!--Montos No presupuestados -->
                <tr bgcolor="#5B5B5B" >
                <td colspan="5" ><span class="Estilo2 Estilo5"><span class="Estilo16">Historial del monto Ejecutado </span></span></td>


           </tr>

                <c:forEach var="moo" items="${montos_ref}">
                    <!-- Elige la tarea para mostrala -->

              <tr>

                        <td><div align="right">  <c:out value="${moo.mon_acu}"/> </div></td>
                        <td><div align="right"> <c:out value="${moo.comprobante}"/></div></td>
                        <td><div align="right"><c:out value="${moo.fecharef}"/>           <!--UltiMonInser-->
                        </div></td>
                        <td><div align="right"><c:out value="${moo.obs}"/></div></td>

              </tr>


                </c:forEach>
                <!--FINFIN Montos No presupuestados -->

                <!--TOTALES suma -->

                <tr>




                    <td colspan="5">&nbsp;   </td>
                </tr>


                <!--FIN FIN TOTALES suma -->


                <tr bgcolor="#BAAD74">
                    <td height="19" colspan="6"><div align="right"></div></td>
                </tr>
            </table>


            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



        </form>
        <div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
        <p></p>
        <div align="right"><a href="javascript:cerrarse('')">cerrar ventana</a></div>
        <p>&nbsp;</p>


    </body>
</html>