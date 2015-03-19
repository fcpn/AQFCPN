<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">
<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<link rel="stylesheet" href="pagina.css" type="text/css">
<!--
<link rel="stylesheet" href="../pagina.css" type="text/css">
<link rel="stylesheet" href="../style.css" type="text/css">
-->
<link rel="stylesheet" href="style.css" type="text/css">

<html>
<head>
  <title>Programa de cedulaci&oacute;n gratuita</title>
  <link rel='SHORTCUT ICON' href='{$img_ico}'>
  <link rel='stylesheet' href='{$insumos}'>
  <meta HTTP-EQUIV='Pragma' CONTENT='no-cache'>
  <script language='javascript' src='{$javascript}'>
  </script>
</head> 

<script language='JavaScript' SRC="./shortcut.js"></script>
<script>
var nav4 = window.Event ? true : false;

function solo_letras(evt)
{
  // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
   var key = nav4 ? evt.which : evt.keyCode;
   return (key <= 13 || (key >= 97 && key <= 122)|| (key >= 65 && key <= 90) );
}


function solo_numeros_0(evt)
{
  // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
   var key = nav4 ? evt.which : evt.keyCode;
   return (key <= 13 || (key >= 48 && key <= 57));
}
function val_ci(evt)
{
  // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
   var key = nav4 ? evt.which : evt.keyCode;
   return (key <= 13 || (key >= 48 && key <= 57) || ( key == 45) || ( key == 78) || ( key == 110 ));
}
 OCULTO="none";
 VISIBLE="inline";

function solo_serie(evt)
{
  // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
   var key = nav4 ? evt.which : evt.keyCode;
   return (key <= 13 || (key >= 48 && key <= 54));
}

function solo_seccion(evt)
{
  // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
   var key = nav4 ? evt.which : evt.keyCode;
   return (key <= 13 || (key >= 48 && key <= 54));
}

function anyoBisiesto(anyo)
{
	/**
	* si el año introducido es de dos cifras lo pasamos al periodo de 1900. Ejemplo: 25 > 1925
	*/
	if (anyo < 100)
	var fin = 19+anyo;
	//var fin = anyo + 1900;
	else
	var fin = anyo ;
	/*
	* primera condicion: si el resto de dividir el año entre 4 no es cero > el año no es bisiesto
	* es decir, obtenemos año modulo 4, teniendo que cumplirse anyo mod(4)=0 para bisiesto
	*/
	 // alert(fin);

	if (fin % 4 != 0)
		return false;
	else
	{
		if (fin % 100 == 0)
		{
			if (fin % 400 == 0)
			{
				return true;

			}
			else
			{
				return false;

			}
		}

		/**
		* si es divisible por 4 y no es divisible por 100 > el año es bisiesto
		*/

		else
		{
			return true;
		}
	}
}


function vacio(q) {
        for ( i = 0; i < q.length; i++ )
        {
                if ( q.charAt(i) != " " ) { return false}
        }
        return true
}


// la funcion validarfechan2 es la funcion que se esta utilizando 

function validarfechan2 (diax,mesx,anyox,merror)
{
	var dia=document.getElementById(diax).value;
	var mes=document.getElementById(mesx).value;
	var anyo=document.getElementById(anyox).value;

        if(vacio(dia)&&vacio(mes)&&vacio(anyo))
        { 	document.getElementById(merror).style.display = 'none';
	        //document.getElementById('guardartarjeta').disabled = false;
		//document.getElementById('showinfotarjeta').style.display = 'none';
                return true;
        }
        if(!vacio(anyo))
        {
           if ((anyo < 1800) || (anyo > 2021))
	   {
		document.getElementById(merror).style.display = 'inline';
		//document.getElementById('guardartarjeta').disabled = true;
		//document.getElementById('showinfotarjeta').style.display = 'inline';
                return false;
	   }
	}

	if(anyoBisiesto(anyo))
		febrero=29;
	else
		febrero=28;
		
	  if(!vacio(mes))
	  {	
	    if ((mes < 1) || (mes > 12))
	    {     
	        	document.getElementById(merror).style.display = 'inline'; 
			//document.getElementById('guardartarjeta').disabled = true;
			//document.getElementById('showinfotarjeta').style.display = 'inline';
	        	return false;             
	     }
	  }
	 if ((mes==2) && ((dia<0) || (dia>febrero)))
	 {
	    document.getElementById(merror).style.display = 'inline';
	    //document.getElementById('guardartarjeta').disabled = true;
	    //document.getElementById('showinfotarjeta').style.display = 'inline';
            return false;
	 }
	/**
	* si el mes introducido es de 31 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
	*/
	  if (((mes==1) || (mes==3) || (mes==5) || (mes==7) || (mes==8) || (mes==10) || (mes==12) ) && ((dia<=0) || (dia>31)))
	  {
	     if(!vacio(dia)) {
	     document.getElementById(merror).style.display = 'inline';
	     //document.getElementById('guardartarjeta').disabled = true;
	     //document.getElementById('showinfotarjeta').style.display = 'inline';
             return false;
	     }
	   }
	/**
	* si el mes introducido es de 30 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
	*/
	   if (((mes==4) || (mes==6) || (mes==9) || (mes==11)) && ((dia<0) || (dia>30)))
	   {
                document.getElementById(merror).style.display = 'inline';
		//document.getElementById('guardartarjeta').disabled = true;
		//document.getElementById('showinfotarjeta').style.display = 'inline';
		return false;
	   }

       if(!vacio(dia))
       {    if(dia<1 || dia>31)
            {   	    	
		document.getElementById(merror).style.display = 'inline';
		//document.getElementById('guardartarjeta').disabled = true;
		//document.getElementById('showinfotarjeta').style.display = 'inline';
		return false;
	    }
       }
    document.getElementById(merror).style.display = 'none';
    //document.getElementById('guardartarjeta').disabled = false;
    //document.getElementById('showinfotarjeta').style.display = 'none';

     return true;
	
}





</script>



<style type="text/css">
#menulateral
{
    width : 1000px;
    position : fixed;
    z-index: 1;
    float : left;
    left : 0px;
    top : 0px;
    background-color: #32342F
}
#AV
{
    position : absolute;
    left : 50px;
    z-index: 0;
    top : 410px;
    width : 900px;
    border-style : solid;
    border-width : 0px;
    Padding : 5px;
}
#RV
{
    position : absolute;
    left : 50px;
    z-index: 0;
    top : 410px;
    width : 900px;
    border-style : solid;
    border-width : 0px;
    Padding : 5px;
}


    #cajaRegistro {
    background-image: url(../imagenesFront/fondoCaja.gif);
    background-repeat: no-repeat;
    background-position: left top;
    height: 80px;
    border-right: 1px solid #CCCCCC;
    border-bottom: 1px solid #CCCCCC;
    border-left: 1px solid #CCCCCC;
    background-color: #F5F5F5;
    overflow: hidden;
    }
    .funcional {
    font-size: 12px;
    border: 1px solid #005C9F;
    color: #005C9F;
    margin-left: 1px;
    margin-top: 1px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    padding: 1px;
    margin-bottom: 1px;
    font-weight: bold;
    background-color: #FBFFB1
    }    
    .campo {
    font-size: 12px;
    border: 1px solid #7D7D7D;
    color: #005C9F;
    margin-left: 1px;
    margin-top: 1px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    padding: 1px;
    margin-bottom: 1px;
    font-weight: bold;
    background-color: #E5F1E4
    }
    .ci {
    font-size: 12px;
    border: 1px solid #7D7D7D;
    margin-left: 20px;
    margin-right: 20px;
    margin-top: 1px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    padding: 1px;
    font-weight: bold;
    color: #666666;
    margin-bottom: 1px;
    }    
    .campoOk {
    font-size: 9px;
    border: 1px solid #7D7D7D;
    margin-left: 1px;
    margin-top: 1px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    padding: 1px;
    font-weight: bold;
    color: #666666;
    margin-bottom: 1px;
    background-color: #ffffff;
    }     
</style>

<style type="text/css">
/*///////////////////
///// SLIDES JS /////
///////////////////*/
/* CONTENIDO GLOBAL*/	
#slides_content {
        width:800px; /* ANCHO DEL CONTENEDOR*/
	overflow:hidden;
        margin:auto;
}
				    
/* HEADERS */
#slides_content h2 {
    font:24px Arial;
    letter-spacing:-1px;
    font-weight:bold;
    margin:5px; 
    color:#FF6600;
}
					    
/* SLIDE */	

#slides_content .foto {
    float:left; 
    width:880px;  /* ANCHO DE CADA SLIDE */
    height:340px; /* ALTURA DE CADA SLIDE */
    padding:10px;
    border-top:5px solid #7596B7;
}

/* LISTA DE ITEMS */
.buttons{
	text-align:left;
	width:0px; /* ANCHO DEL MENU */
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
	padding:8px 14px;
	line-height:31px;
	}	
	
.buttons li a:link,
.buttons li a:visited{
	background-color:#B5CADF; 
	color:#000;
	}	

.buttons li a:hover{
	color:#FFFF00;
	background-color:#7596B7;
	}

.buttons li a#current{
	background-color:#7596B7;
	color:#FFF;
}

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
    var sw = true;
    function zoom(e) {
     var img = document.getElementById(e);
     if(sw) {
      img.width = 1020;
      img.height = 620;
      sw = false;
     }
     else {
      img.width = 720;
      img.height = 320;
      sw = true;
     }
    }  

function parseMessage() {
     var message = req.responseXML.getElementsByTagName("message")[0];
     setMessage(message.childNodes[0].nodeValue);
}
function setMessage(message) {
  var userMessageElement = document.getElementById("resultado");
  userMessageElement.innerHTML ='muestrame'+'<font color=\"red\">' + message +'</font>';
}
function campoOK(elem) {
   
   var campo = document.getElementById(elem);
   //alert (elem);
   //campo.style='background:#000000';
   //campo.style.background = "#D3F9D5";
}
    
function enviar(elem) {
      var campo = document.getElementById(elem);
      var resultado = document.getElementById("resultado");
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
          req = new XMLHttpRequest();
          if (req.overrideMimeType) {
             req.overrideMimeType('text/xml');
          }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
          try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
        }
      }
      req.open('POST', '<c:url value="/transcripcion2.do"/>', true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { 
           if (req.readyState == 4){
                       if (req.status == 200){ 
                          var mes = req.responseXML.getElementsByTagName("respuesta");
                          //alert(mes.length);
                          //setMessage(mes.item(1).childNodes[0].nodeValue);
                          //setMessage(mes.value);
                          //alert(mes.item(0).childNodes[0].nodeValue);
                          campoOK(elem);
                       }
                       else { resultado.innerHTML = '<FONT COLOR="#FF0000">no conectado/</FONT>';}
                       }
                    };
      req.send('campo=' +elem+ '::' + escape(campo.value));      
}



function guardar() {
   if(confirm("Los Datos seran guardados, OK para confirmar"))
      document.getElementById('frmSend').submit();
}    
function salir() {
   window.close();
}    


//==================================================CAJAS==========================================================================
 var cod_depto=0;  //variable global 
//recibo elem=valor del select ; divnom = el nombre del div ; clave = para el switch del controlador
 function mostrarD(elem,divnom,clave) {
      var campo = elem;
      var resultado = document.getElementById(divnom);
      var contenttype = 'application/x-www-form-urlencoded';
    
     
     if(clave==1){cod_depto=elem;document.getElementById('local').innerHTML=' <select id="f_localidad" name="" class="funcional" style="width: 240px" > </select></td>';};  //la primera vez se guarda el departamento  
     
      var req2=null;
       resultado.innerHTML = "cargando..";
//definiendo el objeto httprequest 
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
                               req2 = new XMLHttpRequest();
                                   if (req2.overrideMimeType) {
                                            req2.overrideMimeType('text/xml');
                                                              }
                                   } else if (window.ActiveXObject) { // IE
                                                                     try {
                                                                           req2 = new ActiveXObject("Msxml2.XMLHTTP");
                                                                          } catch (e) {
                                                                                         try {
                                                                                         req2= new ActiveXObject("Microsoft.XMLHTTP");
                                                                                              } catch (e) {}
                                                                                       }
                                                                     }
//-------------------------------------- fin de instanciacion--------------------------------------------
      req2.open('POST', '<c:url value="/cajasdpto.do"/>', true);   //controlador
      req2.setRequestHeader('Content-Type', contenttype);
      req2.onreadystatechange = 
        function() { 
           if (req2.readyState == 4){
                       if (req2.status == 200){ 
                                resultado.innerHTML = req2.responseText; //escribimos las cajas

                       }
                       else { resultado.innerHTML = '<FONT COLOR="#FF0000">no conectado/</FONT>';}
                       }
                    };
                     //enviamos el codigo de la opcion elegida mas la clave para el controlador 
      req2.send('codigo=' + campo +'&clave='+ clave +'&codep='+ cod_depto);      //enviando codep de paso
      
    }
//========================================================fin DE CAJAS ==========================================



//=======================================================================================================================================================
//=====================================================MIERCOLES 1RO DE AGOSTO  CAJAS DE PARIENTES Y RELACIONES (roger)===========================================
//=============================================================================================================================================================


//---------------------------- funcion muestra un listado de relaciones parientes , tramites (trabaja con listRela.java) ----------------------------------

function muestraRela(resultado,clave)
{
   var contenttype = 'application/x-www-form-urlencoded';
   var req2=null;
   resultado.innerHTML = "cargando..";
                  //definiendo el objeto httprequest 
                  if (window.XMLHttpRequest) { // Mozilla, Safari,...
                  req2 = new XMLHttpRequest();
                  if (req2.overrideMimeType) {
                  req2.overrideMimeType('text/xml');
                   }
                   } else if (window.ActiveXObject) { // IE
                   try {
                   req2 = new ActiveXObject("Msxml2.XMLHTTP");
                   } catch (e) {
                   try {
                   req2= new ActiveXObject("Microsoft.XMLHTTP");
                   } catch (e) {}
                                                                                       }
                                                                     }
                           

req2.open('POST', '<c:url value="/listRela.do"/>', true); //controlador
req2.setRequestHeader('Content-Type', contenttype);
req2.onreadystatechange = 
           function() { 
           if (req2.readyState == 4){
           if (req2.status == 200){ 
           resultado.innerHTML = req2.responseText; //escribimos las cajas
           }
           else { resultado.innerHTML = '<FONT COLOR="#FF0000">no conectado/</FONT>';}
           }
           };
           //enviamos el codigo de la opcion elegida mas la clave para el controlador 
           req2.send('clave='+clave);  
}

//------------------------------------------fin de muestraRela --------------------------------------------------------- 


//-----------------------------------------funcion principal  -> inserta registros (Parientes.java) 

function sele(selec,apP,apM,nnom,dir,ext,llista,clave)
{ 

var codigoG="";
var sel = document.getElementById(selec);
var seltexto = sel.options[sel.selectedIndex].text; 
var apellp = document.getElementById(apP);
var apellm = document.getElementById(apM);
var nom1 = document.getElementById(nnom);
var dir = document.getElementById(dir);
var ext = document.getElementById(ext);
var res = document.getElementById(llista);
                                  var req3=null;
                                  if (window.XMLHttpRequest) { // Mozilla, Safari,...
                                  req3 = new XMLHttpRequest();
                                  if (req3.overrideMimeType) {
                                  req3.overrideMimeType('text/xml');
                                                              }
                                   } else if (window.ActiveXObject) { // IE
                                   try {
                                   req3 = new ActiveXObject("Msxml2.XMLHTTP");
                                   } catch (e) {
                                    try {
                                   req3= new ActiveXObject("Microsoft.XMLHTTP");
                                   } catch (e) {}
                                     }
                                   }

 var contenttype = 'application/x-www-form-urlencoded';
 req3.open('POST', '<c:url value="/parientes.do"/>', true);
 req3.setRequestHeader('Content-Type', contenttype); //SE ESTA UTILIZANDO LA VARIABLE CONTENTYPPE DEFINIDA MAS ARRIBA 
 req3.onreadystatechange = 
           function() { 
           if (req3.readyState == 4){          
           if (req3.status == 200){  var positivo=req3.responseText;muestraRela(res,clave); }
           else { //res.innerHTML = '<FONT COLOR="#FF0000">no conectado/</FONT>';
                 }
           }  };
req3.send('nom1='+nom1.value+'&apellidop='+apellp.value+'&apellidom='+apellm.value+'&dir='+dir.value +'&ext='+ext.value+'&clave='+clave+'&rol='+sel.value+'&codigoG='+codigoG);      //enviando codep de paso                                                     
nom1.value=""; 
dir.value="";  
ext.value="";  
apellp.value="";  
apellm.value="";  
}

//------------------------------- fin de  funcion sele ----------------------------------------

//--------------------------------funcion para  quitar parientes (quitaParientes.java)----------------------------------------


function quitarPar(miboton ,milista,miclave)
{

//alert(miboton.name);
var res = document.getElementById(milista);
var i=0;
var cadena='';
var req3=null;

                                 //definiendo el objeto httprequest 
                                 if (window.XMLHttpRequest) { // Mozilla, Safari,...
                                 req3 = new XMLHttpRequest();
                                 if (req3.overrideMimeType) {
                                 req3.overrideMimeType('text/xml');
                                    }
                                 } else if (window.ActiveXObject) { // IE
                                 try {
                                 req3 = new ActiveXObject("Msxml2.XMLHTTP");
                                  } catch (e) {
                                  try {
                                  req3= new ActiveXObject("Microsoft.XMLHTTP");
                                  } catch (e) {}
                                   }
                                   }

                                                                 

var contenttype = 'application/x-www-form-urlencoded';
req3.open('POST', '<c:url value="/quitaparientes.do"/>', true);
req3.setRequestHeader('Content-Type', contenttype); //SE ESTA UTILIZANDO LA VARIABLE CONTENTYPPE DEFINIDA MAS ARRIBA 
        req3.onreadystatechange = 
        function() { 
        if (req3.readyState == 4){          
        if (req3.status == 200){  var positivo=req3.responseText; muestraRela(res,miclave); }
        else { //res.innerHTML = '<FONT COLOR="#FF0000">no conectado/</FONT>';
              }
         }
         };

//enviamos el codigo de la opcion elegida mas la clave para el controlador 
req3.send('clave=' + miclave +'&codigoG='+ miboton);     
      


}

//----------------------------------------------fin de quitar parientes ---------------------------------------


//=======================================================================================================================================================
//=====================================================FIN ----MIERCOLES 1RO DE AGOSTO CAJAS PARIENTES ===========================================
//=============================================================================================================================================================



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
<script type="text/javascript">
function init() {
	shortcut.add("pageup", function() {
	        change(0,document.getElementById('current'));
		mostrar();window.scroll(0,0);document.getElementById("id_relacion").focus()
	});
	shortcut.add("pagedown", function() {
	        change(900,document.getElementById('current'));
		ocultar();window.scroll(0,0);document.getElementById("ap_paterno").focus()
	});
	shortcut.add("F5", function() {
	    ;
	});
}
</script>
<script>     
function mostrarResultado(mes,lugar) {
  var userMes = document.getElementById(lugar);
  userMes.innerHTML = mes;
}

function getGrupos(elemento,destino) {
      var elem = document.getElementById(elemento);
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
      req = new XMLHttpRequest();
        if (req.overrideMimeType) {
          req.overrideMimeType('text/xml');  
        }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
        try {
          req = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {}
       }
      }
      if (elemento == "g1")      
         req.open('GET','<c:url value="/getarbol.do"/>?dato=g1&grp1='+elem.value, true);
      if (elemento == "g2")      
         req.open('GET','<c:url value="/getarbol.do"/>?dato=g2&grp1='+document.getElementById("g1").value+'&grp2='+elem.value, true);
      if (elemento == "g3")      
         req.open('GET','<c:url value="/getarbol.do"/>?dato=g3&grp1='+document.getElementById("g1").value+'&grp2='+document.getElementById("g2").value+'&grp3='+elem.value, true);
      if (elemento == "g4")      
         req.open('GET','<c:url value="/getarbol.do"/>?dato=g4&grp1='+document.getElementById("g1").value+'&grp2='+document.getElementById("g2").value+'&grp3='+document.getElementById("g3").value+'&grp4='+elem.value, true);
                  
      req.onreadystatechange = 
        function() { 
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   mostrarResultado(mes,destino);
                }
                else { 
		   resultado.innerHTML = '<B>SIN CONEXION</B>';
		}
           }                   
           else {
	       resultado.innerHTML = '<B>SIN CONEXION</B>';
           }                     
        };
      req.send(null);      
 }
    
 function getClientes() {
   alert("hola");
 }

function enviarprofesion(elem,sw) {
      var campo = elem;
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      if (campo == "") return;
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
          req = new XMLHttpRequest();
          if (req.overrideMimeType) {
             req.overrideMimeType('text/xml');
          }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
          try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
        }
      }
      req.open('GET','<c:url value="/setprofesion.do"/>?sw='+sw+'&cod_grp='+campo, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   mostrarResultado(mes,"lstprofesiones");
                }
           }                   
        };
        req.send(null);    
}
    
</script>
<script>

//Registro Extranjeros _
function cambiarExtranjero() {
    if(document.getElementById('tipo1').checked) {
	//alert("Nacional");
	document.getElementById('id_tipo_tarjeta').value = 1;
	document.getElementById('extranjero').style.display = "none";
	document.getElementById('rel_extranjero').style.display = "none";
	document.getElementById('par_extranjero').style.display = "none";
    } else {
	//alert("Extranjero");
	document.getElementById('id_tipo_tarjeta').value = 2;
	document.getElementById('extranjero').style.display = "inline";
	document.getElementById('rel_extranjero').style.display = "inline";
	document.getElementById('par_extranjero').style.display = "inline";
    }
}

//Fin Registro Extranjeros _

function vernavegador() {
      var nav;
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
         nav = 'MZ'
      } else if (window.ActiveXObject) { // IE
         nav = 'IE'
      }
      return  nav;
}
function show_cedula() {
  document.getElementById('showcedula').innerHTML = document.getElementById('cedula').value;
}

</script>

<form id="frmTranscripcion" method="POST" action='<c:url value="/error.do"/>'>
</form>

<script>
if (vernavegador() == 'IE')
{ document.getElementById('frmTranscripcion').submit();
}


setInterval('show_cedula()',5000);



</script>


<body bgcolor="#D5D5D5" oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
<div id="menulateral">


<table id="initinfo" width="100%" cellpadding="0" border="0" style="background-color:#D5D5D5">
 <tr>
   <td class="colhpt">Usuario</td> 
   <td class="colhpt" style="padding-left:20px; padding-right:20px; font-size: 16px; color:#7E64AB; border: 1px solid #7E64AB"><c:out value="${id_usuario}"/></td> 
   <td class="colhpt">Tarjeta</td> 
   <td class="colhpt" style="padding-left:20px; padding-right:20px; font-size: 16px; color:#7E64AB; border: 1px solid #7E64AB"><c:out value="${cod_img}"/></td> 
   <td class="colhpt">Nro.Tarjetas Hoy</td> 
   <td class="colhpt" style="padding-left:20px; padding-right:20px; font-size: 16px; color:#7E64AB; border: 1px solid #7E64AB"><c:out value="${nro_hoy}"/></td> 
   <td class="colhpt">Record</td> 
   <td class="colhpt" style="padding-left:20px; padding-right:20px; font-size: 16px; color:#EEEEEE; border: 1px solid #000000; background-color: orange"><c:out value="${nro_total}"/></td> 
   <td class="button"><input name="A" id="A" type="button" value="<" onclick="change(0,this); mostrar();">
                      <input name="B" id="B" type="button" value=">" onclick="change(900,this); ocultar();"></td> 
   <td class="colhpt">Nacional</td> 
                    <input type="hidden" id="id_tipo_tarjeta">
		       		    
   <td class="normal"><input type="radio" id="tipo1" name="tipo" value="1" onclick='cambiarExtranjero();enviar("id_tipo_tarjeta");' checked></td> 
   <td class="colhpt">Extranjero</td> 
   <td class="normal"><input type="radio" id="tipo2" name="tipo" value="2" onclick='cambiarExtranjero();enviar("id_tipo_tarjeta");'></td> 
   <td class="normal" style="background-color:#FFDDE9; padding-left:20px; padding-right:20px; font-size: 14px; color:#000000; border: 1px solid RED"><a href="javascript:salir();" style="decoration:none"><blink>SALIR</blink></a></td>
 </tr> 
</table>

<script type="text/javascript">
window.onload=init;
function initExtranjero() {
   if (<c:out value="${obj.id_tipo_tarjeta}"/> == 2) {
      document.getElementById('tipo2').checked = true;
      cambiarExtranjero();  
   }
}
</script>

<div id="slides_content">

    <div id="elementos" style="width:2900px; margin:0 0 0 0;">
	<div class="foto 1" style="">
     
    <div style="width:730px;height:330px; overflow:auto">
	<img onclick="zoom('img-a');" id="img-a" title="click para zoom" alt="REPORTES" src='<c:out value="${lnombreA}"/>' border=1 width="720" height="320">
    </div>
		
	</div>
	<div class="foto 2" style="">

    <div style="width:730px;height:330px; overflow:auto">
        <img onclick="zoom('img-r');" id="img-r" title="click para zoom" alt="REPORTES" src='<c:out value="${lnombreR}"/>' border=1 width="720" height="320">
    </div>
	
	</div>
    </div>
</div>

</div>
<a id="current" href="javascript:void(0)" onclick="change(0,this);"></a>
<a href="javascript:void(0)" onclick="change(800,this);"></a>

<div id="AV">
<%-- Lado formulario--%>

    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">DATOS PERSONALES</legend>  


                <table cellpadding="0" border="0" cellspacing="0">
                    <tr>
                        <td class="colhpt">Nombre Completo (Paterno, Materno, Nombres)</td>
                    </tr>
                    <tr>
                        <td class="normal"><input type="text" id="ap_paterno" maxlength="32" class="funcional" name="ap_paterno" value="<c:out value="${obj.ap_paterno}"/>" style="width: 145px" onblur='enviar("ap_paterno")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="ap_materno" maxlength="32" class="funcional" name="ap_materno" value="<c:out value="${obj.ap_materno}"/>" style="width: 140px" onblur='enviar("ap_materno")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="nombre1" maxlength="64" class="funcional" name="nombre1" value="<c:out value="${obj.nombre1}"/>" style="width: 145px" onblur='enviar("nombre1")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="nombre2" maxlength="64" class="funcional" name="nombre2" value="<c:out value="${obj.nombre2}"/>" style="width: 145px" onblur='enviar("nombre2")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="nombre3" maxlenght="128" class="funcional" name="nombre3" value="<c:out value="${obj.nombre3}"/>" style="width: 145px" onblur='enviar("nombre3")' onkeypress='return solo_letras(event)'></td>
                    </tr>
                </table>
                <table cellpadding="0" border="0" cellspacing="0">
                    <tr>
                        <td class="colhpt">Nro. Gral (CI)<input type="text" id="cedula" maxlength="16" class="funcional" name="cedula" value="<c:out value="${obj.cedula}"/>" style="width: 80px; font-size: 14px; color: #000000" align="center" onblur='enviar("cedula")' onkeypress='return val_ci(event)'></td>
                        <td class="colhpt">Sexo</td>
                        <td>
<!--			    <input type="text" id="sexo" class="campo" name="" value="<c:out value="${obj.sexo}"/>" style="width: 70px" onblur='enviar("sexo")'> -->
                            <select id="id_sexo" name="" class="funcional" onblur='enviar("id_sexo")' onchange='enviar("id_sexo")'>
			           <option value="M" <c:if test="${obj.id_sexo == 'M'}">selected</c:if>>Varon</option>
				   <option value="F" <c:if test="${obj.id_sexo == 'F'}">selected</c:if>>Mujer</option>
				   <option value="O" <c:if test="${obj.id_sexo == 'O'}">selected</c:if>>Sin dato</option>
                            </select>
                        </td>
                        <td class="colhpt">Libro</td>
                        <td class="normal"><input type="text" id="libro" maxlength="32" class="campo" name="libro" value="<c:out value="${obj.libro}"/>" style="width: 70px" onblur='enviar("libro")'></td>
                        <td class="colhpt">Folio</td>
                        <td class="normal"><input type="text" id="folio" maxlength="32" class="campo" name="folio" value="<c:out value="${obj.folio}"/>" style="width: 70px" onblur='enviar("folio")'></td>
                        <td class="colhpt">Revisor</td>
                        <td class="normal"><input type="text" id="revisor" maxlength="64" class="campo" name="revisor" value="<c:out value="${obj.revisor}"/>" style="width: 159px" onblur='enviar("revisor")'></td>
                </table>
            </td>
	   </tr>    
        </fieldset>
    </table>


    
    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">DATOS DE PROCEDENCIA</legend>  

    
    <table  cellpadding="0" border="0" cellspacing="0">
        <tr>
            <td class="colhpt">Nacionalidad</td>
            <td class="normal"><input type="text" id="nacionalidad" maxlenght="64" class="campo" name="nacionalidad" value="<c:out value="${obj.nacionalidad}"/>" style="width: 200px" onblur='enviar("nacionalidad")'></td>
            <td class="colhpt" style="padding-left:50px">Pais:</td>
	    <td class="normal">
<!--	        <input type="text" id="pais" class="campo" name="" value="<c:out value="${obj.pais}"/>" style="width: 120px" onblur='enviar("pais")'>            -->
                <select id="id_pais" name="" class="funcional" style="width: 250px" onblur='enviar("id_pais")' onchange='enviar("id_pais")'>
                    <c:forEach var="lista" items="${listapais.pageList}">
                        <option value="<c:out value="${lista.cod_pais}"/>" <c:if test="${lista.cod_pais == obj.id_pais}">selected</c:if>><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
	</tr>    
    </table>	
    <table cellpadding="0" border="0" cellspacing="0">
	<tr>
            <td class="colhpt">Dep:</td>
	    <td class="normal">
<!--	        <input type="text" id="departamento" class="campo" name="" value="<c:out value="${obj.departamento}"/>" style="width: 170px" onblur='enviar("departamento")'><br> -->
                <select id="id_departamento" name="" class="funcional" style="width: 120px" onblur='enviar("id_departamento");' onchange='enviar("id_departamento")'>
                    <c:forEach var="lista" items="${listadepto.pageList}">
                        <option value='<c:out value="${lista.cod_depto}"/>' <c:if test="${lista.cod_depto == obj.id_departamento}">selected</c:if>><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
	    
            <td class="colhpt">Prov.</td>	    
            <td class="normal"><input type="text" id="provincia" maxlength="128" class="campo" name="provincia" value="<c:out value="${obj.provincia}"/>" style="width: 214px" onblur='enviar("provincia")'><a href='javascript:mostrarD(document.getElementById("id_departamento").value,"prov","1")' onfocus=''><img src="images/refresh.gif"/></a>
            <div id = 'prov'>    
            <select class="funcional" style="width: 240px">
	         <option><c:out value="${obj.id_provincia}"/>
             </select>
            </div> 
            </td>    
           
            <td class="colhpt" style="padding-left: 20px">Loc.</td>
            
	    <td class="normal"><input type="text" id="localidad" maxlegth="128" class="campo" name="localidad" value="<c:out value="${obj.localidad}"/>" style="width: 214px" onblur='enviar("localidad")'><a href='javascript:mostrarD(document.getElementById("id_provincia").value,"local","4")' onfocus=''><img src="images/refresh.gif"/></a>
            <div id='local'>  
            <select class="funcional" style="width: 240px" >
	         <option><c:out value="${obj.id_localidad}"/>
             </select>
            </div>
            </td>           
        </tr>
    </table>

            </td>
	   </tr>    
        </fieldset>
    </table>







    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">DATOS DE NACIMIENTO</legend>  

    <table cellpadding="0" border="0" cellspacing="0">
        <tr><td></td><td class="normal" colspan="5">


<table cellpadding="0" border="0" cellspacing="0">	
<tr><td>
<div id="infboxn" style="position:relative; display:none">
<table cellpadding="0" border="0" cellspacing="0" style="border: 1px solid #D6D169; background-color: #FBFFAE;">
<tr><td style="padding-left:5px"><img src="images/icon_inf.gif" width="16" height="16"/></td>
    <td class="normal" style=><b>Fecha: Ejemplo 16 03 2005</b></td>
</tr>
</table>    
</div>
</td><td>
<div id="error4n" style="position:relative; display:none">
<table cellpadding="0" border="0" cellspacing="0" style="border: 1px solid RED; color: RED; background-color: #FFE9E9;">
<tr ><td style="padding-left:5px"><img src="icon_error.gif" width="16" height="16"/></td>
    <td class="normal"> La <b>Fecha</b>, no es valida </td>
</tr>
</table>    
</div>
</td></tr>
</table>


	</td>
        <td colspan="5"align="right">


<table cellpadding="0" border="0" cellspacing="0">	
<tr><td><div id="error4c" style="position:relative; display:none">
<table cellpadding="0" border="0" cellspacing="0" style="border: 1px solid RED; color: RED; background-color: #FFE9E9;">
<tr ><td style="padding-left:5px"><img src="icon_error.gif" width="16" height="16"/></td>
    <td class="normal"> La <b>Fecha</b>, no es valida </td>
</tr>
</table>    
</div>
</td><td>
<div id="infboxc" style="position:relative; display:none">
<table cellpadding="0" border="0" cellspacing="0" style="border: 1px solid #D6D169; background-color: #FBFFAE;">
<tr><td style="padding-left:5px"><img src="images/icon_inf.gif" width="16" height="16"/></td>
    <td class="normal" style=><b>Fecha: Ejemplo 16 03 2005</b></td>
</tr>
</table>    
</div>
</td></tr>
</table>


	</td></tr>
        <tr>
            <td class="colhpt">Nacio el</td>
            <td class="normal">
<!--	     <input type="text" id="fec_nacimiento" class="campo" name="" value="<c:out value="${obj.fec_nacimiento}"/>" style="width: 120px" onblur='enviar("fec_nacimiento")'> -->
             <input class="funcional" type="text" id="nac_dia" name="" value="<c:out value="${obj.nac_dia}"/>" style="width: 20px" onblur='enviar("nac_dia");document.getElementById("infboxn").style.display = "none";' maxlength="2" onkeypress="return solo_numeros_0(event)" onfocus="document.getElementById('infboxn').style.display = 'inline';">
	     <input class="funcional" type="text" id="nac_mes" name="" value="<c:out value="${obj.nac_mes}"/>" style="width: 20px" onblur='enviar("nac_mes");document.getElementById("infboxn").style.display = "none";' maxlength="2" onkeypress="return solo_numeros_0(event)" onfocus="document.getElementById('infboxn').style.display = 'inline';">
	     <input class="funcional" type="text" id="nac_anio" name="" value="<c:out value="${obj.nac_anio}"/>" style="width: 35px" onblur='enviar("nac_anio");document.getElementById("infboxn").style.display = "none";' maxlength="4" onkeypress="return solo_numeros_0(event)" onfocus="document.getElementById('infboxn').style.display = 'inline';">
            </td>
            <td class="colhpt">Of.R.C.Nro</td>
            <td class="normal"><input type="text" id="ofic_rcn" maxlength="64" class="campo" name="ofic_rcn" value="<c:out value="${obj.ofic_rcn}"/>" style="width: 75px" onblur='enviar("ofic_rcn")'></td>
            <td class="colhpt">Lib Nro</td>
            <td class="normal"><input type="text" id="libro_no" maxlength="8" class="campo" name="libro_no" value="<c:out value="${obj.libro_no}"/>" style="width: 75px" onblur='enviar("libro_no")'></td>
            <td class="colhpt">Part Nro</td>
            <td class="normal"><input type="text" id="partida_no" maxlength="8" class="campo" name="partida_no" value="<c:out value="${obj.partida_no}"/>" style="width: 75px" onblur='enviar("partida_no")'></td>
            <td class="colhpt">A&ntilde;o</td>
	    <td class="normal">
<!--	          <input type="text" id="crt_nac_anio" class="campo" name="" value="<c:out value="${obj.crt_nac_anio}"/>" style="width: 50px" onblur='enviar("crt_nac_anio")'> -->
                  <input class="funcional" type="text" id="crt_dia" name="" value="<c:out value="${obj.crt_dia}"/>" style="width: 20px" onblur='enviar("crt_dia");document.getElementById("infboxc").style.display = "none";' maxlength="2" onkeypress="return solo_numeros_0(event)" onfocus="document.getElementById('infboxc').style.display = 'inline';">
		  <input class="funcional" type="text" id="crt_mes" name="" value="<c:out value="${obj.crt_mes}"/>" style="width: 20px" onblur='enviar("crt_mes");document.getElementById("infboxc").style.display = "none";' maxlength="2" onkeypress="return solo_numeros_0(event)" onfocus="document.getElementById('infboxc').style.display = 'inline';">
		  <input class="funcional" type="text" id="crt_anio" name="" value="<c:out value="${obj.crt_anio}"/>" style="width: 35px" onblur='enviar("crt_anio");document.getElementById("infboxc").style.display = "none";' maxlength="4" onkeypress="return solo_numeros_0(event)" onfocus="document.getElementById('infboxc').style.display = 'inline';">
	    </td>
        </tr>
    </table>
    <table cellpadding="0" border="0" cellspacing="0">
        <tr>
            <td>
                <table cellpadding="0" border="0" cellspacing="0">
                    <tr>
                        <td class="colhpt" rowspan="2">Hijo de</td>
                        <td class="colhpt">Nombre del PADRE (Paterno, Materno, Nombres)</td>
                    </tr>
                    <tr>
                        <td class="normal"><input type="text" id="padre_ap_paterno"  maxlength="32" class="campo" name="padre_ap_paterno" value="<c:out value="${obj.padre_ap_paterno}"/>" style="width: 80px" onblur='enviar("padre_ap_paterno")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="padre_ap_materno" maxlength="32"  class="campo" name="padre_ap_materno" value="<c:out value="${obj.padre_ap_materno}"/>" style="width: 80px" onblur='enviar("padre_ap_materno")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="padre_nombre1"   maxlength="64"  class="campo" name="padre_nombre1" value="<c:out value="${obj.padre_nombre1}"/>" style="width: 80px" onblur='enviar("padre_nombre1")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="padre_nombre2"  maxlength="64" class="campo" name="padre_nombre2" value="<c:out value="${obj.padre_nombre2}"/>" style="width: 80px" onblur='enviar("padre_nombre2")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="padre_nombre3"  maxlength="128" class="campo" name="padre_nombre3" value="<c:out value="${obj.padre_nombre3}"/>" style="width: 80px" onblur='enviar("padre_nombre3")' onkeypress='return solo_letras(event)'></td>
                    </tr>
                    <tr>
                        <td class="colhpt" rowspan="2">y de</td>
                        <td class="colhpt">Nombre de la MADRE (Paterno, Materno, Nombres)</td>
                    </tr>
                    <tr>
                        <td class="normal"><input type="text" id="madre_ap_paterno"   maxlength="32" class="campo" name="madre_ap_paterno" value="<c:out value="${obj.madre_ap_paterno}"/>" style="width: 80px" onblur='enviar("madre_ap_paterno")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="madre_ap_materno"   maxlength="32" class="campo" name="madre_ap_materno" value="<c:out value="${obj.madre_ap_materno}"/>" style="width: 80px" onblur='enviar("madre_ap_materno")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="madre_nombre1"   maxlength="64" class="campo" name="madre_nombre1" value="<c:out value="${obj.madre_nombre1}"/>" style="width: 80px" onblur='enviar("madre_nombre1")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="madre_nombre2"   maxlength="64" class="campo" name="madre_nombre2" value="<c:out value="${obj.madre_nombre2}"/>" style="width: 80px" onblur='enviar("madre_nombre2")' onkeypress='return solo_letras(event)'>
                        <input type="text" id="madre_nombre3"   maxlength="128" class="campo" name="madre_nombre3" value="<c:out value="${obj.madre_nombre3}"/>" style="width: 80px" onblur='enviar("madre_nombre3")' onkeypress='return solo_letras(event)'></td>
                    </tr>
                </table>
            </td>
            <td>
                <table cellpadding="0" border="0" cellspacing="0">
                    <tr>
                        <td class="colhpt">Lee</td>
			<td class="colhpt">Escribe</td>
                    </tr>
		    <tr>    
			<td class="normal"><input type="text" id="lee"   maxlength="16" class="campo" name="lee" value="<c:out value="${obj.lee}"/>" style="width: 39px" onblur='enviar("lee")'>
                        <select name="" id="id_lee" class="funcional" onblur='enviar("id_lee")' onchange='enviar("id_lee")' style="width:70px">
			   <option value="0" <c:if test="${obj.id_lee == 0}">selected</c:if>>Si
			   <option value="1" <c:if test="${obj.id_lee == 1}">selected</c:if>>No
			   <option value="2" <c:if test="${obj.id_lee == 2}">selected</c:if>>Sin Dato
			</select></td>                                                
                        <td class="normal"><input type="text" id="escribe"   maxlength="16" class="campo" name="escribe" value="<c:out value="${obj.escribe}"/>" style="width: 39px" onblur='enviar("escribe")'>
                        <select name="" id="id_escribe" class="funcional" onblur='enviar("id_escribe")' onchange='enviar("id_escribe")' style="width:70px">
			   <option value="0" <c:if test="${obj.id_escribe == 0}">selected</c:if>>Si
			   <option value="1" <c:if test="${obj.id_escribe == 1}">selected</c:if>>No
			   <option value="2" <c:if test="${obj.id_escribe == 2}">selected</c:if>>Sin Dato
			</select></td>                        
                    </tr>
                </table>
            </td>
        </tr>
    </table>
      
            </td>
	   </tr>    
        </fieldset>
    </table>


<script>
function estcivil() {
  var est = document.getElementById('id_estado_civil').value;
  if (!(est==3 || est==7)) {
    document.getElementById('datosconyugue').style.visibility = 'visible';
    document.getElementById('cony_ap_paterno').focus();
  }    
  else
    document.getElementById('datosconyugue').style.visibility = 'hidden';  
}
</script>


    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">DATOS DE ESTADO CIVIL</legend>  

  <table cellpadding="0" border="0" cellspacing="0">     
   <tr>
    <td>
    <table cellpadding="0" border="0" cellspacing="0">     
      <tr>
	<td class="colhpt">E. Civil</td>
        <td class="normal">
<!--	<input type="text" id="estado_civil" class="campo" name="" value="<c:out value="${obj.estado_civil}"/>" style="width: 50px" onblur='enviar("estado_civil")'> -->
        <select name="" id="id_estado_civil" class="funcional" onblur='enviar("id_estado_civil")' onchange='enviar("id_estado_civil");estcivil();'>
            <c:forEach var="lista" items="${listaestcivil.pageList}">
                <option value="<c:out value="${lista.cod_estcivil}"/>" <c:if test="${lista.cod_estcivil == obj.id_estado_civil}">selected</c:if>><c:out value="${lista.descripcion}"/></option>
            </c:forEach>
        </select>
        </td>
      </tr>	
    </table>
    </td>
    <td style="padding-left: 22px">    
    <table id="datosconyugue" cellpadding="0" border="0" cellspacing="0" style="visibility: hidden">
        <tr>
            <td class="colhpt" rowspan="2">Conyugue</td>
            <td class="colhpt">Nombre Conyugue (Paterno, Materno, Nombres)</td>
        </tr>    
        <tr>        
            <td class="normal"><input type="text" id="cony_ap_paterno"   maxlength="32" class="campo" name="cony_ap_paterno" value="<c:out value="${obj.cony_ap_paterno}"/>" style="width: 90px" onblur='enviar("cony_ap_paterno")' onkeypress='return solo_letras(event)'>
            <input type="text" id="cony_ap_materno"   maxlength="32" class="campo" name="cony_ap_materno" value="<c:out value="${obj.cony_ap_materno}"/>" style="width: 90px" onblur='enviar("cony_ap_materno")' onkeypress='return solo_letras(event)'>
            <input type="text" id="cony_nombre1"   maxlength="64" class="campo" name="cony_nombre1" value="<c:out value="${obj.cony_nombre1}"/>" style="width: 90px" onblur='enviar("cony_nombre1")' onkeypress='return solo_letras(event)'>
            <input type="text" id="cony_nombre2"   maxlength="64" class="campo" name="" value="<c:out value="${obj.cony_nombre2}"/>" style="width: 90px" onblur='enviar("cony_nombre2")' onkeypress='return solo_letras(event)'>
            <input type="text" id="cony_nombre3"   maxlength="128" class="campo" name="" value="<c:out value="${obj.cony_nombre3}"/>" style="width: 90px" onblur='enviar("cony_nombre3")' onkeypress='return solo_letras(event)'></td>
        </tr>
	<tr><td colspan="2">
        <table cellpadding="0" border="0" cellspacing="0">
	<tr>
            <td class="colhpt">Of.R.C.Nro</td>
            <td class="normal"><input type="text" id="ofic_rcn_cony"   maxlength="64" class="campo" name="" value="<c:out value="${obj.ofic_rcn_cony}"/>" style="width: 63px" onblur='enviar("ofic_rcn_cony")'></td>
            <td class="colhpt">Lib Nro</td>
            <td class="normal"><input type="text" id="libro_no_cony"   maxlength="8" class="campo" name="" value="<c:out value="${obj.libro_no_cony}"/>" style="width: 63px" onblur='enviar("libro_no_cony")'></td>
            <td class="colhpt">Part Nro</td>
            <td class="normal"><input type="text" id="partida_no_cony"   maxlength="8" class="campo" name="" value="<c:out value="${obj.partida_no_cony}"/>" style="width: 63px" onblur='enviar("partida_no_cony")'></td>
            <td class="colhpt">A&ntilde;o</td>
            <td class="normal" colspan="0">
<!--	          <input type="text" id="anio_cony" class="campo" name="" value="<c:out value="${obj.anio_cony}"/>" style="width: 50px" onblur='enviar("anio_cony")'> -->
                  <input type="text" id="cony_dia" class="funcional" name="" value="<c:out value="${obj.cony_dia}"/>" style="width: 20px" onblur='enviar("cony_dia");document.getElementById("infboxco").style.display = "none";' maxlength="2" onkeypress='return solo_numeros_0(event)' onfocus="document.getElementById('infboxco').style.display = 'inline';">
		  <input type="text" id="cony_mes" class="funcional" name="" value="<c:out value="${obj.cony_mes}"/>" style="width: 20px" onblur='enviar("cony_mes");document.getElementById("infboxco").style.display = "none";' maxlength="2" onkeypress='return solo_numeros_0(event)' onfocus="document.getElementById('infboxco').style.display = 'inline';">
		  <input type="text" id="cony_anio" class="funcional" name="" value="<c:out value="${obj.cony_anio}"/>" style="width: 35px" onblur='enviar("cony_anio");document.getElementById("infboxco").style.display = "none";' maxlength="4" onkeypress='return solo_numeros_0(event)' onfocus="document.getElementById('infboxco').style.display = 'inline';">
	    </td>
	</tr>
	<tr><td colspan="4"></td>
	<td colspan="4" align="right">

<table cellpadding="0" border="0" cellspacing="0">	
<tr><td><div id="error4co" style="position:relative; display:none">
<table cellpadding="0" border="0" cellspacing="0" style="border: 1px solid RED; color: RED; background-color: #FFE9E9;">
<tr ><td style="padding-left:5px"><img src="icon_error.gif" width="16" height="16"/></td>
    <td class="normal"> La <b>Fecha</b>, no es valida </td>
</tr>
</table>    
</div>
</td><td>
<div id="infboxco" style="position:relative; display:none">
<table cellpadding="0" border="0" cellspacing="0" style="border: 1px solid #D6D169; background-color: #FBFFAE;">
<tr><td style="padding-left:5px"><img src="images/icon_inf.gif" width="16" height="16"/></td>
    <td class="normal" style=><b>Fecha: Ejemplo 16 03 2005</b></td>
</tr>
</table>    
</div>
</td></tr>
</table>
	
	</td>
	</tr>
	</table>
	</td></tr>
    </table>
    </td>
   </tr>        
  </table>
   
            </td>
	   </tr>    
        </fieldset>
    </table>








    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">DATOS DE SERVICIO, PROFESIONES Y DESCRIPCION</legend>  


    <table cellpadding="0" border="0" cellspacing="0">
        <tr style="padding-left:5px">
            <td class="colhpt">Estatura</td>
            <td class="normal"><input type="text" id="altura" class="campo" name="" value="<c:out value="${obj.altura}"/>" style="width: 30px" onblur='enviar("altura")' maxlength="3" onkeypress='return solo_numeros_0(event)'><b>cm</b></td>
            <td class="colhpt">G. sang.</td>
            <td class="normal">
<!--	      <input type="text" id="grupo_sanguineo" class="campo" name="" value="<c:out value="${obj.descripcion}"/>" style="width: 50px" onblur='enviar("descripcion")' maxlength="5"> -->
	    
                            <select id="id_grupo_sanguineo" name="" class="funcional" onblur='enviar("id_grupo_sanguineo")' onchange='enviar("id_grupo_sanguineo")'>
			         <c:forEach var="lista" items="${listagruposang.pageList}">> 
			           <option value='<c:out value="${lista.id_grupo_sanguineo}"/>' <c:if test="${obj.id_grupo_sanguineo == lista.id_grupo_sanguineo}">selected</c:if>><c:out value="${lista.descripcion}"/></option>
				 </c:forEach>  
                            </select>	    
			    
	    </td>
	 </tr>
	 <tr>    
            <td class="colhpt">Serv Militar</td>
            <td class="normal"><input type="text" id="servicio_militar" maxlength="32" class="campo" name="" value="<c:out value="${obj.servicio_militar}"/>" style="width: 120px" onblur='enviar("servicio_militar")'></td>
            <td class="colhpt">Nro</td>
            <td class="normal"><input type="text" id="nro_libreta" maxlength="16" class="campo" name="" value="<c:out value="${obj.nro_libreta}"/>" style="width: 120px" onblur='enviar("nro_libreta")'></td>
            <td class="colhpt">Profesi&oacute;n</td>
            <td class="normal"><input type="text" id="profesion"  maxlength="128" class="campo" name="" value="<c:out value="${obj.profesion}"/>" style="width: 270px" onblur='enviar("profesion")'></td>

        </tr>		
    </table>
            
    <table cellpadding="0" border="0" cellspacing="0">
        <tr>
            <td class="colhpt">Causa Filiacion</td>
            <td class="normal" colspan="0"><input type="text" id="causa_filiacion" maxlength="64" class="campo" name="" value="<c:out value="${obj.causa_filiacion}"/>" style="width: 70px" onblur='enviar("causa_filiacion")'>
                <select name="" id="id_causa_filiacion" class="funcional" onblur='enviar("id_causa_filiacion")' onchange='enviar("id_causa_filiacion")'>
                    <c:forEach var="lista" items="${listafiliacion.pageList}">
                        <option value="<c:out value="${lista.cod_filiacion}"/>" <c:if test="${lista.cod_filiacion == obj.id_causa_filiacion}">selected</c:if>><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td class="colhpt">Se&ntilde;as Particulares</td>
            <td class="normal"><input type="text" id="senias_particulares" maxlength="256" class="campo" name="" value="<c:out value="${obj.senias_particulares}"/>" style="width: 293px" onblur='enviar("senias_particulares")'></td>
        </tr> 
    </table>	
    <table cellpadding="0" border="0" cellspacing="0">
	<tr>  
            <td class="colhpt">Serie</td>
            <td class="normal"><input type="text" id="serie" maxlength="8" class="campo" name="" value="<c:out value="${obj.serie}"/>" style="width: 40px" onblur='enviar("serie")' onkeypress="return solo_serie(event)" maxlength="6"></td>
            <td class="colhpt">Secci&oacute;n</td>
            <td class="normal"><input type="text" id="seccion" maxlength="8" class="campo" name="" value="<c:out value="${obj.seccion}"/>" style="width: 40px" onblur='enviar("seccion")' onkeypress="return solo_seccion(event)" maxlength="6"></td>
            <td class="colhpt">Ocupaciones</td>
	    <td class="normal">
                <select id="ocupacion" name="" class="funcional" style="width: 350px">
		        <option></option>
                    <c:forEach var="lista" items="${listaocupaciones.pageList}">
                        <option value="<c:out value="${lista.cod_grp}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select><input id="" type="button" name="" value="+" style="width: 10px" onclick='enviarprofesion(document.getElementById("ocupacion").value,"add")'>
            </td>
	    <td class="normal"><a href="javascript:showAvanzadas()" style="text-decoration: none">[Avanzadas]</a></td>
        </tr>
    </table>
    <table cellpadding="0" border="0" cellspacing="0">
    <tr><td>     
    </td></tr><tr><td>
    <div id="lstprofesiones">

	<table>
	<c:forEach var="lista" items="${obj.ocupaciones}">
	 <tr>
	  <td class=colb><c:out value="${lista.descripcion}"/></td>
	  <td class=normal><a href="javascript:enviarprofesion('<c:out value="${lista.cod_grp}"/>','less')" style="text-decoration: none"><b>[Eliminar]</b></a></td>
	 </tr>  
	</c:forEach>          
        </table>
            
    </div>
    </td></tr>
    </table>



<script>
function clearField(c) {
  document.getElementById(c).innerHTML = "";    
  
}
function showAvanzadas() {
  document.getElementById('avanzadas').style.display = 'inline';
}
function hideAvanzadas() {
  document.getElementById('avanzadas').style.display = 'none';
}
</script>

<div id="avanzadas" style="position: relative; display: none; ">
    <table cellpadding="0" border="0" cellspacing="0">
        <tr>

            <td class="colhpt">G1</td>
	    <td class="normal">
                <select id="g1" name="g2" class="funcional" style="width: 350px" onblur='getGrupos("g1","g2");clearField("g3");clearField("g4");clearField("g5");' onchange='getGrupos("g1","g2");clearField("g3");clearField("g4");clearField("g5");'>
                    <c:forEach var="lista" items="${listag1.pageList}">
                        <option value="<c:out value="${lista.cod_grp}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
	<tr>

            <td class="colhpt">G2</td>
	    
            <td class="normal">
            <select id="g2" name="g3" class="funcional" style="width: 350px" onblur='getGrupos("g2","g3");clearField("g4");clearField("g5");' onchange='getGrupos("g2","g3");clearField("g4");clearField("g5");'>	    
	    </select>
            </td>    
        </tr>
	<tr>
           

            <td class="colhpt">G3</td>
            
	    <td class="normal">
            <select id="g3" name="g4" class="funcional" style="width: 350px" onblur='getGrupos("g3","g4");clearField("g5");' onchange='getGrupos("g3","g4");clearField("g5");'>	    
	    </select>
            </td>           
        </tr>
	<tr>


            <td class="colhpt">G4</td>
            
	    <td class="normal">
            <select id="g4" name="g5" class="funcional" style="width: 350px" onblur='getGrupos("g4","g5")' onchange='getGrupos("g4","g5")'>	    
	    </select>
            </td>           
        </tr>
	<tr>


            <td class="colhpt">Ocupaci&oacute;n</td>
            
	    <td class="normal">
            <select id="g5" class="funcional" style="width: 350px" onblur='' onchange=''>	    
	    </select>
	    <input id="" type="button" name="" value="+" style="width: 10px" onclick='enviarprofesion(document.getElementById("g5").value,"add")'> 
	    <a href="javascript:hideAvanzadas()" style="text-decoration: none">[Ocultar avanzadas]</a>
            </td>           
        </tr>
    </table>    
</div>    
    
    
</form>

            </td>
	   </tr>    
        </fieldset>
    </table>

<div id="anverso">
</div>
<!-- Campos para Extranjero _ -->
<div id="extranjero" style="display: none">

<table width="95%" align="center">
        <tr>
        <td>
        <fieldset>
            <legend class="normal">PASAPORTE</legend>
    <table cellpadding="0" border="0" cellspacing="0">
     <tr>
	<td class="colhpt">Pasaporte No</td>
	<td class="colhpt">Otorgado por</td>
	<td class="colhpt">Visado en</td>
	<td class="colhpt">El</td>
	<td class="colhpt">Lugares donde ha residido en otros paises</td>
     </tr>
     <tr>
	<td><input id="pasaporte" maxlength="16" type="text" class="campo" name="" value="<c:out value="${obj.pasaporte}"/>" style="width: 80px" onblur='enviar("pasaporte")'></td>
	<td><input id="pste_otorgado" maxlength="32" type="text" class="campo" name="" value="<c:out value="${obj.pste_otorgado}"/>" style="width: 80px" onblur='enviar("pste_otorgado")'></td>
	<td><input id="pste_visado"  maxlength="32" type="text" class="campo" name="" value="<c:out value="${obj.pste_visado}"/>" style="width: 80px" onblur='enviar("pste_visado")'></td>
	<td><input id="pste_fecha"  maxlength="32" type="text" class="campo" name="" value="<c:out value="${obj.pste_fecha}"/>" style="width: 80px" onblur='enviar("pste_fecha")'></td>
	<td><input id="pste_otra_residencia"  maxlength="64" type="text" class="campo" name="" value="<c:out value="${obj.pste_otra_residencia}"/>" style="width: 100%" onblur='enviar("pste_otra_residencia")'></td>
     </tr>
    </table>
    </fieldset>
        <fieldset>
            <legend class="normal">CAMPOS PARA EXTRANJEROS</legend>
    <table cellpadding="0" border="0" cellspacing="0">
     <tr>
	<td class="colhpt">Nombre Supuesto</td>
	<td class="colhpt">Numero Penal</td>
	<td class="colhpt">Numero de Censo</td>
	<td class="colhpt">Radicatoria</td>
	<td class="colhpt">Permanencia</td>
     </tr>
     <tr>
	<td><input id="nombre_supuesto"  maxlength="32" type="text" class="campo" name="" value="<c:out value="${obj.nombre_supuesto}"/>" style="width: 80px" onblur='enviar("nombre_supuesto")'></td>
	<td><input id="nro_penal"  maxlength="16" type="text" class="campo" name="" value="<c:out value="${obj.nro_penal}"/>" style="width: 80px" onblur='enviar("nro_penal")'></td>
	<td><input id="nro_censo"  maxlength="16" type="text" class="campo" name="" value="<c:out value="${obj.nro_censo}"/>" style="width: 80px" onblur='enviar("nro_censo")'></td>
	<td><input id="radicatoria"  maxlength="64" type="text" class="campo" name="" value="<c:out value="${obj.radicatoria}"/>" style="width: 80px" onblur='enviar("radicatoria")'></td>
	<td><input id="permanencia"  maxlength="64" type="text" class="campo" name="" value="<c:out value="${obj.permanencia}"/>" style="width: 80px" onblur='enviar("permanencia")'></td>
     </tr>
    </table>
    </fieldset>
</table>

</div>
<!-- Fin Campos para Extranjero _ -->



<!--
<div id="comentario_anverso" style="visibility:hidden">
-->
	        

    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">COMENTARIO</legend>  
    <table cellpadding="0" border="0" cellspacing="0" width="95%" align="center">
        <tr>
         <td class="normal"><textarea id="comentario_a" maxlength="256" value="" class="campo" style="width: 550px; height: 40px" onblur='enviar("comentario_a");change(900,document.getElementById("current"));ocultar();window.scroll(0,0);document.getElementById("id_relacion").focus()'><c:out value="${obj.comentario_a}"/></textarea></td>
<!--	 <td class="colhpt">Nro. Huellas</td>
	 <td class="normal"><input id="nro_huellas_a" type="text" class="campo" name="" value="<c:out value="${obj.nro_huellas_a}"/>" style="width: 30px" onblur='enviar("nro_huellas_a")' maxlength="2" onkeypress='return solo_numeros_0(event)'></td>
-->	 
        </tr>
    </table>
            </td>
	   </tr>    
        </fieldset>
    </table>
<!-- </div> -->






</div>

<script>
 function mostrar() {
    document.getElementById("AV").style.display="inline";
    document.getElementById("RV").style.display="none";
 }
 function ocultar() {
    document.getElementById("AV").style.display="none";
    document.getElementById("RV").style.display="inline";
 }
</script>

<br><br><br><br><br><br><br><br>
<!--    ===================================================  DESDE AQUI MODIFICADO LUNES 30 DE JULIO POR ROGER ======================= -->

<!-- relaciones -->    
<script>
function enviarrelaciones() {
      var id_relacion = document.getElementById('id_relacion').value;
      var ap_paterno = document.getElementById('rel_ap_paterno').value;
      var ap_materno = document.getElementById('rel_ap_materno').value;
      var nombre1 =  document.getElementById('rel_nombre1').value;
      var direccion = document.getElementById('rel_direccion').value;
      var cedula = document.getElementById('rel_cedula').value;
      
      if (document.getElementById('rel_extranjero').checked)
         var extranjero = document.getElementById('rel_extranjero').value;
      else 
         var extranjero = "N";
	  	 
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
          req = new XMLHttpRequest();
          if (req.overrideMimeType) {
             req.overrideMimeType('text/xml');
          }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
          try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
        }
      }
      req.open('GET','<c:url value="/parientes.do"/>?clave=R&key=add&id='+id_relacion+'&ap_paterno='+ap_paterno+'&ap_materno='+ap_materno+'&nombre1='+nombre1+'&direccion='+direccion+'&extranjero='+extranjero+'&cedula='+cedula, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('listarelaciones').innerHTML = mes;
                }
           }                   
        };
        req.send(null);
}
function eliminarrelacion(codigo) {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
          req = new XMLHttpRequest();
          if (req.overrideMimeType) {
             req.overrideMimeType('text/xml');
          }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
          try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
        }
      }
      req.open('GET','<c:url value="/parientes.do"/>?clave=R&key=less&codigo='+codigo, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('listarelaciones').innerHTML = mes;
                }
           }                   
        };
        req.send(null);
}
function enviarparientes() {
      var id_relacion = document.getElementById('id_pariente').value;
      var ap_paterno = document.getElementById('par_ap_paterno').value;
      var ap_materno = document.getElementById('par_ap_materno').value;
      var nombre1 =  document.getElementById('par_nombre1').value;
      var direccion = document.getElementById('par_direccion').value;
      var cedula = document.getElementById('par_cedula').value;
      
      if (document.getElementById('par_extranjero').checked)
         var extranjero = document.getElementById('par_extranjero').value;
      else 
         var extranjero = "N";
	  	 
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
          req = new XMLHttpRequest();
          if (req.overrideMimeType) {
             req.overrideMimeType('text/xml');
          }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
          try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
        }
      }
      req.open('GET','<c:url value="/parientes.do"/>?clave=P&key=add&id='+id_relacion+'&ap_paterno='+ap_paterno+'&ap_materno='+ap_materno+'&nombre1='+nombre1+'&direccion='+direccion+'&extranjero='+extranjero+'&cedula='+cedula, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('listaparientes').innerHTML = mes;
                }
           }                   
        };
        req.send(null);
}
function eliminarpariente(codigo) {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
          req = new XMLHttpRequest();
          if (req.overrideMimeType) {
             req.overrideMimeType('text/xml');
          }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
          try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
        }
      }
      req.open('GET','<c:url value="/parientes.do"/>?clave=P&key=less&codigo='+codigo, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('listaparientes').innerHTML = mes;
                }
           }                   
        };
        req.send(null);
}
function enviartramites() {
      var id_relacion = document.getElementById('id_tramite').value;
      var tramite = document.getElementById('tramite').value;
      
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
          req = new XMLHttpRequest();
          if (req.overrideMimeType) {
             req.overrideMimeType('text/xml');
          }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
          try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
        }
      }
      req.open('GET','<c:url value="/parientes.do"/>?clave=T&key=add&id='+id_relacion+'&direccion='+tramite, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('listatramites').innerHTML = mes;
                }
           }                   
        };
        req.send(null);
}
function eliminartramite(codigo) {
      var contenttype = 'application/x-www-form-urlencoded';
      var req=null;   
      if (window.XMLHttpRequest) { // Mozilla, Safari,...
          req = new XMLHttpRequest();
          if (req.overrideMimeType) {
             req.overrideMimeType('text/xml');
          }
      } else if (window.ActiveXObject) { // IE
        try {
          req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
          try {
            req = new ActiveXObject("Microsoft.XMLHTTP");
          } catch (e) {}
        }
      }
      req.open('GET','<c:url value="/parientes.do"/>?clave=T&key=less&codigo='+codigo, true);
      
      req.setRequestHeader('Content-Type', contenttype);
      req.onreadystatechange = 
        function() { ''
           if (req.readyState == 4){
                if (req.status == 200)
                {   
		   var mes = req.responseText;
		   document.getElementById('listatramites').innerHTML = mes;
                }
           }                   
        };
        req.send(null);
}

</script>


<div id="RV" style="display: none">


    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">RELACIONES</legend>  

<table cellpadding="0" border="0" cellspacing="0">    
    <tr>
        <td class="colhpt">Relaci&oacute;n</td>
        <td class="colhpt">Nombre Completo (Paterno, Materno, Nombres) <div id="rel_ext"></div></td>
        <td class="colhpt">Direcci&oacute;n</td>
        <td class="colhpt">C&eacute;dula</td>
	<td></td>
	<td></td>
    </tr>    
    <tr>
        <td><select id='id_relacion' name="id_relacion" class="campo" onblur='' onchange=''>
              <c:forEach var="lista" items="${listaparientes.pageList}">
                <option value="<c:out value="${lista.cod_parentesco}"/>"><c:out value="${lista.descripcion}"/></option>
              </c:forEach>
	    </select>
	</td>
        <td><input id="rel_ap_paterno" type="text" class="campo" name="rel_ap_paterno" value="" style="width: 80px">
        <input id="rel_ap_materno" type="text" class="campo" name="rel_ap_materno" value="" style="width: 80px">
        <input id="rel_nombre1" type="text" class="campo" name="rel_nombre1" value="" style="width: 100px">
	</td>
        <td><input id="rel_direccion" type="text" class="campo" name="rel_direccion" value="" style="width: 200px"></td>
        <td><input id="rel_cedula" type="text" class="campo" name="rel_cedula" value="" style="width: 70px" onkeypress='return val_ci(event)'></td>
	<td><input id="rel_extranjero" type="checkbox" class="campo" name="rel_extranjero" value="E" style="display: none"></td>
	<td><input id="" type="button" name="" value="+" style="width: 10px" onclick='enviarrelaciones();'></td>
    </tr>
    <tr><td colspan="5">
      <div id='listarelaciones'></div>
    </td>
    </tr>  
</table>
            
           </fieldset>
            </td>
	   </tr>    
    </table>
<script>enviarrelaciones();</script>




    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">PARIENTES</legend>  

<table cellpadding="0" border="0" cellspacing="0">


    <tr>
        <td class="colhpt">Parientes</td>
        <td class="colhpt" id="par_td">Nombre Completo (Paterno, Materno, Nombres) <div id="par_ext"></div></td>
        <td class="colhpt" id="par_td">Direcci&oacute;n</td>
	<td class="colhpt">C&eacute;dula</td>
	<td></td>
	<td></td>
    </tr>    
    <tr>
        <td><select id ='id_pariente' name="" class="campo">
              <c:forEach var="lista" items="${listaparientes.pageList}">
                <option value="<c:out value="${lista.cod_parentesco}"/>"><c:out value="${lista.descripcion}"/></option>
              </c:forEach>
	    </select>
	</td>
        <td><input id ='par_ap_paterno' type="text" class="campo" name="" value="" style="width: 80px">
        <input id ='par_ap_materno' type="text" class="campo" name="" value="" style="width: 80px">
        <input id ='par_nombre1' type="text" class="campo" name="" value="" style="width: 100px">
	</td>

        <td><input id ='par_direccion' type="text" class="campo" name="" value="" style="width: 200px"></td>
        <td><input id ='par_cedula' type="text" class="campo" name="" value="" style="width: 70px" onkeypress='return val_ci(event)'></td>
        <td><input id ='par_extranjero' type="checkbox" class="campo" name="" value="E" style="display: none"></td>
	<td><input id ='but2' type="button" name="" value="+" style="width: 10px" onclick='enviarparientes();'></td>
     <tr><td colspan="5"><div id='listaparientes'></div> </td>
     </tr>            	         
</table>  
            </td>
	   </tr>    
        </fieldset>
    </table>
<script>enviarparientes();</script>


    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">DOMICILIO</legend>  
   <table cellpadding="0" border="0" cellspacing="0">
      <tr>
        <td class="colhpt">Localidad</td>
        <td class="colhpt">Zona</td>
        <td class="colhpt">Avenida/Calle</td>  
        <td class="colhpt">Nro.</td>
	<td class="colhpt">Ubicaci&oacute;n</td>
      </tr>         
      <tr>
        <td><input id="dom_localidad" type="text" class="campo" name="" value="<c:out value="${obj.dom_localidad}"/>" style="width: 150px" onblur='enviar("dom_localidad")'></td>
        <td><input id="zona" type="text" class="campo" name="" value="<c:out value="${obj.zona}"/>" style="width: 150px" onblur='enviar("zona")'></td>
<!--        <td><input id="barrio" type="text" class="campo" name="" value="<c:out value="${obj.barrio}"/>" style="width: 80px" onblur='enviar("barrio")'></td>  -->
        <td><input id="calle" type="text" class="campo" name="" value="<c:out value="${obj.calle}"/>" style="width: 150px" onblur='enviar("calle")'</td>
        <td><input id="nro_casa" type="text" class="campo" name="" value="<c:out value="${obj.nro_casa}"/>" style="width: 40px" onblur='enviar("nro_casa")'></td>
        <td><input id="ubicacion" type="text" class="campo" name="" value="<c:out value="${obj.ubicacion}"/>" style="width: 250px" onblur='enviar("ubicacion")'></td>
      </tr>
   </table>    
            </td>
	   </tr>    
        </fieldset>
    </table>



    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">TRAMITES</legend>  
   <table cellpadding="0" border="0" cellspacing="0">
     <tr>
        <td></td>       
        <td>
          <select id="id_tramite" name="" class="campo">
              <c:forEach var="lista" items="${listatramite.pageList}">
                <option value="<c:out value="${lista.cod_tramite}"/>"><c:out value="${lista.descripcion}"/></option>
              </c:forEach>
          </select>
          <input id="tramite" type="text" class="campo" name="" value="" style="width: 350px">
          <input type="button" name="" value="+" style="width: 10px" onclick='enviartramites()'>
        </td>                 
     </tr>
     <tr><td colspan="2"><div id='listatramites'></div></td>
     </tr>	
    </table>
            </td>
	   </tr>    
        </fieldset>
    </table>
<script>eliminartramite('0');</script>
  
<!-- ===============================================MODIFICACION HASTA AQUI LUNES 30JULIO POR ROGER===========================================-->

    <table width="95%" align="center">
        <tr>
        <td> 
        <fieldset>
            <legend class="normal">COMENTARIO</legend>  
    <table cellpadding="0" border="0" cellspacing="0" width="90%" align="center">
        <tr>
         <td class="normal"><textarea id="comentario_r" maxlength="256" class="campo" style="width: 550px; height: 40px" onblur='enviar("comentario_r")'><c:out value="${obj.comentario_r}"/></textarea></td>
<!--	 <td class="colhpt">Nro. Huellas</td>
	 <td class="normal"><input id="nro_huellas_r" type="text" class="campo" name="" value="<c:out value="${obj.nro_huellas_r}"/>" style="width: 30px" onblur='enviar("nro_huellas_r")' maxlength="2" onkeypress='return validarN(event)'></td>
-->	 
        </tr>
	<tr>	 
	 <td class="normal" align="right" colspan="3" style="padding-top: 10px; padding-bottom: 10px">
	  <div id="showinfotarjeta" style="display:none"><table><tr><td class="normal" style="background-color:RED; color:WHITE; padding-left:20px; padding-right:20px">HAY ERRORES EN EL FORMULARIO, POR FAVOR REVISE.</td></tr></table></div>
	  <input id="guardartarjeta" type="button" name="" value="Guardar Tarjeta" style="" onclick="guardar();">
	 </td> 
        </tr>
	
    </table>
            </td>
	   </tr>    
        </fieldset>
    </table>                 
</div>





<form id="frmSend" method="GET" action='<c:url value="/transcripcion.do"/>'>
<input type="hidden" name="transcripcion" value="guardar">
</form>

<script>
initExtranjero();estcivil();document.getElementById('ap_paterno').focus();
function setverificarinfo() {
  var vinfo1 = validarfechan2("nac_dia","nac_mes","nac_anio","error4n"); 
  var vinfo2 = validarfechan2("crt_dia","crt_mes","crt_anio","error4c");
  var vinfo3 = validarfechan2("cony_dia","cony_mes","cony_anio","error4co");
  
  if (vinfo1 && vinfo2 && vinfo3) {
    document.getElementById('guardartarjeta').disabled = false;
    document.getElementById('showinfotarjeta').style.display = 'none';
  }    
  else {
    document.getElementById('guardartarjeta').disabled = true;
    document.getElementById('showinfotarjeta').style.display = 'inline';
  }    
  
}
setInterval('setverificarinfo()',5000);
//setInterval('validarfechan2("crt_dia","crt_mes","crt_anio","error4c")',5000);
//setInterval('validarfechan2("cony_dia","cony_mes","cony_anio","error4co")',5000);
</script>   

<div id="infoci" style="position: fixed; right: 0px; top: 250px; background-color: #000000; z-index: 1">
<table cellpadding="0" cellspacing="0" style="border: 1px solid #000000; background-color: #EEEEEE">     
<tr><td align="center" style="padding-right:5px; padding-top: 5px; padding-left: 5px;">
<img src="images/log-emer-2.png" width="130" height="70" alt="logo"/>
</td></tr>
<tr><td>
<table align="center" style="background-color:#EEEEEE">
    <tr>        
       <td style="padding-left:20px; padding-top:10px;"><img src="images/loading.gif" width="20" height="20" alt="loading"/></td>
       <td class="colhp" style="font-size:18px; padding-right:20px; padding-top: 10px; padding-bottom: 10px; color:#000000"><div id="showcedula"></div></td>
    </tr>
</table>
</td></tr>
</table>
</div>


<div id="infoobs" style="position: fixed; left: 0px; top: 370px; background-color: #000000; z-index: 1">
    <table cellpadding="0" border="0" cellspacing="0" width="" align="left">
        <tr>
         <td class="colhpt" style="color:black;font-size:12px; background-color:orange; padding-top:5px; padding-bottom:5px; padding-left:20px; padding-right:20px">OBSERVACION:</td>
         <td class="normal" style="font-size:12px; color:#FFFFFF;"><c:out value="${descripcion}"/></td>
        </tr>
    </table>
</div>


<%@ include file="../VerPieCuerpo.jsp" %>