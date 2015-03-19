<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<%@ include file="../Cabecera.jsp" %>

<center>
<table  border="0" cellspacing="1" cellpadding="0">
<tr>
    <td align="center" class="colh" style="padding-top:3px;padding-bottom:3px">AVISO</td>
</tr>
<tr>    
    <td align="center" class="colb" style="padding-top:5px;padding-bottom:5px"><c:out value="${mensaje}"/></td>
</tr>
<c:if test="${!empty usuario}">
    <tr>
    <td align = center class=colh>USUARIO</tr>
    </tr>
    <tr>
        <td class=colb><c:out value="${usuario}"/></td>
    </tr>
    <tr>
        <td align = center class=colh>PROGRAMA</td>
    </tr>
    <tr>
        <td class=colb><c:out value="${programa}"/></td>
    </tr>   
</c:if>
<tr>
    <td align=center class="normal"> 
    <form name=forma action="<c:url value="/login.do"/>" method="POST">
        <a href="javascript:document.forma.submit()" ><b>Intentar de nuevo</b></a>         
    </form>
</tr>
</table>
</center>

<%@ include file="../VerPieCuerpo.jsp" %> 
