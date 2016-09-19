package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuViajes extends JPanel {

    public CPanelMenuViajes() {
        this.setLocation(100, 100);
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton tomarViajeButton = new JButton("Tomar Viaje");
        JButton rendirViajeButton = new JButton("Rendir Viaje");
        this.add(tomarViajeButton);
        this.add(rendirViajeButton);
    }
}
