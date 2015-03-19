package org.springframework.eam.web.spring.cambiodepin;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class CambioDePin1Controlador implements Controller {

  private EamFacade eam;

  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();
        
    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String nombres    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_nombres");
    String id_rol     = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_rol");
    String id_programa= (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String programa   = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String gestion    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_gestion");
    String periodo    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_periodo");

    String clave    = request.getParameter("clave_actual");
    String clave_nueva     = request.getParameter("clave_nueva");
    String clave_confirmar = request.getParameter("clave_confirmar");

    modelo.put("id_usuario", id_usuario);
    modelo.put("nombres", nombres);
    modelo.put("id_rol", id_rol);
    modelo.put("programa", programa);
    modelo.put("gestion", gestion);
    modelo.put("periodo", periodo);

    if(clave.equals("") || clave_nueva.equals("") || clave_confirmar.equals(""))  {
       modelo.put("mensaje","Clave Actual, Clave Nueva y Confirmar Clave deben ser llenados");
       return new ModelAndView("cambiodepin/CambioDePin", modelo);    
    }

    if(!clave_nueva.equals(clave_confirmar)){
       modelo.put("mensaje","La nueva clave y la clave de confirmacion No son iguales");
       return new ModelAndView("cambiodepin/CambioDePin", modelo);    
    }

    List listita = this.eam.getUsuarioClave(id_programa,id_usuario,clave);

    if(listita.size()==0){
       modelo.put("mensaje","Clave Actual No es valida");
       return new ModelAndView("cambiodepin/CambioDePin", modelo);    
    }

    Usuarios actualizar = new Usuarios();
    actualizar.setId_usuario(id_usuario);
    actualizar.setId_programa(id_programa);
    actualizar.setClave(clave);
    actualizar.setClave_nueva(clave_nueva);
    actualizar.setUlt_usuario(id_usuario);

    this.eam.setActualizarClave(actualizar);

    return new ModelAndView("cambiodepin/CambioDePin1", modelo);
  }
}
