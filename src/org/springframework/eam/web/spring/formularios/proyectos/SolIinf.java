 
package org.springframework.eam.web.spring.formularios.proyectos;

import org.springframework.eam.web.spring.reportes.*;
import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolIinf implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String MT[][]= new String[20][20];

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        
       
        
       String carrera="";
       modelo.put("carrera",carrera);

       List pat=orm.ejecutarLista("gral","mostrar_pat",null,new Rubro());
        
       carreras car=new carreras();
       car.setIdcarrera("INS_INFORMATICA");
       List mat=orm.ejecutarLista("carreras","listar_codigos",car,new Rubro());
       MosPresuIng sing=new MosPresuIng();
       String ctr="";
       ProActTar fuen=new ProActTar();
    
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
                           V[i][3]="1";
                        }
                        else
                        {
                          V[i][0]=" ";V[i][1]=" ";V[i][2]="5";
                        }
                        System.out.print("-un------"+V[i][2]);
                        if(kiii.getTipo().equals("2")){
                            //Sumatoria ACTIVIDAD
                           V[i][0]=kiii.getCodigo();
                           V[i][1]=kiii.getDescripcion();
                           V[i][2]=kiii.getTipo();
                           V[i][3]="2";
                        }
                        else
                        {
                          V[i][0]=" ";V[i][1]=" ";V[i][2]="5";
                        }
                        
                        i++;
                        //Tareas por tareita
                        V[i][0]=kii.getCodigo();
                        V[i][1]=kii.getDescripcion();
                        V[i][2]=kii.getTipo();
                        V[i][3]="3";
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
        
       /*
         for(int uf=0;uf<i;uf++)
           {
              for(int uuf=0;uuf<2;uuf++)
              {
                  System.out.print(V[uf][uuf]+"   ");
           
              }
                  System.out.println(" ");
                  System.out.println(" ");
           }
       
       */






       /*Montos totales
       for(int ii=0; ii< mat.size();ii++)
            {
              MosPresuIng ki=(MosPresuIng) mat.get(ii);
              ctr=ki.getCodtar();
              fuen.setCodtar(ctr);
              List lis_fe_tar=orm.ejecutarLista("fuenteeconomica","fuentes_e_disponibles_en_tarea", fuen, new ProActTar());
                if(lis_fe_tar.size()>0)
               {
                   for(int j=0; j< lis_fe_tar.size();j++)
                   {

                     ProActTar ke=(ProActTar) lis_fe_tar.get(j);
                     FE[j][j]=ke.getCodfueneco();

                   }
               }


*/







/*

                     sing.setCodtar(mat);
                     sing.setCodfueneco(MSC[0][f]);

                     String tt=orm.ejecutarObjeto("montosingreso","tot_ejec_fe",sing,new String());
                     if(tt!=null)
                     {MSC[1][f]=tt;}else{MSC[1][f]="0";}

                      tt=orm.ejecutarObjeto("cuentanopresuing","tot_ejec_fe",sing,new String());
                      if(tt!=null)
                      {MSC[2][f]=tt;}else{MSC[2][f]="0";}

                      tt=orm.ejecutarObjeto("montosegreso","tot_ejec_fe",sing,new String());
                      if(tt!=null)
                      {MSC[3][f]=tt;}else{MSC[3][f]="0";}


                      tt=orm.ejecutarObjeto("cuentasnopresuegr","tot_ejec_fe",sing,new String());
                      if(tt!=null)
                      {MSC[4][f]=tt;}else{MSC[4][f]="0";}

                     orm.ejecutarObjeto("fuenteeconomica","codfueneco",sing,sing);
                     if(sing!=null)
                     {MSC[5][f]=sing.getDescripcion();}
                     com=orm.ejecutarObjeto("comproegr","tot_ejec_fe",sing,new String());
                     if(com!=null)
                     {MSC[7][f]=com;}else{MSC[7][f]="0";}

       }
*/

/*uf       columna cero     puro codigos*/
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
              /*
              ctr=ki.getCodtar();
              fuen.setCodtar(ctr);
              List lis_fe_tar=orm.ejecutarLista("fuenteeconomica","fuentes_e_disponibles_en_tarea", fuen, new ProActTar());
                if(lis_fe_tar.size()>0)
               {
                   for(int j=0; j< lis_fe_tar.size();j++)
                   {

                     ProActTar ke=(ProActTar) lis_fe_tar.get(j);
                     FE[j][j]=ke.getCodfueneco();

                   }
               }


                /*---------*/
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
     //  System.out.println("xs-----------------------------------------" + V[uf][2] + "  0"+V[uf][0]);
        for (int rf=1;rf<tfe;rf++){
       //     System.out.println("En V 0 "+V[uf][0]);
       //     System.out.println("En MT 0 "+MT[rf][0]);
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
 

/*
      for(int uf=0;uf<cmt;uf++)
           {

              for (int rf=0;rf<tfe;rf++){
                System.out.print(""+MT[uf][rf]);
              }

                System.out.println(" - ");
                System.out.println(" - ");

           }


      

      for(int uf=0;uf<i;uf++)
           {
              for(int uuf=0;uuf<3;uuf++)
              {
                  System.out.print(V[uf][uuf]+"   ");
              }
                  System.out.println(" -- ");
                  System.out.println(" -- ");

           }
*/
       modelo.put("M",V);
       modelo.put("Fcl", Integer.toString(i));
       modelo.put("Ccl","2");


        return new ModelAndView("presupuestos3/formularios/MosPatEIF", modelo);
        //return new ModelAndView("presupuestos3/carreras/MosPatEgrIng", modelo);
    }
}