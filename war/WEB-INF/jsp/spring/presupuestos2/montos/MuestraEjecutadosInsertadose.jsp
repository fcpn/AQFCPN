<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Mostrando los montos presupuestados</title>
        <style type="text/css">
            <!--
.Estilo2 {color: #FFCC00}
.Estilo3 {color: #003399}
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
            -->
        </style>
    </head>
    <body>
        <p>&nbsp;</p>
        
        <form name="form1" method="post" action=" <c:url value="Ejecutados_ingresose.do"/>"  ">
              <table width="523" border="1" align="center" bordercolor="#CC9933">
                <tr bgcolor="#BAAD74" >
                    <td colspan="2" ><div align="center" class="Estilo4">Montos Ejecutados Egreso</div></td>
                </tr>
                <tr >
                    <td width="238" >Actividad -- <c:out value="${actividad.descripcion}"/> </td>
                    <td width="269" >Tarea-- <c:out value="${tarea.descripcion}"/>   </td>
                </tr>
    </table>
            <br>
            <br>
            <table width="542" border="1" align="center" bordercolor="#CC9933">
                
                <c:forEach var="mo" items="${mosmoneje}">  
                    
                    <c:if test="${mo.moneje != '0'}"> 
                        <!-- Elige la tarea para mostrala -->
                        <c:if test="${mo.codtar==tarea.codtar }">
                            <!--  funciona   -->                        
                            <tr>
                                <td>-Clasificador</td>
                                <td> - fuente economica  </td>
                                
                                
                                <td>&nbsp;Presupuestado<!---Ultimo # de comprobante--></td>
                                <td> Ejecutado <!--monto insertando --></td>
                                
                                
                                
                            </tr>
                            <tr>
                                <td><c:out value="${mo.codmoning}"/> <c:out value="${mo.descla}"/></td>
                                <td><c:out value="${mo.codfueneco}"/></td>
                                <td><c:out value="${mo.monto}"/></td>
                                <td><c:out value="${mo.moneje}"/></td>
                            </tr>
                </c:if>                </c:if> 
                    
                </c:forEach>    
                
                
                
                
                
                
                
                <tr >
                    <td colspan="2" > <span class="Estilo2">Guardado!!!</span>   </td>
                    <td >&nbsp;</td>
                    <td >&nbsp;</td>
                </tr>
                
                <tr>
                    <td width="117" height="39"></td>
                    <td width="230"><input type="submit" name="Submit2" value="Agregar nuevo monto ejecutado"></td>
                    <td width="173">&nbsp;</td>
                    <td width="173">&nbsp;</td>
                </tr>
                <tr bgcolor="#BAAD74">
                    <td height="19" colspan="4"><div align="right"><span class="Estilo3"><!--[Salir a Men&uacute; Principal] --></span></div></td>
                </tr>
                
                
                
                
                
            </table>
            
            
            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
            
            
            
        </form>
        <p>&nbsp;</p>
    </body>
</html>