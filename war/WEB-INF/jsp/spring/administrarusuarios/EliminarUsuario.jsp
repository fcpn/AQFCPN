<%@ include file="../Cabecera.jsp" %>
<div class="naranja18-link"><font color="red">Fue Borrado del sistema AQUILES el Usuario:</font></div>
<br>
<table width="634" border="0" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
    <tr>
        <td colspan="3">
            <div align="center"><div class="normal"><b><c:out value="${nom_persona}"/></b></div></div>
        </td>
    </tr>
</table>
<br>
<form name="adminusers" action='<c:url value="/administrarUsuarios.do"/>'>
    <p><input type="submit" class="button" value="Administrar usuarios"></p>
</form>


<%@ include file="../VerPieCuerpo.jsp" %>