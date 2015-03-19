
package org.springframework.eam.web.spring.presupuestos;

import org.springframework.eam.web.spring.presupuestos2.*;
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

public class ModEliAct2_1 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String codacti2=request.getParameter("codacti2");

        String descripcion2=request.getParameter("descripcion2");
        String apertura_prog2=request.getParameter("apertura_prog2");


        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        


        /*Modificando Actividad*/
        gr.setCodacti(codacti2);
        gr.setDescripcion(descripcion2);
        gr.setApertura_prog(apertura_prog2);
        orm.ejecutarObjeto("proacttar","modifica",gr, null);

        /*Listar actividades*/
        gr.setCodacti(codacti2);
        orm.ejecutarObjeto("proacttar","codacti",gr,gr);
        modelo.put("act",gr);
        
        
        
        
        orm.cerrar();//cerrar la conexion

        return new ModelAndView("presupuestos/progratar/ModEliAct2_1", modelo);
    }
}