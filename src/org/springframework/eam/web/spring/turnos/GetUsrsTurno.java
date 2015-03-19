package org.springframework.eam.web.spring.turnos;

import java.util.*;
import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Usuarios;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;

import org.springframework.web.util.WebUtils;

public class GetUsrsTurno implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
	String id_turno = request.getParameter("id_turno");
	if (id_turno == null) {
	    id_turno = "0";
	}
        Usuarios turno = new Usuarios();
	turno.setId_turno(Integer.parseInt(id_turno));

        Element root = new Element("root");
        Element nodo;
	List users = this.eam.getUsuariosTurno();
        for (int i=0; i<users.size(); i++) {
         nodo = new Element("usuario").setText("");
	 Usuarios us = (Usuarios) users.get(i);
         nodo.setAttribute("id_usuario",us.getId_usuario());
         nodo.setAttribute("nombres",us.getNombres());
         nodo.setAttribute("cargo",us.getCargo());
	 nodo.setAttribute("id_turno",us.getId_turno()+"");
	 nodo.setAttribute("id_turno_actual",us.getId_turno_actual()+"");
	 nodo.setAttribute("id_turno_tmp",us.getId_turno_tmp()+"");
	 root.addContent(nodo);       
	} 
        Document doc=new Document(root);//Creamos el documento
        try {
          XMLOutputter out=new XMLOutputter("  ",true);
          String cadena="";
          cadena = out.outputString(doc);
          modelo.put("datos",cadena.substring(40,cadena.length()));       
        } catch (Exception e) { e.printStackTrace(); }

        return new ModelAndView("turnos/UsrsTurnosXML", modelo);
    }
}