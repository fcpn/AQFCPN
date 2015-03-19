<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>
        
        <style type="text/css">
            <!--
.Estilo1 {color: #003399}
.Estilo3 {color: #003399; font-size: 12px; }
.Estilo4 {font-weight: bold}
            -->
        </style>
    </head>
    
    <body>
        <form name="form1" method="post" action="<c:url value="/InsertaNoPreIngDetalle3.do"/>"">
              <div class="topdentro"> 
                <div align="center"> 
                    <p>&nbsp;</p>
                    <table width="637" height="287" border="3" align="center" >
                        <tr> 
                            <td width="623" >  
                               
                                
                                
                                <table width="674" border="0" align="center">
                                    <tr bordercolor="#00FF99">
                                        <td colspan="4"><div align="center" class="Estilo1 Estilo6">
                                                <h3>Nuevo DETALLE 2</h3>
                                                   Ud. eligió el grupo [<c:out value="${grupo.cod_gnp}"/> - <c:out value="${grupo.descripcion}"/> ]
                                                 
                                                
                                                
                                                
                                        </div></td>
                                    </tr>
                                    <tr>
                                        <td width="289">&nbsp;</td>
                                        <td colspan="2">&nbsp;</td>
                                        <td width="198"><!-- database mostrar grupo-->&nbsp;</td>
                                    </tr>
                                    <tr bgcolor="#DFDABD">
                                        <td bgcolor="#DFDABD"><span class="Estilo3">Elija <strong><u>SubGrupo </u></strong> para insertar Detalle --&gt;</span></td>
                                        <td colspan="3"><select name="cod_snp">
                                                <c:forEach var="g" items="${subgrupo}">
                                                    <option value="<c:out value="${g.cod_snp}"/>"> <c:out value="${g.cod_snp}"/> - <c:out value="${g.descripcion}"/> </option>
                                                   
                                                </c:forEach> 
                                        </select></td>
                                    </tr>
                                    <tr >
                                        <td colspan="4"></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="3">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="3">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td width="1">&nbsp;</td>
                                        <td width="68"><input type="submit" name="Submit" value="Aceptar"></td>
                                        <td>
                                            <div align="right">
                                                <input type="reset" name="Submit2" value="cancelar">
                                    </div></td></tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>
                                        <div align="right">                </div></td>
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
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr bordercolor="#00FF99" bgcolor="#BAAD74">
                                        <td colspan="4"><div align="center" class="Estilo6 Estilo2 Estilo3 Estilo4">
                                                <div align="center"><span class="Estilo1">[<a href="Rubro.do">Atras</a>]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<a href="insertarcuentasaingresos.do">Men&uacute; Rubro</a>]</span></div>
                                        </div></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                            </table>          </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>