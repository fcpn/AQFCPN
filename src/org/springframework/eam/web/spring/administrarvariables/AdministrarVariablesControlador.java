package org.springframework.eam.web.spring.administrarvariables;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;
import org.springframework.eam.domain.Registro;
import org.springframework.eam.domain.Menues;

public class AdministrarVariablesControlador implements Controller {
        
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();
    
    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String gestion = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_gestion");
    String periodo = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_periodo");

/******************* Verificando la llave del controlador *******************************************/
/*  Este Sub-programa determina si el usuario con sesion iniciada
    tiene asignado a su rol el control o uso de este programa
    Parametros: id_rol, id_programa, usuario y la ruta que hace referencia a este modulo
    desde la URL 
 */
    String id_rol = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_rol");
    String urlDir = "/administrarVariables.do";
    Menues menu = new Menues();
    menu.setId_programa(id_programa);
    menu.setRuta_enlace(urlDir);
    menu.setId_rol(id_rol);
    menu.setUlt_usuario(id_usuario);
    int i = this.eam.getKeySecurity(menu);
    if (i == 0) { return new ModelAndView("KeyError", modelo); }
/*  Fin se continua con el programa si el resultado del metodo da un valor de verdad o 1  ***********/
/************************************** hola ********************************************************/


    String new_gestion = request.getParameter("new_gestion");
    String new_periodo = request.getParameter("new_periodo");
    String accion = request.getParameter("accion");        
    modelo.put("programa",programa);
    modelo.put("periodo",periodo);
    modelo.put("gestion",gestion);

    if("Actualizar".equals(accion)) {
      Registro registro = new Registro();
      registro.setGestion(Integer.parseInt(new_gestion));
      registro.setPeriodo(Integer.parseInt(new_periodo));
      registro.setRegion(id_programa);
      registro.setUlt_usuario(id_usuario);
      this.eam.setActualizarParametros(registro);
      return new ModelAndView("administrarvariables/_link", modelo);
    }

    return new ModelAndView("administrarvariables/AdministrarVariablesEntrada", modelo);
  }
}
  