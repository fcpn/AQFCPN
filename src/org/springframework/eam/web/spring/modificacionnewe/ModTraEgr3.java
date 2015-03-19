
package org.springframework.eam.web.spring.modificacionnewe;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.tras;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModTraEgr3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();



/*GENERALES*/
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        String codmonegr=request.getParameter("codmonegr");
        String codfuenecog=request.getParameter("codfuenecog");
        modelo.put("codfuenecog",codfuenecog);
/*NUEVA PARTIDA DEL CUAL SE SACARA EL TRASPASO*/
        String codmonegr_n=request.getParameter("codmonegr_n");
/*INICIALES*/
        String codmonegr2_=request.getParameter("codmonegr2_");
        modelo.put("codmonegr2_",codmonegr2_);
        String moneje_=request.getParameter("moneje_");
        modelo.put("moneje_",moneje_);
        String saldo_=request.getParameter("saldo_");
        modelo.put("saldo_",saldo_);
        String codfueneco_=request.getParameter("codfueneco_");
        modelo.put("codfueneco_",codfueneco_);
        String monto_=request.getParameter("monto_");
        modelo.put("monto_",monto_);
        String id_=request.getParameter("id_");
        modelo.put("id_",id_);
        String glosa_=request.getParameter("glosa_");
        modelo.put("glosa_",glosa_);
        String cbte_=request.getParameter("cbte_");
        modelo.put("cbte_",cbte_);
        String fecha_=request.getParameter("fecha_");
        modelo.put("fecha_",fecha_);
/*PARA MODIFICAR hISTORIAL TRASPASO*/
        String codmonegr2=request.getParameter("codmonegr2");
        modelo.put("codmonegr2",codmonegr2_);
        String moneje=request.getParameter("moneje");
        modelo.put("moneje",moneje);
        String saldo=request.getParameter("saldo");
        modelo.put("saldo",saldo);
        String codfueneco=request.getParameter("codfueneco");
        String monto=request.getParameter("monto");
        modelo.put("monto",monto);
        String id=request.getParameter("id");
        String glosa=request.getParameter("glosa");
        String cbte=request.getParameter("cbte");
        String fecha=request.getParameter("fecha");
        
/*mostrando */
   /*     System.out.println("*********************************");
        System.out.println("principal  "+codmonegr);
        System.out.println("principal  "+codfuenecog);
        System.out.println("principal  "+codtar);
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println("nuevosac codmonegr_n  "+codmonegr_n);
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println("codmonegr2_     "+codmonegr2_);
        System.out.println("saldo_          "+saldo_);
        System.out.println("codfueneco_      "+codfueneco_);
        System.out.println("monto_          "+monto_);
        System.out.println("id_             "+id_);
        System.out.println("glosa_          "+glosa_);
        System.out.println("cbte_           "+cbte_);
        System.out.println("fecha_          "+fecha_);
        System.out.println("moneje_         "+moneje_);
        System.out.println("*********************************");
        System.out.println("*********************************");
        System.out.println("Los cambios");
        System.out.println("codmonegr2     "+codmonegr2);
        System.out.println("saldo          "+saldo);
        System.out.println("codfueneco     "+codfueneco);
        System.out.println("monto          "+monto);
        System.out.println("id             "+id);
        System.out.println("glosa          "+glosa);
        System.out.println("cbte           "+cbte);
        System.out.println("fecha          "+fecha);
        System.out.println("moneje         "+moneje);
*/

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        

       /*Sacando descripcion de codfueneco*/
        ProActTar fu=new ProActTar();
        fu.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",fu,fu);
        modelo.put("fuente",fu);

//parametros
        
        /*Sacando la actividad*/
        ProActTar act=new ProActTar();
        act.setCodacti(codacti);
        orm.ejecutarObjeto("proacttar","codacti",act,act);
        modelo.put("actividad",act);
        
        /*Sacando la tarea*/
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        


        /*Parte Eliminar*/

        /*Sacando * del principal codmonegr  */

        MosPresuIng mop=new MosPresuIng();
        mop.setCodmonegr(codmonegr);
        mop.setCodfueneco(codfuenecog);
        mop.setCodtar(codtar);
        orm.ejecutarObjeto("montosegreso","mon_pre_eje_sal",mop,mop);
        modelo.put("egremon",mop);

        /*Sacando Historial de traspaso a modificar El cual se hizo con PUT mas arriba*/
 
        
 /*ELIMINANDO TRASPASO  Operando los traspasos Eliminacion*/
            
       /*SUMANDO A MONTO PRESUPUESTADO LO QUE SE RESTO PARA EL TRASPASO */
         MosPresuIng mtm=new MosPresuIng();
         mtm.setCodmonegr(codmonegr);
         mtm.setCodfueneco(codfuenecog);
         mtm.setCodtar(codtar);
         mtm.setMonto(monto_);

         orm.ejecutarObjeto("montosegreso","suma2",mtm,null);
        /*Restando de traspaso_s*/
         orm.ejecutarObjeto("montosegreso","res_tra_s",mtm,null);
         /*Actualizando Saldo*/
         orm.ejecutarObjeto("montosegreso","actualiza_saldo",mtm,null);

         /*Operando con la partida que recepciono el monto*/
         /*Restanado de la partida que recepciono el monto*/
         MosPresuIng rtp=new MosPresuIng();
         rtp.setCodfueneco(codfueneco_);
         rtp.setCodtar(codtar);
         rtp.setCodmonegr(codmonegr2_);
         rtp.setMonto(monto_);
         orm.ejecutarObjeto("montosegreso","resta2",rtp,null);
         /*Restando de traspaso_r*/
         orm.ejecutarObjeto("montosegreso","res_tra_r",rtp,null);
         /*Actualizo saldo*/
         orm.ejecutarObjeto("montosegreso","actualiza_saldo",rtp,null);
         /*Eliminando el registro del la tabla h_traspaso*/
         rtp.setId(id_);
         orm.ejecutarObjeto("histo_tras","eliminar_registro",rtp,null);  
         
         
  /*FIN FIN FIN FIN ELIMINANDO TRASPASO    Operando los traspasos Eliminacion*/


         

 /*Adicionando el nuevo registro de TRSPASO a la base de datos*/

         /*RESTANDO de la presupuestado de la partida principal MONTOSEGRESO*/
         MosPresuIng mtm2=new MosPresuIng();
         mtm2.setCodmonegr(codmonegr_n);
         mtm2.setCodfueneco(codfueneco);
         mtm2.setCodtar(codtar);
         mtm2.setMonto(monto);

         orm.ejecutarObjeto("montosegreso","resta2",mtm2,null);
         /*Sumando al registro de traspasos saliente de la partida*/
         orm.ejecutarObjeto("montosegreso","sum_tra_s",mtm2,null);
         /*Actualizando Saldo*/
         orm.ejecutarObjeto("montosegreso","actualiza_saldo",mtm2,null);

         /*Operando con la NUEVA partida que recepciono el monto*/
         /*SUMANDO de la NUEVA partida que recepciono el monto*/
         MosPresuIng npt=new MosPresuIng();
         npt.setCodfueneco(codfueneco);
         npt.setCodtar(codtar);
         npt.setCodmonegr(codmonegr2);
         npt.setMonto(monto);
         orm.ejecutarObjeto("montosegreso","suma2",npt,null);
         /*Sumando de traspaso_r*/
         orm.ejecutarObjeto("montosegreso","sum_tra_r",npt,null);
         /*Actualizo saldo*/
         orm.ejecutarObjeto("montosegreso","actualiza_saldo",npt,null);


         /*ADICIONANDO el registro a la tabla h_traspaso*/
        tras tr=new tras();

        tr.setCodmonegr(codmonegr_n);
        tr.setCodmonegr2(codmonegr2);
        tr.setCodfueneco(codfueneco);
        tr.setCodtar(codtar);
        tr.setFecha(fecha);
        tr.setCbte(cbte);
        tr.setMonto(monto);
        tr.setGlosa(glosa);
        tr.setDescla("");
        tr.setDescla2("");
        tr.setDesfe("");
        orm.ejecutarObjeto("histo_tras","insertando",tr,null);




/*FIN FIN FIN FIN FIN FIN  Adicionando el nuevo registro de TRSPASO a la base de datos*/
 

/*SACANDO los datos Actualizados General principal*/
        
        MosPresuIng modt=new MosPresuIng();
        modt.setCodmonegr(codmonegr_n);
        modt.setCodfueneco(codfueneco);
        modt.setCodtar(codtar);
        orm.ejecutarObjeto("montosegreso","mon_pre_eje_sal",modt,modt);
        modelo.put("modt",modt);

        /*Traspaso Realizado Final*/
        orm.ejecutarObjeto("histo_tras","un_registro",tr,tr);
        modelo.put("tr",tr);


        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);      */
        return new ModelAndView("modegrnew/traspaso/ModTraEgr3", modelo);
    }
}