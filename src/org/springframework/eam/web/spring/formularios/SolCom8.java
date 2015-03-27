package org.springframework.eam.web.spring.formularios;

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

import org.springframework.eam.domain.TipoCambio;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.web.spring.calendario.Calendario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolCom8 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        String codtar = request.getParameter("codtar");
        String fecha = request.getParameter("fecha");
        String codacti = request.getParameter("codacti");
        String num_sol = request.getParameter("num_sol");
        String correlativo_unidad = request.getParameter("correlativo_unidad");

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

        /*Tipo de CAmbio*/
        String tipo_cambio = "Boliviano";
        String relacion = "Dolar";
        TipoCambio tcam = new TipoCambio();
        tcam.setDescripcion(tipo_cambio);
        tcam.setRelacion(relacion);
        orm.ejecutarObjeto("tipo_cambio", "un_registro", tcam, tcam);
        //modelo.put("actividad", tare);


        /*Modificando los datos */
        String nit = "";
        String cheque = "";
        String cbte = "";
        String correlativo_orden = "";

        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");

        /*Listado de los correlativos de las certificaciones en proceso*/
        Comprometido moscert = new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        List mont = orm.ejecutarLista("formularios", "muestra_por_tarea", moscert, new Comprometido());
        /*orm.ejecutarObjeto("formularios", "distinto", moscert, moscert);
         modelo.put("dis", moscert);*/
        String destinov = "No";
        String responsable = "No";
        String sw = "0";

        if (mont != null) {
            for (int i = 0; i < mont.size(); i++) {
                Comprometido ki = (Comprometido) mont.get(i);
                destinov = ki.getDestino();
                responsable = ki.getResponsable();
                nit = ki.getNit_proveedor();
                cheque = ki.getCheque();
                cbte = ki.getCbte();
                correlativo_orden = ki.getCorrelativo_orden_compra();
                if (nit.equals("No definido")) {
                    sw = "1";
                }
            }

        }

        ///////////////////////////////////
        int unni = 0, pos = 0, sq = 0;
        double sumf = 0;
        String[] montosf = new String[1000];

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
//                    System.out.print("unir   " + montosf[g]);
//                    System.out.println("    monto  " + montosf[g + 1]);
                    if (montosf[g].equals(kim.getUni())) {
                        sumf = sumf + Double.parseDouble(montosf[g + 1]);
                    }

                }
                //String hj = Double.toString(montosf[i]);
                String suf = Double.toString(sumf);
                kim.setMonto(suf);
//                System.out.println("pppp    :: " + kim.getUni());
                monnt.add(kim);

            }
        }

        //////////////////////////////////

        /*Buscando el proveedor segun el NIT*/
        Comprometido pro = new Comprometido();
        pro.setCodtar(codtar);
        pro.setCorrelativo_unidad(correlativo_unidad);
        pro.setNit_proveedor(nit);
        orm.ejecutarObjeto("beneficiarios_proveedores", "buscar_con_nit", pro, pro);
        modelo.put("pro", pro);

        List suc = orm.ejecutarLista("beneficiarios_proveedores", "todas_sucursales", pro, new Comprometido());
        modelo.put("lis_suc", suc);

        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);
        modelo.put("lista_cert", mont);
        modelo.put("nit", nit);
        modelo.put("sw", sw);
        Calendario calendario = new Calendario();
        String me = calendario.getMonth();
        String di = Integer.toString(calendario.getDayOfMonth());
        String an = Integer.toString(calendario.getYear());
        DatosXml autoridad=new DatosXml();
        autoridad.setDato2("JEFE UNIDAD ADM.DESCONCENTRADA");
        orm.ejecutarObjeto("autoridad", "actual", autoridad, autoridad);
        /*docummento en PDF Orden de compra */
        if (mont_ != null) {

            Document document = new Document(PageSize.LETTER);
            // margenes de hoja (lado derecho, lado izquierdo, arriba, abajo)
            document.setMargins(30, 30, 80, 25);//a,b,c,d,
            try {
                //fecha String aa=fech.getFechahrs().replaceAll(" ", "_");

                String ff = "OrdenCompra" + System.currentTimeMillis() + ".pdf";
                //
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("AQUILESHOME7") + "/pdf/" + ff));
//                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/" + ff));

                Paragraph paragraph = new Paragraph();
                //Chunk space = new Chunk(' ');
                // paragraph.add(space);//estacio

                document.open();

                PdfContentByte cb = writer.getDirectContent();
                BaseFont bf = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                BaseFont cuerp = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

                float[] anchos = {0.03f, 0.09f, 0.10f, 0.6f, 0.14f, 0.14f};
                PdfPTable table = new PdfPTable(anchos);
                table.setWidthPercentage(95);

                /*TABLA PARA LOS ENCABEZADOS*/
                float[] anchos2 = {0.5f, 0.5f};
                PdfPTable tabla2 = new PdfPTable(anchos2);
                PdfPCell cell2 = new PdfPCell(new Paragraph(new Phrase("UNIVERSIDAD MAYOR DE SAN ANDRÉS \n\n"+autoridad.getDato3().toUpperCase()+"\n\n UNIDAD DESCONCENTRADA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla2.addCell(cell2);

                /**/
                float[] anchos3 = {0.65f, 0.35f};
                PdfPTable tabla3 = new PdfPTable(anchos3);

                /*TABLA_4*/
                float[] anchos4 = {0.7f, 0.3f};
                PdfPTable tabla4 = new PdfPTable(anchos4);
                PdfPCell cell4 = new PdfPCell(new Paragraph(new Phrase("ORDEN DE COMPRA\n DE BIENES Y/O SERVICIOS ", FontFactory.getFont(FontFactory.TIMES_BOLD, 12))));
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setColspan(2);
                tabla4.addCell(cell4);

                cell4 = new PdfPCell(new Paragraph(new Phrase("\n\nNro:  " + correlativo_orden, FontFactory.getFont(FontFactory.TIMES_BOLD, 10))));
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setColspan(2);
                tabla4.addCell(cell4);

                /*Celda para la tabla4*/
                PdfPCell cell3 = new PdfPCell(tabla4);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla3.addCell(cell3);
                /*TABLA_5*/
                PdfPTable tabla5 = new PdfPTable(1);
                PdfPCell cell5 = new PdfPCell(new Paragraph(new Phrase("N°", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla5.addCell(cell5);
                cell5 = new PdfPCell(new Paragraph(new Phrase("Tipo de Cambio: " + tcam.getCambio(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla5.addCell(cell5);
                cell5 = new PdfPCell(new Paragraph(new Phrase("Fecha: " + di + "/" + me + "/" + an, FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla5.addCell(cell5);
                cell5 = new PdfPCell(new Paragraph(new Phrase("Nro de Cbte: " + cbte, FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla5.addCell(cell5);
                cell5 = new PdfPCell(new Paragraph(new Phrase("Nro de Cheque: " + cheque, FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla5.addCell(cell5);

                /*celda para la tabla5*/
                cell3 = new PdfPCell(tabla5);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla3.addCell(cell3);
                /*Celda para tabla orden de compra*/
                cell2 = new PdfPCell(tabla3);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla2.addCell(cell2);

                /**/
                cell2 = new PdfPCell(new Paragraph(new Phrase("UNIDAD SOLICITANTE:" + tare.getDescripcion(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla2.addCell(cell2);
                cell2 = new PdfPCell(new Paragraph(new Phrase("Se Adjudica a:\n" + pro.getProveedor(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla2.addCell(cell2);

                cell2 = new PdfPCell(new Paragraph(new Phrase("\nDESTINO: " + destinov, FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla2.addCell(cell2);

                /*tabla11*/
                float[] anchos11 = {0.2f, 0.8f};
                PdfPTable tabla11 = new PdfPTable(anchos11);
                PdfPCell cell11 = new PdfPCell(new Paragraph(new Phrase("NIT", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell11.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tabla11.addCell(cell11);
                cell11 = new PdfPCell(new Paragraph(new Phrase(nit, FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                tabla11.addCell(cell11);

                //mont
                if (suc != null) {
                    for (int i = 0; i < suc.size(); i++) {
                        Comprometido ki = (Comprometido) suc.get(i);
                        cell11 = new PdfPCell(new Paragraph(new Phrase("Sucursal::" + (i + 1), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell11.setHorizontalAlignment(Element.ALIGN_RIGHT);

                        tabla11.addCell(cell11);
                        cell11 = new PdfPCell(new Paragraph(new Phrase(ki.getDireccion() + "\n\nTELEFONOS: " + ki.getTelefonos(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell11.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                        tabla11.addCell(cell11);

                    }
                }
                /*para la tabla 11*/
                cell2 = new PdfPCell(tabla11);
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabla2.addCell(cell2);

                /*TABLA PARA LA CABECERA INICIAL DERACHA*/
                PdfPCell cell = new PdfPCell(tabla2);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(6);
                table.addCell(cell);

                //cell.
            /*Fila 4*/
                cell = new PdfPCell(new Paragraph(new Phrase("N°", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("CANTIDAD", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("UNIDAD DE MEDIDA", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("DESCRIPCIÓN", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                /*TABLA6*/
                PdfPTable tabla6 = new PdfPTable(2);
                PdfPCell cell6 = new PdfPCell(new Paragraph(new Phrase("PRECIO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell6.setColspan(2);
                tabla6.addCell(cell6);

                cell6 = new PdfPCell(new Paragraph(new Phrase("UNITARIO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla6.addCell(cell6);
                cell6 = new PdfPCell(new Paragraph(new Phrase("TOTAL", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla6.addCell(cell6);

                /*Celda para tabla6*/
                cell = new PdfPCell(tabla6);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(2);
                table.addCell(cell);
                /*FOR*/
                double a = 0, b = 0, t = 0, mom = 0;
                int v = 0;
                if (mont_ != null) {
                    for (int i = 0; i < monnt.size(); i++) {
                        Comprometido ki = (Comprometido) monnt.get(i);
                        v++;
                        cell = new PdfPCell(new Paragraph(new Phrase("" + (i + 1), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getCantidad(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getUni_medida(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(ki.getGlosa(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                        table.addCell(cell);
                        a = Double.valueOf(ki.getMonto()).doubleValue();
                        t = t + a;
                        b = Double.valueOf(ki.getCantidad()).doubleValue();
                        cell = new PdfPCell(new Paragraph(new Phrase(df2.format(a / b), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        table.addCell(cell);
                        mom = Double.valueOf(ki.getMonto()).doubleValue();
                        cell = new PdfPCell(new Paragraph(new Phrase(df2.format(mom), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        table.addCell(cell);

                    }

                    if (v < 26) {
                        for (int j = 0; j < (26 - v); j++) {
                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                            table.addCell(cell);
                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            table.addCell(cell);

                            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                            table.addCell(cell);
                        }
                    }
                }
                /*fin fin fin fin fFOR*/

                cell = new PdfPCell(new Paragraph(new Phrase("ELABORADO POR:" + "\n  "
                        + "\n\nAPROBADO POR:"
                        + "\n" + ""
                        + "\n\n\n\n\n\n"+autoridad.getDato1()
                        + "\n"+autoridad.getDato2().toUpperCase()+" DE LA "+autoridad.getDato3().toUpperCase(), FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(3);
                table.addCell(cell);


                /*TABLA7*/
                //float[] anchos7 = {0.7f, 0.3f};
                PdfPTable tabla7 = new PdfPTable(1);


                /*TABLA8*/
                float[] anchos8 = {0.841f, 0.159f};
                PdfPTable tabla8 = new PdfPTable(anchos8);
                PdfPCell cell8 = new PdfPCell(new Paragraph(new Phrase("TOTAL BOLIVIANOS", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla8.addCell(cell8);

                cell8 = new PdfPCell(new Paragraph(new Phrase(df2.format(t), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell8.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tabla8.addCell(cell8);
                /*Celda para la tabla8 */
                PdfPCell cell7 = new PdfPCell(tabla8);
                cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla7.addCell(cell7);

                /*TABLA9*/
                float[] anchos9 = {0.68f, 0.32f};
                PdfPTable tabla9 = new PdfPTable(anchos9);
                PdfPCell cell9 = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n\n\nUNIDAD DESCONCENTRADA FCPN", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla9.addCell(cell9);


                /*TABLA10*/
                PdfPTable tabla10 = new PdfPTable(1);
                PdfPCell cell10 = new PdfPCell(new Paragraph(new Phrase("ADJUDICADO POR:", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla10.addCell(cell10);

                cell10 = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n- " + ""
                        + "\nDECANO "+autoridad.getDato4().toUpperCase()+" RESPONSABLE DEL PROCESO DE CONTRATACIONES", FontFactory.getFont(FontFactory.TIMES_BOLD, 6))));
                cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla10.addCell(cell10);
                /*celda para la tabla10*/
                cell9 = new PdfPCell(tabla10);
                cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla9.addCell(cell9);
                /*CELDA PARA LA TABLA9*/
                cell7 = new PdfPCell(tabla9);
                cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla7.addCell(cell7);
                /*celda para la tabla7*/
                cell = new PdfPCell(tabla7);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(3);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(new Phrase("\n\n\n\n\n\n               Firma Proveedor                        Sello", FontFactory.getFont(FontFactory.TIMES_BOLD, 11))));
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell.setColspan(6);
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

        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("formularios/SolCom8", modelo);
    }
}
