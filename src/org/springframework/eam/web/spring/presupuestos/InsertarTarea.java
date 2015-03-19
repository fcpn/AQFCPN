
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

public class InsertarTarea implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //res variable
        String descripcion=request.getParameter("descripcion");
        String codigo=request.getParameter("codigo");
        String codacti=request.getParameter("codacti");
        
        String aper_prog=request.getParameter("aper_prog");
        String num_tarea=request.getParameter("num_tarea");
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        
        
        gr.setCodtar(codigo);
        gr.setDescripcion(descripcion);
        gr.setCodacti(codacti);
        gr.setAper_prog(aper_prog);
        gr.setNum_tarea(num_tarea);
       
        orm.ejecutarObjeto("proacttar","insertar_tarea",gr,null);
        
        //modelo.put("subrubro",gr);
        
        // List sg = orm.ejecutarLista("clasificador","mostrar_subgrupos_in",gr,new GrupoRubro()); //llamano al _orm la consulta
        // modelo.put("grupos",gr);
        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/clasificador/OK", modelo);
    }
}