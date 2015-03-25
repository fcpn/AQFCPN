<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Mostrando los montos presupuestados</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
       
</head>
<body>          
    <div id="content">
        <form name="form1" method="post" action="<c:url value="/InsCom.do"/>">
            <table  align="center">
                <tr>
                    <th colspan="2"><div align="center"><h2>Montos Comprometidos Egresos</h2> </div></th>
                </tr>
                <tr>
                    <th><div align="center"><strong>Actividad </strong></div></th>
                    <th><div align="center"><strong>Tarea </strong></div></th>
                </tr>
                <tr>
                    <td><strong> <c:out value="${actividad.descripcion}"/> </strong></td>
                        <input type=hidden name=desact value='<c:out value="${actividad.descripcion}"/>'>
                        <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                    <td><strong> <c:out value="${tarea.descripcion}"/> </strong> </td>
                        <input type=hidden name=destar value='<c:out value="${tarea.descripcion}"/>'>
                        <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                </tr>
            </table>
            
<!-- mostrando datos generales -->

 <table align="center">
    <c:forEach var="grl" items="${grl}">
      <c:if test="${grl.codtar==tarea.codtar }">
        <tr>
            <th >Identificacion de la Funci&oacute;n </th>
            <td colspan="5"> <c:out value="${grl.funcion}"/> </td>
        </tr>
        <tr>
            <th>Responsable</th>
            <td colspan="5"><c:out value="${grl.nom}"/> <c:out value="${grl.ap}"/> <c:out value="${grl.am}"/></td>
        </tr>
        <tr>
            <th>Cargo del Responsable</th>
            <td colspan="2"><c:out value="${grl.cargo}"/></td>
            <th>Carga horaria </th>
            <td colspan="2"><c:out value="${grl.cargah}"/></td>
        </tr>
        <tr>
            <th>Objetivo</th>
            <td colspan="5"><c:out value="${grl.objetivo}"/></td>
        </tr>
        <tr>
            <th>Fecha de inicio </th>
            <td colspan="2"><c:out value="${grl.fechai}"/></td>
            <th>Fecha Final </th>
            <td colspan="2"><c:out value="${grl.fechaf}"/></td>
        </tr>
        <tr>
            <td colspan="7">&nbsp;</td>
        </tr>
        <tr>
            <td colspan="7">&nbsp;</td>
        </tr>
        <tr>
            <th>#  de Participantes </th>
            <td><div align="right"> <c:out value="${grl.np}"/> </div></td>
            <td>&nbsp;</td>
            <th># Estudiantes </th>
            <td><div align="right"><c:out value="${grl.nee}"/></div></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <th># de Adm</th>
            <td><div align="right"><c:out value="${grl.na}"/></div></td>
            <td>&nbsp;</td>
            <th># Docentes </th>
            <td><div align="right"><c:out value="${grl.nd}"/></div></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td colspan="7">&nbsp;</td>
        </tr>
        <tr>
            <th>Apertura Program&aacute;tica  </th>
            <td height="23" colspan="2"><c:out value="${actividad.apertura_prog}"/></td>
            <td colspan="3">&nbsp;</td>

        </tr>
      </c:if>
    </c:forEach>
</table>
<!-- FIN FIN FIN mostrando datos generales -->

<br>
<br>

<table align="center">
<tr>
    <th >&nbsp;</th>
    <th>Fuente Econ&oacute;mica</th>
    <th>&nbsp;Presupuestado<!---Ultimo # de comprobante--></td>
    <th> Ejecutado<!--monto insertando --></td> 
    <th>Saldo</th>
    <td> </td>
</tr>
<c:forEach var="mo" items="${mosmoneje}">  
    <c:if test="${mo.codtar==tarea.codtar }">
        <tr>
            <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
            <td><c:out value="${mo.codfueneco}"/> - <c:out value="${mo.desfe}"/></td>
            <td><div align="right">&nbsp;<c:out value="${mo.monto}"/></div></td>
            <td><div align="right">&nbsp;<c:out value="${mo.moneje}"/></div></td>
            <td><div align="right">&nbsp;<c:out value="${mo.saldo}"/> </div></td>
            <td> <input type="checkbox" name="compro" value="<c:out value="${mo.codmoning}"/>::<c:out value="${mo.codfueneco}"/>::<c:out value="${mo.ref123}"/>"></td>
	</tr>
    </c:if>              
</c:forEach>    
<!--Montos No presupuestados -->
<tr>
    <th colspan="6" >Montos No Presupuestados</th>
</tr>

<c:forEach var="moo" items="${mos}">  
    <!-- Elige la tarea para mostrala -->
    <c:if test="${moo.codtar==tarea.codtar }">
        <tr>
            <td><c:out value="${moo.codmonnopreegr}"/> - <c:out value="${moo.descla}"/></td>
            <td><c:out value="${moo.codfueneco}"/></td>
            <td>&nbsp;<!--comprocompro--><div align="right"></div></td>
            <td><div align="right"><c:out value="${moo.monejenopre}"/><!--UltiMonInser--></div></td>
            <td><div align="right">&nbsp;</div></td>
            <td>&nbsp;</td>
        </tr>
    </c:if>              
</c:forEach> 
<!--FINFIN Montos No presupuestados -->

<!--TOTALES suma -->
<tr>
    <th>TOTALES</th>
    <td> &nbsp;&nbsp; </td>
    <td><div align="right">[<c:out value="${too}"/>]<!--comprocompro--></div></td>
    <td><div align="right">[<c:out value="${too2 + too3}"/>]<!--UltiMonInser--></div></td>
    <td><div align="right">[<c:out value="${too1}"/>]</div></td>
    <td>&nbsp;</td>
</tr>

<!--FIN FIN TOTALES suma -->
<tr>
    <td colspan="7" ></td>
</tr>
<tr>
    <td colspan="7"><div align="right"><input type="submit" name="Submit" value="Aceptar"><!--[Salir a Men&uacute; Principal] --></span></div></td>
</tr>
</table>
  </form>
<c:if test="${tooz==too}">
    <h5> LOS TOTALES DE MONTOS PRESUPUESTADOS ENTRE INGRESOS Y EGRESOS SON IGUALES </h5>
</c:if><c:if test="${tooz!=too}">
    <font color="#FF0000"><h3> LOS TOTALES DE MONTOS PRESUPUESTADOS ENTRE INGRESOS Y EGRESOS NO SON IGUALES</h3></font><a href=<c:url value="/MostrarTarIngEgr.do">            
                       <c:param name="codtar" value="${tarea.codtar}"/>
                       <c:param name="descripcion" value="${tarea.descripcion}"/>
                       
                   </c:url>><h6> Ver Historial Montos Presupuestados Ingresos y Egresos</h6> </a> 
    </c:if>
</div>
</body>
</html>
