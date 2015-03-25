<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Mostrando los montos presupuestados</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                window.resizeTo(1150, 500);
            });
        </script>
    </head>
    <body>
        <div id="content">
            <form name="form1" method="post" action="<c:url value="/ejecucionparcial1.do"/>">
                <table width="650" border="1" align="center">
                    <tr>
                        <th colspan="7">
                            <strong><div align="center">Glosa Inicial</div></strong>
                        </th>
                    </tr>
                    <tr >
                        <th width="150"><div align="center"><strong>Glosa</strong></div></th>
                    <th width="50"><div align="center"><strong>Cantidad</strong></div></th>
                    <th width="30"><div align="center"><strong>Monto</strong></div></th>
                    <th colspan="2" width="100" ><div align="center"><strong>C&oacute;digo Actividad</strong></div></th>
                    <th><div align="center"><strong>Partida</strong></div></th>
                    <th><div align="center"><strong>FF-OF</strong></div></th>
                    </tr>
                    <tr>
                        <td height="89" valign="top">
                            <textarea name="glosainicial" cols="30" id="glosainicial"><c:out value="${lis_cert.glosa}"/></textarea>
                        </td>
                        <td valign="top"><div align="center" >
                                <c:out value="${lis_cert.cantidad}"/>
                        </td>
                        <td valign="top"><div align="center">
                                <c:out value="${lis_cert.monto}"/></div>
                        </td>

                        <td colspan="2" valign="top"><div align="center"><c:out value="${lis_cert.codtar}"/></div>
                        </td>
                        <!--  <c:out value="${g.codmonegr}"/> -->
                        <td valign="top"><div align="center">
                                <c:out value="${lis_cert.codmonegr}"/>
                            </div>
                        </td>

                        <td valign="top"><div align="center">
                                <c:out value="${lis_cert.codfueneco}"/>
                            </div>
                        </td>
                        <!--<td valign="top"><div align="center"><textarea name="responsable" cols="25" id="responsable"><c:out value="${lis_cert.responsable}"/></textarea></div>  </td>-->
                    </tr>
                    <tr>
                        <th colspan="7">
                            <strong><div align="center">Glosa de Ejecuci&oacute;n</div></strong>
                        </th>
                    </tr>
                    <tr>
                    <th><div align="center"><strong>Glosa</strong></div></th>
                    <th><div align="center"><strong>Nro. del Comprobante</strong></div></th>
                    <th><div align="center"><strong>Fecha</strong></div></th>
                    <th><div align="center" width="40"><strong>Hoja de Ruta</strong></div></th>
                    <th><div align="center" width="40"><strong>Nro. del Cheque</strong></div></th>
                    <th><div align="center"><strong>Monto</strong></div></th>
                    </tr>
                    <tr>
                        <td height="89" valign="top">
                            <textarea name="glosaejecucion" cols="30" id="glosa2" required><c:out value="${lis_cert.glosa}" /></textarea>
                        </td>
                        <td>
                            <div align="center"><input type="text" name="nrocomprobanteejecucion" id="nrocomprobante" required></div>
                        </td>
                        <td>
                            <div align="center"><input type="text" name="fechaejecucion" id="fecha" pattern="[0-3][0-9]/[0-1][0-9]/[0-9][0-9]" title="Debe de coloar la fecha en el siguiente formato dd/mm/aa" size="10" required></div>
                        </td>
                        <td>
                            <div align="center"><input type="text" name="hojaderutaejecucion" id="hojaderuta" required></div>
                        </td>
                        <td>
                            <div align="center"><input type="text" name="nrochequeejecucion" id="nrocheque" required></div>
                        </td>
                        <td>
                            <div align="center"><input type="number" name="montoejecucion" step="0.01" id="mont" pattern="[0-9]{1,}.[0-9]{2}" title="Debe de colocar el monto en el siguiente formato ###,##" required max="<c:out value="${lis_cert.monto}"/>" min="0"></div>
                        </td>
                        <td>
                            <div align="center"><input type="submit" value="Ejecutar"></div>
                            <input type='hidden' name='idregistroinicial' value='<c:out value="${lis_cert.id}"/>'>
                        </td>
                    </tr>
                </table>


            </form>
            <div align="right"><a href="javascript:history.back(1)">Volver Atrás</a></div>
            <p>&nbsp;</p>
    </body>
</html>