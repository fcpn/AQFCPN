package WEB-INF.jsp.spring.presupuestos2.clasificador;


<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <style type="text/css">
<!--
.Estilo1 {font-size: 12px}
-->
        </style>
    </head>
    <body>

        <h3 align="center">Clasificador Presupuestario Egresos (Partida)</h3>


        <table width="673" height="336" border="0" align="center">
          <tr>
            <td><table width="654" height="206" border="0" align="center">
              <tr>
                <td width="261" height="39">Descripciones insertadas para la partida:</td>
                <td width="383"><c:out value="${partida.codigo}"/> - <c:out value="${partida.descripcion}"/></td>
              </tr>
              <tr bgcolor="#999999">
                <td colspan="2">                <div align="justify">
                  <c:out value="${partidadetalle.descripciones}"/>
                </div></td>
              </tr>
            </table>


              <div align="center"><br>
                <br>
            [<a  href="<c:url value="/insdetallespar.do">

                   </c:url>"><span class="Estilo1">Insertar nueva descripci&oacute;n</span> </a>] </div></td>


<!--

<a  href="<c:url value="/insdetallespar.do">
                       <c:param name="codtar" value="${codtar}"/>

                   </c:url>"><span class="Estilo1">Insertar nueva descripci&oacute;n</span> </a>


-->


          </tr>
        </table>

        <p align="center">&nbsp;</p>
    </body>
</html>