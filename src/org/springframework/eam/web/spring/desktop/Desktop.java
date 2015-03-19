/* Programa:    Desktop
 * Descripcion: Establece los datos de la sesion de la cuenta, y autentica al usuario q ha enviado sus datos.
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       24-02-2008
 */
package org.springframework.eam.web.spring.desktop;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class Desktop implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String nombres      = (String) request.getSession().getAttribute("__sess_nombres");
        String id_rol       = (String) request.getSession().getAttribute("__sess_id_rol");
        String programa     = (String) request.getSession().getAttribute("__sess_programa");
        String id_usuario  = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        
        modelo.put("nombres",nombres);        
        modelo.put("id_rol",id_rol);        
        modelo.put("programa",programa);    
                
        
        if (id_rol == ""){
            id_rol = request.getParameter("id_rol");
            request.getSession().setAttribute("__sess_id_rol", id_rol);
        }        
        
        List listaDeCategorias = this.eam.getCategorias(id_programa,id_rol);
        List newListaDeCategorias = new ArrayList();
        for (int i=0; i<listaDeCategorias.size(); i++) {
            Menues categoria = (Menues) listaDeCategorias.get(i); 
            categoria.setEnlaces(this.eam.getEnlaces(categoria.getId_categoria(), id_rol, id_programa));
            newListaDeCategorias.add(categoria);
        }
        modelo.put("categorias",newListaDeCategorias);
                             
        return new ModelAndView("desktop/Desktop", modelo);
    }
}