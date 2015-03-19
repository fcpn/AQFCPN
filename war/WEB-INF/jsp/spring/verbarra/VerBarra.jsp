<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<body OnLoad="document.forma.submit()">    
    <c:if test="${empty id_rol}">
        <form name=forma method='post' action='<c:url value="/login.do"/>' >
    </c:if>    
    <c:if test="${!empty id_rol}">
        <form name=forma method='post' action='<c:url value="/menu.do"/>' >
    </c:if>
        </form>    
</body>