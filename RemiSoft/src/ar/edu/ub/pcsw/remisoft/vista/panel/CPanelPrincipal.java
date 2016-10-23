package ar.edu.ub.pcsw.remisoft.vista.panel;

import javax.swing.*;

public class CPanelPrincipal extends CPanelBase {

    public CPanelPrincipal() {
        this.inicializar();
    }

    private void inicializar() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new CPanelViajes());
        this.add(new CPanelClientes());
        this.add(new CPanelAutos());
        this.add(new CPanelEmpleados());
        this.add(new CPanelReportes());
    }

}
