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



public class GrupoRubro implements Serializable {
    
private String codgru_ru;
private String codigo;
private String codigo2;

private String codsub_ru;
private String tipo;
private String descripcion;
private String codrub;

/*Egresos*/
private String codgru;
private String codsub;
private String codpar;
/*Fin Egresos*/
    public String getCodgru_ru() {
        return codgru_ru;
    }

    public void setCodgru_ru(String codgru_ru) {
        this.codgru_ru = codgru_ru;
    }

   
    public String getCodsub_ru() {
        return codsub_ru;
    }

    public void setCodsub_ru(String codsub_ru) {
        this.codsub_ru = codsub_ru;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodgru() {
        return codgru;
    }

    public void setCodgru(String codgru) {
        this.codgru = codgru;
    }

    public String getCodpar() {
        return codpar;
    }

    public void setCodpar(String codpar) {
        this.codpar = codpar;
    }

    public String getCodsub() {
        return codsub;
    }

    public void setCodsub(String codsub) {
        this.codsub = codsub;
    }

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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codrub
     */
    public String getCodrub() {
        return codrub;
    }

    /**
     * @param codrub the codrub to set
     */
    public void setCodrub(String codrub) {
        this.codrub = codrub;
    }

    /**
     * @return the codigo2
     */
    public String getCodigo2() {
        return codigo2;
    }

    /**
     * @param codigo2 the codigo2 to set
     */
    public void setCodigo2(String codigo2) {
        this.codigo2 = codigo2;
    }
    
}
