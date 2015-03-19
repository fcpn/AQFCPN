
<%@ include file="../VerCabezaCuerpo.jsp" %>
<!--
  <tr>
    <td class=colh align=center colspan=5>ADMINISTRAR MENU <c:out value="${programa}"/> </td>
  <tr>
-->  
<h3><center> Administrar Menues </center></h3> 
<table  border=0>
    <table cellspacing="0" cellpadding="0" align=center>
      <tr>
        <th colspan=3 class=colh align=center>ENLACES DE LOS ROLES</th>
      </tr>
    </table>
<table  cellspacing="0" cellpadding="0" align=center>    
  <tr>
    <td class="colh" align=center>Rol</td>
    <td class="colh" align=center>Descrici&oacute;n</td>        
  <c:forEach var="datos" items="${listaRoles.pageList}" varStatus="contador"> 
  <tr>
  
    <input type=hidden name=id_rol value='<c:out value="${datos.id_rol}"/>:<c:out value="${contador.index}"/>'></td>
<!--    <input type="hidden" name="id_rol"  value='<c:out value="${datos.id_rol}" />'>  -->
    <td class="colb">
    <a href="<c:url value="/administrarMenues1.do"><c:param name="datos" value="${datos.id_rol}"/></c:url>">
    <c:out value="${datos.rol}"/></td>
    <td class="colb"><c:out value="${datos.descripcion}"/></td>
		     
 </c:forEach>        
</table> 
</table>

<%@ include file="../VerPieCuerpo.jsp" %>
