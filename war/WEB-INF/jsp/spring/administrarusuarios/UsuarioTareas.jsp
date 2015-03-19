<%@ include file="../Cabecera.jsp" %>
<script type="text/javascript">
    function seleccionar_todo()
    {
        form = document.forms["form1"]
        for (i=0;i<form.elements.length;i++)
        {
            if(form.elements[i].type == "checkbox")form.elements[i].checked=1;
        }
    }
    function deseleccionar_todo()
    {
        form = document.forms["form1"]
        for (i=0;i<form.elements.length;i++)
        {
            if(form.elements[i].type == "checkbox")form.elements[i].checked=0;
        }
    }
</script>
<form id="form1" name="form1" method="post" action="<c:url value="/RegistrarTareasUsuario.do"/>">
    <div class="naranja18-link">Seleccion de Tareas Para el Usuario:</div><br>
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
            <td colspan="3" class="menuCategoria"><div align="center">Tareas Disponibles</div></td>
        </tr>
        <tr>
            <td colspan="3"><div align="center" class="colhpt">Tipo de Selección</div></td>
        </tr>
        <tr>
            <td width="117"><div align="center"><a href='javascript:seleccionar_todo()' >Todos</a></div></td>
            <td width="462"><div align="center"><a href='javascript:deseleccionar_todo()' >Ninguno</a></div></td>
            <td width="41">&nbsp;</td>
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
    <table width="634" border="0" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
        <tr>
            <td colspan="3">
                <div align="right"><input type="submit" name="button" id="button" value="Aceptar"></div>
                <input type="hidden" name="id_usuario" value="<c:out value="${id_usuario}"/>">
                <input type="hidden" name="id_persona" value="<c:out value="${id_persona}"/>">
            </td>
        </tr>
    </table>
</form>
<%@ include file="../VerPieCuerpo.jsp" %>