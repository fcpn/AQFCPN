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
        
        <form name="form1" method="post" action=" <c:url value="Presupuestado_ingresose.do"/>" ">
              <table width="523" border="1" align="left" bordercolor="#CC9933">
                <tr bgcolor="#BAAD74" >
                    <td colspan="2" ><div align="center" class="Estilo4">Montos Presupuestados Egresos</div></td>
                </tr>
                <tr >
                    <td width="238" >Actividad -- <c:out value="${actividad.descripcion}"/> </td>
                    <td width="269" >Tarea-- <c:out value="${tarea.descripcion}"/> </td>
                </tr>
            </table>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <table width="523" border="1" align="left" bordercolor="#CC9933">
                <tr>
                    <td>Clasificador</td>
                    <td>Fuente Econ&oacute;mica  </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <c:forEach var="mo" items="${mosmoning}">  
                    
                    <!-- Elige la tarea para mostrala -->
                    <c:if test="${mo.codtar==tarea.codtar}">
                    <!--  funciona   -->                        
                       
                    <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
                    <td><c:out value="${mo.codfueneco}"/> - <c:out value="${mo.desfe}"/> </td>
                    <td><c:out value="${mo.monto}"/></td>
                </tr>
                
                
                
                
                
                
                </c:if>  
                
                </c:forEach>    
                
                
                
                
                
                
                
                <tr >
                    <td >&nbsp; </td>
                    <td >&nbsp;  </td>                    
                    <td >&nbsp;</td>
                </tr>
                
                <tr>
                    <td width="216" height="39"></td>
                    <td width="298"><input type="submit" name="Submit2" value="Agregar nuevo monto presupuestado "></td>
                    <td width="298">&nbsp;</td>
                </tr>
                <tr bgcolor="#BAAD74">
                    <td height="19" colspan="3"><div align="right"><span class="Estilo3"> </span></div></td>
                </tr>
                
            </table>
            
            
            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
        </form>
        <p>&nbsp;</p>
    </body>
</html>