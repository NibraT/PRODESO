package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.dialog.CDialogLogin;

import javax.swing.*;
import java.awt.*;

public class CPanelClientes extends JPanel {

    public CPanelClientes() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton clientesButton = new JButton("Clientes");
        CDialogLogin.agregarLogin(clientesButton);
        this.add(clientesButton);
    }

}
