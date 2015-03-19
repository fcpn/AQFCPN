<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title> - </title>
        <style type="text/css">
            <!--
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {color: #FFFFFF}
.Estilo6 {font-size: 10px}
.Estilo7 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
}
.Estilo8 {
	font-size: 10px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
}
            -->
        </style>
    </head>
    <body>
        <p>&nbsp;</p>
        
        <form name="form1" method="post" action="<c:url value="/IncrEgr4.do"/>">
            <table width="523" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#37321C" >
                  <td colspan="2" ><div align="center" class="Estilo4 Estilo5">Incremento de Montos [Egresos] </div></td>
              </tr>
                <tr bgcolor="#E6E6E6" >
                    <td width="238" ><div align="center" class="Estilo6 Estilo7">Actividad </div></td>
                    <td width="269" ><div align="center" class="Estilo8">Tarea </div></td>
                </tr>
                <tr >
                  <td ><div align="justify">  <c:out value="${actividad.descripcion}"/></div></td>
                  <td ><div align="justify"><c:out value="${tarea.descripcion}"/></div></td>
                </tr>
            </table>

            <!-- mostrando datos generales -->

            <!-- FIN FIN FIN mostrando datos generales -->
            <br>
            <br>
            <br>
            <table width="861" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#37321C" >
                  <td colspan="6" ><div align="center" class="Estilo4 Estilo5">Cuenta a Incrementar monto </div></td>
              </tr>
                <tr bgcolor="#E6E6E6" >
                    <td width="242" ><span class="Estilo8">Clasificador</span></td>
                    <td width="260" ><span class="Estilo8">Fuente Economica </span></td>
                    <td width="162" ><span class="Estilo8">Monto presupuestado </span></td>
                    <td colspan="3" ><div align="center"><span class="Estilo8">Monto a incrementar </span></div></td>
                </tr>
                <tr >
                    <td height="29" ><c:out value="${codmonegr}"/> - <c:out value="${des_ref1}"/></td>
                    <td ><c:out value="${codfueneco}"/> - <c:out value="${des.descripcion}"/></td>
                <td ><div align="right"> <c:out value="${monto}"/></div></td>
                    <td colspan="3" bgcolor="#EBE7D6" ><div align="right">
                            <input name="monsum" type="text" id="monsum">
                    </div></td>
                </tr>
                <tr bgcolor="#837843" >
                    <td colspan="6" >&nbsp;</td>
                </tr>
                <tr bgcolor="#E6E6E6" class="Estilo8" >
                    <td colspan="3" bgcolor="#E6E6E6" ><div align="center"><strong>Glosa</strong></div></td>
                    <td colspan="3" ><div align="left"><strong>Fecha (## / ## / ##)</strong></div></td>
                </tr>
                <tr bgcolor="#EBE7D6" >
                    <td height="37" colspan="3" rowspan="2" bgcolor="#EBE7D6" ><input name="glosa" type="text" id="glosa" size="110"></td>
                    <td width="37" ><div align="center">
                      <input name="dia" type="text" id="dia" size="2" maxlength="2">
                    </div></td>
                    <td width="52" ><div align="center">
                      <input name="mes" type="text" id="mes" size="2" maxlength="2">
                    </div></td>
                    <td width="68" ><div align="center">
                      <input name="ani" type="text" id="ani" size="2" maxlength="2">
                    </div></td>
                </tr>
                <tr bgcolor="#EBE7D6" >
                  <td class="Estilo8" ><div align="center">D&iacute;a</div></td>
                  <td class="Estilo8" ><div align="center">Mes</div></td>
                  <td class="Estilo8" ><div align="center">A&ntilde;o</div></td>
                </tr>
                <tr bgcolor="#837843" >
                    <td height="29" colspan="6" >&nbsp;</td>
                </tr>
                <tr class="Estilo8" >
                    <td colspan="2" bgcolor="#E6E6E6" >Comprobante  </td>
                    <td colspan="4" rowspan="2" bgcolor="#E6E6E6" ><div align="right">
                    </div>                      <div align="right">
                      </div></td>
                </tr>
                <tr >
                  <td height="26" colspan="2" bgcolor="#EBE7D6" ><input name="cbte" type="text" id="cbte"></td>
                </tr>
                <tr bgcolor="#837843" >
                  <td height="8" ></td>
                  <td ></td>
                  <td ></td>
                  <td colspan="3" ></td>
                </tr>
                <tr >
                  <td ></td>
                  <td ></td>
                  <td ><div align="right">
                    <input type="reset" name="Submit2" value="Cancelar">
                  </div></td>
                  <td colspan="3" ><div align="right">
                    <input type="submit" name="Submit" value="Aceptar">
                  </div></td>
                </tr>
            </table>
            <br>
            <br>
            
            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
            
            <input type=hidden name=codmonegr value='<c:out value="${codmonegr}"/>'>
         
            <input type=hidden name=codfueneco value='<c:out value="${codfueneco}"/>'>
       
            <input type=hidden name=monto value='<c:out value="${monto}"/>'>
            
            <input type=hidden name=ref1 value='<c:out value="${ref1}"/>'>
        
            
        </form>
        
        
        
        <p>&nbsp;</p>
        
        
        <div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
        <p></p>
        <div align="right"><a href="javascript:cerrarse('')">cerrar ventana</a></div>
    </body>
</html>