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

<form name="form1" method="post" action="<c:url value="/ModEgrRef.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#BAAD74" >
        <td colspan="2" ><div align="center" class="Estilo4">Modificar Egresos </div></td>
    </tr>
    <tr >
        <td width="238" >Actividad -- <c:out value="${desact}"/> </td>
        <td width="269" >Tarea-- <c:out value="${destar}"/> </td>
    </tr>
</table>
<br>
<br>

<table width="861" border="1" align="center" bordercolor="#CC9933">


<!-- Elige la tarea para mostrala -->
	

<!--  funciona   -->                        





<!--Montos No presupuestados -->



<tr bgcolor="#DED8BC">
    <td colspan="5">Modificar Referencia ----------------------------------------------------------------------------------------------------------------------- </td>
  </tr>


<tr>
    <td width="1"></td>
    <td width="163">Monto Acumulado </td>
    
    
    <td width="212">Comprobante</td>
    <td width="227"> <!--monto insertando -->
      Fecha de ejecucion </td>
    <td width="234">observaciones</td>
</tr>


<tr>
    <td></td>
    <td width="163" bgcolor="#F0EEE1"><div align="center">
      <input name="monacumulado2" type="text" id="monacumulado2" value="<c:out value="${monacumulado}"/>">
    </div></td>
    
    
    <td bgcolor="#F0EEE1"><div align="center">
      <input name="comprobante2" type="text" id="comprobante2" value="<c:out value="${comprobante}"/>">
    </div></td>
    <td bgcolor="#F0EEE1"> <!--monto insertando -->
      <div align="center">
        <input name="fecha2" type="text" id="fecha" value="<c:out value="${fecha}"/>">
    </div></td>
    <td bgcolor="#F0EEE1"><div align="center">
      <input name="observaciones2" type="text" id="observaciones2" value="<c:out value="${observaciones}"/>">
    </div></td>
</tr>

<tr>
    <td></td>
    <td colspan="4" bgcolor="#DED8BC">--------------------------------------------------------------------------------------------------------------------------------------------     </td>
  </tr>



<tr>
    <td></td>
    <td width="163">   </td>
    
    
    <td>
</td>
    <td> 
     </td>
    <td><input type="submit" name="Submit" value="Cambiar datos"></td>
</tr>
<tr>
    <td></td>
    <td> </td>
    <td></td>
    <td></td>
    <td> </td>
</tr>

<!--FIN FIN TOTALES suma -->







<tr >
    <td colspan="2" >  </td>
    <td ></td>
    <td ></td>
    <td >
	 <a href=<c:url value="/modclafuemon.do">            
                     
       </c:url>><strong>Salir Cambios</strong></a>
	
	</td>
</tr>


<tr bgcolor="#BAAD74">
    <td height="19" colspan="5"><div align="right"></div></td>
</tr>
</table>



<input type=hidden name=codmonegr value='<c:out value="${codmonegr}"/>'>
<input type=hidden name=descla value='<c:out value="${descla}"/>'>

<input type=hidden name=codfueneco value='<c:out value="${codfueneco}"/>'>
<input type=hidden name=desfe value='<c:out value="${desfe}"/>'>

<input type=hidden name=codtar value='<c:out value="${codtar}"/>'>
<input type=hidden name=destar value='<c:out value="${destar}"/>'>

<input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
<input type=hidden name=desact value='<c:out value="${desact}"/>'>




<input type=hidden name=monacumulado value='<c:out value="${monacumulado}"/>'>

<input type=hidden name=idd value='<c:out value="${id}"/>'>



</form>

</body>
</html>