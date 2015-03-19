
package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.classcertificacion;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.web.spring.calendario.Calendario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class certcert9 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
      
        String codtar=request.getParameter("codtar");
        modelo.put("codtar", codtar);
      
     
             
        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

  

        classcertificacion regtem=new classcertificacion();
        regtem.setCodtar(codtar);
      
     
       orm.ejecutarObjeto("certificacion","borrar",regtem,null);//borrando el temporal de las certificaciones

        orm.cerrar();//cerrar la conexion         ahora vamos a jsp 


/**/  // return new ModelAndView("certificacion/Cert5", modelo);
        return new ModelAndView("", modelo);
    }
}