
package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;
import org.springframework.eam.domain.Comprometido;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModMonCompro implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        
        // codacti = "DC";
        // codtar = "ta1";
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        /*Sacando la actividad*/
        
        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        
     
        
        /*Sacando la tarea*/
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        
        Comprometido tt=new Comprometido();
        tt.setCodtar(codtar);
        List mon=orm.ejecutarLista("comproegr","mostrar_compro_acu",tt, new Comprometido());
        modelo.put("refcompro",mon);
        
        if(mon.size()>0)
        {
            modelo.put("gg","0");
        
        }
        else{ modelo.put("gg","-1"); }
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        
        return new ModelAndView("presupuestos2/comprometido/ModMonCompro", modelo);
    }
}