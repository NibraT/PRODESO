package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelMenuEmpleados extends JPanel {

    public CPanelMenuEmpleados() {
        this.setLocation(100, 100);
        this.setBackground(Color.MAGENTA);
        this.setBorder(BorderFactory.createEtchedBorder());
        JButton altaEmpleadoButton = new JButton("Alta Empleado");
        JButton bajaEmpleadoButton = new JButton("Baja Empleado");
        this.add(altaEmpleadoButton);
        this.add(bajaEmpleadoButton);
    }
}
