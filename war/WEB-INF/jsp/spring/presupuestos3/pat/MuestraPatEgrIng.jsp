<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Mostrando los montos presupuestados</title>
        <link href="tablarep/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablarep/tablecloth.js"></script>
    </head>
    <body>
        <table width="523" border="0" align="center">
            <tr>
                <th colspan="2" ><div align="center">Informe General </div></th>
    </tr>
    <tr>
        <th width="238" ><div align="center">Actividad</div></th>
<th width="269" ><div align="center">Tarea</div></th>
</tr>
<tr>
    <td width="238" ><c:out value="${actividad.descripcion}"/></td>
    <td width="269" ><c:out value="${fech.descripcion}"/> </td>
</tr>
<tr>
    <th colspan="2"><div align="center">Fecha de Actualizaci&oacute;n </div></th>
</tr>
<tr>
    <td colspan="2" ><div align="center"><strong><c:out value="${fech.fecha_act}"/></strong></div></td>
</tr>
</table>
<!-- DATOS GENERALES-->
<table width="630" border="0" align="center">
    <c:forEach var="grl" items="${grl}">
        <c:if test="${grl.codtar==codtar }">
            <tr>
                <th width="192">Identificacion de la Funci&oacute;n </th>
                <td colspan="4"> <c:out value="${grl.funcion}"/> </td>
            </tr>
            <tr>
                <th>Responsable</th>
                <td colspan="4"><c:out value="${grl.nom}"/> <c:out value="${grl.ap}"/> <c:out value="${grl.am}"/></td>
            </tr>
            <tr>
                <th>Cargo del Responsable</th>
                <td width="195"><c:out value="${grl.cargo}"/></td>
                <th width="95">Resultado </th>
                <td width="108"><c:out value="${grl.cargah}"/></td>
            </tr>
            <tr>
                <th>Objetivo</th>
                <td colspan="4"><c:out value="${grl.objetivo}"/></td>
            </tr>
            <tr>
                <th>Fecha de inicio </th>
                <td><c:out value="${grl.fechai}"/></td>
                <th>Fecha Final </th>
                <td><c:out value="${grl.fechaf}"/></td>
            </tr>
            <tr>
                <td height="23" colspan="5">&nbsp;</td>
            </tr>
            <tr>
                <th height="23">Apertura Progr&aacute;matica </th>
                <td height="23" colspan="3"><c:out value="${tarea.aper_prog}"/></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<br>
<table align="left">
    <tr>
        <th><strong>Ingresos</strong></th>
    </tr>
</table>
<br>
<table width="700" align="left">
    <c:forEach var="i" begin="0" end="${Fcl-1}">
        <tr>
            <c:forEach var="j" begin="0" end="${Ccl-1}">
                <c:if test="${i==0}">
                    <th align="right"  width="500"> <c:out value="${M[i][j]}"/></th>
                    </c:if>
                    <c:if test="${i==1}">
                    <th align="right" width="500"> <c:out value="${M[i][j]}"/></th>
                    </c:if>
                    <c:if test="${i>1}">
                    <td align="right" width="500"> <c:out value="${M[i][j]}"/> </td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<br>
<table align="left">
    <tr>
        <th><strong>Egresos</strong></th>
    </tr>
</table>
<br>
<table width="700" align="left">
    <c:forEach var="i" begin="0" end="${EFcl-1}">
        <tr>
            <c:forEach var="j" begin="0" end="${ECcl-1}">
                <c:if test="${i==0}">
                    <th align="right" width="500"><c:out value="${EM[i][j]}"/></th>
                    </c:if>
                    <c:if test="${i==1}">
                    <th width="500" align="right"><c:out value="${EM[i][j]}"/></th>
                    </c:if>
                    <c:if test="${i>1}">
                    <td align="right" width="500"><c:out value="${EM[i][j]}"/></td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<br>
<table align="left">
    <tr>
        <th><div align="center">Saldos Reales</div></th>
</tr>
</table>
<br>
<table width="700" align="left">
    <c:forEach var="i" begin="0" end="${4}">
        <tr>
            <c:forEach var="j" begin="0" end="${coto-1}">
                <c:if test="${i==0}">
                    <th align="right" width="500"><c:out value="${MBT[i][j]}"/></th>
                    </c:if>
                    <c:if test="${i==1}">
                    <td align="right"  width="500"><c:out value="${MBT[i][j]}"/></td>
                </c:if>
                <c:if test="${i==2}">
                    <td align="right"  width="500"><c:out value="${MBT[i][j]}"/></td>
                </c:if>
                <c:if test="${i==3}">
                    <td align="right" width="500"><c:out value="${MBT[i][j]}"/> </td>
                </c:if>
                <c:if test="${i==4}">
                    <td align="right" width="500"><c:out value="${MBT[i][j]}"/></td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<br>
<table align="left">
    <tr>
        <th><div align="center">Porcentajes de ejecuci&oacute;n Real</div></th>
</tr>
</table>
<br>
<table width="700" align="left">
    <c:forEach var="i" begin="0" end="${2}">
        <tr>
            <c:forEach var="j" begin="0" end="${colcom-1}">
                <c:if test="${i==0}">
                    <th align="right" width="500"><c:out value="${COM[i][j]}"/> a</th>
                    </c:if>
                    <c:if test="${i==1}">
                    <td align="right"  width="500"><c:out value="${COM[i][j]}"/></td>
                </c:if>
                <c:if test="${i==2}">
                    <td align="right"  width="500"><c:out value="${COM[i][j]}"/></td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<br>
<table align="left">
    <tr>
        <th><div align="center">Porcentajes de ejecuci&oacute;n Real y en Proceso</div></th>
</tr>
</table>
<br>
<table width="700" align="left">
    <c:forEach var="i" begin="0" end="${2}">
        <tr>
            <c:forEach var="j" begin="0" end="${colcom-1}">
                <c:if test="${i==0}">
                    <th align="right" width="500"><c:out value="${MCM[i][j]}"/></th>
                    </c:if>
                    <c:if test="${i==1}">
                    <td align="right"  width="500"><c:out value="${MCM[i][j]}"/></td>
                </c:if>
                <c:if test="${i==2}">
                    <td align="right"  width="500"><c:out value="${MCM[i][j]}"/></td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<br>
<div align="right">
    <a href=<c:url value="/MuestraPatEgrIngImprime.do">
           <c:param name="codtar" value="${codtar}"/>
           <c:param name="descripcion" value="${descripcion}"/>
       </c:url>>Impresi&oacute;n</a>
</div>
<br><br>
<table align="left">
    <tr>
        <td>
            <c:forEach var="r" items="${dicecciones}">
                <img alt="" src="imagenes/porcentajes_pr/<c:out value="${r}"/>" width="400" height="150">
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>