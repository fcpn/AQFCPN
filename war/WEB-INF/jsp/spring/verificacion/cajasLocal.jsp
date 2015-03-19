<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

      
                <select id="id_localidad" name="" class="funcional" style="width: 240px" onblur='enviar("id_localidad")' onchange='enviar("id_localidad")'>
                    <c:forEach var="lista" items="${listalocalidad.pageList}">
                        <option value="<c:out value="${lista.id_localidad}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
      
