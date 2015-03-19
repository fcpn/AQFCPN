
package org.springframework.eam.web.spring.modificacionnewe;

import org.springframework.eam.web.spring.modificacionnew.*;
import org.springframework.eam.web.spring.presupuestos.*;
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

public class ModSoloEjeE implements Controller {
    
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
        String codacti=request.getParameter("codacti");
        modelo.put("codacti",codacti);
        String codmonegr=request.getParameter("codmonegr");
        modelo.put("codmonegr",codmonegr);
        String moneje=request.getParameter("moneje");
        modelo.put("moneje",moneje);
 
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
        
        /*****************CLASIFICADOR***************************/
        
        /*********************************************/
        /*cacando montos presu eje saldo de un monto ejecutado principal*/
        MosPresuIng mop=new MosPresuIng();
        mop.setCodmonegr(codmonegr);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        orm.ejecutarObjeto("montosegreso","mon_pre_eje_sal",mop,mop);
        modelo.put("montos",mop);
      
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
      
        return new ModelAndView("modegrnew/presu/ModSoloEjeE", modelo);
    }
}