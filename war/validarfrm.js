//FUNCION QUE CONTROLA QUE SOLO SEAN LETRAS LOS INGRESOS
var nav4 = window.Event ? true : false;
function solo_letras(evt)
{

    var key = nav4 ? evt.which : evt.keyCode;
    return (key <= 13 || (key >= 97 && key <= 122) || (key >= 65 && key <= 90));

}


//controla que funcione los numeros menos el 0  disenana para el dia y mes
function solo_numeros(evt)
{
    // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
    var key = nav4 ? evt.which : evt.keyCode;
    return (key <= 13 || (key >= 49 && key <= 57));
}
//controla que funcione los numeros[0123456789] disenana para el anyo
function solo_numeros_0(evt)
{
    // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
    var key = nav4 ? evt.which : evt.keyCode;
    return (key <= 13 || (key >= 48 && key <= 57));
}
function val_ci(evt)
{
    // NOTA: ESPACIO= 8, Enter = 13, '0' = 48, '9' = 57
    var key = nav4 ? evt.which : evt.keyCode;
    return (key <= 13 || (key >= 48 && key <= 57) || (key == 45));
}
OCULTO = "none";
VISIBLE = "inline";

function mostrarErr(blo) {
    document.getElementById(blo).style.display = VISIBLE;
//  document.getElementById('ver_off').style.display=VISIBLE;
//  document.getElementById('ver_on').style.display=OCULTO;
}

function ocultarErr(blo) {
    document.getElementById(blo).style.display = OCULTO;
//  document.getElementById('ver_off').style.display=OCULTO;
//  document.getElementById('ver_on').style.display=VISIBLE;
}

function ambos(e)
{
    if (navigator.appName == 'Netscape' && (e.which == 1 || e.which == 3 || e.which == 2))
    {
        return false;
    }

    else if (navigator.appName == 'Microsoft Internet Explorer' && (event.button == 1 || event.button == 2))
    {
    }
}


var a, mes, dia, anyo, febrero;

function anyoBisiesto(anyo)
{
    /**
     * si el año introducido es de dos cifras lo pasamos al periodo de 1900. Ejemplo: 25 > 1925
     */
    if (anyo < 100)
        var fin = 19 + anyo;
    //var fin = anyo + 1900;
    else
        var fin = anyo;
    /*
     * primera condicion: si el resto de dividir el año entre 4 no es cero > el año no es bisiesto
     * es decir, obtenemos año modulo 4, teniendo que cumplirse anyo mod(4)=0 para bisiesto
     */
    // alert(fin);

    if (fin % 4 != 0)
        return false;
    else
    {
        if (fin % 100 == 0)
        {
            if (fin % 400 == 0)
            {
                return true;

            }
            else
            {
                return false;

            }
        }

        /**
         * si es divisible por 4 y no es divisible por 100 > el año es bisiesto
         */

        else
        {
            return true;
        }
    }
}


function vacio(q) {
    for (i = 0; i < q.length; i++)
    {
        if (q.charAt(i) != " ") {
            return false
        }
    }
    return true
}

function validarfechan()
{
//  alert("hola ahi vamos...")
    //document.onmousedown=ambos
    var dia = document.getElementById("nac_dia").value;
    var mes = document.getElementById("nac_mes").value;
    var anyo = document.getElementById("nac_anio").value;

//	  alert("hola ahi vamos..."+dia+" "+mes+" "+anyo);
    if (vacio(dia) && vacio(mes) && vacio(anyo))
    { //  document.onmousedown=true;
        document.getElementById('error4n').style.display = 'none';
        return;
    }
    if (!vacio(anyo))
    {

        if ((anyo < 1990) || (anyo > 2050))
        {

            //document.getElementById(diax).focus();
            document.getElementById('error4n').style.display = 'inline';  //mostrarErr("error4n");


            //alert("error 4");

            return;

        }
    }

    if (anyoBisiesto(anyo))
        febrero = 29;
    else
        febrero = 28;

    if (!vacio(mes))
    {
        if ((mes < 1) || (mes > 12))
        {


            //document.getElementById(mesx).focus();
            document.getElementById('error4n').style.display = 'inline';
            //mostrarErr("error4n");
            //return;

        }
    }
    if ((mes == 2) && ((dia < 0) || (dia > febrero)))
    {
        //document.getElementById(diax).focus();
        document.getElementById('error4n').style.display = 'inline';
        return;
    }
    /**
     * si el mes introducido es de 31 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
     */
    if (((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) && ((dia <= 0) || (dia > 31)))
    {
        if (!vacio(dia)) {
            document.getElementById('error4n').style.display = 'inline';
            return;
        }
    }
    /**
     * si el mes introducido es de 30 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
     */
    if (((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && ((dia < 0) || (dia > 30)))
    {
        //    document.getElementById(diax).focus();
        //    mostrarErr("error4n");
        document.getElementById('error4n').style.display = 'inline';
        return;
    }
    if (!vacio(mes) && (dia < 1) || (dia > 30))
    {
        //    document.getElementById(diax).focus();
        //    mostrarErr("error4n");return;
        document.getElementById('error4n').style.display = 'inline';
    }

    document.getElementById('error4n').style.display = 'none';

    return;
    //document.onmousedown=true
}


function validarfechac()
{
    //document.onmousedown=ambos

    dia = document.getElementById(crt_dia).value
    mes = document.getElementById(crt_mes).value
    anyo = document.getElementById(crt_anyo).value



    if (vacio(dia) && vacio(mes) && vacio(anyo))
    { //  document.onmousedown=true;
        return;
    }
    if (!vacio(anyo))
    {

        if ((anyo < 1990) || (anyo > 3000))
        {

            //document.getElementById(diax).focus();
            //mostrarErr("error4c");
            document.getElementById('error4c').style.display = 'inline'
            return;

        }
    }

    if (anyoBisiesto(anyo))
        febrero = 29;
    else
        febrero = 28;


    if ((mes < 0) || (mes > 12))
    {
        if (!vacio(mes))
        {
            //document.getElementById(mesx).focus();
//	       	mostrarErr("error4c");
            document.getElementById('error4c').style.display = 'inline'

            return;
        }
    }

    if ((mes == 2) && ((dia < 0) || (dia > febrero)))
    {
        //document.getElementById(diax).focus();
        //mostrarErr("error4c");
        document.getElementById('error4c').style.display = 'inline'

        return;
    }
    /**
     * si el mes introducido es de 31 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
     */
    if (((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) && ((dia <= 0) || (dia > 31)))
    {
        if (!vacio(dia)) {
            //document.getElementById(diax).focus()
            // mostrarErr("error4c");}
            document.getElementById('error4c').style.display = 'inline'

            return;
        }
        /**
         * si el mes introducido es de 30 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
         */
        if (((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && ((dia < 0) || (dia > 30)))
        {
            //    document.getElementById(diax).focus();
            //    mostrarErr("error4c");
            document.getElementById('error4c').style.display = 'inline'

            return;
        }
        if (!vacio(mes) && (dia < 0) || (dia > 30))
        {
            //    document.getElementById(diax).focus();
            //    mostrarErr("error4c");return;
            document.getElementById('error4c').style.display = 'inline'

        }
        //document.onmousedown=true
    }
}




function validarfechaco()
{
    //document.onmousedown=ambos
    dia = document.getElementById(cony_dia).value
    mes = document.getElementById(cony_mes).value
    anyo = document.getElementById(cony_anyo).value

    if (vacio(dia) && vacio(mes) && vacio(anyo))
    { //  document.onmousedown=true;
        return;
    }
    if (!vacio(anyo))
    {

        if ((anyo < 1990) || (anyo > 3000))
        {

            //document.getElementById(diax).focus();
//		mostrarErr("error4co");
            document.getElementById('error4co').style.display = 'inline'

            return;

        }
    }

    if (anyoBisiesto(anyo))
        febrero = 29;
    else
        febrero = 28;

    if ((mes < 0) || (mes > 12))
    {
        if (!vacio(mes))
        {
            //document.getElementById(mesx).focus();
            // 	mostrarErr("error3co");
            document.getElementById('error4co').style.display = 'inline'
            return;
        }
    }

    if ((mes == 2) && ((dia < 0) || (dia > febrero)))
    {
        //document.getElementById(diax).focus();
        //mostrarErr("error2co");
        document.getElementById('error4co').style.display = 'inline'
        return;
    }
    /**
     * si el mes introducido es de 31 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
     */
    if (((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) && ((dia <= 0) || (dia > 31)))
    {
        if (!vacio(dia)) {
            //document.getElementById(diax).focus()
            // mostrarErr("error2co");}
            document.getElementById('error4co').style.display = 'inline'
            return;
        }
        /**
         * si el mes introducido es de 30 dias y el dia introducido es mayor de 31 > alertamos y detenemos ejecucion
         */
        if (((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && ((dia < 0) || (dia > 30)))
        {
            //    document.getElementById(diax).focus();
            //    mostrarErr("error2co");
            document.getElementById('error4co').style.display = 'inline'
            return;
        }
        if (!vacio(mes) && (dia < 0) || (dia > 30))
        {
            //    document.getElementById(diax).focus();
            //    mostrarErr("error2co");return;
            document.getElementById('error4co').style.display = 'inline'
            return;
        }
        //document.onmousedown=true
    }
}