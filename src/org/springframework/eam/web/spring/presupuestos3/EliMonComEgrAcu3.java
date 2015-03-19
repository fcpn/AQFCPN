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
import org.springframework.eam.domain.Comprometido;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EliMonComEgrAcu3 implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        String codtar = request.getParameter("codtar");
        modelo.put("codtar", codtar);
        System.out.println("DES_Tarea ---- " + codtar);

        //llevando fuente actividad + descripcion
        String codacti = request.getParameter("codacti");
        modelo.put("codacti", codacti);
        System.out.println("DES_actividad ---- " + codacti);





        System.out.println("*********************Complemento*********************************************************");
        String comple[] = request.getParameterValues("complemento");
        String compro[] = new String[150];

        String datos[] = new String[450];

        int j = 0;
        for (int i = 0; i < comple.length; i++) {
            //System.out.println(com[i]);
            String[] h = comple[i].split("::");
            compro[j] = h[0];
            compro[j + 1] = h[1];
            compro[j + 2] = h[2];
            compro[j + 3] = h[3];//id

            compro[j + 4] = h[4];//glosa

            compro[j + 5] = h[5];//numsol
            compro[j + 6] = h[6];//cantidad
            compro[j + 7] = h[7];//responsable
            compro[j + 8] = h[8];//glorut
            j = j + 9;
        }
        j = j - 9;



        orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1



        Comprometido gr = new Comprometido();
        Comprometido gt = new Comprometido();
        int r = 0;
        //  System.out.println("***********************Ingresando Datos Comprometidos Acumulados y Totales*******************************************************");
        Comprometido nucerta = new Comprometido();
        for (int g = 0; g < comple.length; g++) {


            gr.setCodmonegr(compro[r]);//codmonegr
            gr.setCodfueneco(compro[r + 1]);//cod fuente
            gr.setMonto(compro[r + 2]);//monto
            gr.setId(compro[r + 3]);//id
            gr.setCodtar(codtar);

            orm.ejecutarObjeto("comproegr", "eliminar_acumulado_ref", gr, null);
            /*Elimiando de formularios*/

            gr.setGlosa(compro[r + 4]);
            gr.setNum_sol(compro[r + 5]);
            gr.setCantidad(compro[r + 6]);
            gr.setResponsable(compro[r + 7]);
            gr.setGlo_rut(compro[r + 8]);
            orm.ejecutarObjeto("formularios", "busca_item", gr, nucerta);
            gr.setId(nucerta.getId());
            orm.ejecutarObjeto("formularios", "eliminar_item", gr, null);

            ///Restar
            orm.ejecutarObjeto("comproegr", "restar_monto", gr, null);
            r = r + 9;
        }


        // System.out.println("***********************Si es Cero el monto total de comprometido borrarlo*******************************************************");



/*System.out.println("codmonegr "+compro[r]);
            System.out.println("codfueneco "+compro[r+1]);
            System.out.println("monto "+compro[r+2]);
            System.out.println("id "+compro[r+3]);
            System.out.println("glosa "+compro[r+4]);
            System.out.println("numsol "+compro[r+5]);
            System.out.println("cantidad "+compro[r+6]);
            System.out.println("responsable "+compro[r+7]);
            System.out.println("glorut "+compro[r+8]);*/

        r = 0;
        for (int g = 0; g < comple.length; g++) {

            
            gr.setCodmonegr(compro[r]);//codmonegr
            gr.setCodfueneco(compro[r + 1]);//cod fuente
            gr.setId(compro[r + 2]);//id
            gr.setCodtar(codtar);
            orm.ejecutarObjeto("comproegr", "eliminar_monto_cero", gr, null);
            r = r + 9;
        }


        orm.cerrar();//cerrar la conexion         ahora vamos a jsp
        return new ModelAndView("presupuestos2/comprometido/EliMonComEgrAcu3", modelo);
    }
}
