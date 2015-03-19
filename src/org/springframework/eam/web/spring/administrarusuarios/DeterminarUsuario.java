

// Jesus Reynaldo
package org.springframework.eam.web.spring.administrarusuarios;

import java.util.*;
import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Personas;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class DeterminarUsuario implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

//    String id_usuario = request.getParameter("id_usuario");
//    Administrativos adm = new Administrativos(); 
//    adm.setId_usuario(id_usuario);
//    adm = this.eam.getAdministrativo(adm);
//    modelo.put("administrativo",adm);

    String id_persona = request.getParameter("id_persona");
    //Administrativos adm = new Administrativos(); 
    //adm.setId_usuario(id_usuario);
    //adm = this.eam.getAdministrativo(adm);
    Personas per = new Personas();
    per.setId_persona(id_persona);
    per = this.eam.getPersona(per);//JESUS  tengo todo del usuario
    modelo.put("per",per);
    modelo.put("a", "aaaaaaaa");//aqui tengo que identificar si es administrador o usuario comun



    return new ModelAndView("administrarusuarios/DeterminarUsuario", modelo);
  }
}


