<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    <title>Modifica </title>
  
</head>
<body>
<div id="container">
<div id="content">

<form name="form1" method="post" action="<c:url value="/ModIngRef.do"/>">
<table width="523">
    <tr>
        <th colspan="2" ><div align="center">Modificar Ingresos </div></th>
    </tr>
    <tr>
        <th width="238" >Actividad  <c:out value="${desact}"/> </th>
        <th width="269" >Tarea <c:out value="${destar}"/> </th>
    </tr>
</table>

<table width="861">

<tr>
    <th colspan="5">Modificar Referencia </th>
  </tr>


<tr>
    <th width="1">-</th>
    <th width="163">Monto Acumulado </th>
    <th width="212">Comprobante</th>
    <th width="227">Fecha de ejecucion </th>
    <th width="234">observaciones</th>
</tr>


<tr>
    <td></td>
    <td width="163"><div align="center">
      <input name="monacumulado2" type="text" id="monacumulado2" value="<c:out value="${monacumulado}"/>">
    </div></td>
    
    
    <td><div align="center">
      <input name="comprobante2" type="text" id="comprobante2" value="<c:out value="${comprobante}"/>">
    </div></td>
    <td><div align="center">
        <input name="fecha2" type="text" id="fecha" value="<c:out value="${fecha}"/>">
    </div></td>
    <td><div align="center">
      <input name="observaciones2" type="text" id="observaciones2" value="<c:out value="${observaciones}"/>">
    </div></td>
</tr>

<tr>
    <td> </td>
    <td width="163">   </td>
    <td> </td>
    <td> </td>
    <td><input type="submit" name="Submit" value="Cambiar datos"></td>
</tr>

<tr >
    <td colspan="2" >  </td>
    <td ></td>
    <td ></td>
    <td >
	 <a href=<c:url value="/modclasificador.do">            
                     
       </c:url>><strong>Salir Cambios</strong></a>
	
	</td>
</tr>

</table>



<input type=hidden name=codmoning value='<c:out value="${codmoning}"/>'>
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