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


import org.springframework.web.util.WebUtils;

public class GetServerInfo implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String id_usuario  = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
	
	String accion = request.getParameter("accion");
	String nombre = request.getParameter("nombre");
	String ip = request.getParameter("ip");
	String puerto = request.getParameter("puerto");
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");

	String id_servidor = request.getParameter("id_servidor");
	    if (accion == null) accion = "";
            if (accion.equals("guardar")) {
    		Servidor srv = new Servidor();
		srv.setId_servidor(id_servidor);
		srv.setServidor(nombre);
		srv.setIp(ip);
		srv.setPuerto(puerto);
		srv.setUsuario(user);
		srv.setPassword(pass);
        	this.eam.setServidor(srv);	  
	        response.sendRedirect("/cp/servidores.do");		  	       
	    }    
	   
            orm_bd orm = new orm_bd();
            Servidor srv = new Servidor();
	    srv.setId_servidor(id_servidor);
	    srv = this.eam.getServidor(srv);
            String strsource = "jdbc:postgresql://"+srv.getIp()+":"+srv.getPuerto()+"/imagenesdb";
            orm.establecerConexion(strsource+";"+srv.getUsuario()+";"+srv.getPassword()+";");
            
	    Servidor srvaux = new Servidor();	    
	    try {
              orm.ejecutarObjeto("imagenes","get_estado_servidor",null,srvaux);
            } catch (Exception e) {
	      id_servidor = null;
	    }
	    if (id_servidor == null)
               return new ModelAndView("supervisor/ServidorError", modelo);        
	    
	    srv.setTotal(srvaux.getTotal());
            srv.setTranscritas(srvaux.getTranscritas());
            this.eam.setServidor(srv);
	    orm.cerrar();

            CreatePie p = new CreatePie();
            p.setTitulo("Servidor: "+srv.getId_servidor());
            p.setTitulovalor1("Transcritas ("+Integer.toString(srv.getTranscritas())+")");
            p.setTitulovalor2("Restantes ("+Integer.toString(srv.getTotal()-srv.getTranscritas())+")");
            p.setValor1(new Double(( (srv.getTranscritas()/(double)srv.getTotal())*100.0)));
            p.setValor2(new Double(( (srv.getTotal() - srv.getTranscritas())/(double)srv.getTotal() ) * (double)100.0));
            p.setArchivo("/opt/tomcat/webapps/cp/images/charts/"+srv.getId_servidor()+".jpg");
            p.getPie();
            
            modelo.put("servidor", srv); 

            return new ModelAndView("supervisor/ServidorInfo", modelo);        
       }
}