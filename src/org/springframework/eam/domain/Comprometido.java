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



public class Comprometido implements Serializable {
    private String glosa;//tambien formularios
    private String monto;//tambien formularios
    private String tipcambio;
    private String codtar;//tambien formularios
    private String codfueneco;//tambien formularios
    private String codmonegr; //tambien formularios
    private String id;    //tambien Formularios
    private String fecha;//tambien formularios
    private String ref123;
    private String obs;
    private String i_e;
    private String num_sol;//tambien formularios
    private String cantidad;//tambien formularios
    private String responsable;//tambien formularios
    private String fechalit;//tambien formularios
    private String fechahrs;//tambien formularios
    private String glo_rut;//tambien formularios
    private String culmi_anula;//tambien formularios
    private String correlativo_unidad;//tambien formularios
    private String destino;//tambien formularios
    private String uni_medida;//tambien formularios
    private String descripcion;
    private String lik;
    private String nit_proveedor;
    private String direccion;
    private String telefonos;
    private String id_sucursal;
    private String correlativo_orden_compra;
    private String uni;
    private String cheque;
    private String cbte;
    private String fecha_cbte;
    private String factura;
    private String fecha_factura;
    private String fecha_ing_material;
    private String correlativo_ing_material;
    private String id_usuario_certificado;

    public String getId_usuario_certificado() {
        return id_usuario_certificado;
    }

    public void setId_usuario_certificado(String id_usuario_certificado) {
        this.id_usuario_certificado = id_usuario_certificado;
    }

    public String getCorrelativo_ing_material() {
        return correlativo_ing_material;
    }

    public void setCorrelativo_ing_material(String correlativo_ing_material) {
        this.correlativo_ing_material = correlativo_ing_material;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getFecha_cbte() {
        return fecha_cbte;
    }

    public void setFecha_cbte(String fecha_cbte) {
        this.fecha_cbte = fecha_cbte;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public String getFecha_ing_material() {
        return fecha_ing_material;
    }

    public void setFecha_ing_material(String fecha_ing_material) {
        this.fecha_ing_material = fecha_ing_material;
    }

    public String getCbte() {
        return cbte;
    }

    public void setCbte(String cbte) {
        this.cbte = cbte;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }


    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }
        
    public String getCorrelativo_orden_compra() {
        return correlativo_orden_compra;
    }

    public void setCorrelativo_orden_compra(String correlativo_orden_compra) {
        this.correlativo_orden_compra = correlativo_orden_compra;
    }

    public String getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(String id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit_proveedor() {
        return nit_proveedor;
    }

    public void setNit_proveedor(String nit_proveedor) {
        this.nit_proveedor = nit_proveedor;
    }

    private String nit;
    private String proveedor;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getLik() {
        return lik;
    }

    public void setLik(String lik) {
        this.lik = lik;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getTipcambio() {
        return tipcambio;
    }

    public void setTipcambio(String tipcambio) {
        this.tipcambio = tipcambio;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRef123() {
        return ref123;
    }

    public void setRef123(String ref123) {
        this.ref123 = ref123;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getI_e() {
        return i_e;
    }

    public void setI_e(String i_e) {
        this.i_e = i_e;
    }

    public String getNum_sol() {
        return num_sol;
    }

    public void setNum_sol(String num_sol) {
        this.num_sol = num_sol;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFechalit() {
        return fechalit;
    }

    public void setFechalit(String fechalit) {
        this.fechalit = fechalit;
    }

    public String getFechahrs() {
        return fechahrs;
    }

    public void setFechahrs(String fechahrs) {
        this.fechahrs = fechahrs;
    }

    public String getGlo_rut() {
        return glo_rut;
    }

    public void setGlo_rut(String glo_rut) {
        this.glo_rut = glo_rut;
    }

    public String getCulmi_anula() {
        return culmi_anula;
    }

    public void setCulmi_anula(String culmi_anula) {
        this.culmi_anula = culmi_anula;
    }

    public String getCorrelativo_unidad() {
        return correlativo_unidad;
    }

    public void setCorrelativo_unidad(String correlativo_unidad) {
        this.correlativo_unidad = correlativo_unidad;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getUni_medida() {
        return uni_medida;
    }

    public void setUni_medida(String uni_medida) {
        this.uni_medida = uni_medida;
    }

    
}
