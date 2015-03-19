<%@ include file="../../Cabecera.jsp" %>


<html>
    <head>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>montos no presupuestados</title>
    </head>

    <body>
<div id="container">
    <div id="content">
        <form name="form1" method="post" action="<c:url value="/InsertarMNPE4.do"/>">

                <div align="center">

                    <table width="660">
                        <tr>
                          <td width="650">
                              <table width="650" align="center">
                            <tr>
                                <th colspan="7"><div align="center">Insertar Montos No Presupuestados Egresos</div></th>
                            </tr>
                                    <tr>
                                        <th>Actividad</th>
                                        <th colspan="6">Tarea</th>
                                    </tr>
                                    <tr>
                                        <td><div align="justify"><c:out value="${actividad.descripcion}"/></div></td>
                                        <td colspan="6"><div align="justify"><c:out value="${tarea.descripcion}"/></div></td>
                                    </tr>
                                    <tr>
                                        <th width="112">Partida</th>
                                        <th colspan="5">Fuente</th>

                                    </tr>
                                    <tr>
                                        <td height="34">
                                                    <select name="codigo">

                                                        <c:forEach var="g" items="${detalle}">

                                                              <option value="<c:out value="${tipo}"/>::<c:out value="${g.cod_snp}"/>"><c:out value="${g.descripcion}"/> - <c:out value="${g.cod_snp}"/></option>

                                                        </c:forEach>

                                                    </select>
                                      </td>
                                        <td colspan="5">
                                                    <select name="codfueneco">
                                                        <c:forEach var="fe" items="${fuente}">
                                                        <option value="<c:out value="${fe.codfueneco}"/>"><c:out value="${fe.codfueneco}"/> - <c:out value="${fe.descripcion}"/> </c:forEach>

                                                    </select>
                                       </td>

                                    </tr>
                                    <tr>
                                     <th>Monto Ejecutado</th>
                      		     <th colspan="5">Comprobante</th>
                                    </tr>
                                    <tr>
                     	 	        <td height="29"><input name="monto" type="text" id="moneje2" value="0" size="10"></td>
					<td colspan="5"><input name="comprobante" type="text" id="comprobante2" value="NA" size="15"></td>
				    </tr>
                                    <tr>
                                        <th colspan="6">Glosa</th>
                                    </tr>
                                    <tr>
                                      <th height="34" colspan="6"><input name="obs" type="text" id="obs" value="Saldo inicial" size="60"></th>
                                    </tr>
                                    <tr>
                                        <th width="112" rowspan="3">&nbsp;</th>
                                        <th colspan="3">Saldos a la fecha</th>
                                        <th colspan="4">&nbsp;</th>
                                    </tr>

    				    <tr>
                                        <td width="51" align="center"><div align="center">
                                          <input name="dia" type="text" id="dia2" size="2" maxlength="2">
                                        </div></td>
                                        <td width="51" align="center"><div align="center">
                                          <input name="mes" type="text" id="mes2" size="2" maxlength="2">
                                        </div></td>
                                        <td width="45">
                                          <div align="center">
                                            <input name="ani" type="text" id="ani2" size="2" maxlength="2">
                                        </div></td>
                                        <td colspan="4">&nbsp;</td>
                                    </tr>
                                    <tr>
					<th><div align="left">Dia</div></th>
                                        <th><div align="left">mes</div></th>
                                        <th>a&ntilde;o</th>
                                        <th width="185">
                                        <input name="sal" type="radio" value="a" checked> Saldo incial</th>
                                        <th width="174"><!-- <input name="sal" type="radio" value="b">
                                        Cuenta Nueva --></th>
                                    </tr>

                                    <tr>
                                        <td colspan="5">&nbsp;</td>
                                        <td><div align="right">
                                          <input type="submit" name="Submit2" value="Aceptar">
                                        </div></td>
                                    </tr>
                                    <tr>
                                        <td colspan="5">&nbsp;</td>
                                        <td><div align="right">
                                          <input type="reset" name="Submit3" value="cancelar">
                                        </div></td>
                                    </tr>
                            </table></td>
                        </tr>
                  </table>

                </div>
          <input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
          <input type=hidden name=codtar value='<c:out value="${codtar}"/>'>
          <input type=hidden name=cod_gnp value='<c:out value="${cod_gnp}"/>'>
        </form>


        </div></div>
    </body>
</html>