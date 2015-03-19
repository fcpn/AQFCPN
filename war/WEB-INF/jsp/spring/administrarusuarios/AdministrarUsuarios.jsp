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
		   }
		   else {
		      document.getElementById('usermsg').innerHTML = '<font style="color:GREEN"><b>Correcto</b></font>';
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
<!-- Jesus Borrado -->
 <%@ include file="../buscar/BuscarPersona.jsp" %> 
<br>
<table border="0" cellspacing="0" cellpadding="0">
<tr>
  <td valign="top" colspan="3">
        <table><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"></td>
                            <td  align="justify"><b>Aviso:</b> Esta funci&oacute;n permite crear una cuenta nueva, <br> para el acceso al <b>sistema Aquiles</b>. mediante autentificaci&oacute;n</td>
                        </tr>
                    </table>
            </td></tr>
        </table>
  </td>
  <td width="10">
    <!--
  <form name="nuevacuenta" action='<c:url value="/registrarpersona.do"/>'>
    <input type="hidden" name="ruta" value='formulario'>
    <input class="button" type="submit" value="Nuevo usuario" name="accion" style="font-weight:bold">
  </form>-->
     </td>
  <td width="10">
  <!-- Jesus Borrado-->
  <!--
  <form name="loginusrs" action='<c:url value="/usuariosconectados.do"/>'>
    <input class="button" type="submit" value="Usuarios conectados" name="accion">
  </form> --></td>
</tr>
<tr>
    <td width="190">
  <form name="nuevacuenta2" action='<c:url value="/registrarpersona_jes.do"/>'>
            <input class="button" type="submit" value="Nuevo usuario Aquiles" name="accion" style="font-weight:bold">
        </form>
    </td>
    <td width="189">
        <!--
  <form name="nuevacuenta2" action='<c:url value="/buscarPersona.do"/>'>buscarpersona_jes.do
            <input class="button" type="submit" value="Buscar Usuarios" name="accion" style="font-weight:bold">
        </form>
        -->
    </td>
</tr>
</table>

<%@ include file="../VerPieCuerpo.jsp" %>
