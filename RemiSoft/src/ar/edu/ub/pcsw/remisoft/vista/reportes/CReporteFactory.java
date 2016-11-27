package ar.edu.ub.pcsw.remisoft.vista.reportes;

import ar.edu.ub.pcsw.remisoft.controlador.main.CSelectSQL;
import ar.edu.ub.pcsw.remisoft.modelo.reportes.CReporte;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.util.HashMap;

public class CReporteFactory {

    private ChartFrame crearGrafico(CReporte reporte) {
        if (! reporte.getTitulo().equals(" ")) {
            JFreeChart jFreeChart = ChartFactory.createPieChart("Reporte " + reporte.getTitulo(),
                    reporte.getObjDataset(), true, true, false);
            ChartFrame frame = new ChartFrame("RemiSoft 1.0", jFreeChart);
            frame.setIconImage(new ImageIcon("src/data/software-icon.png").getImage());
            frame.pack();
            return frame;
        }
        return null;
    }

    public ChartFrame crear(String tituloReporte) {
        HashMap<String, Integer> resultado = null;
        if(tituloReporte.equals("Total viajes"))
        {
            resultado = new CSelectSQL().selectViajesPorAutoOChoferReportes("patente");
        }
        else if (tituloReporte.equals("Total viajes por chofer")){
            resultado = new CSelectSQL().selectViajesPorAutoOChoferReportes("dni");
        }
        else if (tituloReporte.equals("Total autos")){
            resultado = new CSelectSQL().selectTodosAutosReportes();
        }
        else if (tituloReporte.equals("Autos disponibles hoy")){
            resultado = new CSelectSQL().selectTodosAutosDisponiblesNoDisponiblesReportes("1");
        }
        else if (tituloReporte.equals("Autos no disponibles hoy")){
            resultado = new CSelectSQL().selectTodosAutosDisponiblesNoDisponiblesReportes("0");
        }
        else if (tituloReporte.equals("Total clientes")){
            resultado = new CSelectSQL().selectTotalClientesReportes();
        }
        else if (tituloReporte.equals("Antiguedad clientes")){
            resultado = new CSelectSQL().selectAntiguedadClientesReportes();
        }
        return this.crearGrafico(new CReporte(tituloReporte, resultado));
    }

}