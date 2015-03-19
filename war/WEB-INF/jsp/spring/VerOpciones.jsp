<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<table width="15%" bgcolor="#008800" border="0" cellspacing="2" cellpadding="3">
  <tr bgcolor="#CCCCCC">
  <td colspan=2><b>Usuarios</b></td>
  </tr>
<c:forEach var="opciones" items="${listaDeOpciones.pageList}">
  <tr bgcolor="#FFFF88">
    <td>
      <c:out value="${opciones.id_usuario}"/>
    </td>
    <td>
      <c:out value="${opciones.usuario}"/>
    </td>
    <td>
      <c:out value="${opciones.clave}"/>
    </td>
</c:forEach>
