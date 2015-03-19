
<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Most </title>
    <style type="text/css">
        <!--
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {color: #FFFFFF}
.Estilo7 {color: #FFFFFF; font-weight: bold; }
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="<c:url value="/ModSoloEje2.do"/>">
<table width="523" border="1" align="center" bordercolor="#990000">
    <tr bgcolor="#003366" >
      <td colspan="2" ><div align="center" class="Estilo4 Estilo5">Modificar Monto Ejecutado <br>Ingresos </div></td>
  </tr>
    <tr >
        <td width="238" >Actividad - <c:out value="${actividad.descripcion}"/> </td>
        <td width="269" >Tarea - <c:out value="${tarea.descripcion}"/> </td>
    </tr>
</table>
<br>

<table width="612" border="1" align="center" bordercolor="#990000">



<tr bgcolor="#003366">
    <td colspan="5"><span class="Estilo5">Modificar Referencia </span></td>
  </tr>


<tr>

    <td colspan="2" bgcolor="#003D79"><div align="center"><span class="Estilo7">Rubro</span></div></td>


    <td colspan="2" bgcolor="#003D79"><div align="center"><span class="Estilo7">Fuente Econ&oacute;mica
        <!--monto insertando -->
    </span></div></td>
  </tr>


<tr>

    <td colspan="2" bgcolor="#FFFFFF">
	<div align="center">
      <c:out value="${codmoning}"/>
    </div>	</td>


    <td colspan="2" bgcolor="#FFFFFF"><div align="center">
      <c:out value="${codfueneco}"/>
    </div>   </td>
  </tr>


<tr bgcolor="#003D79">

    <td width="178"><div align="center" class="Estilo5"><strong>Presupuestado
    </strong></div></td>


    <td width="216"><div align="center" class="Estilo5"><strong>Ejecutado
    </strong></div></td>
    <td width="227"> <span class="Estilo7">
      <!--monto insertando -->
      </span>
    <div align="center" class="Estilo7">Saldo</div></td>
    <td width="173"><div align="center"><span class="Estilo5"></span>
    </div></td>
</tr>


<tr>

    <td width="178" bgcolor="#FFFFFF"><div align="center">
      <c:out value="${montos.montopresu}"/>
    </div></td>


    <td bgcolor="#FFB7B7"><div align="center">
      <input name="moneje2" type="text" id="moneje2" value="<c:out value="${montos.montoeje}"/>">
    </div></td>
    <td bgcolor="#FFFFFF"> <!--monto insertando -->
      <div align="center">
        <fmt:formatNumber  value="${montos.saldo}" pattern="#,###,###,##0.00"/>
    </div></td>
    <td bgcolor="#FFFFFF"><div align="center">      </div></td>
</tr>


<tr>
    <td colspan="2" bgcolor="#003D79"><div align="center" class="Estilo5">Cambiando el Saldo de ejecucion Inicial </div></td>
    <td>
</td>
    <td><input type="submit" name="Submit" value="Cambiar datos">
    </td>

</tr>


<!--FIN FIN TOTALES suma -->







<tr >
    <td ><div align="center">si
        <input name="sal_ini" type="radio" value="s">
    </div></td>
    <td ><div align="center">no
        <input name="sal_ini" type="radio" value="n" checked>
    </div></td>
    <td ></td>
    <td><a href=<c:url value="/modclasificador.do"></c:url>><strong>Salir Cambios</strong></a> </td>


</tr>


<tr bgcolor="#990000">
    <td height="19" colspan="5"></td>
</tr>
</table>

<input type=hidden name=codmoning value='<c:out value="${codmoning}"/>'>
<input type=hidden name=codfueneco value='<c:out value="${codfueneco}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=moneje1 value='<c:out value="${montos.montoeje}"/>'>

</form>

</body>
</html>