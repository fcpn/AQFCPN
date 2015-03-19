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

public class SolComUc71_1 implements Controller {

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

        String destino = request.getParameter("destino");
        String cheque = request.getParameter("cheque");
        String cbte = request.getParameter("cbte");
        String nit = request.getParameter("nit");


        modelo.put("codtar", codtar);
        modelo.put("fecha", fecha);
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("destino", destino);
        modelo.put("destino", destino);
        modelo.put("codacti", codacti);



        String i_e = "3";

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

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

        /*consulta para sacar el correlativo de la unidad*/
        ProActTar programa = new ProActTar();
        orm.ejecutarObjeto("proacttar", "mostrar_programa", null, programa);
        System.out.println(programa.getCorrelativo_orden_compra());
        int coc = Integer.valueOf(programa.getCorrelativo_orden_compra()).intValue();

        if (Integer.valueOf(correlativo_orden_compra).intValue() == 0) {
            coc++;
            programa.setCorrelativo_orden_compra(Integer.toString(coc));
            programa.setCodpro(tare.getCodpro());
            orm.ejecutarObjeto("programa", "mas_correlativo_orden_compra", programa, null);
        }else {
            coc = Integer.valueOf(correlativo_orden_compra).intValue();
        }

        Comprometido moscerte = new Comprometido();
        moscerte.setCodtar(codtar);
        moscerte.setCorrelativo_unidad(correlativo_unidad);
        moscerte.setNit_proveedor(nit);
        moscerte.setCorrelativo_orden_compra(Integer.toString(coc));
        moscerte.setCbte(cbte);
        moscerte.setCheque(cheque);
        orm.ejecutarObjeto("formularios", "nit_a_todos", moscerte, null);



        /*Listado de los correlativos de las certificaciones en proceso*/
        Comprometido moscert = new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        List mont = orm.ejecutarLista("formularios", "muestra_por_tarea", moscert, new Comprometido());
        /*orm.ejecutarObjeto("formularios", "distinto", moscert, moscert);
        modelo.put("dis", moscert);*/
        String destinov = "No";
        String responsable = "No";
        String sw = "0";
        List mont_ = new ArrayList();
        if (mont != null) {



            for (int i = 0; i < mont.size(); i++) {
                Comprometido ki = (Comprometido) mont.get(i);
                destinov = ki.getDestino();
                responsable = ki.getResponsable();
                nit = ki.getNit_proveedor();

                sw = "1";
            }
        }

        /*Buscando el proveedor segun el NIT*/
        Comprometido pro = new Comprometido();
        pro.setCodtar(codtar);
        pro.setCorrelativo_unidad(correlativo_unidad);
        pro.setNit_proveedor(nit);
        orm.ejecutarObjeto("beneficiarios_proveedores", "buscar_con_nit", pro, pro);
        modelo.put("pro", pro);

        List suc = orm.ejecutarLista("beneficiarios_proveedores", "todas_sucursales", pro, new Comprometido());
        modelo.put("lis_suc", suc);


        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);
        modelo.put("lista_cert", mont);
        modelo.put("nit", nit);



        modelo.put("sw", sw);
        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("formularios/SolComUc71_1", modelo);
    }
}