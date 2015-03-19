/*Estructura elaborada por: John Castillo Valencia*/
package org.springframework.eam.domain.logic;

import java.util.List;
import java.util.Date;
import java.sql.Time;
import java.lang.String;

import org.springframework.eam.dao.MenuesDao;
import org.springframework.eam.dao.UsuariosDao;
import org.springframework.eam.dao.PersonasDao;
import org.springframework.eam.dao.RolesDao;
import org.springframework.eam.dao.RegistroDao;
import org.springframework.eam.dao.AdministrarUsuariosDao;
import org.springframework.eam.dao.TranscripcionesDao;

import org.springframework.eam.domain.Beneficiario;
import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.Roles;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Registro;
import org.springframework.eam.domain.Pais;
import org.springframework.eam.domain.Departamento;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.Tarjeta;
import org.springframework.eam.domain.Turno;
import org.springframework.eam.domain.Reporte;
import org.springframework.eam.domain.Servidor;
import org.springframework.eam.domain.Tiempos;
import org.springframework.eam.domain.carreras;



public class EamImpl implements EamFacade {
    
    private MenuesDao menuesDao;
    private UsuariosDao usuariosDao;
    private PersonasDao personasDao;
    private RolesDao rolesDao;
    private RegistroDao registroDao;
    /*  TRANSCRIPCIONES */
    private TranscripcionesDao transcripcionesDao;
    private AdministrarUsuariosDao administrarUsuariosDao;
    
    //TRANSCRIPCIONES
    public void setTranscripcionesDao(TranscripcionesDao transcripcionesDao) {
        this.transcripcionesDao = transcripcionesDao;
    }
    
    //ADMINISTRAR USUARIOS
    public void setAdministrarUsuariosDao(AdministrarUsuariosDao administrarUsuariosDao) {
        this.administrarUsuariosDao = administrarUsuariosDao;
    }
    
    //MENUES
    public void setMenuesDao(MenuesDao menuesDao) {
        this.menuesDao = menuesDao;
    }
    
    //USUARIOS
    public void setUsuariosDao(UsuariosDao usuariosDao) {
        this.usuariosDao = usuariosDao;
    }
    
    //PERSONAS
    public void setPersonasDao(PersonasDao personasDao) {
        this.personasDao = personasDao;
    }
    
    //ROLES
    public void setRolesDao(RolesDao rolesDao) {
        this.rolesDao = rolesDao;
    }
    
    //REGISTRO
    public void setRegistroDao(RegistroDao registroDao) {
        this.registroDao = registroDao;
    }





    public List getListaPais(Pais pais){
        return this.transcripcionesDao.getListaPais(pais);
    }
    
    public List getListaDepto(Departamento depto){
        return this.transcripcionesDao.getListaDepto(depto);
    }
    
    public List getListaProvincia(Departamento provincia){
        return this.transcripcionesDao.getListaProvincia(provincia);
    }
    
    public List getListaSeccion(Departamento seccion){
        return this.transcripcionesDao.getListaSeccion(seccion);
    }
    
    public List getListaCanton(Departamento canton){
        return this.transcripcionesDao.getListaCanton(canton);
    }
    
    public List getListaLocalidad(Departamento localidad){
        return this.transcripcionesDao.getListaLocalidad(localidad);
    }
    
    public List getListaNacionalidad(Personas nacionalidad){
        return this.transcripcionesDao.getListaNacionalidad(nacionalidad);
    }
    
    public List getListaEstcivil(Personas estcivil){
        return this.transcripcionesDao.getListaEstcivil(estcivil);
    }
    
    public List getListaProfesion(Personas profesion){
        return this.transcripcionesDao.getListaProfesion(profesion);
    }
    
    public List getListaFiliacion(Personas filiacion){
        return this.transcripcionesDao.getListaFiliacion(filiacion);
    }
    
    
    public String getCodigoImg(Usuarios usuario) {
	return this.transcripcionesDao.getCodigoImg(usuario);
    }

    public int setDatosTemporal(Tarjeta datos){
        return this.transcripcionesDao.setDatosTemporal(datos);
    }

       //------parientes------------
    
    public List getListaParientes(Tarjeta parientes){
        return this.transcripcionesDao.getListaParientes(parientes);
    }

    public List getListaTramite(Tarjeta tramite){
        return this.transcripcionesDao.getListaTramite(tramite);
    }

    public int setParientes(Tarjeta parientes){
        return this.transcripcionesDao.setParientes(parientes);
    }

    public List setRelaciones(Tarjeta parientes){
        return this.transcripcionesDao.setRelaciones(parientes); 
    }


    public int quitarRelaciones(Tarjeta relacion){
        return this.transcripcionesDao.quitarRelaciones(relacion);
    }

    public int quitarParientes(Tarjeta relacion){
        return this.transcripcionesDao.quitarParientes(relacion);
    }

    public List getListaRelaciones(Tarjeta relaciones){
        return this.transcripcionesDao.getListaRelaciones(relaciones);
    }

    public int setTramites(Tarjeta tramites){
        return this.transcripcionesDao.setTramites(tramites);
    }

    public int quitarTramites(Tarjeta tramites){
        return this.transcripcionesDao.quitarTramites(tramites);
    }

    public List getListaTramitesTemporal(Tarjeta tramites){
        return this.transcripcionesDao.getListaTramitesTemporal(tramites);
    }





    /*  END TRANSCRIPCIONES */
    
    
    
    
    
    
    
    
//CLIENTES
    public Usuarios getConexion(String id_usuario, String clave) {
        return this.usuariosDao.getConexion(id_usuario, clave);
    }
    public void setControlarIngreso(String id_usuario,String id_rol){
        this.usuariosDao.setControlarIngreso(id_usuario, id_rol);
    }
    public void setControlarSalida(String id_usuario){
        this.usuariosDao.setControlarSalida(id_usuario);
    }
    
//MENUES
    //categorias
    public List getCategorias(String id_programa, String id_rol){
        return this.menuesDao.getCategorias(id_programa, id_rol);
    }
    //enlaces
    public List getEnlaces(String id_categoria, String id_rol, String id_programa) {
        return this.menuesDao.getEnlaces(id_categoria, id_rol, id_programa);
    }
    
//PERSONAS ***** //
    public Personas getPais(int id_pais) {
        return this.personasDao.getPais(id_pais);
    }
    public Personas getDepartamento(int id_departamento) {
        return this.personasDao.getDepartamento(id_departamento);
    }
    public Personas getEstadoCivil(int id_estado_civil) {
        return this.personasDao.getEstadoCivil(id_estado_civil);
    }
    public List getListaEstadoCivil() {
        return this.personasDao.getListaEstadoCivil();
    }
    public List getPaises() {
        return this.personasDao.getPaises();
    }
    public List getDepartamentos() {
        return this.personasDao.getDepartamentos();
    }
    public List getListarDepartamentos(int id_pais) {
        return this.personasDao.getListarDepartamentos(id_pais);
    }
//_ _
    //Metodos de Busqueda
    public Personas getBuscarPersonaId(Personas persona){
        return this.personasDao.getBuscarPersonaId(persona);
    }
    public List getBuscarPersonaCi(Personas persona){
        return this.personasDao.getBuscarPersonaCi(persona);
    }
    public List getBuscarPersonaNombres(Personas persona){
        return this.personasDao.getBuscarPersonaNombres(persona);
    }


    ///3 ibatis
    public Personas setRegistrarPersona(Personas persona){
        return this.personasDao.setRegistrarPersona(persona);
    }
//JES
    public void updateModificarPersona(Personas persona) {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.personasDao.updateModificarPersona(persona);
    }



    //ROLES
    public List getRolesPrograma(String id_programa){
        return this.rolesDao.getRolesPrograma(id_programa);
    }
    
    /************ Administrar Usuarios ***************/
    public List getUsuariosPrograma(String id_programa){
        return this.administrarUsuariosDao.getUsuariosPrograma(id_programa);
    }
    public int setRegistrarUsuariosAdm(Usuarios usuario){
        return this.administrarUsuariosDao.setRegistrarUsuariosAdm(usuario);
    }
    public int getId_usuario(String id_usuario){
        return this.administrarUsuariosDao.getId_usuario(id_usuario);
    }

    public int setRegistrarUsuariosRoles(Usuarios usuario){
        return this.administrarUsuariosDao.setRegistrarUsuariosRoles(usuario);
    }

    /*jes*/
    public void setRegistrarUsuariosyRoles(Usuarios usuario){
        this.administrarUsuariosDao.setRegistrarUsuariosyRoles(usuario);
    }

    public List getListarTareas(ProActTar proActTar) {
        return this.administrarUsuariosDao.getListarTareas(proActTar);
    }

    public ProActTar getActividad(ProActTar tta) {
        return this.administrarUsuariosDao.getActividad(tta);
    }

    public ProActTar getTarea(ProActTar ttar) {
        return this.administrarUsuariosDao.getTarea(ttar);
    }

    public void setCarreasRelacionUsuario(carreras relacion) {
        this.administrarUsuariosDao.setCarreasRelacionUsuario(relacion);
    }

    public List getListaTareasUsuario(carreras relacion_usuario) {
        return this.administrarUsuariosDao.getListaTareasUsuario(relacion_usuario);
    }

    public void setEliminaRelacionTareasUsuarios(carreras tareasUsuario) {
        this.administrarUsuariosDao.setEliminaRelacionTareasUsuarios(tareasUsuario);
    }

    public void setEliminarLoginStatus(Usuarios us) {
        this.administrarUsuariosDao.setEliminarLoginStatus(us);
    }

    public void setElimiarAdministrativo(Administrativos ads) {
        this.administrarUsuariosDao.setElimiarAdministrativo(ads);
    }

    public void setEliminaPersona(Personas per) {
        this.administrarUsuariosDao.setEliminaPersona(per);
    }




    /*Jes*/

    public int setActualizarUsuariosRoles(Usuarios usuario){
        return this.administrarUsuariosDao.setActualizarUsuariosRoles(usuario);
    }
    public int setEliminarUsuariosRoles(Usuarios usuario){
        return this.administrarUsuariosDao.setEliminarUsuariosRoles(usuario);
    }
    public int setRegistrarAdministrativo(Administrativos administrativo){
        return this.administrarUsuariosDao.setRegistrarAdministrativo(administrativo);
    }
    // **************** RGISTRO - PARAMETROS DEL SISTEMA **************************
    public void setActualizarParametros(Registro registro){
        this.registroDao.setActualizarParametros(registro);
    }
    
    /* Menues Enlaces de los Roles */
    public List getEnlacesRoles(String id_rol, String id_programa) {
        return this.menuesDao.getEnlacesRoles(id_rol, id_programa);
    }
    /* Fechas de enlaces  */
    public Menues getFechasEnlaces(int id_enlace) {
        return this.menuesDao.getFechasEnlaces(id_enlace);
    }
    /*  Menues  */
    public void setAdministrarMenues(Menues menu) {
        this.menuesDao.setAdministrarMenues(menu);
    }
    
    public void setActualizarMenues(Menues actualizar) {
        this.menuesDao.setActualizarMenues(actualizar);
    }
    /***** Fin Menues */
    
// Cambio de Pin 
    
    public List getUsuarioClave(String id_programa,String id_usuario,String clave)  {
        return this.usuariosDao.getUsuarioClave(id_programa,id_usuario,clave);
    }
    
    public void setActualizarClave(Usuarios actualizar) {
        this.usuariosDao.setActualizarClave(actualizar);
    }
    
    public int setActualizarClaveKar(Usuarios usuario) {
        return this.administrarUsuariosDao.setActualizarClaveKar(usuario);
    }
    
    
// Fin Cambio de Pin 
    
    public int getKeySecurity(Menues menu){
        return this.administrarUsuariosDao.getKeySecurity(menu);
    }
    public List getRolesUsuario(Usuarios usuario){
        return this.administrarUsuariosDao.getRolesUsuario(usuario);
    }
//usuarios
    public int setActualizarUsuarioAdm(Usuarios usuario){
        return this.administrarUsuariosDao.setActualizarUsuarioAdm(usuario);
    }
    public int setActualizarAdministrativo(Administrativos administrativo){
        return this.administrarUsuariosDao.setActualizarAdministrativo(administrativo);
    }
    public void setBorrarRolesUsuario(Usuarios usuario){
        this.administrarUsuariosDao.setBorrarRolesUsuario(usuario);
    }
    public void setBorrarLoginHistorico(Usuarios usuario){
        this.administrarUsuariosDao.setBorrarLoginHistorico(usuario);
    }
//transcripciones
    public int getRespuesta(){
        return this.usuariosDao.getRespuesta();
    }
    public void setEliminarUsuario(Usuarios usuario) {
        this.usuariosDao.setEliminarUsuario(usuario);
    }
    public List getListaGrupo(Personas parametros) {
        return this.transcripcionesDao.getListaGrupo(parametros);
    }
// reportes
    public List getListaReporteDiario(Tarjeta id_usuario) {
        return this.transcripcionesDao.getListaReporteDiario(id_usuario);
    }
    public List getListaReporteMensual(Tarjeta id_usuario) {
        return this.transcripcionesDao.getListaReporteMensual(id_usuario);
    }
    public List getListaReporteTotal(Tarjeta id_usuario) {
        return this.transcripcionesDao.getListaReporteTotal(id_usuario);
    }
//Fin _ reportes
    public int getTarjetaSess(Usuarios usuario) {
        return this.transcripcionesDao.getTarjetaSess(usuario);
    }
    public Tarjeta getTarjeta(Tarjeta tarjeta) {
        return this.transcripcionesDao.getTarjeta(tarjeta);
    }
    public List getOcupaciones(Tarjeta datos) {
        return this.transcripcionesDao.getOcupaciones(datos);
    }
    public List getParientes(Tarjeta datos) {
        return this.transcripcionesDao.getParientes(datos);
    }
    public List getRelaciones(Tarjeta datos) {
        return this.transcripcionesDao.getRelaciones(datos);
    }
    public List getTramites(Tarjeta datos) {
        return this.transcripcionesDao.getTramites(datos);
    }
    public List getRegistro_civil(Tarjeta datos) {
        return this.transcripcionesDao.getRegistro_civil(datos);
    }
    public String getImgId(Usuarios usuario) {
        return this.transcripcionesDao.getImgId(usuario);
    }	
    public String getDescripcionImg(Tarjeta tarjeta) {
        return this.transcripcionesDao.getDescripcionImg(tarjeta);
    }
    public void setGuardarTarjeta(Tarjeta datos) {
        this.transcripcionesDao.setGuardarTarjeta(datos);
    }
    public String getNombreTarjeta(Tarjeta tarjeta) {
        return this.transcripcionesDao.getNombreTarjeta(tarjeta);
    }
    public String getNombreTarjetaUsr(Tarjeta tarjeta) {
        return this.transcripcionesDao.getNombreTarjetaUsr(tarjeta);
    }
//_ supervisor
    public List getListUsuarios() {
	return this.usuariosDao.getListUsuarios();
    }
    public List getListTarjetas(Usuarios id_usuario) {
	return this.transcripcionesDao.getListTarjetas(id_usuario);
    }
    public void setModificarEstadoTarjeta(Tarjeta tarjeta) {
	this.transcripcionesDao.setModificarEstadoTarjeta(tarjeta);
    }
    public List getListaGrupoSang(Tarjeta gsang) {
	return this.transcripcionesDao.getListaGrupoSang(gsang);
    }
    public String setLoginKey(Usuarios usuario) {
	return this.usuariosDao.setLoginKey(usuario);
    }
    public String getLoginKey(Usuarios usuario) {
	return this.usuariosDao.getLoginKey(usuario);
    }
//Fin _ supervisor
    public int getTarjetasHoy(Usuarios usuario) {
	return this.transcripcionesDao.getTarjetasHoy(usuario);
    }
    public int getTarjetasTotal(Usuarios usuario) {
	return this.transcripcionesDao.getTarjetasTotal(usuario);
    }
    public String getEstadoTranscriptor(Usuarios usuario) {
	return this.transcripcionesDao.getEstadoTranscriptor(usuario);
    }
    //_ Cambiar Turno
    public void setCambiarTurno(Usuarios usuario) {
	this.administrarUsuariosDao.setCambiarTurno(usuario);
    }
    //Fin  Cambiar Turno
    //_ Turno Modulo
    public void setTurno(Turno turno) {
	this.administrarUsuariosDao.setTurno(turno);
    }
    public void setTurno2(Turno turno) {
	this.administrarUsuariosDao.setTurno2(turno);
    }
    public void setTurnoTmp(Turno turno) {
	this.administrarUsuariosDao.setTurnoTmp(turno);
    }
    public int getTurnoActual(Usuarios usuario) {
	return this.administrarUsuariosDao.getTurnoActual(usuario);
    }
    public int getTurno(Usuarios usuario) {
	return this.administrarUsuariosDao.getTurno(usuario);
    }
    public Turno getTurnoTmp(Usuarios usuario) {
	return this.administrarUsuariosDao.getTurnoTmp(usuario);
    }
    public List getUsuariosTurno() {
	return this.administrarUsuariosDao.getUsuariosTurno();
    }
    //Fin _ Turno Modulo
    public List getLoginUsers() {
	return this.usuariosDao.getLoginUsers();
    }
    public Usuarios getLoginUser(Usuarios usuario) {
	return this.usuariosDao.getLoginUser(usuario);
    }
    public void getLoginRefreshUsers() {
	this.usuariosDao.getLoginRefreshUsers();
    }
    public int getVerUsuario(Usuarios usuario) {
	return this.usuariosDao.getVerUsuario(usuario);
    }
    public Administrativos getAdministrativo(Administrativos administrativo) {
        return this.administrarUsuariosDao.getAdministrativo(administrativo);
    }
    public Servidor getServidor(Servidor servidor) {
        return this.administrarUsuariosDao.getServidor(servidor);
    }
    public void setRegistroTranscripcion(Usuarios usuario) {
        this.transcripcionesDao.setRegistroTranscripcion(usuario);
    }
    public List getListaServidores() {
        return this.administrarUsuariosDao.getListaServidores();
    }
    public void setServidor(Servidor servidor) {
        this.administrarUsuariosDao.setServidor(servidor);
    }   
    public void setCajaServidor(Servidor servidor) {
        this.administrarUsuariosDao.setCajaServidor(servidor);
    }   
    public void setDefaultServer(Servidor servidor) {
        this.administrarUsuariosDao.setDefaultServer(servidor);
    }   
    public Servidor getDefaultServer() {
        return this.administrarUsuariosDao.getDefaultServer();
    }   
    public String getTarjetaVerificar(Usuarios usuario) {
	return this.transcripcionesDao.getTarjetaVerificar(usuario);
    }
    
    //Verificacion Tiempos _
    public Time getLapsoTiempos(int id_tiempos) {
	Tiempos tiempo = new Tiempos();
	tiempo.setId_tiempos(id_tiempos);
	return this.transcripcionesDao.getLapsoTiempos(tiempo);
    }
  
    public int setCalificacionTiempos(int id_tiempos, int calificacion) {
	Tiempos tiempo = new Tiempos();
	tiempo.setId_tiempos(id_tiempos);
	tiempo.setCalificacion(calificacion);
	return this.transcripcionesDao.setCalificacionTiempos(tiempo);
    }
  
    public int setFinTiempos(int id_tiempos) {
	Tiempos tiempo = new Tiempos();
	tiempo.setId_tiempos(id_tiempos);
	return this.transcripcionesDao.setFinTiempos(tiempo);
    }
  
    public int setInicioTiempos(String id_tarjeta, String id_estado, String id_usuario, String id_rol) {
	Tiempos tiempo = new Tiempos();
	tiempo.setId_tarjeta(id_tarjeta);
	tiempo.setId_estado(id_estado);
	tiempo.setId_usuario(id_usuario);
	tiempo.setId_rol(id_rol);
	return this.transcripcionesDao.setInicioTiempos(tiempo);
    }
  
    public int setLapsoTiempos(int id_tiempos, Time lapso) {
	Tiempos tiempo = new Tiempos();
	tiempo.setId_tiempos(id_tiempos);
	tiempo.setLapso(lapso);
	return this.transcripcionesDao.setLapsoTiempos(tiempo);
    }
    
    public int getUltimoIdTiempos(String id_tarjeta) {
	Tiempos tiempo = new Tiempos();
	tiempo.setId_tarjeta(id_tarjeta);
	return this.transcripcionesDao.getUltimoIdTiempos(tiempo);
    }
    //Fin Verificacion Tiempos _
    public Personas getPersona(Personas persona){
        return this.personasDao.getPersona(persona);
    }
    public Usuarios getUsuario(Usuarios usuario){
        return this.usuariosDao.getUsuario(usuario);
    }

    public String getUsrCnx(Usuarios usuario) {
	return this.usuariosDao.getUsrCnx(usuario);
    }
    public String getUsrTurno(Usuarios usuario) {
	return this.usuariosDao.getUsrTurno(usuario);
    }
    public String setUsrTurno(Usuarios usuario) {
	return this.usuariosDao.setUsrTurno(usuario);
    }
    public void setCalificacionUsr(Tarjeta datos) {
        this.transcripcionesDao.setCalificacionUsr(datos);
    }
    public void setCalificacionSistema(Tarjeta datos) {
        this.transcripcionesDao.setCalificacionSistema(datos);
    }
    public void setPrepararGuardar(Tarjeta datos) {
        this.transcripcionesDao.setPrepararGuardar(datos);
    }
    public List getUsrsTurno(Usuarios usuario) {
        return this.usuariosDao.getUsrsTurno(usuario);
    }
    public String getIdSrvByBoxName(String cod_img) {
        return this.administrarUsuariosDao.getIdSrvByBoxName(cod_img);
    }
    //jvr
    public String getTarjetasRevertir(String id_usuario) {
        return this.transcripcionesDao.getTarjetasRevertir(id_usuario);
    }

    public void setRegistroBeneficiario(Beneficiario benefi) {
        this.personasDao.setRegistroBeneficiario(benefi);
    }

    public void setRegistroSucursalBeneficiario(Beneficiario benefi) {
        this.personasDao.setRegistroSucursalBeneficiario(benefi);
    }

    public Beneficiario getMostrarSucursal(Beneficiario Sucursal) {
        return this.personasDao.getMostrarSucursal(Sucursal);
    }

    public void updateModificarDatosSucursal(Beneficiario benefi) {
        this.personasDao.updateModificarDatosSucursal(benefi);
    }

    public void setEliminaBeneficiario(Beneficiario benefi) {
        this.personasDao.setEliminaBeneficiario(benefi);
    }

    public void setEliminaSucursales(Beneficiario benefi) {
        this.personasDao.setEliminaSucursales(benefi);
    }

    public Beneficiario getMostrarBeneficiario(Beneficiario benefi) {
        return this.personasDao.getMostrarBeneficiario(benefi);
    }

    public List getListarSucursales(String nit) {
        return this.personasDao.getListarSucursales(nit);
    }

    public void updateModificarDatosBeneficiario(Beneficiario benefi) {
        this.personasDao.updateModificarDatosBeneficiario(benefi);
    }



    public List getListarBeneficiarioPorNombre(String nombrep) {
        return this.personasDao.getListarBeneficiarioPorNombre(nombrep);
    }

    public List getListarBeneficiarioPorNit(String nit) {
        return this.personasDao.getListarBeneficiarioPorNit(nit);
    }

    public void setEliminaSucursal(Beneficiario benefi) {
        this.personasDao.setEliminaSucursal(benefi);
    }

      public double getTotalPresupuestadoTareaFuente(InsPreIng oie) {
        return this.personasDao.getTotalPresupuestadoTareaFuente(oie);
    }

    public double getTotalEjecutadoTareaFuenteEgr(InsPreIng oie) {
        return this.personasDao.getTotalEjecutadoTareaFuenteEgr(oie);
    }

    public double getTotalEjecutadoNoPresupuestadoTareaFuenteEgr(InsPreIng oie) {
        return this.personasDao.getTotalEjecutadoNoPresupuestadoTareaFuenteEgr(oie);
    }

    public double getTotalEjecutadoIngresos(InsPreIng oie) {
        return this.personasDao.getTotalEjecutadoIngresos(oie);
    }

    public double getTotalEjecutadoIngresosNoPresupuestado(InsPreIng oie) {
        return this.personasDao.getTotalEjecutadoIngresosNoPresupuestado(oie);
    }

    public double getTotalComprometidoByTareaAndFuente(InsPreIng oie) {
        return this.personasDao.getTotalComprometidoByTareaAndFuente(oie);
    }

    public List getFuentesDeTareasByUsuario(carreras car) {
        return this.personasDao.getFuentesDeTareasByUsuario(car);
    }

    public List getActividadesByUsuario(carreras car) {
        return this.personasDao.getActividadesByUsuario(car);
    }

    public List getTareasByUsuarioAndActividad(carreras car) {
        return this.personasDao.getTareasByUsuarioAndActividad(car);
    }

    public List getFuentesAndMontosEjecutadosByTarea(ProActTar tarea) {
        return this.personasDao.getFuentesAndMontosEjecutadosByTarea(tarea);
    }

    public List getListActividad() {
        return this.administrarUsuariosDao.getListActividad();
    }

    public List getListAllFuentesFinanciamiento() {
        return this.administrarUsuariosDao.getListAllFuentesFinanciamiento();
    }

    public List getListAllTareaByActividad(ProActTar actividad) {
        return this.administrarUsuariosDao.getListAllTareaByActividad(actividad);
    }

    public Personas getNombresByIdUsuario(String id_usuario_creador_cert) {
        return this.personasDao.getNombresByIdUsuario(id_usuario_creador_cert);
    }
}
