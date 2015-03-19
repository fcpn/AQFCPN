

<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
            <script type="text/javascript">
        function confirma(miurl,aa){

        question = confirm("Para Eliminar El Programa No debe tener ninguna actividad, Desea Eliminar el programa: "+ aa +"?")
        if (question !="0"){
        document.location.href = miurl;
        }
        }

</script>

		<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>

    </head>
    <body>
<div id="container">
<div id="content">
        <br>
 <table width="563" height="92" >
  <tr>
      <th colspan="6">   <div align="center"> Programa </div>   </th>
  </tr>
    <tr>
      <th>   <div align="center"> </div>   </th>
      <th>&nbsp;</th>
      <th><div align="center"> Codigo Programa</div></th>
      <th><div align="center"> Programa </div></th>
      <th>&nbsp;</th>
      <th>&nbsp;</th>
    </tr>
<%int i=0;%>
        <c:forEach var="g" items="${pat}">



			  <%i++;%>
            <tr onMouseOver="this.style.backgroundColor='#66FFCC';" onMouseOut="this.style.backgroundColor='#ffffff';" >
    <td width="18"><%= i%></td>
    <td width="35">Programa</td>
    <td width="51"> <c:out value="${g.codpro}"/> </td>
    <td width="294">  <c:out value="${g.descripcion}"/></td>

				<td width="63"><span class="Estilo1"><a  href="<c:url value="/ModEliProg2.do">
                       <c:param name="codpro" value="${g.codpro}"/>

                   </c:url>"> Modificar </a></span></td>
          <td width="74"><span class="Estilo1">
                         <a  target="mainFrame"  onClick="confirma('<c:url value="/ModEliProg3.do">
                       <c:param name="codpro" value="${g.codpro}"/>

                   </c:url>','<c:out value="${g.codpro}"/>'); return false;"><font color="#FF0000" >Eliminar</font> </a></span></td>

  </tr>




        </c:forEach>
    </table>
</div></div>
    </body>
</html>
