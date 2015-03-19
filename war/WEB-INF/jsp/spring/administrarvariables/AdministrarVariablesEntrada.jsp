<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional - _Apps">
<%@ include file="../VerCabezaCuerpo.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>
<!--
<h3>UMSA -  <c:out value="${programa}"/></h3>

<h4>CONFIGURACION DE LAS VARIABLES DEL SISTEMA</h4>
-->
<form name="forma" method="POST" action='<c:url value="/administrarVariables.do"/>' >
<!--
<table>
 <tr><td>
   <fieldset>
   <legend class=colbp></legend> -->
        <table border="0" cellspacing="2" width="100%">
	 <tr>
	   <td class=colerr align=center colspan=2>CONFIGURACION DE LAS VARIABLES DEL SISTEMA
         <tr>
           <td class=colbp align=center valign=top><img width=40% src='<c:out value="./images/pagina/signs/sign9.jpg"/>' />
	   <td class=colbp><b>IMPORTANTE</b>, Debe tener en cuenta que los cambios a los valores de las siguientes variables, 
	                   alterar&aacute; el funcionamiento del sistema <br>
			   Antes de cambiar estos valores, en lo posible procure estar seguro que nadie esta 
			   con acceso al sistema o tiene iniciada sesi&oacute;n
	 <tr>
	   <td class=colh align=center colspan=2><c:out value="${programa}"/>
        </table>

        <table border="0" cellspacing="2">
	 <tr>
	   <td class=colh>Gestion
	   <td class=colh>::
	   <td><input type=text name=new_gestion value='<c:out value="${gestion}"/>' maxlength=4 size=4 onblur=validar(this,"9")>
	   <td class=colh>Valor Actual:
	   <td class=colb><c:out value="${gestion}"/>
	 <tr>
	   <td class=colh>Periodo
	   <td class=colh>::
	   <td><input type=text name=new_periodo value='<c:out value="${periodo}"/>' maxlength=4 size=4 onblur=validar(this,"9")>
	   <td class=colh>Valor Actual:
	   <td class=colb><c:out value="${periodo}"/>
	 <tr>
	   <td class=colhp><input type=submit name=accion value="Actualizar">
        </table>
        <br><br>

        <table border="0" cellspacing="2" width="100%">
         <tr>
<!--           <td class=colbp align=center valign=top><img width=40% src='<c:out value="./images/pagina/signs/sign9.jpg"/>' /> -->
	   <td class=colbp><b>NOTA</b>, Luego de cambiar los valores, para que la nueva configuracion
	                   tenga efecto se cerrara la sesi&oacute;n actual. 
	 <tr>
	   <td class=colerr align=center colspan=2>CONFIGURACION DE LAS VARIABLES DEL SISTEMA
        </table>

</form>
<!--   </fieldset>
   <td>
</table>
</form>
-->
<!--

<form name=forma action="<c:url value="/administrarVariables.do"/>" method="POST">
<table>
 <tr>
  <td class=colh>Periodo::
  <td class=colb><c:out value="${periodo}"/>
  <td class=colh>Gestion::
  <td class=colb><c:out value="${gestion}"/>
</table>

<table>
 <tr>
  <td> 
   <fieldset>
     <legend class=colhp>Seleccione el plan de estudios</legend>  
     <table>
       <td class=colh>Planes de Estudio
       <td class=colh>::<td>
       <td class=colb><select name="id_plan" onchange="javascript:document.forma.submit();">
                      <c:forEach var="cat" items="${listaPlanes.pageList}">
	              <option value="<c:out value="${cat.id_plan}"/>" > 
                                     <c:out value="${cat.plan}"/>
	              </option>
	              </c:forEach>
	              <option value="" selected>-- Seleccione --
	              </option>
	              </select>
   </table>		      
   </fieldset>
</table>
</form>
<c:if test="${!empty plan}">
<table>
<tr>
  <td class=colh align=center colspan=2>MATERIAS PLAN (
    <c:forEach var="datos" items="${listaPlanes.pageList}">
      <c:if test="${datos.id_plan == plan}">
         <c:out value="${datos.plan}"/>
      </c:if>	 
    </c:forEach>
    )
  <tr class=colh align=center>
    <td>Sigla
    <td>Materia
  <c:forEach var="materias" items="${listaDeMaterias.pageList}">
  <tr class=colb align=center>
    <td align=right>
    <a href="<c:url value="/administrarParalelos.do"><c:param name="id_materia" value="${materias.id_materia}"/></c:url>">
             <c:out value="${materias.sigla}"/>
    <td align=left ><c:out value="${materias.materia}"/>
  </tr>
  </c:forEach>

</table>
</c:if>

-->

<!--
<form name=forma method="POST" action='<c:url value="/registrarDepositos.do"/>' >
  <table>
    <tr>
      <td class=colh align=center colspan= 3>Datos de la persona</td>
    </tr>
    <c:forEach var="datos" items="${datos.pageList}">
    <tr>
      <td class=colh align=right>CI</td>
      <td class=colb><c:out value="${datos.dip}"/></td>
      <input type=hidden name=id_persona value=<c:out value="${datos.id_persona}"/> >
    </tr>
    <tr>
      <td class=colh align=right>Nombres</td>
      <td class=colb><c:out value="${datos.nombre_completo}"/>
    </tr>
    </c:forEach>
  </table>

  <table>
       <tr>
         <td class=colh align=center colspan=4>REGISTRAR DEPOSITOS
       <tr>    
         <td class=colh align=center>Nro. de dep&oacute;sito</td>
         <td class=colh align=center>Fecha del dep&oacute;sito</td>
         <td class=colh align=center>Monto</td>
         <td class=colh align=center>Moneda</td>
       <tr>    
         <td class=colb><input type=text name=nro_deposito >
         <td class=colb><input type=text name=dia maxlength=2 size=2 onblur=validarNota(this,"1","31")>
                        <input type=text name=mes maxlength=2 size=2 onblur=validarNota(this,"1","12")>
                        <input type=text name=anio maxlength=4 size=4 onblur=validarNota(this,"1900","2010")>dd-mm-aaaa
         <td class=colb><input type=text name=monto maxlength=6 size=6>
	 <td class=colb>
	   <select name="id_tipo_moneda">
    	    <c:forEach var="cat" items="${listaTiposMonedas.pageList}">
	       <option value="<c:out value="${cat.id_tipo_moneda}"/>" > 
                              <c:out value="${cat.tipo_moneda}"/>
	       </option>
	    </c:forEach>
	   </select>
       <tr>
	 <td align=center colspan=5>
                        <input type=hidden name=id_tipo_movimiento  value=<c:out value="${id_tipo_movimiento}"/> >
                        <input type=hidden name=id_tipo_actividad   value=<c:out value="${id_tipo_actividad}"/> >
	                <input type=submit name=accion value="Registrar deposito">
	                <input type=reset value="Borrar">
       <c:if test="${!empty _error}">
       <tr>
         <td class=coler colspan=5><c:out value="${_error}"/>
       </c:if>	 
  </table>
</form>       
<c:if test="${ndep > 0}">
<table>
    <tr class=colh>
      <td colspan=8 align=center>DETALLE DE DEPOSITOS DE LA PERSONA
    <tr class=colh>
      <td>Nro. dep&oacute;sito</td>
      <td>Movimiento</td>
      <td>Actividad</td>
      <td>Monto</td>
      <td>Moneda</td>
      <td>Fecha del dep&oacute;sito</td>
      <td>Gestion</td>
      <td>
    </tr>
    <c:forEach var="datos" items="${datos.pageList}">
     <c:forEach var="datos1" items="${listaDepositos.pageList}" varStatus="contador">
     <tr class=colb>
      <td class=colb><c:out value="${datos1.nro_deposito}"/></td>
      <td class=colb><c:out value="${datos1.tipo_movimiento}"/></td>
      <td class=colb><c:out value="${datos1.tipo_actividad}"/></td>
      <td class=colb align=right><c:out value="${datos1.monto}"/></td>
      <td class=colb><c:out value="${datos1.tipo_moneda}"/></td>
      <td class=col align=center><fmt:formatDate value="${datos1.fec_deposito}" pattern="dd/MM/yyyy"/></td>
      <td class=colb align=right><c:out value="${datos1.periodo}"/>/<c:out value="${datos1.gestion}"/></td>
      <td class=colb>
	  <a href="<c:url value="/registrarDepositos.do"><c:param name="persona_deposito" 
	           value="${datos.id_persona}:${datos1.id_deposito}"/></c:url>">
          [Eliminar]    
     </tr>
     </c:forEach>
    </c:forEach>
</table>
</c:if>

-->

<%@ include file="../VerPieCuerpo.jsp" %>