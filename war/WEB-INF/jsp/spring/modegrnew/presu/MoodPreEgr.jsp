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
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="<c:url value="/MoodPreEgr2.do"/>">
<!-- Tabla        style="border:0px solid #C6D1DA" -->
<table width="523" border="0" align="center" bordercolor="#CC9933" style="empty-cells:show ">
    <tr bgcolor="#003366" >
      <td colspan="2" ><div align="center" class="Estilo4">Modificar Egresos </div></td>
  </tr>
    <tr bgcolor="#EAEAEA" >
        <td width="238" ><div align="center">Actividad: <c:out value="${actividad.descripcion}"/> </div></td>
        <td width="269" ><div align="center">Tarea: <c:out value="${tarea.descripcion}"/> </div></td>
  </tr>
</table>
<br>
<br>

<table width="466" border="0" align="center" bordercolor="#CC9933">
<tr bgcolor="#003366">
    <td width="132" bgcolor="#003366"><div align="center"><span class="Estilo7">Partida</span></div></td>
    <td width="159" bgcolor="#003366" ><div align="center"><span class="Estilo7"> Fuente Econ&oacute;mica </span></div></td>

    <td width="161" bgcolor="#003366"><div align="center"><span class="Estilo7">Modificar / Presupuestado
    </span></div></td>
  </tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr bgcolor="#CCCCCC">


<td bgcolor="#CCCCCC">
     <div align="center">
     <c:out value="${montos.codmonegr}"/> </div>
   </td>


<td bgcolor="#CCCCCC"><div align="center"> <c:out value="${montos.codfueneco}"/></div> </td>

<td align="center">

    <input  align="center" name="monpre2" type="text" id="monpre2" value="<c:out value="${montos.montopresu}"/>">

</td>

</tr>



<tr>
    <td bgcolor="#666666"></td>
    <td width="159" bgcolor="#666666">   </td>


    <td bgcolor="#003366"><div align="center"><span class="Estilo7">Ejecutado </span>
    </div></td>
  </tr>

<tr>
    <td bgcolor="#666666"></td>
    <td width="159" bgcolor="#666666">   </td>


    <td bgcolor="#CCCCCC">
        <div align="right"> <fmt:formatNumber value="${montos.montoeje}" pattern="#,###,###,##0.00"/></div></td>

  </tr>





<tr>
    <td bgcolor="#666666"></td>
    <td width="159" bgcolor="#666666">   </td>


    <td><div align="center">
      <input type="submit" name="Submit" value="Cambiar datos">
    </div></td>

  </tr>





<tr >
    <td colspan="2" bgcolor="#FFFFFF" ><div align="center">
        <a href=<c:url value="/modclasificador.do">
       </c:url>><strong>Salir Cambios</strong></a>
    </div> </td>
    <td >

	</td>
  </tr>


<tr bgcolor="#990000">
    <td height="3" colspan="4"></td>
</tr>
</table>

<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
<input type=hidden name=codmonegr value='<c:out value="${codmonegr}"/>'>
<input type=hidden name=codfueneco value='<c:out value="${codfueneco}"/>'>
<input type=hidden name=monpre1 value='<c:out value="${montos.montopresu}"/>'>
<input type=hidden name=moneje value='<c:out value="${montos.montoeje}"/>'>


</form>
<p>&nbsp;</p>
</body>
</html>
