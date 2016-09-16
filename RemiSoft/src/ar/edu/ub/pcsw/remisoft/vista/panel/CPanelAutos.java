package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.dialog.CDialogLogin;

import javax.swing.*;
import java.awt.*;

public class CPanelAutos extends JPanel {

    public CPanelAutos() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton autosButton = new JButton("Autos");
        this.add(CDialogLogin.agregarLogin(autosButton));
    }
}
