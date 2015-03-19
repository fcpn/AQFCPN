<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ include file="../VerCabezaCuerpo.jsp" %>
<body OnLoad="document.forma.submit()">


<form name=forma method=post action='<c:url value="${destino}" />'>
        <input type="hidden" name="id_rol"  value='<c:out value="${id_rol}" />'> 
        <input type="hidden" name="usuario" value='<c:out value="${usuario}" />'>
        <input type="hidden" name="id_usuario" value='<c:out value="${id_usuario}" />'>
        <input type="hidden" name="destino" value='<c:out value="${destino}" />'>
        <input type="hidden" name="acceso" value='<c:out value="${acceso}" />'>
<!--
        <input type="hidden" name="gestion" value='<c:out value="${gestion}" />'>
        <input type="hidden" name="periodo" value='<c:out value="${periodo}" />'>
-->
</form>
</body>
<table border="0">
    <tr>
    <td </td>   
    </tr>
<tr>
    <td </td>   
    </tr>
<tr>
    <td </td>   
    </tr>
</table>
<h3><center> C a r g a n d o . . . . .  </center></h3>
<%@ include file="../VerPieCuerpo.jsp" %>

    