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

public class InsertaNPED3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //res variable
        String descripcion=request.getParameter("descripcion");
        String cod_det=request.getParameter("codigo");
        String cod_snp=request.getParameter("cod_snp");
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        NoPresupues gr=new NoPresupues();
        
        gr.setCod_snp(cod_snp);
        gr.setCod_det(cod_det);
        gr.setDescripcion(descripcion);
        
        
        //gr.setCodrub(codigo);
        // gr.setDescripcion(descripcion);
        //gr.setCodsub_ru(codsub_ru);
        //gr.setCodsub_ru(codsub_ru);
        //gr.setCodgru_ru(descripcion);
        //GrupoRubro grr= new GrupoRubro();
        ////orm.ejecutarObjeto("clasificador","insertar_rubro",entra,sale);
        orm.ejecutarObjeto("cuentanopresuegr","inserta_nped",gr,null);
        
        //modelo.put("subrubro",gr);
        
        // List sg = orm.ejecutarLista("clasificador","mostrar_subgrupos_in",gr,new GrupoRubro()); //llamano al _orm la consulta
        // modelo.put("grupos",gr);
        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos2/montos/MenuNoPreEgr", modelo);
    }
}