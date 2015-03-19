
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
import org.springframework.eam.domain.Rubro;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModMonCompro2 implements Controller {
    
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
                   compro[j]=h[0];//codmonegr's'
                   compro[j+1]=h[1];//codfueneco's'
                   compro[j+2]=h[2];//monto's'
                   compro[j+3]=h[3];//id's'
                   compro[j+4]=h[4];//glosa's'
                   compro[j+5]=h[5];//fecha's'
                   compro[j+6]=h[6];//obs's'
                   compro[j+7]=h[7];//i_e's'
                   compro[j+8]=h[8];//ref123's'
                   String a = compro[j+5];
                   
                   
                   //cuando no hay fecha
                   if(a.substring(0,2).equals("//")){
                   compro[j+9]=a.substring(0,2);compro[j+10]="";compro[j+11]="";}
                   else{compro[j+9]=a.substring(0,2);compro[j+10]=a.substring(3,5);compro[j+11]=a.substring(6,8);}
                   //System.out.println(compro[j+9]);
                   
                   //System.out.println(compro[j+10]);
                   
                   //System.out.println(compro[j+11]);



                   j=j+12;           
                   
                   //System.out.println(a.substring(0,2)+" /// "+a.substring(3,5)+" /// "+a.substring(6,8));
            }
          j=j-12;
         
         for(int g=0; g<=j;g=g+4)
        {
            //System.out.println(compro[g]+" "+compro[g+1]+" "+compro[g+2]+" ii  - "+compro[g+3]);
        
        }
        modelo.put("M",compro);
         }
         modelo.put("j",Integer.toString(j));
         //System.out.println("JJJooo  ---  "+j);
         
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
        
        
        
        
        /*Sacando Rubros*/
        List sg = orm.ejecutarLista("clasificador","mostrar_partida",null,new Rubro()); //llamano al _orm la consulta
        modelo.put("partida",sg);
         /*Sacando fuentes economicas*/
        List fe = orm.ejecutarLista("fuenteeconomica","mostrar_fuenteeconomica",null,new FuenteEconomica()); //llamano al _orm la consulta
        modelo.put("fuente",fe);
        
        
         
         orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("presupuestos2/comprometido/ModMonCompro2", modelo);
    }
}