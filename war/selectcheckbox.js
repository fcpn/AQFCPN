 
function seleccionar_todo()  
 {//Funcion que permite seleccionar todos los checkbox  
   
 form = document.forms["nombre_form"]  
 for (i=0;i<form.elements.length;i++)  
     {  
     if(form.elements[i].type == "checkbox")form.elements[i].checked=1;  
     }  
 }   
   
 function deseleccionar_todo()  
 {//Funcion que permite deseleccionar todos los checkbox  
   
 form = document.forms["nombre_form"]  
 for (i=0;i<form.elements.length;i++)  
     {  
     if(form.elements[i].type == "checkbox")form.elements[i].checked=0;  
     }  
 }
 /*
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
  */
