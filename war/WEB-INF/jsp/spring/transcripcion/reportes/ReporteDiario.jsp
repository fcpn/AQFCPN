<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<!-- Reportes _ -->
<%@ include file="../../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>
<br><br>
<!--
<table align=center width="60%">
    <tr>
        <td align="center"><a href="<c:url value="/transcripcion1.do"></c:url>" target="_blank"><img alt="TRANSCRIPCION" src='./images/mano.jpg' border=0/></a></td>
        <td align="center"><img alt="REPORTES" src='./images/images.jpg' border=0/></td>        
    </tr>    
    <tr>
        <td class=colb align="center">TRANSCRIPCION</td>
        <td class=colb align="center">REPORTES</td>              
    </tr>
</table>
-->

<SCRIPT LANGUAGE="JavaScript">
  function fullScreen() {
  window.open('<c:url value="/transcripcion1.do"/>','','fullscreen=yes, scrollbars=yes');
}

</script>

<table>
  <tr>
    <td class="colb" align="center" colspan="4">Reporte Diario</td>
  </tr>
  <tr>
    <td class="colh" align="center">Nro.</td>
    <td class="colh" align="center">TARJETA</td>
    <td class="colh" align="center">CODIGO</td>
    <td class="colh" align="center">CEDULA</td>
    <td class="colh" align="center">OBS. ANVERSO</td>
    <td class="colh" align="center">OBS. REVERSO</td>
  </tr>
  <c:forEach var="reporte" items="${listaReporteDiario.pageList}" varStatus="i">
    <tr>
      <td class="normal" align="center"><c:out value="${i.index+1}" /></td>
      <td class="normal" align="center"><c:out value="${reporte.id_tarjeta}" /></td>
      <td class="normal" align="center"><c:out value="${reporte.id_persona}" /></td>
      <td class="normal" align="center"><c:out value="${reporte.cedula}" /></td>
      <td class="normal" align="center"><c:out value="${reporte.comentario_a}" /></td>
      <td class="normal" align="center"><c:out value="${reporte.comentario_r}" /></td>
    </tr>
  </c:forEach>
</table>
<br />
<table>
  <tr>
    <td class="normal" align="center"><a href='<c:url value="/reportesm.do"/>'>Reporte Mensual</a></td>
    <td class="normal" align="center"><a href='<c:out value="${archivoMensual}"/>'><img src="<c:out value="./images/pdf_icon.jpg"/>" border="0" width="30"></a></td>
  </tr>
  <tr>
    <td class="normal" align="center"><a href='<c:url value="/reportest.do"/>'>Reporte Completo</a></td>
    <td class="normal" align="center"><a href='<c:out value="${archivoTotal}"/>'><img src="<c:out value="./images/pdf_icon.jpg"/>" border="0" width="30"></a></td>
  </tr>
</table>
<!-- Fin Reportes _ -->
	
  

<%@ include file="../../VerPieCuerpo.jsp" %>