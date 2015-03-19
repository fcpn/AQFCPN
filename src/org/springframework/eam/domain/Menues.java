package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.*;

public class Menues implements Serializable {
    
    /* ATRIBUTOS */
    
// SECCION DE LA TABLA CATEGORIAS
    private String id_programa;
    private String id_categoria;
    private String categoria;
    private String imagen;
    private String id_usuario;
    private String id_rol;
    private List enlaces;
    
// SECCION DE LA TABLA ENLACES
    private int     id_enlace;
    private String  nombre_enlace;
    private String  ruta_enlace;
    private int     orden;		// AUMENTADO POR TARIJA
    
// SECCION DE LA TABLA MENUS
    private Date fec_registro;
    private String ult_usuario;
    
    private Date   fec_activacion;
    private Date   fec_desactivacion;
    private String id_estado;
    
    /*  PROPIEDADES */
    
// SECCION DE LA TABLA CATEGORIAS
    
    public String getId_programa() { return id_programa;  }
    public void setId_programa(String id_programa) { this.id_programa = id_programa; }
    
    public String getId_categoria() { return id_categoria; }
    public void setId_categoria(String id_categoria) {
        id_categoria = id_categoria.toLowerCase();
        this.id_categoria = id_categoria;
    }
    
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) {
        categoria = categoria.toUpperCase();
        this.categoria = categoria.trim();
    }
    
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen.trim(); }
    
    public String getId_usuario() { return id_usuario; }
    public void setId_usuario(String id_usuario) { this.id_usuario = id_usuario.trim(); }
    
    public String getId_rol() { return id_rol; }
    public void setId_rol(String id_rol) { this.id_rol = id_rol.trim(); }
    
    public List getEnlaces() { return enlaces; }
    public void setEnlaces(List enlaces) { this.enlaces = enlaces; }
    
// SECCION DE LA TABLA ENLACES
    public int getId_enlace() { return id_enlace; }
    public void setId_enlace(int id_enlace) { this.id_enlace = id_enlace; }
    
    public String getNombre_enlace() { return nombre_enlace; }
    public void setNombre_enlace(String nombre_enlace) { this.nombre_enlace = nombre_enlace; }
    
    public String getRuta_enlace() { return ruta_enlace; }
    public void setRuta_enlace(String ruta_enlace) { this.ruta_enlace = ruta_enlace; }
    
    // AUMENTADO POR TARIJA
    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }
    
    // FIN AUMENTADO POR TARIJA
    
// SECCION DE LA TABLA MENUES
    public Date getFec_registro(){ return fec_registro; }
    public void setFec_registro(Date fec_registro){ this.fec_registro = fec_registro; }
    
    public String getUlt_usuario() { return ult_usuario; }
    public void setUlt_usuario(String ult_usuario) { this.ult_usuario = ult_usuario.trim(); }
    
    /*************************/
    
    public String getId_estado() { return id_estado; }
    public void setId_estado(String id_estado) { this.id_estado = id_estado.trim(); }
    
    public Date getFec_activacion(){ return fec_activacion; }
    public void setFec_activacion(Date fec_activacion){ this.fec_activacion = fec_activacion; }
    
    public Date getFec_desactivacion(){ return fec_desactivacion; }
    public void setFec_desactivacion(Date fec_desactivacion){ this.fec_desactivacion = fec_desactivacion; }
    
    
}