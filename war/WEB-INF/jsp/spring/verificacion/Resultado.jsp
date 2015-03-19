<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:forEach var="lista" items="${listagrupo}">
  <option value="<c:out value="${lista.cod_grp}"/>"><c:out value="${lista.descripcion}"/></option>
</c:forEach>
          
