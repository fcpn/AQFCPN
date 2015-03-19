<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>
<style type="text/css">
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
    font-size: 9px;
    border: 1px solid #7D7D7D;
    margin-left: 1px;
    margin-top: 1px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    padding: 1px;
    font-weight: bold;
    color: #666666;
    margin-bottom: 1px;
    background-color: #FFEE99;
    }    
    .campo {
    font-size: 9px;
    border: 1px solid #7D7D7D;
    margin-left: 1px;
    margin-top: 1px;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    padding: 1px;
    font-weight: bold;
    color: #666666;
    margin-bottom: 1px;
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

<!--
    //border: 1px solid #0099FF;
    //width: 300px;
-->
<script>
<!--


var winheight=100
var winsize=100
var x=5

/*
Animated Window Opener Script (updated 00/04/24)- 
© Dynamic Drive (www.dynamicdrive.com)
For full source code, installation instructions, 100's more DHTML scripts, and Terms Of
Use, visit dynamicdrive.com
*/



function openwindow(thelocation){
temploc=thelocation
if (!(window.resizeTo&&document.all)&&!(window.resizeTo&&document.getElementById)){
window.open(thelocation)
return
}
win2=window.open("","","scrollbars")
win2.moveTo(0,0)
win2.resizeTo(100,100)
go2()
}
function go2(){
if (winheight>=screen.availHeight-3)
x=0
win2.resizeBy(5,x)
winheight+=5
winsize+=5
if (winsize>=screen.width-5){
win2.location=temploc
winheight=100
winsize=100
x=5
return
}
setTimeout("go2()",50)
}
//-->
</script>
<!--
<p><a href="javascript:openwindow('http://wsabstract.com')">Open window</a>

<p><a href="javascript:openwindow('http://cnn.com')">Open window</a>
-->


<script>
    var sw = false;
    function zoom() {
     if(sw) {
      document.img1.width = 850;
      document.img1.height = 450;
      sw = false;
     }
     else {
      document.img1.width = 700;
      document.img1.height = 300;
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
   campo.style.background = "#99ff99";
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
      req.send('campo=' +elem+ ':' + escape(campo.value));      
}
function guardar() {
   if(confirm("Los tados seran guardados, OK para confirmar"))
      alert("positovo");
   else
      alert("no pasan naranjas");
}
    
    
    
    
    
</script>
<table width=100% border="0" align=center >
    <tr class=normal>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>

<div id="resultado"></div> 
<%-- Lado imagen --%>
<center>
    <a onclick="zoom();">
        <img name="img1" title="click para zoom" alt="REPORTES" src='./images/tarjetas/II CAJA360_jac_011206_im1973_A.jpg' border=1 width="700" height="300">
    </a>
</center>

<%-- Lado formulario--%>
<form name=forma1 method="POST" action='<c:url value="/transcripcion.do"/>'>
    <table>
        <tr>
            <td class="normal"><b>DATOS PERSONALES</b></td>
            <td></td>
        </tr>
    </table>
    <table>
        
    </table>
    <table cellpadding="0" border="0" cellspacing="0">
        <tr>
            <td>
                <table>
                    <tr>
                        <td class="normal">Observaci&oacute;n</td>
                        <td colspan="4" align="right"><input type="text" id="observacion" class="funcional" name="oservacion" value="" style="width: 350px" onblur='enviar("observacion")'></td>
                    </tr>
                    <tr>
                        <td class="normal">A.Paterno</td>
                        <td class="normal">A.Materno</td>
                        <td class="normal">Nombre 1</td>
                        <td class="normal">Nombre 2</td>
                        <td class="normal">Nombre 3</td>
                    </tr>
                    <tr>
                        <td class="normal"><input type="text" id="paterno" class="funcional" name="" value="" style="width: 70px" onblur='enviar("paterno")'></td>
                        <td class="normal"><input type="text" id="materno" class="funcional" name="" value="" style="width: 70px" onblur='enviar("materno")'></td>
                        <td class="normal"><input type="text" id="nombre1" class="funcional" name="" value="" style="width: 70px" onblur='enviar("nombre1")'></td>
                        <td class="normal"><input type="text" id="nombre2" class="funcional" name="" value="" style="width: 70px" onblur='enviar("nombre2")'></td>
                        <td class="normal"><input type="text" id="nombre3" class="funcional" name="" value="" style="width: 100px" onblur='enviar("nombre3")'></td>
                    </tr>
                </table>
            </td>
            <td valign="top">
                <table>
                    <tr>
                        <td class="colh">Nro. Gral (CI)</td>
                        <td class="normal">Sexo</td>
                        <td class="normal">Libro</td>
                        <td class="normal">Folio</td>
                    </tr>
                    <tr>
                        <td align="center"><input type="text" id="ci" class="funcional" name="" value="" style="width: 70px" align="center" onblur='enviar("ci")'></td>
                        <td><input type="text" id="sexo" class="campo" name="" value="" style="width: 30px" onblur='enviar("sexo")'>
                            <select id="f_sexo" name="" class="funcional" onblur='enviar("f_sexo")' onchange='enviar("f_sexo")'><option value="M">M</option><option value="F">F</option>
                            </select>
                        </td>
                        <td class="normal"><input type="text" id="libro" class="campo" name="" value="" style="width: 50px" onblur='enviar("libro")'></td>
                        <td class="normal"><input type="text" id="folio" class="campo" name="" value="" style="width: 50px" onblur='enviar("folio")'></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    
    <table>
        <tr>
            <td class="normal">Nacionalidad</td>
            <td class="normal">Pais:<input type="text" id="pais" class="campo" name="" value="" style="width: 100px" onblur='enviar("pais")'></td>
            <td class="normal">Dep:<input type="text" id="departamento" class="campo" name="" value="" style="width: 100px" onblur='enviar("departamento")'></td>
            <td class="normal">Prov:<input type="text" id="provincia" class="campo" name="" value="" style="width: 100px" onblur='enviar("provincia")'></td>
            <td class="normal">Loc:<input type="text" id="localidad" class="campo" name="" value="" style="width: 100px" onblur='enviar("localidad")'></td>
        </tr>
        <tr>
            <td class="normal"><input type="text" id="nacionalidad" class="campo" name="" value="" style="width: 100px" onblur='enviar("nacionalidad")'></td>
            <td>
                <select id="f_pais" name="" class="funcional" style="width: 200px" onblur='enviar("f_pais")' onchange='enviar("f_pais")'>
                    <c:forEach var="lista" items="${listapais.pageList}">
                        <option value="<c:out value="${lista.cod_pais}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select id="f_departamento" name="" class="funcional" style="width: 200px" onblur='enviar("f_departamento")' onchange='enviar("f_departamento")'>
                    <c:forEach var="lista" items="${listadepto.pageList}">
                        <option value="<c:out value="${lista.cod_depto}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select id="f_provincia" name="" class="funcional" style="width: 200px" onblur='enviar("f_provincia")' onchange='enviar("f_provincia")'>
                    <c:forEach var="lista" items="${listaprovincia.pageList}">
                        <option value="<c:out value="${lista.cod_provincia}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select id="f_localidad" name="" class="funcional" style="width: 200px" onblur='enviar("f_localidad")' onchange='enviar("f_localidad")'>
                    <c:forEach var="lista" items="${listalocalidad.pageList}">
                        <option value="<c:out value="${lista.cod_localidad}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td class="normal"><b>DATOS DE NACIMIENTO</b></td>
            <td></td>
        </tr>
    </table>
    <table>
        <tr>
            <td class="normal">Nacio el</td>
            <td class="normal" colspan="2"><input type="text" id="fecha_nacimiento" class="campo" name="" value="" style="width: 70px" onblur='enviar("fecha_nacimiento")'>
                <select name="" id="f_n_dia" class="funcional" onblur='enviar("f_n_dia")' onchange='enviar("f_n_dia")'>
                    <c:forEach var="i" begin="1" end="31">
                        <option value="<c:out value="${i}"/>"><c:out value="${i}"/></option>
                    </c:forEach>
                </select>
                <select name="" id="f_n_mes" class="funcional" onblur='enviar("f_n_mes")' onchange='enviar("f_n_mes")'>
                    <c:forEach var="i" begin="1" end="12">
                        <option value="<c:out value="${i}"/>"><c:out value="${i}"/></option>
                    </c:forEach>
                </select>
                <select name="" id="f_n_anio" class="funcional" onblur='enviar("f_n_anio")' onchange='enviar("f_n_anio")'>
                    <c:forEach var="i" begin="1900" end="2007">
                        <option value="<c:out value="${i}"/>"><c:out value="${i}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td class="normal">Of.R.C.Nro</td>
            <td class="normal"><input type="text" id="ofic_rcn" class="campo" name="" value="" style="width: 40px" onblur='enviar("ofic_rcn")'></td>
            <td class="normal">Lib Nro</td>
            <td class="normal"><input type="text" id="libro_no" class="campo" name="" value="" style="width: 40px" onblur='enviar("libro_no")'></td>
            <td class="normal">Part Nro</td>
            <td class="normal"><input type="text" id="partida_no" class="campo" name="" value="" style="width: 40px" onblur='enviar("partida_no")'></td>
            <td class="normal">A&ntilde;o</td>
	    <td class="normal"><input type="text" id="anio" class="campo" name="" value="" style="width: 40px" onblur='enviar("anio")'></td>
        </tr>
    </table>
    </table>
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td class="normal" rowspan="2">Hijo de</td>
                        <td class="normal">A.Paterno</td>
                        <td class="normal">A.Materno</td>
                        <td class="normal">Nombre 1</td>
                        <td class="normal">Nombre 2</td>
                        <td class="normal">Nombre 3</td>
                    </tr>
                    <tr>
                        <td class="normal"><input type="text" id="f_ap_paterno_padre" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_ap_paterno_padre")'></td>
                        <td class="normal"><input type="text" id="f_ap_materno_padre" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_ap_materno_padre")'></td>
                        <td class="normal"><input type="text" id="f_nombre1_padre" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_nombre1_padre")'></td>
                        <td class="normal"><input type="text" id="f_nombre2_padre" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_nombre2_padre")'></td>
                        <td class="normal"><input type="text" id="f_nombre3_padre" class="campo" name="" value="" style="width: 100px" onblur='enviar("f_nombre3_padre")'></td>
                    </tr>
                    <tr>
                        <td class="normal" rowspan="2">y de</td>
                        <td class="normal">A.Paterno</td>
                        <td class="normal">A.Materno</td>
                        <td class="normal">Nombre 1</td>
                        <td class="normal">Nombre 2</td>
                        <td class="normal">Nombre 3</td>
                    </tr>
                    <tr>
                        <td class="normal"><input type="text" id="f_ap_paterno_madre" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_ap_paterno_madre")'></td>
                        <td class="normal"><input type="text" id="f_ap_materno_madre" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_ap_materno_madre")'></td>
                        <td class="normal"><input type="text" id="f_nombre1_madre" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_nombre1_madre")'></td>
                        <td class="normal"><input type="text" id="f_nombre2_madre" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_nombre2_madre")'></td>
                        <td class="normal"><input type="text" id="f_nombre3_madre" class="campo" name="" value="" style="width: 100px" onblur='enviar("f_nombre3_madre")'></td>
                    </tr>
                </table>
            </td>
            <td>
                <table>
                    <tr>
                        <td class="normal">Lee</td>
                        <td class="normal"><input type="text" id="lee" class="campo" name="" value="" style="width: 20px" onblur='enviar("lee")'>
                        <select name="" id="f_lee" class="funcional" onblur='enviar("f_lee")' onchange='enviar("f_lee")'><option value="0">SI<option value="1">NO</select></td>
                        
                        <td class="normal">Escribe</td>
                        <td class="normal"><input type="text" id="escribe" class="campo" name="" value="" style="width: 20px" onblur='enviar("escribe")'>
                        <select name="" id="f_escribe" class="funcional" onblur='enviar("f_escribe")' onchange='enviar("f_escribe")'><option value="0">SI<option value="1">NO</select></td>
        
                        <td class="normal">Estado Civil</td>
                        <td class="normal"><input type="text" id="estado_civil" class="campo" name="" value="" style="width: 50px" onblur='enviar("estado_civil")'>
                            <select name="" id="f_estado_civil" class="funcional" onblur='enviar("f_estado_civil")' onchange='enviar("f_estado_civil")'>
                                <c:forEach var="lista" items="${listaestcivil.pageList}">
                                    <option value="<c:out value="${lista.id_estado_civil}"/>"><c:out value="${lista.descripcion}"/></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td class="normal" rowspan="2">Conyugue</td>
            <td class="normal">A.Paterno</td>
            <td class="normal">A.Materno</td>
            <td class="normal">Nombre 1</td>
            <td class="normal">Nombre 2</td>
            <td class="normal">Nombre 3</td>
            <td class="normal">Of.R.C.Nro</td>
            <td class="normal">Lib Nro</td>
            <td class="normal">Part Nro</td>
            <td class="normal">A&ntilde;o/td>
        </tr>    
        <tr>        
            <td class="normal"><input type="text" id="f_paterno_conyuge" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_paterno_conyuge")'></td>
            <td class="normal"><input type="text" id="f_materno_conyuge" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_materno_conyuge")'></td>
            <td class="normal"><input type="text" id="f_nombre1_conyuge" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_nombre1_conyuge")'></td>
            <td class="normal"><input type="text" id="f_nombre2_conyuge" class="campo" name="" value="" style="width: 70px" onblur='enviar("f_nombre2_conyuge")'></td>
            <td class="normal"><input type="text" id="f_nombre3_conyuge" class="campo" name="" value="" style="width: 100px" onblur='enviar("f_nombre3_conyuge")'></td>
            <td class="normal"><input type="text" id="ofic_rcn_conyuge" class="campo" name="" value="" style="width: 30px" onblur='enviar("ofic_rcn_conyuge")'</td>
            <td class="normal"><input type="text" id="libro_no_conyuge" class="campo" name="" value="" style="width: 30px" onblur='enviar("libro_no_conyuge")'</td>
            <td class="normal"><input type="text" id="partida_no_conyuge" class="campo" name="" value="" style="width: 30px" onblur='enviar("partida_no_conyuge")'</td>
            <td class="normal" colspan="0"><input type="text" id="anio_conyuge" class="campo" name="" value="" style="width: 40px" onblur='enviar("anio_conyuge")'></td>
        </tr>
    </table>
    
    <table>
        <tr>
            <td class="normal">Estatura</td>
            <td class="normal"><input type="text" id="altura" class="campo" name="" value="" style="width: 30px" onblur='enviar("altura")'>cm</td>
            <td class="normal">Serv Militar</td>
            <td class="normal"><input type="text" id="servicio_militar" class="campo" name="" value="" style="width: 70px" onblur='enviar("servicio_militar")'></td>
            <td class="normal">Nro Libreta</td>
            <td class="normal"><input type="text" id="no_libreta" class="campo" name="" value="" style="width: 70px" onblur='enviar("no_libreta")'></td>
            <td class="normal">Profesi&oacute;n</td>
            <td class="normal"><input type="text" id="profesion" class="campo" name="" value="" style="width: 70px" onblur='enviar("profesion")'></td>
            <td class="normal">
                <select id="f_profesion" name="" class="funcional" onblur='enviar("f_profesion")' onchange='enviar("f_profesion")'>
                    <c:forEach var="lista" items="${listaprofesion.pageList}">
                        <option value="<c:out value="${lista.cod_profesion}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td class="normal">Causa Filiacion</td>
            <td class="normal" colspan="0"><input type="text" id="causa_filicacion" class="campo" name="" value="" style="width: 70px" onblur='enviar("causa_filicacion")'></td>
            <td class="normal" colspan="0">
                <select name="" id="f_causa_filicacion" class="funcional" onblur='enviar("f_causa_filicacion")' onchange='enviar("f_causa_filicacion")'>
                    <c:forEach var="lista" items="${listafiliacion.pageList}">
                        <option value="<c:out value="${lista.cod_filiacion}"/>"><c:out value="${lista.descripcion}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td class="normal">Se&ntilde;as Particulares</td>
            <td class="normal"><input type="text" id="senias_particulares" class="campo" name="" value="" style="width: 70px" onblur='enviar("senias_particulares")'></td>
            <td class="normal">Serie</td>
            <td class="normal"><input type="text" id="serie" class="campo" name="" value="" style="width: 70px" onblur='enviar("serie")'></td>
            <td class="normal">Secci&oacute;n</td>
            <td class="normal"><input type="text" id="seccion" class="campo" name="" value="" style="width: 70px" onblur='enviar("seccion")'></td>
            <td><input type="button" name="" value="Guardar" onclick="guardar()"></td>
            <td><input type="reset" name="" value="Borrar formulario"></td>
        </tr>
    </table>
</form>


























<!--
<table align=center width="60%">
    <tr>
        <td align="center"><img alt="TRANSCRIPCION" src='./images/mano.jpg' border=0/></td>
        <td align="center"><img alt="REPORTES" src='./images/images.jpg' border=0/></td>        
    </tr>    
    <tr>
        <td class=normal align="center">TRANSCRIPCION</td>
        <td class=normal align="center">REPORTES</td>      
        
    </tr>
</table>

<a href="<c:url value="/menu/menu.do"><c:param name="id_categoria" value="${categorias.id_categoria}"/></c:url>">
<c:out value="${categorias.categoria}"/>
</a>


<form name=forma1 method="POST" action='<c:url value="/transcripcion.do"/>'>    
<input type="submit" value="conexion"> <c:out value="${mensaje}"/>::<c:out value="${c}"/>
</form>
-->
<%@ include file="../VerPieCuerpo.jsp" %> 