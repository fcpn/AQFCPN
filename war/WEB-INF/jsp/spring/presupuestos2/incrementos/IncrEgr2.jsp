<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title> </title>
    <style type="text/css">
        <!--
.Estilo3 {color: #003399}
.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {
	color: #2A3399;
	font-weight: bold;
}
.Estilo6 {color: #FFFFFF}
.Estilo7 {
	font-size: 12px;
	font-weight: bold;
}
.Estilo9 {color: #000000; font-weight: bold; }
.Estilo10 {color: #ffffff}
.Estilo11 {color: #ffffff; font-weight: bold; }
            -->
    </style>
    
</head>
<body>
<p>&nbsp;</p>



<!--  MOSTRANDO TODO DE INGRESOS  -->

<form name="form1" method="post" action="  ">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#57502B" >
      <td colspan="2" ><div align="center" class="Estilo4">Incrementos Egresos</div></td>
    </tr>
    <tr >
        <td width="238" >Actividad -- <c:out value="${actividad.descripcion}"/> </td>
        <td width="269" >Tarea-- <c:out value="${tarea.descripcion}"/> </td>
    </tr>
</table>


<!-- DATOS GENERALES-->

<table width="630" border="1" align="center" bordercolor="#CC9933">
    <c:forEach var="grl" items="${grl}">
        <c:if test="${grl.codtar==codtar }">
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
            <td height="23" bgcolor="#F5E7B4">Apertura Progr&aacute;matica </td>
            <td height="23" colspan="2"><c:out value="${actividad.apertura_prog}"/></td>
            <td height="23" colspan="3"></td>
        </tr>
        </c:if>
    </c:forEach>
     
</table>





<!-- FIN FIN FIN FIN FIN DATOS GENERALES-->
<br>
<br>
<br>
<table width="731" border="2" align="center" bordercolor="#CC9933">
    <tr>
      <td bgcolor="#57502B"><div align="center" class="Estilo5 Estilo10">INFORME EGRESOS</div></td>
    </tr>
    <tr>
      <td bgcolor="#E2E2E2"><div align="center"> Fuente Econ&oacute;mica </div><br> <div align="center"> <c:out value="${codfueneco}"/> - <c:out value="${fe.descripcion}"/></div></td>
    </tr>
</table>
<table width="830" border="1" align="center" bordercolor="#CC9933">
<tr bgcolor="#B9B9B9">
    <td width="262"><span class="Estilo7">Clasificador</span></td>
    <td width="151"><span class="Estilo7">&nbsp;Presupuestado
        <!---Ultimo # de comprobante-->
    </span></td>
    <td width="121"><span class="Estilo7"> Ejecutado
      <!--monto insertando -->
    </span></td> 
    <td width="114"><span class="Estilo7">Saldo</span></td>
    <td width="108"><span class="Estilo7">His. Ejecutado</span></td>
	<td width="108"><span class="Estilo7">Incremento de montos </span></td>
</tr>
<c:forEach var="mo" items="${mosmoneje}">  
    <!-- Elige la tarea para mostrala -->
    
    <c:if test="${mo.codtar==codtar }">
        <!--  funciona   -->                        
        <c:if test="${mo.codfueneco==codfueneco }">
        <tr>
            <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>

            <td><div align="right">&nbsp;<c:out value="${mo.monto}"/>                  <!--comprocompro-->
            </div></td>
            <td><div align="right">&nbsp;<c:out value="${mo.moneje}"/>                  <!--UltiMonInser-->
            </div></td>
            
            <td><div align="right">&nbsp;<c:out value="${mo.saldo}"/> </div></td>
            <td>
		   <a href=<c:url value="/MostrarEjePresue.do">            
                       <c:param name="moneje" value="${mo.moneje}"/>
                       <c:param name="codtar" value="${codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="desfe" value="${mo.desfe}"/>
                       <c:param name="codmoning" value="${mo.codmoning}"/>
                       <c:param name="descla" value="${mo.descla}"/>
                   </c:url>><h6>Historial</h6> 
              </a>
			</td>
       	<td>
		<a href=<c:url value="/IncrEgr3.do">            
                       <c:param name="monto" value="${mo.monto}"/>
                       <c:param name="moneje" value="${mo.moneje}"/>
                       <c:param name="saldo" value="${mo.saldo}"/>
					   
                       <c:param name="codtar" value="${codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                       <c:param name="desfe" value="${mo.desfe}"/>
                       <c:param name="codmonegr" value="${mo.codmoning}"/>
                       <c:param name="descla" value="${mo.descla}"/>
                       <c:param name="ref1" value="${mo.ref123}"/>
                   </c:url>><h6>Incrementar</h6> 
              </a>
		</td>
        </tr>
        </c:if> 
    </c:if>              
</c:forEach>    





<!--Montos No presupuestados -->
<tr >
    <td colspan="2" bgcolor="#B9B9B9" > <span class="Estilo9">Montos No Presupuestados</span>   </td>
    <td bgcolor="#E2E2E2" >&nbsp; </td>
    <td colspan="3" bgcolor="#B9B9B9" >&nbsp;</td>
    </tr>

<c:forEach var="moo" items="${mos}">  
    
    <!-- Elige la tarea para mostrala -->
    <c:if test="${moo.codtar==codtar }">
        <c:if test="${moo.codfueneco==codfueneco}">
        <tr>
            <td><c:out value="${moo.codmonnopreing}"/> - <c:out value="${moo.descla}"/></td>

            <td><div align="center">-</div></td>
            <td><div align="right"><c:out value="${moo.monejenopre}"/>
                    <!--UltiMonInser-->
            </div></td>
         
            <td><div align="right">&nbsp;</div></td>
            <td>
			    <a href=<c:url value="/MostrarEjeNoPresue.do">            
                       <c:param name="monejenopre" value="${moo.monejenopre}"/>
                       <c:param name="codtar" value="${codtar}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="codmonnopreing" value="${moo.codmonnopreing}"/>
                       <c:param name="descla" value="${moo.descla}"/>
                   </c:url>><h6> Historial</h6> 
                </a> 
			
			
			</td>
        	<td><div align="center">-</div></td>
        </tr>
        </c:if>
    </c:if>              
</c:forEach> 
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->

<tr>
<td colspan="6">&nbsp;      </td>
</tr>
<tr bgcolor="#9A9A9A">
    <td bgcolor="#9A9A9A"><strong>TOTALES</strong></td>
    <td><div align="right">[<c:out value="${too}"/>]
            <!--comprocompro-->
    </div></td>
    <td><div align="right">[<c:out value="${too3}"/>] 
            <!--UltiMonInser-->
    </div></td>
  
    <td><div align="right">[<c:out value="${too1}"/>]</div></td>
    <td>&nbsp;</td>
  	<td>&nbsp;</td>
</tr>

<!--FIN FIN TOTALES suma -->







<tr >
    <td colspan="10" >&nbsp; </td>
</tr>

<tr bgcolor="#BAAD74">
    <td height="14" colspan="10">&nbsp;</td>
  
<tr bgcolor="#B9B9B9">
    <td height="19" colspan="10"><div align="right"></div></td>
</tr>
</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>



<!-- FIN FIN FIN FIN FIN FIN FIN MOSTRANDO TODO DE INGRESOS  -->

















































<!--  MOSTRANDO TODO DE ________EGRESOS  -->

<!--  FIN FIN FIN FIN FIN FIN FIN MOSTRANDO TODO DE ________EGRESOS  -->



<p>&nbsp;</p>

<div align="right"><a href="javascript:cerrarse('')">cerrar ventana</a></div>

</body>
</html>
