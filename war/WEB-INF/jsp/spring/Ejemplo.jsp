<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<table border="1">
<caption><h1>Estudiante</h1></caption>

<c:forEach var="listado" items="${listaDeEstudiante.pageList}">
  <tr>
    <td>
      <c:out value="${listado.id_usuario}"/>
    </td>
    <td>
      <c:out value="${listado.programa}"/>
    </td>
    <td>
      <c:out value="${listado.nombres}"/>
    </td>
  </tr>
</c:forEach>
<table align="center" border="0">
  <tr>
     <td class=colh>RECOMENDACIONES:</td>
  </tr
  <tr>
     <td class=colh> * Digite un maximo de 10 caracteres y un minimo de 6.:</td>
  </tr>
  <tr>
     <td class=colh> * Utilize caracteres validos [A-Z],[a-z] y [1-9].:</td>
  </tr>
  <tr>
     <td class=colh>  * No utilize palabras del diccionario ni nombres propios.:</td>
  </tr
  <tr>
     <td class=colh>   * Invente una palabra que pueda recordar.:</td>
  </tr
   <tr>
     <td class=colh>    * Componga palabras e inserte números.:</td>
  </tr
</table>
<tr>

  <td>&nbsp;</td>
  <td><input type="submit" value="Buscar"></td>
</tr