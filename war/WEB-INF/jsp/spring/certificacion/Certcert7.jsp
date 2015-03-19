<style type="text/css">
<!--
.Es_b {
	font-size: 10px;
	font-weight: bold;
}
-->
</style>


<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<table width="400" border="1" align="center" >
 
 <c:forEach var="g" items="${lista_certificado}">
  <tr>

  <td style="cursor:pointer"  colspan="7" onclick="a_partidas_like('<c:out value="${g.codsub}"/>','<c:out value="${g.codgru}"/>','<c:out value="${g.descripciones}"/>','<c:out value="${g.codpartida}"/>');">
  [<c:out value="${g.codpartida}"/>] <c:out value="${g.descripciones}"/> <span class="Es_b">[Buscar Partidas disponibles]</span>
  </td>
  </tr>
    
</c:forEach>
</table><br>
