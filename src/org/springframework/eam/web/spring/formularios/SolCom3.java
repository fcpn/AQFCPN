
package org.springframework.eam.web.spring.formularios;

import Ajayu_orm.orm_bd;
import java.util.ArrayList;
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

public class SolCom3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
       
        String codtar=request.getParameter("codtar");
        String fecha=request.getParameter("fecha");
        String num_sol=request.getParameter("num_sol");
        String correlativo_unidad=request.getParameter("correlativo_unidad");
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("fecha", fecha);
        String i_e="3";
        modelo.put("codtar", codtar);
System.out.println("codtar" + codtar);
System.out.println("fecha" + fecha);
System.out.println("num_sol" + num_sol);
System.out.println("correlativo_unidad" + correlativo_unidad);


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
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        List mont=orm.ejecutarLista("formularios","muestra_por_tarea",moscert,new Comprometido());
        modelo.put("lista_cert", mont);
        /*orm.ejecutarObjeto("formularios", "distinto", moscert, moscert);
        modelo.put("dis", moscert);
*/
        String destinov="No";
        String responsable="No";
         List mont_=new ArrayList();
        if(mont != null) {



              for(int i = 0;i< mont.size();i++) {
                Comprometido ki=(Comprometido) mont.get(i);
               destinov = ki.getDestino();
               responsable = ki.getResponsable();
                //ki.setMonacumulado(df2.format(tmpi).toString());

              }

        }

          /*unidades de medida*/

        List u_medida = orm.ejecutarLista("formularios", "listar_unidades_medida", moscert, new Comprometido());
        modelo.put("u_medida", u_medida);

        modelo.put("destinov", destinov);
        modelo.put("responsable", responsable);
        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("formularios/SolCom3", modelo);
    }
}