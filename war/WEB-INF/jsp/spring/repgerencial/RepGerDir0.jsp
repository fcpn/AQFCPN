<%@ include file="../Cabecera.jsp" %>

<style type="text/css">
<!--
.Estilo5 {font-family: Verdana, Arial, Helvetica, sans-serif}
.Estilo3 {	color: #FFFFFF;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	font-weight: bold;
}
.Estilo6 {color: #FFFFFF; font-weight: bold; font-family: Verdana, Arial, Helvetica, sans-serif; }
.Estilo7 {font-size: 9px}
.Estilo9 {font-family: Verdana, Arial, Helvetica, sans-serif; font-weight: bold; }
-->
</style>




<form name="form1" method="post" action="<c:url value="/RepGerDir1.do"/>">
  <table width="472" height="159" border="0" align="center">
    <tr>
      <td height="23"><div align="center"><img src="./././imagenesgeren/avancetarea.png" width="512" height="50"></div></td>
    </tr>
    <tr>
      <td height="23"><div align="center"><br>
          <span class="Estilo9">INFORME</span></div></td>
    </tr>
    <tr>
      <td height="78"><div align="center"><span class="Estilo9">DEL:</span><br>
        <table width="250" border="1" align="center">
          <tr>
            <td bgcolor="#990033"><div align="center" class="Estilo6">FECHA INICIAL</div></td>
          </tr>
          <tr>
            <td bgcolor="#234567">
              <table width="225" border="0" align="center">
                <tr>
                  <td width="30"><div align="center">
                      <select name="dia1" id="dia1">
                        <option value="01" selected>01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                      </select>
                  </div></td>
                  <td width="145"><div align="center">
                      <select name="mes1" id="mes1">
                        <option value="01" selected>Enero</option>
                        <option value="02">Febrero</option>
                        <option value="03">Marzo</option>
                        <option value="04">Abril</option>
                        <option value="05">Mayo</option>
                        <option value="06">Junio</option>
                        <option value="07">Julio</option>
                        <option value="08">Agosto</option>
                        <option value="09">Septiembre</option>
                        <option value="10">Octubre</option>
                        <option value="11">Noviembre</option>
                        <option value="12">Diciembre</option>
                      </select>
                  </div></td>
                  <td width="28"><div align="center">
                      <select name="anio1" id="anio1"> <option value="10" selected>2010
                      </select>
                  </div></td>
                </tr>
                <tr bgcolor="#234567">
                  <td><div align="center" class="Estilo3"><strong>D&iacute;a</strong></div></td>
                  <td><div align="center" class="Estilo3">Mes</div></td>
                  <td><div align="center" class="Estilo3">A&ntilde;o</div></td>
                </tr>
            </table></td>
          </tr>
        </table>
        <p><span class="Estilo9">al:</span></p>
        <table width="250" border="1" align="center">
          <tr>
            <td bgcolor="#990033"><div align="center" class="Estilo6">FECHA FINAL </div></td>
          </tr>
          <tr>
            <td><table width="234" border="0" align="center">
                <tr>
                  <td width="30"><div align="center"><span class="Estilo7">
                      <select name="dia2" id="select7">
                        <option value="01" selected>01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                      </select>
                  </span></div></td>
                  <td width="145"><div align="center"><span class="Estilo7">
                      <select name="mes2" id="select8">
                        <option value="01">Enero</option>
                        <option value="02" selected>Febrero</option>
                        <option value="03">Marzo</option>
                        <option value="04">Abril</option>
                        <option value="05">Mayo</option>
                        <option value="06">Junio</option>
                        <option value="07">Julio</option>
                        <option value="08">Agosto</option>
                        <option value="09">Septiembre</option>
                        <option value="10">Octubre</option>
                        <option value="11">Noviembre</option>
                        <option value="12">Diciembre</option>
                      </select>
                  </span></div></td>
                  <td width="28"><div align="center"><span class="Estilo7">
                      <select name="anio2" id="select9"><option value="10" selected>2010
                      </select>
                  </span></div></td>
                </tr>
                <tr bgcolor="#234567">
                  <td><div align="center" class="Estilo3"><strong>D&iacute;a</strong></div></td>
                  <td><div align="center" class="Estilo3">Mes</div></td>
                  <td><div align="center" class="Estilo3">A&ntilde;o</div></td>
                </tr>
            </table></td>
          </tr>
        </table>
        </div>
      </td>
    </tr>
    <tr>
      <td>
        <div align="right">
          <input type="submit" name="Submit" value="Aceptar">
      </div></td>
    </tr>
  </table>
</form>
<p>&nbsp;</p>
</body>
</html>