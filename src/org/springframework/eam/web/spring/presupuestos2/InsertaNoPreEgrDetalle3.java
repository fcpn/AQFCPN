/* Programa:    MenuControlador
 * Descripcion: Establece el menu correspondiente al rol
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       26-10-2007
 * Modificado:  Lizeth Amalia Gutierrez Loza, IICCA
 * Fecha
 */
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.NoPresupues;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertaNoPreEgrDetalle3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //res variable
        String cod_snp=request.getParameter("cod_snp");
        
        //String codsub_ru="11100";
        
        //String codgru_ru=request.getParameter("descripcion");
        //  System.out.println("---------"+codsub_ru);
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        // orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        NoPresupues gr=new NoPresupues();
        gr.setCod_snp(cod_snp);
        
        
        orm.ejecutarObjeto("cuentanopresuegr","cod_snp",gr,gr);
        
        modelo.put("subgrupo",gr);
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/montos/InsertarNoPreEgrDetalle3", modelo);
    }
}