/* Programa:    VerBarraControlador
 * Descripcion: Establece si existe rol del usuario para iniciar la aplicacion
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       26-10-2007
 * Modificado:  Lizeth Amalia Gutierrez Loza, IICCA
 * Fecha
 */
package org.springframework.eam.web.spring.verbarra;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.util.WebUtils;

public class VerBarraControlador implements Controller {
        
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();
    
    String id_rol;
    try {
      id_rol = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_rol");
    } catch (Exception e) {
      id_rol = "";
    }
    modelo.put("id_rol", id_rol);
    return new ModelAndView("verbarra/VerBarra", modelo);
  }
}