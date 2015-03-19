package org.springframework.eam.web.spring.reportes;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class ReporteZucDet implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
       String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        String MT[][] = new String[1000][1000];

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        carreras car = new carreras();
        car.setIdcarrera(id_usuario);
        //listado de tareas del usuario
        List listado_tareas_usuario = orm.ejecutarLista("carreras", "listar_codigos_des", car, new ProActTar());

        MosPresuIng sing = new MosPresuIng();

        String V[][] = new String[1000][1000];
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        int i = 0;
        //ltu listado
        //      v[j][0]=codigo para actividad=2   tarea=3 :::   v[j][1]=codigo actividad   ::   v[j][2]=codigo tarea

        //      ::  v[j][3]=descricpion  ::  v[j][4]= fuentes economicas
        int c = 4;
        int cmax = 0;
        if (listado_tareas_usuario != null) {
            for (int j = 0; j < listado_tareas_usuario.size(); j++) {
                ProActTar tarea_usuario = (ProActTar) listado_tareas_usuario.get(j);
                ProActTar activi = new ProActTar();
                c = 4;
                if (j == 0) {
                    //tengo que sacar la actividad

                    activi.setCodtar(tarea_usuario.getCodtar());
                    orm.ejecutarObjeto("gral", "selec", activi, activi);
                    //insertar a la matriz la actividad y la tarea
                    //actividad
                    V[i][0] = "2";
                    V[i][1] = activi.getCodacti();
                    V[i][2] = activi.getCodacti();
                    V[i][3] = activi.getDescripcion();
                    V[i][c] = "0";
                    //tarea
                    i++;
                    V[i][0] = "3";
                    V[i][1] = tarea_usuario.getCodacti();
                    V[i][2] = tarea_usuario.getCodtar();
                    V[i][3] = tarea_usuario.getDescripcion();

                    ProActTar fuente = new ProActTar();
                    fuente.setCodtar(tarea_usuario.getCodtar());
                    List lis_fe_tar = orm.ejecutarLista("fuenteeconomica", "fuentes_disponibles_tarea", fuente, new ProActTar());
                    if (lis_fe_tar != null) {
                        for (int f = 0; f < lis_fe_tar.size(); f++) {
                            ProActTar fuen = (ProActTar) lis_fe_tar.get(f);
                            V[i][c] = fuen.getCodfueneco();
                            c++;
                        }
                    } else {
                        V[i][c] = "0";
                    }

                    i++;
                } else {
                    if (!V[i - 1][1].equals(tarea_usuario.getCodacti())) {
                        activi.setCodtar(tarea_usuario.getCodtar());
                        orm.ejecutarObjeto("gral", "selec", activi, activi);
                        //insertar a la matriz la actividad y la tarea
                        //actividad
                        V[i][0] = "2";
                        V[i][1] = activi.getCodacti();
                        V[i][2] = activi.getCodacti();
                        V[i][3] = activi.getDescripcion();
                        V[i][c] = "0";
                        //tarea
                        i++;
                        V[i][0] = "3";
                        V[i][1] = tarea_usuario.getCodacti();
                        V[i][2] = tarea_usuario.getCodtar();
                        V[i][3] = tarea_usuario.getDescripcion();

                        ProActTar fuente = new ProActTar();
                        fuente.setCodtar(tarea_usuario.getCodtar());
                        List lis_fe_tar = orm.ejecutarLista("fuenteeconomica", "fuentes_disponibles_tarea", fuente, new ProActTar());
                        if (lis_fe_tar != null) {
                            for (int f = 0; f < lis_fe_tar.size(); f++) {
                                ProActTar fuen = (ProActTar) lis_fe_tar.get(f);
                                
                                V[i][c] = fuen.getCodfueneco();
                                c++;
                            }
                        } else {
                            V[i][c] = "0";
                        }
                        i++;
                    } else {
                        V[i][0] = "3";
                        V[i][1] = tarea_usuario.getCodacti();
                        V[i][2] = tarea_usuario.getCodtar();
                        V[i][3] = tarea_usuario.getDescripcion();
                        ProActTar fuente = new ProActTar();
                        fuente.setCodtar(tarea_usuario.getCodtar());
                        List lis_fe_tar = orm.ejecutarLista("fuenteeconomica", "fuentes_disponibles_tarea", fuente, new ProActTar());
                        if (lis_fe_tar != null) {
                            for (int f = 0; f < lis_fe_tar.size(); f++) {
                                ProActTar fuen = (ProActTar) lis_fe_tar.get(f);
                                V[i][c] = fuen.getCodfueneco();
                                c++;
                            }
                        } else {
                            V[i][c] = "0";
                        }
                        i++;
                    }
                }
                if (c > cmax) {//para la maxima columna en fuentes economicas
                    cmax = c;
                }
            }

        }
        modelo.put("M", V);
        modelo.put("Fcl", Integer.toString(i));
        modelo.put("cmax", cmax);
        modelo.put("Ccl", "2");
        return new ModelAndView("presupuestos3/carreras/MostrarFuentesZuc", modelo);
    }
}
