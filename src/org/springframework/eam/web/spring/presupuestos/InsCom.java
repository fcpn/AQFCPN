
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsCom implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        //llevando fuente economica codigo + descripcion
        String codfueneco=request.getParameter("codfueneco");
        String desfe=request.getParameter("desfe");
        
        modelo.put("codfueneco",codfueneco);
        modelo.put("desfe",desfe);
        
        //llevando fuente tarea + descripcion
        String codtar=request.getParameter("codtar");
        String destar=request.getParameter("destar");
        modelo.put("codtar",codtar);
        modelo.put("destar",destar);
        System.out.println("DES_Tarea ---- "+codtar);
        
        
        
        //llevando fuente clasificador codigo + descripcion
        String codmoning=request.getParameter("codmoning");
        String descla=request.getParameter("descla");
        modelo.put("codmoning",codmoning);//Es el codigo del calsificador en este caso de CLASIFICADOR EGRESOS
        modelo.put("descla",descla);
        
        //llevando fuente actividad + descripcion
        String codacti=request.getParameter("codacti");
        String desact=request.getParameter("desact");
        modelo.put("codacti",codacti);
        modelo.put("desact",desact);
        System.out.println("DES_actividad ---- "+codacti);
        
        
        
        
        String[] vec = new String [100];
        //String cod=request.getParameter("codigo");
        String cod=request.getParameter("codigo");
        
        
        // String[] h = compro_metido.split("::");
       // String ref123=h[0];
      //  String codmonnopreegr=h[1];
        
        /*
        String id_cnv_matriz_lis[] = request.getParameterValues("id_cnv_matriz_lis");
        for(int i = 0 ; i < id_cnv_matriz_lis.length ; i++)
	    {
	        convalidaciones.setId_estudiante(id_cnv_matriz_lis[i]);
             
             } */
        
        int j=-1;
        String com[]  = request.getParameterValues("compro");//request.getParameterValues("compro");
        //String [] compro = com.split("::");
         if(com!=null)
        {
        System.out.println("AAAAAAAAAAAAA ");
        String compro []= new String[150];
        j=0;
        for(int i = 0 ; i < com.length ; i++) 
            {
                   //System.out.println(com[i]);
                   String[] h = com[i].split("::");
                   compro[j]=h[0];
                   compro[j+1]=h[1];
                   compro[j+2]=h[2];
                   
                   j=j+3;
            }
          j=j-3;
         
         for(int g=0; g<=j;g=g+3)
        {
            System.out.println(compro[g]+" "+compro[g+1]+" "+compro[g+2]);
        
        }
        modelo.put("M",compro);
         }
         modelo.put("j",Integer.toString(j));
       /* String ser[] = request.getParameterValues("compro");
        String com[] = cod.split("::");
        
        System.out.println("AAAAAAAAAAAAAAAAAA");
        int j=0;
        if(ser!=null)
        {
            for(int i = 0 ; i < ser.length ; i++) 
            {
                vec[j]=com[0];
                vec[j++]=com[1];
                vec[j++]=com[2];
           
                j=j+3;
            }
        }
        
        for(int g=0; g<j;g++)
        {
            System.out.println(vec[g]);
        
        }
        
        */
       
        
        //llevando monto presupuestado
        String monpre=request.getParameter("monpre");
        modelo.put("monpre",monpre);
        
        //llevando monto ejecutado
        String moneje=request.getParameter("moneje");
        modelo.put("moneje",moneje);
        
        //llevando saldo
        String saldo=request.getParameter("saldo");
        modelo.put("saldo",saldo);
        
        /*77777777
        System.out.println("MOSTRANDOOOOOOOOOOOOO EJEEEEEEEEEE");
        //String codfueneco="TGN";
        System.out.println("fuente---"+codfueneco);
        System.out.println("codtar---"+codtar);
        System.out.println("codacti---"+codacti);
        System.out.println("montoeje---"+moneje);
        System.out.println("codigo de clasificador---"+codmoning);
        //codfueneco="TGN";
         */
        
        // codacti = "DC";
        // codtar = "ta1";
        
        /*7777777777777777777
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        7777777777777777777777*/
        
        
        /*Sacando la actividad*/
        /*7777777777777777777
        ProActTar act=new ProActTar();
        act.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",act,act);
        modelo.put("actividad",act);
        77777777777*/
        
        
        
        /*Sacando la tarea*/
        /*7777777777
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        77777777*/
        
        
        
        
        /*Sacando Fuente Economica*/
  /*      FuenteEconomica fe= new FuenteEconomica();
        fe.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomia","codfueneco",fe,fe);
        modelo.put("fu",fe);
   */
        
        
        /*****************CLASIFICADOR***************************/
        
        /*********************************************/
        
        /*cacando montos presu eje saldo de un monto ejecutado especifico*/
       /*77777777777777777777
        MosPresuIng mop=new MosPresuIng();
        mop.setCodmoning(codmoning);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        orm.ejecutarObjeto("montosingreso","mon_pre_eje_sal",mop,mop);
        modelo.put("montos",mop);
        777777777777777*/
        
        /*/sacando comprobante e historial de montos ejecutados*/
        /*77777777777777777777
        MosPresuIng mopr=new MosPresuIng();
        mopr.setCodmoning(codmoning);
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        7777777777777*/
        
        /*77777777777777
        List mont=orm.ejecutarLista("montosingreso","mon_eje_com",mopr,new MosPresuIng());
        modelo.put("montos_ref",mont);
        77777777777777777*/
        //  orm.ejecutarObjeto("montosingreso","mon_eje_com",mopr,mopr);
        // modelo.put("montos_ref",mopr);
        
        
        
        
        //  List mon=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",null, new MosPresuIng());
        //  modelo.put("mosmoneje",mon);
        
        //total montospresupuesados  ingresos
        /************777777
         *ProActTar to=new ProActTar();
         *to.setCodtar(codtar);
         * //Sacando la suma del total de montos presupuestados
         * String too = new String();
         * too=orm.ejecutarObjeto("montosingreso","tot_presu",to, new String());
         * System.out.println("TOTALESSSSSSS-------"+too);
         * modelo.put("too",too);
         *
         * String too1 = new String();
         * too1=orm.ejecutarObjeto("montosingreso","tot_saldo",to, new String());
         * System.out.println("TOTALESSSSSSS-------"+too1);
         * modelo.put("too1",too1);
         *
         * /*
         * ProActTar to2=new ProActTar();
         * to2.setCodtar(codtar);
         * String too2 = new String();
         * too2=orm.ejecutarObjeto("montosingrenso","tot_ejec",to2, new String());
         * modelo.put("too2",too2);
         * System.out.println("TOT1-------"+too2);
         */
        
        /*********777777777
         * String too2 = new String();
         * too2=orm.ejecutarObjeto("montosingreso","tot_ejec",to, new String());
         * System.out.println("TOTALESSSSSSS-------"+too2);
         * modelo.put("too2",too2);
         *
         *
         *
         *
         * List mm=orm.ejecutarLista("cuentanopresuing","mostrar_ejecutados",null, new MosPresuIng());
         * //List oo=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",mon,mon);
         * modelo.put("mos",mm);
         * String too3 = new String();
         * too3=orm.ejecutarObjeto("cuentasnopresuing","tot_ejec",to, new String());
         * System.out.println("TOTALESSS333-------"+too3);
         * modelo.put("too3",too3);
         *
         * String too3 = new String();
         * too3=orm.ejecutarObjeto("cuentanopresuing","tot_eje",to,new String());
         * modelo.put("too3",too3);
         * System.out.println("TOT3------------"+too3);*/
        
        /*     // creacion del modelo de presentacion de la matriz
        List fuentes=orm.ejecutarLista("fuenteeconomica","mostrar_todo",null, new FuenteEconomica());
         
        int sw=0;
        String[][] matriz = new String [100][100];
        int x = 0; int y = 0;
        for (int i = 0; i<mon.size(); i++) {
            MosPresuIng mon_i = (MosPresuIng) mon.get(i);
            if (mon_i.getCodtar().equals("ta1"))
            {
                System.out.println(mon_i.getCodmoning()+" - "+mon_i.getDescla());
         
                for (int j = 0; j<mon.size();j++)
                {   }
            }
         
         
         */
        
        
        
        //}
        
        
        
        
        // orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("presupuestos2/comprometido/MosCom", modelo);
    }
}