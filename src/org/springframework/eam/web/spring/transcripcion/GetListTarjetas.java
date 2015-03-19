//_ Castillo Valencia
package org.springframework.eam.web.spring.transcripcion;

import java.util.*;
import java.lang.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;
import Ajayu_orm.orm_bd;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.web.spring.supervisor.CreatePie;
import org.springframework.web.util.WebUtils;

import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;



public class GetListTarjetas implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String id_usuario  = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");	
	
	     //_ reportes
    	     Tarjeta user = new Tarjeta();
	     user.setId_usuario(id_usuario);
    	     List listaReporteDiario = this.eam.getListaReporteDiario(user);

    	     //modelo.put("listaReporteDiario", listaReporteDiario);
	     //Fin _ reportes
		
            Element root = new Element("root");
            Element nodo;// = new Element("dato").setText(id_servidor);
	    for (int i=0; i < listaReporteDiario.size(); i++) {
	        Tarjeta s = (Tarjeta) listaReporteDiario.get(i); 
	        nodo = new Element("dato").setText("");
		nodo.setAttribute("id_tarjeta",s.getId_tarjeta());
		nodo.setAttribute("id_persona",s.getId_persona());
		nodo.setAttribute("cedula",s.getCedula());
		nodo.setAttribute("comentario_a",s.getComentario_a());
		nodo.setAttribute("comentario_r",s.getComentario_r());
                root.addContent(nodo);
	    }
            
            Document doc=new Document(root);//Creamos el documento
            try {
              XMLOutputter out=new XMLOutputter("  ",true);
    	      String cadena="";
              cadena = out.outputString(doc);
              //System.out.println("jjjj    "+cadena.substring(40,cadena.length()));
              modelo.put("datos",cadena.substring(40,cadena.length()));       
            } catch (Exception e) { e.printStackTrace(); }
	    	    
            return new ModelAndView("transcripcion/ReporteDiario", modelo);        
       }
}