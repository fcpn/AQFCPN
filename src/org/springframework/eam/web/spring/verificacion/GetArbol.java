package org.springframework.eam.web.spring.verificacion;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


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
import org.springframework.eam.domain.Tarjeta;
import org.springframework.web.util.WebUtils;
// ajax imports
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.springframework.eam.domain.DatosXml;

public class GetArbol implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	//String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	//String cod_registro =(String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");


        String dato = request.getParameter("dato");
	String grp1 = request.getParameter("grp1");
	String grp2 = request.getParameter("grp2");
	String grp3 = request.getParameter("grp3");
	String grp4 = request.getParameter("grp4");
	String grp5 = request.getParameter("grp5");
       
        System.out.println("los nombre de dato es:"+ dato);        
        System.out.println("los nombre de valor es:"+ grp1);        
        System.out.println("los nombre de valor es:"+ grp2);        
        System.out.println("los nombre de valor es:"+ grp3);        
        System.out.println("los nombre de valor es:"+ grp4);        
        System.out.println("los nombre de valor es:"+ grp5);        
	List listagrupo = new ArrayList();
	Personas parametro = new Personas();
//	parametro.setCod_grp(valor);
	if (dato.equals("g1")) {
	   parametro.setDescripcion("getG2");
	   parametro.setCod_grp1(grp1);
	   listagrupo = this.eam.getListaGrupo(parametro);   
	   //modelo.put("destino","g3");
	} else if(dato.equals("g2")) {	
	   parametro.setDescripcion("getG3");
	   parametro.setCod_grp1(grp1);
	   parametro.setCod_grp2(grp2);
	   listagrupo = this.eam.getListaGrupo(parametro);   
	   ///modelo.put("destino","g4");
	} else if(dato.equals("g3")) {  
	   parametro.setDescripcion("getG4");
	   parametro.setCod_grp1(grp1);
	   parametro.setCod_grp2(grp2);
	   parametro.setCod_grp3(grp3);
	   listagrupo = this.eam.getListaGrupo(parametro);   
	   //modelo.put("destino","g5");
	} else if(dato.equals("g4")) { 
	   parametro.setDescripcion("getG5");
	   parametro.setCod_grp1(grp1);
	   parametro.setCod_grp2(grp2);
	   parametro.setCod_grp3(grp3);
	   parametro.setCod_grp4(grp4);
	   listagrupo = this.eam.getListaGrupo(parametro);   
	   //modelo.put("destino","none");
	}
	
	
        System.out.println("al tamanio de la lista es:"+Integer.toString(listagrupo.size()));        
	
	//for(int i=0; i <= listagrupo.lenght; i++)
	    
	modelo.put("listagrupo",listagrupo);
	//modelo.put("dato",dato);
	
        	

        return new ModelAndView("transcripcion/Resultado", modelo);
    }
}


