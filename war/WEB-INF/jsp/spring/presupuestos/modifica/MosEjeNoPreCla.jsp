<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<title>No presupuestados ING </title>

</head>
<body>

<div id="container">
<div id="content">
<form name="form1" method="post" action="<c:url value="/ModEjeNoPreCla.do"/>">
<table width="523">
    <tr>
      <th colspan="2" ><div align="center">Modificar Clasificador No Presupuestados<br>
        Modificar Saldo INICIAL Ingresos</div></th>
  </tr>
    <tr >
        <th width="238" >Actividad <c:out value="${desact}"/> </th>
        <th width="269" >Tarea  <c:out value="${desact}"/> </th>
    </tr>
</table>

<table width="463" align="center">
<tr>
    <th width="148">&nbsp;  </th>
    <th colspan="2" >Fuente Econ&oacute;mica</th>


  </tr>
<tr>
<td><div align="center"><c:out value="${npreing.cod_snp}"/> - <c:out value="${npreing.descripcion}"/></div>
    <input type=hidden name="cod_snp" value='<c:out value="${npreing.cod_snp}"/>'>
</td>
<td colspan="2"><div align="center"><c:out value="${f.codfueneco}"/> - <c:out value="${f.descripcion}"/>
                </div></td>
</tr>
<tr>
    <th width="148">Glosa</th>
    <th>Ejecutado </th>
    <th>Saldo Inicial</th>
    <th>Fecha</th>
</tr>



<tr>
  <td><input size="40" type="text"  name="glosa_s2" value="<c:out value="${rnopreing.glosa_s}"/>" id="glosa_s2"></td>
  <td><c:out value="${rnopreing.monejenopre}"/></td>
  <td>
  <div align="center">
  <input  align="center" name="saldo_ej_i2" type="text" id="saldo_ej_i2" value="<c:out value="${rnopreing.saldo_ej_i}"/>">
  </div></td>
  <td><input type="text" name="fecha_saldo2" value="<c:out value="${rnopreing.fecha_saldo}"/>" id="fecha_saldo2"></td>
</tr>


<tr>
    <td>&nbsp;</td>
 <td>
<div align="center">
        <a href=<c:url value="/ModClasificador1.do">
           <c:param name="codacti" value="${codacti}"/>
           <c:param name="codtar" value="${codtar}"/>
       </c:url>>Salir Cambios</a>

</div></td>

  <td ><div align="left">
    <input type="submit" name="Submit" value="Cambiar datos">
  </div></td>
</tr>

</table>



<input type=hidden name="codfueneco" value='<c:out value="${f.codfueneco}"/>'>
<input type=hidden name="ref123" value='<c:out value="${ref123}"/>'>
<input type=hidden name="codtar" value='<c:out value="${rnopreing.codtar}"/>'>
<input type=hidden name="codacti" value='<c:out value="${codacti}"/>'>
<input type=hidden name="monejenopre" value='<c:out value="${rnopreing.monejenopre}"/>'>
<input type=hidden name="saldo_ej_i" value='<c:out value="${rnopreing.saldo_ej_i}"/>'>

</form>
</div></div>
</body>
</html>