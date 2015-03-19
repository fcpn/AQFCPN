

<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fuentes Economicas</title>
    </head>
    <body>

    <h1>Elija Fuente A Consultar </h1>
    

    <c:forEach var="g" items="${fuente}">
       
          
             <a href=<c:url value="/ReporteViceDet2.do">
                       <c:param name="codfueneco" value="${g.codfueneco}"/>
                       <c:param name="descripcion" value="${g.descripcion}"/>
                       
                   </c:url>> <c:out value="${g.codfueneco}"/> &nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;&nbsp;<c:out value="${g.descripcion}"/> </a>
             <br>
          
             
        </c:forEach> 
    
    
    
    
    
    </body>
</html>
