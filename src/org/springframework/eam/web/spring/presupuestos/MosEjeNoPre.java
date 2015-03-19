
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MosEjeNoPre implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codfueneco=request.getParameter("codfueneco");
       
        modelo.put("codfueneco",codfueneco);

        String codtar=request.getParameter("codtar");
        String monejenopre=request.getParameter("monejenopre");
        modelo.put("monejenopre",monejenopre);
        
        String codmonnopreing=request.getParameter("codmonnopreing");
        String descla=request.getParameter("descla");
        modelo.put("codmonnopreing",codmonnopreing);
        modelo.put("descla",descla);
        String codacti=request.getParameter("codacti");
       

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
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
        
        
        
        
        
        /*Sacando Fuente Economica*/
        FuenteEconomica fee= new FuenteEconomica();
        fee.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomia","codfueneco",fee,fee);
        modelo.put("fuu",fee);
        
        
     
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        /*/sacando comprobante e historial de montos ejecutados*/
        MosPresuIng mopr=new MosPresuIng();
        
        
      
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        mopr.setCodmonnopreing(codmonnopreing);
        
        List mmn=orm.ejecutarLista("cuentanopresuing","mon_ref",mopr,new MosPresuIng());
        modelo.put("montos_ref",mmn);

        InsPreIng d=new InsPreIng();
         d.setCodfueneco2(codfueneco);
        d.setCodtar(codtar);
        d.setCodmonnopreing2(codmonnopreing);
        orm.ejecutarObjeto("cuentanopresuing","mostrar_todo",d,d);
        modelo.put("monp", d);
        orm.cerrar();
        
        return new ModelAndView("presupuestos/modifica/MosRefNoPre", modelo);
    }
}