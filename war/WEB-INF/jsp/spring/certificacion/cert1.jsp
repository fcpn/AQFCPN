<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<html>
    <head>
	<script type="text/javascript" src="prototype.js"></script>
    <%int g=0;%>
<script type="text/javascript">


    /////valdaciond


var nav4 = window.Event ? true : false;
function acceptNum(evt){
// NOTIRIJILLA: Backspace = 8, Enter = 13, '0' = 48, '9' = 57
var key = nav4 ? evt.which : evt.keyCode;
return (key <= 13 || (key >= 48 && key <= 57));

}
//-->



    ////
    var i=0;
    var list = new String();

            function buscar(e)
            {
               var codtar='<c:out value="${codtar}"/>';
               if(e.value.length > 2) {
                var params = 'lik='+e.value+'&codtar='+codtar;

                var url = '<c:url value="/cert2.do"/>';
          
                new Ajax.Updater({success:'resultado'},url,
                {method: 'post', parameters: params, onFailure: reportError});
               }
               else{ $('resultado').innerHTML="";}
               return false;
            }
            function reportError(request) {
                $('fixme') = "Error";
            }

            function copi(t,x,y,z,s,c,r)
            {
                $('descripciones').value = t;
                $('codfueneco').value = x;
                $('codtar').value = y;
                $('partida').value = z;
                $('saldo').value = s;
                $('com').value = c;
                $('ref123').value=r;
                // $('correlativo').value = p;
                //$('rut').value = r;

                $('resultado').innerHTML =" ";

            }


            //***************************
            function llamando()
            {


                var codtar='<c:out value="${codtar}"/>';
                var codfueneco=$('codfueneco').value;
                var monto=$('monto').value;
                var requerimiento=$('descripciones').value;
                var responsable=$('responsable').value;
                var partida=$('partida').value;
                var cantidad=$('cantidad').value;
                var correlativo = '<c:out value="${coo}"/>';
               //antes var rut = $('rut').value;
                var ref123=$('ref123').value;
               //antes var params = 'ref123='+ref123+'&rut='+rut+'&correlativo='+correlativo+'&cantidad='+cantidad+'&partida='+partida+'&codtar='+codtar+'&monto='+monto+'&codfueneco='+codfueneco+'&requerimiento='+requerimiento;
                var params = 'responsable='+responsable+'&ref123='+ref123+'&correlativo='+correlativo+'&cantidad='+cantidad+'&partida='+partida+'&codtar='+codtar+'&monto='+monto+'&codfueneco='+codfueneco+'&requerimiento='+requerimiento;

                var url = '<c:url value="/cert3.do"/>';
                //buen ALERT -->>> para la direccion         alert(url+"?"+params);
                new Ajax.Updater({success:'enviados'},url,
                {method: 'post', parameters: params, onFailure: reportError});

                cancelar();

            }

            //***************************








            function guarda()
            {

                if($('responsable').value == ''){
                    alert("Por favor inserte datos del Responsable");
                }
                else
                { if($('cantidad').value==''){
                    alert("Por favor inserte la cantidad de pedido");
                }
                else
                { if($('monto').value==''){
                    alert("Por favor inserte el precio del producto por unidad");
                }
                else
                {
                            var codtar='<c:out value="${codtar}"/>';
                            var codfueneco=$('codfueneco').value;
                            var monto=$('monto').value;
                            var requerimiento=$('descripciones').value;
                            var partida=$('partida').value;
                            var cantidad=$('cantidad').value;
                            var responsable=$('responsable').value;
                            var correlativo = '<c:out value="${coo}"/>';
                        //antes var rut = $('rut').value;
                            var ref123=$('ref123').value;
                            //antes var params = 'ref123='+ref123+'&rut='+rut+'&correlativo='+correlativo+'&cantidad='+cantidad+'&partida='+partida+'&codtar='+codtar+'&monto='+monto+'&codfueneco='+codfueneco+'&requerimiento='+requerimiento;
                            var params = 'responsable='+responsable+'&ref123='+ref123+'&correlativo='+correlativo+'&cantidad='+cantidad+'&partida='+partida+'&codtar='+codtar+'&monto='+monto+'&codfueneco='+codfueneco+'&requerimiento='+requerimiento;
                
                            var url = '<c:url value="/cert3.do"/>';
                            //buen ALERT -->>> para la direccion         alert(url+"?"+params);
                            new Ajax.Updater({success:'enviados'},url,
                            {method: 'post', parameters: params, onFailure: reportError});

                            cancelar();
                       }
                     }
                }
              
            }
            function cancelar(){
                $('codtar').value="";
                $('codfueneco').value="";
                $('monto').value="";
                $('descripciones').value="";
                $('partida').value="";
                $('cantidad').value="";
                //$('correlativo').value="";
                //$('rut').value="";
                $('responsable').value="";
                $('ref123').value="";
                $('saldo').value="";
                $('com').value="";

            }
            function borra(a,b,c,d){
                cancelar();
                var codtar=a;
                var codfueneco=b;
                var id=c;
                var codmonegr=d;
                

               //if(e.value.length > 2) {
                var params = 'codmonegr='+codmonegr+'&id='+id+'&codfueneco='+codfueneco+'&codtar='+codtar;
               // alert("borrando"+params);
                var url = '<c:url value="/cert4.do"/>';

                new Ajax.Updater({success:'enviados'},url,
                {method: 'post', parameters: params, onFailure: reportError});
               //}
               //$('resultado').innerHTML="";
               // actualiza la pagina window.location.reload();
               return false;

            }

            function preguntita ()
            {
                if(confirm('borrar???')){
                    alert("then por si");
                }
                else{
                    alert("else por si");
                }

            }
</script>







        <title>Certificacion</title>
        <style type="text/css">
<!--
.Estilo1 {font-size: large}
.Estilo2 {font-size: 10px}
.Estilo4 {font-size: 10px; font-weight: bold; }
.Estilo5 {font-size: 12px}
-->
</style>













    </head>



    <body >


        <form name="form1" method="post" action="<c:url value="/cert5.do"/>">

<br><br><br>



		        <table width="701" height="382" border="1" align="center">
  <tr>
    <td width="664"><div align="center"></div>


	<table width="592" height="84" border="1" align="center">
      <tr>
        <td width="225">Universidad Mayor de San Andres </td>
        <td width="13">&nbsp;</td>
        <td width="148">Form</td>
        <td width="205">002</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>Solicitud No </td>
        <td><c:out value="${coo}"/></td>
      </tr>
     
    </table>
      <div align="center"><br>
        <strong> SOLICITUD DE CERTIFICADO </strong><br>
        Fecha - <c:out value="${fech_hora}"/></div>




















	<table width="581" border="1" align="center">
        <tr>
          <td><span class="Estilo5">Apertura Programatica </span></td>
          <td><c:out value="${descripCarrera.idcarrera}"/></td>
          <td>&nbsp;</td>
          <td rowspan="3"><div align="center" class="Estilo1">1</div></td>
        </tr>
        <tr>
          <td><span class="Estilo5">Tarea</span></td>
          <td><c:out value="${tarea.descripcion}"/></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td><span class="Estilo5">Resp. Tarea </span></td>
          <td><input name="responsable" type="text" id="responsable"></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td><span class="Estilo5">Cod. Apertura Program&aacute;tica</span></td>

          <td><c:out value="${actividad.apertura_prog}"/></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>


	<table width="577" border="0" align="center" bordercolor="#000000">
        <tr>
          <td height="5" bgcolor="#000000"> </td>
        </tr>
      </table>




<br>





 <div id="enviados">
                 <!-- resultados -->
</div>





      <br>
      <table width="582" height="52" border="1" align="center">
        <tr>
          <td width="45"><span class="Estilo4">Nro</span></td>
          <td width="115"><span class="Estilo4">Requirimiento</span></td>
          <td width="41"><span class="Estilo4">Cantidad</span></td>
          <td width="43"><span class="Estilo4">Monto</span></td>
          <td width="55"><span class="Estilo4">Tarea</span></td>
          <td width="62"><span class="Estilo4">Partida</span></td>
          <td width="46"><span class="Estilo4">FF</span></td>
          <td width="24"><span class="Estilo4">OF</span></td>
          <td width="39"><span class="Estilo4">Adiciona</span></td>
          <td width="48"><span class="Estilo4">Disminuye</span></td>
        </tr>
        <tr>
          <td class="Estilo5">1</td>
          <td> <input name="requerimiento" type="text" id="descripciones" onKeyPress="javascript:buscar(this)"/>
              <div id="resultado">
                 <!-- resultados -->
              </div>

          </td>

          <td valign="top"><div align="right">
            <input name="cantidad" type="text" id="cantidad" size="3" onKeyPress="return acceptNum(event)">
          </div></td>
          <td valign="top"> <div align="right" >
            
            <input name="monto" type="text" id="monto" size="3" onKeyPress="return acceptNum(event)">
</div></td>
          <td valign="top"><input name="codtar" type="text" id="codtar" size="6" /></td>
          <td valign="top"><div align="right">
            <input  name="partida" type="text" id="partida" size="7">
          </div></td>
          <td valign="top"><input  name="codfueneco" type="text" id="codfueneco" size="7" /></td>
          <td valign="top">&nbsp;</td>
          <td valign="top">00</td>
          <td valign="top">00</td>
        </tr>

      </table>




  <table width="200" border="1" align="center">
        <tr>
          <td width="78"><div align="center">Saldo real </div></td>
          <td width="8">&nbsp;</td>
          <td width="92"><div align="center">Monto comprometido a la partida </div></td>
        </tr>
        <tr>
          <td><div align="center">
            <input  name="saldo" type="text" id="saldo" size="7" />

          </div></td>
          <td>&nbsp;</td>
          <td><div align="center">
<input  name="com" type="text" id="com" size="7" />
          </div></td>

          <td>&nbsp;</td>
          <td style="cursor:pointer" onclick="javascript:guarda(this)"> añadir a la lista </td>
        </tr>
      </table>




 <table width="584" border="0" align="center">
       <tr>
          <td width="64">fecha</td>
          <td width="504">&nbsp;</td>
        </tr>
      </table>
      <br>
      <table width="586" border="1" align="center">
        <tr>
          <td><div align="justify" class="Estilo2">El AREA DESCONCENTRADA DE LA FACULTAD en cumplimiento de los Reglamentos Especificos del sistema de Programacion de Operaciones y Presupuestos certifica que la solicitud es PROCEDENTE </div></td>
        </tr>
      </table>
      <p align="center">&nbsp;</p>
 


<input type=hidden name=codacti id="ref123">
<input type=hidden name=codtar  id="codtar" value='<c:out value="${codtar}"/>'>


  <table align="right">
<tr>
<td>

<a  href="<c:url value="/cert5.do">
                       <c:param name="codtar" value="${codtar}"/>
                       
                   </c:url>"> Aceptar </a>
</td>

</tr>
</table>


</td>


  </tr>



 


</table>

<!-- <input type=hidden name=codacti value='<c:out value="${actividad.codacti}"/>'>
 -->





  </form>


<script>

    setTimeout(llamando,800);

</script>
    </body>


</html>

