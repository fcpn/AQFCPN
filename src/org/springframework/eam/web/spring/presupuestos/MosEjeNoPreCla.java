
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.NoPresupues;
import org.springframework.eam.domain.NoPresupues2;
import org.springframework.eam.domain.inno;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MosEjeNoPreCla implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codfueneco=request.getParameter("codfueneco");//ooooooo---------------
        modelo.put("codfueneco",codfueneco);
        String monejenopre=request.getParameter("monejenopre");//ooooooo---------------
        modelo.put("monejenopre",monejenopre);
        String ref123=request.getParameter("ref123");//ooooooo---------------
        modelo.put("ref123",ref123);
        String codtar=request.getParameter("codtar");//ooooooo---------------
        String destar=request.getParameter("destar");//ooooooo---------------
        modelo.put("codtar",codtar);
        modelo.put("destar",destar);
        String codmonnopreing=request.getParameter("codmonnopreing");//ooooooo---------------
        String descla=request.getParameter("descla");//ooooooo---------------
        modelo.put("codmonnopreing",codmonnopreing);
        modelo.put("descla",descla);
        String codacti=request.getParameter("codacti");//ooooooo---------------
        String desact=request.getParameter("desact");//ooooooo---------------
        modelo.put("codacti",codacti);
        modelo.put("desact",desact);
        


        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
        /*Sacando Detalles*/
        NoPresupues sg= new NoPresupues();
        sg.setCod_snp(codmonnopreing);
        System.out.println("cod   "+codmonnopreing);
      
        orm.ejecutarObjeto("clasificador","gruponp",sg,sg); //llamano al _orm la consulta
        modelo.put("npreing",sg);
        
        /*Sacando fuentes economicas*/
        FuenteEconomica f=new FuenteEconomica();
        f.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica", "codfueneco", f, f);
        modelo.put("f",f);


        NoPresupues2 pre2=new NoPresupues2();

        pre2.setCodmonnopreing(codmonnopreing);
        pre2.setCodfueneco(codfueneco);
        pre2.setCodtar(codtar);

        orm.ejecutarObjeto("cuentanopresuing", "saldo_inicial", pre2, pre2);
        modelo.put("rnopreing", pre2);
        
        //en la consulta ya esta predeterminado i_c=0;
        
        orm.cerrar();
        
        
        
        return new ModelAndView("presupuestos/modifica/MosEjeNoPreCla", modelo);
    }
}