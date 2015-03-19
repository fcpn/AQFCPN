package org.springframework.eam.web.spring.transcripcion;

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
import org.springframework.eam.domain.Tarjeta;
import org.springframework.web.util.WebUtils;
// ajax imports
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.springframework.eam.domain.DatosXml;

public class GetBtnSolicitar implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String id_rol = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_rol");
	
	Usuarios user = new Usuarios();
	user.setId_usuario(id_usuario);
	String cod_registro;
	try {
	    cod_registro = (String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");
        } catch(Exception e) {
	    cod_registro = "";
	}
	String estado = this.eam.getEstadoTranscriptor(user);
        modelo.put("id_rol",id_rol);        	
	Tarjeta tar = new Tarjeta();
	if (!cod_registro.equals("") && estado.equals("true")) {
	     tar.setId_tarjeta(cod_registro);
	     tar.setId_usuario(id_usuario);
	     String cod = this.eam.getNombreTarjeta(tar);
	     if (cod_registro.equals(cod)) {
                modelo.put("msgButton","Recargar Tarjeta");
                modelo.put("estado","disabled");
		return new ModelAndView("transcripcion/SolicitarTarjeta",modelo);
             } else {
                modelo.put("msgButton","Solicitar Tarjeta");
                modelo.put("estado","enabled");
	        return new ModelAndView("transcripcion/SolicitarTarjeta",modelo);
	     }		
	     
	} else {      
	    if (estado.equals("true")) {
              modelo.put("msgButton","Solicitar Tarjeta");
              modelo.put("estado","enabled");
	      return new ModelAndView("transcripcion/SolicitarTarjeta", modelo);
	    }
	    else {  
              modelo.put("msgButton","Usuario esta fuera de su horario");
              modelo.put("estado","error");
	      return new ModelAndView("transcripcion/SolicitarTarjeta", modelo);
	    }  
	}     

    }
}

