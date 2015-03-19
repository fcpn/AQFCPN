
<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
      <style type="text/css">

.tablilla {border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px double #000000;}
</style>

<script>
function validar(e) {
    tecla = (document.all)?e.keyCode:e.which;
    if (tecla==8) return true;
    patron = /\d/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}
</script>
    </head>
    <body>
        <c:out value="${actividad.descripcion}"/> - <c:out value="${actividad.codacti}"/><br>

        <c:out value="${tarea.descripcion}"/> - <c:out value="${tarea.codtar}"/>

    <table width="256" border="1" align="center">
          <tr bgcolor="#E88B24">
            <td bgcolor="#F4CA9B"><div align="center"><strong>Certificaci&oacute;n Presupuestaria </strong></div></td>
          </tr>
          <tr>
            <td> <div align="center">              <table width="200" border="0">
                <tr>
                  <td><div align="center">
                    <input name="dia" type="text" id="dia3" onKeyPress="return validar(event)" size="2" maxlength="2">
                  </div></td>
                  <td><div align="center">
                    <input name="mes" type="text" id="mes2" onKeyPress="return validar(event)" size="2" maxlength="2">
                  </div></td>
                  <td><div align="center">
                    <input name="anio" type="text" id="dia4" onkeypress="return validar(event)" value="09" size="2" maxlength="2">
                  </div></td>
                </tr>
                <tr>
                  <td><div align="center"><strong>dia</strong></div></td>
                  <td><div align="center"><strong>mes</strong></div></td>
                  <td><div align="center"><strong>a&ntilde;o</strong></div></td>
                </tr>
              </table>
            </div></td>
          </tr>
          <tr bgcolor="#E88B24">
            <td bgcolor="#F4CA9B">
			<table width="93" border="0" align="center" class="tablilla">
              <tr>
                <td bgcolor="#DA7E18"><div align="center"><strong>Buscar</strong></div></td>
              </tr>
            </table></td>
          </tr>
        </table>

    </body>
</html>