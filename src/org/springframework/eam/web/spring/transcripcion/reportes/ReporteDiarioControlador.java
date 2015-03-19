//_ Reportes
package org.springframework.eam.web.spring.transcripcion.reportes;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.List;
import java.util.Date;
import Ajayu_orm.orm_bd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.logic.EamFacade;

import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import manejodirectorios.DirectorioUsuario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import org.springframework.eam.web.spring.calendario.Calendario;

import java.io.FileOutputStream;
/**
 *
 * @jiwasana
 */
public class ReporteDiarioControlador implements Controller {
    // METODOS PUBLICOS
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
        
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_usuario = (String) request.getSession().getAttribute("__sess_id_usuario");
	Tarjeta reporte = new Tarjeta();
	reporte.setId_usuario(id_usuario);
	Document document = new Document();
	String nombreArchivo = "ReporteDiario"+id_usuario+".pdf";
	PdfWriter.getInstance(document, new FileOutputStream("/opt/tomcat/webapps/cpReportes/reporteDiario/"+nombreArchivo));
	document.open();
	Calendario calendario = new Calendario();
	Font titulo = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
	Font encabezado = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);
	Font cuerpo = new Font(Font.TIMES_ROMAN, 8, Font.NORMAL);
	Image imagen = Image.getInstance("/opt/tomcat/webapps/cp/images/log-reportes.png");
	document.add(imagen);
	document.add(new Paragraph("REPORTE DIARIO", titulo));
	document.add(new Paragraph("FECHA: " + calendario.getDayOfMonth() + "-" + calendario.getMonth() + "-" + calendario.getYear(), titulo));
	document.add(new Paragraph("HORA: " + calendario.getTime(), titulo));
	document.add(new Paragraph("USUARIO: "+id_usuario, titulo));
	List reporteDiario = eam.getListaReporteDiario(reporte);
	int cantidad = reporteDiario.size();
	PdfPTable tabla = new PdfPTable(6);
	tabla.addCell(new PdfPCell(new Paragraph("NUMERO", encabezado)));
	tabla.addCell(new PdfPCell(new Paragraph("TARJETA", encabezado)));
	tabla.addCell(new PdfPCell(new Paragraph("CODIGO", encabezado)));
	tabla.addCell(new PdfPCell(new Paragraph("CEDULA", encabezado)));
	tabla.addCell(new PdfPCell(new Paragraph("OBS. ANVERSO", encabezado)));
	tabla.addCell(new PdfPCell(new Paragraph("OBS. REVERSO", encabezado)));
	for (int i = 0; i < cantidad; i++) {
	    Tarjeta reporteRecorrido = (Tarjeta)reporteDiario.get(i);
	    tabla.addCell(new Paragraph((i+1)+"", cuerpo));
	    tabla.addCell(new Paragraph(reporteRecorrido.getId_tarjeta(), cuerpo));
	    tabla.addCell(new Paragraph(reporteRecorrido.getId_persona(), cuerpo));
	    tabla.addCell(new Paragraph(reporteRecorrido.getCedula(), cuerpo));
	    tabla.addCell(new Paragraph(reporteRecorrido.getComentario_a(), cuerpo));
	    tabla.addCell(new Paragraph(reporteRecorrido.getComentario_r(), cuerpo));
	}
	document.add(new Paragraph("\n\n\n"));
	document.add(tabla);
	document.close();
	response.sendRedirect("/cpReportes/reporteDiario/"+nombreArchivo);
	modelo.put("archivo","/cpReportes/reporteDiario/"+nombreArchivo);
        return new ModelAndView("transcripcion/reportes/ReporteDiario",modelo);
    }

}