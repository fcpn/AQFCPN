package org.springframework.eam.web.spring.transcripcion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Tarjeta;
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

public class Transcripcion3Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
	
	String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String cod_registro =(String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");
        
        String opcion = request.getParameter("campo");
        System.out.println("jjjjjjjjjjj   "+ opcion);
        System.out.println("IMAGEN   "+ cod_registro);
	
	String datos1[] = opcion.split("::");       
	String columna = datos1[0];
	System.out.println("col   "+ columna);
	String dato;
	try {
	  dato = datos1[1];
        } catch(Exception e){
	  dato = "";
	}
	System.out.println("datos   "+ dato);
	
	//String cod_registro = "741-1684";
	        
	Tarjeta datos = new Tarjeta();
	datos.setCod_registro(cod_registro);
        datos.setId_usuario(id_usuario);
        datos.setColumna(columna);
        datos.setDato(dato);
        int rep = this.eam.setDatosTemporal(datos);

        //modelo.put("dato","si";
        return new ModelAndView("transcripcion/Ajax", modelo);
    }
}
