
package org.springframework.eam.web.spring.formularios;

import Ajayu_orm.orm_bd;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SolComAnu2 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
       
        String codtar=request.getParameter("codtar");
        String fecha=request.getParameter("fecha");
        String num_sol=request.getParameter("num_sol");
        String correlativo_unidad=request.getParameter("correlativo_unidad");
        String codmonegr=request.getParameter("codmonegr");
        modelo.put("codmonegr", codmonegr);

        String codfuneco=request.getParameter("codfuneco");
        modelo.put("codfuneco", codfuneco);
        modelo.put("num_sol", num_sol);
        modelo.put("correlativo_unidad", correlativo_unidad);
        modelo.put("fecha", fecha);
        String i_e="3";
        modelo.put("codtar", codtar);



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
        

        /*Anulacion de formularios*/
        Comprometido moscert=new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setFecha(fecha);
        moscert.setNum_sol(num_sol);
        moscert.setCorrelativo_unidad(correlativo_unidad);
        moscert.setCulmi_anula("anulado");
        orm.ejecutarObjeto("formularios","anular",moscert,null);

       
        List lis_formulario = orm.ejecutarLista("comproegr", "buscar_con_numsol", moscert, moscert);
        Comprometido certb = new Comprometido();
        if (lis_formulario != null) {
            for (int i = 0; i < lis_formulario.size(); i++) {
                Comprometido ki = (Comprometido) lis_formulario.get(i);

                certb.setCodfueneco(ki.getCodfueneco());
                certb.setCodtar(ki.getCodtar());
                certb.setCodmonegr(ki.getCodmonegr());
                certb.setNum_sol(ki.getNum_sol());
                certb.setId(ki.getId());
                certb.setMonto(ki.getMonto());
                orm.ejecutarObjeto("comproegr", "eliminar_acumulado_ref", certb, null);
                orm.ejecutarObjeto("comproegr", "restar_monto", certb, null);
                orm.ejecutarObjeto("comproegr", "eliminar_monto_cero", certb, null);

            }
        }
        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("formularios/SolComAnu2", modelo);
    }
}