
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.NoPresupues2;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModRefNoPre implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
       
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        String idd=request.getParameter("idd");
        
        String comprobante2=request.getParameter("comprobante2");
        
        
        
        String comprobante=request.getParameter("comprobante");
        modelo.put("comprobante",comprobante);

        String mon_acu=request.getParameter("mon_acu");



        String mon_acu2=request.getParameter("mon_acu2");
        modelo.put("mon_acu",mon_acu2);


        String obs=request.getParameter("obs");
        modelo.put("obs",obs);

        String obs2=request.getParameter("observaciones2");



        String fecharef2=request.getParameter("fecharef2");
        

        String fecharef=request.getParameter("fecharef");
        modelo.put("fecharef",fecharef);

        String codacti=request.getParameter("codacti");
        
        modelo.put("codacti",codacti);
       
        String codmonnopreing=request.getParameter("codmonnopreing");

        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

        
        NoPresupues2 pre=new NoPresupues2();
        
        pre.setCodmonnopreing(codmonnopreing);
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        pre.setMon_acu(mon_acu);
        
        /*Restamos el montos ingreso ejecutado anterior monto (errado)*/
        orm.ejecutarObjeto("cuentanopresuing","resta",pre,null);
        
        /* SUMARRRRRRR montos ingreso ejecutado nuevo de referencia*/
        NoPresupues2 pre2=new NoPresupues2();
        
        pre2.setCodmonnopreing(codmonnopreing);
        pre2.setCodfueneco(codfueneco);
        pre2.setCodtar(codtar);
        pre2.setMon_acu(mon_acu2);
                
        orm.ejecutarObjeto("cuentanopresuing","suma",pre2,null);

        NoPresupues2 u=new NoPresupues2();
        
        u.setCodmonnopreing(codmonnopreing);
        u.setCodfueneco(codfueneco);
        u.setCodtar(codtar);
        u.setMon_acu(mon_acu2);
        u.setComprobante(comprobante2);
        u.setFecharef(fecharef2);
        u.setObs(obs2);
        u.setIdd(idd);
        orm.ejecutarObjeto("cuentanopresuing","actualiza_ejecutado_ref",u,null);


        /*mostrando resultado*/
        MosPresuIng mopr=new MosPresuIng();
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        mopr.setCodmonnopreing(codmonnopreing);
        mopr.setIdd(idd);
        orm.ejecutarObjeto("cuentanopresuing","mues_un_registro",mopr,mopr);
        modelo.put("monniing",mopr);

        orm.cerrar();//cerrar la conexionjsp
        return new ModelAndView("presupuestos/modifica/ModRefNoPree", modelo);
    }
}