
package org.springframework.eam.web.spring.modificacionnewe;

import org.springframework.eam.web.spring.modificacionnew.*;
import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModSoloEje2E implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
         String sal_ini=request.getParameter("sal_ini");
         


        // String codacti=request.getParameter("codacti");
        String moneje1=request.getParameter("moneje1");
        String monpre2=request.getParameter("moneje2");//ahora sera mi nuevo ejecutado monpre

        String codtar=request.getParameter("codtar");
        String codacti=request.getParameter("codacti");
        String codmonegr=request.getParameter("codmonegr");
        String codfueneco=request.getParameter("codfueneco");
        
        
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("Cod_Tarea  "+codtar);
        System.out.println("Cod___Ing  "+codmonegr);
        System.out.println("Cod_FuenE  "+codfueneco);
        System.out.println("monpre1    "+moneje1);
        System.out.println("monpre2    "+monpre2);


        modelo.put("codmonegr",codmonegr);
        modelo.put("moneje1",moneje1);
        modelo.put("moneje2",monpre2);
        modelo.put("codfueneco",codfueneco);
        modelo.put("codtar",codtar);
        modelo.put("codacti",codacti);
        


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
        
        /*sacando descipcion de fuente economica*/
       ProActTar cd=new ProActTar();
        cd.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",cd,cd);
        modelo.put("des",cd);


//Modificando el Presupuestado EGR
        MosPresuIng ring=new MosPresuIng();
        ring.setCodtar(codtar);
        ring.setCodmonegr(codmonegr);
        ring.setCodfueneco(codfueneco);
        //mostrando antes del modificado
        orm.ejecutarObjeto("montosegreso", "mon_pre_eje_sal", ring, ring);
        modelo.put("ejeante", ring);

        //modificando el Ejecutado

        ring.setMontopre2(monpre2);
        if( sal_ini.equals("s"))
             {
                 orm.ejecutarObjeto("montosegreso", "modifi_eje_sal_i", ring, null);

              }
         else{ //no

                orm.ejecutarObjeto("montosegreso", "modifi_eje", ring, null);
             }



        //actualizando saldo
        orm.ejecutarObjeto("montosegreso", "actualiza_saldo", ring, null);

        //mostrando modificaciones
        orm.ejecutarObjeto("montosegreso", "mon_pre_eje_sal", ring, ring);
        modelo.put("ejemodi", ring);


        
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        
        //System.out.println("ref2-----"+ref2);
        //modingnew/presu/MoodPreIng
        return new ModelAndView("modegrnew/presu/ModSoloEje2E", modelo);
    }
}