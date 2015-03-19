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

.Estilo23 {
	font-size: 15px;
	font-weight: bold;
	font-family: Geneva, Arial, Helvetica, sans-serif;
	color: #FFFFFF;
	text-align: left;
}
            -->
        </style>
    </head>
<body>
        <p>&nbsp;</p>

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
            <tr bgcolor="#003366">
                <td colspan="4" class="Estilo27"><span class="Estilo23">Datos Anteriores</span></td>
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

                <td width="144">
                    <div align="center">
                        <c:out value="${mon_acu}"/>
                    </div>
                </td>
                <td>
                <div align="center">
                   <c:out value="${comprobante}"/>
                </div>
                </td>
                <td>
                    <div align="center">
                            <c:out value="${fecharef}"/>
                    </div>
                </td>
                <td>
                  <div align="center">
                    <c:out value="${obs}"/>
                  </div>
                  </td>
            </tr>

            <tr bgcolor="#003366">

                <td colspan="4">&nbsp;</td>
          </tr>
</table>
        <br>
        <br>
<table width="604" border="1" align="center" bordercolor="#990000">
          <tr bgcolor="#003366">
            <td colspan="4" bgcolor="#003366" class="Estilo27"><span class="Estilo23">Datos Nuevos</span></td>
          </tr>
          <tr bgcolor="#003366">
            <td colspan="2" bgcolor="#003366" class="Estilo27">Partida</td>
            <td colspan="2" bgcolor="#003366" class="Estilo25"><!--monto insertando -->
              <span class="Estilo27">Fuente económica</span></td>
          </tr>
          <tr >
            <td colspan="2"><div align="center"><c:out value="${monniing.codmonnopreing}"/> - <c:out value="${descla}"/> </div></td>
            <td colspan="2"><!--monto insertando -->
              <div align="center"><c:out value="${monniing.codfueneco}"/></div></td>
          </tr>
          <tr bgcolor="#003366">
            <td width="144" bgcolor="#993300" class="Estilo27">Monto Acumulado </td>
            <td width="144" bgcolor="#993300" class="Estilo27">Comprobante</td>
            <td width="144" bgcolor="#993300" class="Estilo25"><!--monto insertando -->
              <span class="Estilo27">Fecha de ejecución</span></td>
            <td width="144" bgcolor="#993300" class="Estilo27">Glosa</td>
          </tr>
          <tr >
            <td width="144"><div align="center">
              <c:out value="${monniing.mon_acu}"/>
            </div></td>
            <td><div align="center">
              <c:out value="${monniing.comprobante}"/>
            </div></td>
            <td><div align="center">
              <c:out value="${monniing.fecharef}"/>
            </div></td>
            <td><div align="center">
              <c:out value="${monniing.obs}"/>
            </div></td>
          </tr>
          <tr bgcolor="#003366">
            <td colspan="4" bgcolor="#003366">&nbsp;</td>
          </tr>
        </table><br>
<br>


<div align="rigth">
<a href=<c:url value="/ModClasificador1.do">
                       <c:param name="codtar" value="${codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>

   </c:url>><h6>Nueva Modificaci&oacute;n</h6>
              </a>
</div>
</body>
</html>
