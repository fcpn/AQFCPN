<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>
<br><br>


<SCRIPT LANGUAGE="JavaScript">
  function fullScreen() {
  window.open('<c:url value="/transcripcion1.do"/>','','fullscreen=yes, scrollbars=yes');
}

</script>


<table>
  <tr>
    <td>
    <input type="button" value="Solicitar" onclick='fullScreen()'>
    </td>
    <td class="colb">Solicitar una tarjeta para transcripci&oacute;n</td> 
  </tr>    
</table>
<br>
<table>
  <tr>
    <td class="colh" align="center">Nro.</td>
    <td class="colh" align="center">Nro. general</td>
    <td class="colh" align="center">Descripci&oacute;n</td>
    <td class="colh" align="center">Estado</td>
  </tr>

  <!-- Reportes _ -->
  <c:forEach var="reporte" items="${listaReporteDiario.pageList}">
    <tr>
      <td class="normal" align="center"><c:out value="${reporte.nro}" /></td>
      <td class="normal" align="center"><c:out value="${reporte.nroGeneral}" /></td>
      <td class="normal" align="center"><c:out value="${reporte.descripcion}" /></td>
      <td class="normal" align="center"><c:out value="${reporte.estado}" /></td>
    </tr>
  </c:forEach>
</table>
<br />
<table>
  <tr>
    <td class="normal" align="justify"><a href='<c:url value="/transcripcion3.do"/>'>Reporte Mensual</a></td>
  </tr>
  <tr>
    <td class="normal" align="justify"><a href='<c:url value="/transcripcion4.do"/>'>Reporte Total</a></td>
  </tr>
  <tr>
    <td class="normal" align="center"><a href='<c:url value="/reporteDiario.do"/>'><img src="<c:out value="./images/pdf_icon.jpg"/>" border="0" width="30">Descargar PDF</a></td>
  </tr>
  <!-- Fin Reportes _ -->
  
</table>  

<%@ include file="../VerPieCuerpo.jsp" %> 