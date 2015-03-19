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

public class ModRefEjeE implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String id=request.getParameter("id");
        modelo.put("id",id);
        System.out.println("id--"+id);
        
        
        String codfueneco=request.getParameter("codfueneco");
        String desfe=request.getParameter("desfe");
        modelo.put("codfueneco",codfueneco);
        modelo.put("desfe",desfe);
        
        System.out.println("codfueneco--"+codfueneco);
        System.out.println("desfe--"+desfe);
        
        
        String codtar=request.getParameter("codtar");
        String destar=request.getParameter("destar");
        modelo.put("codtar",codtar);
        modelo.put("destar",destar);
        System.out.println("codtar--"+codtar);
        System.out.println("destar--"+destar);
        
        
        
        String comprobante=request.getParameter("comprobante");
        modelo.put("comprobante",comprobante);
        System.out.println("comprobante--"+comprobante);
        
        
        
        String monacumulado=request.getParameter("monacumulado");
        modelo.put("monacumulado",monacumulado);
        System.out.println("monacumulado--"+monacumulado);
        
        
        
        String observaciones=request.getParameter("observaciones");
        modelo.put("observaciones",observaciones);
        System.out.println("observaciones--"+observaciones);
        
        
        
        
        String fecha=request.getParameter("fecha");
        modelo.put("fecha",fecha);
        System.out.println("fecha--"+fecha);
        
        
        
        String codmonegr=request.getParameter("codmonegr");
        String descla=request.getParameter("descla");
        modelo.put("codmonegr",codmonegr);
        modelo.put("descla",descla);
        System.out.println("codmonegr--"+codmonegr);
        System.out.println("descla--"+descla);
        
        
        
        String codacti=request.getParameter("codacti");
        String desact=request.getParameter("desact");
        modelo.put("codacti",codacti);
        modelo.put("desact",desact);
        System.out.println("codacti--"+codacti);
        System.out.println("desact--"+desact);
        
        
        
        
        
        return new ModelAndView("presupuestos2/modifica/ModRefEjeE", modelo);
    }
}