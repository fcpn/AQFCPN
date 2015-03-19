<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<table border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td class=colh colspan=4 align=center>LISTA DE USUARIOS</td>
    </tr>
    <tr>
        <td class="colh" align=center>ID</td>
        <td class="colh" align=center>NOMBRE COMPLETO</td>
        <td class="colh" align=center>CARGO</td>
    </tr>
    <c:forEach var="datos" items="${listaUsuarios}">       
        <tr id='row_<c:out value="${datos.id_usuario}"/>' onmouseover=''> 
            <td class="normal">
                <a href='javascript:getModificarUsuario("<c:out value="${datos.id_usuario}"/>")' title="Modificar">            
                    <c:out value="${datos.id_usuario}"/>
                </a>
            </td>
            <td class="normal"><c:out value="${datos.nombres}"/></td>
            <td class="normal"><c:out value="${datos.cargo}"/></td>                
        </tr>
    </c:forEach>
    </tr>
</table>

