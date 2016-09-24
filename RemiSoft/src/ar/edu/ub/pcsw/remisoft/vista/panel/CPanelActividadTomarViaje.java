package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadTomarViaje extends JPanel {

    public CPanelActividadTomarViaje() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JButton tomarViajeButton = new JButton(ETextoButton.TOMARVIAJE.getTexto());
        tomarViajeButton.setPreferredSize(new Dimension(100, 30));
        this.add(Box.createVerticalStrut(50));
        this.add(tomarViajeButton, BorderLayout.NORTH);
    }

}
