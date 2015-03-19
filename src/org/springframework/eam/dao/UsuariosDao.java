package org.springframework.eam.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Usuarios;

public interface UsuariosDao {
  Usuarios getConexion(String id_usuario, String clave) throws DataAccessException;
  void setControlarIngreso (String id_usuario,String id_rol) throws DataAccessException;
  void setControlarSalida (String id_usuario) throws DataAccessException;

// Cambio de Pin

  List getUsuarioClave(String id_programa,String id_usuario,String clave) throws DataAccessException; 

  void setActualizarClave(Usuarios actualizar) throws DataAccessException;  
// Fin Cambio de Pin 
  int getRespuesta() throws DataAccessException;  
  void setEliminarUsuario(Usuarios eliminar) throws DataAccessException;  
  
  // supervision
  List getListUsuarios() throws DataAccessException;
  String setLoginKey(Usuarios usuario) throws DataAccessException;  
  String getLoginKey(Usuarios usuario) throws DataAccessException;  
  //Fin supervision
  List getLoginUsers() throws DataAccessException;
  Usuarios getLoginUser(Usuarios usuario) throws DataAccessException;
  void getLoginRefreshUsers() throws DataAccessException;
  int getVerUsuario(Usuarios usuario) throws DataAccessException;
  Usuarios getUsuario(Usuarios usuarios) throws DataAccessException;
  String getUsrCnx(Usuarios usuario) throws DataAccessException;  
  String getUsrTurno(Usuarios usuario) throws DataAccessException;  
  String setUsrTurno(Usuarios usuario) throws DataAccessException;  
  List getUsrsTurno(Usuarios usuario) throws DataAccessException;
  
}
