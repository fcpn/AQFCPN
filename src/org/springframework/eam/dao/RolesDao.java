package org.springframework.eam.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Roles;

public interface RolesDao {
//_ _
  List getRolesPrograma(String id_programa) throws DataAccessException;
//FIN _  
}