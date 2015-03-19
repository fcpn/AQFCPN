package org.springframework.eam.web.spring.buscar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Buscarpersona_Jes2 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        Personas persona = new Personas();
        String nombres = request.getParameter("nombres");
        String tipo_bus = request.getParameter("tipo_bus");
       
        List lista = new ArrayList();
        if (tipo_bus.equals("n")) {
            if (nombres.equals("*")) {
                nombres = "";
            }
            persona.setNombre_completo(nombres);
            lista = this.eam.getBuscarPersonaNombres(persona);
        } else {
            persona.setDip(nombres);
            lista = this.eam.getBuscarPersonaCi(persona);
        }

        

        PagedListHolder listaPersonas = new PagedListHolder(lista);
        listaPersonas.setPageSize(listaPersonas.getNrOfElements());
        
        modelo.put("listaPersonas", listaPersonas);
        modelo.put("tamanio", Integer.toString(lista.size()));

        return new ModelAndView("", modelo);
        //return new ModelAndView("administrarpersonas/ModificarPersona_Jes2", modelo);
    }
}
