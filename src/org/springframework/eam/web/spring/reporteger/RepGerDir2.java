 
package org.springframework.eam.web.spring.reporteger;

import org.springframework.eam.web.spring.reportes.*;
import Ajayu_orm.orm_bd;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.carreras;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class RepGerDir2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        String MG[][]= new String[1000][1000];
         String com=request.getParameter("cc");
         System.out.println(" comprometido - "+com);

        String fecha1=request.getParameter("fecha1");
        String fecha2=request.getParameter("fecha2");
        String f1n=request.getParameter("f1n");
        String f2n=request.getParameter("f2n");
        modelo.put("f1n", f1n);
        modelo.put("f2n", f2n);


        String codfueneco=request.getParameter("codfueneco");
        String codtar=request.getParameter("codtar");
        String i_e=request.getParameter("i_e");
        String i_c=request.getParameter("i_c");

         int ji=0;
         String fuen[]  = request.getParameterValues("fuentes");//request.getParameterValues("compro");
        //String [] compro = com.split("::");
         if(fuen!=null)
        {
        //System.out.println("AAAAAAAAAAAAA");
       
        ji=2;
        for(int i = 0 ; i < fuen.length ; i++)
            {
                  
                   String[] h = fuen[i].split("::");
                

                   MG[0][ji]=h[0];//codfueneco
                   MG[0][ji+1]=h[1];//descripcion
                   MG[0][ji+2]=" % Ejc.";
                   MG[1][ji]=" Presupuestado ";
                   MG[1][ji+1]=" Ejecutado ";
                   MG[1][ji+2]=" % ";
                   //System.out.println("entro 1"+MG[0][ji]);
                   //System.out.println("entro 2"+MG[0][ji+1]);
                   //System.out.println("entro 2"+MG[0][ji+2]);
                   //System.out.println(" #numero - "+i);
                   ji=ji+3;

                   //System.out.println(a.substring(0,2)+" /// "+a.substring(3,5)+" /// "+a.substring(6,8));
            }

        }

//System.out.println(" pos en la columna final - "+ji);//esta esperando en la primera posicion vacia uno anter es donde hay datos

int limtarea=2;//
       int jf;
       String tar[]  = request.getParameterValues("tareas");//request.getParameterValues("compro");
      
       if(tar!=null)
        {
       //9 System.out.println("AAAAAAAAAAAAABBBBBBBBBBB");
       
      
        for(int i = 0 ; i < tar.length ; i++)
            {
                  
                   String[] tr = tar[i].split(":");
                   if(i==0){MG[i+1][0]=" Cod. ";MG[i+1][1]=" Descrip.";}
                   MG[i+2][0]=tr[0];//cotar
                   MG[i+2][1]=tr[1];//decripcion

                   //System.out.println("TAREA -   "+MG[i+2][0]);
                   //System.out.println("DESCRIP - "+MG[i+2][1]);
                   limtarea++;
                   //System.out.println(a.substring(0,2)+" /// "+a.substring(3,5)+" /// "+a.substring(6,8));
            }

        }

 String fechanum0=fecha1;//fecha___inicial
String fechanum=fecha2;  //fecha___final
/*mostrando la matriz llena
for(int hg=0;hg<limtarea;hg++){
    for(int jk=0;jk<ji; jk++){
      System.out.print(" "+MG[hg][jk]);
    }
   System.out.println(" --------- ---------- --------- -------");
}
*/

        //fechacom tiene el formato de mes dia año para matener un orde para la comparacion

        
        //String fechanum=anio+mes+dia;


        i_e="0";//--  O ingresos     1 egresos
        i_c="0";

        //fecha  desde inicio de gestion hasta la Fecha
        


        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
      
       
      // String carrera="FISICA";
       //modelo.put("carrera",carrera);

    /*MG[][] desde la fila 1 en la columna 1 y 2 estan las tareas*/
    /*MG[][] en la fila 0 en la columna 3 en adelante estan las fuentes economicas en codigo, descripcion, un campo para el porcentaje de 3 en 3*/
    // recorrido de  System.out.println(" Codigo tarea "+MG[g][1]+" versus fuente economica "+MG[0][u]);
     ProActTar to=new ProActTar();
      String total = new String();
      String total2 = new String();
      ///Vector TA para guardar las fuentes economicas dispònible en la tarea
      String TA[]= new String[1000];
      int tt=0;
      int sw=0;
      int ent=0;
System.out.print(" INICIO  ");
/////////////////CARGANDO LOS INGRESOS PRESUPEUSTADOS SEGUN LA FECHA
/////////////////CARGANDO LOS INGRESOS PRESUPEUSTADOS SEGUN LA FECHA
/////////////////CARGANDO LOS INGRESOS PRESUPEUSTADOS SEGUN LA FECHA
/////////////////CARGANDO LOS INGRESOS PRESUPEUSTADOS SEGUN LA FECHA
/////////////////CARGANDO LOS INGRESOS PRESUPEUSTADOS SEGUN LA FECHA
int cont=0;
double ingt; int jh=0;
double egrt;
double eje_i_e;

for(int g=2;g<limtarea;g++){

       to.setCodtar(MG[g][0]);
       System.out.println("comparando codtar "+MG[g][0]);
       List fuentes_x_tarea=orm.ejecutarLista("fuenteeconomica","fuentes_e_disponibles_en_tarea",to,to);
       if(fuentes_x_tarea!=null)
        {//if_1
           sw=1;tt=0;
            for(int h=0; h< fuentes_x_tarea.size();h++)
            {//for 1
                ProActTar ki=(ProActTar) fuentes_x_tarea.get(h);
                TA[tt]=ki.getCodfueneco();
                //9System.out.println("Vector  --"+TA[tt]);
                tt++;
            }
        }//9System.out.println("ggggg");System.out.println("ggggg");System.out.println("ggggg");
       if(sw==1){
           ent=0; jh=0;
           for(int u=2;u<ji;u=u+3){//for de la matriz con todas las fuentes economicas
                   for(int jj=0;jj<tt;jj++){
                              //9 System.out.print(" se compara Vector  "+TA[jj]+" compara con  "+MG[0][u]);
                                      if(TA[jj].equals(MG[0][u]))
                                      {   jh++;
                                            System.out.println("*************");System.out.println("*************");
                                             ent=1;
                                             ingt=0;egrt=0;
                                            //de la tarea MG[g][1] sacar solo las fuente disponbles
                                            //y luego buscar en los ingrsdos sados iniciales  en el historial de incrementos

                                          //CARGANDO MONTOS DE PRESUPUESTADOS SACANDO DE LOS INGRESOS
                                          to.setI_c(i_e);
                                          to.setFechanum(fechanum);
                                          to.setCodtar(MG[g][0]);
                                          to.setCodfueneco(MG[0][u]);
                                          total=orm.ejecutarObjeto("montosingreso","tot_saldo_i",to, new String());//total de los saldos iniciales en ingresos
                                          System.out.println(" saldo inicial Ingresos ");
                                          System.out.println(" Codigo tarea "+MG[g][0]+" versus fuente economica "+MG[0][u] +"conbirtiendo  -- " +total);

                                          if(total != null) {
                                                    ingt = ingt + new Double(total).doubleValue();
                                                    System.out.println("combertido --" +ingt);
                                            }


                                            to.setI_e(i_e);
                                            to.setFechanum(fechanum);
                                            to.setCodtar(MG[g][0]);
                                            to.setCodfueneco(MG[0][u]);
                                            to.setFechanum0(fechanum0);
                                            total=orm.ejecutarObjeto("repgen","his_incremento",to, new String());//total de los incrementos

                                            if(total != null) {
                                                    ingt = ingt + new Double(total).doubleValue();
                                                    System.out.println("combertido historial incremento"+ingt);
                                            }
       
                                                MG[g][u]=Double.toString(ingt);//CARGANDO EL MONTO DE INGRESOS
                                                System.out.println("ingresando a la matriz ing "+ingt);


                                          //FIN FIN FIN FIN FIN FIN CARGANDO MONTOS DE PRESUPUESTADOS SACANDO DE LOS INGRESOS

                                                System.out.println("__________________"); System.out.println("__________________");
                                                //Cargando las ejecuciones de saldos iniciales sacando los valores de EGRESOS
                                                 to.setI_c(i_e);
                                                 to.setFechanum(fechanum);
                                                 to.setCodtar(MG[g][0]);
                                                 to.setCodfueneco(MG[0][u]);
                                                 total2=orm.ejecutarObjeto("montosegreso","tot_saldo_ej_i",to, new String());//total de los saldos ejecutados iniciales en egreso

                                                 if(total2 != null) {
                                                    egrt = egrt + new Double(total2).doubleValue();
                                                    System.out.println("Saldo ini EGR  "+egrt);
                                                 }
                                                 //cargando las ejecuciones de EGRESOS segun la fecha
                                                 to.setFechanum(fechanum);
                                                 to.setCodtar(MG[g][0]);
                                                 to.setCodfueneco(MG[0][u]);
                                                 to.setFechanum0(fechanum0);
                                                 total2=orm.ejecutarObjeto("montosegreso","tot_egr_ejecutado",to, new String());//total de los saldos ejecutados iniciales en egreso

                                                 if(total2 != null) {
                                                    egrt = egrt + new Double(total2).doubleValue();
                                                    System.out.println("Saldo ini ejecutado EGR  "+egrt);
                                                 }
                                                 //cargando los no presupuestoados (saldos iniciales)  de EGRESOS segun la fecha
                                                 to.setFechanum(fechanum);
                                                 to.setCodtar(MG[g][0]);
                                                 to.setCodfueneco(MG[0][u]);
                                                 total2=orm.ejecutarObjeto("cuentasnopresuegr","tot_saldo_ini",to, new String());//total de los saldos ejecutados iniciales en egreso

                                                 if(total2 != null) {
                                                    egrt = egrt + new Double(total2).doubleValue();
                                                    System.out.println("no presupuestado  "+egrt);
                                                 }
                                               /////cargando los historiales de los no presupuestados de EGRESOS segun la fecha
                                                 to.setFechanum(fechanum);
                                                 to.setCodtar(MG[g][0]);
                                                 to.setCodfueneco(MG[0][u]);
                                                 to.setFechanum0(fechanum0);
                                                 total2=orm.ejecutarObjeto("cuentasnopresuegr","tot_eje_nopresuegr",to, new String());//total de los saldos ejecutados iniciales en egreso

                                                 if(total2 != null) {
                                                    egrt = egrt + new Double(total2).doubleValue();
                                                    System.out.println("no presupuestado ejecutado "+egrt);
                                                 }
                                                 
                                                     /////////////////comprometido///
                                                 if(request.getParameter("cc").equals("si")){
                                                        to.setFechanum(fechanum);
                                                        to.setCodtar(MG[g][0]);
                                                        to.setCodfueneco(MG[0][u]);
                                                         to.setFechanum0(fechanum0);
                                                        total2=orm.ejecutarObjeto("comproegr","tot_refcompro_fe",to, new String());//total de los saldos ejecutados iniciales en egreso

                                                        if(total2 != null) {
                                                            egrt = egrt + new Double(total2).doubleValue();
                                                            System.out.println("comprometido "+egrt);
                                                        }
                                                       }
                                                 /////////////////FIN FIN FIN comprometido///


                                                 //FIN FIN FIN FIN FIN EJECUCIONES EGRESOS
                                                 MG[g][u+1]=Double.toString(egrt);//CARGANDO EL MONTO DE EGRESOS
                                                 

                                                 //cargando el porcentaje de ecucion en la MATRIZ
                                                 eje_i_e=0;

                                                 if(ingt==0){eje_i_e=0;}
                                                 else{eje_i_e=(egrt/ingt)*100;}

                                                 MG[g][u+2]=Double.toString(eje_i_e);

                                                 System.out.println("valor de EGRESOOOS MG  "+MG[g][u+1]);
                                                 System.out.println("valor de EGRESOOOS MG "+MG[g][u+1]);
                                                 
                                                 
                                                 

                                                 System.out.println("Entrando a la matriz en La matriz   -- "+MG[g][u]);
                                                 if(jh==tt){u=ji;}jj=tt;

                                 }//if dentro
  if(ent==0){MG[g][u]="0";MG[g][u+1]="0";MG[g][u+2]="0";}
                   }//for jj

               

           }//for u
       }//if

        cont++;
}

///////////////// FIN FIN FIN FIN FIN FIN FIN FIN CARGANDO LOS INGRESOS PRESUPUESTADOS SEGUN LA FECHA
///////////////// FIN FIN FIN FIN FIN FIN FIN FIN CARGANDO LOS INGRESOS PRESUPUESTADOS SEGUN LA FECHA
///////////////// FIN FIN FIN FIN FIN FIN FIN FIN CARGANDO LOS INGRESOS PRESUPUESTADOS SEGUN LA FECHA
///////////////// FIN FIN FIN FIN FIN FIN FIN FIN CARGANDO LOS INGRESOS PRESUPUESTADOS SEGUN LA FECHA



/////////////////*******************************//////////////////***********************////////////*********
////////////////********************************////////////////*************************////////////*********
////////////////*******************************///////////////////*************************////////////*********


///////////////// CARGANDO LAS EJECUCIONES DE EGRESOS SEGUN LA FECHA





///////////////// FIN FIN FIN FIN FIN CARGANDO LAS EJECUCIONES DE EGRESOS SEGUN LA FECHA





////VER

//modificar null
//ver 4000 de direccion y coordinacion FCPN

double fe;
//mostrando y cereando la matriz en caso de que algun campo sea NULL
for(int g=2;g<limtarea;g++){
     for(int u=2;u<ji;u=u+3){
           if(MG[g][u]==null){MG[g][u]="0";}
           if(MG[g][u+1]==null){MG[g][u+1]="0";}
           if(MG[g][u+2]==null){MG[g][u+2]="0";}
         //9System.out.print(MG[g][u]);
         //9System.out.print(MG[g][u+1]);
         //9System.out.print(MG[g][u+2]);
                 
     }
     //9System.out.println("ss");System.out.println("ss");System.out.println("ss");
}


/*Llenado la descripcion ACTIVIDAD a los codigo de tarea*/
/*(1,0)*/
ProActTar t=new ProActTar();
//Sacando Acyividad Con cod tarea


for(int uy=2;uy<=(limtarea-1);uy++){
    t.setCodtar(MG[uy][0]);
    orm.ejecutarObjeto("gral", "selec", t, t);
    MG[uy][1]=" Tarea "+MG[uy][1] + " "+MG[uy][0] ;
    MG[uy][0]=t.getDescripcion();
    //MG[uy][1]=" Tarea "+MG[uy][0] + " "+MG[uy][1];
}

/* */
modelo.put("M",MG);



modelo.put("filas",(limtarea-1));
modelo.put("columnas",(ji-1));





        orm.cerrar();//cerrar la conexion

        return new ModelAndView("presupuestos3/avance/RepGerDir2", modelo);
        
    }
    
}