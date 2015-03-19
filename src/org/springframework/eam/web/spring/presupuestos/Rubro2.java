
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.GrupoRubro;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Rubro2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //res variable
        String codgru_ru=request.getParameter("codgru_ru");
        //String codgru_ru=request.getParameter("descripcion");
        System.out.println("---------"+codgru_ru);
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        GrupoRubro gr=new GrupoRubro();
        gr.setCodgru_ru(codgru_ru);
        //gr.setCodgru_ru(descripcion);
        //GrupoRubro grr= new GrupoRubro();
        orm.ejecutarObjeto("clasificador","descripcion_ru",gr,gr);
        
        modelo.put("rubro",gr);
        
        List sg = orm.ejecutarLista("clasificador","mostrar_subgrupos_in",gr,new GrupoRubro()); //llamano al _orm la consulta
        modelo.put("grupos",sg);
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos/clasificador/Rubro2", modelo);
    }
}