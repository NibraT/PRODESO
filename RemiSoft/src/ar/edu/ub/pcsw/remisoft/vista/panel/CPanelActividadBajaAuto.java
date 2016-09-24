package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadBajaAuto extends JPanel {

    public CPanelActividadBajaAuto() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GREEN);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JButton bajaAutoButton = new JButton(ETextoButton.BAJAAUTO.getTexto());
        bajaAutoButton.setPreferredSize(new Dimension(100, 30));
        this.add(bajaAutoButton, BorderLayout.SOUTH);
        this.add(Box.createVerticalStrut(100));
    }

}
