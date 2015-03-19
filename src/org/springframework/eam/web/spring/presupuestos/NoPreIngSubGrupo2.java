
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.GrupoRubro;
import org.springframework.eam.domain.NoPresupues;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class NoPreIngSubGrupo2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        /*Map modelo = new HashMap();
         
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
         
         
        List sg = orm.ejecutarLista("clasificador","mostrar_grupos_in",null,new GrupoRubro()); //llamano al _orm la consulta
        modelo.put("grupos",sg);
         
         
         
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos/clasificador/SubGrupoRubro", modelo);
         
         
        /************************************************/
        String cod_gnp=request.getParameter("cod_gnp");
        Map modelo = new HashMap();
        
        //res variable
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        NoPresupues np=new NoPresupues();
        
        np.setCod_gnp(cod_gnp);
        //gr.setCodgru_ru(codgru_ru);
        orm.ejecutarObjeto("cuentanopresuing","cod_gnp",np,np);
        
        modelo.put("grup",np);
        
        // List sg = orm.ejecutarLista("clasificador","mostrar_subgrupos_in",gr,new GrupoRubro()); //llamano al _orm la consulta
        // modelo.put("grupos",sg);
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos/montos/NoPreIngSubGrupo2", modelo);
        
        
        /************************************************/
        
        
    }
}