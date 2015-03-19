
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

public class AdministrarMenues3Controlador implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Map modelo = new HashMap();

    String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");

    String id_estado = request.getParameter("id_estado");
    String id_enlace = request.getParameter("id_enlace");
    String fec_activacion = request.getParameter("fec_activacion");
    String fec_desactivacion = request.getParameter("fec_desactivacion");
    
    String dia = "";
    String mes = "";
    String anio = "";

    String xdia = "";
    String xmes = "";
    String xanio = "";
    String mensaje = "LOS DATOS FUERON REGISTRADOS";
    
    int id_enlacex = Integer.parseInt(id_enlace);
    
    if(fec_activacion != null){
	String datos[] = fec_activacion.split("-");
	dia = datos[0];
	mes = datos[1];
	anio = datos[2];
    }

    if(fec_desactivacion != null){
	String datosx[] = fec_desactivacion.split("-");
	xdia = datosx[0];
	xmes = datosx[1];
	xanio = datosx[2];
    }

     Date fec_activacionx = new Date(Integer.parseInt(anio)-1900, Integer.parseInt(mes)-1, Integer.parseInt(dia));
     Date fec_desactivacionx = new Date(Integer.parseInt(xanio)-1900, Integer.parseInt(xmes)-1, Integer.parseInt(xdia));

    Menues actualizar = new Menues();
    actualizar.setId_enlace(Integer.parseInt(id_enlace));
    actualizar.setFec_activacion(fec_activacionx);
    actualizar.setFec_desactivacion(fec_desactivacionx);
    actualizar.setId_estado(id_estado );

    this.eam.setActualizarMenues(actualizar);
    
    Menues fechasenlaces = this.eam.getFechasEnlaces(id_enlacex);
    modelo.put("mensaje",mensaje);
    modelo.put("FechasEnlaces",fechasenlaces);
    return new ModelAndView("administrarmenu/AdministrarMenues2", modelo);
    
  }
}