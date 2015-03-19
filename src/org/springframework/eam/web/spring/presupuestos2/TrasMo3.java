
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

public class TrasMo3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
        String ref1=request.getParameter("ref1");
        modelo.put("ref1",ref1);
        
                
        String codacti=request.getParameter("codacti");
        modelo.put("codacti",codacti);
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        
        
        String codmoning=request.getParameter("codmoning");
        String descla=request.getParameter("descla");
        modelo.put("codmoning",codmoning);
        modelo.put("descla",descla);
        
        
        
        
        
        String codfueneco=request.getParameter("codfueneco");
        String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        modelo.put("desfe",desfe);
        
        
        String monto=request.getParameter("monto");
        modelo.put("monto",monto);
        
        
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
        
        /*77777777
        ProActTar act=new ProActTar();
        act.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",act,act);
        modelo.put("actividad",act);*/
        
        /*Sacando la tarea*/
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        
        
        
        /*Sacando Datos generales */
       /* gen tarr=new gen();
        tarr.setCodtar(codtar);
        
        List ff = orm.ejecutarLista("gral","codtar",tarr,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);*/
        /*FIN FIN FIN Sacando Datos generales */
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        
        List mon=orm.ejecutarLista("montosegreso","mostrar_montos_presupuestados",null, new MosPresuIng());
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
        
        /*
        ProActTar to2=new ProActTar();
        to2.setCodtar(codtar);
        String too2 = new String();
        too2=orm.ejecutarObjeto("montosingrenso","tot_ejec",to2, new String());
        modelo.put("too2",too2);
        System.out.println("TOT1-------"+too2);
         */
        String too2 = new String();
        too2=orm.ejecutarObjeto("montosegreso","tot_ejec_fe",to, new String());
        double nu3=0;
        if (too2 != null) {
            nu3 = new Double(too2).doubleValue();
            
        }
        
        
        /*Mostrar lo noprespuestados ejecutados */
        List mm=orm.ejecutarLista("cuentanopresuegr","mostrar_ejecutados",null, new MosPresuIng());
        List mm_=new ArrayList();
        
        if(mm != null){
            for(int i = 0;i< mm.size();i++) {
                MosPresuIng km=(MosPresuIng) mm.get(i);
                
                double tmpm = new Double(km.getMonejenopre()).doubleValue();
                km.setMonejenopre(df2.format(tmpm).toString());
                
                mm_.add(km);
            }
            
            
            modelo.put("mos",mm_);
        } else{
            modelo.put("mos",mm);
        }
        
        
        
        String too3 = new String();
        too3=orm.ejecutarObjeto("cuentasnopresuegr","tot_ejec_fe",to, new String());
        double nu4=0;
        if(too3 != null) {
            nu4 = new Double(too3).doubleValue();
        }
        double nu5 = nu3 + nu4;
        
        modelo.put("too3",df2.format(nu5).toString());
       
        
        String tooz = new String();
        tooz=orm.ejecutarObjeto("montosingreso","tot_presu_fe",to, new String());
        double numj=0;
        if(tooz != null) {
            numj = new Double(tooz).doubleValue();}
        modelo.put("tooz",df2.format(numj).toString());
        
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        System.out.println("ref1-----"+ref1);
        return new ModelAndView("presupuestos2/traspaso/TrasMo3", modelo);
    }
}