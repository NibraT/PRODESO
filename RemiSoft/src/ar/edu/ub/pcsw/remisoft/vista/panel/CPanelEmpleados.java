package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelEmpleados extends JPanel {

    public CPanelEmpleados() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton empleadosButton = new JButton("Empleados");
        empleadosButton.setPreferredSize(new Dimension(100, 30));
        this.add(empleadosButton);
    }

}
