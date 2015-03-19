
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Rubro;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModEgr implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codfueneco=request.getParameter("codfueneco");
        String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        modelo.put("desfe",desfe);
        
        String codtar=request.getParameter("codtar");
        String moneje=request.getParameter("moneje");
        String codmoning=request.getParameter("codmoning");
        String descla=request.getParameter("descla");
        modelo.put("codmoning",codmoning);
        modelo.put("descla",descla);
        
        String codacti=request.getParameter("codacti");
        
        System.out.println("MOSTRANDOOOOOOOOOOOOO EJEEEEEEEEEE");
        //String codfueneco="TGN";
        System.out.println("fuente---"+codfueneco);
        System.out.println("codtar---"+codtar);
        System.out.println("codacti---"+codacti);
        System.out.println("montoeje---"+moneje);
        System.out.println("codigo de clasificador---"+codmoning);
        //codfueneco="TGN";
        
        
        // codacti = "DC";
        // codtar = "ta1";
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
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
        
        
        /*cacando montos presu eje saldo de un monto ejecutado especifico*/
        MosPresuIng mop=new MosPresuIng();
        //mop.setCodmoning(codmoning);
        mop.setCodmonegr(codmoning);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        orm.ejecutarObjeto("montosegreso","mon_pre_eje_sal",mop,mop);
        modelo.put("montos",mop);
        
        
        /*/sacando comprobante e historial de montos ejecutados*/
        MosPresuIng mopr=new MosPresuIng();
        mopr.setCodmoning(codmoning);
        mopr.setCodfueneco(codfueneco);
        mopr.setCodtar(codtar);
        
        
        /* REFERENCIA de Comprobante*/
        List mont=orm.ejecutarLista("montosegreso","mon_eje_com",mopr,new MosPresuIng());
        modelo.put("montos_ref",mont);
        
        
        /*Sacando Rubros*/
        List sg = orm.ejecutarLista("clasificador","mostrar_partida",null,new Rubro()); //llamano al _orm la consulta
        modelo.put("partida",sg);
        
        /*Sacando fuentes economicas*/
        List fe = orm.ejecutarLista("fuenteeconomica","mostrar_fuenteeconomica",null,new FuenteEconomica()); //llamano al _orm la consulta
        modelo.put("fuente",fe);
        
        
        
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("presupuestos2/modifica/ModEgr", modelo);
    }
}