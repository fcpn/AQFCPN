

// Modificado _ Castillo  ::      2007/10/now, 11:32
package org.springframework.eam.web.spring.administrarusuarios;

import java.util.*;
import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Usuarios;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class UsrUpdateRol implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String user = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String id_usuario = request.getParameter("id_usuario");
    String id_persona = request.getParameter("id_persona");
    String dia = request.getParameter("dia");
    String mes = request.getParameter("mes");
    String anio= request.getParameter("anio");
    String id_rol = request.getParameter("id_rol");
    System.out.println("jjj ---> "+id_usuario);
    System.out.println("jjj ---> "+id_persona);
    System.out.println("jjj ---> "+dia);
    System.out.println("jjj ---> "+mes);
    System.out.println("jjj ---> "+anio);
    System.out.println("jjj ---> "+id_rol);
    System.out.println("jjj ---> "+id_programa);
    Usuarios usuario = new Usuarios();
    usuario.setId_rol(id_rol);
    usuario.setId_usuario(id_usuario);
    usuario.setId_programa(id_programa);
    usuario.setUlt_usuario(user);
    Date fecha;
    try {
          fecha = new Date(Integer.parseInt(anio)-1900, Integer.parseInt(mes)-1, Integer.parseInt(dia));
    }catch (Exception e) {
          fecha = new Date();
    }       	  
    usuario.setFec_expiracion(fecha);	      
    int res = this.eam.setActualizarUsuariosRoles(usuario);
    
/* datos para regresar a usuarioInfo */
    Personas per = new Personas();
    per.setId_persona(id_persona);
    per = this.eam.getPersona(per);
    modelo.put("per",per);
    return new ModelAndView("administrarusuarios/UsuarioInfo", modelo);
  }
}
