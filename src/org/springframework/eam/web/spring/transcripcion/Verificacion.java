package org.springframework.eam.web.spring.transcripcion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class Verificacion implements Controller {
    
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

        String calificacion = request.getParameter("calificacion");        
        System.out.println("calificacion: "+calificacion);
	
        if (calificacion != null) {

	   /**********  Para guardar verificacion  ***************************************/    
	   if (!cod_img.equals("") && id_rol.equals("ver")) {
             
	     
	     Tarjeta datos = new Tarjeta();      // estableciendo los datos de la tarjeta
	     datos.setId_usuario(id_usuario);
	     datos.setCod_img(cod_img);
	     this.eam.setCalificacionSistema(datos);
	     this.eam.setPrepararGuardar(datos);
	     this.eam.setGuardarTarjeta(datos);  // guardando la tarjeta
             
	     /* verificacion guardar */
	     datos.setCalificacion(Integer.parseInt(calificacion));
             //this.eam.getUltimoIdTiempos(tarjeta.getId_tarjeta())
	     this.eam.setCalificacionUsr(datos);

	     request.getSession().removeAttribute("__cod_img");	     
	      
    	     //_ reportes
             Tarjeta user = new Tarjeta();
	     user.setId_usuario(id_usuario);
    	     PagedListHolder listaReporteDiario = new PagedListHolder(this.eam.getListaReporteDiario(user));
	     listaReporteDiario.setPageSize(listaReporteDiario.getNrOfElements());
    	     modelo.put("listaReporteDiario", listaReporteDiario);
	     //Fin _ reportes
	     
	     return new ModelAndView("transcripcion/TranscripcionEntrada0", modelo); 
	   }     
        }

	// salida por defecto - error del navegador. u otra anormalidad
        return new ModelAndView("transcripcion/TranscripcionEntrada", modelo);        
    }
}