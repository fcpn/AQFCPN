<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">

<%@ include file="../Cabecera.jsp" %>
<script>
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

function getUsrsTurno(id_turno) {

      var req=null;   
      req = AjaxHttp();
      req.open('GET','<c:url value="/getusrsturno.do"/>?id_turno='+id_turno, true);
      
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		    var usuarios = req.responseXML.getElementsByTagName('usuario');
		    var htmlStr1 = '<table bgcolor="#E5E8F5" border="0" cellspacing="0" cellpaddign="0"><tr>';
		    var htmlStr2 = '<table bgcolor="#F4F3D3" border="0" cellspacing="0" cellpaddign="0"><tr>';
		    htmlStr1 = htmlStr1 + '<td class="colh" align="center">Ma&ntilde;ana</td><td class="colh" align="center">Nombre</td></tr>';
		    htmlStr2 = htmlStr2 + '<td class="colh" align="center">Tarde</td><td class="colh" align="center">Nombre</td></tr>';
		    for (i = 0; i < usuarios.length; i++) {
		        var usr = usuarios.item(i);
			if (usr.getAttribute("id_turno") == 1 ) {
			    htmlStr1 = htmlStr1 + '<tr><td class="normal"><a href="javascript:;" onclick="changeUsrsTurno(\'' + usr.getAttribute("id_usuario") + '\',1)">' + usr.getAttribute("id_usuario") + '</a></td>';
			    htmlStr1 = htmlStr1 + '<td class="normal"><a href="javascript:;" onclick="changeUsrsTurno(\'' + usr.getAttribute("id_usuario") + '\',1)">' + usr.getAttribute("nombres") + '</a></td></tr>';
			} else if (usr.getAttribute("id_turno") == 2) {
			    htmlStr2 = htmlStr2 + '<tr><td class="normal"><a href="javascript:;" onclick="changeUsrsTurno(\'' + usr.getAttribute("id_usuario") + '\',2)">' + usr.getAttribute("id_usuario") + '</a></td>';
			    htmlStr2 = htmlStr2 + '<td class="normal"><a href="javascript:;" onclick="changeUsrsTurno(\'' + usr.getAttribute("id_usuario") + '\',2)">' + usr.getAttribute("nombres") + '</a></td></tr>';
			} else {
			    ;
			}
                    }
		    htmlStr1 = htmlStr1 + '</table>';
		    htmlStr2 = htmlStr2 + '</table>';
		    document.getElementById('1turno').innerHTML = htmlStr1;
		    document.getElementById('2turno').innerHTML = htmlStr2;
		    if (id_turno == 1) {
			document.getElementById('mensaje').innerHTML = "";
		    } else {
			setTimeout('getUsrsTurno(1)',10000);
		    }
                }
           }           
        };
        req.send(null);     
}

function changeUsrsTurno(id_usuario, id_turno) {

      var req=null;   
      req = AjaxHttp();
      req.open('GET','<c:url value="/changeusrsturno.do"/>?usuario=' + id_usuario + '&turno=' + id_turno, true);
      
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		    document.getElementById('mensaje').innerHTML = "Turno cambiado del usuario " + id_usuario;
		    getUsrsTurno(2);
                }
           }           
        };
        req.send(null);     
}

</script>
<table width=100% border="0" align=center>
  <tr class=colb>
    <th class=colh align=center>ADMINISTRAR TURNOS</th>
</table>
<br>
<p id="mensaje" class="normal"></p>
 <table border="0" cellspacing="0" cellpaddign="0" width="90%">
    <tr>
      <td id="1turno" class="normal" valign="top"></td>
      <td class="normal" valign="top"><div id="2turno" style="position:relative">&nbsp;</div></td>
    </tr>
 </table>
 
<script>
getUsrsTurno(1);
setTimeout('getUsrsTurno(1)',10000);
//setTimeout('getUsrsTurno(2)',3000);
</script>

<%@ include file="../VerPieCuerpo.jsp" %>
