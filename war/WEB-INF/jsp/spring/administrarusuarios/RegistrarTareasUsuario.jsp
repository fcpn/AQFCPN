<%@ include file="../Cabecera.jsp" %>
<div class="naranja18-link">Se Registró el Usuario:</div>
<br>
<table width="634" border="0" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
    <tr>
        <td colspan="3">
            <div align="center"><div class="normal"><b><c:out value="${per.nombres}"/> <c:out value="${per.paterno}"/> <c:out value="${per.materno}"/></b></div></div>
        </td>
    </tr>
</table>
<br>
<table width="634" border="0" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
    <tr>
        <td colspan="3" class="menuCategoria"><div align="center">Tareas Disponibles para el usuario</div></td>
    </tr>
    <tr>
        <td class="menuCategoria"><div align="center">Código Tarea</div></td>
        <td class="menuCategoria"><div align="center">Descripci&oacute;n</div></td>
        <td class="menuCategoria">&nbsp;</td>
    </tr>
    <c:forEach var="tar" items="${tareass}">
        <tr  onMouseOver="this.style.backgroundColor='#EEB882';" onMouseOut="this.style.backgroundColor='#ffffff';">
            <td class="normal"><c:out value="${tar.codtar}"/></td>
            <td class="normal"><b><c:out value="${tar.descripcion}"/></b></td>
            <td>
                <input type="checkbox" name="codtars" value="<c:out value="${tar.codtar}"/>">
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="../VerPieCuerpo.jsp" %>
