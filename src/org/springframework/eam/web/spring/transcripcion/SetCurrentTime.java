package org.springframework.eam.web.spring.transcripcion;

import java.util.HashMap;
import java.util.Map;
import java.sql.*;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.eam.domain.logic.EamFacade;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.util.WebUtils;

public class SetCurrentTime implements Controller {
    
    private EamFacade eam;
    
    public void setEam(EamFacade eam) {
        this.eam = eam;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map modelo = new HashMap();

	String id_usuario =(String) WebUtils.getRequiredSessionAttribute(request,"__sess_id_usuario");
	String cod_img =(String) WebUtils.getRequiredSessionAttribute(request,"__cod_img");

        String tiempo = request.getParameter("tiempo");
        StringTokenizer st = new StringTokenizer(tiempo,":");
        int minutos = Integer.parseInt(st.nextToken());
        int segundos = Integer.parseInt(st.nextToken());
	     
        Time tiempo1 = new Time(0);
        tiempo1.setHours(0);
        tiempo1.setMinutes(minutos);
	tiempo1.setSeconds(segundos);
        int current = this.eam.setLapsoTiempos(this.eam.getUltimoIdTiempos(cod_img),tiempo1);        
	
        return new ModelAndView("transcripcion/Ajax",null);
    }
}


