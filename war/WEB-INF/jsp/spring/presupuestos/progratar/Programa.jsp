<%@ include file="../../Cabecera.jsp" %>

<html>
    <head>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>Grupo Rubro</title>

    </head>
    <body>
        <div id="container">
<div id="content">
    <form name="form1" method="post" action="<c:url value="/InsertarPrograma.do"/>">
       <table width="421" border="0" align="center">
            <tr>
                 <th height="30" colspan="4"><div align="center">Nuevo Programa</div></th>
             </tr>
                                                        <tr>
                                                            <th width="139"><div align="left">C&oacute;digo</div></th>
                                                        <td colspan="3"><div align="left">
                                                              <input name="codigo" type="text" id="codigo" size="25">
                                                            </div></td>
                                                        </tr>
                                                        <tr>
                                                            <th><div align="left">Descripci&oacute;n de Programa</div></th>
                                                            <td colspan="3"><div align="left">
                                                              <input name="descripcion" type="text" id="descripcion" size="40">
                                                            </div></td>
                                                        </tr>

                                                        <tr>
                                                            <th><div align="left">Unidad Ejecutora</div></th>
                                                            <td colspan="3"><div align="left">
                                                              <input name="u_ejecutora" type="text" id="u_ejecutora" size="40">
                                                            </div></td>
                                                        </tr>

                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td width="62"><input type="submit" name="Submit" value="Guardar"></td>
                                                            <td width="14">&nbsp;</td>
                                                            <td width="188"><input type="reset" name="Submit2" value="Cancelar"></td>
                                                        </tr>
                                                </table>



    </form>
</div></div>
    </body>
</html>