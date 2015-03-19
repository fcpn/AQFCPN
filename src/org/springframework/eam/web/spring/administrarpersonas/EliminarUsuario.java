/*
 * Jesus Reynaldo Perez Benavides

 */
package org.springframework.eam.web.spring.administrarpersonas;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.util.WebUtils;

public class EliminarUsuario implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String id_persona = request.getParameter("id_persona");
        String nom_persona = request.getParameter("nom_persona");
        modelo.put("nom_persona", nom_persona);
        Administrativos adm = new Administrativos();
        adm.setId_persona(id_persona);
        adm = this.eam.getAdministrativo(adm);
        String id_usuario = adm.getId_administrativo();
        String mcarrerasusuario = "";
        if (adm != null) {
            System.out.println("entro primer if");
            carreras tareasUsuario = new carreras();
            tareasUsuario.setIdcarrera(id_usuario);
            List listaTareasUsuario = this.eam.getListaTareasUsuario(tareasUsuario);
            if (listaTareasUsuario != null) {
                try {
                    System.out.println("entro segundo if");
                    tareasUsuario.setIdcarrera(adm.getId_administrativo());
                    this.eam.setEliminaRelacionTareasUsuarios(tareasUsuario);
                    mcarrerasusuario = mcarrerasusuario + " ,se eliminaron relaciones con tareas, ";
                } catch (Exception e) {
                    mcarrerasusuario = mcarrerasusuario + " ,no tiene relaciones con tareas, ";
                    System.out.println("NO TIENE TAREAAAAAAAAAAAAAAAAAAAAAS");
                }
            }
        }
        try {
            Usuarios us = new Usuarios();
            us.setId_usuario(id_usuario);
            this.eam.setEliminarLoginStatus(us);
            mcarrerasusuario = mcarrerasusuario + " ,se eliminaron logeoFs de estado, ";
        } catch (Exception e) {
            mcarrerasusuario = mcarrerasusuario + " ,no tiene logeos de estado, ";
        }
        try {
            Usuarios uss = new Usuarios();
            uss.setId_usuario(id_usuario);
            uss.setId_programa(id_programa);
            this.eam.setBorrarRolesUsuario(uss);
            mcarrerasusuario = mcarrerasusuario + " ,se eliminaron relaciones con roles, ";
        } catch (Exception e) {
            mcarrerasusuario = mcarrerasusuario + " ,no tiene relaciones con roles, ";
        }
        try {
        Usuarios usss = new Usuarios();
        usss.setId_usuario(id_usuario);
        this.eam.setEliminarUsuario(usss);
        mcarrerasusuario = mcarrerasusuario + " ,se eliminaron los registros del usuario de entrada, ";
        } catch (Exception e) {
        mcarrerasusuario = mcarrerasusuario + " ,no tiene registros de usuario de entrada, ";
        }
        try {
        Administrativos ads = new Administrativos();
        ads.setId_administrativo(id_usuario);
        this.eam.setElimiarAdministrativo(ads);
        mcarrerasusuario = mcarrerasusuario + " ,se eliminaron las relaciones de usuarios admin del sistema, ";
        } catch (Exception e) {
        mcarrerasusuario = mcarrerasusuario + " ,no tiene relaciones de usuarios admin del sistema, ";
        }
        try {
        Personas per = new Personas();
        per.setId_persona(id_persona);
        this.eam.setEliminaPersona(per);
        mcarrerasusuario = mcarrerasusuario + " ,se eliminaron complemamente del sistema, ";
        } catch (Exception e) {
        mcarrerasusuario = mcarrerasusuario + " ,no se borro a la persona registrada, ";
        }
        return new ModelAndView("administrarusuarios/EliminarUsuario", modelo);
    }
}
