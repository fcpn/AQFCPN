<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INFORME</title>
    </head>
    <body>

    <h1>INFORME</h1>

    <c:forEach var="g" items="${pro}">
       
           <c:out value="${g.codigo}"/> &nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp;<c:out value="${g.descripcion}"/><br>
             
        </c:forEach>     
    </body>
</html>
