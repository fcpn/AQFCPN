// Programa	::	AdministrarUsuarioControlador.java
// Autor	::	Hector Jaramillo
// Creado	::	2004/05/11, 11:00
// Hector Jaramillo :   2004/05/11, 12:00

// Modificado _ Castillo  ::      2005/09/19, 11:32
package org.springframework.eam.web.spring.administrarusuarios;

import java.util.*;
import java.util.Map;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class AdministrarUsuarios1Controlador implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

/*
    String usuario = request.getParameter("usuario");
    String nombres = request.getParameter("nombres");
    String cargo = request.getParameter("cargo");
    String accion = request.getParameter("accion");  
    */
//    modelo.put("id_usuario", id_usuario);
/*
    if ("Modificar".equals(accion)) {
       modelo.put("id_usuario", id_usuario);
       modelo.put("nombres", nombres);
       modelo.put("cargo", cargo);
       return new ModelAndView("administrarusuarios/AdministrarUsuarios3", modelo);
    }
*/
    String titulo = request.getParameter("titulo");
    String salida = request.getParameter("salida");
    String vista = request.getParameter("vista");
    if (vista == null || titulo == null || salida == null) {
         titulo = "ADMINISTRAR USUARIOS";
         vista  = "administrarusuarios/AdministrarUsuarios1";
         salida = "userinfo.do";
    }
    modelo.put("titulo", titulo);
    modelo.put("salida", salida);
    modelo.put("vista", vista);

    return new ModelAndView("administrarusuarios/AdministrarUsuarios1", modelo);
  }
}
