package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

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
        JButton reporteGestionButton = new JButton(ETextoButton.REPORTEGESTION.getTexto());
        reporteGestionButton.setPreferredSize(new Dimension(100, 30));
        this.add(reporteGestionButton, BorderLayout.NORTH);
        this.add(Box.createVerticalStrut(100));
    }

}
