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
        <div id="container">
            <div id="content">
                <table width="563" border="1" align="center">
                    <tr>
                        <th colspan="2">

                        </th>
                    </tr>
                    <tr>
                        <td>
                            <div align="center">
                                <a class="myButton" id="espn" href="javascript:popUp('<c:url value="/reporteZucListaGeneralesPdf.do"></c:url>')">
                                    Saldos Caja y Banco (Real) Pdf.
                                </a></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div align="center"><a href="#" class="myButton" id="espn">Saldos Caja y Banco (Mas comprometido) Pdf.</a></div>
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2">

                        </th>
                    </tr>
                </table>
            </div>
        </div>


    </body>
</html>

