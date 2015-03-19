<%@ include file="../Cabecera.jsp" %>
<script language='JavaScript' SRC="./validar.js"></script>
<script type="text/javascript">
var getURL = document.URL
info = true;
function EscribirValor() {
  document.forma.url.value=innerHTML=getURL
}
function showPassInfo() {
 if (info) {
  document.getElementById('passinfo').style.display = 'inline';
  info = false;
 }
 else {
  document.getElementById('passinfo').style.display = 'none';
  info = true;
 } 
}
function setLogin() {
  var id_usuario = document.getElementById('id_usuario').value;
  var clave = document.getElementById('clave').value;
  if (id_usuario.length == 0) {
    document.getElementById('error').style.display = 'inline';
    document.getElementById('id_usuario').focus();
    return false;
  }  
  else
    document.getElementById('error').style.display = 'none';
  if (clave.length == 0) {
    document.getElementById('error').style.display = 'inline';
    document.getElementById('clave').focus();
    return false;
  }  
  else
    document.getElementById('error').style.display = 'none';    
  return true;  
}
function sendForm(w) {
  if(w) 
    document.getElementById('forma').submit();    
  else
  return w;
}

</script>

<c:if test="${empty id_rol}">
    <form id="forma" name=forma action="<c:url value="/login1.do"/>" method="POST" onsubmit="return sendForm(setLogin())">        
        <table width="90%" border="0" cellspacing="0" cellpaddign="0" align="center">
            <tr>
                <td class=colh style="padding-left:5px; padding-top:2px; padding-bottom:2px; border:1px solid #0F3950">INGRESO</td>
            </tr>
            <tr>
                <td align=center class=colb style="padding-top:10px; padding-bottom:10px">
                    <table>
                        <tr>
                            <td align=right class=normal>Usuario:</td>
                            <td><input id='id_usuario' class="campo" type=text name="id_usuario" size="10" onblur='validar(id_usuario,"A9")'/> </td>
                        </tr>
                        <tr>
                            <td align=right class=normal>Clave:</td>
                            <td><input id='clave' class="campo" type="password" name="clave" size="10" onfocus="showPassInfo()" onblur="showPassInfo()" accept="alert(´hi´)"/> </td>
                        </tr>
                        
                    </table>
            </td></tr>   
            <tr>                        
                <td colspan=2 align=center>
                    <input class="button" type="submit" value="Entrar">
                </td>
            </tr>             
            <tr>
                <td id="error" class="normal" style="color:RED; display:none"><b>Debe completar los Datos</b></td>
            </tr>
            <input type=hidden name=url value="">
        </table>
    </form>
    <div id="passinfo" style="display:none">
        <table><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify">La <b>clave</b> es un elemento muy importante para la seguridad de su cuenta, es confidencial.  El <b>sistema</b> le permitira cambiar la misma en cualquier momento. </td>
                        </tr>
                    </table>      
            </td></tr>
        </table>
    </div>    
    <br>
  
</c:if>
<script>
document.getElementById('id_usuario').focus();
</script>
<%@ include file="../VerPieCuerpo.jsp" %>