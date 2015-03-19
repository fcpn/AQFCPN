
package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Comprometido;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EliMonComEgr3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
       
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        System.out.println("DES_Tarea ---- "+codtar);
       
        //llevando fuente actividad + descripcion
        String codacti=request.getParameter("codacti");
        modelo.put("codacti",codacti);
        System.out.println("DES_actividad ---- "+codacti);
        
        
        
        
        
        System.out.println("*********************Complemento*********************************************************");
        String comple[] = request.getParameterValues("complemento");
        String compro []= new String[150];
        
        String datos []= new String[450];
        
        int j=0;
        for(int i = 0 ; i < comple.length ; i++) 
            {
                   //System.out.println(com[i]);
                   String[] h = comple[i].split("::");
                   compro[j]=h[0];
                   compro[j+1]=h[1];
                   j=j+3;
            }
          j=j-3;
        
        
       
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
  
        
        Comprometido gr=new Comprometido();
        Comprometido gt=new Comprometido();
         int r=0;
        System.out.println("***********************Ingresando Datos Comprometidos Acumulados y Totales*******************************************************");
        for(int g=0; g<comple.length;g++)
        {
            
             System.out.println(compro[r]+" "+compro[r+1]+" "+compro[r+2]);
             gr.setCodmonegr(compro[r]);
             gr.setCodfueneco(compro[r+1]);
             gr.setCodtar(codtar);
             orm.ejecutarObjeto("comproegr","eliminar_Acumulado_total",gr,null);
             
             ///Eliminando Comprometido
             orm.ejecutarObjeto("comproegr","eliminar_Comprometido",gr,null);
             r=r+3;
        }
        
        
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/comprometido/EliMonComEgr3", modelo);
    }
}