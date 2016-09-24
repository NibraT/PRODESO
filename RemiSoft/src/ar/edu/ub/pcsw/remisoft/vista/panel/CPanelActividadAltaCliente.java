package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.button.ETextoButton;

import javax.swing.*;
import java.awt.*;

public class CPanelActividadAltaCliente extends JPanel {

    public CPanelActividadAltaCliente() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        JButton altaClienteButton = new JButton(ETextoButton.ALTACLIENTE.getTexto());
        altaClienteButton.setPreferredSize(new Dimension(100, 30));
        this.add(altaClienteButton, BorderLayout.NORTH);
        this.add(Box.createVerticalStrut(100));
    }

}
