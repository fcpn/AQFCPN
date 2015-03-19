package org.springframework.eam.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.Turno;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Servidor;
import org.springframework.eam.domain.carreras;

public interface AdministrarUsuariosDao {

    List getUsuariosPrograma(String id_programa) throws DataAccessException;

    int setRegistrarUsuariosAdm(Usuarios usuario) throws DataAccessException;

    int getId_usuario(String id_usuario) throws DataAccessException;

    int setRegistrarUsuariosRoles(Usuarios usuario) throws DataAccessException;

    //jes
    void setRegistrarUsuariosyRoles(Usuarios usuario) throws DataAccessException;

    int setActualizarUsuariosRoles(Usuarios usuario) throws DataAccessException;

    int setEliminarUsuariosRoles(Usuarios usuario) throws DataAccessException;

    int setRegistrarAdministrativo(Administrativos administrativo) throws DataAccessException;

    List getRolesUsuario(Usuarios usuario) throws DataAccessException;

    int getKeySecurity(Menues menu) throws DataAccessException;

    int setActualizarUsuarioAdm(Usuarios usuario) throws DataAccessException;

    int setActualizarAdministrativo(Administrativos administrativo) throws DataAccessException;

    void setBorrarRolesUsuario(Usuarios usuario) throws DataAccessException;

    void setBorrarLoginHistorico(Usuarios usuario) throws DataAccessException;

// Actualizar Clave
    int setActualizarClaveKar(Usuarios usuario) throws DataAccessException;

//_ Cambiar Turno
    void setCambiarTurno(Usuarios usuario) throws DataAccessException;
//Fin _ Cambiar Turno
    //_ Turno Modulo

    void setTurno(Turno turno) throws DataAccessException;

    void setTurno2(Turno turno) throws DataAccessException;

    void setTurnoTmp(Turno turno) throws DataAccessException;

    int getTurnoActual(Usuarios usuario) throws DataAccessException;

    int getTurno(Usuarios usuario) throws DataAccessException;

    Turno getTurnoTmp(Usuarios usuario) throws DataAccessException;

    List getUsuariosTurno() throws DataAccessException;
  //String getEstadoTranscriptor(Usuarios usuario) throws DataAccessException;
    //Fin _ Turno Modulo
    Administrativos getAdministrativo(Administrativos administrativo) throws DataAccessException;

    Servidor getServidor(Servidor servidor) throws DataAccessException;

    List getListaServidores() throws DataAccessException;

    void setServidor(Servidor servidor) throws DataAccessException;

    void setCajaServidor(Servidor servidor) throws DataAccessException;

    void setDefaultServer(Servidor servidor) throws DataAccessException;

    Servidor getDefaultServer() throws DataAccessException;

    String getIdSrvByBoxName(String cod_img) throws DataAccessException;

    //jes
    List getListarTareas(ProActTar proActTar) throws DataAccessException;

    ProActTar getActividad(ProActTar tta) throws DataAccessException;

    ProActTar getTarea(ProActTar ttar) throws DataAccessException;

    void setCarreasRelacionUsuario(carreras relacion) throws DataAccessException;

    List getListaTareasUsuario(carreras relacion_usuario) throws DataAccessException;

    void setEliminaRelacionTareasUsuarios(carreras tareasUsuario) throws DataAccessException;

    void setEliminarLoginStatus(Usuarios us) throws DataAccessException;

    void setElimiarAdministrativo(Administrativos ads) throws DataAccessException;

    void setEliminaPersona(Personas per) throws DataAccessException;

    List getFuentesAndMontosEjecutadosByTarea() throws DataAccessException;

    List getListActividad() throws DataAccessException;

    List getListAllFuentesFinanciamiento() throws DataAccessException;

    List getListAllTareaByActividad(ProActTar actividad) throws DataAccessException;

}
