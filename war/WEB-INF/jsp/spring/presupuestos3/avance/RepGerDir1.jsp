

<%@ include file="../../Cabecera.jsp" %>

<html>
<head>

<title>Documento sin t&iacute;tulo</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style type="text/css">
<!--
.Estilo1 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
	font-size: 12px;
}
.Estilo2 {font-family: Verdana, Arial, Helvetica, sans-serif}
.Estilo3 {
	font-size: 9px;
	font-weight: bold;
}
.Estilo4 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 9px; }
.Estilo5 {
	color: #FFFFFF;
	font-weight: bold;
}
.Estilow {
	font-size: 9px;
	font-family: Verdana, Arial, Helvetica, sans-serif;}

.Estilo7 {font-family: Verdana, Arial, Helvetica, sans-serif; font-weight: bold; font-size: 12px; color: #FFFFFF; }
.Estilo8 {font-size: 9px; font-family: Verdana, Arial, Helvetica, sans-serif; color: #FFFFFF; }



-->
</style>


<script type="text/javascript" src="prototype.js"></script>
<script type="text/javascript">
  function seleccionar_todo()
   {//Funcion que permite seleccionar todos los checkbox

   form = document.forms["form1"]
   for (i=0;i<form.elements.length;i++)
       {
       if(form.elements[i].type == "checkbox")form.elements[i].checked=1;
       }

   }

   function deseleccionar_todo()
   {//Funcion que permite deseleccionar todos los checkbox

   form = document.forms["form1"]
   for (i=0;i<form.elements.length;i++)
       {
       if(form.elements[i].type == "checkbox")form.elements[i].checked=0;
       }
   }

</script>


</head>

<body>

<form name="form1" method="post" action="<c:url value="/RepGerDir2.do"/>">
  <input type=hidden name=fecha1 value='<c:out value="${fecha1}"/>'>
  <input type=hidden name=fecha2 value='<c:out value="${fecha2}"/>'>
  <input type=hidden name=f1n value='<c:out value="${f1n}"/>'>
  <input type=hidden name=f2n value='<c:out value="${f2n}"/>'>
    <br>
  <table width="437" border="0" align="center">
    <tr>
      <td colspan="3"> <img src="./././imagenesgeren/avancetarea.png" width="512" height="55"></td>
    </tr>

<tr><TD colspan="3">
<table width="144" border="1" align="center">
  <tr bgcolor="#003366">
    <td colspan="2"><div align="center"><span class="Estilo8">Tomando en Cuenta Los montos Comprometidos? </span></div></td>
  </tr>
  <tr>
    <td width="101"><div align="center">si
        <input name="cc" type="radio" value="si">
    </div></td>
    <td width="83"><div align="center">no
        <input name="cc" type="radio" value="no" checked>
    </div></td>
  </tr>
</table></TD>
</tr>

    <tr bgcolor="#003366">
      <td colspan="3"><div align="center" class="Estilo7">FUENTES EC&Oacute;NOMICAS </div></td>
    </tr>
    <tr>
      <td width="53" bgcolor="#CCCCCC"><div align="center"><strong><span class="Estilo4">C&oacute;digo</span></strong></div></td>
      <td width="374" bgcolor="#CCCCCC"><div align="center"><strong><span class="Estilo4">Descripci&oacute;n</span></strong></div></td>
      <td width="77" align="center">
        <table width="62" border="0" align="center">
          <tr bgcolor="#CCCCCC">
            <td width="56"><div align="center" class="Estilo2 Estilo3">Seleccionar</div></td>
          </tr>
          <tr>


            <td><div align="center"><span class="Estilo4"><a href='javascript:seleccionar_todo()' >Todos</a> </span></div>
                <div align="center"></div></td>
          </tr>
          <tr>
            <td><div align="center"><span class="Estilo4"><a href='javascript:deseleccionar_todo()' >Ninguno</a></span></div></td>
          </tr>
      </table></td>
    </tr>

<c:forEach var="f" items="${fuentes}">
	<tr onMouseOver="this.style.backgroundColor='#CC9999';" onMouseOut="this.style.backgroundColor='#ffffff';">
      <td height="23"><span class="Estilo4"><c:out value="${f.codfueneco}"/></span></td>
      <td><span class="Estilo4"><c:out value="${f.descripcion}"/></span></td>
      <td><div align="center">
        <input name="fuentes" type="checkbox" id="fuentes"  value="<c:out value="${f.codfueneco}"/>::<c:out value="${f.descripcion}"/>">
      </div></td>
    </tr>
</c:forEach>

  </table>
  <table width="606" border="0" align="center">
    <tr>
      <td width="503" height="2" bgcolor="#000000"></td>
    </tr>
  </table>

   <table width="606" border="0" align="center">
    <tr>
      <td width="503" height="2" bgcolor="#000000"></td>
    </tr>
  </table>
  <table width="517" border="0" align="center">
    <tr>
      <td colspan="3">&nbsp; </td>
    </tr>
    <tr bgcolor="#CCCCCC">
      <td colspan="3"><div align="center" class="Estilo1">TAREAS</div></td>
    </tr>
    <tr>
      <td width="54" bgcolor="#003366"><div align="center" class="Estilo5"><span class="Estilo4">C&oacute;digo</span></div></td>
      <td width="372" bgcolor="#003366"><div align="center" class="Estilo5"><span class="Estilo4">Descripci&oacute;n</span></div></td>
      <td width="77" align="center" bgcolor="#003366">&nbsp;      </td>
    </tr>
  <c:forEach var="t" items="${tareas}">
	<tr onMouseOver="this.style.backgroundColor='#CC9999';" onMouseOut="this.style.backgroundColor='#ffffff';">
      <td height="23"><span class="Estilo4"><c:out value="${t.codtar}"/></span></td>
      <td><span class="Estilo4"><c:out value="${t.descripcion}"/></span></td>
      <td><div align="center">
        <input name="tareas" type="checkbox" id="tareas"  value="<c:out value="${t.codtar}"/>:<c:out value="${t.descripcion}"/>">
      </div></td>
    </tr>
</c:forEach>
  </table>
  <br>
  <table width="517" border="0" align="center">

    <tr>
      <td width="54">&nbsp;</td>
      <td width="305">&nbsp;</td>
      <td width="144" align="center"><div align="right">
        <input type="submit" name="Submit" value="Aceptar">
      </div></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>
<p>&nbsp;</p>
</body>
</html>
