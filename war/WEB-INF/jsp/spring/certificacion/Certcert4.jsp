<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<div id="content">
    <c:if test="${nk!=0}">
        <table>
            <c:forEach var="ggt" items="${lista_grupo}">
                <tr>
                    <th><c:out value="${ggt.codgru}"/> - <c:out value="${ggt.descripcion}"/> </th>
                </tr>
            </c:forEach>
            <c:forEach var="gg" items="${lista_subgrupo}">
                <tr>
                    <th><c:out value="${gg.codgru}"/> - <c:out value="${gg.descripcion}"/> </th>
                </tr>
            </c:forEach>
        </table>
    <br>
        <table class="sal_ir" align="right">
            <tr>
                <th style="cursor:pointer" onclick="a_subgrupos('<c:out value="${codmonegr1}"/>');">Ir Para Atras</th>
            </tr>
        </table>
            <br><br><br>
    <c:forEach var="g" items="${lista_partidas}">
        <table>
            <tr>
                <th><span align="center">Partida</span></th>
                <th><span align="center">descripcion</span></th>
                <th><span align="center">Fuente Economica</span></th>
                <th><span align="center">Saldo</span></th>
                <th><span align="center">Comprometido</span></th>
                <th>&nbsp;</th>
            </tr>
            <tr>
                <td><span align="center"><c:out value="${g.codmonegr}"/></span></td>
                <td><c:out value="${g.des_partida}"/></td>
                <td><span align="center"><c:out value="${g.codfueneco}"/></span></td>
                <td><span align="center"> <fmt:formatNumber value="${g.saldo}" pattern="#,###,###,##0.00"/> </span></td>
                <!-- <td align="center"><span class="numeros">  <c:out value="${g.sumcom+g.sumcomtmp}"/></span></td> -->
                <td><span align="center"> <fmt:formatNumber value="${g.sumcom+g.sumcomtmp}" pattern="#,###,###,##0.00"/> </span></td>
                <th style="cursor:pointer"> <span onclick="ok('<c:out value="${g.codtar}"/>', '<c:out value="${g.codmonegr}"/>','<c:out value="${g.codfueneco}"/>','<c:out value="${g.saldo}"/>','<c:out value="${g.sumcom+g.sumcomtmp}"/>','<c:out value="${g.ref123}"/>','<c:out value="${g.sumcomtmp}"/>','<c:out value="${g.descripciones}"/>','<c:out value="${g.disponible}"/>');" ><font color="#FEFEFE"><strong>ok</strong></font></span></th>
            </tr>
            <tr>
                <th colspan="5" >Detalle</th>
            </tr>
            <tr>
                <td colspan="5"><c:out value="${g.descripciones}"/></td>
            </tr>
        </table>
    </c:forEach>
    <br>
        <table class="sal_ir" align="right">
            <tr>
                <th style="cursor:pointer" onclick="a_subgrupos('<c:out value="${codmonegr1}"/>');">Ir Para Atras</th>
            </tr>
        </table>
    <br>
    </c:if>

    <c:if test="${nk==0}">
        <table>
            <tr>
                <th>El Producto seleccionado esta en una partida que no aparece en el clasificador presupuestario asignado a su tarea, Ponganse en contacto Con el Area Desconcentrada para regular esta situacion</th>
            </tr>
            <tr>
                <th>o apropie este producto a una partida mediante este <span  style="cursor:pointer" onclick="inicio('0');">menú partidas</span></th>
            </tr>
        </table>
    </c:if>
</div>

 