package org.springframework.eam.web.spring.vercabeza;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class VerCabeza1Controlador implements Controller {
        
  private EamFacade eam;

  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();
    String id_rol = (String) request.getSession().getAttribute("__sess_id_rol");
    String id_rolnuevo;
    id_rolnuevo = request.getParameter("id_rol");
    if (id_rolnuevo != null){
    
      if (id_rol == id_rolnuevo) {
          return new ModelAndView("vercabeza/VerCabeza");
        } else {
          request.getSession().removeAttribute("__sess_id_rol");
          request.getSession().setAttribute("__sess_id_rol", id_rolnuevo);
        }
    }
    return new ModelAndView("vercabeza/VerCabeza1", modelo);
  }
}