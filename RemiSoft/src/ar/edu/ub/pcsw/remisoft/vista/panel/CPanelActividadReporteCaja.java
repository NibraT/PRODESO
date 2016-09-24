package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

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
        JButton reporteCajaButton = new JButton(ETextoButton.REPORTECAJA.getTexto());
        reporteCajaButton.setPreferredSize(new Dimension(100, 30));
        this.add(reporteCajaButton, BorderLayout.SOUTH);
        this.add(Box.createVerticalStrut(100));
    }

}
