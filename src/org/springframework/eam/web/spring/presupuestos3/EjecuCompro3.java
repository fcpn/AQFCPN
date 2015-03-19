package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.InsRef;


import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EjecuCompro3 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String codtar = request.getParameter("codtar");
        modelo.put("codtar", codtar);
        //llevando fuente actividad + descripcion
        String codacti = request.getParameter("codacti");
        modelo.put("codacti", codacti);
        //Montos Montos
        String mon[] = request.getParameterValues("monto");
        String monto[] = new String[10000];
        //dia mes anio
        String d[] = request.getParameterValues("dia");
        String mm[] = request.getParameterValues("mes");
        String a[] = request.getParameterValues("anio");
        String fecha[] = new String[10000];
        //glosa
        String gloo[] = request.getParameterValues("glosa");
        String glossa[] = new String[10000];
        //comprobante
        String cbt[] = request.getParameterValues("cbte");
        String cbte[] = new String[10000];
        int jj = 0;
        /*  for(int i = 0 ; i < mon.length ; i++)
        {
        String[] hm = mon[i].split("::");
        monto[jj]=hm[0];
        System.out.println("0 --- "+monto[jj]);
        jj++;
        }
         */
        System.out.println("*********************Complemento*********************************************************");
        String comple[] = request.getParameterValues("complemento");
        String compro[] = new String[10000];
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos

        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1         
        InsPreIng pre = new InsPreIng();
        InsRef u = new InsRef();
        Comprometido gr = new Comprometido();
        int j = 0;
        
        for (int i = 0; i < comple.length; i++) {
            //System.out.println(com[i]);
            String[] h = comple[i].split("::");
            compro[j] = h[0];//codmonegr
            compro[j + 1] = h[1];//codfueneco
            compro[j + 2] = h[2];//monto anterior
            System.out.print("MONTO anteror??? -- "+compro[j + 2]);
            

            //--- System.out.print("2 --- "+compro[j+2]);
            compro[j + 3] = h[3];//id
            System.out.print("ID??? -- "+ compro[j + 3]);
            Comprometido mco = new Comprometido();
            mco.setId(compro[j + 3]);
            orm.ejecutarObjeto("comproegr", "busco_por_id", mco, mco);
            System.out.print("---------");
            System.out.print("---------");
            System.out.print("---------");
            System.out.println("ID -- "+ mco.getId()+" glosa::  "+mco.getGlosa()+ "resp  :: "+ mco.getResponsable());
            //preguntar si existe el item en la tabla formulariooooos
            //buscar en los formularios y update a culminado OKOK
            Comprometido sf = new Comprometido();
            sf.setMonto(mco.getMonto());
            sf.setCodtar(mco.getCodtar());
            sf.setCodfueneco(mco.getCodfueneco());
            sf.setCodmonegr(mco.getCodmonegr());
            sf.setGlosa(mco.getGlosa());
            sf.setNum_sol(mco.getNum_sol());
            sf.setCantidad(mco.getCantidad());
            sf.setResponsable(mco.getResponsable());
            sf.setGlo_rut(mco.getGlo_rut());
            orm.ejecutarObjeto("formularios", "busca_item", sf, sf);
           
                Comprometido modfor = new Comprometido();
                modfor.setId(sf.getId());
                modfor.setCulmi_anula("culminado");
                orm.ejecutarObjeto("formularios", "modificar_culmi_anula", modfor, null);
            



            compro[j + 4] = h[4];//ref123
                   /*montos nuevos*/
            String[] hm = mon[i].split("::");
            monto[jj] = hm[0];//monto's'
            System.out.print("MONTO??? -- "+monto[jj]);
            String[] dd = d[i].split("::");
            String[] mmm = mm[i].split("::");
            String[] aa = a[i].split("::");
            fecha[jj] = dd[0] + "/" + mmm[0] + "/" + aa[0];
            String[] ggo = gloo[i].split("::");
            glossa[jj] = ggo[0];
            String[] cb = cbt[i].split("::");
            cbte[jj] = cb[0];
            //////////////////////////////////////////////////////////////////////////
            //insertar montosejecutados
            pre.setCodmonegr(compro[j]);
            pre.setMontoeje(monto[jj]);
            pre.setCodfueneco(compro[j + 1]);
            pre.setCodtar(codtar);
            orm.ejecutarObjeto("montosegreso", "inserta_ejecutado", pre, null);
            //////////////////////////////////////////////////////////////////////////
            //actualiza saldo
            orm.ejecutarObjeto("montosegreso", "actualiza_saldo", pre, null);
            ////////////////////////////////////////////////////////////////////////////
            //--insertando a acumulado tabla referencia ejecu egr
            u.setComprobante(cbte[jj]);
            u.setObservaciones(glossa[jj]);//GLOSA
            u.setFecha(fecha[jj]);
            u.setCodmonegr(compro[j]);
            u.setCodfueneco(compro[j + 1]);
            u.setCodtar(codtar);
            u.setMonacumulado(monto[jj]);
            orm.ejecutarObjeto("montosegreso", "inserta_ejecutado_referencia", u, null);
            /////////////////////////////////////////////////////////////
            ///eliminar Acumulado
            gr.setCodmonegr(compro[j]);//codmonegr
            gr.setCodfueneco(compro[j + 1]);//cod fuente
            gr.setMonto(compro[j + 2]);//monto
            gr.setId(compro[j + 3]);//id
            gr.setCodtar(codtar);
            orm.ejecutarObjeto("comproegr", "eliminar_acumulado_ref", gr, null);
            //////////////////////////////////////////////////////////////////
            ///Restar
            orm.ejecutarObjeto("comproegr", "restar_monto", gr, null);
            jj++;
            j = j + 5;
            ///////////////////////////////////////////////////////////////
            /// Eliminar si llega a cero el monto comprometido total
            orm.ejecutarObjeto("comproegr", "eliminar_monto_cero", gr, null);
        }
        j = j - 5;
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/comprometido/EjecuCompro3", modelo);
    }
}
