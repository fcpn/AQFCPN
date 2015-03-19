<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fuentes Economicas</title>

        <script type="text/javascript">
        function confirma(miurl,aa){

        question = confirm("Eliminar la Fuente Económica : "+ aa +" ?")
        if (question !="0"){
        document.location.href = miurl;
        }
        }

</script>

    </head>
    <body>

    <h1>Fuentes Economicas disponibles</h1>


<table width="800" border="0">

    <c:forEach var="g" items="${fuente}">
  <tr onMouseOver="this.style.backgroundColor='#ACD9E8';" onMouseOut="this.style.backgroundColor='#ffffff';">
    <td>      <c:out value="${g.codfueneco}"/> &nbsp; - &nbsp;<c:out value="${g.descripcion}"/>
             <a href="<c:url value="/modfue.do">
                            <c:param name="codfueneco" value="${g.codfueneco}"/>
             </c:url>">...... [Modificar] </a> .....
             <a 
                style="cursor: pointer; color: red;"
                onClick="confirma('<c:url value="/EliFuen.do">
                    <c:param name="codfueneco" value="${g.codfueneco}"/>
                  </c:url>','<c:out value="${g.codfueneco}"/>'); return false;">
                 [Eliminar] </a>
    </td>

  </tr>



        </c:forEach>

    </table>



    </body>
</html>