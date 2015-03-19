/*
 Programa	::	ADMINISTRAR PERSONAS
Descripcion   ::      Este modulo puede ser llamado por cualquier programa que requiera 
                      registrar a una persona sin importar cuel sera su posicion final en el sistema
			es decir, estudiante, docente, administrativo, etc
			El objeto de este programa es validar y registrar datos peersonales
                      y devolver un ID de Persona el cual fue creado..
 Autor	::	_ CASTILLO - _
 Creado	::	2005/10/1, 11:00
 Modificado   ::      _ Castillo  ::  2005/10/15, 11:32
*/


package org.springframework.eam.web.spring.administrarpersonas;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.List;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.Personas;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class RegistrarPersona implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

      String nombres = request.getParameter("nombres");
      String paterno = request.getParameter("paterno");
      String materno = request.getParameter("materno");
      String dip = request.getParameter("dip");
      String id_sexo = request.getParameter("id_sexo");
      String direccion = request.getParameter("direccion");
      String telefono = request.getParameter("telefono");
      String correo = request.getParameter("correo");
      String ruta = request.getParameter("ruta");
      
      
         Personas persona = new Personas();

        if(ruta != null)
        if (ruta.equals("formulario")) {
          persona.setId_sexo("M");
          persona.setCorreo("@");
          modelo.put("per",persona);
          return new ModelAndView("administrarusuarios/RegistrarPersona", modelo);
        }
	
         persona.setZona("setRegistrarPersona");
         persona.setNombres(nombres);
         persona.setPaterno(paterno);
         persona.setMaterno(materno);
         persona.setDip(dip);
         persona.setId_sexo(id_sexo);
         persona.setFec_nacimiento(new Date());
         persona.setDireccion(direccion);

         persona.setId_estado_civil(0);

         persona.setTelefono(telefono);
         persona.setCorreo(correo);
         persona.setUlt_usuario(ult_usuario);
         persona = (Personas) this.eam.setRegistrarPersona(persona); ///1 ibatis

    persona = this.eam.getPersona(persona);
    modelo.put("per",persona);
    //return new ModelAndView("administrarusuarios/UsuarioInfo", modelo);
    //return new ModelAndView("", modelo);
	 
    return new ModelAndView("administrarpersonas/AdministrarPersonas", modelo);
  }
}