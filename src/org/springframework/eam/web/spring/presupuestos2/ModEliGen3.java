
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;
import org.springframework.eam.domain.inno;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModEliGen3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codtar=request.getParameter("codtar");
     

      

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        ProActTar ta=new ProActTar();
        //GrupoRubro sg=;////direccion y coordinacion
        //gr.setCodsub_ru(codigo);
      
        ta.setCodtar(codtar);
        //gr.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",ta,ta);
        modelo.put("tarea",ta);
        
        
        
        
        
        gen g=new gen();
       
       g.setCodtar(codtar);
       
        orm.ejecutarObjeto("gral","eliminar",g,null);


        ProActTar taa=new ProActTar();
        taa.setCodtar(codtar);
        List ff = orm.ejecutarLista("gral","codtar",taa,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);
        
       
        
        orm.cerrar();//cerrar la conexion
        
        return new ModelAndView("presupuestos2/generales/ModEliGen2_1", modelo);
    }
}