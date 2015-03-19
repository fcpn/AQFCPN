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
.Estilo12 {color: #000000}
            -->
        </style>
    </head>

    <body>

        <form name="form1" method="post" action=" <c:url value="/ModEliGen2_1.do"/>" >
            <br><br><br>
            <table width="487"  align="center">
                <tr bgcolor="#000033">
                  <td><div align="center"><span class="Estilo3">Datos Generales</span></div></td>
                </tr>
                <tr>
                    <td> Tarea: <c:out value="${tarea.descripcion}"/> </td>
                </tr>
            </table>
            <br>
            <br>
            <table width="498"  align="center">
                <tr>
                    <td width="307" bgcolor="#000033" align="center">
                            <h3 align="center" class="Estilo4"> Datos Del Responsable de Tarea </h3>
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
                                              <input name="coddatgen2" type="text" id="coddatgen2" value="<c:out value="${g.coddatgen}"/>">
                                            </div>
                                  </div></td>
                                    <td width="89"> </td>
                                </tr>
                                <tr>
                                    <td height="36" bgcolor="#011E41"><div align="right"><span class="Estilo10">Nombre</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="nom2" type="text" id="nom2" value="<c:out value="${g.nom}"/>">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="35" bgcolor="#011E41"><div align="right"><span class="Estilo10">Apellido Paterno </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="ap2" type="text" id="ap2" value="<c:out value="${g.ap}"/>">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="36" bgcolor="#011E41"><div align="right"><span class="Estilo10">Apellido Materno </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="am2" type="text" id="am2" value="<c:out value="${g.am}"/>">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
								 <tr>
                                    <td height="33" bgcolor="#011E41"><div align="right"><span class="Estilo10">Objetivo </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="objetivo2" type="text" id="objetivo2" value="<c:out value="${g.objetivo}"/>">
                                            </div>
                                   </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="36" bgcolor="#011E41"><div align="right"><span class="Estilo10">Email</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="email2" type="text" id="email2" value="<c:out value="${g.email}"/>">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="36" bgcolor="#011E41"><div align="right"><span class="Estilo10">Telefono</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="telf2" type="text" id="telf2" value="<c:out value="${g.telf}"/>">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="35" bgcolor="#011E41"><div align="right"><span class="Estilo10">Celular</span></div></td>


                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="cel2" type="text" id="cel2" value="<c:out value="${g.cel}"/>">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="34" bgcolor="#011E41"><div align="right"><span class="Estilo10">Cargo</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="cargo2" type="text" id="cargo2" value="<c:out value="${g.cargo}"/>">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td height="38" bgcolor="#011E41"><div align="right"><span class="Estilo10">Resultado </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="cargah2" type="text" id="cargah2" value="<c:out value="${g.cargah}"/>">
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
								<tr>
                                    <td height="86" bgcolor="#011E41"><div align="right"><span class="Estilo10">Identificaci&oacute;n de la Funci&oacute;n </span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <textarea name="funcion2" cols="22" id="funcion2"><c:out value="${g.funcion}"/></textarea>
                                            </div>
                                  </div></td>
                                    <td> </td>
                                </tr>
<tr>
                                    <td height="81" bgcolor="#011E41"><div align="right"><span class="Estilo10">Pol&iacute;tica estrat&eacute;gica(PILAR)</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <textarea name="poli2" cols="22" id="poli2"><c:out value="${g.poli}"/></textarea>
                                            </div>
            </div></td>
                                    <td> </td>
                              </tr>
                              <tr>
                                    <td height="81" bgcolor="#011E41"><div align="right"><span class="Estilo10">Beneficiarios</span></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <textarea name="beneficiarios2" cols="22" id="beneficiarios2"><c:out value="${g.beneficiarios}"/></textarea>
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
                                              <input name="fechai2" type="text" id="fechai2" size="12" value="<c:out value="${g.fechai}"/>">
                                            </div>
                                  </div></td>
                                </tr>
                                <tr>
                                    <td height="33" bgcolor="#011E41"><div align="right" class="Estilo11"><strong>Fecha Final ---&gt;</strong></div></td>
                                    <td bgcolor="#661006">
                                        <div align="center" class="Estilo6">
                                            <div align="left">
                                              <input name="fechaf2" type="text" id="fechaf2" size="12" value="<c:out value="${g.fechaf}"/>">
                                            </div>
                                  </div></td>
                                </tr>
                                <tr>
                                    <td rowspan="3">&nbsp;</td>
                                  <td colspan="2">&nbsp;</td>
                                </tr>
                                <tr>
                                    <td> </td>
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
