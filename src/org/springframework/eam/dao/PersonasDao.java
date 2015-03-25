/*Estructura elaborada por: John Castillo Valencia*/
package org.springframework.eam.dao;

import java.util.List;
import java.util.Date;
import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Beneficiario;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.carreras;

public interface PersonasDao {

    List getPaises() throws DataAccessException;

    List getListaEstadoCivil() throws DataAccessException;

    List getDepartamentos() throws DataAccessException;

    List getListarDepartamentos(int id_pais) throws DataAccessException;

    Personas getPais(int id_pais) throws DataAccessException;

    Personas getDepartamento(int id_departamento) throws DataAccessException;

    Personas getEstadoCivil(int id_estado_civil) throws DataAccessException;
// _ _
    ///4 ibatis

    Personas setRegistrarPersona(Personas persona) throws DataAccessException;
// FIN _ _
    // ****** _ Search *******

    Personas getBuscarPersonaId(Personas persona) throws DataAccessException;

    List getBuscarPersonaCi(Personas persona) throws DataAccessException;

    List getBuscarPersonaNombres(Personas persona) throws DataAccessException;

    // ****** end search ********
    Personas getPersona(Personas persona) throws DataAccessException;

    //JES
    void updateModificarPersona(Personas persona) throws DataAccessException;

    void setRegistroBeneficiario(Beneficiario benefi) throws DataAccessException;

    Beneficiario getMostrarBeneficiario(Beneficiario benefi) throws DataAccessException;

    List getListarSucursales(String nit) throws DataAccessException;

    List getListarBeneficiarioPorNombre(String nombrep) throws DataAccessException;

    List getListarBeneficiarioPorNit(String nit) throws DataAccessException;

    void setEliminaSucursal(Beneficiario benefi) throws DataAccessException;

    void setRegistroSucursalBeneficiario(Beneficiario benefi) throws DataAccessException;

    Beneficiario getMostrarSucursal(Beneficiario Sucursal) throws DataAccessException;

    void updateModificarDatosSucursal(Beneficiario benefi) throws DataAccessException;

    void setEliminaBeneficiario(Beneficiario benefi) throws DataAccessException;

    void setEliminaSucursales(Beneficiario benefi) throws DataAccessException;

    void updateModificarDatosBeneficiario(Beneficiario benefi) throws DataAccessException;

    double getTotalPresupuestadoTareaFuente(InsPreIng oie) throws DataAccessException;

    double getTotalEjecutadoTareaFuenteEgr(InsPreIng oie) throws DataAccessException;

    double getTotalEjecutadoNoPresupuestadoTareaFuenteEgr(InsPreIng oie) throws DataAccessException;

    double getTotalEjecutadoIngresos(InsPreIng oie) throws DataAccessException;

    double getTotalEjecutadoIngresosNoPresupuestado(InsPreIng oie) throws DataAccessException;

    double getTotalComprometidoByTareaAndFuente(InsPreIng oie) throws DataAccessException;

    List getFuentesDeTareasByUsuario(carreras car) throws DataAccessException;

    List getActividadesByUsuario(carreras car) throws DataAccessException;

    List getTareasByUsuarioAndActividad(carreras car) throws DataAccessException;

    List getFuentesAndMontosEjecutadosByTarea(ProActTar tarea) throws DataAccessException;

    Personas getNombresByIdUsuario(String id_usuario_creador_cert) throws DataAccessException;

    Comprometido getObjRefComproById(Comprometido c) throws DataAccessException;

}
