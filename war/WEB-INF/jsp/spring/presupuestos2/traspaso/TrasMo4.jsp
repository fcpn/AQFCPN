<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>traspasos</title>

    </head>
    <body>
        <div id="container">
<div id="content">
        <form name="form1" method="post" action="<c:url value="/TrasMo5.do"/>">
            <table width="523" align="center">
                <tr>
                    <th colspan="2" ><div align="center">Traspaso de Montos</div></th>
                </tr>
                <tr >
                    <th width="238" >Actividad <c:out value="${actividad.descripcion}"/> </th>
                    <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
                </tr>
            </table>

            <table width="535" align="center">
<tr>
                    <th colspan="4" ><div align="center">Partida a traspasar monto </div></th>
                </tr>
                <tr>
                    <th width="112" >Clasificador</th>
                  <th width="123" >Fuente Economica </th>
                    <th width="103" >Monto presupuestado </th>
                    <th colspan="3" >Monto a restar </th>
                </tr>
                <tr >
                    <td height="29" ><c:out value="${codmoning}"/> - <c:out value="${descla}"/></td>
                    <td><c:out value="${codfueneco}"/> - <c:out value="${des.descripcion}"/></td>
                    <td><div align="right"> <c:out value="${monto}"/></div></td>
                    <td colspan="3"><div align="right">
                            <input name="monres" type="text" id="monres">
                    </div></td>
                </tr>

                <tr>
                    <th colspan="3">Glosa</th>
                    <th colspan="3" ><div align="left">Fecha (## / ## / ##)</div></th>
                </tr>
                <tr>
                    <td height="37" colspan="3" rowspan="2"><input name="glosa" type="text" id="glosa" size="50"></td>
                  <td width="89"><div align="center"> <input name="dia" type="text" id="dia" size="2" maxlength="2"></div></td>
                  <td width="90"><div align="center"> <input name="mes" type="text" id="mes" size="2" maxlength="2"></div></td>
                  <td width="79" ><div align="center"><input name="ani" type="text" id="ani" size="2" maxlength="2"></div></td>
              </tr>
                <tr>
                  <th><div align="center">D&iacute;a</div></th>
                  <th ><div align="center">Mes</div></th>
                  <th ><div align="center">A&ntilde;o</div></th>
                </tr>

                <tr>
                    <th colspan="2">Comprobante  </th>
                    <th colspan="4">&nbsp;</th>
                </tr>
                <tr>
                  <td height="26" colspan="2"><input name="cbte" type="text" id="cbte"></td>
                  <td></td>
                  <td colspan="3" ></td>
                </tr>

                <tr >
                  <td ></td>
                  <td ></td>
                  <td ><div align="right">
                    <input type="reset" name="Submit2" value="Cancelar">
                  </div></td>
                  <td colspan="3" ><div align="right">
                    <input type="submit" name="Submit" value="Traspasar">
                  </div></td>
                </tr>
            </table>
            <br>
            <table width="523" align="center">
                <tr>
                    <th colspan="3" ><div align="center">Partida a recibir monto </div></th>
                </tr>
                <tr>
                    <th width="238" >Clasificador</th>
                    <th width="269" >Fuente Economica </th>
                    <th width="269" >Monto presupuestado </th>
                </tr>
                <tr >
                    <td ><c:out value="${codmoning2}"/> - <c:out value="${descla2}"/></td>
                    <td ><c:out value="${codfueneco2}"/> - <c:out value="${des2.descripcion}"/></td>
                    <td ><div align="right"><c:out value="${monto2}"/></div></td>
                </tr>
            </table>


            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>


            <input type=hidden name=codmoning value='<c:out value="${codmoning}"/>'>
            <input type=hidden name=descla value='<c:out value="${descla}"/>'>

            <input type=hidden name=codfueneco value='<c:out value="${codfueneco}"/>'>
            <input type=hidden name=desfe value='<c:out value="${desfe}"/>'>

            <input type=hidden name=monto value='<c:out value="${monto}"/>'>

            <!-- DOS -->
            <input type=hidden name=codmoning2 value='<c:out value="${codmoning2}"/>'>
            <input type=hidden name=descla2 value='<c:out value="${descla2}"/>'>

            <input type=hidden name=codfueneco2 value='<c:out value="${codfueneco2}"/>'>
            <input type=hidden name=desfe2 value='<c:out value="${desfe2}"/>'>

            <input type=hidden name=monto2 value='<c:out value="${monto2}"/>'>


            <input type=hidden name=ref1 value='<c:out value="${ref1}"/>'>
            <input type=hidden name=ref2 value='<c:out value="${ref2}"/>'>

        </form>



        </div></div>
    </body>
</html>