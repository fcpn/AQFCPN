<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
    <head>
    </head>
    <body>
        <c:if test="${!empty MN[0][0]}">
            <iframe src="pdf/<c:out value="${direc}"/>" frameborder="0" style="width:100%;height:100%"></iframe>
        </c:if>
        <c:if test="${empty MN[0][0]}">No Existen Datos para La certificacion Presupuestaria Certificacion!!</c:if>
    </body>
</html>