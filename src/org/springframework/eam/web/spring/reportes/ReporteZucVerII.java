package org.springframework.eam.web.spring.reportes;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class ReporteZucVerII implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        carreras car = new carreras();
        car.setIdcarrera(id_usuario);
        DecimalFormat formatonumber = new DecimalFormat("#,###,###,##0.00");
        List lista_fuentes_financiamiento = eam.getFuentesDeTareasByUsuario(car);
        // v[j][0]=codigo para actividad=2   tarea=3 
        // 0= codigo actividad=2  ::: tarea=3 :::  1= cabeceras de las fuentes de financiamiento
        // 1= codtar :: 2= descripcion tarea
        // 3 > fuentes de financiamiento     lista_fuentes_financiamiento.size()
        // 9000 = Cabecera Total General
        String M[][] = new String[1000][1000];
        int fi = 0;
        int co;
        int ffu = 0;
        List lista_actividades_usuario = eam.getActividadesByUsuario(car);
        String V[] = new String[1000];
        int fv = 0;
        for (int i = 0; i < lista_actividades_usuario.size(); i++) {
            ProActTar actividad = (ProActTar) lista_actividades_usuario.get(i);
            car.setCodacti(actividad.getCodacti());
            M[fi][0] = "2";//codifo fila actividad
            M[fi][1] = actividad.getCodacti();
            M[fi][2] = actividad.getDescripcion();
            fi++;
            co = 3;
            M[fi][0] = "1";//codigo fila cabeceras fuentes
            M[fi][1] = "Tarea";//codigo fila cabeceras fuentes
            M[fi][2] = "Descripcion";//codigo fila cabeceras fuentes
            if (i == 0) {
                ffu = fi;
            }
            for (int f = 0; f < lista_fuentes_financiamiento.size(); f++) {
                FuenteEconomica fuentefin = (FuenteEconomica) lista_fuentes_financiamiento.get(f);
                M[fi][co] = fuentefin.getCodfueneco();
                co++;
            }
            M[fi][co] = "Totales";
            fi++;
            List lista_tareas_usuario = eam.getTareasByUsuarioAndActividad(car);
            for (int j = 0; j < lista_tareas_usuario.size(); j++) {
                ProActTar tarea = (ProActTar) lista_tareas_usuario.get(j);
                M[fi][0] = "3";// codigo solo tarea
                M[fi][1] = tarea.getCodtar();
                M[fi][2] = tarea.getDescripcion();
                List lista_fuentes_tarea = eam.getFuentesAndMontosEjecutadosByTarea(tarea);
                Double totalfila = 0d;
                for (int f = 0; f < lista_fuentes_tarea.size(); f++) {
                    ProActTar fuentemontos = (ProActTar) lista_fuentes_tarea.get(f);
                    for (int fff = 0; fff < lista_fuentes_financiamiento.size(); fff++) {
                        if (M[ffu][3 + fff].equals(fuentemontos.getCodfueneco())) {
                            M[fi][3 + fff] = formatonumber.format(fuentemontos.getTotalmontoejecutadoingreso() - fuentemontos.getTotalmontoejecutadoegreso()) + "";
                            totalfila += fuentemontos.getTotalmontoejecutadoingreso() - fuentemontos.getTotalmontoejecutadoegreso();
                            if (fv == 0) {
                                V[fv] = fuentemontos.getCodfueneco();
                                fv++;
                                V[fv] = (fuentemontos.getTotalmontoejecutadoingreso() - fuentemontos.getTotalmontoejecutadoegreso()) + "";
                                fv++;
                            } else {
                                int sw = 0;
                                for (int vv = 0; vv < fv; vv = vv + 2) {
                                    if (V[vv].equals(fuentemontos.getCodfueneco())) {
                                        Double totalanterior = Double.parseDouble(V[vv + 1]);
                                        V[vv + 1] = (totalanterior + (fuentemontos.getTotalmontoejecutadoingreso() - fuentemontos.getTotalmontoejecutadoegreso())) + "";
                                        sw = 1;
                                    }
                                }
                                if (sw == 0) {
                                    V[fv] = fuentemontos.getCodfueneco();
                                    fv++;
                                    V[fv] = (fuentemontos.getTotalmontoejecutadoingreso() - fuentemontos.getTotalmontoejecutadoegreso()) + "";
                                    fv++;
                                }
                            }
                        }
                    }
                }
                M[fi][3 + lista_fuentes_financiamiento.size()] = formatonumber.format(totalfila) + "";
                fi++;
            }
            fi++;
        }
        Double totalGeneral = 0d;
        for (int yy = 0; yy < (fv - 1); yy = yy + 2) {
            totalGeneral += Double.parseDouble(V[yy + 1]);
            V[yy + 1] = formatonumber.format(Double.parseDouble(V[yy + 1]));
        }

        V[fv] = "Total General";
        fv++;
        V[fv] = formatonumber.format(totalGeneral);
        fv++;

        M[fi][0] = "9000";
        M[fi+1][0] = "9001";
        for (int yy = 0; yy < (fv - 1); yy = yy + 2) {

            for (int fff = 0; fff < lista_fuentes_financiamiento.size(); fff++) {
                if (M[ffu][3 + fff].equals(V[yy])) {
                    M[fi][3 + fff] = "Total Fuente " + M[ffu][3 + fff];
                    M[fi + 1][3 + fff] = V[yy + 1];
                }
            }
            if (yy == (fv - 2)) {
                M[fi][3 + lista_fuentes_financiamiento.size()] = "Total General";
                M[fi + 1][3 + lista_fuentes_financiamiento.size()] = V[yy + 1];
            }
        }
        fi = fi + 2;

        modelo.put("M", M);
        modelo.put("fi", (fi - 1));
        int columnas = 3 + lista_fuentes_financiamiento.size();
        modelo.put("co", columnas);
        modelo.put("fuentesusuario", lista_fuentes_financiamiento);
        return new ModelAndView("presupuestos3/carreras/MosPatEgrIngVerII", modelo);
    }
}
