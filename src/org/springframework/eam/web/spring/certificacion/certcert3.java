
package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.eam.domain.GrupoRubro;
import org.springframework.eam.domain.classcertificacion;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class certcert3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codmonegr1=request.getParameter("codgru");
        //lik="%"+lik+"%";
        modelo.put("codmonegr1",codmonegr1);
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        System.out.println("CODIGO de TAREA ---------->"+codmonegr1);
     
        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        
        /*sacando */
       classcertificacion tarr=new classcertificacion();
        tarr.setCodtar(codtar);
        tarr.setCodmonegr1(codmonegr1);

        List lista_subgrupos=orm.ejecutarLista("certificacion2", "mostrar_subgrupos", tarr, new classcertificacion());
        modelo.put("lista_subgrupos",lista_subgrupos);


        /*Sacando  todo de la actividad en consultas anidadas */
        GrupoRubro tarr2=new GrupoRubro();
        tarr2.setCodgru(codmonegr1);
        List lista_subgrupo=orm.ejecutarLista("clasificador", "mostrargrupos2", tarr2, new GrupoRubro());
        modelo.put("lista_grupo",lista_subgrupo);
        
        /*FIN FIN FIN FIN */
       

        /*//System.out.println("tamaño lista ------ "+lista_certificado.size());
        
        
        //System.out.println("aquiii "+ lik);

*/
      
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp   
        return new ModelAndView("certificacion/Certcert3", modelo);
    }
}