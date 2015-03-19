<%@ include file="../Cabecera.jsp" %>
<script language='JavaScript' SRC="./ajax.js"> </script>
<script language="JavaScript">    
//========== CONEXION ================
var nump = 0;      

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

var xmlhttp;
function getconne() {
    xmlhttp = null;
    xmlhttp = AjaxHttp();      
    xmlhttp.onreadystatechange = cambiarEstado;
    xmlhttp.open('GET','<c:url value="/getconexion.do"/>', true);
    xmlhttp.send(null);      
}

function cambiarEstado() {
  if (xmlhttp.readyState == 4) {
     try {
      if (xmlhttp.status==200) {    
      // conectado
		   document.getElementById('conexionErr').style.display = 'none';
		   document.getElementById('conexion').style.display = 'inline';
                   var mes = xmlhttp.responseText;
		   document.getElementById('conexion').innerHTML = mes;
		   if (document.getElementById('status').value == 'false') {
		      document.getElementById('frmSend').submit();
		   }
         return;
      }
      else {
      alert("Problem retrieving XML data")
	//	   document.getElementById('conexion').style.display = 'none';
	//	   document.getElementById('conexionErr').style.display = 'inline';
      }
    } catch(err) {
      // no conectado      
		   document.getElementById('conexion').style.display = 'none';
		   document.getElementById('conexionErr').style.display = 'inline';
		   
      setTimeout('getconn',20000);
    }
  }
}
            
</script>
<style type="text/css">
.categoria A:link    { COLOR: #FFFFFF; TEXT-DECORATION: none }
.categoria A:visited { COLOR: #FFFFFF; TEXT-DECORATION: none }
.categoria A:active  { COLOR: #FFFFFF; TEXT-DECORATION: none }
.categoria A:hover   { COLOR: #FFA652; TEXT-DECORATION: none; }
.categoria {
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-size: 10px;
    font-weight : bold;
    color: #FFFFFF;
    text-decoration: none;
    background-color: #0F3950;
    border:#FFFFFF 1px solid;
    padding-left:7px;
    padding-right:7px;
    padding-top:3px;
    padding-bottom:3px
}
.titulomenu {
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-size: 9px;
    font-weight : bold;
    color: #FFFFFF;
    text-decoration: none;
    background-color: #000000;
    border:#FFFFFF 1px solid;
    padding-left:7px;
    padding-right:7px;
    padding-top:3px;
    padding-bottom:3px
}    
</style>    
<table width="90%" border="0" cellspacing="1" cellpadding="0">
    <tr>
    <td align="center" class="titulomenu">MENU</td>
    <c:forEach var="categorias" items="${listaDeCategorias}">
        <tr>
        <td class="categoria">
        <img width='10' height='10' src='./imagenes/<c:out value="${categorias.imagen}"/>' border=0>
        <a href="<c:url value="/menu.do"><c:param name="id_categoria" value="${categorias.id_categoria}"/></c:url>">
            <c:out value="${categorias.categoria}"/>
        </a>
        <c:if test="${id_categoria == categorias.id_categoria}">
            <tr>
            <td> 
            <table width="100%" border="0" cellspacing="0" cellpadding="0">    
                <c:forEach var="enlaces" items="${listaDeEnlaces}">
                    <tr>
                    <td class="colb" style="padding-top:3px; padding-bottom:3px"> 
                    <a href="<c:url value="${enlaces.ruta_enlace}"></c:url>" target="cuerpo"><c:out value="${enlaces.nombre_enlace}"/></a>
                </c:forEach>
            </table>            
        </c:if>
    </c:forEach>
</table> 
<br>
    <table cellpadding="0" cellspacing="0" width="90%" style="border: 1px solid #000000; background-color:#000000">     
        <tr><td>
                <table align="center">
                    <tr>        
                        <td class="normal" style="padding-top:5px; padding-bottom:5px; color: #FFFFFF">
			    El <b>sistema</b> verifica automaticamente el estado de conexion con el servidor.
			</td
                    </tr>
                </table>
        </td></tr>
    </table>
<div id='conexion'>
    <table cellpadding="0" cellspacing="0" width="90%" style="border: 1px solid #7D7D7D">     
        <tr><td>
                <table align="center">
                    <tr>        
                        <td><img src="./images/loading.gif" width="32" height="32" alt="loading"/></td>
                        <td class="normal" style="padding-top: 10px; padding-bottom: 10px; color:#7D7D7D">CONECTANDO...</td>
                    </tr>
                </table>
        </td></tr>
    </table>
</div>
<div id='conexionErr' style="display: none">
    <table cellpadding="0" cellspacing="0" width="90%" style="border: 1px solid RED">     
        <tr><td>
                <table align="center">
                    <tr>        
                        <td><img src="./icon_error.gif" alt="error"/></td>
                        <td class="normal" style="padding-top: 10px; padding-bottom: 10px; color: RED"><b>SIN CONEXION</b></td>
                    </tr>
                </table>
        </td></tr>
    </table>
</div>

<div id='count'></div>

<a href="javascript:getconn()">conn</a>
<script>
var n=0;
//getconn();
function reactiveConn() {
 getconn();
// document.getElementById('count').innerHTML = '<font class="normal">'+n+'</font>';
// n++;
 setTimeout(reactiveConn,60000);
}
//reactiveConn();
//setInterval("getconn()",60000);
</script>

<%@ include file="../VerPieCuerpo.jsp" %>