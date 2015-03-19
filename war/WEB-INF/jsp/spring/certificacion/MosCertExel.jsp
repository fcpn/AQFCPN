
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<html>
<head>
<style type="text/css">
<!--
.Estilo5 {font-size: 11px}
.Estilo6 {font-size: 10px}
.Estilo10 {font-size: 11px; font-weight: bold; }
.Estilo11 {font-size: 45px; font-weight: bold; }
.tablilla {border-top: 1px solid #000000; border-bottom: 1px solid #000000; border-left: 1px solid #000000; border-right: 1px double #000000;}
.tablilla2 {border-top: 1px solid #000000; border-bottom: 1px solid #000000;}
-->
</style>

<script type="text/javascript" src="prototype.js"></script>




</head>

<body bgcolor="#99BFEA">



<c:if test="${!empty MN[0][0]}">

<table border="1" align="center">
          <tr bgcolor="#E88B24">
            <td bgcolor="#2F4D84"><span class="Estilo1">
            <div align="center"><font color="ffffff">
			<br><strong>Sistema de Presupuestos<br>
              AQUILES<br>
              Certificaci&oacute;n Presupuestaria
            </strong></font></div>
            </span>
            <br></td>
          </tr>
          <tr>
            <td bgcolor="#D76464">
               <div align="center">
   <strong><font color="#FFFFFF">DESCARGAR CERTIFICACION <br>EN <br>FORMATO EXCEL </font></strong>
<br><br>
<a href="exel/<c:out value="${direc}"/>"><font color="#FFFFFF">Descargar</font></a></div>
                </td>
          </tr>
          <tr bgcolor="#E88B24">
            <td bgcolor="#243C66">&nbsp;			</td>
          </tr>
</table>

</c:if>

<c:if test="${empty MN[0][0]}">No Existen Datos para La certificacion Presupuestaria Certificacion!!</c:if>


</body>
</html>


