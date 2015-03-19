<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<%@ include file="../Cabecera.jsp" %>
<SCRIPT LANGUAGE="JavaScript" SRC="./AnimatedFader.js"></SCRIPT>
<%@ include file="RiaContent.jsp" %>
<script>

//Script submitted to and featured on
//http://www.dynamicdrive.com

/* 
 * FadingText(divName, numSteps, BGColor)
 * divName : Must match the DIV names defined at the end of the BODY)
 * numSteps: The number of steps in the fading transition
 * BGColor : The background colour of the DIV or document.
 */
 FadingText('fade1',10,"FFFFFF");
	
/*** The "Frame Interval" Smaller = faster ***/
 FadeInterval=30;
	    
var navegador;
function msieversion() {
    var ua = window.navigator.userAgent
    var msie = ua.indexOf( "MSIE " )
    
    if ( msie > 0 )      // If Internet Explorer, return version number
        return parseInt(ua.substring(msie+5, ua.indexOf(".", msie )))
    else                 // If another browser, return 0
        return 0
        
}

function AjaxHttp(){
	xmlHttp = null;
	try{
		xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		 try{
			 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		 }catch(e){
			 xmlHttp = new XMLHttpRequest();
		 }
	}
	return xmlHttp;
}

function AjaxHttpRV() {
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


/* Esta funcion muetra a los usuarios que tienes una sesion activa en el sistema 
 * Genera una tabla HTML a partir de la respuesta XML de /getloginusers.do
 * Autor: _ Castillo Valencia
 */
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

		   var num = req.responseXML.getElementsByTagName("usuarios")[0].childNodes[0].nodeValue;
		   var lusers = req.responseXML.getElementsByTagName("dato");
                   var content = '<table border=\"0\" cellspacing=\"1\" cellpadding=\"1\" width=\"75%\" align=\"center\">';
                   content = content + '<tr><td class=\"colhpt\" colspan=\"3\"><b>'+num+'</b> usuarios conectados</td></tr>';     
		   for (i = 0; i < lusers.length; i++) {
		   var xnode = lusers.item(i);
		   var id_usuario = xnode.getAttribute("id_usuario");
		   var cod_img = xnode.getAttribute("cod_img");
		   var nombre_completo = xnode.getAttribute("nombre_completo");
		   var nro_tarjetas = xnode.getAttribute("nro_tarjetas");
                   content = content + '<tr>';		   
                   content = content + '<td class=\"normal\"><img src=\"./images/user.gif\"></td>'
                   content = content + '<td class=\"normal\"><font style=\"color:BLUE\"><b><a href=\"#\" onMouseover=\"showmenu(event,linkset[1], \'170px\')\" onMouseout=\"delayhidemenu()\">'+id_usuario+'</a></b>('+nro_tarjetas+')</font><font style=\"font-size:8px\">&nbsp;('+nombre_completo+')</font></td>';
                   content = content + '<td class=\"normal\"><font style=\"color:black\"><b>Actividad: </b></font>'+cod_img+'</td>';
                   content = content + '</tr>';
		   }
                   content = content + '<tr><td class=\"colhpt\" colspan=\"3\"><b>'+num+'</b> usuarios conectados</td></tr>';
                   content = content + '</table>';
	           document.getElementById('logusers').innerHTML = content;
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
function setText() {
    var msg = '<table><tr><td style=\"border: 1px solid red\">'
    msg = msg + '<table border=\"0\" cellspacing=\"0\" cellpaddign=\"0\">'
    msg = msg + '<tr>'
    msg = msg + '<td valign=\"top\"><img src=\"./icon_error.gif\"></td>'
    msg = msg + '<td class=\"normal\" align=\"justify\"><b>AVISO:</b> Esta funcionalidad no esta disponible en esta version, <br>'
    msg = msg + 'del <b>sistema</b>.  (El equipo del <b>Programa Aquiles)</b>.</td>'
    msg = msg + '</tr>'
    msg = msg + '</table>'
    msg = msg + '</td></tr>'
    msg = msg + '</table>'
    return msg;
}
function outText() {
   document.getElementById('chatmessage').innerHTML = '';
}
function usrChat() {
   document.getElementById('chatmessage').innerHTML = setText();
   setTimeout('outText()',10000);
}
</script>
<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>ADMINISTRAR USUARIOS</th>
</table>

<br>
        <table align="center">
	    <tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>Aviso:</b> Aqui se desplegar&aacute;, a los usuarios que tienen iniciada su sesion en el sistema, esta vista se actualiza automaticamente<br>
			    Este modulo esta en proceso de desarrollo, esta aplicaci&oacute;n permitira iniciar sesiones de <b>Mensajeria Instantanea</b> entre otras<br>
			    funcionalidades del <b>sistema</b>. (El equipo del <b>Programa Aquiles (sistema de presupuestos))</b></td>			    
                        </tr>
                    </table>      
            </td></tr>
        </table>
<br>

<table border="0" cellspacing="0" cellpaddign="0">
  <tr>
   <td class="colh">Usuarios Conectados</td>
   <td class="normal"><img src="./images/refresh.gif"></td>
   <td class="normal"><input type="button" class="button" onclick='refreshUsers()' value="Actualizar" style="font-weight:bold"></td>
   <td class="normal"><input type="button" class="button" value="Administrar usuarios" onclick="document.getElementById('adminusers').submit()"></td>
  </tr>
</table>   
<br>
<form id="adminusers" action='<c:url value="/administrarUsuarios.do"/>'>      
</form>

<!--  
<p><A HREF="" onMouseOver="fade_up('fade1',setText(),'000000')" onMouseOut="fade_down('fade1')">Dynamic Drive</A>
<DIV ID="fade1"></DIV>
-->
<div id="chatmessage"></div>
<div id="logusers"><center><img src="./images/loading.gif"></center></div>
<script>setInterval('getUsuarios()',5000);</script>
<%@ include file="../VerPieCuerpo.jsp" %>
