<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Comprometido 1</title>
    <style type="text/css">
        <!--
.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo13 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold; }
.Estilo14 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-weight: bold;
}
.Estilo15 {font-size: 10px}
.Estilo16 {color: #CBC196}
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>

<form name="form1" method="post" action="<c:url value="/ModMonCompro3.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#544D29" >
        <td colspan="2" ><div align="center" class="Estilo4">Modificar Montos Comprometidos </div></td>
    </tr>
    <tr bgcolor="#CBC196" >
        <td width="238" ><div align="center"><strong>Actividad</strong></div></td>
        <td width="269" ><div align="center"><strong>Tarea </strong></div></td>
    </tr>
	<tr >
        <td width="238" ><c:out value="${actividad.descripcion}"/> </td>
        <td width="269" ><c:out value="${tarea.descripcion}"/> </td>
    </tr>
</table>
<br>
<br>

<table width="750" border="1" align="center" bordercolor="#CC9933">


<!-- Elige la tarea para mostrala -->
	
<c:if test="${j != '-1'}">
<!--  funciona   -->                        
<c:forEach var="i" begin="0" end="${j}" step="12">  

 
<tr bgcolor="#CBC196">
    <td colspan="3"><span class="Estilo13">Partida</span><span class="Estilo13"> </span><span class="Estilo13">&nbsp;<!---Ultimo # de comprobante-->
    </span></td>
  <tr>
    <td colspan="3">
    
  
    <select name="codigo">
        
        <c:forEach var="g" items="${partida}">                                                            
            <c:if test="${g.tipo == '1'}">
                
                <c:if test="${g.codigo == M[i]}">  
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>" selected><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>  
                <c:if test="${g.codigo != M[i]}">  
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>" ><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                
                
                <!-- <input type=hidden name=tipo value='<c:out value="${g.tipo}"/>'>-->
            </c:if>
            <c:if test="${g.tipo == '2'}">
                
                
                <c:if test="${g.codigo == M[i]}">
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>" selected>&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                <c:if test="${g.codigo != M[i]}">
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>">&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                
                
            </c:if>
            <c:if test="${g.tipo == '3'}">
                
                <c:if test="${g.codigo == M[i]}">
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>" selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                
                <c:if test="${g.codigo != M[i]}">
                    <option value="<c:out value="${g.tipo}"/>::<c:out value="${g.codigo}"/>::<c:out value="${g.descripcion}"/>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></option>
                </c:if>
                
                
                
            </c:if>                                                           
        </c:forEach>             
        
    </select>     </td>
  </tr>
<tr>
<td bgcolor="#CBC196"><span class="Estilo13">Fuente Econ&oacute;mica</span></td>
<td bgcolor="#CBC196" class="Estilo13">Monto Comprometido</td>
<td width="383" bgcolor="#CBC196"><span class="Estilo16"></span></td>
</tr>
<tr>
<td>

<select name="codfueneco">
        
        <c:forEach var="fe" items="${fuente}">
            <c:if test="${fe.codfueneco == M[i+1]}">
                <option value="<c:out value="${fe.codfueneco}"/>" selected><c:out value="${fe.codfueneco}"/> - <c:out value="${fe.descripcion}"/></option>
            </c:if>
            <c:if test="${fe.codfueneco != M[i+1]}">
                <option value="<c:out value="${fe.codfueneco}"/>"><c:out value="${fe.codfueneco}"/> - <c:out value="${fe.descripcion}"/></option>
            </c:if>
        </c:forEach>                                                         
        
        <!-- llevando los parametros   -->
                                                        
                                                        
    </select></td>
<td><input name="moncom" type="text" id="monto" value="<c:out value="${M[i+2]}"/>"></td>
<td>&nbsp;</td>
</tr>

<tr bgcolor="#CBC196">
    <td width="196"><span class="Estilo13">Fecha</span></td>
    <td width="270" ><span class="Estilo13">Glosa</span></td>
    
    <td><div align="left"><span class="Estilo13">Observaciones<!---Ultimo # de comprobante-->
        </span>

  </div>
  <tr>
    <td><table width="200" border="0">
      <tr>
        <td><div align="center">
            <input name="dia" type="text" id="dia6" size="3" maxlength="2" value="<c:out value="${M[i+9]}"/>">
        </div></td>
        <td><div align="center">
            <input name="mes" type="text" id="mes5" size="3" maxlength="2" value="<c:out value="${M[i+10]}"/>">
        </div></td>
        <td><div align="center">
            <input name="anio" type="text" id="anio5" size="3" maxlength="2" value="<c:out value="${M[i+11]}"/>">
        </div></td>
      </tr>
      <tr bgcolor="#BAAD74">
        <td><div align="center" class="Estilo14 Estilo15">Dia</div></td>
        <td><div align="center" class="Estilo13">Mes</div></td>
        <td><div align="center" class="Estilo13">A&ntilde;o</div></td>
      </tr>
    </table>	</td>
    <td><div align="center">
      <textarea name="glosa" cols="30" rows="3" id="Glosa" ><c:out value="${M[i+4]}"/></textarea>
    </div>     </td>
    
    <td><div align="center">
      <input name="obs" type="text" id="obs" value="<c:out value="${M[i+6]}"/>">
    </div></td>
  </tr>







<tr>
    <td colspan="3" bgcolor="#CCCCCC"><span class="Estilo13"> </span></td>
  </tr>
 <tr bordercolor="#666666" bgcolor="#666666">
    <td height="19" colspan="6">&nbsp;  </td>
  </tr>
<input type=hidden name=complemento value='<c:out value="${M[i]}"/>::<c:out value="${M[i+1]}"/>::<c:out value="${M[i+2]}"/>::<c:out value="${M[i+3]}"/>::<c:out value="${M[i+8]}"/>'>

 </c:forEach>
 

 
 <c:if test="${j != '-1'}">
     
<input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${codtar}"/>'>
<tr bgcolor="#BAAD74">
    <td height="19" colspan="6"><div align="right">
      <input type="submit" name="Submit" value="Modificar">
    </div></td>
</tr>

</c:if>
 
 
</c:if>

</table>



<c:if test="${j == '-1'}">
Usted no eligió Montos Comprometidos para Ejecutar </c:if>

<br>
<br><br>
    <div align="right"><a href="javascript:history.back(0);">Volver Atras</a></div>

</form>
<p>&nbsp;</p>
</body>
</html>