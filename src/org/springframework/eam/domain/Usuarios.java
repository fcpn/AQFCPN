package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Usuarios extends Personas {

  /* ATRIBUTOS */
  private String  id_usuario;
  private String  id_tipo_usuario;
  private String  tipo_usuario;
  private String  usuario;
  private String  clave;
  private String  id_rol;
  private String  rol;
  private List    roles;
  private String  correo;
  private String  recordatorio;
  private Date    fec_expiracion;
  private String  ult_usuario;
  private int     id_facultad;
  private String  id_programa;
  private String  facultad;
  private String  programa;  
/*  Cambio de Pin */
  private String  clave_nueva;  

  private String  descripcion;  
  private String  hora;  
  private String  log;  
  private String  dia;  
  private String  mes;  
  private String  anio; 
  private int nro_tarjetas; 
  private String score;
  private String  cod_img;  
  private String status;

  
  public String getCod_img() { return cod_img; }
  public void setCod_img(String cod_img) { this.cod_img = cod_img; }


  public int getNro_tarjetas() { return nro_tarjetas; }
  public void setNro_tarjetas(int nro_tarjetas) { this.nro_tarjetas = nro_tarjetas; }
  
  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
  public String getDia() { return dia; }
  public void setDia(String dia) { this.dia = dia; }
  public String getMes() { return mes; }
  public void setMes(String mes) { this.mes = mes; }
  public String getAnio() { return anio; }
  public void setAnio(String anio) { this.anio = anio; }

  public String getHora() { return hora; }
  public void setHora(String hora) { this.hora = hora; }
  public String getLog() { return log; }
  public void setLog(String log) { this.log = log; }


  
  /* PROPIEDADES */
/*  Cambio de Pin */
  public String getClave_nueva() { return clave_nueva; }
  public void setClave_nueva(String clave_nueva) { this.clave_nueva = clave_nueva; }
/*  Fin cambio de Pin  */
  public int getId_facultad() { return id_facultad; }
  public void setId_facultad(int id_facultad) { this.id_facultad = id_facultad; }

  public String getFacultad() { return facultad; }
  public void setFacultad(String facultad) { this.facultad = facultad; }
  
  public String  getId_programa() { return id_programa; }
  public void setId_programa(String id_programa) { this.id_programa = id_programa.trim(); }

  public String getPrograma() { return programa; }
  public void setPrograma(String programa) { this.programa = programa; }
  


  /* JavaBeans Properties */


  // aumentado por _ _ ***********************************
  private String cargo;
  private String nombres;

  public String getCargo() { return cargo; }
  public void setCargo(String cargo) { this.cargo = cargo; }

  public String getNombres() { return nombres; }
  public void setNombres(String nombres) { this.nombres = nombres; }
  //FIN _ ******************************************************


  public String getId_usuario() { return id_usuario; }

  public void setId_usuario(String id_usuario) {
    id_usuario = id_usuario.trim();
    this.id_usuario = id_usuario; 
  }

  public String getId_tipo_usuario() { return id_tipo_usuario; }
  public void setId_tipo_usuario(String id_tipo_usuario) { this.id_tipo_usuario = id_tipo_usuario; }

  public String getTipo_usuario() { return tipo_usuario; }
  public void setTipo_usuario(String tipo_usuario) { this.tipo_usuario = tipo_usuario; }



  public String getUsuario() { return usuario; }
  public void setUsuario(String usuario) { this.usuario = usuario.trim(); }

  public String getClave() { return clave; }
  public void setClave(String clave) { this.clave = clave.trim(); }
  
  public String getId_rol() { return id_rol; }
  public void setId_rol(String id_rol) {
   id_rol = id_rol.toLowerCase();
   this.id_rol = id_rol.trim(); 
  }
  
  public String getRol() { return rol; }
  public void setRol(String rol) {
    rol = rol.toUpperCase();
   this.rol = rol; 
  }

  public String getCorreo() { return correo; }
  public void setCorreo(String correo) { this.correo = correo; }
  
  public String getRecordatorio() { return recordatorio; }
  public void setRecordatorio(String recordatorio) { this.recordatorio = recordatorio; }

// AUMENTADO POR TARIJA
  public Date getFec_expiracion() { return fec_expiracion; }
  public void setFec_expiracion(Date fec_expiracion) { this.fec_expiracion = fec_expiracion; }

  public String getUlt_usuario() { return ult_usuario; }
  public void setUlt_usuario(String ult_usuario) { this.ult_usuario = ult_usuario; }
  
  public List getRoles(){
    return roles;
  }
  public void setRoles(List roles){
    this.roles = roles;
  }
/*_ Cambiar Turno
  private String id_turno;
  public String getId_turno() { return id_turno; }
  public void setId_turno(String id_turno) { this.id_turno = id_turno; }
//Fin _ Cambiar Turno*/
//_ Turno
  private int id_turno;
  public int getId_turno() {
    return id_turno;
  }
  public void setId_turno(int id_turno) {
    this.id_turno = id_turno;
  }

  private int id_turno_actual;
  public int getId_turno_actual() {
    return id_turno_actual;
  }
  public void setId_turno_actual(int id_turno_actual) {
    this.id_turno_actual = id_turno_actual;
  }

  private int id_turno_tmp;
  public int getId_turno_tmp() {
    return id_turno_tmp;
  }
  public void setId_turno_tmp(int id_turno_tmp) {
    this.id_turno_tmp = id_turno_tmp;
  }

  private int dias;
  public int getDias() {
    return dias;
  }
  public void setDias(int dias) {
    this.dias = dias;
  }

    /**
     * @param score the score to set
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
//Fin _ Turno
}
