<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
   
       
     
<table cellpadding="0" border="0" cellspacing="0">                
<c:forEach var="lista" items="${tramites}">
<tr>
  <td class="colb" style="width: 100px"> <c:out value="${lista.descripcion}"/></td>
  <td class="colb" style="width: 200px"> <c:out value="${lista.direccion}"/></td>
  <td class=normal><a href="javascript:eliminartramite('<c:out value="${lista.codigo}"/>')"><b>[Eliminar]</b></a></td>
<tr>
</c:forEach>
</table>
