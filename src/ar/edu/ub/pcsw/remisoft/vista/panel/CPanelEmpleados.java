package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.dialog.CDialogLogin;

import javax.swing.*;
import java.awt.*;

public class CPanelEmpleados extends JPanel {

    public CPanelEmpleados() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton empleadosButton = new JButton("Empleados");
        this.add(CDialogLogin.agregarLogin(empleadosButton));
    }

}
