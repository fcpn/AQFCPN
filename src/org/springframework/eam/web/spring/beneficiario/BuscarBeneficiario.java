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

public class BuscarBeneficiario implements Controller {

    private EamFacade eam;

    public void setEam(EamFacade eam) {
        this.eam = eam;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
        String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
        String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");

        String busBeneficiario = request.getParameter("busBeneficiario");
        String opcionBus = request.getParameter("opcionBus");
        List Beneficiarios = new ArrayList();
        String mensaje = "";
        if (opcionBus.equals("nit")) {
            //busca por nit
            try {
                String nit = "%" + busBeneficiario + "%";
                Beneficiarios = this.eam.getListarBeneficiarioPorNit(nit);
            } catch (Exception e) {
                mensaje = "No se pudo buscar por el nit  " + busBeneficiario;
            }
        } else {
            //buscar por nombre proveedor
            try {
                String nombrep = "%" + busBeneficiario + "%";
                Beneficiarios = this.eam.getListarBeneficiarioPorNombre(nombrep);
            } catch (Exception e) {
                mensaje = "No se pudo buscar por el nombre  " + busBeneficiario;
            }
        }

        modelo.put("mensaje", mensaje);
        modelo.put("beneficiarios", Beneficiarios);
        return new ModelAndView("beneficiario/BuscarBeneficiario", modelo);
    }
}