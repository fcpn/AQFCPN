<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <style type="text/css">
<!--
.Estilo1 {font-size: 11px}
.Estilo5 {font-size: 14px; font-weight: bold; color: #FFFFFF; }
.Estilo6 {color: #FFFFFF}
.Estilo7 {font-size: 11px; color: #000066;
	font-weight: bold;
}
-->
        </style>
    </head>
    <body>

        <br>
 <table width="563" height="92" border="1" align="center">
  <tr bgcolor="#000000">
    <td colspan="4" align="center"><br><span class="Estilo5">MEN&Uacute; DE TAREAS <br>
    Modificar Egresos
    </span>
    </td>

  </tr>
<%int i=0;%>
        <c:forEach var="g" items="${pat}">
             <c:if test="${g.tipo == '2'}">
                <tr bgcolor="#FF1515">
                <td colspan="4"><div align="center"><span class="Estilo1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></div> </td>
             </tr>
			   <tr bgcolor="#0060BF">
                 <td colspan="4"><div align="left" class="Estilo1 Estilo6"><strong>Actividad</strong></div></td>
             </tr>
               <tr>
                <td colspan="4"><div align="center"><span class="Estilo1"><strong><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></strong></span></div> </td>
             </tr>
             </c:if>

              <c:if test="${g.tipo == '3'}">
			  <%i++;%>
            <tr onMouseOver="this.style.backgroundColor='#66FFCC';" onMouseOut="this.style.backgroundColor='#ffffff';" >
    <td width="22"><div align="center" class="Estilo7"><%= i%></div></td>
    <td width="29"><span class="Estilo7">Tarea</span></td>
    <td width="86"><div align="center"><span class="Estilo1"><a  href="<c:url value="/ModClasificador1e.do">
                       <c:param name="codtar" value="${g.codigo}"/>
                       <c:param name="descripcion" value="${g.descripcion}"/>

                   </c:url>">
                <c:out value="${g.codigo}"/> </a></span></div></td>
    <td width="398"><span class="Estilo1"><a  href="<c:url value="/ModClasificador1e.do">
                       <c:param name="codtar" value="${g.codigo}"/>
                       <c:param name="descripcion" value="${g.descripcion}"/>

                   </c:url>">
                <c:out value="${g.descripcion}"/> </a></span></td>
  </tr>


              </c:if>

        </c:forEach>
    </table>

    </body>
</html>
