
package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class GralFuen3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String programa    = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        String destar=request.getParameter("destar");
        modelo.put("destar",destar);
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        String desfe=request.getParameter("desfe");
        modelo.put("desfe",desfe);
        orm_bd orm = new orm_bd();
        orm.verCompilado = "C";
        mconexion m = new mconexion();
        orm.establecerConexion(m.extraerConexion("url1"));
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        gen tarr=new gen();
        tarr.setCodtar(codtar);
        List ff = orm.ejecutarLista("gral","codtar",tarr,new gen());
        modelo.put("grl",ff);
        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        FuenteEconomica fuente =new FuenteEconomica();
        fuente.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica", "codfueneco", fuente, fuente);
        modelo.put("fuente",fuente);
        /* Sancando Informes a Ingresos Presupuestados Ejecutados Sados e historial a ejecutados*/
        List mon=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",null, new MosPresuIng());
        List mon_=new ArrayList();
        if(mon != null) {
            for(int i = 0;i< mon.size();i++) {
                MosPresuIng ki=(MosPresuIng) mon.get(i);
                
                double tmpi = new Double(ki.getMonto()).doubleValue();
                ki.setMonto(df2.format(tmpi).toString());
                
                double tmpi2 = new Double(ki.getMoneje()).doubleValue();
                ki.setMoneje(df2.format(tmpi2).toString());
                
                double tmpi3 = new Double(ki.getSaldo()).doubleValue();
                ki.setSaldo(df2.format(tmpi3).toString());
                
                mon_.add(ki);
            }
            modelo.put("mosmoneje",mon_);
        } else {
            
            modelo.put("mosmoneje",mon);
            
        }
        
        //total montospresupuesados  ingresos
        ProActTar to=new ProActTar();
        to.setCodtar(codtar);
        to.setCodfueneco(codfueneco);
        
        //Sacando la suma del total de montos presupuestados
        String too = new String();
        too=orm.ejecutarObjeto("montosingreso","tot_presu_fe",to, new String());
        double num1=0;
        if(too != null) {
            num1 = new Double(too).doubleValue();}
        
        modelo.put("too",df2.format(num1).toString());
        
        
        
        String too1 = new String();
        too1=orm.ejecutarObjeto("montosingreso","tot_saldo_fe",to, new String());
        double num2=0;
        if(too1 != null) {
            num2 = new Double(too1).doubleValue();}
        modelo.put("too1",df2.format(num2).toString());
        
        
        String too2 = new String();
        too2=orm.ejecutarObjeto("montosingreso","tot_ejec_fe",to, new String());
        double nu3=0;
        if (too2 != null) {
            nu3 = new Double(too2).doubleValue();
            
        }
        
        
        /*3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333*/
        /*Mostrar lo noprespuestados ejecutados */
        List mm=orm.ejecutarLista("cuentanopresuing","mostrar_ejecutados",null, new MosPresuIng());
        List mm_=new ArrayList();
        
        if(mm != null){
            for(int i = 0;i< mm.size();i++) {
                MosPresuIng km=(MosPresuIng) mm.get(i);
                
                double tmpm = new Double(km.getMonejenopre()).floatValue();
                km.setMonejenopre(df2.format(tmpm).toString());
                
                mm_.add(km);
            }
            
            
            modelo.put("mos",mm_);
        } else{
            modelo.put("mos",mm);
        }
        
        
        //
        
        
        
        String too3 = new String();
        too3=orm.ejecutarObjeto("cuentasnopresuing","tot_ejec_fe",to, new String());
        
        
        double nu4=0;
        if(too3 != null) {
            nu4 = new Double(too3).doubleValue();
        }
        double nu5 = nu3 + nu4;
        
        modelo.put("too3",df2.format(nu5).toString());
        
        
        /*FIN FIN FIN FIN Sancando Informes a Ingresos Presupuestados Ejecutados Sados e historial a ejecutados*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        ///A TODOS Z PARA EGRESOS
        List monz=orm.ejecutarLista("comproegr","gral_com_sal",null, new MosPresuIng());
        
        
        String scom=null;
        String scom2=null;
        String scom3=null;
        int y=0;
        double totmoncom=0.0;
        double totsalcom=0.0;
        List monz_=new ArrayList();
        if(monz != null) {
            
            for(int i = 0;i< monz.size();i++) {
                MosPresuIng kii=(MosPresuIng) monz.get(i);
                
                double tmpii = new Double(kii.getMonto()).doubleValue();
                kii.setMonto(df2.format(tmpii).toString());
                
                double tmpii2 = new Double(kii.getMoneje()).doubleValue();
                kii.setMoneje(df2.format(tmpii2).toString());
                
                double tmpii3 = new Double(kii.getSaldo()).doubleValue();
                kii.setSaldo(df2.format(tmpii3).toString());
                
                
                if(kii.getMontocom()!=null && codtar.equals(kii.getCodtar()))
                {  
                    
                    System.out.println("-----------------------------------------989898989898989898  ENTRAAA  -----------------------------------------989898989898989898  ENTRAAA  -----------------------------------------989898989898989898  ENTRAAA  -----------------------------------------989898989898989898  ENTRAAA  -----------------------------------------989898989898989898  ENTRAAA");
                    double tmpii4 = new Double(kii.getMontocom()).doubleValue(); 
                    kii.setMontocom(df2.format(tmpii4).toString());
                    
                    double tmpii5 = new Double(kii.getSaldocompro()).doubleValue();
                    kii.setSaldocompro(df2.format(tmpii5).toString());
                   
                      if(codfueneco.equals(kii.getCodfueneco()))
                      {
                        totmoncom=totmoncom+tmpii4;
                        totsalcom=totsalcom+tmpii5;
                      }
                      System.out.println("Entraaaaaaaaa"+scom);
                      scom2="Monto Comprometido";
                      scom3="Saldo mas Comprometido";
                      modelo.put("scom2",scom2);
                      modelo.put("scom3",scom3);
                      scom="--1";
                      
                     
                
                }
                monz_.add(kii);
                
            }
            
            modelo.put("mosmonejez",monz_);
            
        } else {
            modelo.put("mosmonejez",monz);
            
        }
        System.out.println("Entraaaaaaaaa"+scom);
        modelo.put("scom",scom);
        
        
        
        
        
        DecimalFormat df1 = new DecimalFormat("#,###,###,##0.00");
        modelo.put("totmoncom",df1.format(totmoncom).toString());
        modelo.put("totsalcom",df1.format(totsalcom).toString());
        
        
        //total montospresupuesados  ingresos
        ProActTar toz=new ProActTar();
        toz.setCodtar(codtar);
        toz.setCodfueneco(codfueneco);
        //Sacando la suma del total de montos presupuestados
        String tooz = new String();
        tooz=orm.ejecutarObjeto("montosegreso","tot_presu_fe",toz, new String());
        double num=0;
        if(tooz != null) {
            num = new Double(tooz).doubleValue();}
        modelo.put("tooz",df1.format(num).toString());
        
        String too1z = new String();
        too1z=orm.ejecutarObjeto("montosegreso","tot_saldo_fe",toz, new String());
        double nu7=0;
        if(too1z != null) {
            nu7 = new Double(too1z).doubleValue();}
        modelo.put("too1z",df2.format(nu7).toString());
        
        
        
        
        /*88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888*/
        String too2z = new String();
        too2z=orm.ejecutarObjeto("montosegreso","tot_ejec_fe",to, new String());
        
        double nu8=0;
        if(too2z != null) {
            nu8 = new Double(too2z).doubleValue();
        }
        
        
        
        
        /*Mostrar lo noprespuestados ejecutados */
        List mmz=orm.ejecutarLista("cuentanopresuegr","mostrar_ejecutados",null, new MosPresuIng());
        
        List mmz2=new ArrayList();
        for(int i = 0;i< mmz.size();i++) {
            MosPresuIng k=(MosPresuIng) mmz.get(i);
            //MosPresuIng k2 = new MosPresuIng();
            
            double tmp = new Double(k.getMonejenopre()).doubleValue();
            k.setMonejenopre(df2.format(tmp).toString());
            
            mmz2.add(k);
        }
        
        
        modelo.put("mosz",mmz2);
        
        
        
        String too3z = new String();
        too3z=orm.ejecutarObjeto("cuentasnopresuegr","tot_ejec_fe",toz, new String());
        
        
        double nu9=0;
        if(too3z != null) {
            nu9 = new Double(too3z).doubleValue();
        }
        double nu10 = nu8 + nu9;
        
        modelo.put("too3z",df2.format(nu10).toString());
        
        
        
        
        /*total de los ejecutados*/
        double nu90 = nu5 - nu10;
        double totmsalcom=nu90-totmoncom;
        modelo.put("toto",df2.format(nu90).toString());
        modelo.put("totmsalcom",df2.format(totmsalcom).toString());
        
        
        
        
        
        
        
        
         
        /*Sacando la tarea*/
           ProActTar tarw=new ProActTar();
           tarw.setCodtar(codtar);
           orm.ejecutarObjeto("proacttar","codtar",tarw,tarw);
           
           
           System.out.println("Fechaaaaa   "+tarw.getCodtar());
           System.out.println("Fechaaaaa   "+tarw.getDescripcion());
           System.out.println("Fechaaaaa   "+tarw.getFecha_act());
           modelo.put("fech",tarw);
        ///////////////////////////////////////////
           ///comprometidos para
 /*      List moncz=orm.ejecutarLista("comproegr","mostrar_compro",null, new Comprometido());
       List moncz_=new ArrayList();
        if(monz != null) {
            
            for(int i = 0;i< monz.size();i++) {
                Comprometido kii=(Comprometido) monz.get(i);
                
                double tmpii = new Double(kii.getMonto()).doubleValue();
                kii.setMonto(df2.format(tmpii).toString());
                
                moncz_.add(kii);
            }
            
            modelo.put("mosmoncom",moncz_);
        } else {
            modelo.put("mosmoncom",moncz);
        }        
              
       */ 
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos3/fuentes/MuestraFuPatEgrIng", modelo);
    }
}