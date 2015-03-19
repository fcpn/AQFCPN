package org.springframework.eam.web.spring.verificacion;

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

public class Verificacion1Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");

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
	   if (opcion.equals("verificacion")) {

	     //_ reportes
    	     Tarjeta user = new Tarjeta();
	     user.setId_usuario(id_usuario);
    	     //PagedListHolder listaReporteDiario = new PagedListHolder(this.eam.getListaReporteDiario(user));
	     //listaReporteDiario.setPageSize(listaReporteDiario.getNrOfElements());
    	     //modelo.put("listaReporteDiario", listaReporteDiario);
	     //Fin _ reportes
	
	     return new ModelAndView("verificacion/VerificacionEntrada0", modelo);
	   }     
	   if (opcion.equals("guardar") && !cod_img.equals("")) {
             request.getSession().removeAttribute("__cod_img");
	   
	     Tarjeta datos = new Tarjeta();
	     datos.setId_usuario(id_usuario);
	     datos.setCod_img(cod_img);
             System.out.println("kkkkkkk "+"antes de guardar: user:"+id_usuario+" cod_img:"+cod_img);           
	     this.eam.setGuardarTarjeta(datos);
             System.out.println("kkkkkkk "+"despues de guardar");           

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
        return new ModelAndView("transcripcion/TranscripcionEntrada", modelo);
        
    }
}