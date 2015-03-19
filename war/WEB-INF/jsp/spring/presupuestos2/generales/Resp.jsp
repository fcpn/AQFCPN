<%@ include file="../../Cabecera.jsp" %>
<html>
    <head>
        <title>Documento sin t&iacute;tulo</title>
        <style type="text/css">
            <!--
			TABLE { border-collapse: collapse; border: none; }
.Estilo3 {color: #FFFFFF; font-weight: bold; }
.Estilo4 {color: #FFFFFF}
.Estilo6 {font-size: 12px}
.Estilo10 {font-size: 12px; color: #FFFFFF; font-weight: bold; }
.Estilo11 {font-size: 12px; color: #FFFFFF; }
            -->
        </style>
    </head>

    <body>

        <form name="form1" method="post" action=" <c:url value="/Resp2.do"/>" >
            <br><br><br>
            <table width="487"  align="center">
                <tr bgcolor="#000033">
                  <td colspan="2"><div align="center"><span class="Estilo3">Datos Generales</span></div></td>
                </tr>
                <tr>
                    <td width="300">Actividad: <c:out value="${actividad.descripcion}"/> </td>
                    <td width="300">Tarea: <c:out value="${tarea.descripcion}"/> </td>
                </tr>
            </table>
            <br>
            <br>
            <table width="498"  align="center">
                <tr>
                    <td width="307" bgcolor="#000033" align="center">
                            <h3 align="center" class="Estilo4"> Datos Del Responsable de tarea</h3>
</td>
                </tr>
                <tr>
                    <td height="68">
                        <div align="center"><br>
                            <table width="401" >
                                <tr>
                                    <td width="122" height="35" bgcolor="#011E41"><div align="right"><span class="Estilo10">CI.</span></div></td>
                                    <td width="196" bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="coddatgen" type="text" id="coddatgen2">
                                            </div>
                                  </div></td>
                                    <td width="89"> </td>
                                </tr>
                                <tr>
                                    <td height="36" bgcolor="#011E41"><div align="right"><span class="Estilo10">Nombre</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="nom" type="text" id="nom">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="35" bgcolor="#011E41"><div align="right"><span class="Estilo10">Apellido Paterno </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="ap" type="text" id="ap">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="36" bgcolor="#011E41"><div align="right"><span class="Estilo10">Apellido Materno </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="am" type="text" id="am">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
								 <tr>
                                    <td height="33" bgcolor="#011E41"><div align="right"><span class="Estilo10">Objetivo </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="objetivo" type="text" id="objetivo">
                                            </div>
                                   </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="36" bgcolor="#011E41"><div align="right"><span class="Estilo10">Email</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="email" type="text" id="email">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="36" bgcolor="#011E41"><div align="right"><span class="Estilo10">Telefono</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="telf" type="text" id="telf">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="35" bgcolor="#011E41"><div align="right"><span class="Estilo10">Celular</span></div></td>


                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="cel" type="text" id="cel">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="34" bgcolor="#011E41"><div align="right"><span class="Estilo10">Cargo</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="cargo" type="text" id="cargo">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="38" bgcolor="#011E41"><div align="right"><span class="Estilo10">Resultado </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="cargah" type="text" id="cargah">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
								<tr>
                                    <td height="86" bgcolor="#011E41"><div align="right"><span class="Estilo10">Identificaci&oacute;n de la Funci&oacute;n </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <textarea name="funcion" cols="22" id="funcion"></textarea>
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
<tr>
                                    <td height="81" bgcolor="#011E41"><div align="right"><span class="Estilo10">Pol&iacute;tica estrat&eacute;gica(PILAR)</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <textarea name="poli" cols="22" id="poli"></textarea>
                                            </div>
            </div></td>
                                    <td> </td>
                              </tr>
                              <tr>
                                    <td height="81" bgcolor="#011E41"><div align="right"><span class="Estilo10">Beneficiarios</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <textarea name="beneficiarios" cols="22" id="beneficiarios"></textarea>
                                            </div>
            </div></td>
                                    <td> </td>
                              </tr>

                                <tr>
                                    <td rowspan="2" bgcolor="#011E41"><span class="Estilo10">Vigencia</span></td>
                                    <td height="35" bgcolor="#011E41"><div align="right" class="Estilo11"><strong>Fecha Inicio ---&gt;</strong></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="fechai" type="text" id="fechai" size="12">
                                            </div>
                                  </div></td>
                                </tr>
                                <tr>
                                    <td height="33" bgcolor="#011E41"><div align="right" class="Estilo11"><strong>Fecha Final ---&gt;</strong></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="fechaf" type="text" id="fechaf" size="12">
                                            </div>
                                  </div></td>
                                </tr>
                                <tr>
                                    <td rowspan="3">&nbsp;</td>
                                  <td colspan="2">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td><input type="reset" name="Submit" value="Cancelar"></td>
                                    <td><input type="submit" name="Submit2" value="Guardar"></td>
                                </tr>
                          </table>
                            <br>
                    </div></td>
                </tr>
    </table>

			<input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
            <input type=hidden name=codtar value='<c:out value="${tarea.codtar}"/>'>
            <br>
        </form>
    </body>
</html>
