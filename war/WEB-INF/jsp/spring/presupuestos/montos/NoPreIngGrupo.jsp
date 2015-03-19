<%@ include file="../../Cabecera.jsp" %>


<html>
<head>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<title>Grupo Rubro</title>

</head>
<body>


<div id="container">
<div id="content">
<form name="form1" method="post" action=" <c:url value="/InsertarNoPreIngGru.do"/>" >




    <table width="637" height="287">
      <tr>
        <td width="623" ><table width="373" border="0" align="center">
          <tr>
            <th colspan="4"><div align="center"> Nuevo Grupo  Cuenta No Presupuestaria </div></th>
          </tr>
          <tr>
            <td colspan="4"><div align="center">
                </div>


			  <div align="center">
                <blockquote>
                  <p class="Estilo1"></p>
                </blockquote>
              </div></td>
          </tr>
          <tr>
            <th width="103"><div align="center">C&oacute;digo</div></th>
            <td colspan="3">
              <input name="codigo" type="text" id="codigo" size="20">  </td>
          </tr>
          <tr>
            <th><div align="center">Descripci&oacute;n de la Cuenta</div></th>
            <td colspan="3"><div align="left"><input name="descripcion" type="text" id="descripcion" size="40">
            </div></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td width="108"><input type="submit" name="Submit" value="Guardar"></td>
            <td width="43">&nbsp;</td>
            <td width="101"><input type="reset" name="Submit2" value="Cancelar"></td>
          </tr>
        </table>





</form>

</div></div>
</body>
</html>