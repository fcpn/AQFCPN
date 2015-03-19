<%@ include file="../Cabecera.jsp" %>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<div id="container">
    <div id="content">
        <form name="form1" method="post"  action='<c:url value="/modificarDatosSucursal.do"/>'>
            <table width="335" border="0" align="center">
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
                            <c:out value="${beneficiario.nit}"/>
                            <input type="hidden" name="nit" value="<c:out value="${beneficiario.nit}"/>">
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
                            <c:out value="${beneficiario.proveedor}"/>
                        </div>
                    </td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                    <th>
                        <div align="center">
                            Direcci&oacute;n
                        </div>
                    </th>
                    <td>
                        <div align="left">
                            <input type="text" name="direccion" value="<c:out value="${Sucursal.direccion}"/>" size="50">
                            <input type="hidden" name="id_sucursal" value="<c:out value="${Sucursal.id_sucursal}"/>">
                            
                        </div>
                    </td>
                    <td>
                        <div align="left" class="normal">
                            Inserte aqui la direccion del proveedor
                        </div>
                    </td>
                </tr>
                <tr>
                    <th>
                        <div align="center">
                            Telefonos
                        </div>
                    </th>
                    <td>
                        <div align="left">
                            <input type="text" name="telefonos" value="<c:out value="${Sucursal.telefonos}"/>" size="50">
                        </div>
                    </td>
                    <td>
                        <div align="left" class="normal">
                            Inserte aqui el (o los) numero(s) de telefono
                        </div>
                    </td>
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