package org.springframework.eam.dao.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.StringTokenizer;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapDaoSupport;
import org.springframework.eam.dao.RegistroDao;
import org.springframework.eam.domain.Registro;

public class SqlMapRegistroDao extends SqlMapDaoSupport implements RegistroDao {
//_ _   
  public void setActualizarParametros(Registro registro) throws DataAccessException {
    getSqlMapTemplate().executeUpdate("setActualizarParametros", registro);
  }
}
