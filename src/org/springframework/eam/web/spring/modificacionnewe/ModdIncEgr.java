
package org.springframework.eam.web.spring.modificacionnewe;

import org.springframework.eam.web.spring.modificacionnew.*;
import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.TrasIncre;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModdIncEgr implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
         String codtar=request.getParameter("codtar");
        String codmonegr=request.getParameter("codmon");
        String id=request.getParameter("id");
        String codfueneco=request.getParameter("codfueneco");
        String monto=request.getParameter("monto");

        System.out.println("Cod_Tarea  "+codtar);
        System.out.println("Cod___Egr  "+codmonegr);
        System.out.println("Cod_FuenE  "+codfueneco);
         System.out.println("id  "+id);
        System.out.println("monto  "+monto);

        modelo.put("codmonegr",codmonegr);
        modelo.put("codfueneco",codfueneco);
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
        
        /*sacndo descipcion de fuente economica*/
      ProActTar cd=new ProActTar();
        cd.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",cd,cd);
        modelo.put("des",cd);

        TrasIncre mop=new TrasIncre();
        mop.setId(id);
        orm.ejecutarObjeto("histo_incre","unreg",mop,mop);
        modelo.put("reghis",mop);

     

        

        
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        
        //System.out.println("ref2-----"+ref2);
        //modingnew/presu/MoodPreIng            
        return new ModelAndView("modegrnew/increegr/ModdIncEgr", modelo);
    }
}