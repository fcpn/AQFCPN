<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Ejecutar montos Comprometidos</title>
    <style type="text/css">
        <!--
.Estilo3 {color: #003399}
.Estilo4 {
	color: #2A3399;
	font-weight: bold;
	font-size: 24px;
}
.Estilo12 {font-family: Verdana, Arial, Helvetica, sans-serif; font-weight: bold; font-size: 10px; }
.Estilo13 {font-size: 10px}
            -->
    </style>
</head>
<body>          
<p>&nbsp;</p>

<form name="form1" method="post" action="<c:url value="/ModMonCompro2.do"/>">
<table width="523" border="1" align="center" bordercolor="#CC9933">
    <tr bgcolor="#BAAD74" >
        <td colspan="2" ><div align="center" class="Estilo4">Modificar Montos Comprometidos - Egresos </div></td>
    </tr>
    <tr bgcolor="#DED8BC" >
        <td width="238" ><div align="center"><strong>Actividad </strong></div></td>
        
        <td width="269" ><div align="center"><strong>Tarea </strong></div></td>

    </tr>
	<tr>
        <td width="238" ><strong> <c:out value="${actividad.descripcion}"/> </strong></td>
        <input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>
        <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
        <td width="269"><strong> <c:out value="${tarea.descripcion}"/> </strong> </td>
        <input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>
        <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
    </tr>
</table>

<!-- mostrando datos generales -->
<br><br><br>
<table width="842" border="1" align="center" bordercolor="#CC9933">
<tr>
    <td width="80" bgcolor="#BAAD74"><span class="Estilo12">Partida</span></td>
    <td width="128" bgcolor="#BAAD74" ><span class="Estilo12"> Fuente Econ&oacute;mica </span></td>
    
    <td width="147" bgcolor="#BAAD74"><span class="Estilo12">&nbsp;Monto Comprometido</span></td>
    <td width="337" bgcolor="#BAAD74"><span class="Estilo12">Glosa </span></td>
    <td width="116"><span class="Estilo13"></span></td>
</tr>



<c:forEach var="mo" items="${refcompro}">  
   
            <tr>
            <td><c:out value="${mo.codmonegr}"/></td>
            <td><c:out value="${mo.codfueneco}"/></td>
            <td><div align="right">&nbsp;<c:out value="${mo.monto}"/>          
            </div></td>
          
            <td><c:out value="${mo.glosa}"/></td>
		
        <c:if test="${mo.i_e == 3}">

            <td> <a  href="<c:url value="/MosCertProc.do">
                            <c:param name="codtar" value="${mo.codtar}"/>
                            <c:param name="fecha" value="${mo.fecha}"/>
                            <c:param name="num_sol" value="${mo.num_sol}"/>

                </c:url>"> Cert.# <c:out value="${mo.num_sol}"/></a></td>

        </c:if>

       <c:if test="${mo.i_e != 3}">
          <td><input type="checkbox" name="comproref" value="<c:out value="${mo.codmonegr}"/>::<c:out value="${mo.codfueneco}"/>::<c:out value="${mo.monto}"/>::<c:out value="${mo.id}"/>::<c:out value="${mo.glosa}"/>::<c:out value="${mo.fecha}"/>::<c:out value="${mo.obs}"/>::<c:out value="${mo.i_e}"/>::<c:out value="${mo.ref123}"/>"></td>
        </c:if>
        </tr>
              
</c:forEach>    



    <c:if test="${gg != '-1'}">
       <tr bgcolor="#BAAD74">
            <td height="19" colspan="8"><div align="right"><span class="Estilo3">
                        <input type="submit" name="Submit" value="Aceptar">
           </span></div></td>
        </tr>

    </c:if>
</table>

<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
<input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>

</form>

</body>
</html>
