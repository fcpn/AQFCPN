package org.springframework.eam.domain;

import java.io.Serializable;

public class Roles implements Serializable {

  /* ATRIBUTOS */

  private String id_rol;
  private String rol;
  private String descripcion;
  private String ult_usuario;
  private String id_programa;
  /* PROPIEDADES */

  public void setId_programa(String id_programa) {
    this.id_programa = id_programa;
  }
  public String getId_programa() {
    return id_programa;
  }

  public String getId_rol() {
    return id_rol;
  }
  public void setId_rol(String id_rol) {
    id_rol = id_rol.toLowerCase();
    this.id_rol = id_rol.trim();
  }

  public String getRol() {
    return rol;
  }
  public void setRol(String rol) {
    rol = rol.toUpperCase();
    this.rol = rol.trim();
  }

  public String getDescripcion() {
    return descripcion;
  }
  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion.trim();
  }
  
  public String getUlt_usuario() {
    return ult_usuario;
  }
  
  public void setUlt_usuario(String ult_usuario) {
    this.ult_usuario = ult_usuario.trim();
  }
}