package org.springframework.eam.web.spring.verificacion;

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

public class SetProfesion implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String cod_registro =(String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");


        String cod_grp = request.getParameter("cod_grp");
        String sw = request.getParameter("sw");

        
	Personas profesion = new Personas();
	profesion.setDip(cod_registro);
	profesion.setCod_grp(cod_grp);
	profesion.setUlt_usuario(id_usuario);
	if (sw.equals("add")) {
	   profesion.setDescripcion("add");
	   modelo.put("lstProfesiones",this.eam.getListaGrupo(profesion));
	}else if (sw.equals("less")) {
	   profesion.setDescripcion("less");
	   modelo.put("lstProfesiones",this.eam.getListaGrupo(profesion));
	}
	
        return new ModelAndView("transcripcion/Profesiones", modelo);
    }
}


