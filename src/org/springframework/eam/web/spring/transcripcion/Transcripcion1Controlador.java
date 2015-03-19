package org.springframework.eam.web.spring.transcripcion;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.Tiempos;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;


public class Transcripcion1Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String id_rol = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_rol");

	String cod_img;
	try {
	    cod_img = (String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");
        } catch(Exception e) {
	    cod_img = "";
	}

	Usuarios usuario = new Usuarios();
	usuario.setId_usuario(id_usuario);

        String opcion = request.getParameter("transcripcion");
	
        if (opcion != null) {
	
	   /**********  Entrada Inicial sin parametros   **********************************/    
	   if (opcion.equals("transcripcion")) {

	     //_ reportes
//    	     Tarjeta user = new Tarjeta();
//	     user.setId_usuario(id_usuario);
//    	     PagedListHolder listaReporteDiario = new PagedListHolder(this.eam.getListaReporteDiario(user));
//	     listaReporteDiario.setPageSize(listaReporteDiario.getNrOfElements());
//    	     modelo.put("listaReporteDiario", listaReporteDiario);
	     //Fin _ reportes
	
	     return new ModelAndView("transcripcion/TranscripcionEntrada0", modelo);
	   } 
	   
	   /**********  Para guardar transcripcion  ***************************************/    
	   if (opcion.equals("guardar") && !cod_img.equals("") && id_rol.equals("tra")) {
             
	     request.getSession().removeAttribute("__cod_img");	     
	     String tiempo = request.getParameter("tiempo");
	     StringTokenizer st = new StringTokenizer(tiempo,":");
	     int minutos = Integer.parseInt(st.nextToken());
	     int segundos = Integer.parseInt(st.nextToken());
	     
	     Time tiempo1 = new Time(0);   // estableciendo el lpso de la actividad....
	     tiempo1.setHours(0);
	     tiempo1.setMinutes(minutos);
	     tiempo1.setSeconds(segundos);

	     int current = this.eam.setLapsoTiempos(this.eam.getUltimoIdTiempos(cod_img),tiempo1); // guardando el tiempo
	     	     
	     Tarjeta datos = new Tarjeta();  // estableciendo los datos de la tarjeta
	     datos.setId_usuario(id_usuario);
	     datos.setCod_img(cod_img);

	     this.eam.setGuardarTarjeta(datos);  // guardando la tarjeta

    	     //_ reportes
//             Tarjeta user = new Tarjeta();
//	     user.setId_usuario(id_usuario);
//    	     PagedListHolder listaReporteDiario = new PagedListHolder(this.eam.getListaReporteDiario(user));
//	     listaReporteDiario.setPageSize(listaReporteDiario.getNrOfElements());
//    	     modelo.put("listaReporteDiario", listaReporteDiario);
	     //Fin _ reportes
	     
	     return new ModelAndView("transcripcion/TranscripcionEntrada0", modelo); 
	   }     

	   /**********  Para guardar verificacion  ***************************************/    
	   if (opcion.equals("guardar") && !cod_img.equals("") && id_rol.equals("ver")) {
             
	     String tiempo = request.getParameter("tiempo");
	     StringTokenizer st = new StringTokenizer(tiempo,":");
	     int minutos = Integer.parseInt(st.nextToken());
	     int segundos = Integer.parseInt(st.nextToken());
	     
	     Time tiempo1 = new Time(0);   // estableciendo el lpso de la actividad....
	     tiempo1.setHours(0);
	     tiempo1.setMinutes(minutos);
	     tiempo1.setSeconds(segundos);

	     int current = this.eam.setLapsoTiempos(this.eam.getUltimoIdTiempos(cod_img),tiempo1); // guardando el tiempo
	     return new ModelAndView("transcripcion/CalificarVerificacion", modelo);	       	     	     
	   }     
        }
	
	// salida por defecto - error del navegador. u otra anormalidad
        return new ModelAndView("transcripcion/TranscripcionEntrada", modelo);        
    }
}