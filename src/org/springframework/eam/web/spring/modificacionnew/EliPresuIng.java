
package org.springframework.eam.web.spring.modificacionnew;

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

public class EliPresuIng implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        String codacti=request.getParameter("codacti");
        
        String codfueneco=request.getParameter("codfueneco");
        String codmoning=request.getParameter("codmoning");


        modelo.put("codmoning",codmoning);
        modelo.put("codfueneco",codfueneco);
        modelo.put("codtar",codtar);
        modelo.put("codacti", codacti);

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        /*Sacando la actividad*/
        TrasIncre mop=new TrasIncre();
        mop.setCodmoning(codmoning);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        orm.ejecutarObjeto("montosingreso","elimina_presu",mop,null);
        

        orm.ejecutarObjeto("montosingreso","mon_pre_eje_sal",mop,mop);
        modelo.put("mi", mop);

        

        
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        
        //System.out.println("ref2-----"+ref2);
        //modingnew/presu/MoodPreIng            
        return new ModelAndView("presupuestos/modifica/EliPresuIng", modelo);
    }
}