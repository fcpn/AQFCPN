
package org.springframework.eam.web.spring.presupuestos;

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

public class ModEliTar2_1 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codtar=request.getParameter("codtar");
        String codacti=request.getParameter("codacti");
        String codtar2=request.getParameter("codtar2");
        String correlativo2=request.getParameter("correlativo2");
        String aper_prog2=request.getParameter("aper_prog2");

        String descripcion2=request.getParameter("descripcion2");
        String num_tarea2=request.getParameter("num_tarea2");


        System.out.println("Codtar "+codtar);
        System.out.println("Codacti "+codacti);
        System.out.println("Codtar2 "+codtar2);
        System.out.println("correlativo2 "+correlativo2);
        System.out.println("num_tarea2 "+num_tarea2);

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        


        /*Modificando tarea*/
        gr.setCodtar2(codtar2);
        gr.setCodtar(codtar);
        gr.setCodacti(codacti);
        gr.setDescripcion(descripcion2);
        gr.setNum_tarea(num_tarea2);
        gr.setCorrelativo(correlativo2);
        gr.setAper_prog(aper_prog2);
        orm.ejecutarObjeto("tarea","modifica",gr, null);

        /*codtar */
        gr.setCodacti(codtar2);
        gr.setCodacti(codacti);
        orm.ejecutarObjeto("tarea","codtar",gr,gr);
        modelo.put("tar",gr);
        
        
        
        
        orm.cerrar();//cerrar la conexion

        return new ModelAndView("presupuestos/progratar/ModEliTar2_1", modelo);
    }
}