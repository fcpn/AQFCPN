
package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.classcertificacion;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class cert3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        //'lik='+requerimiento+'&codtar='+codtar+'&monto='+monto+'&partida='+partida+'$codfueneco='+codfueneco;
       
        String requerimiento=request.getParameter("requerimiento");
        String codtar=request.getParameter("codtar");
        String monto=request.getParameter("monto");
        String partida=request.getParameter("partida");
        String codfueneco = request.getParameter("codfueneco");
        String cantidad= request.getParameter("cantidad");
        String correlativo=request.getParameter("correlativo");
        String responsable=request.getParameter("responsable");
        String ref123=request.getParameter("ref123");
        String i_e="3";

        //lik="%"+lik+"%";


        //String codtar=request.getParameter("codtar");
        //modelo.put("codtar",codtar);
        System.out.println("*******************************////////////////////////////*************************************////////////////////////////************************///////////////////**************************///////////////////////**************");//glosa
        System.out.println("Requerimiento   ----------> "+requerimiento);//glosa
        System.out.println("CODIGO de TAREA ----------> "+codtar);//codtar
        System.out.println("monto           ----------> "+monto);//monto que va al comprometido
        System.out.println("codmonegr       ----------> "+partida);// codigo de partida
        System.out.println("codfueneco      ----------> "+codfueneco);//codigo de fuente economica
        System.out.println("cantidad        ----------> "+cantidad);//cantidad o numero de pedidos de un material
        System.out.println("correlativo     ----------> "+correlativo);//numero de correlativo de orden de pedido
       
        System.out.println("ref123          ----------> "+ref123);//referencia de partida
        System.out.println("i_e            -----------> "+i_e);// ingreso egreso certificacion=3
        System.out.println("i_e            -----------> "+responsable);// ingreso egreso certificacion=3




        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

/*insertando datos a la tabla temporal*/
        classcertificacion innn=new classcertificacion();

        innn.setCodmonegr(partida);
        innn.setCodtar(codtar);
        innn.setCodfueneco(codfueneco);
        innn.setGlosa(requerimiento) ;
        
        innn.setMonto(monto);
       // innn.setNo_rut(rut);
        innn.setCorrelativo(correlativo);
        innn.setCantidad(cantidad);
        innn.setRef123(ref123);
        innn.setI_e(i_e);
        innn.setResponsable(responsable);
        orm.ejecutarObjeto("certificacion","insertar_a_tmp",innn,null);
/* FIN FIN FIN FIN FIN insertando datos a la tabla temporal*/


/*SACANDOR LOS DATOS DE LA TABLA TEMPORAL PARA MOSTRARLA EN LA PAGINITA DE CERTIFICACIÓN*/
        classcertificacion regtem=new classcertificacion();
        regtem.setCodtar(codtar);
       // tarr.setCodfueneco(codfueneco);
        List lis_certi_proceso=orm.ejecutarLista("certificacion", "mostrar_certificacion_proceso", regtem, new classcertificacion());
        modelo.put("lis_certi_proceso",lis_certi_proceso);

        String no_pedido="1";
        modelo.put("",no_pedido);

        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("certificacion/Cert3", modelo);
    }
}