<%@ include file="../Cabecera.jsp" %>

<c:if test="${cantidad > '1'}">
    <br>
    <table><tr><td style="border: 1px solid orange">
                <table border="0" cellspacing="0" cellpaddign="0">
                    <tr>
                        <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                        <td class="normal" align="justify">El <b>sistema</b> ha establecido que tiene mas de un rol, por favor seleccione uno para ingresar.</td>
                    </tr>
                </table> 
        </td></tr>
    </table>
    <br>
    <form method=post action='<c:url value="/login2.do"/>' >
        <table cellpadding="2" cellspacing="2" border="0">
            <tr><td class="normal" align="center"><b><c:out value="${usuario.nombres}"/></b></td></tr>
            <tr><td class="normal">
                    <select name="id_rol" class="campo" style="font-size:10px">
                        <c:forEach var="roles" items="${listaDeRoles}">
                            <OPTION value='<c:out value="${roles.id_rol}"/>'> <c:out value="${roles.rol}"/>
                        </c:forEach>
                    </select>
            </td></tr>
            <tr><td class="normal" align="center"><input type="submit" value="Ingresar" class="button"/></td></tr>
        </table>
    </form>
</c:if>

<c:if test="${cantidad == '1'}">
<body OnLoad="document.forma.submit()">
    <c:forEach var="roles" items="${listaDeRoles}">
        <form name=forma method=post action='<c:url value="/login2.do"><c:param name="id_rol" value="${roles.id_rol}"/></c:url>'>
    </c:forEach>
    </form>
</body>
</c:if>
<%@ include file="../VerPieCuerpo.jsp" %>