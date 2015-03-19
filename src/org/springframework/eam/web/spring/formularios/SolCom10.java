package org.springframework.eam.web.spring.formularios;

import Ajayu_orm.orm_bd;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lowagie.text.Image;
import com.lowagie.text.pdf.BarcodeEAN;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.web.spring.calendario.Calendario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolCom10 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        String codtar = request.getParameter("codtar");
        String fecha = request.getParameter("fecha");
        String codacti = request.getParameter("codacti");
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        String num_sol = request.getParameter("num_sol");
        String correlativo_unidad = request.getParameter("correlativo_unidad");

        String corr_ing_mat = request.getParameter("corr_ing_mat");

        String factura = request.getParameter("factura");
        String fecha_factura = request.getParameter("fecha_factura");

        String fecha_cbte = request.getParameter("fecha_cbte");
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("fecha", fecha);
        modelo.put("codtar", codtar);
        modelo.put("codacti", codacti);
        modelo.put("codtar", codtar);
        modelo.put("fecha", fecha);
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("codacti", codacti);

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

        /*Sacando la actividad*/

        ProActTar tare = new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral", "selec", tare, tare);
        modelo.put("actividad", tare);

        /*Sacando la tarea*/
        ProActTar tar = new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codtar", tar, tar);
        modelo.put("tarea", tar);

        /*consulta para sacar el correlativo de la unidad*/
        ProActTar programa = new ProActTar();
        orm.ejecutarObjeto("proacttar", "mostrar_programa", null, programa);

        int cim = Integer.valueOf(programa.getCorrelativo_ing_material()).intValue();


        if (Integer.valueOf(corr_ing_mat).intValue() == 0) {
            cim = cim + 1;
            programa.setCodpro(tare.getCodpro());
            programa.setCorrelativo_ing_material(Integer.toString(cim));
            orm.ejecutarObjeto("programa", "mas_correlativo_ing_mat", programa, null);
        } else {
            cim = Integer.valueOf(corr_ing_mat).intValue();
        }

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
        String fecha2 = di + " de " + me + " de " + an;
        //String fecha2 = desdia+" "+di+" de "+me+" de "+an;
        //System.out.println("fecha2---------------"+fecha2);

        String fecha_ing_mat = fecha2;

        Comprometido moscerte = new Comprometido();
        moscerte.setCodtar(codtar);
        moscerte.setCorrelativo_unidad(correlativo_unidad);
        moscerte.setCorrelativo_ing_material(Integer.toString(cim));
        moscerte.setFecha_cbte(fecha_cbte);
        moscerte.setFecha_factura(fecha_factura);
        moscerte.setFactura(factura);
        moscerte.setFecha_ing_material(fecha_ing_mat);
        orm.ejecutarObjeto("formularios", "fecha_fcf_a_todos", moscerte, null);
        //programa.setCorrelativo_ing_material(Integer.toString(cim));

        /*actualizando el correlativo*/




        /*Listado de los correlativos de las certificaciones en proceso*/
        Comprometido moscert = new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        List mont = orm.ejecutarLista("formularios", "muestra_por_tarea", moscert, new Comprometido());
        String destinov = "No";
        String responsable = "No";
        String sw = "0";
        String cbte = "";
        String nit = "-1";
        String factu = "";
        String fec_factu = "";
        String fec_cbte = "";
        String fech="";
        String corre_ing_mat = "";
        String dest = "";
        List mont_ = new ArrayList();
        if (mont != null) {
            for (int i = 0; i < mont.size(); i++) {
                Comprometido ki = (Comprometido) mont.get(i);
                destinov = ki.getDestino();
                responsable = ki.getResponsable();
                cbte = ki.getCbte();
                nit = ki.getNit_proveedor();
                factu = ki.getFactura();
                fec_factu = ki.getFecha_factura();
                fec_cbte = ki.getFecha_cbte();
                corre_ing_mat = ki.getCorrelativo_ing_material();
                dest = ki.getDestino();
                fech= ki.getFecha_ing_material();
                sw = "1";
            }
        }
        
        Comprometido pro = new Comprometido();
        if (!nit.equals("-1")) {

            pro.setCodtar(codtar);
            pro.setCorrelativo_unidad(correlativo_unidad);
            pro.setNit_proveedor(nit);
            orm.ejecutarObjeto("beneficiarios_proveedores", "buscar_con_nit", pro, pro);
        }
        
        if (mont != null) {
            Document document = new Document(PageSize.LETTER);
            // margenes de hoja (lado derecho, lado izquierdo, arriba, abajo)
            document.setMargins(35, 30, 30, 40);//a,b,c,d,
            try {

                String ff = "In_mat" + System.currentTimeMillis() + ".pdf";
                
                String nombre_firma = "firma_actual.png";
                Image png = Image.getInstance(System.getenv("AQUILESHOME7") + "/firmasjefearea/" + nombre_firma);////IN  CAMCAM
//                Image png = Image.getInstance("d:/" + nombre_firma);
                png.setAlignment(Image.ALIGN_RIGHT);
                png.scaleToFit(130f, 230f);

                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("AQUILESHOME7") + "/pdf/" + ff));
//                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/" + ff));
                Paragraph paragraph = new Paragraph();

                document.open();

                PdfContentByte cb = writer.getDirectContent();
                BaseFont bf = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                BaseFont cuerp = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

                float[] anchos = {0.03f, 0.07f, 0.10f, 0.60f, 0.10f, 0.10f};
                PdfPTable table = new PdfPTable(anchos);
                table.setWidthPercentage(95);

                float[] anchos1 = {0.20f, 0.60f, 0.20f};
                PdfPTable tabla1 = new PdfPTable(anchos1);

                PdfPCell cell1 = new PdfPCell(new Paragraph(new Phrase("UNIVERSIDAD MAYOR DE SAN ANDRÉS \nFACULTAD DE CIENCIAS PURAS Y NATURALES\nALMACENES", FontFactory.getFont(FontFactory.TIMES_BOLD, 4))));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla1.addCell(cell1);

                cell1 = new PdfPCell(new Paragraph(new Phrase("INGRESO DE MATERIAL\n ", FontFactory.getFont(FontFactory.TIMES_BOLD, 10))));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla1.addCell(cell1);

                cell1 = new PdfPCell(new Paragraph(new Phrase(corre_ing_mat, FontFactory.getFont(FontFactory.TIMES_BOLD, 20))));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla1.addCell(cell1);

                cell1 = new PdfPCell(new Paragraph(new Phrase("PROVEEDOR: NIT " + pro.getNit() + "  " + pro.getProveedor()+"             "+fech, FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setColspan(3);
                cell1.setBorder(0);
                tabla1.addCell(cell1);

                cell1 = new PdfPCell(new Paragraph(new Phrase("FACTURA " + factu + " FECHA: " + fec_factu, FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setColspan(3);
                cell1.setBorder(0);
                tabla1.addCell(cell1);

                cell1 = new PdfPCell(new Paragraph(new Phrase("CBTE: " + cbte + " FECHA: " + fec_cbte, FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setColspan(3);
                cell1.setBorder(0);
                tabla1.addCell(cell1);

                cell1 = new PdfPCell(new Paragraph(new Phrase("INGRESO CONTROLADO A, " + dest, FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setColspan(3);
                cell1.setBorder(0);
                tabla1.addCell(cell1);

                cell1 = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setColspan(6);
                tabla1.addCell(cell1);

                PdfPCell cell = new PdfPCell(tabla1);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setColspan(6);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("No", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("CANTIDAD", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("UNIDAD DE MEDIDA", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("DESCRIPCIÓN", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("IMPORTE UNITARIO Bs.", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("IMPORTE Bs.", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                //table.setHeaderRows(2);
            /*
                if (i % 50 == 0) {
                document.add(table);
                table.deleteBodyRows();
                table.setSkipFirstHeader(true);
                }
                if (i == 2) {
                document.add(table);
                table.deleteBodyRows();
                table.setSkipFirstHeader(false);
                }
                 */
                //float[] anchos2 = {0.03f, 0.07f, 0.10f, 0.60f, 0.10f, 0.10f};
                //PdfPTable table = new PdfPTable(anchos);
                //PdfPCell cell ;

                double a = 0, b = 0, t = 0, mom = 0;
                if (mont != null) {
                    for (int i = 0; i < mont.size(); i++) {
                        Comprometido ki = (Comprometido) mont.get(i);

                        cell = new PdfPCell(new Paragraph(new Phrase((i + 1) + " ", FontFactory.getFont(FontFactory.TIMES, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getCantidad(), FontFactory.getFont(FontFactory.TIMES, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getUni_medida(), FontFactory.getFont(FontFactory.TIMES, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getGlosa(), FontFactory.getFont(FontFactory.TIMES, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        a = Double.valueOf(ki.getMonto()).doubleValue();
                        t = t + a;
                        b = Double.valueOf(ki.getCantidad()).doubleValue();
                        mom = Double.valueOf(ki.getMonto()).doubleValue();

                        cell = new PdfPCell(new Paragraph(new Phrase(df2.format(a / b), FontFactory.getFont(FontFactory.TIMES, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(df2.format(mom), FontFactory.getFont(FontFactory.TIMES, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        /*como enter*/
                        cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setBorder(PdfPCell.RIGHT);
                        table.addCell(cell);

                        /*FIN COMO enter*/
                    }
                }

                /*como enter                 */
                for (int i = 0; i <= 20; i++) {
                    /*como enter*/
                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(PdfPCell.RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(PdfPCell.RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(PdfPCell.RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(PdfPCell.RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES, 2))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBorder(PdfPCell.RIGHT);
                    table.addCell(cell);


                }

                /*--------------------------*/




                cell = new PdfPCell(new Paragraph(new Phrase("TOTAL         Bs.", FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(5);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase(df2.format(t), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(cell);

                PdfPTable tablafirmas = new PdfPTable(2);

                PdfPCell cellfirma = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cellfirma.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellfirma.setBorder(0);
                tablafirmas.addCell(cellfirma);

                cellfirma = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n\n\n", FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cellfirma.addElement(new Chunk(png, 70, -80));
                cellfirma.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellfirma.setBorder(Rectangle.NO_BORDER);
                tablafirmas.addCell(cellfirma);
                
                cellfirma = new PdfPCell(new Paragraph(new Phrase("JORGE DURAN MONROY\nENCARGADO DE ALMACENES\nF.C.P.N. - UMSA", FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cellfirma.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellfirma.setBorder(0);
                tablafirmas.addCell(cellfirma);

                cellfirma = new PdfPCell(new Paragraph(new Phrase("Lic. Victor H. Concha Hermosa\nJEFE UNIDAD ADM.DESCONCENTRADA\nF.C.P.N. - UMSA", FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cellfirma.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellfirma.setBorder(0);
                tablafirmas.addCell(cellfirma);
                
                cell = new PdfPCell(tablafirmas);
                cell.setBorder(0);
                cell.setColspan(6);
                table.addCell(cell);
                
                cell = new PdfPCell(new Paragraph(new Phrase("\n\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 9))));
                cell.setBorder(0);
                cell.setColspan(6);
                table.addCell(cell);
                
                document.add(table);
                
                 PdfContentByte cdb = writer.getDirectContent();
                BarcodeEAN codeEAN = new BarcodeEAN();
                codeEAN.setCodeType(codeEAN.EAN13);
                String dig = new String();
                String codbarras = new String();
                dig = String.valueOf(num_sol);
                int as = randomNumber(10000, 50000);
                int bw = randomNumber(10000, 90000);
                if (dig.length() == 2) {
                    dig = dig + "9";
                }
                if (dig.length() == 1) {
                    dig = "99" + dig;
                }
                codbarras = as + "" + dig + "" + bw;
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



        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);
        modelo.put("lista_cert", mont);
        modelo.put("sw", sw);
        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("formularios/SolCom10", modelo);
    }
    private int randomNumber(int min, int max) {
        return min + (new Random()).nextInt(max - min);
    }
}
