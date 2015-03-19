
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Rubro;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.tras;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IncrIng4 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        
        
        /*
         
         en la tabla historial incrementos h_incre en el campo i_e
         0 ---->ingresos
         1 ---->egresos         
         
         */
        
        
        
        
        // String codacti=request.getParameter("codacti");
        String ref1=request.getParameter("ref1");
        
        String codtar=request.getParameter("codtar");
        
        String codmoning=request.getParameter("codmoning");
        modelo.put("codmoning",codmoning);
        
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        
        
        //System.out.println("codfueneco"+codfueneco);
        
        
        String monto=request.getParameter("monto");
        modelo.put("monto",monto);
        
        System.out.println("monto"+monto);
        
        
        
        /*monto_sumar glosa fecha*/
        String monsum=request.getParameter("monsum");
        modelo.put("monsum",monsum);
        
        //System.out.println("monsum"+monsum);
        
        
        String glosa=request.getParameter("glosa");
        modelo.put("glosa",glosa);
        
        
        System.out.println("glosa"+glosa);
        
        /*Fecha*/
               
        String dia=request.getParameter("dia");
        String mes=request.getParameter("mes");
        String ani=request.getParameter("ani");
        
        String fecha=(dia+"/"+mes+"/"+ani);
        
        System.out.println("fecha "+fecha);
        
        String cbte=request.getParameter("cbte");
        System.out.println("cbte "+cbte);
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
        /*sacando tarea*/
        
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        
        /*sacndo actividad con codtar*/
        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        
        /*sacando  descripcion de codfueneco*/
        ProActTar des=new ProActTar();
        des.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",des,des);
        modelo.put("des",des);
        
        
        /*sumando la cantidad del monto de incremento a la cuenta */
        
        tras r=new tras();
        r.setCodmoning(codmoning);      
        r.setCodfueneco(codfueneco);
        r.setCodtar(codtar);
        r.setMonto(monsum);
        orm.ejecutarObjeto("montosingreso","suma2",r,null);
        
        /*Actualizando saldos a la cuenta uno*/
        
        tras rw=new tras();
        
        rw.setCodmoning(codmoning);      
        rw.setCodfueneco(codfueneco);
        rw.setCodtar(codtar);
       
        orm.ejecutarObjeto("montosingreso","actualiza_saldo",rw,null);
        
        /*Sumando al compo incremento*/
        orm.ejecutarObjeto("montosingreso","sum_incre",r,null);
        System.out.println("despuest de incrementos");
       
        /***************Guardando a historial de Incrementos*****************************************************************/
        
        String i_e="0";/*0---->ingresos*/
        tras tr=new tras();
        tr.setCodmon(codmoning);
        tr.setI_e(i_e);
        tr.setCodfueneco(codfueneco);
        tr.setCodtar(codtar);
        tr.setFecha(fecha);
        tr.setCbte(cbte);
        tr.setMonto(monsum);
        tr.setGlosa(glosa);
         
        orm.ejecutarObjeto("histo_incre","insertando_ing",tr,null);
        
        /***************FIN FIN FIN FIN Guardando a historial de Incrementos******************************************************************/
        
        /*sacando los resultados de las cuentas presupuestados ejecutados y saldo final
         de codmonegr Y codmonegr2 */
        //codmonegr
        
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        
        List monin=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",null, new MosPresuIng());
        
         String vu[]= new String[100];
       
         int sw=0;
    //8    int sw2=0;
         if(monin!=null) 
        {//if_1
           for(int i=0; i<monin.size();i++)
           {//for
                 MosPresuIng me=(MosPresuIng) monin.get(i);
                 if(codmoning.equals(me.getCodmoning()) && codfueneco.equals(me.getCodfueneco()) && codtar.equals(me.getCodtar()))
                {//if_2 
                     vu[0]= me.getCodmoning();//ki.getCodfueneco();
                     vu[1]= me.getDescla();
                     vu[2]=me.getCodfueneco();
                     vu[3]=me.getDesfe();
                    
                     
                     double tmpi = new Double(me.getMonto()).doubleValue();
                     vu[4]=df2.format(tmpi).toString();
                     
                     tmpi = new Double(me.getMoneje()).doubleValue();
                     vu[5]=df2.format(tmpi).toString();
                     
                     tmpi = new Double(me.getSaldo()).doubleValue();
                     vu[6]=df2.format(tmpi).toString();
                     sw=1; 
                 }//if_2
                              
                 if(sw==1)
                     {//fin if_4
                          i=monin.size() + 1;
                     }//fin if_4
                 
                  
            }//for
                 
               modelo.put("vu",vu);
   
         }//if_1
        
        
        
       /*descripcion del clasificador*/
         List partida=orm.ejecutarLista("clasificador","mostrar_rubros",null,new Rubro());
        
        modelo.put("partida",partida);
       
        sw=0;
        
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
        return new ModelAndView("presupuestos/incrementos/IncrIng4", modelo);
    }
}