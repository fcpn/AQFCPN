package org.springframework.eam.web.spring.verificacion;

import java.util.HashMap;
import java.util.Map;

//import ajayu_planes.THistorial;
//import java.util.HashMap;
//import java.util.Map;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Date;
import java.sql.*;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Departamento;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.Servidor;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;
import Ajayu_orm.orm_bd;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion; 

//import org.postgresql.util.PSQLException;

public class Transcripcion2Controlador implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        //catalogos!!
    
	String id_usuario = (String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
        
        Pais pais = new Pais();
        Departamento depto = new Departamento();
        Departamento provincia = new Departamento();
        Departamento seccion = new Departamento();
        Departamento canton = new Departamento();
        Departamento localidad = new Departamento();
        Personas nacionalidad = new Personas();
        Personas estcivil = new Personas();
        Personas profesion = new Personas();
        Personas filiacion = new Personas();
	Personas parametros = new Personas();
	parametros.setDescripcion("getG1");
	
        Usuarios usuario = new Usuarios();	        
	usuario.setId_usuario(id_usuario);
	
	Tarjeta tramite = new Tarjeta();
	Tarjeta parientes = new Tarjeta();
	Tarjeta gsang = new Tarjeta();
        
        PagedListHolder listapais = new PagedListHolder(this.eam.getListaPais(pais));
        listapais.setPageSize(listapais.getNrOfElements());
        modelo.put("listapais", listapais);
        
        PagedListHolder listadepto = new PagedListHolder(this.eam.getListaDepto(depto));
        listadepto.setPageSize(listadepto.getNrOfElements());
        modelo.put("listadepto", listadepto);
        
        //PagedListHolder listaprovincia = new PagedListHolder(this.eam.getListaProvincia(provincia));
        //listaprovincia.setPageSize(listaprovincia.getNrOfElements());
        //modelo.put("listaprovincia", listaprovincia);

        //PagedListHolder listalocalidad = new PagedListHolder(this.eam.getListaLocalidad(localidad));
        //listalocalidad.setPageSize(listalocalidad.getNrOfElements());
        //modelo.put("listalocalidad", listalocalidad);
        
        PagedListHolder listaestcivil = new PagedListHolder(this.eam.getListaEstcivil(estcivil));
        listaestcivil.setPageSize(listaestcivil.getNrOfElements());
        modelo.put("listaestcivil", listaestcivil);
        
        PagedListHolder listafiliacion = new PagedListHolder(this.eam.getListaFiliacion(filiacion));
        listafiliacion.setPageSize(listafiliacion.getNrOfElements());
        modelo.put("listafiliacion", listafiliacion);
			
		
	PagedListHolder listaparientes = new PagedListHolder(this.eam.getListaParientes(parientes));
        listaparientes.setPageSize(listaparientes.getNrOfElements());
        modelo.put("listaparientes", listaparientes);	
	
	
	PagedListHolder listatramite = new PagedListHolder(this.eam.getListaTramite(tramite));
        listatramite.setPageSize(listatramite.getNrOfElements());
        modelo.put("listatramite", listatramite);

	PagedListHolder listagrupo = new PagedListHolder(this.eam.getListaGrupo(parametros));
        listagrupo.setPageSize(listagrupo.getNrOfElements());
        modelo.put("listag1", listagrupo);
	
	parametros.setDescripcion("getCache");
	PagedListHolder listaocupaciones = new PagedListHolder(this.eam.getListaGrupo(parametros));
        listaocupaciones.setPageSize(listaocupaciones.getNrOfElements());
        modelo.put("listaocupaciones", listaocupaciones);

	PagedListHolder listagruposang = new PagedListHolder(this.eam.getListaGrupoSang(gsang));
        listagruposang.setPageSize(listagruposang.getNrOfElements());
        modelo.put("listagruposang", listagruposang);
	

	String cod_registro ="";
	String cod_img="";
	try {
	    cod_registro = (String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");
        } catch(Exception e) {
	    cod_registro = "";
	}
        System.out.println("antes ccccccccccccccccc >> "+cod_registro);
        /*     ORM      */
        Servidor srv = new Servidor();
	srv.setId_servidor("srv01");
        srv = (Servidor) this.eam.getServidor(srv);
        orm_bd orm = new orm_bd();
        String strsource = "jdbc:postgresql://"+srv.getIp()+":"+srv.getPuerto()+"/imagenesdb";
        orm.establecerConexion(strsource+";"+srv.getUsuario()+";"+srv.getPassword()+";");
           
        //orm.verCompilado = "C";
        if (cod_registro.equals("")) {   
	  cod_img = orm.ejecutarObjeto("imagenes","get_codigo_img",null,new String()); //this.eam.getCodigoImg(usuario);           
	  usuario.setCod_img(cod_img);
	  this.eam.setRegistroTranscripcion(usuario);
	  orm.cerrar();
	  System.out.println("despues ccccccccccccccccc >> "+cod_img);
          request.getSession().setAttribute("__cod_img", cod_img);
          Tarjeta tarjeta = new Tarjeta();
	  tarjeta.setId_pais("BOL");
	  tarjeta.setId_departamento("2");
	  tarjeta.setId_tipo_tarjeta("1");
	  tarjeta.setId_grupo_sanguineo(2);
	  modelo.put("obj",tarjeta);
	  //modelo.put("id_pais","BOL");
	  //modelo.put("id_departamento","2");
        } else {
          Tarjeta tarjeta = new Tarjeta();
	  tarjeta.setId_tarjeta(cod_registro);
	  tarjeta = this.eam.getTarjeta(tarjeta);
	  // ---->
	  Tarjeta datos = new Tarjeta();
	  datos.setId_tarjeta(cod_registro);
	//datos.setId_usuario(id_usuario);
        try {
	  tarjeta.setOcupaciones(this.eam.getOcupaciones(datos));
	} catch(Exception e) {}
        try {
	  tarjeta.setParientes(this.eam.getParientes(datos));
	} catch(Exception e) {}
        try {
	  tarjeta.setRelaciones(this.eam.getRelaciones(datos));
	} catch(Exception e) {}
        try {
	  tarjeta.setTramites(this.eam.getTramites(datos));
	} catch(Exception e) {}
          //System.out.println("wwwwwwwww  --+ ocup "+Integer.toString(tarjeta.getOcupaciones().size()));
          //System.out.println("wwwwwwwww  --+ par "+Integer.toString(tarjeta.getParientes().size()));
          //System.out.println("wwwwwwwww  --+ rel "+Integer.toString(tarjeta.getRelaciones().size()));
          //System.out.println("wwwwwwwww  --+ tram "+Integer.toString(tarjeta.getTramites().size()));
	  modelo.put("obj",tarjeta);
	  cod_img = cod_registro;
	}
	
        modelo.put("cod_img",cod_img);
	modelo.put("id_usuario",id_usuario.toUpperCase());

        modelo.put("nro_hoy",Integer.toString(this.eam.getTarjetasHoy(usuario)));
        modelo.put("nro_total",Integer.toString(this.eam.getTarjetasTotal(usuario)));
	
	
	/////////////////AQUI AUMENTO LA PARTE DE LAS IMAGENES
	long time=System.currentTimeMillis();
        Date fecha=new Date(time);        
        long milisegundos=fecha.getTime();        
        String distinto=String.valueOf(milisegundos);
        
        String nanverso="";
        String nreverso="";
        String ext="";
        String cod="",codigo="";
        String codigo1="";
        
        //String carpeta_usuario="Usuarios_Transcriptores"+"/"+id_usuario+"/";        
        cod = cod_img; // "741-1700";
        String ndir="/opt/tomcat/webapps/cp/images/tarjetas/"+id_usuario+"/";

        //TRANSCRIPTOR        
        File dir = new File(ndir);        
        if (dir.isDirectory()==true) {
            String[] files = dir.list();
            for ( int i=0;i<files.length;i++ ) {
                String narchivo= ndir+files[i];
                File f=new File(narchivo);
                if (f.isFile()==true) {
                    boolean sw=true;
                    sw=f.delete();
                } else {
                    System.out.println("No es un Archivo");
                }
            }
        } else {
            System.out.println("No es un directorio");
        }


        try {
            Class.forName("org.postgresql.Driver");
            
            Connection con = DriverManager.getConnection(strsource,srv.getUsuario(),srv.getPassword());
            
            con.setAutoCommit(false);
            
            Statement statement=con.createStatement();                                    
            //armamos el codigo con las comillas simples
            codigo="'"+cod+"'";
            //Aqui realizamos la consulta para obtener el archivo imagen
                String sql="select anv_img,rev_img from imagenes_tmp where cod_img="+codigo;

                //se tiene que dar la ruta de donde estara hubicado la carpeta en el servidor
                nanverso=ndir+"anverso_img"+distinto;
                nreverso=ndir+"reverso_img"+distinto;            
                //definimos la extencion
                ext=".jpg";

                ResultSet result=statement.executeQuery(sql);
                result.first();

                InputStream input=result.getBinaryStream(1);
                InputStream input2=result.getBinaryStream(2);

                //aqui le damos el nombre del archivo con el se guardara en un directorio del spring
                FileOutputStream output=new FileOutputStream(nanverso+ext);
                FileOutputStream output2=new FileOutputStream(nreverso+ext);
                //escribimos el anverso
                int c;
                while((c=input.read())!=-1){
                    output.write(c);
                }
                //escribimos el reverso
                while((c=input2.read())!=-1){
                    output2.write(c);
                }                        
                input.close();
                input2.close();
                output.close();
                output.close();
                con.commit();
                cod="El Numero de imagen  No es correcto o No se encuentra en el servidor";
                        
        } catch (ClassNotFoundException e) {
            System.out.println("No funciona la conexion");
        }
        //Aqui se le puede enviar el nombre del archivo para mostrar
        int j=1;
        while(j<=10000){    j++; }
            
            
         //modelo.put("mensaje",cod);   
         String dirIP="./images/tarjetas/"+id_usuario+"/";
         modelo.put("lnombreA",dirIP+"anverso_img"+distinto+ext);
         modelo.put("lnombreR",dirIP+"reverso_img"+distinto+ext);
             
        ///////HASTA ACA
	
	Tarjeta tarjeta = new Tarjeta();
	tarjeta.setCod_img(cod_img);
	String descripcion = this.eam.getDescripcionImg(tarjeta); 
	modelo.put("descripcion",descripcion);
	
	
        return new ModelAndView("transcripcion/TranscripcionEntrada1", modelo);
        
    }
}