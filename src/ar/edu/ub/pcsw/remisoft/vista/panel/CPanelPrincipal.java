package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelPrincipal extends JPanel {

    public CPanelPrincipal() {
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new CPanelViajes());
        this.add(new CPanelClientes());
        this.add(new CPanelAutos());
        this.add(new CPanelEmpleados());
        this.add(new CPanelReportes());
    }

}
