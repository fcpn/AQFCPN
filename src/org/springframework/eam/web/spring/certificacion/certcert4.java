
package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.GrupoRubro;
import org.springframework.eam.domain.classcertificacion;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class certcert4 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codmonegr2=request.getParameter("codsub");
        modelo.put("codmonegr2",codmonegr2);
        String codmonegr1=request.getParameter("codgru");
        modelo.put("codmonegr1",codmonegr1);
        //lik="%"+lik+"%";
        String codtar=request.getParameter("codtar");
        modelo.put("codtar",codtar);
        System.out.println("CODIGO de codigoparti ---------->"+codmonegr2);
     
        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        DecimalFormat df2 = new DecimalFormat("#,###,###,##0.00");
        /*sacando responsables */
        classcertificacion tarr=new classcertificacion();
        tarr.setCodtar(codtar);
        tarr.setCodmonegr2(codmonegr2);

        List lista_partidas=orm.ejecutarLista("certificacion2", "mostrar_partidas", tarr, new classcertificacion());
        modelo.put("lista_partidas",lista_partidas);
         modelo.put("nk",Integer.toString(lista_partidas.size()));
 

        //  System.out.println("tamaño lista ------ "+lista_certificado.size());
        
       // classcertificacion tarr2=new classcertificacion();
        GrupoRubro tarr2=new GrupoRubro();
        tarr2.setCodgru(codmonegr1);
        List lista_grupo=orm.ejecutarLista("clasificador", "mostrargrupos2", tarr2, new GrupoRubro());
        modelo.put("lista_grupo",lista_grupo);
      //  
        //classcertificacion tarr3=new classcertificacion();
        tarr2.setCodgru(codmonegr2);
        List lista_subgrupo=orm.ejecutarLista("clasificador", "mostrargrupos2", tarr2, new GrupoRubro());
        modelo.put("lista_subgrupo",lista_subgrupo);





        /**********************************************************************************************************/
        /**********************************************************************************************************/
        /**********************************************************************************************************/
        /**********************************************************************************************************/
        /**********************************************************************************************************/
        /**********************************************************************************************************/
        /**********************************************************************************************************/

        /*Sacando los totales de los montos ejecutados en ingresos - egresos para la disponibilidad financiera*/

        

/*999999999999999999999999999999999999

         /////total Fuentes disponibles en la partida
         String MSC[][]= new String[20][20];
         MSC[0][0]="0";

         ProActTar fuen=new ProActTar();
         fuen.setCodtar(codtar);
         List lis_fe_tar=orm.ejecutarLista("fuenteeconomica","fuentes_e_disponibles_en_tarea", fuen, new ProActTar());
         modelo.put("tarea",fuen);
        ///Llenado la primera columna 0 de la matriz MSC[][] todas las fuentes disponibles en la tarea
         if(lis_fe_tar.size()>0)
        {//if_1
            for(int i=0; i< lis_fe_tar.size();i++)
            {

                ProActTar ki=(ProActTar) lis_fe_tar.get(i);
                MSC[0][i]=ki.getCodfueneco();
             }
         }
         /////FIN FIN FIN FIN FINtotal Fuentes disponibles en la partida

        ////LLENADO LA MATRIZ DE TOTALES
 MosPresuIng sing=new MosPresuIng();
         //MosPresuIng sing2=new MosPresuIng();
         if(lis_fe_tar.size()!=0)
        {
              for(int f=0;f<lis_fe_tar.size();f++)
             {

                     sing.setCodtar(codtar);
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

                     tt=orm.ejecutarObjeto("comproegr","tot_ejec_fe",sing,new String());
                     if(tt!=null)
                      {MSC[6][f]=tt;}else{MSC[6][f]="0";}

             }
        }
////FIN FIN FIN FIN  LLENADO LA MATRIZ DE TOTALES
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");

 for(int i=0;i<=6;i++){

        for(int j=0;j<lis_fe_tar.size();j++)
        {
            System.out.print(MSC[i][j]);
        }
          System.out.println("ggggg");
          System.out.println("ggggg");
          System.out.println("ggggg");

 }


//OPERACIONES PARA LOS TOTALES EN LA MATRIS DE FUENTES DISPONIBLES
for(int f=0;f<lis_fe_tar.size();f++)
   {
     double a=Double.valueOf(MSC[1][f]).doubleValue();
     double b=Double.valueOf(MSC[2][f]).doubleValue();
     double c=Double.valueOf(MSC[3][f]).doubleValue();
     double d=Double.valueOf(MSC[4][f]).doubleValue();
     double e=(a+b)-(c+d);
     MSC[6][f]=df2.format(e).toString();//String.valueOf(e);

    }
//FIN FIN FIN FINF IFN FIN OPERACIONES PARA LOS TOTALES EN LA MATRIS DE FUENTES DISPONIBLES

        ///fin fin fin fin fin Sacando los totales de los montos ejecutados en ingresos - egresos para la disponibilidad financiera
99999999999999999999999999999999999999999999999999999999*/
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("certificacion/Certcert4", modelo);
    }
}