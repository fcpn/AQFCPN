
package org.springframework.eam.web.spring.presupuestos;

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
import org.springframework.web.util.WebUtils;

public class MostrarEjePresu implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String programa    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        
        String codfueneco=request.getParameter("codfueneco");
        String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        modelo.put("desfe",desfe);
        
        String codtar=request.getParameter("codtar");
        String moneje=request.getParameter("moneje");
        String codmoning=request.getParameter("codmoning");
        String descla=request.getParameter("descla");
        modelo.put("codmoning",codmoning);
        modelo.put("descla",descla);
        String codacti=request.getParameter("codacti");
       
        orm_bd orm = new orm_bd();
        orm.verCompilado = "C";
        mconexion m = new mconexion();
        orm.establecerConexion(m.extraerConexion("url1"));
        
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
 
        /*cacando montos presu eje saldo de un monto ejecutado especifico*/
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        MosPresuIng mop=new MosPresuIng();
        mop.setCodmoning(codmoning);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        orm.ejecutarObjeto("montosingreso","mon_pre_eje_sal",mop,mop);
        
        if(mop != null) {
            
            double tmpi = new Double(mop.getMontopresu()).doubleValue();
            mop.setMontopresu(df2.format(tmpi).toString());
            
            double tmpi2 = new Double(mop.getMontoeje()).doubleValue();
            mop.setMontoeje(df2.format(tmpi2).toString());
            
            double tmpi3 = new Double(mop.getSaldo()).doubleValue();
            mop.setSaldo(df2.format(tmpi3).toString());
            
            /*Saldos*/
            double tmpi4 = new Double(mop.getSaldo_ej_i()).doubleValue();
            mop.setSaldo_ej_i(df2.format(tmpi4).toString());
 
            modelo.put("montos",mop);
                       
        } else {
            modelo.put("montos",mop);
        }
        
        
        /*/sacando comprobante e historial de montos ejecutados*/
        MosPresuIng mopr=new MosPresuIng();
        mopr.setCodmoning(codmoning);
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        
        
        List mont=orm.ejecutarLista("montosingreso","mon_eje_com",mopr,new MosPresuIng());
        
        List mont_=new ArrayList();
        if(mont != null) {            
            for(int i = 0;i< mont.size();i++) {
                MosPresuIng ki=(MosPresuIng) mont.get(i);                
                double tmpi = new Double(ki.getMonacumulado()).doubleValue();
                ki.setMonacumulado(df2.format(tmpi).toString());               
                mont_.add(ki);
            }
            
            
            
            modelo.put("montos_ref",mont_);
        } else {
            
            modelo.put("montos_ref",mont);
            
        }

        orm.cerrar();
        
        return new ModelAndView("presupuestos/montos/MostrarRef", modelo);
    }
}