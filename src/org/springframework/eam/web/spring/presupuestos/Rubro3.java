/* Programa:    MenuControlador
 * Descripcion: Establece el menu correspondiente al rol
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       26-10-2007
 * Modificado:  Lizeth Amalia Gutierrez Loza, IICCA
 * Fecha
 */
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.GrupoRubro;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Rubro3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //res variable
         String codsub_ru=request.getParameter("codsub_ru");
        
        //String codsub_ru="11100";

//String codgru_ru=request.getParameter("descripcion");
        System.out.println("---------"+codsub_ru);
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        // orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        GrupoRubro gr=new GrupoRubro();
        gr.setCodsub_ru(codsub_ru);
        //gr.setCodsub_ru(codsub_ru);
        //gr.setCodgru_ru(descripcion);
        //GrupoRubro grr= new GrupoRubro();
        orm.ejecutarObjeto("clasificador","descripcion_subru",gr,gr);
        
        modelo.put("subrubro",gr);
        
        // List sg = orm.ejecutarLista("clasificador","mostrar_subgrupos_in",gr,new GrupoRubro()); //llamano al _orm la consulta
        // modelo.put("grupos",sg);
         orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos/clasificador/Rubro3", modelo);
    }
}