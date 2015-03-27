package org.springframework.eam.web.spring.egresos;

import org.springframework.eam.web.spring.presupuestos3.*;
import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.InsRef;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Ejecucionparcial1 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String idregistroinicial = request.getParameter("idregistroinicial");
        System.out.println(idregistroinicial);
        Comprometido c = new Comprometido();
        c.setId(idregistroinicial);
        Comprometido ejecucion_inicial = this.eam.getObjRefComproById(c);
        //System.out.println(ejecucion_inicial.getCodtar());

        String glosa_ejecucion=request.getParameter("glosaejecucion");
        String nrocomprobante_ejecucion=request.getParameter("nrocomprobanteejecucion");
        String fecha_ejecucion=request.getParameter("fechaejecucion");
        String hojaderuta_ejecucion=request.getParameter("hojaderutaejecucion");
        String nrocheque_ejecucion=request.getParameter("nrochequeejecucion");
        String monto_ejecucion=request.getParameter("montoejecucion");
        String glosa_inicial=request.getParameter("glosainicial");
       
         
        
        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1 
        Comprometido formulario_compra =new Comprometido();
        orm.ejecutarObjeto("formularios", "busca_item", ejecucion_inicial, formulario_compra);
       // SELECT * FROM formularios_compra WHERE monto=#monto# and codtar=#codtar# and codfueneco=#codfueneco# and codmonegr=#codmonegr# and glosa=#glosa# and num_sol=#num_sol# and cantidad=#cantidad# and responsable=#responsable# and glo_rut=#glo_rut#
        
        formulario_compra.setCulmi_anula("culminado");
        orm.ejecutarObjeto("formularios", "modificar_culmi_anula", formulario_compra, null);
//        UPDATE formularios_compra SET culmi_anula=#culmi_anula# WHERE id=#id#
        
        InsPreIng ejecutado =new InsPreIng();
        ejecutado.setCodmonegr(formulario_compra.getCodmonegr());
        ejecutado.setMontoeje(monto_ejecucion);
        ejecutado.setCodfueneco(formulario_compra.getCodfueneco());
        ejecutado.setCodtar(formulario_compra.getCodtar());
        

        orm.ejecutarObjeto("montosegreso", "inserta_ejecutado", ejecutado, null);
      
        formulario_compra.setGlosa(glosa_inicial);
        formulario_compra.setMonto(monto_ejecucion);
        //Actualiza Glosa...
        orm.ejecutarObjeto("montosegreso", "actualiza_glosa_refcompro", formulario_compra, null);
        orm.ejecutarObjeto("montosegreso", "actualiza_glosa_moncomprometido", formulario_compra, null);
        orm.ejecutarObjeto("montosegreso", "actualiza_glosa_formularioscompra", formulario_compra, null);
         InsRef egreso_ejecutado=new InsRef();
         egreso_ejecutado.setComprobante(nrocomprobante_ejecucion);
         egreso_ejecutado.setObservaciones(glosa_ejecucion);//GLOSA
         egreso_ejecutado.setFecha(fecha_ejecucion);
         egreso_ejecutado.setCodmonegr(ejecucion_inicial.getCodmonegr());
         egreso_ejecutado.setCodfueneco(ejecucion_inicial.getCodfueneco());
         egreso_ejecutado.setCodtar(ejecucion_inicial.getCodtar());
         egreso_ejecutado.setMonacumulado(monto_ejecucion);
         
         orm.ejecutarObjeto("montosegreso", "inserta_ejecutado_referencia", egreso_ejecutado, null);
         orm.ejecutarObjeto("comproegr", "eliminar_acumulado_refh", formulario_compra, null);
         
         
         ejecucion_inicial.setMonto(monto_ejecucion);
         orm.ejecutarObjeto("comproegr", "restar_monto",ejecucion_inicial , null);

        return new ModelAndView("presupuestos2/comprometido/EjecuCompro3", modelo);
    }
}
