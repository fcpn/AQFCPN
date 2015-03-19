<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<%@ include file="../Cabecera.jsp" %>
<style type="text/css">

.PwdMeterBase {
 margin-left:10px;
 margin-bottom:10px;
 margin-top:10px;
 margin-right:10px;
 width:250px;
}

.PwdBack {
 height:9px;
 background-image:url(./images/password_meter_grey.gif);
 background-position:center center;
 background-repeat: no-repeat;
 border:1px solid #646464
}

.PwdMeter {
 width:0px;
 background-image:url(./images/password_meter.gif);
 background-position:center center;
 background-repeat: no-repeat;
 height:9px;
 font:normal 9px Tahoma;color:#444444;
}

/*///////////////////
///// SLIDES JS /////
///////////////////*/
/* CONTENIDO GLOBAL*/	
#slides_content {
        width:750px; /* ANCHO DEL CONTENEDOR*/
	overflow:hidden;
        margin:auto;
}
				    
/* HEADERS */
#slides_content {
    font:10px Arial;
    letter-spacing:-1px;
    font-weight:bold;
    margin:5px; 
    color:#FF6600;
}
					    
/* SLIDE */	

#slides_content .foto {
    float:left; 
    width:730px;  /* ANCHO DE CADA SLIDE */
    height:270px; /* ALTURA DE CADA SLIDE */
    //padding:10px;
    //background-color: #000000;
    border-top:1px solid #7596B7;
}

/* LISTA DE ITEMS */
.buttons{
	text-align:center;
	width:200px; /* ANCHO DEL MENU */
	clear:both;
	display:list-item;
	list-style:none;
	white-space: nowrap;
	padding:0px;
	margin:0px 0px 0px 0px;
	}


.buttons li{
	display: inline;
	list-style-type: none;
}

.buttons li a{
	text-align:center;
	margin:0px 3px 0px 0px;
	//padding:10px 10px;
	line-height:25px;
}	
	
.buttons li a:link,
.buttons li a:visited{
	background-color:#B5CADF; 
	color:#000;
}	

.buttons li a:hover{
	color:ORANGE;
	background-color:#0F3950;
}

.buttons li a#current{
	background-color:#0F3950;
	color:#FFF;
}

</style>

<script>
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

function getResultadosUsr() {

      var req=null;   
      req = AjaxHttp();      
      req.open('GET','<c:url value="/getresultadosusr.do"/>', true);      
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4) {
                if (req.status == 200)
                { 
		    var datos = req.responseXML.getElementsByTagName('dato');
		    var xnode = datos.item(0);
 		    document.getElementById('nro_hoy').innerHTML = xnode.getAttribute("nro_hoy");
 		    document.getElementById('nro_total').innerHTML = xnode.getAttribute("nro_total");
                }
           }                   
        };
        req.send(null);     
}
var index;
function getTarjetasRevertidas() {
      var req=null;   
      req = AjaxHttp();      
      req.open('GET','<c:url value="/gettarjetasrevertidas.do"/>', true);      
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4) {
                if (req.status == 200)
                { 
		   index = req.responseXML.getElementsByTagName('respuesta')[0].childNodes[0].nodeValue;		   
		   document.getElementById('revinfo').innerHTML = '<img src="./icon_success.gif">&nbsp;<b>'+index+'</b> Tarjetas has sido revertidas'
                }
           }                   
        };
        req.send(null);     
}

function showFormUpdate() {
  document.getElementById('personainfoView').style.display = 'none';
  document.getElementById('personainfoUpdate').style.display = 'inline';
}

function cancelUpdate() {
  document.getElementById('personainfoView').style.display = 'inline';
  document.getElementById('personainfoUpdate').style.display = 'none';
}
var cal = 1;
function prepararBandeja() {
    var val = (248 / 100) * cal;
    cal++;
    //val = 248 + \val;
    document.getElementById('meter').style.width = val+'px';    
    document.getElementById('meter').innerHTML = cal+'%';
    if (cal < 100) {
       setTimeout(prepararBandeja,100);
    }       
}

function get() {
getTarjetasRevertidas();
alert(index);
}
</script>
<script>
/* FUNCIONES XCLIENT PARA MOVER LA CABECERA...*/

var xOp7Up,xOp6Dn,xIE4Up,xIE4,xIE5,xNN4,xUA=navigator.userAgent.toLowerCase();if(window.opera){var i=xUA.indexOf('opera');if(i!=-1){var v=parseInt(xUA.charAt(i+6));xOp7Up=v>=7;xOp6Dn=v<7;}}else if(navigator.vendor!='KDE' && document.all && xUA.indexOf('msie')!=-1){xIE4Up=parseFloat(navigator.appVersion)>=4;xIE4=xUA.indexOf('msie 4')!=-1;xIE5=xUA.indexOf('msie 5')!=-1;}else if(document.layers){xNN4=true;}xMac=xUA.indexOf('mac')!=-1;
function xDef(){for(var i=0; i<arguments.length; ++i){if(typeof(arguments[i])=='undefined') return false;}return true;}
function xGetElementById(e){if(typeof(e)=='string') {if(document.getElementById) e=document.getElementById(e);else if(document.all) e=document.all[e];else e=null;}return e;}
function xLeft(e, iX){if(!(e=xGetElementById(e))) return 0;var css=xDef(e.style);if (css && xStr(e.style.left)) {if(xNum(iX)) e.style.left=iX+'px';else {iX=parseInt(e.style.left);if(isNaN(iX)) iX=0;}}else if(css && xDef(e.style.pixelLeft)) {if(xNum(iX)) e.style.pixelLeft=iX;else iX=e.style.pixelLeft;}return iX;}
function xMoveTo(e,x,y){xLeft(e,x);xTop(e,y);}
function xNum(){for(var i=0; i<arguments.length; ++i){if(isNaN(arguments[i]) || typeof(arguments[i])!='number') return false;}return true;}
function xScrollTop(e, bWin){var offset=0;if (!xDef(e) || bWin || e == document || e.tagName.toLowerCase() == 'html' || e.tagName.toLowerCase() == 'body') {var w = window;if (bWin && e) w = e;if(w.document.documentElement && w.document.documentElement.scrollTop) offset=w.document.documentElement.scrollTop;else if(w.document.body && xDef(w.document.body.scrollTop)) offset=w.document.body.scrollTop;}else {e = xGetElementById(e);if (e && xNum(e.scrollTop)) offset = e.scrollTop;}return offset;}
function xStr(s){for(var i=0; i<arguments.length; ++i){if(typeof(arguments[i])!='string') return false;}return true;}
function xTop(e, iY){if(!(e=xGetElementById(e))) return 0;var css=xDef(e.style);if(css && xStr(e.style.top)) {if(xNum(iY)) e.style.top=iY+'px';else {iY=parseInt(e.style.top);if(isNaN(iY)) iY=0;}}else if(css && xDef(e.style.pixelTop)) {if(xNum(iY)) e.style.pixelTop=iY;else iY=e.style.pixelTop;}return iY;}

function getElementPosition(object)
{
    var position = new Object;
    position.left = parseInt(document.getElementById(object).style.marginLeft)
    position.top = parseInt(document.getElementById(object).style.marginTop)
    return position;
}

function change(x,item)
{
	document.getElementById("current").id = "";
	item.id = "current";
	if((x * (-1))<(getElementPosition("elementos").left - 10)){
		distance = (x + getElementPosition("elementos").left) / 5;
		start = getElementPosition("elementos").left;
		for(i=0; i<=distance; i=i+1){
			setTimeout("document.getElementById(\"elementos\").style.margin = \"0 -" + ((start * (-1)) + (i*5)) + "px\"", i*5);
			if(i==distance){
				setTimeout("document.getElementById(\"elementos\").style.margin = \"0 -" + x + "px\"", i*5);
			}
		}
	}else if((x * (-1))>(getElementPosition("elementos").left)){ 
		distance = ((x + getElementPosition("elementos").left) / 5)  * (-1);
		start = getElementPosition("elementos").left;		
		for(i=0; i<=distance; i=i+1)
		{
			//alert(i);
			setTimeout("document.getElementById(\"elementos\").style.margin = \"0 -" + ((start * (-1)) - (i*5)) + "px\"", i*5);
			if(i==distance)
				setTimeout("document.getElementById(\"elementos\").style.margin = \"0 -" + x + "px\"", i*5);
		}
	}
}

</script>

<!--
<a href="javascript:get()">hi</a>
-->
<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>

        <table><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>INFORMACION:</b> 
			       El <b>sistema</b> se ha optimizado para un rendimiento mayor en su trabajo, porporcionandole esta bandeja de trabajo
			       que le proporciona informacion de su actididad mas detallada que antes, los datos se actualizan cada deternimado tiempo.  
			       Puede iniciar la aplicaci&oacute;n en cualquier momento. <br><b>(El Equipo del Programa de Cedulaci&oacute;n Gratuita)</b>
			    </td>	
                        </tr>
                    </table>      
            </td></tr>
        </table>



<div id="slides_content" >
  <ul class="buttons">
    <li><a id="current" href="javascript:void(0)" onclick="change(0,this);">BANDEJA</a></li>
    <li><a href="javascript:void(0)" onclick="change(750,this);">DATOS PERSONALES</a></li>
  </ul>

    <div id="elementos" style="width:2100px; margin:0 0 0 0;">
	<div class="foto 1" style="background-color:red">
	
<!-- Datos de la cuenta -->
<table border="0" cellspacing="0" cellpaddign="0">
 <tr>
  <td class="normal"><img src="./images/user.gif"></td>
  <td class="normal"><b>DATOS DE USUARIO</b></td>
  <td class="normal"><b></td>
 </tr>
</table>

<table border="0" cellspacing="0" cellpaddign="0" width="100%" align="center" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
<td style="padding-top:5px; padding-bottom:5px; padding-left:5px; padding-right:5px">  
 <table border="0" cellspacing="0" cellpaddign="0">
   <tr>        
    <td class="normal"><b>ID</b></td>
    <td class="normal"><font style="text-decoration:underline; font-weight:bold;color:blue;font-size:12px"><c:out value="${id_usuario}"/></font> <img src="./images/icon_nomail.gif"> (0)</td>
    <td class="normal">TOTAL TARJETAS TRANSCRITAS:  <font style="color:#000000;font-size:14px;font-weight:bold">1234</font></td>
    <td class="normal">TARJETAS TRANSCRITAS HOY:  <font style="color:#000000;font-size:14px;font-weight:bold">34</font></td>
   </tr>    
 </table>
</td>
</table>


 <table border="0" cellspacing="0" cellpaddign="0">
   <tr>        
    <td class="normal">
    <div class="PwdMeterBase">
        <div class="PwdBack"><div id="meter" style="width: 0px;" class="PwdMeter"></div></div>
    </div>
    </td>
    <td class="normal"><b>Preparando...</b> por favor sea paciente!</td>
   </tr>
   <tr>
    <td class="normal"><div id="revinfo"><img src="./images/loading.gif" width="15">&nbsp;Revirtiendo tarjetas pasadas</td>
    </td>
   </tr>
 </table>       

		  
	</div>
	<div class="foto 2" style="background-color:blue">


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
<form name="updatePerson" action='<c:url value="/transcripcion.do"/>'>      
<table id="lyClave" border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="background-color:#FDFFEF; border:1px solid #FFE7CE">
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
    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.nombres}"/><input type="hidden" name="nombres" value="<c:out value="${per.nombres}"/>"></td>
   </tr>    
   <tr>        
    <td class="normal" style="width:110px"><b>Ap. Paterno</b></td>
    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.paterno}"/><input type="hidden" name="paterno" value="<c:out value="${per.paterno}"/>"></td>
   </tr>    
   <tr>        
    <td class="normal" style="width:110px"><b>Ap. Materno</b></td>
    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.materno}"/><input type="hidden" name="materno" value="<c:out value="${per.materno}"/>"></td>
   </tr>    
   <tr>        
    <td class="normal" style="width:110px"><b>C&eacute;dula</b></td>
    <td class="normal" style="color:#000000; font-size:12px; font-weight:bold"><c:out value="${per.dip}"/><input type="hidden" name="dip" value="<c:out value="${per.dip}"/>"></td>
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
    <td class="normal" colspan="2"><hr></td>
   </tr>
   <tr>
    <input type="hidden" name="id_persona" value="<c:out value="${per.id_persona}"/>">
    <td class="normal" colspan="2" align="right"><input type="button" value="Cancelar" onclick="cancelUpdate()"><input type="hidden" name="update" value="update"><input type="submit" value="Actualizar" style="font-weight:bold"></td>
   </tr>
 </table>
 <div></div>
</td>
</table>
</form>
</div>

	    
	</div>
    </div>
</div>

































<script>
setTimeout(prepararBandeja,500);
setTimeout(getTarjetasRevertidas,500);

</script>






<%@ include file="../VerPieCuerpo.jsp" %> 