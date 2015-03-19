<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <style type="text/css">
<!--
.Estilo13 {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px; font-weight: bold; }
-->
        </style>
    </head>
    <body>
        
        <h1 align="center">Datos Insertados a Montos<br>
          Comprometidos<br> 
        </h1>
        
        
    <c:forEach var="g" begin="0"   end="${f}">
          <table width="871" border="1" align="center" bordercolor="#CC9933">
          <!-- Elige la tarea para mostrala -->
         
          <!--  funciona   -->
         
            <tr bgcolor="#CBC196">
            <td width="123"><span class="Estilo13">Partida</span></td>
            <td width="136" ><span class="Estilo13"> Fuente Econ&oacute;mica </span></td>
            <td width="155"><span class="Estilo13">&nbsp;Monto Comprometido
                  <!---Ultimo # de comprobante-->
            </span></td>
            <td width="311"><span class="Estilo13"> Glosa
                  <!--monto insertando -->
            </span></td>
            <td width="112"><span class="Estilo13">Observaciones</span></td>
          </tr>
          <tr>
            <td><c:out value="${M[g][0]}"/></td>
            <td><c:out value="${M[g][1]}"/></td>
            <td><div align="center"><c:out value="${M[g][2]}"/> </div>                </td>
            <td><div align="center"><c:out value="${M[g][3]}"/>              </div>                </td>
            <td><div align="right"><c:out value="${M[g][5]}"/></div></td>
          </tr>
          <tr>
            <td colspan="4" rowspan="2" bgcolor="#CCCCCC">
              <div align="center"> </div>
              <div align="center"> </div></td>
            <td bgcolor="#CBC196"><span class="Estilo13">Fecha</span></td>
          </tr>
          <tr>
            <td><div align="center"><c:out value="${M[g][4]}"/></div></td>
          </tr>
          <tr bordercolor="#666666" bgcolor="#666666">
            <td height="19" colspan="6">&nbsp; </td>
          </tr>
         
        </table>
       
              
    </c:forEach> 
        
       
    </body>
</html>
