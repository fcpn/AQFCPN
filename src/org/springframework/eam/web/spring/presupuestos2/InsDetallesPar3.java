
package org.springframework.eam.web.spring.presupuestos2;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.Rubro;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsDetallesPar3 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();
        
        String codpar=request.getParameter("codpar");
        String desdes=request.getParameter("desdes");
        String ref123=request.getParameter("ref123");
        // String codgru_ru=request.getParameter("codgru_ru");
       ///     System.out.println(codpar);
       //   System.out.println(desdes);
       //   System.out.println(ref123);
       orm_bd orm = new orm_bd();//llamando a la tabla _orm
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1
        //parametros
        //ProActTar gr=new ProActTar();
        //gr.setCodsub_ru(codigo);
       // gr.setCodpro(codpro);
        //gr.setCodgru_ru(codgru_ru);
        //gr.setDescripcion(descripcion);
        
        Rubro pa=new Rubro();
        pa.setCodpartida(codpar);
        pa.setDescripciones(desdes);
        pa.setRef123(ref123);
        orm.ejecutarObjeto("clasificador","insertadetallespar",pa,null);
        //modelo.put("partida",pa);
        //Rubro paa=new Rubro();
        pa.setCodpartida(codpar);
        pa.setRef123(ref123);
        orm.ejecutarObjeto("clasificador","mostrardetallesparins",pa,pa);
        modelo.put("partidadetalle",pa);
        
        
        
        pa.setCodigo(codpar);
        orm.ejecutarObjeto("clasificador","mostrandopar",pa,pa);
        modelo.put("partida",pa);
        //gr.setCodsub_ru(codsub_ru);
        //gr.setCodgru_ru(descripcion);
        //GrupoRubro grr= new GrupoRubro();
        ////orm.ejecutarObjeto("clasificador","insertar_rubro",entra,sale);
       // List partida=orm.ejecutarLista("clasificador","mostrandopar",null,new Rubro());
       
        //System.out.println(gr.getCodacti());
         
       // modelo.put("partida",partida);
        
        // List sg = orm.ejecutarLista("clasificador","mostrar_subgrupos_in",gr,new GrupoRubro()); //llamano al _orm la consulta
        // modelo.put("grupos",gr);
        orm.cerrar();//cerrar la conexion
     
        
        return new ModelAndView("presupuestos2/clasificador/InsDetallesPar3", modelo);
    }
    
}