<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<table style="border:1px solid black; background-color:#F1F1F1"><tr><td>
<table cellpadding="0" border="0" cellspacing="0" width="100%">
<tr class="colh">
  <td style="padding-top:7px; padding-bottom:7px; padding-left:10px">ACTUALIZAR USUARIO</td>
  <td class="cerrar" align="center" style="padding-left:7px"><a href="javascript:salir('usuarios')">Cerrar</a></d>
</tr>
</tr></td><tr><td>
</table> 
<table style="padding-left:30px; padding-top:5px">
 <tr><td valign="top">
    <table cellpadding="0" border="0" cellspacing="0">
        <tr>
         <td colspan="2" class="colhpt" style="color:black;font-size:12px; background-color:#F1F1F1">Datos Personales</td>
        </tr>
	<tr>
	   <td class="normal">C&eacute;dula CI.</td>
	   <td><input id="dip" type="text" class="campo" style="width:200px" value='<c:out value="${administrativo.dip}"/>'></td>
	</tr>   
	<tr>
	   <td class="normal">Apellido paterno.</td>
	   <td><input id="paterno" type="text" class="campo" style="width:200px" value='<c:out value="${administrativo.paterno}"/>'></td>
	</tr>   
	<tr>
	   <td class="normal">Apellido materno.</td>
	   <td><input id="materno" type="text" class="campo" style="width:200px" value='<c:out value="${administrativo.materno}"/>'></td>
	</tr>   
	<tr>
	   <td class="normal">Nombres</td>
	   <td><input id="nombres" type="text" class="campo" style="width:200px" value='<c:out value="${administrativo.nombres}"/>'></td>
	</tr>   
	<tr>
	   <td class="normal">Email:</td>
	   <td><input id="correo" type="text" class="campo" style="width:200px" value='<c:out value="${administrativo.correo}"/>'></td>
	</tr>   
	<tr>
	   <td class="normal">Tel./Cel.</td>
	   <td><input id="telefono" type="text" class="campo" style="width:200px value='<c:out value="${administrativo.telefono}"/>'"></td>
	</tr><tr><td>&nbsp;</td></tr>   
	<tr>
	   <td id="cerror" colspan="2" class="normal" style="padding-top:5px; padding-bottom:5px" align="center"><div id="error" style="position:relative; padding-left:5px; padding-top:5px; padding-right:5px; padding-bottom:5px;display:none;"></div></td>
	</tr>   
    </table>
   </td><td valign="top" style="padding-left:20px">
    <table cellpadding="0" border="0" cellspacing="0">    
        <tr>
           <td colspan="3" class="colhpt" style="color:black;font-size:12px; background-color:#F1F1F1">Informacion de Cuenta</td>
        </tr>
	<tr>
	   <td class="normal">ID usuario.</td>
	   <td class="normal"><input disabled id="id_usuario" type="text" class="campo" style="width:100px" value='<c:out value="${administrativo.id_usuario}"/>'>
	</tr>   
	<tr>
	   <td class="normal">Clave.</td>
	   <td colspan="2" class="normal"><input id="clave1" type="password" class="campo" style="width:100px"></td>
	</tr>   
	<tr>
	   <td class="normal">Repetir la clave.</td>
	   <td colspan="2" class="normal"><input id="clave2" type="password" class="campo" style="width:100px"></td>
	</tr>   
	<tr>
	   <td class="normal">Turno.</td>
	   <td class="normal" colspan="2"><input id="manana" type="radio" name="turno" <c:if test="${administrativo.id_turno == 1}">checked</c:if>>Ma&ntilde;ana&nbsp;<input id="tarde" type="radio" name="turno" <c:if test="${administrativo.id_turno == 2}">checked</c:if>>Tarde</td>
	</tr>   
	<tr>
	   <td class="normal">Tipo usuario.</td>
           <td class="normal" colspan="2"><input id="civil" type="radio" name="tipo" <c:if test="${administrativo.cargo == 'Programa'}">checked</c:if>>Civil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="poli" type="radio" name="tipo" <c:if test="${administrativo.cargo == 'Policia'}">checked</c:if>>Policia</td>
	</tr>   
	<tr>
	   <td class="normal" align="right"><img src="./images/loading.gif"></td>
	   <td colspan="2" style="padding-top:15px" align="left"><input id="registrar" value="Registar" type="button" class="button" onclick='registrarUsuario();'></td>
	</tr>   
    </table>
   </td></tr>    
</table>       
</td></tr></table>