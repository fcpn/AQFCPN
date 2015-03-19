package org.springframework.eam.web.spring.verificacion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Departamento;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.web.util.WebUtils;

// ajax imports
import org.jdom.*;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.springframework.eam.domain.DatosXml;

public class quitaPariente implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String cod_registro =(String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");

        String codigoG = request.getParameter("codigoG");
        
        String clave = request.getParameter("clave");//CLAVE DONDE ES  1=RELACIONES 2=PARIENTES 3= TRAMITES
        System.out.println(">>>>>>>>>>>>>>> "+codigoG);
        System.out.println(">>>>>>>>>>>>>>> "+clave);
	Tarjeta relacion = new Tarjeta();
	relacion.setCodigo(codigoG);
	relacion.setCod_img(cod_registro);//<==== codigo
	int resp;
        int clavein=Integer.parseInt(clave.trim());
        //PARA RELACIONES
        if(clavein==1){System.out.println("quitar en la tabla RELACIONES el registro con el codigo  "+ codigoG);
	    resp = this.eam.quitarRelaciones(relacion);
	
	}    
	          
         //PARA PARIENTESquita
        if(clavein==2) {System.out.println("quitar en la tabla PARIENTE el registro con el codigo : "+codigoG);
	    resp = this.eam.quitarParientes(relacion);
	}   
        
        
        //PARA TRAMITES
        if(clavein==3) {System.out.println("quitar en la tabla TRAMITE  el registro con el codigo: "+codigoG);   
	    Tarjeta tramites = new Tarjeta();
	    tramites.setCod_img(cod_registro);
	    tramites.setCodigo(codigoG);
	    int result = this.eam.quitarTramites(tramites);    	
        }     
        return new ModelAndView("transcripcion/TranscripcionEntrada1", modelo);
    }
}


