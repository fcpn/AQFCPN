
<%@ include file="../VerCabezaCuerpo.jsp" %>
<script language='JavaScript' SRC="./validar.js">  </script>


<h3><center> <c:out value="${titulo}" /> </center></h3>
<h3><center> Seguridad </center></h3>

<form name=forma action="<c:url value="/seguridad1.do"/>" method="POST">
<table cellspacing="0" cellpadding="0"  align=center>
  <tr>  
    <td class=colh>Gesti&oacute;n</td>
    <td class=colh>Periodo</td>
  </tr>
  <tr>
    <td class=colb><c:out value="${gestion}"/></td>
    <td class=colb><c:out value="${periodo}"/></td>
  </tr>
 </table> 

<td colspan=3><hr><br></td>
<table cellspacing="0" cellpadding="0" align=center>
 
  <tr>
    <td class=colh>Carrera:</td>  
    <td class=colb><c:out value="${programa}"/></td>
  </tr>        
  <tr>
    <td class=colh>Nombre:</td>    
    <td class=colb><c:out value="${nombres}"/></td>
  </tr>
  <tr>
    <td class=colh>Clave:</td>    
    <td class=colb><input type="password" name=clave maxlength=30 ></td>
  </tr>
</table>

        <input type="hidden" name="destino" value='<c:out value="${destino}" />'>
        <input type="hidden" name="titulo" value='<c:out value="${titulo}" />'>

<table cellspacing="0" cellpadding="0" align=center>
      <tr>
    	<td align=center colspan=2><input type=submit name='boton' value='Ingresar' align=center ></td>
      </tr>
</table>

<table align=center>
      <tr>    
        <c:if test="${!empty mensaje}">    
	    <td class=coler align=center><c:out value="${mensaje}"/>
	</c:if>           	
      </tr>	
</table>      

<br>
<tr>
</tr>

</form>


<%@ include file="../VerPieCuerpo.jsp" %>
