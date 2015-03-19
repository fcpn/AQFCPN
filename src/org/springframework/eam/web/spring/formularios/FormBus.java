package org.springframework.eam.web.spring.formularios;

import Ajayu_orm.orm_bd;
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

public class FormBus implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String num = request.getParameter("num");
        String opbus = request.getParameter("opbus");
        orm_bd orm = new orm_bd();
        orm.verCompilado = "C";
        mconexion m = new mconexion();
        orm.establecerConexion(m.extraerConexion("url1"));
        Comprometido moscert = new Comprometido();
        List mont = null;
        if (opbus.equals("oc")) {
            moscert.setCorrelativo_orden_compra(num);
            mont = orm.ejecutarLista("formularios", "por_corr_or_compra", moscert, new Comprometido());
        } else {
            moscert.setCorrelativo_unidad(num);
            mont=orm.ejecutarLista("formularios","por_corr_sol_compra",moscert,new Comprometido());
        }
        modelo.put("correlativo", mont);
        orm.cerrar();
        return new ModelAndView("formularios/FormBus", modelo);
    }
}
