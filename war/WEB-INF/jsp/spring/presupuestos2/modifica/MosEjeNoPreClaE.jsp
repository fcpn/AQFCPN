<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
<title>Most </title>
    <style type="text/css">
        <!--
.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {color: #FFFFFF}
.Estilo6 {color: #00FF99}
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="<c:url value="/ModEjeNoPreClaE.do"/>">
<table width="523" border="1" align="center" bordercolor="#003366">
    <tr bgcolor="#003366" >
      <td colspan="2" ><div align="center" class="Estilo4">Modificar Clasificador No Presupuestados<br>
        <span class="Estilo6">Modificar Saldo INICIAL Egresos</span></div></td>
  </tr>
    <tr >
        <td width="238" >Actividad <c:out value="${desact}"/> </td>
        <td width="269" >Tarea  <c:out value="${desact}"/> </td>
    </tr>
</table>
<br>
<br>

<table width="463" border="1" align="center" bordercolor="#990000">
<tr bgcolor="#003366">
    <td width="148"><span class="Estilo5">-</span></td>
    <td colspan="2" ><span class="Estilo5"> - Fuente Econ&oacute;mica </span></td>


  </tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr bgcolor="#999999">


<td>

    <div align="center">

               <c:out value="${rnopreegr.codmonnopreegr}"/>

    </div></td>
<td colspan="2">

    <div align="center">
<c:out value="${f.codfueneco}"/> - <c:out value="${f.descripcion}"/>


    </div></td>

</tr>
<tr bgcolor="#003366">
    <td width="148" bgcolor="#003366"><span class="Estilo5">Glosa
   </span></td>
        <td ><span class="Estilo5">Ejecutado</span> </td>
    <td bgcolor="#003366" ><span class="Estilo5">Saldo Inicial</span></td>
    <td ><span class="Estilo5">Fecha</span> </td>

</tr>



<tr>

<td bgcolor="#999999"><input size="40" type="text"  name="glosa_s2" value="<c:out value="${rnopreegr.glosa_s}"/>" id="glosa_s2"></td>

<td bgcolor="#999999"><c:out value="${rnopreegr.monejenopre}"/></td>
<td bgcolor="#999999">
  <div align="center">
  <input  align="center" name="saldo_ej_i2" type="text" id="saldo_ej_i2" value="<c:out value="${rnopreegr.saldo_ej_i}"/>">

      </div></td>
  <td bgcolor="#999999"><input type="text" name="fecha_saldo2" value="<c:out value="${rnopreegr.fecha_saldo}"/>" id="fecha_saldo2"></td>
</tr>



    <tr><td>
	</td>

    <td width="126">
      <div align="right">  &nbsp;      </div></td>

    <td width="167"></td>
  </tr>
<tr>
    <td></td>


    <td><div align="right">

    </div></td>

    <td></td>
</tr>


<tr >
 <td >  </td>
  <td >
<div align="center">

        <a href=<c:url value="/ModClasificador1e.do">
           <c:param name="codacti" value="${codacti}"/>
           <c:param name="codtar" value="${codtar}"/>
       </c:url>><strong>Salir Cambios</strong></a>

</div></td>



  <td ><div align="left">
    <input type="submit" name="Submit" value="Cambiar datos">
  </div></td>
</tr>


<tr bgcolor="#993300">
    <td height="19" colspan="5"><div align="right"></div></td>
</tr>
</table>


<input type=hidden name="codmonnopreegr" value='<c:out value="${rnopreegr.codmonnopreegr}"/>'>
<input type=hidden name="codfueneco" value='<c:out value="${f.codfueneco}"/>'>
<input type=hidden name="ref123" value='<c:out value="${ref123}"/>'>
<input type=hidden name="codtar" value='<c:out value="${rnopreegr.codtar}"/>'>
<input type=hidden name="codacti" value='<c:out value="${codacti}"/>'>
<input type=hidden name="monejenopre" value='<c:out value="${rnopreegr.monejenopre}"/>'>
<input type=hidden name="saldo_ej_i" value='<c:out value="${rnopreegr.saldo_ej_i}"/>'>

</form>
<p>&nbsp;</p>
</body>
</html>