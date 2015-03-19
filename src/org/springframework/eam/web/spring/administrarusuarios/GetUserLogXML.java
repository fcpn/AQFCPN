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

public class GetUserLogXML implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");

    Element root = new Element("root");
    Usuarios user = new Usuarios();
    user.setId_usuario(id_usuario);
    //List userLog = this.eam.getUserLog(user);
    Element nodo;
   // for (int i=0; i < userLog.size(); i++) {
     //  Usuarios userx = (Usuarios) userLog.get(i);       
      // nodo = new Element("dato").setText("");
      // nodo.setAttribute("hora",user.getHora());
      // nodo.setAttribute("log",user.getLog());
     //  root.addContent(nodo);       
  ///  }

        Document doc=new Document(root);//Creamos el documento
        try {
          XMLOutputter out=new XMLOutputter("  ",true);
          String cadena="";
          cadena = out.outputString(doc);
          modelo.put("datos",cadena.substring(40,cadena.length()));       
        } catch (Exception e) { e.printStackTrace(); }
    
    return new ModelAndView("administrarusuarios/XMLUserLog", modelo);
  }
}
