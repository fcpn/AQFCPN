<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Most </title>
        <style type="text/css">
            <!--
.Estilo25 {font-size: 10px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo26 {color: #FFFFFF}
.Estilo27 {font-size: 10px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; color: #FFFFFF; }
            -->
        </style>
    </head>
<body>
        <p>&nbsp;</p>

<form name="form1" method="post" onsubmit="return confirm('¿Esta seguro de los cambios?')" action="<c:url value="/ModRefNoPre.do"/>">
            <table width="523" border="1" align="center" bordercolor="#990000">
                <tr bgcolor="#003366" >
                  <td colspan="2" ><div align="center" class="Estilo4 Estilo26">Modificar Ingresos </div></td>
              </tr>
                <tr >
                  <td width="238" class="Estilo25" >Actividad: <c:out value="${actividad.descripcion}"/> </td>
                  <td width="269" class="Estilo25">Tarea: <c:out value="${tarea.descripcion}"/> </td>
                </tr>
    </table>
        <br>
            <br>

        <table width="604" border="1" align="center" bordercolor="#990000">


            <!-- Elige la tarea para mostrala -->


            <!--  funciona   -->









            <!--Montos No presupuestados -->



            <tr bgcolor="#003366">
                <td colspan="4" class="Estilo27">Modificar Referencia </td>
          </tr>
   <tr bgcolor="#003366">
                    <td colspan="2" class="Estilo27">Partida</td>

                  <td colspan="2" class="Estilo25"> <!--monto insertando -->
                <span class="Estilo27">Fuente económica</span></td>
            </tr>


            <tr bgcolor="#CCCCCC">

                <td colspan="2"><div align="center"><c:out value="${monniing.codmonnopreing}"/> - <c:out value="${descla}"/> </div></td>

                <td colspan="2"> <!--monto insertando -->
                    <div align="center"><c:out value="${monniing.codfueneco}"/></div></td>
            </tr>

            <tr bgcolor="#003366">
                <td width="144" class="Estilo27">Monto Acumulado </td>


              <td width="144" class="Estilo27">Comprobante</td>
                <td width="144" class="Estilo25"> <!--monto insertando -->
              <span class="Estilo27">Fecha de ejecución</span></td>
                <td width="144" class="Estilo27">Glosa</td>
            </tr>


            <tr bgcolor="#CCCCCC">

                <td width="144"><div align="center">
                        <input name="mon_acu2" type="text" id="mon_acu2" value="<c:out value="${monniing.mon_acu}"/>">
              </div></td>


                <td><div align="center">
                        <input name="comprobante2" type="text" id="comprobante2" value="<c:out value="${monniing.comprobante}"/>">
              </div></td>
                <td> <!--monto insertando -->
                    <div align="center">
                        <input name="fecharef2" type="text" id="fecharef2" value="<c:out value="${monniing.fecharef}"/>">
              </div></td>
                <td><div align="center">
                        <input name="observaciones2" type="text" id="obs2" value="<c:out value="${monniing.obs}"/>">
              </div></td>
            </tr>

            <tr bgcolor="#003366">

                <td colspan="4">&nbsp;</td>
          </tr>



            <tr>

                <td width="144">   </td>


                <td>
                </td>
                <td>
                </td>
                <td><input type="submit" name="Submit" value="Cambiar datos"></td>
            </tr>
            <tr>

                <td> </td>
                <td></td>
                <td></td>
                  <td width="144" >
                    <a href=<c:url value="/modclasificador.do">

                    </c:url>><strong>Salir Cambios</strong></a>

                </td>
            </tr>


            <tr bgcolor="#990000">
              <td height="2" colspan="5"></td>
            </tr>
</table>



            <input type=hidden name=codmonnopreing value='<c:out value="${monniing.codmonnopreing}"/>'>
            <input type=hidden name=descla value='<c:out value="${descla}"/>'>
            <input type=hidden name=codfueneco value='<c:out value="${monniing.codfueneco}"/>'>
            <input type=hidden name=codtar value='<c:out value="${monniing.codtar}"/>'>
            <input type=hidden name=idd value='<c:out value="${monniing.idd}"/>'>
            <input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
            <input type=hidden name=mon_acu value='<c:out value="${monniing.mon_acu}"/>'>
            <input type=hidden name=obs value='<c:out value="${monniing.obs}"/>'>
            <input type=hidden name=fecharef value='<c:out value="${monniing.fecharef}"/>'>
            <input type=hidden name=comprobante value='<c:out value="${monniing.comprobante}"/>'>


        </form>

</body>
</html>
