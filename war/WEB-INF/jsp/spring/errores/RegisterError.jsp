<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<link rel="stylesheet" href="pagina.css" type="text/css">
<link rel="stylesheet" href="../pagina.css" type="text/css">
<blink>
<center>
<table width="30%"  border="0" cellspacing="1" cellpadding="0">
  <tr>
    <td align = center class=colh><c:out value="ERROR"/> </td>
  </tr>
  <tr>
    <td align = center class=colb><c:out value="${mensaje}"/> </td>
  </tr>
</table>
</center>
</blink>
