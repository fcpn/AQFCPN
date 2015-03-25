
<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <script>
        function validar(e) {
            tecla = (document.all)?e.keyCode:e.which;
            if (tecla==8) return true;
            patron = /\d/;
            te = String.fromCharCode(tecla);
            return patron.test(te);
        }
        </script>
        <style type="text/css">
            .tab{
                width: 250;
            }
        </style>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
    </head>
    <body>
        <div id="content" align="center">
            <div align="center"><h2><b>
                <c:out value="${actividad.descripcion}"/> - <c:out value="${actividad.codacti}"/><br>
                <c:out value="${tarea.descripcion}"/> - <c:out value="${tarea.codtar}"/>
                    </b></h2>
            </div>
        
                    <table class="tab">
            <tr>
                <th colspan="3"><div align="center">Certificaci&oacute;n Presupuestaria</div></th>
            </tr>
            <tr>
                <td>
                    <div align="center"><input name="dia" type="text" id="dia3" onKeyPress="return validar(event)" size="2" maxlength="2"></div>
                </td>
                <td>
                    <div align="center"><input name="mes" type="text" id="mes2" onKeyPress="return validar(event)" size="2" maxlength="2"></div>
                </td>
                <td>
                    <div align="center"><input name="anio" type="text" id="dia4" onkeypress="return validar(event)" value="09" size="2" maxlength="2"></div>
                </td>
            </tr>
            <tr>
                <td><div align="center"><strong>dia</strong></div></td>
                <td><div align="center"><strong>mes</strong></div></td>
                <td><div align="center"><strong>a&ntilde;o</strong></div></td>
            </tr>
            <tr>
                <td colspan="3"><div align="center"><strong style="border: solid"> &nbsp; Buscar &nbsp; </strong></div></td>
            </tr>
        </table>
        </div>
    </body>
</html>