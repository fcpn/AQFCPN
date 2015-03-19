package org.springframework.eam.web.spring.administrarusuarios;

import java.util.*;
import java.util.Map;
import java.lang.String;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.ProActTar;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.util.WebUtils;

public class SetRegistrarUsuarioAquiles implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String id_prog = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String id_persona = request.getParameter("id_persona");
        modelo.put("id_persona", id_persona);
        String id_usuario = request.getParameter("id_usuario");
        modelo.put("id_usuario", id_usuario);
        String clave = request.getParameter("clave");
        String ops = request.getParameter("ops");
        //todos los datos de persona
        Personas per = new Personas();
        per.setId_persona(id_persona);
        per = this.eam.getPersona(per);
        modelo.put("per", per);
        int res = -1;
        Administrativos administrativo = new Administrativos();
        administrativo.setId_administrativo(id_usuario);
        administrativo.setId_persona(id_persona);
        administrativo.setCargo("Operador");
        administrativo.setId_programa("PRE");
        administrativo.setUlt_usuario("sistema");
        //jesus
        res = this.eam.setRegistrarAdministrativo(administrativo);
        //jesus
        Usuarios usuario = new Usuarios();
        usuario.setId_usuario(id_usuario);
        usuario.setClave(clave);
        usuario.setRecordatorio("ninguno");
        usuario.setId_programa("PRE");
        usuario.setUlt_usuario("sistema");
        res = this.eam.setRegistrarUsuariosAdm(usuario);
        res = 2;
        if (res > -1) {
            if (ops.equals("zuc")) {
                usuario.setId_rol(ops);
                usuario.setFec_expiracion(new Date());
                res = this.eam.setRegistrarUsuariosRoles(usuario);
                List tareas = this.eam.getListarTareas(new ProActTar());
                modelo.put("tareass", tareas);
                return new ModelAndView("administrarusuarios/UsuarioTareas", modelo);
            }
            if (ops.equals("adm")) {
                //Administrador
                usuario.setId_rol("op1");
                usuario.setFec_expiracion(new Date());
                res = this.eam.setRegistrarUsuariosRoles(usuario);
                usuario.setId_rol("sisp");
                usuario.setFec_expiracion(new Date());
                res = this.eam.setRegistrarUsuariosRoles(usuario);
                usuario.setId_rol("sispc");
                usuario.setFec_expiracion(new Date());
                res = this.eam.setRegistrarUsuariosRoles(usuario);
                usuario.setId_rol("sispg");
                usuario.setFec_expiracion(new Date());
                res = this.eam.setRegistrarUsuariosRoles(usuario);
                return new ModelAndView("administrarusuarios/UsuarioAdministrador", modelo);
            }
            if (ops.equals("usarea")) {
                // usuario Area
                usuario.setId_rol("form");
                usuario.setFec_expiracion(new Date());
                res = this.eam.setRegistrarUsuariosRoles(usuario);
                return new ModelAndView("administrarusuarios/UsuarioAreadesconcentrada", modelo);
            }
        }
        return new ModelAndView("administrarusuarios/UsuarioInfo", modelo);
    }
}