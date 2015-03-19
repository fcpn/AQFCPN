<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<style type="text/css">
<!--
.Estilo2 {font-size: 11px; color: #FEFEFE;}
-->
</style>

<table align="center">
    <c:forEach var="gg" items="${lista_grupo}">
    <tr>
        <td>
            <c:out value="${gg.codgru}"/>
        </td>
        <td>- <c:out value="${gg.descripcion}"/> </td>
    </tr>
    </c:forEach>
</table>

<table align="right">
    <tr>
      <td  bgcolor="#DBDB20" style="cursor:pointer" onclick="buscar('<c:out value="${codtar}"/>');">
      <font color="#091C5A"><strong> Ir Para Atras</strong></font>
      </td>
    </tr>
</table>
<br><br>




<table width="260" border="1" align="center">
 
 <c:forEach var="g" items="${lista_subgrupos}">
  <tr>

  <td bgcolor="#5A6DA9" width="20" style="cursor:pointer" onclick="a_partidas('<c:out value="${g.codmonegr2}"/>','<c:out value="${codmonegr1}"/>','1');">
  <span class="Estilo2">[<strong><c:out value="${g.codmonegr2}"/></strong>]</span>
  </td>
  <td bgcolor="#5A6DA9" width="10" style="cursor:pointer" onclick="a_partidas('<c:out value="${g.codmonegr2}"/>','<c:out value="${codmonegr1}"/>','1');"><span class="Estilo2">[<strong><c:out value="${g.des2}"/></strong>]</span> </td>
  </tr>
  <tr>
      <td colspan=2""><c:out value="${g.descripciones2}"/></td>
  </tr>
</c:forEach>
</table>


<table align="right">
    <tr>
      <td  bgcolor="#DBDB20" style="cursor:pointer" onclick="buscar('<c:out value="${codtar}"/>');">
      <font color="#091C5A"><strong> Ir Para Atras</strong></font>
      </td>
    </tr>
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



 