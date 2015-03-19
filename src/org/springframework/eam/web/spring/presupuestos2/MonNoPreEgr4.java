
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.NoPresupues;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MonNoPreEgr4 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String codtar=request.getParameter("codtar");
        
        String codacti=request.getParameter("codacti");
         String cod_gnp=request.getParameter("cod_gnp");

         modelo.put("codtar", codtar);
         modelo.put("codacti", codacti);
         modelo.put("cod_gnp", cod_gnp);


String tipo="2";
modelo.put("tipo",tipo);


        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        ProActTar ta=new ProActTar();
        //GrupoRubro sg=;////direccion y coordinacion
        //gr.setCodsub_ru(codigo);
        gr.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",gr,gr);
        modelo.put("actividad",gr);
        
        ta.setCodtar(codtar);
        //gr.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",ta,ta);
        modelo.put("tarea",ta);
        
        
        NoPresupues te = new NoPresupues();
        te.setCod_gnp(cod_gnp);
        List sg = orm.ejecutarLista("clasificador","subgrupo_codgrue",te,te);//llamano al _orm la consulta
        modelo.put("detalle",sg);
        
        
        List fe = orm.ejecutarLista("fuenteeconomica","mostrar_fuenteeconomica",null,new FuenteEconomica()); //llamano al _orm la consulta
        modelo.put("fuente",fe);
        
      
        orm.cerrar();//cerrar la conexion
        
        return new ModelAndView("presupuestos2/montos/MonNoPreEgr4", modelo);
    }
}