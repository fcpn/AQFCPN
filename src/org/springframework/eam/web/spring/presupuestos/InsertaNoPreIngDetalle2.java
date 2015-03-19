
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.GrupoRubro;
import org.springframework.eam.domain.NoPresupues;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertaNoPreIngDetalle2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //res variable
        String cod_gnp=request.getParameter("cod_gnp");
        //String codgru_ru=request.getParameter("descripcion");
        //System.out.println("---------"+codgru_ru);
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        NoPresupues gr=new NoPresupues();
        gr.setCod_gnp(cod_gnp);
        //gr.setCodgru_ru(descripcion);
        //GrupoRubro grr= new GrupoRubro();
        orm.ejecutarObjeto("cuentanopresuing","cod_gnp",gr,gr);
         
        modelo.put("grupo",gr);
         
        List sg = orm.ejecutarLista("cuentanopresuing","mostrar_subgrupos",gr,new NoPresupues()); //llamano al _orm la consulta
        modelo.put("subgrupo",sg);
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos/montos/InsertaNoPreIngDetalle2", modelo);
    }
}