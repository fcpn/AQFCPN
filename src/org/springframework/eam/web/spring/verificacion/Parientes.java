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

public class Parientes implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String cod_registro =(String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");

        String id = request.getParameter("id");
        String ap_paterno = request.getParameter("ap_paterno");
        String ap_materno = request.getParameter("ap_materno");
        String nombre1 = request.getParameter("nombre1");
        String direccion = request.getParameter("direccion");
        String extranjero = request.getParameter("extranjero");
        String cedula = request.getParameter("cedula");
	String codigo = request.getParameter("codigo");

        String clave = request.getParameter("clave");  // P=parientes R=relaciones T=tramites 
        String key = request.getParameter("key");  // add=adisionar less=eliminar  

        //String nom1 = request.getParameter("");
        //String dir = request.getParameter("dir");
        //String ext = request.getParameter("ext");
        //
	//String apellp = request.getParameter("apellidop"); //AQUI SE RECIBE LA DESCRIPCION EN CASO DE TRAMITE!!!!!!
        //String cod_parentesco = request.getParameter("rol"); //AQUI SE ESCRIBE EL TIPO DE TRAMITE ESCOGIDO  EN CASO DE TRAMITE!!
        //String apellm = request.getParameter("apellidom");
	//String codigo = request.getParameter("codigoG");//<======== no mando nada 
        //String clave = request.getParameter("clave");//DONDE clave  ES  1=RELACIONES 2=PARIENTES 3=TRAMITES
        //===================================seteando =========================================
	System.out.println("id---------"+id);
	System.out.println("pat---------"+ap_paterno);
	System.out.println("mat---------"+ap_materno);
	System.out.println("pnom---------"+nombre1);
	System.out.println("direccion---------"+direccion);
	System.out.println("ext---------"+extranjero);
	System.out.println("cedula---------"+extranjero);
	System.out.println("codigo---------"+codigo);
	System.out.println("clave---------"+clave);
	System.out.println("key---------"+key);
	
	Tarjeta datos = new Tarjeta();
	  datos.setDescripcion(id);
	  datos.setId_usuario(id_usuario);
	  datos.setCod_img(cod_registro);//<==== codigo
	if (key.equals("less")) {
	try {
	  datos.setCodigo(codigo);
	} catch (Exception e) {}
	}
	  
        if (key.equals("add")  && (clave.equals("P") || clave.equals("R"))) {
	  datos.setNombre1(nombre1);
	  datos.setDireccion(direccion);
	  datos.setId_pais(extranjero);
	  datos.setAp_paterno(ap_paterno);
	  datos.setAp_materno(ap_materno);
	  datos.setCedula(cedula);
	}
	
	if(clave.equals("R")) {
	   if (key.equals("add"))
	      datos.setDato("add_rel");
	   else      
	      datos.setDato("less_rel");
	      
	   modelo.put("relaciones",this.eam.setRelaciones(datos));
	   return new ModelAndView("transcripcion/Relaciones", modelo);
	   
	}
	if(clave.equals("P")) {
	   if (key.equals("add"))
	      datos.setDato("add_par");
	   else      
	      datos.setDato("less_par");
	      
	   modelo.put("parientes",this.eam.setRelaciones(datos));
	   return new ModelAndView("transcripcion/Parientes", modelo);
	   
	}
	if(clave.equals("T")) {
	   if (key.equals("add")) {
	      datos.setDireccion(direccion);
	      datos.setDato("add_tra");
	   }      
	   else      
	      datos.setDato("less_tra");
	      
	   modelo.put("tramites",this.eam.setRelaciones(datos));
	   return new ModelAndView("transcripcion/Tramites", modelo);
	   
	}
	//else if(clave.equals("P")') {
	//}
	return new ModelAndView("Aviso",modelo);
	
	
	
        //int resp;
        
                //======================mensajes SOLO para compilacion
                //System.out.println("los nombres recibidos por el controlador son "+ nom1+" "+nom2 +" "+nom3);        
                //System.out.println("el apellido paterno  ==> es "+ apellp);        
                //System.out.println("el apellido materno   es "+ apellm);                //
                //System.out.println("cod_registro enviado al SET  es"+ cod_registro);
                //====================================================
        
        
        //int clavein=Integer.parseInt(clave.trim());
        //se escoge si lo que guardaremos sera un registro de relaciones , parientes o tramites
        
        //PARA RELACIONES
        //if(clavein==1){System.out.println("es nueva relacion de "+cod_parentesco); 
	//               resp = this.mi.setRelaciones(parientes); }    
        
        //PARA PARIENTES
        //if(clavein==2) {System.out.println("es nuevo pariente : "+cod_parentesco); 
	//    resp = this.mi.setParientes(parientes); }
        
        
        //PARA TRAMITES
        //if(clavein==3) {System.out.println("es nuevo tramite: "+cod_parentesco); 
        
	//Tarjeta tramites = new Tarjeta();
	//tramites.setDescripcion(nom1);
        //tramites.setCod_img(cod_registro);
	//tramites.setCodigo(cod_parentesco);
	//int result = this.mi.setTramites(tramites);
	//}     
        //   resp = this.mi.setTramites(parientes); }
        //return new ModelAndView("transcripcion/TranscripcionEntrada1", modelo);
    }
}


