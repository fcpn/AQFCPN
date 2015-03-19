/*
 * mconexion.java
 *
 * Created on 6 de marzo de 2006, 18:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package org.springframework.eam.web.spring.Ajayu_morm;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author root
 */
public class mconexion {
    
    /** Creates a new instance of mconexion */
    private List conexiones;
    public mconexion() {
        System.out.println("datos");
        conexiones = new ArrayList();
	//  incluir las conexiones y colocarles un nombre
	//  this.incluirConexion(direccio,usuario,clave,nombre_conexion);                
        this.incluirConexion("jdbc:postgresql://localhost:5432/aquilesfcpn","postgres","postgres","url1");
        
    //this.incluirConexion("jdbc:postgresql://localhost:5432/matriculacion","root","","url2");                
    }
    public void incluirConexion(String conexion,String usuario,String clave,String nombre){
        tconexion con = new tconexion();
        con.conexion = conexion;
        con.usuario = usuario;
        con.clave = clave;
        con.nombre = nombre;
        conexiones.add(con);        
    }
    public String extraerConexion(String conexion){
        boolean fin;
        int i;
        i = 0;
        fin = false;
        String conexion2;
        conexion2="";
        while (!fin){
            if (i < conexiones.size()){
                tconexion con = (tconexion) conexiones.get(i);                
                if (con.nombre.equals(conexion)){
                    conexion2 = con.conexion+";"+con.usuario+";"+con.clave+";";
                    fin = true;
                }
                i++;                
            } else {
                fin = true;
            }                            
        }        
        return conexion2;
    }            
}
