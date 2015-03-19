<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">


<%@ include file="../Cabecera.jsp" %>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>ADMINISTRAR SERVIDORES</th>
</table>
<br>
        <table align="center"><tr><td style="border: 1px solid red">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./icon_error.gif"></td>
                            <td class="normal" align="justify"><b>ERROR:</b> EL sistema ha lanzado una Exepci&oacute;n en una operacion de conexion a una base de datos.<br>
			    comunique este error a un administrador del <b>sistema</b> o de <b>RED</b>.</td>			    
                        </tr>
                    </table>      
            </td></tr>
        </table> 

<form id="frmNuevo" name="frmNuevo" method="POST" action='<c:url value="/servidores.do"/>'>
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td class="normal">
    <input type="submit" class="button" value="Aceptar"><td>   
  </tr>
</table>
</form>
   

<%@ include file="../VerPieCuerpo.jsp" %>


