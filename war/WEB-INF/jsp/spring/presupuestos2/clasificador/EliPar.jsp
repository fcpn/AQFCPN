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
 <form name="form1" method="post" action="<c:url value="/mostarpartida.do"/>">

<table width="221" border="0" align="center">
  <tr>
    <th colspan="2"> <div align="center">Modificar <c:out value="${des}"/> </div></th>
  </tr>
  <tr>
    <th width="183">Codigo</th>
    <td width="28">
      <c:out value="${cod}"/>    </td>
  </tr>
  <tr>
    <th>Descripcion</th>
    <td><c:out value="${r.descripcion}"/></td>
  </tr>
  <tr>
    <td colspan="2"><div align="justify">
      <font color="#FF0000">Si la Informaci�n De este Recuadro Esta vac�a los datos se eliminaron satisfactoriamente</font>
    </div></td>
    </tr>
  <tr>
    <td colspan="2"><input type="submit" name="Submit" value="Menu Partidas"></td>
  </tr>
</table>
<input name="codmoning" type="hidden" value="<c:out value="${codmoning}"/>">
<input name="tipo" type="hidden" value="<c:out value="${tipo}"/>">

       </form>

      </div></div>
    </body>
</html>
