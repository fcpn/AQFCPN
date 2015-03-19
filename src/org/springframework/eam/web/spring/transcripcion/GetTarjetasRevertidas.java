//_ Castillo Valencia
package org.springframework.eam.web.spring.transcripcion;

import java.util.*;
import java.lang.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Usuarios;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class GetTarjetasRevertidas implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String id_usuario  = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");	
	
        modelo.put("mensaje",this.eam.getTarjetasRevertir(id_usuario));       

        String ndir="/opt/tomcat/webapps/cp/images/tarjetas/"+id_usuario+"/";
        /* borrado de todo el contenido deldirectorio del usuario */       
	/* Codigo: Eddy Mendoza */
        File dir = new File(ndir);        
        if (dir.isDirectory()==true) {
            String[] files = dir.list();
            for ( int i=0;i<files.length;i++ ) {
                String narchivo= ndir+files[i];
                File f=new File(narchivo);
                if (f.isFile()==true) {
                    boolean sw=true;
                    sw=f.delete();
                } else {
                    System.out.println("No es un Archivo");
                }
            }
        } else {
            System.out.println("No es un directorio");
        }
	
        return new ModelAndView("ajax/Respuesta", modelo);        
    }
}