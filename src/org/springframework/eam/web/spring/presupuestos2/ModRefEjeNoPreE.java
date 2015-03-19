/* Programa:    MenuControlador
 * Descripcion: Establece el menu correspondiente al rol
 * Autor:       _ston Castillo Valencia, _ - UMSA
 * Fecha:       26-10-2007
 * Modificado:  Lizeth Amalia Gutierrez Loza, IICCA
 * Fecha
 */
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Rubro;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModRefEjeNoPreE implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codfueneco=request.getParameter("codfueneco");
        //String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        //modelo.put("desfe",desfe);
        
        System.out.println("codfueneco--"+codfueneco);
        //System.out.println("desfe--"+desfe);
        
        
        String idd=request.getParameter("idd");
        modelo.put("idd",idd);
        System.out.println("IDD no PRE *******"+idd);
        
        
        String codtar=request.getParameter("codtar");
        String destar=request.getParameter("destar");
        modelo.put("codtar",codtar);
        modelo.put("destar",destar);
        System.out.println("codtar--"+codtar);
        System.out.println("destar--"+destar);
        
        
        
        String comprobante=request.getParameter("comprobante");
        modelo.put("comprobante",comprobante);
        System.out.println("comprobante--"+comprobante);
        
        
        
        String mon_acu=request.getParameter("monacumulado");
        modelo.put("mon_acu",mon_acu);
        System.out.println("monacumulado--"+mon_acu);
        
        
        
        String obs=request.getParameter("observaciones");
        modelo.put("obs",obs);
        System.out.println("obs--"+obs);
        
        
        
        
        String fecharef=request.getParameter("fecha");
        modelo.put("fecharef",fecharef);
        System.out.println("fecharef--"+fecharef);
        
        
        
        String codmonnopreegr=request.getParameter("codmonnopreegr");
        String descla=request.getParameter("descla");
        modelo.put("codmonnopreegr",codmonnopreegr);
        modelo.put("descla",descla);
        System.out.println("codmonnopreegr--"+codmonnopreegr);
        System.out.println("descla--"+descla);
        
        
        String codacti=request.getParameter("codacti");
        String desact=request.getParameter("desact");
        modelo.put("codacti",codacti);
        modelo.put("desact",desact);
        System.out.println("codacti--"+codacti);
        System.out.println("desact--"+desact);
        
        return new ModelAndView("presupuestos2/modifica/ModRefEjeNoPreE", modelo);
    }
}