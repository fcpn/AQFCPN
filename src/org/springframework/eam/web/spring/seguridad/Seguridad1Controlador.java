package org.springframework.eam.web.spring.seguridad;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class Seguridad1Controlador implements Controller {

  private EamFacade eam;

  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();
        
    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String nombres    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_nombres");
    String id_programa= (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String programa   = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String gestion    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_gestion");
    String periodo    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_periodo");

    String clave    = request.getParameter("clave");
    String destino  = request.getParameter("destino");
    String titulo   = request.getParameter("titulo");

    modelo.put("id_usuario", id_usuario);
    modelo.put("nombres", nombres);
    modelo.put("programa", programa);
    modelo.put("gestion", gestion);
    modelo.put("periodo", periodo);

    modelo.put("destino", destino);
    modelo.put("titulo", titulo);

    if(clave.equals(""))  {
	modelo.put("mensaje","Debe ser llenado el campo Clave");
       return new ModelAndView("seguridad/Seguridad", modelo);    
    }

    List listita = this.eam.getUsuarioClave(id_programa,id_usuario,clave);

    if(listita.size()==0){
       modelo.put("mensaje","La Clave No es valida");
       return new ModelAndView("seguridad/Seguridad", modelo);    
    }
    modelo.put("acceso","SI");
    return new ModelAndView("seguridad/blanco", modelo);
  }
}
