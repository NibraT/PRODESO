package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelViajes extends JPanel {

    public CPanelViajes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton viajesButton = new JButton("Viajes");
        viajesButton.setPreferredSize(new Dimension(100, 30));
        this.add(viajesButton);
    }

}
