<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <style type="text/css">
            .myButton#espn {
                -moz-box-shadow: 0px 10px 14px -7px #54a3f7;
                -webkit-box-shadow: 0px 10px 14px -7px #54a3f7;
                box-shadow: 0px 10px 14px -7px #54a3f7;
                background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #007dc1), color-stop(1, #0061a7));
                background:-moz-linear-gradient(top, #007dc1 5%, #0061a7 100%);
                background:-webkit-linear-gradient(top, #007dc1 5%, #0061a7 100%);
                background:-o-linear-gradient(top, #007dc1 5%, #0061a7 100%);
                background:-ms-linear-gradient(top, #007dc1 5%, #0061a7 100%);
                background:linear-gradient(to bottom, #007dc1 5%, #0061a7 100%);
                filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#007dc1', endColorstr='#0061a7',GradientType=0);
                background-color:#007dc1;
                -moz-border-radius:8px;
                -webkit-border-radius:8px;
                border-radius:8px;
                display:inline-block;
                cursor:pointer;
                color:#ffffff;
                font-family:arial;
                font-size:18px;
                font-weight:bold;
                padding:2px 30px;
                text-decoration:none;
                text-shadow:0px 1px 0px #154682;
            }
            .myButton#espn:hover {
                background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #0061a7), color-stop(1, #007dc1));
                background:-moz-linear-gradient(top, #0061a7 5%, #007dc1 100%);
                background:-webkit-linear-gradient(top, #0061a7 5%, #007dc1 100%);
                background:-o-linear-gradient(top, #0061a7 5%, #007dc1 100%);
                background:-ms-linear-gradient(top, #0061a7 5%, #007dc1 100%);
                background:linear-gradient(to bottom, #0061a7 5%, #007dc1 100%);
                filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0061a7', endColorstr='#007dc1',GradientType=0);
                background-color:#0061a7;
            }
            .myButton#espn:active {
                position:relative;
                top:1px;
            }

        </style>
    </head>
    <body>
        <br>
<!--        <table width="163" border="1" align="center">
            <tr>
                <td><div align="right"><a href="#" class="myButton" id="espn">Ver Otros Reportes</a></div></td>
            </tr>
        </table>-->
        <div id="content">
            <div align="center"><b>Informaci&oacute;n de Fuentes Financieras</b></div>
            <table width="563" border="1" align="center">
                <tr>
                    <th colspan="2">
                        Fuentes de Financiamiento
                    </th>
                </tr>
                <tr>
                    <th>
                        Codigo
                    </th>
                    <th>
                        Descripcion
                    </th>
                </tr>
                <c:forEach var="fu" items="${fuentesusuario}">
                    <tr>
                        <td>
                            <c:out value="${fu.codfueneco}"/>
                        </td>
                        <td>
                            <c:out value="${fu.descripcion}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <table width="563" border="1" align="center">
            <tr>
                <td><div align="center"><b>REPORTE GENERAL</b><br><b>SALDOS CAJA BANCO</b></div></td>
            </tr>
        </table>

        <div id="content">
            <table width="563" border="1" align="center">
                <%int fil=1;%>
                <c:forEach var="f" begin="0" end="${fi}">
                    <tr>
                        <c:forEach var="c" begin="1" end="${co}">
                            <!--<td><c:out value="${M[f][c]}"/></td>-->
                            <c:if test="${M[f][0]==2}"><c:if test="${c==1}"><td>&nbsp;</td></c:if>  <c:if test="${c<3}"> <th><c:out value="${M[f][c]}"/></th></c:if> <c:if test="${c>=3}"> <td><c:out value="${M[f][c]}"/></td></c:if></c:if>
                            <c:if test="${M[f][0]==1}">  <c:if test="${c==1}"><td style="height:1px;">&nbsp;</td></c:if> <c:if test="${c<=2}"><td style="height:1px;"><div align="center"><h2 style="height:1px;"><c:out value="${M[f][c]}"/></h2></div></td></c:if> <c:if test="${c>2}"><th style="height:1px;"><div align="center"><c:out value="${M[f][c]}"/></div></th></c:if>    </c:if>
                                    <c:if test="${M[f][0]==3}">
                                        <c:if test="${c==1}"><td><%= fil%><%fil++;%></td></c:if>
                            <c:if test="${c<=2}"> 
                                <td>
                                    <a  href="javascript:popUp('<c:url value="/MostrarTarIngEgr.do">
                                            <c:param name="codtar" value= "${M[f][1]}"/>
                                            <c:param name="descripcion" value="${M[f][2]}"/>
                                        </c:url>')"><c:out value="${M[f][c]}"/>
                                    </a>
                                </td>
                            </c:if>  
                            <c:if test="${c>2}"><td><div align="right"><c:out value="${M[f][c]}"/></div></td></c:if> 
                            </c:if>
                            <c:if test="${M[f][0]==9000}"><c:if test="${c==1}"><td>&nbsp;</td></c:if><c:if test="${c>2}"><th><div align="center"><c:out value="${M[f][c]}"/></div></th></c:if> <c:if test="${c<=2}"><td><c:out value="${M[f][c]}"/></td></c:if></c:if>
                        <c:if test="${M[f][0]==9001}"><c:if test="${c==1}"><td>&nbsp;</td></c:if><td  <c:if test="${c==co}">style="background-color: #444444; color: #F5FAFE" </c:if>><div align="right"><h3><c:out value="${M[f][c]}"/></h3></div></td> </c:if>
                                </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

