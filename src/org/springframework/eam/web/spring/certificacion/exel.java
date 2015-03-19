package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jxl.Workbook;
import jxl.write.*;
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import jxl.write.Number;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.classcertificacion;

public class exel implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String codtar = request.getParameter("codtar");
        modelo.put("codtar", codtar);


        String fechaan = request.getParameter("fecha");

        String num_sol = request.getParameter("num_sol");
        modelo.put("coo", num_sol);

        String i_e = "3";

        // String responsable=request.getParameter("responsable");

        String MN[][] = new String[3][3];
        MN[0][0] = null;
        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

        DecimalFormat df2 = new DecimalFormat("###,###,###,##0.00");

        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar taree = new ProActTar();
        taree.setCodtar(codtar);
        orm.ejecutarObjeto("gral", "selec", taree, taree);
        modelo.put("actividad", taree);
        String codacti = taree.getCodacti();
        /*FIN FIN FIN FIN */
        /*Sacando la tarea*/
        ProActTar tarw = new ProActTar();
        tarw.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codtar", tarw, tarw);
        modelo.put("tarea", tarw);



        ProActTar fuen = new ProActTar();

        //modelo.put("tarea",tarw);





        String M[][] = new String[1000][1000];

        classcertificacion regtem = new classcertificacion();
        regtem.setCodtar(codtar);
        regtem.setNum_sol(num_sol);
        regtem.setFecha(fechaan);
        // tarr.setCodfueneco(codfueneco);
        List lis_certi_proceso = orm.ejecutarLista("certificacion2", "mostrar_certificacion_area", regtem, new classcertificacion());


        //if(lis_certi_proceso!=null){modelo.put("sw",'1');}



        //List lis_para_insertar=orm.ejecutarLista("certificacion2", "mostrar_certificacion_area", regtem, new classcertificacion());
        // insert into refcompro (monto,codtar,codfueneco,codmonegr,glosa,fecha,ref123,obs,i_e) values (#monto#,#codtar#,#codfueneco#,#codmonegr#,#glosa#,#fecha#,#ref123#,#obs#,#i_e#);
        double ssum = 0;
        double a = 0;

        if (lis_certi_proceso.size() > 0) {//if_1
            for (int i = 0; i < lis_certi_proceso.size(); i++) {//for 1

                //System.out.println("SACANDO de la lista");
                classcertificacion ki = (classcertificacion) lis_certi_proceso.get(i);


                if (codtar.equals(ki.getCodtar())) {//if_2
                    M[i][0] = ki.getCodmonegr();
                    M[i][1] = ki.getCodtar();
                    M[i][2] = ki.getCodfueneco();
                    //String sd=;
                    System.out.println("funte economica a set" + M[i][2]);
                    fuen.setCodfueneco(M[i][2]);
                    orm.ejecutarObjeto("fuenteeconomica", "codfueneco", fuen, fuen);
                    M[i][3] = fuen.getDescripcion();
                    a = Double.valueOf(ki.getMonto()).doubleValue(); //new Double().doubleValue();
                    ssum = ssum + a;
                    M[i][4] = df2.format(a).toString();
                    M[i][5] = ki.getGlosa();
                    M[i][6] = ki.getCantidad();
                    M[i][7] = ki.getResponsable();
                    //System.out.println("Comparando tarea"+ki.getCodtar());
                    }
            }

            modelo.put("M", M);
            modelo.put("ssum", df2.format(ssum).toString());
            modelo.put("n", Integer.toString(lis_certi_proceso.size()));
            MN[0][0] = df2.format(ssum).toString();
        } else {
            modelo.put("lis_certi_proceso", lis_certi_proceso);
        }

        for (int i = 0; i < lis_certi_proceso.size(); i++) {
            for (int j = 0; j < lis_certi_proceso.size(); j++) {
                System.out.print(" " + M[i][j]);

            }
            System.out.println(" ");
        }



        classcertificacion fech = new classcertificacion();
        fech.setCodtar(codtar);
        fech.setNum_sol(num_sol);
        fech.setFecha(fechaan);
        fech.setI_e(i_e);
        orm.ejecutarObjeto("certificacion2", "descri_fechas", fech, fech);
        modelo.put("fechas", fech);
        //an.substring(2, 4)
        System.out.println("Fecha con horas ------->" + fech.getFechahrs());
        System.out.println("Fecha literal ------->" + fech.getFechalit());
        System.out.println("numero literal ------->" + fech.getFechalit().length());
        int cc = fech.getFechalit().length();
        int ini = fech.getFechalit().length() - 4;
        System.out.println("año final ------->" + fech.getFechalit().substring(ini, cc));
        modelo.put("ani_corre", fech.getFechalit().substring(ini, cc));
        /*Fecha*/
        /*Sacando  todo de la actividad en consultas anidadas */

        ProActTar descrip = new ProActTar();
        //descripcion de la carrera para la certificacion
        descrip.setCodtar(codtar);
        descrip.setCodacti(codacti);

        orm.ejecutarObjeto("codigostareaactividad", "descripcion", descrip, descrip);
        modelo.put("descripCarrera", descrip);
        /*FIN FIN FIN FIN */


        modelo.put("MN", MN);






/////////////////////////////////////////////EXEL
        if (M[0][0] != null) {

            Workbook workbook = null;
            WritableWorkbook nworkbook = null;
            String filex = System.currentTimeMillis() + ".xls";

            workbook = Workbook.getWorkbook(new File(System.getenv("AQUILESHOME7") + "/exel/mcertificacion.xls"));

            nworkbook = workbook.createWorkbook(new File(System.getenv("AQUILESHOME7") + "/exel/" + filex), workbook);

            /* Seleccionando una hoja del documento */
            WritableSheet sheet = nworkbook.getSheet("aquiles");
            WritableCell titulos = sheet.getWritableCell(2, 12);//numero correlativo
            WritableCell num = sheet.getWritableCell(5, 19);
            WritableCell serie = sheet.getWritableCell(0, 19);
            WritableCell tare = sheet.getWritableCell(2, 10);
            WritableCell flit = sheet.getWritableCell(3, 6);
            WritableCell td = sheet.getWritableCell(2, 8);
            WritableCell tex = sheet.getWritableCell(5, 41);//Arial 7 de (de la plantilla columna 10, fila 3)


            ///////////////////////////Solicitud Nro///////////num_sol+"/"+fech.getFechalit().substring(ini, cc)
            Label la = new Label(10, 2, num_sol + "/" + fech.getFechalit().substring(ini, cc));
            la.setCellFormat(titulos.getCellFormat());
            sheet.addCell(la);

            //////FECHA debajo del SOLICITUD DE CERTIFICACIÓN DE://////////////
            la = new Label(3, 6, fech.getFechalit());
            la.setCellFormat(flit.getCellFormat());
            sheet.addCell(la);


            //////////////Unidad Ejecutora ///////////////////////////////////////////////////////////////
            la = new Label(2, 8, "FACULTAD DE CIENCIAS PURAS Y NATURALES");
            la.setCellFormat(td.getCellFormat());
            sheet.addCell(la);
            //////////////////////////////////////////////////////////
            la = new Label(2, 9, taree.getDescripcion());
            la.setCellFormat(td.getCellFormat());
            sheet.addCell(la);

            la = new Label(2, 10, tarw.getDescripcion());
            la.setCellFormat(tare.getCellFormat());
            sheet.addCell(la);

            la = new Label(2, 11, M[0][7]);
            la.setCellFormat(td.getCellFormat());
            sheet.addCell(la);

            la = new Label(2, 12, taree.getApertura_prog());
            la.setCellFormat(td.getCellFormat());
            sheet.addCell(la);
//////////////////////////////////////////////////////////////////////////////////
            //lLENADO LOS MONTOS

            int gt = 18;
            int nm = lis_certi_proceso.size();
            for (int g = 0; g <= (nm - 1); g++) {
                Number nu = new Number(0, gt, g + 1);
                nu.setCellFormat(serie.getCellFormat());
                sheet.addCell(nu);
                ////////////////////////requerimiento
                la = new Label(1, gt, M[g][5]);
                la.setCellFormat(td.getCellFormat());
                sheet.addCell(la);
                ////////////////////cantidad
                la = new Label(4, gt, M[g][6]);
                la.setCellFormat(serie.getCellFormat());
                sheet.addCell(la);
                /////////////////monto total
                la = new Label(5, gt, M[g][4]);
                la.setCellFormat(num.getCellFormat());
                sheet.addCell(la);
                /////////////////////Num_tarea
                la = new Label(6, gt, tarw.getNum_tarea());
                la.setCellFormat(serie.getCellFormat());
                sheet.addCell(la);
                //////////////////////////num_Partida
                la = new Label(7, gt, M[g][0]);
                la.setCellFormat(serie.getCellFormat());
                sheet.addCell(la);
                ///////////////////////Fuente economica
                la = new Label(8, gt, M[g][2]);
                la.setCellFormat(td.getCellFormat());
                sheet.addCell(la);
                /////////////////////0.00
                la = new Label(10, gt, "0.00");
                la.setCellFormat(serie.getCellFormat());
                sheet.addCell(la);
                la = new Label(11, gt, "0.00");
                la.setCellFormat(serie.getCellFormat());
                sheet.addCell(la);

                gt++;
            }


            //TOTAL
            la = new Label(5, 31, df2.format(ssum).toString());
            la.setCellFormat(num.getCellFormat());
            sheet.addCell(la);
            //fecha
            la = new Label(1, 37, fech.getFechahrs());
            la.setCellFormat(td.getCellFormat());
            sheet.addCell(la);
            //fecha2
            la = new Label(5, 41, M[0][7]);
            la.setCellFormat(tex.getCellFormat());
            sheet.addCell(la);

            gt = 46;
            for (int g = 0; g <= (nm - 1); g++) {
                Number nu = new Number(0, gt, g + 1);
                nu.setCellFormat(serie.getCellFormat());
                sheet.addCell(nu);

                la = new Label(1, gt, "4030008596");
                la.setCellFormat(td.getCellFormat());
                sheet.addCell(la);

                la = new Label(3, gt, "UMSA-Fac.Cs Puras y Naturales");
                la.setCellFormat(td.getCellFormat());
                sheet.addCell(la);

                la = new Label(6, gt, M[g][3]);
                la.setCellFormat(td.getCellFormat());
                sheet.addCell(la);

                la = new Label(10, gt, M[g][4]);
                la.setCellFormat(num.getCellFormat());
                sheet.addCell(la);
                gt++;
            }

            la = new Label(10, 59, df2.format(ssum).toString());
            la.setCellFormat(num.getCellFormat());
            sheet.addCell(la);

            //fecha3
            la = new Label(1, 63, fech.getFechahrs());
            la.setCellFormat(td.getCellFormat());
            sheet.addCell(la);
            //fecha4
            la = new Label(1, 70, fech.getFechahrs());
            la.setCellFormat(tex.getCellFormat());
            sheet.addCell(la);

            nworkbook.write();
            nworkbook.close();
            modelo.put("direc", filex);
//////////////////////////////////////////FIN EXEL
        }
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp

        return new ModelAndView("certificacion/MosCertExel", modelo);
    }
}
