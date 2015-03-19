<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Re sultado de los incrementos </title>
        <style type="text/css">
            <!--
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {color: #FFFFFF}
.Estilo6 {color: #FFFFFF; font-weight: bold; font-size: 24px; }
.Estilo10 {
	font-size: 10px;
	font-weight: bold;
}
.Estilo11 {font-family: Verdana, Arial, Helvetica, sans-serif}
.Estilo12 {font-size: 10px; font-weight: bold; font-family: Verdana, Arial, Helvetica, sans-serif; }
            -->
        </style>
		
		
		
		
 
    </head>
    <body>
        <table width="668" border="0" align="center">
          <tr>
            <td>			 <p align="center">&nbsp;</p>
       
              <div align="center">
              <table width="523" border="1" align="center" bordercolor="#CC9933">
                  <tr bgcolor="#5B532D" >
                    <td colspan="2" ><div align="center" class="Estilo6">Incremento de Montos Presupuestados <br>
                      -Ingresos-                    </div></td>
                </tr>
                  <tr bgcolor="#E6E6E6" >
                      <td width="238" ><div align="center" class="Estilo10 Estilo11">Actividad</div></td>
                      <td width="269" ><div align="center" class="Estilo12">Tarea</div></td>
                  </tr>
                  <tr >
                    <td ><div align="justify"> <c:out value="${actividad.descripcion}"/> </div></td>
                    <td ><div align="justify"><c:out value="${tarea.descripcion}"/> </div></td>
                  </tr>
              </table>
              <br>
              <br>
              <br>
              <br>
              <table width="523" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#BAAD74" >
                  <td width="507" bgcolor="#5B532D" ><div align="center" class="Estilo4 Estilo5">Antes del Incremento</div></td>
                </tr>
              </table>
              <table width="523" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#BAAD74" >
                  <td colspan="4" ><div align="center" class="Estilo4">
                    <div align="left">Cuenta </div>
                  </div></td>
                </tr>
                <tr bgcolor="#E6E6E6" class="Estilo12" >
                  <td width="238" bgcolor="#E6E6E6" >Clasificador</td>
                  <td width="269" >Fuente Econ&oacute;mica </td>
                  <td width="269" >Monto Presupuestado </td>
                  <td width="269" >Monto a incrementar</td>
                </tr>
                <tr >
                  <td ><c:out value="${codmoning}"/> - <c:out value="${des_ref1}"/></td>
                  <td ><c:out value="${codfueneco}"/> - <c:out value="${des.descripcion}"/></td>
                  <td ><div align="right"><c:out value="${monto}"/></div></td>
                  <td ><div align="right"><c:out value="${monsum}"/></div></td>
                </tr>
              </table>
              <br>
              <br>
              <br>
              <br>
              <table width="523" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#BAAD74" >
                  <td width="507" bgcolor="#5B532D" ><div align="center" class="Estilo4 Estilo5">Resultado del Incremento</div></td>
                </tr>
              </table>
              <table width="523" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#BAAD74" >
                  <td colspan="4" ><div align="center" class="Estilo4">
                      <div align="left">Cuenta</div>
                  </div></td>
                </tr>
                <tr bgcolor="#BAAD74" >
                  <td bgcolor="#E6E6E6" class="Estilo12" > Fuente Econ&oacute;mica </td>
                  <td colspan="3" bgcolor="#E6E6E6" ><div align="center"><c:out value="${vu[2]}"/> - <c:out value="${vu[3]}"/></div></td>
                </tr>
                <tr bgcolor="#E6E6E6" class="Estilo12" >
                  <td width="118" bgcolor="#E6E6E6" >Clasificador</td>
                  <td width="143" >Monto Presupuestado </td>
                  <td width="123" >Monto Ejecutado </td>
                  <td width="111" > Saldo</td>
                </tr>
                <tr >
                  <td ><c:out value="${vu[0]}"/> - <c:out value="${vu[1]}"/></td>
                  <td ><div align="right"><c:out value="${vu[4]}"/></div></td>
                  <td ><div align="right"><c:out value="${vu[5]}"/></div></td>
                  <td ><div align="right"><c:out value="${vu[6]}"/></div></td>
                </tr>
              </table>
              <!-- mostrando datos generales -->
  
            <!-- FIN FIN FIN mostrando datos generales -->
              <br>
              <table width="516" border="1" bordercolor="#000066" bgcolor="#FFFFFF">
                <tr bgcolor="#000066">
                  <td width="268" bgcolor="#FFFFFF">
                     
                           <a href=<c:url value="/IncrIng.do">            
                          <c:param name="codfueneco" value="${codfueneco}"/>
                          </c:url>>
                  <h6 align="center"> Nuevo Incremento en la misma Fuente </h6> </a>              </td>
                  
                  <td width="238" bgcolor="#FFFFFF">
                          <div align="right"><a href="javascript:cerrarse('')">cerrar ventana</a></div>                
                </td>
                
                </tr>
              </table>
              <br>
</div>              </td>
          </tr>
    </table>
       
 <form> 
 
</form>

	   
    </body>
</html>