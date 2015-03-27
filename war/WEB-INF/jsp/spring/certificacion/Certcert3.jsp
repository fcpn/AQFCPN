<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<div id="content">
    <table>
        <c:forEach var="gg" items="${lista_grupo}">
            <tr>
                <th><div align="center"><c:out value="${gg.codgru}"/> - <c:out value="${gg.descripcion}"/></div></th>
            </tr>
        </c:forEach>
    </table>
    <table class="sal_ir" align="right">
        <tr>
            <th style="cursor:pointer" onclick="buscar('<c:out value="${codtar}"/>');">Ir Para Atras</th>
        </tr>
    </table>
<br/>
    <table>
        <c:forEach var="g" items="${lista_subgrupos}">
            <tr>
                <th style="cursor:pointer" onclick="a_partidas('<c:out value="${g.codmonegr2}"/>','<c:out value="${codmonegr1}"/>','1');">
                    [<c:out value="${g.codmonegr2}"/>]
                </th>
                <th style="cursor:pointer" onclick="a_partidas('<c:out value="${g.codmonegr2}"/>','<c:out value="${codmonegr1}"/>','1');">
                    [<c:out value="${g.des2}"/>] 
                </th>
            </tr>
            <tr>
                <td colspan=2""><c:out value="${g.descripciones2}"/></td>
            </tr>
        </c:forEach>
    </table>
    <table class="sal_ir" align="right">
        <tr>
            <th style="cursor:pointer" onclick="buscar('<c:out value="${codtar}"/>');">Ir Para Atras</th>
        </tr>
    </table>
<!--

<!-- '<c:out value="${g.correlativo}"/>', '<c:out value="${g.no_rut}"/>'
<a  href="('<c:url value="">
    <c:param name="codtar" value="${g.codfueneco}"/>
    <c:param name="descripcion" value="${g.descripciones}"/>

                   </c:url>')">    </a>

<c:out value="${g.codpartida}"/> -- <c:out value="${g.des_partida}"/> --
         <c:out value="${g.ref123}"/> -- <c:out value="${g.codfueneco}"/> --
         <c:out value="${g.descripciones}"/> -- <c:out value="${g.codtar}"/> --
         <c:out value="${g.no_rut}"/> -- <c:out value="${g.correlativo}"/> --
         <c:out value="${g.saldo}"/> <br>




-->



 