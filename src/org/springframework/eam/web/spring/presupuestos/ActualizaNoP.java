
package org.springframework.eam.web.spring.presupuestos;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.InsRef;
import org.springframework.eam.domain.MosPresuIng;
import org.springframework.eam.domain.NoPresupues2;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.web.spring.calendario.Calendario;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ActualizaNoP implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        
        String cod=request.getParameter("codigo");/*codigo del clasificador*/
        String codfueneco=request.getParameter("codfueneco");
        String monejenopre=request.getParameter("monto");
        String mon_acu=monejenopre;/*monto ejecutado que se acumula*/
        
        String codacti=request.getParameter("codacti");
        String codtar=request.getParameter("codtar");
        String cod_gnp=request.getParameter("cod_gnp");
        modelo.put("codtar", codtar);
        modelo.put("codacti", codacti);
        modelo.put("cod_gnp", cod_gnp);

        
        String comprobante=request.getParameter("comprobante");
        String obs=request.getParameter("obs");
        String fecharef=request.getParameter("fecha");
        // String fecha=request.getParameter("fecha");
        //String fech=fecha;
        
        
        
        //System.out.println("-----VRIALBLES VARIBLES del FORMULARIO-------");
        // System.out.println(ref123);
        String[] h = cod.split("::");/*cod      codigo del clasificador + tipo*/
        String ref123=h[0];
        String codmonnopreing=h[1];
        
      //  String codcod=codmonnopreing;
        
        /*
        System.out.println("REV LOS SALDOS SALDOS");
        System.out.println("tipo----"+ref123);
        System.out.println("codigoclasificador----"+codmonnopreing);
        System.out.println("codigofuente----"+codfueneco);
        System.out.println("codtar----"+codtar);
        System.out.println("montoeje----"+monejenopre);
        System.out.println("codacti----"+codacti);
        System.out.println("comprobante----"+comprobante);
        System.out.println("monacumulado----"+montoacu);
        System.out.println("fecha----"+fecha);
        */
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        // GrupoRubro gr=new GrupoRubro();
        // gr.setCodgru_ru(codgru_ru);
        
        /*Fecha*/
        
        Calendario calendario = new Calendario();
        String me = calendario.getMonth();
        String di = Integer.toString(calendario.getDayOfMonth());
        String an = Integer.toString(calendario.getYear());
        
        String ff = di+" de "+me+" de "+an;
        
        InsPreIng fec=new InsPreIng();
        fec.setFecha_act(ff);
        fec.setCodtar(codtar);
        fec.setCodacti(codacti);
        orm.ejecutarObjeto("tarea","inserta_fecha_act",fec,null);
        /*fecha*/
        
        
        
        NoPresupues2 pre=new NoPresupues2();
        
        pre.setCodmonnopreing(codmonnopreing);
        pre.setCodfueneco(codfueneco);
        pre.setCodtar(codtar);
        pre.setMonejenopre(monejenopre);
        pre.setRef123(ref123);
        
        orm.ejecutarObjeto("cuentanopresuing","atc_ejecutado",pre,null);
        
        
     // UPDATE montosnopresupuesing SET monejenopre=monejenopre+#monejenopre# WHERE codmonnopreing=#codmonnopreing# and codfueneco=#codfueneco# and codtar=#codtar#;
        
        
        
        
        
        
        /*insertando a acumulado tabla referencia ejecu ing*/
        NoPresupues2 nnp=new NoPresupues2();
        nnp.setComprobante(comprobante);
        nnp.setObs(obs);
        nnp.setFecharef(fecharef);
        nnp.setCodmonnopreing(codmonnopreing);
        nnp.setCodtar(codtar);
        nnp.setCodfueneco(codfueneco);
        nnp.setMon_acu(mon_acu);
             
        orm.ejecutarObjeto("cuentanopresuing","inserta_ejecutado_referencia",nnp,null);
        
        
        
        
        
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
        
        List mon=orm.ejecutarLista("cuentanopresuing","mostrar_ejecutados",null, new MosPresuIng());
        //List oo=orm.ejecutarLista("montosingreso","mostrar_montos_presupuestados",mon,mon);
        modelo.put("mosmoneje",mon);
         
        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        /*return new ModelAndView("presupuestos/montos/MuestraEjecutadosInsertados", modelo);*/
        return new ModelAndView("presupuestos/montos/MuestraEjecutadosNoPresu", modelo);
        
    }
}