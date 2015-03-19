//_ Castillo Valencia
package org.springframework.eam.web.spring.supervisor;

import java.util.*;
import java.lang.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Servidor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;
import Ajayu_orm.orm_bd;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.web.spring.supervisor.CreatePie;

import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;


import org.springframework.web.util.WebUtils;

public class ActualizarServidor implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String id_usuario  = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
	
	String id_servidor = request.getParameter("id_servidor");	
	String accion = request.getParameter("accion");
	if (accion == null) accion = "";	 
	if (accion.equals("default")) {
	    Servidor srv = new Servidor();
	    srv.setId_servidor(id_servidor);	   
	    this.eam.setDefaultServer(srv);
            List servers = this.eam.getListaServidores();
            modelo.put("listaServidores", servers);        	
            return new ModelAndView("supervisor/Servidores", modelo);
	}
	else {
            orm_bd orm = new orm_bd();
            Servidor srv = new Servidor();
	    srv.setId_servidor(id_servidor);
	    srv = this.eam.getServidor(srv);
            String strsource = "jdbc:postgresql://"+srv.getIp()+":"+srv.getPuerto()+"/imagenesdb";
            orm.establecerConexion(strsource+";"+srv.getUsuario()+";"+srv.getPassword()+";");
            
	    Servidor srvaux = new Servidor();	    
            orm.ejecutarObjeto("imagenes","get_estado_servidor",null,srvaux);
            
	    srv.setTotal(srvaux.getTotal());
            srv.setTranscritas(srvaux.getTranscritas());
            this.eam.setServidor(srv);
	    orm.cerrar();
	    
            Element root = new Element("root");
            Element nodo = new Element("dato").setText(id_servidor);
            nodo.setAttribute("total",Integer.toString(srv.getTotal()));
            nodo.setAttribute("transcritas",Integer.toString(srv.getTranscritas()));
            nodo.setAttribute("imagen","./images/charts/"+srv.getId_servidor()+".jpg");
            root.addContent(nodo);
            Document doc=new Document(root);//Creamos el documento
            try {
              XMLOutputter out=new XMLOutputter("  ",true);
    	      String cadena="";
              cadena = out.outputString(doc);
              //System.out.println("jjjj    "+cadena.substring(40,cadena.length()));
              modelo.put("datos",cadena.substring(40,cadena.length()));       
            } catch (Exception e) { e.printStackTrace(); }
	    
	      
            //servs.add(srv);
            
	    CreatePie p = new CreatePie();
            p.setTitulo("Servidor: "+srv.getId_servidor());
            p.setTitulovalor1("Transcritas ("+Integer.toString(srv.getTranscritas())+")");
            p.setTitulovalor2("Restantes ("+Integer.toString(srv.getTotal()-srv.getTranscritas())+")");
            p.setValor1(new Double(( (srv.getTranscritas()/(double)srv.getTotal())*100.0)));
            p.setValor2(new Double(( (srv.getTotal() - srv.getTranscritas())/(double)srv.getTotal() ) * (double)100.0));
            p.setArchivo("/opt/tomcat/webapps/cp/images/charts/"+srv.getId_servidor()+".jpg");
            p.getPie();
            
        //}
	//*/
        //modelo.put("listaServidores", servers);        	
        return new ModelAndView("supervisor/Servidor", modelo);
        }
    }
}