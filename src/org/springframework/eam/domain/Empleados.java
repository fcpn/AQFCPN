package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.List;
import org.springframework.eam.domain.Personas;

public class Empleados extends Personas{

  /* ATRIBUTOS */
    private String id_administrativo;
    private String cargo;
  /* PROPIEDADES */
  public String getId_administrativo(){
    return id_administrativo;
  }
  public void setId_administrativo(String id_administrativo){
    id_administrativo = id_administrativo.trim();  
    id_administrativo = id_administrativo.toLowerCase();
    this.id_administrativo = id_administrativo;
  }
  public String getCargo(){
    return cargo;
  }
  public void setCargo(String cargo){
    this.cargo = cargo;
  }
}