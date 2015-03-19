<%@ include file="../Cabecera.jsp" %>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<div id="container">
    <div id="content">
        <form name="form1" method="post"  action='<c:url value="/modificarDatosBeneficiario.do"/>'>
            <table width="335" border="0" align="center">
                <tr>
                    <td colspan="3">
                        <div align="center">
                            <a href=<c:url value="/benefis.do">
                               </c:url>><font color="red">Menu Proveedores</font></a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th width="203" colspan="3"><div align="center">Nuevo Proveedor/Beneficiario</div></th>
                </tr>
                <tr>
                    <th>
                        <div align="center">
                            Numero de NIT
                        </div>
                    </th>
                    <td>
                        <div align="left">
                            <input type="text" name="nit" value="<c:out value="${beneficiario.nit}"/>" size="50">
                            <input type="hidden" name="nitAnterior" value="<c:out value="${beneficiario.nit}"/>">
                        </div>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <th>
                        <div align="center">
                            Nombre del Proveedor
                        </div>
                    </th>
                    <td>
                        <div align="left">
                            <input type="text" name="proveedor" value="<c:out value="${beneficiario.proveedor}"/>" size="50">
                        </div>
                    </td>
                    <td>&nbsp;</td>
                </tr>

                <tr>
                    <td colspan="3">
                        <div align="right">
                            <input type="submit" name="Submit" value="Guardar Cambios">
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@ include file="../VerPieCuerpo.jsp" %>