<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">


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
var colors = new Array(); 
colors[0] = '#FFD8C2';
colors[1] = '#FFFFBB';
colors[2] = '#D6FFBA';
colors[3] = '#B6FFD6';
colors[4] = '#A8D6F4';
colors[5] = '#CCBAFF';
colors[6] = '#F6BDFF';
colors[7] = '#FFB0B1';
var colindex = 0;
var cont;
function getCajasServidor(server) {

      var req=null;   
      req = AjaxHttp();      
      req.open('GET','<c:url value="/getservermoreinfo.do"/>?id_servidor='+server, true);      
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {  var htmlStr = '<p class="normal"><b>CAJAS EN ESTE SERVIDOR<b></p><table border="0" cellspacing="0" cellpaddign="0"><tr>';
		   var datos = req.responseXML.getElementsByTagName('dato');
		   cont = 10;
		   for (i=0; i<datos.length; i++) {
		     var xnode = datos.item(i);
		     htmlStr = htmlStr + '<td class="normal" style="background-color:'+colors[colindex]+'"><a href="#"><font style="font-size:14px; font-weight:bold">'+xnode.getAttribute("caja")+'</font></a>('+xnode.getAttribute("total")+')</td>';
		     if ((i+1) == cont) { htmlStr = htmlStr + '</tr><tr>'; cont = cont + 10;}
		     colindex++;
		     if (colindex == 7) colindex=0;
		   }
		   htmlStr = htmlStr + '</tr></table>';
		   document.getElementById('serverMoreInfo').innerHTML = htmlStr;
                }
           }                   
        };
        req.send(null);     
}

</script>
<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>ADMINISTRAR SERVIDORES</th>
</table>
        <table><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>Aviso:</b> Esta opci&oacute;n actualiza los datos de un servidor de imagenes de tarjetas debidamente instalada y configurada <br>
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
<form id="frmUpdate" method="POST" action='<c:url value="/serverinfo.do"/>'>

<table border="0" cellspacing="0" cellpadding="0">    
<tr><td valign="top">
<table border="0" cellspacing="0" cellpadding="0">    
  <tr>
    <td class="colh" colspan="2" style="padding-top:3px; padding-bottom:3px">INFO <c:out value="${servidor.id_servidor}"/></td>
  </tr> 
  <tr>
    <td class="colhpt">Nombre del Servidor</td>
    <td class="colhpt"><input name="nombre" type="text" class="campo" value='<c:out value="${servidor.servidor}"/>'></td>
  </tr>
  <tr>
    <td class="colhpt">IP</td>
    <td class="colhpt"><input name="ip" type="text" class="campo" value='<c:out value="${servidor.ip}"/>'></td>
  </tr>
  <tr>
    <td class="colhpt">Puerto</td>
    <td class="colhpt"><input name="puerto" type="text" class="campo" value="5432" value='<c:out value="${servidor.puerto}"/>'></td>
  </tr>
  <tr>
    <td class="colhpt">Usurario</td>
    <td class="colhpt"><input name="user" type="text" class="campo" value='<c:out value="${servidor.usuario}"/>'> (Username of DataBase)</td>
  </tr>
  <tr>
    <td class="colhpt">Password</td>
    <td class="colhpt"><input name="pass" type="password" class="campo"></td>
  </tr>
  <tr>        
    <td class="colhpt" align="center" style="padding-top:4px; padding-bottom:5px">
    <input type="hidden" name="accion" value="guardar">
    <input type="hidden" name="id_servidor" value='<c:out value="${servidor.id_servidor}"/>'>
    <input type="submit" class="button" value="Guardar"></td>   
    <td class="colhpt" style="color:#000000; font-weight:normal">Modificar los datos de un <b>servidor de imagenes</b> en el <b>sistema</b>.</td>
  </tr>
</table>
</td><td valign="top" align="center"><img src='./images/charts/<c:out value="${servidor.id_servidor}"/>.jpg'>
</tr>
</table>
</form>
<hr>
<p class="normal"><b>TOTAL IMAGENES:</b> <c:out value="${servidor.total}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <b>TRANSCRITAS:</b> <c:out value="${servidor.transcritas}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <b>DISPONIBLES PARA TRANSCRIPCION:</b> <c:out value="${servidor.total - servidor.transcritas}"/>
</p>
<div id="serverMoreInfo"><center><img src="./images/loading.gif"></center></div>

<script>
setTimeout('getCajasServidor(\'<c:out value="${servidor.id_servidor}"/>\')',1000)
</script>



<%@ include file="../VerPieCuerpo.jsp" %>


