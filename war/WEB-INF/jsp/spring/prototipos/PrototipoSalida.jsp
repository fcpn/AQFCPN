<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ include file="../VerCabezaCuerpo.jsp" %>

<center>
<h3>Datos que han sido recogidos
<br>
<br>
<table align=center>
 <tr class=colb>
   <td><c:out value='${dip}'/>
   <td><c:out value='${id_persona}'/>
   <td><c:out value='${nombre_completo}'/>
 <tr class=colb>
   <td><c:out value='${id_estudiante}'/>
   <td colspan=2><c:out value='${programa}'/>

</table>


<%@ include file="../VerPieCuerpo.jsp" %>


