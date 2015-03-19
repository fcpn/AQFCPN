package org.springframework.eam.domain; 


import java.io.Serializable;
import java.util.Date;

public class Personas extends Registro {

  /* ATRIBUTOS */
  private String  id_persona;
  private String  dip;
  private String  nombre_completo;
  private String  paterno;
  private String  materno;
  private String  nombres;
  private String  id_sexo;
  private String  sexo;
  private String  departamento;
  private String  provincia;
  private String  localidad;
  private String  direccion;
  private String  pais;
  private String  colegio;
  private String  turno;   
  private String  tipo_colegio; 
  private String  nro_documento;
  private String  observacion;
  private String  zona;
  private String  tipo_sanguineo;
  private String  ciudad;
  private int     id_departamento;
  private int     id_pais;
  private String  telefono;
  private int     id_zona;
  private Date    fec_nacimiento;
  private String  correo;
  private int     id_estado_civil;
  private String  estado_civil;
  private int     id_tipo_aprobacion;
  private String  id_grado;
  
/*
  private int  id_colegio;
  private int  id_turno;
  private int  id_tipo_colegio;

DATOS SOCIALES
  private int id_ocupacion_padre;
  private int id_ocupacion_madre;
  private int id_ocupacion;
  private String ocupacion;

  private int    anio_titulacion;
  private String titulo;
  private int id_universidad;
  private String universidad;
  private float carga_horaria;
*/

/* Transcripciones   */  
  
 private int     cod_nacionalidad;
 private String  descripcion;
 private int     cod_estcivil;
 private int     cod_profesion;
 private int     cod_filiacion;
 
 private String cod_grp;
 private String cod_grp1;
 private String cod_grp2;
 private String cod_grp3;
 private String cod_grp4;
 private String cod_grp5;
 private int score; 
 
 /* PROPIEDADES*/  

 /* Transcripciones   */  
  public int getScore() { return score; }
  public void setScore(int score) { this.score = score; }
 
  public String getCod_grp() { return cod_grp; }
  public void setCod_grp(String cod_grp) { this.cod_grp = cod_grp; }
  
  public String getCod_grp1() { return cod_grp1; }
  public void setCod_grp1(String cod_grp1) { this.cod_grp1 = cod_grp1; }
  
  public String getCod_grp2() { return cod_grp2; }
  public void setCod_grp2(String cod_grp2) { this.cod_grp2 = cod_grp2; }
  
  public String getCod_grp3() { return cod_grp3; }
  public void setCod_grp3(String cod_grp3) { this.cod_grp3 = cod_grp3; }
  
  public String getCod_grp4() { return cod_grp4; }
  public void setCod_grp4(String cod_grp4) { this.cod_grp4 = cod_grp4; }
  
  public String getCod_grp5() { return cod_grp5; }
  public void setCod_grp5(String cod_grp5) { this.cod_grp5 = cod_grp5; }
  
  public int getCod_nacionalidad() { return cod_nacionalidad; }
  public void setCod_nacionalidad(int cod_nacionalidad) { this.cod_nacionalidad = cod_nacionalidad; }
 
  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }


  public int getCod_estcivil() { return cod_estcivil; }
  public void setCod_estcivil(int cod_estcivil) { this.cod_estcivil = cod_estcivil; }
  
  public int getCod_profesion() { return cod_profesion; }
  public void setCod_profesion(int cod_profesion) { this.cod_profesion = cod_profesion; }
  
  public int getCod_filiacion() { return cod_filiacion; }
  public void setCod_filiacion(int cod_filiacion) { this.cod_filiacion = cod_filiacion; }
  
  
  /*  End Transcripciones   */  
 
  public String getNombre_completo() { return nombre_completo; }
  public void setNombre_completo(String nombre_completo) { this.nombre_completo = nombre_completo; }
  
  public int getId_tipo_aprobacion() { return id_tipo_aprobacion; }
  public void setId_tipo_aprobacion(int id_tipo_aprobacion) { this.id_tipo_aprobacion = id_tipo_aprobacion; }

  public String getId_grado() { return id_grado; }
  public void setId_grado(String id_grado) { this.id_grado = id_grado; }
    
  public String getCorreo() { return correo; }
  public void setCorreo(String correo ) { this.correo = correo.trim(); }

  public int getId_estado_civil() { return id_estado_civil; }
  public void setId_estado_civil(int id_estado_civil) { this.id_estado_civil = id_estado_civil; }
  
  public String getEstado_civil() { return estado_civil; }
  public void setEstado_civil(String estado_civil) { this.estado_civil = estado_civil.trim(); } 

  public String getTipo_sanguineo() { return tipo_sanguineo; }
  public void setTipo_sanguineo(String tipo_sanguineo) { this.tipo_sanguineo = tipo_sanguineo.trim(); }

  public String getId_persona() { return id_persona; }
  public void setId_persona(String id_persona) { this.id_persona = id_persona; }
  
  public String getDip() { return dip; }
  public void setDip(String dip) { this.dip = dip.trim(); }
  
  public String getPaterno() { return paterno; }
  public void setPaterno(String paterno) { 
    paterno = paterno.toUpperCase();
  this.paterno = paterno.trim(); }
  
  public String getMaterno() { return materno; }
  public void setMaterno(String materno) { 
    materno = materno.toUpperCase();
  this.materno = materno.trim(); }
  
  public String getNombres() { return nombres; }
  public void setNombres(String nombres) {
    nombres = nombres.toUpperCase();
  this.nombres = nombres.trim(); }  
     
  public String getId_sexo() { return id_sexo; }
  public void setId_sexo(String id_sexo) { this.id_sexo = id_sexo; }
  
  public String getSexo() { return sexo; }
  public void setSexo(String sexo) { this.sexo = sexo; } 
  
  public Date getFec_nacimiento() { return fec_nacimiento; }
  public void setFec_nacimiento(Date fec_nacimiento) { this.fec_nacimiento = fec_nacimiento; }  
  
  public int getId_pais() { return id_pais; }
  public void setId_pais(int id_pais) { this.id_pais = id_pais; }
  
  public String getPais() { return pais; }
  public void setPais(String pais) { this.pais = pais; }  
  
  public int getId_departamento() { return id_departamento; }
  public void setId_departamento(int id_departamento) { this.id_departamento = id_departamento; }
  
  public String getDepartamento() { return departamento; }
  public void setDepartamento(String departamento) {
    departamento = departamento.toUpperCase();
   this.departamento = departamento; }   

  public String getProvincia() { return provincia; }
  public void setProvincia(String provincia) {
    provincia = provincia.toUpperCase();
   this.provincia = provincia.trim(); }  

  public String getLocalidad() { return localidad; }
  public void setLocalidad(String localidad) { 
    localidad = localidad.toUpperCase();
  this.localidad = localidad.trim(); }

  public String getDireccion() { return direccion; }
  public void setDireccion(String direccion) { 
    direccion = direccion.toUpperCase();
  this.direccion = direccion.trim(); }

  public String getTelefono() { return telefono; }
  public void setTelefono(String telefono) { this.telefono = telefono; }
  
  
  public String getColegio() { return colegio; }
  public void setColegio(String colegio) { this.colegio = colegio.trim(); }
    
  public String getTurno() { return turno; }
  public void setTurno(String turno) { this.turno = turno.trim(); }

  public String getTipo_colegio() { return tipo_colegio; }
  public void setTipo_colegio(String tipo_colegio) { this.tipo_colegio = tipo_colegio.trim(); }
  
  public int getId_zona() { return id_zona; }
  public void setId_zona(int id_zona) { this.id_zona = id_zona; }       
  
  public String getZona() { return zona; }
  public void setZona(String zona) { this.zona = zona; }       
   
  public void setCiudad(String ciudad){
    this.ciudad = ciudad;
  }

  public String getCiudad(){
    return ciudad;
  }
  
/*DATOS SOCIALES
  public int getId_ocupacion_padre() { return id_ocupacion_padre; }
  public void setId_ocupacion_padre(int id_ocupacion_padre) { this.id_ocupacion_padre = id_ocupacion_padre ; }
  
  public int getId_ocupacion_madre() { return id_ocupacion_madre; }
  public void setId_ocupacion_madre(int id_ocupacion_madre) { this.id_ocupacion_madre = id_ocupacion_madre ; }
  
  public int getId_ocupacion() { return id_ocupacion; }
  public void setId_ocupacion(int id_ocupacion) { this.id_ocupacion = id_ocupacion; }
  
  public String getOcupacion() { return ocupacion; }
  public void setOcupacion(String ocupacion) { this.ocupacion = ocupacion.trim(); }

   public int getAnio_titulacion(){return anio_titulacion;
  }
  public void setAnio_titulacion(int anio_titulacion){
    this.anio_titulacion = anio_titulacion;
  }

  public String getTitulo(){
    return titulo;
  }
  public void setTitulo(String titulo){
    this.titulo = titulo;
  }
  
  public int getId_universidad(){
    return id_universidad;
  }
  public void setId_universidad(int id_universidad){
    this.id_universidad = id_universidad;
  }
  public float getCarga_horaria(){
    return carga_horaria;
  }
  public void setCarga_horaria(float carga_horaria){
    this.carga_horaria = carga_horaria;
  }

  public int getId_colegio() { return id_colegio; }
  public void setId_colegio(int id_colegio) { this.id_colegio = id_colegio; }
  
    public int getId_turno() { return id_turno; }
  public void setId_turno(int id_turno) { this.id_turno = id_turno; }
  
  public int getId_tipo_colegio() { return id_tipo_colegio; }
  public void setId_tipo_colegio(int id_tipo_colegio) { this.id_tipo_colegio = id_tipo_colegio; }

  public String getId_programa() { return id_programa; }
  public void setId_programa(String id_programa) { this.id_programa = id_programa; }
  
  public String getPrograma() { return programa; }
  public void setPrograma(String programa) { this.programa = programa; }
  
 */



}

