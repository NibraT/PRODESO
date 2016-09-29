package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadReporteCaja extends JPanel {

    public CPanelActividadReporteCaja() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JLabel reporteCajaLabel = new JLabel("REPORTE CAJA", SwingConstants.CENTER);
        reporteCajaLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        reporteCajaLabel.setFont(new Font("Arial", Font.BOLD, 25));
        reporteCajaLabel.setForeground(Color.WHITE);
        this.add(reporteCajaLabel, BorderLayout.NORTH);
        JLabel surLabel = new JLabel();
        surLabel.setPreferredSize(new Dimension(this.getWidth(), 100));
        this.add(surLabel, BorderLayout.SOUTH);
    }

}
