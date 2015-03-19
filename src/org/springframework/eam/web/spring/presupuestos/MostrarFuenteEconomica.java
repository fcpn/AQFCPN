
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MostrarFuenteEconomica implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
      
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
         List fe=orm.ejecutarLista("fuenteeconomica","mostrar_fuenteeconomica",null,new FuenteEconomica());
       
           
        modelo.put("fuente",fe);
         
       
        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/fuenteseconomicas/MostrarFuentes", modelo);
    }
}