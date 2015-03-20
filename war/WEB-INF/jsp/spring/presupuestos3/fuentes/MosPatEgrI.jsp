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
                $("tr>td").parent("tr").mouseenter(function ()
                {
                    $(this).find("td").css("background","#092B86");
                    $(this).find("td").css("color","#ffffff");
                    $(this).find("td").find("a").css("color","#ffffff");
                    
                });
                $("tr>td").parent("tr").mouseleave(function ()
                {
                    $(this).find("td").removeAttr("style");
                    $(this).find("td").find("a").removeAttr("style");
                    
                });
                $("tr>td>a").mouseenter(function(){
                    $(this).css("cursor","pointer");
                })
            });
        </script>
    </head>
    <body>


<div id="content">
        <table width="100%">
  <tr>
    <th colspan="4"><div align="center"><br>MEN&Uacute; DE TAREAS </div></th>
  </tr>
  <tr>
      <th>Nro.</th>
      <th>C&oacute;digo</th>
      <th>Descripci&oacute;n</th>
      <th>Fuentes de financiamiento</th>
  </tr>
<%int i=0;%>
<c:forEach var="c" begin="0" end="${tam-1}">
    <tr>
        <td><c:out value="${c+1}" /></td>
    
        <td>
        <c:out value="${v[c][0]}" />
        </td>
        <td>
        <c:out value="${v[c][1]}" />
        </td>
        <td>
            <c:if test="${cnt[c]>0}">
            <c:forEach var="j" begin="0" end="${cnt[c]-1}">
                [ 
                    <a  href="javascript:popUp('<c:url value="/GralFuen3.do">
                        <c:param name="codtar" value="${v[c][0]}"/>
                        <c:param name="codfueneco" value="${v[c][2*j+2]}"/>
                        </c:url>')" title="Ver detalle de la tarea <c:out value="${v[c][1]}"/> en base a la fuente de financiamiento <c:out value="${v[c][2*j+3]}"/>">
                            <c:out value="${v[c][2*j+2]}" />
                    </a>
                
                 ]
            </c:forEach>
            </c:if>
        </td>
    </tr>    
</c:forEach>



    </table>
</div>
    </body>
</html>
