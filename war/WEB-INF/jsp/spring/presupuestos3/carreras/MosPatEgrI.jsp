<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
<style type="text/css">
<!--
.Estilo1 {font-size: 12px}
.Estilo5 {font-size: 12px; font-weight: bold; color: #FFFFFF; }
.Estilo6 {color: #FFFFFF}
.Estilo7 {font-size: 11px; color: #000066;
	font-weight: bold;
}
-->
        </style>


    </head>
    <body>

        <table width="563" height="92" border="1" align="center">
  <tr bgcolor="#003366">
    <td colspan="4" align="center"><br><span class="Estilo5">MEN&Uacute; DE TAREAS <br> para la Fuente Econ&oacute;mica <br> <c:out value="${codfueneco}"/> - <c:out value="${descripcion}"/> <br>&nbsp;</span></td>
  </tr>
<%int i=0;%>


        <c:forEach var="i" begin="0" end="${Fcl-1}">
             <c:if test="${M[i][2]==2}">
               <tr bgcolor="#A90E0E">
                <td colspan="4"><div align="center"><span class="Estilo1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></div> </td>
             </tr>
			   <tr bgcolor="#004F9D">
                 <td colspan="4"><div align="left" class="Estilo1 Estilo6"><strong>Actividad</strong></div></td>
             </tr>
               <tr>
                <td colspan="4"><div align="center"><span class="Estilo1"><strong><c:out value="${M[i][0]}"/> - <c:out value="${M[i][1]}"/></strong></span></div> </td>
             </tr>

            </c:if>

            <c:if test="${M[i][2]==5}">
               
            </c:if>
            <c:if test="${M[i][2]==3}">


           <%i++;%>
            <tr onMouseOver="this.style.backgroundColor='#66FFCC';" onMouseOut="this.style.backgroundColor='#ffffff';" >
    <td width="22"><div align="center" class="Estilo7"><%= i%></div></td>
    <td width="29"><span class="Estilo7">Tarea</span></td>
    <td width="86"><div align="center"><span class="Estilo1">
        <a  href="javascript:popUp('<c:url value="/GralFuen3.do">
                        <c:param name="codtar" value="${M[i][0]}"/>
                        <c:param name="destar" value="${M[i][1]}"/>

                       <c:param name="codfueneco" value="${codfueneco}"/>
                       <c:param name="desfe" value="${descripcion}"/>
                    </c:url>')">
                     <c:out value="${M[i][0]}"/> </a>

    </span></div></td>

                <td width="398"><span class="Estilo1"><a  href="javascript:popUp('<c:url value="/GralFuen3.do">
                        <c:param name="codtar" value="${M[i][0]}"/>
                        <c:param name="destar" value="${M[i][1]}"/>

                       <c:param name="codfueneco" value="${codfueneco}"/>
                       <c:param name="desfe" value="${descripcion}"/>
                    </c:url>')">
                     <c:out value="${M[i][1]}"/> </a></span></td>
  </tr>






            </c:if>






        </c:forEach>

        </table>
        <br><br><br>&nbsp;

    </body>
</html>
