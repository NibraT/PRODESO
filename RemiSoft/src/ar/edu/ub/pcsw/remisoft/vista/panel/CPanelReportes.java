package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.dialog.CDialogLogin;

import javax.swing.*;
import java.awt.*;

public class CPanelReportes extends JPanel {

    public CPanelReportes() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton reportesButton = new JButton("Reportes");
        this.add(CDialogLogin.agregarLogin(reportesButton));
    }

}
