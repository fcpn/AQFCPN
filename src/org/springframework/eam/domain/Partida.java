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



public class Partida implements Serializable {
    

private String descripcion;
private String codgru;
private String codsub;
private String codpar;

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the codgru
     */
    public String getCodgru() {
        return codgru;
    }

    /**
     * @param codgru the codgru to set
     */
    public void setCodgru(String codgru) {
        this.codgru = codgru;
    }

    /**
     * @return the codsub
     */
    public String getCodsub() {
        return codsub;
    }

    /**
     * @param codsub the codsub to set
     */
    public void setCodsub(String codsub) {
        this.codsub = codsub;
    }

    /**
     * @return the codpar
     */
    public String getCodpar() {
        return codpar;
    }

    /**
     * @param codpar the codpar to set
     */
    public void setCodpar(String codpar) {
        this.codpar = codpar;
    }

}
