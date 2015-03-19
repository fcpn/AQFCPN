
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IncrEgr2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
       // String destar=request.getParameter("destar");
       // modelo.put("destar",destar);
        
        System.out.println("Cod tar---"+codtar);
      //  System.out.println("descri---"+destar);
        
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        //String desfe=request.getParameter("desfe");
        //modelo.put("desfe",desfe);
        
        System.out.println("CODFUENECO---"+codfueneco);
        //System.out.println("DESFE---"+desfe);
        
        
        
        // codacti = "DC";
        // codtar = "ta1";
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        
        
        /*Sacando Datos generales */
        gen tarr=new gen();
        tarr.setCodtar(codtar);
        
        List ff = orm.ejecutarLista("gral","codtar",tarr,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);
        /*FIN FIN FIN Sacando Datos generales */
        
        
        
        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        
        
        /*Sacando  todo de la descripcion de tarea*/
        ProActTar des=new ProActTar();
        des.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",des,des);
        modelo.put("tarea",des);
        
        
         /*Sacando  todo de la descripcion de fuente economica*/
        ProActTar fet=new ProActTar();
        fet.setCodfueneco(codfueneco);
        
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",fet,fet);
        modelo.put("fe",fet);
        
        /*FIN FIN FIN FIN */
      
        /* Sancando Informes a Ingresos Presupuestados Ejecutados Sados e historial a ejecutados*/
        
        List mon=orm.ejecutarLista("montosegreso","mostrar_montos_presupuestados",null, new MosPresuIng());
        
        List mon_=new ArrayList();
        if(mon != null) {
            
            
            for(int i = 0;i< mon.size();i++) {
                
                //Controlar la ki.getCodtar()==codtar para el reporte Final
                //Llenado la lista nueva
                MosPresuIng ki=(MosPresuIng) mon.get(i);
                
                double tmpi = new Double(ki.getMonto()).doubleValue();
                ki.setMonto(df2.format(tmpi).toString());
                
                double tmpi2 = new Double(ki.getMoneje()).doubleValue();
                ki.setMoneje(df2.format(tmpi2).toString());
                
                double tmpi3 = new Double(ki.getSaldo()).doubleValue();
                ki.setSaldo(df2.format(tmpi3).toString());
                
                mon_.add(ki);
            }
            
            
            //modelo.put("mosz",mmz2);
            
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
        too=orm.ejecutarObjeto("montosegreso","tot_presu_fe",to, new String());
        double num1=0;
        if(too != null) {
            num1 = new Double(too).doubleValue();}
        
        modelo.put("too",df2.format(num1).toString());
        
        
        
        String too1 = new String();
        too1=orm.ejecutarObjeto("montosegreso","tot_saldo_fe",to, new String());
        double num2=0;
        if(too1 != null) {
            num2 = new Double(too1).doubleValue();}
        modelo.put("too1",df2.format(num2).toString());
        
        
        String too2 = new String();
        too2=orm.ejecutarObjeto("montosegreso","tot_ejec_fe",to, new String());
        double nu3=0;
        if (too2 != null) {
            nu3 = new Double(too2).doubleValue();
            
        }
        
        
        /*3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333*/
        /*Mostrar lo noprespuestados ejecutados */
        List mm=orm.ejecutarLista("cuentanopresuegr","mostrar_ejecutados",null, new MosPresuIng());
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
        too3=orm.ejecutarObjeto("cuentasnopresuegr","tot_ejec_fe",to, new String());
        
        
        double nu4=0;
        if(too3 != null) {
            nu4 = new Double(too3).doubleValue();
        }
        double nu5 = nu3 + nu4;
        
        modelo.put("too3",df2.format(nu5).toString());
        
        
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/incrementos/IncrEgr2", modelo);
    }
}