
package org.springframework.eam.web.spring.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class MenuControlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String id_usuario  = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String nombres     = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_nombres");
        String id_rol      = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_rol");
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        
        String id_categoria = request.getParameter("id_categoria");
        
        if (id_rol == ""){
            id_rol = request.getParameter("id_rol");
            request.getSession().setAttribute("__sess_id_rol", id_rol);
        }
        
        List listaDeCategorias = this.eam.getCategorias(id_programa,id_rol);
        
        if (id_categoria != null) {
            List listaDeEnlaces = this.eam.getEnlaces(id_categoria, id_rol, id_programa);
            modelo.put("listaDeEnlaces", listaDeEnlaces);
        }
        
        modelo.put("nombres",nombres);
        modelo.put("id_usuario",id_usuario);
        modelo.put("id_rol",id_rol);
        modelo.put("listaDeCategorias", listaDeCategorias);
        modelo.put("id_categoria", id_categoria);
        //modelo.put("jesus", "Jeeeeeeeees...");
        
        return new ModelAndView("menu/Menu", modelo);
    }
}