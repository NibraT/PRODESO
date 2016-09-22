package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuReportes extends JPanel {

    public CPanelMenuReportes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton reporteGestionButton = new JButton("Reporte Gestión");
        JButton reporteCajaButton = new JButton("Reporte Caja");
        reporteGestionButton.setPreferredSize(new Dimension(100, 30));
        reporteCajaButton.setPreferredSize(new Dimension(100, 30));
        this.add(Box.createHorizontalStrut(35));
        this.add(reporteGestionButton);
        this.add(Box.createVerticalStrut(150));
        this.add(reporteCajaButton);
        this.add(Box.createVerticalStrut(200));
    }

}
