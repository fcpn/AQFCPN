<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Most </title>
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

<form name="form1" method="post" action="<c:url value="/ModIng2.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#BAAD74" >
        <td colspan="2" ><div align="center" class="Estilo4">Modificar Ingresos </div></td>
    </tr>
    <tr >
        <td width="238" >Actividad -- <c:out value="${actividad.descripcion}"/> </td>
        <td width="269" >Tarea-- <c:out value="${tarea.descripcion}"/> </td>
    </tr>
</table>
<br>
<br>

<table width="871" border="1" align="left" bordercolor="#CC9933">
<tr>
    <td>-</td>
    <td width="138" > - Fuente Econ&oacute;mica </td>
    
    <td>&nbsp;Presupuestado<!---Ultimo # de comprobante--></td>
    <td> Ejecutado___ <!--monto insertando --></td> 
    </tr>

<!-- Elige la tarea para mostrala -->
	

<!--  funciona   -->                        

<tr>


<td> 
    
    <select name="codigo">
        
        <c:forEach var="g" items="${rubros}">                                                            
            <c:if test="${g.tipo == '1'}">
                
                <c:if test="${g.codigo == codmoning}">  
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>" selected><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>  
                <c:if test="${g.codigo != codmoning}">  
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>" ><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                
                
                <!-- <input type=hidden name=tipo value='<c:out value="${g.tipo}"/>'>-->
            </c:if>
            <c:if test="${g.tipo == '2'}">
                
                
                <c:if test="${g.codigo == codmoning}">
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>" selected>&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                <c:if test="${g.codigo != codmoning}">
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>">&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                
                
            </c:if>
            <c:if test="${g.tipo == '3'}">
                
                <c:if test="${g.codigo == codmoning}">
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>" selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                
                <c:if test="${g.codigo != codmoning}">
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                
                
                
            </c:if>                                                           
        </c:forEach>             
        
    </select>
    
    
    
</td>


<td>
    
    <select name="codfueneco2">
        
        <c:forEach var="fe" items="${fuente}">
            <c:if test="${fe.codfueneco == codfueneco}">
                <option value="<c:out value="${fe.codfueneco}"/>" selected><c:out value="${fe.codfueneco}"/> - <c:out value="${fe.descripcion}"/></option>
            </c:if>
            <c:if test="${fe.codfueneco != codfueneco}">
                <option value="<c:out value="${fe.codfueneco}"/>"><c:out value="${fe.codfueneco}"/> - <c:out value="${fe.descripcion}"/></option>
            </c:if>
        </c:forEach>                                                         
        
        <!-- llevando los parametros   -->
                                                        
                                                        
    </select>
    
    
</td>

<td>
    
    <input name="monpre" type="text" id="monpre" value="<c:out value="${montos.montopresu}"/>">
    <!--<div align="right">&nbsp;<c:out value="${montos.montopresu}"/>                  comprocompro-->
    
</div></td>
<td>
    
    <div align="right">
        &nbsp;<c:out value="${montos.montoeje}"/>       
        <!--UltiMonInser <input name="moneje" type="text" id="monpre" value="<c:out value="${montos.montoeje}"/>">      -->
</div></td>
</tr>







<!--Montos No presupuestados -->

<tr>
    <td colspan="4"> </td>
    </tr>
<!--
<c:forEach var="moo" items="${montos_ref}">
   
   
    <tr>
        <td>&nbsp;</td>  
        <td><div align="right">
          <input name="monacumulado" type="text" id="monacumulado" value="<c:out value="${moo.monacumulado}"/>" >  
           </div></td>
        <td><div align="right">
          <input name="comprobante" type="text" id="comprobante" value="<c:out value="${moo.comprobante}"/>">
          </div></td>
        <td><div align="right">
          <input name="fecha" type="text" id="fecha" value="<c:out value="${moo.fecha}"/>">
                    
        </div></td>
        <td><div align="right">
          <input name="observaciones" type="text" id="observaciones" value="<c:out value="${moo.observaciones}"/>">
          </div></td>
        <td>&nbsp;</td>
    </tr>
    
    
</c:forEach> 
-->
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->

<tr>
    <td></td>
    <td width="138">   </td>
    
    
    <td>
</td>
    <td> <!--monto insertando -->
      <div align="center">
        <input type="submit" name="Submit" value="Cambiar datos">      
      </div>
      <div align="right"></div></td>
    </tr>
<tr>
    <td></td>
    <td> </td>
    <td></td>
    <td><div align="right"> 
            <!--UltiMonInser-->
    </div></td>
    </tr>

<!--FIN FIN TOTALES suma -->







<tr >
    <td colspan="2" >  </td>
    <td ></td>
    <td ><div align="center">
        
        <a href=<c:url value="/modclasificador.do">            
                     
       </c:url>><strong>Salir Cambios</strong></a>
        
         
    </div></td>
    </tr>


<tr bgcolor="#BAAD74">
    <td height="19" colspan="4"><div align="right"></div></td>
</tr>
</table>


<input type=hidden name=codmoning value='<c:out value="${codmoning}"/>'>
<input type=hidden name=codfueneco value='<c:out value="${codfueneco}"/>'>

<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>

<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
<input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>
<input type=hidden name="moneje" value='<c:out value="${montos.montoeje}"/>'>

</form>
<p>&nbsp;</p>
</body>
</html>