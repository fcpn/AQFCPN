
package org.springframework.eam.web.spring.login;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginControlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String id_usuario = request.getParameter("id_usuario");
        String clave      = request.getParameter("clave");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        
        System.out.println("id_usuario    .. "+id_usuario);
        System.out.println("pass    .. "+clave);



        String url        = request.getParameter("url");
        if (id_usuario.equals("")||clave.equals("")){
            return new ModelAndView("ajax/Respuesta", "mensaje", "Datos imcompletos, introduzca todos los campos");
        }        
        Usuarios usuario = (Usuarios) this.eam.getConexion(id_usuario, clave);
        /*sacando todo de un usuario    roles y status*/


        if (usuario.getNombres().equals("")) {
            return new ModelAndView("login/ErrorLogin", "mensaje", "No puedo encontrar al usuario o caduco su ingreso");
        }
        
        if (usuario.getRoles().size() == 0) {
            modelo.put("usuario", usuario.getNombres());
            modelo.put("programa", usuario.getPrograma());
            modelo.put("mensaje", "No tiene ninguna funcion asignada o la cuenta a caducado");
            return new ModelAndView("login/ErrorLogin", modelo);
        }
        
        String aplicacion="";
        if(url!=""){            
            int cont=0;
            for(int e=0;url.length()>e;e++){
                if(cont==3 && url.charAt(e)!='/')
                    aplicacion=aplicacion+url.charAt(e);
                if( url.charAt(e)=='/')
                    cont++;
            }
        }

        request.getSession().setAttribute("__sess_id_prog", usuario.getId_programa());
        request.getSession().setAttribute("__sess_nombres", usuario.getNombres());
        request.getSession().setAttribute("__sess_id_persona", usuario.getId_persona());
        request.getSession().setAttribute("__sess_id_usuario", usuario.getId_usuario());
        request.getSession().setAttribute("__sess_tipo_usuario", usuario.getTipo_usuario());
        request.getSession().setAttribute("__sess_programa", usuario.getPrograma());
    //    request.getSession().setAttribute("__sess_login_key",this.eam.setLoginKey(usuario));

        request.getSession().setAttribute("__sess_login_key",this.eam.setLoginKey(usuario));//loginstatus
        request.getSession().setAttribute("__sess_roles",usuario.getRoles());
        //request.getSession().setAttribute("__sess_gestion","2007");
        //request.getSession().setAttribute("__sess_periodo","2");
        modelo.put("listaDeRoles",usuario.getRoles());
        modelo.put("cantidad",    Integer.toString(usuario.getRoles().size()));
        modelo.put("usuario",     usuario);
        
        /* _ Castillo V. Transcripciones ver si el usuario tiene tarjeta y cargar a la sesion */
        //Tarjeta tarjeta = new Tarjeta();
        //tarjeta.setId_usuario(usuario.getId_usuario());
        //String tar = this.eam.getNombreTarjetaUsr(tarjeta);        
        //if (tar != null) request.getSession().setAttribute("__cod_img",tar);                
                
        return new ModelAndView("login/LoginSalida", modelo);
    }
}