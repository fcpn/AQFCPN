//_ Verificacion Tiempos
package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.Date;
import java.sql.Time;
import java.util.List;

public class Tiempos implements Serializable {

  /* ATRIBUTOS */
  private int id_tiempos;
  private String id_tarjeta;
  private String id_usuario;
  private String id_rol;
  private String id_estado;
  private Date fec_inicio;
  private Date fec_fin;
  private int calificacion;
  private Time lapso;

  public int getId_tiempos() { return id_tiempos; }
  public void setId_tiempos(int id_tiempos) { this.id_tiempos = id_tiempos; }

  public String getId_tarjeta() { return id_tarjeta; }
  public void setId_tarjeta(String id_tarjeta) { this.id_tarjeta = id_tarjeta; }

  public String getId_usuario() { return id_usuario; }
  public void setId_usuario(String id_usuario) { this.id_usuario = id_usuario; }

  public String getId_rol() { return id_rol; }
  public void setId_rol(String id_rol) { this.id_rol = id_rol; }

  public String getId_estado() { return id_estado; }
  public void setId_estado(String id_estado) { this.id_estado = id_estado; }

  public Date getFec_inicio() { return fec_inicio; }
  public void setFec_inicio(Date fec_inicio) { this.fec_inicio = fec_inicio; }

  public Date getFec_fin() { return fec_fin; }
  public void setFec_fin(Date fec_fin) { this.fec_fin = fec_fin; }

  public int getCalificacion() { return calificacion; }
  public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

  public Time getLapso() { return lapso; }
  public void setLapso(Time lapso) { this.lapso = lapso; }


}
