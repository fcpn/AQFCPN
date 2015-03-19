
package org.springframework.eam.web.spring.transcripcion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Departamento;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class CajasDpto implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
       
         String opcion = request.getParameter("codigo");
	 
         String numero=opcion.trim();
         String clave = request.getParameter("clave");
	 
	 System.out.println("provincias: "+opcion+"---"+numero+"clave--- "+clave);
	 
         int clavein=Integer.parseInt(clave.trim());
         if(clavein==1){ Departamento provincia = new Departamento();
                      provincia.setCod_depto(numero);
                     PagedListHolder listaprovincia = new PagedListHolder(this.eam.getListaProvincia(provincia));
                     listaprovincia.setPageSize(listaprovincia.getNrOfElements());
                     modelo.put("listaprovincia", listaprovincia);
                    System.out.println("la opcion es 1"); 
                    return new ModelAndView("transcripcion/cajasDpto", modelo);} 
         else { 
         if(clavein==2){
                
                       Departamento seccion = new Departamento();
                      seccion.setCod_provincia(numero);
                     PagedListHolder listaseccion = new PagedListHolder(this.eam.getListaSeccion(seccion));
                     listaseccion.setPageSize(listaseccion.getNrOfElements());
                     modelo.put("listaseccion", listaseccion);
                
                      System.out.println("la opcion es 2"); 
                      return new ModelAndView("transcripcion/cajasSeccion", modelo);} 
            else {
                   if(clavein==3){
                
                       Departamento canton = new Departamento();
                      canton.setCod_seccion(numero);
                     PagedListHolder listacanton = new PagedListHolder(this.eam.getListaCanton(canton));
                     listacanton.setPageSize(listacanton.getNrOfElements());
                     modelo.put("listacanton", listacanton);
                
                      System.out.println("la opcion es 3"); 
                      return new ModelAndView("transcripcion/cajasCanton", modelo);} 
            else {
                   if(clavein==4){
                
                     Departamento localidad = new Departamento();
                     localidad.setCod_provincia(numero);
                         
                     String clavedep = request.getParameter("codep");
                     String claved=clavedep.trim();
                     localidad.setCod_depto(opcion);
                     PagedListHolder listalocalidad = new PagedListHolder(this.eam.getListaLocalidad(localidad));
                     listalocalidad.setPageSize(listalocalidad.getNrOfElements());
                     modelo.put("listalocalidad", listalocalidad);
                
                      System.out.println("la opcion es 4"+opcion); 
                      return new ModelAndView("transcripcion/cajasLocal", modelo);} 
            else {
                   return new ModelAndView("transcripcion/cajasDpto", modelo);}
            
            
            }
            
            }
       }
          
      
     
        
      
        
    }
}