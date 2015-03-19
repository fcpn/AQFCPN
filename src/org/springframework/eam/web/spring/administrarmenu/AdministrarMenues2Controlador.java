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
import org.springframework.eam.domain.Menues;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class AdministrarMenues2Controlador implements Controller {
 
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
    String id_enlace = request.getParameter("id_enlace");
    String fec_activacion = request.getParameter("fec_activacion");
    String fec_desactivacion = request.getParameter("fec_desactivacion");
    
    int id_enlacex = Integer.parseInt(id_enlace);
    System.out.println("Datos del del  fec desactivacion**********-------"+fec_desactivacion);


    Menues fechasenlaces = this.eam.getFechasEnlaces(id_enlacex);
    modelo.put("FechasEnlaces",fechasenlaces);
    return new ModelAndView("administrarmenu/AdministrarMenues2", modelo);
    
  }
}