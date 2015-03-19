
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModFuen implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        
        String codfueneco= request.getParameter("codfueneco");
        modelo.put("codfueneco", codfueneco);
        String cod="";
        String des="Fuentes Economicas";

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
     

        FuenteEconomica r =new FuenteEconomica();
        r.setCodfueneco(codfueneco);


          orm.ejecutarObjeto("fuenteeconomica", "codfueneco", r, r);
          cod=r.getCodfueneco();
          
       
        modelo.put("r",r); 
        modelo.put("cod",cod);
        modelo.put("des",des);
        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/fuenteseconomicas/ModFuen", modelo);
    }
    
}