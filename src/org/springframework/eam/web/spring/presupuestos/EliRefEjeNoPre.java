
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Rubro;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EliRefEjeNoPre implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        String codfueneco=request.getParameter("codfueneco");
        String desfuen=request.getParameter("desfuen");
        modelo.put("desfuen",desfuen);

        modelo.put("codfueneco",codfueneco);
        String idd=request.getParameter("idd");
        modelo.put("idd",idd);
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        String comprobante=request.getParameter("comprobante");
        modelo.put("comprobante",comprobante);
        String mon_acu=request.getParameter("monacumulado");//MONTO
        modelo.put("mon_acu",mon_acu);
        String obs=request.getParameter("observaciones");
        modelo.put("obs",obs);
        String fecharef=request.getParameter("fecha");
        modelo.put("fecharef",fecharef);
        String codmonnopreing=request.getParameter("codmonnopreing");
        String descla=request.getParameter("descla");
        modelo.put("descla",descla);

        modelo.put("codmonnopreing",codmonnopreing);
        String codacti=request.getParameter("codacti");
        modelo.put("codacti",codacti);
        
       
         orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        

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


        MosPresuIng mopr=new MosPresuIng();
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        mopr.setCodmonnopreing(codmonnopreing);
        mopr.setIdd(idd);
        mopr.setMon_acu(mon_acu);

        //actualizo salo Resta
        orm.ejecutarObjeto("cuentanopresuing","resta",mopr,null);

        //eliminar
        orm.ejecutarObjeto("cuentanopresuing","eliminar",mopr,null);
        //muestro registro
            
        orm.ejecutarObjeto("cuentanopresuing","mues_un_registro",mopr,mopr);
        modelo.put("monniing",mopr);

        orm.cerrar();
        return new ModelAndView("presupuestos/modifica/EliRefEjeNoPre", modelo);
    }
}