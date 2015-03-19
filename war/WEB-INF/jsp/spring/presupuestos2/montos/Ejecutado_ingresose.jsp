<%@ include file="../../Cabecera.jsp" %>


<html>
    <head>
        <title>montos presupuestados</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        
        <style type="text/css">
            <!--
.Estilo2 {
	color: #FFFFFF;
	font-weight: bold;
}
.Estilo3 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
}
.Estilo4 {font-size: 10px}
.Estilo5 {font-family: Verdana, Arial, Helvetica, sans-serif; font-weight: bold; font-size: 10px; }
.Estilo7 {font-size: 24px}
            -->
        </style>
    </head>
    
    <body> 
        <form name="form1" method="post" action="<c:url value="InsertarEjecutadose.do"/>">
            <div class="topdentro"> 
                <div align="center"> 
                    <br>
                    
                    <table width="494" border="1">
                        <tr>
                            <td width="499"><table width="483" border="0" align="center">
                                    <tr bgcolor="#4B4625" width="230">
                                        <td colspan="7"><div align="center" class="Estilo2"><span class="Estilo1">Insertar Montos <span class="Estilo7">Ejecutados</span> a Egresos</span></div></td>
                                    </tr>
                                    <tr bgcolor="#E4E4E4" width="230">
                                        <td colspan="4"><div align="center" class="Estilo3 Estilo4">Actividad  </div></td>
                                        
                                        <td colspan="3"><div align="center" class="Estilo5">Tarea</div></td>
                                    </tr>
                                    <tr> 
                                        <td colspan="4"><div align="justify"><c:out value="${actividad.descripcion}"/></div></td>
                                        <td colspan="3"><div align="justify"><c:out value="${tarea.descripcion}"/></div></td>
                                    </tr>
                                    <tr>
                                        <td colspan="4"><font size="3"><strong> </strong></font></td>
                                        <td colspan="3"><font size="3"><strong> </strong></font></td>
                                    </tr>
                                    <tr bgcolor="#B4B4B4" class="Estilo4">
                                        <td colspan="7"><span class="Estilo3">Partida</span></td>
                                    </tr>
                                    <tr bgcolor="#DAD5B6">
                                        <td height="44" colspan="7"><font size="3"><strong>
                                                    <select name="codigo">
                                                        
                                                        <c:forEach var="g" items="${partida}">                                                            
                                                           <!-- <c:if test="${g.tipo == '1'}">
                                                                <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>" ><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                                                         <input type=hidden name=tipo value='<c:out value="${g.tipo}"/>'>
                                                            </c:if>-->
                                                          <!--   <c:if test="${g.tipo == '2'}">
                                                                <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>">&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                                                               <input type=hidden name=tipo value='<c:out value="${g.tipo}"/>'>
                                                            </c:if>-->
                                                            <c:if test="${g.tipo == '3'}">
                                                                <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>"><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                                                             <!--   <input type=hidden name=tipo value='<c:out value="${g.tipo}"/>'>-->
                                                            </c:if>                                                           
                                                        </c:forEach>             
                                                        
                                                    </select>
                                            </strong></font><font size="3"><strong>
                                        </strong></font></td>
                                    </tr>
                                    <tr bgcolor="#B4B4B4">
                                        <td colspan="4"><span class="Estilo5">Fuente
                                        </span></td>
                                        <td colspan="3"><span class="Estilo5">Monto a Ejecutar</span></td>
                                    </tr>
                                    <tr>
                                        <td height="39" colspan="4" bgcolor="#DAD5B6"><font size="3"><strong>
                                                    <select name="codfueneco">
                                                        <c:forEach var="fe" items="${fuente}">
                                                            <option value="<c:out value="${fe.codfueneco}"/>"><c:out value="${fe.codfueneco}"/> - <c:out value="${fe.descripcion}"/></option>
                                                        </c:forEach>                                                         
                                                        
                                                        <!-- llavando los parametros   -->
                                                        
                                                        
                                                    </select>
                                        </strong></font> </td>
                                        <td colspan="3" bgcolor="#DAD5B6"><input name="monpreegr" type="text" id="monpreegr" size="8"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="4" bgcolor="#B4B4B4"><span class="Estilo5">Saldos a la fecha</span></td>
                                        <td colspan="3" bgcolor="#B4B4B4"><span class="Estilo5"> </span></td>
                                    </tr>
                                    
                                    <tr>
                                        <td width="33" align="center" bgcolor="#DAD5B6"><div align="center">
                                                <input name="dia" type="text" id="dia" size="2" maxlength="2">                                          
                                        </div>                                          <div align="center"></div></td>
                                        <td width="38" bgcolor="#DAD5B6" align="center"><div align="center">
                                                <input name="mes" type="text" id="mes" size="2" maxlength="2">
                                        </div></td>
                                        <td width="31" bgcolor="#DAD5B6" align="center"><div align="center">
                                                <input name="ani" type="text" id="ani" size="2" maxlength="2"> 
                                        </div></td>
                                        <td width="32" bgcolor="#B4B4B4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                        <td colspan="3" bgcolor="#DAD5B6">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td bgcolor="#B4B4B4" class="Estilo5"><div align="left">Dia </div></td>
                                        <td bgcolor="#B4B4B4"><div align="left"><span class="Estilo5">mes</span></div></td>
                                        <td bgcolor="#B4B4B4"><div align="left"><span class="Estilo5">a&ntilde;o</span></div></td>
                                        <td bgcolor="#B4B4B4">&nbsp;</td>
                                        <td width="164" bgcolor="#BDB47D">&nbsp;</td>
                                        <td colspan="2" bgcolor="#BDB47D">&nbsp;</td>
                                    </tr>
                                    <tr bgcolor="#DFDABD">
                                        <td colspan="7"><!-- <a href="#">Ver montos presupuestados Ingresos</a> --></td>
                                    </tr>
                                    <tr>
                                        <td colspan="4" bgcolor="#B4B4B4">
                                            
                                        <div align="left" class="Estilo5">Comprobante </div></td>
                                        <td colspan="3" bgcolor="#B4B4B4">
                                        <div align="left" class="Estilo5"><strong>Glosa</strong></div></td>
                                    </tr>
                                    <tr>
                                        <td height="34" colspan="4" bgcolor="#DAD5B6"><input name="comprobante" type="text" id="comprobante" size="20"></td>
                                        <td colspan="3" bgcolor="#DAD5B6"><input name="obs" type="text" id="obs" size="50"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="4">&nbsp;</td>
                                        <td colspan="2">&nbsp;</td>
                                        <td width="127"><input type="submit" name="Submit2" value="Aceptar"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="4">&nbsp;</td>
                                        <td colspan="2">&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td colspan="4">&nbsp;</td>
                                        <td colspan="2">&nbsp;</td>
                                        <td><input type="reset" name="Submit3" value="cancelar"></td>
                                    </tr>
                                </table>
                            <div align="center"></div></td>
                        </tr>
                    </table>
                    <br>
                </div>
            </div>
            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
            
        </form>
    </body>
</html>
