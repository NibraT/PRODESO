package ar.edu.ub.pcsw.remisoft.modelo.reportes;

import org.jfree.data.general.DefaultPieDataset;

import java.util.HashMap;

public class CReporte {

    private DefaultPieDataset objDataset;
    private String titulo;

    public CReporte(String titulo, HashMap<String, Integer> chartData) {
        this.titulo = titulo;
        this.objDataset = new DefaultPieDataset();
        for(String key : chartData.keySet()) {
            this.getObjDataset().setValue(key, chartData.get(key));
        }
    }

    public DefaultPieDataset getObjDataset() { return this.objDataset; }

    public String getTitulo() { return this.titulo; }

}
