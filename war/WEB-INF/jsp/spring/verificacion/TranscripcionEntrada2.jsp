<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>
<table width=100% border="0" align=center>
    <tr class=colb>
    <th class=colh align=center>MODULO DE TRANSCRIPCION</th>
</table>
<br><br>

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
.campo {
	font-size: 9px;
	border: 1px solid #0099FF;
	//width: 300px;
	margin-left: 1px;
	margin-top: 1px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	padding: 1px;
	font-weight: bold;
	color: #666666;
	margin-bottom: 1px;
}
</style>

                           
<table>
    <tr>
        <td class="colb">Observaci&oacute;n</td>
        <td colspan="8" class="colb"><input type="text" class="campo" name="" value="" style="width: 500px"></td>
    </tr>
    <tr>
        <td class="colb">A.Paterno</td>
        <td class="colb"><input type="text" class="campo" name="" value="" style="width: 70px"></td>
        <td class="colb">A.Materno</td>
        <td class="colb"><input type="text" class="campo" name="" value="" style="width: 70px"></td>
        <td class="colb">Nombres</td>
        <td class="colb"><input type="text" class="campo" name="" value="" style="width: 120px"></td>
        <td class="colb">Sexo</td>
        <td class="colb"><input type="text" class="campo" name="" value="" style="width: 30px"</td>
        <td class="colb"><select name="" class="campo"><option value="M">M<option value="F">F</select></td>
    </tr>
    <tr>
        <td class="colb">Nro. General (CI)</td>
        <td class="colb"><input type="text" class="campo" name="" value="" style="width: 40px"</td>
        <td class="colb">Nacionalidad</td>
        <td class="colb"><input type="text" class="campo" name="" value="" style="width: 40px"</td>
        <td class="colb">Pais</td>
        <td class="colb"><input type="text" class="campo" name="" value="" style="width: 40px"</td>  
        <td class="colb" colspan="3"><select name="" class="campo"><option value="M">BOLIVIA<option value="F">ARGENTINA</select></td>
    </tr>
    <tr>
        <td class="colb">Departamento</td>
        <td class="colb"><input type="text" class="campo" name="" value="" style="width: 40px"</td>   
        <td class="colb" colspan="7"><select name="" class="campo"><option value="M">LA PAZ<option value="F">COCHABAMBA</select></td>        
        
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