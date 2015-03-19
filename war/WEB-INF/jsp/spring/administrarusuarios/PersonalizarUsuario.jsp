<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<%@ include file="../Cabecera.jsp" %>
<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>ADMINISTRAR USUARIOS</th>
</table>

<script>
var navegador;
var key;
function msieversion() {
    var ua = window.navigator.userAgent
    var msie = ua.indexOf( "MSIE " )
    
    if ( msie > 0 )      // If Internet Explorer, return version number
        return parseInt(ua.substring(msie+5, ua.indexOf(".", msie )))
    else                 // If another browser, return 0
        return 0
        
}

function AjaxHttp() {
    navegador = msieversion();
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();		
    }
    else if(window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;    
}

function verUsuario(user) {
      var id_usuario = user;
      if (user.length  <= 3) { 
        document.getElementById('boxerror').value = 'error';      
        document.getElementById('boxok').value = '';      
        return; 
      } 
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();
      
      req.open('GET','<c:url value="/verusuario.do"/>?id_usuario='+id_usuario, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseXML.getElementsByTagName('respuesta')[0].childNodes[0].nodeValue;
		   if (mes == "1") {
		      document.getElementById('usermsg').innerHTML = '<font style="color:RED"><img src="./icon_error.gif"> La cuenta con este <b>ID</b> ya esta siendo usada, intente con otro por favor.</font>';
                      document.getElementById('boxerror').value = 'error';
                      document.getElementById('boxok').value = '';
		   }
		   else {
		      document.getElementById('usermsg').innerHTML = '<font style="color:GREEN"><img src="./icon_success.gif"> Este <b>ID</b> es correcto y esta disponible para su uso.</font>';		   
                      document.getElementById('boxerror').value = '';
                      document.getElementById('boxok').value = 'ok';
		      document.getElementById('msgError').style.display = 'none';
		   }
                }
           }                   
        };
        req.send(null);     
}

function setViewPass() {
 if (document.getElementById('ckbPass').checked) {
   document.getElementById('clave').type = 'text'; 
   document.getElementById('clave2').type = 'text'; 
 } else {
   document.getElementById('clave').type = 'password';  
   document.getElementById('clave2').type = 'password';  
 }  
}

function showPerInfo() {
   document.getElementById('moreperinfo').style.display = 'inline';
}

function verIdDisponible() {
  if (document.getElementById('id_usuario').value.length > 3) {
     verUsuario(document.getElementById('id_usuario').value);
  }
  else {
     document.getElementById('usermsg').innerHTML = '';  
     document.getElementById('boxerror').value = 'error';
     document.getElementById('boxok').value = '';
  }     
}

function verClave() {
 if (document.getElementById('clave').value != document.getElementById('clave2').value)
   return false;
 else 
   return true;          
}

function verificarClave() {
  if (document.getElementById('clave').value.length == 0) {
    document.getElementById('boxerror').value = 'error';
    return;
  }    
  if(!verClave()) {
     document.getElementById('passwordmsg').innerHTML = '<font style="color:RED"><img src="./icon_error.gif"> La clave debe repetirse exactamente en abmos cuadros. <b>Clave no es igual</b>';
     document.getElementById('boxerror').value = 'error';
  }
  else {
     document.getElementById('passwordmsg').innerHTML = '';
     document.getElementById('boxerror').value = '';
     document.getElementById('msgError').style.display = 'none';     
     clearInterval(key);
  }     
}

function verifyKey() {
  document.getElementById('rowVerifyField').style.visibility = 'visible';
  key = setInterval('verificarClave()',1000);
}

function verForm() {
  verUsuario(document.getElementById('id_usuario').value);
  verificarClave();

  if (document.getElementById('id_usuario').value.length == 0)
    return false;
  if (document.getElementById('clave').value.length == 0)
    return false;      
  if (document.getElementById('boxerror').value.length != 0)
    return false;      
  if (document.getElementById('boxok').value.length == 0)
    return false;      
  return true;    
}

function sendForm() {
  if(verForm())
     document.getElementById('nuevacuenta').submit();
  else
    //alert('error');     
    document.getElementById('msgError').style.display = 'inline';
}

</script>    
<br>
<table border="0" cellspacing="0" cellpaddign="0">
 <tr>
  <td class="normal"><b>DATOS DE LA PERSONA</b></td>
 </tr>
</table>
<p class="normal">La siguiente informaci&oacute;n ser&aacute; asociada a: <b><c:out value="${per.nombres}"/> <c:out value="${per.paterno}"/> <c:out value="${per.materno}"/></b> con
n&uacute;mero de c&eacute;dula: <b><c:out value="${per.dip}"/></b>.  <a href="javascript:showPerInfo()">Mas informaci&oacute;n <b>aqui.</b></a>
</p>
<div id="moreperinfo" style="display:none">
<table border="0" cellspacing="0" cellpaddign="0" width="100%" align="center" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
<td style="padding-top:5px; padding-bottom:5px; padding-left:5px; padding-right:5px">  
 <table border="0" cellspacing="0" cellpaddign="0">
   <tr>        
    <td class="normal"><b>Fecha de Nacimiento:</b></td>
    <td class="normal"><c:out value="${per.fec_nacimiento}"/></td>
    <td class="normal"><b>Sexo:</b></td>
    <td class="normal"><c:out value="${per.sexo}"/></td>
    <td class="normal"><b>Email:</b></td>
    <td class="normal"><c:out value="${per.correo}"/></td>
    <td class="normal"><b>Telfonos:</b></td>
    <td class="normal"><c:out value="${per.telefono}"/></td>
   </tr>    
 </table>
 <div></div>
</td>
</table>
</div>
<table border="0" cellspacing="0" cellpaddign="0">
 <tr>
  <td class="normal"><img src="./images/user.gif"></td>
  <td class="normal"><b>DATOS DE USUARIO</b></td>
 </tr>
</table>
<p class="normal">La suguiente informacion es muy <font color="blue"><b>importante</b></font>, pues permite autorizar a una persona el acceso al sistema mediante un <b>c&oacute;digo</b> y un <b>PIN</b>
complete los datos necesarios en el siguiente formulario para crear la cuenta.
</p>


<form id="nuevacuenta" name="nuevacuenta" action='<c:url value="/determinarusuario.do"/>'>      


<table id="lyId_usuario" border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="background-color:#FDFFEF; border:1px solid #FFE7CE">
<td style="padding-top:30px; padding-bottom:30px; padding-left:30px; padding-right:30px">  
 <table border="0" cellspacing="0" cellpaddign="0">
   <tr>
    <td class="normal" colspan="2">Ingrese un <b>Nuevo ID</b> del usuario, el <b>sistema</b> verificara la disponibilidad del mismo.<br> El ID deber&aacute; ser de 4 o mas caracteres</td>
   </tr>
   <tr>        
    <td class="normal" style="width:110px"><b>Nuevo ID:</b></td>
    <td class="normal"><input type="text" class="campo" id="id_usuario" style="width:220px" maxlength="32"></td>
   </tr>    
   <tr>
    <td class="normal"></td>
    <td class="normal"><div id="usermsg"></div></td>
   </tr>
 </table> 
</td>
</table>
<br>
<table id="lyClave" border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="background-color:#FDFFEF; border:1px solid #FFE7CE">
<td style="padding-top:30px; padding-bottom:30px; padding-left:30px; padding-right:30px">  
 <table border="0" cellspacing="0" cellpaddign="0">
   <tr>
    <td class="normal" colspan="2">Ingrese la <b>Clave</b> del usuario, este parametro permitite la autentificaci&oacute;n del usuario en el <b>sistema</b>.<br></td>
   </tr>
   <tr>        
    <td class="normal" style="width:110px"><b>Clave/Password:</b></td>
    <td class="normal"><input type="password" class="campo" id="clave" style="width:220px" maxlength="16" onblur="verifyKey()">
    <input id="ckbPass" type="checkbox" onclick="setViewPass()">Mostrar (Firefox)</td>
   </tr>    
   <tr id="rowVerifyField" style="visibility:hidden">        
    <td class="normal">Repetir la Clave</td>
    <td class="normal"><input type="password" class="campo" id="clave2" style="width:220px" maxlength="16" onblur="verifyKey()">
   </tr>    
   <tr>
    <td class="normal"></td>
    <td class="normal"><div id="passwordmsg"></div></td>
   </tr>
 </table>
 <div></div>
</td>
</table>
<br><!-- La siguiente lista es estatica, sin embargo se puede desarrollar una lista dinamica via BD base de datos 
         Programa de Cedulacion Gratuita (_ston castillo Valencia)-->
<table id="lyRoles" border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="background-color:#FDFFEF; border:1px solid #FFE7CE">
<td style="padding-top:30px; padding-bottom:30px; padding-left:30px; padding-right:30px">  
 <table border="0" cellspacing="0" cellpaddign="0">
   <tr>
    <td class="normal" colspan="2">Seleccione de la siguieente lista los <b>Roles</b> del usuario, el usuario tendra acceso a las funcionalidades de cada rol del <b>sistema</b> seleccionado<br></td>
   </tr>
   <tr>        
    <td class="normal" style="width:110px"><b>Seleccione los Roles:</b></td>
    <td class="normal">
       <table border="0" cellspacing="0" cellpaddign="0">
         <tr>
	  <td class="normal"><input name="roles" type="checkbox"> Administrador
         </tr> 
         <tr>
	  <td class="normal"><input name="roles" type="checkbox"> Funcionario Trascriptor
         </tr> 
         <tr>
	  <td class="normal"><input name="roles" type="checkbox"> Funcionario Verificador
         </tr> 
       </table>	 
    </td>
   </tr>    
 </table>
 <div></div>
</td>
</table>
<br>
<div id="msgError" style="display:none">
<table border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="background-color:#FDFFEF; border:1px solid RED">
<td style="padding-top:3px; padding-bottom:3px; padding-left:30px; padding-right:30px">  
 <table border="0" cellspacing="0" cellpaddign="0">
   <tr>
    <td class="normal" align="center">Se han encontrado <b>errores</b> en el formulario, por favor revise los datos introducido e intente guardar nuevamenete.</td>
   </tr>
 </table>
</td>
</table>
<br>
</div>

   <table border="0" cellspacing="0" cellpaddign="0" align="center">
    <tr>	    
      <td colspan="2" align="center" class="normal">
      <input type="hidden" name="id_persona" value='<c:out value="${per.id_persona}"/>'>
      <input type="hidden" id="boxerror" value="error">
      <input type="hidden" id="boxok" value="">
      <input class="button" type="button" value="Guardar el formulario" style="font-weight:bold" onclick='sendForm()'>
      </td>
    </tr>
   </table>       

</form>

<script>
function noUser() {
  document.getElementById('nouser').style.display = 'inline';
}
setInterval('verIdDisponible()',5000);
</script>

<%@ include file="../VerPieCuerpo.jsp" %>
