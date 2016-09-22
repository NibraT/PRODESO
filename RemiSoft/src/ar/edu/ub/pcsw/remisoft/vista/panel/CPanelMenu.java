package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelMenu extends JPanel {

    public CPanelMenu() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.add(new CPanelCambiante(new CPanelMenuViajes(), new CPanelMenuClientes(), new CPanelMenuAutos(),
                new CPanelMenuEmpleados(), new CPanelMenuReportes()), BorderLayout.CENTER);
    }

}
