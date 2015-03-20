package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class GralFuen2 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

        String codfueneco = request.getParameter("codfueneco");
        modelo.put("codfueneco", codfueneco);
        String descripcion = request.getParameter("descripcion");
        modelo.put("descripcion", descripcion);
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

        List pat = orm.ejecutarLista("tarea", "tareas", null, new Rubro());
        String[][] V = new String[1000][1000];
        int []cnt=new int[1000];
        if (pat != null) {
//            ProActTar e = new ProActTar();
            for (int i = 0; i < pat.size(); i++) {
                Rubro e = (Rubro) pat.get(i);
                V[i][0] = e.getCodtar();
                V[i][1] = e.getDescripcion();
                
                ProActTar fuente = new ProActTar();
                fuente.setCodtar(e.getCodtar());
                
                List lis_fe_tar = orm.ejecutarLista("fuenteeconomica", "fuentes_disponibles_tarea", fuente, new ProActTar());
                cnt[i]=lis_fe_tar.size();
//                 ee=new ProActTar();
                for (int j=0;j<lis_fe_tar.size();j++){
                   ProActTar ee = (ProActTar) lis_fe_tar.get(j);
                    V[i][j*2+2]=ee.getCodfueneco();
                    V[i][j*2+3]=ee.getDescripcion();
                    
                }
            }
        }
        modelo.put("tam", pat.size());
        modelo.put("v", V);
        modelo.put("cnt", cnt);

        orm.cerrar();//cerrar la conexion

        return new ModelAndView("presupuestos3/fuentes/MosPatEgrI", modelo);
    }

}
