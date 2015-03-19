<%@ include file="../Cabecera.jsp" %>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<div id="container">
    <div id="content">
        <form name="form1" method="post"  action='<c:url value="/buscarBenefiario.do"/>'>
            <table width="335" border="0" align="center">
                <tr>
                    <th colspan="2"> <div align="center">Men&uacute; Proveedores <c:out value="${des}"/> </div></th>
                </tr>
                <tr>
                    <th width="203"><div align="center">Buscar Beneficiario</div></th>
                    <td width="122"><div align="center"></div></td>
                </tr>
                <tr>
                    <td>
                        <div align="center">
                            <input name="busBeneficiario" type="text" size="50" >
                        </div>
                    </td>
                    <td>
                        <div align="center">
                            <a href=<c:url value="/nuevoBeneficiario.do">
                                   <c:param name="moneje" value="${mo.moneje}"/>
                               </c:url>>Nuevo Beneficiario </a>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div align="center">
                            <table width="292" border="0">
                                <tr>
                                    <td width="141">
                                        <div align="center">NIT
                                            <input name="opcionBus" type="radio" value="nit" checked>
                                        </div>
                                    </td>
                                    <td width="141">
                                        <div align="center">NOMBRE
                                            <input name="opcionBus" type="radio" value="nombre">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" class="normal">
                                        <div align="center">
                                            <font color="#FF9900">Para <b>[Mostrar Toda la lista de Proveedores Beneficiarios]</b> no inserte datos en la casilla de busqueda solo presione <b>BUSCAR</b></font>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </td>
                    <td rowspan="2">
                        <div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div align="center">
                            <input type="submit" name="Submit" value="Buscar">
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@ include file="../VerPieCuerpo.jsp" %>