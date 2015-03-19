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

public class ModifiCertProc2 implements Controller {

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
        String glo_rutan = request.getParameter("glo_rutan");
        //System.out.println("especificacion   glosa  "+glosa);

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
        // System.out.println("responsable  "+responsable);

        String codacti = request.getParameter("codacti");
        String id = request.getParameter("id");
        //System.out.println("id   "+id);
        String id_usuario_certificado = request.getParameter("id_usuario_certificado");

        modelo.put("num_sol", num_sol);
//        modelo.put("id", id);

        modelo.put("codtar", codtar);
        modelo.put("codacti", codacti);

        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros

        /*fech actual*/

        /*Fecha*/
        Calendario calendario = new Calendario();
        String me = calendario.getMonth();
        String di = Integer.toString(calendario.getDayOfMonth());
        String an = Integer.toString(calendario.getYear());
        String hora = Integer.toString(calendario.getHour());
        String minuto = Integer.toString(calendario.getMinute());

        if (calendario.getMinute() < 10) {
            minuto = "0" + minuto;
        }
        if (calendario.getDayOfMonth() < 10) {
            di = "0" + di;
        }
        String horas = hora + ":" + minuto;

        String desdia = calendario.getDay();
        String dmes = Integer.toString(calendario.getMonthInt());

        String fecha2 = desdia + " " + di + " de " + me + " de " + an;
        String fecha = di + " de " + me + " de " + an;

        if (calendario.getMonthInt() < 10) {
            dmes = "0" + dmes;
        }

        //System.out.println("dia ******   "+di);
        //System.out.println("mes ******   "+me);
        //System.out.println("año ******   "+an.substring(2, 4));
        String fechacom = di + "/" + dmes + "/" + an.substring(2, 4);
        //System.out.println("Fecha para el comprometido   "+ fechacom);
        modelo.put("fecha", fechacom);

        modelo.put("an", an);
        String fech_hora = fecha + " Hrs " + horas;//descripcion con horas

        modelo.put("fech_hora", fech_hora);

        /*FIN FIN FIN FIN fecha actual*/
        /*Registro anterior*/
        /*classcertificacion fech=new classcertificacion();
         fech.setCodtar(codtar);
         fech.setNum_sol(num_sol);
         fech.setId(id);
         fech.setI_e(i_e);
         orm.ejecutarObjeto("certificacion2","antiguo",fech,fech);
         /* FIN FIN FIN FINRegistro anterior*/

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
        /*eleminando la montocompro_refenrencia*/
        orm.ejecutarObjeto("compro_certificacion", "elimina_ref", moscert, null);
        moscert.setCodfueneco(codfuenecoan);
        moscert.setCodmonegr(codmonegran);
        moscert.setMonto(montoan);
        moscert.setNum_sol(num_sol);
        moscert.setGlosa(glosaan);
        moscert.setGlo_rut(glo_rutan);
        moscert.setResponsable(responsablean);
        moscert.setCantidad(cantidadan);
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
        nucert.setFecha(fechacom);

        nucert.setRef123(ref123);
        nucert.setObs(obs);
        nucert.setId_usuario_certificado(id_usuario_certificado);
        orm.ejecutarObjeto("comproegr", "insertar_compro", nucert, null);
        nucert.setI_e(i_e);
        nucert.setNum_sol(num_sol);
        nucert.setMonto(monto);
        nucert.setCantidad(cantidad);
        nucert.setResponsable(responsable);
        nucert.setFechahrs(fech_hora);
        nucert.setFechalit(fecha2);
        orm.ejecutarObjeto("certificacion", "insertar_ref_del_tmpcom", nucert, null);

        orm.ejecutarObjeto("comproegr", "actualiza_compro", nucert, null);

        orm.ejecutarObjeto("comproegr", "eliminar_monto_cero", moscert, null);

        orm.ejecutarObjeto("certificacion", "modifica_fecha_num_sol", nucert, null);

        /*FORMULARIOS*/
        Comprometido nucerta = new Comprometido();
        orm.ejecutarObjeto("formularios", "busca_item", moscert, nucerta);
        System.out.println("id id id     - " + nucerta.getId());

        nucert.setId(nucerta.getId());
        orm.ejecutarObjeto("formularios", "modificar_de_certificacion", nucert, null);

        nucert.setCorrelativo_unidad(nucerta.getCorrelativo_unidad());
        orm.ejecutarObjeto("formularios", "modifica_fech", nucert, null);

        orm.cerrar();//cerrar la conexion    ahora vamos a jsp

        return new ModelAndView("presupuestos2/comprometido/ModifiCertProc2", modelo);
    }
}
