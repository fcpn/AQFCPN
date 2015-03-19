<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
    <head>
        <script type="text/javascript" src="prototype.js"></script>
        <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    </head>
    <style type="text/css">
        #cargando {
            position: absolute;
            width: 100%;
            height: 100%;
            background: #fff url(images/gifloadPdf.gif) no-repeat center;
        }
        #cuerpo{
            width: 100%;
        }
    </style>
    <script language="javascript" type="text/javascript">
        $(window).load(function() {
            $('#cargando').hide();
        });
    </script> 
    <body>
        <div id="cargando">Cargando...</div>
        <div id="cuerpo">
            <iframe src="pdf/<c:out value="${namefile}"/>" frameborder="0" style="width:100%;height:100%"></iframe>
        </div>
    </body>
</html>