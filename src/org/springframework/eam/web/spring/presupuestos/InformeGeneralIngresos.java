/* Programa:    MenuControlador
 * Descripcion: Establece el menu correspondiente al rol
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       26-10-2007
 * Modificado:  Lizeth Amalia Gutierrez Loza, IICCA
 * Fecha
 */
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.InsRef;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.MosRef;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InformeGeneralIngresos implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        //res variable     para la ultima paginita
        //String ref123=request.getParameter("tipo");
        // String cod=request.getParameter("codigo");/*codigo del clasificador*/
        // String codfueneco=request.getParameter("codfueneco");
        // String montoeje=request.getParameter("monpreing");
        // String monacumulado=montoeje;/*monto ejecutado que se acumula*/
        
        
        
        
        // String codacti=request.getParameter("codacti");
        // String codtar=request.getParameter("codtar");
        //  String tartar=codtar;
        
        //  String comprobante=request.getParameter("comprobante");
        //  String observaciones=request.getParameter("obs");
        //  String fecha=request.getParameter("fecha");
        //  String fech=fecha;
        
        
        
        //System.out.println("-----VRIALBLES VARIBLES del FORMULARIO-------");
        // System.out.println(ref123);
        // String[] h = cod.split("::");/*cod      codigo del clasificador + tipo*/
        // String ref123=h[0];
        // String codmoning=h[1];
        
        //  String codcod=codmoning;
        
        
        /*
        System.out.println("TIPO----"+ref123);
        System.out.println("codigoclasificador----"+codmoning);
        System.out.println("codigofuente----"+codfueneco);
        System.out.println("codtar----"+codtar);
        System.out.println("montoeje----"+montoeje);
        System.out.println("codacti----"+codacti);
        System.out.println("comprobante----"+comprobante);
        System.out.println("monacumulado----"+monacumulado);
        System.out.println("fecha----"+fecha);
         */
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        // GrupoRubro gr=new GrupoRubro();
        // gr.setCodgru_ru(codgru_ru);
        
        
      /*  InsPreIng pre=new InsPreIng();
        pre.setCodmoning(codmoning);
        //pre.setMontopresu(montoeje);
        pre.setMontoeje(montoeje);
        
        //pre.setRef123(ref123);
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        
        /*insertar montosejecutados*/
      /*  orm.ejecutarObjeto("montosingreso","inserta_ejecutado",pre,null);
        
        /*actualiza saldo*/
  /*      orm.ejecutarObjeto("montosingreso","actualiza_saldo",pre,null);
        
        
        /*insertando a acumulado tabla referencia ejecu ing*/
    /*    InsRef u=new InsRef();
        u.setComprobante(comprobante);
        u.setObservaciones(observaciones);
        u.setFecha(fech);/**/
   /*     u.setCodmoning(codcod);/**/
  /*      u.setCodfueneco(codfueneco);
        u.setCodtar(tartar);/**/
  /*      u.setMonacumulado(monacumulado);
        
        /*
        System.out.println("INGRESANDO a REFERENCIA");
        System.out.println("comprobante----"+comprobante);
        System.out.println("observaciones----"+observaciones);
        System.out.println("fecha----"+fecha);
        System.out.println("codmoning----"+codmoning);
        System.out.println("codfueneco----"+codfueneco);
        System.out.println("codtar----"+codtar);
        System.out.println("monacumulado----"+monacumulado);*/
        
        
        
   /*     orm.ejecutarObjeto("montosingreso","inserta_ejecutado_referencia",u,null);
        
        
        
        
        
        /*Sacando la actividad*/
    /*    ProActTar act=new ProActTar();
        act.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",act,act);
        modelo.put("actividad",act);
        
        /*Sacando la tarea*/
/*        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        */
        
        
        
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
         List sg = orm.ejecutarLista("proacttar","mostrar_programa",null,new ProActTar()); //llamano al _orm la consulta
        modelo.put("proacttar",sg);
        
      /*  List muetod=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",null, new MosPresuIng());
        //List oo=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",mon,mon);
        modelo.put("mosmoneje",muetod);
        
        
        /*List monref=orm.ejecutarLista("montosingreso","mostrar_referencia",null, new MosRef());
          modelo.put("mosref",monref);*/
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("presupuestos/montos/MuestraGral1", modelo);
    }
}