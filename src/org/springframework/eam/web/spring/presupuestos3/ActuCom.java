
package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;
import org.springframework.eam.domain.Comprometido;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ActuCom implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        
        
        /*MOSTRAR LISTADO DE SOLO COMPROMETIDOS POR TAREA*/
        
        
        
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
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
        gen tarr=new gen();
        tarr.setCodtar(codtar);
        
        List ff = orm.ejecutarLista("gral","codtar",tarr,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);
        /*FIN FIN FIN Sacando Datos generales */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Comprometido tt=new Comprometido();
        tt.setCodtar(codtar);
        List mon=orm.ejecutarLista("comproegr","mostrar_compro",tt, new Comprometido());
        modelo.put("refcompro",mon);
        
        
        
        
        
        
        
        
        
        
        //total montospresupuesados  ingresos
        ProActTar to=new ProActTar();
        to.setCodtar(codtar);
        
        //Sacando la suma del total de montos presupuestados
        String too = new String();
        too=orm.ejecutarObjeto("montosegreso","tot_presu",to, new String());
        System.out.println("TOTALESSSSSSS-------"+too);
        modelo.put("too",too);
        
        
        
        
        
        String too1 = new String();
        too1=orm.ejecutarObjeto("montosegreso","tot_saldo",to, new String());
        System.out.println("TOTALESSSSSSS-------"+too1);
        modelo.put("too1",too1);
        
        /*
        ProActTar to2=new ProActTar();
        to2.setCodtar(codtar);
        String too2 = new String();
        too2=orm.ejecutarObjeto("montosingrenso","tot_ejec",to2, new String());
        modelo.put("too2",too2);
        System.out.println("TOT1-------"+too2);
         */
        String too2 = new String();
        too2=orm.ejecutarObjeto("montosegreso","tot_ejec",to, new String());
        System.out.println("TOTALESSSSSSS-------"+too2);
        modelo.put("too2",too2);
        
        
        
        /*Mostrar lo noprespuestados ejecutados */
        List mm=orm.ejecutarLista("cuentanopresuegr","mostrar_ejecutados",null, new MosPresuIng());
        //List oo=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",mon,mon);
        modelo.put("mos",mm);
        
        
        
        String too3 = new String();
        too3=orm.ejecutarObjeto("cuentasnopresuegr","tot_ejec",to, new String());
        System.out.println("TOTALESSS333-------"+too3);
        modelo.put("too3",too3);
       /*
        String too3 = new String();
        too3=orm.ejecutarObjeto("cuentanopresuing","tot_eje",to,new String());
        modelo.put("too3",too3);
        System.out.println("TOT3------------"+too3);*/
        
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
        
        /*totales presupuestados ingresos*/
        //Sacando la suma del total de montos presupuestados
        
        String tooz = new String();
        tooz=orm.ejecutarObjeto("montosingreso","tot_presu",to, new String());
        System.out.println("total ingresos--"+tooz);
        modelo.put("tooz",tooz);
        /**/
         
        
        
        
        
         System.out.println("666666666666666666666555555555555555555444444444444");
        
         
         
      
        
        
        if (mon.size() > 0)
        {
            System.out.println("a menos 0000000           "); 
            modelo.put("gg","0");       
        }
        else
        {
    
            System.out.println("a menos unooooooooo           "); 
            modelo.put("gg","-1"); 
        }
        orm.cerrar();//cerrar la conexion    ahora vamos a jsp
        
        return new ModelAndView("presupuestos2/comprometido/MuestraRefCompro", modelo);
    }
}