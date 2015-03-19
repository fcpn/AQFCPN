package org.springframework.eam.web.spring.administrarpersonas;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.List;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.Personas;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class RegistrarPersona_Jes2 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

        String nombres = request.getParameter("nombres");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String dip = request.getParameter("dip");
        String id_sexo = request.getParameter("id_sexo");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String ruta = request.getParameter("ruta");


        String _error = new String("");
        if ("".equals(nombres) || "".equals(dip) || "".equals(paterno)) {
            _error = "Los Campo(s) ";
            if ("".equals(nombres)) {
                _error = _error + "Nombres, ";
            }
            if ("".equals(dip)) {
                _error = _error + "Cedula, ";
            }
            if ("".equals(paterno)) {
                _error = _error + "sexo, ";
            }
            _error = _error + "son obligatorios...";
            modelo.put("_error", _error);
        }
        if(!_error.equals("")) {
           return new ModelAndView("administrarusuarios/RegistrarPersona_Jes", modelo);
        }





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
        persona.setUlt_usuario(ult_usuario);
        persona = (Personas) this.eam.setRegistrarPersona(persona); ///1 ibatis


        //(paternoMaternoNombreTodoCi)
        String idd_per;
        idd_per = paterno.substring(0, 1) + materno.substring(0, 1) + nombres.substring(0, 1) + dip;
        idd_per = idd_per.toUpperCase();
        System.out.println("idd_PERPER--->" + idd_per);
        System.out.println("idd_PERPER--->" + idd_per);
        System.out.println("idd_PERPER--->" + idd_per);
        System.out.println("idd_PERPER--->" + idd_per);

        persona.setId_persona(idd_per);
        persona = this.eam.getPersona(persona);

        modelo.put("per", persona);
        //return new ModelAndView("administrarusuarios/UsuarioInfo", modelo);
        //return new ModelAndView("", modelo);

        return new ModelAndView("administrarpersonas/RegistrarPersona_Jes2", modelo);
    }
}
