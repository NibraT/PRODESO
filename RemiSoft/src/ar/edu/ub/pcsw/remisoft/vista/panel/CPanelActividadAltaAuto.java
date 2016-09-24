package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadAltaAuto extends JPanel {

    public CPanelActividadAltaAuto() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JButton altaAutoButton = new JButton(ETextoButton.ALTAAUTO.getTexto());
        altaAutoButton.setPreferredSize(new Dimension(100, 30));
        this.add(altaAutoButton, BorderLayout.NORTH);
        this.add(Box.createVerticalStrut(100));
    }

}
