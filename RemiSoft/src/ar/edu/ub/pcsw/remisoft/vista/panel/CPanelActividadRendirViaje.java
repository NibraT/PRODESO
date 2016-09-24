package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadRendirViaje extends JPanel {

    public CPanelActividadRendirViaje() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.ORANGE);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JButton rendirViajeButton = new JButton(ETextoButton.RENDIRVIAJE.getTexto());
        rendirViajeButton.setPreferredSize(new Dimension(100, 30));
        this.add(rendirViajeButton, BorderLayout.SOUTH);
        this.add(Box.createVerticalStrut(50));
    }

}
