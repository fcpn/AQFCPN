<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>

         <script type="text/javascript">
        function confirma(miurl,aa){

        question = confirm("Eliminar el Partida : "+ aa +" ?")
        if (question !="0"){
        document.location.href = miurl;
        }
        }

</script>


    </head>
    <body>
        
        <h1>Clasificador Presupuestario Egresos (Partida)</h1>
        <c:forEach var="g" items="${partida}">
       
            <c:if test="${g.tipo == '1'}">
                
               <br><br><br><font color="#BF0039"> <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></font>
               <a href="<c:url value="/modpar.do">
                            <c:param name="codmonegr" value="${g.codigo}"/>
                            <c:param name="tipo" value="${g.tipo}"/>
                     </c:url>">...... [Modificar] </a> .....
             <a style="cursor: pointer; color: red;"
                onClick="confirma('<c:url value="/EliPar.do">
                    <c:param name="codmonegr" value="${g.codigo}"/>
                    <c:param name="tipo" value="${g.tipo}"/></c:url>','<c:out value="${g.codigo}"/>'); return false;">
                 [Eliminar] </a>
               <br>
              </c:if>
             <c:if test="${g.tipo == '2'}">
                &nbsp;&nbsp;&nbsp;&nbsp;
               <font  color="#04047B"> <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></font>
                <a href="<c:url value="/modpar.do">
                            <c:param name="codmonegr" value="${g.codigo}"/>
                            <c:param name="tipo" value="${g.tipo}"/>
                     </c:url>">...... [Modificar] </a> .....
             <a style="cursor: pointer; color: red;"
                onClick="confirma('<c:url value="/EliPar.do">
                    <c:param name="codmonegr" value="${g.codigo}"/>
                    <c:param name="tipo" value="${g.tipo}"/></c:url>','<c:out value="${g.codigo}"/>'); return false;">
                 [Eliminar] </a>

               <br>
              </c:if>
              <c:if test="${g.tipo == '3'}">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/>
                <a href="<c:url value="/modpar.do">
                            <c:param name="codmonegr" value="${g.codigo}"/>
                            <c:param name="tipo" value="${g.tipo}"/>
                     </c:url>">...... [Modificar] </a> .....
             <a style="cursor: pointer; color: red;"
                onClick="confirma('<c:url value="/EliPar.do">
                    <c:param name="codmonegr" value="${g.codigo}"/>
                    <c:param name="tipo" value="${g.tipo}"/></c:url>','<c:out value="${g.codigo}"/>'); return false;">
                 [Eliminar] </a>
                <br>
              </c:if>
              
        </c:forEach> 
        
        
    </body>
</html>