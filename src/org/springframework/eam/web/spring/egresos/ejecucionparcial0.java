
package org.springframework.eam.web.spring.egresos;

import org.springframework.eam.web.spring.presupuestos3.*;
import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ejecucionparcial0 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        String fecha=request.getParameter("fecha");
        String num_sol=request.getParameter("num_sol");
        String codmonegr=request.getParameter("codmonegr");
        String codfueneco=request.getParameter("codfueneco");
        String monto=request.getParameter("monto");
        String id=request.getParameter("id");
        modelo.put("id", id);
        modelo.put("num_sol", num_sol);
        modelo.put("fecha", fecha);
        modelo.put("codtar", codtar);
        modelo.put("codacti", codacti);
        String i_e="3";
        


        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        /*Sacando la actividad*/
        
        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
       
        /*Sacando la tarea*/
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        

        /*Listado de los correlativos de las certificaciones en proceso*/
        Comprometido moscert=new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setId(id);
        moscert.setMonto(monto);
        moscert.setCodfueneco(codfueneco);
        moscert.setNum_sol(num_sol);
        moscert.setI_e(i_e);
        orm.ejecutarObjeto("compro_certificacion","modificar_valores",moscert,moscert);
        modelo.put("lis_cert", moscert);


        orm.cerrar();//cerrar la conexion    ahora vamos a jsp
        
        return new ModelAndView("presupuestos2/egresos/ejecucionparcial0", modelo);
    }
}