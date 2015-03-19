<%@ include file="../Cabecera.jsp" %>
<div class="naranja18-link">Tareas Disponibles para el Usuario:</div><br>
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
        <td colspan="3" class="menuCategoria"><div align="center">Tareas Asignadas al Usuario</div></td>
    </tr>
    <tr>
        <td class="menuCategoria"><div align="center">Código Tarea</div></td>
        <td class="menuCategoria"><div align="center">Descripci&oacute;n</div></td>
        <td class="menuCategoria"><div align="center">Numero de Tarea</div></td>
    </tr>
    <!--Aqui con Ajax para el tareas -->
    <c:forEach var="i" begin="0"   end="${filas-1}">
        <tr  onMouseOver="this.style.backgroundColor='#EEB882';" onMouseOut="this.style.backgroundColor='#ffffff';">
            <td class="normal"><c:out value="${M[i][0]}"/></td>
            <td class="normal"><b><c:out value="${M[i][1]}"/></b></td>
            <td>
                <div align="center" class="normal"><c:out value="${M[i][2]}"/></div>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="../VerPieCuerpo.jsp" %>