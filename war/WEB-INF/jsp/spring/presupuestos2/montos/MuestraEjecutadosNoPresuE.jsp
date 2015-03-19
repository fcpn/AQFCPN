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
        <form name="form1" method="post" action=" <c:url value="/MonNoPreEgr4.do"/>" >
              <table width="523">
                <tr>
                    <th colspan="2" ><div align="center">Montos Ejecutados No Presupuestados Egresos</div></th>
                </tr>
                <tr >
                    <th width="238" >Actividad  <c:out value="${actividad.descripcion}"/> </th>
                    <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
                </tr>
            </table>
            <br>

            <table width="542">

                <c:forEach var="mo" items="${mosmoneje}">

                        <c:if test="${mo.codtar==tarea.codtar }">
                            <tr>
                                <td width="96">-</td>
                                <td width="373"><c:out value="${mo.codfueneco}"/> - fuente economica  </td>
                            </tr>
                            <tr>
                                <td><c:out value="${mo.codmonnopreegr}"/> - <c:out value="${mo.descla}"/></td>
                                <td><c:out value="${mo.monejenopre}"/> </td>
                            </tr>
                        </c:if>
                </c:forEach>

                <tr>
                    <td height="39" colspan="2"><div align="right">
                      <input type="submit" name="Submit2" value="Agregar nuevo monto ejecutado">
                    </div></td>
                </tr>
          </table>
            <input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${codtar}"/>'>
            <input type=hidden name=cod_gnp value='<c:out value="${cod_gnp}"/>'>
    </form>
        </div></div>
    </body>
</html>