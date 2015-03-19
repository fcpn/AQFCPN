//_ Turnos
package org.springframework.eam.web.spring.turnos;

import java.util.*;
import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Turno;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class ChangeUsrsTurno implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
	
	Turno turno = new Turno();
	String id_usuario1 = request.getParameter("usuario");
	turno.setId_usuario(id_usuario1);
	int id_turno = Integer.parseInt(request.getParameter("turno"));
	if (id_turno == 0 || id_turno == 2) {
	    id_turno = 1;
	} else {
	    id_turno = 2;
	}
	turno.setId_turno(id_turno);
	this.eam.setTurno2(turno);
	
	response.sendRedirect("turnos.do");

        return new ModelAndView("turnos/Turnos", modelo);
    }
}