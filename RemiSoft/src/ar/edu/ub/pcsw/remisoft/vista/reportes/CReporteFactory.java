package ar.edu.ub.pcsw.remisoft.vista.reportes;

import ar.edu.ub.pcsw.remisoft.controlador.main.CSelectSQL;
import ar.edu.ub.pcsw.remisoft.modelo.reportes.CReporte;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.util.HashMap;
import java.util.Random;

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

    // TODO: eliminar este método y hacer lo que hay que hacer
    public HashMap<String, Integer> crearHashMapHardcodeado() {
        HashMap<String, Integer> hardcode = new HashMap<>();
        String[] keys = new String[] {"X", "Y", "Z"};
        /*int cont = 0;
        for (String s: new CSelectSQL().selectAutoDisponibles(1) ) {
            keys[cont] = s;
            cont ++;
        }*/
        Random random = new Random();
        for(int i = 0; i < random.nextInt(8) + 2; i++) {
            hardcode.put(keys[random.nextInt(keys.length)], random.nextInt(50));
        }
        /*for (String s:keys ) {
            hardcode.put(s, 20);
        }*/
        return hardcode;
    }

    public ChartFrame crear(String tituloReporte) {
        // TODO: Aca va la magia de pulpo
        // Hay que crear un CReporte a partir de un HashMap llenado por una consulta SQL,
        // que variará de acuerdo al reporte solicitado.
        /*HashMap<String, Integer> resultado = null;
        if(tituloReporte.equals("Auto frula"))
        {
            CSelectSQL a;
            resultado = a.obtenerResultado();
        }*/
        return this.crearGrafico(new CReporte(tituloReporte, crearHashMapHardcodeado()/* resultado de la magia de pulpo */));
    }

}
