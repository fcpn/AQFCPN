 
package org.springframework.eam.web.spring.reporteger;

import org.springframework.eam.web.spring.reportes.*;
import Ajayu_orm.orm_bd;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.eam.web.spring.calendario.Calendario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RepGerDir0 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        Calendario calendario = new Calendario();
        String me = calendario.getMonth();
        String di = Integer.toString(calendario.getDayOfMonth());
        String an = Integer.toString(calendario.getYear());
        String hora = Integer.toString(calendario.getHour());
        String minuto=Integer.toString(calendario.getMinute());

        if(calendario.getMinute()<10){minuto="0"+minuto;}
        if(calendario.getDayOfMonth()<10){di="0"+di;}
        String horas = hora+":"+minuto;

        String desdia=calendario.getDay();
        String dmes=Integer.toString(calendario.getMonthInt());


        String fecha2 = desdia+" "+di+" de "+me+" de "+an;
        String fecha=di+" de "+me+" de "+an;

        if(calendario.getMonthInt()<10){dmes="0"+dmes;}


        System.out.println("dia ******   "+di);
        System.out.println("mes ******   "+me);
        System.out.println("año ******   "+an.substring(2, 4));
        String fechacom=di+"/"+dmes+"/"+an.substring(2, 4);
        System.out.println("Fecha para el comprometido   "+ fechacom);
        modelo.put("fecha", fechacom);


        modelo.put("di",di);
        modelo.put("me",me);
        modelo.put("an",an.substring(2, 4));
        modelo.put("ani",an);


        return new ModelAndView("repgerencial/RepGerDir0", modelo);
        
    }
    
}