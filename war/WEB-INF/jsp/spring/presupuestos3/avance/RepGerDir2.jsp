
<%@ include file="../../Cabecera.jsp" %>

<html>
<head>
    <title>Avance de Tareas de la Facultad de Ciencias Puras y Naturales</title>
    <style type="text/css">
        <!--
.Estilo4 {
	color: #ffffff;
	font-weight: bold;
	font-size: 12px;
}


.dosca {
	color: #000000;
	font-weight: bold;
	font-size: 12px;
}
.cuerpo {
	color: #000000;
	font-size: 12px;
}
.Estilo7 {color: #FFFFFF; font-weight: bold; font-family: Verdana, Arial, Helvetica, sans-serif; }
.Estilo8 {font-size: 10px}
.Estilo9 {color: #FFFFFF; font-weight: bold; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; }
.Estilo10 {
	color: #FFFFFF;
	font-weight: bold;
}

        -->
    </style>





</head>
<body>



<table width="518" border="0" align="center">
    <tr>
      <td width="526" colspan="3"> <div align="center"><img src="./././imagenesgeren/avancetarea.png" width="512" height="55"></div></td>
    </tr>
    <tr>
      <td colspan="3"><table width="265" border="1" align="center">
        <tr>
          <td width="125" bgcolor="#990033"><div align="center" class="Estilo7 Estilo8">del</div></td>
          <td width="124" bgcolor="#990033"><div align="center"><span class="Estilo9">al</span></div></td>
        </tr>
        <tr>
          <td bgcolor="#234567"> <div align="center" class="Estilo10"><c:out value="${f1n}"/></div></td>
          <td bgcolor="#234567"><div align="center"><span class="Estilo10"><c:out value="${f2n}"/></span></div></td>
        </tr>
      </table>      </td>
    </tr>
</table>



<!--  MOSTRANDO TODO DE INGRESOS  -->

<form name="form1" method="post" action="  ">

<table width="700" border="1" align="center" >

<c:forEach var="i" begin="0" end="${filas}">
    <tr onMouseOver="this.style.backgroundColor='#CC9999';" onMouseOut="this.style.backgroundColor='#ffffff';">
     <c:forEach var="j" begin="0" end="${columnas}">

         <c:if test="${i==0}">

             <td align="right" bgcolor="#993300"  width="500"> <span class="Estilo4"> <c:out value="${M[i][j]}"/></span></td>

         </c:if>

         <c:if test="${i==1}">

             <td align="right" bgcolor="#E2E2E2" width="500"> <span class="dosca"><c:out value="${M[i][j]}"/></span></td>

         </c:if>

         <c:if test="${i>1}">

             <c:if test="${j<2}">
                <td align="right" width="500"><span class="cuerpo"> <c:out value="${M[i][j]}"/> </span></td>
            </c:if>
            <c:if test="${j>1}">
                <td align="right" width="500"><span class="cuerpo">  <fmt:formatNumber value="${M[i][j]}" pattern="#,###,###,##0.00"/> </span></td>
            </c:if>
         </c:if>

     </c:forEach>
  </tr>
</c:forEach>


</table>
</form>

</body>
</html>


