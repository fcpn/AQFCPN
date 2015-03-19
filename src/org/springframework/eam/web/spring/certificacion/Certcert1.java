
package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.gen;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.web.spring.calendario.Calendario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Certcert1 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        String destar=request.getParameter("descripcion");
        modelo.put("destar",destar);
        
        System.out.println("Cod tar---"+codtar);
        System.out.println("descri---"+destar);
        
       
 
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
      //  DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        
        
        /*Sacando Datos generales */
        gen tarr=new gen();
        tarr.setCodtar(codtar);
        
        List ff = orm.ejecutarLista("gral","codtar",tarr,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);
        /*FIN FIN FIN Sacando Datos generales */
        
        
        
        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        String codacti=tare.getCodacti();
        /*FIN FIN FIN FIN */

        /*Sacando  todo de la actividad en consultas anidadas */
    
        ProActTar descrip=new ProActTar();
        //descripcion de la carrera para la certificacion
        descrip.setCodtar(codtar);
        descrip.setCodacti(codacti);
        
        orm.ejecutarObjeto("codigostareaactividad","descripcion",descrip,descrip);
        modelo.put("descripCarrera",descrip);
        /*FIN FIN FIN FIN */
     
        /*Sacando la tarea*/
           ProActTar tarw=new ProActTar();
           tarw.setCodtar(codtar);
           orm.ejecutarObjeto("proacttar","codtar",tarw,tarw);
           modelo.put("tarea",tarw);
           String n_cor=tarw.getCorrelativo();
           int f;
           f=Integer.valueOf(n_cor).intValue() + 1;
           //f=Double.valueOf(n_cor).doubleValue() + 1;
           modelo.put("coo", Integer.toString(f));



           /*Fecha*/

        Calendario calendario = new Calendario();
        String me = calendario.getMonth();
        String di = Integer.toString(calendario.getDayOfMonth());
        String an = Integer.toString(calendario.getYear());
        String hora = Integer.toString(calendario.getHour());
        String minuto=Integer.toString(calendario.getMinute());
        int mmi=calendario.getMinute();
        if(mmi<10){minuto="0"+minuto;}
        String horas = hora+":"+minuto;
        String fecha = di+" de "+me+" de "+an;

        String fech_hora= fecha+" Hrs. "+horas;

        modelo.put("fech_hora",fech_hora);
        






        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("certificacion/certcert1", modelo);
    }
}