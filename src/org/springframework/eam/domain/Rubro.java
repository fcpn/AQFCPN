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



public class Rubro implements Serializable {
    
private String tipo;
private String codigo;
private String descripcion;
private String codtar;
private String codpartida;
private String descripciones;
private String ref123;
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodtar() {
        return codtar;
    }

    public void setCodtar(String codtar) {
        this.codtar = codtar;
    }

    /**
     * @return the codpartida
     */
    public String getCodpartida() {
        return codpartida;
    }

    /**
     * @param codpartida the codpartida to set
     */
    public void setCodpartida(String codpartida) {
        this.codpartida = codpartida;
    }

    /**
     * @return the descripciones
     */
    public String getDescripciones() {
        return descripciones;
    }

    /**
     * @param descripciones the descripciones to set
     */
    public void setDescripciones(String descripciones) {
        this.descripciones = descripciones;
    }

    /**
     * @return the ref123
     */
    public String getRef123() {
        return ref123;
    }

    /**
     * @param ref123 the ref123 to set
     */
    public void setRef123(String ref123) {
        this.ref123 = ref123;
    }

    
}
