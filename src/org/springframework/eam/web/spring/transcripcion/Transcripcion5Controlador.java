package org.springframework.eam.web.spring.transcripcion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.util.WebUtils;

public class Transcripcion5Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        String opcion = request.getParameter("transcripcion");        
        modelo.put("mensaje","hola transcriptor...");
	/*
        int sw;
        try {
            sw = this.mi.getRespuesta();
        } catch(Exception e){
            sw=0;
        }
        if (sw==0)
            modelo.put("c","No Conectado");
        else
            modelo.put("c","Conectado");
        try {
	  
	} catch(Exception e){
	  
        }	
   */   
	//_ reportes
	String id_usuario = (String)WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
	Tarjeta user = new Tarjeta();
	user.setId_usuario(id_usuario);
	PagedListHolder listaReporteTotal = new PagedListHolder(this.eam.getListaReporteTotal(user));
	listaReporteTotal.setPageSize(listaReporteTotal.getNrOfElements());
	modelo.put("listaReporteTotal", listaReporteTotal);
	//Fin _ reportes
   
   
	if (opcion != null) {
           System.out.println("kkkkkkk "+opcion);
	   if (opcion.equals("transcripcion"))
	     return new ModelAndView("transcripcion/TranscripcionEntrada4", modelo);
        }

        return new ModelAndView("transcripcion/TranscripcionEntrada4", modelo);
        
    }
}