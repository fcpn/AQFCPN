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
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MonNoPreEgr3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codacti=request.getParameter("codacti");
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        gr.setCodacti(codacti);
        
        /*informacion de actividad*/
        
        orm.ejecutarObjeto("proacttar","codacti",gr,gr);
        modelo.put("actividad",gr);
                
        
        
        /*Listado informacion de la tareas*/
        orm.verCompilado = "C";
        List g = orm.ejecutarLista("proacttar","mostrar_tarea",gr,gr); //llamano al _orm la consulta
        modelo.put("proacttar",g);
        
        
        
        
        
        
        // List sg = orm.ejecutarLista("proacttar","mostrar_actividad",gr,gr); //llamano al _orm la consulta
        //  modelo.put("proacttar",sg);
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/montos/MonNoPreEgr3", modelo);
        
        
        
    }
}