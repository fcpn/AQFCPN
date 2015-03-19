
package org.springframework.eam.web.spring.presupuestos2;

import org.springframework.eam.web.spring.presupuestos.*;
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

public class ModPar implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        String cod="";
        String tipo1="";

        String codmonegr= request.getParameter("codmonegr");
        modelo.put("codmonegr", codmonegr);
        String tipo= request.getParameter("tipo");
        String des= " ";
       

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
     

        GrupoRubro r =new GrupoRubro();
        r.setCodigo(codmonegr);


        if(tipo.equals("1"))
        {
          orm.ejecutarObjeto("clasificador", "grupo_partida", r, r);
          cod=r.getCodgru();
          des="Grupo";
          tipo1="1";
        }

        if(tipo.equals("2"))
        {
          orm.ejecutarObjeto("clasificador", "subgru_partida", r, r);
          cod=r.getCodsub();
          des="Sub Grupo";
          tipo1="2";
        }

        if(tipo.equals("3"))
        {
          orm.ejecutarObjeto("clasificador", "partida", r, r);
          cod=r.getCodpar();
          des="Partida";
          tipo1="3";
        }


        modelo.put("des",des);

        modelo.put("cod",cod);
        
        modelo.put("tipo",tipo1);

        modelo.put("r",r); 

        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos2/clasificador/ModPar", modelo);
    }
    
}