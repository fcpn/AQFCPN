
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;

import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IncrIng3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
                
        String codtar=request.getParameter("codtar");
        
        
        String codmoning=request.getParameter("codmoning");
        modelo.put("codmoning",codmoning);
      
        
        String ref1=request.getParameter("ref1");
        modelo.put("ref1",ref1);
        
        
        
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        
        
        /*mon  presupuestado*/
        String monto=request.getParameter("monto");
        modelo.put("monto",monto);
        
      
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
        
        /*sacndo descipcion de fuente economica*/
        ProActTar cd=new ProActTar();
        cd.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",cd,cd);
        modelo.put("des",cd);
        
        
        /*clasificador*/
       List partida=orm.ejecutarLista("clasificador","mostrar_rubros",null,new Rubro());
        
        modelo.put("partida",partida);
       
        int sw=0;
        int sw2=0;
        String des_ref1;
        String des_ref2;
        if(partida!=null) 
        {//if_1
            for(int i=0; i< partida.size();i++)
            {//for
                 Rubro pa=(Rubro) partida.get(i);
                 
                           if(ref1.equals(pa.getTipo()) && codmoning.equals(pa.getCodigo()))
                           {//if_2
                                 des_ref1=pa.getDescripcion();     sw=1;
                                  modelo.put("des_ref1",des_ref1);
                                  //tr.setDescla(des_ref1);
                                 System.out.println("des_ref1-----------------"+des_ref1);
                           }//fin if_2
                                          
                    if(sw==1)
                     {//fin if_4
                          i=partida.size() + 1;
                     }//fin if_4
                 
            }//for
            
           // orm.ejecutarObjeto("histo_tras","insertando",tr,null);
        }//if_1
        
        
        
        
        
        
        
        
        
        
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        System.out.println("ref1-----"+ref1);
        //System.out.println("ref2-----"+ref2);
        return new ModelAndView("presupuestos/incrementos/IncrIng3", modelo);
    }
}