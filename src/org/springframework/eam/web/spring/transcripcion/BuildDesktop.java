package org.springframework.eam.web.spring.transcripcion;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

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

public class BuildDesktop implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String id_persona = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_persona");
	String id_rol = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_rol");

        String update = request.getParameter("update");
        if (update == null) update="";
	if (update.equals("update")) {
         String nombres = request.getParameter("nombres");
         String paterno = request.getParameter("paterno");
         String materno = request.getParameter("materno");
         String dip = request.getParameter("dip");
         String id_sexo = request.getParameter("id_sexo");
         String direccion = request.getParameter("direccion");
         String telefono = request.getParameter("telefono");
         String correo = request.getParameter("correo");
      
         Personas persona = new Personas();
         persona.setZona("setActualizarPersona");
         persona.setId_persona(id_persona);
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
         persona.setUlt_usuario(id_usuario);
         persona = (Personas) this.eam.setRegistrarPersona(persona);
        }

    Personas per = new Personas();
    per.setId_persona(id_persona);
    per = this.eam.getPersona(per);
    modelo.put("per",per);
    modelo.put("id_usuario",id_usuario);

        return new ModelAndView("transcripcion/BuildDesktop", modelo);
    }
}


