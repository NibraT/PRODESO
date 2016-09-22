package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelReportes extends JPanel {

    public CPanelReportes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.PINK);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton reportesButton = new JButton("Reportes");
        reportesButton.setPreferredSize(new Dimension(100, 30));
        this.add(reportesButton);
    }

}
