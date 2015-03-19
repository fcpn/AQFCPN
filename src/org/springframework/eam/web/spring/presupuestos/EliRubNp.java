
package org.springframework.eam.web.spring.presupuestos;

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

public class EliRubNp implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


       
        String codigo= request.getParameter("cod_gnp");
        String tipo= request.getParameter("tipo");
        
        String cod="";

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
     

        NoPresupues r =new NoPresupues();
        r.setCodigo(codigo);
        
        if(tipo.equals("1"))
        {
          orm.ejecutarObjeto("clasificador", "elimina_gruponp", r, null);
          r.setCodigo(codigo);
          orm.ejecutarObjeto("clasificador", "gruponp", r, r);
          cod=r.getCod_gnp();
          
        }

        if(tipo.equals("2"))
        {
          orm.ejecutarObjeto("clasificador", "elimina_subgruponp", r, null);
          r.setCodigo(codigo);
          orm.ejecutarObjeto("clasificador", "subgrunp", r, r);
          cod=r.getCod_snp();
          
        }

        if(tipo.equals("3"))
        {
          orm.ejecutarObjeto("clasificador", "elimina_rubronp", r, null);
          r.setCodigo(codigo);
          orm.ejecutarObjeto("clasificador", "rubronp", r, r);
          cod=r.getCod_det();
          
        }


        
        modelo.put("cod",cod);
        
        modelo.put("r",r); 

        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/clasificador/EliRubNp", modelo);
    }
    
}