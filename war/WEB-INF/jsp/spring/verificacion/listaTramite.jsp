<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:forEach var="lista" items="${listatramitestemporal.pageList}">
<tr style="position:relative" ><td class="colb" style="position:relative; width: 150px"><c:out value="${lista.descripcion}"/></td>
<td class="colb" style="position:relative; width: 340px" > <c:out value="${lista.nombre1}"/></td>


<td class=normal><a href="javascript:quitarPar('<c:out value="${lista.cod_tramite}"/>','listtramr','3')" style="text-decoration: none"><b>[Eliminar]</b></a></td>

</c:forEach>
