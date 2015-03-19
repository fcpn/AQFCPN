
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.NoPresupues2;
import org.springframework.eam.domain.inno;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MosEjeNoPreClaE implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        
        
        //System.out.println("desfe--"+desfe);
        String monejenopre=request.getParameter("monejenopre");
        
        
        String ref123=request.getParameter("ref123");
        modelo.put("ref123",ref123);
        
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
                
        String codmonnopreegr=request.getParameter("codmonnopreegr");

        String codacti=request.getParameter("codacti");

        modelo.put("codacti",codacti);

        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
        /*Sacando Detalles*/

        NoPresupues2 pre2=new NoPresupues2();
        pre2.setCodmonnopreegr(codmonnopreegr);
        pre2.setCodfueneco(codfueneco);
        pre2.setCodtar(codtar);
        orm.ejecutarObjeto("cuentanopresuegr", "saldo_inicial", pre2, pre2);
        modelo.put("rnopreegr", pre2);



        FuenteEconomica f = new FuenteEconomica();
        f.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",f,f); //llamano al _orm la consulta
        modelo.put("f",f);
        
        
        orm.cerrar();
        
        return new ModelAndView("presupuestos2/modifica/MosEjeNoPreClaE", modelo);
    }
}