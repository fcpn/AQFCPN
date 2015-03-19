<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Mostrando los montos presupuestados</title>
    <style type="text/css">
        <!--
.Estilo3 {color: #003399}
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo7 {color: #000000; font-weight: bold; }
            -->
    </style>
</head>
<body>          
<p>&nbsp;</p>

<form name="form1" method="post" action="<c:url value="/InsCom.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#BAAD74" >
        <td colspan="2" ><div align="center" class="Estilo4">Montos Comprometidos Egresos </div></td>
    </tr>
    <tr bgcolor="#DED8BC" >
        <td width="238" ><div align="center"><strong>Actividad </strong></div></td>
        
        <td width="269" ><div align="center"><strong>Tarea </strong></div></td>

    </tr>
	
	
	
	<tr >
        <td width="238" ><strong> <c:out value="${actividad.descripcion}"/> </strong></td>
        <input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>
        <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
        <td width="269"><strong> <c:out value="${tarea.descripcion}"/> </strong> </td>
        <input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>
        <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
    </tr>
</table>

<!-- mostrando datos generales -->

 <table width="630" border="1" align="center" bordercolor="#CC9933">
    <c:forEach var="grl" items="${grl}">
      <c:if test="${grl.codtar==tarea.codtar }">
        <tr>
      <td width="192" bgcolor="#F5E7B4">Identificacion de la Funci&oacute;n </td>
      <td colspan="5"> <c:out value="${grl.funcion}"/> </td>
    </tr>
    <tr>
      <td bgcolor="#F5E7B4">Responsable</td>
      <td colspan="5"><c:out value="${grl.nom}"/> <c:out value="${grl.ap}"/> <c:out value="${grl.am}"/></td>
    </tr>
    <tr>
      <td bgcolor="#F5E7B4">Cargo del Responsable</td>
      <td colspan="2"><c:out value="${grl.cargo}"/></td>
      <td width="95" bgcolor="#F5E7B4">Carga horaria </td>
      <td colspan="2"><c:out value="${grl.cargah}"/></td>
    </tr>
    <tr>
      <td bgcolor="#F5E7B4">Objetivo</td>
      <td colspan="5"><c:out value="${grl.objetivo}"/></td>
    </tr>
    <tr>
      <td bgcolor="#F5E7B4">Fecha de inicio </td>
      <td colspan="2"><c:out value="${grl.fechai}"/></td>
      <td bgcolor="#F5E7B4">Fecha Final </td>
      <td colspan="2"><c:out value="${grl.fechaf}"/></td>
    </tr>
    <tr>
      <td height="23" colspan="6">&nbsp;</td>
    </tr>
    <tr>
      <td height="23" colspan="6">&nbsp;</td>
    </tr>
    <tr>
      <td height="23" bgcolor="#F5E7B4">#  de Participantes </td>
      <td width="42" height="23"><div align="right"> <c:out value="${grl.np}"/> </div></td>
      <td width="153">&nbsp;</td>
      <td height="23" bgcolor="#F5E7B4"># Estudiantes </td>
      <td width="46" height="23">
        <div align="right"><c:out value="${grl.nee}"/></div></td>
      <td width="62">&nbsp;</td>
    </tr>
    <tr>
      <td height="23" bgcolor="#F5E7B4"># de Adm</td>
      <td height="23"><div align="right"><c:out value="${grl.na}"/></div></td>
      <td height="23">&nbsp;</td>
      <td height="23" bgcolor="#F5E7B4"># Docentes </td>
      <td height="23"><div align="right"><c:out value="${grl.nd}"/></div></td>
      <td height="23">&nbsp;</td>
    </tr>
    <tr>
      <td height="23" colspan="6">&nbsp;</td>
    </tr>
    <tr>
      <td height="23" bgcolor="#F5E7B4">Apertura Program&aacute;tica  </td>
      <td height="23" colspan="2"><c:out value="${actividad.apertura_prog}"/></td>
      <td height="23"> </td>
      <td height="23" colspan="2"> </td>
    </tr>
    </c:if>    </c:forEach>
</table>



<!-- FIN FIN FIN mostrando datos generales -->

<br>
<br>

<table width="842" border="1" align="center" bordercolor="#CC9933">
<tr>
    <td width="191" bgcolor="#BAAD74">&nbsp;</td>
    <td width="152" bgcolor="#BAAD74" ><strong> Fuente Econ&oacute;mica </strong></td>
    
    <td width="121" bgcolor="#BAAD74"><strong>&nbsp;Presupuestado
        <!---Ultimo # de comprobante-->
    </strong></td>
    <td width="126" bgcolor="#BAAD74"><strong> Ejecutado      
        <!--monto insertando -->
    </strong></td> 

    <td width="86" bgcolor="#BAAD74"><strong>Saldo</strong></td>
    <td width="126"> </td>
</tr>



<c:forEach var="mo" items="${mosmoneje}">  
   
    
    <c:if test="${mo.codtar==tarea.codtar }">
                         
        
        <tr>
            <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
            <td><c:out value="${mo.codfueneco}"/> - <c:out value="${mo.desfe}"/></td>
            <td><div align="right">&nbsp;<c:out value="${mo.monto}"/>          
            </div></td>
            <td><div align="right">&nbsp;<c:out value="${mo.moneje}"/>           
            </div></td>
          
            <td><div align="right">&nbsp;<c:out value="${mo.saldo}"/> </div></td>
            <td> <input type="checkbox" name="compro" value="<c:out value="${mo.codmoning}"/>::<c:out value="${mo.codfueneco}"/>::<c:out value="${mo.ref123}"/>"></td>
		
			
        </tr>
    </c:if>              
</c:forEach>    





<!--Montos No presupuestados -->
<tr bgcolor="#999999" >
    <td colspan="6" > <span class="Estilo7">Montos No Presupuestados</span>   </td>
  </tr>

<c:forEach var="moo" items="${mos}">  
    
    <!-- Elige la tarea para mostrala -->
    <c:if test="${moo.codtar==tarea.codtar }">
        <tr>
            <td><c:out value="${moo.codmonnopreegr}"/> - <c:out value="${moo.descla}"/></td>
            <td><c:out value="${moo.codfueneco}"/></td>
            <td>&nbsp;<!--comprocompro-->
            <div align="right"></div></td>
            <td><div align="right"><c:out value="${moo.monejenopre}"/>
                    <!--UltiMonInser-->
            </div></td>
           
            <td><div align="right">&nbsp;</div></td>
            <td>&nbsp;</td>
        </tr>
        
    </c:if>              
</c:forEach> 
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->
<tr>
    <td>TOTALES</td>
    <td> &nbsp;&nbsp; </td>
    <td><div align="right">[<c:out value="${too}"/>]
            <!--comprocompro-->
    </div></td>
    <td><div align="right">[<c:out value="${too2 + too3}"/>] 
            <!--UltiMonInser-->
    </div></td>
   
    <td><div align="right">[<c:out value="${too1}"/>]</div></td>
    <td>&nbsp;</td>
</tr>

<!--FIN FIN TOTALES suma -->







<tr >
    <td colspan="7" >&nbsp; </td>
  </tr>
<tr bgcolor="#BAAD74">
    <td height="19" colspan="7"><div align="right"><span class="Estilo3">
      <input type="submit" name="Submit" value="Aceptar">
      <!--[Salir a Men&uacute; Principal] --></span></div></td>
</tr>
</table>


<div align="right">
  </form>
  
</div>
<c:if test="${tooz==too}">
    <h5> LOS TOTALES DE MONTOS PRESUPUESTADOS ENTRE INGRESOS Y EGRESOS SON IGUALES </h5>
</c:if><c:if test="${tooz!=too}">
    <font color="#FF0000"><h3> LOS TOTALES DE MONTOS PRESUPUESTADOS ENTRE INGRESOS Y EGRESOS NO SON IGUALES</h3></font><a href=<c:url value="/MostrarTarIngEgr.do">            
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="descripcion" value="${tarea.descripcion}"/>
                       
                   </c:url>><h6> Ver Historial Montos Presupuestados Ingresos y Egresos</h6> </a> 
    
    
    
</c:if>

<p>&nbsp;</p>
</body>
</html>
