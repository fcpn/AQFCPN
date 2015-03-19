package org.springframework.eam.web.spring.administrarmenu;

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

import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Roles;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class AdministrarMenuesControlador implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Map modelo = new HashMap();

    String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");

    String id_persona = request.getParameter("id_persona");
    String accion = request.getParameter("accion");

    String titulo = request.getParameter("titulo");
    String salida = request.getParameter("salida");
    String vista = request.getParameter("vista");

    modelo.put("titulo", titulo);
    modelo.put("salida", salida);
    modelo.put("vista", vista);

    PagedListHolder listaRoles = new PagedListHolder(this.eam.getRolesPrograma(id_programa));
    listaRoles.setPageSize(listaRoles.getNrOfElements()); 
    modelo.put("listaRoles", listaRoles);

    return new ModelAndView("administrarmenu/AdministrarMenues", modelo);
    
  }
}