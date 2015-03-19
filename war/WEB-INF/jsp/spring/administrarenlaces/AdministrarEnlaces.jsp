<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js">  </script>
<body onload='inicio(document.fcrear.id_categoria)'>

<h3>Administrar Enlaces</h3>
<table width=100%>
<tr>
<td width="45%" valign=top>
<form name="fcrear" method="POST" action='<c:url value="/administrarEnlaces.do"/>' >
  <div>
    <table border=0 align=center>
      <tr>
        <th class=colh colspan=3>AGREGAR NUEVO ENLACE</th>
      </tr>
      <tr>
        <td class=colh align=right>Categor&iacute;a</td>
	<td class=colh>::</td>
        <td>	<select name="id_categoria">
    		  <c:forEach var="cat1" items="${listaCategorias.pageList}">
		    <option value="<c:out value="${cat1.id_categoria}"/>" > 
			<c:out value="${cat1.categoria}"/>
		    </option>
		  </c:forEach>
		</select>
	</td>
      </tr>
      <tr>
        <td class=colh align=right>Nombre del Enlace</td>
	<td class=colh>::</td>
        <td><input type=text name=nombre_enlace maxlength=40 ></td>
      </tr>
      <tr>
        <td class=colh align=right>Ruta del Enlace</td>
	<td class=colh>::</td>
        <td><input type=text name=ruta_enlace maxlength=40 ></td>
      </tr>
      <tr>
        <td class=colh align=right>Posici&oacute;n en la Categor&iacute;a</td>
	<td class=colh>::</td>
        <td><input type=text name=orden maxlength=1 onblur='validar(orden,"9")' ></td>
      </tr>
      <tr>
        <td class=colh align=right>Imagen</td>
	<td class=colh>::</td>
        <td><input type=text name=imagen maxlength=20 ></td>
      </tr>
      <tr>
    	<td align=center colspan="3"><input type=submit name='boton' value='Crear'></td>
      </tr>
   </table>
</div>
</form>
</td>
<td width=10%>
</td>
<td width=45% valign=top>
<form name="fmodificar" method="POST" action='<c:url value="/administrarEnlaces.do"/>' >
  <div>
    <table border=0 align=center>
      <tr>
        <th class=colh colspan=3>MODIFICAR UN ENLACE</th>
      </tr>
      <tr>
        <td class=colh align=right>Seleccione </td>
	<td class=colh>::</td>
	
        <td>	<select name="id_categoria_s" onchange="javascript:document.fmodificar.submit();">
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
        <td class=colh align=right>Enlaces de la Categor&iacute;a</td>
	<td class=colh>::</td>
        <td>	<select name="id_enlace_s" onchange="javascript:document.fmodificar.submit();">
		  <option value="0">-- un enlace --
    		  <c:forEach var="cat1" items="${listaEnlaces.pageList}">
		    <option value="<c:out value="${cat1.id_enlace}"/>" <c:if test="${cat1.id_enlace == id_enlace}">selected</c:if>> 
			<c:out value="${cat1.nombre_enlace}"/>
		    </option>
		  </c:forEach>
		</select>
	</td>
      </tr>
      <tr>
        <td class=colh align=right>Nuevo Nombre del Enlace</td>
	<td class=colh>::</td>
        <td><input type=text name=nombre_enlace_s value="<c:out value="${enlace.nombre_enlace}" />" maxlength=50 ></td>
      </tr>
      <tr>
        <td class=colh align=right>Ruta del Enlace</td>
	<td class=colh>::</td>
        <td><input type=text name=ruta_enlace_s value="<c:out value="${enlace.ruta_enlace}"/>" maxlength=100 ></td>
      </tr>
      <tr>
        <td class=colh align=right>Posici&oacute;n en la Categor&iacute;a</td>
	<td class=colh>::</td>
        <td><input type=text name=orden_s value="<c:out value="${enlace.orden}"/>" maxlength=1 ></td>
      </tr>
      <tr>
        <td class=colh align=right>Imagen</td>
	<td class=colh>::</td>
        <td><input type=text name=imagen_s maxlength=20 value="<c:out value="${enlace.imagen}"/>"></td>
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
</body>

<%@ include file="../VerPieCuerpo.jsp" %>