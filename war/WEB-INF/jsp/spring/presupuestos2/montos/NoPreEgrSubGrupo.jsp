<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>
        
        <style type="text/css">
            <!--
.Estilo1 {color: #003399}
.Estilo3 {color: #003399; font-size: 12px; }
.Estilo4 {font-weight: bold}
            -->
        </style>
    </head>
    
    <body>
        <form name="form1" method="post" action="<c:url value="/NoPreEgrSubGrupo2.do"/>" ">
              <div class="topdentro"> 
                <div align="center"> 
                    <p>&nbsp;</p>
                    <table width="637" height="287" border="3" align="center" >
                        <tr> 
                            <td width="623" > <table width="674" border="0" align="center">
                                    <tr bordercolor="#00FF99">
                                        <td colspan="4"><div align="center" class="Estilo1 Estilo6">
                                                <h3>Nuevo SubGrupo --(Cuentas No Presupuestarias)-- Egresos</h3>
                                        </div></td>
                                    </tr>
                                    <tr>
                                        <td width="257">&nbsp;</td>
                                        <td colspan="2">&nbsp;</td>
                                        <td width="191">&nbsp;</td>
                                    </tr>
                                    <tr bgcolor="#999999">
                                        <td bgcolor="#DFDABD"><span class="Estilo3">Elija <u><strong>Grupo de Cuentas no Presupuestarias</strong></u> para insertar SubGrupo --&gt;</span></td>
                                        <td colspan="3" bgcolor="#DFDABD">
                                            <select name="cod_gnp">
                                                <!--
                                                <option>11000 - Ingresos de operaciones</option>
                                                <option>12000 - Venta de bienes y servicios de las Adm.</option>
                                                <option>13000 - Ingreso por impuesto</option>
                                                <option>14000 - Regalias</option>-->
                                                <c:forEach var="g" items="${grupos}">
                                                    <option value="<c:out value="${g.cod_gnp}"/>"><c:out value="${g.cod_gnp}"/> - <c:out value="${g.descripcion}"/></option>
                                                </c:forEach> 
                                        </select></td>
                                    </tr>
                                    <tr >
                                        <td colspan="4"></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="3">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td colspan="3">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td width="1">&nbsp;</td>
                                        <td width="90"><input type="submit" name="Submit" value="Aceptar"></td>
                                        <td><div align="left">
                                                <input type="reset" name="Submit2" value="cancelar">
                                        </div></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>
                                        <div align="right">                </div></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                        <td>&nbsp;</td>
                                    </tr>
                                                                       
                                    <tr bordercolor="#00FF99" bgcolor="#BAAD74">
                                        <td colspan="4"><div align="center" class="Estilo6 Estilo2 Estilo3 Estilo4">
                                                <div align="center"><span class="Estilo6"><span class="Estilo1"><!--[<a href="insertarcuentasaingresos.do">Atras</a>]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<a href="insertarcuentasaingresos.do">Men&uacute; Rubro</a>]--></span></span></div>
                                        </div></td>
                                    </tr>
                                   
                                </table>            
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>