<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">
<%@ include file="../Cabecera.jsp" %>
<script type="text/javascript">
    function buscar_persona(e,id)
    {
        var sd=String(id);
        if(e.length>=1) {
            var params = 'id='+id+'&lik='+e;
            var url = '<c:url value="/BuscarPersona_Jes2.do"/>';
            new Ajax.Updater({success:sd},url,
            {method: 'post', parameters: params, onFailure: reportError});
        }
        else{ $(sd).innerHTML="";}
        return false;
    }
    function reportError(request) {
        $('fixme') = "Error";
    }
    function al_in(ii,des){

        $('uni_medida'+ii).value=des;
        $(ii).innerHTML="";
    }
</script>



<table width=100% border="0" align=center>
    <tr>
        <th class=colh align=center>Buscar Personas</th>
    </tr>
</table>
<table align="center"><tr><td style="border: 1px solid orange">
            <table border="0" cellspacing="0">
                <tr>
                    <td valign="top"><img src="./images/light.gif" width="20" height="20"></td>
                    <td class="normal" align="justify">
                        <b>Aviso:</b> En esta secci&oacute;n ingrese los datos necesarios para la busqueda de personas registradas
                    </td>
                </tr>
            </table>
        </td></tr>
</table>
<form name="adminusers" action='<c:url value="/administrarUsuarios.do"/>'>
    <p><input type="submit" class="button" value="Administrar usuarios"></p>
</form>

<div id="personainfoUpdate" style="display:inline">
</div>
<form name="bpjes" method="post" action='<c:url value="/Buscarpersona_Jes2.do"/>'>
    <table align="center">
        <tr>
            <td colspan="2">
                <input name="nombres" type="text">
            </td>
        </tr>
        <tr>
            <td class="campo">
                <div align="center"><input type="radio" name="tipo_bus" value="n" checked></div>
            </td>
            <td class="campo">
                <div align="center"><input type="radio" name="tipo_bus" value="ci"></div>
            </td>
        </tr>
        <tr>
            <td class="campo">
                <div align="center">Nombres</div>
            </td>
            <td class="campo">
                <div align="center">Cedula de Identidad</div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div align="right"><input type="submit" name="BUSCAR" id="BUSCAR" value="BUSCAR"></div>
            </td>
        </tr>
    </table>
</form>

<%@ include file="../VerPieCuerpo.jsp" %>


