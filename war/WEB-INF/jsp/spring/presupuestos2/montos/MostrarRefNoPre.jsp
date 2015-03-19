<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Mostrando los montos presupuestados</title>
    <style type="text/css">
        <!--
.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {font-family: Verdana, Arial, Helvetica, sans-serif}
.Estilo8 {font-size: 10px}
.Estilo10 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold; }
.Estilo11 {color: #FFFFFF}
.Estilo13 {font-family: Geneva, Arial, Helvetica, sans-serif}
.Estilo14 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; }
.Estilo15 {
	font-size: 14px;
	font-weight: bold;
}
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="  ">
<table width="523" border="1" align="center" bordercolor="#CC9933">
  <tr bgcolor="#372500" >
    <td colspan="2" ><div align="center" class="Estilo4 Estilo5">Informe Egresos <br>
        Referencia no presupuestados </div></td>
  </tr>
  <tr bgcolor="#CCCCCC" >
    <td width="238" ><div align="center"><strong>Actividad</strong></div></td>
    <td width="269" ><div align="center"><strong>Tarea</strong></div></td>
  </tr>
  <tr >
    <td ><c:out value="${actividad.descripcion}"/></td>
    <td ><c:out value="${tarea.descripcion}"/></td>
  </tr>
</table>
<br>
<br>

<table width="871" border="1" align="center" bordercolor="#CC9933">

<c:if test="${supe==1 }">
                    <tr bgcolor="#EBEBEB">
                        <td colspan="3" bgcolor="#EBEBEB"><div align="left" class="Estilo8 Estilo13 Estilo14"><span class="Estilo19"><span class="Estilo15"><c:out value="${sup.descripcion}"/></span></span></div> </td>
                        <td ></td>
                        <td ></td>
                    </tr>
    </c:if>
<tr bgcolor="#BFBFBF">
    <td><span class="Estilo10">Partida</span></td>
    <td width="138" ><span class="Estilo10">  Fuente Econ&oacute;mica </span></td>

    <td><span class="Estilo10">&nbsp;Presupuestado
        <!---Ultimo # de comprobante-->
    </span></td>
    <td><span class="Estilo10"> Ejecutado
      <!--monto insertando -->
    </span></td>
    <td><span class="Estilo10">Saldo</span></td>
</tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr>
    <td><c:out value="${codmonnopreegr}"/> - <c:out value="${descla}"/> </td>
    <td><c:out value="${codfueneco}"/> </td>

    <td><div align="right">&nbsp;-                  <!--comprocompro-->
    </div></td>
    <td><div align="right">&nbsp;<c:out value="${monejenopre}"/> <!--UltiMonInser--> </div></td>
    <td><div align="right">&nbsp;- </div></td>

</tr>






<tr bgcolor="#CCCCCC">
    <td colspan="5" class="Estilo10">Saldo inicial</td>
</tr>



<tr bgcolor="#CCCCCC">
    <td width="138"><div align="center" class="Estilo10">Monto Acumulado </div></td>


    <td><span class="Estilo14"><strong>&nbsp;
        <!---Ultimo # de comprobante-->
Comprobante
    </strong> </span>      <div align="right" class="Estilo14"></div></td>
    <td> <span class="Estilo14"><strong>&nbsp;
        <!--monto insertando -->
      Fecha de Ejecuci&oacute;n </strong> </span>      <div align="right" class="Estilo14"></div></td>



    <td><div align="center" class="Estilo14"><strong>Observaciones&nbsp;</strong></div></td>

</tr>





<tr>
     <td bgcolor="#EBEBEB" ><div align="right"> <fmt:formatNumber  value="${salini.saldo_ej_i}" pattern="#,###,###,##0.00"/>   </div></td>
        <td bgcolor="#EBEBEB"><div align="right"><c:out value="${salini.comprobante}"/> </div></td>
        <td bgcolor="#EBEBEB"><div align="right"> <c:out value="${salini.fecha_saldo}"/>           <!--UltiMonInser-->
      </div></td>
        <td bgcolor="#EBEBEB"><div align="right"> <c:out value="${salini.glosa_s}"/></div></td>

</tr>

<tr bgcolor="#5B5B5B" >
    <td colspan="5" > <span class="Estilo11">Historial del monto Ejecutado </span> </td>
    </tr>








<c:forEach var="moo" items="${montos_ref}">
    <!-- Elige la tarea para mostrala -->

    <tr>
        <td><div align="right">  <c:out value="${moo.mon_acu}"/> </div></td>
        <td><div align="right"> <c:out value="${moo.comprobante}"/></div></td>
        <td><div align="right"><c:out value="${moo.fecharef}"/>           <!--UltiMonInser-->
        </div></td>
        <td><div align="right"><c:out value="${moo.obs}"/></div></td>

    </tr>
    <tr>





                    <td colspan="5">&nbsp;   </td>
    </tr>

</c:forEach>
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->

<!--FIN FIN TOTALES suma -->










<tr bgcolor="#BAAD74">
    <td height="19" colspan="6">&nbsp;</td>
</tr>
</table>


<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>



</form>

<p>&nbsp;</p>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
        <p></p>
        <div align="right"><a href="javascript:cerrarse('')">cerrar ventana</a></div>
        <p>&nbsp;</p>
</body>
</html>