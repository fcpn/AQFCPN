
package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.classcertificacion;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class certcert7 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String lik=request.getParameter("lik");
        lik="%"+lik+"%";
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        System.out.println("CODIGO de TAREA ---------->"+codtar);
     
        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        
        /*sacando responsables */
        classcertificacion tarr=new classcertificacion();
        tarr.setLik(lik);
       // tarr.setCodfueneco(codfueneco);
        tarr.setCodtar(codtar);
       
        List lista_certificado=orm.ejecutarLista("certificacion2", "mostrar_like2", tarr, new classcertificacion());
        modelo.put("lista_certificado",lista_certificado);
        
        System.out.println("tamaño lista ------ "+lista_certificado.size());
        
        
        System.out.println("aquiii "+ lik);


      
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("certificacion/Certcert7", modelo);
    }
}