<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
<title>Documento sin t&iacute;tulo</title>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<style type="text/css">
<!--


body{
	margin:0;
	padding:0;
	background:#f1f1f1;
	font:80% Arial, Helvetica, sans-serif;
	color:#555;
	line-height:150%;
	text-align:left;
}
a{
	text-decoration:none;
	color:#057fac;
}
a:hover{
	text-decoration:none;
	color:#999;
}
h1{
	font-size:140%;
	margin:0 20px;
	line-height:80px;
}
h2{
	font-size:120%;
}
#container{
	margin:0 auto;
	width:680px;
	background:#fff;
	padding-bottom:20px;
}
#content{margin:0 10px;}
p.sig{
	margin:0 auto;
	width:680px;
	padding:1em 0;
}
form{
	margin:1em 0;
	padding:.2em 20px;
	background:#eee;
}



-->
</style>
</head>

<body>
<div id="container">
<div id="content">
<form name="form1" method="post" action="<c:url value="/modeligen.do"/>">
  <p>&nbsp;</p>
  <table width="68%" >
    <tr>
     <th colspan="2"> <div align="center">Datos Generales Datos Generales <br>
       Modificados </div></th>
    </tr>
   <tr >
      <td width="238" ><div align="center"><strong>Actividad</strong></div></td>
      <td width="269" ><div align="center"><strong>Tarea</strong></div></td>
    </tr>
    <tr >
      <td width="238" > <c:out value="${actividad.descripcion}"/> </td>
      <td width="269" > <c:out value="${tarea.descripcion}"/></td>
    </tr>
</table>
  <br>
  <table width="630">
    <c:forEach var="grl" items="${grl}">
      <tr>
      <th width="192" >Identificacion de la Funci&oacute;n </th>
      <td colspan="4"> <c:out value="${grl.funcion}"/> </td>
    </tr>
    <tr>
      <th >Responsable</th>
      <td colspan="4"><c:out value="${grl.nom}"/> <c:out value="${grl.ap}"/> <c:out value="${grl.am}"/></td>
    </tr>
    <tr>
      <th >Cargo del Responsable</th>
      <td width="195"><c:out value="${grl.cargo}"/></td>
      <th width="95" >Resultado </th>
      <td width="108"><c:out value="${grl.cargah}"/></td>
    </tr>
    <tr>
      <th >Objetivo</th>
      <td colspan="4"><c:out value="${grl.objetivo}"/></td>
    </tr>
	<tr>
      <th >Pol&iacute;tica Estrat&eacute;gica (PILAR)</th>
      <td colspan="4"><c:out value="${grl.poli}"/></td>
    </tr>
    <tr>
      <th >Fecha de inicio</th>
      <td><c:out value="${grl.fechai}"/></td>
      <th>Fecha Final</th>
      <td><c:out value="${grl.fechaf}"/></td>
    </tr>
    <tr>
      <td height="23" colspan="2">&nbsp;</td>
      <td height="23">&nbsp;</td>
      <td height="23"><input type="submit" name="Submit" value="Aceptar"></td>
    </tr>
    </c:forEach>
</table>
  <p>&nbsp;  </p>
</form>


</div>
</div>
</body>
</html>
