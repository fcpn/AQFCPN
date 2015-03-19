<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<%@ include file="../Cabecera.jsp" %>
<table width=100% border="0" align=center>
<!--    <tr class=colb>  Jesus -->
        <tr>
    <th class=colh align=center>ADMINISTRAR USUARIOS</th>
</table>
       <!-- <table align="center"><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0" cellpaddign="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>Aviso:</b> En esta secci&oacute;n ingrese los datos necesarios para establecer un nuevo registro de <b>persona</b>
			    </td>
                        </tr>
                    </table>
            </td></tr>
        </table> -->
<form name="adminusers" action='<c:url value="/administrarUsuarios.do"/>'>
 <p><input type="submit" class="button" value="Administrar usuarios"></p>
</form>

<div id="personainfoUpdate" style="display:inline">
<form name="updatePerson" action='<c:url value="/registrarpersona.do"/>'>
<!-- Jesus Borra-->
<!-- <table id="lyClave" border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="background-color:#FDFFEF; border:1px solid #FFE7CE"> -->

<table id="lyClave" border="0" cellspacing="0" cellpaddign="0" width="80%" align="center" style="border:1px solid">

<td style="padding-top:20px; padding-bottom:20px; padding-left:30px; padding-right:30px">
 <table border="0" cellspacing="0" cellpaddign="0">
   <tr>
    <!--<td class="normal" colspan="2"><b>INFORMACION PERSONAL</b>, ahora puede Ud. modificar la informaci&oacute;n, luego asegurese de guardar.</td>  JESUS bajo para abajo es class=normal-->
    <td colspan="2"><b>INFORMACION PERSONAL</b>,.</td>

   </tr>
   <tr>
    <td colspan="2"><hr></td>
   </tr>
   <tr>
    <td style="width:110px"><b>Nombres</b></td>
    <td ><input type="text" class="campo" name="nombres" style="width:220px" value="<c:out value="${per.nombres}"/>"></td>
   </tr>
   <tr>
    <td style="width:110px"><b>Ap. Paterno</b></td>
    <td ><input type="text" class="campo" name="paterno" style="width:220px" value="<c:out value="${per.paterno}"/>"></td>
   </tr>
   <tr>
    <td style="width:110px"><b>Ap. Materno</b></td>
    <td ><input type="text" class="campo" name="materno" style="width:220px" value="<c:out value="${per.materno}"/>"></td>
   </tr>
   <tr>
    <td style="width:110px"><b>C&eacute;dula</b></td>
    <td ><input type="text" class="campo" name="dip" style="width:220px" value="<c:out value="${per.dip}"/>"></td>
   </tr>
   <tr>
    <td style="width:110px"><b>Sexo</b></td>
    <td >
      <input type="radio" name="id_sexo" value="M" <c:if test="${per.id_sexo == 'M'}">checked</c:if>>Masculino
      <input type="radio" name="id_sexo" value="F" <c:if test="${per.id_sexo == 'F'}">checked</c:if>>Femenino
    </td>
   </tr>
   <tr>
    <td  style="width:110px"><b>Email</b></td>
    <td ><input type="text" class="campo" name="correo" style="width:220px" value="<c:out value="${per.correo}"/>"></td>
   </tr>
   <tr>
    <td  style="width:110px"><b>Telefonos</b></td>
    <td ><input type="text" class="campo" name="telefono" style="width:220px" value="<c:out value="${per.telefono}"/>"></td>
   </tr>
   <tr>
    <td  style="width:110px"><b>Direcci&oacute;n</b></td>
    <td ><input type="text" class="campo" name="direccion" style="width:220px" value="<c:out value="${per.direccion}"/>"></td>
   </tr>
   <tr>
    <td  colspan="2"><hr></td>
   </tr>
   <tr>
    <td colspan="2" align="right"><input type="reset" value="Limpiar"><input type="submit" value="Registrar" style="font-weight:bold"></td>
   </tr>
 </table>
 <div></div>
</td>
</table>
</form>
</div>



<%@ include file="../VerPieCuerpo.jsp" %>
