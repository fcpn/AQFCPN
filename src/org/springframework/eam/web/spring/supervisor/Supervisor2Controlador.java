package org.springframework.eam.web.spring.supervisor;

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


public class Supervisor2Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
	String id_tarjeta = request.getParameter("id_tarjeta");
	String id_estado = request.getParameter("id_estado");
	String id_usuario = request.getParameter("id_usuario");
	Tarjeta tarjeta = new Tarjeta();
	tarjeta.setId_tarjeta(id_tarjeta);
	tarjeta.setId_estado(id_estado);
	this.eam.setModificarEstadoTarjeta(tarjeta);
	response.sendRedirect("supervisor1.do?id_usuario="+id_usuario);
        return new ModelAndView("supervisor/Supervisor1", modelo);
    }
}