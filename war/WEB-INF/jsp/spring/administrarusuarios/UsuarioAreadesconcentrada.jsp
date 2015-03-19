<%@ include file="../Cabecera.jsp" %>
<div class="naranja18-link">El Usuario:</div>
<br>
<table width="634" border="0" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
    <tr>
        <td colspan="3">
            <div align="center"><div class="normal"><b><c:out value="${per.nombres}"/> <c:out value="${per.paterno}"/> <c:out value="${per.materno}"/></b></div></div>
        </td>
    </tr>
</table>
<br>
<table width="634" border="0" style="background-color:#FFFDF4; border:1px solid #FFE7CE">
    <tr>
        <td colspan="3" class="menuCategoria"><div align="center">
          <p>Es el tipo de Usuario Área Desconcentrada<br>
          Tendra disponible:</p>
          </div></td>
    </tr>
    <tr>
      <td colspan="3" class="normal">Reportes Generales y Delallados</td>
    </tr>
    <tr>
      <td colspan="3" class="normal">Certificación Presupuestaria</td>
    </tr>
    <tr>
      <td colspan="3" class="normal">Formularios Digitales</td>
    </tr>
</table>
<%@ include file="../VerPieCuerpo.jsp" %>