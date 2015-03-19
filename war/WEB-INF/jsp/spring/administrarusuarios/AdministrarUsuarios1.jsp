<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">

<%@ include file="../Cabecera.jsp" %>
<%@ include file="../buscar/BuscarPersona.jsp" %>

<form name="forma" method="POST" action='<c:url value="/administrarPersonas.do"/>' >
    
    <table border="0" cellspacing="0" cellpadding="0">
        <tr><td>
        <fieldset>
            <legend class=colbp>Registrar Usuario Nuevo</legend>
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                <td class=colbp align=center valign=top><img width=30% src='<c:out value="./images/pagina/signs/sign9.jpg"/>' /></td>
                <td class=colbp>Esta opcion le permite crear un usuario registrando los datos de una persona previamente.
                Debe tener en cuenta que una vez registrado estos datos no podran ser borrados.</td>
                </tr>
                <tr>
                <td class=colbp align=center valign=top>
		<input type=hidden name=titulo value='<c:out value="${titulo}"/>'>
                <input type=hidden name=salida value='<c:out value="administrarusuarios/_link"/>'>
                <input type=submit name=accion value="Nuevo Usuario"></td>
                <td class=colbp>El usuario nuevo pertenecera al grupo según los roles asignados por el,
                verifique su registro en la parte superior ingresando la C&eacute;dula de identidad.
                </td></tr>
                <tr>
                <td class=colh align=center colspan=2>TODA LA RESPONSABILIDAD DEL SIGUIENTE REGISTRO ESTA ASIGNADO SOBRE EL USUARIO DE ESTA SESION</td>
                </tr>
            </table>
        </fieldset>
        </td></tr>
    </table>
</form>

<%@ include file="../VerPieCuerpo.jsp" %>


