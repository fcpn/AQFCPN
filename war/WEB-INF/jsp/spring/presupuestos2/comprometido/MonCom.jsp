<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <style>
            #men
            {
                position: absolute;
                //display:none;
                font-family:Arial;
                font-size:0.8em;
                width:280px;
                background-color:#f1f1f1;
                padding:5px;
            }
        </style>
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
        <script>
            $(document).ready(function(){
                $("#men").slideUp(0);
                $("#men").css("border","solid");
                $("#content>table").find("tr>td").click(function(e){
                    var y=e.pageY;
                    if($("body").height()-350<y)
                    {
                        y=$("body").height()-350;
                    }
                    var k=$(this).parent("tr").children(1).find("a").html().trim();
                    $("#men").css({left:e.pageX, top:y});
                    $("#tit").html("Men&uacute "+$(this).parent("tr").find("td").last().find("a").html());
                    $("#el1").attr("href","/aquiles/InformeEgrCom.do?codtar="+k+"&codacti="+k.split("-")[0]+"");
                    $("#el2").attr("href","/aquiles/ActuCom.do?codtar="+k+"&codacti="+k.split("-")[0]+"");
                    $("#el3").attr("href","/aquiles/EjecuCompro.do?codtar="+k+"&codacti="+k.split("-")[0]+"");
                    $("#el4").attr("href","/aquiles/ModMonCompro.do?codtar="+k+"&codacti="+k.split("-")[0]+"");
                    $("#el5").attr("href","/aquiles/nrocert.do?codtar="+k+"&codacti="+k.split("-")[0]+"");
                    $("#el6").attr("href","/aquiles/fechacert.do?codtar="+k+"&codacti="+k.split("-")[0]+"");
                    $("#el7").attr("href","/aquiles/EliMonComEgr.do?codtar="+k+"&codacti="+k.split("-")[0]+"");
                    $("#el8").attr("href","/aquiles/EliMonComEgrAcu.do?codtar="+k+"&codacti="+k.split("-")[0]+"");
                    $("#men").slideDown("slow");
                    
                });
                $("tr>td").parent("tr").mouseenter(function ()
                {   
                    $(this).find("td").css("background","#092B86");
                    $(this).find("td").css("color","#ffffff");
                    $(this).find("td").find("a").css("color","#ffffff");
                    $(this).css("cursor","pointer");
                });
                $("#content>table").find("tr").mouseenter(function(){
                    $("#men").slideUp("fast");
                });
                $("tr>td").parent("tr").mouseleave(function ()
                {
                    $(this).find("td").removeAttr("style");
                    $(this).find("td").find("a").removeAttr("style");
                   
                });
                $("a").click(function(e){
                    e.preventDefault();
                });
                $("#men>table").find("tr").find("td").click(function(){
                    
                    popUp($(this).find("a").attr("href"));
                    $("#men").slideUp("slow");
                    //document.getElementById($(this).find("a").attr("id")).click();
                    //$(location).attr("href",$("this").find("a").attr("href"));
                });
            });
        </script>
    </head>
    <body>
        
            <div id="content">
        <div id="men">    <table>
                <tr><th id="tit"></th></tr>
                <tr><th>Nuevo</th></tr>
                <tr><td><a id="el1">Nuevo Monto Comprometido</a></td></tr>
                <tr><td><a id="el2">Acumular Monto Comprometido</a></td></tr>
                <tr><td><a id="el3">Ejecutar Comprometido</a></td></tr>
                <tr><td><a id="el4">Modificar Montos Comprometidos</a></td></tr>
                <tr><th>Certificaci&oacute;n Presupuestaria</th></tr>
                <tr><td><a id="el5">Nro. Certificaci&oacute;n</a></td></tr>
                <tr><td><a id="el6">Fecha</a></td></tr>
                <tr><th>Anulaciones</th></tr>
                <tr><td><a id="el7">Anular Monto Comprometido con su Historial</a></td></tr>
                <tr><td><a id="el8">Eliminar Comprometido Acumulado</a></td></tr>
            </table>
            </div>
        </div>
        
        
        
    <div id="content">    
        <h1>Programas Actividades y Tareas</h1>
        
        <table>    
            <c:forEach var="g" items="${pat}">
                <c:if test="${g.tipo == '1'}">
                    <tr>
                        <th colspan="2">
                            <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/>
                        </th>
                    </tr>
                </c:if>
             <c:if test="${g.tipo == '2'}">
                <tr>
                    <th colspan="2">
                        <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/>
                    </th>
                </tr>
                <tr>
                    <th>C&oacute;digo</th>
                    <th>Descripci&oacute;n</th>
                </tr>
              </c:if>
              <c:if test="${g.tipo == '3'}">
                  <tr title="Clic para ver el men&uacute; de la tarea <c:out value="${g.descripcion}"/>">
                    <td>
                        <a  href="javascript:popUp('<c:url value="/MenuCom.do">             
                        <c:param name="codtar" value="${g.codigo}"/>
                        <c:param name="descripcion" value="${g.descripcion}"/>
                         </c:url>')">
                        <c:out value="${g.codigo}"/> </a>
                    </td>
                    <td>
                        <a  href="javascript:popUp('<c:url value="/MenuCom.do">             
                        <c:param name="codtar" value="${g.codigo}"/>
                        <c:param name="descripcion" value="${g.descripcion}"/>
                        </c:url>')">
                        <c:out value="${g.descripcion}"/> </a>
                        
                    </td>
                </tr>
              </c:if>
            </c:forEach> 
        </table>
    </div>
        
    </body>
</html>
