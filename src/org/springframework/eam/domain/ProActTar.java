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

public class ProActTar implements Serializable {

    private String codpro;
    private String codpro2;
    private String codigo;
    private String descripcion;
    private String u_ejecutora;
    private String codacti;
    private String apertura_prog;
    private String codtar;
    private String codfueneco;
    private String correlativo;
    private String aper_prog2;
    private String aper_prog;
    private String idcarrera;

    private String fecha_act;
    private String num_tarea;
    private String des_actividad;
    private String dia;
    private String mes;
    private String anio;
    private String id;
    private String i_e;
    private String fecha;
    private String monto;
    private String fechanum;
    private String fechanum0;
    private String correlativo_unidad;
    private String correlativo_orden_compra;
    private String correlativo_ing_material;

    private Double totalmontoejecutadoingreso;
    private Double totalmontoejecutadoegreso;
    private Double totalmontocomprometido;

    public Double getTotalmontoejecutadoingreso() {
        return totalmontoejecutadoingreso;
    }

    public void setTotalmontoejecutadoingreso(Double totalmontoejecutadoingreso) {
        this.totalmontoejecutadoingreso = totalmontoejecutadoingreso;
    }

    public Double getTotalmontoejecutadoegreso() {
        return totalmontoejecutadoegreso;
    }

    public void setTotalmontoejecutadoegreso(Double totalmontoejecutadoegreso) {
        this.totalmontoejecutadoegreso = totalmontoejecutadoegreso;
    }

    public Double getTotalmontocomprometido() {
        return totalmontocomprometido;
    }

    public void setTotalmontocomprometido(Double totalmontocomprometido) {
        this.totalmontocomprometido = totalmontocomprometido;
    }

    public String getCorrelativo_ing_material() {
        return correlativo_ing_material;
    }

    public void setCorrelativo_ing_material(String correlativo_ing_material) {
        this.correlativo_ing_material = correlativo_ing_material;
    }

    public String getCorrelativo_orden_compra() {
        return correlativo_orden_compra;
    }

    public void setCorrelativo_orden_compra(String correlativo_orden_compra) {
        this.correlativo_orden_compra = correlativo_orden_compra;
    }

    private String i_c;
    private String codtar2;

    public String getCodpro() {
        return codpro;
    }

    public void setCodpro(String codpro) {
        this.codpro = codpro;
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

    public String getU_ejecutora() {
        return u_ejecutora;
    }

    public void setU_ejecutora(String u_ejecutora) {
        this.u_ejecutora = u_ejecutora;
    }

    public String getCodacti() {
        return codacti;
    }

    public void setCodacti(String codacti) {
        this.codacti = codacti;
    }

    public String getApertura_prog() {
        return apertura_prog;
    }

    public void setApertura_prog(String apertura_prog) {
        this.apertura_prog = apertura_prog;
    }

    public String getCodtar() {
        return codtar;
    }

    public void setCodtar(String codtar) {
        this.codtar = codtar;
    }

    public String getCodfueneco() {
        return codfueneco;
    }

    public void setCodfueneco(String codfueneco) {
        this.codfueneco = codfueneco;
    }

    public String getFecha_act() {
        return fecha_act;
    }

    public void setFecha_act(String fecha_act) {
        this.fecha_act = fecha_act;
    }

    /**
     * @return the idcarrera
     */
    public String getIdcarrera() {
        return idcarrera;
    }

    /**
     * @param idcarrera the idcarrera to set
     */
    public void setIdcarrera(String idcarrera) {
        this.idcarrera = idcarrera;
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
     * @return the num_tarea
     */
    public String getNum_tarea() {
        return num_tarea;
    }

    /**
     * @param num_tarea the num_tarea to set
     */
    public void setNum_tarea(String num_tarea) {
        this.num_tarea = num_tarea;
    }

    /**
     * @return the des_actividad
     */
    public String getDes_actividad() {
        return des_actividad;
    }

    /**
     * @param des_actividad the des_actividad to set
     */
    public void setDes_actividad(String des_actividad) {
        this.des_actividad = des_actividad;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(String anio) {
        this.anio = anio;
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
     * @return the fechasum
     */
    public String getFechanum() {
        return fechanum;
    }

    /**
     * @param fechacom the fechasum to set
     */
    public void setFechanum(String fechanum) {
        this.fechanum = fechanum;
    }

    /**
     * @return the i_c
     */
    public String getI_c() {
        return i_c;
    }

    /**
     * @param i_c the i_c to set
     */
    public void setI_c(String i_c) {
        this.i_c = i_c;
    }

    /**
     * @return the fechanum0
     */
    public String getFechanum0() {
        return fechanum0;
    }

    /**
     * @param fechanum0 the fechanum0 to set
     */
    public void setFechanum0(String fechanum0) {
        this.fechanum0 = fechanum0;
    }

    /**
     * @return the codtar2
     */
    public String getCodtar2() {
        return codtar2;
    }

    /**
     * @param codtar2 the codtar2 to set
     */
    public void setCodtar2(String codtar2) {
        this.codtar2 = codtar2;
    }

    /**
     * @return the aper_prog2
     */
    public String getAper_prog2() {
        return aper_prog2;
    }

    /**
     * @param aper_prog2 the aper_prog2 to set
     */
    public void setAper_prog2(String aper_prog2) {
        this.aper_prog2 = aper_prog2;
    }

    /**
     * @return the aper_prog
     */
    public String getAper_prog() {
        return aper_prog;
    }

    /**
     * @param aper_prog the aper_prog to set
     */
    public void setAper_prog(String aper_prog) {
        this.aper_prog = aper_prog;
    }

    /**
     * @return the codpro2
     */
    public String getCodpro2() {
        return codpro2;
    }

    /**
     * @param codpro2 the codpro2 to set
     */
    public void setCodpro2(String codpro2) {
        this.codpro2 = codpro2;
    }

    /**
     * @return the correlativo_unidad
     */
    public String getCorrelativo_unidad() {
        return correlativo_unidad;
    }

    /**
     * @param correlativo_unidad the correlativo_unidad to set
     */
    public void setCorrelativo_unidad(String correlativo_unidad) {
        this.correlativo_unidad = correlativo_unidad;
    }

    /**
     * @return the idcarreras
     */
}
