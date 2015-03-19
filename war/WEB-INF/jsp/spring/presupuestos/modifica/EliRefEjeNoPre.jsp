<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title></title>

    </head>
<body>
 <div id="container">
<div id="content">
            <table width="523">
                <tr>
                  <th colspan="2" ><div align="center">No presupuestados Ingresos</div></th>
              </tr>
                <tr >
                  <th width="238">Actividad <c:out value="${actividad.descripcion}"/> </th>
                  <th width="269">Tarea <c:out value="${tarea.descripcion}"/> </th>
                </tr>
    </table>

        <table width="604">



   <tr>
                    <th colspan="2" class="Estilo27">Partida</th>

                  <th colspan="2">Fuente económica</th>
            </tr>


            <tr >

                <td colspan="2"><div align="center"><c:out value="${monniing.codmonnopreing}"/> - <c:out value="${descla}"/> </div></td>

                <td colspan="2"> <!--monto insertando -->
                    <div align="center"><c:out value="${monniing.codfueneco}"/></div></td>
            </tr>

            <tr>
                <th width="144" class="Estilo27">Monto Acumulado </th>


              <th width="144">Comprobante</th>
                <th width="144"> Fecha de ejecución</th>
                <th width="144">Glosa</th>
            </tr>


            <tr>

                <td width="144"><div align="center"><c:out value="${monniing.mon_acu}"/>

              </div></td>


                <td><div align="center">
                       <c:out value="${monniing.comprobante}"/>
              </div></td>
                <td> <div align="center">
                      <c:out value="${monniing.fecharef}"/>
              </div></td>
                <td><div align="center">
                      <c:out value="${monniing.obs}"/>
              </div></td>
            </tr>


<tr>
                  <td colspan="4" width="144" >
                   si los datos de glosa comprobante y fecha estan vacios el registro se borro correctamente </td>
            </tr>

            <tr>
                  <td colspan="4" width="144" ><div align="right">
                    <a href=<c:url value="/modclasificador.do">

                    </c:url>>Salir</a>
</div>
                </td>
            </tr>


</table>


</div></div>

</body>
</html>
