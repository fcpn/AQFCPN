<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ include file="../Cabecera.jsp" %>

<style type="text/css">
    A:link    { COLOR: #FFFFFF; TEXT-DECORATION: none }
    A:visited { COLOR: #FFFFFF; TEXT-DECORATION: none }
    A:active  { COLOR: #FFFFFF; TEXT-DECORATION: none }
    A:hover   { COLOR: #FFA652; TEXT-DECORATION: none }
</style>
<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%" >
 <td><img  width="100%" border="0" src='<c:out value="./images/pagina/Banner${id_programa}.gif"/>'/></td>
    

</table>
<%@ include file="VerCabezaMenu.jsp" %>
<%@ include file="../VerPieCuerpo.jsp" %>