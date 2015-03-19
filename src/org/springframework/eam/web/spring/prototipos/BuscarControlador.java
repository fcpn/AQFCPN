package org.springframework.eam.web.spring.prototipos;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.lang.Integer;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BuscarControlador implements Controller {
        
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      Map modelo = new HashMap();









      String id_persona = request.getParameter("id_persona");
      String id_estudiante = request.getParameter("id_estudiante");
      String dip = request.getParameter("dip");
      String nombre_completo = request.getParameter("nombre_completo");
      String programa = request.getParameter("programa");
      //Id_programa, no es necesario pues es el mismo con el que se manda... para la busqueda
      if(id_persona == null) {
        String salida = "/prototipo.do";
        String titulo = "TITULO DEL MODULO QUE SOLICITA LA BUSQUEDA";
        modelo.put("salida", salida);
        modelo.put("titulo", titulo);
	modelo.put("id_programa", "EST"); //NOMBRE DEL PROGRAMA.. ES NECESARIO!! sirve para definir la 
                              //region de la busqueda 
	
        return new ModelAndView("buscar/BuscarPersonaEstudiante", modelo); ///ESTO NO SE CAMBIA
      }




    modelo.put("nombre_completo", nombre_completo);
    modelo.put("dip", dip);
    modelo.put("id_persona", id_persona);
    modelo.put("id_estudiante", id_estudiante);
    modelo.put("programa", programa);
      
    return new ModelAndView("prototipos/PrototipoSalida", modelo);
    
  }
}    
  