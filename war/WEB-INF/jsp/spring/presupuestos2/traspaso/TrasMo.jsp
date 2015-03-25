<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function()
            {
                $("tr>td").click(function(){
                    $(location).attr("href",$(this).find("a").attr("href"));
                })
                $("tr>td").parent("tr").mouseenter(function ()
                {
                    $(this).find("td").css("background","#092B86");
                    $(this).find("td").css("color","#ffffff");
                    $(this).find("td").find("a").css("color","#ffffff");
                    $(this).css("cursor","pointer");
                    
                });
                $("tr>td").parent("tr").mouseleave(function ()
                {
                    $(this).find("td").removeAttr("style");
                    $(this).find("td").find("a").removeAttr("style");
                    
                });
                $("table").width(1000);
            });
        </script>
    </head>
    <body>
        <div id="content" align="center">
            <h1>Traspasos de Montos Egreso:</h1>
            <br>
            <h2>Fuente Económica:&nbsp;&nbsp;&nbsp;<c:out value="${codfueneco}"/> - <c:out value="${fe.descripcion}"/></h2>
            <br>
            <table>
                <c:forEach var="g" items="${pat}">
                    <c:if test="${g.tipo == '1'}">
                        <tr>
                            <th colspan="2"><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></th>
                        </tr>
                    </c:if>
                    <c:if test="${g.tipo == '2'}">
                        <tr>
                            <th colspan="2"><c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></th>
                        </tr>
                    </c:if>
                    <c:if test="${g.tipo == '3'}">
                        <tr>
                            <td>
                                <a href="javascript:popUp('<c:url value="/TrasMo2.do">            
                                                            <c:param name="codtar" value="${g.codigo}"/>
                                                            <c:param name="descripcion" value="${g.descripcion}"/>
                                                            <c:param name="codfueneco" value="${codfueneco}"/>
                                                            </c:url>')">
                                                            <c:out value="${g.codigo}"/> 
                                </a>
                            </td>
                            <td>
                                <a href="javascript:popUp('<c:url value="/TrasMo2.do">            
                                                            <c:param name="codtar" value="${g.codigo}"/>
                                                            <c:param name="descripcion" value="${g.descripcion}"/>
                                                            <c:param name="codfueneco" value="${codfueneco}"/>
                                                            </c:url>')">
                                                            <c:out value="${g.descripcion}"/> 
                                </a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach> 
            </table>
        </div>        
    </body>
</html>
