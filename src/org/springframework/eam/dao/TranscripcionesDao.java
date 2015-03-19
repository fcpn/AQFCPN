/*
 * TranscripcionesDao.java
 *
 * Created on 13 de julio de 2007, 18:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.springframework.eam.dao;


import java.util.List;
import java.sql.Time;

import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Beneficiario;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Departamento;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Reporte;
import org.springframework.eam.domain.Tiempos;
/**
 *
 * @author Administrador
 */
public interface TranscripcionesDao {
    
    /** Creates a new instance of TranscripcionesDao */
    List getListaPais(Pais pais) throws DataAccessException;
    List getListaDepto(Departamento depto) throws DataAccessException;
    List getListaProvincia(Departamento provincia) throws DataAccessException;
    List getListaSeccion(Departamento seccion) throws DataAccessException;
    List getListaCanton(Departamento canton) throws DataAccessException;
    List getListaLocalidad(Departamento localidad) throws DataAccessException;
    List getListaNacionalidad(Personas nacionalidad) throws DataAccessException;
    List getListaEstcivil(Personas estcivil) throws DataAccessException;
    List getListaProfesion(Personas profesion) throws DataAccessException;
    List getListaFiliacion(Personas filiacion) throws DataAccessException;
    String getCodigoImg(Usuarios usuario) throws DataAccessException;
    
    List getListaGrupo(Personas parametros) throws DataAccessException;
    

    ///parientes
    int setDatosTemporal(Tarjeta datos) throws DataAccessException;
    List getListaParientes(Tarjeta parientes) throws DataAccessException;
    List getListaTramite(Tarjeta tramite) throws DataAccessException;
    
    int setParientes(Tarjeta parientes) throws DataAccessException;    
    List setRelaciones(Tarjeta parientes) throws DataAccessException;    
    int quitarRelaciones(Tarjeta relacion) throws DataAccessException;    
    int quitarParientes(Tarjeta relacion) throws DataAccessException;    
    List getListaRelaciones(Tarjeta relaciones) throws DataAccessException;
    
    int setTramites(Tarjeta tramites) throws DataAccessException;        
    int quitarTramites(Tarjeta tramites) throws DataAccessException;       
    List getListaTramitesTemporal(Tarjeta tramites) throws DataAccessException;
         
    //_ reportes
    List getListaReporteDiario(Tarjeta id_usuario) throws DataAccessException;
    List getListaReporteMensual(Tarjeta id_usuario) throws DataAccessException;
    List getListaReporteTotal(Tarjeta id_usuario) throws DataAccessException;
    //Fin _ reportes
    int getTarjetaSess(Usuarios usuario) throws DataAccessException;
    Tarjeta getTarjeta(Tarjeta tarjeta) throws DataAccessException;
    List getParientes(Tarjeta datos) throws DataAccessException;
    List getRelaciones(Tarjeta datos) throws DataAccessException;
    List getOcupaciones(Tarjeta datos) throws DataAccessException;
    List getTramites(Tarjeta datos) throws DataAccessException;
    List getRegistro_civil(Tarjeta datos) throws DataAccessException;
    String getImgId(Usuarios usuario) throws DataAccessException;
    String getDescripcionImg(Tarjeta tarjeta) throws DataAccessException;
    void setGuardarTarjeta(Tarjeta datos ) throws DataAccessException;
    String getNombreTarjeta(Tarjeta tarjeta) throws DataAccessException;
    String getNombreTarjetaUsr(Tarjeta tarjeta) throws DataAccessException;
    //_ supervision
    List getListTarjetas(Usuarios id_usuario) throws DataAccessException;
    void setModificarEstadoTarjeta(Tarjeta tarjeta) throws DataAccessException;
    List getListaGrupoSang(Tarjeta gsang) throws DataAccessException;
    //Fin _ supervision
    int getTarjetasHoy(Usuarios usuario) throws DataAccessException;
    int getTarjetasTotal(Usuarios usuario) throws DataAccessException;
    String getEstadoTranscriptor(Usuarios usuario) throws DataAccessException;
    void setRegistroTranscripcion(Usuarios usuario) throws DataAccessException;
    String getTarjetaVerificar(Usuarios usuario) throws DataAccessException;

    //Verificacion Tiempos _
    Time getLapsoTiempos(Tiempos tiempo) throws DataAccessException;
    int setCalificacionTiempos(Tiempos tiempo) throws DataAccessException;
    int setFinTiempos(Tiempos tiempo) throws DataAccessException;
    int setInicioTiempos(Tiempos tiempo) throws DataAccessException;
    int setLapsoTiempos(Tiempos tiempo) throws DataAccessException;
    int getUltimoIdTiempos(Tiempos tiempo) throws DataAccessException;
    //Fin Verificacion Tiempos _
    void setCalificacionUsr(Tarjeta datos) throws DataAccessException;
    void setCalificacionSistema(Tarjeta datos) throws DataAccessException;
    void setPrepararGuardar(Tarjeta datos) throws DataAccessException;

    //jvr
    String getTarjetasRevertir(String id_usuario) throws DataAccessException;

}
