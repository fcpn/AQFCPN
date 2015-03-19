

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<table width="400" border="1" align="center" >

 <c:forEach var="g" items="${lista_proveedor}">
  <tr>

  <td style="cursor:pointer" onclick="al_pro('<c:out value="${g.nit}"/>','<c:out value="${g.proveedor}"/>');">
      
      <font color="#FF6600"><c:out value="${g.nit}"/>-<c:out value="${g.proveedor}"/></font>
     
  </td>

  </tr>

</c:forEach>
</table>