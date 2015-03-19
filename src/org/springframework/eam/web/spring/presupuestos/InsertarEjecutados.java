
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

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.eam.web.spring.calendario.Calendario;



public class InsertarEjecutados implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //res variable     para la ultima paginita
        //String ref123=request.getParameter("tipo");
        String cod=request.getParameter("codigo");/*codigo del clasificador*/
        String codfueneco=request.getParameter("codfueneco");
        String montoeje=request.getParameter("monpreing");
        String monacumulado=montoeje;/*monto ejecutado que se acumula*/
        
        String dia=request.getParameter("dia");
        String mes=request.getParameter("mes");
        String ani=request.getParameter("ani");
        
        String fecha=dia+"/"+mes+"/"+ani;
        
        
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        String tartar=codtar;
        
        String comprobante=request.getParameter("comprobante");
        String observaciones=request.getParameter("obs");
        
        
        String fech=fecha;
        
        
        
        //System.out.println("-----VRIALBLES VARIBLES del FORMULARIO-------");
        // System.out.println(ref123);
        String[] h = cod.split("::");/*cod      codigo del clasificador + tipo*/
        String ref123=h[0];
        String codmoning=h[1];
        
        String codcod=codmoning;
        
        
        System.out.println("REV LOS SALDOS SALDOS");
        System.out.println("tipo----"+ref123);
        System.out.println("codigoclasificador----"+codmoning);
        System.out.println("codigofuente----"+codfueneco);
        System.out.println("codtar----"+codtar);
        System.out.println("montoeje----"+montoeje);
        System.out.println("codacti----"+codacti);
        System.out.println("comprobante----"+comprobante);
        System.out.println("monacumulado----"+monacumulado);
        System.out.println("fecha----"+fecha);
        
        
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
        pre.setCodmoning(codmoning);
        //pre.setMontopresu(montoeje);
        pre.setMontoeje(montoeje);
        
        //pre.setRef123(ref123);
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        
        /*insertar montosejecutados*/
        orm.ejecutarObjeto("montosingreso","inserta_ejecutado",pre,null);
        
        /*actualiza saldo*/
        orm.ejecutarObjeto("montosingreso","actualiza_saldo",pre,null);
        
        
        /*insertando a acumulado tabla referencia ejecu ing*/
        InsRef u=new InsRef();
        u.setComprobante(comprobante);
        u.setObservaciones(observaciones);
        u.setFecha(fech);/**/
        u.setCodmoning(codcod);/**/
        u.setCodfueneco(codfueneco);
        u.setCodtar(tartar);/**/
        u.setMonacumulado(monacumulado);
        
        orm.ejecutarObjeto("montosingreso","inserta_ejecutado_referencia",u,null);
        
        
        
        
        
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
                
                float tmpi2 = new Float(ki.getMoneje()).floatValue();
                ki.setMoneje(df2.format(tmpi2).toString());
                mon_.add(ki);
            }
            
            
            
            
            modelo.put("mosmoneje",mon_);
        } else {
            
            modelo.put("mosmoneje",mon);
            
        }
        
        
        
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        
        return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);
    }
}