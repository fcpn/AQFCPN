
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

public class ModTraEgr implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
       
        
        String codtar=request.getParameter("codtar");
        String moneje=request.getParameter("moneje");
        modelo.put("moneje",moneje);
        String monto=request.getParameter("monto"); 
        modelo.put("monto",monto);
        String saldo=request.getParameter("saldo"); 
        modelo.put("saldo",saldo);
        
        String codmonegr=request.getParameter("codmonegr");
        String codmonegr2=request.getParameter("codmonegr");
        String descla=request.getParameter("descla");
        modelo.put("codmonegr",codmonegr);
        modelo.put("descla",descla);
        String codacti=request.getParameter("codacti");
        
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
        mop.setCodmonegr(codmonegr);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
       
        List mont=orm.ejecutarLista("histo_tras","listado",mop,new TrasIncre());
        modelo.put("his_tra",mont);
        /*List mont_=new ArrayList();
        if(mont != null) {
          
            
            
              for(int i = 0;i< mont.size();i++) {
                TrasIncre ki=(TrasIncre) mont.get(i);
                
                double tmpi = new Double(ki.getMonto()).doubleValue();
                //ki.setMonacumulado(df2.format(tmpi).toString());
                ki.setMonto(df2.format(tmpi).toString());
                mont_.add(ki);
            }
            
            
            
            modelo.put("his_tra",mont_);
        } else {
            
            modelo.put("his_tra",mont);
            
        }
*/


        TrasIncre mop2=new TrasIncre();
        mop2.setCodmonegr(codmonegr2);
        mop2.setCodfueneco(codfueneco);
        mop2.setCodtar(codtar);

        List mont2=orm.ejecutarLista("histo_tras","traspaso_a",mop2,new TrasIncre());
        modelo.put("his_tra2",mont2);

        
        
   
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("modegrnew/traspaso/ModTraEgr", modelo);
    }
}