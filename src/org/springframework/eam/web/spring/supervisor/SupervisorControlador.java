//_ Supervisor
package org.springframework.eam.web.spring.supervisor;

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

import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Roles;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;
import org.springframework.eam.domain.Menues;

import org.springframework.web.util.WebUtils;

public class SupervisorControlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String gestion = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_gestion");
        String periodo = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_periodo");
        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        
        /******************* Verificando la llave del controlador *******************************************/
/*  Este Sub-programa determina si el usuario con sesion iniciada
    tiene asignado a su rol el control o uso de este programa
    Parametros: id_rol, id_programa, usuario y la ruta que hace referencia a este modulo
    desde la URL
 */
        String id_rol = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_rol");
        String urlDir = "/administrarUsuarios.do";
        Menues menu = new Menues();
        menu.setId_programa(id_programa);
        menu.setRuta_enlace(urlDir);
        menu.setId_rol(id_rol);
        menu.setUlt_usuario(id_usuario);
        int i = this.eam.getKeySecurity(menu);
        if (i == 0) { return new ModelAndView("KeyError", modelo); }
        /*  Fin se continua con el programa si el resultado del metodo da un valor de verdad o 1  ***********/
        /************************************** hola ********************************************************/
        
        modelo.put("gestion", gestion);
        modelo.put("periodo", periodo);
        modelo.put("programa", programa);
        String usuario = request.getParameter("usuario");
        String nombres = request.getParameter("nombres");
        String cargo = request.getParameter("cargo");
        String accion = request.getParameter("accion");
        Usuarios user = new Usuarios();
        user.setId_usuario(usuario);
        user.setId_programa(id_programa);

        PagedListHolder listaUsuarios = new PagedListHolder(this.eam.getListUsuarios());
        listaUsuarios.setPageSize(listaUsuarios.getNrOfElements());
        modelo.put("listaUsuarios", listaUsuarios);
        modelo.put("nUsuarios", Integer.toString(listaUsuarios.getNrOfElements()));
        
        return new ModelAndView("supervisor/Supervisor", modelo);
        
    }
}