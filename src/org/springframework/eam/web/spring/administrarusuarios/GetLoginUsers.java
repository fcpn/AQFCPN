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
import org.springframework.eam.domain.Usuarios;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;

public class GetLoginUsers implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String key = request.getParameter("key");
    System.out.println(">>>>>>> "+key);
    if (key != null)
      if (key.equals("refresh"))
         this.eam.getLoginRefreshUsers();
    List lista = this.eam.getLoginUsers();

    Element root = new Element("root");
    for (int i=0; i<lista.size(); i++) {
       Usuarios user = (Usuarios) lista.get(i);       
       Element nodo = new Element("dato").setText("");
       nodo.setAttribute("id_usuario",user.getId_usuario());
       nodo.setAttribute("cod_img",user.getCod_img());
       nodo.setAttribute("nro_tarjetas",Integer.toString(user.getNro_tarjetas()));
       nodo.setAttribute("nombre_completo",user.getNombre_completo());
       root.addContent(nodo);       
    }
    Element nodo = new Element("usuarios").setText(Integer.toString(lista.size()));
       root.addContent(nodo);       
    
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
