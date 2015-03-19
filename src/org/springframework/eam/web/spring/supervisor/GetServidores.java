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

public class GetServidores implements Controller {
    
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

	if (accion == null) accion = "";	 
	System.out.println("accion >>>>>> "+accion);
	if (accion.equals("nuevo")) {
            return new ModelAndView("supervisor/RegServidor", modelo);
	}
	if (accion.equals("guardar")) {
	    Servidor srv = new Servidor();
	    srv.setServidor(nombre);
	    srv.setIp(ip);
	    srv.setPuerto(puerto);
	    srv.setUsuario(user);
	    srv.setPassword(pass);
            this.eam.setServidor(srv);	    
            List servers = this.eam.getListaServidores();
            modelo.put("listaServidores", servers);        	
            return new ModelAndView("supervisor/Servidores", modelo);
	}
	else {
        //orm_bd orm = new orm_bd();
        List servers = this.eam.getListaServidores();
        //List servs = new ArrayList();
	/*
        for (int i=0; i<servers.size(); i++) {
            Servidor srv = new Servidor();
            srv = (Servidor) servers.get(i);
            String strsource = "jdbc:postgresql://"+srv.getIp()+":"+srv.getPuerto()+"/imagenesdb";
            orm.establecerConexion(strsource+";"+srv.getUsuario()+";"+srv.getPassword()+";");
            Servidor srvaux = new Servidor();
	    
            orm.ejecutarObjeto("imagenes","get_estado_servidor",null,srvaux);
            srv.setTotal(srvaux.getTotal());
            srv.setTranscritas(srvaux.getTranscritas());
            this.eam.setServidor(srv);
            servs.add(srv);
            CreatePie p = new CreatePie();
            p.setTitulo("Servidor: "+srv.getId_servidor());
            p.setTitulovalor1("Transcritas ("+Integer.toString(srv.getTranscritas())+")");
            p.setTitulovalor2("Restantes ("+Integer.toString(srv.getTotal()-srv.getTranscritas())+")");
            p.setValor1(new Double(( (srv.getTranscritas()/(double)srv.getTotal())*100.0)));
            p.setValor2(new Double(( (srv.getTotal() - srv.getTranscritas())/(double)srv.getTotal() ) * (double)100.0));
            p.setArchivo("/opt/tomcat/webapps/cp/images/charts/"+srv.getId_servidor()+".jpg");
            p.getPie();
            orm.cerrar();
        }
	*/
        modelo.put("listaServidores", servers);        	
        return new ModelAndView("supervisor/Servidores", modelo);
        }
    }
}