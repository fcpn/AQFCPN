/* Programa:    VerCabezaControlador
 * Descripcion: Establece los datos de la sesion en la cabecera de la aplicacion.
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       26-10-2007
 * Modificado:  Lizeth Amalia Gutierrez Loza, IICCA
 * Fecha
 */
package org.springframework.eam.web.spring.vercabeza;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class VerCabezaControlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String nombres      = (String) request.getSession().getAttribute("__sess_nombres");
        String id_rol       = (String) request.getSession().getAttribute("__sess_id_rol");
        String programa     = (String) request.getSession().getAttribute("__sess_programa");
        String id_programa  = (String) request.getSession().getAttribute("__sess_id_prog");
        String tipo_usuario = (String) request.getSession().getAttribute("__sess_tipo_usuario");
        List listaDeRoles   = (List)   request.getSession().getAttribute("__sess_roles");
        
        modelo.put("listaDeRoles",listaDeRoles);
        modelo.put("nombres",nombres);
        modelo.put("id_rol",id_rol);
        modelo.put("id_programa",id_programa);
        modelo.put("programa",programa);
        modelo.put("tipo_usuario",tipo_usuario);
        try {
            modelo.put("cantidad",Integer.toString(listaDeRoles.size()));
        } catch(Exception e) {}
        /* variables para mostrar el reloj de la aplicacion */
        Date fecha = new Date();
        modelo.put("hora",Integer.toString(fecha.getHours()));
        modelo.put("minuto",Integer.toString(fecha.getMinutes()));
        modelo.put("segundo",Integer.toString(fecha.getSeconds()));
        
        return new ModelAndView("vercabeza/VerCabeza", modelo);
    }
}
