
package org.springframework.eam.web.spring.reportes;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ReporteCenBioDet2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String codfueneco=request.getParameter("codfueneco");
        modelo.put("codfueneco",codfueneco);
        String descripcion=request.getParameter("descripcion");
        modelo.put("descripcion",descripcion);
        
        System.out.println("codfueneco----"+codfueneco);
        System.out.println("descripFUENTE----"+descripcion);
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
        
       String carrera="Centro de Estudiantes Biología";
       modelo.put("carrera",carrera);
// int i=0;
       List pat=orm.ejecutarLista("gral","mostrar_pat",null,new Rubro());
        
       carreras car=new carreras();
       car.setIdcarrera("CEBIO");
       List mat=orm.ejecutarLista("carreras","listar_codigos",car,new Rubro());
       
       String V[][]= new String[1000][1000];
       int i=0;
       if(mat!=null)
       {
          for(int j=0;j<mat.size();j++)
          {
             Rubro ki=(Rubro) mat.get(j);
             String tg = ki.getCodtar();
             
               for(int g=0;g<pat.size();g++)
               {
                  Rubro kii=(Rubro) pat.get(g);
                  String th = kii.getCodigo();
                  
                    if(tg.equals(th))
                    {
                        
                        Rubro kiii=(Rubro) pat.get(g-1);
                        String thh = kiii.getCodigo();
                        
                        V[i][0]=kiii.getCodigo();
                        V[i][1]=kiii.getDescripcion();
                        V[i][2]=kiii.getTipo();
                        
                        System.out.print("-un------"+V[i][2]);
                        
                        
                        i++;
                        V[i][0]=kii.getCodigo();
                        V[i][1]=kii.getDescripcion();
                        V[i][2]=kii.getTipo();
                        System.out.print("-dos------"+V[i][2]);
                        i++;
                    }
               }
             
          }
       } 
       else
       {
            modelo.put("pat",pat);
       }
        
       
         for(int uf=0;uf<i;uf++)
           {
              for(int uuf=0;uuf<2;uuf++)
              {
                  System.out.print(V[uf][uuf]+"     ");
           
              }
                  System.out.println(" ");
                  System.out.println(" ");
           }
       
       
       System.out.println("I------>"+i);
       modelo.put("M",V);
       modelo.put("Fcl", Integer.toString(i));
       modelo.put("Ccl","2");
        
        orm.cerrar();//cerrar la conexion
        
        return new ModelAndView("presupuestos3/carreras/MosPatEgrI", modelo);
    }
    
}