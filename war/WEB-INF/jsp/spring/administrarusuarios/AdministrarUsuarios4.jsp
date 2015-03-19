<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">

<%@ include file="../Cabecera.jsp" %>

<table width=100% border="0" align=center>
  <tr class=colb>
    <th class=colh align=center>ADMINISTRAR USUARIOS <c:out value="${programa}"/></th>
</table>

<table>
 <tr>
  <td class=colh>Periodo::
  <td class=colb><c:out value="${periodo}"/>
  <td class=colh>Gestion::
  <td class=colb><c:out value="${gestion}"/>
  <td class=colh>Programa::
  <td class=colb><c:out value="${programa}"/>
</table>
<br>

<table border="0" cellspacing="0" cellpadding="0">
 <tr>
  <td class=colh>Nombres:
  <td class=colb><c:out value="${nombres}"/>
  <td class=colh>Cargo:
  <td class=colb><c:out value="${cargo}"/>
 <tr> 
  <td class=colh>Usuario:
  <td class=colb><c:out value="${usuario}"/>
</table>
<br><br>
<form name="forma" method="POST" action='<c:url value="/administrarUsuarios.do"/>' >
<table align=center border="0" cellspacing="0" cellpaddign="0">
<tr>
  <td colspan=2 class=colh>Eliminar</td>
<tr>
  <td colspan=2 align=center class=colb>
  <table>
    <tr>
      <td align=left class=normal><b>ADVERTENCIA:</b></td>
    <tr>
      <td align=center class=normal>El actual Usuario del sistema sera puesto en inactividad</td>
    <tr>
  <td align=center class=normal> <input type=hidden name=usuario value='<c:out value="${usuario}"/>' />
  <input type=hidden name=accion value='Eliminar1' />
                                     <input type="submit" value="Aceptar"></td>
  </table>
</table>
</form>
<%@ include file="../VerPieCuerpo.jsp" %>
