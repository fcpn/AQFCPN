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
        <h3>Lista Montos no Presupuestados Ejecutados Egresos</h3>

        <table width="542" align="center">
            <tr>
                <th>Clasificador</th>
                <th>Fuente Economica</th>
                <th>Ejecutado</th>
            </tr>
            <c:forEach var="mo" items="${mosmoneje}">
                <c:if test="${mo.codtar==tarea.codtar }">
                    <tr>
                        <td><c:out value="${mo.codmonnopreegr}"/> - <c:out value="${mo.descla}"/></td>
                        <td><c:out value="${mo.codfueneco}"/></td>
                        <td><c:out value="${mo.monejenopre}"/></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>


        <form name="form1" method="post" action="<c:url value="/ActualizaNoPe.do"/>">
              <div class="topdentro">
                <div align="center">
                     <br>
                    <table width="596">
                        <tr>
                            <td width="586">
                                <table width="586">
                                    <tr>
                                        <th colspan="3"><div align="center">Actualiza Montos No Presupuestados Egresos</div></th>
                                    </tr>
                                    <tr>
                                        <th colspan="3">Actividad <c:out value="${actividad.descripcion}"/> Tarea <c:out value="${tarea.descripcion}"/></th>
                                    </tr>

                                    <tr>
                                        <th>Cuenta</th>
                                        <th>Fuente</th>

                                    </tr>
                                    <tr>
                                        <td>
                                                    <select name="codigo">
                                                        <c:forEach var="g" items="${detalle}">
                                                                <option value="<c:out value="${tipo}"/>::<c:out value="${g.cod_snp}"/>"><c:out value="${g.descripcion}"/> - <c:out value="${g.cod_snp}"/></option>
                                                        </c:forEach>
                                                    </select>                                        </td>
                                        <td>
                                         <select name="codfueneco">
                                           <c:forEach var="fe" items="${fuente}">
                                                        <option value="<c:out value="${fe.codfueneco}"/>"><c:out value="${fe.codfueneco}"/> - <c:out value="${fe.descripcion}"/> </c:forEach>
                                          </select>                                        </td>

                                    </tr>
                                    <tr>
                                        <th>monto </th>
                                        <th>Numero de Comprobante</th>

                                    </tr>
                                    <tr>
                                        <td><input name="monto" type="text" size="8"></td>
                                        <td><input name="comprobante" type="text" id="comprobante" size="40"></td>
                                    </tr>

                                    <tr>
                                        <th>Observaciones</th>
                                        <th>Fecha</th>

                                    </tr>
                                    <tr>
                                        <td><input name="obs" type="text" id="obs"></td>
                                        <td><input name="fecha" type="text" id="fecha" size="20"></td>

                                    </tr>

                                    <tr>
                                        <td>&nbsp;</td>
                                        <td><input type="submit" name="Submit2" value="Aceptar"></td>

                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td><input type="reset" name="Submit3" value="cancelar"></td>

                                    </tr>
                            </table></td>
                        </tr>
                    </table>

                </div>
            </div>
           <input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
           <input type=hidden name=codtar value='<c:out value="${codtar}"/>'>
           <input type=hidden name=cod_gnp value='<c:out value="${cod_gnp}"/>'>
        </form>

        </div></div>
    </body>
</html>
