<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title>FCPN :: Sistema de Presupuestos AQUILES</title>
    <meta content="text/html; charset=windows-1252" http-equiv="Content-Type" />
    <META HTTP-EQUIV="Cache-Control" CONTENT="max-age=0">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="expires" content="0">
    <META HTTP-EQUIV="Expires" CONTENT="Tue, 01 Jan 1980 1:00:00 GMT">
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  </head>

<link href='http://localhost:8080/cp2010/images/favicon.ico' rel='icon'/>
<link href='http://localhost:8080/cp2010/images/favicon.ico' rel='shortcut icon'/>
<link rel="shortcut icon" href="http://localhost:8080/cp2010/images/favicon.ico" type="image/x-icon" />


  <frameset rows='17%,*' frameborder='no' border='0' framespacing='0'>
    <frame src='<c:url value="verCabeza.do"/>' name='cabeza' scrolling='NO' noresize marginwidth="0" marginheight="0">
    <frameset cols='20%,*' frameborder='no' border='0' framespacing='0'>
      <frame src='verBarra.do' name='barra' scrolling='SI' noresize>
      <frameset rows='*,12%' frameborder='no' border='0' framespacing='0'>
        <frame src='verCuerpo.do' name='cuerpo' scrolling='SI' noresize>
        <frame src='<c:url value="verPie.do"/>' name='pie' scrolling='NO' noresize>
      </frameset>
    </frameset>
  </frameset>

</html>