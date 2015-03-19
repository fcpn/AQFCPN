
package org.springframework.eam.web.spring.presupuestos2;

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

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MostrarEjePresue implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codfueneco=request.getParameter("codfueneco");
        String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        modelo.put("desfe",desfe);
        
        String codtar=request.getParameter("codtar");
        String moneje=request.getParameter("moneje");
        String codmonegr=request.getParameter("codmoning");
        String descla=request.getParameter("descla");
        modelo.put("codmonegr",codmonegr);
        modelo.put("descla",descla);
        String codacti=request.getParameter("codacti");
        modelo.put("codtar",codtar);
        
        
        
        
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
  /*      FuenteEconomica fe= new FuenteEconomica();
        fe.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomia","codfueneco",fe,fe);
        modelo.put("fu",fe);
   */
        
        
        /*****************CLASIFICADOR***************************/
        
        /*********************************************/
        
        /*cacando montos presu eje saldo de un monto ejecutado especifico*/
        MosPresuIng mop=new MosPresuIng();
        mop.setCodmonegr(codmonegr);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        orm.ejecutarObjeto("montosegreso","mon_pre_eje_sal",mop,mop);
        if(mop != null) {
            
            float tmpi = new Float(mop.getMontopresu()).floatValue();
            mop.setMontopresu(df2.format(tmpi).toString());
            
            float tmpi2 = new Float(mop.getMontoeje()).floatValue();
            mop.setMontoeje(df2.format(tmpi2).toString());
            
            float tmpi3 = new Float(mop.getSaldo()).floatValue();
            mop.setSaldo(df2.format(tmpi3).toString());
            
            double tmpi4 = new Double(mop.getSaldo_ej_i()).doubleValue();
            mop.setSaldo_ej_i(df2.format(tmpi4).toString());
            
            
            System.out.println("Saldoooo-----"+ tmpi3);
            
            modelo.put("montos",mop);
            
        } else {
            modelo.put("montos",mop);
        }
        
        
        /*/sacando comprobante e historial de montos ejecutados*/
        MosPresuIng mopr=new MosPresuIng();
        mopr.setCodmonegr(codmonegr);
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        
        
        List mont=orm.ejecutarLista("montosegreso","mon_eje_com",mopr,new MosPresuIng());
        List mont_=new ArrayList();
        if(mont != null) {
            
            
            
            for(int i = 0;i< mont.size();i++) {
                MosPresuIng ki=(MosPresuIng) mont.get(i);
                
                float tmpi = new Float(ki.getMonacumulado()).floatValue();
                ki.setMonacumulado(df2.format(tmpi).toString());
                
                mont_.add(ki);
            }
            
            
            
            modelo.put("montos_ref",mont_);
        } else {
            
            modelo.put("montos_ref",mont);
            
        }
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("presupuestos2/montos/MostrarRef", modelo);
    }
}