package org.springframework.eam.dao.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.StringTokenizer;

import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.carreras;
import org.springframework.orm.ibatis.support.SqlMapDaoSupport;
import org.springframework.eam.dao.AdministrarUsuariosDao;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.Menues;
import org.springframework.eam.domain.Turno;
import org.springframework.eam.domain.Administrativos;
import org.springframework.eam.domain.Servidor;
import org.springframework.eam.domain.Tarjeta;

public class SqlMapAdministrarUsuariosDao extends SqlMapDaoSupport implements AdministrarUsuariosDao {
//_ _ - Administrar Usuarios *****************************************
  public List getUsuariosPrograma(String id_programa) throws DataAccessException {
    Usuarios usuario = new Usuarios();
    usuario.setId_programa(id_programa);
    return getSqlMapTemplate().executeQueryForList("getUsuariosPrograma", usuario);
  }
  //_ Cambiar Turno
  public void setCambiarTurno(Usuarios usuario) throws DataAccessException {
    if (usuario.getId_turno() == 1) {
	usuario.setId_turno(2);
    } else {
	usuario.setId_turno(1);
    }
    getSqlMapTemplate().executeUpdate("setCambiarTurno", usuario);
  }
  //Fin _ Cambiar Turno
  //_ Turno Modulo
  public void setTurno(Turno turno) throws DataAccessException {
    getSqlMapTemplate().executeQueryForObject("setTurno", turno);
  }
  public void setTurno2(Turno turno) throws DataAccessException {
    getSqlMapTemplate().executeQueryForObject("setTurno2", turno);
  }
  public void setTurnoTmp(Turno turno) throws DataAccessException {
    getSqlMapTemplate().executeQueryForObject("setTurnoTmp", turno);
  }
  public int getTurnoActual(Usuarios usuario) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getTurnoActual", usuario);
    return i.intValue();
  }
  public int getTurno(Usuarios usuario) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getTurno", usuario);
    return i.intValue();
  }
  public Turno getTurnoTmp(Usuarios usuario) throws DataAccessException {
    Turno turno = new Turno();
    turno.setId_usuario(usuario.getId_usuario());
    Turno turno2 = (Turno) getSqlMapTemplate().executeQueryForObject("getTurnoTmp", turno);
    return turno2;
  }
  public List getUsuariosTurno() throws DataAccessException {
    Usuarios usuario = new Usuarios();
    return getSqlMapTemplate().executeQueryForList("getUsuariosTurno", usuario);
  }
  //Fin _ Turno Modulo
  public int setRegistrarUsuariosAdm(Usuarios usuario) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setRegistrarUsuariosAdm", usuario);
    return i.intValue();
  }
  public int getId_usuario(String id_usuario) throws DataAccessException {
    Usuarios usuario = new  Usuarios();
    usuario.setId_usuario(id_usuario);
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getId_usuario", usuario);
    return i.intValue();
  }
  public int setRegistrarUsuariosRoles(Usuarios usuario) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setRegistrarUsuariosRoles", usuario);
    return i.intValue();
  }





  //Jes
  public void setRegistrarUsuariosyRoles(Usuarios usuario) throws DataAccessException {
    getSqlMapTemplate().executeQueryForObject("setRegistrarUsuariosyRoles", usuario);
  }

    public List getListarTareas(ProActTar proActTar) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListarTareas", proActTar);
    }

    public ProActTar getActividad(ProActTar tta) throws DataAccessException {
        return (ProActTar) getSqlMapTemplate().executeQueryForObject("getActividad", tta);
    }

    public ProActTar getTarea(ProActTar ttar) throws DataAccessException {
        return (ProActTar) getSqlMapTemplate().executeQueryForObject("getTarea", ttar);
    }

    public void setCarreasRelacionUsuario(carreras relacion) throws DataAccessException {        
        getSqlMapTemplate().executeUpdate("setCarreasRelacionUsuario", relacion);
    }

    public List getListaTareasUsuario(carreras relacion_usuario) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaTareasUsuario", relacion_usuario);
    }

    public void setEliminaRelacionTareasUsuarios(carreras tareasUsuario) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setEliminaRelacionTareasUsuarios", tareasUsuario);
    }

    public void setEliminarLoginStatus(Usuarios us) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setEliminarLoginStatus", us);
    }

    public void setElimiarAdministrativo(Administrativos ads) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setElimiarAdministrativo", ads);
    }

    public void setEliminaPersona(Personas per) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setEliminaPersona", per);
    }



  public int setActualizarUsuariosRoles(Usuarios usuario) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setActualizarUsuariosRoles", usuario);
    return i.intValue();
  }
  public int setEliminarUsuariosRoles(Usuarios usuario) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setEliminarUsuariosRoles", usuario);
    return i.intValue();
  }
  public int setRegistrarAdministrativo(Administrativos administrativo) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setRegistrarAdministrativo", administrativo);
    return i.intValue();
  }
  public List getRolesUsuario(Usuarios usuario) throws DataAccessException {
    return getSqlMapTemplate().executeQueryForList("getRolesUsuario", usuario);
  }
  public int getKeySecurity(Menues menu) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getKeySecurity", menu);
    return i.intValue();
  }
  public int setActualizarUsuarioAdm(Usuarios usuario) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setActualizarUsuarioAdm", usuario);
    return i.intValue();
  }
  public int setActualizarAdministrativo(Administrativos administrativo) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setActualizarAdministrativo", administrativo);
    return i.intValue();
  }
  public void setBorrarRolesUsuario(Usuarios usuario) throws DataAccessException {
    getSqlMapTemplate().executeUpdate("setBorrarRolesUsuario", usuario);
  }
  public void setBorrarLoginHistorico(Usuarios usuario) throws DataAccessException {
    getSqlMapTemplate().executeUpdate("setBorrarLoginHistorico", usuario);
  }

  public int setActualizarClaveKar(Usuarios usuario) throws DataAccessException {
    Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("setActualizarClaveKar", usuario);
    return i.intValue();
  }
  public Administrativos getAdministrativo(Administrativos administrativo) throws DataAccessException {
     return (Administrativos) getSqlMapTemplate().executeQueryForObject("getAdministrativo",administrativo);
  }
  public Servidor getServidor(Servidor servidor) throws DataAccessException {
     return (Servidor) getSqlMapTemplate().executeQueryForObject("getServidor",servidor);
  }
  public List getListaServidores() throws DataAccessException {
     return getSqlMapTemplate().executeQueryForList("getListaServidores",null);
  }
  public void setServidor(Servidor servidor) throws DataAccessException {
      String res = (String) getSqlMapTemplate().executeQueryForObject("setServidor",servidor);
  }
  public void setCajaServidor(Servidor servidor) throws DataAccessException {
      String res = (String) getSqlMapTemplate().executeQueryForObject("setCajaServidor",servidor);
  }
  public void setDefaultServer(Servidor servidor) throws DataAccessException {
      String res = (String) getSqlMapTemplate().executeQueryForObject("setDefaultServer",servidor);
  }
  public Servidor getDefaultServer() throws DataAccessException {
     return (Servidor) getSqlMapTemplate().executeQueryForObject("getDefaultServer",null);
  }
  public String getIdSrvByBoxName(String cod_img) throws DataAccessException {
      Tarjeta tarjeta = new Tarjeta();
      tarjeta.setCod_img(cod_img);
      return (String) getSqlMapTemplate().executeQueryForObject("getIdSrvByBoxName",tarjeta);
  }
//FIN  

    @Override
    public List getFuentesAndMontosEjecutadosByTarea() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getListActividad() {
        return getSqlMapTemplate().executeQueryForList("getListActividad", null);
    }

    public List getListAllFuentesFinanciamiento() throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListAllFuentesFinanciamiento", null);
    }

    public List getListAllTareaByActividad(ProActTar actividad) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListAllTareaByActividad", actividad);
    }

    
}
