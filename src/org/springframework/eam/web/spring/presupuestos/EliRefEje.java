
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EliRefEje implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


       
       String codtar= request.getParameter("codtar");
       String codacti= request.getParameter("codacti");
       String codfueneco= request.getParameter("codfueneco");
       String codmoning= request.getParameter("codmoning");
       String monacumulado= request.getParameter("monacumulado");
       String id= request.getParameter("id");

       modelo.put("codtar", codtar);
       modelo.put("codmoning", codmoning);
       modelo.put("codfueneco", codfueneco);
       modelo.put("codacti", codacti);


        String cod="";

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        MosPresuIng mop=new MosPresuIng();
        mop.setCodmoning(codmoning);
        mop.setCodfueneco(codfueneco);
        mop.setCodtar(codtar);
        mop.setId(id);
        mop.setMonacumulado(monacumulado);
        //Restando Ejecucion en tabla Montos Ingresos
        orm.ejecutarObjeto("montosingreso","resta",mop,null);
        orm.ejecutarObjeto("montosingreso","actualiza_saldo",mop,null);
        


        //Eliminando ejecucion ING

        orm.ejecutarObjeto("montosingreso","elimina_ejecutado",mop,null);

        //Mostrando los datos si se borraron o no
        orm.ejecutarObjeto("montosingreso","id",mop,mop);
        modelo.put("moo", mop);


        orm.cerrar();//cerrar la conexion
        
        
        return new ModelAndView("presupuestos/modifica/EliRefEje", modelo);
    }
    
}