
package org.springframework.eam.web.spring.formularios;

import Ajayu_orm.orm_bd;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolComAnu implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
       
        String codtar=request.getParameter("codtar");
        String fecha=request.getParameter("fecha");
        String num_sol=request.getParameter("num_sol");
        String correlativo_unidad=request.getParameter("correlativo_unidad");
        modelo.put("num_sol", num_sol);
        String codmonegr=request.getParameter("codmonegr");
        modelo.put("codmonegr", codmonegr);

        String codfuneco=request.getParameter("codfuneco");
        modelo.put("codfuneco", codfuneco);

        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("fecha", fecha);
        String i_e="3";
        modelo.put("codtar", codtar);



        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        /*Sacando la actividad*/

        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
       
        /*Sacando la tarea*/
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        

        /*Listado de los correlativos de las certificaciones en proceso*/
        Comprometido moscert=new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        List mont=orm.ejecutarLista("formularios","muestra_por_tarea",moscert,new Comprometido());
        modelo.put("lista_cert", mont);

        String destinov="No";
        String responsable="No";
        String sw="0";
        // List mont_=new ArrayList();
        if(mont != null) {



              for(int i = 0;i< mont.size();i++) {
                Comprometido ki=(Comprometido) mont.get(i);

                destinov = ki.getDestino();
               responsable = ki.getResponsable();
               
                if(destinov.equals("No definido") || ki.getUni_medida().equals("No definido")){
                    sw="1"; }
              }

        }

        
        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);
         modelo.put("sw", sw);


         //mi PDF
         if(sw.equals("0")){



        Document document = new Document(PageSize.LETTER.rotate());
		// margenes de hoja (lado derecho, lado izquierdo, arriba, abajo)
        document.setMargins(30, 20, 20, 20);//a,b,c,d,

		try {
			
			String ff=correlativo_unidad+codtar+"_"+System.currentTimeMillis()+".pdf";
                        PdfWriter writer= PdfWriter.getInstance(document,new FileOutputStream(System.getenv("AQUILESHOME7")+"/pdf/"+ff));
			Paragraph paragraph = new Paragraph();

                        document.open();
			PdfPTable table = new PdfPTable(3);
			PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
			cell.setColspan(3);
			table.addCell(cell);
			table.addCell("1.1");
			table.addCell("2.1");
			table.addCell("3.1");
			table.addCell("1.2");
			table.addCell("2.2");
			table.addCell("3.2");
			cell = new PdfPCell(new Paragraph("cell test1"));
			cell.setBorderColor(new Color(255, 0, 0));
			table.addCell(cell);
			cell = new PdfPCell(new Paragraph("cell test2"));
			cell.setColspan(2);
			cell.setBackgroundColor(new Color(0xC0, 0xC0, 0xC0));
			table.addCell(cell);
			document.add(table);
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		// step 5: we close the document
		document.close();


}
       // orm.ejecutarObjeto("formularios", "distinto", moscert, moscert);
      //  modelo.put("dis", moscert);

        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("formularios/SolComAnu", modelo);
    }
}