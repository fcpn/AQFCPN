<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Sub Grupo </title>
        <style type="text/css">
            <!--
.Estilo1 {color: #003399}
.Estilo2 {
	color: #005ACE;
	font-weight: bold;
	font-size: 24px;
}
.Estilo3 {font-size: 12px}
.Estilo6 {color: #0033FF}
.Estilo8 {color: #003399; font-size: 12px; }
.Estilo10 {color: #003399; font-size: 12px; font-weight: bold; }
            -->
        </style>
    </head>
    <body>

        
        <form name="form1" method="post" action="  <c:url value="/InsertarNoPreEgrSubGrupo.do"/>"">
            <div class="topdentro">
                <div align="center">
                    <table width="646" height="248" border="3" align="center" bordercolor="#FFFFFF" >
                        <tr> 
                            <td width="632" height="238" bgcolor="">
                                <div class="topdentro">
                                    <div align="center">
                                        <p>&nbsp;</p>
                                        <table width="637" height="287" border="3" align="center" >
                                            <tr>
                                                <td width="623" ><table width="200" border="0" align="center">
                                                        <tr>
                                                            <td colspan="4"><div align="center"><span class="Estilo6 Estilo2"> <span class="Estilo1">Nuevo SubGrupo -- (Cuentas No Presupuestarias) -- Egresos</span> </span></div></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="4"><div align="center">
                                                                    <blockquote>
                                                                        <p class="Estilo1"><br>
                                                                        Ud eligi� el grupo [<c:out value="${grup.cod_gnp}"/> - <c:out value="${grup.descripcion}"/> ]</p>
                                                                    </blockquote>
                                                            </div>                                                              </td>
                                                        </tr>
                                                        <tr bgcolor="#DFDABD">
                                                            
                                                            <td width="186"><div align="center"><span class="Estilo1">
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        <input name="codigo" type="text" id="codigo" size="8" maxlength="26" border="ffccff">
                                                            </span></div></td>
                                                            <td colspan="3"><div align="left"><span class="Estilo1">
                                                                        <input name="descripcion" type="text" id="descripcion" size="55">
                                                           
                                                                        <input type=hidden name=cod_gnp value='<c:out value="${grup.cod_gnp}"/>'>
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        </span></div></td>
                                                        </tr>
                                                        <tr bgcolor="#DFDABD">
                                                            <td><span class="Estilo10">C&oacute;digo</span></td>
                                                            <td colspan="3"><strong>&nbsp;<span class="Estilo8">Descripci&oacute;n</span></strong>
                                                            <div align="left"> </div></td>
                                                        </tr>
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td colspan="3">&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td width="186">&nbsp;</td>
                                                            <td width="209">&nbsp;</td>
                                                            <td width="209"><div align="right"> </div></td>
                                                        </tr>
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td><input type="submit" name="Submit" value="Guardar"></td>
                                                            <td>&nbsp;</td>
                                                            <td><input type="reset" name="Submit2" value="Cancelar"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr bordercolor="#00FF99" bgcolor="#BAAD74">
                                                            <td colspan="4"><div align="center" class="Estilo6 Estilo2 Estilo3">
                                                                    <div align="center"><span class="Estilo1"><!--[<a href="SubGrupoRubro.do">Atras</a>]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<a href="insertarcuentasaingresos.do">Men&uacute; Rubro</a>]--></span> <br>
                                                                    </div>
                                                            </div></td>
                                                        </tr>
                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                </table></td>
                                            </tr>
                                        </table>
                                    </div>
                            </div><br>            <p>&nbsp;</p>            </td>
                        </tr>
                    </table>
                </div>
            </div>
            
        </form>
    </body>
</html>