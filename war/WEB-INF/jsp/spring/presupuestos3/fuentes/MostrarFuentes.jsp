<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fuentes Economicas</title>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="tablecloth/tablecloth.js"></script>
        <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
         <script type="text/javascript">
            $(document).ready(function()
            {
                $("tr>td").parent("tr").click(function()
                {
                       $(location).attr("href",$(this).find("td").find("a").attr("href"));
                       
                });
                $("tr>td").parent("tr").mouseenter(function ()
                {
                    $(this).find("td").css("background","#092B86");
                    $(this).find("td").find("a").css("color","#ffffff");
                    $(this).css("cursor","pointer");
                });
                $("tr>td").parent("tr").mouseleave(function ()
                {
                    $(this).find("td").removeAttr("style");
                    $(this).find("td").find("a").removeAttr("style");
                });
            });
        </script>
    </head>
    <script type="text/javascript"></script>
    <body>
        <div id="content">
    <h1>Elija Fuente A Consultar </h1>
    <table>
        <tr><th>C&oacute;digo</th><th>Descripci&oacute;n</th></tr>
        <c:forEach var="g" items="${fuente}">
            <tr title="Clic para ver el informe general en base a la fuente de ingreso <c:out value="${g.codfueneco}"/> - <c:out value="${g.descripcion}"/>">

                    <td> <a href=<c:url value="/GralFuen2.do"><c:param name="codfueneco" value="${g.codfueneco}"/><c:param name="descripcion" value="${g.descripcion}"/></c:url>> <c:out value="${g.codfueneco}"/></a></td>
                    <td> <a href=<c:url value="/GralFuen2.do"><c:param name="codfueneco" value="${g.codfueneco}"/><c:param name="descripcion" value="${g.descripcion}"/></c:url>> <c:out value="${g.descripcion}"/></a></td>
                </tr>
        </c:forEach> 
    </table>
    </div>
    </body>
</html>
