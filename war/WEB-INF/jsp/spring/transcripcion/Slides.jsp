<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">
<HTML>
<HEAD>

<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./ajax.js">  </script>
<script language='JavaScript' SRC="./validar.js">  </script>


<style type="text/css">
BODY{ 
	font-family: verdana, arial;
	padding:0px;
	margin:0px;
}
#cabecera {
	position:absolute;
	top:0px;
	left:0px;
	width: 100%;
	height:20px;
	color: #ffcc88;
}
#cols {
  font-family: Verdana, Helvetica, sans-serif;
  font-size: 10px;
  font-weight: normal;
  color : #7D7D7D;
  background-color: #3399FF;
  border:#CFCFCF 1px solid;
  padding-left:7px;
  padding-right:7px;
}
#logo{
	float: left;
	margin-left:2px;
	font-weight: bold;
}
#enlaces{
	float: right;
	margin-right:4px;
}
#contenido{
	margin-top: 30px;
}

</style>

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
<br>

<div id="slides_content" >
  <ul class="buttons">
    <li><a id="current" href="javascript:void(0)" onclick="change(0,this);">AMBERSO</a></li>
    <li><a href="javascript:void(0)" onclick="change(750,this);">REBERSO</a></li>
  </ul>
    <div id="elementos" style="width:2100px; margin:0 0 0 0;">
	<div class="foto 1">
<center>
    <a onclick="zoom();">
        <img name="img1" title="click para zoom" alt="REPORTES" src='./images/tarjetas/II CAJA360_jac_011206_im1973_A.jpg' border=1 width="700" height="300">
    </a>
</center>
	
	
	
	
	</div>
	<div class="foto 2">
<center>
    <a onclick="zoom();">
        <img name="img1" title="click para zoom" alt="REPORTES" src='./images/tarjetas/II CAJA360_jac_011206_im1973_R.jpg' border=1 width="700" height="300">
    </a>
</center>          	
	
	</div>
    </div>
</div>

<%@ include file="../VerPieCuerpo.jsp" %>
