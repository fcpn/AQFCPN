/*
 * CreatePie.java
 *
 * Created on 7 de septiembre de 2007, 8:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

//_ Castillo Valencia
package org.springframework.eam.web.spring.supervisor;

import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.*;
import org.jfree.util.*;
import java.awt.Color;
import java.io.*;
/**
 *
 * @author _ston Castillo Valencia
 */
public class CreatePie {
    private String titulovalor1;
    private String titulovalor2;
    private Double valor1;
    private Double valor2;
    private String titulo;
    private String archivo;
    /** Creates a new instance of CreatePie */
    public void getPie() {
        // TODO code application logic here
        DefaultPieDataset piedataset = new DefaultPieDataset();
        
        piedataset.setValue(this.titulovalor1, this.valor1);
        piedataset.setValue(this.titulovalor2, this.valor2);

        JFreeChart torta = ChartFactory.createPieChart3D(this.titulo, piedataset, true, true, true);
        torta.setBackgroundPaint(Color.WHITE);
        
        PiePlot3D pie3dplot = (PiePlot3D) torta.getPlot();

        pie3dplot.setStartAngle(40D);
        pie3dplot.setDirection(Rotation.ANTICLOCKWISE);
        pie3dplot.setForegroundAlpha(0.6F);
        

        File imagenarchivo = new File(this.archivo);
        try {
            ChartUtilities.saveChartAsJPEG(imagenarchivo,torta,400,150);
        } catch (Exception e){}          
    }

    public String getTitulovalor1() {
        return titulovalor1;
    }

    public void setTitulovalor1(String titulovalor1) {
        this.titulovalor1 = titulovalor1;
    }

    public String getTitulovalor2() {
        return titulovalor2;
    }

    public void setTitulovalor2(String titulovalor2) {
        this.titulovalor2 = titulovalor2;
    }

    public Double getValor1() {
        return valor1;
    }

    public void setValor1(Double valor1) {
        this.valor1 = valor1;
    }

    public Double getValor2() {
        return valor2;
    }

    public void setValor2(Double valor2) {
        this.valor2 = valor2;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
}
