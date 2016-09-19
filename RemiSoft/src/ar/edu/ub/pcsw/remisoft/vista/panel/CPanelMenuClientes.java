package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.dialog.CDialogLogin;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuClientes extends JPanel {

    public CPanelMenuClientes() {
        this.setLocation(100, 100);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton altaClienteButton = new JButton("Alta Cliente");
        JButton bajaClienteButton = new JButton("Baja Cliente");
        this.add(altaClienteButton);
        this.add(bajaClienteButton);
    }
}
