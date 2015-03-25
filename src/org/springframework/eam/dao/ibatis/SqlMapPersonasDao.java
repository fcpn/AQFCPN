/*Estructura elaborada por: John Castillo Valencia*/
package org.springframework.eam.dao.ibatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.StringTokenizer;

import org.springframework.dao.DataAccessException;
import org.springframework.eam.domain.Beneficiario;
import org.springframework.orm.ibatis.support.SqlMapDaoSupport;
import org.springframework.eam.dao.PersonasDao;
import org.springframework.eam.domain.Comprometido;
import org.springframework.eam.domain.InsPreIng;
import org.springframework.eam.domain.Personas;
import org.springframework.eam.domain.ProActTar;
import org.springframework.eam.domain.carreras;

public class SqlMapPersonasDao extends SqlMapDaoSupport implements PersonasDao {

    public List getPaises() throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getPaises", null);
    }

    public List getDepartamentos() throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getDepartamentos", null);
    }

    public List getListarDepartamentos(int id_pais) throws DataAccessException {
        Personas l_departamentos = new Personas();
        l_departamentos.setId_pais(id_pais);
        return getSqlMapTemplate().executeQueryForList("getListarDepartamentos", l_departamentos);
    }

    public List getListaEstadoCivil() throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListaEstadoCivil", null);
    }

    public Personas getEstadoCivil(int id_estado_civil) {
        Personas persona = new Personas();
        persona.setId_estado_civil(id_estado_civil);
        return (Personas) getSqlMapTemplate().executeQueryForObject("getEstadoCivil", persona);
    }

    public Personas getPais(int id_pais) throws DataAccessException {
        Personas persona_g = new Personas();
        persona_g.setId_pais(id_pais);
        return (Personas) getSqlMapTemplate().executeQueryForObject("getPais", persona_g);
    }

    public Personas getDepartamento(int id_departamento) throws DataAccessException {
        Personas persona_g = new Personas();
        persona_g.setId_departamento(id_departamento);
        return (Personas) getSqlMapTemplate().executeQueryForObject("getDepartamento", persona_g);
    }
// _ _ - REgistrar persona 5 Ibatis

    public Personas setRegistrarPersona(Personas persona) throws DataAccessException {
        return (Personas) getSqlMapTemplate().executeQueryForObject(persona.getZona(), persona);
    }

// fin _
    //jes
    public void updateModificarPersona(Personas persona) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("updateModificarPersona", persona);
    }
  //fin jes
    // ********** _ Search *****************  
    public Personas getBuscarPersonaId(Personas persona) throws DataAccessException {
        return (Personas) getSqlMapTemplate().executeQueryForObject("getBuscarPersonaId", persona);
    }

    public List getBuscarPersonaCi(Personas persona) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getBuscarPersonaCi", persona);
    }

    public List getBuscarPersonaNombres(Personas persona) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getBuscarPersonaNombres", persona);
    }

    // ************* End sear methods ********* 
    public Personas getPersona(Personas persona) throws DataAccessException {
        return (Personas) getSqlMapTemplate().executeQueryForObject("getPersona", persona);
    }
    /*Beneficiarios*/

    public void setRegistroBeneficiario(Beneficiario benefi) throws DataAccessException {
        Beneficiario ben = new Beneficiario();
        ben.setNit(benefi.getNit());
        ben.setProveedor(benefi.getProveedor());
        getSqlMapTemplate().executeUpdate("setRegistroBeneficiario", ben);

        Beneficiario suc = new Beneficiario();
        suc.setNit(benefi.getNit());
        suc.setProveedor(benefi.getProveedor());
        suc.setTelefonos(benefi.getTelefonos());
        suc.setDireccion(benefi.getDireccion());
        getSqlMapTemplate().executeUpdate("setRegistroSucursalBeneficiario", suc);
    }

    public void setRegistroSucursalBeneficiario(Beneficiario benefi) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setRegistroSucursalBeneficiario", benefi);
    }

    public void updateModificarDatosBeneficiario(Beneficiario benefi) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("updateModificarDatosBeneficiario", benefi);
    }

    public Beneficiario getMostrarSucursal(Beneficiario Sucursal) throws DataAccessException {
        return (Beneficiario) getSqlMapTemplate().executeQueryForObject("getMostrarSucursal", Sucursal);
    }

    public void updateModificarDatosSucursal(Beneficiario benefi) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("updateModificarDatosSucursal", benefi);
    }

    public void setEliminaBeneficiario(Beneficiario benefi) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setEliminaBeneficiario", benefi);
    }

    public void setEliminaSucursales(Beneficiario benefi) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setEliminaSucursales", benefi);
    }

    public Beneficiario getMostrarBeneficiario(Beneficiario benefi) throws DataAccessException {
        return (Beneficiario) getSqlMapTemplate().executeQueryForObject("getMostrarBeneficiario", benefi);
    }

    public List getListarSucursales(String nit) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListarSucursales", nit);
    }

    public List getListarBeneficiarioPorNombre(String nombrep) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListarBeneficiarioPorNombre", nombrep);
    }

    public List getListarBeneficiarioPorNit(String nit) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getListarBeneficiarioPorNit", nit);
    }

    public void setEliminaSucursal(Beneficiario benefi) throws DataAccessException {
        getSqlMapTemplate().executeUpdate("setEliminaSucursal", benefi);
    }

    public double getTotalPresupuestadoTareaFuente(InsPreIng oie) throws DataAccessException {
        try {
            InsPreIng sm = (InsPreIng) getSqlMapTemplate().executeQueryForObject("getTotalPresupuestadoTareaFuente", oie);
            if (sm != null) {
                return Double.valueOf(sm.getMontopresu());
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    public double getTotalEjecutadoTareaFuenteEgr(InsPreIng oie) throws DataAccessException {
        try {
            InsPreIng sm = (InsPreIng) getSqlMapTemplate().executeQueryForObject("getTotalEjecutadoTareaFuenteEgr", oie);
            if (sm != null) {
                return Double.valueOf(sm.getMontoeje());
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    public double getTotalEjecutadoNoPresupuestadoTareaFuenteEgr(InsPreIng oie) throws DataAccessException {
        try {
            InsPreIng sm = (InsPreIng) getSqlMapTemplate().executeQueryForObject("getTotalEjecutadoNoPresupuestadoTareaFuenteEgr", oie);
            if (sm != null) {
                return Double.valueOf(sm.getMontoeje());
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    public double getTotalEjecutadoIngresos(InsPreIng oie) throws DataAccessException {
        try {
            InsPreIng sm = (InsPreIng) getSqlMapTemplate().executeQueryForObject("getTotalEjecutadoIngresos", oie);
            if (sm != null) {
                return Double.valueOf(sm.getMontoeje());
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    public double getTotalEjecutadoIngresosNoPresupuestado(InsPreIng oie) throws DataAccessException {
        try {
            InsPreIng sm = (InsPreIng) getSqlMapTemplate().executeQueryForObject("getTotalEjecutadoIngresosNoPresupuestado", oie);
            if (sm != null) {
                return Double.valueOf(sm.getMontoeje());
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    public double getTotalComprometidoByTareaAndFuente(InsPreIng oie) throws DataAccessException {
        try {
            InsPreIng sm = (InsPreIng) getSqlMapTemplate().executeQueryForObject("getTotalComprometidoByTareaAndFuente", oie);
            if (sm != null) {
                return Double.valueOf(sm.getMontoeje());
            }

        } catch (Exception e) {
            return 0;
        }
        return 0;
    }

    public List getFuentesDeTareasByUsuario(carreras car) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getFuentesDeTareasByUsuario", car);
    }

    public List getActividadesByUsuario(carreras car) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getActividadesByUsuario", car);
    }
    
    public List getTareasByUsuarioAndActividad(carreras car) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getTareasByUsuarioAndActividad", car);
    }
//che
    public List getFuentesAndMontosEjecutadosByTarea(ProActTar tarea) throws DataAccessException {
        return getSqlMapTemplate().executeQueryForList("getFuentesAndMontosEjecutadosByTarea", tarea);
    }

    public Personas getNombresByIdUsuario(String id_usuario_creador_cert) throws DataAccessException {
        
        Personas persona = (Personas) getSqlMapTemplate().executeQueryForObject("getNombresByIdUsuario", id_usuario_creador_cert);
        if (persona != null) {
            return persona;
        }else{
            persona.setNombres("");
            return persona;
        }
        
    }

    public Comprometido getObjRefComproById(Comprometido c) throws DataAccessException {
        return (Comprometido) getSqlMapTemplate().executeQueryForObject("getObjRefComproById", c);
    }
}
