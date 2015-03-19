 
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.gen;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModEliGen implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
       
        
       List pat=orm.ejecutarLista("gral","listado",null,new gen());
      
        modelo.put("pat",pat);
        

        /*
           DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        List mon=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",null, new MosPresuIng());


        List mon_=new ArrayList();
        if(mon != null) {

            for(int i = 0;i< mon.size();i++) {
                MosPresuIng ki=(MosPresuIng) mon.get(i);

                float tmpi = new Float(ki.getMonto()).floatValue();
                ki.setMonto(df2.format(tmpi).toString());

                float tmpi2 = new Float(ki.getMoneje()).floatValue();
                ki.setMoneje(df2.format(tmpi2).toString());

                float tmpi3 = new Float(ki.getSaldo()).floatValue();
                ki.setSaldo(df2.format(tmpi3).toString());
                mon_.add(ki);
            }



            modelo.put("mosmoneje",mon_);
        } else {

            modelo.put("mosmoneje",mon);

        }




         */



        orm.cerrar();//cerrar la conexion
        
        return new ModelAndView("presupuestos2/generales/ModEliGen", modelo);
    }
    
}