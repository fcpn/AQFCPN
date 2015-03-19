package org.springframework.eam.web.spring.seguridad;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class SeguridadControlador implements Controller {

  private EamFacade eam;

  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();
        
    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String nombres    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_nombres");
    String programa   = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String gestion = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_gestion");
    String periodo = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_periodo");

    modelo.put("id_usuario", id_usuario);
    modelo.put("nombres", nombres);
    modelo.put("programa", programa);
    modelo.put("gestion", gestion);
    modelo.put("periodo", periodo);

    return new ModelAndView("seguridad/Seguridad", modelo);
  }
}
