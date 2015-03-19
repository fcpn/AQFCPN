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



public class InRubro3 implements Serializable {
    
    private String codrub;
    private String descripcion;
    private String codsub_ru;
    private String codsub;
    private String codpar;
    
    public String getCodrub() {
        return codrub;
    }
    
    public void setCodrub(String codrub) {
        this.codrub = codrub;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getCodsub_ru() {
        return codsub_ru;
    }
    
    public void setCodsub_ru(String codsub_ru) {
        this.codsub_ru = codsub_ru;
    }

    public String getCodsub() {
        return codsub;
    }

    public void setCodsub(String codsub) {
        this.codsub = codsub;
    }

    public String getCodpar() {
        return codpar;
    }

    public void setCodpar(String codpar) {
        this.codpar = codpar;
    }
    
    
}
