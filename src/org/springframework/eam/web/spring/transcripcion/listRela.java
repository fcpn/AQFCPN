
package org.springframework.eam.web.spring.transcripcion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Departamento;

import org.springframework.eam.domain.Tarjeta;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class listRela implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
        String cod_registro =(String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");
        String clave = request.getParameter("clave");
        System.out.println("cod registro  ==> es "+ cod_registro);        
        Tarjeta relaciones = new Tarjeta();
        relaciones.setClave(clave);
        relaciones.setCod_img(cod_registro);
        
        
        int clavein=Integer.parseInt(clave.trim());
        if(clavein==1){
            relaciones.setClave("op1");
            relaciones.setClave("op1");
            relaciones.setCod_img(cod_registro);//<==== codigo
            PagedListHolder listarelaciones = new PagedListHolder(this.eam.getListaRelaciones(relaciones));
            listarelaciones.setPageSize(listarelaciones.getNrOfElements());
            modelo.put("listarelaciones", listarelaciones);
            System.out.println("op es 1");
            return new ModelAndView("transcripcion/listaRelacion", modelo);
        } else {
            
            if(clavein==2){Departamento provincia = new Departamento();
            provincia.setCod_depto("3");
             relaciones.setClave("op2");
            
           PagedListHolder listarelaciones = new PagedListHolder(this.eam.getListaRelaciones(relaciones));
            listarelaciones.setPageSize(listarelaciones.getNrOfElements());
            System.out.println("la opcion es 2");
            modelo.put("listaparientes", listarelaciones);
            return new ModelAndView("transcripcion/listaPariente", modelo);
            } else{
                Tarjeta tramites = new Tarjeta();
		tramites.setCod_img(cod_registro);
                tramites.setCodigo(clave);
                PagedListHolder listatramitestemporal = new PagedListHolder(this.eam.getListaTramitesTemporal(tramites));
                listatramitestemporal.setPageSize(listatramitestemporal.getNrOfElements());
                modelo.put("listatramitestemporal", listatramitestemporal);
                System.out.println("la opcion es 3");
                return new ModelAndView("transcripcion/listaTramite", modelo); }}
        
    }
}