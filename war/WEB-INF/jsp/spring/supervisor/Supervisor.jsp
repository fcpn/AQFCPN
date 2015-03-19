<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">


<%@ include file="../Cabecera.jsp" %>

<table width=100% border="0" align=center>
  <tr class=colb>
    <th class=colh align=center>ADMINISTRAR USUARIOS <c:out value="${programa}"/></th>
</table>
<table>
</table>
<br>
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
  <c:if test="${!empty nUsuarios}">
    <tr>
      <td class=colh colspan=6 align=center>LISTA DE USUARIOS</td>
    </tr> 
    <tr>
      <td class="colh" align=center>ID Usuario</td>
      <td class="colh" align=center colspan=3>Nombres</td>
      <td class="colh" align=center>Cargo</td>
      <td class="colh" align=center>Ver Tarjeta</td>
    </tr>
    <c:forEach var="datos" items="${listaUsuarios.pageList}"> 
        <tr>
          <td class="colb">
	  <c:out value="${datos.id_usuario}"/></td>
          <td class="colb" colspan=3><c:out value="${datos.nombres}"/></td>
          <td class="colb"><c:out value="${datos.cargo}"/></td>
	  <td class="colb" align=center>
	    <a href='<c:url value="/supervisor1.do"><c:param name="id_usuario" value="${datos.id_usuario}"/></c:url>'>
	   <img width=15% src='<c:out value="./images/iconos/modificar.png"/>' border=0 alt=Modificar tag="Modificar"></a></td>
        </tr>
    </c:forEach>
  </c:if>
    </tr>
  </table>

<%@ include file="../VerPieCuerpo.jsp" %>


