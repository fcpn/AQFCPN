

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

     <form name="form1" method="post" action="<c:url value="ModEliTar2_1.do"/>">
<table width="324" border="0" align="center">
          <tr>
            <th height="30" colspan="4"><div align="center"> Modificar Tarea </div></th>
          </tr>
          <tr>
          <th width="82">C&oacute;digo </th>
            <td width="193" colspan="3"><input name="codtar2" type="text" id="codtar2" value="<c:out value="${tar.codtar}"/>"></td>
          </tr>
		  <tr>
          <th width="82">Apertura Program&aacute;tica </th>
            <td width="193" colspan="3"><input name="aper_prog2" type="text" id="aper_prog2" value="<c:out value="${tar.aper_prog}"/>"></td>
          </tr>
          <tr>
            <th>Descripci&oacute;n de Tarea </th>
            <td colspan="3" ><textarea name="descripcion2" cols="25" id="descripcion2"><c:out value="${tar.descripcion}"/></textarea> </td>
          </tr>

		   <tr>
		    <th>Correlativo para certificacion presupuestaria </th>
            <td colspan="3"><input name="correlativo2" type="text" value="<c:out value="${tar.correlativo}"/>"></td>
          </tr>

		   <tr>
		    <th>Numero de Tarea </th>
            <td colspan="3"><input name="num_tarea2" type="text" value="<c:out value="${tar.num_tarea}"/>"></td>
          </tr>

          <tr>
            <td colspan="4">Para modificar el C&oacute;digo es necesario que la tarea no tenga presupuesto asignado</td>
          </tr>
          <tr>
            <td colspan="4"><div align="right">
              <input type="submit" name="Submit" value="Guardar Modificacion">
            </div></td>
          </tr>
        </table>
<input type="hidden" name="codtar" value="<c:out value="${codtar}"/>" >
    <input type="hidden" name="codacti" value="<c:out value="${tar.codacti}"/>" >
</form>
</div></div>
    </body>
</html>