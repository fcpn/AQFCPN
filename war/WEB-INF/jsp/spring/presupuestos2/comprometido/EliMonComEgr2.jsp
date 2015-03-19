<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Comprometido 1</title>
    <style type="text/css">
        <!--
.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo13 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold; }
.Estilo14 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
}
.Estilo15 {font-size: 10px}
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="<c:url value="/EliMonComEgr3.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#544D29" >
        <td colspan="2" ><div align="center" class="Estilo4">Eliminar Montos Comprometidos</div></td>
    </tr>
    <tr bgcolor="#CBC196" >
        <td width="238" ><div align="center"><strong>Actividad </strong></div></td>
        <td width="269" ><div align="center"><strong>Tarea </strong></div></td>
    </tr>
	<tr >
        <td width="238" ><c:out value="${actividad.descripcion}"/> </td>
        <td width="269" ><c:out value="${tarea.descripcion}"/> </td>
    </tr>
</table>
<br>
<br>

<table width="871" border="1" align="center" bordercolor="#CC9933">


<!-- Elige la tarea para mostrala -->
	
<c:if test="${j != '-1'}">
<!--  funciona   -->                        
<c:forEach var="i" begin="0" end="${j}" step="3">  

<tr bgcolor="#CBC196">
    <td width="123"><span class="Estilo13">Partida</span></td>
    <td width="136" ><span class="Estilo13"> Fuente Econ&oacute;mica </span></td>
    
    <td width="155"><span class="Estilo13">&nbsp;Monto Comprometido a Acumular
        <!---Ultimo # de comprobante-->
    </span>



<tr>
    <td><c:out value="${M[i]}"/></td>
    <td> <c:out value="${M[i+1]}"/></td>
    
    <td><c:out value="${M[i+2]}"/></td>
  </tr>


<tr>
    <td colspan="5" bgcolor="#CCCCCC">Se eliminaran los datos de la lista incluyendo sus historiales. </td>
  </tr>
 <tr bordercolor="#666666" bgcolor="#666666">
    <td height="19" colspan="6">&nbsp;  </td>
  </tr>
<input type=hidden name=complemento value='<c:out value="${M[i]}"/>::<c:out value="${M[i+1]}"/>::<c:out value="${M[i+2]}"/>'>

 </c:forEach>
 

 
 <c:if test="${j != '-1'}">
     
<input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${codtar}"/>'>
<tr bgcolor="#BAAD74">
    <td height="19" colspan="6"><div align="right">
      <input type="submit" name="Submit" value="Aceptar">
    </div></td>
</tr>

</c:if>
 
 
</c:if>

</table>



<c:if test="${j == '-1'}">
Usted no eligió Montos Comprometidos para Eliminar </c:if>

<br>
<br><br>
    <div align="right"><a href="javascript:history.back(0);">Volver Atras</a></div>

</form>
<p>&nbsp;</p>
</body>
</html>