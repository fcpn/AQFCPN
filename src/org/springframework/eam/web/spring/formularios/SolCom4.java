package org.springframework.eam.web.spring.formularios;

import Ajayu_orm.orm_bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolCom4 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String codtar = request.getParameter("codtar");
        String fecha = request.getParameter("fecha");
        String num_sol = request.getParameter("num_sol");
        String correlativo_unidad = request.getParameter("correlativo_unidad");
        String destino = request.getParameter("destino");
        String tam_um = request.getParameter("tam_um");
        int lim = Integer.parseInt(tam_um);
        String var = "";

        String hy[] = new String[5000];
        for (int r = 0; r < lim; r++) {
            var = "uni_medida" + String.valueOf(r + 1);
            hy[r] = request.getParameter(var);
            // System.out.println("----:---: " + hy[r] + "    var var ----:---: " + var);
        }


        String unif[] = request.getParameterValues("unionFormulario");
        /*
        for(int y=0; y<=unif.length;y++){
        System.out.println(":: "+unif[y]);
        }
         */
        String idd[] = request.getParameterValues("idd");
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("fecha", fecha);
        String i_e = "3";
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        /*Sacando la actividad*/
        ProActTar tare = new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral", "selec", tare, tare);
        modelo.put("actividad", tare);
        /*Sacando la tarea*/
        ProActTar tar = new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codtar", tar, tar);
        modelo.put("tarea", tar);
        for (int g = 0; g < lim; g++) {
            Comprometido moscert = new Comprometido();
            moscert.setCodtar(codtar);
            moscert.setFecha(fecha);
            moscert.setNum_sol(num_sol);
            moscert.setId(idd[g]);
            moscert.setDestino(destino);
            moscert.setUni_medida(hy[g]);
            moscert.setCorrelativo_unidad(correlativo_unidad);
            System.out.println("entra ---> "+unif[g]);
            moscert.setUni(unif[g]);
            System.out.println("entra ---> "+unif[g]);

            orm.ejecutarObjeto("formularios", "actualiza_unidad_medida", moscert, null);
        }
        Comprometido moscert = new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        List mont = orm.ejecutarLista("formularios", "muestra_por_tarea", moscert, new Comprometido());
        String destinov = "No";
        String responsable = "No";
        List mont_ = new ArrayList();
        if (mont != null) {
            for (int i = 0; i < mont.size(); i++) {
                Comprometido ki = (Comprometido) mont.get(i);
                destinov = ki.getDestino();
                responsable = ki.getResponsable();
            }
        }
        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);
        modelo.put("lista_cert", mont);
        orm.cerrar();//cerrar la conexion    ahora vamos a jsp
        return new ModelAndView("formularios/SolCom4", modelo);
        //return new ModelAndView("", modelo);
    }
}
