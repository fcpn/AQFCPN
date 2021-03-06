

// Modificado _ Castillo  ::      2007/10/now, 11:32
package org.springframework.eam.web.spring.administrarusuarios;

import java.util.*;
import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Administrativos;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class GetAdministrativo implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String id_prog = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String id_usuario = request.getParameter("id_usuario");
    Administrativos adm = new Administrativos(); 
    adm.setId_usuario(id_usuario);
    adm = this.eam.getAdministrativo(adm);
    modelo.put("administrativo",adm);
    return new ModelAndView("administrarusuarios/VerAdministrativo", modelo);
  }
}
