package org.springframework.eam.web.spring.buscar;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class BuscarPersonaControlador implements Controller {
        
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();
    List lista = new ArrayList();
    Personas persona = new Personas();
    
    String titulo = request.getParameter("titulo");
    String salida = request.getParameter("salida");
    String vista = request.getParameter("vista");
    if (vista == null || "".equals(vista))
       vista = "buscar/BuscarPersona";
    
    String busqueda = request.getParameter("busqueda");
    String entrada = request.getParameter("entrada");
    
  if (!"".equals(entrada)) {
    //En caso de que la busqueda sea por ci
    if ("ci".equals(busqueda)) {
      persona.setDip(entrada);
      lista = this.eam.getBuscarPersonaCi(persona);
    }
    //En caso de que la busqueda sea por nombre
    if ("nombres".equals(busqueda)) {
      if (entrada.equals("*")) entrada = "";
      persona.setNombre_completo(entrada);
      lista = this.eam.getBuscarPersonaNombres(persona);
    }

    PagedListHolder listaPersonas = new PagedListHolder(lista);
    listaPersonas.setPageSize(listaPersonas.getNrOfElements());
    modelo.put("listaPersonas", listaPersonas);
    modelo.put("tamanio", Integer.toString(lista.size()));
  } 
  else {
    modelo.put("_error", "No se completaron datos requeridos");
  }
    modelo.put("salida", salida);
    modelo.put("titulo", titulo);
    modelo.put("entrada", entrada);
    modelo.put("busqueda", busqueda);
    modelo.put("vista", vista);
    return new ModelAndView(vista,modelo);
  }
}
  