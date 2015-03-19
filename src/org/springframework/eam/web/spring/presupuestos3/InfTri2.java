

package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.gen;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InfTri2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        
        /*Matriz trimestral*/
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        String descripcion=request.getParameter("descripcion");
        modelo.put("descripcion",descripcion);
        
        System.out.println("Cod tar---"+codtar);
        System.out.println("descri---"+descripcion);
        
        
        
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        DecimalFormat df2 = new DecimalFormat("###,###,###,##0.00");
        
        int Coe=0;
        int fito=0;
        int coto=0;
        /*Sacando Datos generales */
        gen tarr=new gen();
        tarr.setCodtar(codtar);
        
        List ff = orm.ejecutarLista("gral","codtar",tarr,new gen()); //llamano al _orm la consulta
        modelo.put("grl",ff);
        /*FIN FIN FIN Sacando Datos generales */
        
        
        
        
        
        /*Sacando  todo de la actividad en consultas anidadas */
        ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        
        /*FIN FIN FIN FIN */
        
        
        
        
        
        
        
        
        /* Sancando Informes a Ingresos Presupuestados Ejecutados Sados e historial a ejecutados*/
                                                                           
        List acu=orm.ejecutarLista("montosingreso","mostrar_acumulado",null, new MosPresuIng());
        
        /*ALGORITMOOOO*/
        
        String MA[][]= new String[1000][1000];
        
        int f=0;
        int c=0;
        int Ccl=2;
        int Fcl=0;
        
        int swc=0;
        int swfe=0;
        
        String aa;
        
        if(acu!=null) 
        {//if_1
            for(int i=0; i< acu.size();i++)
            {//for 1 
                
                System.out.println("SACANDO de la lista");
                MosPresuIng ki=(MosPresuIng) acu.get(i);
                
                String ds= ki.getI_c();
                
                if(ds.equals("0"))   
                {//if1_2  
                  if(codtar.equals(ki.getCodtar()))
                    {//if_2  
                          System.out.println("Comparando tarea"+ki.getCodtar());
                         if(f==0 && c==0)
                         {//if_3
                             
                            MA[0][0]="-";
                            MA[0][1]="-";
                            MA[0][Ccl]=ki.getCodfueneco();
                            MA[0][Ccl+1]=ki.getDesfe() ;
                            MA[0][Ccl+2]="-";
                            
                            MA[1][0]="Codigo";
                            MA[1][1]="Partida";
                            
                            MA[1][2]="Presuspuestado";
                            MA[1][3]="Ejecutado";
                            MA[1][4]="Saldo";
                            
                            MA[2][0]=ki.getCodmoning();
                            MA[2][1]=ki.getDescla();
                            
                            MA[2][2]=ki.getSaldo_i();
                            MA[2][3]=ki.getSaldo_ej_i();
                            MA[2][4]=ki.getSaldoi();
                            
                            f=1;
                            c=1;
                            Fcl=3;
                            Ccl=5;
                            
                         }//if_3
                         else
                         {//else if_3
                              //Existe el clasificador y la cuenta
                              swc=0;  swfe=0;
                              
                              for(int p=2 ; p<Fcl; p++)
                              {//for2
                                   //System.out.println("VUELTA DOS");
                                   String hh=MA[p][0];
                                   //System.out.println("MAT---"+hh+"----"+ki.getCodmoning());
                                  if( hh.equals(ki.getCodmoning()) )
                                   {//if_4   
                                      System.out.println("Entre");
                                        for(int k=2; k<Ccl; k=k+3)
                                         {//for3                                             
                                              aa=MA[0][k]; 
                                              if(aa.equals(ki.getCodfueneco()) )
                                               {//if_5
                                                   swc=1;
                                                   swfe=1;
                                                   
                                                   MA[p][k]=ki.getSaldo_i();
                                                   MA[p][k+1]=ki.getSaldo_ej_i();
                                                   MA[p][k+2]=ki.getSaldoi();
                                                   
                                                   k=Ccl;
                                                   p=Fcl;
                                                   
                                                }//if_5
                                            }//for3
                                       
                                     }//if_4
                                 
                                 }//for2
                              
                              
                              
                              if(swfe==0)
                              {//if_6
                                   for(int iy=2;iy<Fcl;iy++)
                                   {//for_4
                                       
                                      String fw=MA[iy][0]; 
                                      //System.out.println("Ex Clasi---"+fw+"----"+ki.getCodmoning());
                                      //System.out.println("El Fcl---"+Fcl);
                                      if(fw.equals(ki.getCodmoning())) //Existe clasificador
                                      {//if_7
                                          MA[0][Ccl]=ki.getCodfueneco();
                                          MA[0][Ccl+1]=ki.getDesfe();
                                          MA[0][Ccl+2]="-";
                                          
                                          MA[1][Ccl]="Presupuestado";
                                          MA[1][Ccl+1]="Ejecutado";
                                          MA[1][Ccl+2]="Saldo";
                                          
                                          MA[iy][Ccl]=ki.getSaldo_i();
                                          MA[iy][Ccl+1]=ki.getSaldo_ej_i();
                                          MA[iy][Ccl+2]=ki.getSaldoi();
                                          
                                          Ccl=Ccl+3;
                                          swc=1;
                                          iy=Fcl;
                                          
                                      }//if_7
                                   }//for_4
                              }//if_6
                              
                                ///Existe Fuente Economica no clasificador
                              if(swc==0)
                              {//if_8
                                  
                                  for(int jy=2;jy<Ccl;jy=jy+3)
                                  {//for_5
                                     String qa=MA[0][jy];
                                    if(qa.equals(ki.getCodfueneco()))
                                     {//if_9
                                         MA[Fcl][0]=ki.getCodmoning();
                                         MA[Fcl][1]=ki.getDescla();
                                         
                                         MA[Fcl][jy]=ki.getSaldo_i();
                                         MA[Fcl][jy+1]=ki.getSaldo_ej_i();  
                                         MA[Fcl][jy+2]=ki.getSaldoi();
                                         
                                         Fcl=Fcl+1;
                                         swfe=1;
                                         jy=Ccl;
                                         
                                      }//if_9
                                  
                                   }//for_5
                                  
                                 }//if_8
                              
                              //No existe ninguno de los dos
                              if(swfe==0 && swc==0)
                              {//if_10
                                 MA[0][Ccl]=ki.getCodfueneco();
                                 MA[0][Ccl+1]=ki.getDesfe();
                                 MA[0][Ccl+2]="-";
                                 
                                 MA[1][Ccl]="Presupuestado";
                                 MA[1][Ccl+1]="Ejecutado";
                                 MA[1][Ccl+2]="Saldo";
                                 
                                 MA[Fcl][0]=ki.getCodmoning();
                                 MA[Fcl][1]=ki.getDescla();
                                 
                                 MA[Fcl][Ccl]=ki.getSaldo_i();
                                 MA[Fcl][Ccl+1]=ki.getSaldo_ej_i();
                                 MA[Fcl][Ccl+2]=ki.getSaldoi();
                                 
                                 Fcl=Fcl+1;
                                 Ccl=Ccl+3;
                              }//if_10
                              
                              
                         
                         }//else if_3
                    }//if_2
               
                }//if 1_2
            }//for 1    
            
            
        }//if_1
        
        int ini_f_sal=Fcl;
        
        int ini_c_sal=2;
        int fin_c_sal=Ccl;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*Primer Semestre*/
        int wf=0;
        int wc=0;
        int sww=0;
        
        /*var fecha*/
        String fech;
        String fh;
        String fdc;
        
        int Iccl=Ccl;//inicio de columna para el primer trimestre
        
        String ej;
        double ejj=0;
        
        int inipri=0;
        /*variables para las sumas Beta*/
        String at;
        String incre="0";
        double att;
        
        
        double sumpre=0;
        double sumeje=0;
        
        //en acu ya esta cargada la lista de saldos o nosaldos diferenciado 0,1 en -->i_c
         if(acu != null)
         {//if1
            for(int ui=0; ui<acu.size(); ui++)
            {//for1
                MosPresuIng ki = (MosPresuIng) acu.get(ui);
                String ii=ki.getI_c();
               
              if(codtar.equals(ki.getCodtar()))
              {//if for1 a if2
                 wf=0;
                 wc=0;
                sumpre=0;
                sumeje=0;
                if(ii.equals("1"))   //para saber que no es saldo inicial
                 {//if2
                         fech=ki.getFecha_saldo();
                         fh=fech.substring(3,5);
                         f = Integer.valueOf(fh).intValue();
                         if(f>0 && f<7)
                         {///if3
                               at=ki.getSaldo_i();
                               att= Double.valueOf(at).doubleValue();
                               sumpre=sumpre+att;
                               
                               at=ki.getSaldo_ej_i();
                               att= Double.valueOf(at).doubleValue();
                               sumeje=sumeje+att;
                         }///if3
                 }//if2
              
                
                //Sacando valores de incrementos segun codfueneco, codtar, codmoning
                MosPresuIng mop=new MosPresuIng();
                mop.setCodmoning(ki.getCodmoning());
                mop.setCodfueneco(ki.getCodfueneco());
                mop.setCodtar(ki.getCodtar());
                //0 incrementos en ---> i_e (tabla de h_incrementos)
                mop.setI_e(incre); 
                List Incr=orm.ejecutarLista("incrementos","detallado",mop,new MosPresuIng());
                if(Incr != null)
                   {//if5
                       
                      for(int p=0 ;p<Incr.size();p++)
                       {//for4
                          MosPresuIng kin=(MosPresuIng) Incr.get(p);
                          fech=kin.getFecha();
                          fh=fech.substring(3,5);
                          f = Integer.valueOf(fh).intValue();
                          if(f>0 && f<7)
                            {//if6
                               at=kin.getMonto();
                               att= Double.valueOf(at).doubleValue();
                               sumpre=sumpre+att;                                              
                            }//if6                            
                       }//for4
                       
                    }//if5                                       
                    //FIN FIN FIN FIN FIN Sacando valores de incrementos segun codfueneco, codtar, codmoning
                                
                     //EJECUTADOS EN no presupuestados INGRESOS
                       MosPresuIng moop=new MosPresuIng();
                       moop.setCodmoning(ki.getCodmoning());
                       moop.setCodfueneco(ki.getCodfueneco());
                       moop.setCodtar(ki.getCodtar());
                        List Refin=orm.ejecutarLista("montosingreso","mon_eje_com",moop,new MosPresuIng());
                         //ej = ki.getSaldo_ej_i(); ESTA PARTE ERA PARA SUMAR TODOS LOS EJECUTADOS
                         //ejj= Double.valueOf(ej).doubleValue();
                         //sumeje = sumeje + ejj;
                         if(Refin != null)
                         {//if7
                               for(int p=0;p<Refin.size();p++)
                               {//for5
                                       MosPresuIng ke = (MosPresuIng) Refin.get(p);
                                       fech=ke.getFecha();
                                       fh=fech.substring(3,5);
                                       f = Integer.valueOf(fh).intValue();
                                           if(f>0 && f<7)
                                            {//if7
                                                System.out.println("+++++++++++++++++++++++++++"+ke.getMonacumulado());
                                                at=ke.getMonacumulado();
                                                //att= Double.valueOf(at).doubleValue();
                                                att=Double.valueOf(at).doubleValue();
                                                sumeje=sumeje+att;
                                            }//if7
                                }//for5
                                          
                            }//if7
                
                     //FIN FIN FINN FIN FIN FIN EJECUTADOS EN INGRESOS
                      
                     // aca ya esta almacenado
                     // las sumas de los presupuestados y ejecutados
                     //ahora acomodar el ma matriz MA[][]  
                        //controlar existencias de fuente y clasificador
                                             //hola amor estare con tigo siempre no me dejes: Tati
                    
                 //existe fuente y clasificador     
                    for(int im=2;im<Fcl;im++)
                    {//for
                       String  co=MA[im][0];
                       if(co.equals(ki.getCodmoning()))
                       {//if3
                           for(int cm=Iccl;cm<Ccl;cm=cm+3)
                           {//for3
                                String coo=MA[0][cm];
                               if(coo.equals(ki.getCodfueneco()))
                               {//if4
                                    //nO EXISTE TRASPASO EN INGRESOS  valores de Traspaso  //FIN FIN FIN FIN FIN FIN FIN valores de Traspaso 
                                      
                                      MA[im][cm] = Double.toString(sumpre);
                                      MA[im][cm+1] = Double.toString(sumeje);
                                      MA[im][cm+2] = "a"; // es el saldo que despues se llenara
                                      cm=Ccl;im=Fcl;
                                      wf=1; //switch Fuente
                                      wc=1; //swistch Calsificador
                                      
                                      
                               }//if4
                           }//for3
                       }//if3
                        
                    }//for2
                 //FIN FIN FIN FIN FIN FIN existe fuente y clasificador   
                     
                    
                   //Existe Fuente Economica NO clasificador     
                   if(wc==0)
                    {//if5
                       for(c=Iccl;c<Ccl;c=c+3)
                       {
                           String co=MA[0][c];
                           if(co.equals(ki.getCodfueneco()))
                           {
                             MA[Fcl][0]=ki.getCodmoning();  
                             MA[Fcl][1]=ki.getDescla();
                             
                             MA[Fcl][c]=Double.toString(sumpre);
                             MA[Fcl][c+1]=Double.toString(sumeje);
                             MA[Fcl][c+2]="a";
                             wf=1;
                             Fcl++;
                           }
                       }
                    }//if5
                   //FIN FIN FIN FIN FIN FIN FIN Existe Fuente Economica NO clasificador     
                        
                      //Existe Clasifcador No Fuente economica
                        if(wf==0)
                        {
                          for(f=2;f<Fcl;f++)
                          {
                             String co=MA[f][0];
                             if(co.equals(ki.getCodmoning()))
                             {
                               MA[0][Ccl]=ki.getCodfueneco();
                               MA[0][Ccl+1]=ki.getDesfe();
                               MA[0][Ccl+2]="-";
                               
                               MA[1][Ccl]="Presupuestado";
                               MA[1][Ccl+1]="Ejecutado";
                               MA[1][Ccl+2]="Saldo";
                               
                               MA[f][Ccl]=Double.toString(sumpre);
                               MA[f][Ccl+1]=Double.toString(sumeje);
                               MA[f][Ccl+2]="a";
                               wc=1;
                               Ccl=Ccl+3;
                               
                             }
                          }
                        }
                     //FIN FIN FIN FIN FIN FIN FIN Existe Clasifcador No Fuente economica
                   
                      //No existe Clasificador ni fuente economica
                        
                        if(wf==0 && wc==0)
                        {
                           MA[Fcl][0]=ki.getCodmoning();  
                           MA[Fcl][1]=ki.getDescla();
                           
                           MA[0][Ccl]=ki.getCodfueneco();
                           MA[0][Ccl+1]=ki.getDesfe();
                           MA[0][Ccl+2]="-";
                               
                           MA[1][Ccl]="Presupuestado";
                           MA[1][Ccl+1]="Ejecutado";
                           MA[1][Ccl+2]="Saldo";
                               
                           MA[Fcl][Ccl]=Double.toString(sumpre);
                           MA[Fcl][Ccl+1]=Double.toString(sumeje);
                           MA[Fcl][Ccl+2]="a";
                           Fcl++;
                           Ccl=Ccl+3;
                        }
                        
                      //FIN FIN FIN FIN FIN FIN FIN FIN No existe Clasificador ni fuente economica
                   
              }//if for1 a if2
            }//for1
            
         }//if1
        
        
        
       
        
        
        int ini_c_pri = fin_c_sal;
        int fin_c_pri = Ccl;
        
        
        
  /*FIN FIN FIN FIN FIN Primer Trimestre*/
        
       
        
  /*2222222222222Segundo Trimestre*/    
        /*AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA*/
          /*Segundo Semestre*/
        wf=0;
        wc=0;
        sww=0;
        
        /*var fecha*/
        
        
        
        
        //int Iccl=Ccl;//inicio de columna para el primer trimestre999999999999999999999999999999999999999
        
        
        ejj=0;
        
        inipri=0;
        /*variables para las sumas Beta*/
        
        
        
        
        
        sumpre=0;
        sumeje=0;
        
        //en acu ya esta cargada la lista de saldos o nosaldos diferenciado 0,1 en -->i_c
         if(acu != null)
         {//if1
            for(int ui=0; ui<acu.size(); ui++)
            {//for1
                MosPresuIng ki = (MosPresuIng) acu.get(ui);
                String ii=ki.getI_c();
               
              if(codtar.equals(ki.getCodtar()))
              {//if for1 a if2
                 wf=0;
                 wc=0;
                sumpre=0;
                sumeje=0;
                if(ii.equals("1"))   //para saber que no es saldo inicial
                 {//if2
                         fech=ki.getFecha_saldo();
                         fh=fech.substring(3,5);
                         f = Integer.valueOf(fh).intValue();
                         if(f>6 && f<13)
                         {///if3
                               at=ki.getSaldo_i();
                               att= Double.valueOf(at).doubleValue();
                               sumpre=sumpre+att;
                               
                               at=ki.getSaldo_ej_i();
                               att= Double.valueOf(at).doubleValue();
                               sumeje=sumeje+att;
                         }///if3
                 }//if2
              
                
                //Sacando valores de incrementos segun codfueneco, codtar, codmoning
                MosPresuIng mop=new MosPresuIng();
                mop.setCodmoning(ki.getCodmoning());
                mop.setCodfueneco(ki.getCodfueneco());
                mop.setCodtar(ki.getCodtar());
                //0 incrementos en ---> i_e (tabla de h_incrementos)
                mop.setI_e(incre); 
                List Incr=orm.ejecutarLista("incrementos","detallado",mop,new MosPresuIng());
                if(Incr != null)
                   {//if5
                       
                      for(int p=0 ;p<Incr.size();p++)
                       {//for4
                          MosPresuIng kin=(MosPresuIng) Incr.get(p);
                          fech=kin.getFecha();
                          fh=fech.substring(3,5);
                          f = Integer.valueOf(fh).intValue();
                          if(f>6 && f<13)
                            {//if6
                               at=kin.getMonto();
                               att= Double.valueOf(at).doubleValue();
                               sumpre=sumpre+att;                                              
                            }//if6                            
                       }//for4
                       
                    }//if5                                       
                    //FIN FIN FIN FIN FIN Sacando valores de incrementos segun codfueneco, codtar, codmoning
                                
                     //EJECUTADOS EN no presupuestados INGRESOS
                       MosPresuIng moop=new MosPresuIng();
                       moop.setCodmoning(ki.getCodmoning());
                       moop.setCodfueneco(ki.getCodfueneco());
                       moop.setCodtar(ki.getCodtar());
                        List Refin=orm.ejecutarLista("montosingreso","mon_eje_com",moop,new MosPresuIng());
                         //ej = ki.getSaldo_ej_i(); ESTA PARTE ERA PARA SUMAR TODOS LOS EJECUTADOS
                         //ejj= Double.valueOf(ej).doubleValue();
                         //sumeje = sumeje + ejj;
                         if(Refin != null)
                         {//if7
                               for(int p=0;p<Refin.size();p++)
                               {//for5
                                       MosPresuIng ke = (MosPresuIng) Refin.get(p);
                                       fech=ke.getFecha();
                                       fh=fech.substring(3,5);
                                       f = Integer.valueOf(fh).intValue();
                                           if(f>0 && f<7)
                                            {//if7
                                                System.out.println("+++++++++++++++++++++++++++"+ke.getMonacumulado());
                                                at=ke.getMonacumulado();
                                                //att= Double.valueOf(at).doubleValue();
                                                att=Double.valueOf(at).doubleValue();
                                                sumeje=sumeje+att;
                                            }//if7
                                }//for5
                                          
                            }//if7
                
                     //FIN FIN FINN FIN FIN FIN EJECUTADOS EN INGRESOS
                      
                     // aca ya esta almacenado
                     // las sumas de los presupuestados y ejecutados
                     //ahora acomodar el ma matriz MA[][]  
                        //controlar existencias de fuente y clasificador
                                             //hola amor estare con tigo siempre no me dejes: Tati
                    
                 //existe fuente y clasificador     
                    for(int im=2;im<Fcl;im++)
                    {//for
                       String  co=MA[im][0];
                       if(co.equals(ki.getCodmoning()))
                       {//if3
                           for(int cm=Iccl;cm<Ccl;cm=cm+3)
                           {//for3
                                String coo=MA[0][cm];
                               if(coo.equals(ki.getCodfueneco()))
                               {//if4
                                    //nO EXISTE TRASPASO EN INGRESOS  valores de Traspaso  //FIN FIN FIN FIN FIN FIN FIN valores de Traspaso 
                                      
                                      MA[im][cm] = Double.toString(sumpre);
                                      MA[im][cm+1] = Double.toString(sumeje);
                                      MA[im][cm+2] = "a"; // es el saldo que despues se llenara
                                      cm=Ccl;im=Fcl;
                                      wf=1; //switch Fuente
                                      wc=1; //swistch Calsificador
                                      
                                      
                               }//if4
                           }//for3
                       }//if3
                        
                    }//for2
                 //FIN FIN FIN FIN FIN FIN existe fuente y clasificador   
                     
                    
                   //Existe Fuente Economica NO clasificador     
                   if(wc==0)
                    {//if5
                       for(c=Iccl;c<Ccl;c=c+3)
                       {
                           String co=MA[0][c];
                           if(co.equals(ki.getCodfueneco()))
                           {
                             MA[Fcl][0]=ki.getCodmoning();  
                             MA[Fcl][1]=ki.getDescla();
                             
                             MA[Fcl][c]=Double.toString(sumpre);
                             MA[Fcl][c+1]=Double.toString(sumeje);
                             MA[Fcl][c+2]="a";
                             wf=1;
                             Fcl++;
                           }
                       }
                    }//if5
                   //FIN FIN FIN FIN FIN FIN FIN Existe Fuente Economica NO clasificador     
                        
                      //Existe Clasifcador No Fuente economica
                        if(wf==0)
                        {
                          for(f=2;f<Fcl;f++)
                          {
                             String co=MA[f][0];
                             if(co.equals(ki.getCodmoning()))
                             {
                               MA[0][Ccl]=ki.getCodfueneco();
                               MA[0][Ccl+1]=ki.getDesfe();
                               MA[0][Ccl+2]="-";
                               
                               MA[1][Ccl]="Presupuestado";
                               MA[1][Ccl+1]="Ejecutado";
                               MA[1][Ccl+2]="Saldo";
                               
                               MA[f][Ccl]=Double.toString(sumpre);
                               MA[f][Ccl+1]=Double.toString(sumeje);
                               MA[f][Ccl+2]="a";
                               wc=1;
                               Ccl=Ccl+3;
                               
                             }
                          }
                        }
                     //FIN FIN FIN FIN FIN FIN FIN Existe Clasifcador No Fuente economica
                   
                      //No existe Clasificador ni fuente economica
                        
                        if(wf==0 && wc==0)
                        {
                           MA[Fcl][0]=ki.getCodmoning();  
                           MA[Fcl][1]=ki.getDescla();
                           
                           MA[0][Ccl]=ki.getCodfueneco();
                           MA[0][Ccl+1]=ki.getDesfe();
                           MA[0][Ccl+2]="-";
                               
                           MA[1][Ccl]="Presupuestado";
                           MA[1][Ccl+1]="Ejecutado";
                           MA[1][Ccl+2]="Saldo";
                               
                           MA[Fcl][Ccl]=Double.toString(sumpre);
                           MA[Fcl][Ccl+1]=Double.toString(sumeje);
                           MA[Fcl][Ccl+2]="a";
                           Fcl++;
                           Ccl=Ccl+3;
                        }
                        
                      //FIN FIN FIN FIN FIN FIN FIN FIN No existe Clasificador ni fuente economica
                   
              }//if for1 a if2
            }//for1
            
         }//if1
        
        
        
       
        
        
        int ini_c_seg = fin_c_pri;
        int fin_c_seg = Ccl;
        
        
        
  /*FIN FIN FIN FIN FIN Primer Trimestre*/
       /*AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA*/
  /*22222222222222FIN FIN FIN FIN FIN FIN FIN FIN FIN FIN Segundo Trimestre*/      
        
     
        
        
        
        
        
        
        
        
        
        
        
        
    /***********No presupuestado Saldos, Primer semestre y Segundo Semestre***************NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN**/
         
        
        
        /*No presu ING*/
        
        /*SALDO no presupuestados SALDOs*/
        
        /*Mostrar lo noprespuestados ejecutados SALDOs*/
        List mm=orm.ejecutarLista("cuentanopresuing","mostrar_ejecutados",null, new MosPresuIng());
        
        if(mm!=null) 
        {//if_1
                          
             int Nfcl=Fcl;
             int Nccl=Ccl;
             int sfe=0;
             int scl=0;
             int gh=0;
             
            for(int io=0; io< mm.size();io++)
            {//for 1                 
                System.out.println("SACANDO de la lista");
                MosPresuIng kii=(MosPresuIng) mm.get(io);
                String hf=kii.getI_c();
                if(hf.equals("0"))
               {
                 if(codtar.equals(kii.getCodtar()))
                    {//if_2   
                       sfe=0;
                       scl=0;
                       
                       if(gh==0)
                       {
                            MA[Fcl][0]="Cuentas";
                            MA[Fcl][1]="No Presupuestarias";
                                Fcl++;
                                gh++;
                       }
                       
                          //existe fuente economica y clasificador no presupuestario
                         
                       for(int ic=ini_f_sal; ic<Fcl;ic++)
                          {//for22
                              if(MA[ic][0].equals(kii.getCodmonnopreing()))
                              {//if_3n
                                 for(int kc=ini_c_sal;kc<fin_c_sal;kc=kc+3)
                                 {
                                     if(MA[0][kc].equals(kii.getCodfueneco()))
                                     {    
                                        MA[ic][kc+1]=kii.getSaldo_ej_i();
                                        sfe=1; 
                                        scl=1;
                                        kc=fin_c_sal;
                                        ic=Fcl;
                                     }
                                 }
                              }//if_3n
                            }//for22 
                           ////////////////////////////////////////////////////////////////////
                           //Existe Fuente Economica no exis clasificadorno PRESU
                          if(sfe==0)
                          {//if4n
                             for(int fe=ini_c_sal;fe<fin_c_sal;fe=fe+3)
                             {
                                if(MA[0][fe].equals(kii.getCodfueneco()))
                                {//if5n
                                    MA[Fcl][0]=kii.getCodmonnopreing();
                                    MA[Fcl][1]=kii.getDescla();
                                    
                                    MA[Fcl][fe+1]=kii.getSaldo_ej_i();
                                    
                                    fe=fin_c_sal;
                                    scl=1;
                                    Fcl++;
                                }//if5n
                             }
                          }//if4n
                                              
                     }
                 }
            }//for 1
            
        }//if_1
        
        
        
        /*FIN FIN FIN FIN FIN SALDO no presupuestados SALDOs*/
        
       // int ininopre=top_f_pri;//inicio de los no presupuestados en la matriz
         /* NO PRESUPUESTADOS PRIMER SEMESTRE */
        
        List mmu=orm.ejecutarLista("cuentanopresuing","mostrar_ejecutados",null, new MosPresuIng());
        
        if(mmu!=null) 
        {//if_1
             int Nfcl=Fcl;
             int Nccl=Ccl;
             
             
            for(int io=0; io< mmu.size();io++)
            {//for 1                 
               System.out.println("SACANDO de la lista");
               MosPresuIng kii=(MosPresuIng) mmu.get(io);
            if(codtar.equals(kii.getCodtar()))
            {//if_2     
               wf=0; //switch Fuentt
               wc=0; // switch Clasificador
               sumeje=0;
               
               String hf=kii.getI_c();
               if(hf.equals("1"))
               {
                       fech=kii.getFecha_saldo();
                       fh=fech.substring(3,5);
                       f = Integer.valueOf(fh).intValue();
                       if(f>0 && f<7)
                       {///if3
                               at=kii.getSaldo_ej_i();
                               att= Double.valueOf(at).doubleValue();
                               sumeje=sumeje+att;
                       }///if3
               }
                              
               
            /*Sacando montos ejecutados ejecutados a los no Presupuestados*/
             MosPresuIng mopr=new MosPresuIng();
             mopr.setCodfueneco(kii.getCodfueneco());
             mopr.setCodtar(codtar);
             mopr.setCodmonnopreing(kii.getCodmonnopreing());
       
             List mmn=orm.ejecutarLista("cuentanopresuing","mon_ref",mopr,new MosPresuIng());
             if(mmn != null) 
               {
                  for(int p=0;p<mmn.size();p++)
                  {//for5n
                      MosPresuIng ke = (MosPresuIng) mmn.get(p);
                      fech=ke.getFecharef();
                      fh=fech.substring(3,5);
                      f = Integer.valueOf(fh).intValue();
                      if(f>0 && f<7)
                      {//if8
                          at=ke.getMon_acu();
                          att=Double.valueOf(at).doubleValue();
                          sumeje=sumeje+att;
                      }//if8
                   
                  }//for5n
                  
               }
               /*FIN FIN FIN FIN FIN FIN Sacando montos ejecutados ejecutados a los no Presupuestados*/
               
               //existe fuente y clasificador     
                    for(int im=ini_f_sal;im<Fcl;im++) //empieza la busqueda desde el primer no presupuestado
                    {//for
                       String  co=MA[im][0];
                       if(co.equals(kii.getCodmonnopreing())) 
                       {//if3
                           for(int cm=ini_c_pri;cm<fin_c_pri;cm=cm+3)
                           {//for3
                                String coo=MA[0][cm];
                               if(coo.equals(kii.getCodfueneco()))
                               {//if4
                                    //nO EXISTE TRASPASO EN INGRESOS  valores de Traspaso  //FIN FIN FIN FIN FIN FIN FIN valores de Traspaso 
                                      
                                      MA[im][cm+1] = Double.toString(sumeje);
                                      cm=Ccl;im=Fcl;
                                      cm=fin_c_pri;
                                      im=Fcl;
                                      wf=1; //switch Fuente
                                      wc=1; //swistch Clasificador
                                      
                               }//if4
                           }//for3
                       }//if3
                        
                    }//for2
                   
                 //FIN FIN FIN FIN FIN FIN existe fuente y clasificador      
                   
                //Existe Fuente Economica No clasificador
                if(wc==0)
                   {
                      for(c=ini_c_pri;c<fin_c_pri;c=c+3)
                      {
                          String  co=MA[0][c];
                          if(co.equals(kii.getCodfueneco()))
                          {
                             MA[Fcl][0]=kii.getCodmonnopreing();
                             MA[Fcl][1]=kii.getDescla();
                             
                              MA[Fcl][c+1] = Double.toString(sumeje);
                              c=fin_c_pri;
                              wf=1; //switch Fuente
                              Fcl++;
                          }
                      }
                      
                   }
                 // FIN FIN FIN FIN FIN FIN Existe Fuente Economica No clasificador
             
               //Existe Clasificador No Fuente Economica 
               if(wf==0)
                {
                   for(f=ini_f_sal;f<Fcl;f++)
                      {
                          String  co=MA[f][0];
                          if(co.equals(kii.getCodmonnopreing()))
                          {
                              MA[0][Ccl]=kii.getCodfueneco();
                              MA[0][Ccl+1]=kii.getDesfe();
                              MA[0][Ccl+2]="-";
                              
                              MA[1][Ccl]="Presupuestado";
                              MA[1][Ccl+1]="Ejecutado";
                              MA[1][Ccl+2]="Saldo";
                              
                              MA[f][Ccl+1] = Double.toString(sumeje);
                              f=Fcl;
                              wc=1; //switch Fuente
                              Ccl=Ccl+3;
                              f=Fcl;
                          }
                      }
                }
                 
               if(wc==0 && wf==0)
               {
                  MA[Fcl][0]=kii.getCodmonnopreing();
                  MA[Fcl][1]=kii.getDescla();
                  
                   MA[0][Ccl]=kii.getCodfueneco();
                   MA[0][Ccl+1]=kii.getDesfe();
                   MA[0][Ccl+2]="-";
                              
                   MA[1][Ccl]="Presupuestado";
                   MA[1][Ccl+1]="Ejecutado";
                   MA[1][Ccl+2]="Saldo";
                   
                   MA[Fcl][Ccl+1] = Double.toString(sumeje);
                   
                   Ccl=Ccl+3;
                   Fcl++;
                   
               }
               
             }//if_2
            }//for 1
         }//if_1
        
        
        /*FIN FIN FIN FIN FIN FIN FIN NO PRESUPUESTADOS INGRESOS Primer semestre*/
      /*FIN FOIN FIN FIN FIN nO PRESUPUESTADOS pRIMER sEMESTRE*/
        
        
        
        
        
        
        
        
        
        
        
        /*No presupuestarias SEGUNDO semestre*/
         
        
        List mmus=orm.ejecutarLista("cuentanopresuing","mostrar_ejecutados",null, new MosPresuIng());
        
        if(mmus!=null) 
        {//if_1
             
            for(int io=0; io< mmus.size();io++)
            {//for 1                 
               System.out.println("SACANDO de la lista");
               MosPresuIng kii=(MosPresuIng) mmus.get(io);
            if(codtar.equals(kii.getCodtar()))
            {//if_2     
               wf=0; //switch Fuentt
               wc=0; // switch Clasificador
               sumeje=0;
               
               String hf=kii.getI_c();
               if(hf.equals("1"))
               {
                       fech=kii.getFecha_saldo();
                       fh=fech.substring(3,5);
                       f = Integer.valueOf(fh).intValue();
                       if(f>6 && f<13)
                       {///if3
                               at=kii.getSaldo_ej_i();
                               att= Double.valueOf(at).doubleValue();
                               sumeje=sumeje+att;
                       }///if3
               }
                              
               
            /*Sacando montos ejecutados ejecutados a los no Presupuestados*/
             MosPresuIng mopr=new MosPresuIng();
             mopr.setCodfueneco(kii.getCodfueneco());
             mopr.setCodtar(codtar);
             mopr.setCodmonnopreing(kii.getCodmonnopreing());
       
             List mmns=orm.ejecutarLista("cuentanopresuing","mon_ref",mopr,new MosPresuIng());
             if(mmns != null) 
               {
                  for(int p=0;p<mmns.size();p++)
                  {//for5n
                      MosPresuIng ke = (MosPresuIng) mmns.get(p);
                      fech=ke.getFecharef();
                      fh=fech.substring(3,5);
                      f = Integer.valueOf(fh).intValue();
                      if(f>6 && f<13)
                      {//if8
                          at=ke.getMon_acu();
                          att=Double.valueOf(at).doubleValue();
                          sumeje=sumeje+att;
                      }//if8
                   
                  }//for5n
                  
               }
               /*FIN FIN FIN FIN FIN FIN Sacando montos ejecutados ejecutados a los no Presupuestados*/
               
               //existe fuente y clasificador     
                    for(int im=ini_f_sal;im<Fcl;im++) //empieza la busqueda desde el primer no presupuestado
                    {//for
                       String  co=MA[im][0];
                       if(co.equals(kii.getCodmonnopreing())) 
                       {//if3
                           for(int cm=ini_c_seg;cm<Ccl;cm=cm+3)
                           {//for3
                                String coo=MA[0][cm];
                               if(coo.equals(kii.getCodfueneco()))
                               {//if4
                                    //nO EXISTE TRASPASO EN INGRESOS  valores de Traspaso  //FIN FIN FIN FIN FIN FIN FIN valores de Traspaso 
                                      
                                      MA[im][cm+1] = Double.toString(sumeje);
                                      cm=Ccl;im=Fcl;
                                      cm=fin_c_pri;
                                      im=Fcl;
                                      wf=1; //switch Fuente
                                      wc=1; //swistch Clasificador
                                      
                               }//if4
                           }//for3
                       }//if3
                        
                    }//for2
                   
                 //FIN FIN FIN FIN FIN FIN existe fuente y clasificador      
                   
                //Existe Fuente Economica No clasificador
                if(wc==0)
                   {
                      for(c=ini_c_seg;c<Ccl;c=c+3)
                      {
                          String  co=MA[0][c];
                          if(co.equals(kii.getCodfueneco()))
                          {
                             MA[Fcl][0]=kii.getCodmonnopreing();
                             MA[Fcl][1]=kii.getDescla();
                             
                              MA[Fcl][c+1] = Double.toString(sumeje);
                              c=fin_c_pri;
                              wf=1; //switch Fuente
                              Fcl++;
                          }
                      }
                      
                   }
                 // FIN FIN FIN FIN FIN FIN Existe Fuente Economica No clasificador
             
               //Existe Clasificador No Fuente Economica 
               if(wf==0)
                {
                   for(f=ini_f_sal;f<Fcl;f++)
                      {
                          String  co=MA[f][0];
                          if(co.equals(kii.getCodmonnopreing()))
                          {
                              MA[0][Ccl]=kii.getCodfueneco();
                              MA[0][Ccl+1]=kii.getDesfe();
                              MA[0][Ccl+2]="-";
                              
                              MA[1][Ccl]="Presupuestado";
                              MA[1][Ccl+1]="Ejecutado";
                              MA[1][Ccl+2]="Saldo";
                              
                              MA[f][Ccl+1] = Double.toString(sumeje);
                              f=Fcl;
                              wc=1; //switch Fuente
                              Ccl=Ccl+3;
                             
                          }
                      }
                }
                 
               if(wc==0 && wf==0)
               {
                  MA[Fcl][0]=kii.getCodmonnopreing();
                  MA[Fcl][1]=kii.getDescla();
                  
                   MA[0][Ccl]=kii.getCodfueneco();
                   MA[0][Ccl+1]=kii.getDesfe();
                   MA[0][Ccl+2]="-";
                              
                   MA[1][Ccl]="Presupuestado";
                   MA[1][Ccl+1]="Ejecutado";
                   MA[1][Ccl+2]="Saldo";
                   
                   MA[Fcl][Ccl+1] = Double.toString(sumeje);
                   
                   Ccl=Ccl+3;
                   Fcl++;
                   
               }
               
             }//if_2
            }//for 1
         }//if_1
        
        
        /*FIN FIN FIN FIN FIN FIN FIN NO PRESUPUESTADOS INGRESOS Primer semestre*/
      /*FIN FOIN FIN FIN FIN nO PRESUPUESTADOS pRIMER sEMESTRE*/
        
        
        /*FIN FIN FIN fin No presupuestaria SEGUNDO semestre*/
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
/*EGRESOS MONTOS*/        
        

        
        
/*FIN FIN FIN FIN FIN FIN FIN EGRESOS MONTOS*/        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /* borrado */
        for(int ufs=0;ufs<Fcl;ufs++)
           {
              for(int uuf=0;uuf<Ccl;uuf++)
              {
                  System.out.print(MA[ufs][uuf]+"     ");
           
              }
                  System.out.println(" ");
                  System.out.println(" ");
           }
        
        
        
        System.out.println("codtar ----"+codtar);
        //System.out.println("codmoning"+codmoning);
        orm.cerrar();//cerrar la conexion  ahora vamos a jsp
        return new ModelAndView("presupuestos3/pat/", modelo);
    }
}