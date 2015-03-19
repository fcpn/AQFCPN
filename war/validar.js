    // JAVASCRIPT PROBADO EN IE -Internet Explorer 5
    //			     MOZILLA 1
    //			     KONQUEROR 3.0.4

    // funcion que coloca el cursor en un objeto deseado
    function inicio(obj) {
	obj.focus();
    }

    function seleccion(obj) {
	obj.select();
    }
    
    // funcion que valida un tado cualquiera
    // tipo   =  "9" numerico	 "A" alfabetico	 "A9" alfanumerico
    function validar(obj, tipo) {
	dato = obj.value;
	cad = dato.split("");
	if (obj.value == "") {
	    return false;
	}
	else {
	    switch (tipo) {
		case '9' : 
			for (i=0; i < cad.length; i++) {
			    if ((cad[i] > '9')||(cad[i] < '0')||(cad[i]==".")) {
				alert("el dato : '"+dato+"'  no es un número valido");
			        obj.focus();
			        obj.select();
			        return false;
			    }
			} 
			break;
		case 'A' : 
			for (i=0; i < cad.length; i++) {
	    		    if (!((cad[i] == ' ')||((cad[i] >= 'a')&&(cad[i] <= 'z'))||((cad[i]  >= 'A')&&(cad[i] <= 'Z'))||(cad[i]=='.') )) {
			        alert("el dato : '"+dato+"'  no es parte del alfabeto valido");
			        obj.focus();
			        obj.select();
			        return false;
			    }
			} 
			break;
		case 'A9': 
			for (i=0; i<cad.length; i++) {
    			    if (!((cad[i] == '%') ||(cad[i] == '-')||(cad[i] == ' ')||((cad[i]>='0')&&(cad[i]<='9'))||((cad[i]>='a')&&(cad[i]<='z'))||((cad[i]>='A')&&(cad[i]<='Z')) )) {
			        alert("el dato : '"+dato+"'  contiene caracteres especiales no validos");
			        obj.focus();
			        obj.select();
			        return false;
			    }
			} 
			break;
	    }
	}
	return true;
    }

    // funcion que valida un conjunto de datos del mismo tipo
    // forma	(formulario a validar)
    // inicio	(numerico primer elemento a validar)
    // cant	(numerico cantidad de elementos a validar)
    function validarVacio(forma, inicio, cant) {
	for (j=inicio; j<inicio+cant; j++) {
	    res = forma.elements[j];
	    if (res.value == "") {
		alert("Todos los campos deben tener valores");
	        return false;
	        break;
	    }
	}
	return true;
    }

    // funcion que valida un conjunto de datos segun el nombre del objeto
    // forma	(formulario a validar)
    // inicio	(numerico primer elemento a validar)
    // cant	(numerico cantidad de elementos a validar)
    function validarTodo(forma, inicio, cant) {
	for (j=inicio; j<inicio+cant; j++) {
	    res = forma.elements[j];
	    cad = res.name;
	    if ((res.value == "")||((cad.lastIndexOf("cad") == 0)&&((!(validar(res,"A"))) == true))) {
		return true;
		break;
	    }
	    if ((res.value == "")||((cad.lastIndexOf("int") == 0)&&((!(validar(res,"9"))) == true))) {
		return true;
		break;
	    }
	}
	return true;
    }
	    
    // funcion que valida un conjunto de datos numericos entre un rango
    // ri,rs	(numerico rango inferior superior)
    function validarNota(obj,ri,rs) {
	if(obj.value == ""){
	    alert("Por favor introduzca las Notas requeridaa en las cajas de texto.");
	    obj.focus();
	    obj.select();
	    return false;
	}

	res = validar(obj,"9");
	if (res == true) {
	    valor=parseInt(obj.value);
	    if ((valor<ri) || (valor>rs)) {
		alert("el número : "+obj.value+" fuera de rango, debe estar entre : "+ri+" y "+rs);
		obj.focus();
		obj.select();
		return false;
            }
	}
	return true;   
    }
    
    function validarAnio(obj,ri,rs) {
	if(obj.value == ""){
	    alert("Por favor introduzca el AÃ±o requerido en las caja de texto.");
	    obj.focus();
	    obj.select();
	    return false;
	}

	res = validar(obj,"9");
	if (res == true) {
	    valor=parseInt(obj.value);
	    if ((valor<ri) || (valor>rs)) {
		alert("el número : "+obj.value+" fuera de rango, debe estar entre : "+ri+" y "+rs);
		obj.focus();
		obj.select();
		return false;
            }
	}
	return true;   
    }
    
    function ventana(direccion, nombre, ancho, largo) {
	window.open(direccion, nombre, "width ="+ ancho +", height="+ largo +", scrollbars=yes, menubar=no, toolbar=no, resizable=yes");
    }

///jjj
// Funcion par validar un campo vacio  
//busca caracteres que no sean espacio en blanco en una cadena

/*function vacio(q) {
        for ( i = 0; i < q.length; i++ ) {
	    if ( q.charAt(i) != " " ) {
	       return true
	                }
	}
	alert("El campo no Debe estar Vacio!!!");
	return false
 }*/
 
    function vacio(obj) {
     cadena = obj.value;
     if(cadena.length==0){
	obj.focus();
	obj.select();
	return false;
     }else{
       for(i=0;cadena.length>i;i++)
       {
         if(cadena.charAt(i)!=" "){
	   return true;
	 }
       }
	obj.focus();
	obj.select();
	return false;
     }
    }
  
