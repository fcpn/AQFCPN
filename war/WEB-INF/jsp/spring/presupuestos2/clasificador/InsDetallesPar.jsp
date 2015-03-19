
<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
    </head>
    <body>

        <h1>Descripciones a partidas EGRESOS  </h1>
        <c:forEach var="g" items="${partida}">

            <c:if test="${g.tipo == '1'}">

               <br><br><br>
               <font color="#BF0039"> <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></font>....... [<a  href="javascript:popUp('<c:url value="/InsDetallesPar2.do">
                       <c:param name="codpar" value="${g.codigo}"/> <c:param name="codpar" value="${g.tipo}"/>
                       </c:url>')"> <font color="BF0039" size="2"><em><strong>Ins. Descripci&oacute;n</strong></em></font> </a>]...[<a  href="javascript:popUp('<c:url value="/InsDetallesPar4.do">
                       <c:param name="codpar" value="${g.codigo}"/> <c:param name="tipo" value="${g.tipo}"/>
                       </c:url>')"> <font color="009933" size="2"><em><strong>Modificar Descripciones Ins.</strong></em></font> </a>]<br>
        </c:if>
             <c:if test="${g.tipo == '2'}">
                &nbsp;&nbsp;&nbsp;&nbsp;
               <font  color="#04047B"> <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/></font>....... [<a  href="javascript:popUp('<c:url value="/InsDetallesPar2.do">
                       <c:param name="codpar" value="${g.codigo}"/>
                       </c:url>')"> <font color="BF0039" size="2"><em><strong>Ins. Descripci&oacute;n</strong></em></font> </a>]...[<a  href="javascript:popUp('<c:url value="/InsDetallesPar4.do">
                       <c:param name="codpar" value="${g.codigo}"/> <c:param name="tipo" value="${g.tipo}"/>
                       </c:url>')"> <font color="009933" size="2"><em><strong>Modificar Descripciones Ins.</strong></em></font> </a>]<br>
        </c:if>
              <c:if test="${g.tipo == '3'}">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <c:out value="${g.codigo}"/> - <c:out value="${g.descripcion}"/>....... [<a  href="javascript:popUp('<c:url value="/InsDetallesPar2.do">
                       <c:param name="codpar" value="${g.codigo}"/>
                       </c:url>')"> <font color="BF0039" size="2"><em><strong>Ins. Descripci&oacute;n</strong></em></font> </a>]...[<a  href="javascript:popUp('<c:url value="/InsDetallesPar4.do">
                       <c:param name="codpar" value="${g.codigo}"/> <c:param name="tipo" value="${g.tipo}"/>
                       </c:url>')"> <font color="009933" size="2"><em><strong>Modificar Descripciones Ins.</strong></em></font> </a>]<br>
              </c:if>

        </c:forEach>




<!--

<a  href="javascript:popUp('<c:url value="/InsDetallesPar2.do">
                       <c:param name="codpar" value="${g.codigo}"/>
                       </c:url>')"> <font color="BF0039" size="2"><em><strong>Ins. Descripci&oacute;n</strong></em></font> </a>

-->










    </body>
</html>