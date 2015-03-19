
<%@ include file="../VerCabezaCuerpo.jsp" %>

<table cellspacing="0" cellpadding="0" >
    <table width=100% border=0 align=center>
      <tr>
        <th colspan=3 class=colh align=center>ADMINISTRAR MENU</th>
      </tr>
    </table>
    <table cellspacing="0" cellpadding="0" align=center>    
        <tr>
         <td class="colh" align=center>Nombre del Enlace</td>        
         <td class="colh" align=center>Fecha de Activaci&oacute;n</td>        
         <td class="colh" align=center>Fecha de Expiraci&oacute;n</td>        
         <td class="colh" align=center>Estado</td>        
         <td class="colh" align=center>Opci&oacute;n</td>        
      <c:forEach var="datos" items="${listaEnlacesRoles.pageList}" varStatus="contador"> 
        <tr>
	 <td class="colb" align=center><c:out value="${datos.nombre_enlace}"/> 
	 <td class="colb" align=center><c:out value="${datos.fec_activacion.date}"/>/<c:out value="${datos.fec_desactivacion.month+1}"/>/<c:out value="${datos.fec_desactivacion.year+1900}"/></td> 
	 <td class="colb" align=center><c:out value="${datos.fec_desactivacion.date}"/>/<c:out value="${datos.fec_desactivacion.month+1}"/>/<c:out value="${datos.fec_desactivacion.year+1900}"/></td> 
	 <td class="colb" align=center><c:out value="${datos.id_estado}"/></td> 	 
	<td class="colb">
	<a href="<c:url value="/administrarMenues2.do"><c:param name="id_enlace" value="${datos.id_enlace}"/></c:url>">
	    [Modificar]</td>
	  
	 <input type="hidden" name="id_rol"  value='<c:out value="${datos.id_rol}" />'>
	 <input type="hidden" name="id_enlace"  value='<c:out value="${datos.id_enlace}" />'>
	 <input type="hidden" name="nombre_enlace"  value='<c:out value="${datos.nombre_enlace}" />'>	 
	 <input type="hidden" name="id_programa"  value='<c:out value="${datos.id_programa}" />'>
	 <input type="hidden" name="id_categoria"  value='<c:out value="${datos.id_categoria}" />'>
      </c:forEach>  
   </table> 
</table>
<%@ include file="../VerPieCuerpo.jsp" %>
