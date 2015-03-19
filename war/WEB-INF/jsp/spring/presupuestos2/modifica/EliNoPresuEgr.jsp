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
                 <th height="30" colspan="4"><div align="center">Egresos</div></th>
             </tr>
                                                        <tr>
                                                            <th width="139"><div align="left">C&oacute;digo Partida </div></th>
                                                        <td colspan="3"><div align="left">
                                                                <c:out value="${mi.codmonnopreegr}"/>

                                                            </div></td>
                                                        </tr>
                                                        <tr>
                                                            <th><div align="left">Fuente Economica</div></th>
                                                            <td colspan="3"><div align="left">
                                                                    <c:out value="${mi.codfueneco}"/>

                                                            </div></td>
                                                        </tr>



                                                       <tr>
                                                            <th><div align="left">Ejecutado</div></th>
                                                            <td colspan="3"><div align="left"><c:out value="${mi.monejenopre}"/>
                                                            </div></td>
                                                        </tr>


                                                        <tr>
                           <td colspan="4"><div align="right">
                                   <a  href="<c:url value="/ModClasificador1e.do">
                       <c:param name="codtar" value="${codtar}"/>
                       <c:param name="codacti" value="${codacti}"/>

                   </c:url>">Modificar Egresos </a>


                                    </div></td>

                                                        </tr>
                                                        <tr>
                                                            <td colspan="4">Para Eliminar la Partida no debe tener ejecuciones</td>

                                                        </tr>

                                                        <tr>
                                                            <td colspan="4">Si el campo ejecutado esta vacio se borro correctamente el registro</td>

                                                        </tr>
                                                </table>

                                                            <input name="codpro" type="hidden" value="<c:out value="${g.codpro}"/>">

    </form>
</div></div>
    </body>
</html>