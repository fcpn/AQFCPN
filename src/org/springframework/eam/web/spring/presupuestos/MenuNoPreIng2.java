
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.NoPresupues;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MenuNoPreIng2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
  
        String codtar=request.getParameter("codtar");
        String codacti=request.getParameter("codacti");
   
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        ProActTar gr=new ProActTar();
        ProActTar ta=new ProActTar();
        gr.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",gr,gr);
        modelo.put("actividad",gr);
        ta.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",ta,ta);
        modelo.put("tarea",ta);
        
        NoPresupues fr = new NoPresupues();
        List s=orm.ejecutarLista("cuentanopresuing","mostrar_grupos",null,fr);
        
        modelo.put("gruponp",s);


        orm.cerrar();
        
        return new ModelAndView("presupuestos/montos/MenuNoPreIng2", modelo);
    }
}