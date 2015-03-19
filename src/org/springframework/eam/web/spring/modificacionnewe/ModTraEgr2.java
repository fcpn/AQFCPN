
package org.springframework.eam.web.spring.modificacionnewe;

import org.springframework.eam.web.spring.presupuestos2.*;
import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.TrasIncre;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModTraEgr2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String monto=request.getParameter("monto_c");
        modelo.put("monto",monto);
        String codmonegr=request.getParameter("codmonegr_c");
        modelo.put("codmonegr",codmonegr);
        String moneje=request.getParameter("moneje_c");
        modelo.put("moneje",moneje);
        String saldo=request.getParameter("saldo_c");
        modelo.put("saldo",saldo);



        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        String codtar=request.getParameter("codtar");
        
        
        
       

        String codmonegr2=request.getParameter("codmonegr2");
        String codacti=request.getParameter("codacti");
        String id=request.getParameter("id");

     
        /*
        System.out.println("MOSTRANDOOOOOOOOOOOOO EJEEEEEEEEEE");
        //String codfueneco="TGN";
        System.out.println("fuente---"+codfueneco);
        System.out.println("codtar---"+codtar);
        System.out.println("codacti---"+codacti);
        System.out.println("montoeje---"+moneje);
        System.out.println("codigo de clasificador---"+codmonegr);
        //codfueneco="TGN";
        */
        
        // codacti = "DC";
        // codtar = "ta1";
  
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        

       /*Sacando descripcion de codfueneco*/
        ProActTar fu=new ProActTar();
        fu.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",fu,fu);
        modelo.put("fuente",fu);

//parametros
        
        /*Sacando la actividad*/
        ProActTar act=new ProActTar();
        act.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",act,act);
        modelo.put("actividad",act);
        
        /*Sacando la tarea*/
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        
        
        /*****************CLASIFICADOR***************************/
        
        /*********************************************/
       DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        /*cacando montos presu eje saldo de un monto ejecutado especifico*/
        TrasIncre mop=new TrasIncre();
        mop.setCodmonegr2(codmonegr2);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        mop.setId(id);
        orm.ejecutarObjeto("histo_tras","particular",mop,mop);
        modelo.put("moo",mop);
        
            

   
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("modegrnew/traspaso/ModTraEgr2", modelo);
    }
}