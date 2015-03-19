<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<table>
  <tr>
    <td>
      <c:if test="${estado == 'enabled'}">
        <input id="btnsolicitar" class="button" value="<c:out value="${msgButton}"/>" type="submit" onclick='fullScreen()'>
	</td>
        <td class="normal">Solicitar una <b>TARJETA</b> para 
	<c:if test="${id_rol == 'tra'}">transcripci&oacute;n</c:if>
	<c:if test="${id_rol == 'ver'}">verificaci&oacute;n</c:if>
	</td> 
      </c:if>
      <c:if test="${estado == 'disabled'}">
        <input id="btnsolicitar" class="button" value='<c:out value="${msgButton}"/>' type="submit" onclick='fullScreen()'>
	</td>
        <td class="colb" style="background-color: #FBDCD5"><b>AVISO:</b> hay una <b>TARJETA</b> en la bandeja de 
	<c:if test="${id_rol == 'tra'}">transcripci&oacute;n</c:if>
	<c:if test="${id_rol == 'ver'}">verificaci&oacute;n</c:if>
	en estado pendiente.</td>  
      </c:if>
      <c:if test="${estado == 'error'}">
        <input class="button" value='<c:out value="${msgButton}"/>' type="submit" disabled>
	</td>
        <td class="normal" style="background-color: #FBDCD5"><b>AVISO:</b> La sesi&oacute;n de 
	<c:if test="${id_rol == 'tra'}">transcripci&oacute;n</c:if>
	<c:if test="${id_rol == 'ver'}">verificaci&oacute;n</c:if>
	se ha finalizado por estar fuera de horario, </td>  
      </c:if>
  </tr>    
</table>
