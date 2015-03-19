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

<form name="form1" method="post" action="  ">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#BAAD74" >
        <td colspan="2" ><div align="center" class="Estilo4">Informe Egresos </div></td>
    </tr>
    <tr >
        <td width="238" >Actividad -- <c:out value="${actividad.descripcion}"/> </td>
        <td width="269" >Tarea-- <c:out value="${tarea.descripcion}"/> </td>
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
    <td width="262">-</td>
    <td width="134" > - Fuente Econ&oacute;mica </td>
    
    <td width="127">&nbsp;Presupuestado<!---Ultimo # de comprobante--></td>
    <td width="121"> Ejecutado___ <!--monto insertando --></td> 
    <td width="50">VER</td>
    <td width="108">Saldo___</td>
</tr>
<c:forEach var="mo" items="${mosmoneje}">  
    <!-- Elige la tarea para mostrala -->
    
    <c:if test="${mo.codtar==tarea.codtar }">
        <!--  funciona   -->                        
        
        <tr>
            <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
            <td><c:out value="${mo.codfueneco}"/> - <c:out value="${mo.desfe}"/></td>
            <td><div align="right">&nbsp;<c:out value="${mo.monto}"/>                  <!--comprocompro-->
            </div></td>
            <td><div align="right">&nbsp;<c:out value="${mo.moneje}"/>                  <!--UltiMonInser-->
            </div></td>
            <td>   
                <a href=<c:url value="/MostrarEjePresue.do">            
                       <c:param name="moneje" value="${mo.moneje}"/>
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="desfe" value="${mo.desfe}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="descla" value="${mo.descla}"/>
                   </c:url>><h6> Ver Historial Monto Ejecutado</h6> </a>             
                
            </td>
            <td><div align="right">&nbsp;<c:out value="${mo.saldo}"/> </div></td>
        </tr>
    </c:if>              
</c:forEach>    





<!--Montos No presupuestados -->
<tr >
    <td colspan="2" > <span class="Estilo2">Montos No Presupuestados</span>   </td>
    <td ><div align="right">&nbsp;</div></td>
    <td ><div align="right">&nbsp;</div></td>
    <td >&nbsp;</td>
    <td ><div align="right">&nbsp;</div></td>
</tr>

<tr>
    <td>-</td>
    <td width="134">&nbsp; </td>
    
    
    <td>&nbsp;<!---Ultimo # de comprobante-->
    <div align="right"></div></td>
    <td> &nbsp;<!--monto insertando -->
    <div align="right"></div></td>
    
    
    
    <td>&nbsp;</td>
    <td><div align="right">&nbsp;</div></td>
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
            <td>                
                <a href=<c:url value="/MostrarEjeNoPresue.do">            
                       <c:param name="monejenopre" value="${moo.monejenopre}"/>
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="codmonnopreegr" value="${moo.codmonnopreegr}"/>
                       <c:param name="descla" value="${moo.descla}"/>
                   </c:url>><h6> Ver Historial Monto Ejecutado</h6> </a> 
                
            </td>
            <td><div align="right">&nbsp;</div></td>
        </tr>
        
    </c:if>              
</c:forEach> 
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->

<tr>
    <td>-</td>
    <td width="134"> --  </td>
    
    
    <td>&nbsp;<!---Ultimo # de comprobante-->
    <div align="right"></div></td>
    <td> &nbsp;<!--monto insertando -->
    <div align="right"></div></td>
    
    
    
    <td>&nbsp;</td>
    <td><div align="right">&nbsp;</div></td>
</tr>
<tr>
    <td>TOTALES --> </td>
    <td> &nbsp;&nbsp; </td>
    <td><div align="right">[<c:out value="${too}"/>]
            <!--comprocompro-->
    </div></td>
    <td><div align="right">[<c:out value="${too3}"/>] 
            <!--UltiMonInser-->
    </div></td>
    <td>&nbsp;</td>
    <td><div align="right">[<c:out value="${too1}"/>]</div></td>
</tr>

<!--FIN FIN TOTALES suma -->







<tr >
    <td colspan="6" >&nbsp; </td>
    </tr>
<tr bgcolor="#BAAD74">
    <td height="19" colspan="6"><div align="right"><span class="Estilo3"><!--[Salir a Men&uacute; Principal] --></span></div></td>
</tr>
</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>


<c:if test="${tooz==too}">
    <h5> LOS TOTALES DE MONTOS PRESUPUESTADOS ENTRE INGRESOS Y EGRESOS SON IGUALES </h5>
</c:if>

<c:if test="${tooz!=too}">
    <font color="#FF0000"><h3> LOS TOTALES DE MONTOS PRESUPUESTADOS ENTRE INGRESOS Y EGRESOS NO SON IGUALES</h3></font>
    <a href=<c:url value="/MostrarTarIngEgr.do">            
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="descripcion" value="${tarea.descripcion}"/>
                   </c:url>><h6> Ver Historial Montos Presupuestados Ingresos y Egresos</h6> </a> 
    
    
    
</c:if>
<p>&nbsp;</p>
</body>
</html>