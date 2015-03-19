/*Estructura elaborada por: John Castillo Valencia*/
package org.springframework.eam.domain.logic;

import java.util.List;
import java.util.Date;
import java.sql.Time;
import java.lang.*;
import org.springframework.eam.domain.Beneficiario;
import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Roles;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Registro;
import org.springframework.eam.domain.Documentos;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Departamento;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.Turno;
import org.springframework.eam.domain.Reporte;
import org.springframework.eam.domain.Servidor;
import org.springframework.eam.domain.carreras;

public interface EamFacade {

    /************************* TRANSCRIPCIONES *****************************/
    List getListaPais(Pais pais);

    List getListaDepto(Departamento depto);

    List getListaProvincia(Departamento provincia);

    List getListaSeccion(Departamento seccion);

    List getListaCanton(Departamento canton);

    List getListaLocalidad(Departamento localidad);

    List getListaNacionalidad(Personas nacionalidad);

    List getListaEstcivil(Personas estcivil);

    List getListaProfesion(Personas profesion);

    List getListaFiliacion(Personas filiacion);

    List getListaParientes(Tarjeta parientes);

    List getListaTramite(Tarjeta tramite);

    String getCodigoImg(Usuarios usuario);
    //-------parientes--------

    int setDatosTemporal(Tarjeta datos);

    int setParientes(Tarjeta parientes);

    List setRelaciones(Tarjeta parientes);

    int quitarRelaciones(Tarjeta relacion);

    int quitarParientes(Tarjeta relacion);

    List getListaRelaciones(Tarjeta relaciones);

    int setTramites(Tarjeta tramites);

    int quitarTramites(Tarjeta tramites);

    List getListaTramitesTemporal(Tarjeta tramites);

//USUARIOS
    Usuarios getConexion(String id_usuario, String clave);

    void setControlarIngreso(String id_usuario, String id_rol);

    void setControlarSalida(String id_usuario);

//MENUES
    //categorias
    List getCategorias(String id_programa, String id_rol);
    //enlaces

    List getEnlaces(String id_categoria, String id_rol, String id_programa);
    //PERSONAS

    List getPaises();

    List getDepartamentos();

    List getListaEstadoCivil();

    Personas getPais(int id_pais);

    Personas getDepartamento(int id_departamento);

    Personas getEstadoCivil(int id_estado_civil);
//_ _ 
//Metodos de Busqueda *****************************************
  /* Busqueda personas *************/

    Personas getBuscarPersonaId(Personas persona);

    List getBuscarPersonaCi(Personas persona);

    List getBuscarPersonaNombres(Personas persona);
//fin metodos de busqueda *************************************
  /* USUARIOS ************************************************/

    List getUsuariosPrograma(String id_programa);

    //2 Ibatis
    Personas setRegistrarPersona(Personas persona);
    //JES

    void updateModificarPersona(Personas persona);
    //ROLES

    List getRolesPrograma(String id_programa);
    //USUARIOS

    int setRegistrarUsuariosAdm(Usuarios usuario);

    int getId_usuario(String id_usuario);
    //Administrativos

    int setRegistrarAdministrativo(Administrativos administrativo);
    //Usuarios ROLES

    int setRegistrarUsuariosRoles(Usuarios usuario);

    //Jes
    void setRegistrarUsuariosyRoles(Usuarios usuario);

    int setActualizarUsuariosRoles(Usuarios usuario);

    int setEliminarUsuariosRoles(Usuarios usuario);

    void setActualizarParametros(Registro registro);

    /* Lista de enlaces de roles _ */
    List getEnlacesRoles(String id_rol, String id_programa);

    Menues getFechasEnlaces(int id_enlace);

    void setActualizarMenues(Menues actualizar);
    /* Menues _ */

    void setAdministrarMenues(Menues menu);

// Cambio de Pin _
    List getUsuarioClave(String id_programa, String id_usuario, String clave);

    void setActualizarClave(Usuarios actualizar);

    int setActualizarClaveKar(Usuarios usuario);
// Fin Cambio de Pin _

    int getKeySecurity(Menues menu);

    List getRolesUsuario(Usuarios usuario);

    int setActualizarUsuarioAdm(Usuarios usuario);

    int setActualizarAdministrativo(Administrativos administrativo);

    void setBorrarRolesUsuario(Usuarios usuario);

    void setBorrarLoginHistorico(Usuarios usuario);
//transcripciones

    int getRespuesta();

    void setEliminarUsuario(Usuarios usuario);

    List getListaGrupo(Personas parametros);
//_ reportes

    List getListaReporteDiario(Tarjeta id_usuario);

    List getListaReporteMensual(Tarjeta id_usuario);

    List getListaReporteTotal(Tarjeta id_usuario);
//Fin _ reportes

    int getTarjetaSess(Usuarios usuario);

    Tarjeta getTarjeta(Tarjeta tarjeta);

    List getOcupaciones(Tarjeta datos);

    List getParientes(Tarjeta datos);

    List getRelaciones(Tarjeta datos);

    List getTramites(Tarjeta datos);

    List getRegistro_civil(Tarjeta datos);

    String getImgId(Usuarios usuario);

    String getDescripcionImg(Tarjeta tarjeta);

    void setGuardarTarjeta(Tarjeta datos);

    String getNombreTarjeta(Tarjeta tarjeta);

    String getNombreTarjetaUsr(Tarjeta tarjeta);
//_ supervisor

    List getListUsuarios();

    List getListTarjetas(Usuarios id_usuario);

    void setModificarEstadoTarjeta(Tarjeta tarjeta);

    List getListaGrupoSang(Tarjeta gsang);

    String setLoginKey(Usuarios usuario);

    String getLoginKey(Usuarios usuario);
//Fin _ supervisor

    int getTarjetasHoy(Usuarios usuario);

    int getTarjetasTotal(Usuarios usuario);

    String getEstadoTranscriptor(Usuarios usuario);
    //_ Cambiar Turno

    void setCambiarTurno(Usuarios usuario);
    //Fin _ Cambiar Turno
    //_ Turno Modulo

    void setTurno(Turno turno);

    void setTurno2(Turno turno);

    void setTurnoTmp(Turno turno);

    int getTurnoActual(Usuarios usuario);

    int getTurno(Usuarios usuario);

    Turno getTurnoTmp(Usuarios usuario);

    List getUsuariosTurno();
    //Fin _ Turno Modulo

    void getLoginRefreshUsers();

    List getLoginUsers();

    Usuarios getLoginUser(Usuarios usuario);

    int getVerUsuario(Usuarios usuario);

    Administrativos getAdministrativo(Administrativos administrativo);

    Servidor getServidor(Servidor servidor);

    void setRegistroTranscripcion(Usuarios usuario);

    List getListaServidores();

    void setServidor(Servidor servidor);

    void setCajaServidor(Servidor servidor);

    void setDefaultServer(Servidor servidor);

    Servidor getDefaultServer();

    String getTarjetaVerificar(Usuarios usuario);

    //Verificacion Tiempos _
    Time getLapsoTiempos(int id_tiempos);

    int setCalificacionTiempos(int id_tiempos, int calificacion);

    int setFinTiempos(int id_tiempos);

    int setInicioTiempos(String id_tarjeta, String id_estado, String id_usuario, String id_rol);

    int setLapsoTiempos(int id_tiempos, Time lapso);

    int getUltimoIdTiempos(String id_tarjeta);
    //Fin Verificacion Tiempos _

    Personas getPersona(Personas persona);

    Usuarios getUsuario(Usuarios usuario);

    String getUsrCnx(Usuarios usuario);

    String getUsrTurno(Usuarios usuario);

    String setUsrTurno(Usuarios usuario);

    void setCalificacionUsr(Tarjeta datos);

    void setCalificacionSistema(Tarjeta datos);

    void setPrepararGuardar(Tarjeta datos);

    List getUsrsTurno(Usuarios usuario);

    String getIdSrvByBoxName(String cod_img);
    //jvr

    String getTarjetasRevertir(String id_usuario);

    //jes
    List getListarTareas(ProActTar proActTar);

    ProActTar getActividad(ProActTar tta);

    ProActTar getTarea(ProActTar ttar);

    void setCarreasRelacionUsuario(carreras relacion);

    List getListaTareasUsuario(carreras relacion_usuario);

    void setEliminaRelacionTareasUsuarios(carreras tareasUsuario);

    void setEliminarLoginStatus(Usuarios us);

    void setElimiarAdministrativo(Administrativos ads);

    void setEliminaPersona(Personas per);

    void setRegistroBeneficiario(Beneficiario benefi);

    Beneficiario getMostrarBeneficiario(Beneficiario benefi);

    List getListarSucursales(String nit);

    List getListarBeneficiarioPorNombre(String nombrep);

    List getListarBeneficiarioPorNit(String nit);

    void setEliminaSucursal(Beneficiario benefi);

    void setRegistroSucursalBeneficiario(Beneficiario benefi);

    Beneficiario getMostrarSucursal(Beneficiario Sucursal);

    void updateModificarDatosSucursal(Beneficiario benefi);

    void setEliminaBeneficiario(Beneficiario benefi);

    void setEliminaSucursales(Beneficiario benefi);

    void updateModificarDatosBeneficiario(Beneficiario benefi);

    double getTotalPresupuestadoTareaFuente(InsPreIng oie);

    double getTotalEjecutadoTareaFuenteEgr(InsPreIng oie);

    double getTotalEjecutadoNoPresupuestadoTareaFuenteEgr(InsPreIng oie);

    double getTotalEjecutadoIngresos(InsPreIng oie);

    double getTotalEjecutadoIngresosNoPresupuestado(InsPreIng oie);

    double getTotalComprometidoByTareaAndFuente(InsPreIng oie);

    List getFuentesDeTareasByUsuario(carreras car);

    List getActividadesByUsuario(carreras car);

    List getTareasByUsuarioAndActividad(carreras car);

    List getFuentesAndMontosEjecutadosByTarea(ProActTar tarea);

    List getListActividad();

    List getListAllFuentesFinanciamiento();

    List getListAllTareaByActividad(ProActTar actividad);

    Personas getNombresByIdUsuario(String id_usuario_creador_cert);


}
 