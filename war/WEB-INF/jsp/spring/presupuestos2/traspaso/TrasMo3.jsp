<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <title>traspasar</title>
       
    </head>
    <body>
<div id="container">
<div id="content">
        <form name="form1" method="post" action="  ">
            <table width="523" align="center">
                <tr>
                    <th colspan="2" ><div align="center">Traspaso de Montos</div></th>
                </tr>
                <tr>
                    <th width="238" >Actividad <c:out value="${actividad.descripcion}"/> </th>
                    <th width="269" >Tarea <c:out value="${tarea.descripcion}"/> </th>
                </tr>
            </table>

            
            <br>
            <table width="523" align="center">
                <tr>
                    <th colspan="3" ><div align="center">Elija cuenta a traspasar monto </div></th>
                </tr>
                <tr>
                    <th width="238" >Clasificador</th>
                    <th width="269" >Fuente Economica </th>
                    <th width="269" >Monto presupuestado </th>
                </tr>
                <tr >
                    <td><c:out value="${codmoning}"/> - <c:out value="${descla}"/></td>
                    <td><c:out value="${codfueneco}"/> - <c:out value="${desfe}"/></td>
                    <td><div align="right"><c:out value="${monto}"/></div></td>
                </tr>
            </table>
            
            
            <table width="842" align="center">
                <tr>
                    <th width="262"> &nbsp;</th>
                    <th width="134" >Fuente Econ&oacute;mica </th>
                    
                    <th width="127">Presupuestado</th>
                    <th width="121">Ejecutado</th>
                    <th width="50">VER</th>
                    <th width="108">Saldo</th>
                    <th width="108">Traspasar monto</th>
                </tr>
                <c:forEach var="mo" items="${mosmoneje}">  
                    <c:if test="${mo.codtar==tarea.codtar }">
                      <c:if test="${mo.codfueneco==codfueneco}">
                      <c:if test="${mo.codmoning!=codmoning}">
                        <tr>
                            <td><c:out value="${mo.codmoning}"/> - <c:out value="${mo.descla}"/></td>
                            <td><c:out value="${mo.codfueneco}"/> - <c:out value="${mo.desfe}"/></td>
                            <td><div align="right"><c:out value="${mo.monto}"/></div></td>
                            <td><div align="right"><c:out value="${mo.moneje}"/></div></td>
                            <td>   
                                <a href=<c:url value="/MostrarEjePresue.do">            
                                       <c:param name="moneje" value="${mo.moneje}"/>
                                       <c:param name="codtar" value="${tarea.codtar}"/>
                                       <c:param name="codacti" value="${actividad.codacti}"/>
                                       <c:param name="codfueneco" value="${mo.codfueneco}"/>
                                       <c:param name="desfe" value="${mo.desfe}"/>
                                       <c:param name="codmoning" value="${mo.codmoning}"/>
                                       <c:param name="descla" value="${mo.descla}"/>
                                   </c:url>> His. Ejecutado</a>
                                
                            </td>
                            <td><div align="right"><c:out value="${mo.saldo}"/> </div></td>
                            <td>
                                <a href=<c:url value="/TrasMo4.do">            
                                       <c:param name="monto2" value="${mo.monto}"/>
                                       <c:param name="codtar" value="${tarea.codtar}"/>
                                       <c:param name="codacti" value="${actividad.codacti}"/>
                                       <c:param name="codfueneco2" value="${mo.codfueneco}"/>
                                       <c:param name="desfe2" value="${mo.desfe}"/>
                                       <c:param name="codmoning2" value="${mo.codmoning}"/>
                                       <c:param name="descla2" value="${mo.descla}"/>
                                       <c:param name="ref2" value="${mo.ref123}"/>
                                       
                                       <c:param name="descla" value="${descla}"/>
                                       <c:param name="codmoning" value="${codmoning}"/>
                                       <c:param name="codfueneco" value="${codfueneco}"/>
                                       <c:param name="desfe" value="${desfe}"/>
                                       <c:param name="monto" value="${monto}"/>
                                       <c:param name="ref1" value="${ref1}"/>
                                       
                                       
                                       
                                   </c:url>><div align="right">Recibe Monto</div></a>
                                
                                
                                
                                
                            </td>
                        </tr>
                          </c:if>
                        </c:if>
                    </c:if>              
                </c:forEach>     
                
                
            
                <tr >
                    <th colspan="6" >Montos No Presupuestados  </th>
                </tr>
                
                             
                <c:forEach var="moo" items="${mos}">  
                    
                   
                    <c:if test="${moo.codtar==tarea.codtar }">
                         <c:if test="${moo.codfueneco==codfueneco}">
                        <tr>
                            <td><c:out value="${moo.codmonnopreegr}"/> - <c:out value="${moo.descla}"/></td>
                            <td><c:out value="${moo.codfueneco}"/></td>
                            <td>&nbsp;</td>
                            <td><div align="right"><c:out value="${moo.monejenopre}"/></div></td>
                            <td>                
                                <a href=<c:url value="/MostrarEjeNoPresue.do">            
                                       <c:param name="monejenopre" value="${moo.monejenopre}"/>
                                       <c:param name="codtar" value="${tarea.codtar}"/>
                                       <c:param name="codacti" value="${actividad.codacti}"/>
                                       <c:param name="codfueneco" value="${moo.codfueneco}"/>
                                       <c:param name="codmonnopreegr" value="${moo.codmonnopreegr}"/>
                                       <c:param name="descla" value="${moo.descla}"/>
                                   </c:url>>His. Ejecutado </a>
                                
                            </td>
                            <td><div align="right">&nbsp;</div></td>
                        </tr>
                        </c:if> 
                    </c:if>              
                </c:forEach> 
             
            
                <tr>
                    <th>TOTALES </th>
                    <td> &nbsp; </td>
                    <td><div align="right">[<c:out value="${too}"/>]</div></td>
                    <td><div align="right">[<c:out value="${too3}"/>]</div></td>
                    <td>&nbsp;</td>
                    <td><div align="right">[<c:out value="${too1}"/>]</div></td>
                </tr>
               
            </table>
            
            
            <input type=hidden name=codacti value='<c:out value="${codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${codtar}"/>'>
             <input type=hidden name=codfueneco value='<c:out value="${codfueneco}"/>'>
                        
            
            
        </form>
        
    </div></div>
       
    </body>
</html>