<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<div id="content" align="center">
    <c:if test="${!empty lis_certi_proceso}">
        <table>
            <tr>
                <th><span align="center">Nro</span></th>
                <th><span align="center">Requerimiento especificado</span></th>
                <th><span align="center">Cantidad</span></th>
                <th><span align="center">Monto</span></th>
                <th><span align="center">Tarea</span></th>
                <th><span align="center">Partida</span></th>
                <th><div align="center">FF-OF</div></th>
                <th><span align="center">Responsable de tarea</span></th>
                <!-- <td width="46"><span class="Estilo4">Disminuye</span></td> -->
                <th><span align="center">borrar</span></th>
            </tr>
            <% int i; int sum=0;
                //a.substring(0,4);
                //son los numeros de pedidos
            i=1; %>
        <c:forEach var="g" items="${lis_certi_proceso}">
            <tr>
                <td><div align="center"> <%= i%> </div></td>
                <td valign="top"><div align="right"><c:out value="${g.glosa}"/></div></td>
                <td valign="top"><div align="center" ><c:out value="${g.cantidad}"/></div></td>
                <td valign="top"><div align="right"><fmt:formatNumber value="${g.monto}" pattern="#,###,###,##0.00"/> </div></td>
                <td valign="top"><div align="center"><c:out value="${g.codtar}"/> </div></td>
                <td valign="top"><div align="center"><c:out value="${g.codmonegr}"/></div></td>
                <td valign="top"><div align="center"><c:out value="${g.codfueneco}"/></div></td>
                <td valign="top" align="center"><c:out value="${g.responsable}"/></td>
                <!-- <td valign="top">00</td> -->
                <th style="cursor:pointer" onclick="borra('<c:out value="${g.codtar}"/>', '<c:out value="${g.codfueneco}"/>', '<c:out value="${g.id}"/>', '<c:out value="${g.codmonegr}"/>');">borrar</th>
            </tr>
            <% i++;%>
	</c:forEach>
            <tr onMouseOver="this.style.backgroundColor='#c0c0c0';" onMouseOut="this.style.backgroundColor='#ffffff';">
                <th colspan="4" > <div align="right">Monto Total a Gastar</div></th>
                <td valign="top"><div align="right"> <fmt:formatNumber value="${total}" pattern="#,###,###,##0.00"/> </div></td>
                <td colspan="3">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="8" > . </td>
            </tr>
            <tr onMouseOver="this.style.backgroundColor='#c0c0c0';" onMouseOut="this.style.backgroundColor='#ffffff';">
                <td colspan="8" > . </td>
                <td><a  href="<c:url value="/cert5.do"> <c:param name="codtar" value="${codtar}"/> </c:url>">Aceptar</a></td>
            </tr>
        </table>
    </c:if>
<!--
'<c:out value="${g.correlativo}"/>', '<c:out value="${g.no_rut}"/>'
<a  href="('<c:url value="">
    <c:param name="codtar" value="${g.codfueneco}"/>
    <c:param name="descripcion" value="${g.descripciones}"/>

                   </c:url>')">    </a>

-->



 