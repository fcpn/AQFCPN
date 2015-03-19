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

public class SolCom9 implements Controller {

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

        String fecha_cbte="";
        String factura="";
        String fecha_factura="";
        String fecha_ing_material="";
        String corr_ing_mat="";

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
                fecha_cbte=ki.getFecha_cbte();
                modelo.put("fecha_cbte", fecha_cbte);
                factura=ki.getFactura();
                modelo.put("factura", factura);
                fecha_factura=ki.getFecha_factura();
                modelo.put("fecha_factura", fecha_factura);
                corr_ing_mat=ki.getCorrelativo_ing_material();
                modelo.put("corr_ing_mat", corr_ing_mat);

                if (nit != null) {
                    Comprometido bprovee = new Comprometido();
                    bprovee.setNit(nit);

                    orm.ejecutarObjeto("beneficiario", "todo", bprovee, bprovee);
                    modelo.put("bprovee", bprovee);
                }

                if (ki.getUni_medida().equals("No definido")) {
                    sw = "1";
                    i = mont.size();
                } else {
                    if (destinov.equals("No definido")) {
                        sw = "2";
                        i = mont.size();
                    } else {
                        if (nit.equals("No definido")) {
                            sw = "3";
                            i = mont.size();
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

        // orm.ejecutarObjeto("formularios", "distinto", moscert, moscert);
        //  modelo.put("dis", moscert);

        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("formularios/SolCom9", modelo);
    }
}
