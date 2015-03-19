<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
	<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>

	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
    </head>
    <body>
	<div id="container">
<div id="content">
 <form name="form1" method="post" action="<c:url value="/mostrarrubros.do"/>">

<table width="200" border="0" align="center">
  <tr>
    <th colspan="2"> <div align="center">Modificar <c:out value="${des}"/> </div></th>
  </tr>
  <tr>
    <th>Codigo</th>
    <td>
      <c:out value="${cod}"/>    </td>
  </tr>
  <tr>
    <th>Descripcion</th>
    <td><c:out value="${r.descripcion}"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="right">
      <input type="submit" name="Submit" value="Menu Rubro">
    </div></td>
    </tr>
</table>
<input name="codmoning" type="hidden" value="<c:out value="${codmoning}"/>">
<input name="tipo" type="hidden" value="<c:out value="${tipo}"/>">

       </form>

      </div></div>
    </body>
</html>
