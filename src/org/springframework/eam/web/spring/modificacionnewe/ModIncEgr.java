
package org.springframework.eam.web.spring.modificacionnewe;

import org.springframework.eam.web.spring.modificacionnew.*;
import org.springframework.eam.web.spring.presupuestos3.*;
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

public class ModIncEgr implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String codacti=request.getParameter("codacti");

        //String monto=request.getParameter("monto");
        //System.out.println("presupuestado   ---"+monto);
        //modelo.put("monto",monto);
        
        
        //String moneje=request.getParameter("moneje");
        //System.out.println("monto ejecutado ---"+moneje);
        //modelo.put("moneje",moneje);
        
        
        //String saldo=request.getParameter("saldo");
        //System.out.println("saldo--------"+saldo);
        //modelo.put("saldo",saldo);
        
        
        String codtar=request.getParameter("codtar");
        System.out.println("codtar--------"+codtar);
        modelo.put("codtar",codtar);
        
        
        
        String codfueneco=request.getParameter("codfueneco");
        System.out.println("codfueneco--------"+codfueneco);
        modelo.put("codfueneco",codfueneco);
        
        
        String codmon=request.getParameter("codmoning");
        System.out.println("codigo de monto ingreso o egreso--------"+codmon);
        modelo.put("codmon",codmon);
        
        
        //String ref1=request.getParameter("ref1");
        ///ystem.out.println("ref123//tipo--------"+ref1);
        //modelo.put("ref1",ref1);
        
        
        
        String i_e="1";// 1   por que pertenece a los incrementos de los Egresos
        System.out.println("ref 0/1--------"+i_e);
        modelo.put("i_e",i_e);
    
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

        //monto ingresos

        MosPresuIng mopr=new MosPresuIng();
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        mopr.setCodmonegr(codmon);
        orm.ejecutarObjeto("montosegreso","mon_pre_eje_sal",mopr,mopr);
        modelo.put("reging", mopr);






        ///Incremetos
     DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        /*sacando montos hiostorial del los incrementos*/
     TrasIncre mop=new TrasIncre();
        mop.setCodmon(codmon);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        mop.setI_e(i_e);
        List mont=orm.ejecutarLista("histo_incr","listado",mop,new TrasIncre());
      
            modelo.put("his_inc",mont);
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("modegrnew/increegr/ModIncEgr", modelo);
    }
}