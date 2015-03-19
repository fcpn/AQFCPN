<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
 
        
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
    </head>
    <body>
        
        <h1>Incremento de Montos Egresos:</h1>
        
        <br><br>
        <h5 align="center">Fuente Económica:&nbsp;&nbsp;&nbsp;<c:out value="${codfueneco}"/> - <c:out value="${fe.descripcion}"/></h5>
        
        
        <br><br>
        
        
        
        <c:forEach var="g" items="${pat}">
       
            <c:if test="${g.tipo == '1'}">
                
                <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/><br>
              </c:if>
             <c:if test="${g.tipo == '2'}">
                &nbsp;&nbsp;&nbsp;&nbsp;
                <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/><br>
              </c:if>
              <c:if test="${g.tipo == '3'}">
                
                  
                  <a href="javascript:popUp('<c:url value="/IncrEgr2.do">            
                       <c:param name="codtar" value="${g.codigo}"/>
                       <c:param name="descripcion" value="${g.descripcion}"/>
                       <c:param name="codfueneco" value="${codfueneco}"/>
                   </c:url>')"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/> </a> <br><br><br>
              </c:if>
              
        </c:forEach> 
        
        
    </body>
</html>
