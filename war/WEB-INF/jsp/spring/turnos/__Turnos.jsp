<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">


<%@ include file="../Cabecera.jsp" %>

<table width=100% border="0" align=center>
  <tr class=colb>
    <th class=colh align=center>ADMINISTRAR TURNOS <c:out value="${programa}"/></th>
</table>
<br>

<table border="0" cellspacing="0" cellpadding="0" width=100%>
  <c:if test="${!empty nUsuarios}">
    <tr>
      <td class=colh colspan=7 align=center>LISTA DE USUARIOS</td>
    </tr>
    <tr>
      <td class="colh" align=center>ID Usuario</td>
      <td class="colh" align=center colspan=2>Nombres</td>
      <td class="colh" align=center>Turno Actual</td>
      <td class="colh" align=center>Turno Permanente</td>
      <td class="colh" align=center>Turno Temporal</td>
    </tr>
    <c:forEach var="datos" items="${listaUsuarios.pageList}"> 
        <tr id='turno_act<c:out value="${datos.id_usuario}"/>'>
          <td class="colb">
	  <c:out value="${datos.id_usuario}"/></td>
          <td class="colb" colspan=2><c:out value="${datos.nombres}"/></td>
	  <td class="colb" align=center>
	    <c:if test="${datos.id_turno_actual == 1}">
	    Ma&ntilde;ana
	    <script>document.getElementById('turno_act<c:out value="${datos.id_usuario}"/>').style.background = '#D8DDF9'</script>
	    </c:if>
	    <c:if test="${datos.id_turno_actual == 2}">
	    Tarde
	    <script>document.getElementById('turno_act<c:out value="${datos.id_usuario}"/>').style.background = '#F9F7DB'</script>
	    </c:if>
	    <c:if test="${datos.id_turno_actual == datos.id_turno_tmp && datos.id_turno_actual != 0}">
	    (Dias:<c:out value="${datos.dias}" />)
	    </c:if>
	  </td>
	  <td class="colb" style="text-align:justify">
	    <form action="turnos.do" method="get">
	        <input type="hidden" name="usuario" id="usuario" value="<c:out value="${datos.id_usuario}" />"/>
	        <input type="hidden" name="nombres" id="nombres" value="<c:out value="${datos.nombres}" />"/>
	        <input type="hidden" name="cargo"   id="cargo"   value="<c:out value="${datos.cargo}" />"/>
	        <select name='turno<c:out value="${datos.id_usuario}"/>' id='turno<c:out value="${datos.id_usuario}"/>'>
		    <option value="0" <c:if test="${datos.id_turno == 0}">selected</c:if>>Ninguno</option>
		    <option value="1" <c:if test="${datos.id_turno == 1}">selected</c:if>>Ma&ntilde;ana</option>
		    <option value="2" <c:if test="${datos.id_turno == 2}">selected</c:if>>Tarde</option>
		</select>
	        <input type="hidden" name="accion"  id="accion"  value="Permanente"/>
		<input type="submit" value="Asignar" />
	    </form>
	    <c:if test="${datos.id_turno == 1}">
	    <script>document.getElementById('turno_act<c:out value="${datos.id_usuario}"/>').style.background = '#D8DDF9'</script>
	    </c:if>
	    <c:if test="${datos.id_turno == 2}">
	    <script>document.getElementById('turno_act<c:out value="${datos.id_usuario}"/>').style.background = '#F9F7DB'</script>
	    </c:if>
	  </td>
	  <td class="colb" style="text-align:justify">
	    <form action="turnos.do" method="get">
		Dias:<c:out value="${datos.dias}" /><input type="text" name="dias" id="dias" style="width:20px"/>
	        <input type="hidden" name="usuario" id="usuario" value="<c:out value="${datos.id_usuario}" />"/>
	        <input type="hidden" name="nombres" id="nombres" value="<c:out value="${datos.nombres}" />"/>
	        <input type="hidden" name="cargo"   id="cargo"   value="<c:out value="${datos.cargo}" />"/>
	        <select name='turno_tmp<c:out value="${datos.id_usuario}"/>' id='turno_tmp<c:out value="${datos.id_usuario}"/>'>
		    <option value="0" <c:if test="${datos.id_turno_tmp == 0}">selected</c:if>>Ninguno</option>
		    <c:if test="${datos.id_turno != 1}">
		    <option value="1" <c:if test="${datos.id_turno_tmp == 1}">selected</c:if>>Ma&ntilde;ana</option>
		    </c:if>
		    <c:if test="${datos.id_turno != 2}">
		    <option value="2" <c:if test="${datos.id_turno_tmp == 2}">selected</c:if>>Tarde</option>
		    </c:if>
		</select>
	        <input type="hidden" name="accion"  id="accion"  value="Temporal"/>
		<input type="submit" value="Asignar" />
	    <c:if test="${datos.id_turno_tmp == 1}">
	    <script>document.getElementById('turno_tmp<c:out value="${datos.id_usuario}"/>').style.background = '#D8DDF9'</script>
	    </c:if>
	    <c:if test="${datos.id_turno_tmp == 2}">
	    <script>document.getElementById('turno_tmp<c:out value="${datos.id_usuario}"/>').style.background = '#F9F7DB'</script>
	    </c:if>
	    </form>
	  </td>
        </tr>
    </c:forEach>
  </c:if>
    </tr>
</table>

<%@ include file="../VerPieCuerpo.jsp" %>
