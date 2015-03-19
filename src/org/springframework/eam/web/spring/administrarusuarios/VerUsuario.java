// Programa	::	GetLoginUsers.java
// Autor	::	_ Castillo
// Creado	::	2004/05/11, 11:00
// Hector Jaramillo :   2004/05/11, 12:00

// Modificado _ Castillo  ::      2007/10/now, 11:32
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
import org.springframework.eam.domain.Usuarios;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class VerUsuario implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String usuario = request.getParameter("id_usuario");
    if (usuario != null) {
      Usuarios user = new Usuarios();
      user.setId_usuario(usuario);
      int i = this.eam.getVerUsuario(user);
      modelo.put("mensaje",Integer.toString(i));
    }
    return new ModelAndView("administrarusuarios/Respuesta", modelo);
  }
}
