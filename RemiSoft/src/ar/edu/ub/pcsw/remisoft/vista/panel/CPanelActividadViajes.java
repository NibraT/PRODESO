package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadViajes extends JPanel {

    public CPanelActividadViajes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton tomarViajeButton = new JButton("A DEFINIR");
        JButton rendirViajeButton = new JButton("A DEFINIR");
        tomarViajeButton.setPreferredSize(new Dimension(100, 30));
        rendirViajeButton.setPreferredSize(new Dimension(100, 30));
        this.add(Box.createHorizontalStrut(35));
        this.add(tomarViajeButton);
        this.add(Box.createVerticalStrut(150));
        this.add(rendirViajeButton);
        this.add(Box.createVerticalStrut(200));
    }

}



