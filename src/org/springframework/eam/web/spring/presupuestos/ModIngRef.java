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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.InsRef;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModIngRef implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        /**7777777777777777777777777777777777777777777777777777**/
        
        
        String codfueneco=request.getParameter("codfueneco");
        String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        modelo.put("desfe",desfe);
        
        System.out.println("codfueneco--"+codfueneco);
        System.out.println("desfe--"+desfe);
        
        
        String id=request.getParameter("idd");
        modelo.put("id",id);
        System.out.println("idididididididididididididididi--"+id);
        
        
        String codtar=request.getParameter("codtar");
        String destar=request.getParameter("destar");
        modelo.put("codtar",codtar);
        modelo.put("destar",destar);
        System.out.println("codtar--"+codtar);
        System.out.println("destar--"+destar);
        
        
        
        String comprobante=request.getParameter("comprobante2");
        modelo.put("comprobante",comprobante);
        System.out.println("comprobante--"+comprobante);
        
        
        
        String monacumulado=request.getParameter("monacumulado");
        modelo.put("monacumulado",monacumulado);
        System.out.println("monacumulado--"+monacumulado);
        
        
        String monacumulado2=request.getParameter("monacumulado2");
        modelo.put("monacumulado",monacumulado2);
        System.out.println("monacumulado2--"+monacumulado2);
        
        
        
        
        String observaciones=request.getParameter("observaciones2");
        modelo.put("observaciones",observaciones);
        System.out.println("observaciones--"+observaciones);
        
        
        
        
        String fecha=request.getParameter("fecha2");
        modelo.put("fecha",fecha);
        System.out.println("fecha--"+fecha);
        
        
        
        
        String codacti=request.getParameter("codacti");
        String desact=request.getParameter("desact");
        modelo.put("codacti",codacti);
        modelo.put("desact",desact);
        System.out.println("codacti--"+codacti);
        System.out.println("desact--"+desact);
        
        /**7777777777777777777777777777777777777777777777777777**/
        String codmoning=request.getParameter("codmoning");
        System.out.println("Cod anterior---"+codmoning);
        
        
        //String saldo = monpre-moneje;
        
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        
        InsPreIng pre=new InsPreIng();
        pre.setCodmoning(codmoning);
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        pre.setMonacumulado(monacumulado);
        
        /*Restamos el montos ingreso ejecutado anterior monto (errado)*/
        orm.ejecutarObjeto("montosingreso","resta",pre,null);
        
        /* SUMARRRRRRR montos ingreso ejecutado nuevo de referencia*/
        InsPreIng pre2=new InsPreIng();
        pre2.setCodmoning(codmoning);
        pre2.setCodfueneco(codfueneco);
        pre2.setCodtar(codtar);
        pre2.setMonacumulado(monacumulado2);
                
        orm.ejecutarObjeto("montosingreso","suma",pre2,null);
         
        /*actualiza saldo*/
        orm.ejecutarObjeto("montosingreso","actualiza_saldo",pre,null);
        
        
        /*Actualizamos a referencia*/
        InsRef u=new InsRef();
        u.setComprobante(comprobante); 
        u.setObservaciones(observaciones); 
        u.setFecha(fecha); 
        u.setCodmoning(codmoning);
        u.setCodfueneco(codfueneco);
        u.setCodtar(codtar);
        u.setMonacumulado(monacumulado2);
        u.setId(id);
        orm.ejecutarObjeto("montosingreso","actualiza_ejecutado_ref",u,null);
        
         
        orm.cerrar();//cerrar la conexionjsp
        return new ModelAndView("presupuestos/clasificador/OK", modelo);
    }
}