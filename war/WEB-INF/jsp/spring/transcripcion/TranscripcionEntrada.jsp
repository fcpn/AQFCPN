<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<%@ include file="../Cabecera.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>
<br><br>
<table align=center width="60%">
    <tr>
        <td align="center"><a href="<c:url value="/transcripcion.do"><c:param name="transcripcion" value="transcripcion"/></c:url>"><img alt="TRANSCRIPCION" src='./images/log-transcrip.png' border=0/></a></td>
        <td align="center"><img alt="REPORTES" src='./images/log-reportes.png' border=0/></td>        
    </tr>    
    <tr>
        <td class=colb align="center">TRANSCRIPCION</td>
        <td class=colb align="center">REPORTES</td>              
    </tr>
</table>

<a href="<c:url value="/menu/menu.do"><c:param name="id_categoria" value="${categorias.id_categoria}"/></c:url>">
    <c:out value="${categorias.categoria}"/>
</a>
<!--

<form name=forma1 method="POST" action='<c:url value="/transcripcion.do"/>'>    
    <input type="submit" value="conexion"> <c:out value="${mensaje}"/>::<c:out value="${c}"/>
</form>
-->
<%@ include file="../VerPieCuerpo.jsp" %> 