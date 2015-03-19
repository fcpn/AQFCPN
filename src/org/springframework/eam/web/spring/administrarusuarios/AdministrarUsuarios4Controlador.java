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

public class AdministrarUsuarios4Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
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
        modelo.put("usuario", id_usuario);
        modelo.put("nombres", nombres);
        
        
        Usuarios user = new Usuarios();
        user.setId_usuario(id_usuario);
        user.setId_programa(id_programa);
        
        
        PagedListHolder rolesUser = new PagedListHolder(this.eam.getRolesUsuario(user));
        rolesUser.setPageSize(rolesUser.getNrOfElements());
        modelo.put("listaRolesU", rolesUser);
        
        Usuarios usr = new Usuarios();
        usr.setId_usuario(id_usuario);
        //this.mi.setBorrarLoginHistorico(usr);
        //this.mi.setBorrarRolesUsuario(usr);
        this.eam.setEliminarUsuario(usr);
        return new ModelAndView("administrarusuarios/AdministrarUsuarios4", modelo);
    }
}
