//_ login
package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UsuariosLogin extends Personas {

  /* ATRIBUTOS */
  private String  id_usuario;
  private String  clave;
  private String  id_usuario2;
  private String  clave2;
  /* PROPIEDADES */
  public String getClave() { return clave; }
  public void setClave(String clave) { this.clave = clave; }
  public String getId_usuario() { return id_usuario; }
  public void setId_usuario(String id_usuario) {this.id_usuario = id_usuario; }
  public String getClave2() { return clave2; }
  public void setClave2(String clave2) { this.clave2 = clave2; }
  public String getId_usuario2() { return id_usuario2; }
  public void setId_usuario2(String id_usuario2) {this.id_usuario2 = id_usuario2; }

}
