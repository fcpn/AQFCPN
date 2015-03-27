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
import org.springframework.eam.domain.DatosXml;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolFor4 implements Controller {

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

        
         DatosXml autoridad=new DatosXml();
        autoridad.setDato2("JEFE UNIDAD ADM.DESCONCENTRADA");
        orm.ejecutarObjeto("autoridad", "actual", autoridad, autoridad);
        if (mont_ != null) {
            //mi PDF
            if (sw.equals("0")) {
                Document document = new Document(PageSize.LETTER.rotate());
                // margenes de hoja (lado derecho, lado izquierdo, arriba, abajo)
                document.setMargins(30, 30, 80, 25);//a,b,c,d,
                try {

                    String ff = "for_" + codtar + "_" + correlativo_unidad + "_" + System.currentTimeMillis() + ".pdf";

                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("AQUILESHOME7") + "/pdf/" + ff));
                    //PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/" + ff));
                    Paragraph paragraph = new Paragraph();

                    document.open();

                    PdfContentByte cb = writer.getDirectContent();
                    BaseFont bf = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                    BaseFont cuerp = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

                    float[] anchos = {0.03f, 0.07f, 0.12f, 0.08f, 0.40f, 0.1f, 0.1f, 0.1f};
                    PdfPTable table = new PdfPTable(anchos);
                    table.setWidthPercentage(95);

                    PdfPCell cell = new PdfPCell(new Paragraph(new Phrase("UNIVERSIDAD MAYOR DE SAN ANDRÉS \n\n"+autoridad.getDato3().toUpperCase(), FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(4);
                    table.addCell(cell);



                    cell = new PdfPCell(new Paragraph(new Phrase("SOLICITUD DE COMPRA DE BIENES Y/O SERVICIOS", FontFactory.getFont(FontFactory.TIMES_BOLD, 15))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    //TABLA PARA EL CORRELATIVO
                    PdfPTable tabla3 = new PdfPTable(2);
                    PdfPCell cell3 = new PdfPCell(new Paragraph(new Phrase("UNIDAD SOLICITANTE", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell3.setColspan(2);
                    tabla3.addCell(cell3);

                    cell3 = new PdfPCell(new Paragraph(new Phrase("N° CORRELATIVO", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);

                    cell3 = new PdfPCell(new Paragraph(new Phrase("FECHA", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);

                    cell3 = new PdfPCell(new Paragraph(new Phrase(correlativo_unidad + " - FCPN", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);

                    cell3 = new PdfPCell(new Paragraph(new Phrase(fecha, FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla3.addCell(cell3);
                    //FIN FIN FIN FIN FIN PARA EL CORRELATIVO

                    //Unidad Solicitante para el numero correlativo
                    PdfPCell dcell = new PdfPCell(tabla3);
                    dcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    dcell.setColspan(4);
                    table.addCell(dcell);


                    //TABLA PARTIDA en dos
                    PdfPTable tabla2 = new PdfPTable(2);
                    PdfPCell cell1 = new PdfPCell(new Paragraph(new Phrase("UNIDAD SOLICITANTE", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla2.addCell(cell1);

                    cell1 = new PdfPCell(new Paragraph(new Phrase("DESTINO", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla2.addCell(cell1);

                    cell1 = new PdfPCell(new Paragraph(new Phrase(tare.getDescripcion(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla2.addCell(cell1);

                    cell1 = new PdfPCell(new Paragraph(new Phrase(destinov, FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla2.addCell(cell1);

                    //FIN FIN FIN FIN FTABLA PARTIDA EN DOS
                    //AÃ±adiendo la tablita partida en dos a la original
                    dcell = new PdfPCell(tabla2);
                    dcell.setColspan(8);
                    table.addCell(dcell);

                    cell = new PdfPCell(new Paragraph(new Phrase("N°", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase("CANTIDAD", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("UNIDAD DE MEDIDA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("CANTIDAD AUTORIZADA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("DESCRIPCIÓN", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    //Tabla Cotizacion

                    PdfPTable tabla4 = new PdfPTable(2);
                    PdfPCell cell4 = new PdfPCell(new Paragraph(new Phrase("PARA COTIZACIÓN", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell4.setColspan(2);
                    tabla4.addCell(cell4);


                    cell4 = new PdfPCell(new Paragraph(new Phrase("UNITARIO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(cell4);


                    cell4 = new PdfPCell(new Paragraph(new Phrase("TOTAL", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla4.addCell(cell4);


                    //Para Cotizacion
                    cell = new PdfPCell(tabla4);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(2);
                    table.addCell(cell);


                    cell = new PdfPCell(new Paragraph(new Phrase("PARTIDA \nGASTO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    double a = 0, b = 0, c = 0;
                    int v = 0;
                    //pARA EL fOR
                    for (int j = 0; j < monnt.size(); j++) {
                        v++;
                        Comprometido ki = (Comprometido) monnt.get(j);
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

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getCantidad(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getGlosa(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                        table.addCell(cell);

                        a = Double.valueOf(ki.getMonto()).doubleValue();
                        b = Double.valueOf(ki.getCantidad()).doubleValue();
                        c = a / b;

                        cell = new PdfPCell(new Paragraph(new Phrase(df2.format(c).toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(df2.format(a).toString(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getCodmonegr(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    }
                    if (v < 23) {
                        for (int j = 0; j < (21 - v); j++) {
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
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);
                        }
                    }
//**************************************************
//***************************************
                    cell = new PdfPCell(new Paragraph(new Phrase("Cotizado por: \n\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 10))));
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setColspan(3);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

//***************************************
//**************************************************
                    cell = new PdfPCell(new Paragraph(new Phrase("Elaborado por: \n\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 10))));
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cell.setColspan(3);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    //FIN PARA EL FOR


                    //Parte Final
                    cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 15))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(3);
                    table.addCell(cell);


                    //TABLA PARA EL COMTROL PRESUPUESTARIO
                    PdfPTable tabla5 = new PdfPTable(3);
                    PdfPCell cell5 = new PdfPCell(new Paragraph(new Phrase("C O N T R O L      P R E S U P U E S T A R I O", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell5.setColspan(3);
                    tabla5.addCell(cell5);
                    cell5 = new PdfPCell(new Paragraph(new Phrase(tar.getAper_prog(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell5.setColspan(3);
                    tabla5.addCell(cell5);
                    //TABLA PARA SEPARAR NOMBRE DEL SELLO
                    float[] anchos6 = {0.615f, 0.385f};
                    PdfPTable tabla6 = new PdfPTable(anchos6);

                    //Tabla para el responsable de tarea y Nom Actividad
                    PdfPTable tabla7 = new PdfPTable(2);
                    PdfPCell cell7 = new PdfPCell(new Paragraph(new Phrase("NOMBRES", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell7.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    tabla7.addCell(cell7);

                    cell7 = new PdfPCell(new Paragraph(new Phrase(responsable, FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tabla7.addCell(cell7);


                    cell7 = new PdfPCell(new Paragraph(new Phrase("NOMBRE DE LA ACTIVIDAD", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell7.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    tabla7.addCell(cell7);

                    cell7 = new PdfPCell(new Paragraph(new Phrase(tar.getDescripcion(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                    cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tabla7.addCell(cell7);
                    //Espacio para el sello hacia abajo
                    cell7 = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell7.setColspan(2);
                    tabla7.addCell(cell7);
                    //llenado de nombre de actividad y nombre responsable
                    PdfPCell cell6 = new PdfPCell(tabla7);
                    cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla6.addCell(cell6);

                    cell6 = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tabla6.addCell(cell6);
                    // FIN FIN FINF INF FIN TABLA PARA SEPARAR NOMBRE DEL SELLO
                    //celda de nombre actividad y responsable para la Divicion en dos
                    cell5 = new PdfPCell(tabla6);
                    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell5.setColspan(3);
                    tabla5.addCell(cell5);
                    //FIN FIN FIN FIN FIN FIN TABLA PARA EL COMTROL PRESUPUESTARIO
                    //Celda para Control presupuestario
                    cell = new PdfPCell(tabla5);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(5);
                    table.addCell(cell);


                    //Pie del PDF
                    cell = new PdfPCell(new Paragraph(new Phrase("UNIDAD SOLICITANTE", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(3);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("Sistema de Presupuestos Aquiles", FontFactory.getFont(FontFactory.TIMES_ITALIC, 5))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(2);
                    table.addCell(cell);
                    cell = new PdfPCell(new Paragraph(new Phrase("RESPONSABLE CONTROL", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setColspan(3);
                    table.addCell(cell);
                    table.addCell(cell);
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

        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("presupuestos3/formularios/SolFor4", modelo);
    }
}
