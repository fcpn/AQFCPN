<%@ include file="../../Cabecera.jsp" %>

<html>
    <head>
        <title>Actividad 2</title>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    </head>
    <body>
<div id="container">
<div id="content">

       <form name="form1" method="post" action=" <c:url value="/modeliact.do"/> ">
            <table width="200" border="0" align="center">
                                                        <tr>
                                                            <th height="30" colspan="4"><div align="center"> Datos Modificados<br> Actividad </div></th>
                                                        </tr>

                                                          <tr >
                                                            <td><div align="center">
                                                            </div></td>
                                                            <td colspan="3"><div align="left"> </div></td>
                                                        </tr>
                                                        <tr>
                                                            <th>C&oacute;digo</th>
                                                            <td colspan="3"><c:out value="${act.codacti}"/></td>
                                                        </tr>
                                                        <tr>
                                                            <th>Descripci&oacute;n de Actividad </th>
                                                            <td colspan="3"><c:out value="${act.descripcion}"/></td>
                                                        </tr>
                                                        <tr>
                                                            <th>Apertura Programatica</th>
                                                            <td colspan="3"><c:out value="${act.apertura_prog}"/></td>
                                                        </tr>


                                                        <tr>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>

                                                            <td colspan="4"><div align="right">
                                                              <input type="submit" name="Submit" value="Aceptar">
                                                            </div></td>
                                                        </tr>
                                                </table>
                                              <input type=hidden name=codpro value='<c:out value="${programa.codpro}"/>'>

        </form>
</div></div>
    </body>
</html>