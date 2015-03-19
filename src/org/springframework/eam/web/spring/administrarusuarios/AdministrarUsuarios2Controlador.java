// Programa	::	AdministrarUsuarioControlador.java
// Autor	::	Hector Jaramillo
// Creado	::	2004/05/11, 11:00
// Hector Jaramillo :   2004/05/11, 12:00

// Modificado _ Castillo  ::      2005/09/19, 11:32
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
import java.io.*;
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

public class AdministrarUsuarios2Controlador implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

      Map modelo = new HashMap();

      String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
      String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
      String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");

      String id_persona = request.getParameter("id_persona");
      String nombres = request.getParameter("nombres");

      String id_usuario = request.getParameter("id_usuario");
      String clave1 = request.getParameter("clave1");
      String clave2 = request.getParameter("clave2");
      String recordatorio = request.getParameter("recordatorio");
      String id_tipo_usuario = request.getParameter("id_tipo_usuario");
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
    if (nombres == null) {
          System.out.println("Estoy dentro el IF");
          Personas persona = new Personas();
	  persona.setId_persona(id_persona);
	  persona = (Personas) this.eam.getBuscarPersonaId(persona);
	  nombres = persona.getNombre_completo();
    }
    modelo.put("id_persona", id_persona);
    modelo.put("nombres", nombres);
      
    PagedListHolder listaRoles = new PagedListHolder(this.eam.getRolesPrograma(id_programa));
    listaRoles.setPageSize(listaRoles.getNrOfElements()); 
    modelo.put("listaRoles", listaRoles);
    if (accion != null ) { 
      String _error = new String("");
      if("".equals(id_usuario) || "".equals(clave1) || "".equals(clave2) || "".equals(recordatorio) || 
         "".equals(cargo) || lr == 0) {
        _error = "Los Campo(s) ";
        if("".equals(id_usuario))
            _error = _error + "ID Usuario, ";
        if("".equals(clave1) || "".equals(clave2))
            _error = _error + "clave, ";
        if("".equals(recordatorio))
            _error = _error + "Recordatorio, ";
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
      if(this.eam.getId_usuario(id_usuario) == 1){
           String _error_user = "este ID ya esta siendo utilizado por otro usuario. ";
           modelo.put("_error_user", _error_user);
           _error = "el ID usuario no es valido...";
      }
      
      if("".equals(_error)) {
        Usuarios usuario = new Usuarios();
	usuario.setId_usuario(id_usuario);
	usuario.setClave(clave1);
	usuario.setRecordatorio(recordatorio);
	usuario.setId_programa(id_programa);
	usuario.setUlt_usuario(ult_usuario);
	int res = this.eam.setRegistrarUsuariosAdm(usuario);
        if (res == 0) {
            modelo.put("mensaje","El usuario no fue registrado, intente nuevamente verificando los datos de entrada...");
            return new ModelAndView("errores/RegisterError", modelo);
	 }
	Administrativos administrativo = new Administrativos();
	administrativo.setId_administrativo(id_usuario);
	administrativo.setId_persona(id_persona);
	administrativo.setCargo(cargo);
	administrativo.setId_programa(id_programa);
	administrativo.setUlt_usuario(ult_usuario);
	res = this.eam.setRegistrarAdministrativo(administrativo);
        if (res == 0) {
            modelo.put("mensaje","El empleado no fue registrado...");
            return new ModelAndView("errores/RegisterError", modelo);
	}
        Usuarios usr_roles = new Usuarios();
	usr_roles.setId_usuario(id_usuario);
	usr_roles.setId_programa(id_programa);
	usr_roles.setUlt_usuario(ult_usuario);
        for(int i = 0; i<lr; i++) {
          String datos[] = roles[i].split(":");
	  int pos = Integer.parseInt(datos[1]);
	  usr_roles.setId_rol(datos[0]);
          Date fec_exp = new Date(Integer.parseInt(anio[pos])-1900, Integer.parseInt(mes[pos])-1, Integer.parseInt(dia[pos]));
	  usr_roles.setFec_expiracion(fec_exp);
          res = this.eam.setRegistrarUsuariosRoles(usr_roles);
        }
	// crear directorio del usuario...
        File directorio = new File("/opt/tomcat/webapps/Alojamiento_Transcriptores/Usuarios_Transcriptores/"+id_usuario);
	directorio.mkdir();	
        modelo.put("mensaje","El Usuario fue registrado...");
        return new ModelAndView("Aviso", modelo);
      }
      modelo.put("_error", _error);
      modelo.put("id_usuario", id_usuario);
      modelo.put("recordatorio", recordatorio);
      modelo.put("cargo", cargo);
      return new ModelAndView("administrarusuarios/AdministrarUsuarios2", modelo);
    }
    return new ModelAndView("administrarusuarios/AdministrarUsuarios2", modelo);
  }
}
