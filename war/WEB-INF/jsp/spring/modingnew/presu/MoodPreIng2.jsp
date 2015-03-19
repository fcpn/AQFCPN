<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Most </title>
    <style type="text/css">
        <!--
		TABLE { border-collapse: collapse; border: none; }
.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo7 {color: #FFFFFF; font-weight: bold; }
.Estilo9 {font-size: 12px}
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>


<!-- Tabla        style="border:0px solid #C6D1DA" -->
<table width="523" border="0" align="center" bordercolor="#CC9933" style="empty-cells:show ">
    <tr bgcolor="#003366" >
      <td colspan="2" ><div align="center" class="Estilo4">Modificar Ingresos </div></td>
  </tr>
    <tr bgcolor="#EAEAEA" >
        <td width="238" ><div align="center">Actividad: <c:out value="${actividad.descripcion}"/> </div></td>
        <td width="269" ><div align="center">Tarea: <c:out value="${tarea.descripcion}"/> </div></td>
  </tr>
</table>
<br>
<br>

<table width="496" border="0" align="center" bordercolor="#CC9933">
  <tr bgcolor="#003366">
    <td  colspan="4" bgcolor="#003366"> <div align="center" class="Estilo7">Datos Anteriores</div></td>
  </tr>
  <tr bgcolor="#003366">
    <td width="132" bgcolor="#003366"><div align="center" class="Estilo9"><span class="Estilo7">Partida</span></div></td>
    <td width="159" bgcolor="#003366" ><div align="center" class="Estilo9"><span class="Estilo7"> Fuente Econ&oacute;mica </span></div></td>
    <td width="191" bgcolor="#003366"><div align="center" class="Estilo9"><span class="Estilo7">Presupuestado </span></div></td>
    <td width="191" bgcolor="#003366"><div align="center" class="Estilo9"><span class="Estilo7">Ejecutado</span></div></td>
    <td width="191" bgcolor="#003366"><div align="center" class="Estilo9"><span class="Estilo7">Saldo</span></div></td>
  </tr>
  <!-- Elige la tarea para mostrala -->
  <!--  funciona   -->
  <tr >
    <td>
      <div align="center"> <c:out value="${preante.codmoning}"/> </div></td>
    <td><div align="center"> <c:out value="${preante.codfueneco}"/></div></td>
    <td align="center" bgcolor="#999999"> <c:out value="${monpre1}"/> </td>
    <td align="center" > <c:out value="${preante.montoeje}"/> </td>
    <td align="center" > <fmt:formatNumber  value="${monpre1-preante.montoeje}" pattern="#,###,###,##0.00"/></td>
  </tr>
  <tr bgcolor="#990000">
    <td height="3" colspan="5"></td>
  </tr>
</table>
<br>
<table width="496" border="0" align="center" bordercolor="#CC9933">
  <tr bgcolor="#344A85">
    <td  colspan="5">
    <div align="center" class="Estilo7">Datos Actuales Modificados </div></td>
  </tr>
  <tr bgcolor="#344A85">
    <td width="132"><div align="center" class="Estilo9"><span class="Estilo7">Partida</span></div></td>
    <td width="159" ><div align="center" class="Estilo9"><span class="Estilo7"> Fuente Econ&oacute;mica </span></div></td>
    <td width="191"><div align="center" class="Estilo9"><span class="Estilo7">Presupuestado </span></div></td>
    <td width="191"><div align="center" class="Estilo9"><span class="Estilo7">Ejecutado</span></div></td>
	    <td width="191"><div align="center" class="Estilo9"><span class="Estilo7">Saldo</span></div></td>
  </tr>
  <!-- Elige la tarea para mostrala -->
  <!--  funciona   -->
  <tr>
   <td>      <div align="center"> <c:out value="${premodi.codmoning}"/> </div></td>
    <td><div align="center"> <c:out value="${premodi.codfueneco}"/></div></td>
    <td align="center" bgcolor="#FFA6B8"> <c:out value="${premodi.montopresu}"/> </td>
	    <td align="center"><fmt:formatNumber  value="${premodi.montoeje}" pattern="#,###,###,##0.00"/> </td>
			    <td align="center"><fmt:formatNumber  value="${premodi.saldo}" pattern="#,###,###,##0.00"/>  </td>
  <tr bgcolor="#990000">
    <td height="3" colspan="5"></td>
  </tr>
</table>
<br>
<table width="496" border="0" align="center" bordercolor="#CC9933">
  <tr >
    <td  colspan="3">
	  <a  href="<c:url value="/ModClasificador1.do">
                            <c:param name="codtar" value="${tarea.codtar}"/>
                            <c:param name="codacti" value="${actividad.codacti}"/>

                            </c:url>"> Modificar  Monto Presupuestado
     </a>
</td>
    <td width="234"></td>
  </tr>

</table>
<p>&nbsp;</p>
<p>

</p>
<p>&nbsp;</p>
</body>
</html>
