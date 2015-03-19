<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<%@ include file="../Cabecera.jsp" %>
<table width=100% border="0" align=center>
    <tr class=colb>
        <th class=colh align=center>ADMINISTRAR USUARIOS</th>
    </tr>
</table>

<table align="center"><tr><td style="border: 1px solid orange">
            <table border="0" cellspacing="0">
                <tr>
                    <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                    <td class="normal" align="justify"><b>Aviso:</b> En esta secci&oacute;n ingrese los datos necesarios para establecer un nuevo registro de <b>persona</b>
                    </td>
                </tr>
            </table>
        </td></tr>
</table> 
<div id="personainfoUpdate" style="display:inline">
    <table id="lyClave" border="0" cellspacing="0" width="80%" align="center" style="border:1px solid">
        <tr>
            <td style="padding-top:20px; padding-bottom:20px; padding-left:30px; padding-right:30px">
                <table width="380" border="0" cellspacing="0">
                    <tr>
                        <td colspan="2" class=colh><b>LA INFORMACION PERSONAL GUARDADA ES</b></td>
                    </tr>
                    <tr>
                        <td colspan="2"><hr></td>
                    </tr>
                    <tr>
                        <td width="134" class=colh style="width:110px"><b>Nombres</b></td>
                        <td width="216" class=campop><c:out value="${per.nombres}"/></td>
                    </tr>
                    <tr>
                        <td style="width:110px" class=colh><b>Ap. Paterno</b></td>
                        <td class=campop><c:out value="${per.paterno}"/></td>
                    </tr>
                    <tr>
                        <td style="width:110px" class=colh><b>Ap. Materno</b></td>
                        <td class=campop><c:out value="${per.materno}"/></td>
                    </tr>
                    <tr>
                        <td style="width:110px" class=colh><b>C&eacute;dula</b></td>
                        <td class=campop><c:out value="${per.dip}"/></td>
                    </tr>
                    <tr>
                        <td style="width:110px" class=colh><b>Sexo</b></td>
                        <td class=campop >
                            <c:if test="${per.id_sexo == 'M'}">
                                Masculino
                            </c:if>

                            <c:if test="${per.id_sexo == 'F'}">
                                Femenino
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td  style="width:110px" class=colh><b>Email</b></td>
                        <td class=campop><c:out value="${per.correo}"/></td>
                    </tr>
                    <tr>
                        <td  style="width:110px" class=colh><b>Telefonos</b></td>
                        <td class=campop><c:out value="${per.telefono}"/></td>
                    </tr>
                    <tr>
                        <td  style="width:110px" class=colh><b>Direcci&oacute;n</b></td>
                        <td class=campop><c:out value="${per.direccion}"/></td>
                    </tr>
                    <tr>
                        <td  colspan="2"><hr></td>
                    </tr>
                    <tr>
                        <td>
                            <form name="adminusers" action='<c:url value="/administrarUsuarios.do"/>'>
                                <input type="submit" class="button" value="Administrar usuarios">
                            </form>
                        </td>
                        <td><div align="center">
                                <a href="<c:url value="/modificarPersona_Jes.do">
                                        <c:param name="id_persona" value="${per.id_persona}"/>
                                    </c:url>"><font color="#000066">Modificar</font>
                                </a>
                            </div>
                        </td>
                        <td>
                            <div align="center">
                                <a href="<c:url value="/eliminaPersona_Jes.do">
                                        <c:param name="id_persona" value="${per.id_persona}"/>
                                    </c:url>"><font color="red">Eliminar</font>
                                </a>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
<%@ include file="../VerPieCuerpo.jsp" %>
