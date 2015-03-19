package org.springframework.eam.web.spring.formularios.proyectos;
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
import org.springframework.web.util.WebUtils;

public class SolFor2 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        String codtar = request.getParameter("codtar");
        String fecha = request.getParameter("fecha");
        String num_sol = request.getParameter("num_sol");
        String correlativo_unidad = request.getParameter("correlativo_unidad");
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("fecha", fecha);
        String i_e = "3";
        modelo.put("codtar", codtar);
        orm_bd orm = new orm_bd();
        orm.verCompilado = "C";
        mconexion m = new mconexion();
        orm.establecerConexion(m.extraerConexion("url1"));
       
        ProActTar tare = new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral", "selec", tare, tare);
        modelo.put("actividad", tare);

        /*Sacando la tarea*/
        ProActTar tar = new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codtar", tar, tar);
        modelo.put("tarea", tar);


        /*Listado de los correlativos de las certificaciones en proceso*/
        Comprometido moscert = new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        List mont = orm.ejecutarLista("formularios", "muestra_por_tarea", moscert, new Comprometido());
        modelo.put("lista_cert", mont);
        String destinov = "No";
        String responsable = "No";
        List mont_ = new ArrayList();
        double sum = 0;
        if (mont != null) {
            for (int i = 0; i < mont.size(); i++) {
                Comprometido ki = (Comprometido) mont.get(i);
                destinov = ki.getDestino();
                responsable = ki.getResponsable();
                sum = sum + Double.parseDouble(ki.getMonto());
            }
        }
        modelo.put("sum", sum);
        List u_medida = orm.ejecutarLista("formularios", "listar_unidades_medida", moscert, new Comprometido());
        modelo.put("u_medida", u_medida);
        modelo.put("tam_um", mont.size());
        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);
        orm.cerrar();
        return new ModelAndView("presupuestos3/formularios/SolFor2", modelo);
    }
}
