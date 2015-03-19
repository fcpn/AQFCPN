<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<table>
<c:forEach var="lista" items="${lstProfesiones}">
<tr>
  <td class=colb><c:out value="${lista.descripcion}"/></td>
  <td class=normal><a href="javascript:enviarprofesion('<c:out value="${lista.cod_grp}"/>','less')" style="text-decoration: none"><b>[Eliminar]</b></a></td>
</tr>  
</c:forEach>          
</table>
