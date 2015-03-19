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



public class InsRef implements Serializable {
    
    
    private String codmoning;
    private String codfueneco;
    private String codtar;
    private String comprobante;
    private String observaciones;
    private String fecha;
    private String monacumulado;
    private String codmonegr;
    private String id;
    public String getCodmoning() {
        return codmoning;
    }
    
    public void setCodmoning(String codmoning) {
        this.codmoning = codmoning;
    }
    
    public String getCodfueneco() {
        return codfueneco;
    }
    
    public void setCodfueneco(String codfueneco) {
        this.codfueneco = codfueneco;
    }
    
    public String getCodtar() {
        return codtar;
    }
    
    public void setCodtar(String codtar) {
        this.codtar = codtar;
    }
    
    public String getComprobante() {
        return comprobante;
    }
    
    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getMonacumulado() {
        return monacumulado;
    }
    
    public void setMonacumulado(String monacumulado) {
        this.monacumulado = monacumulado;
    }
    
    public String getCodmonegr() {
        return codmonegr;
    }
    
    public void setCodmonegr(String codmonegr) {
        this.codmonegr = codmonegr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
