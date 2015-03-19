/*
 * Autor: Jesus Reynaldo Perez Benavides
 */
package org.springframework.eam.web.spring.beneficiario;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Beneficiario;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class AbcdfBeneficiario implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
        String nit = request.getParameter("nit");
        String opcion = request.getParameter("opcion");
        String id_sucursal = request.getParameter("id_sucursal");
        String mensaje = "";
        Beneficiario benefi = new Beneficiario();
        benefi.setNit(nit);
        List Sucursales = new ArrayList();
        try {
            benefi = this.eam.getMostrarBeneficiario(benefi);
            Sucursales = this.eam.getListarSucursales(benefi.getNit());

        } catch (Exception e) {
            mensaje = mensaje + " No se puede mostrar sus sucursales";
        }
        modelo.put("mensaje", mensaje);
        modelo.put("Sucursal", Sucursales);
        modelo.put("beneficiario", benefi);
        /*************************************************************************************************/
        if (opcion.equals("nueva_sb")) {
            return new ModelAndView("beneficiario/AdicionarSucursal", modelo);
        }
        if (opcion.equals("modifica_b")) {
            return new ModelAndView("beneficiario/ModificaBeneficiario", modelo);
        }
        if (opcion.equals("elimina_b")) {
            try {
                this.eam.setEliminaBeneficiario(benefi);
                mensaje="Registro Eliminado!!!";
                benefi.setNit(nit);
                try {
                    benefi = this.eam.getMostrarBeneficiario(benefi);
                } catch (Exception e) {
                    mensaje = mensaje + " No se puede eliminar Benefirio";
                }
            } catch (Exception e) {
                mensaje = mensaje + " No se puede eliminar el registro";
            }
            modelo.put("mensaje", mensaje);
            modelo.put("beneficiario", benefi);
        }
        if (opcion.equals("modifica_s")) {
            Beneficiario Sucursal = new Beneficiario();
            Sucursal.setId_sucursal(id_sucursal);
            Sucursal = this.eam.getMostrarSucursal(Sucursal);
            modelo.put("Sucursal", Sucursal);
            return new ModelAndView("beneficiario/ModificaSucursal", modelo);
        }
        if (opcion.equals("elimina_s")) {
            //OK
            benefi.setId_sucursal(id_sucursal);
            this.eam.setEliminaSucursal(benefi);
            mensaje="Registro Eliminado!!!";
            try {
                Sucursales = this.eam.getListarSucursales(benefi.getNit());

            } catch (Exception e) {
                mensaje = mensaje + " No se puede mostrar sus sucursales";
            }
            modelo.put("mensaje", mensaje);
            modelo.put("Sucursal", Sucursales);
        }
        /*************************************************************************************************/
        return new ModelAndView("beneficiario/VerSucursales", modelo);
    }
}