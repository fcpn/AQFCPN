<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">


<%@ include file="../Cabecera.jsp" %>

<style type="text/css">
#dhtmltooltip{
position: absolute;
left: -300px;
width: 150px;
border: 1px solid black;
padding: 2px;
background-color: lightyellow;
visibility: hidden;
z-index: 100;
/*Remove below line to remove shadow. Below line should always appear last within this CSS*/
filter: progid:DXImageTransform.Microsoft.Shadow(color=gray,direction=135);
}

#dhtmlpointer{
position:absolute;
left: -300px;
z-index: 101;
visibility: hidden;
}
</style>
<script type="text/javascript">

/***********************************************
* Cool DHTML tooltip script II- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
* Implementado en este sistema por: _ Castillo Valencia
* Programa de Cedulacion Gratuita Bolivia
***********************************************/

var offsetfromcursorX=12 //Customize x offset of tooltip
var offsetfromcursorY=10 //Customize y offset of tooltip

var offsetdivfrompointerX=10 //Customize x offset of tooltip DIV relative to pointer image
var offsetdivfrompointerY=14 //Customize y offset of tooltip DIV relative to pointer image. Tip: Set it to (height_of_pointer_image-1).

document.write('<div id="dhtmltooltip"></div>') //write out tooltip DIV
document.write('<img id="dhtmlpointer" src="./images/arrow2.gif">') //write out pointer image

var ie=document.all
var ns6=document.getElementById && !document.all
var enabletip=false
if (ie||ns6)
var tipobj=document.all? document.all["dhtmltooltip"] : document.getElementById? document.getElementById("dhtmltooltip") : ""

var pointerobj=document.all? document.all["dhtmlpointer"] : document.getElementById? document.getElementById("dhtmlpointer") : ""

function ietruebody(){
return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body
}

function ddrivetip(thetext, thewidth, thecolor){
if (ns6||ie){
if (typeof thewidth!="undefined") tipobj.style.width=thewidth+"px"
if (typeof thecolor!="undefined" && thecolor!="") tipobj.style.backgroundColor=thecolor
//tipobj.innerHTML=thetext;
var img = document.getElementById(thetext).src;
tipobj.innerHTML='<center><img src=\"'+img+'\" /></center>'; //style=\"width:500px\"/>';
enabletip=true
return false
}
}

function positiontip(e){
if (enabletip){
var nondefaultpos=false
var curX=(ns6)?e.pageX : event.clientX+ietruebody().scrollLeft;
var curY=(ns6)?e.pageY : event.clientY+ietruebody().scrollTop;
//Find out how close the mouse is to the corner of the window
var winwidth=ie&&!window.opera? ietruebody().clientWidth : window.innerWidth-20
var winheight=ie&&!window.opera? ietruebody().clientHeight : window.innerHeight-20

var rightedge=ie&&!window.opera? winwidth-event.clientX-offsetfromcursorX : winwidth-e.clientX-offsetfromcursorX
var bottomedge=ie&&!window.opera? winheight-event.clientY-offsetfromcursorY : winheight-e.clientY-offsetfromcursorY

var leftedge=(offsetfromcursorX<0)? offsetfromcursorX*(-1) : -1000

//if the horizontal distance isn't enough to accomodate the width of the context menu
if (rightedge<tipobj.offsetWidth){
//move the horizontal position of the menu to the left by it's width
tipobj.style.left=curX-tipobj.offsetWidth+"px"
nondefaultpos=true
}
else if (curX<leftedge)
tipobj.style.left="5px"
else{
//position the horizontal position of the menu where the mouse is positioned
tipobj.style.left=curX+offsetfromcursorX-offsetdivfrompointerX+"px"
pointerobj.style.left=curX+offsetfromcursorX+"px"
}

//same concept with the vertical position
if (bottomedge<tipobj.offsetHeight){
tipobj.style.top=curY-tipobj.offsetHeight-offsetfromcursorY+"px"
nondefaultpos=true
}
else{
tipobj.style.top=curY+offsetfromcursorY+offsetdivfrompointerY+"px"
pointerobj.style.top=curY+offsetfromcursorY+"px"
}
tipobj.style.visibility="visible"
if (!nondefaultpos)
pointerobj.style.visibility="visible"
else
pointerobj.style.visibility="hidden"
}
}

function hideddrivetip(){
if (ns6||ie){
enabletip=false
tipobj.style.visibility="hidden"
pointerobj.style.visibility="hidden"
tipobj.style.left="-1000px"
tipobj.style.backgroundColor=''
tipobj.style.width=''
}
}

document.onmousemove=positiontip
</script>

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

function updateServerDatos(elem) {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      req = AjaxHttp();
      
      req.open('GET','<c:url value="/updateserver.do"/>?id_servidor='+elem, true);      
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
                          var lista = req.responseXML.getElementsByTagName("dato");
			  xnodo = lista.item(0);
			  var total = xnodo.getAttribute("total");
			  var trans = xnodo.getAttribute("transcritas");
			  var resta = total - trans;
			  var img = xnodo.getAttribute("imagen");
			  document.getElementById('total'+elem).innerHTML = total;
			  document.getElementById('trans'+elem).innerHTML = trans;
			  document.getElementById('resta'+elem).innerHTML = resta;
			  document.getElementById('state'+elem).innerHTML = '<font color=#90D087>CONECTADO <a href=\"javascript:serverInfo(\''+elem+'\')\">mas...</a></font>';
			  document.getElementById('dvimg'+elem).innerHTML = '<img id="img'+elem+'" src="'+img+'" width="100" onMouseover="ddrivetip(\'img'+elem+'\',410,\'#FFFFFF\')" onMouseout="hideddrivetip()">';
              }
	   }      
        };
        req.send(null);  
}

function serverInfo(server) {
 document.getElementById('frmServerInfo').id_servidor.value = server
 document.getElementById('frmServerInfo').submit();     
}

function updateServer(elem) {
 if (document.getElementById(elem).checked) {
   document.getElementById('frmUpdate').id_servidor.value = document.getElementById(elem).value
   document.getElementById('frmUpdate').submit()
 } 
}
</script>

<form id="frmUpdate" name="frmUpdate" method="POST" action='<c:url value="/updateserver.do"/>'>
    <input type="hidden" name="id_servidor" value=""> 
    <input type="hidden" name="accion" value="default"> 
</form>
<form id="frmServerInfo" name="frmUpdate" method="POST" action='<c:url value="/serverinfo.do"/>'>
    <input type="hidden" name="id_servidor" value=""> 
    <input type="hidden" name="accion" value="default"> 
</form>

<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>ADMINISTRAR SERVIDORES</th>
</table>
        <table align="center">
	    <tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>Aviso:</b> Aqui se desplegar&aacute;, a los usuarios que tienen iniciada su sesion en el sistema, esta vista se actualiza automaticamente<br>
			    Este modulo esta en proceso de desarrollo, esta aplicaci&oacute;n permitira iniciar sesiones de <b>Mensajeria Instantanea</b> entre otras<br>
			    funcionalidades del <b>sistema</b>. (El equipo del <b>Programa de Cedulaci&oacute;n Gratuita de Bolivia)</b></td>			    
                        </tr>
                    </table>      
            </td></tr>
        </table>
<br>

<form id="frmNuevo" name="frmNuevo" method="POST" action='<c:url value="/servidores.do"/>'>
<table border="0" cellspacing="0" cellpadding="0">    
  <tr>
    <td class="normal">
    <input type="hidden" name="accion" value="nuevo"> 
    <input type="submit" class="button" value="Agregar servidor" style="font-weight:bold"><td>   
    <td class="normal">Registra un <b>servidor de imagenes</b> al sistema.
  </tr>
</table>
</form>
<p class="normal"><b>TR</b>, significa que el servidor esta seleccionado para <b>TRANSCRIPCION</b> 
<font color="#B02626">Posicione el puntero sobre la imagen para ver los detalles, y haga click en <b>mas..</b> para ver mas informaci&oacute;n.</font>
</p>
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">    
    <tr>
        <td class=colh colspan=10 align=center style="padding-top:4px; padding-bottom:4px">SERVIDORES DE IMAGENES</td>
    </tr> 
    <tr>
        <td class="colhp" align=center>No.</td>
        <td class="colhp" align=center>ID</td>
        <td class="colhp" align=center>GRF</td>
        <td class="colhp" align=center>Total</td>
        <td class="colhp" align=center>Trans.</td>
        <td class="colhp" align=center>Disp.</td>
        <td class="colhp" align=center>Servidor</td>
        <td class="colhp" align=center>IP</td>
        <td class="colhp" align=center>TR</td>
        <td class="colhp" align=center>Estado</td>
    </tr>
    <c:forEach var="datos" items="${listaServidores}" varStatus="i"> 
      <c:if test="${i.count%2 == 0}">  
        <tr style="background-color:#FFFDDD">
	    <td align="right" class="normal"><b><c:out value="${i.count}"/></b></td>
            <td class="normal" style="font-weight:normal; color:#000000"><b><c:out value="${datos.id_servidor}"/></b></td>
            <td class="normal" align="right">&nbsp;<div id='dvimg<c:out value="${datos.id_servidor}"/>'></div></td>
            <td align="right" class="normal" style="color:#000000; font-size:12px; font-weight: bold"><div id='total<c:out value="${datos.id_servidor}"/>'><c:out value="${datos.total}"/></div></td>
            <td align="right" class="normal" style="background-color:#F8E4E4; font-weight: bold"><div id='trans<c:out value="${datos.id_servidor}"/>'><c:out value="${datos.transcritas}"/></div></td>
            <td align="right" class="normal" style="background-color:#DCDFF8; font-weight: bold"><div id='resta<c:out value="${datos.id_servidor}"/>'><c:out value="${datos.total - datos.transcritas}"/></div></td>
            <td class="normal" style="font-weight: normal"><c:out value="${datos.servidor}"/></td>
            <td class="normal" style="font-weight: normal"><c:out value="${datos.ip}"/></td>
            <td class="normal" align="center" <c:if test="${datos.transcripcion == '1'}">style="background-color:#DEFFDD"</c:if>><input type="checkbox" id='<c:out value="${datos.id_servidor}"/>' value='<c:out value="${datos.id_servidor}"/>' <c:if test="${datos.transcripcion == '1'}">checked</c:if> onclick='updateServer("<c:out value="${datos.id_servidor}"/>")'></td>
	    <td class="normal" style="font-weight: bold"><div id='state<c:out value="${datos.id_servidor}"/>'><font color="#FF9D9F">DESCONECTADO</font></div></td>
	</tr>
      </c:if>
      <c:if test="${i.count%2 != 0}">  
        <tr style="background-color:#FFFFFF">
	    <td align="right" class="normal"><b><c:out value="${i.count}"/></b></td>
            <td class="normal" style="font-weight:normal; color:#000000"><b><c:out value="${datos.id_servidor}"/></b></td>
            <td class="normal" align="right">&nbsp;<div id='dvimg<c:out value="${datos.id_servidor}"/>'></div></td>
            <td align="right" class="normal" style="color:#000000; font-size:12px; font-weight: bold"><div id='total<c:out value="${datos.id_servidor}"/>'><c:out value="${datos.total}"/></div></td>
            <td align="right" class="normal" style="background-color:#F8E4E4; font-weight: bold"><div id='trans<c:out value="${datos.id_servidor}"/>'><c:out value="${datos.transcritas}"/></div></td>
            <td align="right" class="normal" style="background-color:#DCDFF8; font-weight: bold"><div id='resta<c:out value="${datos.id_servidor}"/>'><c:out value="${datos.total - datos.transcritas}"/></div></td>
            <td class="normal" style="font-weight: normal"><c:out value="${datos.servidor}"/></td>
            <td class="normal" style="font-weight: normal"><c:out value="${datos.ip}"/></td>
            <td class="normal" align="center" <c:if test="${datos.transcripcion == '1'}">style="background-color:#DEFFDD"</c:if>><input type="checkbox" id='<c:out value="${datos.id_servidor}"/>' value='<c:out value="${datos.id_servidor}"/>' <c:if test="${datos.transcripcion == '1'}">checked</c:if> onclick='updateServer("<c:out value="${datos.id_servidor}"/>")'></td>
	    <td class="normal" style="font-weight: bold"><div id='state<c:out value="${datos.id_servidor}"/>'><font color="#FF9D9F">DESCONECTADO</font></div></td>
	</tr>
      </c:if>
    </c:forEach>    
</table>
<div id="mensaje"></div>
<div id="fffff"></div>
<!-- ejemplo del script tooltip dhtml
<a href="down.do" onMouseover="ddrivetip('JavaScriptKit.com JavaScript tutorials', 300)" onMouseout="hideddrivetip()">download</a>
-->
<script>
var servers = new Array();
<c:forEach var="datos" items="${listaServidores}" varStatus="i">
servers[<c:out value="${i.index}"/>] = '<c:out value="${datos.id_servidor}"/>';
</c:forEach>  
var sindex = 0; 
function conectarServidores() {
   updateServerDatos(servers[sindex]); 
   if (sindex == servers.length-1)
      sindex = 0;
   else
      sindex++; 
   document.getElementById('mensaje').innerHTML = '<font class="normal">Conectando con: '+servers[sindex]+'</font>';           
}
setInterval('conectarServidores()',5000);
</script>

<%@ include file="../VerPieCuerpo.jsp" %>

