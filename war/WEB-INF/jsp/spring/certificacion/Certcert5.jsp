
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>



<style type="text/css">
<!--
.Estilo1 {color: #FFFFFF}
.Estilo2 {font-size: 14px}
.Estilo3 {
	color: #FFFFFF;
	font-size: 14px;
	font-weight: bold;
}
-->
</style>


<c:if test="${!empty lis_certi_proceso}">
<table width="617" height="52" border="1" align="center">
      <tr>
        <td width="42" align="center" bgcolor="#1B3572"><span class="Estilo1 Estilo4 Estilo2"><strong>Nro</strong></span></td>
        <td width="110" align="center" bgcolor="#1B3572"><span class="Estilo1 Estilo4 Estilo2"><strong>Requerimiento especificado</strong></span></td>
        <td width="41"align="center" bgcolor="#1B3572"><span class="Estilo1 Estilo4 Estilo2"><strong>Cantidad</strong></span></td>
        <td width="41" align="center" bgcolor="#1B3572"><span class="Estilo1 Estilo4 Estilo2"><strong>Monto</strong></span></td>
        <td width="52" align="center" bgcolor="#1B3572"><span class="Estilo1 Estilo4 Estilo2"><strong>Tarea</strong></span></td>
        <td width="59" align="center" bgcolor="#1B3572"><span class="Estilo1 Estilo4 Estilo2"><strong>Partida</strong></span></td>
        <td width="59" align="center" bgcolor="#1B3572"><div align="center" class="Estilo3"><span class="Estilo4">FF-OF</span></div></td>
        <td width="85" align="center" bgcolor="#1B3572"><span class="Estilo1 Estilo4 Estilo2"><strong>Responsable de tarea</strong></span></td>
        <!-- <td width="46"><span class="Estilo4">Disminuye</span></td> -->
        <td width="41" bgcolor="#1B3572" class="Estilo1 Estilo4"><span class="Estilo2"><strong>borrar</strong></span></td>
      </tr>
<% int i; int sum=0;


//a.substring(0,4);
//son los numeros de pedidos
i=1; %>
      <c:forEach var="g" items="${lis_certi_proceso}">

	  <tr onMouseOver="this.style.backgroundColor='#c0c0c0';" onMouseOut="this.style.backgroundColor='#ffffff';">
        <td class="Estilo5"><div align="center"> <%= i%> </div></td>
        <td valign="top"><div align="right"><c:out value="${g.glosa}"/></div></td>
        <td valign="top"><div align="center" ><c:out value="${g.cantidad}"/></div></td>
        <td valign="top"><div align="right"><fmt:formatNumber value="${g.monto}" pattern="#,###,###,##0.00"/> </div></td>
        <td valign="top"><div align="center"><c:out value="${g.codtar}"/> </div></td>
        <td valign="top"><div align="center"><c:out value="${g.codmonegr}"/></div></td>
        <td valign="top"><div align="center"><c:out value="${g.codfueneco}"/></div></td>
        <td valign="top" align="center"><c:out value="${g.responsable}"/></td>
        <!-- <td valign="top">00</td> -->
        <td bgcolor="#C53218" style="cursor:pointer" onclick="borra('<c:out value="${g.codtar}"/>', '<c:out value="${g.codfueneco}"/>', '<c:out value="${g.id}"/>', '<c:out value="${g.codmonegr}"/>');"><span class="Estilo5"><strong>borrar</strong></span>
        </td>

      </tr>

      <% i++;%>
	  </c:forEach>



 <tr onMouseOver="this.style.backgroundColor='#c0c0c0';" onMouseOut="this.style.backgroundColor='#ffffff';">
 <td colspan="4" > <div align="right"> <strong>Monto Total a Gastar </strong></div></td>
 <td valign="top" bgcolor="#FE4545"><div align="right"> <fmt:formatNumber value="${total}" pattern="#,###,###,##0.00"/> </div></td>
 <td colspan="3">&nbsp;</td>
  </tr>



<tr >
 <td colspan="8" > . </td>
 </tr>

  <tr onMouseOver="this.style.backgroundColor='#c0c0c0';" onMouseOut="this.style.backgroundColor='#ffffff';">

      <td colspan="8" > . </td>
  <td>

<a  href="<c:url value="/cert5.do"> <c:param name="codtar" value="${codtar}"/> </c:url>"> Aceptar</a>

</td>

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



 