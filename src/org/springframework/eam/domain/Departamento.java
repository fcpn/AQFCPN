/*
 * Departamento.java
 *
 * Created on 17 de julio de 2007, 9:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.springframework.eam.domain;

/**
 *
 * @author Administrador
 */


public class Departamento extends Pais{
    
    /** Creates a new instance of Departamento */
private String cod_provincia;    
private String cod_depto;    
private String cod_seccion;    
private String cod_canton;    
private String cod_localidad;    
private String descripcion;        

    /** Creates a new instance of Pais */

    public String getCod_depto() { return cod_depto; }
    public void setCod_depto(String cod_depto) { this.cod_depto = cod_depto; } 
  
   
   public String getDescripcion() { return descripcion; }
   public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
   
   public String getCod_provincia() { return cod_provincia; }
    public void setCod_provincia(String cod_provincia) { this.cod_provincia = cod_provincia; } 
    
    public String getCod_seccion() { return cod_seccion; }
    public void setCod_seccion(String cod_seccion) { this.cod_seccion = cod_seccion; } 
    
    public String getCod_canton() { return cod_canton; }
    public void setCod_canton(String cod_canton) { this.cod_seccion = cod_canton; } 
    
    public String getCod_localidad() { return cod_localidad; }
    public void setCod_localidad(String cod_localidad) { this.cod_localidad = cod_localidad; } 
    
}
