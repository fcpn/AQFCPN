<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<meta http-equiv="content-Type" content="text/html; charset=utf-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
   
       
     
                
<c:forEach var="lista" items="${listaparientes.pageList}">
<tr>
  <td class="colb" style="width: 87px"><c:out value="${lista.descripcion}"/></td>
  <td class="colb" style="width: 71px" ><c:out value="${lista.ap_paterno}"/></td>
  <td class="colb" style="width: 71px" ><c:out value="${lista.ap_materno}"/></td>
  <td class="colb" style="width: 100px" > <c:out value="${lista.nombre1}"/></td>
  <td class="colb" style="width: 200px" > <c:out value="${lista.direccion}"/></td>
  <td class="colb" style="width: 50px" > <c:out value="${lista.cedula}"/></td>
  <td class="colb" style="width: 10px" > <c:out value="${lista.id_pais}"/></td>
  <td class=normal><a href="javascript:quitarPar('<c:out value="${lista.cod_parientes}"/>','listpar','2')" style="text-decoration: none"><b>[Eliminar]</b></a></td>
</tr>  
</c:forEach>
