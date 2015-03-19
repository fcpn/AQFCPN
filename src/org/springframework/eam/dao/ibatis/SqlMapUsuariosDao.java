package org.springframework.eam.dao.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapDaoSupport;
import org.springframework.eam.dao.UsuariosDao;
import org.springframework.eam.domain.Usuarios;
import org.springframework.eam.domain.UsuariosLogin;

public class SqlMapUsuariosDao extends SqlMapDaoSupport implements UsuariosDao {
    
    
//METODOS PRIVADOS
// Start _ New Login **** Private Methods ****
    private String getUserString(Usuarios usuario) throws DataAccessException {
        return (String) getSqlMapTemplate().executeQueryForObject("getUserString", usuario);
    }
    private Usuarios getUserAccount(Usuarios usuario) throws DataAccessException {
        return (Usuarios) getSqlMapTemplate().executeQueryForObject("getUserAccount", usuario);
    }
    private List getRolesDelUsuario(Usuarios usuario) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getRolesDelUsuario", usuario);
    }
    private Usuarios getUsuarioNombres(Usuarios usuario) throws DataAccessException {
        return (Usuarios) getSqlMapTemplate().executeQueryForObject("getUsuarioNombres", usuario);
    }
// END _ New Login **** Private Methods ****

    //METODOS PUBLICOS
    public Usuarios getConexion(String id_usuario, String clave) throws DataAccessException {
        Usuarios usuario = new Usuarios();
        usuario.setId_usuario(id_usuario);
        usuario.setClave(clave);

        id_usuario = this.getUserString(usuario);//sacando el status segun el los datos del usuario introducidos en el login
        if (id_usuario.equals("")) {
                usuario.setNombres("");
        } else {
            usuario.setId_usuario(id_usuario);
            /* id_programa, programa, id_tipo_usuario, tipo_usuario = getUsrAccount()*/
            Usuarios u = (Usuarios) this.getUserAccount(usuario);


            usuario.setId_programa(u.getId_programa());
            usuario.setPrograma(u.getPrograma());
            usuario.setId_tipo_usuario(u.getId_tipo_usuario());
            usuario.setTipo_usuario(u.getTipo_usuario());

            usuario.setRoles(this.getRolesDelUsuario(usuario));// listado de roles a disposicion
            
            /* otras variables de sesion */
	    Usuarios uaux = (Usuarios) this.getUsuarioNombres(usuario);// sale idpersona y nombres


            usuario.setNombres(uaux.getNombres());
            usuario.setId_persona(uaux.getId_persona());
        }                
        return usuario;
    }
    
    public void setControlarSalida(String id_usuario) throws DataAccessException {
        Usuarios ingreso = new Usuarios();
        ingreso.setId_usuario(id_usuario);
        getSqlMapTemplate().executeQueryForObject("setControlarSalida", ingreso);
    }
    public void setControlarIngreso(String id_usuario,String id_rol) throws DataAccessException {
        Usuarios ingreso = new Usuarios();
        ingreso.setId_usuario(id_usuario);
        ingreso.setId_rol(id_rol);
        getSqlMapTemplate().executeQueryForObject("setControlarIngreso", ingreso);
    }
    
// Cambio de Pin _
    
    public List getUsuarioClave(String id_programa,String id_usuario,String clave) throws DataAccessException {
        Usuarios usuario = new Usuarios();
        usuario.setId_programa(id_programa);
        usuario.setId_usuario(id_usuario);
        usuario.setClave(clave);
        return getSqlMapTemplate().executeQueryForList("getUsuarioClave", usuario);
    }
    
    public void setActualizarClave(Usuarios actualizar) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setActualizarClave", actualizar);
    }
// Cambio de Pin _
    public int getRespuesta() throws DataAccessException {
        Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getRespuesta",null);
        return i.intValue();
    }

  public void setEliminarUsuario(Usuarios eliminar) throws DataAccessException {
     getSqlMapTemplate().executeUpdate("setEliminarUsuario", eliminar);
  }

    //_ supervisor
    public List getListUsuarios() {
        return getSqlMapTemplate().executeQueryForList("getListUsuario", null);
    }
    
  public String setLoginKey(Usuarios usuario) throws DataAccessException {
     return (String) getSqlMapTemplate().executeQueryForObject("setLoginKey", usuario);
  }
  public String getLoginKey(Usuarios usuario) throws DataAccessException {
     return (String) getSqlMapTemplate().executeQueryForObject("getLoginKey", usuario);
  }
    //Fin _ supervisor
    public List getLoginUsers() {
        return getSqlMapTemplate().executeQueryForList("getLoginUsers", null);
    }
    public Usuarios getLoginUser(Usuarios usuario) {
        return (Usuarios) getSqlMapTemplate().executeQueryForObject("getLoginUser", usuario);
    }
    public void getLoginRefreshUsers() {
        getSqlMapTemplate().executeUpdate("getLoginRefreshUsers", null);
    }
    public int getVerUsuario(Usuarios usuario) throws DataAccessException {
        Integer i = (Integer) getSqlMapTemplate().executeQueryForObject("getVerUsuario",usuario);
        return i.intValue();
    }
    
    public Usuarios getUsuario(Usuarios usuario) throws DataAccessException {
        return (Usuarios) getSqlMapTemplate().executeQueryForObject("getUsuario",usuario);
    }

  public String getUsrCnx(Usuarios usuario) throws DataAccessException {
     return (String) getSqlMapTemplate().executeQueryForObject("getUsrCnx", usuario);
  }
  public String getUsrTurno(Usuarios usuario) throws DataAccessException {
     return (String) getSqlMapTemplate().executeQueryForObject("getUsrTurno", usuario);
  }
  public String setUsrTurno(Usuarios usuario) throws DataAccessException {
     return (String) getSqlMapTemplate().executeQueryForObject("setUsrTurno", usuario);
  }
  public List getUsrsTurno(Usuarios usuario) throws DataAccessException {
     return getSqlMapTemplate().executeQueryForList("getUsrsTurno", usuario);
  }
}
