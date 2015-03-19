/*
 * Tarjeta.java
 *
 * Created on 13 de julio de 2007, 15:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.springframework.eam.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class Tarjeta extends Registro{

// tarjeta
private String id_tarjeta;
private String sexo;
private String libro;
private String folio;
private String revisor;
private String nacionalidad;
private String pais;
private String departamento;
private String provincia;
private String localidad;
private String fec_nacimiento;
private String crt_nac_anio;
private String padre_ap_paterno;
private String padre_ap_materno;
private String padre_nombre1;
private String padre_nombre2;
private String padre_nombre3;
private String madre_ap_paterno;
private String madre_ap_materno;
private String madre_nombre1;
private String madre_nombre2;
private String madre_nombre3;
private String lee;
private String escribe;
private String estado_civil;
private String cony_ap_paterno;
private String cony_ap_materno;
private String cony_nombre1;
private String cony_nombre2;
private String cony_nombre3;
private String servicio_militar;
private String profesion;
private String senias_particulares;
private String grupo_sanguineo;
private String serie;
private String seccion;
private String causa_filiacion;
private String comentario_a;
private String comentario_r;
private String id_tipo_tarjeta;
private String pasaporte;
private String pste_otorgado;
private String pste_visado;
private String pste_fecha;
private String pste_otra_residencia;
private String nombre_supuesto;
private String nro_penal;
private String nro_censo;
private String radicatoria;
private String permanencia;
private String usr_transcriptor;
private String usr_verificador;
/*
 *   Personas Fil
 */
private String id_persona;
private String cedula;
private String id_sexo;
private String ap_paterno;
private String ap_materno;
private String nombre1;
private String nombre2;
private String nombre3;
private String id_pais;
private String codigo_compuesto;
private String nac_dia;
private String nac_mes;
private String nac_anio;
private int id_lee;
private int id_escribe;
private int id_estado_civil;
private String nro_libreta;
private int altura;
private int id_grupo_sanguineo;
private int id_causa_filiacion;
private String dom_localidad;
private String zona;
private String barrio;
private String calle;
private String nro_casa;
/*
 *   Listas
 */ 
private List ocupaciones;
private List parientes;
private List relaciones;
private List tramites;
private List registro_civil;
/*
 *   Extras
 */
private String cod_img;
private String clave;
private String codigo;
private String id_departamento;
private String id_provincia;
private String ofic_rcn;
private String libro_no;
private String partida_no;
private String crt_dia;
private String crt_mes;
private String crt_anio;
private String ofic_rcn_cony;
private String partida_no_cony;
private String libro_no_cony;
private String anio_cony;
private String cony_dia;
private String cony_mes;
private String cony_anio;
private String nro_huellas_a;
private String nro_huellas_r;
private String id_localidad;
private String codigo_ocupacion;
private String id_pariente;
private String id_tramite;
private String direccion;
private String ubicacion;
/*
 *   Ajax
 */
private String dato;
private String columna;
private String cod_registro;
private String id_usuario;
private String cod_parentesco;
private String descripcion;
private String cod_tramite;
private String cod_relaciones ;
private String cod_parientes ;

/*
 * Supervision
 */
private String id_estado;
private int calificacion;

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(String id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFec_nacimiento() {
        return fec_nacimiento;
    }

    public void setFec_nacimiento(String fec_nacimiento) {
        this.fec_nacimiento = fec_nacimiento;
    }

    public String getCrt_nac_anio() {
        return crt_nac_anio;
    }

    public void setCrt_nac_anio(String crt_nac_anio) {
        this.crt_nac_anio = crt_nac_anio;
    }

    public String getPadre_ap_paterno() {
        return padre_ap_paterno;
    }

    public void setPadre_ap_paterno(String padre_ap_paterno) {
        this.padre_ap_paterno = padre_ap_paterno;
    }

    public String getPadre_ap_materno() {
        return padre_ap_materno;
    }

    public void setPadre_ap_materno(String padre_ap_materno) {
        this.padre_ap_materno = padre_ap_materno;
    }

    public String getPadre_nombre1() {
        return padre_nombre1;
    }

    public void setPadre_nombre1(String padre_nombre1) {
        this.padre_nombre1 = padre_nombre1;
    }

    public String getPadre_nombre2() {
        return padre_nombre2;
    }

    public void setPadre_nombre2(String padre_nombre2) {
        this.padre_nombre2 = padre_nombre2;
    }

    public String getPadre_nombre3() {
        return padre_nombre3;
    }

    public void setPadre_nombre3(String padre_nombre3) {
        this.padre_nombre3 = padre_nombre3;
    }

    public String getMadre_ap_paterno() {
        return madre_ap_paterno;
    }

    public void setMadre_ap_paterno(String madre_ap_paterno) {
        this.madre_ap_paterno = madre_ap_paterno;
    }

    public String getMadre_ap_materno() {
        return madre_ap_materno;
    }

    public void setMadre_ap_materno(String madre_ap_materno) {
        this.madre_ap_materno = madre_ap_materno;
    }

    public String getMadre_nombre1() {
        return madre_nombre1;
    }

    public void setMadre_nombre1(String madre_nombre1) {
        this.madre_nombre1 = madre_nombre1;
    }

    public String getMadre_nombre2() {
        return madre_nombre2;
    }

    public void setMadre_nombre2(String madre_nombre2) {
        this.madre_nombre2 = madre_nombre2;
    }

    public String getMadre_nombre3() {
        return madre_nombre3;
    }

    public void setMadre_nombre3(String madre_nombre3) {
        this.madre_nombre3 = madre_nombre3;
    }

    public String getLee() {
        return lee;
    }

    public void setLee(String lee) {
        this.lee = lee;
    }

    public String getEscribe() {
        return escribe;
    }

    public void setEscribe(String escribe) {
        this.escribe = escribe;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getCony_ap_paterno() {
        return cony_ap_paterno;
    }

    public void setCony_ap_paterno(String cony_ap_paterno) {
        this.cony_ap_paterno = cony_ap_paterno;
    }

    public String getCony_ap_materno() {
        return cony_ap_materno;
    }

    public void setCony_ap_materno(String cony_ap_materno) {
        this.cony_ap_materno = cony_ap_materno;
    }

    public String getCony_nombre1() {
        return cony_nombre1;
    }

    public void setCony_nombre1(String cony_nombre1) {
        this.cony_nombre1 = cony_nombre1;
    }

    public String getCony_nombre2() {
        return cony_nombre2;
    }

    public void setCony_nombre2(String cony_nombre2) {
        this.cony_nombre2 = cony_nombre2;
    }

    public String getCony_nombre3() {
        return cony_nombre3;
    }

    public void setCony_nombre3(String cony_nombre3) {
        this.cony_nombre3 = cony_nombre3;
    }

    public String getServicio_militar() {
        return servicio_militar;
    }

    public void setServicio_militar(String servicio_militar) {
        this.servicio_militar = servicio_militar;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getSenias_particulares() {
        return senias_particulares;
    }

    public void setSenias_particulares(String senias_particulares) {
        this.senias_particulares = senias_particulares;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCausa_filiacion() {
        return causa_filiacion;
    }

    public void setCausa_filiacion(String causa_filiacion) {
        this.causa_filiacion = causa_filiacion;
    }

    public String getComentario_a() {
        return comentario_a;
    }

    public void setComentario_a(String comentario_a) {
        this.comentario_a = comentario_a;
    }

    public String getComentario_r() {
        return comentario_r;
    }

    public void setComentario_r(String comentario_r) {
        this.comentario_r = comentario_r;
    }

    public String getId_tipo_tarjeta() {
        return id_tipo_tarjeta;
    }

    public void setId_tipo_tarjeta(String id_tipo_tarjeta) {
        this.id_tipo_tarjeta = id_tipo_tarjeta;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getPste_otorgado() {
        return pste_otorgado;
    }

    public void setPste_otorgado(String pste_otorgado) {
        this.pste_otorgado = pste_otorgado;
    }

    public String getPste_visado() {
        return pste_visado;
    }

    public void setPste_visado(String pste_visado) {
        this.pste_visado = pste_visado;
    }

    public String getPste_fecha() {
        return pste_fecha;
    }

    public void setPste_fecha(String pste_fecha) {
        this.pste_fecha = pste_fecha;
    }

    public String getPste_otra_residencia() {
        return pste_otra_residencia;
    }

    public void setPste_otra_residencia(String pste_otra_residencia) {
        this.pste_otra_residencia = pste_otra_residencia;
    }

    public String getNombre_supuesto() {
        return nombre_supuesto;
    }

    public void setNombre_supuesto(String nombre_supuesto) {
        this.nombre_supuesto = nombre_supuesto;
    }

    public String getNro_penal() {
        return nro_penal;
    }

    public void setNro_penal(String nro_penal) {
        this.nro_penal = nro_penal;
    }

    public String getNro_censo() {
        return nro_censo;
    }

    public void setNro_censo(String nro_censo) {
        this.nro_censo = nro_censo;
    }

    public String getRadicatoria() {
        return radicatoria;
    }

    public void setRadicatoria(String radicatoria) {
        this.radicatoria = radicatoria;
    }

    public String getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(String permanencia) {
        this.permanencia = permanencia;
    }

    public String getUsr_transcriptor() {
        return usr_transcriptor;
    }

    public void setUsr_transcriptor(String usr_transcriptor) {
        this.usr_transcriptor = usr_transcriptor;
    }

    public String getUsr_verificador() {
        return usr_verificador;
    }

    public void setUsr_verificador(String usr_verificador) {
        this.usr_verificador = usr_verificador;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(String id_sexo) {
        this.id_sexo = id_sexo;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getId_pais() {
        return id_pais;
    }

    public void setId_pais(String id_pais) {
        this.id_pais = id_pais;
    }

    public String getCodigo_compuesto() {
        return codigo_compuesto;
    }

    public void setCodigo_compuesto(String codigo_compuesto) {
        this.codigo_compuesto = codigo_compuesto;
    }

    public String getNac_dia() {
        return nac_dia;
    }

    public void setNac_dia(String nac_dia) {
        this.nac_dia = nac_dia;
    }

    public String getNac_mes() {
        return nac_mes;
    }

    public void setNac_mes(String nac_mes) {
        this.nac_mes = nac_mes;
    }

    public String getNac_anio() {
        return nac_anio;
    }

    public void setNac_anio(String nac_anio) {
        this.nac_anio = nac_anio;
    }

    public int getId_lee() {
        return id_lee;
    }

    public void setId_lee(int id_lee) {
        this.id_lee = id_lee;
    }

    public int getId_escribe() {
        return id_escribe;
    }

    public void setId_escribe(int id_escribe) {
        this.id_escribe = id_escribe;
    }

    public int getId_estado_civil() {
        return id_estado_civil;
    }

    public void setId_estado_civil(int id_estado_civil) {
        this.id_estado_civil = id_estado_civil;
    }

    public String getNro_libreta() {
        return nro_libreta;
    }

    public void setNro_libreta(String nro_libreta) {
        this.nro_libreta = nro_libreta;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getId_grupo_sanguineo() {
        return id_grupo_sanguineo;
    }

    public void setId_grupo_sanguineo(int id_grupo_sanguineo) {
        this.id_grupo_sanguineo = id_grupo_sanguineo;
    }

    public int getId_causa_filiacion() {
        return id_causa_filiacion;
    }

    public void setId_causa_filiacion(int id_causa_filiacion) {
        this.id_causa_filiacion = id_causa_filiacion;
    }

    public String getDom_localidad() {
        return dom_localidad;
    }

    public void setDom_localidad(String dom_localidad) {
        this.dom_localidad = dom_localidad;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNro_casa() {
        return nro_casa;
    }

    public void setNro_casa(String nro_casa) {
        this.nro_casa = nro_casa;
    }

    public List getOcupaciones() {
        return ocupaciones;
    }

    public void setOcupaciones(List ocupaciones) {
        this.ocupaciones = ocupaciones;
    }

    public List getParientes() {
        return parientes;
    }

    public void setParientes(List parientes) {
        this.parientes = parientes;
    }

    public List getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(List relaciones) {
        this.relaciones = relaciones;
    }

    public List getTramites() {
        return tramites;
    }

    public void setTramites(List tramites) {
        this.tramites = tramites;
    }

    public List getRegistro_civil() {
        return registro_civil;
    }

    public void setRegistro_civil(List registro_civil) {
        this.registro_civil = registro_civil;
    }

    public String getCod_img() {
        return cod_img;
    }

    public void setCod_img(String cod_img) {
        this.cod_img = cod_img;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getCod_registro() {
        return cod_registro;
    }

    public void setCod_registro(String cod_registro) {
        this.cod_registro = cod_registro;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCod_parentesco() {
        return cod_parentesco;
    }

    public void setCod_parentesco(String cod_parentesco) {
        this.cod_parentesco = cod_parentesco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCod_tramite() {
        return cod_tramite;
    }

    public void setCod_tramite(String cod_tramite) {
        this.cod_tramite = cod_tramite;
    }
    
    public String getId_estado() {
	return this.id_estado;
    }
    
    public void setId_estado(String id_estado) {
	this.id_estado = id_estado;
    }
    public String getCod_relaciones() {return cod_relaciones;}
    public void setCod_relaciones(String cod_relaciones) {this.cod_relaciones = cod_relaciones;}

    public String getCod_parientes() {return cod_parientes;}
    public void setCod_parientes(String cod_parientes) {this.cod_parientes = cod_parientes;}

    public String getId_departamento() {return id_departamento;}
    public void setId_departamento(String id_departamento) {this.id_departamento = id_departamento;}

    public String getId_provincia() {return id_provincia;}
    public void setId_provincia(String id_provincia) {this.id_provincia = id_provincia;}

    public String getOfic_rcn() {return ofic_rcn;}
    public void setOfic_rcn(String ofic_rcn) {this.ofic_rcn = ofic_rcn;}

    public String getLibro_no() {return libro_no;}
    public void setLibro_no(String libro_no) {this.libro_no = libro_no;}

    public String getPartida_no() {return partida_no;}
    public void setPartida_no(String partida_no) {this.partida_no = partida_no;}

    public String getCrt_dia() {return crt_dia;}
    public void setCrt_dia(String crt_dia) {this.crt_dia = crt_dia;}

    public String getCrt_mes() {return crt_mes;}
    public void setCrt_mes(String crt_mes) {this.crt_mes = crt_mes;}

    public String getCrt_anio() {return crt_anio;}
    public void setCrt_anio(String crt_anio) {this.crt_anio = crt_anio;}

    public String getOfic_rcn_cony() {
            return ofic_rcn_cony;
    }
		
    public void setOfic_rcn_cony(String ofic_rcn_cony) {
            this.ofic_rcn_cony = ofic_rcn_cony;
    }
				
    public String getPartida_no_cony() {
            return partida_no_cony;
    }
						
    public void setPartida_no_cony(String partida_no_cony) {
            this.partida_no_cony = partida_no_cony;
    }
								
    public String getLibro_no_cony() {
            return libro_no_cony;
    }
										
    public void setLibro_no_cony(String libro_no_cony) {
            this.libro_no_cony = libro_no_cony;
    }
												
    public String getAnio_cony() {
            return anio_cony;
    }
														
    public void setAnio_cony(String anio_cony) {
            this.anio_cony = anio_cony;
    }
																
    public String getCony_dia() {
            return cony_dia;
    }
																		
    public void setCony_dia(String cony_dia) {
            this.cony_dia = cony_dia;
    }
																				
    public String getCony_mes() {
            return cony_mes;
    }
																						
    public void setCony_mes(String cony_mes) {
            this.cony_mes = cony_mes;
    }
																								
    public String getCony_anio() {
            return cony_anio;
    }
																										
    public void setCony_anio(String cony_anio) {
            this.cony_anio = cony_anio;
    }

    public String getNro_huellas_a() {
            return nro_huellas_a;
    }
																										
    public void setNro_huellas_a(String nro_huellas_a) {
            this.nro_huellas_a = nro_huellas_a;
    }

    public String getNro_huellas_r() {
            return nro_huellas_r;
    }
																										
    public void setNro_huellas_r(String nro_huellas_r) {
            this.nro_huellas_r = nro_huellas_r;
    }

    public String getId_localidad() {
            return id_localidad;
    }
																										
    public void setId_localidad(String id_localidad) {
            this.id_localidad = id_localidad;
    }

    public String getCodigo_ocupacion() {
            return codigo_ocupacion;
    }
																										
    public void setCodigo_ocupacion(String codigo_ocupacion) {
            this.codigo_ocupacion = codigo_ocupacion;
    }

    public String getId_pariente() {
            return id_pariente;
    }
																										
    public void setId_pariente(String id_pariente) {
            this.id_pariente = id_pariente;
    }

    public String getId_tramite() {
            return id_tramite;
    }
																										
    public void setId_tramite(String id_tramite) {
            this.id_tramite = id_tramite;
    }

    public String getDireccion() {
            return direccion;
    }
																										
    public void setDireccion(String direccion) {
            this.direccion = direccion;
    }

    public String getUbicacion() {
            return ubicacion;
    }
																										
    public void setUbicacion(String direccion) {
            this.ubicacion = ubicacion;
    }
}



