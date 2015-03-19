<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>

<style type="text/css">
<!--
.Estilo2 {font-size: 12px}
.Letras {font-size: 12px; font-weight: bold; }
.numeros {font-size: 12px}
-->
</style>



<c:if test="${nk!=0}">
<table align="center">
    <c:forEach var="ggt" items="${lista_grupo}">
    <tr>
        <td>
            <c:out value="${ggt.codgru}"/>
        </td>
        <td>- <c:out value="${ggt.descripcion}"/> </td>
    </tr>
    </c:forEach>
<c:forEach var="gg" items="${lista_subgrupo}">
    <tr>
        <td>
            <c:out value="${gg.codgru}"/>
        </td>
        <td>- <c:out value="${gg.descripcion}"/> </td>
    </tr>
    </c:forEach>


</table><br>

<!-- Restringiendo el retroceso por la busqueda en Like
<table align="right">
    <tr>
      <td style="cursor:pointer" onclick="a_subgrupos('<c:out value="${codmonegr1}"/>');">
       Ir Para Atras
      </td>
    </tr>
</table>-->
<br><br>


 <c:forEach var="g" items="${lista_partidas}">
<table width="559" height="59" border="1" align="center">
  <tr bgcolor="#CCCCCC">
    <td bgcolor="#7C8CC1" width="51" align="center"><span class="Letras">Partida</span></td>
    <td bgcolor="#7C8CC1" width="274" align="center"><span class="Letras">descripcion</span></td>
    <td bgcolor="#7C8CC1" width="66" align="center"><span class="Letras">Fuente Economica </span></td>
    <td bgcolor="#7C8CC1" width="66" align="center"><span class="Letras">Saldo</span></td>
    <td bgcolor="#7C8CC1"  width="80" align="center"><span class="Letras">Comprometido</span></td>
    <td bgcolor="#FEFEFE" width="20" align="center">&nbsp;</td>
  </tr>
  <tr>
    <td height="21" align="center"><span class="numeros"><c:out value="${g.codmonegr}"/></span></td>
    <td align="justify"><span class="numeros"><c:out value="${g.des_partida}"/></span></td>
    <td align="center"><span class="numeros"><c:out value="${g.codfueneco}"/></span></td>
    <td align="center"><span class="numeros"> <fmt:formatNumber value="${g.saldo}" pattern="#,###,###,##0.00"/> </span></td>
    <!-- <td align="center"><span class="numeros"><c:out value="${g.sumcom}"/></span></td> -->
    <td align="center"><span class="numeros"> <fmt:formatNumber value="${g.sumcom+g.sumcomtmp}" pattern="#,###,###,##0.00"/> </span></td>
    
    <td bgcolor="#1B3572" align="center" style="cursor:pointer"><span class="numeros" onclick="ok('<c:out value="${g.codtar}"/>', '<c:out value="${g.codmonegr}"/>','<c:out value="${g.codfueneco}"/>','<c:out value="${g.saldo}"/>','<c:out value="${g.sumcom+g.sumcomtmp}"/>','<c:out value="${g.ref123}"/>','<c:out value="${g.sumcomtmp}"/>','<c:out value="${g.descripciones}"/>','<c:out value="${g.disponible}"/>');" ><font color="#FEFEFE"><strong>ok</strong></font></span></td>
  </tr>
  <tr bgcolor="#CCCCCC">
    <td bgcolor="#7C8CC1" height="21" colspan="5" align="center"><span class="Letras">Detalle</span></td>
  </tr>
  <tr>
    <td height="21" colspan="5" align="justify"><span class="numeros"><c:out value="${g.descripciones}"/></span></td>
  </tr>
  
</table>
</c:forEach>

<br>
<table align="right">
    <tr>
      <td style="cursor:pointer" onclick="inicio();" bgcolor="#F46060">
       Salir de este menú
      </td>
    </tr>
</table>
<br><br>

</c:if>

<c:if test="${nk==0}">
<table><tr>
    <td bgcolor="#F8501F"><strong><font color="#ffffff">El Producto seleccionado esta en una partida que no aparece en el clasificador presupuestario asignado a su tarea, Ponganse en contacto Con el Area Desconcentrada para regular esta situacion</font></strong></td>
    </tr><tr><td bgcolor="#336699"> <font color="#ffffff">o apropie este producto a una partida mediante este <span  style="cursor:pointer" onclick="inicio('0');">menú partidas</span></font></td>
    </tr></table>

    </c:if>


 