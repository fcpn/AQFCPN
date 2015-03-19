
package org.springframework.eam.web.spring.certificacion;

import Ajayu_orm.orm_bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.eam.domain.classcertificacion;

import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.eam.web.spring.Ajayu_morm.mconexion;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class cert4 implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

        //'lik='+requerimiento+'&codtar='+codtar+'&monto='+monto+'&partida='+partida+'$codfueneco='+codfueneco;
       
        String codtar=request.getParameter("codtar");
        String partida=request.getParameter("codmonegr");
        String codfueneco = request.getParameter("codfueneco");
        String id=request.getParameter("id");
        //lik="%"+lik+"%";

    
        //String codtar=request.getParameter("codtar");
        //modelo.put("codtar",codtar);
        System.out.println("CODIGO de TAREA ----------> "+codtar);//codtar
        System.out.println("codmonegr       ----------> "+partida);// codigo de partida
        System.out.println("codfueneco      ----------> "+codfueneco);//codigo de fuente economica
        System.out.println("ID              ----------> "+id);//idenetificacion del registro id en la tabl aes de tipo serial
      
        orm_bd orm = new orm_bd();//llamando a la tabla _orma
        orm.verCompilado = "C";
        mconexion m = new mconexion();//conexion a la base de datos
        orm.establecerConexion(m.extraerConexion("url1"));//conexion establecida con url1

/*insertando datos a la tabla temporal*/
       classcertificacion innn=new classcertificacion();

        innn.setCodmonegr(partida);
        innn.setCodtar(codtar);
        innn.setId(id);
        innn.setCodfueneco(codfueneco);
        orm.ejecutarObjeto("certificacion","borrar_a_tmp",innn,null);
        // delete from tmp_comprometido where codmonegr=#codmonegr# and codtar=#codtar# and codfueneco=#codfueneco# and id=#id#

/* FIN FIN FIN FIN FIN insertando datos a la tabla temporal*/
        classcertificacion regtem=new classcertificacion();
        regtem.setCodtar(codtar);
        // tarr.setCodfueneco(codfueneco);
        List lis_certi_proceso=orm.ejecutarLista("certificacion", "mostrar_certificacion_proceso", regtem, new classcertificacion());
        modelo.put("lis_certi_proceso",lis_certi_proceso);
        // insert into refcompro (monto,codtar,codfueneco,codmonegr,glosa,fecha,ref123,obs,i_e) values (#monto#,#codtar#,#codfueneco#,#codmonegr#,#glosa#,#fecha#,#ref123#,#obs#,#i_e#);


        orm.cerrar();//cerrar la conexion         ahora vamos a jsp 

       



        return new ModelAndView("certificacion/Cert3", modelo);
    }
}