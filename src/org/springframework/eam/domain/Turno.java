//_ Turnos Modulo
package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Turno implements Serializable {

  /* ATRIBUTOS */
  private String id_usuario;
  private int id_turno;
  private String fec_asignacion;
  private String fec_caducidad;
  private String id_estado;
  private int dias;

  public String getId_usuario() { return id_usuario; }
  public void setId_usuario(String id_usuario) { this.id_usuario = id_usuario; }

  public int getId_turno() { return id_turno; }
  public void setId_turno(int id_turno) { this.id_turno = id_turno; }

  public String getFec_asignacion() { return fec_asignacion; }
  public void setFec_asignacion(String fec_asignacion) { this.fec_asignacion = fec_asignacion; }

  public String getFec_caducidad() { return fec_caducidad; }
  public void setFec_caducidad(String fec_caducidad) { this.fec_caducidad = fec_caducidad; }

  public String getId_estado() { return id_estado; }
  public void setId_estado(String id_estado) { this.id_estado = id_estado; }

  public int getDias() { return dias; }
  public void setDias(int dias) { this.dias = dias; }

}
