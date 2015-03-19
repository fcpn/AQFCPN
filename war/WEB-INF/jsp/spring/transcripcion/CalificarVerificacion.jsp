<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<%@ include file="../Cabecera.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>

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

</style>

<script>
var nav4 = window.Event ? true : false;

function solo_numeros_0(evt) {
   // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
   var key = nav4 ? evt.which : evt.keyCode;
   return (key <= 13 || (key >= 48 && key <= 57));
}

function validate() {
   var valor = document.getElementById('calificacion').value;
   if(valor == '') return false;
   if(valor > 50 || valor < 0)
     return false;
   else
     return true;
}

function ver() {
  if(validate()) {
    document.getElementById('error').style.display = 'none';
    document.getElementById('guardar').disabled = false;
    document.getElementById('calificacion').focus();
    var cal = document.getElementById('calificacion').value;
    var val = (248 / 50) * cal;
    val = 248 - val;
//    val = parseInt(val);
    document.getElementById('meter').style.width = val+'px';    
    if (cal <= 2) {
      document.getElementById('meter').innerHTML = 'Exelente';
      return;
    }  
    if (cal <= 5) {
      document.getElementById('meter').innerHTML = 'Buena';
      return;
    }  
    document.getElementById('meter').innerHTML = 'Mala';
    return;  
  }
  else {    
    document.getElementById('error').style.display = 'inline';
    document.getElementById('guardar').disabled = true;
    document.getElementById('meter').style.width = '0px';    
    document.getElementById('meter').innerHTML = '<font color=\"red\">Error</font>';    
  }    
}
 
</script>


<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>VERIFICACION</th>
</table>


<br><br>

<table align="center"><td>

        <table><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>Aviso:</b> Se debe establecer el n&uacute;mero de correcciones realizadas en la verificacion de esta tarjeta.
			                                       <br> siendo <b>0</b> la m&aacute;xima ponderaci&oacute;n al trabajo realizado por el funcionario transcriptor.<br>
							       Este n&uacute;mero no debera ser mayor a <b>50</b>.
			    </td>	
                        </tr>
                    </table>      
            </td></tr>
        </table>
<br><br>



<form id="frmcalificacion" method="POST" action='<c:url value="/verificacion.do"/>'>

<table border="0" cellspacing="0" cellpaddign="0" align="center">
<tr><td style="border:1px solid #D5D5D5; padding-bottom:3px">
<table border="0" cellspacing="0" cellpaddign="0" align="center">
<tr>
  <td class="colhpt" align="center" style="padding-bottom:3px; padding-top:3px">CALIFICACION</td>
</tr>  
<tr>
  <td class="normal" align="center">
<!-- Error Layer -->
<div id="error" style="display:none">
<table cellpadding="0" border="0" cellspacing="0" style="border: 1px solid RED; color: RED; background-color: #FFE9E9;">
<tr><td style="padding-left:5px"><img src="icon_error.gif" width="16" height="16"/></td>
    <td class="normal">El valor introducido no es valido para la calificaci&oacute;n</td>
</tr>
</table>    
</div>

  </td>
</tr>  
  <td class="normal" align="center"><input id="calificacion" name="calificacion" type="text" class="campo" value="0" style="width:50px" onblur='ver()' onkeypress="return solo_numeros_0(event)"></td>
</tr>
<tr>
  <td class="normal" colspan="2">

    <div class="PwdMeterBase">
        <div class="PwdBack"><div id="meter" style="width: 0px;" class="PwdMeter"></div></div>
    </div>
  
  </td>
</tr>
<tr>
  <td class="normal" align="center" align="right"><input id="guardar" type="submit" class="button" value="Guardar" disabled></td>
</tr>
</table>
</tr></td>
</table>
<!--
</td><td valign="top">
<table border="0" cellspacing="0" cellpaddign="0">
<tr>
  <td colspan="2">
  <div>



  </div>
  </td>
</tr>
</table>
</td></tr>
</table>
-->
</form>

<script>
setInterval('ver()',2000);
</script>


<!--
<a href="<c:url value="/transcripcion.do"><c:param name="transcripcion" value="transcripcion"/></c:url>"><b>inicio</b></a>
-->

<!--
<table align=center width="60%">
    <tr>
        <td align="center"><a href="<c:url value="/transcripcion.do"><c:param name="transcripcion" value="transcripcion"/></c:url>"><img alt="TRANSCRIPCION" src='./images/log-transcrip.png' border=0/></a></td>
        <td align="center"><img alt="REPORTES" src='./images/log-reportes.png' border=0/></td>        
    </tr>    
    <tr>
        <td class=colb align="center">TRANSCRIPCION</td>
        <td class=colb align="center">REPORTES</td>              
    </tr>
</table>

-->

<a href="<c:url value="/menu/menu.do"><c:param name="id_categoria" value="${categorias.id_categoria}"/></c:url>">
    <c:out value="${categorias.categoria}"/>
</a>



<!--

<form name=forma1 method="POST" action='<c:url value="/transcripcion.do"/>'>    
    <input type="submit" value="conexion"> <c:out value="${mensaje}"/>::<c:out value="${c}"/>
</form>
-->
<%@ include file="../VerPieCuerpo.jsp" %> 