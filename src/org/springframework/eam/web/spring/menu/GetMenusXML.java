/* Programa	::	GetLoginUsers.java
 * Autor	::	_ Castillo
 * Modificado   ::      _ Castillo   24/02/2008
 */
package org.springframework.eam.web.spring.menu;

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
import org.springframework.eam.domain.Menues;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;

public class GetMenusXML implements Controller {
    
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
        
        
        if (id_rol == ""){
            id_rol = request.getParameter("id_rol");
            request.getSession().setAttribute("__sess_id_rol", id_rol);
        }        
        
        List listaDeCategorias = this.eam.getCategorias(id_programa,id_rol);
                       
        Element root = new Element("root");
        Element nodo = new Element("categorias").setText("");
        root.addContent(nodo);
        for (int i=0; i<listaDeCategorias.size(); i++) {
            Menues categoria = (Menues) listaDeCategorias.get(i);
            Element xnodo = new Element("categoria").setText("");
            xnodo.setAttribute("id_categoria",categoria.getId_categoria());
            xnodo.setAttribute("categoria",categoria.getCategoria());
            List listaDeEnlaces = this.eam.getEnlaces(categoria.getId_categoria(), id_rol, id_programa);
            for (int j=0; j<listaDeEnlaces.size(); j++) {
               Menues enlace = (Menues) listaDeEnlaces.get(j); 
               Element ynodo = new Element("enlace").setText(enlace.getNombre_enlace());
               ynodo.setAttribute("id_enlace",Integer.toString(enlace.getId_enlace()));
               ynodo.setAttribute("ruta",enlace.getRuta_enlace());               
               xnodo.addContent(ynodo);
            }
            nodo.addContent(xnodo);           
        }
        
        
        Document doc=new Document(root);//Creamos el documento
        try {
            XMLOutputter out=new XMLOutputter("  ",true);
            String cadena="";
            cadena = out.outputString(doc);
            modelo.put("datos",cadena.substring(40,cadena.length()));
        } catch (Exception e) { e.printStackTrace(); }
        
        return new ModelAndView("menu/XMLMenus", modelo);
    }
}
