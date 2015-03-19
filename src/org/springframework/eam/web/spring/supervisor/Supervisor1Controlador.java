package org.springframework.eam.web.spring.supervisor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;


public class Supervisor1Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
	String id_usuario = request.getParameter("id_usuario");
	Usuarios usuario = new Usuarios();
	usuario.setId_usuario(id_usuario);
        PagedListHolder listaTarjetas = new PagedListHolder(this.eam.getListTarjetas(usuario));
	listaTarjetas.setPageSize(listaTarjetas.getNrOfElements());
        modelo.put("listaTarjetas", listaTarjetas);
        modelo.put("id_usuario", id_usuario);
	
	String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
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
        
        modelo.put("gestion", gestion);
        modelo.put("periodo", periodo);
        modelo.put("programa", programa);

        return new ModelAndView("supervisor/Supervisor1", modelo);
    }
}