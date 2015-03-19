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

<form name="form1" method="post" action="  ">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#BAAD74" >
        <td colspan="2" ><div align="center" class="Estilo4">Montos Modificados Ingresos </div></td>
    </tr>
    <tr >
        <td width="238" >Actividad -- <c:out value="${desact}"/> </td>
        <td width="269" >Tarea-- <c:out value="${destar}"/> </td>
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
    <td> Saldo___ <!--monto insertando --></td> 
    </tr>

<!-- Elige la tarea para mostrala -->
	

<!--  funciona   -->                        

<tr>


<td> 
    
    <c:out value="${codmoning2}"/> - <c:out value="${descla}"/>
    
</td>


<td>
    
    <c:out value="${fuente.codfueneco}"/> - <c:out value="${fuente.descripcion}"/>
    
</td>

<td>
    
    <c:out value="${monpre}"/>
    <!--<div align="right">&nbsp;<c:out value="${montopresu}"/>                  comprocompro-->
    
</td>
<td>
    <c:out value="${moneje}"/>
        <!--UltiMonInser-->
</td>


<td>
    <c:out value="${monpre-moneje}"/>
        <!--UltiMonInser-->
</td>

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
                     
       </c:url>><strong>Salir </strong></a>
        
         
    </div></td>
    </tr>


<tr bgcolor="#BAAD74">
    <td height="19" colspan="4"><div align="right"></div></td>
</tr>
</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>

<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
<input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>


</form>
<p>&nbsp;</p>
</body>
</html>