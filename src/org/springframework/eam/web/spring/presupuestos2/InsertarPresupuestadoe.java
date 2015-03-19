
package org.springframework.eam.web.spring.presupuestos2;

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

public class InsertarPresupuestadoe implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String monejeing=request.getParameter("monejeing");
        
        String sal=request.getParameter("sal");
        String cbte=request.getParameter("cbte");
        String glosa_s=request.getParameter("glosa_s");
        
        /*saldos a la fecha*/
        String dia=request.getParameter("dia");
        String mes=request.getParameter("mes");
        String ani=request.getParameter("ani");
        String fecha=dia+"/"+mes+"/"+ani;
        
        
        String obss;
        String i_c;
        
        //obss="Saldos de Caja y Bancos al "+fecha;
        if(sal.equals("a")) {
            obss=glosa_s+" "+fecha;
            i_c="0"; // es saldo inicial
        } else {
            obss=glosa_s;
            i_c="1";// no es saldo inicial
        }
        
        //String cbte="NA";
        //res variable     para la ultima paginita
        //String ref123=request.getParameter("tipo");
        String cod=request.getParameter("codigo");/*codigo del clasificador*/
        String codfueneco=request.getParameter("codfueneco");
        String montopresu=request.getParameter("monpreegre");
        
        
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        //System.out.println("-----VRIALBLES VARIBLES del FORMULARIO-------");
        // System.out.println(ref123);
        String[] h = cod.split("::");
        String ref123=h[0];
        String codmonegr=h[1];
        
        System.out.println(ref123);
        System.out.println(codmonegr);
        System.out.println(codfueneco);
        System.out.println(codtar);
        System.out.println(montopresu);
        
        System.out.println("monejeing ----- "+monejeing);
        System.out.println("fecha ----- "+fecha);
        
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        // GrupoRubro gr=new GrupoRubro();
        
// gr.setCodgru_ru(codgru_ru);
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
        pre.setCodmonegr(codmonegr);
        //pre.setCodmoning(codmonegr);
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
        
        orm.ejecutarObjeto("montosegreso","inserta__monto_presu",pre,null);
        
        
        /*Actualizando SALDOS*/
        orm.ejecutarObjeto("montosegreso","actualiza_saldo",pre,null);
        
        
        /*insertando a la referencia*/
        
        /*no07
         insertando a acumulado tabla referencia ejecu
         
         
        InsRef u=new InsRef();
        u.setComprobante(cbte);
        u.setObservaciones(obss);
        u.setFecha(fecha);
        u.setCodmonegr(codmonegr);
        u.setCodfueneco(codfueneco);
        u.setCodtar(codtar);
        u.setMonacumulado(monejeing);
        orm.ejecutarObjeto("montosegreso","inserta_ejecutado_referencia",u,null);
        no07*/
        
        
        
        
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
        
        
        
        
        /* if(tipo=='1')
        {  }
        else
        {  }
         */
        /*
        ProActTar pat=new ProActTar();
        pat.setCodpro(codigo);
        pat.setDescripcion(descripcion);
        pat.setU_ejecutora(u_ejecutora);
        orm.ejecutarObjeto("proacttar","insertar_programa",pat,null);
         */
        
        /*lista clasificador*/
        /*List gr=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",null, new GrupoRubro());
        modelo.put("clasificador",gr);
       /*lista fuente economica*/
 /*DDD**       List fe=orm.ejecutarLista("fuenteeconomica","mostrar_fuenteeconomica",null, new FuenteEconomica());
        modelo.put("fuente",fe);
        /*lista montosingreso*/
/*       List mo=orm.ejecutarLista("montosingreso","mostrar_presupuestado",null, new InsPreIng());
        modelo.put("presupuestado",mo);
 
 
        /************************************************************************************/
        /*quiero sacar el clasificador de los que estan en la tabla montos ingreso
         a la vez de fuentes economicas
         segun el codigo almacenado en la dichicha tabla*/
        /*******************************************************************************/
        // ProActTar nn=new ProActTar();
        //  nn.setCodtar(nn);
        //orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        //modelo.put("tarea",tar);
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        List mon=orm.ejecutarLista("montosegreso","mostrar_montos_presupuestados",null, new MosPresuIng());
        
        List mon_=new ArrayList();
        if(mon != null) {
            
            for(int i = 0;i< mon.size();i++) {
                MosPresuIng ki=(MosPresuIng) mon.get(i);
                
                float tmpi = new Float(ki.getMonto()).floatValue();
                ki.setMonto(df2.format(tmpi).toString());
                
                
                
                mon_.add(ki);
            }
            
            
            //modelo.put("mosz",mmz2);
            
            modelo.put("mosmoning",mon_);
        } else {
            
            modelo.put("mosmoning",mon);
            
        }
        
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/montos/MuestraPresupuestadosInsertadose", modelo);
    }
}