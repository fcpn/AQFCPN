package org.springframework.eam.dao.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapDaoSupport;
import org.springframework.eam.dao.RolesDao;
import org.springframework.eam.domain.Roles;

public class SqlMapRolesDao extends SqlMapDaoSupport implements RolesDao {

//_ _
  public List getRolesPrograma(String id_programa) {
    Roles rol = new Roles();
    rol.setId_programa(id_programa);
    return getSqlMapTemplate().executeQueryForList("getRolesPrograma", rol);
  }
//FIN _
}