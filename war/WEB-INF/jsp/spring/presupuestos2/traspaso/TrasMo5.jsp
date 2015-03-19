<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
    <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>Mostrando los montos presupuestados</title>
        
    </head>
    <body>
 <div id="container">
<div id="content">
        <table width="668" align="center">
          <tr>
            <td>
       
              <div align="center">
              <table width="523" align="center">
                  <tr>
                    <th colspan="2" ><div align="center">Traspasos de Montos Presupuestados </div></th>
                </tr>
                  <tr>
                      <th width="238" >Actividad  <c:out value="${actividad.descripcion}"/> </th>
                      <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
                  </tr>
              </table>
              <br>
              
              <table width="523" align="center">
                <tr>
                  <th width="507"><div align="center">Antes de los Traspasos </div></th>
                </tr>
              </table>
              <table width="523" align="center">
                <tr>
                  <th colspan="4" ><div align="center">Partida de traspaso (monto salida)</div></th>
                </tr>
                <tr>
                  <th width="238" >Clasificador</th>
                  <th width="269" >Fuente Econ&oacute;mica </th>
                  <th width="269" >Monto Presupuestado </th>
                  <th width="269" >Monto Sacado</th>
                </tr>
                <tr>
                  <td ><c:out value="${codmoning}"/> - <c:out value="${des_ref1}"/></td>
                  <td ><c:out value="${codfueneco}"/> - <c:out value="${des.descripcion}"/></td>
                  <td ><div align="right"><c:out value="${monto}"/></div></td>
                  <td ><div align="right"><c:out value="${monres}"/></div></td>
                </tr>
                <tr>
                  <th colspan="4" ><div align="left">Partida que recibi&oacute; monto de traspaso</div></th>
                </tr>
                <tr>
                  <th>Clasificador</th>
                  <th>Fuente Econ&oacute;mica</th>
                  <th>Monto Presupuestado</th>
                  <th rowspan="2" >&nbsp;</th>
                </tr>
                <tr >
                  <td><c:out value="${codmoning2}"/> - <c:out value="${des_ref2}"/></td>
                  <td><c:out value="${codfueneco}"/> - <c:out value="${des.descripcion}"/></td>
                  <td><div align="right"><c:out value="${monto2}"/></div></td>
                </tr>
              </table>
              <br>
              
              <table width="523" align="center">
                <tr>
                  <th width="507" ><div align="center">Resultado de los Traspasos </div></th>
                </tr>
              </table>
              <table width="523" align="center">
                <tr>
                  <th colspan="4" ><div align="center">
                      <div align="left">Partida de traspaso </div>
                  </div></th>
                </tr>
                <tr>
                  <th> Fuente Econ&oacute;mica </th>
                  <td colspan="3"><div align="center"><c:out value="${vu[2]}"/> - <c:out value="${vu[3]}"/></div></td>
                </tr>
                <tr>
                  <th width="118" >Clasificador</th>
                  <th width="143" >Monto Presupuestado </th>
                  <th width="123" >Monto Ejecutado </th>
                  <th width="111" > Saldo</th>
                </tr>
                <tr >
                  <td ><c:out value="${vu[0]}"/> - <c:out value="${vu[1]}"/></td>
                  <td ><div align="right"><c:out value="${vu[4]}"/></div></td>
                  <td ><div align="right"><c:out value="${vu[5]}"/></div></td>
                  <td ><div align="right"><c:out value="${vu[6]}"/></div></td>
                </tr>
                <tr>
                  <th colspan="4" ><div align="left">Partida que recibi&oacute; monto de traspaso </div></th>
                </tr>
                <tr>
                  <th >Clasificador</th>
                  <th > Monto Presupuestado</th>
                  <th >Monto Ejecutado</th>
                  <th >Saldo</th>
                </tr>
                <tr >
                  <td > <c:out value="${vd[0]}"/> - <c:out value="${vd[1]}"/></td>
                  <td ><div align="right"><c:out value="${vd[2]}"/></div></td>
                  <td ><div align="right"><c:out value="${vd[3]}"/></div></td>
                  <td ><div align="right"><c:out value="${vd[4]}"/></div></td>
                </tr>
              </table>
              
              <br>
              <table width="516">
                <tr>
                  <td width="268">
                           <a href=<c:url value="/TrasMo2.do">
                                      
                                       <c:param name="codfueneco" value="${codfueneco}"/>
                                       <c:param name="codtar" value="${codtar}"/>
                                       <c:param name="codacti" value="${codacti}"/>
                                   </c:url>>Nuevo Traspaso </a>
                  </td>
                  <td width="238">
                      <a href=<c:url value="/trasmon.do">            
                       </c:url>> Salir</a>
                  </td>
                </tr>
              </table>
              <br>
</div>              </td>
          </tr>
    </table>
       </div></div>
    </body>
</html>