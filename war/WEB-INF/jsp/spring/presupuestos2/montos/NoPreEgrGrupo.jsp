<%@ include file="../../Cabecera.jsp" %>


<html>
<head>
<title>Grupo </title>
<style type="text/css">
<!--
.Estilo1 {color: #003399}
.Estilo2 {
	color: #005ACE;
	font-weight: bold;
	font-size: 24px;
}
.Estilo3 {font-size: 12px}
.Estilo6 {color: #0033FF}
.Estilo8 {color: #003399; font-size: 12px; }
.Estilo10 {color: #003399; font-size: 12px; font-weight: bold; }
-->
</style>
</head>
<body>
<form name="form1" method="post" action=" <c:url value="/InsertarNoPreEgrGru.do"/>"            ">
  <div class="topdentro">
    <div align="center">
      <table width="646" height="248" border="3" align="center" bordercolor="#FFFFFF" >
        <tr> 
          <td width="632" height="238" bgcolor="">
<div class="topdentro">
  <div align="center">
    <p>&nbsp;</p>
    <table width="637" height="287" border="3" align="center" >
      <tr>
        <td width="623" ><table width="454" border="0" align="center">
          <tr>
            <td colspan="4"><div align="center"><span class="Estilo6 Estilo2"> Nuevo Grupo <br>
              Cuenta No Presupuestaria Egresos</span></div></td>
          </tr>
          <tr>
            <td width="103"><div align="center">
                <blockquote>
                  <p class="Estilo1"></p>
                </blockquote>
            </div></td>
            <td colspan="3">
			
			
			<div align="center">
                <blockquote>
                  <p class="Estilo1"></p>
                </blockquote>
            </div></td>
          </tr>
          <tr>
            <td><div align="center"><span class="Estilo1"> &nbsp; </span></div></td>
            <td colspan="3"><div align="center"><span class="Estilo1"> <!-- database mostrar grupo--></span></div></td>
          </tr>
          <tr bgcolor="#DFDABD">
            <td><div align="center"><span class="Estilo1">
                
                
                
                
                <input name="codigo" type="text" id="codigo" size="8" maxlength="26" border="ffccff">
            </span></div></td>
            <td colspan="3"><div align="left"><span class="Estilo1">
                <input name="descripcion" type="text" id="descripcion" size="55">
            </span></div></td>
            
            
            
            
          </tr>
          <tr bgcolor="#DFDABD">
            <td><span class="Estilo10">C&oacute;digo [opcional]</span></td>
            <td colspan="3"><strong>&nbsp;<span class="Estilo8">Descripci&oacute;n de la Cuenta</span></strong>
              <div align="left"> </div></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td width="141">&nbsp;</td>
            <td width="22">&nbsp;</td>
            <td width="170"><div align="right"> </div></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><input type="submit" name="Submit" value="Guardar"></td>
            <td>&nbsp;</td>
            <td><input type="reset" name="Submit2" value="Cancelar"></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr bordercolor="#00FF99" bgcolor="#BAAD74">
            <td colspan="4"><div align="center" class="Estilo6 Estilo2 Estilo3">
                <div align="center"><span class="Estilo1"><!--[Atras]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[Men&uacute; Rubro]--></span> <br>
                </div>
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table>
  </div>
</div><br>            <p>&nbsp;</p>            </td>
        </tr>
      </table>
</div>
  </div>

</form>
</body>
</html>