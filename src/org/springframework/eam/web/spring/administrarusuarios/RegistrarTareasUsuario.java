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
import org.springframework.eam.domain.carreras;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.util.WebUtils;

public class RegistrarTareasUsuario implements Controller {

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
        String codtars[] = request.getParameterValues("codtars");
        if (codtars != null) {
            for (int i = 0; i < codtars.length; i++) {
                String codtare = codtars[i];
                //sacar codigo de actividad
                ProActTar ativi = new ProActTar();
                ativi.setCodtar(codtare);
                ativi = this.eam.getActividad(ativi);
                //sacar numero de tareas a la tabla tarea
                ProActTar ttar = new ProActTar();
                ttar.setCodtar(codtare);
                ttar = this.eam.getTarea(ttar);
                //insertar a tabla carreras_pass
                carreras relacion = new carreras();
                relacion.setCodacti(ativi.getCodacti());
                relacion.setCodtar(codtare);
                int u = Integer.parseInt(ttar.getNum_tarea());
                relacion.setNum_tarea(u);
                relacion.setIdcarrera(id_usuario);
                this.eam.setCarreasRelacionUsuario(relacion);
            }
        }
        //todos los datos de persona
        Personas per = new Personas();
        per.setId_persona(id_persona);
        per = this.eam.getPersona(per);
        modelo.put("per", per);
        carreras relacion_usuario = new carreras();
        relacion_usuario.setIdcarrera(id_usuario);
        String M[][] = new String[1000][10];
        List tareas_usuario = this.eam.getListaTareasUsuario(relacion_usuario);

        for (int i = 0; i < tareas_usuario.size(); i++) {
            carreras tareas = (carreras) tareas_usuario.get(i);
            ProActTar tra = new ProActTar();
            tra.setCodtar(tareas.getCodtar());
            tra = this.eam.getTarea(tra);
            M[i][0]=tareas.getCodtar();
            M[i][1]=tra.getDescripcion();
            M[i][2]=Integer.toString(tareas.getNum_tarea());
        }
        modelo.put("M", M);
        modelo.put("filas", tareas_usuario.size());
        modelo.put("tareas_usuario", tareas_usuario);
        return new ModelAndView("administrarusuarios/TareasDeUsuario", modelo);
    }
}
