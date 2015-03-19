
package org.springframework.eam.web.spring.administrarpersonas;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.eam.domain.Personas;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.util.WebUtils;

public class RegistrarPersona_Jes implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

      String nombres = request.getParameter("nombres");
      String paterno = request.getParameter("paterno");
      String materno = request.getParameter("materno");
      String dip = request.getParameter("dip");
      String id_sexo = request.getParameter("id_sexo");
      String direccion = request.getParameter("direccion");
      String telefono = request.getParameter("telefono");
      String correo = request.getParameter("correo");
      String ruta = request.getParameter("ruta");
   
          Personas persona = new Personas();
          persona.setId_sexo("M");
          persona.setCorreo("@");
          modelo.put("per",persona);
          return new ModelAndView("administrarusuarios/RegistrarPersona_Jes", modelo);

  }
}