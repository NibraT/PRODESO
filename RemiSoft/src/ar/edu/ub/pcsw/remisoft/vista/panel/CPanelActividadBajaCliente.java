package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadBajaCliente extends JPanel {

    public CPanelActividadBajaCliente() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JButton bajaClienteButton = new JButton(ETextoButton.BAJACLIENTE.getTexto());
        bajaClienteButton.setPreferredSize(new Dimension(100, 30));
        this.add(bajaClienteButton, BorderLayout.SOUTH);
        this.add(Box.createVerticalStrut(100));
    }

}
