/*
 * Pais.java
 *
 * Created on 13 de julio de 2007, 16:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.springframework.eam.domain;

/**
 *
 * @author Administrador
 */
import java.io.Serializable;
import java.util.Date;



public class Pais implements Serializable {
    
private String cod_pais;    
private String descripcion;        

    /** Creates a new instance of Pais */

   public String getCod_pais() { return cod_pais; }
   public void setCod_pais(String cod_pais) { this.cod_pais = cod_pais; }

   public String getDescripcion() { return descripcion; }
   public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
   
   
    
}
