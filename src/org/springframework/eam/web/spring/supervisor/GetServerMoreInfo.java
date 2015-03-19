//_ Castillo Valencia
package org.springframework.eam.web.spring.supervisor;

import java.util.*;
import java.lang.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Servidor;
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



public class GetServerMoreInfo implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String id_usuario  = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
	
	String id_servidor = request.getParameter("id_servidor");
	
            orm_bd orm = new orm_bd();
            Servidor srv = new Servidor();
	    srv.setId_servidor(id_servidor);
	    srv = this.eam.getServidor(srv);
            String strsource = "jdbc:postgresql://"+srv.getIp()+":"+srv.getPuerto()+"/imagenesdb";
            orm.establecerConexion(strsource+";"+srv.getUsuario()+";"+srv.getPassword()+";");
            
	    Servidor srvaux = new Servidor();	    
            List cajas = orm.ejecutarLista("imagenes","get_cajas_servidor",null,new Servidor());
	    
            Element root = new Element("root");
            Element nodo;// = new Element("dato").setText(id_servidor);
	    for (int i=0; i < cajas.size(); i++) {
	        Servidor s = (Servidor) cajas.get(i); 
		s.setId_servidor(id_servidor);
		this.eam.setCajaServidor(s);
	        nodo = new Element("dato").setText("");
		nodo.setAttribute("caja",s.getCaja());
	     	nodo.setAttribute("total",Integer.toString(s.getTotal()));
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
	    	    
            return new ModelAndView("supervisor/Servidor", modelo);        
       }
}