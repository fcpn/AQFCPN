
<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>
<script>
    var sw = false;
    function imagen(){
       var ventana = window.open("<c:url value="/images/Eye of the tiger.jpg"/>","nueva","menubar=no,location=no,toolbar=no,statusbar=no,scrollbars=no,resizable=yes");
       ventana.resizeTo(776,379);
    }
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
</script>
<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>
<br><br>

<style type="text/css">
    
.texto {
	font-size: 9px;
	margin-left: 1px;
	margin-top: 1px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	padding: 1px;
	color: #666666;
	margin-bottom: 1px;
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
.campo {
	font-size: 9px;
	border: 1px solid #0099FF;
	margin-left: 1px;
	margin-top: 1px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	padding: 1px;
	font-weight: bold;
	color: #666666;
	margin-bottom: 1px;
        background-color: #E0E0E0;
}
</style>

<center>
    <a onclick="zoom();">
        <img name="img1" title="click para zoom" alt="REPORTES" src='./images/tarjetas/Eye of the tiger.jpg' border=0 width="700" height="300">
    </a>
</center>                           
<table width="100%">
    <tr>
       <table width="70%" align="center"> 
        <td colspan="2" nowrap><span class="texto">Relaciones</span><br>
          <textarea name="coment" cols="35" rows="2" class="form-combos" id="coment" onBlur="this.className='form-combos'" onClick="this.className='form-combos1'"></textarea>
        </td>
        <td colspan="2"><span class="texto">Tramitaciones</span><br />
          <select name="" class="campo">
              <option value="M">Certificado de bautismo
              <option value="F">...
          </select><br>
        <input type="text" class="campo" name="" value="" style="width: 150px"> &nbsp;&nbsp;&nbsp;
        <input type="button" name="" value="+" style="width: 10px">
        </td>                 
    </tr>
    <tr>
        <td><span class="texto">Relaci&oacute;n</span></td>
        <td><span class="texto">Ap. Paterno</span></td>
        <td><span class="texto">Ap. Materno</span></td>
        <td><span class="texto">Nombre 1</span></td>
        <td><span class="texto">Nombre 2</span></td>
        <td><span class="texto">Nombre 3</span></td>       
    </tr>    
    <tr>
        <td><select name="" class="campo"><option value="M">ABUELOS(AS)<option value="F">NIETOS(AS)</select></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>   
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>   
        <td><input type="text" class="campo" name="" value="" style="width: 80px"> &nbsp;&nbsp;&nbsp;<input type="button" name="" value="+" style="width: 10px"></td>
    </tr>    
   </table>   
    <tr>
       <table width="70%" align="center">  
        <td colspan="2" nowrap><span class="texto">Parientes</span><br />
          <textarea name="coment" cols="35" rows="2" class="form-combos" id="coment" onBlur="this.className='form-combos'" onClick="this.className='form-combos1'"></textarea>
        </td>                     
    </tr>
    <tr>
        <td><span class="texto">Relaci&oacute;n</span></td>
        <td><span class="texto">Ap. Paterno</span></td>
        <td><span class="texto">Ap. Materno</span></td>
        <td><span class="texto">Nombre 1</span></td>
        <td><span class="texto">Nombre 2</span></td>
        <td><span class="texto">Nombre 3</span></td>
    </tr>         
    <tr>
        <td><select name="" class="campo"><option value="M">ABUELOS(AS)<option value="F">NIETOS(AS)</select></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>   
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>   
        <td><input type="text" class="campo" name="" value="" style="width: 80px"> &nbsp;&nbsp;&nbsp;<input type="button" name="" value="+" style="width: 10px"></td>
    </tr>
    <tr>
        <td colspan="2" nowrap><span class="texto">Domicilio</span><br />
          <textarea name="coment" cols="35" rows="2" class="form-combos" id="coment" onBlur="this.className='form-combos'" onClick="this.className='form-combos1'"></textarea>
        </td>                     
    </tr>
   </table>  
    <tr>
       <table width="70%" align="center">   
        <td><span class="texto">Ciudad</span></td>
        <td><span class="texto">Zona</span></td>
        <td><span class="texto">Barrio</span></td>  
        <td><span class="texto">Calle</span></td>
        <td><span class="texto">Nº casa</span></td>
    </tr>         
    <tr>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>  
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>
        <td><input type="text" class="campo" name="" value="" style="width: 80px"></td>
        <td><input type="submit" name="" value="Grabar Tarjeta" style="width: 100px; font-size:9px"></td>
       </table>   
    </tr>
</table>

<!--
<table align=center width="60%">
    <tr>
        <td align="center"><img alt="TRANSCRIPCION" src='./images/mano.jpg' border=0/></td>
        <td align="center"><img alt="REPORTES" src='./images/images.jpg' border=0/></td>        
    </tr>    
    <tr>
        <td class=colb align="center">TRANSCRIPCION</td>
        <td class=colb align="center">REPORTES</td>      
        
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