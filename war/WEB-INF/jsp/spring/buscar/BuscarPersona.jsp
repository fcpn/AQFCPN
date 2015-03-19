<!DOCTYPE HTML PUBLIC "HTML 4.01 Transitional">

<script language='JavaScript' SRC="./validar.js">  </script>
<script type="text/javascript">
    var getURL= document.URL
    function EscribirValor() {
        document.forma.url.value=innerHTML=getURL
    }
    function highlightWord(node,word) {
        word = word.replace(/([\.\{\}\[\]\^\$\/\\\+\*\?\(\)])/g, "\\$1");
        var re = new RegExp("(>[^<]*?)\\b(" + word + ")\\b([^>]*?<)", 'gi');
        var str = node.innerHTML;
        var str = str.replace(re, '$1<span class=searchword>$2</span>$3');
        node.innerHTML = str;
        node = null; re = null; str = null; word = null;
    }
    function SearchHighlight(search) {
        if (!document.createElement) return;
        var ref = document.referrer;

        if (ref.indexOf('torrentz.com') != -1 || search) {
            if (ref.indexOf('torrentz.com') != -1)
                search = ref.replace(/^.*?torrentz.com\/(search|search-deep|find)_(.*?)(_0\w)?$/i, '$2');
            var words = unescape(search.replace(/-/g,' ')).split(/\s+/);
            for (w=0;w < words.length;w++) {
                highlightWord(document.getElementById('content'),words[w]);
            }
        } else googleSearchHighlight(ref);
        search = null; ref = null;
    }
    function googleSearchHighlight(ref) {
        if (ref.indexOf('?') == -1) return;
        qs = ref.substr(ref.indexOf('?')+1);
        qsa = qs.split('&');
        for (i=0;i < qsa.length;i++) {
            qsip = qsa[i].split('=');
            if (qsip.length == 1) continue;
            if (qsip[0] == 'q' || qsip[0] == 'p' || qsip[0] == 'search') { // q= for Google, p= for Yahoo, search= for BitTorrent
                words = unescape(qsip[1].replace(/\+/g,' ')).split(/\s+/);
                for (w=0;w < words.length;w++) {
                    highlightWord(document.getElementById('content'),words[w]);
                }
            }
        }
    }
    function seeAll() {
        document.buscarPersona.entrada.value = '*';
        document.getElementById('nombres').checked = true;
        document.buscarPersona.submit();
    }
    function confirma(miurl, n){        
        question = confirm("Borrar del sistema Aquiles a [ "+n+" ] ?");
        if (question !="0"){
            document.location.href = miurl;
        }
    }
</script>
<style type="text/css">
    .searchword {
        background-color: #C2EEFF;
    }
</style>

<form name=buscarPersona method="POST" action='<c:url value="/buscarPersona.do"/>' >
    <input type=hidden name=salida value='<c:out value="${salida}"/>'>
    <input type=hidden name=titulo value='<c:out value="${titulo}"/>'>
    <input type=hidden name=vista  value='<c:out value="${vista}"/>'>

    <table width=100%>
        <tr>
            <td class=colh align=center style="padding-top:3px;padding-bottom:3px"><c:out value="${titulo}"/></td>
        </tr>
    </table>

    <table align=center>
        <tr>
            <td class=colfindn colspan=3 align=center>BUSQUEDA DE PERSONAS</td>
        </tr>
        <tr>
            <td align=center><input id="entrada" type=text name=entrada size=50 maxlength=35 onblur='validar(this,"A9")' value='<c:out value="${entrada}"/>'></td>
        </tr>
        <tr>
            <td align=center><input class="button" type=submit name=buscar value='Buscar'>
                <input class="button" type=reset value='Restablecer'></td>
        </tr>
        <tr>
            <!-- Criterios de busqueda -->
            <td class=colfind>Busqueda:
                <input type=radio name='busqueda' value="ci" checked>c&eacute;dula
                <input id="nombres" type=radio name='busqueda' value="nombres">nombres    &nbsp;&nbsp;
                <!-- Fin de los criterios en lista -->
                <font class="normal"><b><a href="javascript:seeAll()" style="text-decoration:underline">mostrar todo...</a></b>
            </td>
        </tr>
    </table>
    <c:if test="${tamanio == 0}">
        <script>
            document.getElementById('entrada').style.background = '#FFE9E9';
        </script>
    </c:if>
    <c:if test="${tamanio > 0}">
        <script>
            document.getElementById('entrada').style.background = 'YELLOW';
        </script>
    </c:if>
    <table width=100%>
        <tr>
            <td class=colh>RESULTADOS:
        <c:if test="${!empty tamanio}">
            (<c:out value="${tamanio}"/>) Resultado(s) de la Busqueda
            Criterio: (<c:out value="${busqueda}"/>)  Entrada: (<c:out value="${entrada}"/>)
        </c:if>
        <c:if test="${!empty _error}">
            <tr>
                <td class=coler><c:out value="${_error}"/>
        </c:if>
    </table>
</form>

<div id="content">    
    <c:if test="${tamanio > 0}" >
        <table border="0" cellspacing="0" cellpadding="0" width="70%">
            <tr>
                <td class="colh" align=center>CI</td>
                <td class="colh" align=center>Nombres</td>
                <td class="colh" align=center> </td>
            </tr>
            <c:forEach var="datos" items="${listaPersonas.pageList}">
                <tr onMouseOver="this.style.backgroundColor='#CC9999';" onMouseOut="this.style.backgroundColor='#ffffff';">
                    <td class="colb"><c:out value="${datos.dip}"/></td>
                <td class="colb">
                <c:if test="${datos.id_estado == 'A'}">
                    <a href=<c:url value="${salida}">
                        <c:param name="id_persona" value="${datos.id_persona}"/>
                        <c:param name="salida" value="${salida}"/>
                        </c:url>>
                </c:if>
                <c:out value="${datos.nombre_completo}"/></a></td>
                <td class="color_reprobado" align=center>

                    <a style="cursor: pointer; color: red;"  onClick="confirma('<c:url value="/EliminarUsuario.do">
                        <c:param name="id_persona" value="${datos.id_persona}"/>
                        <c:param name="nom_persona" value="${datos.nombre_completo}"/>
                        </c:url>','<c:out value="${datos.nombre_completo}"/>'); return false;">Eliminar
                    </a>


                </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<script>
    document.getElementById('entrada').focus();
    SearchHighlight("<c:out value="${entrada}"/>")
</script>

<%@ include file="../VerPieCuerpo.jsp" %>



