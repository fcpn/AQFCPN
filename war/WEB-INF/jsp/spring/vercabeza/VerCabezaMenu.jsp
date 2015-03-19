<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr valign=top class=colh>
        <c:if test="${!empty nombres}">
            <td style="padding-bottom:10px"><c:out value="${nombres}"/>&nbsp;[<c:out value="${id_rol}"/>]</td>  
        </c:if>
        <c:if test="${empty nombres}">
            <td style="padding-bottom:10px">&nbsp;</td>
        </c:if>
        <c:if test="${cantidad > 1}">
            <td align=right>
                <form name=forma action='<c:url value="/verCabeza1.do"/>' method="POST">
                    <table class=textoEncabezado border=0 cellspacing="0" cellpadding="0">
                        <tr valign=top >
                            <td class="normal" style="color:#FFFFFF"><b>Cambiar rol ::</b></td>
                            <td><select name="id_rol" class="campo" style="font-size:10px">
                                    <c:forEach var="roles" items="${listaDeRoles}">
                                        <option value='<c:out value="${roles.id_rol}"/>' <c:if test="${id_rol == roles.id_rol}">selected</c:if> > 
                                        <c:out value="${roles.rol}"/>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><a href="javascript:document.forma.submit()">&nbsp;Cambiar</a></td>
                        </tr>
                    </table>
                </form>
            </td>
        </c:if>    
            <td align=right><a href='<c:url value="/logoutUsuario.do"/>'>Desconectar</a></td>
    </tr>
</table>
