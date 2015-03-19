
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
import org.springframework.eam.domain.Comprometido;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsAcuCom2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
       
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        System.out.println("DES_Tarea ---- "+codtar);
       
        //llevando fuente actividad + descripcion
        String codacti=request.getParameter("codacti");
        modelo.put("codacti",codacti);
        System.out.println("DES_actividad ---- "+codacti);
        
        
        
        
        
        System.out.println("*********************Complemento*********************************************************");
        String comple[] = request.getParameterValues("complemento");
        String compro []= new String[150];
        
        String datos []= new String[450];
        
        int j=0;
        for(int i = 0 ; i < comple.length ; i++) 
            {
                   //System.out.println(com[i]);
                   String[] h = comple[i].split("::");
                   compro[j]=h[0];
                   compro[j+1]=h[1];
                   compro[j+2]=h[2];
                   
                   j=j+3;
            }
          j=j-3;
        
        
        

        String hy [] = request.getParameterValues("moncom");
        String gl [] = request.getParameterValues("glosa");
        String di [] = request.getParameterValues("dia");String me [] = request.getParameterValues("mes");String an [] = request.getParameterValues("anio");
        String ob [] = request.getParameterValues("obs");
       
      
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
  
        
        Comprometido gr=new Comprometido();
        Comprometido gt=new Comprometido();
         int r=0;
        System.out.println("***********************Ingresando Datos*******************************************************");
        for(int g=0; g<hy.length;g++)
        {
            String fecha = di[g]+"/"+me[g]+"/"+an[g];
            System.out.println(compro[r]+" "+compro[r+1]+" "+compro[r+2]+" "+hy[g]+" "+gl[g]+" "+fecha+" "+ob[g]);
            
             
             gr.setCodmonegr(compro[r]);
             gr.setCodfueneco(compro[r+1]);
             gr.setRef123(compro[r+2]);
             gr.setMonto(hy[g]);
             gr.setGlosa(gl[g]);
             gr.setFecha(fecha);
             gr.setObs(ob[g]);
             gr.setCodtar(codtar);
             orm.ejecutarObjeto("comproegr","insertar_ref",gr,null);
             r=r+3;
        }
        
        
        System.out.println("***********************Actualizando el monto total del comprometido*******************************************************");
        int f=0;
        String [][] DatosIns  = new String[450][450];
        r=0;
        int fi=0;
         int co=0;
         for(int g=0; g<hy.length;g++)
        {
            String fecha = di[g]+"/"+me[g]+"/"+an[g];
            System.out.println(compro[r]+" "+compro[r+1]+" "+compro[r+2]+" "+hy[g]+" "+gl[g]+" "+fecha+" "+ob[g]);
            
             
             gr.setCodmonegr(compro[f]);
             gr.setCodfueneco(compro[f+1]);
             gr.setRef123(compro[f+2]);
             gr.setMonto(hy[g]);
             gr.setGlosa(gl[g]);
             gr.setFecha(fecha);
             gr.setObs(ob[g]);
             gr.setCodtar(codtar);
             orm.ejecutarObjeto("comproegr","actualiza_compro",gr,null);
             
             DatosIns[fi][co]=compro[f];
             DatosIns[fi][co+1]=compro[f+1];
             DatosIns[fi][co+2]=hy[g];
             DatosIns[fi][co+3]=gl[g];
             DatosIns[fi][co+4]=fecha;
             DatosIns[fi][co+5]=ob[g];
             fi++;
             f=f+3;
        }
        
        
        
        
        
        
        System.out.println("***********************Mostrando los datos insertados*******************************************************");
        
        fi--;
        //co=co-6;
         for(int uf=0;uf<=fi;uf++)
           {
              for(int uuf=0;uuf<6;uuf++)
              {
                  System.out.print(DatosIns[uf][uuf]+"     ");
           
              }
                  System.out.println(" ");
                  System.out.println(" ");
           }
        modelo.put("M",DatosIns);
        System.out.println("fiiii  "+fi);
        modelo.put("f",Integer.toString(fi));
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/comprometido/MosComIns", modelo);
    }
}