
package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.FuenteEconomica;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsAcuCom implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        //llevando fuente economica codigo + descripcion
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        
        //llevando fuente tarea + descripcion
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        System.out.println("DES_Tarea ---- "+codtar);
        
        
        
        //llevando fuente clasificador codigo + descripcion
        String codmonegr=request.getParameter("codmonegr");
        
        
        
        //llevando fuente actividad + descripcion
        String codacti=request.getParameter("codacti");
        modelo.put("codacti",codacti);
        System.out.println("DES_actividad ---- "+codacti);
        
        
        
        
        String[] vec = new String [100];
        //String cod=request.getParameter("codigo");
        String cod=request.getParameter("codigo");
        
        
        
        int j=-1;
        String com[]  = request.getParameterValues("comproref");//request.getParameterValues("compro");
        //String [] compro = com.split("::");
         if(com!=null)
        {
        System.out.println("AAAAAAAAAAAAA ");
        String compro []= new String[150];
        j=0;
        for(int i = 0 ; i < com.length ; i++) 
            {
                   //System.out.println(com[i]);
                   String[] h = com[i].split("::");
                   compro[j]=h[0];
                   compro[j+1]=h[1];
                   compro[j+2]=h[2];
                   
                   j=j+3;
            }
          j=j-3;
         
         for(int g=0; g<=j;g=g+3)
        {
            System.out.println(compro[g]+" "+compro[g+1]+" "+compro[g+2]);
        
        }
        modelo.put("M",compro);
         }
         modelo.put("j",Integer.toString(j));
       
        
        
        
         
         
         
         
         orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        
        
         orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("presupuestos2/comprometido/MosComAcu", modelo);
    }
}