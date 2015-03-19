<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">

<%@ include file="../VerCabezaCuerpo.jsp" %>
<script language='JavaScript' SRC="./validar.js">  </script>

<table width=100% border=0 align=center>
  <tr class=colb>
    <th class=colh align=center> CAMBIO DE CLAVE </th>
</table>

<table cellspacing="1" cellpadding="1" border=0 align=center>
   <td class=colb align=center><font color="red">Esta opci&oacute;n cambiara su clave para el <b>Ingreso al Sistema</b>,  <br>
	           debe estar seguro de cambiarla, adem&aacute;s de recordar la nueva <b>Clave</b>. <br>
		   Su clave no debe pasar de 12 caracteres y <b>NO</b> debe tener caracteres <br>
		   especiales como * + / - ? ¿ ! ¡ " $ % & ( ) : @ # ¬ \ º 
    </td>
</table>

<form name=forma action="<c:url value="/cambioPin1.do"/>" method="POST">

<table cellspacing="1" cellpadding="1" border="1" align=center>
 
  <tr>
    <td class=colh>Carrera:</td>  
    <td class=colb><c:out value="${programa}"/></td>
  </tr>        
  <tr>
    <td class=colh>Nombres:</td>    
    <td class=colb><c:out value="${nombres}"/></td>
  </tr>
  <tr>
    <td class=colh>Clave Actual:</td>    
    <td class=colb><input type="password" name=clave_actual maxlength=30 ></td>
  </tr>
  <tr>
    <td class=colh>Nueva Clave:</td>    
    <td class=colb><input type="password" name=clave_nueva maxlength=30 ></td>
  </tr>
  <tr>
    <td class=colh>Confirmar Clave:</td>    
    <td class=colb><input type="password" name=clave_confirmar maxlength=30 ></td>
    <input type=hidden name=id_usuario value='<c:out value="${id_usuario}"/>'  
  </tr>    
      <tr>
    	<td align=center colspan=2><input type=submit name='boton' value='Aceptar' align=center ></td>
      </tr>
</table>
<table align=center>
      <tr>    
        <c:if test="${!empty mensaje}">    
	    <td class=coler align=center><c:out value="${mensaje}"/>
	</c:if>           	
        <c:if test="${!empty mensaje1}">    
	    <td align=center><c:out value="${mensaje1}"/>
	</c:if>           	
      </tr>	
</table>      
<br>
<tr>
</tr>

</form>


<%@ include file="../VerPieCuerpo.jsp" %>
