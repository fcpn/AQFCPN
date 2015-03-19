// *********************************************************************************************************
// Programa	::	ADMINISTRAR PERSONAS
//Descripcion   ::      Este modulo puede ser llamado por cualquier programa que requiera 
//                      registrar a una persona sin importar cuel sera su posicion final en el sistema
//			es decir, estudiante, docente, administrativo, etc
//			El objeto de este programa es validar y registrar datos peersonales
//                      y devolver un ID de Persona el cual fue creado..
// Autor	::	_ CASTILLO - _
// Creado	::	2005/10/1, 11:00
// Modificado   ::      _ Castillo  ::  2005/10/15, 11:32
// *********************************************************************************************************
package org.springframework.eam.web.spring.administrarpersonas;

import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.List;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;

import org.springframework.eam.domain.Personas;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class AdministrarPersonasControlador implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }

  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_programa");
    String id_programa = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");
    String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
// DATOS DE LA DIRECCION DE SALIDA DE LOS RESULTADOS DE ESTE MODULO ***********
      String titulo = request.getParameter("titulo");
      String salida = request.getParameter("salida");
      modelo.put("titulo", titulo);
      modelo.put("salida", salida); //es el nombre de la vista a donde saldra
                                    //cuando este metodo finalice y ademas devolvera el nuevo ID PERSONA
// ****************************************************************************
      String nombres = request.getParameter("nombres");
      String paterno = request.getParameter("paterno");
      String materno = request.getParameter("materno");
      String dip = request.getParameter("dip");
      String id_sexo = request.getParameter("id_sexo");
      String dia = request.getParameter("dia");
      String mes = request.getParameter("mes");
      String anio = request.getParameter("anio");
      //String id_pais = request.getParameter("id_pais");
      //String id_departamento = request.getParameter("id_departamento");
      String direccion = request.getParameter("direccion");
      //String ciudad = request.getParameter("ciudad");
      //String tipo_sanguineo = request.getParameter("tipo_sanguineo");
      //String id_estado_civil = request.getParameter("id_estado_civil");
      String telefono = request.getParameter("telefono");
      String correo = request.getParameter("correo");
      String accion = request.getParameter("accion");
      
      //PagedListHolder listaPaises = new PagedListHolder(this.eam.getPaises());
      //listaPaises.setPageSize(listaPaises.getNrOfElements()); 
      //modelo.put("listaPaises", listaPaises);

      //PagedListHolder listaDepartamentos = new PagedListHolder(this.eam.getDepartamentos());
      //listaDepartamentos.setPageSize(listaDepartamentos.getNrOfElements()); 
      //modelo.put("listaDepartamentos", listaDepartamentos);

      //PagedListHolder lestadosciviles = new PagedListHolder(this.eam.getListaEstadoCivil());
      //lestadosciviles.setPageSize(lestadosciviles.getNrOfElements()); 
      //modelo.put("lestadosciviles", lestadosciviles);

 //validacion de los datos de ingreso necesarios para continuar
    if (accion.equals("Continuar >>")) { 
        String _error = new String("");
        if("".equals(nombres) || "".equals(dip) || "".equals(anio) ) {
           _error = "Los Campo(s) ";
           if("".equals(nombres))
                _error = _error + "Nombres, ";
           if("".equals(dip))
                _error = _error + "Cedula, ";
           if("".equals(anio))
                _error = _error + "A ";
           _error = _error + "son obligatorios...";
           modelo.put("_error", _error);
        }  
        modelo.put("nombres", nombres);
        modelo.put("paterno", paterno);
        modelo.put("materno", materno);
        modelo.put("dip", dip);
        modelo.put("id_sexo", id_sexo);
        modelo.put("dia", dia);
        modelo.put("mes", mes);
        modelo.put("anio", anio);
        //modelo.put("id_pais", id_pais);
        //modelo.put("pais", this.eam.getPais(Integer.parseInt(id_pais)).getPais());
        //modelo.put("id_departamento", id_departamento);
        //modelo.put("departamento", this.eam.getDepartamento(Integer.parseInt(id_departamento)).getDepartamento());
        //modelo.put("id_estado_civil", id_estado_civil);
        //modelo.put("estado_civil", this.eam.getEstadoCivil(Integer.parseInt(id_estado_civil)).getEstado_civil());
        modelo.put("direccion", direccion);
        //modelo.put("ciudad", ciudad);
        //modelo.put("tipo_sanguineo", tipo_sanguineo);
        modelo.put("telefono", telefono);
        modelo.put("correo", correo);
        modelo.put("programa", programa);

        if(!_error.equals("")) {
           return new ModelAndView("administrarpersonas/AdministrarPersonas", modelo);
        }
        else {
         Personas persona = new Personas();
         persona.setNombres(nombres);
         persona.setPaterno(paterno);
         persona.setMaterno(materno);
         persona.setDip(dip);
         persona.setId_sexo(id_sexo);
         Date fec_nacimiento = new Date(Integer.parseInt(anio)-1900, Integer.parseInt(mes)-1, Integer.parseInt(dia));
         persona.setFec_nacimiento(fec_nacimiento);
         //persona.setId_pais(Integer.parseInt(id_pais));
         //persona.setId_departamento(Integer.parseInt(id_departamento));
         persona.setDireccion(direccion);
         //persona.setCiudad(ciudad);
         //persona.setTipo_sanguineo(tipo_sanguineo);
         persona.setId_estado_civil(0);
         persona.setTelefono(telefono);
         persona.setCorreo(correo);
         persona.setUlt_usuario(ult_usuario);
         persona = (Personas) this.eam.setRegistrarPersona(persona);
	 if ("".equals(persona.getId_persona())) {
            modelo.put("mensaje","La persona no fue registrada. <br> Es posible que la persona ya exista <br> comuniquese con el administrador del sistema");
            return new ModelAndView("errores/RegisterError", modelo);
	 }
         modelo.put("id_persona", persona.getId_persona());
         return new ModelAndView(salida, modelo);
      }
    }
    modelo.put("id_sexo","M");  // valores por defecto
    //modelo.put("id_estado_civil","1");  //valores por defecto
    return new ModelAndView("administrarpersonas/AdministrarPersonas", modelo);
  }
}