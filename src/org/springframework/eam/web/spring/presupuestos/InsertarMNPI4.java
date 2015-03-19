
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.NoPresupues2;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.web.spring.calendario.Calendario;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertarMNPI4 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        




        String dia=request.getParameter("dia");
        String mes=request.getParameter("mes");
        String ani=request.getParameter("ani");
        
        
        String fecha= dia+"/"+mes+"/"+ani;
        String sal=request.getParameter("sal");
        
        String obs=request.getParameter("obs");
  
        String i_c;
        if(sal.equals("a"))
        {
          i_c="0";
          obs=obs+" "+fecha;          
        }
        else
        {
          i_c="1";
        
        }
        
        
        
        String cod=request.getParameter("codigo");/*codigo del clasificador*/
        String codfueneco=request.getParameter("codfueneco");
        String monejenopre=request.getParameter("monto");
        String montoacu=monejenopre;/*monto ejecutado que se acumula*/
        
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        String cod_gnp=request.getParameter("cod_gnp");

        modelo.put("codtar", codtar);
        modelo.put("codacti", codacti);
        modelo.put("cod_gnp", cod_gnp);


        String tartar=codtar;
        
        String comprobante=request.getParameter("comprobante");
        
        
        // String fecha=request.getParameter("fecha");
        String fech=fecha;
        
        
        
        //System.out.println("-----VRIALBLES VARIBLES del FORMULARIO-------");
        // System.out.println(ref123);
        String[] h = cod.split("::");/*cod      codigo del clasificador + tipo*/
        String ref123=h[0];
        String codmonnopreing=h[1];
        
        String codcod=codmonnopreing;
        
        
        System.out.println("REV LOS SALDOS SALDOS");
        System.out.println("tipo----"+ref123);
        System.out.println("codigoclasificador----"+codmonnopreing);
        System.out.println("codigofuente----"+codfueneco);
        System.out.println("codtar----"+codtar);
        System.out.println("montoeje----"+monejenopre);
        System.out.println("codacti----"+codacti);
        System.out.println("comprobante----"+comprobante);
        System.out.println("monacumulado----"+montoacu);
        System.out.println("fecha----"+fecha);
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        // GrupoRubro gr=new GrupoRubro();
        // gr.setCodgru_ru(codgru_ru);
        
        
        NoPresupues2 pre=new NoPresupues2();
        
        pre.setCodmonnopreing(codmonnopreing);
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        pre.setMonejenopre(monejenopre);
        pre.setRef123(ref123);
        pre.setComprobante(comprobante);
        pre.setI_c(i_c);
        pre.setSaldo_ej_i(monejenopre);
        pre.setFecha_saldo(fecha);
        pre.setGlosa_s(obs);
        
        orm.ejecutarObjeto("cuentanopresuing","inserta_ejecutado",pre,null);
        
        
        if(sal.equals("b"))
        {
          /*insertando a acumulado tabla referencia ejecu ing*/
          NoPresupues2 nnp=new NoPresupues2();
          nnp.setComprobante(comprobante);
          nnp.setObs(obs);
          nnp.setFecharef(fecha);
          nnp.setCodmonnopreing(codmonnopreing);
          nnp.setCodtar(codtar);
          nnp.setCodfueneco(codfueneco);
          nnp.setMon_acu(montoacu);
        
          orm.ejecutarObjeto("cuentanopresuing","inserta_ejecutado_referencia",nnp,null);
        }
        
        
        
        
        
        
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
        List mon=orm.ejecutarLista("cuentanopresuing","mostrar_ejecutados",null, new MosPresuIng());
        
        List mon_=new ArrayList();
        if(mon != null) {
            
            for(int i = 0;i< mon.size();i++) {
                MosPresuIng ki=(MosPresuIng) mon.get(i);
                
                float tmpi2 = new Float(ki.getMonejenopre()).floatValue();
                ki.setMonejenopre(df2.format(tmpi2).toString());
                
                mon_.add(ki);
            }
            
            
            modelo.put("mosmoneje",mon_);
        } else {
            
            modelo.put("mosmoneje",mon);
            
        }
        
        
        
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("presupuestos/montos/MuestraEjecutadosNoPresu", modelo);
        
    }
}