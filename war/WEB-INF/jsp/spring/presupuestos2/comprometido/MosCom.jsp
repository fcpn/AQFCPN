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

<form name="form1" method="post" action="<c:url value="/InsCom2.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#544D29" >
        <td colspan="2" ><div align="center" class="Estilo4">Insertar Monto Comprometido</div></td>
    </tr>
    <tr bgcolor="#CBC196" >
        <td width="238" ><div align="center"><strong>Actividad </strong></div></td>
        <td width="269" ><div align="center"><strong>Tarea </strong></div></td>
    </tr>
	<tr >
        <td width="238" ><c:out value="${desact}"/> </td>
        <td width="269" ><c:out value="${destar}"/> </td>
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
    
    <td width="155"><span class="Estilo13">&nbsp;Monto Comprometido
        <!---Ultimo # de comprobante-->
    </span></td>
    <td width="311"><span class="Estilo13"> Glosa 
      <!--monto insertando -->
    </span></td> 
    <td width="112"><span class="Estilo13">Observaciones</span></td>
  
</tr>



<tr>
    <td><c:out value="${M[i]}"/></td>
    <td> <c:out value="${M[i+1]}"/></td>
    
    <td><div align="center">
      <input name="moncom" type="text" id="moncom" value="0" size="12">
    </div>      <c:out value="${monpre}"/></td>
    <td><div align="center">
      <textarea name="glosa" cols="40" rows="3" id="glosa"></textarea>
    </div>      <c:out value="${moneje}"/></td>
    <td><div align="right">
      <textarea name="obs" cols="40" rows="2" id="textarea"></textarea>
      <input type=hidden name=complemento value='<c:out value="${M[i]}"/>::<c:out value="${M[i+1]}"/>::<c:out value="${M[i+2]}"/>'>
      </div></td>
    
</tr>


<tr>
    <td colspan="4" rowspan="2" bgcolor="#CCCCCC">            <div align="center">
    </div>      <div align="center">
          </div></td>
    <td bgcolor="#CBC196"><span class="Estilo13">Fecha</span></td>
    
</tr>


<tr>
    <td><div align="center">
      <table width="200" border="0">
        <tr>
          <td><div align="center">
              <input name="dia" type="text" id="dia6" size="3" maxlength="2">
          </div></td>
          <td><div align="center">
              <input name="mes" type="text" id="mes5" size="3" maxlength="2">
          </div></td>
          <td><div align="center">
              <input name="anio" type="text" id="anio5" size="3" maxlength="2">
          </div></td>
        </tr>
        <tr bgcolor="#BAAD74">
          <td><div align="center" class="Estilo14 Estilo15">Dia</div></td>
          <td><div align="center" class="Estilo13">Mes</div></td>
          <td><div align="center" class="Estilo13">A&ntilde;o</div></td>
        </tr>
      </table>
    </div></td>
</tr>










 <tr bordercolor="#666666" bgcolor="#666666">
    <td height="19" colspan="6">&nbsp;  </td>
  </tr>


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
Usted no eligi� partidas para montos comprometidos

</c:if>

<br><br><br>
    <div align="right"><a href="javascript:history.back(0);">Volver Atras</a></div>

</form>
<p>&nbsp;</p>
</body>
</html>