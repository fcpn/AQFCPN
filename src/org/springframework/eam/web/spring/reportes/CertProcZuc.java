package org.springframework.eam.web.spring.reportes;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class CertProcZuc implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        orm_bd orm = new orm_bd();
        orm.verCompilado = "C";
        mconexion m = new mconexion();
        orm.establecerConexion(m.extraerConexion("url1"));
        List pat = orm.ejecutarLista("gral", "mostrar_pat", null, new Rubro());
        carreras car = new carreras();
        car.setIdcarrera(id_usuario);
        List mat = orm.ejecutarLista("carreras", "listar_codigos", car, new Rubro());
        String V[][] = new String[1000][1000];
        int i = 0;
        if (mat != null) {
            for (int j = 0; j < mat.size(); j++) {
                Rubro ki = (Rubro) mat.get(j);
                String tg = ki.getCodtar();

                for (int g = 0; g < pat.size(); g++) {
                    Rubro kii = (Rubro) pat.get(g);
                    String th = kii.getCodigo();

                    if (tg.equals(th)) {

                        Rubro kiii = (Rubro) pat.get(g - 1);
                        String thh = kiii.getCodigo();

                        if (kiii.getTipo().equals("1")) {
                            V[i][0] = kiii.getCodigo();
                            V[i][1] = kiii.getDescripcion();
                            V[i][2] = kiii.getTipo();
                        } else {
                            V[i][0] = " ";
                            V[i][1] = " ";
                            V[i][2] = "5";
                        }                        
                        if (kiii.getTipo().equals("2")) {
                            V[i][0] = kiii.getCodigo();
                            V[i][1] = kiii.getDescripcion();
                            V[i][2] = kiii.getTipo();
                        } else {
                            V[i][0] = " ";
                            V[i][1] = " ";
                            V[i][2] = "5";
                        }

                        i++;
                        V[i][0] = kii.getCodigo();
                        V[i][1] = kii.getDescripcion();
                        V[i][2] = kii.getTipo();
                        i++;
                    }
                }

            }
        } else {
            modelo.put("pat", pat);
        }
        modelo.put("M", V);
        modelo.put("Fcl", Integer.toString(i));
        modelo.put("Ccl", "2");
        orm.cerrar();
        return new ModelAndView("presupuestos3/carreras/MosPatEgrIngCertProc", modelo);
    }
}
