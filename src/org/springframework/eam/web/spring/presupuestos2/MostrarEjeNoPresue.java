
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

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MostrarEjeNoPresue implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String noref123=request.getParameter("noref123");
        
        String codfueneco=request.getParameter("codfueneco");
        //String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        // modelo.put("desfe",desfe);
        
        String codtar=request.getParameter("codtar");
        String monejenopre=request.getParameter("monejenopre");
        modelo.put("monejenopre",monejenopre);
        
        String codmonnopreegr=request.getParameter("codmonnopreegr");
        String descla=request.getParameter("descla");
        modelo.put("codmonnopreegr",codmonnopreegr);
        modelo.put("descla",descla);
        String codacti=request.getParameter("codacti");
        
        
        System.out.println("MOSTRANDOOOOOOOOOOOOO EJEEEEEEEEEE");
        //String codfueneco="TGN";
        System.out.println("fuente---"+codfueneco);
        System.out.println("codtar---"+codtar);
        System.out.println("codacti---"+codacti);
        System.out.println("montoeje---"+monejenopre);
        //  System.out.println("codigo de clasificador---"+codmoning);
        //codfueneco="TGN";
        
        
        // codacti = "DC";
        // codtar = "ta1";
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros




         /*saldo inicial*/
        MosPresuIng sali=new MosPresuIng();
        sali.setCodfueneco(codfueneco);
        sali.setCodtar(codtar);
        sali.setCodmonnopreegr(codmonnopreegr);
        orm.ejecutarObjeto("cuentanopresuegr","saldo_inicial",sali,sali);
        modelo.put("salini", sali);
       System.out.println("Monto Acumulado   "+ sali.getSaldo_ej_i());








        /*Sacando la actividad*/
        ProActTar act=new ProActTar();
        act.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",act,act);
        modelo.put("actividad",act);
        
        /*Sacando la tarea*/
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        
        
        
        
        
        /*Sacando Fuente Economica*/
  /*      FuenteEconomica fe= new FuenteEconomica();
        fe.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomia","codfueneco",fe,fe);
        modelo.put("fu",fe);
   */
        
        
        /*****************CLASIFICADOR***************************/
        
        /*********************************************/
        
        /*cacando montos presu eje saldo de un monto ejecutado especifico*/
        
        
        
        /*
         
        MosPresuIng mop=new MosPresuIng();
        mop.setCodmoning(codmoning);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        orm.ejecutarObjeto("cuentanopresuing","mon_eje",mop,mop);
        modelo.put("mont",mop);
         */
        
        /*/sacando comprobante e historial de montos ejecutados*/
        MosPresuIng mopr=new MosPresuIng();
        
        
        //mopr.setCodmonnopreing(codmonnopreing);
        //mopr.setCodmoning(codmoning);
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        mopr.setCodmonnopreegr(codmonnopreegr);
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        List mmn=orm.ejecutarLista("cuentanopresuegr","mon_ref",mopr,new MosPresuIng());
        List mmn_=new ArrayList();
        if(mmn != null) {
            
            for(int i = 0;i< mmn.size();i++) {
                MosPresuIng ki=(MosPresuIng) mmn.get(i);
                
                float tmpi = new Float(ki.getMon_acu()).floatValue();
                ki.setMon_acu(df2.format(tmpi).toString());
                
                mmn_.add(ki);
            }
            
            
            
            modelo.put("montos_ref",mmn_);
        } else {
            
            modelo.put("montos_ref",mmn);            
        }
        
        
        
        
        
        
         /*SUPER CUENTAA no presupuestadoooo*/
        if (noref123.equals("1"))
        {System.out.println("UNO");
          String supe="0"; 
          modelo.put("supe",supe);
        }
        
    
        
        if (noref123.equals("2"))
        {
            System.out.println("codigooooo------ "+noref123);
            MosPresuIng sup=new MosPresuIng();
            sup.setCodmonnopreegr(codmonnopreegr);
            orm.ejecutarObjeto("cuentanopresuegr","sub_a_grupo",sup,sup);
            modelo.put("sup",sup);
            String supe="1";
            modelo.put("supe",supe);
        }
        
        if (noref123.equals("3"))
        {
            System.out.println("codigooooo------ "+noref123);
            MosPresuIng sup=new MosPresuIng();
            sup.setCodmonnopreegr(codmonnopreegr);
            orm.ejecutarObjeto("cuentanopresuegr","det_a_grupo",sup,sup);
            modelo.put("sup",sup);
            String supe="1";
            modelo.put("supe",supe);
        }
        
        
        
        //////SACAR
        

       




        orm.cerrar();
        System.out.println("REF!---------------"+noref123);
        return new ModelAndView("presupuestos2/montos/MostrarRefNoPre", modelo);
    }
}