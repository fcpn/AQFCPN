// Programa	::	GetLoginUsers.java
// Autor	::	_ Castillo
// Creado	::	2004/05/11, 11:00
// Hector Jaramillo :   2004/05/11, 12:00

// Modificado _ Castillo  ::      2007/10/now, 11:32
package org.springframework.eam.web.spring.administrarusuarios;

import java.util.*;
import java.util.Map;
import java.lang.String;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Usuarios;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;

public class GetUsuarioXML implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");

    String key = request.getParameter("key");

    String id_persona = request.getParameter("id_persona");


    Element root = new Element("root");
/*
    for (int i=0; i<lista.size(); i++) {
       Usuarios user = (Usuarios) lista.get(i);       
       Element nodo = new Element("dato").setText("");
       nodo.setAttribute("id_usuario",user.getId_usuario());
       nodo.setAttribute("cod_img",user.getCod_img());
       nodo.setAttribute("nro_tarjetas",Integer.toString(user.getNro_tarjetas()));
       nodo.setAttribute("nombre_completo",user.getNombre_completo());
       root.addContent(nodo);       
    }
*/
   /* Datos administrativo */
    Administrativos adm = new Administrativos();
    adm.setId_persona(id_persona);
    adm = this.eam.getAdministrativo(adm);
    String resp = new String();
    if (adm.getId_administrativo().equals(""))
       resp = "false";
    else
       resp = "true";   
    Element nodo = new Element("respuesta").setText(resp);
    root.addContent(nodo);       
    if (resp.equals("true")) {
       Usuarios user = new Usuarios();
       user.setId_usuario(adm.getId_administrativo());
       user = this.eam.getUsuario(user);
       nodo = new Element("usuario").setText("");
       nodo.setAttribute("id_usuario",user.getId_usuario());
       nodo.setAttribute("recordatorio",user.getRecordatorio());
       root.addContent(nodo);       
       nodo = new Element("conectado").setText(this.eam.getUsrCnx(user));
       root.addContent(nodo);       
       nodo = new Element("turno").setText(this.eam.getUsrTurno(user));
       root.addContent(nodo);       
       user.setId_programa(id_programa);
       user.setRoles(this.eam.getRolesUsuario(user));
       for (int i=0; i<user.getRoles().size(); i++) {
         nodo = new Element("roles").setText("");
	 Usuarios us = (Usuarios) user.getRoles().get(i);
         nodo.setAttribute("id_estado",us.getId_estado());
         nodo.setAttribute("id_rol",us.getId_rol());
         nodo.setAttribute("rol",us.getRol());
         nodo.setAttribute("descripcion",us.getDescripcion());
         nodo.setAttribute("anio",us.getAnio());
         nodo.setAttribute("mes",us.getMes());
         nodo.setAttribute("dia",us.getDia());
         nodo.setAttribute("estado",us.getEstado());
         root.addContent(nodo);       
       }
    }
    
    
        Document doc=new Document(root);//Creamos el documento
        try {
          XMLOutputter out=new XMLOutputter("  ",true);
          String cadena="";
          cadena = out.outputString(doc);
          modelo.put("datos",cadena.substring(40,cadena.length()));       
        } catch (Exception e) { e.printStackTrace(); }
    
    return new ModelAndView("administrarusuarios/XMLLoginUsers", modelo);
  }
}
