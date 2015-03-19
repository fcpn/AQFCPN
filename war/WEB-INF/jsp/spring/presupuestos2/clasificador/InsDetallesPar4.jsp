
<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
    </head>
    <body>

        <h3 align="center">Modificar Clasificador Presupuestario Egresos (Partida)</h3>

        <form name="form1" method="post" action="<c:url value="/InsDetallesPar5.do"/>">
        <table width="673" height="336" border="0" align="center">
          <tr>
            <td><table width="654" height="315" border="0" align="center">
              <tr>
                <td width="239">Modificar:</td>
                <td width="405"><c:out value="${partida.codigo}"/> - <c:out value="${partida.descripcion}"/></td>
              </tr>
              <tr bgcolor="#003366">
                <td colspan="2"><div align="center">
                  <textarea name="desdes" cols="100" rows="15" id="desdes" ><c:out value="${partidadetalle.descripciones}"/> </textarea>
                </div></td>
              </tr>
            </table>


              <div align="right"><br>
                <br>
                <input type="submit" name="Submit" value="Guardar Modificaciones" align="rigth">
              </div></td>

          </tr>
        </table>

        <input type=hidden name=ref123 value='<c:out value="${partida.tipo}"/>'>
        <input type=hidden name=codpar value='<c:out value="${partida.codigo}"/>'>

        </form>
        <p align="center">&nbsp;</p>
    </body>
</html>