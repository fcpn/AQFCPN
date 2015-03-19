<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Tarea2</title>
        
        <style type="text/css">
            <!--
.Estilo1 {color: #003399}
.Estilo3 {color: #003399; font-size: 12px; }
.Estilo4 {font-weight: bold}
            -->
        </style>
    </head>
    
    <body>
        <form name="form1" method="post" action=" <c:url value="/MonNoPreIng3.do"/>"">
            <div class="topdentro"> 
                <div align="center"> 
                    <p>&nbsp;</p>
                    <table width="637" height="287" border="3" align="center" >
                        <tr> 
                            <td width="623" >  
                                <table width="574" border="0" align="center">
                                    <tr bordercolor="#00FF99">
                                        <td colspan="4"><div align="center" class="Estilo1 Estilo6">
                                                <h3>Montos - NO -Presupuestados</h3>
                                        </div></td>
                                    </tr>
                                    <tr>
                                        <td colspan="4"><!-- database mostrar grupo-->                &nbsp;
                                        <div align="center"><span class="Estilo1"><strong>Ud. eligi&oacute; el programa [<c:out value="${programa.descripcion}"/>]</strong></span></div></td>
                                    </tr>
                                    <tr bgcolor="#DFDABD">
                                        <td width="253" bgcolor="#DFDABD"><span class="Estilo3">Elija <strong><u>Actividad</u></strong> para insertar monto--&gt;</span></td>
                                        <td colspan="3"><select name="codacti">
                                                
                                                <c:forEach var="pat" items="${proacttar}">
                                                     <option value="<c:out value="${pat.codacti}"/>"><c:out value="${pat.codacti}"/> - <c:out value="${pat.descripcion}"/></option>
                                                </c:forEach> 
                                                    
                                                
                                            </select>
                                            
                                            
                                            
                                        </td>
                                        
                                        
                                        
                                        
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
                                        <td width="37">&nbsp;</td>
                                        <td width="68">&nbsp;</td>
                                        <td width="198">
                                    <div align="right">                </div></td></tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td><input type="submit" name="Submit" value="Aceptar"></td>
                                        <td>
                                            <div align="right">
                                                <input type="reset" name="Submit2" value="cancelar">
                                        </div></td>
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
                                                <div align="center"><span class="Estilo1">[Elegir Programa] &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;[Inicio]</span></div>
                                        </div></td>
                                    </tr>
                            </table>          </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>