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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.InsRef;
import org.springframework.eam.domain.NoPresupues2;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModRefNoPreE implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
       
        
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        System.out.println("codfueneco--"+codfueneco);
        //System.out.println("desfe--"+desfe);
        
        
        String codtar=request.getParameter("codtar");
        String destar=request.getParameter("destar");
        modelo.put("codtar",codtar);
        modelo.put("destar",destar);
        System.out.println("codtar--"+codtar);
        System.out.println("destar--"+destar);
        
        
        
        String idd=request.getParameter("idd");
        modelo.put("idd",idd);
        System.out.println("Iddd   DOS DOS ---"+idd);
        
        String comprobante=request.getParameter("comprobante2");
        modelo.put("comprobante",comprobante);
        System.out.println("comprobante--"+comprobante);
        
        
        
        String mon_acu=request.getParameter("mon_acu");
        modelo.put("mon_acu",mon_acu);
        System.out.println("monacumulado1--"+mon_acu);
        
        
        String mon_acu2=request.getParameter("mon_acu2");
        modelo.put("mon_acu2",mon_acu2);
        System.out.println("mon_acu2--"+mon_acu2);
        
        
        
        
        String obs=request.getParameter("observaciones2");
        modelo.put("obs",obs);
        System.out.println("obs--"+obs);
        
       
        String fecharef2=request.getParameter("fecharef2");
        modelo.put("fecharef2",fecharef2);
        System.out.println("fecharef2--"+fecharef2);
        
        
        
        
        String codacti=request.getParameter("codacti");
        String desact=request.getParameter("desact");
        modelo.put("codacti",codacti);
        modelo.put("desact",desact);
        System.out.println("codacti--"+codacti);
        System.out.println("desact--"+desact);
        
        /**7777777777777777777777777777777777777777777777777777**/
        String codmonnopreegr=request.getParameter("codmonnopreegr");
        System.out.println("Cod anterior---"+codmonnopreegr);
        
        
        //String saldo = monpre-moneje;
        
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        
        NoPresupues2 pre=new NoPresupues2();
        
        pre.setCodmonnopreegr(codmonnopreegr);
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        pre.setMon_acu(mon_acu);
        
        /*Restamos el montos ingreso ejecutado anterior monto (errado)*/
        orm.ejecutarObjeto("cuentanopresuegr","resta",pre,null);
        
        /* SUMARRRRRRR montos ingreso ejecutado nuevo de referencia*/
        NoPresupues2 pre2=new NoPresupues2();
        
        pre2.setCodmonnopreegr(codmonnopreegr);
        pre2.setCodfueneco(codfueneco);
        pre2.setCodtar(codtar);
        pre2.setMon_acu(mon_acu2);
                
        orm.ejecutarObjeto("cuentanopresuegr","suma",pre2,null);
         
        /*actualiza saldo*/
        //orm.ejecutarObjeto("montosingreso","actualiza_saldo",pre,null);
        
        
        /*Actualizamos a referencia  ref_eje_cuentasnopresu*/
       
        NoPresupues2 u=new NoPresupues2();
        
        u.setCodmonnopreegr(codmonnopreegr);
        u.setCodfueneco(codfueneco);
        u.setCodtar(codtar);
        u.setMon_acu(mon_acu2);
        u.setComprobante(comprobante);
        u.setFecharef(fecharef2);
        u.setObs(obs);
        u.setIdd(idd);
        orm.ejecutarObjeto("cuentanopresuegr","actualiza_ejecutado_ref",u,null);
        
         
        orm.cerrar();//cerrar la conexionjsp
        return new ModelAndView("presupuestos/clasificador/OK", modelo);
    }
}