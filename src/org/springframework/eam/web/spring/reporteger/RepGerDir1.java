 
package org.springframework.eam.web.spring.reporteger;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RepGerDir1 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


         //Usuarios usuario = (Usuarios) this.eam.getConexion("d", "d");
        

        String dia1=request.getParameter("dia1");
        String mes1=request.getParameter("mes1");
        String anio1=request.getParameter("anio1");

        String dia2=request.getParameter("dia2");
        String mes2=request.getParameter("mes2");
        String anio2=request.getParameter("anio2");

System.out.println("........111....."+anio1);
System.out.println("........222222....."+anio2);
        /*
            dia="08";
            mes="07";
            anio="09";
        */

        //fechacom tiene el formato de mes dia año para matener un orde para la comparacion
        String fechanum1=anio1+mes1+dia1;
        String fechanum2=anio2+mes2+dia2;
        modelo.put("fecha1",fechanum1);
        modelo.put("fecha2",fechanum2);
        String f1n=dia1+"/"+mes1+"/"+anio1;
        String f2n=dia2+"/"+mes2+"/"+anio2;
        modelo.put("f1n",f1n);
        modelo.put("f2n",f2n);
        

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
      
       String MG[][]= new String[1000][1000];
    
       List tareas=orm.ejecutarLista("tarea","tareas",null,new ProActTar());
       modelo.put("tareas",tareas);
    

      List fuentes=orm.ejecutarLista("fuenteeconomica","mostrar_todo",null,new ProActTar());
      modelo.put("fuentes",fuentes);
    

       orm.cerrar();//cerrar la conexion

        return new ModelAndView("presupuestos3/avance/RepGerDir1", modelo);
        
    }
    
}