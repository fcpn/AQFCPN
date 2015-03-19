// FUNCIONES   -  AJAX
// _ - SIA
// ELABORADO POR: FRANZ JULIO CHURQUI AGUIRRE
// INICIALIZA EL HTTP AJAX
// PROBADO EN INTERNET EXPLORE AND MOZILLA FIREFOX

function AjaxHttp()
{
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
	xmlhttp = new XMLHttpRequest();	
          if (xmlhttp.overrideMimeType) {
             xmlhttp.overrideMimeType('text/text');
          }	
    }
    else if(window.ActiveXObject)
    {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;    
}


function verifica_materias()
{
    var elementos= document.getElementsByTagName("select");
    //alert(elementos.length);
    var aux=0;
    for (var i=0;i<=elementos.length-1;i++)
    {
	if (elementos[i].value!="nulo")    
	{
	    aux++;
	}
    }
    //alert(aux);
    var max_materias= document.getElementById("maximo_materias");
    var mivar = document.getElementById("maxiom");

    if(aux<=max_materias.value)
    {
	return true;
    }
    else
    {
	return false;
    }
}

// FUNCION CARGA LOS PARALELOS INTRODUCIENDO COMO PARAMETRO
// LA MATERIA

function cargarParalelo(id_materia,sigla,periodo)
{
	var elemento=document.getElementById(id_materia);
	if (elemento.length==1)
	{
	//setNotaTemporal.do?id_fasee="+cfase.value+"&paralelo_materia="+cmateria.value+"&id_evaluacion="+cevaluacion.value+"&nota="+cnota.value+"&id_estudiante="+regu+"&periodo="+cperiodo.value;
	var variable=id_materia+":"+sigla;    
	var url="getParalelosMateriaPorCursar.do?idMateria_Sigla="+variable;
        var http = AjaxHttp();
        http.open("POST",url,true);
        //alert("cargar paralelo");    
        http.onreadystatechange = function listarParalelos()
        {
    	    if (http.readyState == 4)
	    {
	        if (http.status == 200)
		{ 
		    var lista=http.responseXML.getElementsByTagName("dato");
		    for(var i=0;i<lista.length;i++)
		    {
			var xnodo=lista.item(i);
    			var idmateria_nodo=xnodo.getAttribute("id_materia");
			var id_nodo=xnodo.getAttribute("id_paralelo");    		    
			var paralelo_nodo=xnodo.getAttribute("paralelo");
			var cupo_nodo= xnodo.getAttribute("cupo_restante");   	
			var horas_nodo= xnodo.getAttribute("horario");   	
			var sigla_nodo=xnodo.getAttribute("sigla");
                        var periodo_nodo=xnodo.getAttribute("periodo");
			var opcion_nueva=document.createElement("option");
			opcion_nueva.value=idmateria_nodo+":"+id_nodo+":"+paralelo_nodo+":"+cupo_nodo+":"+sigla_nodo+":"+horas_nodo+":"+periodo_nodo;
			opcion_nueva.innerHTML=paralelo_nodo+"("+cupo_nodo+")";
			elemento.appendChild(opcion_nueva);
		    }
		}
	    }
	}
	http.send(null);
	}
}

// DESPLIEGA LAS MATERIAS QUE EL ESTUDIANTE PUEDE TOMAR

function cargarMaterias()
{

    var cadena1="";
    url="getMateriasPorCursar.do"
    var http = AjaxHttp();
    http.open("GET",url,true);
    http.onreadystatechange = function listarMaterias()
    {
	if (http.readyState == 4)
	{
	    if (http.status == 200)
	    { 
		    var lista=http.responseXML.getElementsByTagName("dato");
		    var cadena="";
		    for(var i=0;i<lista.length;i++)
		    {
			var xnodo=lista.item(i);
			var nombre_nodo=xnodo.getAttribute("nombre");
			if (nombre_nodo=="materiasPorCursar")
			{
			    var id_nodo=xnodo.getAttribute("id_materia");
			    var sigla_nodo=xnodo.getAttribute("sigla");
			    var materia_nodo=xnodo.getAttribute("materia");
			    var obs_nodo=xnodo.getAttribute("observaciones");
                            var periodo_nodo=xnodo.getAttribute("periodo");
			    var nivel_nodo=xnodo.getAttribute("nivel_academico");
			    
			    if (obs_nodo!=null || obs_nodo.trim()!="")
			    {
				cadena = cadena+"<tr class=colb align=center><td align=left class=colh>"+(i+1)+"</td><td id='tdperiodo"+periodo_nodo+"' align=center class=colb>"+periodo_nodo+"</td><td id='tdnivel"+id_nodo+"' align=center class=colb>"+nivel_nodo+"</td><td id='td"+id_nodo+"' align=left class=colb>["+sigla_nodo+"] - "+materia_nodo+"</td><td class=colb><select id='"+id_nodo+":"+periodo_nodo+"' name='materia_paralelo' onFocus=cargarParalelo('"+ id_nodo+":"+periodo_nodo+"','"+sigla_nodo+"','"+periodo_nodo+"'); onChange=horarioDib('"+id_nodo+":"+periodo_nodo+"','"+sigla_nodo+"');><option value='nulo'>Seleccione</option></select></td></tr>";			    
				//cadena = cadena+"<tr class=colb align=center><td align=left class=colh>"+(i+1)+"</td><td align=center class=colb>"+nivel_nodo+"</td><td align=left class=colb>["+sigla_nodo+"] - "+materia_nodo+"</td><td class=colb><select id="+id_nodo+" name='materia_paralelo' onFocus=cargarParalelo(); onChange=horarioDib('"+id_nodo+"');><option value='nulo'>Seleccione</option></select></td></tr>";			    
			    }
			    else
			    {
				cadena = cadena+"<tr class=colb align=center><td align=left class=colh>"+(i+1)+"</td><td id='tdperiodo"+periodo_nodo+"' align=center class=colb>"+periodo_nodo+"</td><td id='tdnivel"+id_nodo+"' align=center class=colb>"+nivel_nodo+"</td><td id='td"+id_nodo+"' align=left class=colb>["+sigla_nodo+"] - "+materia_nodo+"</td><td class=colb><select id='"+id_nodo+":"+periodo_nodo+"' name='materia_paralelo' onFocus=cargarParalelo('"+id_nodo+":"+periodo_nodo+"','"+sigla_nodo+"','"+periodo_nodo+"'); onChange=horarioDib('"+id_nodo+":"+periodo_nodo+"','"+sigla_nodo+"');><option value='nulo'>Seleccione</option></select></td></tr>";			    
				//cadena = cadena+"<tr class=colb align=center><td align=left class=colh>"+(i+1)+"</td><td align=center class=colb>"+nivel_nodo+"</td><td align=left class=colb>["+sigla_nodo+"] - "+materia_nodo+" <font color=blue>("+obs_nodo+")</font></td><td class=colb><select id="+id_nodo+" name='materia_paralelo' onFocus=cargarParalelo(); onChange=horarioDib('"+id_nodo+"');><option value='nulo'>Seleccione</option></select></td></tr>";
			    }
                            
			}
			
			else
    			{
                           
			    if (nombre_nodo=="intervalos")
			    {
				var datos_nodo=xnodo.getAttribute("datos");
				cadena1=cadena1+"<input  type='text'  id='horarios'  value='"+datos_nodo+"'/>";
			    }
			    else 
			    {
				if (nombre_nodo=="maximoMaterias")
				{
				    var max = xnodo.getAttribute("dato");
				    cadena1=cadena1+"<input  type='text'  id='maximo_materias'  value='"+max+"'/>";
				}
				else
				{
				    var dias = xnodo.getAttribute("dato");
				    cadena1=cadena1+"<input  type='text'   id='dias'  value='"+dias+"'/>";
				}
			    }
			}
			var auxelement=document.getElementById('varGlobales');
			auxelement.innerHTML=cadena1;
		    }
		    var listaMaterias=document.getElementById('listaMaterias');
		    listaMaterias.innerHTML="<table id='tablaInscripcion' align=center width=600>"+
		    "<tr class=colh align=center><td>Nro.<td>Periodo<td>Nivel<td>Sigla - Materia<td>Paralelo (Cupo)</tr>"+cadena+"</a></table>";
		    var hrs=document.getElementById("horarios");
		    var dia =document.getElementById("dias");
		    cargarHorario(hrs.value,dia.value);
	    }
	}
    }
    
    http.send(null);

}
function llenar_filas()
{
    var horario = document.getElementById("tablaHorario").getElementsByTagName("tbody")[0];    
    var filas = horario.getElementsByTagName("tr");
    for (var i=2;i<=filas.length-1;i++)
    {
	if(horario.getElementsByTagName("tr").item(i).style.display=="none")
	{
            //alert(horario.getElementsByTagName("tr").item(i).style.display="");
            horario.getElementsByTagName("tr").item(i).style.display="";
	}
    }
}

function limpiar_filas()
{
    var horario = document.getElementById("tablaHorario").getElementsByTagName("tbody")[0];    
    var filas = horario.getElementsByTagName("tr");
    for (var i=2;i<=filas.length-1;i++)
    {
	var sw=0;
	var celdas=filas[i].getElementsByTagName("td");
	for (var j=1;j<=celdas.length-1;j++)
	{
	    var aux=celdas[j].childNodes;
	    if (celdas[j].hasChildNodes())
	    {
		  sw=1;	    
	    }
	}
	if (sw==0)
	{
	    horario.getElementsByTagName("tr").item(i).style.display="none";
	}
    }
}


/* DIBUJO DE TABLA DE HORARIO */
function cargarHorario(datos,dias)
{
    var diaSemana= new Array('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES','SABADO','DOMINGO');
    var cadena="";
    var horario=document.getElementById("cargaHorarios");	
    cadena="<table id='tablaHorario' align='center' width=80%><tr><td class=colh colspan="+(dias+1)+" align=center> HORARIO DEL ESTUDIANTE </td></tr>";		
    var intervalo=datos.split(",");
    for (var i=0;i<=intervalo.length-1;i=i+2)
    {
    	    cadena=cadena+"<tr>";
    	    for(var j=0;j<=dias;j++)
    	    {
		if (i==0)
		{
		    if (j==0)
		    {
			cadena=cadena+"<td class='colh' align=center width=70>HORAS</td>";
		    }
		    else
		    {
			cadena=cadena+"<td class='colh' align=center>"+diaSemana[j-1]+"</td>";
		    }
		}
		else
		{
            if (j==0)
		    {
			//alert(intervalo[i-2]+"  "+intervalo[i-1]);
			cadena=cadena + "<td class='colh' align=center width=70>"+ceros_horario(intervalo[i-2])+"-"+ceros_horario(intervalo[i-1])+"</td>";
		    }
		    else
		    {
			cadena=cadena+"<td class='colb' align=center></td>";
		    }
		}
    	    }
	    cadena=cadena+"</tr>";
    }
    cadena="<br><br>"+cadena+"</table>"+"<table align=center></table>"
    horario.innerHTML=cadena;
}

function ceros_horario(intervalo_i)
{
    var t=intervalo_i.split(":");
    var mRes =t[0];
    var sRes  =t[1];
    var horas,minutos;
    sRes.toString().length < 2 ? minutos="0" + sRes : minutos = sRes;
    mRes.toString().length < 2 ? horas="0" + mRes : horas = mRes;
    intervalo_i = String(horas) + ":" + String(minutos);
    return intervalo_i;
}

function horarioDib(id_select,sigla)
{

/*
    auxiliar[0] --> id_materia
    auxiliar[1] --> id_nodo
    auxiliar[2] --> paralelo_nodo	
    auxiliar[3] --> cupo_nodo
    auxiliar[4] --> sigla
    auxiliar[5] --> horas_nodo
    horas='0,0|0,1|5,2|5,3'
*/    
    llenar_filas();

    var verifica=verifica_materias();
    if (verifica)
    {
	var elemento =document.getElementById(id_select);
	var valor    = elemento.options[elemento.selectedIndex].value;
	deshabilita(id_select,sigla,valor);
	if (valor!="nulo")
	{
        var auxiliar =valor.split(":");
	    var cord = auxiliar[5].split("|");
	    //alert(cord.length);
	    buscaMateria(auxiliar[4]);
	    for (var i=0;i<=cord.length-1;i++)
	    {
	    var pos = cord[i].split(",");
		var px  = pos[0];//representta filas
		var py  = pos[1];//respresenta columnas
		estableceHorario(Number(px)+2,Number(py)+1,auxiliar[4],auxiliar[2]);
	    }
	}
	else
	{
	    buscaMateria(sigla);
	}
        
    }
    else
    {
	var auxelemento=document.getElementById(id_select);
	auxelemento.selectedIndex=0;
	alert("Error!!!! \n\t No puede inscribirse en mas materias.\n\t Usted alcanzo el limite de materias permitidas.....");
    }
}

function deshabilita(aux1,aux2,val)
{
    var vect1=aux1.split(":");
    var elementos= document.getElementsByTagName("select");
    var aux=0;
    for (var i=0;i<=elementos.length-1;i++)
    {
	var vect0=elementos[i].id.split(":");
	if (vect0[0]==vect1[0])
	{
	    if (aux1!=elementos[i].id)
	    {
		if (val!="nulo")
		{
		    elementos[i].disabled=true;
		}
		else
		{
		    elementos[i].disabled=false;
		}
	    }
	}

    }
}

function estableceHorario(x,y,sigla,paralelo)
{
    var tabla=document.getElementById("tablaHorario");        
    var filas=tabla.getElementsByTagName("tr");
    var celdas=filas[x].getElementsByTagName("td");
    if (celdas[y].hasChildNodes() == false)
        {
	       celdas[y].className="col_s";    
	       celdas[y].innerHTML=sigla+" ("+paralelo+")";
        }
        else
        {
           var auxiliar= celdas[y].firstChild.nodeValue;
           var franz =celdas[y].childNodes;
           var i=0;
          
           var cadenaux="";
//         alert(franz.length);
           while(i<franz.length)
            {
               cadenaux=cadenaux+franz[i].nodeValue+"<br>";
     //        alert(i + "----> " + cadenaux);
                i=i+2;
            }
    //      alert(cadenaux+sigla+" ("+paralelo+")");
            celdas[y].innerHTML=cadenaux+sigla+" ("+paralelo+")";
            celdas[y].className="col_s";
       }
 }


function buscaMateria(sigla)
{
    var tablaMat=document.getElementById("tablaHorario");
    var filas1= tablaMat.getElementsByTagName("tr");    
    for (var i=2;i<=filas1.length-1;i++)
    {
    var celdas1 = filas1[i].getElementsByTagName("td");
	for(var j=1;j<=celdas1.length-1;j++)
	{	
	    var sw=0;
   
	    //var celdaValor=celdas1[j].firstChild.nodeValue;
	    if (celdas1[j].hasChildNodes()==true)
	    {
	      var varAux=celdas1[j].childNodes;
		  var k=0;
		  var cadena="";
		  while (k<varAux.length)
          {
            if (varAux[k].nodeValue!=null)
		    {
	       	     var mat=varAux[k].nodeValue.split(" ");
                 if (mat[0]!=sigla)
			     {
			         cadena=cadena+varAux[k].nodeValue+"<br>";  
                     sw=1;
			     }
                 else
                 {
			         if (varAux.length==1)
			         {
			            celdas1[j].className="colb";
	    			    celdas1[j].innerHTML="";
			         }
                 }
		    }
		    k=k+2;
		  }
		  if (sw==1 || cadena=="")
		  {
                celdas1[j].className="col_s";
	    	celdas1[j].innerHTML=cadena;
          }
	    }
	   }
    }
    return;   
}

function dibConfirmarInscripcion()
{
    var cadena= "<table id='tablaConfirmar' align='center' width=500><tr><td class=colh colspan='6' align=center> MATERIAS SELECCIONADAS  </td></tr>"+
		"<tr><td class=colh align=center width=25> Nro. </td><td class=colh align=center width=25>Periodo</td><td class=colh align=center width=25> Nivel </td><td class=colh align=center width=100> Sigla  </td><td class=colh align=center width=300> Materia </td><td class=colh align=center width=50> Paralelo </td></tr>";
    var elementoSelect=document.getElementsByTagName("select");
    var j=0;
    var cadena2="";
    var x="";
    var y="";
    for (var i=0;i<=elementoSelect.length-1;i++)
    {
	if (elementoSelect[i].value!="nulo")	
	{	
	    j=j+1;

	    var aux=elementoSelect[i].value.split(":");

	    var valorSelect = elementoSelect[i].options[elementoSelect[i].selectedIndex].text;
	    var auxiliar=valorSelect.split("(");
	    
	    var auxNivel="tdnivel"+aux[0];
	    var elementotd0=document.getElementById(auxNivel);
	    var celdaNivel=elementotd0.childNodes;

	    var auxNombre="td"+aux[0];
	    var elementotd=document.getElementById(auxNombre);
	    var celda=elementotd.childNodes;
	    var materia =  celda[0].nodeValue.split("-");
            var vectorPeriodo=elementoSelect[i].id.split(":");
            var periodo=vectorPeriodo[1];
	    if (j%2==0)
	    {
		cadena2=cadena2+"<tr align=center class=col_2><td align=center class=colh width=25>"+j+"</td><td align=center class=col_2 width=25>"+periodo+"</td><td align=center class=col_2 width=25>"+celdaNivel[0].nodeValue+"</td><td align=center class=col_2 width=150>"+materia[0]+"</td><td align=center class=col_2 width=300>"+materia[1]+"</td><td align=center class=col_2 width=100>"+auxiliar[0]+"</td></tr>";
	    }
	    else
	    {
		cadena2=cadena2+"<tr align=center class=col_1><td align=center class=colh width=25>"+j+"</td><td align=center class=col_1 width=25>"+periodo+"</td><td align=center class=col_1 width=25>"+celdaNivel[0].nodeValue+"</td><td align=center class=col_1 width=150>"+materia[0]+"</td><td align=center class=col_1 width=300>"+materia[1]+"</td><td align=center class=col_1 width=100>"+auxiliar[0]+"</td></tr>";	    
	    }
	    x=x+elementoSelect[i].id +":"+aux[1]+",";
	    y=y+materia[0]+":"+materia[1]+":"+auxiliar[0]+":"+elementoSelect[i].id +",";
	}
    }   

    var auxelement1=document.getElementById('cargaHorarios'); 

    if(auxelement1.childNodes.length>=2)
    {
	auxelement1.removeChild(document.getElementById('cargaHorarios').firstChild);
	auxelement1.removeChild(document.getElementById('cargaHorarios').firstChild);
    }
    
    //auxelement1.removeChild(document.getElementById('inputVar').firstChild);
	if (j<=0)
	{
	    auxelement1.innerHTML=cadena+cadena2+"<tr><td class=colh colspan='6' align=center> <input type=submit value='  Confirmar  ' disabled='true'></input></td></tr></table>"+"<br>"+auxelement1.innerHTML+"</form>";
	}
	else
	{
	    //auxelement1.innerHTML=cadena+cadena2+"<tr><td class=colh colspan='5' align=center> <input type='submit' value='  Confirmar  '/></td></tr></table>"+"<br>"+auxelement1.innerHTML+"<input type=text name='materias_seleccionadas' value='"+x+"'><br><input type=text name='materias_seleccionadas2' value='"+y+"'><form>";
    	    auxelement1.innerHTML=cadena+cadena2+"<tr><td class=colh colspan='6' align=center> <input type='submit' value='  Confirmar  '/></td></tr></table>"+"<br>"+auxelement1.innerHTML
	    
	    var auxiliarHidden = document.getElementsByTagName("input");
	    if (auxiliarHidden.length<=4)
	    {
		auxelement1.innerHTML=auxelement1.innerHTML+"<input id='inputVar1' type=hidden name='materias_seleccionadas' value='"+x+"'><br><input id='inputVar2' type='hidden' name='materias_seleccionadas2' value='"+y+"'>";
	    }
	    else
	    {
		var auxe1=document.getElementById("inputVar1");
		var auxe2=document.getElementById("inputVar2");
		auxe1.value=x;
		auxe2.value=y;
	    }
	}
    limpiar_filas();
}

function cuentaAtras()
{
if(segundos > 0){
   segundos--
  }
  else{
	 if(minutos > 0){
	     segundos = 59;
	     minutos--
	   }
	  else{
	        if(horas > 0){
	          minutos = 59;
	          horas--
	        }
	   }
  }
  ceros();
  document.getElementById("reloj").innerHTML = "<table><tr><td class='colh'>TIEMPO RESTANTE: "+ horas2 + ":" + minutos2 + ":" + segundos2+"</td></tr></table>";
   if(horas > 0 || minutos > 0 || segundos > 0){
        tiempo = setTimeout('cuentaAtras()',1000)
   }
}


function ceros()
{
       segundos.toString().length < 2 ? segundos2="0" + segundos : segundos2 = segundos
       minutos.toString().length < 2 ? minutos2="0" + minutos : minutos2 = minutos
       horas.toString().length < 2 ? horas2="0" + horas : horas2 = horas
}

function escribe()
{
   ceros()
   element=document.getElementById("reloj");
   element.innerHTML= "<table><tr><td class='colh'>TIEMPO RESTANTE: "+ horas +":" + minutos + ":" + segundos + "</td></tr></table>" ;
}


/* FUNCIONES XCLIENT PARA MOVER LA CABECERA...*/


var xOp7Up,xOp6Dn,xIE4Up,xIE4,xIE5,xNN4,xUA=navigator.userAgent.toLowerCase();if(window.opera){var i=xUA.indexOf('opera');if(i!=-1){var v=parseInt(xUA.charAt(i+6));xOp7Up=v>=7;xOp6Dn=v<7;}}else if(navigator.vendor!='KDE' && document.all && xUA.indexOf('msie')!=-1){xIE4Up=parseFloat(navigator.appVersion)>=4;xIE4=xUA.indexOf('msie 4')!=-1;xIE5=xUA.indexOf('msie 5')!=-1;}else if(document.layers){xNN4=true;}xMac=xUA.indexOf('mac')!=-1;
function xDef(){for(var i=0; i<arguments.length; ++i){if(typeof(arguments[i])=='undefined') return false;}return true;}
function xGetElementById(e){if(typeof(e)=='string') {if(document.getElementById) e=document.getElementById(e);else if(document.all) e=document.all[e];else e=null;}return e;}
function xLeft(e, iX){if(!(e=xGetElementById(e))) return 0;var css=xDef(e.style);if (css && xStr(e.style.left)) {if(xNum(iX)) e.style.left=iX+'px';else {iX=parseInt(e.style.left);if(isNaN(iX)) iX=0;}}else if(css && xDef(e.style.pixelLeft)) {if(xNum(iX)) e.style.pixelLeft=iX;else iX=e.style.pixelLeft;}return iX;}
function xMoveTo(e,x,y){xLeft(e,x);xTop(e,y);}
function xNum(){for(var i=0; i<arguments.length; ++i){if(isNaN(arguments[i]) || typeof(arguments[i])!='number') return false;}return true;}
function xScrollTop(e, bWin){var offset=0;if (!xDef(e) || bWin || e == document || e.tagName.toLowerCase() == 'html' || e.tagName.toLowerCase() == 'body') {var w = window;if (bWin && e) w = e;if(w.document.documentElement && w.document.documentElement.scrollTop) offset=w.document.documentElement.scrollTop;else if(w.document.body && xDef(w.document.body.scrollTop)) offset=w.document.body.scrollTop;}else {e = xGetElementById(e);if (e && xNum(e.scrollTop)) offset = e.scrollTop;}return offset;}
function xStr(s){for(var i=0; i<arguments.length; ++i){if(typeof(arguments[i])!='string') return false;}return true;}
function xTop(e, iY){if(!(e=xGetElementById(e))) return 0;var css=xDef(e.style);if(css && xStr(e.style.top)) {if(xNum(iY)) e.style.top=iY+'px';else {iY=parseInt(e.style.top);if(isNaN(iY)) iY=0;}}else if(css && xDef(e.style.pixelTop)) {if(xNum(iY)) e.style.pixelTop=iY;else iY=e.style.pixelTop;}return iY;}

function getElementPosition(object)
{
    var position = new Object;
    position.left = parseInt(document.getElementById(object).style.marginLeft)
    position.top = parseInt(document.getElementById(object).style.marginTop)
    return position;
}

function change(x,item)
{
	if(x==750)
	{	
	    dibConfirmarInscripcion();
	}


	document.getElementById("current").id = "";
	item.id = "current";
	if((x * (-1))<(getElementPosition("elementos").left - 10)){
		distance = (x + getElementPosition("elementos").left) / 5;
		start = getElementPosition("elementos").left;
		for(i=0; i<=distance; i=i+1){
			setTimeout("document.getElementById(\"elementos\").style.margin = \"0 -" + ((start * (-1)) + (i*5)) + "px\"", i*5);
			if(i==distance){
				setTimeout("document.getElementById(\"elementos\").style.margin = \"0 -" + x + "px\"", i*5);
			}
		}
	}else if((x * (-1))>(getElementPosition("elementos").left)){ 
		distance = ((x + getElementPosition("elementos").left) / 5)  * (-1);
		start = getElementPosition("elementos").left;		
		for(i=0; i<=distance; i=i+1)
		{
			//alert(i);
			setTimeout("document.getElementById(\"elementos\").style.margin = \"0 -" + ((start * (-1)) - (i*5)) + "px\"", i*5);
			if(i==distance)
				setTimeout("document.getElementById(\"elementos\").style.margin = \"0 -" + x + "px\"", i*5);
		}
	}
}
