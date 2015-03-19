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



public class classcertificacion implements Serializable {
    /*certificacion uno*/
    private String codmonegr;
    private String des_partida;
    private String ref123;
    private String descripciones;
    private String i_e;
    private String num_sol;
    private String lik;
    private String no_rut;
    private String rut;
    private String correlativo;
    private String codtar;
    private String codfueneco;
    private String saldo;
    private String sumcom;
    private String obs;
    private String monto;
    private String cantidad;
    private String glosa;
    private String id;
    private String responsable;
    private String sumcomtmp;
    private String codpartida;
    private String codgru;
    private String codsub;
    private String id_usuario_certificado;

    public String getId_usuario_certificado() {
        return id_usuario_certificado;
    }

    public void setId_usuario_certificado(String id_usuario_certificado) {
        this.id_usuario_certificado = id_usuario_certificado;
    }



    /*certificacion dos*/
    private String codmonegr1;
    private String codmonegr2;
    private String des1;
    private String des2;
    private String descripciones1;
    private String descripciones2;
    private String fecha;
    private String fechalit;
    private String fechahrs;
    private String disponible;
    /**
     * @return the codmonegr
     */
    public String getCodmonegr() {
        return codmonegr;
    }

    /**
     * @param codmonegr the codmonegr to set
     */
    public void setCodmonegr(String codmonegr) {
        this.codmonegr = codmonegr;
    }

    /**
     * @return the des_partida
     */
    public String getDes_partida() {
        return des_partida;
    }

    /**
     * @param des_partida the des_partida to set
     */
    public void setDes_partida(String des_partida) {
        this.des_partida = des_partida;
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
     * @return the i_e
     */
    public String getI_e() {
        return i_e;
    }

    /**
     * @param i_e the i_e to set
     */
    public void setI_e(String i_e) {
        this.i_e = i_e;
    }

    /**
     * @return the lik
     */
    public String getLik() {
        return lik;
    }

    /**
     * @param lik the lik to set
     */
    public void setLik(String lik) {
        this.lik = lik;
    }

    /**
     * @return the no_rut
     */
    public String getNo_rut() {
        return no_rut;
    }

    /**
     * @param no_rut the no_rut to set
     */
    public void setNo_rut(String no_rut) {
        this.no_rut = no_rut;
    }

    /**
     * @return the correlativo
     */
    public String getCorrelativo() {
        return correlativo;
    }

    /**
     * @param correlativo the correlativo to set
     */
    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    /**
     * @return the codtar
     */
    public String getCodtar() {
        return codtar;
    }

    /**
     * @param codtar the codtar to set
     */
    public void setCodtar(String codtar) {
        this.codtar = codtar;
    }

    /**
     * @return the codfueneco
     */
    public String getCodfueneco() {
        return codfueneco;
    }

    /**
     * @param codfueneco the codfueneco to set
     */
    public void setCodfueneco(String codfueneco) {
        this.codfueneco = codfueneco;
    }

    /**
     * @return the saldo
     */
    public String getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the sumcom
     */
    public String getSumcom() {
        return sumcom;
    }

    /**
     * @param sumcom the sumcom to set
     */
    public void setSumcom(String sumcom) {
        this.sumcom = sumcom;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the monto
     */
    public String getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(String monto) {
        this.monto = monto;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the glosa
     */
    public String getGlosa() {
        return glosa;
    }

    /**
     * @param glosa the glosa to set
     */
    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    /**
     * @return the num_sol
     */
    public String getNum_sol() {
        return num_sol;
    }

    /**
     * @param num_sol the num_sol to set
     */
    public void setNum_sol(String num_sol) {
        this.num_sol = num_sol;
    }

    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    /**
     * @return the codmonegr1
     */
    public String getCodmonegr1() {
        return codmonegr1;
    }

    /**
     * @param codmonegr1 the codmonegr1 to set
     */
    public void setCodmonegr1(String codmonegr1) {
        this.codmonegr1 = codmonegr1;
    }

    /**
     * @return the codmonegr2
     */
    public String getCodmonegr2() {
        return codmonegr2;
    }

    /**
     * @param codmonegr2 the codmonegr2 to set
     */
    public void setCodmonegr2(String codmonegr2) {
        this.codmonegr2 = codmonegr2;
    }

    /**
     * @return the des1
     */
    public String getDes1() {
        return des1;
    }

    /**
     * @param des1 the des1 to set
     */
    public void setDes1(String des1) {
        this.des1 = des1;
    }

    /**
     * @return the des2
     */
    public String getDes2() {
        return des2;
    }

    /**
     * @param des2 the des2 to set
     */
    public void setDes2(String des2) {
        this.des2 = des2;
    }

    /**
     * @return the descripciones1
     */
    public String getDescripciones1() {
        return descripciones1;
    }

    /**
     * @param descripciones1 the descripciones1 to set
     */
    public void setDescripciones1(String descripciones1) {
        this.descripciones1 = descripciones1;
    }

    /**
     * @return the descripciones2
     */
    public String getDescripciones2() {
        return descripciones2;
    }

    /**
     * @param descripciones2 the descripciones2 to set
     */
    public void setDescripciones2(String descripciones2) {
        this.descripciones2 = descripciones2;
    }

    /**
     * @return the sumcomtmp
     */
    public String getSumcomtmp() {
        return sumcomtmp;
    }

    /**
     * @param sumcomtmp the sumcomtmp to set
     */
    public void setSumcomtmp(String sumcomtmp) {
        this.sumcomtmp = sumcomtmp;
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the fechalit
     */
    public String getFechalit() {
        return fechalit;
    }

    /**
     * @param fechalit the fechalit to set
     */
    public void setFechalit(String fechalit) {
        this.fechalit = fechalit;
    }

    /**
     * @return the fechahrs
     */
    public String getFechahrs() {
        return fechahrs;
    }

    /**
     * @param fechahrs the fechahrs to set
     */
    public void setFechahrs(String fechahrs) {
        this.fechahrs = fechahrs;
    }

    /**
     * @return the disponible
     */
    public String getDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

   
}
