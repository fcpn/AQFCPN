<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<style type="text/css">
    .Estilo2 {font-size: 11px; color: #FEFEFE;}
</style>




<table align="right">
    <tr>
        <td style="cursor:pointer" onclick="inicio();"  bgcolor="#DBDB20">
            <font color="#091C5A"><strong>Salir</strong></font>
        </td>
    </tr>
</table>
<br><br>

<table width="260" border="1" align="center">

    <c:forEach var="g" items="${lista_grupos}">
        <tr>

            <td bgcolor="#3B518E" width="20" style="cursor:pointer" onclick="a_subgrupos('<c:out value="${g.codmonegr1}"/>');">
                <span class="Estilo2">[<strong><c:out value="${g.codmonegr1}"/></strong>]</span>
            </td>
            <td bgcolor="#3B518E" width="10" style="cursor:pointer" onclick="a_subgrupos('<c:out value="${g.codmonegr1}"/>');"><span class="Estilo2">[<strong><c:out value="${g.des1}"/></strong>]</span> </td>
        </tr>
        <tr>
            <td colspan="2"><c:out value="${g.descripciones1}"/></td>
        </tr>
    </c:forEach>
</table>


<table align="right">
    <tr>
        <td style="cursor:pointer" onclick="inicio();"  bgcolor="#DBDB20">
            <font color="#091C5A"><strong>Salir</strong></font>
        </td>
    </tr>
</table>

