<%@ include file="../Cabecera.jsp" %>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<div id="container">
    <div id="content">
        <font color="red"><c:out value="${mensaje}"/><br></font>
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
                <th width="203" colspan="3"><div align="center">Beneficiario(s)/Proveedor(es)</div></th>
            </tr>
            <tr>
                <th>
                    <div align="center">
                        Numero de NIT
                    </div>
                </th>
                <th>
                    <div align="left">
                        Nombre del Beneficiario/Proveedor
                    </div>
                </th>
            </tr>
            <c:forEach var="ben" items="${beneficiarios}">
                <tr>
                    <td>
                        <div align="center">
                            <c:out value="${ben.nit}"/>
                        </div>
                    </td>
                    <td>
                        <div align="left">
                            <c:out value="${ben.proveedor}"/>
                        </div>
                    </td>
                    <td>
                        <div align="center">
                            <a href=<c:url value="/verSucursales.do">
                                   <c:param name="nit" value="${ben.nit}"/>
                               </c:url>>Ver Sucursales</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@ include file="../VerPieCuerpo.jsp" %>