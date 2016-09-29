package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadReporteGestion extends JPanel {

    public CPanelActividadReporteGestion() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JLabel reporteGestionLabel = new JLabel("REPORTE GESTION", SwingConstants.CENTER);
        reporteGestionLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        reporteGestionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        reporteGestionLabel.setForeground(Color.WHITE);
        this.add(reporteGestionLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        this.add(surLabel, BorderLayout.SOUTH);
    }

}
