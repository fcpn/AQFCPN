<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">


<%@ include file="../Cabecera.jsp" %>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>ADMINISTRAR SERVIDORES</th>
</table>
        <table align="center"><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>Aviso:</b> Esta opci&oacute;n registra un servidor de imagenes de tarjetas debidamente instalada y configurada <br>
			    para ser tomada encuenta por el <b>sistema</b>, de acuerdo a las especificaciones de instalacion del <b>modelo</b> </td>			    
                        </tr>
                    </table>      
            </td></tr>
        </table>
<table border="0" cellspacing="0" cellpaddign="0">
<tr><td>
<form name="admin" action='<c:url value="/servidores.do"/>'>      
  <input type="submit" class="button" value="Administrar servidores">
</form>
</td></tr>
</table>
	
<br>	
<form id="frmRegistro" method="POST" action='<c:url value="/servidores.do"/>'>
<table border="0" cellspacing="0" cellpadding="0" align="center">    
  <tr>
    <td class="colh" colspan="2" style="padding-top:3px; padding-bottom:3px">REGISTRO DE SERVIDOR</td>
  </tr> 
  <tr>
    <td class="colhpt">Nombre del Servidor</td>
    <td class="colhpt"><input name="nombre" type="text" class="campo"></td>
  </tr>
  <tr>
    <td class="colhpt">IP</td>
    <td class="colhpt"><input name="ip" type="text" class="campo"></td>
  </tr>
  <tr>
    <td class="colhpt">Puerto</td>
    <td class="colhpt"><input name="puerto" type="text" class="campo" value="5432"></td>
  </tr>
  <tr>
    <td class="colhpt">Usuario</td>
    <td class="colhpt"><input name="user" type="text" class="campo"> (Username of DataBase)</td>
  </tr>
  <tr>
    <td class="colhpt">Password</td>
    <td class="colhpt"><input name="pass" type="password" class="campo"></td>
  </tr>
  <tr>        
    <td class="colhpt" align="center" style="padding-top:4px; padding-bottom:5px">
    <input type="hidden" name="accion" value="guardar">
    <input type="submit" class="button" value="Agregar servidor"></td>   
    <td class="colhpt" style="color:#000000; font-weight:normal">Registra un <b>servidor de imagenes</b> al sistema.</td>
  </tr>
</table>
</form>

<script>
document.getElementById('frmRegistro').nombre.focus();
</script>
<%@ include file="../VerPieCuerpo.jsp" %>


