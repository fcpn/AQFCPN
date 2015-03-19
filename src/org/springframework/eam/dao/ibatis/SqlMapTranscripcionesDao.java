/*
 * SqlMapTranscripcionesDao.java
 *
 * Created on 13 de julio de 2007, 18:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.springframework.eam.dao.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Time;
import java.util.StringTokenizer;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapDaoSupport;

import org.springframework.eam.dao.TranscripcionesDao;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Departamento;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.Tiempos;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Reporte;

import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.Administrativos;
/**
 *
 * @author Jesus
 */
public class SqlMapTranscripcionesDao extends SqlMapDaoSupport implements TranscripcionesDao{
    
    /** Creates a new instance of SqlMapTranscripcionesDao */
    public List getListaPais(Pais pais) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaPais", pais);
    }   
    public List getListaDepto(Departamento depto) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaDepto", depto);
    }

    public List getListaProvincia(Departamento provincia) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaProvincia", provincia);
    }

    public List getListaSeccion(Departamento seccion) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaSeccion", seccion);
    }
     
    public List getListaCanton(Departamento canton) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaCanton", canton);
    }
    
    public List getListaLocalidad(Departamento localidad) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaLocalidad", localidad);
    }
    
    public List getListaNacionalidad(Personas nacionalidad) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaNacionalidad", nacionalidad);
    }
    
    public List getListaEstcivil(Personas estcivil) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaEstcivil", estcivil);
    }
    
    public List getListaProfesion(Personas profesion) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaProfesion", profesion);
    }
    
    public List getListaFiliacion(Personas filiacion) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaFiliacion", filiacion);
    }
    
    
    public List getListaParientes(Tarjeta parientes) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaParientes", parientes);
    }

    public List getListaTramite(Tarjeta tramite) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaTramite", tramite);
    }
    
    public String getCodigoImg(Usuarios usuario) throws DataAccessException {
    System.out.println("888888888888 el usuario"+usuario.getId_usuario());
    return (String) getSqlMapTemplate().executeQueryForObject("getCodigoImg", usuario);
    }    
    
    public int setDatosTemporal(Tarjeta datos) throws DataAccessException {
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setDatosTemporal", datos);
     return i.intValue();
  }

   
    public List getListaGrupo(Personas parametros) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList(parametros.getDescripcion(),parametros);
    }

   
 

    //============PARIENTES=======================
    
    public int setParientes(Tarjeta parientes) throws DataAccessException {
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setParientes", parientes);
     return 1;
  }

    public List setRelaciones(Tarjeta parientes) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList(parientes.getDato(), parientes);
    }

    public int quitarRelaciones(Tarjeta relacion) throws DataAccessException {
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("quitarRelaciones", relacion);
     return i.intValue();
  }

    public int quitarParientes(Tarjeta relacion) throws DataAccessException {
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("quitarParientes", relacion);
     return i.intValue();
  }

    public List getListaRelaciones(Tarjeta relaciones) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList(relaciones.getClave(), relaciones);
    }   

    public int setTramites(Tarjeta tramites) throws DataAccessException {
           System.out.println("inserto tramites "); 
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setTramitesTemporal", tramites);
        System.out.println("insersion existosaa "); 
     return 1;
  }

    public int quitarTramites(Tarjeta tramites) throws DataAccessException {
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("quitarTramitesTemporal", tramites);
     return 1;
  }

    public List getListaTramitesTemporal(Tarjeta tramites) throws DataAccessException {
           System.out.println("intentando listar ");
        return getSqlMapTemplate().executeQueryForList("getListaTramitesTemporal", tramites);
    }
//==============================FIN PARIENTES

    //_ reportes
    public List getListaReporteDiario(Tarjeta id_usuario) {
	return getSqlMapTemplate().executeQueryForList("getReporteDiario", id_usuario);
    }
    public List getListaReporteMensual(Tarjeta id_usuario) {
	return getSqlMapTemplate().executeQueryForList("getReporteMensual", id_usuario);
    }
    public List getListaReporteTotal(Tarjeta id_usuario) {
	return getSqlMapTemplate().executeQueryForList("getReporteTotal", id_usuario);
    }
    //Fin _ reportes
    
    public int getTarjetaSess(Usuarios usuario) throws DataAccessException {
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getTarjetaSess", usuario);
     return i.intValue();
    }
    
    public Tarjeta getTarjeta(Tarjeta tarjeta) throws DataAccessException {
        return (Tarjeta) getSqlMapTemplate().executeQueryForObject("getTarjeta", tarjeta);    
    }
    public List getOcupaciones(Tarjeta datos) throws DataAccessException {
	return getSqlMapTemplate().executeQueryForList("getOcupaciones", datos);
    }
    public List getParientes(Tarjeta datos) throws DataAccessException {
	return getSqlMapTemplate().executeQueryForList("getParientes", datos);
    }
    public List getRelaciones(Tarjeta datos) throws DataAccessException {
	return getSqlMapTemplate().executeQueryForList("getRelaciones", datos);
    }
    public List getTramites(Tarjeta datos) throws DataAccessException {
	return getSqlMapTemplate().executeQueryForList("getTramites", datos);
    }
    public List getRegistro_civil(Tarjeta datos) throws DataAccessException {
	return getSqlMapTemplate().executeQueryForList("getRegistro_civil", datos);
    }
    public String getImgId(Usuarios usuario) throws DataAccessException {
        return (String) getSqlMapTemplate().executeQueryForObject("getImgId", usuario);
    }
    public String getDescripcionImg(Tarjeta tarjeta) throws DataAccessException {
        return (String) getSqlMapTemplate().executeQueryForObject("getDescripcionImg", tarjeta);
    }
    public void setGuardarTarjeta(Tarjeta datos) throws DataAccessException {
        getSqlMapTemplate().executeQueryForObject("setGuardarTarjeta", datos);
    }
    public String getNombreTarjeta(Tarjeta tarjeta) throws DataAccessException {
        return (String) getSqlMapTemplate().executeQueryForObject("getNombreTarjeta", tarjeta);
    }
    public String getNombreTarjetaUsr(Tarjeta tarjeta) throws DataAccessException {
        return (String) getSqlMapTemplate().executeQueryForObject("getNombreTarjetaUsr", tarjeta);
    }

    //_ supervisor
    public List getListTarjetas(Usuarios id_usuario) {
	return getSqlMapTemplate().executeQueryForList("getListTarjetas", id_usuario);
    }
    public void setModificarEstadoTarjeta(Tarjeta tarjeta) throws DataAccessException {
        getSqlMapTemplate().executeQueryForObject("setModificarEstadoTarjeta", tarjeta);
    }
    public List getListaGrupoSang(Tarjeta gsang) {
	return getSqlMapTemplate().executeQueryForList("getListaGrupoSang", gsang);
    }

    //Fin _ supervisor
    public int getTarjetasHoy(Usuarios usuario) throws DataAccessException {
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getTarjetasHoy", usuario);
     return i.intValue();
    }
    
    public int getTarjetasTotal(Usuarios usuario) throws DataAccessException {
     Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getTarjetasTotal", usuario);
     return i.intValue();
    }
    /*
    public String getEstadoTranscriptor(Usuarios usuario) throws DataAccessException {
      return (String) getSqlMapTemplate().executeQueryForObject("getEstadoTranscriptor", usuario);
    }
    */
    public String getEstadoTranscriptor(Usuarios usuario) throws DataAccessException {
	return (String) getSqlMapTemplate().executeQueryForObject("getEstadoTranscriptor", usuario);
    }
    
    public void setRegistroTranscripcion(Usuarios usuario) throws DataAccessException {
      String cod_img = (String) getSqlMapTemplate().executeQueryForObject("setRegistroTranscripcion", usuario);
    }
    public String getTarjetaVerificar(Usuarios usuario) throws DataAccessException {
      return (String) getSqlMapTemplate().executeQueryForObject("getTarjetaVerificar", usuario);
    }
    
    //Verificacion Tiempos _
    public Time getLapsoTiempos(Tiempos tiempo) throws DataAccessException {
	return (Time) getSqlMapTemplate().executeQueryForObject("getLapsoTiempos", tiempo);
    }
  
    public int setCalificacionTiempos(Tiempos tiempo) throws DataAccessException {
	Integer id_tiempos = (Integer) getSqlMapTemplate().executeQueryForObject("setCalificacionTiempos", tiempo);
	return id_tiempos.intValue();
    }
  
    public int setFinTiempos(Tiempos tiempo) throws DataAccessException {
	Integer id_tiempos = (Integer) getSqlMapTemplate().executeQueryForObject("setFinTiempos", tiempo);
	return id_tiempos.intValue();
    }
  
    public int setInicioTiempos(Tiempos tiempo) throws DataAccessException {
	Integer id_tiempos = (Integer) getSqlMapTemplate().executeQueryForObject("setInicioTiempos", tiempo);
	return id_tiempos.intValue();
    }
  
    public int setLapsoTiempos(Tiempos tiempo) throws DataAccessException {
	Integer id_tiempos = (Integer) getSqlMapTemplate().executeQueryForObject("setLapsoTiempos", tiempo);
	return id_tiempos.intValue();
    }
    
    public int getUltimoIdTiempos(Tiempos tiempo) throws DataAccessException {
	Integer id_tiempos = (Integer) getSqlMapTemplate().executeQueryForObject("getUltimoIdTiempos", tiempo);
	return id_tiempos.intValue();
    }
    //Fin Verificacion Tiempos _
    public void setCalificacionUsr(Tarjeta datos) throws DataAccessException {
	Integer id_tiempos = (Integer) getSqlMapTemplate().executeQueryForObject("setCalificacionUsr", datos);       
    }
    public void setCalificacionSistema(Tarjeta datos) throws DataAccessException {
	Integer id_tiempos = (Integer) getSqlMapTemplate().executeQueryForObject("setCalificacionSistema", datos);       
    }
    public void setPrepararGuardar(Tarjeta datos) throws DataAccessException {
	Integer id_tiempos = (Integer) getSqlMapTemplate().executeQueryForObject("setPrepararGuardar", datos);       
    }
    //jvr
    public String getTarjetasRevertir(String id_usuario) throws DataAccessException {
      Usuarios usuario= new Usuarios();
      usuario.setId_usuario(id_usuario); 
      return (String) getSqlMapTemplate().executeQueryForObject("getTarjetasRevertir", usuario);
    }
    

}
