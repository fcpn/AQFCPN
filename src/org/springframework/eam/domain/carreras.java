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



public class carreras implements Serializable {
    
private String tipo;
private String codigo;
private String descripcion;
private String codacti;
private int num_tarea;
private String codtar;
private String idcarrera;


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

    public String getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(String idcarrera) {
        this.idcarrera = idcarrera;
    }

    /**
     * @return the codacti
     */
    public String getCodacti() {
        return codacti;
    }

    /**
     * @param codacti the codacti to set
     */
    public void setCodacti(String codacti) {
        this.codacti = codacti;
    }

    /**
     * @return the num_tarea
     */
    public int getNum_tarea() {
        return num_tarea;
    }

    /**
     * @param num_tarea the num_tarea to set
     */
    public void setNum_tarea(int num_tarea) {
        this.num_tarea = num_tarea;
    }

    
}
