<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Mostrando los montos presupuestados</title>
        <style type="text/css">
            <!--
.Estilo2 {color: #FFCC00}
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo7 {color: #2A3399}
            -->
        </style>
    </head>
    <body>
        <p>&nbsp;</p>
        
        <form name="form1" method="post" action=" <c:url value="Presupuestado_ingresos.do"/>"  ">
              <table width="523" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#BAAD74" >
                    <td colspan="2" ><div align="center" class="Estilo4">Montos Presupuestados </div></td>
                </tr>
                <tr >
                    <td width="238" >Actividad -- <c:out value="${actividad.descripcion}"/> </td>
                    <td width="269" >Tarea-- <c:out value="${tarea.descripcion}"/>  </td>
                </tr>
    </table>
            <br>
            <br>
            <br>
            <table width="523" border="1" align="center" bordercolor="#CC9933">
                
                <tr bgcolor="#E4E0C9">
                            <td><span class="Estilo7">Clasificador</span></td>
                            <td><span class="Estilo7">Fuente Econ&oacute;mica</span></td>
                            <td><span class="Estilo7">Monto Presupuestado</span></td>
                        </tr>
				<c:forEach var="mo" items="${mosmoning}">  
                    
                    <!-- Elige la tarea para mostrala -->
                    
					<c:if test="${mo.codtar==tarea.codtar}">
                        <!--  funciona   -->                        
                        
                        <tr>
                            <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
                            <td><c:out value="${mo.codfueneco}"/> -  <c:out value="${mo.desfe}"/> </td>
                            <td><div align="right"><c:out value="${mo.monto}"/></div></td>
                        </tr>
                        
                        
                        
                        
                        
                        
                    </c:if>  
                    
                </c:forEach>    
                
                
                
                
                
                
                
                <tr >
                    <td > <span class="Estilo2">Guardado Exitoso!!!</span> </td>
                    <td >&nbsp;  </td>                    
                    <td ><div align="right"></div></td>
                </tr>
                
                <tr>
                    <td width="216" height="39"></td>
                    <td width="298"><input type="submit" name="Submit2" value="Agregar nuevo monto presupuestado "></td>
                    <td width="298">&nbsp;</td>
                </tr>
                <tr bgcolor="#BAAD74">
                    <td height="19" colspan="3"><div align="right"></div></td>
                </tr>
                
                
                
                
                
            </table>
            
            
            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
            
            
            
            
        </form>
        <p>&nbsp;</p>
    </body>
</html>