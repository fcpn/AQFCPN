
package org.springframework.eam.web.spring.presupuestos2;

import org.springframework.eam.web.spring.presupuestos.*;
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

public class ModEjeNoPreClaE implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
  
        /*Datos Anteriores*/
        String codmonnopreegr = request.getParameter("codmonnopreegr");
        String codfueneco = request.getParameter("codfueneco");
        String codtar = request.getParameter("codtar");/*no cambiable*/
        modelo.put("codtar",codtar);
        String codacti = request.getParameter("codacti");
        modelo.put("codacti",codacti);
        String monejenopre = request.getParameter("monejenopre");
        String saldo_ej_i = request.getParameter("saldo_ej_i");
        String i_c ="0";
        String ref123=request.getParameter("ref123");
        /* Datos Anteriores*/

/*Fuente Elegida */
        String codfueneco2=request.getParameter("codfueneco2");
/*Fuente Elegida */
String glosa_s2=request.getParameter("glosa_s2");
String fecha_saldo2=request.getParameter("fecha_saldo2");
String saldo_ej_i2=request.getParameter("saldo_ej_i2");

/*FIN FIN FIN FIN FIN FIN Datos Nuevo a Cambiar*/
      
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        FuenteEconomica fe=new FuenteEconomica();
        
        /*sacando * de la nueva fuente economica*/
        fe.setCodfueneco(codfueneco2);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",fe,fe);
        modelo.put("fuente",fe);
               
        /*Modificando fuentes (codigos)*/
        InsPreIng pre=new InsPreIng();
        pre.setCodmonnopreegr(codmonnopreegr);
        pre.setCodtar(codtar);
        pre.setCodfueneco(codfueneco);
        pre.setRef123(ref123);
        pre.setI_c(i_c);
       /*mostrando anterior*/
        orm.ejecutarObjeto("cuentanopresuegr","saldo_inicial",pre,pre);
        modelo.put("ant", pre);

        /*Restando el valor inicial del saldo*/
        
        pre.setSaldo_ej_i(saldo_ej_i);
        orm.ejecutarObjeto("cuentanopresuegr","resta_s_inicial",pre,pre);

        /*  FIN FIN FINF IN FIN Restando el valor inicial del saldo*/

        /*MODIFICANDO  LOS DATOS */
pre.setGlosa_s2(glosa_s2);
pre.setFecha_saldo2(fecha_saldo2);
pre.setSaldo_ej_i2(saldo_ej_i2);
orm.ejecutarObjeto("cuentanopresuegr","mod_s_ini",pre,pre);

/* FIN FIN FIN FIN MODIFICANDO  LOS DATOS */

/*mostrando los datos modificados*/

orm.ejecutarObjeto("cuentanopresuegr","saldo_inicial",pre,pre);
 modelo.put("ant2", pre);



        orm.cerrar();//cerrar la conexion         ahora vamos a jsp///**/
        return new ModelAndView("presupuestos2/modifica/MuestraModNoPreE", modelo);
    }
}