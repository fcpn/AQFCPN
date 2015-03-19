package org.springframework.eam.web.spring.presupuestos3;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.ProActTar;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.eam.web.spring.calendario.Calendario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ModifiCertProc4 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();


        String montoan = request.getParameter("montoan");

        String monto = request.getParameter("monto");
        //System.out.println("monto  "+monto);
        String codtar = request.getParameter("codtar");
        //System.out.println("codtar   "+codtar);
        String codfueneco = request.getParameter("codfueneco");
        //System.out.println("codfueneco   "+codfueneco);
        String codfuenecoan = request.getParameter("codfuenecoan");
        //System.out.println("codfuenecoan   "+codfuenecoan);
        String codmonegr = request.getParameter("partida");
        //System.out.println("partida   "+codmonegr);
        String codmonegran = request.getParameter("codmonegran");
        //System.out.println("codmonegran   "+codmonegran);
        String glosa = request.getParameter("especificacion");
        String glosaan = request.getParameter("glosaan");
        //System.out.println("especificacion   glosa  "+glosa);
        String glo_rut = request.getParameter("glo_rut");
        String glo_rutan = request.getParameter("glo_rutan");
        //System.out.println("glosa rut  "+glo_rut);

        String ref123 = "3";
        String obs = "Certificación Presupuestaria Modificada";

        String i_e = "3";

        String num_sol = request.getParameter("num_sol");
        //System.out.println("num_sol    "+num_sol);
        String cantidad = request.getParameter("cantidad");
        String cantidadan = request.getParameter("cantidadan");
        //System.out.println("cantidad   "+cantidad);
        String responsable = request.getParameter("responsable");
        String responsablean = request.getParameter("responsablean");
        //System.out.println("responsable  "+responsable);

        String codacti = request.getParameter("codacti");
        String id = request.getParameter("id");
        //System.out.println("id   "+id);

        String fecha = request.getParameter("fecha");
        //System.out.println("fecha    "+fecha);

        String fechalit = request.getParameter("fechalit");
        //System.out.println("fechalit    "+fechalit);

        String fechahrs = request.getParameter("fechahrs");
        
        String id_usuario_certificado=request.getParameter("id_usuario_certificado");
        //System.out.println("fechahrs    "+fechahrs);
        modelo.put("num_sol", num_sol);
        modelo.put("fecha", fecha);
//        modelo.put("id", id);

        modelo.put("codtar", codtar);
        modelo.put("codacti", codacti);

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros



        /*Sacando la actividad*/

        ProActTar tare = new ProActTar();
        tare.setCodtar(codtar);
        orm.ejecutarObjeto("gral", "selec", tare, tare);
        modelo.put("actividad", tare);

        /*Sacando la tarea*/
        ProActTar tar = new ProActTar();
        tar.setCodtar(codtar);
        orm.ejecutarObjeto("proacttar", "codtar", tar, tar);
        modelo.put("tarea", tar);


        /*Listado de los correlativos de las certificaciones en proceso*/
        Comprometido moscert = new Comprometido();
        moscert.setCodtar(codtar);
        moscert.setId(id);
        moscert.setI_e(i_e);
        moscert.setNum_sol(num_sol);
        moscert.setGlosa(glosaan);
        moscert.setGlo_rut(glo_rutan);
        moscert.setResponsable(responsablean);
        moscert.setCantidad(cantidadan);
        /*eleminando la montocompro_refenrencia*/
        orm.ejecutarObjeto("compro_certificacion", "elimina_ref", moscert, null);
        moscert.setCodfueneco(codfuenecoan);
        moscert.setCodmonegr(codmonegran);
        moscert.setMonto(montoan);
        orm.ejecutarObjeto("comproegr", "restar_monto", moscert, null);

        /*insertando el nuevo*/
        Comprometido nucert = new Comprometido();
        nucert.setCodtar(codtar);
        nucert.setCodfueneco(codfueneco);
        nucert.setCodmonegr(codmonegr);
        nucert.setGlosa(glosa);
        nucert.setFecha(fecha);

        nucert.setRef123(ref123);
        nucert.setObs(obs);
        orm.ejecutarObjeto("comproegr", "insertar_compro", nucert, null);
        nucert.setI_e(i_e);
        nucert.setNum_sol(num_sol);
        nucert.setMonto(monto);
        nucert.setCantidad(cantidad);
        nucert.setResponsable(responsable);
        nucert.setFechahrs(fechahrs);
        nucert.setFechalit(fechalit);
        nucert.setGlo_rut(glo_rut);
        nucert.setId_usuario_certificado(id_usuario_certificado);
        orm.ejecutarObjeto("certificacion", "insertar_ref_del_tmpcom", nucert, null);




        orm.ejecutarObjeto("comproegr", "actualiza_compro", nucert, null);

        orm.ejecutarObjeto("comproegr", "eliminar_monto_cero", moscert, null);

        orm.ejecutarObjeto("certificacion", "modifica_fecha_num_sol", nucert, null);

        /*Actualizando el formulario de Solicitud de Compra*/


        /*Buscar el Item en la tabla de formularios*/
        Comprometido nucerta = new Comprometido();
        orm.ejecutarObjeto("formularios", "busca_item", moscert, nucerta);
        System.out.println("id id id     - " + nucerta.getId());

        nucert.setId(nucerta.getId());
        orm.ejecutarObjeto("formularios", "modificar_de_certificacion", nucert, null);


        orm.cerrar();//cerrar la conexion    ahora vamos a jsp
//
        return new ModelAndView("presupuestos2/comprometido/ModifiCertProc2", modelo);
    }
}
