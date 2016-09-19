package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuReportes extends JPanel {

    public CPanelMenuReportes() {
        this.setLocation(100, 100);
        this.setBackground(Color.PINK);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton reporteGestionButton = new JButton("Reporte de Gestión");
        JButton reporteFinancieroButton = new JButton("Reporte de Finanzas");
        this.add(reporteGestionButton);
        this.add(reporteFinancieroButton);
    }
}
