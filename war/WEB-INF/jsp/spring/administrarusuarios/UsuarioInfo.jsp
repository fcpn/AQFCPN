<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<%@ include file="../Cabecera.jsp" %>
<script>
    var nav4 = window.Event ? true : false;
    function solo_numeros_0(evt)
    {
        // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
        var key = nav4 ? evt.which : evt.keyCode;
        return (key <= 13 || (key >= 48 && key <= 57));
    }

    var navegador;
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

    function showFormUpdate() {
        document.getElementById('personainfoView').style.display = 'none';
        document.getElementById('personainfoUpdate').style.display = 'inline';
    }

    function cancelUpdate() {
        document.getElementById('personainfoView').style.display = 'inline';
        document.getElementById('personainfoUpdate').style.display = 'none';
    }
    var log_usuario;
    function getUsuarioByIdPersona(id_persona) {
        var contenttype = 'application/x-www-form-urlencoded';
        var req=null;
        req = AjaxHttp();

        req.open('GET','<c:url value="/getusuarioxml.do"/>?id_persona='+id_persona, true);
        req.onreadystatechange =
            function() { ''
            if (req.readyState == 4) {
                if (req.status == 200) {   
                    var resp = req.responseXML.getElementsByTagName('respuesta')[0].childNodes[0].nodeValue;
                    if (resp == "false") {
                        document.getElementById('checkUserLoading').style.display = 'none';
                        document.getElementById('checkUserFalse').style.display = 'inline';
                    }
                    else {
                        document.getElementById('checkUserLoading').style.display = 'none';
                        document.getElementById('checkUserTrue').style.display = 'inline';
                        var user = req.responseXML.getElementsByTagName('usuario')[0];
                        log_usuario = user.getAttribute('id_usuario');
                        document.getElementById('nick_usuario').innerHTML = '<font style="text-decoration:underline; font-weight:bold;color:blue;font-size:12px">'+log_usuario+'</font> <img src="./images/icon_nomail.gif"> (0)';
                        var turnHTML = 'TURNO:&nbsp;<b>'+req.responseXML.getElementsByTagName('turno')[0].childNodes[0].nodeValue+'</b>&nbsp;';
                        turnHTML = turnHTML + '&nbsp;<input type="button" value="Cambiar" onclick="setChangeTurno(\''+log_usuario+'\')" style="font-size:9px">';
                        document.getElementById('turno').innerHTML = turnHTML;
                        var ucnx = req.responseXML.getElementsByTagName('conectado')[0].childNodes[0].nodeValue;
                        if (ucnx == 'false') {
                            document.getElementById('estado').innerHTML = '<b>DESCONECTADO</b>'
                        }
                        else {
                            document.getElementById('estado').innerHTML = '<font style="color:green"><b>EN LINEA</b></font>'
                        }
		     
                        var roles = req.responseXML.getElementsByTagName('roles');
                        for (i = 0; i < roles.length; i++) {
                            var rol = roles.item(i);
                            if (rol.getAttribute("id_estado") == "S") {
                                var srol = rol.getAttribute("id_rol");
                                document.getElementById(srol).checked = true;
                                var htmlop = '<form name="frm'+srol+'" action=\'<c:url value="/usrupdaterol.do"/>\'>';
                                htmlop = htmlop + '<input type="hidden" name="id_usuario" value="'+user.getAttribute('id_usuario')+'">';
                                htmlop = htmlop + '<input type="hidden" name="id_persona" value="<c:out value="${per.id_persona}"/>">';
                                htmlop = htmlop + '<input type="hidden" name="id_rol"  value="'+srol+'">';
                                htmlop = htmlop + '<table border="0" cellspacing="0" cellpaddign="0"><tr><td class="normal">Fecha de Caducidad:</td><td class="normal">';
                                htmlop = htmlop + '<input class="campop" type="text" name="dia" value="'+rol.getAttribute("dia")+'" style="width: 20px" maxlength="2" onkeypress="return solo_numeros_0(event)">';
                                htmlop = htmlop + '<input class="campop" type="text" name="mes" value="'+rol.getAttribute("mes")+'" style="width: 20px" maxlength="2" onkeypress="return solo_numeros_0(event)">';
                                htmlop = htmlop + '<input class="campop" type="text" name="anio" value="'+rol.getAttribute("anio")+'" style="width: 35px" maxlength="4" onkeypress="return solo_numeros_0(event)">';
                                htmlop = htmlop + '</td><td class="normal">';
                                htmlop = htmlop + '<input type="submit" value="Actualizar" style="font-size:9px">';
                                htmlop = htmlop + '</td></tr><tr><td class="normal" colspan="3">';
                                if (rol.getAttribute("estado") == "activo") {
                                    htmlop = htmlop + '<img src="./icon_success.gif">&nbsp;<b>Acceso vigente</b>';
                                }
                                if (rol.getAttribute("estado") == "caduco") {
                                    htmlop = htmlop + '<img src="./icon_error.gif">&nbsp;<b>Acceso ha caducado</b>';
                                }
                                htmlop = htmlop + '</td></tr></table>';
                                htmlop = htmlop + '</form>';
                                document.getElementById('op'+srol).innerHTML = htmlop;
                            }
                        }
                    }
                }
            }
        };
        req.send(null);     
    }

    function setRol(rol) {
        document.getElementById('changerol').id_rol.value = rol;
        document.getElementById('changerol').id_usuario.value = log_usuario;
        if(document.getElementById(rol).checked) {
            document.getElementById('changerol').accion.value = 'add';
        } else {
            document.getElementById('changerol').accion.value = 'del';
        }
        document.getElementById('changerol').submit();
    }

    function setChangeTurno(id_usuario) {

        var req=null;
        req = AjaxHttp();

        req.open('GET','<c:url value="/usrchangeturno.do"/>?id_usuario='+id_usuario, true);
      
        req.onreadystatechange =
            function() { ''
            if (req.readyState == 4){
                if (req.status == 200)
                {   
                    var mes = req.responseXML.getElementsByTagName('respuesta')[0].childNodes[0].nodeValue;
                    var turnHTML = 'TURNO:&nbsp;<b>'+mes+'</b>&nbsp;';
                    turnHTML = turnHTML + '&nbsp;<input type="button" value="Cambiar" onclick="setChangeTurno(\''+id_usuario+'\')" style="font-size:9px">';
                    document.getElementById('turno').innerHTML = turnHTML;
                }
            }
        };
        req.send(null);     
    }

</script>

<form id="changerol" name="changerol" action='<c:url value="/usrchangerol.do"/>'>      
    <input type="hidden" name="id_persona" value="<c:out value="${per.id_persona}"/>">
    <input type="hidden" name="id_rol" value="">
    <input type="hidden" name="id_usuario" value="">
    <input type="hidden" name="accion" value="">
</form>

<table width=100% border="0" align=center>
    <tr class=colb>
        <th class=colh align=center>ADMINISTRAR USUARIOS  </th>
</table>
<table align="center"><tr><td style="border: 1px solid orange">
            <table border="0" cellspacing="0" cellpaddign="0">
                <tr>
                    <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                    <td class="normal" align="justify"><b>Aviso:</b> en esta secci&oacute;n se muestra informaci&oacute;n relacionada a una persona, sus datos, y ademas de poder actualizarlos.
			    tambien se despliega los datos de las cuentas que una persona tiene registrada en el <b>sistema</b>.</td>			    
                </tr>
            </table>
        </td></tr>
</table>

<table border="0" cellspacing="0" cellpaddign="0">
    <tr><td>
            <form name="adminusers" action='<c:url value="/administrarUsuarios.do"/>'>
                <input type="submit" class="button" value="Administrar usuarios">
            </form>
        </td><td>
            <!--<form name="nuevacuenta" action='<c:url value="/registrarpersona.do"/>'> -->
            <form name="nuevacuenta" action='<c:url value="/registrarpersona_jes.do"/>'>
                <input type="hidden" name="ruta" value='formulario'>
                <input class="button" type="submit" value="Nuevo usuario" name="accion">
            </form>
        </td></tr>
</table>

<!-- Informacion de la persona en modo LECTURA con un link para desplegar el layer de EDICION 
     @Autor _ston Castillo Valencia -->
<div id="personainfoView" style="display:inline">
    <table id="lyClave" border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="background-color:#FDFFEF; border:1px solid #FFE7CE">
        <td style="padding-top:20px; padding-bottom:20px; padding-left:30px; padding-right:30px">
            <table border="0" cellspacing="0" cellpaddign="0">
                <tr>
                    <td class="normal" colspan="2"><b>INFORMACION PERSONAL</b>, esta informacion fue recabada en el registro inicial, para <b>modificar</b> estos datos <a href="javascript:showFormUpdate()"><b>haga click aqui.</b></a></td>
                </tr>
                <tr>
                    <td class="normal" colspan="2"><hr></td>
                </tr>
                <tr>
                    <td class="normal" style="width:110px"><b>Nombres</b></td>
                    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.nombres}"/></td>
                </tr>
                <tr>
                    <td class="normal" style="width:110px"><b>Ap. Paterno</b></td>
                    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.paterno}"/></td>
                </tr>
                <tr>
                    <td class="normal" style="width:110px"><b>Ap. Materno</b></td>
                    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.materno}"/></td>
                </tr>
                <tr>
                    <td class="normal" style="width:110px"><b>C&eacute;dula</b></td>
                    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.dip}"/></td>
                </tr>
                <tr>
                    <td class="normal" style="width:110px"><b>Sexo</b></td>
                    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold">
                        <c:if test="${per.id_sexo == 'M'}">Masculino</c:if><c:if test="${per.id_sexo == 'F'}">Femenino</c:if>
                    </td>
                </tr>
                <tr>
                    <td class="normal" style="width:110px"><b>Email</b></td>
                    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.correo}"/></td>
                </tr>
                <tr>
                    <td class="normal" style="width:110px"><b>Telefonos</b></td>
                    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.telefono}"/></td>
                </tr>
                <tr>
                    <td class="normal" style="width:110px"><b>Direcci&oacute;n</b></td>
                    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.direccion}"/></td>
                </tr>
            </table>
            <div></div>
        </td>
    </table>
</div>
<!-- Capa de mono de EDICION para actualizar informacion de la persona : _ston Castillo Valencia-->
<div id="personainfoUpdate" style="display:none">
    <form name="updatePerson" action='<c:url value="/actualizarpersona.do"/>'>
        <table id="lyClave" border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="background-color:#FDFFEF; border:1px solid #FFE7CE">
            <tr>
                <td style="padding-top:20px; padding-bottom:20px; padding-left:30px; padding-right:30px">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td class="normal" colspan="2"><b>INFORMACION PERSONAL</b>, ahora puede Ud. modificar la informaci&oacute;n, luego asegurese de guardar.</td>
                        </tr>
                        <tr>
                            <td class="normal" colspan="2"><hr></td>
                        </tr>
                        <tr>
                            <td class="normal" style="width:110px"><b>Nombres</b></td>
                            <td class="normal"><input type="text" class="campo" name="nombres" style="width:220px" value="<c:out value="${per.nombres}"/>"></td>
                        </tr>
                        <tr>
                            <td class="normal" style="width:110px"><b>Ap. Paterno</b></td>
                            <td class="normal"><input type="text" class="campo" name="paterno" style="width:220px" value="<c:out value="${per.paterno}"/>"></td>
                        </tr>
                        <tr>
                            <td class="normal" style="width:110px"><b>Ap. Materno</b></td>
                            <td class="normal"><input type="text" class="campo" name="materno" style="width:220px" value="<c:out value="${per.materno}"/>"></td>
                        </tr>
                        <tr>
                            <td class="normal" style="width:110px"><b>C&eacute;dula</b></td>
                            <td class="normal"><input type="text" class="campo" name="dip" style="width:220px" value="<c:out value="${per.dip}"/>"></td>
                        </tr>
                        <tr>
                            <td class="normal" style="width:110px"><b>Sexo</b></td>
                            <td class="normal">
                                <input type="radio" name="id_sexo" value="M" <c:if test="${per.id_sexo == 'M'}">checked</c:if>>Masculino
                                <input type="radio" name="id_sexo" value="F" <c:if test="${per.id_sexo == 'F'}">checked</c:if>>Femenino
                            </td>
                        </tr>
                        <tr>
                            <td class="normal" style="width:110px"><b>Email</b></td>
                            <td class="normal"><input type="text" class="campo" name="correo" style="width:220px" value="<c:out value="${per.correo}"/>"></td>
                        </tr>
                        <tr>
                            <td class="normal" style="width:110px"><b>Telefonos</b></td>
                            <td class="normal"><input type="text" class="campo" name="telefono" style="width:220px" value="<c:out value="${per.telefono}"/>"></td>
                        </tr>
                        <tr>
                            <td class="normal" style="width:110px"><b>Direcci&oacute;n</b></td>
                            <td class="normal"><input type="text" class="campo" name="direccion" style="width:220px" value="<c:out value="${per.direccion}"/>"></td>
                        </tr>
                        <tr>
                            <td class="normal" colspan="2"><hr><input type="hidden" name="id_persona" value="<c:out value="${per.id_persona}"/>"></td>
                        </tr>
                        <tr>
                        
                        <td class="normal" colspan="2" align="right"><input type="button" value="Cancelar" onclick="cancelUpdate()"><input type="submit" value="Actualizar" style="font-weight:bold"></td>
            </tr>
        </table>
        <div></div>
        </td>
        </tr>
        </table>
    </form>
</div>
<br>
<div id="checkUserLoading"><center><img src="./images/loading.gif"></center></div>
<div id="checkUserFalse" style="display:none">
    <table align="center"><tr><td style="border: 1px solid orange">
                <table border="0" cellspacing="0" cellpaddign="0">
                    <tr>
                        <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                        <td class="normal" align="justify"><b>IMPORTANTE</b> El <b>sistema</b> ha determinado que esta persona esta registrada y esta activa, sin embargo no tiene cuantas de acceso al mismo.
			    Seleccione <blink><b>Crear cuenta</b></blink> para asignarle permisos, y roles en el sistema.
            </td>
        </tr>
        <tr><td></td><td align="center">
                <form name="adminusers" action='<c:url value="/determinarusuario.do"/>'>
                    <input type="hidden" name="id_persona" value='<c:out value="${per.id_persona}"/>'>
                    <input type="submit" class="button" value="Crear cuenta">
                </form>
            </td></tr>
    </table>
</td></tr>
</table>        
</div>

<div id="checkUserTrue" style="display:none">
    <table border="0" cellspacing="0" cellpaddign="0">
        <tr>
            <td class="normal"><img src="./images/user.gif"></td>
            <td class="normal"><b>DATOS DE USUARIO</b></td>
        </tr>
    </table>
<!--
    <table border="0" cellspacing="0" cellpaddign="0" width="100%" align="center" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
        <td style="padding-top:5px; padding-bottom:5px; padding-left:5px; padding-right:5px">
            <table border="0" cellspacing="0" cellpaddign="0">
                <tr>
                    <td class="normal"><b>ID</b></td>
                    <td class="normal"><div id="nick_usuario"></div></td>
                    <td class="normal"><div id="estado"></div></td>
                    <td class="normal">

                        <div id="turno"></div>

                    </td>
                </tr>
            </table>
        </td>
    </table>
-->
<!--
    <table border="0" cellspacing="0" cellpaddign="0" align="center" width="90%">
        <td class="normal" colspan="2"><hr></td>
    </table>
    <table border="0" cellspacing="0" cellpaddign="0" style="background-color:#FFFDF4">
        <tr>
            <td class="normal" style="width:210px"><input type="checkbox" id='sisp' value='sisp' onclick="setRol('sisp')"><b>Administrador de sistema</b></td>
            <td class="normal" style="padding-top:5px; padding-bottom:5px"><div id="opsisp">&nbsp;</div></td>
        </tr>
    </table>

    <table border="0" cellspacing="0" cellpaddign="0">
        <tr>
            <td class="normal" style="width:210px"><input type="checkbox" id='tra' value='tra' onclick="setRol('tra')"><b>Funcionario transcriptor</b></td>
            <td class="normal" style="padding-top:5px; padding-bottom:5px"><div id="optra">&nbsp;</div></td>
        </tr>
    </table>

    <table border="0" cellspacing="0" cellpaddign="0" style="background-color:#FFFDF4">
        <tr>
            <td class="normal" style="width:210px"><input type="checkbox" id='ver' value='ver' onclick="setRol('ver')"><b>Funcionario verificador</b></td>
            <td class="normal" style="padding-top:5px; padding-bottom:5px"><div id="opver">&nbsp;</div></td>
        </tr>
    </table> -->
    <!--
    <p class="normal">La suguiente informacion es muy <font color="blue"><b>importante</b></font>, pues permite autorizar a una persona el acceso al sistema mediante un <b>c&oacute;digo</b> y un <b>PIN</b>
    complete los datos necesarios en el siguiente formulario para crear la cuenta.
    </p>
    -->
</div>

<script>
    setTimeout('getUsuarioByIdPersona(\'<c:out value="${per.id_persona}"/>\')',100);
</script>

<%@ include file="../VerPieCuerpo.jsp" %>