
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

public class ModFuen2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


       
        String codfueneco= request.getParameter("codfueneco");
      
        String codfueneco2= request.getParameter("codfueneco2");
        String descripcion2= request.getParameter("descripcion2");
        String cod="";

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
     

        FuenteEconomica r =new FuenteEconomica();
        r.setCodfueneco(codfueneco);
        r.setCodfueneco2(codfueneco2);
        r.setDescripcion(descripcion2);

      
          orm.ejecutarObjeto("fuenteeconomica", "modifica_codfueneco", r, null);
          r.setCodfueneco(codfueneco2);
          orm.ejecutarObjeto("fuenteeconomica", "codfueneco", r, r);
          cod=r.getCodfueneco();
          
      

        
        modelo.put("cod",cod);
        
        modelo.put("r",r); 

        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/fuenteseconomicas/ModFuen2", modelo);
    }
    
}