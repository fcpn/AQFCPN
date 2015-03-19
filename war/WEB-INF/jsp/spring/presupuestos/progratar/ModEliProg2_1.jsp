<%@ include file="../../Cabecera.jsp" %>

<html>
    <head>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>Programas</title>

    </head>
    <body>
        <div id="container">
<div id="content">
    <form name="form1" method="post" action="<c:url value="/ModEliProg2_1.do"/>">
       <table width="421" border="0" align="center">
            <tr>
                 <th height="30" colspan="4"><div align="center">Datos Modificados Programa</div></th>
             </tr>
                                                        <tr>
                                                            <th width="139"><div align="left">C&oacute;digo</div></th>
                                                        <td colspan="3"><div align="left">
                                                                <c:out value="${g.codpro}"/>
                                                              
                                                            </div></td>
                                                        </tr>
                                                        <tr>
                                                            <th><div align="left">Descripci&oacute;n de Programa</div></th>
                                                            <td colspan="3"><div align="left">
                                                                    <c:out value="${g.descripcion}"/>
                                                              
                                                            </div></td>
                                                        </tr>

                                                        <tr>
                                                            <th><div align="left">Unidad Ejecutora</div></th>
                                                            <td colspan="3"><div align="left"><c:out value="${g.u_ejecutora}"/>
                                                            </div></td>
                                                        </tr>

                                                        <tr>
                           <td colspan="4"><div align="right">
                               <a  href="<c:url value="/mostrarprogramas.do">

                   </c:url>">Modificar Programas </a>
                                    </div></td>
                                                        
                                                        </tr>


                                                        <tr>
                                                            <td colspan="4">El codigo del programa solo se podra modificar si no tiene dependencia de actividades</td>

                                                        </tr>
                                                </table>

                                                            <input name="codpro" type="hidden" value="<c:out value="${g.codpro}"/>">

    </form>
</div></div>
    </body>
</html>