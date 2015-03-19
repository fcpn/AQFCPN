
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.InsRef;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;





import org.springframework.eam.web.spring.calendario.Calendario;



import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class InsertarPresupuestado implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
    String sal=request.getParameter("sal");
    System.out.println("SAL---->"+sal);
    
    String cbte=request.getParameter("cbte");
    
    String glosa_s=request.getParameter("glosa_s");
    System.out.println("glosa_s---->"+glosa_s);

        /*ejecutado saldo inicaial a la cuenta*/
        String monejeing=request.getParameter("monejeing");
        
        /*saldos a la fecha*/
        String dia=request.getParameter("dia");
        String mes=request.getParameter("mes");
        String ani=request.getParameter("ani");
        String fecha=dia+"/"+mes+"/"+ani;
        
        String obss;
        String i_c;
        
      //  String cbte=cdtew;
        
        if(sal.equals("a"))
        {
          obss=glosa_s+" "+fecha;
          i_c="0"; // es saldo inicial
        }
        else
        {
          obss=glosa_s;
          i_c="1";// no es saldo inicial
        }
        
        
        
        
        String cod=request.getParameter("codigo");/*codigo del clasificador*/
        String codfueneco=request.getParameter("codfueneco");
        String montopresu=request.getParameter("monpreing");
        
        
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        //System.out.println("-----VRIALBLES VARIBLES del FORMULARIO-------");
        // System.out.println(ref123);
        String[] h = cod.split("::");
        String ref123=h[0];
        String codmoning=h[1];
        
        System.out.println("ref123--- "+ref123);
        System.out.println("codmoning--"+codmoning);
        System.out.println("codfueneco--"+codfueneco);
        System.out.println("codtar-----"+codtar);
        System.out.println("mon presu---"+montopresu);
        System.out.println("fecha---"+fecha);
        System.out.println("monejeing---"+monejeing);
        //System.out.println("mon presu---"+);
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
        
        
        
        
        
        
        /*Fecha*/
        
        Calendario calendario = new Calendario();
        String me = calendario.getMonth();
        String di = Integer.toString(calendario.getDayOfMonth());
        String an = Integer.toString(calendario.getYear());
        
        String ff = di+" de "+me+" de "+an;
        
        InsPreIng fec=new InsPreIng();
        fec.setFecha_act(ff);
        fec.setCodtar(codtar);
        fec.setCodacti(codacti);
        orm.ejecutarObjeto("tarea","inserta_fecha_act",fec,null);
        /*fecha*/
        
        
        
        
        
        
        
        InsPreIng pre=new InsPreIng();
        pre.setCodmoning(codmoning);
        pre.setMontopresu(montopresu);
        pre.setRef123(ref123);
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        /*saldos*/
        /*saldo a la fecha*/
        pre.setFecha_saldo(fecha);
        pre.setSaldo_ej_i(monejeing);
        pre.setSaldo_i(montopresu);
        pre.setMontoeje(monejeing);
        pre.setGlosa_s(obss);
        pre.setI_c(i_c);
        
        /*se inserta en caso de que sea uno se toma encuenta la fecha para los reportes de los sementres deferenciando el cero*/
        orm.ejecutarObjeto("montosingreso","inserta_monto_presupuestado",pre,null);
        
        
        /*Actualizando SALDOS*/
        orm.ejecutarObjeto("montosingreso","actualiza_saldo",pre,null);
        
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
        
        
        
       
    DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        List mon=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",null, new MosPresuIng());
        
        List mon_=new ArrayList();
        if(mon != null) {
            
            for(int i = 0;i< mon.size();i++) {
                MosPresuIng ki=(MosPresuIng) mon.get(i);
                
                float tmpi = new Float(ki.getMonto()).floatValue();
                ki.setMonto(df2.format(tmpi).toString());
                
                //float tmpi2 = new Float(ki.getMoneje()).floatValue();
                // ki.setMoneje(df2.format(tmpi2).toString());
                
                // float tmpi3 = new Float(ki.getSaldo()).floatValue();
                // ki.setSaldo(df2.format(tmpi3).toString());
                
                mon_.add(ki);
            }
            
            
            //modelo.put("mosz",mmz2);
            
            modelo.put("mosmoning",mon_);
        } else {
            
            modelo.put("mosmoning",mon);
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
    
        return new ModelAndView("presupuestos/montos/MuestraPresupuestadosInsertados", modelo);
    }
}