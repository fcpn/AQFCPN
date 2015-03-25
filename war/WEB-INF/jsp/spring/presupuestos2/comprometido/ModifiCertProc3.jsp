<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Mostrando los montos presupuestados</title>
   <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
 <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
 <script type="text/javascript">
     $(document).ready(function(){
         if($("#glo_rut").html()=="null")
         {
             $("#glo_rut").html("");
         }
     });
 </script>
</head>
<body>
<p>&nbsp;</p>
<div id="content">
<form name="form1" method="post" action="<c:url value="/ModifiCertProc4.do"/>">
<table width="650" height="239" border="1" align="center">
    <tr>
        <th colspan="8"><strong>
            <div align="center">Correlativo # <c:out value="${num_sol}"/></div><br>
            <div align="center">Realizado en fecha <c:out value="${fecha}"/></div></strong>
        </th>
    </tr>
    <tr >
        <th width="146"><div align="center"><strong>Requerimiento especificado</strong></div></th>
        <th width="48"><div align="center"><strong>Cantidad</strong></div></th>
        <th width="48" ><div align="center"><strong>Monto</strong></div></th>
        <th width="52"><div align="center"><strong>Tarea</strong></div></th>
        <th width="60"><div align="center"><strong>Partida</strong></div></th>
        <th width="68"><div align="center"><strong>FF-OF</strong></div></th>
        <th><div align="center"><strong>Responsable de tarea</strong></div></th>
        <th width="69" ><div align="center"><span class="Estilo1">Modificar</span></div></th>
    </tr>
    <tr>
        <!--           <c:out value="${g.glosa}"/> -->
	<td height="89" valign="top">
          <textarea name="especificacion" cols="20" id="textarea"><c:out value="${lis_cert.glosa}"/></textarea>
        </td>
        <td valign="top"><div align="center" >
          <input name="cantidad" type="text" id="cantidad" size="5" value="<c:out value="${lis_cert.cantidad}"/>">
        </td>
        <td valign="top">
          <input name="monto" type="text" id="monto" size="5" value="<c:out value="${lis_cert.monto}"/>">
        </td>

        <td valign="top"><c:out value="${lis_cert.codtar}"/>
        </td>
	    <!--  <c:out value="${g.codmonegr}"/> -->
        <td valign="top"><div align="center">
            <input name="partida" type="text" id="partida" size="7"  value="<c:out value="${lis_cert.codmonegr}"/>">
         </div>
        </td>

        <td valign="top"><div align="center">
          <input name="codfueneco" type="text" id="codfueneco" size="6"  value="<c:out value="${lis_cert.codfueneco}"/>">
          </div>
        </td>

        <td valign="top"><div align="center"><textarea name="responsable" cols="25" id="responsable"><c:out value="${lis_cert.responsable}"/></textarea></div>  </td>

        <td><div align="center"> <input type="submit" name="Submit" value="modificar"></div></td>
    </tr>
    <tr bgcolor="#CCCCCC">
        <td rowspan="2" >&nbsp;</td>
	<th colspan="4" valign="top"><strong>Otros para la glosa y RUT</strong></th>
	<td colspan="4" rowspan="2" >&nbsp;</td>
    </tr>
    <tr>
        <td height="85" colspan="4" valign="top"><div align="center"><textarea name="glo_rut" cols="18" id="glo_rut" placeholder="S/R"><c:out value="${lis_cert.glo_rut}"/></textarea>
	    </div>
        </td>
    </tr>


</table>

<input type=hidden name="id" id="id" value='<c:out value="${lis_cert.id}"/>'>
<input type=hidden name="codmonegran" id="codmonegran" value='<c:out value="${lis_cert.codmonegr}"/>'>
<input type=hidden name="codfuenecoan" id="codfuenecoan" value='<c:out value="${lis_cert.codfueneco}"/>'>
<input type=hidden name="montoan" id="montoan" value='<c:out value="${lis_cert.monto}"/>'>
<input type=hidden name="id_usuario_certificado" id="montoan" value='<c:out value="${lis_cert.id_usuario_certificado}"/>'>
<input type=hidden name="glosaan" id="glosaan" value='<c:out value="${lis_cert.glosa}"/>'>
<input type=hidden name="cantidadan" id="cantidadan" value='<c:out value="${lis_cert.cantidad}"/>'>
<input type=hidden name="responsablean" id="responsablean" value='<c:out value="${lis_cert.responsable}"/>'>
<input type=hidden name="glo_rutan" id="glo_rutan" value='<c:out value="${lis_cert.glo_rut}"/>'>


<input type=hidden name="codtar" id="codtar" value='<c:out value="${codtar}"/>'>
  <input type=hidden name="codacti" id="codacti" value='<c:out value="${codacti}"/>'>
 <input type=hidden name="num_sol" id="num_sol" value='<c:out value="${num_sol}"/>'>
  <input type=hidden name="fecha" id="fecha" value='<c:out value="${fecha}"/>'>
<input type=hidden name="fechalit" id="fechalit" value='<c:out value="${lis_cert.fechalit}"/>'>
    <input type=hidden name="fechahrs" id="fechahrs" value='<c:out value="${lis_cert.fechahrs}"/>'>
<input type=hidden name="id" id="id" value='<c:out value="${id}"/>'>

</form>
<div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
<p>&nbsp;</p>
</body>
</html>