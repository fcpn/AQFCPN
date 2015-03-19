package org.springframework.eam.web.spring.formularios;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
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

public class SolComUc7 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        String codtar = request.getParameter("codtar");
        String fecha = request.getParameter("fecha");
        String codacti = request.getParameter("codacti");
        String num_sol = request.getParameter("num_sol");
        String correlativo_unidad = request.getParameter("correlativo_unidad");
        String correlativo_orden_compra = request.getParameter("correlativo_orden_compra");

        modelo.put("correlativo_orden_compra", correlativo_orden_compra);
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("fecha", fecha);
        modelo.put("codtar", codtar);
        modelo.put("codacti", codacti);

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
        String nit = "No";
        String cbte = "No";
        String cheque = "No";

        String sw = "3";
        // List mont_=new ArrayList();
        if (mont != null) {



            for (int i = 0; i < mont.size(); i++) {
                Comprometido ki = (Comprometido) mont.get(i);

                destinov = ki.getDestino();
                responsable = ki.getResponsable();
                nit = ki.getNit_proveedor();
                cbte=ki.getCbte();
                cheque=ki.getCheque();

                if (nit != null) {
                    Comprometido bprovee = new Comprometido();
                    bprovee.setNit(nit);

                    orm.ejecutarObjeto("beneficiario", "todo", bprovee, bprovee);
                    modelo.put("bprovee", bprovee);
                }

                if (ki.getUni_medida().equals("No definido")) {
                    sw = "1";
                    i = mont.size();
                    System.out.println("no unidad " + ki.getUni_medida());
                    System.out.println("no unidad " + ki.getUni_medida());
                } else {
                    if (destinov.equals("No definido")) {
                        sw = "2";
                        i = mont.size();
                        System.out.println("no destino " + destinov);
                        System.out.println("no destino " + destinov);
                    } else {
                        if (nit.equals("No definido")) {
                            sw = "3";
                            i = mont.size();
                            System.out.println("No nit " + nit);
                            System.out.println("No nit " + nit);
                        }
                    }
                }



            }

        }




        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);

        modelo.put("nitt", nit);
        modelo.put("cheque", cheque);
        modelo.put("cbte", cbte);
        modelo.put("sw", sw);
        orm.cerrar();
        return new ModelAndView("formularios/SolComUc7", modelo);
    }
}
