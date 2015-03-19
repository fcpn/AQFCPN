
<%@ include file="../VerCabezaCuerpo.jsp" %>

<form name="forma" method="POST" action='<c:url value="/administrarMenues3.do"/>' >
<tr>
<tr>
<table border=0>
    <table width=100%  align=center>
      <tr>
        <th colspan=3 class=colh align=center>ADMINISTRAR MENU</th>
      </tr>
    </table>
    <table cellspacing="0" cellpadding="0" align=center>    
        <tr>
         <td class="colh" align=center>Nombre del Enlace</td>        
         <td class="colh" align=center>Fecha de Activaci&oacute;n</td>        
         <td class="colh" align=center>Fecha de Expiraci&oacute;n</td>        
         <td class="colh" align=center>Activo</td>        
         <td class="colh" align=center>Desactivo</td>        
         <td class="colh" align=center>Opci&oacute;n</td>        
        <tr>
	 <td class="colb" align=center><c:out value="${FechasEnlaces.nombre_enlace}"/> 
	 <td class="colb" align=center><input type="text" name="fec_activacion" value=<c:out value="${FechasEnlaces.fec_activacion.date}"/>-<c:out value="${FechasEnlaces.fec_activacion.month+1}"/>-<c:out value="${FechasEnlaces.fec_activacion.year+1900}"/>></td> 
	 <td class="colb" align=center><input type="text" name="fec_desactivacion" value=<c:out value="${FechasEnlaces.fec_desactivacion.date}"/>-<c:out value="${FechasEnlaces.fec_desactivacion.month+1}"/>-<c:out value="${FechasEnlaces.fec_desactivacion.year+1900}"/>></td>  
         <td class="colb" align=center><input type=radio name='id_estado' value="A" <c:if test="${FechasEnlaces.id_estado == 'A'}">checked</c:if> 
         <td class="colb" align=center><input type=radio name='id_estado' value="X" <c:if test="${FechasEnlaces.id_estado == 'X'}">checked</c:if> 	 
	 <td class=colh  align=center><input type=submit name=accion value='Aceptar'></td>
	 <input type="hidden" name="id_enlace"  value='<c:out value="${FechasEnlaces.id_enlace}" />'>   	 
	 <input type="hidden" name="id_programa"  value='<c:out value="${FechasEnlaces.id_programa}" />'>
	 <input type="hidden" name="id_categoria"  value='<c:out value="${FechasEnlaces.id_categoria}" />'>
   </table> 
</table>
    <c:if test="${!empty mensaje}">
    <table align=center>
      <tr>
        <th colspan=3 class=colh align=center>LOS DATOS FUERON REGISTRADOS</th>
      </tr>
    </table>
    </c:if>
</form>
<%@ include file="../VerPieCuerpo.jsp" %>
