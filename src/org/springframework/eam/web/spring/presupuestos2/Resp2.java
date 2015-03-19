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
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;
import org.springframework.eam.domain.inno;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Resp2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codtar=request.getParameter("codtar");
        String codacti=request.getParameter("codacti");
        
        String coddatgen=request.getParameter("coddatgen");
        String poli=request.getParameter("poli");
        String nom=request.getParameter("nom");
        String ap=request.getParameter("ap");
        String am=request.getParameter("am");        
        String email=request.getParameter("email");        
        String telf=request.getParameter("telf");         
        String cel=request.getParameter("cel");      
        String fechai=request.getParameter("fechai");         
        String fechaf=request.getParameter("fechaf");              
        String cargo=request.getParameter("cargo");             
        String cargah=request.getParameter("cargah");        
        String funcion=request.getParameter("funcion");         
        String objetivo=request.getParameter("objetivo");    
         String beneficiarios=request.getParameter("beneficiarios");    
        
        
        
        
        String np="";
        String na="";
        String nee="";
        String nd="";
        


        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        ProActTar gr=new ProActTar();
        ProActTar ta=new ProActTar();
        //GrupoRubro sg=;////direccion y coordinacion
        //gr.setCodsub_ru(codigo);
        gr.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",gr,gr);
        modelo.put("actividad",gr);
        
        ta.setCodtar(codtar);
        //gr.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",ta,ta);
        modelo.put("tarea",ta);
        
        
        
        
        
        gen g=new gen();
        
        g.setCoddatgen(coddatgen);
        g.setNom(nom);
        g.setAp(ap);
        g.setAm(am);
        g.setEmail(email);
        g.setTelf(telf);
        g.setCodtar(codtar);
        g.setCel(cel);
        g.setFechai(fechai);
        g.setFechaf(fechaf);
        g.setCargo(cargo);
        g.setCargah(cargah);
        g.setFuncion(funcion);
        g.setObjetivo(objetivo);
        g.setNa(na);
        g.setNd(nd);
        g.setNee(nee);
        g.setNp(np);
        g.setPoli(poli);
        g.setBeneficiarios(beneficiarios);
        
        orm.ejecutarObjeto("gral","inserta_gral",g,null);
        
        ProActTar taa=new ProActTar();
        taa.setCodtar(codtar);
        List ff = orm.ejecutarLista("gral","codtar",taa,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);
        
       
        
        orm.cerrar();//cerrar la conexion
        
        return new ModelAndView("presupuestos2/generales/Resp2", modelo);
    }
}