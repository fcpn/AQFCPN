<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<!-- Reportes _ -->
<%@ include file="../../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>
<br><br>

<table>
  <tr>
    <td class="colb" align="center" colspan="4">Reporte Total</td>
  </tr>
  <tr>
    <td class="colh" align="center">Nro.</td>
    <td class="colh" align="center">TARJETA</td>
    <td class="colh" align="center">CODIGO</td>
    <td class="colh" align="center">CEDULA</td>
    <td class="colh" align="center">OBS. ANVERSO</td>
    <td class="colh" align="center">OBS. REVERSO</td>
  </tr>
  <c:forEach var="reporte" items="${listaReporteTotal.pageList}" varStatus="i">
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
    <td class="normal" align="center"><a href="javascript:history.back(0);">Volver</a></td>
  </tr>
</table>
<br />
<!-- Fin Reportes _ -->
<%@ include file="../../VerPieCuerpo.jsp" %>