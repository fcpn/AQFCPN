<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>

<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>

    </head>
    <body>

        <div id="container">
<div id="content">
        <table width="563" height="92" align="center">
  <tr>
    <th colspan="4"><div align="center"><br>MEN&Uacute; DE TAREAS <br> para la Fuente Econ&oacute;mica <br> <c:out value="${codfueneco}"/> - <c:out value="${descripcion}"/> <br></div></th>
  </tr>
<%int i=0;%>
        <c:forEach var="g" items="${pat}">
             <c:if test="${g.tipo == '2'}">
                <tr>
                <td colspan="4"><div align="center"><span class="Estilo1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></div> </td>
             </tr>
			  <tr>
                <th colspan="4"><div align="center"><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></div> </th>
             </tr>
             </c:if>

              <c:if test="${g.tipo == '3'}">
			  <%i++;%>
            <tr>
    <td width="22"><div align="center"><%= i%></div></td>
    <td width="29">Tarea</td>
    <td width="86"><div align="center"><a href="javascript:popUp('<c:url value="/GralFuen3.do">
                       <c:param name="codtar" value="${g.codigo}"/>
                       <c:param name="destar" value="${g.descripcion}"/>

                       <c:param name="codfueneco" value="${codfueneco}"/>
                       <c:param name="desfe" value="${descripcion}"/>

                   </c:url>')"> <c:out value="${g.codigo}"/> </a></div></td>
    <td width="398"><a href="javascript:popUp('<c:url value="/GralFuen3.do">
                       <c:param name="codtar" value="${g.codigo}"/>
                       <c:param name="destar" value="${g.descripcion}"/>

                       <c:param name="codfueneco" value="${codfueneco}"/>
                       <c:param name="desfe" value="${descripcion}"/>

                   </c:url>')"> <c:out value="${g.descripcion}"/> </a></td>
  </tr>


              </c:if>

        </c:forEach>
    </table>
</div></div>
    </body>
</html>
