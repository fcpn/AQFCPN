<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <style type="text/css">
            <!--
.Estilo1 {color: #2A3399}
            -->
        </style>
    </head>
    
    <body>
        <br>
        <br>
        <table width="702" border="1" align="center">
            <tr>
                <td width="650" height="68"><div align="center">
                        <u>Actividad</u> <c:out value="${actividad.descripcion}"/> - <u>Tarea</u> 
                <c:out value="${tarea.descripcion}"/>  </div>    </td>
            </tr>
            
           
        </table>
        <br>
        
        <form name="form1" method="post" action="<c:url value="/Resp.do"/>">
            <table width="317" border="1" align="center">
                <tr>
                    <td width="307" bgcolor="#BAAD74"><div align="center"><h3 class="Estilo1"> Datos Generales </h3> 
                    </div></td>
                </tr>
                <tr>
                    <td height="68"> <div align="center"><br>
                            
                            
                            
                            
                            <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
                            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
                            
                            <input type="submit" name="Submit" value="Insertar Responsable / Participantes">
                            <br>
                            <br> 
                    </div></td>
                </tr>
            </table>
        </form>
        
                   
        </form>
    </body>
</html>
