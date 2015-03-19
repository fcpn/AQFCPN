

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<table width="400" border="1" align="center" >

 <c:forEach var="g" items="${lista_medida}">
  <tr>

  <td style="cursor:pointer" onclick="al_in('<c:out value="${iddd}"/>','<c:out value="${g.descripcion}"/>');">
      
      <font color="#FF6600"> <c:out value="${g.descripcion}"/></font>
     
  </td>

  </tr>

</c:forEach>
</table><br>

<!--
 <fieldset>
          <legend>
      <font color="#FF6600"> valor </font>
      </legend>
      </fieldset>

-->