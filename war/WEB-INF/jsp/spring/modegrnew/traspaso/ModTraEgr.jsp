<%@ include file="../../Cabecera.jsp" %>
<html>
<head>

     <script type="text/javascript">
        function confirma(miurl){

        question = confirm("Elimnar el Registro?")
        if (question !="0"){
        document.location.href = miurl;
        }
        }

</script>
    <title>Mostrando los montos presupuestados</title>
    <style type="text/css">
        <!--
.Estilo3 {color: #003399}
.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {
	color: #FFFFFF;
	font-weight: bold;
}
.Estilo25 {font-size: 10px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; }
.montitos {font-size: 11px; font-weight: normal; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo29 {font-size: 10px; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo30 {font-family: Verdana, Arial, Helvetica, sans-serif}





			-->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="  ">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#422D00" >
      <td colspan="2" ><div align="center" class="Estilo4">Informe Traspasos</div></td>
    </tr>
    <tr class="Estilo25" >
        <td width="238" bgcolor="#D6D6D6" ><div align="center" class="Estilo25">Actividad  </div></td>
        <td width="269" bgcolor="#D6D6D6" ><div align="center" class="Estilo25">Tarea  </div></td>
    </tr>
    <tr >
      <td ><div align="left" class="montitos"><c:out value="${actividad.descripcion}"/></div></td>
      <td ><div align="left" class="montitos"><c:out value="${tarea.descripcion}"/></div></td>
    </tr>
</table>
<br>
<br>

<table width="812" border="1" align="center" bordercolor="#CC9933">
<tr bgcolor="#D6D6D6" class="Estilo25">
    <td width="193"><span class="Estilo25">Clasificador</span></td>
    <td width="236" ><span class="Estilo25"> - Fuente Econ&oacute;mica </span></td>

    <td width="148"><span class="Estilo25">&nbsp;Monto Presupuestado
        <!---Ultimo # de comprobante-->
    </span></td>
    <td width="129"><span class="Estilo25"> Monto Ejecutado
        <!--monto insertando -->
    </span></td>
    <td width="131"><span class="Estilo25">Saldo</span></td>
</tr>

<!-- Elige la tarea para mostrala -->


<!--  funciona   -->

<tr>
    <td><div class="montitos"><c:out value="${codmonegr}"/> - <c:out value="${descla}"/> </div></td>
    <td><div class="montitos"><c:out value="${codfueneco}"/> - <c:out value="${fuente.descripcion}"/></div></td>

    <td><div align="right" class="montitos">&nbsp;<c:out value="${monto}"/>                  <!--comprocompro-->
    </div></td>
    <td><div align="right" class="montitos">&nbsp;<c:out value="${moneje}"/>                  <!--UltiMonInser-->
    </div></td>
    <td><div align="right" class="montitos">&nbsp;<c:out value="${saldo}"/> </div></td>

</tr>







<!--Montos No presupuestados -->
<tr bgcolor="#838383" >
    <td colspan="5" bgcolor="#838383" > <span class="Estilo5">Monto Traspaso de la Partida <c:out value="${codmonegr}"/> a:</span> </td>
    </tr>

<tr>
    <td bgcolor="#D6D6D6"><div align="center"><span class="Estilo25">Partida de recepcion de monto </span></div></td>
    <td width="236" bgcolor="#D6D6D6"><div align="center" class="Estilo25">Glosa</div></td>


    <td bgcolor="#D6D6D6"><span class="Estilo29"><strong>&nbsp;
        <!---Ultimo # de comprobante-->
Comprobante
    </strong> </span>      <div align="right" class="Estilo29"></div></td>
    <td bgcolor="#D6D6D6"> <span class="Estilo29"><strong>&nbsp;
        <!--monto insertando -->
      Fecha deTraspaso </strong> </span>      <div align="right" class="Estilo29"></div></td>



    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto Acumulado&nbsp;</strong></div></td>

        <td bgcolor="#D6D6D6"><div align="center" class="Estilo25">Modificar registro</div></td>
          <td bgcolor="#D6D6D6"><div align="center" class="Estilo25">Eliminar</div></td>


</tr>

<c:forEach var="moo" items="${his_tra}">
    <!-- Elige la tarea para mostrala -->

    <tr>
        <td><div class="montitos"><c:out value="${moo.codmonegr2}"/> - <c:out value="${moo.descla2}"/></div></td>
        <td><div align="justify" class="montitos"><c:out value="${moo.glosa}"/></div> </td>
        <td><div align="right" class="montitos"><c:out value="${moo.cbte}"/></div></td>
        <td><div align="right" class="montitos"><c:out value="${moo.fecha}"/>           <!--UltiMonInser-->
        </div></td>
        <td> <div align="right" class="montitos"><c:out value="${moo.monto}"/> </div></td>

        <td bgcolor="#BDD6FD">
            <a href=<c:url value="/ModTraEgr2.do">
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="monto" value="${moo.monto}"/>
                       <c:param name="moneje" value="${moo.moneje}"/>
                       <c:param name="saldo" value="${moo.saldo}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="codmonegr2" value="${moo.codmonegr2}"/>

<c:param name="codmonegr_c" value="${codmonegr}"/>
<c:param name="monto_c" value="${monto}"/>
<c:param name="moneje_c" value="${moneje}"/>
<c:param name="saldo_c" value="${saldo}"/>



<c:param name="id" value="${moo.id}"/>
                       </c:url>><div align="right" class="montitos">Modificar</div>
            </a>



            </td>

        <td bgcolor="#FF6464">

  <a  target="mainFrame" onClick="confirma('<c:url value="/ModTraEgr4.do">
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="montoe" value="${moo.monto}"/>
                       <c:param name="moneje" value="${moo.moneje}"/>
                       <c:param name="saldo" value="${moo.saldo}"/>
                       <c:param name="codacti" value="${actividad.codacti}"/>
                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                       <c:param name="codmonegr2" value="${moo.codmonegr2}"/>
                           <c:param name="codmonegr" value="${moo.codmonegr}"/>

<c:param name="id" value="${moo.id}"/>
                    </c:url>'); return false;"> <div align="right" class="montitos">Eliminar</div>
            </a>




		</td>

    </tr>


</c:forEach>
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->



<!--FIN FIN TOTALES suma -->










<tr>
    <td height="19" colspan="7" bgcolor="#993300"><div align="right"><span class="Estilo3"><!--[Salir a Men&uacute; Principal]--> </span></div></td>
</tr>

<tr>
    <td colspan="5" bgcolor="#003366" > <span class="Estilo5"> </span> <br>
      <br></td>
</tr>


<tr>
    <td colspan="5" bgcolor="#838383" align="left"> <span class="Estilo5">Montos Traspasados a la partida <c:out value="${codmonegr}"/> de:</span></td>
</tr>

<tr>
    <td bgcolor="#D6D6D6"><div align="center"><span class="Estilo25">Partida </span></div></td>
    <td width="236" bgcolor="#D6D6D6"><div align="center" class="Estilo25">Glosa</div></td>


    <td bgcolor="#D6D6D6"><span class="Estilo29"><strong>&nbsp;
        <!---Ultimo # de comprobante-->
Comprobante
    </strong> </span>      <div align="right" class="Estilo29"></div></td>
    <td bgcolor="#D6D6D6"> <span class="Estilo29"><strong>&nbsp;
        <!--monto insertando -->
      Fecha deTraspaso </strong> </span>      <div align="right" class="Estilo29"></div></td>



    <td bgcolor="#D6D6D6"><div align="center" class="Estilo29"><strong>Monto Acumulado&nbsp;</strong></div></td>

</tr>
<c:forEach var="moo2" items="${his_tra2}">
    <!-- Elige la tarea para mostrala -->

    <tr>
        <td><div class="montitos"><c:out value="${moo2.codmonegr}"/> - <c:out value="${moo2.descla}"/></div></td>
        <td><div align="justify" class="montitos"><c:out value="${moo2.glosa}"/></div> </td>
        <td><div align="right" class="montitos"><c:out value="${moo2.cbte}"/></div></td>
        <td><div align="right" class="montitos"><c:out value="${moo2.fecha}"/>           <!--UltiMonInser-->
        </div></td>
        <td> <div align="right" class="montitos"><c:out value="${moo2.monto}"/> </div></td>

    </tr>


</c:forEach>


</table>


<input type=hidden name=codacti_c value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar_c value='<c:out value="${tarea.codtar}"/>'>
<input type=hidden name=codtar_c value='<c:out value="${codfuneco}"/>'>
<input type=hidden name=codmonegr_c value='<c:out value="${codmonegr}"/>'>
<input type=hidden name=monto_c value='<c:out value="${monto}"/>'>
<input type=hidden name=moneje_c value='<c:out value="${moneje}"/>'>
<input type=hidden name=saldo_c value='<c:out value="${saldo}"/>'>

</form>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>