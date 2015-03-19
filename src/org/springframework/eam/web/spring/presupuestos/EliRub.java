
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

public class EliRub implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


       
        String codmoning= request.getParameter("codmoning");
        String tipo= request.getParameter("tipo");
        
        String cod="";

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
     

        GrupoRubro r =new GrupoRubro();
        r.setCodigo(codmoning);
        
        if(tipo.equals("1"))
        {
          orm.ejecutarObjeto("clasificador", "elimina_grupo", r, null);

          r.setCodigo(codmoning);
          orm.ejecutarObjeto("clasificador", "grupo", r, r);
          cod=r.getCodgru_ru();
          
        }

        if(tipo.equals("2"))
        {
          orm.ejecutarObjeto("clasificador", "elimina_subgrupo", r, null);
          r.setCodigo(codmoning);
          orm.ejecutarObjeto("clasificador", "subgru", r, r);
          cod=r.getCodsub_ru();
          
        }

        if(tipo.equals("3"))
        {
          orm.ejecutarObjeto("clasificador", "elimina_rubro", r, null);
          r.setCodigo(codmoning);
          orm.ejecutarObjeto("clasificador", "rubro", r, r);
          cod=r.getCodrub();
          
        }


        
        modelo.put("cod",cod);
        
        modelo.put("r",r); 

        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/clasificador/EliRub", modelo);
    }
    
}