<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<div id="content">

    <table class="sal_ir" align="right">
        <tr>
            <th style="cursor:pointer" onclick="inicio();">Salir</th>
        </tr>
    </table>
    <br>
    <table>
        <c:forEach var="g" items="${lista_grupos}">
            <tr>
                <th style="cursor:pointer" onclick="a_subgrupos('<c:out value="${g.codmonegr1}"/>');">
                    [<c:out value="${g.codmonegr1}"/>]
                </th>
                <th style="cursor:pointer" onclick="a_subgrupos('<c:out value="${g.codmonegr1}"/>');">
                    [<c:out value="${g.des1}"/>]
                </th>
            </tr>
            <tr>
                <td colspan="2"><c:out value="${g.descripciones1}"/></td>
            </tr>
        </c:forEach>
    </table>
    <table class="sal_ir" align="right">
        <tr>
            <th style="cursor:pointer" onclick="inicio();">Salir</td>
        </tr>
    </table>
