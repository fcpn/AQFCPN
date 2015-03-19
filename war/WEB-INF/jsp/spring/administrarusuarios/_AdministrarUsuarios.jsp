<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<%@ include file="../Cabecera.jsp" %>
<script language='JavaScript' SRC="./validar.js"> </script>
<script language='JavaScript' SRC="./ajax.js"> </script>
<style type="text/css">
.cerrar A:link    { COLOR: #FFFFFF; TEXT-DECORATION: none }
.cerrar A:visited { COLOR: #FFFFFF; TEXT-DECORATION: none }
.cerrar A:active  { COLOR: #FFFFFF; TEXT-DECORATION: none }
.cerrar A:hover   { COLOR: #FFFFFF; TEXT-DECORATION: none }
.cerrar {
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-size: 10px;
    font-weight: bold;
    color: #FFFFFF;
    text-decoration: none
}
</style>
<script>
function emailCheck (emailStr) {
  var emailPat=/^(.+)@(.+)$/
  var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]"
  var validChars="\[^\\s" + specialChars + "\]"
  var quotedUser="(\"[^\"]*\")"
  var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/

  var atom=validChars + '+' 
  var word="(" + atom + "|" + quotedUser + ")"
  var userPat=new RegExp("^" + word + "(\\." + word + ")*$")
  /* domain, as opposed to ipDomainPat, shown above. */
  var domainPat=new RegExp("^" + atom + "(\\." + atom +")*$")
  
  var matchArray=emailStr.match(emailPat)
  if (matchArray==null) {
    return false
  }
  var user=matchArray[1]
  var domain=matchArray[2]

  // Si el user "user" es valido 
  if (user.match(userPat)==null) {
  // Si no
     return false
  }

  var IPArray=domain.match(ipDomainPat)
  if (IPArray!=null) {
    for (var i=1;i<=4;i++) {
      if (IPArray[i]>255) {
        return false
      }
    }
    return true
  }

  var domainArray=domain.match(domainPat)
  if (domainArray==null) {
    return false
  }

  var atomPat=new RegExp(atom,"g")
  var domArr=domain.match(atomPat)
  var len=domArr.length
  if (domArr[domArr.length-1].length<2 || 
    domArr[domArr.length-1].length>3) {
    return false
  }
  if (len<2) {
    return false
  }

  return true;
}

function getUsuarios() {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();
      
      req.open('GET','<c:url value="/getloginusers.do"/>', true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('users').innerHTML = mes;
                }
           }                   
        };
        req.send(null);    
}
function listaUsuarios() {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();
      
      req.open('GET','<c:url value="/listausuarios.do"/>', true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('usuarios').innerHTML = mes;
                }
           }                   
        };
        req.send(null);    
}

function refreshUsers() {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();      
      req.open('GET','<c:url value="/getloginusers.do"/>?key=refresh',true);      
      req.send(null);    
}

function showusers() {
  listaUsuarios();
  document.getElementById('usuarios').style.display = 'inline';
  document.getElementById('showusers').style.display = 'none';      
  document.getElementById('hideusers').style.display = 'inline';      
}
function hideusers() {
  document.getElementById('usuarios').style.display = 'none';
  document.getElementById('showusers').style.display = 'inline';      
  document.getElementById('hideusers').style.display = 'none';      
}
function adicionarUsuario() {
  document.getElementById('adduser').style.display = 'inline';
}
function salir(win) {
  document.getElementById(win).style.display = 'none'; 
}

function setError(s) {
  if(s) {
    document.getElementById('error').style.display = 'inline'; 
    document.getElementById('error').innerHTML = "<font style='color:RED'><b>Hay errores o faltan datos</b></font>";
    document.getElementById('cerror').style.border = '1px solid RED';
  }
  else {
    document.getElementById('error').style.display = 'none';  
    document.getElementById('cerror').style.border = '1px solid #FFFFFF';
  }    
}

function verUsuario() {
      var id_usuario = document.getElementById('id_usuario').value;
      if (id_usuario.length == 0) return;
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
		   document.getElementById('userstate').value = mes;
		   if (mes == "1") {
		      document.getElementById('usermsg').innerHTML = '<font style="color:RED"><b>Usuario ya existe</b></font>';
		      //document.getElementById('cellmsg').style.border = '#F1C8AC';
		   }
		   else {
		      document.getElementById('usermsg').innerHTML = '<font style="color:GREEN"><b>Correcto</b></font>';		   
		      //document.getElementById('cellmsg').style.background = '#C9EFC4';		   
		   }
                }
           }                   
        };
        req.send(null);     
}

function clearFields() {
   //document.getElementById('registrar').disabled = 'false';
   document.getElementById('registrar').value = 'Registrar';  

   document.getElementById('dip').value = '';
   document.getElementById('paterno').value = '';
   document.getElementById('materno').value = '';
   document.getElementById('nombres').value = '';
   document.getElementById('correo').value = '';
   document.getElementById('telefono').value = '';
   document.getElementById('id_usuario').value = '';
   document.getElementById('clave1').value = '';
   document.getElementById('clave2').value = '';
   document.getElementById('userstate').value = '';
   document.getElementById('dip').focus();

  document.getElementById('usermsg').innerHTML = '';		   
  //document.getElementById('cellmsg').style.background = '#FFFFFF';
  document.getElementById('usermsg').innerHTML = '';
}

function registrarUsuario() {
    
  var dip = document.getElementById('dip').value;
  var paterno = document.getElementById('paterno').value;
  var materno = document.getElementById('materno').value;
  var nombres = document.getElementById('nombres').value;
  var correo = document.getElementById('correo').value;
  var telefono = document.getElementById('telefono').value;
  var id_usuario = document.getElementById('id_usuario').value;
  var clave1 = document.getElementById('clave1').value;
  var clave2 = document.getElementById('clave2').value;
  var userstate = document.getElementById('userstate').value;
  
  if (dip.length == 0) {
    setError(true);
    document.getElementById('dip').style.background = '#F1C8AC';
    document.getElementById('dip').focus();
    return;
  } else {
     document.getElementById('dip').style.background = '#FBFBFB';       
     setError(false);
  }    
  
  if (correo.length != 0) {
    if (!emailCheck(correo)) {
       setError(true);
       document.getElementById('correo').style.background = '#F1C8AC';
       document.getElementById('correo').focus();
       return;
    } else {
       document.getElementById('correo').style.background = '#FBFBFB';       
       setError(false);
      }
  } else {
       document.getElementById('correo').style.background = '#FBFBFB';       
       setError(false);
  }
  
  if (id_usuario.length == 0) {
    setError(true);
    document.getElementById('id_usuario').style.background = '#F1C8AC';
    document.getElementById('id_usuario').focus();
    return;
  } else {
     document.getElementById('id_usuario').style.background = '#FBFBFB';       
     setError(false);
  }
  verUsuario();    
  if (userstate == "1") {
    setError(true);
    document.getElementById('id_usuario').style.background = '#F1C8AC';
    document.getElementById('id_usuario').focus();
    return;
  }
      
      
  if (clave1.length == 0 || clave2.length == 0) {
    setError(true);
    document.getElementById('clave1').style.background = '#F1C8AC';
    document.getElementById('clave2').style.background = '#F1C8AC';
    document.getElementById('clave1').focus();
    return;
  } else {
     document.getElementById('clave1').style.background = '#FBFBFB';       
     document.getElementById('clave2').style.background = '#FBFBFB';       
     setError(false);
  }    
  
  if (clave1 != clave2) {
    setError(true);
    document.getElementById('clave1').style.background = '#F1C8AC';
    document.getElementById('clave2').style.background = '#F1C8AC';    
    document.getElementById('clave1').focus();
    return;
  } else {
     document.getElementById('clave1').style.background = '#FBFBFB';       
     document.getElementById('clave2').style.background = '#FBFBFB';       
     setError(false);
  }     

  //document.getElementById('registrar').disabled = 'true';
  document.getElementById('registrar').value = 'Enviando...';  
  var cargo;
  var id_turno;
  if (document.getElementById('civil').checked)
    cargo = 'Programa';
  else
    cargo = 'Policia';
  if (document.getElementById('manana').checked)
    id_turno = '1';
  else
    id_turno = '2';
        
  
      var url = '<c:url value="/setregistrarusuario.do"/>';
      url = url+'?dip='+dip;
      url = url+'&paterno='+paterno;
      url = url+'&materno='+materno;
      url = url+'&nombres='+nombres;
      url = url+'&correo='+correo;
      url = url+'&telefono='+telefono;
      url = url+'&id_usuario='+id_usuario;
      url = url+'&clave='+clave1;
      url = url+'&cargo='+cargo;
      url = url+'&id_turno='+id_turno;
      
      sendForm(url);
      document.getElementById('error').style.display = 'inline';
      document.getElementById('cerror').style.border = '1px solid GREEN';
      listaUsuarios();
      clearFields();

  return;
}

function sendForm(urlstr) {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();
      req.open('GET',urlstr, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseXML.getElementsByTagName('respuesta')[0].childNodes[0].nodeValue;
		   document.getElementById('error').innerHTML = '<font style="color:GREEN"><b>'+mes+'</b></font>';
                }
           }                   
        };
        req.send(null);        
}

function getModificarUsuario(usuario) {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();
      
      req.open('GET','<c:url value="/getmodificarusuario.do"/>?id_usuario='+usuario, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('usuarios').innerHTML = mes;
                }
           }                   
        };
        req.send(null);     
}

function selectMenu(menu) {
   document.getElementById('').setyle.background = 'yellow';
}


</script>

<%@ include file="../buscar/BuscarPersona.jsp" %>



<table border="0" cellspacing="0" cellpadding="0">
<tr>
  <td valign="top">

        <table><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>Aviso:</b> Esta funci&oacute;n permite crear una cuenta nueva, <br> para el acceso al <b>sistema</b>. mediante autentificaci&oacute;n</td>			    
                        </tr>
                    </table>      
            </td></tr>
        </table>
  <form name="nuevacuenta" action='<c:url value="/administrarPersonas.do"/>'>
    <input type="hidden" name="titulo" value='<c:out value="${titulo}"/>'>
    <input type="hidden" name="salida" value='<c:out value="administrarusuarios/_link"/>'>
    <input class="button" type="submit" value="Nuevo usuario" name="accion">
  </form>
  </td>
<td valign="top">
<table border="0" cellspacing="0" cellpadding="0" style="width:380px">
    <tr>
        <td class=colh align=center>USUARIOS CONECTADOS</td>
    </tr>
</table>    
<p class="normal">Usuarios Conectados <img src="./images/refresh.gif"><a href="javascript:refreshUsers()">Actualizar</a></p>
<div id="users"></div>  
</td>
</tr>
</table>

<br>


<iframe name="frm1" frameborder="0" width="590px" height="260px">
</iframe>







<!--
<form name="forma" method="POST" action='<c:url value="/administrarUsuarios1.do"/>' >
    
  <table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td> <input type="submit" value="Usuario Nuevo"> 
      <td class=normal style="border:1px solid blue"><b>MENU</b>&nbsp;|&nbsp;</td>
      <td id="menu3" class=normal align="center" style="padding-top:2px; padding-bottom:2px; border:1px solid orange; background-color:#F4F1E4"><a href='javascript:adicionarUsuario()'>Nuevo <b>usuario</b></a></td>
      <td id="menu4" class=normal align="center" style="padding-top:2px; padding-bottom:2px; border:1px solid orange; background-color:#F4F1E4"><a href='javascript:buscarUsuario()'>Buscar <b>usuario</b></a></td>    
      <td class="normal">
          <a id="showusers" href="javascript:showusers()">Mostrar todos los <b>usuarios</b></a>
          <a id="hideusers" href="javascript:hideusers()" style="display:none">Ocultar <b>usuarios</b></a>
      </td> 
    </tr>
  </table>

  <br>
</form>
<div id="usuarios" style="display:none"></div>

<div id="adduser" style="background-color:#FFFFFF; display:none;">     
<table style="border:1px solid black; background-color:#F1F1F1"><tr><td>
<table cellpadding="0" border="0" cellspacing="0" width="100%">
<tr class="colh">
  <td style="padding-top:7px; padding-bottom:7px; padding-left:10px">ADICIONAR NUEVO USUARIO</td>
  <td class="cerrar" align="center" style="padding-left:7px"><a href="javascript:salir('adduser')">Cerrar</a></d>
</tr>
</tr></td><tr><td>
</table> 
<table style="padding-left:30px; padding-top:5px">
 <tr><td valign="top">
    <table cellpadding="0" border="0" cellspacing="0">
        <tr>
         <td colspan="2" class="colhpt" style="color:black;font-size:12px; background-color:#F1F1F1">Datos Personales</td>
        </tr>
	<tr>
	   <td class="normal">C&eacute;dula CI.</td>
	   <td><input id="dip" type="text" class="campo" style="width:200px"></td>
	</tr>   
	<tr>
	   <td class="normal">Apellido paterno.</td>
	   <td><input id="paterno" type="text" class="campo" style="width:200px"></td>
	</tr>   
	<tr>
	   <td class="normal">Apellido materno.</td>
	   <td><input id="materno" type="text" class="campo" style="width:200px"></td>
	</tr>   
	<tr>
	   <td class="normal">Nombres</td>
	   <td><input id="nombres" type="text" class="campo" style="width:200px"></td>
	</tr>   
	<tr>
	   <td class="normal">Email:</td>
	   <td><input id="correo" type="text" class="campo" style="width:200px"></td>
	</tr>   
	<tr>
	   <td class="normal">Tel./Cel.</td>
	   <td><input id="telefono" type="text" class="campo" style="width:200px"></td>
	</tr><tr><td>&nbsp;</td></tr>   
	<tr>
	   <td id="cerror" colspan="2" class="normal" style="padding-top:5px; padding-bottom:5px" align="center"><div id="error" style="position:relative; padding-left:5px; padding-top:5px; padding-right:5px; padding-bottom:5px;display:none;"></div></td>
	</tr>   
    </table>
   </td><td valign="top" style="padding-left:20px">
    <table cellpadding="0" border="0" cellspacing="0">    
        <tr>
           <td colspan="3" class="colhpt" style="color:black;font-size:12px; background-color:#F1F1F1">Informacion de Cuenta</td>
        </tr>
	<tr>
	   <td class="normal">ID usuario.</td>
	   <td class="normal"><input id="id_usuario" type="text" class="campo" style="width:100px" onblur='verUsuario()'><input id="userstate" type='hidden'></td>
	   <td class="normal" id="cellmsg"><div id="usermsg" style="position:relative"></div></td>
	</tr>   
	<tr>
	   <td class="normal">Clave.</td>
	   <td colspan="2" class="normal"><input id="clave1" type="password" class="campo" style="width:100px"></td>
	</tr>   
	<tr>
	   <td class="normal">Repetir la clave.</td>
	   <td colspan="2" class="normal"><input id="clave2" type="password" class="campo" style="width:100px"></td>
	</tr>   
	<tr>
	   <td class="normal">Turno.</td>
	   <td class="normal" colspan="2"><input id="manana" type="radio" name="turno" checked>Ma&ntilde;ana&nbsp;<input id="tarde" type="radio" name="turno">Tarde</td>
	</tr>   
	<tr>
	   <td class="normal">Tipo usuario.</td>
	   <td class="normal" colspan="2"><input id="civil" type="radio" name="tipo" checked>Civil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="poli" type="radio" name="tipo">Policia</td>
	</tr>   
	<tr>
	   <td class="normal" align="right"><img src="./images/loading.gif"></td>
	   <td colspan="2" style="padding-top:15px" align="left"><input id="registrar" value="Registar" type="button" class="button" onclick='registrarUsuario();'></td>
	</tr>   
    </table>
   </td></tr>    
</table>       
</td></tr></table>
</div>
-->
<script>setInterval('getUsuarios()',3000);</script>
<%@ include file="../VerPieCuerpo.jsp" %>
