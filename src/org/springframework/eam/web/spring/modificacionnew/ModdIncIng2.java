
package org.springframework.eam.web.spring.modificacionnew;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.TrasIncre;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.tras;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModdIncIng2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        // String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        String codmoning=request.getParameter("codmoning");
        String glosa=request.getParameter("glosa");
        String cbte=request.getParameter("cbte");
        String fecha=request.getParameter("fecha");
        String monpre=request.getParameter("monto");
        String codfueneco=request.getParameter("codfueneco");

        String codm=codmoning;

        String monpre1=request.getParameter("monto1");
        String id=request.getParameter("id");
        String codmoning1=request.getParameter("codmoning1");
        String glosa1=request.getParameter("glosa1");
        String cbte1=request.getParameter("cbte1");
        String fecha1=request.getParameter("fecha1");
        String codfueneco1=request.getParameter("codfueneco1");

        modelo.put("id", id);
        modelo.put("monpre1", monpre1);
        modelo.put("codmoning1", codmoning1);
        modelo.put("glosa1", glosa1);
        modelo.put("cbte1", cbte1);
        modelo.put("fecha1", fecha1);
        modelo.put("codfueneco1", codfueneco1);


        System.out.println("ANTES--------------");
        System.out.println("Cod_Tarea  "+codtar);
        System.out.println("Cod___Ing1  "+codmoning1);
        System.out.println("Cod_FuenE1  "+codfueneco1);
        System.out.println("cbte1       "+cbte1);
        System.out.println("fecha1      "+fecha1);
        System.out.println("glosa1      "+glosa1);
        System.out.println("id         "+id);
        System.out.println("monpre1      "+monpre1);

        System.out.println("Ahora --------------");
        System.out.println("Cod_Tarea  "+codtar);
        System.out.println("Cod___Ing  "+codmoning);
        System.out.println("Cod_FuenE  "+codfueneco);
        System.out.println("cbte       "+cbte);
        System.out.println("fecha      "+fecha);
        System.out.println("glosa      "+glosa);
        System.out.println("id         "+id);
        System.out.println("monpre     "+monpre);


        modelo.put("codmoning",codmoning);
        modelo.put("codfueneco",codfueneco);
        modelo.put("codtar",codtar);


        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        
        /*Sacando la actividad*/
     ProActTar tare=new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral","selec",tare,tare);
        modelo.put("actividad",tare);
        /*Sacando la tarea*/
        ProActTar tar=new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar","codtar",tar,tar);
        modelo.put("tarea",tar);
        
        /*sacndo descripcion de fuente economica*/
       ProActTar cd=new ProActTar();
        cd.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("fuenteeconomica","codfueneco",cd,cd);
        modelo.put("des",cd);


        ///Modificando Incremento


        //restando presupuestado e incremento
        MosPresuIng iing=new MosPresuIng();
        iing.setMonpre1(monpre1);
        iing.setCodtar(codtar);
        iing.setCodmoning(codmoning1);
        iing.setCodfueneco(codfueneco1);
        orm.ejecutarObjeto("montosingreso","resta_presu_incre",iing,null);
        //modelo.put("reghis",iing);


        //Actualizando Saldo
        orm.ejecutarObjeto("montosingreso","actualiza_saldo",iing,null);


        //Eliminando Historial incremento
        TrasIncre incr=new TrasIncre();
        incr.setId(id);
        orm.ejecutarObjeto("histo_incre","elimina_hincre_id",incr,null);


        ///Insertando el Nuevo historial de Comprometido
        //99999999999999999999999999999999999999

//Adicionando Incremento

        tras r=new tras();
        r.setCodmoning(codmoning);
        r.setCodfueneco(codfueneco);
        r.setCodtar(codtar);
        r.setMonto(monpre);
        orm.ejecutarObjeto("montosingreso","suma2",r,null);


/*Actualizando saldos a la cuenta uno*/

      tras rw=new tras();

        rw.setCodmoning(codmoning);
        rw.setCodfueneco(codfueneco);
        rw.setCodtar(codtar);

        orm.ejecutarObjeto("montosingreso","actualiza_saldo",rw,null);

        /*Sumando al compo incremento*/
       orm.ejecutarObjeto("montosingreso","sum_incre",r,null);
        System.out.println("despuest de incrementos");


/*Insertando historial*/

  String i_e="0";/*0---->ingresos*/
        tras tr=new tras();
        tr.setCodmon(codmoning);
        tr.setI_e(i_e);
        tr.setCodfueneco(codfueneco);
        tr.setCodtar(codtar);
        tr.setFecha(fecha);
        tr.setCbte(cbte);
        tr.setMonto(monpre);
        tr.setGlosa(glosa);

        orm.ejecutarObjeto("histo_incre","insertando_ing",tr,null);

//Sacando el Ultimo dato insertado EL dato modificado
        tras mominc=new tras();
        mominc.setCodtar(codtar);
        mominc.setCodmon(codm);
        mominc.setCodfueneco(codfueneco);
        mominc.setCbte(cbte);
        mominc.setMonto(monpre);
        mominc.setI_e(i_e);
        orm.ejecutarObjeto("histo_incre","lista_un_reg",mominc,mominc);
        modelo.put("reghisto", mominc);


        orm.cerrar();
     /*88889 */
        return new ModelAndView("modingnew/increing/ModdIncIng2", modelo);
    }
}