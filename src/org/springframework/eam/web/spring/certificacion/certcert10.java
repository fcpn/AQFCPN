
package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.eam.domain.GrupoRubro;
import org.springframework.eam.domain.classcertificacion;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class certcert10 implements Controller {
    
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
        String codmonegr=request.getParameter("codpar");
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
        tarr.setCodmonegr(codmonegr);

        List lista_partidas=orm.ejecutarLista("certificacion2", "mostrar_partidas_like", tarr, new classcertificacion());
        modelo.put("lista_partidas",lista_partidas);
         modelo.put("nk",Integer.toString(lista_partidas.size()));
        /*
         modelo.put("n_l",lista_partidas.size());
        if(lista_partidas.size()==0)
        {  System.out.println("*******************************************************************************************NUMERO CARDINAL "+lista_partidas.size());}



         */



       /* List Lis_par=new ArrayList();
        if(lista_partidas != null){
            for(int i=0;i<lista_partidas.size();i++){
                classcertificacion par=(classcertificacion) lista_partidas.get(i);
                double mon = new Double(par.getSaldo()).doubleValue();
                par.setSaldo(df2.format(mon).toString());
                mon=new Double(par.getSumcom()).doubleValue();
                par.setSumcom(df2.format(mon).toString());
                Lis_par.add(par);
            }
            modelo.put("lista_partidas",Lis_par);
        }
        else{
           modelo.put("lista_partidas",lista_partidas);
        }

*/

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

      
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("certificacion/Certcert10", modelo);
    }
}