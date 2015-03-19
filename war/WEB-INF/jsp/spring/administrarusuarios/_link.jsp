<%@ include file="../Cabecera.jsp" %>

<body OnLoad="document.forma.submit()">
<form name=forma method=post action='<c:url value="/administrarUsuarios2.do"/>' >

<input type=hidden name='id_persona' value='<c:out value="${id_persona}"/>' >
</form>
<center><p class="normal">CARGANDO...</p></center>
</body>

<%@ include file="../VerPieCuerpo.jsp" %>
