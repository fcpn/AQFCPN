<%@ include file="Cabecera.jsp" %>

<c:if test="${visita == 'Si'}">
    <SCRIPT language=JavaScript>
        <!-- Begin
        // Set slideShowSpeed (milliseconds)
        var slideShowSpeed = 4000;
        // Duration of crossfade (seconds)
        var crossFadeDuration = 10;
        // Specify the image files
        var Pic = new Array();
        // to add more images, just continue
        // the pattern, adding to the array below

        Pic[0] = './1.png'
        Pic[1] = './2.png'
        /*Pic[2] = './3.png'
Pic[3] = './4.png'
Pic[4] = './5.png'*/

        // do not edit anything below this line
        var t;
        var j = 0;
        var p = Pic.length;
        var preLoad = new Array();
        for (i = 0; i < p; i++) {
            preLoad[i] = new Image();
            preLoad[i].src = Pic[i];
        }
        function runSlideShow() {
            if (document.all) {
                document.images.SlideShow.style.filter="blendTrans(duration=10)";
                document.images.SlideShow.style.filter="blendTrans(duration=crossFadeDuration)";
                document.images.SlideShow.filters.blendTrans.Apply();
            }
            document.images.SlideShow.src = preLoad[j].src;
            if (document.all) {
                document.images.SlideShow.filters.blendTrans.Play();
            }
            j = j + 1;
            if (j > (p - 1)) j = 0;
            t = setTimeout('runSlideShow()', slideShowSpeed);
        }
        //  End -->
    </SCRIPT>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" style="">
        <tr>
            <td align="center" class="colh" style="padding-top:2px; padding-bottom:2px"><font size="3">"FACULTAD DE CIENCIAS PURAS Y NATURALES" (2015)</font></td>
        </tr>
    </table>  

    <table style="background-color:#D9E6E9" width="100%">
        <td>       
            <table>
                <tr>
                    <td>        
                        <span class="normal" align="center"><b>"FACULTAD DE CIENCIAS PURAS Y NATURALES" (2015)</b></span>
                    </td>
                </tr>
                <tr><td><img src="./images/java.jpg" width="80%" border="1">

                    </td></tr>
                <tr>
                    <td>
                        <!---->
                        <span class="normal"><b>REQUERIMIENTOS MINIMOS DEL SISTEMA</b><br>
                            <li>Windows XP o superior. Linux Kernel 2.4.x</li>
                            <li>Mozilla Firefox</li>
                            <li>Adobe Acrobat Reader 6.0 en Windows o Linux.</li>
                            <li>Resoluci&oacute;n de pantalla 1024x768 pixeles</li>
                        </span>
                    </td>
                </tr>
            </table>
        </td>
        <td>
            <table width="70%" border="0" cellspacing="1" cellpadding="0" align="right" style="">  
                <tr>
                    <td style="background-color:#000000; padding-top:5px; padding-bottom:5px; padding-left:50px; padding-right:50px">
                        <IMG src=""  name="SlideShow"> 
                        <script>runSlideShow();</script>
                    <td> 
                </tr>
            </table>
        </td>
    </table>
    <!--<MARQUEE bgcolor = "#FFFFFF" width = 50% scrolldelay = 0> Msc. Franz Cuevaz Quiroz Director General Del Proyecto </MARQUEE> -->
</c:if>