package org.springframework.eam.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Registro;

public interface RegistroDao {
//_ _
  void setActualizarParametros(Registro registro) throws DataAccessException;
}