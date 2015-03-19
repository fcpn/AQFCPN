package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.classcertificacion;
import org.springframework.eam.web.spring.calendario.Calendario;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class cert5 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

        String codtar = request.getParameter("codtar");
        modelo.put("codtar", codtar);
        // String responsable=request.getParameter("responsable");

        String MN[][] = new String[3][3];
        MN[0][0] = null;
        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

        DecimalFormat df2 = new DecimalFormat("###,###,###,##0.00");


        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar tare = new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral", "selec", tare, tare);
        modelo.put("actividad", tare);
        String codacti = tare.getCodacti();
        /*FIN FIN FIN FIN */

        //sacando el todo de la tabla programa en base al codigo de tarea
        ProActTar pro = new ProActTar();
        pro.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codpro_desde_codtar", pro, pro);

        int corr_pro = Integer.valueOf(pro.getCorrelativo_unidad());
        corr_pro++;
        String corre_prog = Integer.toString(corr_pro);
        //FINFIN


        /*Sacando la tarea*/
        ProActTar tarw = new ProActTar();
        tarw.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codtar", tarw, tarw);
        modelo.put("tarea", tarw);
        String n_cor = tarw.getCorrelativo();
        int f;
        f = Integer.valueOf(n_cor).intValue() + 1;
        //f=Double.valueOf(n_cor).doubleValue() + 1;
        modelo.put("coo", Integer.toString(f));

        ProActTar fuen = new ProActTar();

        //modelo.put("tarea",tarw);
        String M[][] = new String[1000][1000];

        classcertificacion regtem = new classcertificacion();
        regtem.setCodtar(codtar);
        // tarr.setCodfueneco(codfueneco);
        List lis_certi_proceso = orm.ejecutarLista("certificacion", "mostrar_certificacion_proceso", regtem, new classcertificacion());

        //if(lis_certi_proceso!=null){modelo.put("sw",'1');}
        List lis_para_insertar = orm.ejecutarLista("certificacion", "mostrar_certificacion_proceso", regtem, new classcertificacion());
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
//                        System.out.println("funte economica a set"+M[i][2]);
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


        /*Fecha*/
        Calendario calendario = new Calendario();
        String me = calendario.getMonth();
        String di = Integer.toString(calendario.getDayOfMonth());

        String an = Integer.toString(calendario.getYear());
        String hora = Integer.toString(calendario.getHour());
        String minuto = Integer.toString(calendario.getMinute());

        if (calendario.getMinute() < 10) {
            minuto = "0" + minuto;
        }
        if (calendario.getDayOfMonth() < 10) {
            di = "0" + di;
        }
        String horas = hora + ":" + minuto;

        String desdia = calendario.getDay();
        String dmes = Integer.toString(calendario.getMonthInt());

        String fecha2 = desdia + " " + di + " de " + me + " de " + an;
        String fecha = di + " de " + me + " de " + an;

        if (calendario.getMonthInt() < 10) {
            dmes = "0" + dmes;
        }

//        System.out.println("dia ******   "+di);
//        System.out.println("mes ******   "+me);
//        System.out.println("año ******   "+an.substring(2, 4));
        String fechacom = di + "/" + dmes + "/" + an.substring(2, 4);
//        System.out.println("Fecha para el comprometido   "+ fechacom);

        modelo.put("fecha", fecha2);//descripcion del dia
        modelo.put("an", an);
        String fech_hora = fecha + " Hrs " + horas;//descripcion con horas

        modelo.put("fech_hora", fech_hora);

        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar descrip = new ProActTar();
        //descripcion de la carrera para la certificacion
        descrip.setCodtar(codtar);
        descrip.setCodacti(codacti);

        orm.ejecutarObjeto("codigostareaactividad", "descripcion", descrip, descrip);
        modelo.put("descripCarrera", descrip);
        /*FIN FIN FIN FIN */

        String numsol = "", fechacr = "";
        Comprometido gr = new Comprometido();
        if (lis_para_insertar != null) {//if_1
            for (int i = 0; i < lis_para_insertar.size(); i++) {//for 1

                classcertificacion ki = (classcertificacion) lis_certi_proceso.get(i);
                gr.setCodmonegr(ki.getCodmonegr());
                gr.setCodfueneco(ki.getCodfueneco());
                gr.setRef123(ki.getRef123());
                gr.setMonto(ki.getMonto());
                gr.setGlosa(ki.getGlosa());
                //gr.setGlosa(ki.getGlosa() + " con cantidad de "+ki.getCantidad());
                gr.setFecha(fechacom);
                if (i == 0) {
                    numsol = ki.getNum_sol();
                    fechacr = fechacom;
                }
                gr.setObs(ki.getObs());
                gr.setCodtar(codtar);
                orm.ejecutarObjeto("comproegr", "insertar_compro", gr, null);
                gr.setNum_sol(ki.getNum_sol());
                gr.setCantidad(ki.getCantidad());
                gr.setResponsable(ki.getResponsable());
                gr.setFechahrs(fech_hora);
                gr.setFechalit(fecha2);
                gr.setId_usuario_certificado(id_usuario);
                //Insertando de la tabla comprmetido a la tabla ref compro para que se realice la certificacion presupuestaria en proceso 
                orm.ejecutarObjeto("certificacion", "insertar_ref_del_tmpcom", gr, null);

                gr.setCulmi_anula("proceso");
                //gr.setGlosa(ki.getObs());
                gr.setCorrelativo_unidad(corre_prog);
                orm.ejecutarObjeto("formularios", "insertar_registros", gr, null);

                orm.ejecutarObjeto("comproegr", "actualiza_compro", gr, null);

                orm.ejecutarObjeto("certificacion", "in_particular", gr, null);//insertando en particular

            }
            //actualizamos el correlativo de la unidad
            pro.setCodpro(pro.getCodpro());
            pro.setCorrelativo_unidad(corre_prog);
            orm.ejecutarObjeto("proacttar", "actualizo_correlativo", pro, null);
        }

        System.out.println("codtar   " + codtar + "  fechacr " + fechacr + "    numsol " + numsol);
        String dirarchi = generaPdfCertificacion(codtar, fechacr, numsol);

        if (MN[0][0] != null) {
            orm.ejecutarObjeto("certificacion", "solicitud_mas", regtem, null); //para el correlativo
        }

        modelo.put("MN", MN);
        modelo.put("direc", dirarchi);

        orm.cerrar();//cerrar la conexion         ahora vamos a jsp 


        /**/  // return new ModelAndView("certificacion/Cert5", modelo);
        return new ModelAndView("certificacion/Cert5", modelo);
    }

    private String generaPdfCertificacion(String codtar, String fechacr, String numsol) throws Exception {

        Map modelo = new HashMap();
        modelo.put("codtar", codtar);
        String fechaan = fechacr;
        String num_sol = numsol;
        modelo.put("coo", num_sol);
        String i_e = "3";
        String MN[][] = new String[3][3];
        MN[0][0] = null;
        orm_bd orm2 = new orm_bd();
        orm2.verCompilado = "C";
        mconexion m = new mconexion();
        orm2.establecerConexion(m.extraerConexion("url1"));
        DecimalFormat df2 = new DecimalFormat("###,###,###,##0.00");
        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar taree = new ProActTar();
        taree.setCodtar(codtar);
        orm2.ejecutarObjeto("gral", "selec", taree, taree);
        modelo.put("actividad", taree);
        String codacti = taree.getCodacti();
        /*FIN FIN FIN FIN */
        /*Sacando la tarea*/
        ProActTar tarw = new ProActTar();
        tarw.setCodtar(codtar);
        orm2.ejecutarObjeto("proacttar", "codtar", tarw, tarw);
        modelo.put("tarea", tarw);
        ProActTar fe = new ProActTar();
        String MSC[][] = new String[20][20];
        MSC[0][0] = "0";
        ProActTar fuen = new ProActTar();
        fuen.setCodtar(codtar);
        List lis_fe_tar = orm2.ejecutarLista("fuenteeconomica", "fuentes_e_disponibles_en_tarea", fuen, new ProActTar());
        modelo.put("tarea", fuen);
        if (lis_fe_tar.size() > 0) {
            for (int i = 0; i < lis_fe_tar.size(); i++) {
                ProActTar ki = (ProActTar) lis_fe_tar.get(i);
                MSC[0][i] = ki.getCodfueneco();
            }
        }
        String com;
        MosPresuIng sing = new MosPresuIng();
        if (lis_fe_tar.size() != 0) {
            for (int f = 0; f < lis_fe_tar.size(); f++) {
                sing.setCodtar(codtar);
                sing.setCodfueneco(MSC[0][f]);
                String tt = orm2.ejecutarObjeto("montosingreso", "tot_ejec_fe", sing, new String());
                if (tt != null) {
                    MSC[1][f] = tt;
                } else {
                    MSC[1][f] = "0";
                }
                tt = orm2.ejecutarObjeto("cuentanopresuing", "tot_ejec_fe", sing, new String());
                if (tt != null) {
                    MSC[2][f] = tt;
                } else {
                    MSC[2][f] = "0";
                }
                tt = orm2.ejecutarObjeto("montosegreso", "tot_ejec_fe", sing, new String());
                if (tt != null) {
                    MSC[3][f] = tt;
                } else {
                    MSC[3][f] = "0";
                }
                tt = orm2.ejecutarObjeto("cuentasnopresuegr", "tot_ejec_fe", sing, new String());
                if (tt != null) {
                    MSC[4][f] = tt;
                } else {
                    MSC[4][f] = "0";
                }
                orm2.ejecutarObjeto("fuenteeconomica", "codfueneco", sing, sing);
                if (sing != null) {
                    MSC[5][f] = sing.getDescripcion();
                }
                com = orm2.ejecutarObjeto("comproegr", "tot_ejec_fe", sing, new String());
                if (com != null) {
                    MSC[7][f] = com;
                } else {
                    MSC[7][f] = "0";
                }
            }
        }
        for (int f = 0; f < lis_fe_tar.size(); f++) {
            double a = Double.valueOf(MSC[1][f]).doubleValue();
            double b = Double.valueOf(MSC[2][f]).doubleValue();
            double c = Double.valueOf(MSC[3][f]).doubleValue();
            double d = Double.valueOf(MSC[4][f]).doubleValue();
            double co = Double.valueOf(MSC[7][f]).doubleValue();
            double e = ((a + b) - (c + d)) - co;
            MSC[6][f] = df2.format(e).toString();
        }
        String sal = "";
        String M[][] = new String[1000][1000];
        classcertificacion regtem = new classcertificacion();
        regtem.setCodtar(codtar);
        regtem.setNum_sol(num_sol);
        regtem.setFecha(fechaan);
        List lis_certi_proceso = orm2.ejecutarLista("certificacion2", "mostrar_certificacion_area", regtem, new classcertificacion());
        double ssum = 0;
        double a = 0;
        String id_usuario_creador_cert = "";
        if (lis_certi_proceso.size() > 0) {
            for (int i = 0; i < lis_certi_proceso.size(); i++) {
                classcertificacion ki = (classcertificacion) lis_certi_proceso.get(i);
                id_usuario_creador_cert = ki.getId_usuario_certificado();
                if (codtar.equals(ki.getCodtar())) {
                    M[i][0] = ki.getCodmonegr();
                    M[i][1] = ki.getCodtar();
                    M[i][2] = ki.getCodfueneco();
                    fuen.setCodfueneco(M[i][2]);
                    orm2.ejecutarObjeto("fuenteeconomica", "codfueneco", fuen, fuen);
                    M[i][3] = fuen.getDescripcion();
                    a = Double.valueOf(ki.getMonto()).doubleValue();
                    ssum = ssum + a;
                    M[i][4] = df2.format(a).toString();
                    M[i][5] = ki.getGlosa();
                    M[i][6] = ki.getCantidad();
                    M[i][7] = ki.getResponsable();
                }
            }
            modelo.put("M", M);
            modelo.put("ssum", df2.format(ssum).toString());
            modelo.put("n", Integer.toString(lis_certi_proceso.size()));
            MN[0][0] = df2.format(ssum).toString();
        } else {
            modelo.put("lis_certi_proceso", lis_certi_proceso);
        }
        
        //InsPreIng sm = (InsPreIng) getSqlMapTemplate().executeQueryForObject("getTotalComprometidoByTareaAndFuente", oie);
        Personas persona = eam.getNombresByIdUsuario(id_usuario_creador_cert);

        classcertificacion fech = new classcertificacion();
        fech.setCodtar(codtar);
        fech.setNum_sol(num_sol);
        fech.setFecha(fechaan);
        fech.setI_e(i_e);
        orm2.ejecutarObjeto("certificacion2", "descri_fechas", fech, fech);
        modelo.put("fechas", fech);
        int cc = fech.getFechalit().length();
        int ini = fech.getFechalit().length() - 2;
        modelo.put("ani_corre", fech.getFechalit().substring(ini, cc));
        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar descrip = new ProActTar();
        descrip.setCodtar(codtar);
        descrip.setCodacti(codacti);
        orm2.ejecutarObjeto("codigostareaactividad", "descripcion", descrip, descrip);
        modelo.put("descripCarrera", descrip);
        modelo.put("MN", MN);
        String ff = codtar + "_" + num_sol + "_" + System.currentTimeMillis() + ".pdf";
        if (M[0][0] != null) {
            Document document = new Document(PageSize.LETTER);
            // margenes de hoja (lado derecho, lado izquierdo, arriba, abajo)
            document.setMargins(30, 30, 25, 25);//a,b,c,d,
            try {
                String nombre_firma = "firma_actual.png";
                Image png = Image.getInstance(System.getenv("AQUILESHOME7") + "/firmasjefearea/" + nombre_firma);////IN  CAMCAM
//                Image png = Image.getInstance("d:/" + nombre_firma);
                png.setAlignment(Image.ALIGN_RIGHT);
                png.scaleToFit(130f, 230f);

                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("AQUILESHOME7") + "/pdf/" + ff));
//                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/" + ff));
                document.open();
                Font encabezado = new Font(Font.TIMES_ROMAN, 7, Font.BOLD);
                Font encabezado2 = new Font(Font.TIMES_ROMAN, 5, Font.BOLD);
                document.add(new Paragraph("UNIVERSIDAD MAYOR DE SAN ANDRÉS", encabezado));
                document.add(new Paragraph("DIRECCIÓN ADMINISTRATIVA FINANCIERA", encabezado));
                document.add(new Paragraph("SISTEMA DE PRESUPUESTOS AQUILES FCPN", encabezado2));
                PdfContentByte cb = writer.getDirectContent();
                BaseFont bf = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                BaseFont cuerp = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                cb.saveState();
                cb.beginText();
                cb.setFontAndSize(bf, 7);
                cb.moveText(470, 756);
                cb.newlineShowText("Form");
                cb.endText();
/////////////////////////////
                cb.beginText();
                cb.setFontAndSize(bf, 7);
                cb.moveText(550, 756);
                cb.newlineShowText("002");
                cb.endText();
/////////////////////////////////
                cb.beginText();
                cb.setFontAndSize(bf, 7);
                cb.moveText(470, 746);
                cb.newlineShowText("Solicitud Nro");
                cb.endText();
///////////////////////////////////////////
                cb.beginText();
                cb.setFontAndSize(bf, 9);
                cb.moveText(550, 746);
                cb.newlineShowText(num_sol + "/" + fech.getFechalit().substring(ini, cc));
                cb.endText();
///////////////////////////////////////////////////////////////////////////
                cb.beginText();
                cb.setFontAndSize(bf, 7);
                cb.moveText(470, 730);
                cb.newlineShowText("Hoja de ruta");
                cb.endText();
////////////////////////////////////////////////////////////
                cb.beginText();
                cb.setFontAndSize(bf, 6);
                cb.moveText(550, 730);
                cb.newlineShowText("...............");
                cb.endText();
///////////////////////////////////////////////////////////////////////////////////
                cb.beginText();
                cb.setFontAndSize(bf, 12);
                cb.moveText(190, 710);
                cb.newlineShowText("SOLICITUD DE CERTIFICACIÓN DE:");
                cb.endText();
//////////////////////////////////FECHA literal/////////////////////////////////////////////////
                cb.beginText();
                cb.setFontAndSize(cuerp, 7);
                cb.moveText(250, 700);
                cb.newlineShowText(fech.getFechalit());//
                cb.endText();

                for (int g = 0; g <= 4; g++) {
                    document.add(new Paragraph(" ", encabezado));
                }
                float[] anchos = {0.2f, 0.6f, 0.2f};
                PdfPTable tabla = new PdfPTable(anchos);
                tabla.setWidthPercentage(95);
////////////////////////////////////////////////////////
                PdfPCell dcell = new PdfPCell(new Paragraph(new Phrase("Direccion Administrativa", FontFactory.getFont(FontFactory.TIMES_BOLD, 8)))); // Unidad Ejecutora
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase("FACULTAD DE CIENCIAS PURAS Y NATURALES", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
///////////////////////////////////////////////////////////
                dcell = new PdfPCell(new Paragraph(new Phrase("Unidad Ejecutora", FontFactory.getFont(FontFactory.TIMES_BOLD, 8)))); // Apertura Programatica
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase(taree.getDescripcion(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));// 
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                ///////////////////////////////////////////////////////////////////////
                dcell = new PdfPCell(new Paragraph(new Phrase("Actividad y/o Proyecto", FontFactory.getFont(FontFactory.TIMES_BOLD, 8)))); //Tarea
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase(tarw.getDescripcion(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));//
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                tabla.addCell(dcell);
                ///////////////////////////////////////////////////////////////
                dcell = new PdfPCell(new Paragraph(new Phrase("Resp.Tarea", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase(M[0][7], FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));//   
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                ////////////////////////////////////////////////////////
                dcell = new PdfPCell(new Paragraph(new Phrase("Cod. Apertura Programática", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase(tarw.getAper_prog(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));//
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
                dcell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla.addCell(dcell);
//////////////////////////////////////////////////////////////
                dcell = new PdfPCell(new Paragraph(new Phrase("________________________________________________________________________________________"
                        + "__________________________________________________________________"
                        + "____________________________________________________________________________", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));

                dcell.setBorder(Rectangle.NO_BORDER);
                dcell.setColspan(3);
                tabla.addCell(dcell);
                document.add(tabla);
////////////////////////////////////////
                float[] widths = {0.04f, 0.41f, 0.08f, 0.1f, 0.05f, 0.08f, 0.08f, 0.07f, 0.09f};
                PdfPTable table = new PdfPTable(widths);
                table.setWidthPercentage(95);
                PdfPCell cell = new PdfPCell(new Paragraph(new Phrase("Nro.", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("Requerimiento", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("Cantidad", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("Monto", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("Tarea", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("Partida", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("FF-OF", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("TRASPASO PPTRIO", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(2);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                for (int g = 1; g <= 7; g++) {
                    table.addCell(cell);
                }

                cell = new PdfPCell(new Paragraph(new Phrase("Adiciona", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("Disminuye", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                //////////////////////////////////////
                int nm = lis_certi_proceso.size();
                for (int g = 0; g <= (nm - 1); g++) {
                    cell = new PdfPCell(new Paragraph(new Phrase(Integer.toString(g + 1), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase(M[g][5], FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase(M[g][6], FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase(M[g][4], FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase(tarw.getNum_tarea(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase(M[g][0], FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase(M[g][2], FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("0.00", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("0.00", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                }
                //////////////////////////////
                cell = new PdfPCell(new Paragraph(new Phrase("Totales", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setBorderColor(new Color(0));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(3);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase(df2.format(ssum).toString(), FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("0.00", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("0.00", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
///////////////////////////////////////////////////////
                cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 6))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 6))));//
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);
                ///////////////////////////////////////////
                cell = new PdfPCell(new Paragraph(new Phrase("________________________________________________________________________________________"
                        + "__________________________________________________________________"
                        + "____________________________________________________________________________", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));

                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(9);
                table.addCell(cell);
                ////////////////////////////
                cell = new PdfPCell(new Paragraph(new Phrase("Nro", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("Cuenta", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("Nombre Cuenta", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("Fuente Recursos", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("Monto", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell);
//////////////////////////////////////////////////
                for (int g = 0; g <= (nm - 1); g++) {
                    cell = new PdfPCell(new Paragraph(new Phrase(Integer.toString(g + 1), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(Rectangle.NO_BORDER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("10000004696388", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(Rectangle.NO_BORDER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("UMSA-Fac.Cs Puras y Naturales", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setColspan(3);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(M[g][3], FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));//       
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setColspan(3);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(M[g][4], FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));   //     
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setBorder(Rectangle.NO_BORDER);
                    table.addCell(cell);

                }
/////////////////////////Total//////
                cell = new PdfPCell(new Paragraph(new Phrase("Total:", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(8);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase(df2.format(ssum).toString(), FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));//    
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setBorder(Rectangle.NO_BORDER);
                table.addCell(cell);
                ////////////////////
                cell = new PdfPCell(new Paragraph(new Phrase("PRESUPUESTO y DISPONIBILIDAD FINANCIERA ", FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(9);
                table.addCell(cell);
////////////////////////////////////////////////
                cell = new PdfPCell(new Paragraph(new Phrase("El JEFE DEL ÁREA DESCONCENTRADA DE LA FACULTAD en cumplimiento de los Reglamentos Específicos de Operaciones, Presupuesto y de Tesorería, certifica que la solicitud es PROCEDENTE ademas que tiene Disponibilidad Financiera en la(s) Cuenta(s) del Banco Unión S.A.", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setColspan(9);
                table.addCell(cell);
                //****NEW 2014
//                float[] anchcabecera = {0.25f,0.25f,0.25f,0.25f};
                float[] anchcabecera = {0.125f, 0.125f, 0.125f, 0.125f, 0.125f, 0.125f, 0.125f, 0.125f};
                PdfPTable tablaCabecera = new PdfPTable(anchcabecera);
                tablaCabecera.setWidthPercentage(100);

                PdfPCell cellcb = new PdfPCell(new Paragraph(new Phrase("Montos Reales", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cellcb.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellcb.setColspan(4);
                cellcb.setBackgroundColor(Color.LIGHT_GRAY);
                tablaCabecera.addCell(cellcb);

                cellcb = new PdfPCell(new Paragraph(new Phrase("Gastos mas Comprometido", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cellcb.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellcb.setColspan(4);
                cellcb.setBackgroundColor(Color.LIGHT_GRAY);
                tablaCabecera.addCell(cellcb);
                for (int is = 1; is <= 2; is++) {
                    Color c = Color.white;
                    if (is == 2) {
                        c = Color.LIGHT_GRAY;
                    }

                    cellcb = new PdfPCell(new Paragraph(new Phrase("Ingreso", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                    cellcb.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellcb.setFixedHeight(12f);
                    cellcb.setBackgroundColor(c);
                    tablaCabecera.addCell(cellcb);

                    cellcb = new PdfPCell(new Paragraph(new Phrase("Gasto", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                    cellcb.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellcb.setFixedHeight(12f);
                    cellcb.setBackgroundColor(c);
                    tablaCabecera.addCell(cellcb);

                    cellcb = new PdfPCell(new Paragraph(new Phrase("Disponible", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                    cellcb.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellcb.setFixedHeight(12f);
                    cellcb.setBackgroundColor(c);
                    tablaCabecera.addCell(cellcb);

                    cellcb = new PdfPCell(new Paragraph(new Phrase("% Ejecución", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                    cellcb.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellcb.setFixedHeight(12f);
                    cellcb.setBackgroundColor(c);
                    tablaCabecera.addCell(cellcb);
                }
                ///////////////////////////////
//                cell = new PdfPCell(tablaTotales);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setColspan(9);
//                table.addCell(cell);
                float[] anch = {0.2f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f};
                PdfPTable tablaTotales = new PdfPTable(anch);
                tablaTotales.setWidthPercentage(95);
                PdfPCell celldt = new PdfPCell(new Paragraph(new Phrase("Fuente de Financiamieto", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                celldt.setHorizontalAlignment(Element.ALIGN_CENTER);
                celldt.setFixedHeight(12f);
                celldt.setBackgroundColor(Color.LIGHT_GRAY);
                tablaTotales.addCell(celldt);

                celldt = new PdfPCell(tablaCabecera);
                celldt.setHorizontalAlignment(Element.ALIGN_CENTER);
                celldt.setColspan(8);
                tablaTotales.addCell(celldt);
                String V[] = new String[20];
                int vi = 0;
                DecimalFormat formatoeje = new DecimalFormat("###,###,##0.00");
                for (int f = 0; f < lis_fe_tar.size(); f++) {
                    InsPreIng oie = new InsPreIng();
                    oie.setCodtar(codtar);
                    oie.setCodfueneco(MSC[0][f]);

                    double total_presupuestado_egreso = eam.getTotalPresupuestadoTareaFuente(oie);
                    double total_ejecutado_egreso = eam.getTotalEjecutadoTareaFuenteEgr(oie);
                    double total_ejecutado_nopresupuestado_egreso = eam.getTotalEjecutadoNoPresupuestadoTareaFuenteEgr(oie);

                    celldt = new PdfPCell(new Paragraph(new Phrase(MSC[0][f] + "-" + MSC[5][f], FontFactory.getFont(FontFactory.TIMES_ROMAN, 5))));
                    celldt.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);

                    double total_ejecutado_ingresos = eam.getTotalEjecutadoIngresos(oie);
                    double total_ejecutado_nopre_ingresos = eam.getTotalEjecutadoIngresosNoPresupuestado(oie);

                    double ejecutado = ((total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso) / (total_ejecutado_ingresos + total_ejecutado_nopre_ingresos)) * 100;
                    double total_comprometido_egresos = eam.getTotalComprometidoByTareaAndFuente(oie);

                    celldt = new PdfPCell(new Paragraph(new Phrase("" + formatoeje.format(total_ejecutado_ingresos + total_ejecutado_nopre_ingresos), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));// Ingresos Ejecutado por fuente
                    celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);

                    celldt = new PdfPCell(new Paragraph(new Phrase("" + formatoeje.format(total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));// Gastos Ejecutados por fuente
                    celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);

                    celldt = new PdfPCell(new Paragraph(new Phrase("" + formatoeje.format((total_ejecutado_ingresos + total_ejecutado_nopre_ingresos) - (total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso)), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));// Disponible
                    celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);

                    celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format(ejecutado) + " %", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);

                    ////
                    celldt = new PdfPCell(new Paragraph(new Phrase("" + formatoeje.format(total_ejecutado_ingresos + total_ejecutado_nopre_ingresos), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));// Ingresos Ejecutado por fuente
                    celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);

                    celldt = new PdfPCell(new Paragraph(new Phrase("" + formatoeje.format(total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + total_comprometido_egresos), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));// Gastos Ejecutados por fuente
                    celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);

                    celldt = new PdfPCell(new Paragraph(new Phrase("" + formatoeje.format((total_ejecutado_ingresos + total_ejecutado_nopre_ingresos) - (total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + total_comprometido_egresos)), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));// Disponible
                    celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);

                    ejecutado = ((total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + total_comprometido_egresos) / (total_ejecutado_ingresos + total_ejecutado_nopre_ingresos)) * 100;
                    celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format(ejecutado) + " %", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    celldt.setFixedHeight(11f);
                    tablaTotales.addCell(celldt);
                    if (vi == 0) {
                        V[0] = total_ejecutado_ingresos + total_ejecutado_nopre_ingresos + "";
                        V[1] = total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + "";
                        V[2] = (total_ejecutado_ingresos + total_ejecutado_nopre_ingresos) - (total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso) + "";

                        V[3] = total_ejecutado_ingresos + total_ejecutado_nopre_ingresos + "";
                        V[4] = total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + total_comprometido_egresos + "";
                        V[5] = (total_ejecutado_ingresos + total_ejecutado_nopre_ingresos) - (total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + total_comprometido_egresos) + "";
                        vi++;
                    } else {
                        V[0] = Double.parseDouble(V[0]) + (total_ejecutado_ingresos + total_ejecutado_nopre_ingresos) + "";
                        V[1] = Double.parseDouble(V[1]) + total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + "";
                        V[2] = Double.parseDouble(V[2]) + ((total_ejecutado_ingresos + total_ejecutado_nopre_ingresos) - (total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso)) + "";

                        V[3] = Double.parseDouble(V[3]) + total_ejecutado_ingresos + total_ejecutado_nopre_ingresos + "";
                        V[4] = Double.parseDouble(V[4]) + (total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + total_comprometido_egresos) + "";
                        V[5] = Double.parseDouble(V[5]) + ((total_ejecutado_ingresos + total_ejecutado_nopre_ingresos) - (total_ejecutado_egreso + total_ejecutado_nopresupuestado_egreso + total_comprometido_egresos)) + "";
                    }
                }

                celldt = new PdfPCell(new Paragraph(new Phrase("TOTALES", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);

                celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format(Double.parseDouble(V[0])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);
                celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format(Double.parseDouble(V[1])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);
                celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format(Double.parseDouble(V[2])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);
                celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format((Double.parseDouble(V[1]) / Double.parseDouble(V[0])) * 100) + "%", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);

                celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format(Double.parseDouble(V[3])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);
                celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format(Double.parseDouble(V[4])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);
                celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format(Double.parseDouble(V[5])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);
                celldt = new PdfPCell(new Paragraph(new Phrase(formatoeje.format((Double.parseDouble(V[4]) / Double.parseDouble(V[3])) * 100) + "%", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                celldt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                celldt.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tablaTotales.addCell(celldt);

                ////////Matriz de fuentes///////////////////
                cell = new PdfPCell(tablaTotales);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(9);
                table.addCell(cell);

//                cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));//       
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                cell.setColspan(7);
//                table.addCell(cell);
///////////////////////////
                cell = new PdfPCell(new Paragraph(new Phrase("Us: " + persona.getPaterno()+" "+persona.getMaterno()+" "+persona.getNombres(), FontFactory.getFont(FontFactory.TIMES_ITALIC, 5)))); //      
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(9);
                table.addCell(cell);
/////////////////////////////////////////////////////////
                PdfPTable tableFirm2 = new PdfPTable(9);
                tableFirm2.setWidthPercentage(95);

                PdfPCell cellf2 = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cellf2.setBorder(Rectangle.NO_BORDER);
                cellf2.setColspan(3);
                tableFirm2.addCell(cellf2);

                cellf2 = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cellf2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellf2.setBorder(Rectangle.NO_BORDER);
                cellf2.setColspan(3);
                tableFirm2.addCell(cellf2);

                cellf2 = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cellf2.addElement(new Chunk(png, 30, -26));
                cellf2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cellf2.setBorder(Rectangle.NO_BORDER);
                cellf2.setColspan(3);
                tableFirm2.addCell(cellf2);

                cellf2 = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cellf2.setBorder(Rectangle.NO_BORDER);
                cellf2.setColspan(3);
                tableFirm2.addCell(cellf2);
                cellf2 = new PdfPCell(new Paragraph(new Phrase(M[0][7] + "\n Responsable de tarea", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8)))); //    
                cellf2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellf2.setBorder(Rectangle.NO_BORDER);
                cellf2.setColspan(3);
                tableFirm2.addCell(cellf2);

                cellf2 = new PdfPCell(new Paragraph(new Phrase("Lic. Victor H. Concha Hermosa\nJEFE UNIDAD ADM.DESCONCENTRADA\nFac.Cs. Puras y Naturales", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                cellf2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellf2.setBorder(Rectangle.NO_BORDER);
                cellf2.setColspan(3);
                tableFirm2.addCell(cellf2);
                cell = new PdfPCell(tableFirm2);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(9);
                table.addCell(cell);

//                cell = new PdfPCell(new Paragraph(new Phrase("El DEPARTAMENTO DE PRESUPUESTO Y PLANIFICACIÓN FINANCIERA SI( ) NO ( ) autoriza la solicitud de modificación presupuestaria.", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
//                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//                //cell.setBorder(Rectangle.NO_BORDER);
//                cell.setColspan(9);
//                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("FECHA " + fech.getFechahrs(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(9);
                table.addCell(cell);

/////////////////////////////////////////////////////////
                for (int f = 1; f <= 3; f++) {
                    cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                    cell.setBorder(Rectangle.NO_BORDER);
                    cell.setColspan(9);
                    table.addCell(cell);
                }
                cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("_______________________", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("_______________________", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("Analista DPTO.PRESUPUESTO Y PLANIFICACIÓN FINANCIERA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("VºBº JEFE DPTO.PRESUPUESTO Y PLANIFICACIÓN FINANCIERA", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setColspan(3);
                table.addCell(cell);

                document.add(table);
                // codigo de barras
                //Comecando a configurar o cod de barras
                PdfContentByte cdb = writer.getDirectContent();
                BarcodeEAN codeEAN = new BarcodeEAN();
                codeEAN.setCodeType(codeEAN.EAN13);
                String dig = new String();
                String codbarras = new String();
                dig = String.valueOf(num_sol);
                int as = randomNumber(10000, 50000);
                int b = randomNumber(10000, 90000);
                if (dig.length() == 2) {
                    dig = dig + "9";
                }
                if (dig.length() == 1) {
                    dig = "99" + dig;
                }
                codbarras = as + "" + dig + "" + b;
                codeEAN.setCode(codbarras);
                Image imageEAN = codeEAN.createImageWithBarcode(cdb, null, null);
                document.add(new Phrase(new Chunk(imageEAN, 0, 0)));
                modelo.put("direc", ff);
            } catch (DocumentException de) {
                System.err.println(de.getMessage());
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            }
            document.close();
        }

        orm2.cerrar();
        return ff;
    }

    private int randomNumber(int min, int max) {
        return min + (new Random()).nextInt(max - min);
    }
}
