<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">

<%@ include file="../VerCabezaCuerpo.jsp" %>
<script language='JavaScript' SRC="./validar.js">  </script>

<table width=100% border=0 align=center>
  <tr class=colb>
    <th class=colh align=center> CAMBIO DE CLAVE </th>
</table>

<form name=forma action="<c:url value="/cambioPin2.do"/>" method="POST">

<table align=center>
   <tr> 
    <td class=colfindn colspan=3 align=center>BUSQUEDA DE ESTUDIANTES</td>
   <tr>
    <td align=center><input type=text name=entrada size=50 maxlength=35></td>
   <tr>    
    <td align=center><input type=submit name=buscar value='Buscar'></td>
<!--
                     <input type=reset value='Restablecer'></td>
-->		     
   <tr>
    <td class=colfind>Busqueda por : 
    <input type=radio name='busqueda' value="ci" checked>c&eacute;dula    
<!--
    <input type=radio name='busqueda' value="nombres">nombres
-->
    <input type=radio name='busqueda' value="ru" >registro universitario
<!--    
    <input type=radio name='busqueda' value="matricula">matr&iacute;cula 
-->    
    <!-- Fin de los criterios en lista -->
</table>

<c:if test="${tamanio > 0}" >
  <table border="0" cellspacing="2" cellpadding="3" width=100%>
    <tr>
      <td class=colh colspan=6 align=center>RESULTADOS DE LA BUSQUEDA</td>
    </tr> 
    <tr>
      <td class="colh" align=center>RU</td>    
      <td class="colh" align=center>Nombres</td>
      <td class="colh" align=center>CI</td>    
    </tr>
    <c:forEach var="datos" items="${listaPersonas.pageList}"> 
        <tr>
          <td class="colb"><c:out value="${datos.id_estudiante}"/></td>
          <td class="colb">
	  <c:if test="${datos.id_estado == 'A'}">
<!--	    <a href=<c:url value="${salida}">   -->
	              <c:param name="id_persona"      value="${datos.id_persona}"/>
	              <c:param name="id_estudiante"   value="${datos.id_estudiante}"/>
	              <c:param name="nombre_completo" value="${datos.nombre_completo}"/>
	              <c:param name="dip"             value="${datos.dip}"/>
	              <c:param name="programa"        value="${datos.programa}"/>
<!--	            </c:url>>  -->
	  </c:if>
	  <c:out value="${datos.nombre_completo}"/></td>
          <td class="colb"><c:out value="${datos.dip}"/></td>
	
        <input type=hidden name=ru value="<c:out value="${datos.id_estudiante}"/>">     
        <input type=hidden name=ci value="<c:out value="${datos.dip}"/>">  
<!--	
	<td class=colb align=center><input type=checkbox name="chequeo" VALUE="<c:out value="${datos.id_estudiante}"/>"></td>
-->

        </tr>
    </c:forEach>
      <td class=colh colspan=6 align=center>RESULTADOS DE LA BUSQUEDA</td>
  </table>  
<table border="0" cellspacing="2" cellpadding="3" align=center>
  <td class="colb"> Cambiar a la <b>Clave Original (C.I.)</b></td>
  <td align=center colspan=6><input type=submit style="width:110px;" name=cambiar value='Cambiar'onclick="document.forma.action='<c:url value="/cambioPin2.do"/>'"></td>	
</table>  

</c:if>


<table align=center>
      <tr>    
        <c:if test="${!empty valor}">    
	<script language="Javascript">
	    alert("la Clave ha sido Restablecida");
	</script>    
	</c:if>           	
      </tr>	
</table>      

<br>
<tr>
</tr>

</form>


<%@ include file="../VerPieCuerpo.jsp" %>
