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

public class GuardarBeneficiario implements Controller {

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
        String proveedor = request.getParameter("proveedor");
        String direccion = request.getParameter("direccion");
        String telefonos = request.getParameter("telefonos");
        Beneficiario benefi = new Beneficiario();
        benefi.setNit(nit);
        benefi.setProveedor(proveedor);
        benefi.setDireccion(direccion);
        benefi.setTelefonos(telefonos);
        String mensaje="";
        try {
            this.eam.setRegistroBeneficiario(benefi);
        } catch (Exception e) {
            mensaje = "No se pudo ingresar los datos del Proveedor " + proveedor;
        }
        List Sucursales = new ArrayList();
        try {
            benefi.setNit(nit);
            benefi = this.eam.getMostrarBeneficiario(benefi);
            Sucursales = this.eam.getListarSucursales(benefi.getNit());

        } catch (Exception e) {
            mensaje = mensaje + " No se puede mostrar sus sucursales";
        }
        modelo.put("mensaje",mensaje);
        modelo.put("Sucursal",Sucursales);
        modelo.put("beneficiario", benefi);
        return new ModelAndView("beneficiario/ResultadoNuevoBeneficiario", modelo);
    }
}