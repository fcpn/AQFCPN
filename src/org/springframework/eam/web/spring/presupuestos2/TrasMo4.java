
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TrasMo4 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
        String ref1=request.getParameter("ref1");
        modelo.put("ref1",ref1);
        
        String ref2=request.getParameter("ref2");
        modelo.put("ref2",ref2);
        
        String codacti=request.getParameter("codacti");
        modelo.put("codacti",codacti);
        String codtar=request.getParameter("codtar");
        modelo.put("codtar", codtar);

        
        String codmoning=request.getParameter("codmoning");
        String descla=request.getParameter("descla");
        modelo.put("codmoning",codmoning);
        modelo.put("descla",descla);
        
        
        String codfueneco=request.getParameter("codfueneco");
        //String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        //modelo.put("desfe",desfe);
        
        
        String monto=request.getParameter("monto");
        modelo.put("monto",monto);
        
        
        /*2 para cambiar*/
        String codmoning2=request.getParameter("codmoning2");
        String descla2=request.getParameter("descla2");
        modelo.put("codmoning2",codmoning2);
        modelo.put("descla2",descla2);
        
        
        String codfueneco2=request.getParameter("codfueneco2");
        //String desfe2=request.getParameter("desfe2");
        modelo.put("codfueneco2",codfueneco2);
        //modelo.put("desfe2",desfe2);
        
        
        String monto2=request.getParameter("monto2");
        modelo.put("monto2",monto2);
        
        
        
        
        
        // codacti = "DC";
        // codtar = "ta1";
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
        
        /*sacndo descipcion de fuente economica*/
        ProActTar cd=new ProActTar();
        cd.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",cd,cd);
        modelo.put("des",cd);
        
        
        ProActTar cd1=new ProActTar();
        cd1.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",cd1,cd1);
        modelo.put("des2",cd1);
        
        /*Sacando Datos generales */
        gen tarr=new gen();
        tarr.setCodtar(codtar);
                
        
        List ff = orm.ejecutarLista("gral","codtar",tarr,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);
        /*FIN FIN FIN Sacando Datos generales */
        
     
        orm.cerrar();//cerrar la conexion ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
       
        return new ModelAndView("presupuestos2/traspaso/TrasMo4", modelo);
    }
}