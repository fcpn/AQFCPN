
package org.springframework.eam.web.spring.modificacionnewe;


import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.TrasIncre;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.tras;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EliIncEgr implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        String monpre1=request.getParameter("monto");
        String id=request.getParameter("id");
        String codmonegr1=request.getParameter("codmon");
        String codfueneco1=request.getParameter("codfueneco");
        String fecha1=request.getParameter("fecha");
        String glosa1=request.getParameter("glosa");
        String cbte1=request.getParameter("cbte");


        modelo.put("id", id);
        modelo.put("monpre1", monpre1);
        modelo.put("codmonegr1", codmonegr1);
        modelo.put("codfueneco1", codfueneco1);
        modelo.put("cbte1", cbte1);
        modelo.put("fecha1", fecha1);
        modelo.put("glosa1", glosa1);

        System.out.println("ANTES--------------");
        System.out.println("Cod_Tarea  "+codtar);
        System.out.println("Cod___Egr1  "+codmonegr1);
        System.out.println("Cod_FuenE1  "+codfueneco1);
        System.out.println("id         "+id);
        System.out.println("monpre1      "+monpre1);



        modelo.put("codmonegr",codmonegr1);
        modelo.put("codfueneco",codfueneco1);
        modelo.put("codtar",codtar);


        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        /*Sacando la actividad*/
    ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        /*Sacando la tarea*/
      ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        
        /*sacndo descripcion de fuente economica*/
       ProActTar cd=new ProActTar();
        cd.setCodfueneco(codfueneco1);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",cd,cd);
        modelo.put("des",cd);


        ///Modificando Incremento


        //restando presupuestado e incremento
        MosPresuIng iing=new MosPresuIng();
        iing.setMonpre1(monpre1);
        iing.setCodtar(codtar);
        iing.setCodmonegr(codmonegr1);
        iing.setCodfueneco(codfueneco1);
        orm.ejecutarObjeto("montosegreso","resta_presu_incre",iing,null);
        //modelo.put("reghis",iing);


        //Actualizando Saldo
        orm.ejecutarObjeto("montosegreso","actualiza_saldo",iing,null);


        //Eliminando Historial incremento
        TrasIncre incr=new TrasIncre();
        incr.setId(id);
        orm.ejecutarObjeto("histo_incre","elimina_hincre_id",incr,null);

        orm.cerrar();
     /*88889 */
        return new ModelAndView("modegrnew/increegr/EliIncEgr", modelo);
    }
}