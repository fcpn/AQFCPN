package org.springframework.eam.dao.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapDaoSupport;
import org.springframework.eam.dao.MenuesDao;
import org.springframework.eam.domain.Menues;

public class SqlMapMenuesDao extends SqlMapDaoSupport implements MenuesDao {

  public List getCategorias(String id_programa, String id_rol) throws DataAccessException {
    Menues categorias = new Menues();
    categorias.setId_programa(id_programa);
    categorias.setId_rol(id_rol);
    return getSqlMapTemplate().executeQueryForList("getCategorias", categorias);
  }

  public List getEnlaces(String id_categoria, String id_rol, String id_programa) throws DataAccessException {
    Menues enlace = new Menues();
    enlace.setId_categoria(id_categoria);
    enlace.setId_programa(id_programa);
    enlace.setId_rol(id_rol);
    return getSqlMapTemplate().executeQueryForList("getEnlaces", enlace);
  }
  
  public List getEnlacesRoles(String id_rol, String id_programa) throws DataAccessException {
    Menues enlaces = new Menues();
    enlaces.setId_rol(id_rol);
    enlaces.setId_programa(id_programa);
    return getSqlMapTemplate().executeQueryForList("getEnlacesRoles", enlaces);
  }


  public Menues getFechasEnlaces(int id_enlace) throws DataAccessException {
    Menues fechas = new Menues();
    fechas.setId_enlace(id_enlace);
    return (Menues) getSqlMapTemplate().executeQueryForObject("getFechasEnlaces", fechas);
  }

  public void setActualizarMenues(Menues actualizar) throws DataAccessException {
     getSqlMapTemplate().executeUpdate("setActualizarMenues", actualizar);
  }


  public void setAdministrarMenues(Menues menu) throws DataAccessException {
    getSqlMapTemplate().executeUpdate("setAdministrarMenues", menu);
    
  }
  
}