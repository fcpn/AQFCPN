<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<%@ include file="../Cabecera.jsp" %>

<script language='JavaScript' SRC="./ajax.js"></script>
<script language='JavaScript' SRC="./shortcut.js"></script>

<SCRIPT LANGUAGE="JavaScript">
  function fullScreen() {
    document.getElementById('btnsolicitar').disabled = true;
    window.open('<c:url value="/transcripcion1.do"/>','transcripcion','fullscreen=yes, scrollbars=yes');
  }

function getbtnsolicitar() {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();
      req.open('GET','<c:url value="/getbtnsolicitar.do"/>', true);      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById("solicitar").innerHTML = mes;
                }
           }                   
        };
        req.send(null);    
}
function init() {
	shortcut.add("F5", function() {
	    ;
	});
}
window.onload=init;

// ************************************************************************
var navegador;
function msieversion() {
    var ua = window.navigator.userAgent
    var msie = ua.indexOf( "MSIE " )
    
    if ( msie > 0 )      // If Internet Explorer, return version number
        return parseInt(ua.substring(msie+5, ua.indexOf(".", msie )))
    else                 // If another browser, return 0
        return 0
        
}

function AjaxHttp2() {
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

function getReporteDiario() {

      var req=null;   
      req = AjaxHttp2();      
      req.open('GET','<c:url value="/getlisttarjetas.do"/>', true);      
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4) {
                if (req.status == 200)
                { 
                    var htmlStr = '<table><tr><td class="colh" align="center" width="50px">Nro.</td><td class="colh" align="center" width="100px">TARJETA</td><td class="colh" align="center" width="100px">CODIGO</td><td class="colh" align="center" width="100px">CEDULA</td><td class="colh" align="center" width="200px">OBS. ANVERSO</td><td class="colh" align="center" width="200px">OBS. REVERSO</td></tr>';
		    var datos = req.responseXML.getElementsByTagName('dato');
		    for (i=0; i<datos.length; i++) {
		      var xnode = datos.item(i);
		      htmlStr = htmlStr + '<tr>';
		      htmlStr = htmlStr + '<td class="normal" align="center" width="50px">'+(i+1)+'</td>';
		      htmlStr = htmlStr + '<td class="normal" align="center" width="100px">'+xnode.getAttribute("id_tarjeta")+'</td>';
		      htmlStr = htmlStr + '<td class="normal" align="center" width="100px">'+xnode.getAttribute("id_persona")+'</td>';
		      htmlStr = htmlStr + '<td class="normal" align="center" width="100px">'+xnode.getAttribute("cedula")+'</td>';
		      htmlStr = htmlStr + '<td class="normal" align="center" width="200px">'+xnode.getAttribute("comentario_a")+'</td>';
		      htmlStr = htmlStr + '<td class="normal" align="center" width="200px">'+xnode.getAttribute("comentario_r")+'</td>';
		      htmlStr = htmlStr + '</tr>';
                    }		
		    htmlStr = htmlStr + '</table>';
 		    document.getElementById('reporteDiario').innerHTML = htmlStr;
                }
           }                   
        };
        req.send(null);     
}


</script>
<script language='JavaScript' SRC="./shortcut.js"></script>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>
<br><br>

<div id="solicitar"><input class="button" type="button" value="Conectando con el servicio" disabled>&nbsp;<img src="images/loading.gif" width="20" height="20" alt="loading"/></div>

<br>
<div id='reporteDiario'>
<table>
  <tr>
    <td class="colh" align="center" width="50px">Nro.</td>
    <td class="colh" align="center" width="100px">TARJETA</td>
    <td class="colh" align="center" width="100px">CODIGO</td>
    <td class="colh" align="center" width="100px">CEDULA</td>
    <td class="colh" align="center" width="200px">OBS. ANVERSO</td>
    <td class="colh" align="center" width="200px">OBS. REVERSO</td>
  </tr>
  <tr>
    <td class="normal" align="right"><img src="./images/loading.gif" width="20"></td> 
    <td colspan="5" class="normal" style="color:#000000"><b>AVISO</b>: Para su comodidad el <b>sistema</b> esta procesando esta solicitud en segundo plano, para evitar molestas demoras en la respuesta. <b>Continue por favor!</b></td>
  </tr>
</table>
</div>

<script>
getbtnsolicitar();
setTimeout(getReporteDiario,5000);
setInterval("getbtnsolicitar()",30000);
</script>

<%@ include file="../VerPieCuerpo.jsp" %> 