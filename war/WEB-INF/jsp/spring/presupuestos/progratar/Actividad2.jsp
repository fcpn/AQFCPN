<%@ include file="../../Cabecera.jsp" %>

<html>
    <head>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>Actividad 2</title>

    </head>
    <body>
        <div id="container">
<div id="content">
       <form name="form1" method="post" action=" <c:url value="/InsertaActividad.do"/> ">

          <table width="200">
                 <tr>
                     <th colspan="4"><div align="center">programa <c:out value="${programa.descripcion}"/></div></th>
                  </tr>

                                                        <tr>
                                                          <th height="30" colspan="4"><div align="center">Nueva Actividad</div></th>
                                                        </tr>
                                                        <tr>
                                                            <th>C&oacute;digo</th>
                                                            <td colspan="3"><input name="codacti" type="text" id="codacti"></td>
                                                        </tr>
                                                         <tr>
                                                            <th>Descripci&oacute;n de Actividad</th>
                                                           <td colspan="3"><input name="descripcion" type="text" id="descripcion"></td>
                                                        </tr>
                                                        <tr>
                                                            <th>Apertura Programatica</th>
                                                            <td colspan="3"><input name="apertura_prog" type="text" id="apertura_prog"></td>
                                                        </tr>

                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td><input type="submit" name="Submit" value="Guardar"></td>
                                                            <td>&nbsp;</td>
                                                            <td><input type="reset" name="Submit2" value="Cancelar"></td>
                                                        </tr>
                                                </table>
 <input type=hidden name=codpro value='<c:out value="${programa.codpro}"/>'>

    </form>
 </div></div>
    </body>
</html>