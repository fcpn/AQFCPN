
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

public class ModEliGen2_1 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codtar=request.getParameter("codtar");
     

        String codacti=request.getParameter("codacti");
        
        String coddatgen=request.getParameter("coddatgen2");
        String poli=request.getParameter("poli2");
        String nom=request.getParameter("nom2");
        String ap=request.getParameter("ap2");
        String am=request.getParameter("am2");
        String email=request.getParameter("email2");
        String telf=request.getParameter("telf2");
        String cel=request.getParameter("cel2");
        String fechai=request.getParameter("fechai2");
        String fechaf=request.getParameter("fechaf2");
        String cargo=request.getParameter("cargo2");
        String cargah=request.getParameter("cargah2");
        String funcion=request.getParameter("funcion2");
        String objetivo=request.getParameter("objetivo2");
        String beneficiarios=request.getParameter("beneficiarios2");
        
        
        
        
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
        orm.ejecutarObjeto("gral","modifica",g,null);


        ProActTar taa=new ProActTar();
        taa.setCodtar(codtar);
        List ff = orm.ejecutarLista("gral","codtar",taa,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);
        
       
        
        orm.cerrar();//cerrar la conexion
        
        return new ModelAndView("presupuestos2/generales/ModEliGen2_1", modelo);
    }
}