<%@ include file="../Cabecera.jsp" %>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<div id="container">
    <div id="content">
        <font color="red"><c:out value="${mensaje}"/><br></font>
        <table width="335" border="0" align="center">
            <tr>
                <td colspan="2">
                    <div align="center">
                    <a href=<c:url value="/benefis.do">
                       </c:url>><font color="red">Menu Proveedores</font></a>
                    </div>
                </td>
            </tr>
            <tr>
                <th width="203" colspan="2"><div align="center">Beneficiario Guardado</div></th>
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
                    </div>
                </td>
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
            </tr>
            <c:forEach var="moo" items="${Sucursal}">
                <tr>
                    <th>
                        <div align="center">
                            Direcci&oacute;n
                        </div>
                    </th>
                    <td>
                        <div align="left">
                            <c:out value="${moo.direccion}"/>
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
                            <c:out value="${moo.telefonos}"/>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2"> </td>
            </tr>
            <tr>
                <td>
                    <div align="right">
                        <a href=<c:url value="/nuevoBeneficiario.do">
                           <c:param name="nit" value="${beneficiario.nit}"/>
                           </c:url>>Nuevo Beneficiario </a>
                    </div>
                </td>
                <td>
                    <div align="right">
                        <a href=<c:url value="/abcdfBeneficiario.do">
                           <c:param name="nit" value="${beneficiario.nit}"/>
                           <c:param name="opcion" value="nueva_sb"/>
                           </c:url>>Nueva Sucursal</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>
<%@ include file="../VerPieCuerpo.jsp" %>