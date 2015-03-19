<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<table width="200" border="0">
 
 <c:forEach var="g" items="${lista_certificado}">
  <tr>

  <td style="cursor:pointer" onclick="copi('<c:out value="${g.descripciones}"/>', '<c:out value="${g.codfueneco}"/>', '<c:out value="${g.codtar}"/>', '<c:out value="${g.codmonegr}"/>', '<c:out value="${g.saldo}"/>', '<c:out value="${g.sumcom}"/>', '<c:out value="${g.ref123}"/>');">
  [<c:out value="${g.codmonegr}"/>] [<c:out value="${g.codfueneco}"/>] <c:out value="${g.descripciones}"/>
  </td>
  </tr>
    
</c:forEach>
</table>

 <!--

<!-- '<c:out value="${g.correlativo}"/>', '<c:out value="${g.no_rut}"/>'
<a  href="('<c:url value="">
    <c:param name="codtar" value="${g.codfueneco}"/>
    <c:param name="descripcion" value="${g.descripciones}"/>

                   </c:url>')">    </a>

<c:out value="${g.codpartida}"/> -- <c:out value="${g.des_partida}"/> --
         <c:out value="${g.ref123}"/> -- <c:out value="${g.codfueneco}"/> --
         <c:out value="${g.descripciones}"/> -- <c:out value="${g.codtar}"/> --
         <c:out value="${g.no_rut}"/> -- <c:out value="${g.correlativo}"/> --
         <c:out value="${g.saldo}"/> <br>




-->



 