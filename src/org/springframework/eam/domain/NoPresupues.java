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



public class NoPresupues implements Serializable {
    
    
    private String descripcion;
    
    private String cod_gnp;
    
    private String cod_snp;

    private String cod_det;

    private String codigo;
    
    private String codigo2;
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCod_gnp() {
        return cod_gnp;
    }

    public void setCod_gnp(String cod_gnp) {
        this.cod_gnp = cod_gnp;
    }

    public String getCod_snp() {
        return cod_snp;
    }

    public void setCod_snp(String cod_snp) {
        this.cod_snp = cod_snp;
    }

    public String getCod_det() {
        return cod_det;
    }

    public void setCod_det(String cod_det) {
        this.cod_det = cod_det;
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
