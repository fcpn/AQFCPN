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
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertarNoPreEgrGru implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String descripcion=request.getParameter("descripcion");
        String codigo=request.getParameter("codigo");
        
        System.out.println(codigo);
        System.out.println(descripcion);
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        FuenteEconomica fe=new FuenteEconomica();/*En la clase exite cod_gnp y cod_snp Los cuales son propios para 
                                                  *insertar en la cuenta de no presupuestados no tienen nada 
                                                  *de relacion con la fuentes economicas
         */
        fe.setCod_gnp(codigo);
        //fe.setCodfueneco(codigo);
        fe.setDescripcion(descripcion);
        
        orm.ejecutarObjeto("cuentanopresuegr","insertar_cuentanopresuegr",fe,null);
        
        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/clasificador/OK", modelo);
    }
}