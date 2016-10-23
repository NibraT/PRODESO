package ar.edu.ub.pcsw.remisoft.vista.panel;

import ar.edu.ub.pcsw.remisoft.vista.interfaces.IPanelFactory;

import java.awt.*;

public class CPanelActividad extends CPanelCambiante implements IPanelFactory {

    public CPanelActividad() {
        this.inicializar();
    }

    private void inicializar() {
        CPanelFondo panelFondo = (CPanelFondo) crearPanel();
        panelFondo.add(new CPanelActividadTomarViaje());
        panelFondo.add(new CPanelActividadRendirViaje());
        panelFondo.add(new CPanelActividadAltaCliente());
        panelFondo.add(new CPanelActividadBajaCliente());
        panelFondo.add(new CPanelActividadAltaAuto());
        panelFondo.add(new CPanelActividadBajaAuto());
        panelFondo.add(new CPanelActividadAltaEmpleado());
        panelFondo.add(new CPanelActividadBajaEmpleado());
        panelFondo.add(new CPanelActividadReporteOperativo());
        panelFondo.add(new CPanelActividadReporteFinanciero());
        this.add(panelFondo, BorderLayout.CENTER);
    }

}
