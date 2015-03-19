<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<!-- Reportes _ -->
<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>
<br><br>

<table>
  <tr>
    <td class="colb" align="center" colspan="6">Reporte Mensual</td>
  </tr>
  <tr>
    <td class="colh" align="center" width="50px">Nro.</td>
    <td class="colh" align="center" width="100px">TARJETA</td>
    <td class="colh" align="center" width="100px">CODIGO</td>
    <td class="colh" align="center" width="100px">CEDULA</td>
    <td class="colh" align="center" width="200px">OBS. ANVERSO</td>
    <td class="colh" align="center" width="200px">OBS. REVERSO</td>
  </tr>
  <c:forEach var="reporte" items="${listaReporteMensual.pageList}" varStatus="i">
    <tr>
      <td class="normal" align="center" width="50px"><c:out value="${i.index+1}" /></td>
      <td class="normal" align="center" width="100px"><c:out value="${reporte.id_tarjeta}" /></td>
      <td class="normal" align="center" width="100px"><c:out value="${reporte.id_persona}" /></td>
      <td class="normal" align="center" width="100px"><c:out value="${reporte.cedula}" /></td>
      <td class="normal" align="center" width="200px"><c:out value="${reporte.comentario_a}" /></td>
      <td class="normal" align="center" width="200px"><c:out value="${reporte.comentario_r}" /></td>
    </tr>
  </c:forEach>
  <tr>
    <td class="normal" align="center"><a href='<c:url value="/reporteMensual.do"/>'><img src="<c:out value="./images/pdf_icon.jpg"/>" border="0" width="30">Descargar PDF</a></td>
  </tr>
</table>
<br />
<table>
  <tr>
    <td class="normal" align="center"><a href="javascript:history.back(0);">Volver</a></td>
  </tr>
</table>
<br />
<!-- Fin Reportes _ -->
<%@ include file="../VerPieCuerpo.jsp" %>