package org.springframework.eam.web.spring.verificacion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Reporte;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.util.WebUtils;

public class Transcripcion7Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String cod_registro =(String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");
        
	String opcion = request.getParameter("transcripcion");        
        modelo.put("mensaje","hola transcriptor...");
	
	
	
	Tarjeta datos = new Tarjeta();
	datos.setId_tarjeta(cod_registro);
	datos.setId_usuario(id_usuario);
	
	
	
	
	Tarjeta tarjeta = new Tarjeta();
	
	tarjeta = (Tarjeta) this.eam.getTarjeta(datos);
	tarjeta.setOcupaciones(this.eam.getOcupaciones(datos));
	tarjeta.setParientes(this.eam.getParientes(datos));
	tarjeta.setRelaciones(this.eam.getRelaciones(datos));
	tarjeta.setTramites(this.eam.getTramites(datos));
	//tarjeta.setRegistro_civil(this.mi.getRegistro_civil(datos));
        modelo.put("tarjeta",tarjeta);
	

        return new ModelAndView("transcripcion/TranscripcionEntrada4", modelo);
        
    }
}