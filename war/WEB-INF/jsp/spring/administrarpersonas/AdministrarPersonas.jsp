<%@ include file="../Cabecera.jsp" %>

<script language='JavaScript' SRC="./validar.js"> </script>
<script language='JavaScript'>
    <!--
    function habilitarDep(obj) {
        if (obj.value == "1")
            return 0;
        else
            return 1;
    }
    //javascript:document.forma.id_departamento.disabled = this.value=1;
    -->
</script>
<body onload='inicio(document.forma.nombres)'>

    <form name="forma" method="POST" action='<c:url value="/administrarPersonas.do"/>' >

        <table width=100% border=0 align=center>
            <tr class=colb>
                <th class=colh align=center>ADMINISTRAR PERSONAS - <c:out value="${titulo}"/></th>
        </table>
        <input type=hidden name=salida value='<c:url value="${salida}"/>'>
        <input type=hidden name=titulo value='<c:out value="${titulo}"/>'>
        <br>
        <table><tr><td style="border: 1px solid orange">
                    <table border="0" cellspacing="0">
                        <tr>
                            <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                            <td class="normal" align="justify"><b>Aviso:</b> Esta funci&oacute;n permite crear una cuenta nueva, para el acceso al <b>sistema</b>. mediante autentificaci&oacute;n<br>
			    Rellene los campos del formulario necesarios para esta operaci&oacute;n.</td>
                        </tr>
                    </table>
                </td></tr>
        </table>
        <br>
        <c:if test='${!empty _error}'>
            <br>
            <table align=center border=0>
                <tr>
                    <th class=coler align=center><c:out value="E R R O R"/> </th>
                    <th class=coler align=center>:</th>
                    <th class=coler align=center><c:out value='${_error}'/></th>
            </table>
            <br>
        </c:if>

        <table border=0 cellspacing=0 cellpadding=0>
            <tr>
                <td class=colh align="center" colspan="3" style="border:1px solid black; padding-top:5px; padding-bottom:5px">FORMULARIO DE REGISTRO DE DATOS PERSONALES</td>
            <tr>
                <td class=colhpt style="padding-left:20px; padding-top:10px">Nombres:</td>
                <td colspan=2 class=colhpt style="padding-top:10px"><input class="campo" type=text name=nombres maxlength=30 value="<c:out value="${nombres}"/>"  >
            <tr>
                <td class=colhpt style="padding-left:20px">Apellido Paterno:</td>
                <td colspan=2 class=colhpt> <input class="campo" type=text name=paterno maxlength=30 value="<c:out value="${paterno}"/>"  >
            <tr>
                <td class=colhpt style="padding-left:20px">Apellido Materno:</td>
                <td colspan=2 class=colhpt> <input class="campo" type=text name=materno maxlength=30 value="<c:out value="${materno}"/>"  >
            <tr class="colhpt">
                <td class=colhpt style="padding-left:20px">C&eacute;dula de Identidad:</td>
                <td class=colhpt> <input class="campo" type=text name=dip maxlength=10 size=10 value='<c:out value="${dip}"/>' onblur='validar(this,"9");'>
                <td class="normal">Ingrese unicamente datos n&uacute;mericos de la C&eacute;dula de Identidad, sin el prefijo de ciudad</td>
            <tr>
                <td class=colhpt style="padding-left:20px">Sexo:</td>
                <td colspan=2 class=colhpt>
                    <input type=radio name='id_sexo' value="M" <c:if test="${id_sexo == 'M'}">checked</c:if> >Hombre
                    <input type=radio name='id_sexo' value="F" <c:if test="${id_sexo == 'F'}">checked</c:if> >Mujer
            <tr>
                <td class=colhpt style="padding-left:20px">Fecha de nacimiento:</td>
                <td colspan=2 class=colhpt>
                    <select class="campo" name="dia">
                        <c:forEach var="i" begin='1' end='31'>
                            <option value="<c:out value='${i}'/>" <c:if test="${dia == i}">selected</c:if>>
                                <c:out value="${i}"/>
                            </option>
                        </c:forEach>
                    </select>
                    <select class="campo" name="mes">
                        <option value="1" <c:if test="${mes == 1}">selected</c:if>>  Enero</option>
                        <option value="2" <c:if test="${mes == 2}">selected</c:if>>  Febrero</option>
                        <option value="3" <c:if test="${mes == 3}">selected</c:if>>  Marzo</option>
                        <option value="4" <c:if test="${mes == 4}">selected</c:if>>  Abril</option>
                        <option value="5" <c:if test="${mes == 5}">selected</c:if>>  Mayo</option>
                        <option value="6" <c:if test="${mes == 6}">selected</c:if>>  Junio</option>
                        <option value="7" <c:if test="${mes == 7}">selected</c:if>>  Julio</option>
                        <option value="8" <c:if test="${mes == 8}">selected</c:if>>  Agosto</option>
                        <option value="9" <c:if test="${mes == 9}">selected</c:if>>  Septiembre</option>
                        <option value="10" <c:if test="${mes == 10}">selected</c:if>>Octubre</option>
                        <option value="11" <c:if test="${mes == 11}">selected</c:if>>Noviembre</option>
                        <option value="12" <c:if test="${mes == 12}">selected</c:if>>Diciembre</option>
                    </select>
                    <input class="campo" type=text name=anio maxlength=4 size=4 value='<c:out value="${anio}"/>'> Año (Ej. 1980)
            <tr>
                <td class=colhpt style="padding-left:20px">Direcci&oacute;n:</td>
                <td colspan=2 class=colhpt> <input class="campo" type=text name=direccion size=40 maxlength=50 value="<c:out value="${direccion}"/>"  >
            <tr>
                <td class=colhpt style="padding-left:20px">Telefono:</td>
                <td colspan=2 class=colhpt><input class="campo" type=text name=telefono maxlength=15 value="<c:out value="${telefono}"/>" >
            <tr>
                <td class=colhpt style="padding-left:20px">Correo:</td>
                <td colspan=2 class=colhpt>
                    <c:if test="${empty correo}">
                        <input class="campo" type=text name=correo maxlength=50 value="@">
                    </c:if>
                    <c:if test="${!empty correo}">
                        <input class="campo" type=text name=correo maxlength=50 value="<c:out value="${correo}"/>" >
                    </c:if>
            <tr>
                <td class=colhpt align=right colspan=4 style="padding-top:10px; padding-bottom:10px; padding-right:10px"><input class="button" type=submit name=accion value='Continuar >>'></td>
        </table>
    </form>

    <%@ include file="../VerPieCuerpo.jsp" %>

