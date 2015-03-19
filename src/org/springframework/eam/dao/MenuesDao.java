package org.springframework.eam.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Menues;

public interface MenuesDao {

// SECCION DE TRABAJO CON LA TABLA CATEGORIAS
  List getCategorias(String id_programa, String id_rol) throws DataAccessException;
// SECCION DE TRABAJO CON LA TABLA ENLACES
  List getEnlaces(String id_categoria, String id_rol, String id_programa) throws DataAccessException;
//******** Menues  ****** // 
  /* Enlaces de los roles */
  List getEnlacesRoles(String id_rol,String id_programa) throws DataAccessException;
  Menues getFechasEnlaces(int id_enlace) throws DataAccessException;

  void setActualizarMenues(Menues actualizar) throws DataAccessException;
/** Menues     */
  void setAdministrarMenues(Menues menu) throws DataAccessException;  
  //********* Fin Memues ******/
}