package org.springframework.eam.web.spring.formularios.proyectos;

import Ajayu_orm.orm_bd;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.TipoCambio;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolFor5 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        String codtar = request.getParameter("codtar");
        String fecha = request.getParameter("fecha");
        String num_sol = request.getParameter("num_sol");
        String correlativo_unidad = request.getParameter("correlativo_unidad");
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("fecha", fecha);
        String i_e = "3";
        modelo.put("codtar", codtar);



        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros

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


        String tipo_cambio="Boliviano";
        String relacion="Dolar";
        TipoCambio tcam = new TipoCambio();
        tcam.setDescripcion(tipo_cambio);
        tcam.setRelacion(relacion);
        orm.ejecutarObjeto("tipo_cambio", "un_registro", tcam, tcam);

        /*Listado de los correlativos de las certificaciones en proceso*/
        Comprometido moscert = new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        List mont = orm.ejecutarLista("formularios", "muestra_por_tarea", moscert, new Comprometido());
        modelo.put("lista_cert", mont);

        String destinov = "No";
        String responsable = "No";
        String sw = "0";
        // List mont_=new ArrayList();
        if (mont != null) {



            for (int i = 0; i < mont.size(); i++) {
                Comprometido ki = (Comprometido) mont.get(i);

                destinov = ki.getDestino();
                responsable = ki.getResponsable();

                if (destinov.equals("No definido") || ki.getUni_medida().equals("No definido")) {
                    sw = "1";
                }
            }

        }
 int unni = 0, pos = 0, sq = 0;
        double sumf = 0;
        String[] montosf = new String[10000];

        List mont_ = new ArrayList();
        if (mont != null) {
            for (int i = 0; i < mont.size(); i++) {
                Comprometido ki = (Comprometido) mont.get(i);
                montosf[pos + 1] = ki.getMonto();
                montosf[pos] = ki.getUni();
                pos = pos + 2;
                if (i == 0) {
                    unni = Integer.parseInt(ki.getUni());
                    mont_.add(ki);
                } else {
                    if (unni == Integer.parseInt(ki.getUni())) {
                    } else {
                        mont_.add(ki);
                        unni = Integer.parseInt(ki.getUni());
                    }
                }
            }
        }

        pos = pos - 2;


        List monnt = new ArrayList();
        if (mont_ != null) {
            for (int i = 0; i < mont_.size(); i++) {
                Comprometido kim = (Comprometido) mont_.get(i);
                sumf = 0;
                for (int g = 0; g <= pos; g = g + 2) {
                    System.out.print("unir   " + montosf[g]);
                    System.out.println("    monto  " + montosf[g + 1]);
                    if (montosf[g].equals(kim.getUni())) {
                        sumf = sumf + Double.parseDouble(montosf[g + 1]);
                    }

                }
                //String hj = Double.toString(montosf[i]);
                String suf = Double.toString(sumf);
                kim.setMonto(suf);
                System.out.println("pppp    :: " + kim.getUni());
                monnt.add(kim);

            }
        }
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);
        modelo.put("sw", sw);

        if (mont_ != null) {
            //mi PDF
            if (sw.equals("0")) {

                Document document = new Document(PageSize.LETTER.rotate());
                // margenes de hoja (lado derecho, lado izquierdo, arriba, abajo)
                document.setMargins(30, 30, 80, 25);//a,b,c,d,
                try {
                    //fecha String aa=fech.getFechahrs().replaceAll(" ", "_");



                    String ff = "ped_" + codtar + "_" + correlativo_unidad + "_" + System.currentTimeMillis() + ".pdf";
                    //System.getenv("AQUILESHOME4")+
                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("AQUILESHOME7")+"/pdf/"+ ff));

                    //PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/" + ff));

                    Paragraph paragraph = new Paragraph();
                    //Chunk space = new Chunk(' ');
                    // paragraph.add(space);//estacio

                    document.open();

                    PdfContentByte cb = writer.getDirectContent();
                    BaseFont bf = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                    BaseFont cuerp = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                    /*
                    for(int g=0;g<=4;g++){
                    document.add(new Paragraph(" ", encabezado));
                    }*/
                    //float[] anchos = {0.03f, 0.07f, 0.12f, 0.08f, 0.40f, 0.1f, 0.1f, 0.1f};
                    float[] anchos = {0.03f, 0.07f, 0.12f, 0.26f, 0.08f, 0.08f, 0.08f, 0.08f, 0.1f, 0.1f};
                    PdfPTable table = new PdfPTable(anchos);
                    table.setWidthPercentage(95);

                    /*TABLA PARA LOS ENCABEZADOS*/
                    float[] anchos2 = {0.3f, 0.34f, 0.36f};
                    PdfPTable tabla2 = new PdfPTable(anchos2);
                    PdfPCell cell2 = new PdfPCell(new Paragraph(new Phrase("UNIVERSIDAD MAYOR DE SAN ANDRÉS \n\nFACULTAD DE CIENCIAS PURAS Y NATURALES\n\n UNIDAD DESCONCENTRADA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla2.addCell(cell2);

                    cell2 = new PdfPCell(new Paragraph(new Phrase("PEDIDO DE MATERIALES", FontFactory.getFont(FontFactory.TIMES_BOLD, 12))));
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla2.addCell(cell2);

                    /*TABLA PARA LA CABECERA INICIAL DERACHA*/

                    float[] anchos3 = {0.3f, 0.3f, 0.2f, 0.2f};
                    PdfPTable tabla3 = new PdfPTable(anchos3);
                    PdfPCell cell3 = new PdfPCell(new Paragraph(new Phrase("UNIDAD SOLICITANTE", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell3.setColspan(2);
                    tabla3.addCell(cell3);

                    cell3 = new PdfPCell(new Paragraph(new Phrase("ALMACEN", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell3.setColspan(2);
                    tabla3.addCell(cell3);

                    cell3 = new PdfPCell(new Paragraph(new Phrase("N° CORRELATIVO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);

                    cell3 = new PdfPCell(new Paragraph(new Phrase("FECHA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);
                    cell3 = new PdfPCell(new Paragraph(new Phrase("N° CORRELATIVO", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);

                    cell3 = new PdfPCell(new Paragraph(new Phrase("FECHA", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);


                    /**/
                    cell3 = new PdfPCell(new Paragraph(new Phrase(correlativo_unidad + " - FCPN", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);
//                    cell3 = new PdfPCell(new Paragraph(new Phrase(fecha, FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
//                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    tabla3.addCell(cell3);
                    tabla3.addCell("  ");
                    tabla3.addCell("  ");
                    tabla3.addCell("  ");
                    /*FIN FIN FIN FIN FIN FIN FIN FIN TABLA PARA LA CABECERA INICIAL DERACHA*/
                    /*para la tabla cabecera derecha inicial*/
                    cell2 = new PdfPCell(tabla3);
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla2.addCell(cell2);
                    /**/
                    PdfPCell cell = new PdfPCell(tabla2);
                    cell.setColspan(10);
                    table.addCell(cell);

                    /*Segunda fila*/
                    float[] anchos4 = {0.25f, 0.25f, 0.248f, 0.252f};
                    PdfPTable tabla4 = new PdfPTable(anchos4);
                    PdfPCell cell4 = new PdfPCell(new Paragraph(new Phrase("UNIDAD SOLICITANTE", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(cell4);

                    cell4 = new PdfPCell(new Paragraph(new Phrase("DESTINO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(cell4);
                    cell4 = new PdfPCell(new Paragraph(new Phrase("CÓDIGO ESTRUCTURAL", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(cell4);
                    cell4 = new PdfPCell(new Paragraph(new Phrase("N° INGRESO MATERIALES", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(cell4);

                    cell4 = new PdfPCell(new Paragraph(new Phrase(tare.getDescripcion(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(cell4);
                    cell4 = new PdfPCell(new Paragraph(new Phrase(destinov, FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(cell4);
                    tabla4.addCell("  ");
                    tabla4.addCell("  ");
                    /*Segunda fila*/

                    cell = new PdfPCell(tabla4);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(10);
                    table.addCell(cell);

                    /*Fila 4*/
                    cell = new PdfPCell(new Paragraph(new Phrase("N°", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("CANTIDAD PEDIDA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("UNIDAD DE MEDIDA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("DESCRIPCIÓN", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("CANTIDAD APROBADA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("CANTIDAD ENTREGADA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("UNITARIO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("TOTAL", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("PARTIDA GASTO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("CÓDIGO KARDEX", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    double a = 0, b = 0, c = 0, total = 0, totalu = 0;
                    int v = 0;
                    /*Para el for*/
                    for (int j = 0; j < monnt.size(); j++) {
                        Comprometido ki = (Comprometido) monnt.get(j);
                        v++;
                        //for (int u = 0; u <= 10; u++) {
                        cell = new PdfPCell(new Paragraph(new Phrase(String.valueOf(j + 1), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getCantidad(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getUni_medida(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);


                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getGlosa(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getCantidad(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        table.addCell("  ");

                        a = Double.valueOf(ki.getMonto()).doubleValue();
                        b = Double.valueOf(ki.getCantidad()).doubleValue();
                        c = a / b;
                        total = total + a;
                        totalu = totalu + c;
                        cell = new PdfPCell(new Paragraph(new Phrase(df2.format(c).toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(df2.format(a).toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getCodmonegr(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        table.addCell("  ");
                    }
                    if (v < 16) {
                        for (int j = 0; j < (16 - v); j++) {
                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);


                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);

                            table.addCell("  ");

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);

                            table.addCell("  ");
                        }
                    }

                    /*FIN FIN FIN FIN FOR.......*/
                    /*PenUltima fila*/

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setColspan(3);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("TIPO DE CAMBIO: "+tcam.getCambio(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("TOTALES", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setColspan(2);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(df2.format(totalu).toString(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(df2.format(total).toString(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(2);
                    table.addCell(cell);

                    /*FILA FINAL*/

                    cell = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n\nUNIDAD SOLICITANTE", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(3);
                    table.addCell(cell);


                    /*TABLA_5*/

                    PdfPTable tabla5 = new PdfPTable(2);
                    PdfPCell cell5 = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n\nUNIDAD DESCONCENTRADA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla5.addCell(cell5);

                    cell5 = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n\nDIVISION DE INVENTARIOS", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla5.addCell(cell5);
                    /*FIN FFIN FIN FINF TABLA_5*/
                    /*insertnado tabla5*/
                    cell = new PdfPCell(tabla5);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    /*entregado por TABLA_6 */
                    float[] anchos6 = {0.4f, 0.6f};
                    PdfPTable tabla6 = new PdfPTable(anchos6);
                    PdfPCell cell6 = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n\nENTREGADO POR:", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla6.addCell(cell6);

                    cell6 = new PdfPCell(new Paragraph(new Phrase("RECIBIDO POR:\n\n\n" +
                            "NOMBRE ................................................................................" +
                            "\n\nC.I.: .........................................................................................." +
                            "\n\nFIRMA ...................................................................................." +
                            "\n\nFECHA ....................................................................................", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tabla6.addCell(cell6);
                    /*FIN FIN FIN FIN FIN entregado por TABLA_6*/
                    /*Tabla de los entregado y nombre TABLA_6*/
                    cell = new PdfPCell(tabla6);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(6);
                    table.addCell(cell);
                    /*FIN FIN FIN FIN FFILA FINAL*/

                    document.add(table);

                    modelo.put("direc", ff);

                } catch (DocumentException de) {
                    System.err.println(de.getMessage());
                } catch (IOException ioe) {
                    System.err.println(ioe.getMessage());
                }


                document.close();


            }

        }

        // orm.ejecutarObjeto("formularios", "distinto", moscert, moscert);
        //  modelo.put("dis", moscert);

        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("presupuestos3/formularios/SolFor5", modelo);
    }
}
