
package org.springframework.eam.web.spring.administrarusuarios;

import java.util.*;
import java.util.Map;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Personas;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.util.WebUtils;

public class SetRegistrarUsuarioTranscriptor implements Controller {
 
  private EamFacade eam;
 
  public void setEam(EamFacade eam) {
    this.eam = eam;
  }
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Map modelo = new HashMap();

    String ult_usuario = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_usuario");
    String id_prog = (String) WebUtils.getRequiredSessionAttribute(request, "__sess_id_prog");

//    String dip = request.getParameter("dip");
//    String paterno = request.getParameter("paterno");
//    String materno = request.getParameter("materno");
//    String nombres = request.getParameter("nombres");
//    String correo = request.getParameter("correo");
//    String telefono = request.getParameter("telefono");
      String id_persona = request.getParameter("id_persona");
      String id_usuario = request.getParameter("id_usuario");
      String clave = request.getParameter("clave");
      String roles[] = request.getParameterValues("roles");
      
      
      
    Personas per = new Personas();
    per.setId_persona(id_persona);
    per = this.eam.getPersona(per);
    modelo.put("per",per);
    

int res;

	Administrativos administrativo = new Administrativos();
	administrativo.setId_administrativo(id_usuario);
	administrativo.setId_persona(id_persona);
	administrativo.setCargo("Funcionario");
	administrativo.setId_programa(id_prog);
	administrativo.setUlt_usuario(ult_usuario);
	res = this.eam.setRegistrarAdministrativo(administrativo);


        Usuarios usuario = new Usuarios();
	usuario.setId_usuario(id_usuario);
	usuario.setClave(clave);
	usuario.setRecordatorio("ninguno");
	usuario.setId_programa(id_prog);
	usuario.setUlt_usuario(ult_usuario);
	res = this.eam.setRegistrarUsuariosAdm(usuario);
    
    int lr;
    try{
        lr = roles.length;
    }catch(Exception e){
        lr = 0;
    }

        for(int i = 0; i<lr; i++) {
	  usuario.setId_rol(roles[i]);
	  usuario.setFec_expiracion(new Date());
          res = this.eam.setRegistrarUsuariosRoles(usuario);
        }
      
    
      
//    String id_turno = request.getParameter("id_turno");
//    String cargo = request.getParameter("cargo");

//    System.out.println(cargo);

//    Administrativos adm = new Administrativos();
//    adm.setDip(dip);
//    adm.setPaterno(paterno);
//    adm.setMaterno(materno);
//    adm.setNombres(nombres);
//    adm.setCorreo(correo);
//    adm.setTelefono(telefono);
//    adm.setId_usuario(usuario);
//    adm.setClave(clave);
//    adm.setId_turno(Integer.parseInt(id_turno));
//    adm.setCargo(cargo);
//    adm.setUlt_usuario(id_usuario);
    
//    int res = this.eam.setRegistrarAdministrativo(adm);
    File directorio = new File("/opt/tomcat/webapps/cp/images/tarjetas/"+id_usuario);
    directorio.mkdir();	
             
//    modelo.put("mensaje","La cuenta ha sido creada");

    return new ModelAndView("administrarusuarios/UsuarioInfo", modelo);
//    return new ModelAndView("administrarusuarios/Respuesta", modelo);
  }
}
