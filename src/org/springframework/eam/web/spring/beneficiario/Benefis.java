package org.springframework.eam.web.spring.beneficiario;

import org.springframework.eam.web.spring.administrarpersonas.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class Benefis implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

        //String id_persona = request.getParameter("id_persona");
        //Personas persona = new Personas();
        //persona.setId_persona(id_persona);
        //persona = this.eam.getPersona(persona);
        //modelo.put("per", persona);
        return new ModelAndView("beneficiario/Benefis", modelo);
    }
}
