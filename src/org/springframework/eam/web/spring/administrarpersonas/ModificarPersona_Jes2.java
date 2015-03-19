package org.springframework.eam.web.spring.administrarpersonas;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModificarPersona_Jes2 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        String id_persona = request.getParameter("id_persona");
        String nombres = request.getParameter("nombres");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String dip = request.getParameter("dip");
        String id_sexo = request.getParameter("id_sexo");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String ruta = request.getParameter("ruta");


        Personas persona = new Personas();


        persona.setZona("setRegistrarPersona");
        persona.setNombres(nombres);
        persona.setPaterno(paterno);
        persona.setMaterno(materno);
        persona.setDip(dip);
        persona.setId_sexo(id_sexo);
        persona.setFec_nacimiento(new Date());
        persona.setDireccion(direccion);
        persona.setId_estado_civil(0);
        persona.setTelefono(telefono);
        persona.setCorreo(correo);
   
        persona.setId_persona(id_persona);
        this.eam.updateModificarPersona(persona);
        
        persona.setId_persona(id_persona);
        persona = this.eam.getPersona(persona);
        modelo.put("per", persona);
        return new ModelAndView("administrarpersonas/ModificarPersona_Jes2", modelo);
    }
}
