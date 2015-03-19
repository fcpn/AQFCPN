
package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Servidor implements Serializable {

  /* ATRIBUTOS */
  private String id_servidor;
  private String servidor;
  private String ip;
  private String puerto;
  private String usuario;
  private String password;
  private String transcripcion;
  /* tarjetas */
  private int total;
  private int transcritas;
  private int anuladas;
  /* Datos caja */
  private String caja;
  private String descripcion;
  
    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getTranscripcion() {
        return transcripcion;
    }

    public void setTranscripcion(String transcripcion) {
        this.transcripcion = transcripcion;
    }

    public String getId_servidor() {
        return id_servidor;
    }

    public void setId_servidor(String id_servidor) {
        this.id_servidor = id_servidor;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTranscritas() {
        return transcritas;
    }

    public void setTranscritas(int transcritas) {
        this.transcritas = transcritas;
    }

    public int getAnuladas() {
        return anuladas;
    }

    public void setAnuladas(int anuladas) {
        this.anuladas = anuladas;
    }
  
}
