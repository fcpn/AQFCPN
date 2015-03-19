
package org.springframework.eam.web.spring.formularios;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolCom7_1 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String lik=request.getParameter("lik");
        lik=lik+"%";
        


        
        System.out.println("likkk   :: "+lik);


        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
  
        Comprometido moscert=new Comprometido();
        /*sacando responsables */
        moscert.setLik(lik);
        List lista_proveedor=orm.ejecutarLista("formularios", "buscar_proveedor", moscert, new Comprometido());
        
         modelo.put("lista_proveedor",lista_proveedor);
  
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp    certificacion/Certcert7
        return new ModelAndView("formularios/SolCom7_1", modelo);
    }
}