
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

public class ModMonCompro3 implements Controller {
    
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
                   compro[j+3]=h[3];
                   j=j+4;
            }
          j=j-4;
        
        
       
          
          
          
          
          
          
          
          
          
          
          
          
        /*nuevos datos para insertar y validar comprometido*/
        String cod [] = request.getParameterValues("codigo");
        String codfe [] = request.getParameterValues("codfueneco");
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
        System.out.println("***********************eliminando el comprometido*******************************************************");
        for(int g=0; g<comple.length;g++)
        {
            
             
             gr.setCodmonegr(compro[r]);//codmonegr
             gr.setCodfueneco(compro[r+1]);//cod fuente
             gr.setMonto(compro[r+2]);//monto
             gr.setId(compro[r+3]);//id
             gr.setCodtar(codtar);
             

             System.out.println("codmonegr ANTI  "+compro[r]+"  codfuenecoANTI  "+compro[r+1]+" MontoAnti  "+compro[r+2]+"    Id Anti  "+compro[r+3]);

             orm.ejecutarObjeto("comproegr","eliminar_acumulado_ref",gr,null);
             
             ///Restar
             orm.ejecutarObjeto("comproegr","restar_monto",gr,null);
             r=r+3;
        }
        
        
        
        
        
        /*adicionando comprometido*/
        
        
        
        r=0;
        System.out.println("***********************Ingresando Datos*******************************************************");
        for(int g=0; g<hy.length;g++)
        {
            String fecha = di[g]+"/"+me[g]+"/"+an[g];
            
            String[] h = cod[g].split("::");
            //compro[j]=h[0];
             
             gr.setCodmonegr(h[1]);
             gr.setCodfueneco(codfe[g]);
             gr.setRef123(h[0]);
             gr.setMonto(hy[g]);
             gr.setGlosa(gl[g]);
             gr.setFecha(fecha);
             gr.setObs(ob[g]);
             gr.setCodtar(codtar);
             
            System.out.println("codmonegr new  "+h[1]+"  codfueneco new  "+codfe[g]+" Monto new  "+hy[g]+"    codtar  "+codtar);
 

            orm.ejecutarObjeto("comproegr","insertar_compro",gr,null);
             
            orm.ejecutarObjeto("comproegr","insertar_ref",gr,null);
             
            orm.ejecutarObjeto("comproegr","actualiza_compro",gr,null);
             r=r+3;
        }
//////////////////////////////////////Fin Adicion Comprometido        

       // System.out.println("***********************Si es Cero el monto total de comprometido borrarlo*******************************************************");
        r=0;
         for(int g=0; g<comple.length;g++)
        {
            
             //System.out.println(compro[r]+" "+compro[r+1]+" "+compro[r+2]);
             gr.setCodmonegr(compro[r]);//codmonegr
             gr.setCodfueneco(compro[r+1]);//cod fuente
             gr.setId(compro[r+2]);//id
             gr.setCodtar(codtar);
             orm.ejecutarObjeto("comproegr","eliminar_monto_cero",gr,null);
             r=r+3;
        }
        
        
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/comprometido/ModMonCompro3", modelo);
    }
}