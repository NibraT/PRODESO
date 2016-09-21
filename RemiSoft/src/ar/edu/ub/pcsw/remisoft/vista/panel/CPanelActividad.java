package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividad extends JPanel {

    public CPanelActividad() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        this.add(new CPanelCambiante(new CPanelFondo(), new CPanelActividadViajes(), new CPanelActividadClientes(),
                new CPanelActividadAutos(), new CPanelActividadEmpleados(), new CPanelActividadReportes()),
                BorderLayout.NORTH);
    }

}
