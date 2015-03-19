<meta http-equiv="content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<table cellpadding="0" cellspacing="0" width="90%" style="border: 1px solid GREEN">     
<tr><td>
<table align="center">
    <tr>        
       <td><img src="./images/icon_success.gif" alt="success"/></td>
       <td class="normal" style="padding-top: 10px; padding-bottom: 10px; color: GREEN"><b>CONECTADO</b></td>
    </tr>
</table>
</td></tr>
</table>

<form id="frmSend" method="GET" action='<c:url value="/logoutUsuario.do"/>'>
<input id="status" type="hidden" value='<c:out value="${status}"/>'>
</form>