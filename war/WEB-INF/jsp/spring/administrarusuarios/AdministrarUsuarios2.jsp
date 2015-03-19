<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">

<%@ include file="../Cabecera.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>
<!--
<script language='JavaScript' SRC="./calendario.js"> </script>
-->

<form name="forma" method="POST" action='<c:url value="/administrarUsuarios2.do"/>' >

<table width=100% border="0" cellspacing="0" cellpadding="0" align=center>
  <tr class=colbp>
    <th class=colh align=center>ADMINISTRAR USUARIOS - AGREGAR USUARIO</th>
</table>
<table>
  <tr>
    <td colspan=2 class=colh align=center>DATOS DE LA PERSONA ACEPTADOS</td>
  <tr>
    <td class=colh>Nombres:</td>
    <td class=colb><c:out value="${nombres}"/>
  <tr>
</table>

<table width=100% border="0" cellspacing="0" cellpadding="0" align=center>
  <tr class=colb>
    <th class=colh align=center>ADMINISTRAR USUARIOS - DATOS DE USUARIO</th>
</table>

<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class=colh align=center colspan=5>FORMULARIO DE REGISTRO DE DATOS DE USUARIO</td>
  <tr>
    <td class=colh align=right>ID Usuario</td>
    <td class=colh>:</td>
    <td class=colb colspan=3> <input type=text name=id_usuario maxlength=10 size=10 value="<c:out value="${id_usuario}"/>"  >
       <c:if test="${!empty _error_user}">
       <table border=0>
         <td class=colerr><c:out value="${_error_user}"/> 
       </table>	 
       </c:if>
       Ingrese una cadena con caracteres alfanumericos sin espacios y todo en minuscula</td>
  <tr>
    <td class=colh align=right>Clave</td>
    <td class=colh>:</td>
    <td colspan=3 class=colb> <input type=password maxlength=10 size=10 name=clave1>
  <tr>
    <td class=colh align=right>Repita la Clave</td>
    <td class=colh>:</td>
    <td colspan=3 class=colb> <input type=password maxlength=10 size=10 name=clave2>
  <tr>
    <td class=colh align=right>Recordatorio</td>
    <td class=colh>:</td>
    <td class=colb colspan=3> <input type=text name=recordatorio maxlength=10 size=10 value='<c:out value="${recordatorio}"/>'>
    Ingrese una palabra o frase, esta le permite recuperar su clave</td>
  <tr>
    <td class=colh align=right>Tipo de Usuario</td>
    <td class=colh>:</td>
    <td colspan=3 class=colb> 
        <input type=radio name='id_tipo_usuario' value="1" disabled>sistema
        <input type=radio name='id_tipo_usuario' value="2" checked>administrativo
  <tr>
    <td class=colh align=center colspan=5>FORMULARIO DE REGISTRO DE DATOS DE EMPLEADO</td>
  <tr>
    <td class=colh align=right>Cargo</td>
    <td class=colh>:</td>
    <td class=colb> <input type=text name=cargo maxlength=20 size=20 value="<c:out value="${cargo}"/>"  >
    <td class=colb colspan=2>Ingrese la posici&oacute;n administrativa que ocupa el empleado</td>
  <tr>
    <td colspan=5 class=colbp align=center>Selecione los roles o funciones que se le asignaran al nuevo usuario.  
                   <br> La siguiente lista muestra todas las funciones... 

  <c:if test='${!empty _error}'> 
  <tr>
    <th class=coler align=center colspan=5><c:out value="E R R O R: "/><c:out value='${_error}'/></th>
  </c:if> 

  <tr>
    <td class=colh align=center colspan=5>FUNCIONES DESARROLLADAS PARA <c:out value="${programa}"/> </td>
  <tr>
    <td class="colh"></td>
    <td class="colh" colspan=2 align=center>Rol</td>
    <td class="colh" align=center>Descrici&oacute;n</td>
    <td class="colh" align=center>Fecha de Expiraci&oacute;n</td>
 <c:forEach var="datos" items="${listaRoles.pageList}" varStatus="contador"> 
  <tr>
    <td class="colb"><input type=checkbox name=roles value='<c:out value="${datos.id_rol}"/>:<c:out value="${contador.index}"/>'></td>
    <td class="colb" colspan=2><c:out value="${datos.rol}"/></td>
    <td class="colb"><c:out value="${datos.descripcion}"/></td>
<!--
    <td class="colb"><input type=text name=dia  maxlength=2 size=2 onblur='validarNota(this,"1","31");'>-
                     <input type=text name=mes  maxlength=2 size=2 onblur='validarNota(this,"1","12");'>-
		     <input type=text name=anio maxlength=4 size=4 onblur='validarNota(this,"2005","2010");'>
-->
<!--
    <td class="colb"><input type=text id="date" name=anio maxlength=8 size=8>
                     <a href="javascript:NewCal('date','ddmmyyyy')">
                     <img src="images/cal.gif" width="16" height="16" border="0" alt="Calendario"></a>
-->
    <td colspan=2 class=colb>
        <select name="dia">
	  <c:forEach var="i" begin='1' end='31'>
           <option value="<c:out value='${i}'/>" <c:if test="${dia == i}">selected</c:if>> 
		<c:out value="${i}"/>
           </option>
	  </c:forEach>
	</select>
        <select name="mes">
	    <option value="1" <c:if test="${mes == 1}">selected</c:if>>  Enero</option>
	    <option value="2" <c:if test="${mes == 2}">selected</c:if>>  Febrero</option>
	    <option value="3" <c:if test="${mes == 3}">selected</c:if>>  Marzo</option>
	    <option value="4" <c:if test="${mes == 4}">selected</c:if>>  Abril</option>
	    <option value="5" <c:if test="${mes == 5}">selected</c:if>>  Mayo</option>
	    <option value="6" <c:if test="${mes == 6}">selected</c:if>>  Junio</option>
	    <option value="7" <c:if test="${mes == 7}">selected</c:if>>  Julio</option>
	    <option value="8" <c:if test="${mes == 8}">selected</c:if>>  Agosto</option>
	    <option value="9" <c:if test="${mes == 9}">selected</c:if>>  Septiembre</option>
	    <option value="10" <c:if test="${mes == 10}">selected</c:if>>Octubre</option>
	    <option value="11" <c:if test="${mes == 11}">selected</c:if>>Noviembre</option>
	    <option value="12" <c:if test="${mes == 12}">selected</c:if>>Diciembre</option>
	</select>
        <input type=text name=anio maxlength=4 size=4 value='<c:out value="${anio}"/>' onblur='validarNota(this,"1900","2010");'>(Ej. 1980)



    
    
    
 </c:forEach>
  <tr>
    <td> <input type=hidden name=id_persona value='<c:out value="${id_persona}"/>'>
         <input type=hidden name=nombres value='<c:out value="${nombres}"/>'>
  <tr>
    <td class=colh align=center colspan=5><input type=submit name=accion value='Continuar >>'>
</table>
</form>

<%@ include file="../VerPieCuerpo.jsp" %>


