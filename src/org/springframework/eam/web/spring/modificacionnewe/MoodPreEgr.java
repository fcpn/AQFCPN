
package org.springframework.eam.web.spring.modificacionnewe;

import org.springframework.eam.web.spring.modificacionnew.*;
import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MoodPreEgr implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
        //String monpre=request.getParameter("monpre");
        //String moneje=request.getParameter("moneje");
        String codtar=request.getParameter("codtar");
        String codacti=request.getParameter("codacti");
        String codmonegr=request.getParameter("codmoning");
        //String ref1=request.getParameter("ref1");
        String codfueneco=request.getParameter("codfueneco");
        //String monto=request.getParameter("monto");

        System.out.println("Cod_Tarea  "+codtar);
        System.out.println("Cod___Egr  "+codmonegr);
        System.out.println("Cod_FuenE  "+codfueneco);

        modelo.put("codmonegr",codmonegr);
        modelo.put("codfueneco",codfueneco);
        modelo.put("codtar",codtar);
        
      
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



        MosPresuIng ring=new MosPresuIng();
        ring.setCodtar(codtar);
        ring.setCodmonegr(codmonegr);
        ring.setCodfueneco(codfueneco);

        orm.ejecutarObjeto("montosegreso", "mon_pre_eje_sal", ring, ring);
        modelo.put("montos",ring);
        
        /*clasificador
         List partida=orm.ejecutarLista("clasificador","mostrar_rubros",null,new Rubro());
        
        modelo.put("partida",partida);*/
       /*
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
        

        */
        
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        
        //System.out.println("ref2-----"+ref2);
        //presupuestos/incrementos/IncrIng3
        return new ModelAndView("modegrnew/presu/MoodPreEgr", modelo);
    }
}