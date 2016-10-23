package ar.edu.ub.pcsw.remisoft.vista.reportes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class CChartFrame {

    public ChartFrame getReporte(String tituloReporte) {
        JFreeChart objChart;
        if (tituloReporte.equals("Total autos")) {
            DefaultPieDataset objDataset = new DefaultPieDataset();
            objDataset.setValue("Apple", 29);
            objDataset.setValue("HTC", 15);
            objDataset.setValue("Samsung", 24);
            objDataset.setValue("LG", 7);
            objDataset.setValue("Motorola", 10);
            objChart = ChartFactory.createPieChart("Reporte " + tituloReporte, objDataset, true, true, false);
            ChartFrame frame = new ChartFrame("RemiSoft 1.0", objChart);
            frame.setIconImage(new ImageIcon("src/data/software-icon.png").getImage());
            frame.pack();
            frame.setVisible(true);
            return frame;
        }
        else if (tituloReporte.equals("Autos disponibles hoy")) {
            DefaultPieDataset objDataset = new DefaultPieDataset();
            objDataset.setValue("Apple", 85);
            objDataset.setValue("Samsung", 15);
            objChart = ChartFactory.createPieChart("Reporte " + tituloReporte, objDataset, true, true, false);
            ChartFrame frame = new ChartFrame("RemiSoft 1.0", objChart);
            frame.setIconImage(new ImageIcon("src/data/software-icon.png").getImage());
            frame.pack();
            frame.setVisible(true);
            return frame;
        }
        else if (tituloReporte.equals("Total activo")) {
            DefaultPieDataset objDataset = new DefaultPieDataset();
            objDataset.setValue("Apple", 15);
            objDataset.setValue("Samsung", 85);
            objChart = ChartFactory.createPieChart("Reporte " + tituloReporte, objDataset, true, true, false);
            ChartFrame frame = new ChartFrame("RemiSoft 1.0", objChart);
            frame.setIconImage(new ImageIcon("src/data/software-icon.png").getImage());
            frame.pack();
            frame.setVisible(true);
            return frame;
        }
        else if (tituloReporte.equals("Cuentas a pagar")) {
            DefaultPieDataset objDataset = new DefaultPieDataset();
            objDataset.setValue("Apple", 50);
            objDataset.setValue("Samsung", 50);
            objChart = ChartFactory.createPieChart("Reporte " + tituloReporte, objDataset, true, true, false);
            ChartFrame frame = new ChartFrame("RemiSoft 1.0", objChart);
            frame.setIconImage(new ImageIcon("src/data/software-icon.png").getImage());
            frame.pack();
            frame.setVisible(true);
            return frame;
        }
        return null;
    }

}
