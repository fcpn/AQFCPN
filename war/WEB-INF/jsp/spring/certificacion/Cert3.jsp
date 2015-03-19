

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<table width="617" height="52" border="1" align="center">
      <tr>
        <td width="42" align="center"><span class="Estilo4">Nro</span></td>
        <td width="110" align="center"><span class="Estilo4">Requirimiento</span></td>
        <td width="41"align="center"><span class="Estilo4">Cantidad</span></td>
        <td width="41" align="center"><span class="Estilo4">Monto</span></td>
        <td width="52" align="center"><span class="Estilo4">Tarea</span></td>
        <td width="59" align="center"><span class="Estilo4">Partida</span></td>
        <td width="59" align="center"><span class="Estilo4"><div align="right">FF-OF</div></span></td>
        <td width="85" colspan="2" align="center"><span class="Estilo4">Responsable de tarea</span></td>
        <!-- <td width="46"><span class="Estilo4">Disminuye</span></td> -->
        <td width="41" class="Estilo4">borrar</td>
      </tr>
<% int i;


//a.substring(0,4);
//son los numeros de pedidos
i=1; %>
      <c:forEach var="g" items="${lis_certi_proceso}">

	  <tr>
        <td class="Estilo5"><div align="center"> <%= i%> </div></td>
        <td valign="top"><div align="right"><c:out value="${g.glosa}"/></div></td>
        <td valign="top"><div align="center" ><c:out value="${g.cantidad}"/></div></td>
        <td valign="top"><div align="right"><c:out value="${g.monto}"/> </div></td>
        <td valign="top"><div align="center"><c:out value="${g.codtar}"/> </div></td>
        <td valign="top"><div align="center"><c:out value="${g.codmonegr}"/></div></td>
        <td valign="top"><div align="center"><c:out value="${g.codfueneco}"/></div></td>
        <td valign="top" colspan="2" align="center"><c:out value="${g.responsable}"/></td>
        <!-- <td valign="top">00</td> -->
        <td style="cursor:pointer" onclick="borra('<c:out value="${g.codtar}"/>', '<c:out value="${g.codfueneco}"/>', '<c:out value="${g.id}"/>', '<c:out value="${g.codmonegr}"/>');"><span class="Estilo5">borrar</span></td>
      </tr>

      <% i++;%>
	  </c:forEach>


    </table>


 <!--

'<c:out value="${g.correlativo}"/>', '<c:out value="${g.no_rut}"/>'
<a  href="('<c:url value="">
    <c:param name="codtar" value="${g.codfueneco}"/>
    <c:param name="descripcion" value="${g.descripciones}"/>

                   </c:url>')">    </a>

-->



 