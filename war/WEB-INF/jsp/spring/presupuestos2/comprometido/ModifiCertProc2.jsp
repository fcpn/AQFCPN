
<%@ include file="../../Cabecera.jsp" %>
<html>
<head>
    <title>Mostrando los montos presupuestados</title>
    <style type="text/css">
        <!--

.Estilo4 {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 24px;
}
.Estilo5 {
	color: #FFFFFF;
	font-weight: bold;
}
.Estilo25 {font-size: 10px; font-weight: bold; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo29 {font-size: 10px; font-family: Geneva, Arial, Helvetica, sans-serif; }
.Estilo30 {font-family: Verdana, Arial, Helvetica, sans-serif}
.Estilo31 {font-size: 12px}

.Estilo1 {font-size: 12px}
.Estilo3 {font-size: 12px; font-weight: bold; }
            -->
    </style>
</head>
<body>
<p>&nbsp;</p>
<br><br>
Los Datos Fueron Modificados.<br><br><br><br>


<div align="Center"><a  href="<c:url value="/MosCertProc.do">
                            <c:param name="codtar" value="${tarea.codtar}"/>
                            
                            <c:param name="fecha" value="${fecha}"/>
                            <c:param name="num_sol" value="${num_sol}"/>
                            </c:url>">Ver Resultados</a></div>
<p>&nbsp;</p>
</body>
</html>