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

public class FuenteEconomica implements Serializable {

    private String codfueneco;
    private String codfueneco2;
    private String descripcion;
    private String acro;

    public String getAcro() {
        return acro;
    }

    public void setAcro(String acro) {
        this.acro = acro;
    }

    private String cod_gnp;

    private String cod_snp;

    public String getCodfueneco() {
        return codfueneco;
    }

    public void setCodfueneco(String codfueneco) {
        this.codfueneco = codfueneco;
    }

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

    /**
     * @return the codfueneco2
     */
    public String getCodfueneco2() {
        return codfueneco2;
    }

    /**
     * @param codfueneco2 the codfueneco2 to set
     */
    public void setCodfueneco2(String codfueneco2) {
        this.codfueneco2 = codfueneco2;
    }

}
