<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>

      <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>

        <title>Documento sin t&iacute;tulo</title>

    </head>

    <body>
      <div id="container">
<div id="content">
        <table  align="center">
            <tr>
                <th><div align="center">
                     Actividad <c:out value="${actividad.descripcion}"/> <br> Tarea <c:out value="${tarea.descripcion}"/>  </div>    </th>
            </tr>


        </table>
        <br>

        <form name="form1" method="post" action="<c:url value="/MonNoPreEgr4.do"/>">
            <table align="center">
                <tr>
                    <th><div align="center">Cuentas No Presupuestarias egresos</div></th>
                </tr>

                 <tr>
                    <th>
                  Nueva cuenta</th>
                </tr>

                <tr>
               <td> <div align="center">
           <select name="cod_gnp">
                       <c:forEach var="d" items="${gruponp}">
   <option value="<c:out value="${d.cod_gnp}"/>" ><c:out value="${d.cod_gnp}"/> - <c:out value="${d.descripcion}"/></option>
                       </c:forEach>
           </select></div>
</td>
                </tr>
               <tr>
               <td><div align="center">
                <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                <input type="submit" name="Submit" value="Insertar Montos No Presupuestado (inicial) ">
                    </div></td>
                </tr>
            </table>
        </form>

        <form name="form2" method="post" action="<c:url value="/ActualizaNoPresupuestariae.do"/>">
            <table  align="center">

                <tr>
                    <th>
                  Actualizar</th>
                </tr>

                <tr>
                    <td>
                        <div align="center">
<select name="cod_gnp">
                       <c:forEach var="d" items="${gruponp}">
   <option value="<c:out value="${d.cod_gnp}"/>" ><c:out value="${d.cod_gnp}"/> - <c:out value="${d.descripcion}"/></option>
                       </c:forEach>
           </select>
                        </div>
                    </td>
                </tr>
              <tr>
                    <td>
                    <div align="center">
                            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>

                            <input type="submit" name="Submit2" value="Actualizar Cuenta No Presupuestaria">

                    </div></td>
                </tr>
            </table>

        </form>
        </div>
        </div>
    </body>
</html>
