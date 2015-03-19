<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<%@ include file="../Cabecera.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE SUPERVISION</th>
</table>
<br><br>
  <table border="0" cellspacing="0" cellpadding="0">
 <tr>
  <td class=colh width=15%>Periodo::
  <td class=colb width=5%><c:out value="${periodo}"/>
  <td class=colh width=20%>Gestion::
  <td class=colb width=20%><c:out value="${gestion}"/>
  <td class=colh width=20%>Programa::
  <td class=colb width=20%><c:out value="${programa}"/>
    </tr>
    <tr><td><br /></td></tr>
    <tr><td><br /></td></tr>
    <tr>
      <td class=colh colspan=6 align=center>ESTADO</td>
    </tr> 
    <tr>
      <td class="colh" align=center>ID tarjeta</td>
      <td class="colh" align=center>Estado</td>
      <td class="colh" align=center>Activo</td>
      <td class="colh" align=center>Transcripcion</td>
      <td class="colh" align=center>Verificado</td>
      <td class="colh" align=center>Eliminado</td>
    </tr>
  <c:forEach var="tarjeta" items="${listaTarjetas.pageList}">
    <tr>
      <td class="colb"><c:out value="${tarjeta.id_tarjeta}"/></td>
      <td class="colb"><c:out value="${tarjeta.id_estado}"/></td>
      <td class="colb"><a href="<c:url value="supervisor2.do"><c:param name="id_estado" value="T"/><c:param name="id_tarjeta" value="${tarjeta.id_tarjeta}"/><c:param name="id_usuario" value="${id_usuario}"/></c:url>">Transcripcion</a></td>
      <td class="colb"><a href="<c:url value="supervisor2.do"><c:param name="id_estado" value="A"/><c:param name="id_tarjeta" value="${tarjeta.id_tarjeta}"/><c:param name="id_usuario" value="${id_usuario}"/></c:url>">Activo</a></td>
      <td class="colb"><a href="<c:url value="supervisor2.do"><c:param name="id_estado" value="V"/><c:param name="id_tarjeta" value="${tarjeta.id_tarjeta}"/><c:param name="id_usuario" value="${id_usuario}"/></c:url>">Verificado</a></td>
      <td class="colb"><a href="<c:url value="supervisor2.do"><c:param name="id_estado" value="X"/><c:param name="id_tarjeta" value="${tarjeta.id_tarjeta}"/><c:param name="id_usuario" value="${id_usuario}"/></c:url>">Eliminado</a></td>
    </tr>
  </c:forEach>
</table>

<a href="<c:url value="/menu/menu.do"><c:param name="id_categoria" value="${categorias.id_categoria}"/></c:url>">
    <c:out value="${categorias.categoria}"/>
</a>
<!--

<form name=forma1 method="POST" action='<c:url value="/transcripcion.do"/>'>    
    <input type="submit" value="conexion"> <c:out value="${mensaje}"/>::<c:out value="${c}"/>
</form>
-->
<%@ include file="../VerPieCuerpo.jsp" %> 