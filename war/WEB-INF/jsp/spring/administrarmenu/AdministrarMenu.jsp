<%@ include file="../Cabecera.jsp" %>

<h3>Administrar Menues</h3>
<table width=70%>
<tr>
<td width="45%" valign=top>
<form name="fcrear" method="POST" action='<c:url value="/administrarMenues.do"/>' >
  <div>
    <table width=100% border=0 align=center>
      <tr>
        <th colspan=3 class=colh align=center>AGREGAR NUEVO MENU</th>
      </tr>
      <tr>
        <td class=colh>Seleccione Usuario </td>
	<td class=colh>::</td>
        <td>	<select name="id_usuario_rol_s" onchange="javascript:document.fcrear.submit();">
		  <option value="--">-- un usuario --
    		  <c:forEach var="cat1" items="${listaUsuarios.pageList}">
		    <option value="<c:out value="${cat1.id_usuario}"/>" <c:if test="${cat1.id_usuario == id_usuario}">selected</c:if>> 
			<c:out value="${cat1.usuario}"/>
		    </option>
		  </c:forEach>
		</select>
	</td>
      </tr>
      <tr>
        <td class=colh>Roles del Usuario</td>
	<td class=colh>::</td>
        <td>	<select name="id_rol_s" >
		  <option value="--">-- seleccione un rol --
    		  <c:forEach var="cat1" items="${listaUsrRoles.pageList}">
		    <option value="<c:out value="${cat1.id_rol}"/>" <c:if test="${cat1.id_rol == id_rol}">selected</c:if>> 
			<c:out value="${cat1.rol}"/>
		    </option>
		  </c:forEach>
		</select>
	</td>
      </tr>
      
      <tr>
        <td class=colh>Seleccione Categoria </td>
	<td class=colh>::</td>
        <td>	<select name="id_categoria_s" onchange="javascript:document.fcrear.submit();">
		  <option value="">-- una categoria --
    		  <c:forEach var="cat1" items="${listaCategorias.pageList}">
		    <option value="<c:out value="${cat1.id_categoria}"/>" <c:if test="${cat1.id_categoria == id_categoria}">selected</c:if>> 
			<c:out value="${cat1.categoria}"/>
		    </option>
		  </c:forEach>
		</select>
	</td>
      </tr>
      <tr>
        <td colspan=3><hr><br></td>
      </tr>
        <td colspan=3>
	<table width=100%>
        <tr>
           <th class=colh align=center>Enlaces de la Categoria</th>
           <th width=10%>&nbsp;</th>
           <th class=colh align=center>Enlaces Permitidos para del Usuario</th>
        </tr>
	<tr>
	  <td valign=top>
	  <table>
    	  <c:forEach var="datos1" items="${listaEnlaces.pageList}">    
            <tr>
    	      <td class=colh> <input type=checkbox name="id_enlace_s" value="<c:out value="${datos1.id_enlace}"/>" >
                              <c:out value="${datos1.nombre_enlace}"/>
	      </td>
    	    </tr>
    	  </c:forEach> 
	  </table>
	  </td>
           <td width=10%>&nbsp;</td>
	  <td valign=top>
	  <table>
    	  <c:forEach var="datos1" items="${listaUsrRolEnlaces.pageList}">    
            <tr>
    	      <td class=colh> <input type=checkbox name="id_enlace_u" value="<c:out value="${datos1.id_enlace}"/>">
                              <c:out value="${datos1.nombre_enlace}"/>
	      </td>
    	    </tr>
    	  </c:forEach> 
	  </table>
	  </td>
	</tr>
        <tr>
    	  <td><input type=submit name='boton' value='Agregar'></td>
    	  <td></td>
    	  <td><input type=submit name='boton' value='Eliminar'></td>
        </tr>
        </table>
	</td>
      </tr>
   </table>
</div>
</form>
</td>
<td width=10%>
</td>

</tr>
</table>

<%@ include file="../VerPieCuerpo.jsp" %>
