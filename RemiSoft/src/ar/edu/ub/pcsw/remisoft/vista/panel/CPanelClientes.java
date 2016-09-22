package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelClientes extends JPanel {

    public CPanelClientes() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton clientesButton = new JButton("Clientes");
        clientesButton.setPreferredSize(new Dimension(100, 30));
        this.add(clientesButton);
    }

}
