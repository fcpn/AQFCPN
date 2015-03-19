package org.springframework.eam.web.spring.vercuerpo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class VerCuerpoControlador implements Controller {

  private EamFacade eam;

  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();
    String visita;
    String id_rol;
    try {
      id_rol = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_rol");
    } catch (Exception e) {
      id_rol = null;
    }  
    
    if (id_rol == null ){
        visita = "Si";
    }else {
        visita = "No";
    }
    modelo.put("visita", visita);
    return new ModelAndView("IncluyeSubMenuRapido", modelo); //enviar "modelo" a "menu.jsp"
  }
}