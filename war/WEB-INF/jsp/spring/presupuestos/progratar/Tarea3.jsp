

<%@ include file="../../Cabecera.jsp" %>

<html>
    <head>
        <title>Tarea</title>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    </head>
    <body>
<div id="container">
<div id="content">

     <form name="form1" method="post" action="<c:url value="InsertarTarea.do"/>">
<table width="324" border="0" align="center">
    <tr>
            <th colspan="4"><div align="center"><c:out value="${programa.descripcion}"/></div></th>
            </tr>
    <tr>
            <th height="30" colspan="4"><div align="center"> Nueva Tarea </div></th>
          </tr>
          <tr>
          <th width="82">C&oacute;digo </th>
            <td width="193" colspan="3"><input name="codigo" type="text" id="codigo" value="<c:out value="${tar.codtar}"/>"></td>
          </tr>
		  <tr>
          <th width="82">Apertura Program&aacute;tica </th>
            <td width="193" colspan="3"><input name="aper_prog" type="text" id="aper_prog" value="<c:out value="${tar.aper_prog}"/>"></td>
          </tr>
          <tr>
            <th>Descripci&oacute;n de Tarea </th>
            <td colspan="3" ><textarea name="descripcion" cols="25" id="descripcion"><c:out value="${tar.descripcion}"/></textarea> </td>
          </tr>



		   <tr>
		    <th>Numero de Tarea </th>
            <td colspan="3"><input name="num_tarea" type="text" value="<c:out value="${tar.num_tarea}"/>"></td>
          </tr>

          
          <tr>
            <td colspan="4"><div align="right">
              <input type="submit" name="Submit" value="Guardar Modificacion">
            </div></td>
          </tr>
        </table>
<input type="hidden" name="codtar" value="<c:out value="${codtar}"/>" >
    <input type="hidden" name="codacti" value="<c:out value="${codacti}"/>" >

	 <input type=hidden name=codacti value='<c:out value="${programa.codacti}"/>'>
</form>
</div></div>
    </body>
</html>