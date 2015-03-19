<script language="JavaScript">
function mueveReloj(hora,minuto,segundo){     
    if ( hora < 0 ) {
        hora = 0;
    }
    if ( minuto < 0 ){
	minuto = 0;
    }			    
    if ( segundo < 0 ) {
	segundo = 0;
    }
       segundo +=1;
    if ( segundo > 59 ) {
        segundo = 0;
	minuto += 1;
    }
    if ( minuto > 59 ) {
        hora +=1;
	minuto = 0;
    }	
     if ( hora > 23 ) {
         hora = 0;
    }
    str_segundo = new String (segundo)
    if (str_segundo.length == 1)
       segundo = "0" + segundo

    str_minuto = new String (minuto)
    if (str_minuto.length == 1)
       minuto = "0" + minuto

    str_hora = new String (hora)
    if (str_hora.length == 1)
       hora = "0" + hora    
    if (typeof(document.form_reloj.reloj) != 'undefined') {
    document.form_reloj.reloj.value = hora + ":" + minuto + ":" + segundo;
    }
    setTimeout("mueveReloj( " + hora + "," + minuto+ "," + segundo+ " )",1000)
}
</script>

<table background="./images/bkg-sidebar.gif" border="0" cellspacing="0" cellpadding="0" width="100%" align=left>
<tr valign=top class=colh>
    <td >
        <c:out value="${nombres}"/> [<c:out value="${tipo_usuario}"/> <c:out value="${programa}"/>] <c:out value="${gestion}"/>
    </td>  
    <c:if test="${!empty id_rol}">
        <td align=right>
            <form name=forma action='<c:url value="/verCabeza1.do"/>' method='POST'>
                <c:if test="${cantidad > '1'}"> 
                    <table border=0 cellspacing="0" cellpadding="0" style="">
                        <tr valign=top >
                            <td class="normal" style="color:#ffffff">
                                Cambiar rol ::
                            </td>
                            <td class="normal" style="color:#ffffff"> 
                                <SELECT NAME="id_rol" class=textoEncabezado>
                                    <c:forEach var="roles" items="${listaDeRoles.pageList}">
                                        <OPTION value='<c:out value="${roles.id_rol}"/>' <c:if test="${id_rol == roles.id_rol}">selected</c:if> > 
                                        <c:out value="${roles.rol}"/>
                                    </c:forEach>
                                </SELECT>
                            </td>
                            <td class="normal" style="color:#ffffff">
                                <a href="javascript: document.forma.submit()">Cambiar</a>            
                            </td>
                        </tr>
                    </table>
                </c:if>
            </form>
        </td>    
        <td align=right>
        <a href='<c:url value="/logoutUsuario.do" />'>Terminar Sesion</a>
    </c:if>
    </td>
    <td align=right>
        <body onload='mueveReloj(<c:out value="${hora}"/>,<c:out value="${minuto}"/>,<c:out value="${segundo}"/>)'>
        <form name="form_reloj">
            <input type="text" name="reloj" align="center" size="10" style="background-color : White; color : Black; font-family : Verdana, Arial, Helvetica; font-size : 8pt; text-align : center;" onfocus="window.document.form_reloj.reloj.blur()">
        </form>
    </td>
</tr>
</table>
