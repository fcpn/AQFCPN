<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<%@ include file="../Cabecera.jsp" %>

<script language='JavaScript' SRC="./ajax.js"></script>
<script language='JavaScript' SRC="./shortcut.js"></script>

<SCRIPT LANGUAGE="JavaScript">
  function fullScreen() {
  window.open('<c:url value="/transcripcion1.do"/>','transcripcion','fullscreen=yes, scrollbars=yes');
}

function getbtnsolicitar() {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();
      req.open('GET','<c:url value="/getbtnsolicitar.do"/>', true);      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById("solicitar").innerHTML = mes;
                }
           }                   
        };
        req.send(null);    
}
function init() {
	shortcut.add("F5", function() {
	    ;
	});
}
window.onload=init;


</script>
<script language='JavaScript' SRC="./shortcut.js"></script>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE VERIFICACION</th>
</table>
<br><br>

<div id="solicitar"><input class="button" type="button" value="Conectando con el servicio" disabled>&nbsp;<img src="images/loading.gif" width="20" height="20" alt="loading"/></div>

<br>
<table>
  <tr>
    <td class="colh" align="center" width="50px">Nro.</td>
    <td class="colh" align="center" width="100px">TARJETA</td>
    <td class="colh" align="center" width="100px">CODIGO</td>
    <td class="colh" align="center" width="100px">CEDULA</td>
    <td class="colh" align="center" width="200px">OBS. ANVERSO</td>
    <td class="colh" align="center" width="200px">OBS. REVERSO</td>
  </tr>
  <!-- Reportes _ -->
  <c:forEach var="reporte" items="${listaReporteDiario.pageList}" varStatus="i">
    <tr>
      <td class="normal" align="center" width="50px"><c:out value="${i.index+1}" /></td>
      <td class="normal" align="center" width="100px"><c:out value="${reporte.id_tarjeta}" /></td>
      <td class="normal" align="center" width="100px"><c:out value="${reporte.id_persona}" /></td>
      <td class="normal" align="center" width="100px"><c:out value="${reporte.cedula}" /></td>
      <td class="normal" align="center" width="200px"><c:out value="${reporte.comentario_a}" /></td>
      <td class="normal" align="center" width="200px"><c:out value="${reporte.comentario_r}" /></td>
    </tr>
  </c:forEach>
</table>

<script>setInterval("getbtnsolicitar()",3000)</script>

<%@ include file="../VerPieCuerpo.jsp" %> 