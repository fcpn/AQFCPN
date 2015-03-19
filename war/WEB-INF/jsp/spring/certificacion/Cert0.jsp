
<%@ include file="../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
    </head>
    <body>
        
        <h1>Programas Actividades y Tareas</h1>
        <c:forEach var="g" items="${pat}">
       
            <c:if test="${g.tipo == '1'}">
                
                <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/><br>
              </c:if>
             <c:if test="${g.tipo == '2'}"><br><br>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/><br>
              </c:if>
              <c:if test="${g.tipo == '3'}">
                
                  
                  <a  href="javascript:popUp('<c:url value="/cert1.do">
                       <c:param name="codtar" value="${g.codigo}"/>
                       <c:param name="descripcion" value="${g.descripcion}"/>
                       
                   </c:url>')"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/> </a> <br>
              </c:if>
              
        </c:forEach> 
        
        
    </body>
</html>
