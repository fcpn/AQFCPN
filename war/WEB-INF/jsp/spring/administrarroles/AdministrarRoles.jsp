<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> 
 </script>
<body onload='inicio(document.fcrear.id_rol)'>

<h3>Administrar Roles</h3>
<table>
<tr>
<td valign=top>
<form name="fcrear" method="POST" action='<c:url value="/administrarRoles.do"/>' >
  <div>
    <table width=100% border=0 align=center>
      <tr>
        <td align=center colspan=3 class=colh>AGREGAR NUEVO ROL</td>
      </tr>
      <tr>
        <td class=colh align=right>C&oacute;digo Rol</td>
	<td class=colh>::</td>
        <td><input type=text name=id_rol maxlength=4 onblur='validar(id_rol,"A9")' ></td>
      </tr>
      <tr>
        <td class=colh align=right>Rol</td>
	<td class=colh>::</td>
        <td><input type=text name=rol maxlength=20 onblur='validar(rol,"A")'></td>
      </tr>
      <tr>
        <td class=colh align=right>Descripci&oacute;n</td>
	<td class=colh>::</td>
        <td><input type=text name=descripcion maxlength=20 ></td>
      </tr>
      <tr>
    	<td align=center colspan="3"><input type=submit name='boton' value='Crear'></td>
      </tr>
    </table>
  </div>
</form>
</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
<td valign=top>
<form name="fmodificar" method="POST" action='<c:url value="/administrarRoles.do"/>' >
  <div>
    <table width=100% border=0 align=center>
      <tr>
        <td align=center colspan=3 class=colh>MODIFICAR UN ROL</td>
      </tr>
      <tr>
        <td class=colh align=right>Seleccione</td>
	<td class=colh>::</td>
        <td>	<select name="id_rol_s" onchange="javascript:document.fmodificar.submit();">
		  <option value="--">-- un rol --
    		  <c:forEach var="cat1" items="${listaRoles.pageList}">
		    <option value="<c:out value="${cat1.id_rol}"/>" <c:if test="${cat1.id_rol == id_rol}">selected</c:if>> 
			<c:out value="${cat1.rol}"/>
		    </option>
		  </c:forEach>
		</select>
	</td>
      </tr>
      <tr>
        <td class=colh align=right>Rol</td>
	<td class=colh>::</td>
        <td><input type=text name=rol_s maxlength=20 value="<c:out value="${rol.rol}"/>" ></td>
      </tr>
      <tr>
        <td class=colh align=right>Descripci&oacute;n</td>
	<td class=colh>::</td>
        <td><input type=text name=descripcion_s maxlength=20 value="<c:out value="${rol.descripcion}"/>"></td>
      </tr>
      <tr>
    	<td align=center colspan="3">
	    <input type=submit name='boton' value='Modificar'>
	</td>
      </tr>
   </table>
</div>
</form>
</td>

</tr>
</table>
</body>

<%@ include file="../VerPieCuerpo.jsp" %>