package org.springframework.eam.web.spring.ajax;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Departamento;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;
// ajax imports
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.springframework.eam.domain.DatosXml;

public class ConexionControlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //String opcion = request.getParameter("campo");
        //System.out.println("jjjjjjjjjjj   "+ opcion);        
        //
	String key = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_login_key");
	String usuario = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	
	System.out.println("Key >>>>>>>>>> "+key);
	System.out.println("usr >>>>>>>>>> "+usuario);
	Usuarios usr = new Usuarios();
	usr.setId_usuario(usuario);
	if (key.equals(this.eam.getLoginKey(usr)))
	  modelo.put("status","true");
	else
	  modelo.put("status","false");
	  
        
        return new ModelAndView("ajax/Conexion", modelo);
    }
}


        /*
        Element root = new Element("root");
        DatosXml datos = new DatosXml();
        Element nodo=new Element("dato").setText("");
        nodo.setAttribute("respuesta","si");
        root.addContent(nodo);
        Document doc=new Document(root);
        try{
            XMLOutputter out=new XMLOutputter("  ",true);
            String cadena="";
            cadena = out.outputString(doc);
            System.out.println("kvv---> "+cadena.substring(40,cadena.length()));
            modelo.put("datos",cadena.substring(40,cadena.length()));            
        }catch(Exception e){e.printStackTrace();}     
         */    
