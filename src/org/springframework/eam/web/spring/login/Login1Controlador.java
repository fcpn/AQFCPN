/* Programa:    Login1Controlador
 * Descripcion: Establece los datos de la sesion de la cuenta, y autentica al usuario q ha enviado sus datos.
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       26-10-2007
 * Modificado:  Lizeth Amalia Gutierrez Loza, IICCA
 * Fecha
 */
package org.springframework.eam.web.spring.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Login1Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
                
        String id_rol = request.getParameter("id_rol");        
        String id_usuario = (String) request.getSession().getAttribute("__sess_id_usuario");
        request.getSession().setAttribute("__sess_id_rol", id_rol);
        this.eam.setControlarIngreso(id_usuario,id_rol);
        return new ModelAndView("login/LoginSalida1", modelo);
    }
}