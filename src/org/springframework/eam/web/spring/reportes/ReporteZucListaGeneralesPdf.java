package org.springframework.eam.web.spring.reportes;

import Ajayu_orm.orm_bd;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class ReporteZucListaGeneralesPdf implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        orm_bd orm = new orm_bd();
        orm.verCompilado = "C";
        mconexion m = new mconexion();
        orm.establecerConexion(m.extraerConexion("url1"));
        carreras car = new carreras();
        car.setIdcarrera(id_usuario);

        DecimalFormat formatonumber = new DecimalFormat("#,###,###,##0.00");
        //Listado de fuentes fin USUARIO
        List lista_fuentes_financiamiento = eam.getFuentesDeTareasByUsuario(car);

        //Lista de Todas DE ACTIVIDADADES de USUARIO
        /////////////PDF
        // 72f  -->   1in  //    1 in --->  2.54 cm
        // oficio= 21.59 cm       x = 8.5 in      x = 612f
        // oficio= 33 cm          y = 12.99 in    y = 935.43f
        Rectangle pagesize;
        if (lista_fuentes_financiamiento.size() <= 3) {
            pagesize = new Rectangle(612f, 935.43f);
        } else {
            pagesize = new Rectangle(612f, 1417.33f);
        }
        int cvv = lista_fuentes_financiamiento.size();
        String V[] = new String[((cvv * 4) + 3 + 4)];
//        Document document = new Document(PageSize.LEGAL.rotate());
        int cfilv = 0;
        Document document = new Document(pagesize.rotate());
        Calendar cal = Calendar.getInstance();
        String anio = cal.get(Calendar.YEAR) + "";
        String mes = "";
        String dia = "";
        String hrs = cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE);

        if (cal.get(Calendar.MONTH) < 10) {
            mes = "0" + (cal.get(Calendar.MONTH) + 1);
        } else {
            mes = "" + (cal.get(Calendar.MONTH) + 1);
        }
        if (cal.get(Calendar.DAY_OF_MONTH) < 10) {
            dia = "0" + cal.get(Calendar.DAY_OF_MONTH);
        } else {
            dia = "" + cal.get(Calendar.DAY_OF_MONTH);
        }
        document.setMargins(10, 10, 10, 10);//a,b,c,d,
        int nroFilasTareas = 1;
        String nameFile = "rgenextendido" + System.currentTimeMillis() + ".pdf";
        try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("AQUILESHOME7") + "/pdf/" + nameFile));
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/" + nameFile));
            document.open();

            float[] anchosCabecera = {0.3f, 0.1f, 0.3f, 0.3f};
            PdfPTable tablaCabecera = new PdfPTable(anchosCabecera);
            PdfPCell c = new PdfPCell(new Paragraph(new Phrase("UNIVERSIDAD MAYOR DE SAN ANDRÉS", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            c.setBorder(0);
            c.setColspan(3);
            c.setHorizontalAlignment(Element.ALIGN_LEFT);
            tablaCabecera.addCell(c);
            c = new PdfPCell(new Paragraph(new Phrase(dia + "-" + mes + "-" + anio + "  " + hrs, FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            c.setBorder(0);
            c.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaCabecera.addCell(c);

            c = new PdfPCell(new Paragraph(new Phrase("SISTEMA DE PRESUPUESTOS AQUILES FCPN", FontFactory.getFont(FontFactory.TIMES_BOLD, 5))));
            c.setBorder(0);
            c.setColspan(4);
            c.setHorizontalAlignment(Element.ALIGN_LEFT);
            tablaCabecera.addCell(c);

            c = new PdfPCell(new Paragraph(new Phrase("REPORTE \n CAJA Y BANCOS \n  \n ", FontFactory.getFont(FontFactory.TIMES_BOLD, 10))));
            c.setBorder(0);
            c.setColspan(4);
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaCabecera.addCell(c);

            float[] anchosTfuentes = {0.05f, 0.3f, 0.65f};
            PdfPTable tablaDescripcionFuentes = new PdfPTable(anchosTfuentes);
            PdfPCell cf = new PdfPCell(new Paragraph(new Phrase("FUENTES DE FINANCIAMIENTO", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cf.setColspan(2);
            cf.setBackgroundColor(Color.LIGHT_GRAY);
            cf.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDescripcionFuentes.addCell(cf);
            cf = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cf.setBorder(0);
            tablaDescripcionFuentes.addCell(cf);

            cf = new PdfPCell(new Paragraph(new Phrase("Código", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cf.setHorizontalAlignment(Element.ALIGN_CENTER);
            cf.setBackgroundColor(Color.LIGHT_GRAY);
            tablaDescripcionFuentes.addCell(cf);
            cf = new PdfPCell(new Paragraph(new Phrase("Descripción", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cf.setHorizontalAlignment(Element.ALIGN_CENTER);
            cf.setBackgroundColor(Color.LIGHT_GRAY);
            tablaDescripcionFuentes.addCell(cf);
            cf = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cf.setBorder(0);
            tablaDescripcionFuentes.addCell(cf);

            for (int ff = 0; ff < lista_fuentes_financiamiento.size(); ff++) {
                FuenteEconomica fuente = (FuenteEconomica) lista_fuentes_financiamiento.get(ff);

                cf = new PdfPCell(new Paragraph(new Phrase(fuente.getCodfueneco() + " " + fuente.getAcro(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                cf.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaDescripcionFuentes.addCell(cf);
                cf = new PdfPCell(new Paragraph(new Phrase(fuente.getDescripcion(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                cf.setHorizontalAlignment(Element.ALIGN_LEFT);
                tablaDescripcionFuentes.addCell(cf);
                cf = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cf.setBorder(0);
                tablaDescripcionFuentes.addCell(cf);
            }

            int columnasFuentes = lista_fuentes_financiamiento.size();
            float anchosColumnasFuentes = 0;

            float anchoNro;
            float anchoCodtar;
            float anchoDescripcion;
            float anchoSobrante;
            if (columnasFuentes > 3) {
                anchoNro = 0.01f;
                anchoCodtar = 0.04f;
                anchoDescripcion = 0.17f;
                anchoSobrante = 0.79f;
            } else {
                anchoNro = 0.03f;
                anchoCodtar = 0.05f;
                anchoDescripcion = 0.12f;
                anchoSobrante = 0.8f;
            }

            anchosColumnasFuentes = (anchoSobrante / ((columnasFuentes * 4) + 4));  // el +1 es por el TOTAL

            // este vector solo saca la cantidad de columnas OK
            float[] anchos = new float[(columnasFuentes * 4) + 3 + 4]; //+3 por las 3 primeras columnas   0 1 2    +1 po la columna TOTAL
            anchos[0] = anchoNro;
            anchos[1] = anchoCodtar;
            anchos[2] = anchoDescripcion;

            int columnasTotal = (columnasFuentes * 4) + 3 + 4;

            for (int clm = 3; clm < columnasTotal; clm++) {
                anchos[clm] = anchosColumnasFuentes;
            }

            PdfPTable tabla = new PdfPTable(anchos);
            tabla.setWidthPercentage(98);

            PdfPCell cell = new PdfPCell(tablaCabecera); // TABLA CABECERA
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(columnasTotal + 3);
            tabla.addCell(cell);

            cell = new PdfPCell(tablaDescripcionFuentes); // TABLA FUENTES FINANCIEMIENTO
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan(columnasTotal);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Phrase(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(columnasTotal);
            tabla.addCell(cell);
            //listado de actividades

            List lista_actividades_usuario = eam.getActividadesByUsuario(car);
            String M2[][] = new String[1000][1000];
            int cm2 = 0;
            int swm = 0;
//            int cantidad_actividades = lista_actividades_usuario.size();
            for (int act = 0; act < lista_actividades_usuario.size(); act++) {
                //Definiendo matris de DATOS para TAREA

                ProActTar actividad = (ProActTar) lista_actividades_usuario.get(act);
                String M[][] = new String[1000][1000];
                int fila = 0;
                int columna = 0;

                cell = new PdfPCell(new Paragraph(new Phrase(actividad.getCodacti() + " - " + actividad.getDescripcion(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 9))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(columnasTotal);
                cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
//                cell.setGrayFill(1.5f);
                tabla.addCell(cell);
//                //cabeceras de Descricion Tarea y Fuentes
                cell = new PdfPCell(new Paragraph(new Phrase("N.", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("Tarea.", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tabla.addCell(cell);
                cell = new PdfPCell(new Paragraph(new Phrase("Descripcion.", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                tabla.addCell(cell);
                // Para cabeces de Fuentes
                columna = 3;
                for (int ff = 0; ff < columnasFuentes; ff++) {
                    FuenteEconomica fuente = (FuenteEconomica) lista_fuentes_financiamiento.get(ff);
                    M[0][columna] = fuente.getCodfueneco();

                    if (swm == 0 && ff == 0) {
                        M2[0][columna] = fuente.getCodfueneco();
                        cm2 = columna + 4;
                        swm++;
                    }
                    columna = columna + 4;

                    PdfPTable tablaFuentesInt = new PdfPTable(4);
                    PdfPCell cfint = new PdfPCell(new Paragraph(new Phrase(fuente.getCodfueneco() + " " + fuente.getAcro(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cfint.setColspan(4);
                    cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                    cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tablaFuentesInt.addCell(cfint);

                    cfint = new PdfPCell(new Paragraph(new Phrase("Ingreso", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                    tablaFuentesInt.addCell(cfint);

                    cfint = new PdfPCell(new Paragraph(new Phrase("Gasto ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                    tablaFuentesInt.addCell(cfint);

                    cfint = new PdfPCell(new Paragraph(new Phrase("Saldo", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                    cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tablaFuentesInt.addCell(cfint);

                    cfint = new PdfPCell(new Paragraph(new Phrase("% Ejec.", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                    cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.85f));
                    cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tablaFuentesInt.addCell(cfint);

                    cell = new PdfPCell(tablaFuentesInt);
                    cell.setColspan(4);
                    tabla.addCell(cell);
                }

                PdfPTable tablaTotal = new PdfPTable(4);
                PdfPCell ctf = new PdfPCell(new Paragraph(new Phrase("TOTALES", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                ctf.setColspan(4);
                ctf.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.7f));
                ctf.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaTotal.addCell(ctf);

                ctf = new PdfPCell(new Paragraph(new Phrase("Total Ingreso", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                ctf.setHorizontalAlignment(Element.ALIGN_CENTER);
                ctf.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.7f));
                tablaTotal.addCell(ctf);

                ctf = new PdfPCell(new Paragraph(new Phrase("Total Gasto ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                ctf.setHorizontalAlignment(Element.ALIGN_CENTER);
                ctf.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.7f));
                tablaTotal.addCell(ctf);

                ctf = new PdfPCell(new Paragraph(new Phrase("Total Saldo", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                ctf.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.7f));
                ctf.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaTotal.addCell(ctf);

                ctf = new PdfPCell(new Paragraph(new Phrase("Total % Ejec.", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                ctf.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.7f));
                ctf.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaTotal.addCell(ctf);

                cell = new PdfPCell(tablaTotal);
                cell.setColspan(4);
                tabla.addCell(cell);
                fila++;
                car.setCodacti(actividad.getCodacti());
                List lista_tareas_usuario = eam.getTareasByUsuarioAndActividad(car);
                for (int j = 0; j < lista_tareas_usuario.size(); j++) {
                    ProActTar tarea = (ProActTar) lista_tareas_usuario.get(j);
                    M[fila][0] = nroFilasTareas + "";
                    nroFilasTareas++;
                    M[fila][1] = tarea.getCodtar();
                    M[fila][2] = tarea.getDescripcion();
                    List lista_fuentes_tarea = eam.getFuentesAndMontosEjecutadosByTarea(tarea);
                    Double totalFilaIngreso = 0d;
                    Double totalFilaEgreso = 0d;
                    Double totalFilaDisponible = 0d;
                    for (int ime = 0; ime < lista_fuentes_tarea.size(); ime++) {
                        ProActTar fuentemontos = (ProActTar) lista_fuentes_tarea.get(ime);
                        for (int cma = 3; cma < (columnasTotal - 4); cma = cma + 4) {
                            if (M[0][cma].equals(fuentemontos.getCodfueneco())) {
                                if (cfilv == 0) {
                                    V[cfilv] = fuentemontos.getCodfueneco();
                                    V[cfilv + 1] = fuentemontos.getTotalmontoejecutadoingreso() + "";
                                    V[cfilv + 2] = fuentemontos.getTotalmontoejecutadoegreso() + "";
                                    cfilv = cfilv + 3;
                                } else {
                                    int sw = 0;
                                    for (int cnv = 0; cnv < cfilv; cnv = cnv + 3) {
                                        if (V[cnv].equals(fuentemontos.getCodfueneco())) {
                                            V[cnv + 1] = (Double.parseDouble(V[cnv + 1]) + fuentemontos.getTotalmontoejecutadoingreso()) + "";
                                            V[cnv + 2] = (Double.parseDouble(V[cnv + 2]) + fuentemontos.getTotalmontoejecutadoegreso()) + "";
                                            cnv = cfilv;
                                            sw++;
                                        }
                                    }
                                    if (sw == 0) {
                                        V[cfilv] = fuentemontos.getCodfueneco();
                                        V[cfilv + 1] = fuentemontos.getTotalmontoejecutadoingreso() + "";
                                        V[cfilv + 2] = fuentemontos.getTotalmontoejecutadoegreso() + "";
                                        cfilv = cfilv + 3;
                                    }
                                }

                                M[fila][cma] = formatonumber.format(fuentemontos.getTotalmontoejecutadoingreso()) + "";
                                M[fila][cma + 1] = formatonumber.format(fuentemontos.getTotalmontoejecutadoegreso()) + "";
                                M[fila][cma + 2] = formatonumber.format(fuentemontos.getTotalmontoejecutadoingreso() - fuentemontos.getTotalmontoejecutadoegreso()) + "";
                                if (fuentemontos.getTotalmontoejecutadoingreso() == 0) {
                                    M[fila][cma + 3] = formatonumber.format(0);
                                } else {
                                    M[fila][cma + 3] = formatonumber.format((fuentemontos.getTotalmontoejecutadoegreso() / fuentemontos.getTotalmontoejecutadoingreso()) * 100) + "";
                                }
                                totalFilaIngreso += fuentemontos.getTotalmontoejecutadoingreso();
                                totalFilaEgreso += fuentemontos.getTotalmontoejecutadoegreso();
                                totalFilaDisponible += fuentemontos.getTotalmontoejecutadoingreso() - fuentemontos.getTotalmontoejecutadoegreso();
                            } else {
                                if (M[fila][cma] == null) {
                                    M[fila][cma] = "-";
                                    M[fila][cma + 1] = "-";
                                    M[fila][cma + 2] = "-";
                                    M[fila][cma + 3] = "-";
                                }
                            }
                        }
                    }
                    M[fila][columnasTotal - 4] = formatonumber.format(totalFilaIngreso) + "";//formatonumber.format(totalFilaIngreso) + "";
                    M[fila][columnasTotal - 3] = formatonumber.format(totalFilaEgreso) + "";
                    M[fila][columnasTotal - 2] = formatonumber.format(totalFilaDisponible) + "";
                    if (totalFilaIngreso == 0) {
                        M[fila][columnasTotal - 1] = formatonumber.format(0) + "";
                    } else {
                        M[fila][columnasTotal - 1] = formatonumber.format((totalFilaEgreso / totalFilaIngreso) * 100) + "";
                    }
                    fila++;
                }
                for (int imcc = 1; imcc < fila; imcc++) {
                    float ccf = 0.959f;
                    if (imcc % 2 == 1) {
                        ccf = 0f;
                    }
                    for (int cca = 0; cca < columnasTotal; cca++) {
                        if (cca == 0 || cca == 1) {
                            cell = new PdfPCell(new Paragraph(new Phrase(M[imcc][cca], FontFactory.getFont(FontFactory.TIMES_ROMAN, 6))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell.setGrayFill(ccf);
                            tabla.addCell(cell);
                        }
                        if (cca == 2) {
                            if (M[imcc][cca] != null) {
                                cell = new PdfPCell(new Paragraph(new Phrase(MayusculaPrimera(M[imcc][cca].toLowerCase()), FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                                cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                                cell.setGrayFill(ccf);
                                tabla.addCell(cell);
                            } else {
                                cell = new PdfPCell(new Paragraph(new Phrase(M[imcc][cca], FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                                cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                                cell.setGrayFill(ccf);
                                tabla.addCell(cell);
                            }
                        }
                        if (cca > 2) {

                            if (cca >= (columnasTotal - 4)) {
                                cell = new PdfPCell(new Paragraph(new Phrase(M[imcc][cca], FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                                cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.9f));
//                                cell.setGrayFill(ccf);
                                tabla.addCell(cell);
                            } else {
                                cell = new PdfPCell(new Paragraph(new Phrase(M[imcc][cca], FontFactory.getFont(FontFactory.TIMES_ROMAN, 7))));
                                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                                cell.setGrayFill(ccf);
                                tabla.addCell(cell);
                            }

                            //
                        }
                    }
                }
                //Una vez llenada las matriz
                // cargar al PDF
                //Cargado de cada tarea con su fuente
            }

            //ULTIMA FILA TOTALES GENERALES
            cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(((lista_fuentes_financiamiento.size() * 4) + 3 + 4));
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Phrase("TOTAL GRAL.", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(((lista_fuentes_financiamiento.size() * 4) + 3 + 4));
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(3);
            tabla.addCell(cell);

            for (int fff = 0; fff < lista_fuentes_financiamiento.size(); fff++) {
                FuenteEconomica fuente = (FuenteEconomica) lista_fuentes_financiamiento.get(fff);

                PdfPTable tablaFuentesInt = new PdfPTable(4);
                PdfPCell cfint = new PdfPCell(new Paragraph(new Phrase(fuente.getCodfueneco() + " " + fuente.getAcro(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cfint.setColspan(4);
                cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.75f));
                cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaFuentesInt.addCell(cfint);

                cfint = new PdfPCell(new Paragraph(new Phrase("Ingreso", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.75f));
                tablaFuentesInt.addCell(cfint);

                cfint = new PdfPCell(new Paragraph(new Phrase("Gasto ", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.75f));
                tablaFuentesInt.addCell(cfint);

                cfint = new PdfPCell(new Paragraph(new Phrase("Saldo", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.75f));
                cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaFuentesInt.addCell(cfint);

                cfint = new PdfPCell(new Paragraph(new Phrase("% Ejec.", FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                cfint.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.75f));
                cfint.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaFuentesInt.addCell(cfint);

                cell = new PdfPCell(tablaFuentesInt);
                cell.setColspan(4);
                tabla.addCell(cell);
            }

            cell = new PdfPCell(new Paragraph(new Phrase("Gral. Ingreso", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            tabla.addCell(cell);
            cell = new PdfPCell(new Paragraph(new Phrase("Gral. Gasto", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            tabla.addCell(cell);
            cell = new PdfPCell(new Paragraph(new Phrase("Gral. Saldo", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            tabla.addCell(cell);
            cell = new PdfPCell(new Paragraph(new Phrase("Total % Gral", FontFactory.getFont(FontFactory.TIMES_BOLD, 8))));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Phrase("", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8))));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setColspan(3);
            tabla.addCell(cell);
            double totIngreso = 0d;
            double totEgreso = 0d;
            for (int fff = 0; fff < lista_fuentes_financiamiento.size(); fff++) {
                FuenteEconomica fuente = (FuenteEconomica) lista_fuentes_financiamiento.get(fff);
                for (int fcv = 0; fcv < cfilv; fcv = fcv + 3) {
                    if (fuente.getCodfueneco().equals(V[fcv])) {
                        cell = new PdfPCell(new Paragraph(new Phrase(formatonumber.format(Double.parseDouble(V[fcv + 1])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.83f));
                        tabla.addCell(cell);
                        totIngreso += Double.parseDouble(V[fcv + 1]);

                        cell = new PdfPCell(new Paragraph(new Phrase(formatonumber.format(Double.parseDouble(V[fcv + 2])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.83f));
                        tabla.addCell(cell);

                        totEgreso += Double.parseDouble(V[fcv + 2]);

                        cell = new PdfPCell(new Paragraph(new Phrase(formatonumber.format(Double.parseDouble(V[fcv + 1]) - Double.parseDouble(V[fcv + 2])), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.83f));
                        tabla.addCell(cell);

                        cell = new PdfPCell(new Paragraph(new Phrase(formatonumber.format((Double.parseDouble(V[fcv + 2]) / Double.parseDouble(V[fcv + 1]) * 100)), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
                        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                        cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.83f));
                        tabla.addCell(cell);
                        fcv = cfilv;

                    }
                }
            }

            cell = new PdfPCell(new Paragraph(new Phrase(formatonumber.format(totIngreso), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.87f));
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Phrase(formatonumber.format(totEgreso), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.87f));
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Phrase(formatonumber.format(totIngreso - totEgreso), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.87f));
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(new Phrase(formatonumber.format((totEgreso / totIngreso) * 100), FontFactory.getFont(FontFactory.TIMES_BOLD, 7))));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setBackgroundColor(Color.getHSBColor(0.0f, 0.0f, 0.87f));
            tabla.addCell(cell);

            tabla.setHeaderRows(3);
            document.add(tabla);

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
        modelo.put("namefile", nameFile);
        //FIN PDF PDF PDF
//        modelo.put("M", M);
//        modelo.put("fi", (fi - 1));
//        int columnas = 3 + lista_fuentes_financiamiento.size();
//        modelo.put("co", columnas);
//        modelo.put("fuentesusuario", lista_fuentes_financiamiento);
        return new ModelAndView("presupuestos3/carreras/ReporteZucListaGeneralesPdf", modelo);
//        return null;
    }

    private String MayusculaPrimera(String strg) {
        if (strg.length() == 0) {
            return "";
        }
        char[] caracteres = (strg.toLowerCase()).toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);
        return new String(caracteres);
    }
}
