package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;
import java.awt.*;

public class CPanelActividad extends CPanelCambiante {

    public CPanelActividad() {
        this.inicializar();
    }

    private void inicializar() {
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout());
        CPanelFondo panelFondo = new CPanelFondo("src/data/mapaGarin.jpg", 1100, 587);
        panelFondo.add(new CPanelActividadTomarViaje());
        panelFondo.add(new CPanelActividadRendirViaje());
        panelFondo.add(new CPanelActividadAltaCliente());
        panelFondo.add(new CPanelActividadBajaCliente());
        panelFondo.add(new CPanelActividadAltaAuto());
        panelFondo.add(new CPanelActividadBajaAuto());
        panelFondo.add(new CPanelActividadAltaEmpleado());
        panelFondo.add(new CPanelActividadBajaEmpleado());
        panelFondo.add(new CPanelActividadReporteGestion());
        panelFondo.add(new CPanelActividadReporteCaja());
        this.add(panelFondo, BorderLayout.CENTER);
    }

}
