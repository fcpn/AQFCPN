

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
            -->
    </style>
</head>
<body>

<table width="523" border="1" align="center" bordercolor="#003366">
    <tr bgcolor="#003366" >
      <td colspan="2" ><div align="center" class="Estilo4"><span class="Estilo5">Datos modificados  Egresos</span></div></td>
  </tr>
    <tr >
        <td width="238" >Actividad <c:out value="${desact}"/> </td>
        <td width="269" >Tarea  <c:out value="${desact}"/> </td>
    </tr>
</table>
<br>

<table width="463" border="1" align="center" bordercolor="#990000">
<tr bgcolor="#003366">
    <td width="148"><span class="Estilo5">-</span></td>
    <td colspan="2" ><span class="Estilo5"> - Fuente Econ&oacute;mica </span></td>


  </tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr >


<td>

    <div align="center">
          <c:out value="${ant2.codmonnopreegr}"/>
    </div></td>
<td colspan="2" >

    <div align="center">
<c:out value="${ant2.codfueneco}"/></div></td>

</tr>
<tr bgcolor="#003366">
    <td width="148" bgcolor="#003366"><span class="Estilo5">Glosa
   </span></td>
   <td bgcolor="#003366" ><span class="Estilo5">Ejecutado</span></td>

    <td bgcolor="#003366" ><span class="Estilo5">Saldo Inicial</span></td>
    <td ><span class="Estilo5">Fecha</span> </td>
</tr>



<tr>


<td><c:out value="${ant2.glosa_s}"/></td>
<td><c:out value="${ant2.monejenopre}"/></td>
<td >
  <div align="center">
<c:out value="${ant2.saldo_ej_i}"/>

      </div></td>
  <td ><c:out value="${ant2.fecha_saldo}"/></td>
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
       </c:url>><strong>Menu</strong></a>

</div></td>



  <td ><div align="left"></div></td>
</tr>


<tr bgcolor="#993300">
    <td height="19" colspan="5"><div align="right"></div></td>
</tr>
</table>




<p>&nbsp;</p>
</body>
</html>