
package org.springframework.eam.web.spring.administrarusuarios;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.List;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Administrativos;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class AdministrarUsuarios3Controlador implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade mi) {
    this.eam = mi;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

      Map modelo = new HashMap();

      String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
      String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
      String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");

    String gestion = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_gestion");
    String periodo = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_periodo");
    String facultad = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_facultad");




    modelo.put("gestion", gestion);
    modelo.put("periodo", periodo);
    modelo.put("programa", programa);
    modelo.put("facultad", facultad);







//      String id_persona = request.getParameter("id_persona");
      String nombres = request.getParameter("nombres");

      String id_usuario = request.getParameter("id_usuario");
      String clave1 = request.getParameter("clave1");
      String clave2 = request.getParameter("clave2");
//      String recordatorio = request.getParameter("recordatorio");
//      String id_tipo_usuario = request.getParameter("id_tipo_usuario");
      String cargo = request.getParameter("cargo");
      String accion = request.getParameter("accion");
      String roles[] = request.getParameterValues("roles");
      String dia[] = request.getParameterValues("dia");
      String mes[] = request.getParameterValues("mes");
      String anio[] = request.getParameterValues("anio");

    int lr;
    try{
        lr = roles.length;
    }catch(Exception e){
        lr = 0;
    }
/*
    if (nombres == null) {
          Personas persona = new Personas();
	  persona.setId_persona(id_persona);
	  persona = (Personas) this.mi.getBuscarPersonaId(persona);
	  nombres = persona.getNombre_completo();
    }
    modelo.put("id_persona", id_persona);
    modelo.put("nombres", nombres);
*/
      
/*    PagedListHolder listaRoles = new PagedListHolder(this.mi.getRolesPrograma(id_programa));
    listaRoles.setPageSize(listaRoles.getNrOfElements()); 
    modelo.put("listaRoles", listaRoles);
*/
    modelo.put("usuario", id_usuario);
    modelo.put("nombres", nombres);


    Usuarios user = new Usuarios();
    user.setId_usuario(id_usuario);
    user.setId_programa(id_programa);


    PagedListHolder rolesUser = new PagedListHolder(this.eam.getRolesUsuario(user)); 
    rolesUser.setPageSize(rolesUser.getNrOfElements()); 
    modelo.put("listaRolesU", rolesUser);

 //   return new ModelAndView("administrarusuarios/AdministrarUsuarios3", modelo);



    if (accion != null ) { 
      String _error = new String("");
      if("".equals(cargo) || lr == 0) {
        _error = "Los Campo(s) ";
        if("".equals(cargo))
            _error = _error + "Cargo, ";
        if(lr == 0)
            _error = _error + "de seleccion de roles, ";
        _error = _error + "son obligatorios...";
      }  
      
      if(!clave1.equals(clave2) && "".equals(_error)) {
        _error = "Los campos de la Clave deben ser iguales.  Ingrese nuevamente su clave";
      }
      
      for(int i = 0; i<lr; i++) {
        String datos[] = roles[i].split(":");
	int pos = Integer.parseInt(datos[1]);
	if (dia[pos].equals("") || mes[pos].equals("") || anio[pos].equals("")){
           _error = "Los Datos de fecha no son validos o no pueden ser vacios";
	}
      }

/*
      if(this.mi.getId_usuario(id_usuario) == 1){
           String _error_user = "este ID ya esta siendo utilizado por otro usuario. ";
           modelo.put("_error_user", _error_user);
           _error = "el ID usuario no es valido...";
      }
*/      
      if("".equals(_error)) {
        Usuarios usuario = new Usuarios();
	usuario.setId_usuario(id_usuario);
        if("".equals(clave1))
	    usuario.setClave("");
	else  
            usuario.setClave(clave1);
	    
//	usuario.setRecordatorio(recordatorio);
	usuario.setId_programa(id_programa);
	usuario.setUlt_usuario(ult_usuario);
	int res = this.eam.setActualizarUsuarioAdm(usuario);
        if (res == 1) {
            modelo.put("mensaje","SE HA CAMBIADO LA CLAVE DEL USUARIO ACTUAL");
//            return new ModelAndView("errores/RegisterError", modelo);
	}
	Administrativos administrativo = new Administrativos();
	administrativo.setId_administrativo(id_usuario);
//	administrativo.setId_persona(id_persona);
	administrativo.setCargo(cargo);
	administrativo.setId_programa(id_programa);
	administrativo.setUlt_usuario(ult_usuario);

	res = this.eam.setActualizarAdministrativo(administrativo);
        
        Usuarios usr_roles = new Usuarios();
	usr_roles.setId_usuario(id_usuario);
	usr_roles.setId_programa(id_programa);
	usr_roles.setUlt_usuario(ult_usuario);
	this.eam.setBorrarRolesUsuario(usr_roles);              
        for(int i = 0; i<lr; i++) {
          String datos[] = roles[i].split(":");
	  int pos = Integer.parseInt(datos[1]);
	  usr_roles.setId_rol(datos[0]);
          Date fec_exp = new Date(Integer.parseInt(anio[pos])-1900, Integer.parseInt(mes[pos])-1, Integer.parseInt(dia[pos]));
	  usr_roles.setFec_expiracion(fec_exp);
          res = this.eam.setRegistrarUsuariosRoles(usr_roles);
        }
        modelo.put("mensaje","El Usuario fue actualizado...");
        return new ModelAndView("Aviso", modelo);
      }
      modelo.put("_error", _error);
      modelo.put("id_usuario", id_usuario);
      modelo.put("cargo", cargo);
      return new ModelAndView("administrarusuarios/AdministrarUsuarios3", modelo);
    }
    return new ModelAndView("administrarusuarios/AdministrarUsuarios3", modelo);
  }
}
