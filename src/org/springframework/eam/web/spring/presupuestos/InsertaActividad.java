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
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertaActividad implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String codacti=request.getParameter("codacti");
        String descripcion=request.getParameter("descripcion");
        String codpro=request.getParameter("codpro");
        String apertura_prog=request.getParameter("apertura_prog");
        
        //String codpro=request.getParameter("codpro");
        //String codigo=request.getParameter("codigo");
        // String codigo=request.getParameter("codigo");
        // String codgru_ru=request.getParameter("codgru_ru");
        System.out.println("Datos para actividad");   
        System.out.println(codacti);
          System.out.println(descripcion);
        //  System.out.println(codgru_ru);
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        //gr.setCodsub_ru(codigo);
        gr.setCodacti(codacti);
        gr.setDescripcion(descripcion);
        gr.setCodpro(codpro);
        gr.setApertura_prog(apertura_prog);
          
        orm.ejecutarObjeto("proacttar","insertar_actividad",gr,null);
        
        //modelo.put("programa",gr);
        
        // List sg = orm.ejecutarLista("clasificador","mostrar_subgrupos_in",gr,new GrupoRubro()); //llamano al _orm la consulta
        // modelo.put("grupos",gr);
        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/clasificador/OK", modelo);
    }
    
}