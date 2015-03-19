package org.springframework.eam.domain; 


import java.io.Serializable;
import java.util.Date;

public class Registro implements Serializable {

  /* ATRIBUTOS */
  private Date  fec_registro;
  private Date  fec_modificacion;
  private String  ult_usuario;
  private String  id_estado;
  private String  estado;
  private int  gestion;  
  private int  periodo;  
  private String usuario;
  private String region;  //atributo para determinar la region de trabajo se le asigna el id_programa

  /* PROPIEDADES*/
  public Date getFec_registro() { return fec_registro; }
  public void setFec_registro(Date fec_registro) { this.fec_registro = fec_registro; }  

  public Date getFec_modificacion() { return fec_modificacion; }
  public void setFec_modificacion(Date fec_modificacion) { this.fec_modificacion = fec_modificacion; }  
  
  public String getUlt_usuario() { return ult_usuario; }
  public void setUlt_usuario(String ult_usuario) { this.ult_usuario = ult_usuario; }  

  public String getId_estado() { return id_estado; }
  public void setId_estado(String id_estado) { this.id_estado = id_estado.trim(); }

  public String getEstado() { return estado; }
  public void setEstado(String estado) { this.estado = estado; }      
  
  public int getGestion() { return gestion; }
  public void setGestion(int gestion) { this.gestion = gestion; }
  
  public int getPeriodo() { return periodo; }
  public void setPeriodo(int periodo) { this.periodo = periodo; }

  public String getRegion() { return region; }
  public void setRegion(String region) { this.region = region; }

}

