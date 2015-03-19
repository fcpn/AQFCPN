<%@ include file="../Cabecera.jsp" %>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<div id="container">
    <div id="content">
        <font color="red"><c:out value="${mensaje}"/><br></font>
        <table width="562" border="0">
            <tr>
                <td colspan="5">
                    <div align="center"> 
                        <a href=<c:url value="/benefis.do">
                           </c:url>><font color="red">Menu Proveedores</font></a>
                    </div>
                </td>
            </tr>
            <tr>
                <th colspan="5"><div align="center">PROVEEDOR/BENEFICIARIO</div></th>
            </tr>
            <tr>
                <th width="137"><div align="center">NIT</div></th>
                <th width="304"><div align="center">PROVEEDOR</div></th>
                <td width="67">&nbsp;</td>
                <td width="68">&nbsp;</td>
                <td width="36">&nbsp;</td>
            </tr>
            <tr>
                <td align="justify"><c:out value="${beneficiario.nit}"/></td>
                <td><c:out value="${beneficiario.proveedor}"/></td>
                <td>
                    <a href=<c:url value="/abcdfBeneficiario.do">
                           <c:param name="opcion" value="nueva_sb"/>
                           <c:param name="nit" value="${beneficiario.nit}"/>
                       </c:url>><font color="green">Nueva Sucursal</font></a>
                </td>
                <td>
                    <a href=<c:url value="/abcdfBeneficiario.do">
                           <c:param name="opcion" value="modifica_b"/>
                           <c:param name="nit" value="${beneficiario.nit}"/>
                       </c:url>>Modificar</a>
                </td>
                <td>
                    <a href=<c:url value="/abcdfBeneficiario.do">
                           <c:param name="opcion" value="elimina_b"/>
                           <c:param name="nit" value="${beneficiario.nit}"/>
                       </c:url>><font color="red">Eliminar</font></a>
                </td>
            </tr>
            <tr>
                <th colspan="2"><div align="center">Sucursales</div></th>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <th>Telefonos</th>
                <th>Direccion</th>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <c:forEach var="moo" items="${Sucursal}">
                <tr>
                    <td><c:out value="${moo.telefonos}"/></td>
                    <td><c:out value="${moo.direccion}"/></td>
                    <td>&nbsp;</td>
                    <td>
                        <a href=<c:url value="/abcdfBeneficiario.do">
                               <c:param name="opcion" value="modifica_s"/>
                               <c:param name="nit" value="${moo.nit}"/>
                               <c:param name="id_sucursal" value="${moo.id_sucursal}"/>
                           </c:url>>Modificar</a>
                    </td>
                    <td>
                        <a href=<c:url value="/abcdfBeneficiario.do">
                               <c:param name="opcion" value="elimina_s"/>
                               <c:param name="nit" value="${moo.nit}"/>
                               <c:param name="id_sucursal" value="${moo.id_sucursal}"/>
                           </c:url>><font color="red">Eliminar</font></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@ include file="../VerPieCuerpo.jsp" %>