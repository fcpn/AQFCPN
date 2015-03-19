/* Programa:    MenuControlador
 * Descripcion: Establece el menu correspondiente al rol
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       26-10-2007
 * Modificado:  Lizeth Amalia Gutierrez Loza, IICCA
 * Fecha
 */
package org.springframework.eam.web.spring.presupuestos2;

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

public class InformeGeneralEgresos implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
       
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
        
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
        return new ModelAndView("presupuestos2/montos/MuestraGral1e", modelo);
    }
}