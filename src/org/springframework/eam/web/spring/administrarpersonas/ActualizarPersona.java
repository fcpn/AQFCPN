
package org.springframework.eam.web.spring.administrarpersonas;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.List;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.Personas;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class ActualizarPersona implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

      String id_persona = request.getParameter("id_persona");
      String nombres = request.getParameter("nombres");
      String paterno = request.getParameter("paterno");
      String materno = request.getParameter("materno");
      String dip = request.getParameter("dip");
      String id_sexo = request.getParameter("id_sexo");
      String direccion = request.getParameter("direccion");
      String telefono = request.getParameter("telefono");
      String correo = request.getParameter("correo");
      
         Personas persona = new Personas();
         persona.setZona("setActualizarPersona");
         persona.setId_persona(id_persona);
         persona.setNombres(nombres);
         persona.setPaterno(paterno);
         persona.setMaterno(materno);
         persona.setDip(dip);
         persona.setId_sexo(id_sexo);
         persona.setFec_nacimiento(new Date());
         persona.setDireccion(direccion);

         persona.setId_estado_civil(0);

         persona.setTelefono(telefono);
         persona.setCorreo(correo);
         persona.setUlt_usuario(ult_usuario);
         persona = (Personas) this.eam.setRegistrarPersona(persona);

    persona = this.eam.getPersona(persona);
    modelo.put("per",persona);
    return new ModelAndView("administrarusuarios/UsuarioInfo", modelo);
	 
//    return new ModelAndView("administrarpersonas/AdministrarPersonas", modelo);
  }
}