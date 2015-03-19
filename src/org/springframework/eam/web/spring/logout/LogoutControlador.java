package org.springframework.eam.web.spring.logout;

import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.eam.domain.logic.EamFacade;


public class LogoutControlador implements Controller {

  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String id_usuario = (String) request.getSession().getAttribute("__sess_id_usuario");		
    this.eam.setControlarSalida(id_usuario);
    request.getSession().removeAttribute("__sess_gestion_nueva");
    request.getSession().removeAttribute("__sess_periodo_nuevo");
    request.getSession().removeAttribute("__sess_id_rol");
    request.getSession().removeAttribute("__sess_gestion");
    request.getSession().removeAttribute("__sess_periodo");
    request.getSession().removeAttribute("__sess_id_fac");
    request.getSession().removeAttribute("__sess_id_prog");
    request.getSession().removeAttribute("__sess_aplicacion");
    request.getSession().removeAttribute("__sess_programa");
    request.getSession().removeAttribute("__sess_facultad");
    request.getSession().removeAttribute("__sess_dip");
    request.getSession().removeAttribute("__sess_nombres");
    request.getSession().removeAttribute("__sess_id_usuario");
    request.getSession().removeAttribute("__sess_roles");
    request.getSession().removeAttribute("__cod_img");
    request.getSession().invalidate();
    return new ModelAndView("vercabeza/VerCabeza1");
  }
}
