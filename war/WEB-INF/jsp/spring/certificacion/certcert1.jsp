<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
    <head>
        <script type="text/javascript" src="prototype.js"></script>
        <link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript">
        function detectBrowser() 
        {
            var ie = document.all != undefined;
            var opera = window.opera != undefined;
            if (opera) return "opera";
            if (ie) {alert("El navegador de internet que utiliza no es compatible para esta aplicacion, por favor utilice Navegador FIREFOX"); window.close(); }//return "ie";
            // if ((window) && (window.netscape) && (window.netscape.security)) {
            if (window.XML) {
                return "firefox15";
            }
            else return "firefox10";
        }
        /***************************************************************RESTRICIIONES ANTES DE GUARDAR PARTIDA POR PARTIDA*/
        var nav4 = window.Event ? true : false;
        function acceptNum(evt){
            var key = nav4 ? evt.which : evt.keyCode;
            return (key <= 13 || (key >= 48 && key <= 57));
        }
        function AcceptNumAndPuntito(evt){
            var key = nav4 ? evt.which : evt.keyCode;
            return (key <= 13 || (key >= 48 && key <= 57) || (key == 46));
        }
        function bloquea(){
            document.form1.partida.disabled = true;
            document.form1.codtar.disabled = true;
            document.form1.codfueneco.disabled = true;
        }
        function formatNumber(numero){ // v2007-08-06
            numero = parseFloat(numero);
            var decimales = 2;
            var separador_decimal = '.';
            var separador_miles = '';
            if (isNaN(numero)){
                return "";
            }
            if (decimales !== undefined){
            // Redondeamos
                numero = numero.toFixed(decimales);
            }
            // Convertimos el punto en separador_decimal
            numero = numero.toString().replace(".", separador_decimal !== undefined ? separador_decimal : ",");
                if (separador_miles){
            // Añadimos los separadores de miles
                    var miles = new RegExp("(-?[0-9]+)([0-9]{3})");
                    while (miles.test(numero)) {
                        numero = numero.replace(miles, "$1" + separador_miles + "$2");
                    }
                }
            return numero;
        }
        function hiddeLoadingImage(){
                $('loading').hide();
        }
    
        function buscar()
        {
            $('loading').show();
            $('resultado').innerHTML="";
            window.setTimeout('hiddeLoadingImage()', 3700);
//          Ajax.Responders.register({
//              onCreate: function() {
//                  $('loading').show();
            var codtar = '<c:out value="${codtar}"/>';
            var params = 'codtar=' + codtar;
            var url = '<c:url value="/certcert2.do"/>';
            new Ajax.Updater({success:'resultado'}, url,
                {method: 'post', parameters: params, onFailure: reportError});
//                            },
//                    onComplete: function() {
//                                    $('loading').hide();
//                            }
//                  });
            return false;
        }
        function reportError(request) {
            $('fixme') = "Error";
        }
        function a_subgrupos(e)
        {
            $('loading').show();
            $('resultado').innerHTML="";
            window.setTimeout('hiddeLoadingImage()', 3700);
            var codgru = e;
            //$('grupo').value = e;
            var codtar = '<c:out value="${codtar}"/>';
            var params = 'codgru=' + codgru + '&codtar=' + codtar;
            var url = '<c:url value="/certcert3.do"/>';
            // alert(url+"?"+params);
            new Ajax.Updater({success:'resultado'}, url,
               {method: 'post', parameters: params, onFailure: reportError});
            //$('resultado').innerHTML="";
            return false;
        }
        function a_partidas (a, b, c){
            $('loading').show();
            $('resultado').innerHTML="";
            window.setTimeout('hiddeLoadingImage()', 3700);
            if (c == '1' && $('especificacion').value == ''){$('especificacion').value = ''; } else{if (c == '1'){$('especificacion').value = $('especificacion').value} else{$('especificacion').value = c; }}//No me combence Funciona PERO Se puede mejorar
            // alert(c);
            var codtar = '<c:out value="${codtar}"/>';
            var codsub = a;
            var codgru = b;
            //alert("esto es a--> "+a+"   Esto es B---->"+b);
            var params = 'codgru=' + codgru + '&codsub=' + codsub + '&codtar=' + codtar;
            var url = '<c:url value="/certcert4.do"/>';
            //alert(url+"?"+params);
            new Ajax.Updater({success:'resultado'}, url,
                {method: 'post', parameters: params, onFailure: reportError});
                $('resultado').innerHTML = "";
                $('en_like').innerHTML = "";
                return false;
        }
        function a_partidas_like (a, b, c, d){
            if (c == '1' && $('especificacion').value == ''){$('especificacion').value = ''; } else{if (c == '1'){$('especificacion').value = $('especificacion').value} else{$('especificacion').value = c; }}//No me combence Funciona PERO Se puede mejorar
            // alert(c);
            $('loading').show();
//          $('resultado').innerHTML="";
            window.setTimeout('hiddeLoadingImage()', 3700);
            var codtar = '<c:out value="${codtar}"/>';
            var codsub = a;
            var codgru = b;
            var codpar = d;
            //alert("esto es a--> "+a+"   Esto es B---->"+b);
            var params = 'codpar=' + codpar + '&codgru=' + codgru + '&codsub=' + codsub + '&codtar=' + codtar;
            var url = '<c:url value="/certcert10.do"/>';
            //alert(url+"?"+params);
            new Ajax.Updater({success:'resultado'}, url,
                {method: 'post', parameters: params, onFailure: reportError});
            $('resultado').innerHTML = "";
            $('en_like').innerHTML = "";
            return false;
        }
        function listo (a){
            $('partida').value = a;
            // alert(" Entro a listo");
            $('resultado').innerHTML = "";
        }
        function limpia(){
            $('requerimiento').value = '';
            $('cantidad').value = '';
            $('monto').value = '';
            $('codtar').value = '';
            $('partida').value = '';
            $('codfueneco').value = '';
            $('saldo').value = '';
            $('com').value = '';
            $('especificacion').value = '';
        }
        function inicio(){
            $('resultado').innerHTML = "<table><tr> <th width='20' style='cursor:pointer' onclick='buscar();'><div align='center'> Menú Partidas </div></th></tr></table>";
        }
        function ok(a, b, c, d, e, f, g, h, i){
            //alert(" Jesus ");
            //alert("que es Comprometido -- "+e);
            ////alert("que es Saldo --------  "+d);
            //i= dis
            //d = sd
            //g= s d com tot
            //var ff= comas(d);
            d = parseFloat(d);
            e = parseFloat(e);
            i = parseFloat(i);
            g = parseFloat(g);
            //alert(" Jesus ");
            //alert("valor i "+i);
            //alert("valor g "+g);
            var sig = i;
            sig = parseFloat(sig);
            if (d > e)
            {
                if (d > g){
                    if (sig > 0)
                    {
                        e = formatNumber(e);
                        d = formatNumber(d);
                        $('codtar').value = '<c:out value="${tarea.num_tarea}"/>';
                        $('partida').value = b;
                        $('codfueneco').value = c;
                        $('saldo').value = d;
                        $('com').value = e;
                        $('ref123').value = f;
                        $('requerimiento').value = h;
                        $('dispo').value = sig;
                        inicio();
                        $('en_like').innerHTML = "";
                    } else{alert("Existe Presupuesto en la partida " + b + " Con fuente economica " + c + " pero no hay disponibilidad financiera, la cual es de " + sig + " comoniquese con el Área Desconcentrada"); }
                }
                else{
                    alert("El pedido que intenta realizar no se puede realizar por que no queda saldo disponible: Revise la lista de sus pedidos de esta certificación para la partida " + b + "  Con fuente economica " + c);
                }
            } 
            else{alert("No tiene saldo para realizar pedidos"); }

            //inicio();
            //$('resultado').innerHTML =" ";
            //

        }
        /*mostrando los ya guardados en la tabla temporal*/
        function mosIni()
        {
            var codtar = '<c:out value="${codtar}"/>';
            /*var codfueneco='';
            var monto='';
            var requerimiento='';
            var partida='';  var cantidad=$('cantidad').value;
            var responsable=$('responsable').value;
            var correlativo = '<c:out value="${coo}"/>';
            var ref123=$('ref123').value;*/
            var params = 'responsable=' + '' + '&ref123=' + '' + '&correlativo=' + '' + '&cantidad=' + '' + '&partida=' + '' + '&codtar=' + codtar + '&monto=' + '' + '&codfueneco=' + '' + '&requerimiento=' + '';
            var url = '<c:url value="/certcert5.do"/>';
            new Ajax.Updater({success:'enviados'}, url,
                {method: 'post', parameters: params, onFailure: reportError});
                //alert("Aqui las sentencias para guardar");
            limpia();
        }
            /*FIN FIN FIN FIN mostrando los ya aldos en la tabla temporal*/

            /******FIN*FIN******FIN**************************************************RESTRICIIONES ANTES DE GUARDAR PARTIDA POR PARTIDA*/


            /*###############################GUARDAR PARTIDA POR PARTIDA*/
        function guarda()            
        {
            var nn = $('cantidad').value;
            var na = $('monto').value;
            var nb = $('com').value;
            var nc = $('saldo').value;
            var disdis = 0;
            disdis = $('dispo').value;
            disdis = parseFloat(disdis);
            nn = parseFloat(nn);
            na = parseFloat(na);
            nb = parseFloat(nb);
            nc = parseFloat(nc);
            
            // alert ("entro con "+nn);
            if ($('responsable').value == ''){
                alert("Por favor inserte datos del Responsable");
            }
            else
            { 
                if ($('cantidad').value == ''){
                    alert("Por favor inserte la cantidad de pedido");
                }
                else
                {
                    if (nn == 0){
                        alert("La cantidad de pedido es 0");
                    } else{
                        if ($('monto').value == ''){
                            alert("Por favor inserte el precio del producto por unidad");
                        }
                        else
                        {
                            if (na == 0){
                                alert("el precio del pedido es 0");
                            }
                            else
                            {
                                if ($('requerimiento').value == ''){
                                    alert("Por favor inserte descripcion de requerimineto");
                                }
                                else
                                {
                                    if ($('especificacion').value == ''){
                                        alert("Por favor inserte descripcion de las especificaciones");
                                    }
                                    else
                                    {
                                        if ($('codtar').value == ''){
                                            alert("Por favor elija la fuente y partida para el gasto");
                                        }
                                        else
                                        {
                                            //alert("cantidad "+nn);
                                            //alert("monto    "+na);
                                            //alert("compro   "+nb);
                                            //alert("saldo    "+nc);
                                            //alert("MONTO total a gastar    "+na);
                                            //alert("SALDO - COMPROMETIDO    "+(nc-nb));

                                            //if((nn*na)>=(nc-nb))   Para los precios unitarios
                                            //if(na>(nc-nb)){ para los precios totales
                                            if (na > (nc - nb)){
                                                alert("El Monto total a gastar sobrepasa el saldo real menos el monto comprometido a la partida");
                                            } else
                                            {
                                                //alert("na monto "+na);
                                                //alert("disdis disponible fin "+disdis);
                                                //alert("comprometido "+ nb);

                                                //alert("tienee que ser mayor  "+(na+nb));
                                                //alert("a la disponi  "+(disdis));
                                                if ((na) > disdis){alert("Existe presupuestos en la partida pero, El Monto total a gastar sobrepasa la disponibilidad Financiera " + disdis + " de su tarea"); }
                                                else{
                                                        //alert("Aqui las sentencias para guardar");alert(" se gastaaaa  ");
                                                        var codtar = '<c:out value="${codtar}"/>';
                                                        var codfueneco = $('codfueneco').value;
                                                        // alert("- codfueneco  "+codfueneco);
                                                        var monto = $('monto').value;
                                                        //  alert("- monto  "+monto);
                                                        var requerimiento = $('requerimiento').value;
                                                        //   alert("- requerimiento  "+requerimiento);
                                                        var partida = $('partida').value;
                                                        // alert("- partida  "+partida);
                                                        var cantidad = $('cantidad').value;
                                                        //  alert("- cantidad  "+cantidad);
                                                        var responsable = $('responsable').value;
                                                        //  alert("- responsable  "+responsable);
                                                        var correlativo = '<c:out value="${coo}"/>';
                                                        //antes var rut = $('rut').value;
                                                        var ref123 = $('ref123').value;
                                                        var especificacion = $('especificacion').value;
                                                        //antes var params = 'ref123='+ref123+'&rut='+rut+'&correlativo='+correlativo+'&cantidad='+cantidad+'&partida='+partida+'&codtar='+codtar+'&monto='+monto+'&codfueneco='+codfueneco+'&requerimiento='+requerimiento;
                                                        var params = 'especificacion=' + especificacion + '&responsable=' + responsable + '&ref123=' + ref123 + '&correlativo=' + correlativo + '&cantidad=' + cantidad + '&partida=' + partida + '&codtar=' + codtar + '&monto=' + monto + '&codfueneco=' + codfueneco + '&requerimiento=' + requerimiento;
                                                        var url = '<c:url value="/certcert5.do"/>';
                                                        //buen ALERT -->>> para la direccion         alert(url+"?"+params);
                                                        new Ajax.Updater({success:'enviados'}, url,
                                                        {method: 'post', parameters: params, onFailure: reportError});
                                                        //alert("Aqui las sentencias para guardar");
                                                        limpia();
                                                        // location.reload();
                                                    }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        /*######FIN FIN FIN FIN FIN #########################GUARDAR PARTIDA POR PARTIDA*/
        /*Borrar los insertardo en la tabla temnporal*/
        function borra(a, b, c, d){
            //cancelar();
            var codtar = a;
            var codfueneco = b;
            var id = c;
            var codmonegr = d;
            //if(e.value.length > 2) {
            var params = 'codmonegr=' + codmonegr + '&id=' + id + '&codfueneco=' + codfueneco + '&codtar=' + codtar;
            // alert("borrando"+params);
            var url = '<c:url value="/certcert6.do"/>';
            new Ajax.Updater({success:'enviados'}, url,
                {method: 'post', parameters: params, onFailure: reportError});
            //}
            //$('resultado').innerHTML="";
            // actualiza la pagina window.location.reload();
            return false;
        }
        /* FION FIN FIN FIN Borrar los insertardo en la tabla temnporal*/
        /*Busqueda para LKE LIKE*/
        function buscar_like(e)
        {
            var codtar = '<c:out value="${codtar}"/>';
            if ((e.value.length % 4) == 0 && e.value.length > 1 && $('codtar').value == '' && $('codfueneco').value == '') { //controlanto las teclas Key
                $('loading').show();
                window.setTimeout('hiddeLoadingImage()', 5000);
                var params = 'lik=' + e.value + '&codtar=' + codtar;
                var url = '<c:url value="/certcert7.do"/>';
                new Ajax.Updater({success:'en_like'}, url,
                    {method: 'post', parameters: params, onFailure: reportError});
            }
            else{ $('loading').hide(); $('en_like').innerHTML = ""; }
            return false;
        }
        function reportError(request) {
            $('fixme') = "Error";
        }
        /*FIN FIN FIN FIN FINF INF INFINBusqueda para LKE LIKE*/
        /*para buscar lasa partidas a partir del Like*/
        function busca_partida_like(a, b, c)
        {
        }
        //Formularios FORMULARIOS
        function inicio2(){
            // alert("ENTRAAAA");
            $('validar').innerHTML = "No valido para Formularios de compra";
        }
        function valida_formulario(){
            $('validar').innerHTML = "Valido para Formularios de compra";
        }
    </script>
    <title>Certificaci&oacute;nn</title>
        <style type="text/css">
            table{
                width: 75%;
            }
            .sal_ir{
                width: 15%;
                text-align: right;
            }
            #loading {
                z-index: 100;
                position: absolute;
                top: 30%;
                left: 40%;
                background-image: url("images/progress-running.gif");
                background-repeat: no-repeat;
                background-position: 5px;
                background-color: white;
                padding-left: 25px;
                padding-top: 8px;
                /*border-style: double;*/
                border-color: #c0c0c0;
                width: 120px;
                height: 30px;
                font-size: 1.0em;
                font-weight: bolder;
            }
        </style>
    </head>
    <body >
        <div id="content" align="center">
            <form name="form1" method="post" action='<c:url value="/cert5.do" />'>
                <table>
                <tr>
                    <th colspan="2"><h2 align="center">SOLICITUD DE CERTIFICACI&Oacute;N<br><c:out value="${fech_hora}"/></h2></th>
                </tr>

                <tr>
                    <th>Apertura Programatica</th>
                    <td><c:out value="${descripCarrera.des_actividad}"/></td>
<!--                <td rowspan="3" bgcolor="#E9F1FE"><div align="center" class="Estilo16"><h2><c:out value="${tarea.num_tarea}"/></h2></div></td>-->
                </tr>
                <tr>
                    <th>Tarea</th>
                    <td><c:out value="${tarea.descripcion}"/></td>
                </tr>
                <tr>
                    <th>Resp. Tarea</th>
                    <td><input name="responsable" type="text" id="responsable" size="40"></td>
                </tr>
                <tr>
                    <th>Cod. Apertura Program&aacute;tica</th>
                    <td><c:out value="${actividad.apertura_prog}"/></td>
                </tr>
                </table>
                <br>
                <div id="loading" style="display:none">Cargando...
                    <div style="background-color: white; position: absolute; top: 0px; right: 0px; width: 5px; height: 5px; cursor:pointer;"
                        onclick="$('loading').hide()">
                    </div>
                </div>
                <div id="resultado"></div>
                <br>
                <table>
                    <tr>
                        <th colspan="7"><div align="center">Descripci&oacute;n de la Partida </span></div></th>
                    </tr>
                    <tr>
                        <td colspan="7"><div align="center">
                            <textarea name="requerimiento" cols="65" readonly="readonly" id="requerimiento"></textarea>
                        </div></td>
                    </tr>
                    <tr>
                        <td colspan="7">
                            <br>
                            <div id="en_like" align="center"> </div> 
                        </td> 
                    </tr>
                    <tr>
                        <th>Especificacion (Ejem. color, modelo, etc)</th>
                        <td colspan="6"><input name="especificacion" type="text" id="especificacion" size="80" onKeyPress="javascript:buscar_like(this)"/></td>
                    </tr>
                    <tr>
                        <th><div align="center">Cantidad</div></th>
                        <th><div align="center">Monto</div></th>
                        <th><div align="center">Tarea</div></th>
                        <th><div align="center">Partida</div></th>
                        <th><div align="center">FF - OF</div></th>
                        <th>Adiciona</th>
                        <th>Disminuye</td>
                    </tr>
                    <tr>
                        <td bgcolor="#666666"><div align="center">
                            <input name="cantidad" type="text" id="cantidad" size="3" onKeyPress="return acceptNum(event)">
                        </div></td>
                        <td bgcolor="#666666"><div align="center" >
                            <input name="monto" type="text" id="monto" size="3" onKeyPress="return AcceptNumAndPuntito(event)" >
                        </div></td>
                        <td><div align="center">
                            <input  size="3" name="codtar" type="text" id="codtar" readonly="readonly"  size="6"/>
                        </div></td>
                        <td><div align="right">
                            <input  name="partida" type="text" id="partida" readonly size="7">
                        </div></td>
                        <td><input  name="codfueneco" type="text" id="codfueneco" readonly="readonly"  size="7" /></td>
                        <td><div align="center">00</div></td>
                        <td><div align="center">00</div></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <th><div align="center">Saldo real</div></th>
                        <th><div align="center">Monto comprometido a la partida</div></td>
                    </tr>
                    <tr>
                        <td><div align="center">
                            <input  name="saldo" type="text" id="saldo" size="7" readonly="readonly"/>
                        </div></td>
                        <td><div align="center">
                            <input  name="com" type="text" id="com" size="7" readonly="readonly" />
                        </div></td>
                        <th style="cursor:pointer" onclick="javascript:guarda(this)"> 
                            <div align="center"><strong>A&ntilde;adir a la lista</strong></div>
                        </th>
                    </tr>
                </table>
                <br>
                <div id="enviados"></div>
                <input type=hidden name=codacti id="ref123">
                <input type=hidden name=codtar  id="codtar" value='<c:out value="${codtar}"/>'>
                <input type=hidden name=sumcomtmp id="sumcomtmp">
                <input type=hidden name=dispo id="dispo">
            </form>
        </div>
        <script>
                    setTimeout(detectBrowser, 100);
                    setTimeout(mosIni, 500);
                    setTimeout(inicio, 800);
        </script>
       
    </body>
</html>