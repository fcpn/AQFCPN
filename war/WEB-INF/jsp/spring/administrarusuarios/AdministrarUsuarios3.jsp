<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">

<%@ include file="../cabecera.jsp" %>

<table width=100% border="0" align=center>
  <tr class=colb>
    <th class=colh align=center>ADMINISTRAR USUARIOS <c:out value="${programa}"/></th>
</table>

<table>
 <tr>
  <td class=colh>Periodo::
  <td class=colb><c:out value="${periodo}"/>
  <td class=colh>Gestion::
  <td class=colb><c:out value="${gestion}"/>
  <td class=colh>Programa::
  <td class=colb><c:out value="${programa}"/>
</table>
<br>

<form name="forodel" method="POST" action='<c:url value="/administrarUsuarios.do"/>' >
<table>
<tr><td valign=top>
<table border="0" cellspacing="0" cellpadding="0">
 <tr>
  <td class=colh>Nombres:
  <td class=colb><c:out value="${nombres}"/>
  <td class=colh>Cargo:
  <td class=colb><c:out value="${cargo}"/>
 <tr> 
  <td class=colh>Usuario:
  <td class=colb><c:out value="${usuario}"/>
  
</table>
<td valign=middle>
<table cellspacing="0">
 <tr><td>
 <input type=hidden name=usuario value='<c:out value="${usuario}"/>'>
 <input type=hidden name=nombres value='<c:out value="${nombres}"/>'>
 <input type=hidden name=cargo value='<c:out value="${cargo}"/>'>
 <input type=submit name=accion value="Eliminar">
</table>
</table>  
</form>
<!--
<table>
  <tr><c:out value="${id_usuario}"/>
   <td class=colb><c:out value="${usuario}"/><c:out value="${nombres}"/><c:out value="${cargo}"/>
</table>
-->

<form name="forma" method="POST" action='<c:url value="/administrarUsuarios3.do"/>' >


<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class=colh align=center colspan=5>FORMULARIO DE REGISTRO DE DATOS DE USUARIO</td>
  <tr>
    <td class=colh align=right>Clave:</td>
    <td colspan=4 class=colb><input type=password maxlength=10 size=10 name=clave1> 
    <b>ADVERTENCIA:</b> Si llena estos cuadros se va ha cambiar la clave del usuario actual
    sin preguntar
  <tr>
    <td class=colh align=right>Repita la Clave:</td>
    <td colspan=4 class=colb> <input type=password maxlength=10 size=10 name=clave2>
  <tr>
    <td class=colh align=center colspan=5>FORMULARIO DE REGISTRO DE DATOS DE EMPLEADO</td>
  <tr>
    <td class=colh align=right>Cargo:</td>
    <td class=colb><input type=text name=cargo maxlength=20 size=20 value="<c:out value="${cargo}"/>"  >
    <td class=colb colspan=3>Ingrese la posici&oacute;n administrativa que ocupa el empleado</td>
  <tr>
    <td colspan=5 class=colbp align=center>Selecione los roles o funciones que se le asignaran al nuevo usuario.  
                   <br> La siguiente lista muestra todas las funciones... 

  <c:if test='${!empty _error}'> 
  <tr>
    <th class=coler align=center colspan=5><c:out value="E R R O R: "/><c:out value='${_error}'/></th>
  </c:if> 

<!--
</table>

<table width=80% border="0" cellspacing="0" cellpadding="0">
-->

  <tr>
    <td class=colh align=center colspan=5>FUNCIONES DESARROLLADAS PARA <c:out value="${programa}"/> </td>
  <tr>
    <td class="colh"></td>
    <td class="colh" align=center>Rol</td>
    <td class="colh" align=center>Descripci&oacute;n</td>
    <td class="colh" align=center>Fecha dia/mes/a&ntilde;o (a&ntilde;o Ej. 2005)</td>
    <td class="colh" align=center>Estado</td>
 <c:forEach var="datos" items="${listaRolesU.pageList}" varStatus="contador"> 
  <tr>
    <td class="colb"><input type=checkbox name=roles value='<c:out value="${datos.id_rol}"/>:<c:out value="${contador.index}"/>'<c:if test="${datos.id_estado=='S'}">checked</c:if> > </td>
    <td class="colb"><c:out value="${datos.rol}"/></td>
    <td class="colb"><c:out value="${datos.descripcion}"/></td>
    <td class="colb">
        <select name="dia">
	  <c:forEach var="i" begin='1' end='31'>
           <option value="<c:out value='${i}'/>" <c:if test="${datos.dia == i}">selected</c:if>> 
		<c:out value="${i}"/>
           </option>
	  </c:forEach>
	</select>
        <select name="mes">
	    <option value="1" <c:if test="${datos.mes == 1}">selected</c:if>>  Enero</option>
	    <option value="2" <c:if test="${datos.mes == 2}">selected</c:if>>  Febrero</option>
	    <option value="3" <c:if test="${datos.mes == 3}">selected</c:if>>  Marzo</option>
	    <option value="4" <c:if test="${datos.mes == 4}">selected</c:if>>  Abril</option>
	    <option value="5" <c:if test="${datos.mes == 5}">selected</c:if>>  Mayo</option>
	    <option value="6" <c:if test="${datos.mes == 6}">selected</c:if>>  Junio</option>
	    <option value="7" <c:if test="${datos.mes == 7}">selected</c:if>>  Julio</option>
	    <option value="8" <c:if test="${datos.mes == 8}">selected</c:if>>  Agosto</option>
	    <option value="9" <c:if test="${datos.mes == 9}">selected</c:if>>  Septiembre</option>
	    <option value="10" <c:if test="${datos.mes == 10}">selected</c:if>>Octubre</option>
	    <option value="11" <c:if test="${datos.mes == 11}">selected</c:if>>Noviembre</option>
	    <option value="12" <c:if test="${datos.mes == 12}">selected</c:if>>Diciembre</option>
	</select>
        <input type=text name=anio maxlength=4 size=4 value='<c:out value="${datos.anio}"/>' onblur='validarNota(this,"1900","2010");'>
    <td <c:if test="${datos.estado=='caduco'}"> class="colerr" </c:if> <c:if test="${datos.estado!='caduco'}"> class="colb" </c:if> > 
      <c:out value="${datos.estado}"/></td>
 </c:forEach>
  <tr>
    <td class=colb align=center colspan=5><input type=submit name=accion value='Actualizar'>
     <!-- Datos ocultos -->     
         <input type=hidden name=nombres value='<c:out value="${nombres}"/>'>
         <input type=hidden name=id_usuario value='<c:out value="${usuario}"/>'>

</table>
</form>

<%@ include file="../VerPieCuerpo.jsp" %>


