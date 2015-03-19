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
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.InsPreIng;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModIng2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String codmoning=request.getParameter("codmoning");
        System.out.println("Cod anterior---"+codmoning);
        
        String cod=request.getParameter("codigo");
        String[] h = cod.split("::");
        String ref123=h[0];
        String codmoning2=h[1];
        String descla=h[2];
        modelo.put("descla",descla);
        modelo.put("codmoning2",codmoning2);
        System.out.println("Cod Actual--"+codmoning2);
        
        String codfueneco=request.getParameter("codfueneco");
        System.out.println("Fuente Anterior--"+codfueneco);
        
        String codfueneco2=request.getParameter("codfueneco2");
        System.out.println("Fuente New---"+codfueneco2);
        
        
        
        String montopresu=request.getParameter("monpre");
        modelo.put("monpre",montopresu);
        String montoeje=request.getParameter("moneje");
        modelo.put("moneje",montoeje); 
        
        //String saldo = monpre-moneje;
        
        String codacti=request.getParameter("codacti");
        String desact=request.getParameter("desact");
        modelo.put("desact",desact);
        
        String codtar=request.getParameter("codtar");
        String destar=request.getParameter("desact");
        modelo.put("destar",destar);
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        FuenteEconomica fe=new FuenteEconomica();
        
        fe.setCodfueneco(codfueneco2);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",fe,fe);
        modelo.put("fuente",fe);
        
        
        
        
        InsPreIng pre=new InsPreIng();
        pre.setCodmoning(codmoning);
        pre.setMontoeje(montoeje);
        pre.setMontopresu(montopresu);
        pre.setRef123(ref123); 
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        pre.setCodmoning2(codmoning2);
        pre.setCodfueneco2(codfueneco2);
        /*Actualizando con nuevos datos*/
        orm.ejecutarObjeto("montosingreso","modifica",pre,null);
        
        /*actualiza saldo*/
        orm.ejecutarObjeto("montosingreso","actualiza_saldo",pre,null);
            
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos/modifica/MuestraMod", modelo);
    }
}