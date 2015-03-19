 
package org.springframework.eam.web.spring.reportes;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ReporteIgob implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
       
        
       String carrera="IDHGOB";
       modelo.put("carrera",carrera);
// int i=0;
       List pat=orm.ejecutarLista("gral","mostrar_pat",null,new Rubro());
        
       carreras car=new carreras();
       car.setIdcarrera("IDHGOB");
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

                        if(kiii.getTipo().equals("1")){
                           V[i][0]=kiii.getCodigo();
                           V[i][1]=kiii.getDescripcion();
                           V[i][2]=kiii.getTipo();
                        }
                        else
                        {
                          V[i][0]=" ";V[i][1]=" ";V[i][2]="5";
                        }
                        System.out.print("-un------"+V[i][2]);
                        if(kiii.getTipo().equals("2")){
                           V[i][0]=kiii.getCodigo();
                           V[i][1]=kiii.getDescripcion();
                           V[i][2]=kiii.getTipo();
                        }
                        else
                        {
                          V[i][0]=" ";V[i][1]=" ";V[i][2]="5";
                        }

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
        
       

       String MT[][]= new String[20][20];
 MosPresuIng sing=new MosPresuIng();
 int cmt=1;
int tfe=0;
  for(int uf=0;uf<i;uf++)
           {
               if(V[uf][2].equals("3"))
                  {
                    MT[cmt][0]=V[uf][0];
                    cmt++;
                  }
           }
/*insertando fuentes economicas */

      List lis_fe_tar=orm.ejecutarLista("fuenteeconomica","mostrar_todo", null, new ProActTar());

      if(lis_fe_tar.size()>0)
               {
                   for(int j=0; j< lis_fe_tar.size();j++)
                   {

                     ProActTar ke=(ProActTar) lis_fe_tar.get(j);
                     MT[0][j+1]=ke.getCodfueneco();
                     tfe++;

                   }
               }

/*Llenando a   los null*/
        for(int uf=0;uf<cmt;uf++)
           {  for (int rf=0;rf<tfe;rf++){
                  if(MT[uf][rf]==null){
                         MT[uf][rf]="a";
                  }
              }
           }


  /*FIN FIN FIN  -------------------Llenando a   los null------*/



/*LLENADO LA MATRIZ DE TOTALES*/
      double totft=0;
      int h;int sw;
      for(int uf=1;uf<cmt;uf++)
           {  for (int rf=1;rf<tfe;rf++){
                     totft=0;
                     sw=0;

                     sing.setCodtar(MT[uf][0]);
                     sing.setCodfueneco(MT[0][rf]);

                     String tt=orm.ejecutarObjeto("montosingreso","tot_ejec_fe",sing,new String());
                     if(tt!=null)
                     {totft= totft + Double.valueOf(tt).doubleValue();sw=1;}

                      tt=orm.ejecutarObjeto("cuentanopresuing","tot_ejec_fe",sing,new String());
                      if(tt!=null)
                      {totft= totft + Double.valueOf(tt).doubleValue();sw=1;}

                      tt=orm.ejecutarObjeto("montosegreso","tot_ejec_fe",sing,new String());
                      if(tt!=null)
                      {totft= totft - Double.valueOf(tt).doubleValue();sw=1;}

                      tt=orm.ejecutarObjeto("cuentasnopresuegr","tot_ejec_fe",sing,new String());
                      if(tt!=null)
                      {totft= totft - Double.valueOf(tt).doubleValue();sw=1;}


                     String com=orm.ejecutarObjeto("comproegr","tot_ejec_fe",sing,new String());
                     if(com!=null)
                      {totft= totft - Double.valueOf(com).doubleValue();sw=1;}

                     if(sw != 0){MT[uf][rf]=Double.toString(totft);}
                     else{MT[uf][rf]="a";}



              }
           }



DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
 for(int uf=0;uf<i;uf++)
 {
   if(V[uf][2].equals("3")){

        for (int rf=1;rf<tfe;rf++){

            if(MT[rf][0]!=null && V[uf][0]!=null && MT[rf][0].equals(V[uf][0])){
              V[uf][4]="";
                for(int hy=1;hy<tfe;hy++){
                      if(!MT[rf][hy].equals("a")){
                       V[uf][4]=V[uf][4]+"  ["+MT[0][hy]+" con saldo de "+df2.format(Double.parseDouble(MT[rf][hy])).toString()+"]";


                    }
                }
            }
        }

   }
 }


       modelo.put("M",V);
       modelo.put("Fcl", Integer.toString(i));
       modelo.put("Ccl","2");
       orm.cerrar();//cerrar la conexion
        
        return new ModelAndView("presupuestos3/carreras/MosPatEgrIng", modelo);
        //return new ModelAndView("presupuestos3/carreras/MosPatEgrIng", modelo);
    }
    
}