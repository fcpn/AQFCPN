
package org.springframework.eam.web.spring.presupuestos3;

import org.springframework.eam.web.spring.presupuestos.*;
import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModEliProg2_1 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codpro2=request.getParameter("codpro2");
        String codpro=request.getParameter("codpro");
        String descripcion=request.getParameter("descripcion2");
        String u_ejecutora2=request.getParameter("u_ejecutora2");
       
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        


        /*Modificando programa*/
        gr.setCodpro(codpro);
        gr.setCodpro2(codpro2);
        gr.setDescripcion(descripcion);
        gr.setU_ejecutora(u_ejecutora2);
        orm.ejecutarObjeto("programa","modifica",gr, null);

        /*codtar */
        ProActTar ac=new ProActTar();
        ac.setCodpro(codpro2);

        orm.ejecutarObjeto("proacttar","codpro",ac,ac);
        modelo.put("g",ac);
        
        
        
        
        orm.cerrar();//cerrar la conexion

        return new ModelAndView("presupuestos/progratar/ModEliProg2_1", modelo);
    }
}