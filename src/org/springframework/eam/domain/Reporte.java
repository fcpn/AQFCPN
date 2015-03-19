//_ reportes
package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Reporte implements Serializable {

  /* ATRIBUTOS */
  private String id_usuario;
  private int nro;
  private String nroGeneral;
  private String descripcion;
  private String estado;

  public String getId_usuario() { return id_usuario; }
  public void setId_usuario(String id_usuario) { this.id_usuario = id_usuario; }

  public int getNro() { return nro; }
  public void setNro(int nro) { this.nro = nro; }

  public String getNroGeneral() { return nroGeneral; }
  public void setNroGeneral(String nroGeneral) { this.nroGeneral = nroGeneral; }

  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

  public String getEstado() { return estado; }
  public void setEstado(String estado) { this.estado = estado; }

}
