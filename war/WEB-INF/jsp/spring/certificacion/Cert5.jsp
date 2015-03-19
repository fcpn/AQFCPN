<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
    <head>
        <script type="text/javascript" src="prototype.js"></script>
        <script>
            function borrar_tmp()
            {
                var codtar = '<c:out value="${codtar}"/>';
                var params = 'codtar=' + codtar;
                var url = '<c:url value="/certcert9.do"/>';
                new Ajax.Updater({success: 'resultadoz'}, url,
                        {method: 'post', parameters: params, onFailure: reportError});
                return false;
            }
            function reportError(request) {
                $('fixme') = "Error";
            }
        </script>
    </head>
    <body>
        <c:if test="${!empty MN[0][0]}">
            <iframe src="pdf/<c:out value="${direc}"/>" frameborder="0" style="width:100%;height:100%"></iframe>
            <script>
                function imprimehj()
                {
                    alert("Tambien Puede ver, imprimir y guardar la certificacion presupuestaria en el enlace CERTIFICACION EN PROCESO de la tarea");
//                    window.close();
                }
                setTimeout(imprimehj, 50);
                setTimeout(borrar_tmp, 2);
            </script>
        </c:if>
        <c:if test="${empty MN[0][0]}">No Existen Datos para La certificacion Presupuestaria Certificacion!!</c:if>
    </body>
</html>