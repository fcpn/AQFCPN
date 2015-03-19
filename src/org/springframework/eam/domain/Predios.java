package org.springframework.eam.domain; 


import java.io.Serializable;
import java.util.Date;
import org.springframework.eam.domain.Registro;

public class Predios extends Registro {

  /* ATRIBUTOS */
  private String  id_predio;
  private String  predio;
  private String  direccion;

  /* PROPIEDADES*/
  
  public String getId_predio() { return id_predio; }
  public void setId_predio(String id_predio) { this.id_predio = id_predio; }  

  public String getPredio() { return predio; }
  public void setPredio(String predio) { this.predio = predio; }

  public String getDireccion() { return direccion; }
  public void setDireccion(String direccion) { this.direccion = direccion; }      
  
}

