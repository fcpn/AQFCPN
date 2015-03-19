package org.springframework.eam.domain; 


import java.io.Serializable;
import java.util.Date;
import org.springframework.eam.domain.Documentos;

public class Documentos extends Personas {

  /* ATRIBUTOS */
    private String id_documento ;
    private int id_est_documento ;
    private String  tipo_documento;
    private int  id_tipo_documento;
    private String documento;
    private String obligatorio;
    private int nro_requisito;
    private String nro_documento;
    private String observacion;
    private Date fec_emision;
    private String  id_estudiante;
    private String  id_programa;
    private String  id_existencia;
    private String  id_tipo_existencia;
    private String  tipo_existencia;
    private String  nombre_digital;
    private String  ruta_documento;
    private int    gestion;
    private int    periodo;



  /* PROPIEDADES*/

   public int getGestion(){
    return gestion;
  }
  public void setGestion(int gestion){
    this.gestion = gestion;
  }
  public int getPeriodo(){
    return periodo;
  }
  public void setPeriodo(int periodo){
    this.periodo = periodo;
  }


  public String getId_documento() { return id_documento; }
  public void setId_documento(String id_documento) { this.id_documento = id_documento; }
  
  public int getId_est_documento() { return id_est_documento; }
  public void setId_est_documento(int id_est_documento) { this.id_est_documento = id_est_documento; }
  
  public String getTipo_documento() { return tipo_documento; }
  public void setTipo_documento(String tipo_documento) { this.tipo_documento = tipo_documento; }  

  public int getId_tipo_documento() { return id_tipo_documento; }
  public void setId_tipo_documento(int id_tipo_documento) { this.id_tipo_documento = id_tipo_documento; }

  public String getDocumento() { return documento; }
  public void setDocumento(String documento) { this.documento = documento; }  

  public String getObligatorio() { return obligatorio; }
  public void setObligatorio(String obligatorio) { this.obligatorio = obligatorio; } 
  
  public int getNro_requisito() { return nro_requisito; }
  public void setNro_requisito(int nro_requisito) { this.nro_requisito = nro_requisito; } 

  public String getNro_documento() { return nro_documento; }
  public void setNro_documento(String nro_documento) { this.nro_documento = nro_documento; } 
  
  public String getObservacion() { return observacion; }
  public void setObservacion(String observacion) { this.observacion = observacion; }  
  
  public Date getFec_emision() {return fec_emision; }
  public void setFec_emision(Date fec_emision) {this.fec_emision = fec_emision;}

  public String getId_estudiante() { return id_estudiante; }
  public void setId_estudiante(String id_estudiante) { this.id_estudiante = id_estudiante; }
  
  public String getId_programa() { return id_programa;  }
  public void setId_programa(String id_programa) { this.id_programa = id_programa; }
  
  public String getId_existencia() { return id_existencia;  }
  public void setId_existencia(String id_existencia) { this.id_existencia = id_existencia; }

  public String getId_tipo_existencia() { return id_tipo_existencia;  }
  public void setId_tipo_existencia(String id_tipo_existencia) { this.id_tipo_existencia = id_tipo_existencia; }
  
  public String getTipo_existencia() { return tipo_existencia;  }
  public void setTipo_existencia(String tipo_existencia) { this.tipo_existencia = tipo_existencia; }
  
  public String getNombre_digital() { return nombre_digital;  }
  public void setNombre_digital(String nombre_digital) { this.nombre_digital = nombre_digital; }

  public String getRuta_documento() { return ruta_documento;  }
  public void setRuta_documento(String ruta_documento) { this.ruta_documento = ruta_documento; }

//*  --------completar .......metodos
  
}














