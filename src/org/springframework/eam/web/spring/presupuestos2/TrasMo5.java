
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
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

public class TrasMo5 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
        String ref1=request.getParameter("ref1");
        String ref2=request.getParameter("ref2");
      
        String codtar=request.getParameter("codtar");
        modelo.put("codtar", codtar);
        String codacti=request.getParameter("codacti");
        modelo.put("codacti",codacti);
        String codmoning=request.getParameter("codmoning");
        String descla=request.getParameter("descla");
        modelo.put("codmoning",codmoning);
        modelo.put("descla",descla);
        
        String codfueneco=request.getParameter("codfueneco");
        String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        modelo.put("desfe",desfe);
        
        System.out.println("codfueneco"+codfueneco);
        
        
        String monto=request.getParameter("monto");
        modelo.put("monto",monto);
        
        
        System.out.println("monto"+monto);
        
        /*monto_restar glosa fecha*/
        String monres=request.getParameter("monres");
        modelo.put("monres",monres);
        
        System.out.println("monres"+monres);
        
        
        
        String glosa=request.getParameter("glosa");
        modelo.put("glosa",glosa);
        
        
        System.out.println("glosa"+glosa);
        
        /*Fecha*/
               
         //String fecha=request.getParameter("fecha");
         //modelo.put("fecha",fecha);
        String dia=request.getParameter("dia");
        String mes=request.getParameter("mes");
        String ani=request.getParameter("ani");
        
        String fecha=(dia+"/"+mes+"/"+ani);
        
        System.out.println("fecha "+fecha);
        
        String cbte=request.getParameter("cbte");
        System.out.println("cbte "+cbte);
        //modelo.put("monto",monto);        
        //String fecha=ani+"-"+mes"-"+ani;
        
        //java.util.Date d = targetDateFormat.parse(stodate);

        /*Fecha*/
        
        
        /*2 para cambiar*/
        String codmoning2=request.getParameter("codmoning2");
        String descla2=request.getParameter("descla2");
        modelo.put("codmoning2",codmoning2);
        modelo.put("descla2",descla2);
        
        System.out.println("codmoning2 "+codmoning2);
        
        String codfueneco2=request.getParameter("codfueneco2");
        String desfe2=request.getParameter("desfe2");
        modelo.put("codfueneco2",codfueneco2);
        modelo.put("desfe2",desfe2);
        
        System.out.println("codfueneco2 "+codfueneco2);
        
        
        String monto2=request.getParameter("monto2");
        modelo.put("monto2",monto2);
        
        System.out.println("monto2 "+monto2);
        
       
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
        
        /*restando la cantidad del monto de traspaso a la cuenta uno*/
        
        tras r=new tras();
        
        r.setCodmonegr(codmoning);      
        r.setCodfueneco(codfueneco);
        r.setCodtar(codtar);
        r.setMonto(monres);
        orm.ejecutarObjeto("montosegreso","resta2",r,null);
        
        /*Actualizando saldos a la cuenta uno*/
        
        tras rw=new tras();
        
        rw.setCodmonegr(codmoning);      
        rw.setCodfueneco(codfueneco);
        rw.setCodtar(codtar);
       
        orm.ejecutarObjeto("montosegreso","actualiza_saldo",rw,null);
        
        /*Sumando traspaso_s    traspasos salientes a la cuenta uno*/
        orm.ejecutarObjeto("montosegreso","sum_tra_s",r,null);
        System.out.println("despuest de traspasos");
       
        /*******************CUENTA DOS  ****************************/
        /*Actualizando la cuenta 2 sumando monres a la cuenta 2 monto presupuestado*/
        tras rq=new tras();
        rq.setCodmonegr(codmoning2);      
        rq.setCodfueneco(codfueneco);
        rq.setCodtar(codtar);
        rq.setMonto(monres);
        orm.ejecutarObjeto("montosegreso","suma2",rq,null);
        
        
        /*Sumando al monto acumulado de traspasos traspaso_r (recibidos) al cuemta dos*/
        orm.ejecutarObjeto("montosegreso","sum_tra_r",rq,null);
        
        
        /*Actualizando saldos a la cuenta dos*/
        tras qw=new tras();
        
        qw.setCodmonegr(codmoning2);
        qw.setCodfueneco(codfueneco);
        qw.setCodtar(codtar);
        orm.ejecutarObjeto("montosegreso","actualiza_saldo",qw,null);
       

        /***************Guardando a historial de traspasos******************************************************************/
        
        tras tr=new tras();
        
        tr.setCodmonegr(codmoning);
        tr.setCodmonegr2(codmoning2);
        //tr.setRef1(ref1);
        //tr.setRef2(ref2);
        tr.setCodfueneco(codfueneco);
        tr.setCodtar(codtar);
        tr.setFecha(fecha);
        tr.setCbte(cbte);
        tr.setMonto(monres);
        tr.setGlosa(glosa);
        
        
        
        //ProActTar cd=new ProActTar();
        //cd.setCodfueneco(codfueneco);
        //orm.ejecutarObjeto("fuenteeconomica","codfueneco",cd,cd);
        List fue=orm.ejecutarLista("fuenteeconomica","mostrar_todo",null,new ProActTar());          
        //modelo.put("des",cd);
        //tr.setDesfe(ddes);
        String des_fe;
        if(fue!=null) 
        {//if_1
                 for(int j=0; j<fue.size();j++)
                 {//for
                      ProActTar fa=(ProActTar) fue.get(j);
                      if(codfueneco.equals(fa.getCodfueneco()))
                           {//if_2
                                 des_fe=fa.getDescripcion();
                                 tr.setDesfe(des_fe);
                                 //tr.setDescla(des_ref1);
                                 //System.out.println("des_ref1-----------------"+des_ref1);
                           }//fin if_2   
                     
                 }//for
        
        
        }//if_1
        
        
        
        
        List partida=orm.ejecutarLista("clasificador","mostrar_partida",null,new Rubro());
        
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
                                  tr.setDescla(des_ref1);
                                 System.out.println("des_ref1-----------------"+des_ref1);
                           }//fin if_2
                           else
                           {//els if_2
                              if(ref2.equals(pa.getTipo()) && codmoning2.equals(pa.getCodigo()))
                              {//fin if_3
                                 des_ref2=pa.getDescripcion();     sw2=1;
                                 modelo.put("des_ref2",des_ref2);
                                 tr.setDescla2(des_ref2);
                                 System.out.println("des_ref2-----------------"+des_ref2);
                              }//fin if_3
                                          
                           }//els fin if_2
                 
                    if(sw==1 && sw2==1)
                     {//fin if_4
                          i=partida.size() + 1;
                     }//fin if_4
                 
            }//for
            
            orm.ejecutarObjeto("histo_tras","insertando",tr,null);
        }//if_1
        
        /***************FIN FIN FIN FIN Guardando a historial de traspasos******************************************************************/
        
        /*sacando los resultados de las cuentas presupuestados ejecutados y saldo final
         de codmonegr Y codmonegr2 */
        //codmonegr
        
        List moneg=orm.ejecutarLista("montosegreso","mostrar_montos_presupuestados",null, new MosPresuIng());
        
        String vu[]= new String[100];
        String vd[]= new String[100];
        sw=0;
        sw2=0;
        if(moneg!=null) 
        {//if_1
            for(int i=0; i<moneg.size();i++)
            {//for
                 MosPresuIng me=(MosPresuIng) moneg.get(i);
                 if(codmoning.equals(me.getCodmoning()) && codfueneco.equals(me.getCodfueneco()) && codtar.equals(me.getCodtar()))
                {//if_2
                     vu[0]= me.getCodmoning();//ki.getCodfueneco();
                     vu[1]= me.getDescla();
                     vu[2]=me.getCodfueneco();
                     vu[3]=me.getDesfe();
                     vu[4]=me.getMonto();
                     vu[5]=me.getMoneje();
                     vu[6]=me.getSaldo();
                     sw=1;
                 }//if_2
                 
                 if(codmoning2.equals(me.getCodmoning()) && codfueneco.equals(me.getCodfueneco()) && codtar.equals(me.getCodtar()))
                {//if_2
                     vd[0]= me.getCodmoning();//ki.getCodfueneco();
                     vd[1]= me.getDescla();
                     //vd[2]=me.getCodfueneco();
                     vd[2]=me.getMonto();
                     vd[3]=me.getMoneje();
                     vd[4]=me.getSaldo();
                     sw2=1;                     
                 }//if_2
                 
                 if(sw==1 && sw2==1)
                     {//fin if_4
                          i=moneg.size() + 1;
                     }//fin if_4
                 
                  
            }//for
                 
            modelo.put("vd",vd);
            modelo.put("vu",vu);
            
        }//if_1
        
        
        
       
        
        
        
        
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        return new ModelAndView("presupuestos2/traspaso/TrasMo5", modelo);
    }
}